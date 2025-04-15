# Scenario:

#Go to the #CitizenShip page.
#Create process with the parameter method. (Scenario 1)
#After #Daha, verify that it is not possible to create again with the same information. (negative test) (Scenario 2)
#Verify the deletion of the information entered in #Ayrı scenario (Scenario 3)

Feature: Citizenship Functionality

  Background:
    Given Navigate to campus
    When Enter valid username and password and click login button
    Then User should login successfully
    And Navigate to citizenship

  @Regression
  Scenario Outline: Create a Citizenship
    When Create a citizenship that name as "<name>" short name as "<shortname>"
    Then Success message should be displayed

    When Create a citizenship that name as "<name>" short name as "<shortname>"
    Then Already exist message should be displayed

    When User delete the citizenship that name as "<name>"
    Then Success message should be displayed

    Examples:
      | name       | shortname |
      | Turkish    | sh561     |
      | Canadian   | sh562     |
      | Australian | sh563     |
      | Norwegian  | sh564     |
      | German     | sh565     |

   #  dataProvider (for TestNG), Scenario Outline (cucumber)
   #  For each value given the # task, the entire scenario runs