import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MailRuTest extends ConfigurationManager {

    //TODO: read ExpectedConditions.java WebDriverWait.java
    //TODO: 10 different tests with different asserts
    //TODO: refactor the project with packages

    @Test
    public void unsuccessfulLoginTest() {
        loginPage.fillLoginField(testData.getIncorrectLogin())
                 .fillPasswordField(testData.getIncorrectPassword())
                 .submitLoginForm();
        assertEquals(loginPage.getPageTitle(), testData.getPageTitle(), "Something went wrong while unsuccessful login");
    }

    @Test
    public void successfulLoginTest() {
        loginPage.fillLoginField(testData.getCorrectLogin())
                .fillPasswordField(testData.getCorrectPassword())
                .submitLoginForm();
        assertEquals(driver.getCurrentUrl(), testData.getPageUrl(), "Login was unsuccessful");
    }

    @Test
    public void checkEmailTest() {
        InboxPage inboxPage = loginPage.fillLoginField(testData.getCorrectLogin())
                .fillPasswordField(testData.getCorrectPassword())
                .submitSuccessfulLoginForm();
                inboxPage.getLatestEmail();
    }
}