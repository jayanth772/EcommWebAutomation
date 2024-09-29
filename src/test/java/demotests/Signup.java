package demotests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Signup {

    public static void main(String[] args) {

        //Arrange
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://web-playground.ultralesson.com/");
        driver.manage().window().maximize();

        //Act
        //driver.findElement(By.xpath("//div[@class='menu-drawer__utility-links']//a[contains(@href,'login')]//*[name()='svg']")).click();
        driver.findElement(By.xpath("//a[@class='header__icon header__icon--account link focus-inset small-hide']//*[name()='svg']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Create account']")).click();

        driver.findElement(By.id("RegisterForm-FirstName")).sendKeys("user772");
        driver.findElement(By.name("customer[last_name]")).sendKeys("last");
        driver.findElement(By.id("RegisterForm-email")).sendKeys("userlast774@gmail.com");
        driver.findElement(By.name("customer[password]")).sendKeys("User@123");
        driver.findElement(By.xpath("//button[normalize-space()='Create']")).click();

        //Assert
        driver.findElement(By.xpath("//a[@class='header__icon header__icon--account link focus-inset small-hide']//*[name()='svg']")).click();
        String actual = driver.findElement(By.xpath("//a[@href='/account/logout']")).getText().strip();
        driver.quit();
        System.out.println("actual:"+actual);
        Assert.assertEquals(actual,"Log out");






    }
}
