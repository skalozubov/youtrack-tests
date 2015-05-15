package ru.mail.locators;

import org.openqa.selenium.By;

public enum LocatorsEnum {

    LOGIN_FIELD(By.id("mailbox__login")),
    PASSWORD_FIELD(By.id("mailbox__password")),
    SUBMIT_LOGIN_FORM_BUTTON(By.id("mailbox__auth__button"));

    private By locator;

    private LocatorsEnum(By locator) {
        this.locator = locator;
    }

    public By getValue() {
        return this.locator;
    }
}
