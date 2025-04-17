Feature: Fees Multiple Values Functionality

  Background:
    Given Navigate to campus
    When Enter valid username and password and click login button
    Then User should login successfully

  @Regression
  Scenario Outline: Fee Functionality
    And Click on the element in LeftNav
      | setup      |
      | parameters |
      | fees       |

    And Click on the element in Dialog
      | addButton |

    And User sending the keys in Dialog
      | nameInput       | <name>     |
      | codeInput       | <code>     |
      | integrationCode | <intCode>  |
      | priorityCode    | <priority> |

    And Click on the element in Dialog
      | toggleBar  |
      | saveButton |

    Then Success message should be displayed

    And User delete the element from Dialog
      | <name> |

    Then Success message should be displayed

    Examples:
      | name              | code     | intCode  | priority |
      | Enrollment Fee    | ENR-001  | PayPal   | PR-1001  |
      | Application Fee   | APP-002  | Cash     | PR-1002  |
      | Library Fee       | LIB-003  | Cheque   | PR-1003  |
      | Technology Fee    | TEC-004  | ApplePay | PR-1004  |
      | Certification Fee | CERT-005 | Crypto   | PR-1005  |