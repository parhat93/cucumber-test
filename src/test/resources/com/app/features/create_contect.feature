Feature: Creating contacts

  Scenario: Create contact using Create page
    Given I logged into suiteCRM
    And I open the create contact page
    And I enter the first name"Parhat" and the last name"Osman"
    And I enter the phone number"202-202-2222"
    And I enter the department "CIA"
    When I click on the save button
    Then I should see contact information for "Parhat osman"

  Scenario: Create contact using Create page
    Given I logged into suiteCRM
    And I open the create contact page
    And I enter the first name"Sara" and the last name"Osman"
    And I enter the phone number"202-202-2222"
    And I enter the department "IT"
    When I click on the save button
    Then I should see contact information for "Sara Osman"

  Scenario Outline: Create multiple contacts
    Given I logged into suiteCRM
    And I open the create contact page
    And I enter the first name"<firstname>" and the last name"<lastname>"
    And I enter the phone number"<phonenumber>"
    And I enter the department "<department>"
    When I click on the save button
    Then I should see contact information for "<firstname> <lastname>"

    Examples: 
      | firstname | lastname | phonenumber | department |
      | Rabiya    | Kadir    |   234325335 | UY         |
      | Parhat    | Osman    |    34234234 | FBI        |
      | Kaysar    | ahsoph   |  2343242323 | CIA        |
