package testBase;

import org.openqa.selenium.WebDriver;

//to create threadsafe drivers for multiple Threading
public class DriverFactory {

	private DriverFactory() {
	}
	
	private static DriverFactory instance = new DriverFactory();
	
	public static DriverFactory getInstance() {
		return instance;
	}

	
	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	// To retrieve the value from hashmap
	public WebDriver getDriver() {
		return driver.get(); // It will retrieve value
	}

	// First set webdriver reference
	public void setDriver(WebDriver driverParm) {
		driver.set(driverParm); // It will set value in hashmap
	}

	// to remove current driver copy
	public void closeBrowser() {
		driver.get().close(); // get the latest status of the driver and then close the driver
		driver.remove(); // remove the current driver copy from hashmap
	}

}
