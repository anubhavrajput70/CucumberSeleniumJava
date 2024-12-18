package pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Products_Page extends BasePage{
	
	public @FindBy(xpath ="//div[@id='container-special-offers']") WebElement button_specialOffers;
	public @FindBy(xpath="//div[@id='container-product2']']") WebElement button_laptops;
	public @FindBy(xpath="//div[@id='myModal']//b[contains(text(),'NEWCUSTOME')]") WebElement voucherNumber;
	public @FindBy(xpath="//button[text()='Proceed']") WebElement button_proceed;

	public Products_Page() throws IOException
	{
		super();
	}
	
	public Products_Page clickOnProceedButton_popup() throws IOException
	{
		waitAndClickElement(button_proceed);
		return new Products_Page();
	}
	public String printSpecialOfferVoucherCode() {
		String voucherCode =voucherNumber.getText();
		System.out.println("Voucher Code: "+voucherCode);
		return voucherCode;
		
	}
	
}
