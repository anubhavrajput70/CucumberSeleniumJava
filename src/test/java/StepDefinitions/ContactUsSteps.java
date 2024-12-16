package StepDefinitions;

import java.io.IOException;

import Utils.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactUsSteps extends DriverFactory {
	
	@Given("User Access webdriveruniversity contactus form")
	public void user_is_on_the_webdriveruniversity() throws IOException {
		contactuspage.getContactUsPage();
	}

	@When("User click on the contact us button")
	public void user_click_on_the_contact_us_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User enter firstname")
	public void user_enter_firstname() throws IOException {
	  contactuspage.enterFirstName();
	}

	@When("User enter lastname")
	public void user_enter_lastname(DataTable dataTable) throws IOException {
		contactuspage.enterLastName(dataTable, 0, 1);
	   
	}

	@When("User enter an email address")
	public void user_enter_an_email_address() throws IOException {
	    contactuspage.enterEmailAddress("webdriveruniversity@outlook.com");
	}

	@When("User enter comments")
	public void user_enter_comments(DataTable dataTable) throws IOException {
	   contactuspage.enterComments(dataTable, 0, 0);
	}

	@When("User clicks on the submit button")
	public void user_clicks_on_the_submit_button() throws IOException {
	    contactuspage.clickOnSubmitButton();
	}

	@Then("the information should be successfully be submitted via contact us forms")
	public void the_information_should_be_successfully_be_submitted_via_contact_us_forms() throws IOException {
	   contactuspage.confirmContactusFormSubmissionSuccessful();
	}




}
