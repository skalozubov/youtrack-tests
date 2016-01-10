package com.jetbrains.youtrack.tests;

import com.jetbrains.youtrack.BaseTest;
import com.jetbrains.youtrack.pages.DashboardPage;
import com.jetbrains.youtrack.pages.LoginPage;
import com.jetbrains.youtrack.pages.YoutrackPages;
import com.jetbrains.youtrack.testdata.DefaultData;
import com.jetbrains.youtrack.users.YoutrackUser;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Stories;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTest {

    @Test
    @Stories("Existing user should be able to login successfully")
    public void existingUserShouldBeAbleToLogin() {
        YoutrackUser user = DefaultData.DEVELOPER_YOUTRACK_USER;
        DashboardPage dashboardPage = new DashboardPage(driver);

        LoginPage loginPage = dashboardPage.clickLoginButton();
        dashboardPage = (DashboardPage) loginPage.doLogin(user, YoutrackPages.DASHBOARD);
        assertTrue(dashboardPage.isUserLoggedIn(user), "User was not logged in");
    }

    @Test
    @Stories("User with incorrect password should not be able to login")
    public void userWithIncorrectPasswordShouldNotBeAbleToLogin() {
        YoutrackUser user = DefaultData.DEVELOPER_YOUTRACK_USER;
        user.setPassword("some_incorrect_password");
        DashboardPage dashboardPage = new DashboardPage(driver);

        LoginPage loginPage = dashboardPage.clickLoginButton();
        loginPage = (LoginPage) loginPage.doLogin(user, YoutrackPages.LOGIN);
        assertTrue(loginPage.isLoginErrorMessageVisible(), "Login error message is absent");
    }
}
