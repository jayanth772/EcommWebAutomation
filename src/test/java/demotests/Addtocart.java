package demotests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Addtocart {

    public static void main(String[] args) throws InterruptedException {
        //(WIP)
        //Arrange
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://web-playground.ultralesson.com/");
        driver.manage().window().maximize();

        //Act
        driver.findElement(By.xpath("//summary[@aria-label='Search']//span//*[name()='svg']")).click();
        driver.findElement(By.xpath("//input[@class='search__input field__input']")).sendKeys("Jeans");
        driver.findElement(By.xpath("//button[@aria-label='Search']//*[name()='svg']")).click();
        List<WebElement> items = driver.findElements(By.xpath("//li[@class='grid__item']"));
        //int noofitems = items.size();

        Random rand = new Random();
        int randomnum = 1 + rand.nextInt(items.size()-1+1);
        System.out.println(randomnum);
        items.get(randomnum).click();

        WebElement addtocartbutton = driver.findElement(By.xpath("//div[@class='product-form__buttons']/button"));
        System.out.println(addtocartbutton.isDisplayed());
        addtocartbutton.click();
        Thread.sleep(Duration.ofSeconds(5));
       //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        String actual = driver.findElement(By.className("cart-notification__heading caption-large")).getText();
//        System.out.println(actual);




        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement ele = driver.findElement(By.id("cart-notification-button"));
        js.executeScript("arguments[0].click()",ele);






    }
}
