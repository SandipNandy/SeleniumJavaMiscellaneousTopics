import java.io.IOException;
import java.net.HttpURLConnection;

import java.net.MalformedURLException;

import java.net.URL;

import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.asserts.SoftAssert;

public class BrokenLink_Automation_SoftAssertion {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","..\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS);
		List<WebElement> links=   driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		SoftAssert a =new SoftAssert();
		for(WebElement link : links)

	      {
	          String url= link.getAttribute("href");
				HttpURLConnection conn=(HttpURLConnection) new URL(url).openConnection();
				conn.setRequestMethod("HEAD");
				conn.connect();
				int ResCode=conn.getResponseCode();
				System.out.println(ResCode);
				 a.assertTrue(ResCode<400, "The link with Text"+link.getText()+" is broken with code " +ResCode);
	      }
		a.assertAll();

	}

}
