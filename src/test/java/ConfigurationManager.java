import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class ConfigurationManager {
    protected static WebDriver driver = null;
    public String baseUrl;
    protected TestData testData;
    protected LoginPage loginPage;

    @BeforeClass
    public void setUpClass() {
        System.out.println("Started all tests in class");
        System.setProperty("webdriver.chrome.driver", "/usr/lib/chromedriver");
        baseUrl = "https://mail.ru/";
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl);
        testData = new TestData();
        loginPage = new LoginPage();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

    @AfterClass
    public void tearDownClass() {
        System.out.println("Finished all tests in class");
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
