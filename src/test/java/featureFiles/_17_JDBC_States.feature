# Scenario:
# Check whether the first 10 data in the States menu are the same as the data in the DB.

# Senaryo:
# States menusunde gelen ilk 10 verinin DB deki data ile aynı olup olmadığını kontrol ediniz.

Feature: Testing JDBC States

  Background:
    Given Navigate to campus
    When Enter valid username and password and click login button
    Then User should login successfully

  Scenario: States testing with JDBC
    And Click on the element in LeftNav
      | setup      |
      | parameters |
      | countries  |

    Then Send the query the database "select name from states limit 10" and control match