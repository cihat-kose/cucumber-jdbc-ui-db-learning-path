# Country menu as create,delete,
# Run the scenario outline 5 times
# In this scenario, there is a software error in country delete

Feature:  Country Functionality

  Background:
    Given Navigate to campus
    When Enter valid username and password and click login button
    Then User should login successfully
    And Navigate to country

  Scenario Outline: Country with Parameter
    When Create a country that name as "<name>" code as "<code>"
    Then Success message should be displayed
    When Create a country that name as "<name>" code as "<code>"
    Then Already exist message should be displayed
    When User delete the country that name as "<name>"
    Then Success message should be displayed

    Examples:
      | name           | code   |
      | Eldoria        | ELD01  |
      | Norvania       | NOR99  |
      | Zafrania       | ZAF75  |
      | Veltronia      | VLT20  |
      | Arkenland      | ARK88  |