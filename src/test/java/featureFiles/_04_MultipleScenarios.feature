Feature: Multi Scenario

  Background:
    Given Navigate to campus
    When Enter valid username and password and click login button
    Then User should login successfully

  Scenario: Create a Country
    And Navigate to country
    When Create a country
    Then Success message should be displayed

  Scenario: Create a CitizenShip
    And Navigate to citizenship
    When Create a citizenship
    Then Success message should be displayed
