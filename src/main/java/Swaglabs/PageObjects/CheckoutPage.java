package Swaglabs.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.Abstractcomponents.AbstractComponents;
import rahulshettyacademy.pageobject.ConformationPage;

public class CheckoutPage extends AbstractComponents {

	WebDriver driver;
	public CheckoutPage(WebDriver driver) {

	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}

	
	
//	driver.findElement(By.id("first-name")).sendKeys("Rajesh");
//	driver.findElement(By.id("last-name")).sendKeys("Veldanda");
//	driver.findElement(By.id("postal-code")).sendKeys("");
	
	
	@FindBy(id="first-name")
	WebElement firstname;
	
	@FindBy(id="last-name")
	WebElement lastname;
	
	@FindBy(id="postal-code")
	WebElement postalcode;
	
	//driver.findElement(By.linkText("CHECKOUT")).click();
	
	@FindBy(xpath="//input[@class='btn_primary cart_button']")
	WebElement checkout;
	
	@FindBy(linkText="FINISH")
	WebElement submit;
	
	public void selectInformation(String frist,String last,String postal)  
	{
		firstname.sendKeys(frist);
		lastname.sendKeys(last);
		postalcode.sendKeys(postal);
		checkout.click();
	}
	public ConformationPage submitOrder()
	{
		submit.click();
		return new ConformationPage(driver);
		
	}
	
	
}
	
	
