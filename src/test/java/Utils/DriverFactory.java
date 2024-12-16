package Utils;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import pageObjects.BasePage;
import pageObjects.Contactus_Page;
import pageObjects.Products_Page;

public class DriverFactory {
	public static WebDriver driver=null;
	public static Contactus_Page contactuspage;
	public static Products_Page productspage;
	public static BasePage basePage;
	
	public WebDriver getDriver() 
	{
		// TODO Auto-generated method stub
		try
		{
			//read config
//			ReadConfigFile file =new ReadConfigFile();
//			String browserName=file.getBrowser();	
			//calling properties file directly
			
			Properties p=new Properties();
			FileInputStream fi=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\properties\\config.properties");
			p.load(fi);
			String browserName=p.getProperty("browser");
			switch (browserName) {
			case "firefox":
				if(driver==null)
				{
					System.setProperty("webdriver.gecko.driver", Constant.GECKO_DRIVER_DIRECTORY);
					driver=new FirefoxDriver();
				}
				break;
			case "chrome":
				if(driver==null)
				{
					System.setProperty("webdriver.chrome.driver", Constant.CHROME_DRIVER_DIRECTORY);
					driver=new ChromeDriver();
				}
				break;
			}
		}
		catch (Exception e) {
			System.out.println("unable to load browser"+e.getMessage());
		}
		finally {
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
			contactuspage=PageFactory.initElements(driver, Contactus_Page.class);
			productspage=PageFactory.initElements(driver, Products_Page.class);
			basePage=PageFactory.initElements(driver, BasePage.class);
		}
		return driver;
	}

}
