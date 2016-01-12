package com.jetbrains.youtrack.pages;

import com.jetbrains.youtrack.helpers.SeleniumHelper;
import com.jetbrains.youtrack.users.YoutrackUser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.element.Button;

public class DashboardPage extends BaseYoutrackPage {
    @FindBy(css = "widget-youtrack-issues")
    private WebElement youtrackIssuesWidget;

    @FindBy(css = ".ring-header__user-menu-item_login > button")
    private Button loginButton;

    @FindBy(xpath = ".//img[@class = \"ring-icon__pic\"]/../..")
    private WebElement userMenuItem;

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageCorrect() {
        return SeleniumHelper.isElementPresentAndVisible(youtrackIssuesWidget);
    }

    @Step("Click Login button")
    public LoginPage clickLoginButton() {
        loginButton.click();
        return new LoginPage(driver);
    }

    @Step("Check that user is successfully logged in")
    public boolean isUserLoggedIn(YoutrackUser user) {
        return userMenuItem.getAttribute("title").equals(user.getUsername());
    }
}
