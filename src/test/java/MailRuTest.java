import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MailRuTest extends ConfigurationManager {
    private String incorrectLogin = "test";
    private String incorrectPassword = "test";
    private String correctLogin = "sourceittest";
    private String correctPassword = "sourceit12345";

    @Test
    public void unsuccessfulLoginTest() {
        driver.get(baseUrl);
        driver.findElement(LocatorsEnum.LOGIN_FIELD.getValue()).clear();
        driver.findElement(LocatorsEnum.LOGIN_FIELD.getValue()).sendKeys(incorrectLogin);
        driver.findElement(LocatorsEnum.PASSWORD_FIELD.getValue()).clear();
        driver.findElement(LocatorsEnum.PASSWORD_FIELD.getValue()).sendKeys(incorrectPassword);
        driver.findElement(LocatorsEnum.SUBMIT_LOGIN_FORM_BUTTON.getValue()).click();
        assertEquals(driver.getTitle(), "Вход - Почта Mail.Ru", "Something went wrong while unsuccessful login");
    }

    @Test
    public void successfulLoginTest() {
        driver.get(baseUrl);
        driver.findElement(LocatorsEnum.LOGIN_FIELD.getValue()).clear();
        driver.findElement(LocatorsEnum.LOGIN_FIELD.getValue()).sendKeys(correctLogin);
        driver.findElement(LocatorsEnum.PASSWORD_FIELD.getValue()).clear();
        driver.findElement(LocatorsEnum.PASSWORD_FIELD.getValue()).sendKeys(correctPassword);
        driver.findElement(LocatorsEnum.SUBMIT_LOGIN_FORM_BUTTON.getValue()).click();
        assertEquals(driver.getCurrentUrl(), "https://e.mail.ru/messages/inbox/?back=1", "Login was unsuccessful");
    }
}