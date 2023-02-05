package ComponentsFactory;

import io.qameta.allure.Step;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import LocatorsFactory.CheckOutPageLocators;

public class CheckOutPage {
	public WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
	}

	private String errorFirstNameNotification = "Error: First Name is required";
	private String errorLastNameNotification = "Error: Last Name is required";
	private String errorPostalCodeNotification = "Error: Postal Code is required";

	@Step("Fill field \"First Name\" with data ({firstname}), fill field \"Last Name\" with data ({lastName}), fill field \"Zip/Postal Code\" with data ({postalCode})")
	public void fillFields(String firstname, String lastName, String postalCode) {
		driver.findElement(By.xpath(CheckOutPageLocators.firstNameField)).sendKeys(firstname);
		driver.findElement(By.xpath(CheckOutPageLocators.lastNameField)).sendKeys(lastName);
		driver.findElement(By.xpath(CheckOutPageLocators.postalCodeField)).sendKeys(postalCode);
	}

	@Step("Click \"CONTINUE\" button on the Checkout page")
	public void clickContinueButton() {
		driver.findElement(By.xpath(CheckOutPageLocators.continueButton)).click();
	}

	@Step("Method returns notification with requirement of necessary about First Name")
	public String getErrorFirstNameNotification() {
		return errorFirstNameNotification;
	}

	@Step("Method returns notification with requirement of necessary about Last Name")
	public String getErrorLastNameNotification() {
		return errorLastNameNotification;
	}

	@Step("Method returns notification with requirement of necessary about Postal Code")
	public String getErrorPostalCodeNotification() {
		return errorPostalCodeNotification;
	}

	@Step("Method returns error notification")
	public String errorNotification() {
		return driver.findElement(By.xpath(CheckOutPageLocators.errorNotification)).getText();
	}

}