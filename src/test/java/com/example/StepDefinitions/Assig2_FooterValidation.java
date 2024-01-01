package com.example.StepDefinitions;

import io.cucumber.java.en.And;
import org.example.FooterValidation;


public class Assig2_FooterValidation extends FooterValidation {
    @And("User validates footers")
    public void userValidatesFooters() {
        tripTextValidation();
        bookingTextValidation();
        flightTextValidation();
        footerPictureCapture();
        browserQuit();
    }
}
