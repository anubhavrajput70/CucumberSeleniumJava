package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utils.DriverFactory;

public class BasePage extends DriverFactory{
	protected WebDriverWait wait;
	
	public void waitAndClickElement(WebElement element)
	{
		boolean clicked=false;
		int attempts=0;
		while(!clicked&& attempts<10)
		{
			try {

				this.wait.until(ExpectedConditions.elementToBeClickable(element)).click();
				System.out.println("Successfully clicked on the element: "+"<"+element.toString()+">");
				clicked=true;
			} catch (Exception e) {
			System.out.println("Unable to wait and click on webelement, Exception: "+e.getMessage());
			}
			attempts++;
		}
	}
	public void waitAndClickElementsUsingLocator(By by)
	{
		boolean clicked=false;
		int attempts=0;
		while(!clicked&& attempts<10)
		{
			try {

				this.wait.until(ExpectedConditions.elementToBeClickable(by)).click();
				System.out.println("Successfully clicked on the element: "+"<"+by.toString()+">");
				clicked=true;
			} catch (Exception e) {
			System.out.println("Unable to wait and click on webelement, Exception: "+e.getMessage());
			}
			attempts++;
		}
	}
	
	public void sendKeysToWebElement(WebElement element, String textToSend)
	{
		try {
			element.clear();
			element.sendKeys(textToSend);
			System.out.println("Successfull sent the following keys: "+textToSend+" to element: "+"<"+element.toString()+">");
		} catch (Exception e) {
			System.out.println("unable to locate webelemnt :"+"<"+element.toString()+"> and sent the following keys: "+textToSend);
			org.junit.Assert.fail("unable to send keys to webElement, Exception: "+e.getMessage());
		}
	}
	
	public void actionMoveAndClick(WebElement element) throws Exception
	{
		Actions ob=new Actions(driver);
		try {
			ob.moveToElement(element).click().build().perform();
			System.out.println("Successfully action moved and clicked on the webelement, using locator: "+"<"+element.toString()+">");
		} catch (StaleElementReferenceException elementUpdated) {
			WebElement elementToClick=element;
			Boolean elementPresent=wait.until(ExpectedConditions.elementToBeClickable(elementToClick)).isEnabled();
			if(elementPresent)
			{
				ob.moveToElement(elementToClick).click().build().perform();
				System.out.println("(stale Exception )- Successfully action moved and clicked on the webelement, using locator: "+"<"+element.toString()+">");
			}
		}
		catch (Exception e) {
			System.out.println("Unable to move and clicke on the webelement, using locator: "+"<"+element.toString()+">");
			org.junit.Assert.fail("Unable to move and clicke on the webelement, Exception: "+e.getMessage());
		}
	}
	
	public void actionMoveAndClickByLocator(By element) throws Exception{

		Actions ob=new Actions(driver);
		try {
			Boolean elementPresent=wait.until(ExpectedConditions.elementToBeClickable(element)).isEnabled();
			if(elementPresent)
			{
				WebElement elementToClick=driver.findElement(element);
				ob.moveToElement(elementToClick).click().build().perform();
				System.out.println(" Successfully action moved and clicked on the webelement, using locator: "+"<"+element.toString()+">");
			}
		}
			catch (StaleElementReferenceException elementUpdated) {
				WebElement elementToClick=driver.findElement(element);
				ob.moveToElement(elementToClick).click().build().perform();
				System.out.println("(stale Exception )- Successfully action moved and clicked on the webelement, using locator: "+"<"+element.toString()+">");
				}
			catch (Exception e) {
				System.out.println("Unable to move and clicke on the webelement, using locator: "+"<"+element.toString()+">");
				org.junit.Assert.fail("Unable to move and clicke on the webelement, Exception: "+e.getMessage());
			}
	}
	
}
