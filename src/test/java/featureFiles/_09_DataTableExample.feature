Feature: DataTable Example

  Scenario: Users List
    When Write username "Kerem"
    And  Write username and password "Kerem" and "Ke12@45"

    And Write username as DataTable
      | Daniel  |
      | Aisha   |
      | Mateo   |
      | Sophie  |

    And Write username and password as DataTable
      | Daniel  | Dn45#2023 |
      | Aisha   | Ai78@xxy  |
      | Mateo   | Mt99$abc  |
      | Sophie  | Sp12!def  |

#  dataProvider(for testNG) , Senaryo Outline(for cucumber)
#  Task: Executing each given value in the entire scenario
#
#  DataTable allows us to give many parameters to a step.