package com.example.StepDefinitions;

import io.cucumber.java.en.When;
import org.example.HeaderValidation;


public class Assig2_HeaderValidation extends HeaderValidation {
    @When("User validates headers")
    public void userValidatesHeaders() {
        imageSrcValidation();
        offerFieldValidation();
        businessTextValidation();
        tripTextValidation();
        loginTextValidation();
    }
}
