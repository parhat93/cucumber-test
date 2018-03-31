package com.app.step_definitions;

import java.util.List;

import com.app.beans.ContactBean;
import com.app.pages.SuitCRMcontactInformationPage;
import com.app.pages.SuiteCRMdashBoardPage;
import com.app.utilities.BrowserUtils;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.When;

public class Create_contact_using_beans {
	
	SuiteCRMdashBoardPage dashboardPage = new SuiteCRMdashBoardPage();
	SuitCRMcontactInformationPage createContact = new SuitCRMcontactInformationPage();
	
//	@When("^I save a new contact:$")
//	public void i_save_a_new_contact(List <ContactBean> contact) {
//		System.out.println(contact.size());
//		ContactBean contactbean  = contact.get(0);
//		System.out.println(contactbean.getFirstName());
//		System.out.println(contactbean.getLastName());
//		System.out.println(contactbean.getCellphone());
//		System.out.println(contactbean.getOfficePhone());
//		System.out.println(contactbean.getDepartment());
//		System.out.println(contactbean.getEmail());
//		
//	}
	
	@When("^I save a new contact:$")
	public void i_save_a_new_contact(List <ContactBean> contact) {
		System.out.println(contact.size());
		ContactBean contactbean  = contact.get(0);
		// open the create contact page
		BrowserUtils.hover(dashboardPage.createLink);
		dashboardPage.createContact.click();
		//enter date
		createContact.firstname.sendKeys(contactbean.getFirstName());
		createContact.lastname.sendKeys(contactbean.getLastName());
		createContact.officephoneNumber.sendKeys(contactbean.getOfficePhone());
		createContact.cellphoneNumber.sendKeys(contactbean.getCellphone());
		createContact.department.sendKeys(contactbean.getDepartment());
		createContact.email.sendKeys(contactbean.getEmail());
		createContact.save();
	}
	
	
	
	
	
	
	
}
