
Feature: User Interface for SuiteCRM

@Regression 
  Scenario: CRM Name and Modules
    Given I logged into suiteCRM
    Then CRM name should be SuitsCRM
    And Modules should be displayed
		# Then I logout from application
   