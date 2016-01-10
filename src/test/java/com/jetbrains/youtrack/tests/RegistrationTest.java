package com.jetbrains.youtrack.tests;

import com.jetbrains.youtrack.pages.RegistrationPage;
import org.testng.annotations.Test;
import com.jetbrains.youtrack.BaseTest;
import com.jetbrains.youtrack.testdata.RegistrationData;
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
