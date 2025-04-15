Feature: DataTable Example

  Scenario: Users List
    When Write username "Kerem"
    And  Write username and password "Kerem" and "1234"

    And Write username as DataTable
      | Said   |
      | Mehmet |
      | Yakut  |
      | Fatma  |

    And Write username and password as DataTable
      | Said   | 12345 |
      | Mehmet | 23323 |
      | Yakut  | 45454 |
      | Fatma  | 44545 |

#  dataProvider(for testNG) , Senaryo Outline(for cucumber)
#  Task: Executing each given value in the entire scenario
#
#  DataTable allows us to give many parameters to a step.