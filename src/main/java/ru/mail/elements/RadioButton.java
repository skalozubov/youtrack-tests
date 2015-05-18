package ru.mail.elements;


import org.openqa.selenium.By;

public class RadioButton extends Element {
    public RadioButton(By by) {
        this.by = by;
    }

    public void click() {
        element().click();
    }

}
