package ru.mail.elements;

import org.openqa.selenium.By;

public class InputField extends Element {

    public InputField(By by) {
        this.by = by;
    }

    public void sendKeys(String keys) {
        element().sendKeys(keys);
    }
}
