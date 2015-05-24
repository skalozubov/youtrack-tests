package ru.mail.pages;

import org.openqa.selenium.WebDriver;
import ru.mail.helpers.WebDriverManager;
import ru.mail.elements.Button;
import ru.mail.elements.InputField;
import ru.mail.locators.LoginPageLocators;

public class LoginPage extends BasePage {
    private InputField loginInputField = new InputField(LoginPageLocators.LOGIN_FIELD.getValue(), driver);
    private InputField passwordInputField = new InputField(LoginPageLocators.PASSWORD_FIELD.getValue(), driver);
    private Button submitLoginFormButton = new Button(LoginPageLocators.SUBMIT_LOGIN_FORM_BUTTON.getValue(), driver);
    private Button openRegistrationPageButton = new Button(LoginPageLocators.OPEN_REGISTRATION_BUTTON.getValue(), driver);

    public LoginPage(WebDriver driver) {
        super(driver);
    }

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
        return new InboxPage(driver);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public RegistrationPage openRegistrationPage() {
        openRegistrationPageButton.click();
        return new RegistrationPage(driver);
    }
}
