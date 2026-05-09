package com.mycompany.klainsuniapp;

public class Person {
    private String givenName;
    private String surname;
    private String dob;

    public Person(String givenName, String surname, String dob) {
        this.givenName = givenName;
        this.surname = surname;
        this.dob = dob;
    }

    // Getters
    public String getGivenName() {
        return givenName;
    }

    public String getSurname() {
        return surname;
    }

    public String getDob() {
        return dob;
    }

    // Setters
    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}