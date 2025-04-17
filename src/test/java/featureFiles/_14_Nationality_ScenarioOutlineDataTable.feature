# Scenario:

# Registration and deletion feature of the Nationality menu
# (with DataTable) Run with 5 different value sets.

Feature: Nationality functionality (With Scenario Outline and Data Table)

  Background:
    Given Navigate to campus
    When Enter valid username and password and click login button
    Then User should login successfully

  @Regression
  Scenario Outline: Create Nationality and Delete
    And Click on the element in LeftNav
      | setup         |
      | parameters    |
      | nationalities |

    And Click on the element in Dialog
      | addButton |

    And User sending the keys in Dialog
      | nameInput | <name> |

    And Click on the element in Dialog
      | saveButton |

    Then Success message should be displayed

    And User delete the element from Dialog
      | <name> |

    Examples:
      | name         |
      | TR_Turkish   |
      | KU_Kurdish   |
      | IT_Italian   |
      | ES_Spanish   |
      | NO_Norwegian |
