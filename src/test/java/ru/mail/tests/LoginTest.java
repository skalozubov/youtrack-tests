package ru.mail.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.mail.BaseTest;
import ru.mail.pages.InboxPage;

public class LoginTest extends BaseTest {

    //TODO: 10 different tests with different asserts
    //TODO: HttpClient
    //TODO email without UI
    //TODO testng.xml
    //TODO @Test attributes


    @Test
    public void unsuccessfulLoginTest() {
        loginPage.fillLoginField(testData.getIncorrectLogin())
                 .fillPasswordField(testData.getIncorrectPassword())
                 .submitLoginForm();
        Assert.assertEquals(loginPage.getPageTitle(), testData.getPageTitle(), "Something went wrong while unsuccessful login");
    }

    @Test
    public void successfulLoginTest() {
        loginPage.fillLoginField(testData.getCorrectLogin())
                .fillPasswordField(testData.getCorrectPassword())
                .submitLoginForm();
        Assert.assertEquals(driver.getCurrentUrl(), testData.getPageUrl(), "Login was unsuccessful");
    }

    @Test
    public void checkEmailTest() {
        InboxPage inboxPage = loginPage.fillLoginField(testData.getCorrectLogin())
                .fillPasswordField(testData.getCorrectPassword())
                .submitSuccessfulLoginForm();
                inboxPage.getLatestEmail();
    }
}