package Swaglabs.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Swaglab.AbstarctComponents.abstartcComponent;





public class ConfirmationPage extends abstartcComponent{
	
	WebDriver driver;
	public ConfirmationPage(WebDriver driver) {

	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
	
	@FindBy(css=".complete-header")
	WebElement confirmmessage;
	
	public String getConformationMessage()
		{
		      return confirmmessage.getText();
		}
	
}
