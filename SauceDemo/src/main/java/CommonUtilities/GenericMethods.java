package CommonUtilities;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class GenericMethods{
	
	public Logger log = Logger.getLogger(GenericMethods.class.getSimpleName());
    Properties property;
    WebDriver driver;	
	
	// function to launch google chrome browser
	public WebDriver launchBrowserChrome(String URL,String DriverPath) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", DriverPath);
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		prefs.put("profile.default_content_settings.popups", 0);
//		ChromeOptions options = new ChromeOptions();
//		options.setExperimentalOption("prefs", prefs);
//		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//		options.addArguments("chrome.switches","--disable-extensions");	
//		options.addArguments("disable-infobars");
//		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//		capabilities.setCapability("unexpectedAlertBehaviour", "ignore");
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		return driver;
	}
	
	// function to close the browser window once the script is completed
 	public void tearDown(WebDriver driver)
	{
		driver.quit();	
	}

}