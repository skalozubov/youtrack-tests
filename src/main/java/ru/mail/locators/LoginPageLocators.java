package ru.mail.locators;

import org.openqa.selenium.By;

public enum LoginPageLocators {

    LOGIN_FIELD(By.id("mailbox__login")),
    PASSWORD_FIELD(By.id("mailbox__password")),
    SUBMIT_LOGIN_FORM_BUTTON(By.id("mailbox__auth__button")),
    OPEN_REGISTRATION_BUTTON(By.className("mailbox__register__link"));

    private By locator;

    private LoginPageLocators(By locator) {
        this.locator = locator;
    }

    public By getValue() {
        return this.locator;
    }
}
