# Scenario:

# Save and delete feature of the CitizenShip menu
# (with DataTable) Run with 5 different value sets.

Feature: CitizenShip functionality

  Background:
    Given Navigate to campus
    When Enter valid username and password and click login button
    Then User should login successfully

  Scenario Outline: Create CitizenShip and Delete
    And Click on the element in LeftNav
      | setup       |
      | parameters  |
      | citizenship |

    And Click on the element in Dialog
      | addButton |

    And User sending the keys in Dialog
      | nameInput | <name>      |
      | shortName | <shortname> |

    And Click on the element in Dialog
      | saveButton |

    Then Success message should be displayed

    And User delete the element from Dialog
      | <name> |

    Then Success message should be displayed
    Examples:
      | name       | shortname |
      | Turkish    | TR01      |
      | Canadian   | CA01      |
      | Australian | AU01      |
      | Norwegian  | NO01      |
      | German     | DE01      |
