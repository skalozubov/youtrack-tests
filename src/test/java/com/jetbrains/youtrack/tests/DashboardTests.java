package com.jetbrains.youtrack.tests;

import com.jetbrains.youtrack.BaseTest;
import com.jetbrains.youtrack.pages.DashboardPage;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Stories;

import static org.testng.Assert.assertTrue;

public class DashboardTests extends BaseTest {

    @Test
    @Stories("Any user should be able to see the Dashboard")
    public void anyUserShouldBeAbleToSeeTheDashboard() {
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.open();
        assertTrue(dashboardPage.isPageCorrect(), "Dashboard page was not verified");
    }
}
