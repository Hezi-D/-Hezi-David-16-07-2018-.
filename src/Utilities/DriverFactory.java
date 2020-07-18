package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {
	
	//This Method return webDriver object
	public static WebDriver open (String browserType) {
		
		if(browserType.equalsIgnoreCase("fireFox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\heziD\\eclipse-workspace\\Test1\\BrowsersDrivers\\geckodriver.exe");
			return new FirefoxDriver();
		}
		else if (browserType.equalsIgnoreCase("IE")){
			//Return IE driver
			System.setProperty("webdriver.msedgedriver.driver", "C:\\Users\\heziD\\eclipse-workspace\\Test1\\BrowsersDrivers\\msedgedriver.exe");
			return new InternetExplorerDriver();
		
		}
		else {
			//Return chrome driver
		
			System.setProperty("webdriver.chrome.driver","C:\\Users\\heziD\\eclipse-workspace\\Test1\\BrowsersDrivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("incognito");
			return new ChromeDriver(options);
		}
		
		
		
	}

}
