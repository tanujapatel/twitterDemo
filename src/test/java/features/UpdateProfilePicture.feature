@twitterDemo
Feature: Update profile picture

  Scenario Outline: Update Profile Picture
    Given User launches Twitter Sign In page
    When User logs into Twitter using available username as "<username>" and password as "<password>"
    Then Login is successful
    And User selects profile picture as "<profilePicLocation>" and set the picture
    And User logs out
    And User closes browser

    Examples:
      | username | password | profilePicLocation |
      | UserName | Password | File_Name          |
