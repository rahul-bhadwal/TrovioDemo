package TestScripts;

import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.Test;
import data.UserData;
import ComponentsFactory.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePageTests {
	
	WebDriver driver;	

	@Test
    @Description(value = "Test checks possibility to login with correct data and make successful purchase.")
    public void buyProduct() {
	driver = MainDriverClass.driver;
	LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    CartPage cart = new CartPage(driver);
    CheckOutPage checkout = new CheckOutPage(driver);
    ReviewOrderPage review = new ReviewOrderPage(driver);
    FinishPage finish = new FinishPage(driver);
    loginPage.login(UserData.userNameLogin, UserData.userPassword);
    homePage.clickAddCartSauceLabsBackpackButton();
    homePage.clickCartButton();
    cart.clickCheckoutButton();
    checkout.fillFields(UserData.firstName, UserData.lastName, UserData.postalCode);
    checkout.clickContinueButton();
    review.clickFinishButton();
    Assert.assertEquals("THANK YOU FOR YOUR ORDER", finish.getGratitudeNotification());
    driver.findElement(By.xpath("//button[text()='Open Menu']")).click();
    driver.findElement(By.xpath("//a[text()='Logout']")).click();
  }



  @Test
  @Description(value = "Test checks possibility to make purchase from product's page.")
  public void buyProductFromItsPage() {
	LoginPage loginPage = new LoginPage(driver);
	HomePage homePage = new HomePage(driver);
	CartPage cart = new CartPage(driver);
	CheckOutPage checkout = new CheckOutPage(driver);
	ReviewOrderPage review = new ReviewOrderPage(driver);
	FinishPage finish = new FinishPage(driver);  
	AddElementtoCart addElement = new AddElementtoCart(driver);
	loginPage.login(UserData.userNameLogin, UserData.userPassword);
    homePage.clickSauceLabsBackpack();
    addElement.clickAddToCartButton();
    addElement.clickCartButton();
    cart.clickCheckoutButton();
    checkout.fillFields(UserData.firstName, UserData.lastName, UserData.postalCode);
    checkout.clickContinueButton();
    review.clickFinishButton();
    Assert.assertEquals("THANK YOU FOR YOUR ORDER", finish.getGratitudeNotification());
    driver.findElement(By.xpath("//button[text()='Open Menu']")).click();
    driver.findElement(By.xpath("//a[text()='Logout']")).click();
  }



  @Test
  @Description(value = "Test confirms impossible to make purchase with empty First Name field in the Checkout page.")
  public void buyProductWithEmptyFirstName() {
    LoginPage loginPage = new LoginPage(driver);
	HomePage homePage = new HomePage(driver);
	CartPage cart = new CartPage(driver);
	CheckOutPage checkout = new CheckOutPage(driver);  
    loginPage.login(UserData.userNameLogin, UserData.userPassword);
    homePage.clickAddCartSauceLabsBackpackButton();
    homePage.clickCartButton();
    cart.clickCheckoutButton();
    checkout.fillFields(UserData.emptyString, UserData.lastName, UserData.postalCode);
    checkout.clickContinueButton();
    Assert.assertEquals(checkout.getErrorFirstNameNotification(), checkout.errorNotification());
    driver.findElement(By.xpath("//button[text()='Open Menu']")).click();
    driver.findElement(By.xpath("//a[text()='Logout']")).click();
  }



  @Test
  @Description(value = "Test confirms impossible to make purchase with empty \"Last Name\" field in the Checkout page.")
  public void buyProductWithIncorrectLastName() {
	LoginPage loginPage = new LoginPage(driver);
	HomePage homePage = new HomePage(driver);
	CartPage cart = new CartPage(driver);
	CheckOutPage checkout = new CheckOutPage(driver); 
    loginPage.login(UserData.userNameLogin, UserData.userPassword);
    homePage.clickAddCartSauceLabsBackpackButton();
    homePage.clickCartButton();
    cart.clickCheckoutButton();
    checkout.fillFields(UserData.firstName, UserData.emptyString, UserData.postalCode);
    checkout.clickContinueButton();
    Assert.assertEquals(checkout.getErrorLastNameNotification(), checkout.errorNotification());
    driver.findElement(By.xpath("//button[text()='Open Menu']")).click();
    driver.findElement(By.xpath("//a[text()='Logout']")).click();
  }



  @Test
  @Description(value = "Test confirms impossible to make purchase with empty \"Zip/Postal Code\" field in the Checkout page.")
  public void buyProductWithIncorrectPostalCode() {
    LoginPage loginPage = new LoginPage(driver);
	HomePage homePage = new HomePage(driver);
	CartPage cart = new CartPage(driver);
	CheckOutPage checkout = new CheckOutPage(driver);
    loginPage.login(UserData.userNameLogin, UserData.userPassword);
    homePage.clickAddCartSauceLabsBackpackButton();
    homePage.clickCartButton();
    cart.clickCheckoutButton();
    checkout.fillFields(UserData.firstName, UserData.lastName, UserData.emptyString);
    checkout.clickContinueButton();
    Assert.assertEquals(checkout.getErrorPostalCodeNotification(), checkout.errorNotification());
    driver.findElement(By.xpath("//button[text()='Open Menu']")).click();
    driver.findElement(By.xpath("//a[text()='Logout']")).click();
  }



  @Test
  @Description(value = "Test confirms possibility to cancel purchase before customer fills its personal data")
  public void cancelPurchase() {
	LoginPage loginPage = new LoginPage(driver);
	HomePage homePage = new HomePage(driver);
	CartPage cart = new CartPage(driver);
	CheckOutPage checkout = new CheckOutPage(driver);
	ReviewOrderPage review = new ReviewOrderPage(driver);
    loginPage.login(UserData.userNameLogin, UserData.userPassword);
    homePage.clickAddCartSauceLabsBackpackButton();
    homePage.clickCartButton();
    cart.clickCheckoutButton();
    checkout.fillFields(UserData.firstName, UserData.lastName, UserData.postalCode);
    checkout.clickContinueButton();
    review.clickCancelButton();
    Assert.assertEquals(6, homePage.getitemsSuiteInt());
  }
}