package com.icesi.classroom.model;

import javafx.scene.image.Image;

import java.time.LocalDate;

public class StudentAccount {

    private String username;
    private String password;
    private Image image;
    private Gender gender;
    private Career career;
    private LocalDate birthDate;
    private Browser browser;

    public StudentAccount(String username, String password, Image image, Gender gender, Career career, LocalDate birthDate, Browser browser) {
        this.username = username;
        this.password = password;
        this.image = image;
        this.gender = gender;
        this.career = career;
        this.birthDate = birthDate;
        this.browser = browser;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Image getImage() {
        return image;
    }

    public Gender getGender() {
        return gender;
    }

    public Career getCareer() {
        return career;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Browser getBrowser() {
        return browser;
    }

    @Override
    public String toString(){
        return "\nUsername: " + this.username + " Career " + this.career;
    }
}
