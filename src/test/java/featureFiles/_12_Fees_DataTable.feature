# Scenario:

# Cities menusunun kayıt, silme özelliğini test ediniz

Feature: Cities Functionality Datatable

  Background:
    Given Navigate to campus
    When Enter valid username and password and click login button
    Then User should login successfully

  @SmokeTest
  Scenario: Fees create and delete functionality

    And Click on the element in LeftNav
      | setup      |
      | parameters |
      | fees       |

    And Click on the element in Dialog
      | addButton |

    And User sending the keys in Dialog
      | nameInput       | Enrollment Fee |
      | codeInput       | ENR-FEE-1001   |
      | integrationCode | ENR-INT-1001   |
      | priorityCode    | 1001           |

    And User sending the Enter keys in Dialog

    And Click on the element in Dialog
      | saveButton |

    Then Success message should be displayed

    And User delete the element from Dialog
      | Enrollment Fee |

    Then Success message should be displayed