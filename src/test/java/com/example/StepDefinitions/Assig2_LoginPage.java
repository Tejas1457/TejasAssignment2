package com.example.StepDefinitions;

import io.cucumber.java.en.When;

import static org.example.LoginPageValidation.loginClick;
import static org.example.LoginPageValidation.loginPageUiValidation;

public class Assig2_LoginPage {
    @When("User navigate to login page and validate UI")
    public void userNavigateToLoginPageAndValidateUI() {
        loginClick();
        loginPageUiValidation();
    }
}
