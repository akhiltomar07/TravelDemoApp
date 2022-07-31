package testBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import reusableComponents.ActionEngine;
import reusableComponents.PropertiesOperations;

public class TestBase extends ActionEngine {
	
	public static WebDriverWait wait;
	BrowserFactory bf=new BrowserFactory();
	
	
	@SuppressWarnings("deprecation")
	@BeforeMethod(alwaysRun = true)
	public void launchApplication()
	{
	 	String browser=PropertiesOperations.getPropertyValueByKey("browser");
	    String url=	PropertiesOperations.getPropertyValueByKey("url");
		
		WebDriver driverInstance= bf.createBrowserInstance(browser);  //get the instance of driver
		DriverFactory.getInstance().setDriver(driverInstance);
		WebDriver driver = DriverFactory.getInstance().getDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.navigate().to(url);
		
		
		
	}
	

	@AfterMethod
	public void tearDown()
	{
		DriverFactory.getInstance().closeBrowser();
	}

}
