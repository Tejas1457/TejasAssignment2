package com.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Assig2_Base;

import java.io.IOException;

import static org.example.Assig2_Base.browserQuit;
import static org.example.SearchBtnValidation.LoginBtnValidation;
import static org.example.SearchBtnValidation.SearchBtnValidation;

public class Assig2_Negative  {
    @When("User validates Search button")
    public void userValidatesSearchButton() throws IOException {
        SearchBtnValidation();
    }

    @And("User validates Login button")
    public void userValidatesLoginButton() throws IOException{
        LoginBtnValidation();
    }

    @Then("User closed the application")
    public void userClosedTheApplication() {
        browserQuit();
    }
}
