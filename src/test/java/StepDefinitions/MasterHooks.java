package StepDefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Utils.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class MasterHooks extends DriverFactory{
	
	@Before
	public void setup()
	{
		driver=getDriver();
	}
	// we can also add the tags in the cucumber hooks
//	@Before("@smoke")
//	public void setup()
//	{
//		driver=getDriver();
//	}
	@After
	public void tearDownScreenshotOnFailure(Scenario scenario)
	{
		try {
			if(driver!=null &&scenario.isFailed())
			{
				scenario.attach(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES),"image/png", null);
				driver.manage().deleteAllCookies();
				driver.quit();
				driver=null;
			}
			if(driver!=null)
			{
				driver.manage().deleteAllCookies();
				driver.quit();
				driver=null;
			}
		} catch (Exception e) {
			System.out.println("Method failed: tearDownScreenShotOnFailure, Exception: "+e.getMessage());;
		}
	}

}
