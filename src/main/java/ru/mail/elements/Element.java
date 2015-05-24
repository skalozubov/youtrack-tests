package ru.mail.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class Element {
    protected WebDriver driver;
    protected By by;

    public Element(By by, WebDriver driver) {
        this.by = by;
        this.driver = driver;
    }

    public WebElement element() {
        return driver.findElement(by);
    }
}
