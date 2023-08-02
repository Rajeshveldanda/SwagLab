package Swaglabs.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Swaglab.AbstarctComponents.abstartcComponent;
import rahulshettyacademy.Abstractcomponents.AbstractComponents;
import rahulshettyacademy.pageobject.ProductCatalogue;

public class LandingPage extends abstartcComponent{
	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//	WebElement userid=	driver.findElement(By.id("user-name"));
	
		@FindBy(id="user-name")
		WebElement username;	
		
	//	driver.findElement(By.id("password")).sendKeys("secret_sauce");
		@FindBy(id="password")
		WebElement Password;
		
	//	driver.findElement(By.id("login-button")).click();
		@FindBy(id="login-button")
		WebElement loginbutton;
		
		public ProductCatalog loginapplication(String email,String password)
		{
			username.sendKeys(email);
			Password.sendKeys(password);
			loginbutton.click();
			ProductCatalog productcatalog = new ProductCatalog(driver);
			return productcatalog;
		}
		
		public void goTo()
		{
			driver.get("https://www.saucedemo.com/v1/");
			
		}
}
