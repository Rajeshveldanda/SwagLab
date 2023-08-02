package Swaglab.AbstarctComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Swaglabs.PageObjects.CartPage;

public class abstartcComponent {
	
WebDriver driver;
	

	public abstartcComponent(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css= ".fa-w-18")
	WebElement cartHeader;
	
	@FindBy(css= ".subheader")
	WebElement orderHeader;
	
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".inventory_item")));
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".subheader")));
	

	public void waitforelementToAppear(By findBy)
	{
	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public CartPage goToCartPage()
	{
		cartHeader.click();
		CartPage cartpage=new CartPage(driver);
		return cartpage;
	}
	
	
	
	
	
	}
	


