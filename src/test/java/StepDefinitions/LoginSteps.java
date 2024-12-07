package StepDefinitions;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends DriverFactory{

	
	@Given("User navigates to {string}")
	public void user_navigates_to(String string) {
	  driver.get(string);
	}

	@When("User clicks on the login portal button")
	public void user_clicks_on_the_login_portal_button() {
	   driver.findElement(By.xpath("//h1[contains(text(),'LOGIN PORTAL')]")).click();
	}

	@When("User enters the {string} username")
	public void user_enters_the_username(String string) {
		String parentWindow=driver.getWindowHandle();
		Set<String> allhandles=driver.getWindowHandles();
		for(String handle:allhandles)
		{
			if(!handle.equals(parentWindow))
			{
				driver.switchTo().window(handle);
				break;
			}
		}
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("text")));
		driver.findElement(By.id("text")).sendKeys(string);
	}

	@When("User enters the {string} password")
	public void user_enters_the_password(String string) {
		driver.findElement(By.id("password")).sendKeys(string);
	}

	@When("User clicks on the login button")
	public void user_clicks_on_the_login_button() {
	   driver.findElement(By.id("login-button")).click();
	}

	@Then("User should be presented with the following prompt alert {string}")
	public void user_should_be_presented_with_the_following_prompt_alert(String msg) {
	    Alert alert=driver.switchTo().alert();
	    assertEquals(alert.getText().toString().toLowerCase().replaceAll("\\s", ""),msg.toLowerCase().replaceAll("\\s", ""));
	    alert.accept();
	}
}
