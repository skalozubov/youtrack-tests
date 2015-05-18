package ru.mail.tests;

import org.testng.annotations.Test;
import ru.mail.BaseTest;
import ru.mail.pages.RegistrationPage;
import ru.mail.testdata.RegistrationData;

import static org.testng.Assert.assertTrue;

public class RegistrationTest extends BaseTest {

    @Test
    public void userShouldPassRegistrationSuccessfullyTest() {
        RegistrationData registrationData = new RegistrationData();
        RegistrationPage registrationPage = loginPage.openRegistrationPage();
        registrationPage.fillRegistrationForm(registrationData);
        registrationPage.submitRegistrationForm();
        assertTrue(registrationPage.isCapturePopupVisible(), "Capture is invisible");
    }
}
