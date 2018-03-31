Feature: Creating contacts_wih_maps

  Scenario: Create contact using a map
    Given I logged into suiteCRM
    When I create a new contact:
      | first_name    | John         |
      | last_name     | Smith        |
      | office_number | 202-222-2222 |
      | cell_phone    | 222-333-3123 |
    Then I should see contact information for "John Smith"

  @create_contact
  Scenario Outline: Create contact using a map
    Given I logged into suiteCRM
    When I create a new contact:
      | first_name    | <first_name>    |
      | last_name     | <Lname>         |
      | cell_phone    | <cell_Phone>    |
      | office_number | <office_number> |
    Then I should see contact information for "<first_name> <Lname>"

    Examples: 
      | first_name  | Lname      | cell_Phone | office_number |
      | Parhat      | Osman      |  312312321 |       2321312 |
      | Kaysar      | AssJH      |  331233423 |       2421312 |
      | Battelefiel | HIghSchool |  324212321 |       1312423 |
      | Michle      | Water      |  312312321 |       2321312 |
      | Pepsi       | cola       |  312312321 |       2321312 |
      | Amazing     | Spiderman  |  312312321 |       2321312 |
      | hurry       | potter     |  312312321 |       2321312 |
      | dilmurat    | dilshat    |  312312321 |       2321312 |
