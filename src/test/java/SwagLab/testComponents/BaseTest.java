package SwagLab.testComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;



import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobject.LandingPage;

public class BaseTest {
	
		public WebDriver driver;
		public LandingPage landingpage;
		
	public WebDriver initializeDriver() throws IOException
	{
		//properties class
		Properties prop = new Properties();
		FileInputStream fls = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//rahulshettyacademy//resourceses//GlobalData.properties");
		prop.load(fls);
		String browserName=System.getProperty("browser")!= null ? System.getProperty("browser") : prop.getProperty("browser");
		//prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{	
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();	
	
		}
		else if (browserName.equalsIgnoreCase("Firefox")){
			System.setProperty("webdriver.chrome.driver", "D://Automation//driver//geckodriver-v0.32.0-win64.exe");
		     driver = new FirefoxDriver();
			//Firefox
		}
		else if (browserName.equalsIgnoreCase("Edge"))
		{
			//Edge
			System.setProperty("webDriver.edge.driver", "edge.exe");
			WebDriver driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot	ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
		
	}
	
		@BeforeMethod(alwaysRun=true)
		public LandingPage launchapplication() throws IOException
		{
			driver = initializeDriver();
			landingpage = new LandingPage();
			landingpage.goTo();
			return landingpage;
	
		}

}
