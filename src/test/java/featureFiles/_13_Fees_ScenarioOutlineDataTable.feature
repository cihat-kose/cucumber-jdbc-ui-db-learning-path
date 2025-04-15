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
      | name     | code   | intCode  | priority |
      | KrmFee10 | 902224 | PayPal   | 994304   |
      | KrmFee20 | 802225 | Cash     | 912305   |
      | KrmFee30 | 702226 | Cheque   | 901230   |
      | KrmFee40 | 602227 | ApplePay | 912307   |
      | KrmFee50 | 502229 | Crypto   | 912308   |