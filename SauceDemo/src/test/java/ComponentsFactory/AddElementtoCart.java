package ComponentsFactory;

import io.qameta.allure.Step;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class AddElementtoCart {
	public WebDriver driver;
	public AddElementtoCart(WebDriver driver) {
		this.driver = driver;
	}

	private By addToCartButton = By.xpath("//button[text()='Add to cart']");
	private By cartButton = By.xpath("//div[@id='shopping_cart_container']/a");

	@Step("Click \"ADD TO CART\" button on the Sauce Labs Backpack page")
	public void clickAddToCartButton() {
		driver.findElement(addToCartButton).click();
	}

	@Step("Click Cart icon on the Sauce Labs Backpack page")
	public void clickCartButton() {
		driver.findElement(cartButton).click();
	}
}