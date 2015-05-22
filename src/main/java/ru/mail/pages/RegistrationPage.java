package ru.mail.pages;

import ru.mail.elements.*;
import ru.mail.locators.RegisterPageLocators;
import ru.mail.testdata.RegistrationData;

public class RegistrationPage {

    private InputField firstNameInputField = new InputField(RegisterPageLocators.FIRST_NAME.getValue());
    private InputField lastNameInputField = new InputField(RegisterPageLocators.LAST_NAME.getValue());
    private Dropdown dayOfBirth = new Dropdown(RegisterPageLocators.DAY_OF_BIRTH.getValue());
    private Dropdown monthOfBirth = new Dropdown(RegisterPageLocators.MONTH_OF_BIRTH.getValue());
    private Dropdown yearOfBirth = new Dropdown(RegisterPageLocators.YEAR_OF_BIRTH.getValue());
    private RadioButton maleRadioButton = new RadioButton(RegisterPageLocators.MALE_RADIO_BUTTON.getValue());
    private InputField emailAddress = new InputField(RegisterPageLocators.EMAIL_ADDRESS.getValue());
    private InputField password = new InputField(RegisterPageLocators.PASSWORD_INPUT.getValue());
    private InputField verifyPassword = new InputField(RegisterPageLocators.VERIFY_PASSWORD.getValue());
    private Button submitRegistrationButton = new Button(RegisterPageLocators.SUBMIT_BUTTON.getValue());
    private CapturePopup capturePopup = new CapturePopup(RegisterPageLocators.CAPTURE_POPUP.getValue());

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
