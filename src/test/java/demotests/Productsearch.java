package demotests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class Productsearch {

    public static void main(String[] args) {

       //Arrange
       WebDriver driver = new ChromeDriver();
       driver.navigate().to("https://web-playground.ultralesson.com/");
       driver.manage().window().maximize();
       driver.findElement(By.xpath("//summary[@aria-label='Search']//span//*[name()='svg']")).click();
       driver.findElement(By.id("Search-In-Modal")).sendKeys("Jeans");
       driver.findElement(By.xpath("//button[@aria-label='Search']//*[name()='svg']")).click();

       //Act
       List<WebElement> items = driver.findElements(By.xpath("//li[@class='grid__item']"));
       int actualnoofitems = items.size();
       driver.quit();

       //Assert
       Assert.assertEquals(actualnoofitems,4);


    }
}
