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
	// we can also add the tags in the cucumber hooks
//	@Before("@smoke")
//	public void setup()
//	{
//		driver=getDriver();
//	}
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
