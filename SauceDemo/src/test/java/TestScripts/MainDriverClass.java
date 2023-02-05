package TestScripts;

import org.apache.log4j.Logger;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import CommonTestScenarios.LandingOnHomePageChrome;
import CommonUtilities.GenericMethods;

public class MainDriverClass {
	static WebDriver driver;
	GenericMethods GM;
	public static long WaitTime;
	LoginPageTests loginPage;
	CartTests cartTest;
	HomePageTests homePage;
	
	@BeforeTest
	public void setUp() throws Exception {
		driver = new LandingOnHomePageChrome().landingOnHomePage();
	}


	public MainDriverClass() {
		GM = new GenericMethods();
		GM.log = Logger.getLogger(MainDriverClass.class.getSimpleName());
		loginPage = new LoginPageTests();
		cartTest = new CartTests();
		homePage = new HomePageTests();
	}

	
	@Test(priority = 1)
	public void loginPageScripts() throws Exception {
		try {
			// Execute login page scripts 
			loginPage.CorrectLogin();
			loginPage.LoginWithEmptyUsername();
			loginPage.LoginWithEmptyPassword();
			loginPage.loginWithEmptyUsernameAndPassword();
			loginPage.incorrectLogin();
			loginPage.incorrectPassword();
			loginPage.incorrectLoginAndPassword();
			Thread.sleep(2000);

		} catch (Exception e) {
			GM.log.info("Error occured while running the automation test scripts, will restart again.");
			Thread.sleep(5000);
			GM.tearDown(driver);
		}
	}
	
	@Test(priority = 2)
	public void cartPageScripts() throws Exception {
		try {
			// Execute cart page scripts 
			cartTest.addItemToCartAndDeleteIt();
			cartTest.addAllItemsToCartAndDeleteIt();
			cartTest.addItemToCartAndContinueShopping();
			Thread.sleep(2000);

		} catch (Exception e) {
			GM.log.info("Error occured while running the automation test scripts, will restart again.");
			Thread.sleep(5000);
			GM.tearDown(driver);
		}
	}
	
	@Test(priority = 3)
	public void HomePageScripts() throws Exception {
		try {
			// Execute home page scripts (End to End test cases)
			homePage.buyProduct();
			homePage.buyProductFromItsPage();
			homePage.buyProductWithEmptyFirstName();
			homePage.buyProductWithIncorrectLastName();
			homePage.buyProductWithIncorrectPostalCode();
			homePage.cancelPurchase();
			
			Thread.sleep(2000);

		} catch (Exception e) {
			GM.log.info("Error occured while running the automation test scripts, will restart again.");
			Thread.sleep(5000);
			GM.tearDown(driver);
		}
	}

	@AfterTest
	public void close() {
		driver.quit();
	}

	public static void main(String[] args) throws Exception {
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		testng.setTestClasses(new Class[] { MainDriverClass.class });
		testng.addListener(tla);
		testng.run();
	}
}