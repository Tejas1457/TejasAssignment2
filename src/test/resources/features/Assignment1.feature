Feature: Assignment1
  #Launching of application can be put inside Background: tag for all the Scenarios
  @Test
  Scenario: Register a new user
    Given User launches the application
    Then User click on Register
    And enter the user name and password
    Then validate user login

  @Test
  Scenario: Validate user is able to login with valid credentials
    Given User launches the application
    When User login to the application with registered credentials
    Then User able to login successfully

  @Test
  Scenario: Validate user is unable to login with invalid credentials
    Given User launches the application
    When User try to login with valid username and invalid password
    Then User unable to login

  @Test
  Scenario: Valid User able to book flight ticket
    Given User launches the application to book flight ticket
    Then User able to enter required details in booking page
    Then User can see the ticket booking status
