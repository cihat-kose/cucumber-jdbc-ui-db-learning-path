Feature: DataTable Functionality

  Background:
    Given Navigate to campus
    When Enter valid username and password and click login button
    Then User should login successfully

  @Regression
  Scenario: Create Country
    And Click on the element in LeftNav
      | setup      |
      | parameters |
      | countries  |

    And Click on the element in Dialog
      | addButton |

    And User sending the keys in Dialog
      | nameInput | Norway - NO |
      | codeInput | NO - 47     |

    And Click on the element in Dialog
      | saveButton |

    Then Success message should be displayed

    And User delete the element from Dialog
      | Norway - NO |

    Then Success message should be displayed

  @Regression
  Scenario:  Create Nationality
    And Click on the element in LeftNav
      | setup         |
      | parameters    |
      | nationalities |

    And Click on the element in Dialog
      | addButton |

    And User sending the keys in Dialog
      | nameInput | Norwegian - NO |

    And Click on the element in Dialog
      | saveButton |

    Then Success message should be displayed

    And User delete the element from Dialog
      | Norwegian - NO |

    Then Success message should be displayed

  @Regression
  Scenario: Fee Functionality
    And Click on the element in LeftNav
      | setup      |
      | parameters |
      | fees       |

    And Click on the element in Dialog
      | addButton |

    And User sending the keys in Dialog
      | nameInput       | Fee-FE47      |
      | codeInput       | FE47          |
      | integrationCode | INT12347      |
      | priorityCode    | PRIORITY12347 |

    And Click on the element in Dialog
      | toggleBar  |
      | saveButton |

    Then Success message should be displayed

    And User delete the element from Dialog
      | Fee-FE47 |

    Then Success message should be displayed