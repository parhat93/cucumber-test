Feature: SuperCRM menu options

 @TypingDead
  Scenario: Verify collaboration menu options
    Given I logged into suiteCRM
    When I hover over the Collaboration menu
    Then following menu options should be visible for Collaboration:
      | Home      |
      | Emails    |
      | Documents |
      | Projects  |


  Scenario: Verify collaboration menu options
    Given I logged into suiteCRM
    When I hover over the Support menu
    When I hover over the Sales menu
    When I hover over the All menu
   
    Then following menu options should be visible for Support:
      | Home     |
      | Accounts |
      | Contacts |
      | Cases    |
