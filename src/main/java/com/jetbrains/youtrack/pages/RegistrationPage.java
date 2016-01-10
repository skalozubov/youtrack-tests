package com.jetbrains.youtrack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.jetbrains.youtrack.testdata.RegistrationData;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Select;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class RegistrationPage extends BasePage {
    @FindBy(css = ".qc-firstname-row input")
    private TextInput firstNameTextInput;

    @FindBy(css = ".qc-lastname-row input")
    private TextInput lastNameTextInput;

    @FindBy(className = "qc-select-day")
    private Select dayOfBirth;

    @FindBy(className = "qc-select-month")
    private Select monthOfBirth;

    @FindBy(className = "qc-select-year")
    private Select yearOfBirth;

    @FindBy(id = "man1")
    private WebElement maleRadioButton;

    @FindBy(xpath = "//*[@id=\"loginField\"]/span/input")
    private TextInput emailAddress;

    @FindBy(css = ".qc-pass-row input")
    private TextInput password;

    @FindBy(css = ".qc-passverify-row input")
    private TextInput verifyPassword;

    @FindBy(css = ".btn_signup")
    private Button submitRegistrationButton;

    @FindBy(xpath = "//div[@class = \"is-signupphone2_in\"]")
    private WebElement capturePopup;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void fillRegistrationForm(RegistrationData testData) {
        firstNameTextInput.sendKeys(testData.getFirstName());
        lastNameTextInput.sendKeys(testData.getLastName());
        dayOfBirth.selectByVisibleText(testData.getDayOfBirth());
        monthOfBirth.selectByVisibleText(testData.getMonthOfBirth());
        yearOfBirth.selectByVisibleText(testData.getYear());
        maleRadioButton.click();
        emailAddress.sendKeys(testData.getEmailAddress());
        password.sendKeys(testData.getPassword());
        verifyPassword.sendKeys(testData.getPassword());
    }

    public void submitRegistrationForm() throws InterruptedException {
        //TODO: need to replace with expected conditions
        Thread.sleep(2000);
        submitRegistrationButton.click();
    }

    public boolean isCapturePopupVisible() {
        return capturePopup.isDisplayed();
    }
}
