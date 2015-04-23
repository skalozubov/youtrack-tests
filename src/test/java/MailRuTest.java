import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class MailRuTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/usr/lib/chromedriver");
        driver = new ChromeDriver();
        baseUrl = "https://mail.ru/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void loginTest() {
        driver.get(baseUrl);
        driver.findElement(By.id("mailbox__login")).clear();
        driver.findElement(By.id("mailbox__login")).sendKeys("dfgsdfg");
        driver.findElement(By.id("mailbox__password")).clear();
        driver.findElement(By.id("mailbox__password")).sendKeys("sdfgsdfg");
        driver.findElement(By.id("mailbox__auth__button")).click();
        assertTrue(true, "");
    }

    @AfterTest
    public void tearDown() throws Exception {
        driver.quit();
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}