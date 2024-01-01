package com.example.StepDefinitions;

import io.cucumber.java.en.When;

import static org.example.WebsiteNameAndUrlValidation.nameAndUrlValidation;

public class Assig2_WebsiteNameValidation {
    @When("User validates website name and url")
    public void userValidatesWebsiteNameandUrl() {
        nameAndUrlValidation();
    }
}
