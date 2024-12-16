package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.cucumber.datatable.DataTable;

public class Contactus_Page extends BasePage{
	 
	public @FindBy(xpath="//input[@name='first_name']") WebElement textfield_firstName;
	public @FindBy(xpath="//input[@name='last_name']") WebElement textfield_lastName;
	public @FindBy(xpath="//input[@name='email']") WebElement textfield_EmailAddress;
	public @FindBy(xpath="//textarea[@name='meassage']") WebElement textfield_Message;
	public @FindBy(xpath="//input[@value='SUBMIT']") WebElement button_Submit;
	

	public Contactus_Page() throws IOException
	{
		super();
	}
	
	public Contactus_Page getContactUsPage() throws IOException
	{
		getDriver().get("https://www.webdriveruniversity.com/Contact-Us/contactus.html");
		return new Contactus_Page();
	}
	
	public Contactus_Page enterFirstName() throws IOException
	{
		sendKeysToWebElement(textfield_firstName, "Tom");
		 return new Contactus_Page();
	}
	
	public Contactus_Page enterLastName(DataTable dataTable, int row,int col) throws IOException
	{
		List<List<String>> data = dataTable.asLists(String.class);
		sendKeysToWebElement(textfield_lastName,data.get(row).get(col)+"\n");
		 return new Contactus_Page();
	}
	
	public Contactus_Page enterEmailAddress(String email) throws IOException
	{
		sendKeysToWebElement(textfield_EmailAddress, email);
		 return new Contactus_Page();
	}
	
	public Contactus_Page enterComments(DataTable dataTable, int row,int col) throws IOException
	{
		List<List<String>> data = dataTable.asLists(String.class);
		sendKeysToWebElement(textfield_Message,data.get(row).get(col)+"\n");
		 return new Contactus_Page();
	}
	
	public Contactus_Page clickOnSubmitButton() throws IOException
	{
		waitAndClickElement(button_Submit);
		 return new Contactus_Page();
	}
	

	public Contactus_Page confirmContactusFormSubmissionSuccessful() throws IOException
	{
		WebElement thanksContactUsPage=getDriver().findElement(By.xpath("//*[@id='contact_reply']/h1"));
		org.junit.Assert.assertEquals("thankyouforyourmessage!",  thanksContactUsPage.getText().toLowerCase().replaceAll("[(,replacement0-9", ""));
		 return new Contactus_Page();
	}
	
}
