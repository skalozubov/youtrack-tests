package com.jetbrains.youtrack.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.jetbrains.youtrack.BaseTest;
import com.jetbrains.youtrack.pages.InboxPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import static org.testng.Assert.fail;

@Features("Login feature")
public class LoginTest extends BaseTest {

    @Stories("Not existed user should not be able to login")
    @Test
    public void unsuccessfulLoginTest() {
        loginPage.fillLoginField(testData.getIncorrectLogin())
                 .fillPasswordField(testData.getIncorrectPassword())
                 .submitLoginForm();
        Assert.assertEquals(loginPage.getPageTitle(), testData.getPageTitle(), "Something went wrong while unsuccessful login");
    }

    @Stories("Existed user should be able to login successfully")
    @Test
    public void successfulLoginTest() {
        loginPage.fillLoginField(testData.getCorrectLogin())
                .fillPasswordField(testData.getCorrectPassword())
                .submitLoginForm();
        Assert.assertEquals(driver.getCurrentUrl(), testData.getPageUrl(), "Login was unsuccessful");
    }

    @Test
    @Stories("Failed test")
    public void checkEmailTest() {
        InboxPage inboxPage = loginPage.fillLoginField(testData.getCorrectLogin())
                .fillPasswordField(testData.getCorrectPassword())
                .submitSuccessfulLoginForm();
                inboxPage.getLatestEmail();
        fail("Some error.");
    }
}