# Scenario:
# Check whether the first 10 data in the nationalities menu are the same as the data in the DB.

# Senaryo:
# Nationalities menusunde gelen ilk 10 verinin DB deki data ile aynı olup olmadığını kontrol ediniz.

Feature: Testing JDBC States

  Background:
    Given Navigate to campus
    When Enter valid username and password and click login button
    Then User should login successfully

  Scenario: Nationality testing with JDBC
    And Click on the element in LeftNav
      | setup         |
      | parameters    |
      | nationalities |

    Then Send the query the database "select name from nationality limit 10" and control match