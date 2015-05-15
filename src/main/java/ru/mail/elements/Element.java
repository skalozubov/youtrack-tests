package ru.mail.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.mail.helpers.WebDriverManager;

public abstract class Element {
    protected By by;

    public WebElement element() {
        return WebDriverManager.getDriver().findElement(by);
    }
}
