package ru.mail.pages;

import org.openqa.selenium.WebDriver;
import ru.mail.helpers.WebDriverManager;
import ru.mail.elements.Button;
import ru.mail.elements.InputField;
import ru.mail.locators.LoginPageLocators;
import ru.yandex.qatools.allure.annotations.Step;

public class LoginPage extends BasePage {
    private InputField loginInputField = new InputField(LoginPageLocators.LOGIN_FIELD.getValue(), driver);
    private InputField passwordInputField = new InputField(LoginPageLocators.PASSWORD_FIELD.getValue(), driver);
    private Button submitLoginFormButton = new Button(LoginPageLocators.SUBMIT_LOGIN_FORM_BUTTON.getValue(), driver);
    private Button openRegistrationPageButton = new Button(LoginPageLocators.OPEN_REGISTRATION_BUTTON.getValue(), driver);

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

    @Step("Submit login form")
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
