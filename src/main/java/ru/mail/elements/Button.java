package ru.mail.elements;

import org.openqa.selenium.By;

public class Button extends Element {

    public Button(By by) {
        this.by = by;
    }

    public void click() {
        element().click();
    }
}
