package com.jetbrains.youtrack;

import com.jetbrains.youtrack.helpers.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import com.jetbrains.youtrack.helpers.ConfigurationManager;
import com.jetbrains.youtrack.listeners.ExecutionListener;
import ru.yandex.qatools.allure.annotations.Step;

@Listeners(ExecutionListener.class)
public class BaseTest {
    protected WebDriver driver;
    private String baseUrl;
    private String browser;
    private WebDriverManager webDriverManager = new WebDriverManager();
    private ConfigurationManager configurationManager = new ConfigurationManager();

    @BeforeClass
    public void setUpClass() {
        System.out.println("Started all tests in class");
        baseUrl = configurationManager.getProperty("baseUrl");
        browser = configurationManager.getProperty("browser");
    }

    @BeforeMethod
    @Step("Open Dashboard page")
    public void setUp() {
        driver = webDriverManager.getWebDriver(browser);
        driver.get(baseUrl);
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
