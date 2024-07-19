Feature: Verify Login Functionality

  Scenario Outline: Login with valid credentials
    Given user has navigated to login page.
    When User enter email address <email>
    And User enter password <password>
    And user clicks on login button
    Then user navigated to admin dashboard.

    Examples: 
      | email                 | password  |
      | prakash@freerange.com | Avdi@1212 |

  Scenario: Unsuccessful login with invalid credentials
    Given user has navigated to login page.
    When User enter email address <email>
    And User enter password <password>
    And user clicks on login button
    Then user should get a warning message
		
		Examples:
    	|email|password|
    	|prakash-tester@freerange.com|Avdi@1212|
    	
    	
	Scenario: Unsuccessful login with missing credentials
    Given user has navigated to login page.
    When User dont enter email address
    And User dont enter password
    And user clicks on login button
    Then user should get a warning message
		

    
