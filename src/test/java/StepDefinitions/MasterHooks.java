package StepDefinitions;

import Utils.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class MasterHooks extends DriverFactory{
	
	@Before
	public void setup()
	{
		driver=getDriver();
	}
	@After
	public void tearDown()
	{
		if(driver!=null)
		{
			driver.manage().deleteAllCookies();
			driver.quit();
		}
	}

}
