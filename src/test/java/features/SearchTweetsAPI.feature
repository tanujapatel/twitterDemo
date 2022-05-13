@twitterDemo
Feature: Search Tweets

 Scenario: Search Tweets via API
    Given User creates Twitter instance
    When User searches for tweets
    Then User creates and verifies tweets
