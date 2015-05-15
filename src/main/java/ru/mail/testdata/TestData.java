package ru.mail.testdata;

public class TestData {
    private String incorrectLogin = "test";
    private String incorrectPassword = "test";
    private String correctLogin = "sourceittest";
    private String correctPassword = "sourceit12345";
    private String pageTitle = "Вход - Почта Mail.Ru";
    private String pageUrl = "https://e.mail.ru/messages/inbox/?back=1";

    public String getIncorrectLogin() {
        return incorrectLogin;
    }

    public void setIncorrectLogin(String incorrectLogin) {
        this.incorrectLogin = incorrectLogin;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public String getIncorrectPassword() {
        return incorrectPassword;
    }

    public void setIncorrectPassword(String incorrectPassword) {
        this.incorrectPassword = incorrectPassword;
    }

    public String getCorrectLogin() {
        return correctLogin;
    }

    public void setCorrectLogin(String correctLogin) {
        this.correctLogin = correctLogin;
    }

    public String getCorrectPassword() {
        return correctPassword;
    }

    public void setCorrectPassword(String correctPassword) {
        this.correctPassword = correctPassword;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }
}
