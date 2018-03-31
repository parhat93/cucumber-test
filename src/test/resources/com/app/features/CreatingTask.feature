Feature: Creating tasks

  @Dev
  Scenario: Create a task
    Given I logged into suiteCRM
    When I click on create task
    And Set subject as "Automate Scenario"
    And Set status as "In Progress"
    And Start date is todays date
    And Due date is 5 days after todays data
    And Set "Medium" priority
    And Set description as "Automate test cases using Cucumber and Selenium"
    And Save the task
    Then Task details page should be displayed
    And Date should match with create task date
    Then I logout from application
