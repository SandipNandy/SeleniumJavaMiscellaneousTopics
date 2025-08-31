import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FilterWebTablewithSeleniumJava {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://seleniumPractise/#/offers");
		
		 Thread.sleep(3000);
		
               driver.findElement(By.id("search-field")).sendKeys("Potato");
        Thread.sleep(3000);
        List<WebElement> Vegitables= driver.findElements(By.xpath("//tr/td[1]"));
        List<WebElement> FilteredList=Vegitables.stream().filter(V->V.getText().contains("Potato")).collect(Collectors.toList());
		
        Assert.assertEquals(Vegitables.size(), FilteredList.size());

	}

}


