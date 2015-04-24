import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class ConfigurationManager {
    protected WebDriver driver;
    protected String baseUrl;

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Started all tests in class");
    }

    @BeforeTest
    public void setUp() {
        baseUrl = "https://mail.ru/";
        System.setProperty("webdriver.chrome.driver", "/usr/lib/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @AfterTest
    public void tearDown() throws Exception {
        driver.quit();
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Finished all tests in class");
    }
}
