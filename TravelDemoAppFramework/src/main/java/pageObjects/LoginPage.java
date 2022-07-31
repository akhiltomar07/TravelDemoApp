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

import testBase.DriverFactory;
import testBase.TestBase;

public class LoginPage extends TestBase {

	By EMAIL = By.xpath("//input[@placeholder='Email']");
	By PASSWORD = By.xpath("//input[@placeholder='Password']");
	By LOGIN_BTN = By.xpath("//span[text()='Login']");

	// login to App
	
	  public void login(String email, String password) {
	  sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(EMAIL),
	  "LoginEmailFIeld", email);
	  sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(PASSWORD)
	  , "LoginPasswordFIeld", password);
	  
	  click_Custom(DriverFactory.getInstance().getDriver().findElement(LOGIN_BTN),
	  "LoginButton");
	  
	  }
	 

	public void validateBrokenLinks() throws IOException {
		List<WebElement> links = DriverFactory.getInstance().getDriver().findElements(By.tagName("a"));
		System.out.println(links.size());

		// create a List to add url that have href attribute
		List<String> urlList = new ArrayList<String>();

		// check one by one and find all links that have attribute value as "href" and
		// pass URLs to checkBrokenLink method to check whether status code is 400 or
		// not?
		for (WebElement e : links) {
			String url = e.getAttribute("href");
			urlList.add(url);
			// checkBrokenLink(url);
		}

		urlList.parallelStream().forEach(e -> checkBrokenLinkForAllUrls(e));

	}

	// to validate broken link using response code 400
	public static void checkBrokenLinkForAllUrls(String linkUrl)

	{
		try {

			URL url = new URL(linkUrl);
			HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
			httpUrlConnection.setConnectTimeout(5000);
			httpUrlConnection.connect();

			if (httpUrlConnection.getResponseCode() >= 400) {
				System.out.println(
						linkUrl + "  -------> " + httpUrlConnection.getResponseMessage() + " is a broken link");
			}

			else {
				System.out.println(
						linkUrl + " ---->  " + httpUrlConnection.getResponseMessage() + " is not a broken link");
			}

		}

		catch (Exception e) {

		}
	}

}
