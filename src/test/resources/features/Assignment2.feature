Feature: Assignment2

  @Tejas
  Scenario: Validate headers, footers and website name
    Given User launch the application
    When User validates website name and url
    When User validates headers
    And User validates footers

  @Tejas
  Scenario: Login page Validation
    Given User launch the application
    When User navigate to login page and validate UI
    Then User try to login with Valid credentials
    And User try to login with Invalid credentials

  @Tejas
  Scenario: Hotel Booking
    Given User launch the application
    When User click on hotels
    And User can able to select city and other details and click on search
    And User Select the Required hotel
    Then User modifies the number of adults and checkout
    And User Serach for hotels with updated data and chekout

    @Tejas
    Scenario: Search Button Text validation (Negative scenario)
      Given User launch the application
      When User validates Search button
      And User validates Login button
      Then User closed the application




