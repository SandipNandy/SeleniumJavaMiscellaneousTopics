import java.util.HashMap;

import java.util.Map;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Proxy_plugins_DownloadpathsSeleniumjava {
	public static void main(String[] args) {
		//we can use https://chromedriver.chromium.org/capabilities to know more
		ChromeOptions options=new ChromeOptions();
		//to set the proxy
		Proxy proxy=new Proxy();
		proxy.setHttpProxy("ipaddress:4444");
		options.setCapability("proxy", proxy);
		
		//to set the download path
		Map<String, Object> prefs= new HashMap<String, Object>();
		prefs.put("download.default_directory", "/download/newfolder");
		options.setExperimentalOption("prefs", prefs);
		System.setProperty("webdriver.chrome.driver","..\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://expired.badssl.com/");
		driver.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
	}

}
