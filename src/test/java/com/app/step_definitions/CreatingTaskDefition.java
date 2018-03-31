package com.app.step_definitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.app.pages.SuiteCRMSearchResultsPage;
import com.app.pages.SuiteCRMTaskSummuryPage;
import com.app.pages.SuiteCRMdashBoardPage;
import com.app.pages.SuiteCRMloginPage;
import com.app.pages.SuitsSRMCreateTaskPage;
import com.app.utilities.Driver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreatingTaskDefition {
	
	private WebDriver driver = Driver.getDriver();
	SuiteCRMdashBoardPage dashboardPage = new SuiteCRMdashBoardPage();
	SuitsSRMCreateTaskPage createTaskpage = new SuitsSRMCreateTaskPage();
	SuiteCRMTaskSummuryPage summuryPage = new SuiteCRMTaskSummuryPage();
	
	Map<String,String> createTaskMap = new HashMap<>();
	Map<String,String> overviewTaskMap = new HashMap<>();
	
	@When("^I click on create task$")
	public void i_click_on_create_task() {
		dashboardPage.clickCreateTask();
	}

	@When("^Set subject as \"([^\"]*)\"$")
	public void set_subject_as(String TaskSubject) {
		createTaskpage.subject.sendKeys(TaskSubject);
		createTaskMap.put("Subject", TaskSubject);
	}
    
	@When("^Set status as \"([^\"]*)\"$")
	public void set_status_as(String Status) {
		Select statusSelect = new Select(createTaskpage.status);
		statusSelect.selectByVisibleText(Status);
		createTaskMap.put("status", Status);
		
	}

	@When("^Start date is todays date$")
	public void start_date_is_todays_date() {
	   LocalDate today = LocalDate.now();
	   DateTimeFormatter fomatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	   String todaysDate = today.format(fomatter).toString();
	   // System.out.println(todaysDate);
	  // System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")).toString());
	   createTaskpage.Startdata.sendKeys(todaysDate+Keys.TAB);
	   createTaskMap.put("Start Data", todaysDate);
	   
	}

	@When("^Due date is (\\d+) days after todays data$")
	public void due_date_is_days_after_todays_data(int daysAhead) {
		   String dudate =LocalDate.now().plusDays(daysAhead).format(DateTimeFormatter.ofPattern("MM/dd/yyyy")).toString();
		   createTaskpage.date_due_date.sendKeys(dudate+Keys.TAB);
		   createTaskMap.put("duDate", dudate);
	}

	@When("^Set \"([^\"]*)\" priority$")
	public void set_priority(String priority) {
		Select statusSelect = new Select(createTaskpage.priority);
		statusSelect.selectByVisibleText(priority);
		createTaskMap.put("Priority", priority);
	}

	@When("^Set description as \"([^\"]*)\"$")
	public void set_description_as(String description) {
		createTaskpage.description.sendKeys(description);
		createTaskMap.put("Descriptions", description);
	}

	@When("^Save the task$")
	public void save_the_task() {
		createTaskpage.Save.click();
	}

	@Then("^Task details page should be displayed$")
	public void task_details_page_should_be_displayed() {
		assertTrue(summuryPage.taskOverview.isDisplayed());
		
		overviewTaskMap.put("Subject",summuryPage.subject.getText());
		overviewTaskMap.put("status",summuryPage.status.getText());
		overviewTaskMap.put("Start Data",summuryPage.date_start.getText().replace(" 12:00am", ""));
		overviewTaskMap.put("duDate",summuryPage.date_due.getText().replace(" 12:00am", ""));
		overviewTaskMap.put("Priority",summuryPage.priority.getAttribute("value"));
		overviewTaskMap.put("Descriptions",summuryPage.description.getText());
		System.out.println(overviewTaskMap);
		System.out.println(createTaskMap);
	}

	@Then("^Date should match with create task date$")
	public void date_should_match_with_create_task_date() {
	    assertEquals(overviewTaskMap, createTaskMap);
	}

}
