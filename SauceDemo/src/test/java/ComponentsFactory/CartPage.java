package ComponentsFactory;

import io.qameta.allure.Step;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import LocatorsFactory.CartPageLocators;

import java.util.List;

public class CartPage {
	public WebDriver driver;
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Delete one product item from the cart by clicking \"REMOVE\" button")
	public void removeOneItemFromCart() {
		driver.findElement(By.xpath(CartPageLocators.removeButton)).click();
	}

	@Step("Delete all items from the cart by clicking button \"REMOVE\" near every product item")
	public void removeAllItemsFromCart() {
		List<WebElement> removeButtonsList = driver.findElements(By.xpath(CartPageLocators.removeButton));
		for (int i = 0; i < removeButtonsList.size(); i++) {
			removeButtonsList.get(i).click();
		}

	}

	public int listOfItems() {
		List<WebElement> items = driver.findElements(By.xpath(CartPageLocators.listOfItems));
		return items.size();
	}

	@Step("Click \"CHECKOUT\" button on the Cart page")
	public void clickCheckoutButton() {
		driver.findElement(By.xpath(CartPageLocators.checkoutButton)).click();
	}

	@Step("Click \"CONTINUE SHOPPING\" button on the Cart page")
	public void clickContinueShoppingButton() {
		driver.findElement(By.xpath(CartPageLocators.continueShoppingButton)).click();
	}
}