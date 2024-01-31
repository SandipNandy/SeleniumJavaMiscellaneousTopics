import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLink_Practice {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","..\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS);
		String url=driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
				HttpURLConnection conn=(HttpURLConnection) new URL(url).openConnection();
				conn.setRequestMethod("HEAD");
				conn.connect();
				int ResCode=conn.getResponseCode();
				System.out.println(ResCode);

	}

}
