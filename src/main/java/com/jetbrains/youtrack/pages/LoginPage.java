package com.jetbrains.youtrack.pages;

import com.jetbrains.youtrack.helpers.SeleniumHelper;
import com.jetbrains.youtrack.users.YoutrackUser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class LoginPage extends BaseYoutrackPage {
    @FindBy(css = ".login-button")
    private Button submitLoginButton;

    @FindBy(css = "#username")
    private TextInput usernameInputField;

    @FindBy(css = "#password")
    private TextInput passwordInputField;

    @FindBy(xpath = ".//div[@class=\"header__text\"]/span[@ng-show=\"message\"]")
    private WebElement loginErrorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageCorrect() {
        return SeleniumHelper.isElementPresentAndVisible(submitLoginButton.getWrappedElement());
    }

    @Step("Fill login form and submit it")
    public BaseYoutrackPage doLogin(YoutrackUser user, YoutrackPages targetPage) {
        usernameInputField.clear();
        usernameInputField.sendKeys(user.getUsername());
        passwordInputField.clear();
        passwordInputField.sendKeys(user.getPassword());
        submitLoginButton.click();
        return pagesFactory.getPage(targetPage);
    }

    @Step("Check that login error message is on the page")
    public boolean isLoginErrorMessageVisible() {
        return SeleniumHelper.isElementPresentAndVisible(loginErrorMessage);
    }
}
