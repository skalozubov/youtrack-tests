package ru.mail.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CapturePopup extends Element {
    public CapturePopup(By by, WebDriver driver) {
        super(by, driver);
    }

    public boolean isDisplayed() {
        return element().isDisplayed();
    }
}
