package org.example;

import org.example.internal.Toggles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriverManager implements DriverManager<WebDriver> {

    @Override
    public WebDriver create() {
        if(Toggles.HEADLESS.isOn()) {
            return createHeadlessChromeDriver();
        }
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private ChromeDriver createHeadlessChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = getHeadlessChromeOptions();
        return new ChromeDriver(chromeOptions);
    }

    private ChromeOptions getHeadlessChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("disable-gpu");
        return chromeOptions;
    }
}
