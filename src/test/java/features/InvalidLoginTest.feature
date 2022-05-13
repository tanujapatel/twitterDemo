@twitterDemo
Feature: Login

  @invalidLogin
 Scenario Outline: Invalid Login
    Given User launches Twitter Sign In page
    When User logs into Twitter using available username as "<username>" and password as "<password>"
    Then Error message is shown for invalid login as "<errMsg>"
    And User closes browser
 
Examples:
    | username  | password  | errMsg  |
    | user | pwd |Wrong password!     |
