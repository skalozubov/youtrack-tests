package ru.mail.elements;

import org.openqa.selenium.By;
import ru.mail.elements.Element;

public class InputField extends Element {

    public InputField(By by) {
        this.by = by;
    }

    public void sendKeys(String keys) {
        element().sendKeys(keys);
    }
}
