package ru.mail.pages;

import org.openqa.selenium.WebDriver;
import ru.mail.elements.*;
import ru.mail.locators.RegisterPageLocators;
import ru.mail.testdata.RegistrationData;

public class RegistrationPage extends BasePage {

    private InputField firstNameInputField = new InputField(RegisterPageLocators.FIRST_NAME.getValue(), driver);
    private InputField lastNameInputField = new InputField(RegisterPageLocators.LAST_NAME.getValue(), driver);
    private Dropdown dayOfBirth = new Dropdown(RegisterPageLocators.DAY_OF_BIRTH.getValue(), driver);
    private Dropdown monthOfBirth = new Dropdown(RegisterPageLocators.MONTH_OF_BIRTH.getValue(), driver);
    private Dropdown yearOfBirth = new Dropdown(RegisterPageLocators.YEAR_OF_BIRTH.getValue(), driver);
    private RadioButton maleRadioButton = new RadioButton(RegisterPageLocators.MALE_RADIO_BUTTON.getValue(), driver);
    private InputField emailAddress = new InputField(RegisterPageLocators.EMAIL_ADDRESS.getValue(), driver);
    private InputField password = new InputField(RegisterPageLocators.PASSWORD_INPUT.getValue(), driver);
    private InputField verifyPassword = new InputField(RegisterPageLocators.VERIFY_PASSWORD.getValue(), driver);
    private Button submitRegistrationButton = new Button(RegisterPageLocators.SUBMIT_BUTTON.getValue(), driver);
    private CapturePopup capturePopup = new CapturePopup(RegisterPageLocators.CAPTURE_POPUP.getValue(), driver);

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void fillRegistrationForm(RegistrationData testData) {
        firstNameInputField.sendKeys(testData.getFirstName());
        lastNameInputField.sendKeys(testData.getLastName());
        dayOfBirth.select(testData.getDayOfBirth());
        monthOfBirth.select(testData.getMonthOfBirth());
        yearOfBirth.select(testData.getYear());
        maleRadioButton.click();
        emailAddress.sendKeys(testData.getEmailAddress());
        password.click();
        password.sendKeys(testData.getPassword());
        verifyPassword.sendKeys(testData.getPassword());
    }

    public void submitRegistrationForm() throws InterruptedException {
        Thread.sleep(2000);
        submitRegistrationButton.click();
    }

    public boolean isCapturePopupVisible() {
        return capturePopup.isDisplayed();
    }
}
