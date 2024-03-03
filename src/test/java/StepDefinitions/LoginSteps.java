package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
		System.out.println("step 1");
	}

	@When("user enters username and password")
	public void user_enters_username_and_password() {
		System.out.println("step 2");
	}

	@When("clicks on login button")
	public void clicks_on_login_button() {
		System.out.println("step 3");
	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {
		System.out.println("step 4");
	}

	@When("user enters user1 and pass1")
	public void user_enters_user1_and_pass1() {
		System.out.println("step 5");
	}

	@When("user enters user2 and pass2")
	public void user_enters_user2_and_pass2() {
		System.out.println("step 6");
	}



}
