Feature: Create contacts using beans

  Scenario: Create contact
    Given I logged into suiteCRM
    When I save a new contact:
      | firstName | lastName | department | officePhone  | cellphone    | email                |
      | Kaysar    | Dammey   | Laji       | 202-333-4233 | 333-423-5235 | kaysarlaji@gmail.com |
    Then I should see contact information for "Kaysar Dammey"

  @Using_beans
  Scenario Outline: Create contact
    Given I logged into suiteCRM
    When I save a new contact:
      | firstName   | lastName | department   | officePhone | cellphone | email   |
      | <firstname> | <lname>  | <department> | <ofiice>    | <cell>    | <email> |
    Then I should see contact information for "<firstname> <lname>"

    Examples: 
      | firstname | lname | department | ofiice  | cell     | email         |
      | Kaysar    | AssJH | IYT        | 3213123 | 12312312 | par@gmail.com |
    #  | dilmuratkiz | dilxat   | FBI       | 3213123 | 12312312 | DIL@gmail.com |
