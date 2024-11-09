package StepDefinitions;
import static org.junit.Assert.assertThat;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Utils.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchSteps {
	
	WebDriver driver=null;
	
	@Given("user is on the browser")
	public void user_is_on_the_browser() {
		DriverFactory driver=new DriverFactory();
		driver.getDriver();
	}

	@And("user enters a text in the search box")
	public void user_enters_a_text_in_the_search_box() {
		driver.navigate().to("https://www.google.com/");
	}

	@When("user enters a text in search box")
	public void user_enters_a_text_in_search_box() throws InterruptedException {
	    driver.findElement(By.xpath("//textarea[@title='Search']")).sendKeys("Automation");
	    Thread.sleep(2000);
	}

	@And("hits enter")
	public void hits_enter() {
	    driver.findElement(By.xpath("//textarea[@title='Search']")).sendKeys(Keys.ENTER);	
	}

	@Then("user is navigated to search results")
	public void user_is_navigated_to_search_results() {
		driver.getPageSource().contains("Automation is the use of technology");
		driver.close();
		driver.quit();
	  
	}


}
