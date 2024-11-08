package Utils;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {
	public static WebDriver driver=null;

	public WebDriver getDriver() {
		// TODO Auto-generated method stub
		try
		{
			//read config
			ReadConfigFile file =new ReadConfigFile();
			String browserName=file.getBrowser();		
			switch (browserName) {
			case "firelfox":
				if(driver==null)
				{
					System.setProperty("webdriver.gecko.driver", Constant.GECKO_DRIVER_DIRECTORY);
					DesiredCapabilities capabilities=new DesiredCapabilities();
					driver=new FirefoxDriver();
				}
				break;
			case "Chrome":
				if(driver==null)
				{
					System.setProperty("webdriver.chrome.driver", Constant.CHROME_DRIVER_DIRECTORY);
					DesiredCapabilities capabilities=new DesiredCapabilities();
					driver=new ChromeDriver();
				}
				break;
			default:
				break;
			}
		}
		catch (Exception e) {
			System.out.println("unable to load browser"+e.getMessage());
		}
		finally {
			driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);	
		}
		return driver;
	}

}
