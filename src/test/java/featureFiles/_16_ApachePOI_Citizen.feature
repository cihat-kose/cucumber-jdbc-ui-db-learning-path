# Scenario:

# First save all the Citizenship information you read from Excel
# Then delete it.

Feature: ApachePOI Citizen Functionality

  Background:
    Given Navigate to campus
    When Enter valid username and password and click login button
    Then User should login successfully
    And Navigate to citizenship

  @Regression
  Scenario: Create and Delete CitizenShip From Excel
    When User create citizenship with ApachePOI
    Then User delete citizenship with ApachePOI