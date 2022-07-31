package pageObjects;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import testBase.DriverFactory;
import testBase.TestBase;

public class MyProfile extends TestBase {

	By My_Profile_Button = By.xpath("//ul[@class='sidebar-menu list-items']//a[contains(@class,'waves-effect')][normalize-space()='My Profile']");
	By First_Name = By.xpath("//input[@name='firstname']");
	By Last_Name = By.xpath("//input[@name='lastname']");
	By Update_Button = By.xpath("//button[@type='submit']");
	
	
	public void clickMyProfileButton() {
		
		click_Custom(DriverFactory.getInstance().getDriver().findElement(My_Profile_Button), "My Profile Button was not clicked");
		
	}
	
	public void updateProfileInformation() throws InterruptedException
	{
		
	//	wait.until(ExpectedConditions.visibilityOf(element));
		//DriverFactory.getInstance().getDriver().findElement(First_Name).clear();
		Thread.sleep(2000);
		DriverFactory.getInstance().getDriver().findElement(First_Name).clear();
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(First_Name), "FirstName", "Akhil");
		DriverFactory.getInstance().getDriver().findElement(Last_Name).clear();
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(Last_Name), "LastName", "Tomar");
		Thread.sleep(2000);
		click_Custom(DriverFactory.getInstance().getDriver().findElement(Update_Button), "Update Profile Button");

	}

}
