package com.example.StepDefinitions;

import io.cucumber.java.en.And;

import static org.example.HotelSelection.setHotelSelector;

public class Assig2_HotelSelection {
    @And("User Select the Required hotel")
    public void userSelectTheRequiredHotel() {
        setHotelSelector();
    }
}
