package StepDefinitions;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchSteps {
	
	WebDriver driver=null;
	
	@Given("user is on the browser")
	public void user_is_on_the_browser() {
		System.setProperty("webdriver.chrome.driver","C:/Users/ANUBHAV/Desktop/Revision/CucumberSeleniumJava/src/test/resources/driver/chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@And("user enters a text in the search box")
	public void user_enters_a_text_in_the_search_box() {
		driver.navigate().to("https://www.google.com/");
	}

	@When("user enters a text in search box")
	public void user_enters_a_text_in_search_box() {
	    driver.findElement(By.xpath("//textarea[@title='Search']")).sendKeys("Automation");
	}

	@And("hits enter")
	public void hits_enter() {
	
	}

	@Then("user is navigated to search results")
	public void user_is_navigated_to_search_results() {
	    driver.close();
	}


}
