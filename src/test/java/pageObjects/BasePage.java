package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.DriverFactory;
import dev.failsafe.internal.util.Assert;

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
	

}
