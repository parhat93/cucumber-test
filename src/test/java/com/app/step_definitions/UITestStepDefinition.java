package com.app.step_definitions;



import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.app.pages.SuiteCRMSearchResultsPage;
import com.app.pages.SuiteCRMdashBoardPage;
import com.app.pages.SuiteCRMloginPage;

import com.app.utilities.ConfigurationReader;
import com.app.utilities.Driver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
// ^ --> beginning of pattern/step
// $ --> end of pattern/step
public class UITestStepDefinition {
	
	private WebDriver driver = Driver.getDriver();
	SuiteCRMloginPage loginpage = new SuiteCRMloginPage();
	SuiteCRMdashBoardPage dashboardPage = new SuiteCRMdashBoardPage();
	SuiteCRMSearchResultsPage searchResultsPage = new SuiteCRMSearchResultsPage();
	
	@Given("^I logged into suiteCRM$")
	public void i_logged_into_suiteCRM() {
		System.out.println("I logged into suiteCRM");
		driver.get(ConfigurationReader.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		loginpage.LoginIn(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
	}
	

	@Then("^CRM name should be SuitsCRM$")
	public void crm_name_should_be_SuitsCRM() {
		System.out.println("CRM name should be SuitsCRM");
		assertTrue(driver.getTitle().endsWith("SuiteCRM"));
	}

	@Then("^Modules should be displayed$")
	public void modules_should_be_displayed() {
		System.out.println("Modules should be displayed");
		assertTrue(dashboardPage.sales.isDisplayed());
		assertTrue(dashboardPage.marketing.isDisplayed());
		assertTrue(dashboardPage.support.isDisplayed());
		assertTrue(dashboardPage.activities.isDisplayed());
		assertTrue(dashboardPage.collaboration.isDisplayed());
		assertTrue(dashboardPage.all.isDisplayed());
	}
	
	
	@When("^I search for \"([^\"]*)\"$")
	public void i_search_for(String searchTerm) {
		try {
			assertTrue(dashboardPage.searchInput.isDisplayed());
		} catch (AssertionError e) {
			dashboardPage.searchButton.click();
		}
		dashboardPage.searchInput.sendKeys(searchTerm + Keys.ENTER);
	}

	@Then("^link for user \"([^\"]*)\" should be displayed$")
	public void link_for_user_should_be_displayed(String searchTerm) {
		assertTrue(searchResultsPage.resultLink(searchTerm).isDisplayed(), searchTerm + " was not displayed");
	}

	@Then("^there should be (\\d+) result for \"([^\"]*)\"$")
	public void there_should_be_result_for(int count, String searchTerm) {
		int actual = searchResultsPage.resultLinks(searchTerm).size();
		assertEquals(actual, count, "number of results did not match");
	}
	
}
