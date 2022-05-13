@twitterDemo
Feature: Login

 Scenario Outline: Successful Login
    Given User launches Twitter Sign In page
    When User logs into Twitter using available username as "<username>" and password as "<password>"
    Then Login is successful
    And User logs out
    And User closes browser
 
Examples:
    | username  | password  |
		| UserName | Password |