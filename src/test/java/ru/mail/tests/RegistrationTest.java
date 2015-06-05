package ru.mail.tests;

import org.testng.annotations.Test;
import ru.mail.BaseTest;
import ru.mail.pages.RegistrationPage;
import ru.mail.testdata.RegistrationData;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import static org.testng.Assert.assertTrue;

@Features("Register feature")
public class RegistrationTest extends BaseTest {

    @Test
    @Stories("New user should be successfully registered")
    public void userShouldPassRegistrationSuccessfullyTest() throws InterruptedException {
        RegistrationData registrationData = new RegistrationData();
        RegistrationPage registrationPage = loginPage.openRegistrationPage();
        registrationPage.fillRegistrationForm(registrationData);
        registrationPage.submitRegistrationForm();
        assertTrue(registrationPage.isCapturePopupVisible(), "Capture is invisible");
    }
}
