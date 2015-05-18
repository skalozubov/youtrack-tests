package ru.mail.testdata;

import java.util.Random;

public class RegistrationData {
    private String firstName = "John";
    private String lastName = "Doe";
    private String dayOfBirth = "11";
    private String monthOfBirth = "Сентябрь";
    private String year = "2000";
    private String emailAddress = "testEmail" + new Random().nextInt(Integer.MAX_VALUE);
    private String password = "swordfish12345";


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public String getMonthOfBirth() {
        return monthOfBirth;
    }

    public void setMonthOfBirth(String monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }
}
