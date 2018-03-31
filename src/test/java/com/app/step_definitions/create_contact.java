package com.app.step_definitions;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import com.app.pages.SuitCRMcontactInformationPage;
import com.app.pages.SuiteCRMdashBoardPage;
import com.app.utilities.BrowserUtils;
import com.app.utilities.Driver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class create_contact {
	SuiteCRMdashBoardPage dashpage = new SuiteCRMdashBoardPage();
	SuitCRMcontactInformationPage contectinformation= new SuitCRMcontactInformationPage();
	
	@Given("^I open the create contact page$")
	public void i_open_the_create_contact_page() {
	  BrowserUtils.hover(dashpage.createLink);
	  dashpage.createContact.click();
	}

	@Given("^I enter the first name\"([^\"]*)\" and the last name\"([^\"]*)\"$")
	public void i_enter_the_first_name_and_the_last_name(String firstName, String lastName) {
		contectinformation.firstname.sendKeys(firstName);
		contectinformation.lastname.sendKeys(lastName);
	}

	@Given("^I enter the phone number\"([^\"]*)\"$")
	public void i_enter_the_phone_number(String phoneNumber) {
	  contectinformation.officephoneNumber.sendKeys(phoneNumber);
	}

	@Given("^I enter the department \"([^\"]*)\"$")
	public void i_enter_the_department(String department) {
		 contectinformation.department.sendKeys(department);
	}

	@When("^I click on the save button$")
	public void i_click_on_the_save_button() {
		 contectinformation.save();
	}

	@Then("^I should see contact information for \"([^\"]*)\"$")
	public void i_should_see_contact_information_for(String fullName) {
		assertEquals(contectinformation.firstname.getText(), fullName.split(" ")[0]);
		assertEquals(contectinformation.lastname.getText(), fullName.split(" ")[1]);
	}


}
