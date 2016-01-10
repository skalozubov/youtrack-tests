package com.jetbrains.youtrack;

import com.jetbrains.youtrack.helpers.WebDriverManager;
import com.jetbrains.youtrack.pages.LoginPage;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import com.jetbrains.youtrack.helpers.ConfigurationManager;
import com.jetbrains.youtrack.listeners.ExecutionListener;
import com.jetbrains.youtrack.testdata.TestData;

@Listeners(ExecutionListener.class)
public class BaseTest {
    protected WebDriver driver;
    public String baseUrl;
    protected TestData testData;
    protected LoginPage loginPage;
    private WebDriverManager webDriverManager = new WebDriverManager();
    private ConfigurationManager configurationManager = new ConfigurationManager();

    @BeforeClass
    public void setUpClass() {
        System.out.println("Started all tests in class");
        baseUrl = configurationManager.getProperty("baseUrl");
    }

    @BeforeMethod
    public void setUp() {
        //TODO: move browser type into properties
        driver = webDriverManager.getWebDriver("CHROME");
        driver.get(baseUrl);
        testData = new TestData();
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        webDriverManager.killDriver();
    }

    @AfterClass
    public void tearDownClass() {
        System.out.println("Finished all tests in class");
    }

    //TODO: need to investiagte how to forvard driver into listener.
    public WebDriver getDriver() {
        return driver;
    }
}
