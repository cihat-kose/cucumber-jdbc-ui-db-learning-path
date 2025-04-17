# Scenario:

# Test the Item Categories Study in the Inventory Section.
# Make a new addition and then delete the added item.

Feature: Inventory functionality

  Background:
    Given Navigate to campus
    When Enter valid username and password and click login button
    Then User should login successfully

  @Regression
  Scenario Outline: Create Inventory and Delete
    And Click on the element in LeftNav
      | inventory      |
      | setupInventory |
      | itemCategories |

    And Click on the element in Dialog
      | addButton |

    And User sending the keys in Dialog
      | nameInput | <name> |

    And Click on the element in Dialog
      | userType |
      | <type>   |

    And Click on the element in Dialog
      | saveButton |

    Then Success message should be displayed

    And User delete the element from Dialog
      | <name> |

    Then Success message should be displayed
    Examples:
      | name                    | type          |
      | Curriculum Textbooks    | student       |
      | Science Lab Equipment   | administrator |
      | E-learning Materials    | student       |
      | Classroom Essentials    | administrator |
      | Academic Software Tools | administrator |