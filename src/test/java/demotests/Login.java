package demotests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Login {

    public static void main(String[] args) {

        //Arrange
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://web-playground.ultralesson.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@class='header__icon header__icon--account link focus-inset small-hide']//*[name()='svg']")).click();

        //Act
        driver.findElement(By.id("CustomerEmail")).sendKeys("userlast774@gmail.com");
        driver.findElement(By.name("customer[password]")).sendKeys("User@123");
        driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();

        //Assert
        driver.findElement(By.xpath("//a[@class='header__icon header__icon--account link focus-inset small-hide']//*[name()='svg']")).click();
        String actual = driver.findElement(By.xpath("//a[@href='/account/logout']")).getText().strip();
        driver.quit();
        System.out.println("actual:"+actual);
        Assert.assertEquals(actual,"Log out");
    }
}
