Feature: feature to test google search functionality

	@search
  Scenario: validate google search functionality
    Given user is on the browser
    And user enters a text in the search box
    When user enters a text in search box
    And hits enter
    Then user is navigated to search results
