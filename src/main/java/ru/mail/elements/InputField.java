package ru.mail.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InputField extends Element {

    public InputField(By by, WebDriver driver) {
        super(by, driver);
    }

    public void sendKeys(String keys) {
        element().sendKeys(keys);
    }

    public void click() {
        element().click();
    }
}
