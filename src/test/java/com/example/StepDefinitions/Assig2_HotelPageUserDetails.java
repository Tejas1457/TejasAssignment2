package com.example.StepDefinitions;

import io.cucumber.java.en.And;
import org.example.HotelPageUserDetails;

import static org.example.HotelPageUserDetails.*;

public class Assig2_HotelPageUserDetails extends HotelPageUserDetails {
    @And("User can able to select city and other details and click on search")
    public void userCanAbleToSelectCityAndOtherDetailsAndClickOnSearch() {
        citySelector();
        checkInAndCheckOutDateSelector();
        roomSelector();
    }
}
