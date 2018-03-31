package com.app.step_definitions;

import java.util.Map;

import com.app.pages.SuitCRMcontactInformationPage;
import com.app.pages.SuiteCRMTaskSummuryPage;
import com.app.pages.SuiteCRMdashBoardPage;
import com.app.pages.SuitsSRMCreateTaskPage;
import com.app.utilities.BrowserUtils;

import cucumber.api.DataTable;
import cucumber.api.java.en.When;

public class Create_contact_maps_step_definition {
	SuiteCRMdashBoardPage dashboardPage = new SuiteCRMdashBoardPage();
	SuitsSRMCreateTaskPage createTaskpage = new SuitsSRMCreateTaskPage();
	SuiteCRMTaskSummuryPage summuryPage = new SuiteCRMTaskSummuryPage();
	SuitCRMcontactInformationPage createContact = new SuitCRMcontactInformationPage();
	
	@When("^I create a new contact:$")
	public void i_create_a_new_contact(Map<String, String> contact) {
		//open the create dialog
		BrowserUtils.hover(dashboardPage.createLink);
		dashboardPage.createContact.click();
		// enter information
		if(contact.get("first_name")!=null) {
			createContact.firstname.sendKeys(contact.get("first_name"));
		}
		if(contact.get("last_name")!=null) {
			createContact.lastname.sendKeys(contact.get("last_name"));
		}
		if(contact.get("office_number")!=null) {
			createContact.officephoneNumber.sendKeys(contact.get("office_number"));
		}
		if(contact.get("cell_phone")!=null) {
			createContact.cellphoneNumber.sendKeys(contact.get("cell_phone"));
		}
		// save
		createContact.save();
	}
}
