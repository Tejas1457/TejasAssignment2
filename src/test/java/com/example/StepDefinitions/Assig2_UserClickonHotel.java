package com.example.StepDefinitions;

import io.cucumber.java.en.When;

import static org.example.UserClickOnHotel.hotelClick;

public class Assig2_UserClickonHotel {
    @When("User click on hotels")
    public void userClickOnHotels() {
        hotelClick();
    }
}
