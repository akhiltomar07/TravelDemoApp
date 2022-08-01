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

public class HomePage extends TestBase {

	By welcomeMessage = By.xpath("//div[@class='col-lg-6']//h2[@class='sec__title font-size-30 text-white']");
	By PASSWORD = By.xpath("//input[@placeholder='Password']");
	By LOGIN_BTN = By.xpath("//span[text()='Login']");
	By USER_NAME = By.xpath("//span[@style='text-transform:capitalize']");

	public boolean validateUserLogin() throws InterruptedException {
		boolean flag = false;
		String userName = DriverFactory.getInstance().getDriver().findElement(USER_NAME).getText();
		String welcomMessageText = DriverFactory.getInstance().getDriver().findElement(welcomeMessage).getText();
		if (welcomMessageText.equalsIgnoreCase("Hi, " + userName + " Welcome Back")) {
			flag = true;
		}
		return flag;

	}

	public boolean waitForScreenLoad() {
		boolean status = false;
		waitLoading();
		status = true;
		return status;
	}

	public void waitLoading() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='col-lg-6']//h2[@class='sec__title font-size-30 text-white']")));
	}

}
