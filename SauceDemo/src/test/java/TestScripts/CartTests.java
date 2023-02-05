package TestScripts;

import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.Test;
import ComponentsFactory.HomePage;
import data.UserData;
import ComponentsFactory.CartPage;
import ComponentsFactory.LoginPage;
import org.openqa.selenium.WebDriver;

public class CartTests {
	WebDriver driver = MainDriverClass.driver;
	LoginPage loginPage = new LoginPage(driver);
	HomePage homePage = new HomePage(driver);
	CartPage cart = new CartPage(driver);
	
	@Test
	@Description(value = "Test confirms pssibility to add one product item to cart and then delete product item from cart.")
	public void addItemToCartAndDeleteIt() {
		driver = MainDriverClass.driver;
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = new HomePage(driver);
		CartPage cart = new CartPage(driver);
		loginPage.login(UserData.userNameLogin, UserData.userPassword);
		homePage.clickAddCartSauceLabsBackpackButton();
		homePage.clickCartButton();
		cart.removeOneItemFromCart();
		Assert.assertEquals(0, cart.listOfItems());
		driver.navigate().back();
		driver.navigate().back();
	}

	@Test
	@Description(value = "Test confirms possibility to add all product items to cart and then delete all product items from cart.")
	public void addAllItemsToCartAndDeleteIt() {
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = new HomePage(driver);
		CartPage cart = new CartPage(driver);
        loginPage.login(UserData.userNameLogin, UserData.userPassword);
		homePage.addAllItemsOfProductsToCart();
		homePage.clickCartButton();
		cart.removeAllItemsFromCart();
		Assert.assertEquals(0, cart.listOfItems());
		driver.navigate().back();
		driver.navigate().back();
	}

	@Test
	@Description(value = "Test confirms possibility to add product item to cart and then click CONTINUE SHOPPING button.")
	public void addItemToCartAndContinueShopping() {
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = new HomePage(driver);
		CartPage cart = new CartPage(driver);
		loginPage.login(UserData.userNameLogin, UserData.userPassword);
		homePage.clickAddCartSauceLabsBackpackButton();
		homePage.clickCartButton();
		cart.clickContinueShoppingButton();
		Assert.assertEquals(6, homePage.getitemsSuiteInt());
		driver.navigate().back();
		driver.navigate().back();
	}

}