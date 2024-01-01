package com.example.StepDefinitions;

import io.cucumber.java.en.Given;

import static org.example.Assig2_Base.browserLaunch;
import static org.example.DataDecrypter.dataEncrypter;


public class Assig2_imp  {
    @Given("User launch the application")
    public void userLaunchTheApplication() throws Exception {
        browserLaunch();
    }
}
