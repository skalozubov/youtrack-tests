package ru.mail.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverManager {
    private WebDriver driver = null;

    public WebDriver getDriver() {
        if (driver == null) {
            initializeDriver();
            return driver;
        }
        return driver;
    }

    private void initializeDriver() {
        System.setProperty("webdriver.chrome.driver", "/usr/lib/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void killDriver() {
        driver.quit();
        driver = null;
    }
}
