package com.jetbrains.youtrack.pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class LoginPage extends BaseYoutrackPage {
    @FindBy(id = "mailbox__login")
    private TextInput loginInputField;

    @FindBy(id = "mailbox__password")
    private TextInput passwordInputField;

    @FindBy(id = "mailbox__auth__button")
    private Button submitLoginFormButton;

    @FindBy(className = "mailbox__register__link")
    private Button openRegistrationPageButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Fill login field")
    public LoginPage fillLoginField(String login) {
        loginInputField.sendKeys(login);
        return this;
    }

    @Step("Fill password field")
    public LoginPage fillPasswordField(String password) {
        passwordInputField.sendKeys(password);
        return this;
    }

    @Step("Submit login form")
    public LoginPage submitLoginForm() {
        submitLoginFormButton.click();
        return this;
    }

}
