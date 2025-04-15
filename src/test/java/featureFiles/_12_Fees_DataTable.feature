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
      | nameInput       | KeremCity |
      | codeInput       | 23941     |
      | integrationCode | Crypto    |
      | priorityCode    | 42435     |

    And User sending the Enter keys in Dialog

    And Click on the element in Dialog
      | saveButton |

    Then Success message should be displayed

    And User delete the element from Dialog
      | KeremCity |

    Then Success message should be displayed