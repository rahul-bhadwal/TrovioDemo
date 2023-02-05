package CommonTestScenarios;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import CommonUtilities.GenericMethods;
import CredentialStore.CredentialStores;

public class LandingOnHomePageChrome {
	WebDriver driver;
	GenericMethods GM;
	
	public LandingOnHomePageChrome() {
		GM = new GenericMethods();
		
	}
	
	public WebDriver landingOnHomePage() throws Exception {
		
		// call chrome browser launch function
		driver = GM.launchBrowserChrome(CredentialStores.SauceDemoURL,CredentialStores.ChromeDriver);
		Reporter.log("Launch the browser.");
		Thread.sleep(2000);
		
		return driver;
	}

}