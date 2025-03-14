# Scenario:

# Cities menusunun kayıt, silme özelliğini test ediniz

Feature: Cities Functionality Datatable

  Background:
    Given Navigate to campus
    When Enter valid username and password and click login button
    Then User should login successfully

  @SmokeTest
  Scenario: Create and Delete Cities

    And Click on the element in LeftNav
      | setup      |
      | parameters |
      | cities     |

    And Click on the element in Dialog
      | addButton     |
    #  | countrySelect |
    #  | countryOption |

    And User sending the keys in Dialog
      | nameInput | KeremCity |

    And Click on the element in Dialog
      | saveButton |

    Then Success message should be displayed

    And User delete the element from Dialog
      | KeremCity |

    Then Success message should be displayed