package com.app.step_definitions;

import org.openqa.selenium.WebDriver;

import com.app.pages.SuiteCRMdashBoardPage;
import com.app.pages.SuiteCRMloginPage;
import com.app.utilities.Driver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DashBoardActions {
	
	SuiteCRMdashBoardPage dashpage = new SuiteCRMdashBoardPage();
	
	
	@When("^I post \"([^\"]*)\"$")
	public void i_post(String note) {
		dashpage.postNote(note);
		
	}

	@Then("^Post should be displayed$")
	public void post_should_be_displayed() {
	
	}
	
	@Then("^I logout from application$")
	public void i_logout_from_application() {
	   dashpage.logout();
	}
	
	
}
