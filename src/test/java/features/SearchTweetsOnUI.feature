@twitterDemo
Feature: Search Tweets

  Scenario Outline: Search Tweets on UI
    Given User launches Twitter Sign In page
    When User logs into Twitter using available username as "<username>" and password as "<password>"
    Then Login is successful
    And User searches for tweets using search string as "<searchString>"
    And User logs out
    And User closes browser

    Examples:
      | username | password | searchString |
      | UserName | Password | News         |