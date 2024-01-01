package com.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static org.example.InvalidLogin.invalidLoginCheck;
import static org.example.ValidBIUserLogin.*;


public class Assig2_UserLogin {
    @Then("User try to login with Valid credentials")
    public void userTryToLoginWithValidCredentials() throws Exception {
        // enterUserName();
        userEntersEmail();
        userEnterOtherDetails();
        otpPage();
    }

    @And("User try to login with Invalid credentials")
    public void userTryToLoginWithInvalidCredentials() throws Exception {
        invalidLoginCheck();
        browserQuit();
    }
}
