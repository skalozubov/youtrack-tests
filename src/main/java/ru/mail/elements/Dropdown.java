package ru.mail.elements;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import ru.mail.helpers.WebDriverManager;

public class Dropdown extends Select {

    public Dropdown(By by) {
        super(WebDriverManager.getDriver().findElement(by));
    }

    public void select(String data) {
        super.selectByVisibleText(data);
    }
}
