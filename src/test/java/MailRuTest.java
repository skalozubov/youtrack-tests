import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MailRuTest extends ConfigurationManager {
    private String incorrectLogin = "";
    private String incorrectPassword = "";
    private String correctLogin = "";
    private String correctPassword = "";

    @Test
    public void unsuccessfulLoginTest() {
        driver.get(baseUrl);
        driver.findElement(Locators.loginField).clear();
        driver.findElement(Locators.loginField).sendKeys(incorrectLogin);
        driver.findElement(Locators.passwordField).clear();
        driver.findElement(Locators.passwordField).sendKeys(incorrectPassword);
        driver.findElement(Locators.submitLoginFormButton).click();
        assertEquals(driver.getCurrentUrl(), "asd", "");
    }

    @Test
    public void successfulLoginTest() {
        driver.get(baseUrl);
        driver.findElement(Locators.loginField).clear();
        driver.findElement(Locators.loginField).sendKeys(correctLogin);
        driver.findElement(Locators.passwordField).clear();
        driver.findElement(Locators.passwordField).sendKeys(correctPassword);
        driver.findElement(Locators.submitLoginFormButton).click();
        assertTrue(true, "");
    }
}