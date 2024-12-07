Feature: Login to account

  @login
  Scenario Outline: Login to account with credentials
    Given User navigates to "<url>"
    When User clicks on the login portal button
    And User enters the "<username>" username
    And User enters the "<password>" password
    When User clicks on the login button
    Then User should be presented with the following prompt alert "<message>"

    Examples: 
      | url                                  | username  | password     | message              |
      | https://www.webdriveruniversity.com/ | user1     | user2        | validation failed    |
      | https://www.webdriveruniversity.com/ | webdriver | webdriver124 | validation succeeded |
