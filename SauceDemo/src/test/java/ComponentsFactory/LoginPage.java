package ComponentsFactory;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import LocatorsFactory.LoginPageLocators;
public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	private String errorNotificationUsername = "Epic sadface: Username is required";
	private String errorNotificationPassword = "Epic sadface: Password is required";
	private String strUsernameAndPassDoNotMatch = "Epic sadface: Username and password do not match any user in this service";

	@Step("Fill Username field with username), Password field with password and then click LOGIN button")
	public void login(String login, String password) {
		driver.findElement(By.xpath(LoginPageLocators.username)).sendKeys(login);
		driver.findElement(By.xpath(LoginPageLocators.password)).sendKeys(password);
		driver.findElement(By.xpath(LoginPageLocators.login)).click();
	}

	public String getErrorNotificationUsername() {
		return errorNotificationUsername;
	}

	public String getErrorNotificationPassword() {
		return errorNotificationPassword;
	}

	public String notificationUsername() {
		WebElement strUserNameIsRequired = driver.findElement(By.xpath(LoginPageLocators.userNameIsRequired));
		return strUserNameIsRequired.getText();
	}

	public String notificationUsernameAndPassword() {
		WebElement strNotificationUsernameAndPassword = driver.findElement(By.xpath(LoginPageLocators.errorNotificationUsernameAndPassword));
		return strNotificationUsernameAndPassword.getText();
	}

	public String notificationPassword() {
		WebElement strNotificationPassword = driver.findElement(By.xpath(LoginPageLocators.passIsRequired));
		return strNotificationPassword.getText();
	}

	public String getStrUsernameAndPassDoNotMatch() {
		return strUsernameAndPassDoNotMatch;
	}

	public Boolean loginButtonIsDisplayed() {
		return driver.findElement(By.xpath(LoginPageLocators.login)).isDisplayed();
	}
}