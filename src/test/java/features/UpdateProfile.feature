@twitterDemo
Feature: Update profile information

  Scenario Outline: Update Bio, Location and URL
    Given User launches Twitter Sign In page
    When User logs into Twitter using available username as "<username>" and password as "<password>"
    Then Login is successful
    And User set profile details bio as "<bio>" and location as "<location>" and url as "<url>"
    And User verifies profile details as "<bio>" and location as "<location>" and url as "<url>"
    And User logs out
    And User closes browser

    Examples:
      | username | password | bio                      | location | url         |
      | UserName | Password | Selenium Automation User | Pune     | twitter.com |
