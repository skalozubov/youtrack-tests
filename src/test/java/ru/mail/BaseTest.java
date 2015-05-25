package ru.mail;

import org.openqa.selenium.*;
import org.testng.annotations.*;
import ru.mail.helpers.ConfigurationManager;
import ru.mail.helpers.WebDriverManager;
import ru.mail.pages.LoginPage;
import ru.mail.testdata.TestData;

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
        driver = webDriverManager.getDriver();
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
}
