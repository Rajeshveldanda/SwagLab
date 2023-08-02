package SwagLabs.test;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.pageobject.LandingPage;



public class SubmitOrderSwagLab {

	public static void main(String[] args) throws InterruptedException {
		  
			System.setProperty("webdriver.chrome.driver", "D://Automation//driver//chrome//chromedriver.exe");
			String ProductName = "Sauce Labs Backpack";
			
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.saucedemo.com/v1/");
		//	LandingPage landingpage = new LandingPage(driver);
		//	landingpage.loginapplication("performance_glitch_user", "secret_sauce");
			
			driver.findElement(By.id("user-name")).sendKeys("performance_glitch_user");
			driver.findElement(By.id("password")).sendKeys("secret_sauce");
			driver.findElement(By.id("login-button")).click();
			
			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".inventory_item")));
			
			List<WebElement> products =driver.findElements(By.cssSelector(".inventory_item"));
			
			WebElement prod= products.stream().filter(product->product.findElement(By.xpath("//div[normalize-space()='Sauce Labs Backpack']"))
			.getText().equals(ProductName)).findFirst().orElse(null);
			prod.findElement(By.xpath("(//button[contains(text(),'ADD TO CART')])[1]")).click();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
			driver.findElement(By.cssSelector(".fa-w-18")).click();
			
			driver.findElement(By.linkText("CHECKOUT")).click();
			
			
			driver.findElement(By.id("first-name")).sendKeys("Rajesh");
			driver.findElement(By.id("last-name")).sendKeys("Veldanda");
			driver.findElement(By.id("postal-code")).sendKeys("509301");
			
			driver.findElement(By.xpath("//input[@class='btn_primary cart_button']")).click();
			
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".subheader")));
			
			driver.findElement(By.linkText("FINISH")).click();
			
			System.out.println(driver.findElement(By.cssSelector(".complete-header")).getText());
			
			

	}

}
