package com.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Assig1_Base;

import java.io.IOException;

import static org.example.FlightBooking.BookingStatus;
import static org.example.FlightBooking.FlightDataEntry;

public class Assig1_imp extends Assig1_Base {

    @Given("User launches the application")
    public void userLaunchesTheApplication() throws IOException {
        flag = 0;
        BrowserSetup();
    }

    @Then("User click on Register")
    public void userClickOnRegister() {
        RegisterClick();
    }

    @And("enter the user name and password")
    public void enterTheUserNameAndPassword() {
        UserRegistration();
    }

    @Then("validate user login")
    public void validateUserLogin() {
        UserValidation();
        BrowserClose();
    }

    @When("User login to the application with registered credentials")
    public void userLoginToTheApplicationWithRegisteredCredentials() {
        ValidUserLoginCheck();
    }

    @Then("User able to login successfully")
    public void userAbleToLoginSuccessfully() {
        BrowserClose();
    }

    @When("User try to login with valid username and invalid password")
    public void userTryToLoginWithValidUsernameAndInvalidPassword() {
        ValidUserInvalidPassword();
    }

    @Then("User unable to login")
    public void userUnableToLogin() {
        BrowserClose();
    }

    @Given("User launches the application to book flight ticket")
    public void userLaunchesTheApplicationToBookFlightTicket() throws IOException {
        flag = 1;
        BrowserSetup();
    }

    @Then("User able to enter required details in booking page")
    public void userAbleToEnterRequiredDetailsInBookingPage() {
        FlightDataEntry();
    }

    @Then("User can see the ticket booking status")
    public void userCanSeeTheTicketBookingStatus() {
        BookingStatus();
        BrowserClose();
    }
}
