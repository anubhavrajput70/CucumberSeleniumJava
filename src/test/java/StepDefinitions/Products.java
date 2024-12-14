package StepDefinitions;

import org.openqa.selenium.By;

import Utils.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Products extends DriverFactory{

	@When("User clicks on the {string}")
	public void user_clicks_on_the(String string) throws InterruptedException {
	    Thread.sleep(2000);
	    driver.findElement(By.cssSelector(string)).click();;
	    Thread.sleep(2000);
	}

	@Then("User should be presented with a promo alert")
	public void user_should_be_presented_with_a_promo_alert() throws InterruptedException {
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//button[text()='Proceed']")).click();
	}


}
