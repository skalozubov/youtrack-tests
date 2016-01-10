package com.jetbrains.youtrack.pages;

import org.openqa.selenium.WebDriver;

public class YoutrackPagesFactory {
    private WebDriver driver;

    public YoutrackPagesFactory(WebDriver driver) {
        this.driver = driver;
    }

    public BaseYoutrackPage getPage(YoutrackPages page) {
        switch (page) {
            case DASHBOARD:
                return new DashboardPage(driver);
            case LOGIN:
                return new LoginPage(driver);
            default:
                return null;
        }
    }
}
