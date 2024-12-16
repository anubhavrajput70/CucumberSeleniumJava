Feature: Submit data to webdriveruniversity.com using contact us form

  #backgroud keyword is for common step for all the feature have it is a precondition
  # Background:
  #    Given User is on the webdriveruniversity
  #   When User click on the contact us button
  @contactus
  Scenario: Submit information using the contact us form
    Given User Access webdriveruniversity contactus form
    And User enter firstname
    And User enter lastname
      | woods | jackson | jones |
    And User enter an email address
    And User enter comments
      | example comment one | example comment two |
    When User clicks on the submit button
    Then the information should be successfully be submitted via contact us forms

  Scenario: Submit information using the contact us form, when click on the reset button then information should be removed
    And User enter a invalid firstname
    And User enter a invalid lastname
    And User enter  a invalidan email address
    And User enter comments
    When User clicks on the reset button
    Then all the information which was listed by the user on the contact us form should now be removed
