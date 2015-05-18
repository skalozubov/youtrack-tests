package ru.mail.pages;

import ru.mail.helpers.WebDriverManager;
import ru.mail.elements.Button;
import ru.mail.elements.InputField;
import ru.mail.locators.LocatorsEnum;

public class LoginPage {
    private InputField loginInputField = new InputField(LocatorsEnum.LOGIN_FIELD.getValue());
    private InputField passwordInputField = new InputField(LocatorsEnum.PASSWORD_FIELD.getValue());
    private Button submitLoginFormButton = new Button(LocatorsEnum.SUBMIT_LOGIN_FORM_BUTTON.getValue());

    public LoginPage fillLoginField(String login) {
        loginInputField.sendKeys(login);
        return this;
    }

    public LoginPage fillPasswordField(String password) {
        passwordInputField.sendKeys(password);
        return this;
    }

    public LoginPage submitLoginForm() {
        submitLoginFormButton.click();
        return this;
    }

    public InboxPage submitSuccessfulLoginForm() {
        submitLoginFormButton.click();
        return new InboxPage();
    }

    public String getPageTitle() {
        return WebDriverManager.getDriver().getTitle();
    }
}
