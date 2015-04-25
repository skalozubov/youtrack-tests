import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class ConfigurationManager {
    protected WebDriver driver;
    public String baseUrl;

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
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

    @AfterClass
    public void tearDownClass() {
        System.out.println("Finished all tests in class");
    }
}
