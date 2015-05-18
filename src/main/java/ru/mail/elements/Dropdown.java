package ru.mail.elements;


import org.openqa.selenium.By;

public class Dropdown extends Element {

    public Dropdown(By by) {
        this.by = by;
    }

    public void select(String data) {
        element().select(data);
    }
}
