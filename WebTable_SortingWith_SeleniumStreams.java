import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebTable_SortingWith_SeleniumStreams {

public static void main(String[] args) throws InterruptedException {
// TODO Auto-generated method stub
System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
WebDriver driver = new ChromeDriver();
driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
  
// click on column
driver.findElement(By.xpath("//tr/th[1]")).click();
  
// capture all webelements into list
List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));
  
// capture text of all webelements into new(original) list
List<String> originalList = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList());

// sort on the original list of step 3 -> sorted list

List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

// compare original list vs sorted list

Assert.assertTrue(originalList.equals(sortedList));

List<String> price;

// scan the name column with getText ->Beans->print the price of the Rice

do

{

List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));

//This is called '->' Lambda Expression
price = rows.stream().filter(s -> s.getText().contains("Rice"))
.map(s -> getPriceVeggie(s)).collect(Collectors.toList());

price.forEach(a -> System.out.println(a));

if(price.size()<1)

{
//This is a pagination concepts
driver.findElement(By.cssSelector("[aria-label='Next']")).click();

}

}while(price.size()<1);



}

//When you will have multiple page to scan through automation script and after searching the elements in diffrent page we can 
//perform the opertaion we want - This entire concepts are colled pagination

private static String getPriceVeggie(WebElement s) {

// TODO Auto-generated method stub

String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();



return pricevalue;

}

}


