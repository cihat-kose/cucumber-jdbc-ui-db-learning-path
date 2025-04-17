Feature: Country Multi Scenario

  Background:
    Given Navigate to campus
    When  Enter valid username and password and click login button
    Then  User should login successfully
    And   Navigate to country

  @Regression
  Scenario: Create a country
    When  Create a country
    Then  Success message should be displayed

  @Regression
  Scenario: Create a country with base name and code (but generate unique)
    When  Create a unique country based on name "TrainingLand" and code "TRL"
    Then  Success message should be displayed
 

