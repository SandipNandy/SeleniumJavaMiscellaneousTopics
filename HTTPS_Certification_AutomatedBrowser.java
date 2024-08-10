import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.edge.EdgeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class HTTPS_Certification_AutomatedBrowser {

	public static void main(String[] args) {
		ChromeOptions options= new ChromeOptions();
		
		options.setAcceptInsecureCerts(true);
		//same way we can create it for firefox
		
		//FirefoxOptions options2=new FirefoxOptions();
		
		//options2.setAcceptInsecureCerts(true);
		//same way we can create it for Edge
		//EdgeOptions options3=new EdgeOptions();
		//options3.setAcceptInsecureCerts(true);
		System.setProperty("webdriver.chrome.driver","..\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://expired.badssl.com/");
		
		driver.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		
		/*System.setProperty("webdriver.gecko.driver", "/geckodriver-v0.30.0-win64/geckodriver.exe");
		WebDriver driver1 = new FirefoxDriver();
		// # without passing the options2 parameter in firefox driver iys passing the ssl sertificate
		//WebDriver driver1 = new FirefoxDriver(options2);

		driver1.manage().window().maximize();
		driver1.get("https://expired.badssl.com/");
		driver1.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS);
		System.out.println(driver1.getTitle());
		*/
		/*System.setProperty("webdriver.edge.driver", "/edgedriver_win64/msedgedriver.exe");
		WebDriver driver3 = new EdgeDriver(options3);
		driver3.manage().window().maximize();
		driver3.get("https://expired.badssl.com/");
		driver3.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS);
		System.out.println(driver3.getTitle());*/
		
		
		

	}

}
