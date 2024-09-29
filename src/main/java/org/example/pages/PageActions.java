package org.example.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

public class PageActions {

    private WebDriver webDriver;
    private PageWaits waits;

    public PageActions(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.waits = new PageWaits(webDriver);
    }

    public void click(By by) {
        webDriver.findElement(by).click();
    }

    public void type(By by, String value) {
        webDriver.findElement(by).sendKeys(value);
    }

    public String getText(WebElement element) {
        try {
            //WebElement childElement = element.findElement(By.xpath("./*")); // Selects direct child element
            return element.getText().trim();
        } catch (Exception e) {
            System.out.println("Error while getting child text: " + e.getMessage());
            return "";
        }
    }

    public void refreshPage(){
        webDriver.navigate().refresh();
    }

    public void executeJS(String script, Object... args) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;
        jsExecutor.executeScript(script, args);
    }

    public void takeScreenshot(String name) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) webDriver;
        File screenshot = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot,new File("./screenshots/"+name+".png"));
    }

}
