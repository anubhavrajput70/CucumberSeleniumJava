package StepDefinitions;

import java.io.IOException;

import org.openqa.selenium.By;

import Utils.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;

public class ProductsSteps extends DriverFactory{
	
	

	@When("User clicks on the {string}")
	public void user_clicks_on_the(String string) throws InterruptedException {
		getDriver().findElement(By.cssSelector(string)).click();
	}

	@Then("User should be presented with a promo alert")
	public void user_should_be_presented_with_a_promo_alert() throws InterruptedException, IOException {
		 productspage.clickOnProceedButton_popup();
		 productspage.printSpecialOfferVoucherCode();
	}


}
