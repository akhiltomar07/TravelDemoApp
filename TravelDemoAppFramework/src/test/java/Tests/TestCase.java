package Tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyProfile;
import reusableComponents.PropertiesOperations;
import testBase.DriverFactory;
import testBase.ExtentFactory;
import testBase.TestBase;

public class TestCase extends TestBase {

	LoginPage loginPage = new LoginPage();
	HomePage homepage = new HomePage();
	MyProfile myProfile = new MyProfile();
	String email = PropertiesOperations.getPropertyValueByKey("email");
	String password = PropertiesOperations.getPropertyValueByKey("password");

	@Test(priority = 1, description = "Login Functionality")
	public void login() throws Throwable

	{
		loginPage.validateBrokenLinks();
		loginPage.login(email, password);
	}

	@Test(priority = 2, description = "Valid Login Functionality for valid user")
	public void validateUserLogin() throws InterruptedException {
		loginPage.login(email, password);
		Thread.sleep(1000);
		Assert.assertTrue(homepage.validateUserLogin());

	}

	@Test(priority = 3, description = "Update User Data")
	public void updateUserData() throws InterruptedException {
		loginPage.login(email, password);
		Thread.sleep(1000);
		Assert.assertTrue(homepage.validateUserLogin());

		myProfile.clickMyProfileButton();
		myProfile.updateProfileInformation();
	}
}
