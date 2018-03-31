package com.app.step_definitions;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.app.pages.SuiteCRMdashBoardPage;
import com.app.utilities.BrowserUtils;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class menuOptions {
	SuiteCRMdashBoardPage dashpage = new SuiteCRMdashBoardPage();
	
	@When("^I hover over the (Collaboration|Sales|Marketing|Support|All) menu$")
	public void i_hover_over_the_Collaboration_menu(String menu) {
		switch (menu) {
			case "Sales":
					BrowserUtils.hover(dashpage.sales);
					BrowserUtils.waitFor(2);
			break;
			case "Marketing":
				BrowserUtils.hover(dashpage.marketing);
				BrowserUtils.waitFor(2);
			break;
			case "Support":
				BrowserUtils.hover(dashpage.support);
				BrowserUtils.waitFor(2);
			break;
			case "Collaboration":
				BrowserUtils.hover(dashpage.collaboration);
				BrowserUtils.waitFor(2);
			break;
			case "All":
				BrowserUtils.hover(dashpage.all);
				BrowserUtils.waitFor(2);
			break;
			case "Activities":
				BrowserUtils.hover(dashpage.activities);
				BrowserUtils.waitFor(2);
			break;
			
			default :
				break;
		}
	}

	@Then("^following menu options should be visible for (Collaboration|Sales|Marketing|Support|All):$")
	public void following_menu_options_should_be_visible_for_Collaboration(String menu , List<String> options) {
		// capture list of webelements
		List<WebElement> topMunulist = dashpage.topMenuOption(menu);
		// get theri text in a list 
		List<String> topMenuListString = BrowserUtils.getElementsTextBy(topMunulist);
		// campare the list with options
		assertEquals(topMenuListString.size(), options.size(),
				"Number of expected menu options did not match");
		for(int i = 0; i< options.size();i++) {
			assertEquals(topMenuListString.get(i), options.get(i));
		}
		
	}

}
