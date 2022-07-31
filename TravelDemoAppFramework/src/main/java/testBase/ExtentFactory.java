package testBase;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

//To make Extent test object as thread safe
public class ExtentFactory {

	private ExtentFactory() {
	}
	
	private static ExtentFactory instance = new ExtentFactory();
	
	public static ExtentFactory getInstance() {
		return instance;
	}

	// -------------------------------------Factory Design pattern----------------------------------------------
	// define separate factory methods for creating objects and create objects by calling that method

	ThreadLocal<ExtentTest> extent = new ThreadLocal<ExtentTest>();

	// To retrieve the value from hashmap
	public ExtentTest getExtent() {
		return extent.get(); // It will retrieve value
	}

	// First set webdriver reference
	public void setExtent(ExtentTest extentTestObject) {
		extent.set(extentTestObject); // It will set value in hashmap
	}
	
	public void removeExtentObject()
	{
		extent.remove();
	}

}
