package ru.mail.elements;

import org.openqa.selenium.By;

public class CapturePopup extends Element {
    public CapturePopup(By by) {
        this.by = by;
    }

    public boolean isDisplayed() {
        return element().isDisplayed();
    }
}
