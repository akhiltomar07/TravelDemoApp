package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

//to handle multiple browsers
public class BrowserFactory {

	// create webdriver object for given browser using WebDriverManager
	
	public WebDriver createBrowserInstance(String browser) {
		WebDriver driver = null;

		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options =new ChromeOptions();//ChromeOptions contains various setting of browser
			options.addArguments("--incognito");//to run test cases in private mode
			driver = new ChromeDriver(options);
		//	System.getProperty("webdriver.chrome.SilentOutput", true);

		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions foptions=new FirefoxOptions();
			foptions.addArguments("-private");
			driver = new FirefoxDriver(foptions);
		}
		if (browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			InternetExplorerOptions iOptions=new InternetExplorerOptions();
			iOptions.addCommandSwitches("-private");
			driver = new InternetExplorerDriver(iOptions);
		}

		return driver;
	}

}
