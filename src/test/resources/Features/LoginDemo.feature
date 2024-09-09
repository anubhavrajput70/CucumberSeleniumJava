Feature: Test login functionality

  Scenario: Check login is successful with valid credentials
    Given user is on the browser
    And user is on login page
    When user enters username and password
    Then user is navigated to the home page
