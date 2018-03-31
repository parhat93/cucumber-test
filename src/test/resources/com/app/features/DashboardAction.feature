	
	
  Feature: Note on Dashboard
	
	Background:
	  Given I logged into suiteCRM
	
	@backg
  Scenario: Post a note on Dashboard
  When I post "We have 25 minute left to go home"
  Then Post should be displayed
  Then I logout from application

  Scenario: Post another note on Dashboard
  When I post "We have 25 minute left to go home"
  Then Post should be displayed
  Then I logout from application
