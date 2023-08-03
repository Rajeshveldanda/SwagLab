package SwagLabs.test;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Swaglabs.PageObjects.ProductCatalog;
import rahulshettyacademy.pageobject.ConformationPage;
import Swaglabs.PageObjects.CartPage;
import Swaglabs.PageObjects.CheckoutPage;
import Swaglabs.PageObjects.ConfirmationPage;
import Swaglabs.PageObjects.LandingPage;









public class StandaloneTest {

	public static void main(String[] args) throws InterruptedException {
		  
			System.setProperty("webdriver.chrome.driver", "D://Automation//driver//chrome//chromedriver.exe");
			String ProductName = "Sauce Labs Backpack";
			
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			LandingPage landingpage = new LandingPage(driver);
			landingpage.goTo();
			landingpage.equals(landingpage);
			ProductCatalog productcatalog =landingpage.loginapplication("performance_glitch_user", "secret_sauce");
			List<WebElement>products=productcatalog.getProdcutList();
			productcatalog.addProductToCart(ProductName);
			CartPage cartpage=productcatalog.goToCartPage();
			Boolean match=cartpage.verifyProductoDisplay(ProductName);
			Assert.assertTrue(match);
			CheckoutPage checkoutpage=cartpage.goTocheckout();
			checkoutpage.selectInformation("Rajesh", "veldanda", "509361");
			ConfirmationPage confirmationpage=checkoutpage.submitOrder();
			String confirmmessage =confirmationpage.getConformationMessage();
			Assert.assertTrue(confirmmessage.equalsIgnoreCase("THANK YOU FOR YOUR ORDER"));
			driver.close();
			
			
			
			

	}

}
