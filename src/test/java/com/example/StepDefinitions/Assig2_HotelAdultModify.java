package com.example.StepDefinitions;

import io.cucumber.java.en.Then;

import static org.example.HotelUpdateAdult.adultChanger;

public class Assig2_HotelAdultModify {
    @Then("User modifies the number of adults and checkout")
    public void userModifiesTheNumberOfAdultsAndCheckout() {
        adultChanger();
    }
}
