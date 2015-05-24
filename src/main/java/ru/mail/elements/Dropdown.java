package ru.mail.elements;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown extends Select {

    public Dropdown(By by, WebDriver driver) {
        super(driver.findElement(by));
    }

    public void select(String data) {
        super.selectByVisibleText(data);
    }
}
