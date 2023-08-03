package Swaglabs.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Swaglab.AbstarctComponents.abstartcComponent;


public class ProductCatalog extends abstartcComponent{
	WebDriver driver;
	public ProductCatalog(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//	List<WebElement> products =driver.findElements(By.cssSelector(".inventory_item"));
		
		@FindBy(css=".inventory_item")
		List<WebElement> products;
		
		By ProductsBy= By.cssSelector(".inventory_item");
		By addToCart = By.xpath("(//button[contains(text(),'ADD TO CART')])[1]");
		By Cart = By.cssSelector(".inventory_item");
		
		public  List<WebElement> getProdcutList(){
			waitforelementToAppear(ProductsBy);
			return products;
		}	
		public WebElement getProductByName(String ProductName)
		{
			WebElement prod= getProdcutList().stream().filter(product->product.findElement(By.xpath("//div[normalize-space()='Sauce Labs Backpack']"))
			.getText().equals(ProductName)).findFirst().orElse(null);
			return prod;
		}
		public void addProductToCart(String ProductName)
		{
			WebElement prod=getProductByName(ProductName); 
			prod.findElement(addToCart).click();
			waitforelementToAppear(Cart);
		}
		
		
		
		
}
		
			
		
