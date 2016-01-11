package com.jetbrains.youtrack;

import com.jetbrains.youtrack.helpers.*;
import com.jetbrains.youtrack.helpers.Configuration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import com.jetbrains.youtrack.listeners.ExecutionListener;
import ru.qatools.properties.PropertyLoader;
import ru.yandex.qatools.allure.annotations.Step;

@Listeners(ExecutionListener.class)
public class BaseTest {
    protected WebDriver driver;
    private WebDriverManager webDriverManager = new WebDriverManager();
    Configuration config = PropertyLoader.newInstance().populate(Configuration.class);

    @BeforeClass
    public void setUpClass() {
        System.out.println("Started all tests in class");
    }

    @BeforeMethod
    @Step("Open Dashboard page")
    public void setUp() {
        driver = webDriverManager.getWebDriver(config.getBrowser());
        driver.get(config.getBaseUrl());
    }

    @AfterMethod
    public void tearDown() throws Exception {
        webDriverManager.killDriver();
    }

    @AfterClass
    public void tearDownClass() {
        System.out.println("Finished all tests in class");
    }

    //TODO: need to investigate how to forward driver into listener.
    public WebDriver getDriver() {
        return driver;
    }
}
