package Swaglabs.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Swaglab.AbstarctComponents.abstartcComponent;


public class CartPage extends abstartcComponent {
			WebDriver driver;
			
		public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
		
		
		@FindBy(linkText="CHECKOUT")
		WebElement checkoutEle;
		
		@FindBy(css=".inventory_item_name")
		 List<WebElement> cartProduct;
		
		public boolean verifyProductoDisplay(String ProductName)
		{
			Boolean match=cartProduct.stream().anyMatch(cartproduc->cartproduc.getText().equalsIgnoreCase(ProductName));
			return match;
		}
		public CheckoutPage goTocheckout()
		{
			checkoutEle.click();
			return new CheckoutPage(driver);
		}
		
		
	
		
		}
