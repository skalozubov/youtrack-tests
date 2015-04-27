/**
 * Created by kate on 27.04.15.
 */
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
        return ConfigurationManager.getDriver().getTitle();
    }

    public void getLatestEmail() {

    }
}
