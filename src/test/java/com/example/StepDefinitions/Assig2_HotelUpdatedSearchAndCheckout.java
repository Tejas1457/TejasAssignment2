package com.example.StepDefinitions;

import io.cucumber.java.en.And;

import static org.example.Assig2_Base.browserQuit;
import static org.example.UpdatedSearchAndCheckout.checkoutWithUpdatedData;

public class Assig2_HotelUpdatedSearchAndCheckout {
    @And("User Serach for hotels with updated data and chekout")
    public void userSerachForHotelsWithUpdatedDataAndChekout() {
        checkoutWithUpdatedData();
        browserQuit();
    }
}
