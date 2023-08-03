package SwagLab.StepDefinations;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import SwagLab.testComponents.BaseTest;
import Swaglabs.PageObjects.CartPage;
import Swaglabs.PageObjects.CheckoutPage;
import Swaglabs.PageObjects.ConfirmationPage;
import Swaglabs.PageObjects.LandingPage;
import Swaglabs.PageObjects.ProductCatalog;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.pageobject.ConformationPage;





public class StepDefinationimplem {
	public class stepDefinationsImpl extends BaseTest{
		
		public LandingPage  landingPage;
		public ProductCatalog ProductCatalog;
		public ConformationPage Confirmationpage;
		public CheckoutPage checkoutpage;
		
		
		@Given ("I landed on Ecommerce page")
		public void I_landed_on_ecommerce_page() throws IOException
		{
			landingpage =launchapplication();
		}
		
		@Given("^Logged on with username (.+) and pasword (.+)$")
		public void Logged_in_username_and_password(String username, String password)
		{
			ProductCatalog productcatalog =landingPage.loginapplication(username, password);
		}
		//When I add the product <productName> to cart
		
		@When("^I add product (.+) to cart$")
		public void i_add_product_to_cart(String productName) throws InterruptedException
		{
			List<WebElement>products=ProductCatalog.getProdcutList();
			ProductCatalog.addProductToCart(productName);
		}
		//And checkout <productName> and submit the order page
		@And("^checkout (.+) and submit the order page$")
		public void checkout_and_submit_the_order_page(String productName) throws InterruptedException
		{
			CartPage cartpage=ProductCatalog.goToCartPage();
			Boolean match=cartpage.verifyProductoDisplay(productName);
			Assert.assertTrue(match);
			CheckoutPage checkoutpage=cartpage.goTocheckout();
			checkoutpage.selectInformation("Rajesh", "veldanda", "509361");
			Confirmationpage=checkoutpage.submitOrder();
			
		}
		//Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage
		@Then ("{string} message is displayed on ConfirmationPage")
		public void message_is_displayed_on_ConfirmationPage(String string)
		{
			String conformmessage =Confirmationpage.getConformationMessage(); 
			Assert.assertTrue(conformmessage.equalsIgnoreCase(string));
		}
	}
}
