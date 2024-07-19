Feature: Verify Login Functionality

  Scenario Outline: Login with valid credentials
    Given user has navigated to login page.
    When User enter valid email address <email>
    And User enter valid password <password>
    And user clicks on login button
    Then user navigated to admin dashboard.

    Examples: 
      | email                 | password  |
      | prakash@freerange.com | Avdi@1212 |