package ru.mail.locators;

import org.openqa.selenium.By;

public enum RegisterPageLocators {

    FIRST_NAME(By.cssSelector(".qc-firstname-row input")),
    LAST_NAME(By.cssSelector(".qc-lastname-row input")),
    DAY_OF_BIRTH(By.className("qc-select-day")),
    MONTH_OF_BIRTH(By.className("qc-select-month")),
    MALE_RADIO_BUTTON(By.id("man1")),
    EMAIL_ADDRESS(By.xpath("//div[@class = \"loginField\"]/span/input")),
    PASSWORD_INPUT(By.cssSelector(".qc-pass-row input")),
    VERIFY_PASSWORD(By.cssSelector(".qc-passverify-row input")),
    SUBMIT_BUTTON(By.cssSelector(".btn_signup")),
    CAPTURE_POPUP(By.xpath("//div[@class = \"is-signupphone2_in\"]")),
    YEAR_OF_BIRTH(By.className("qc-select-year"));

    private By locator;

    private RegisterPageLocators(By locator) {
        this.locator = locator;
    }

    public By getValue() {
        return this.locator;
    }
}
