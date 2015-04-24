import org.openqa.selenium.By;

//TODO: convert interface into enum
public interface Locators {
    By loginField = By.id("mailbox__login");
    By passwordField = By.id("mailbox__password");
    By submitLoginFormButton = By.id("mailbox__auth__button");
}
