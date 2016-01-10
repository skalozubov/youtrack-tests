package com.jetbrains.youtrack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;

public abstract class BaseYoutrackPage {
    protected WebDriver driver;
    protected YoutrackPagesFactory pagesFactory;

    public BaseYoutrackPage(WebDriver driver) {
        PageFactory.initElements(new HtmlElementDecorator(driver), this);
        this.driver = driver;
        verifyPage();
        pagesFactory = new YoutrackPagesFactory(driver);
    }

    @Step("Check that page is correct")
    private void verifyPage() {
        if (!isPageCorrect()) {
            throw new IllegalStateException(this.toString() +
                    " was not verified. Current URL is: " + driver.getCurrentUrl());
        }
    }

    protected abstract boolean isPageCorrect();

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
