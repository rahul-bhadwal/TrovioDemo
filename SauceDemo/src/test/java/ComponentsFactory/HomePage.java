package ComponentsFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import LocatorsFactory.HomePageLocators;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public ArrayList<String> sortListAToZ() {
		ArrayList<String> obtainedList = new ArrayList<>();
		List<WebElement> elementList = driver.findElements(By.xpath(HomePageLocators.itemsSuite));
		for (int i = 0; i < elementList.size(); i++) {
			obtainedList.add(elementList.get(i).getText());
		}

		Collections.sort(obtainedList);
		return obtainedList;
	}

	public ArrayList<String> sortListZToA() {
		ArrayList<String> obtainedList = new ArrayList<>();
		List<WebElement> elementList = driver.findElements(By.xpath(HomePageLocators.itemsSuite));

		for (int i = 0; i < elementList.size(); i++) {
			obtainedList.add(elementList.get(i).getText());
		}
		obtainedList.sort(Comparator.reverseOrder());
		return obtainedList;
	}

	public ArrayList<String> notSortedItemList() {
		ArrayList<String> obtainedList = new ArrayList<>();
		List<WebElement> itemsList = driver.findElements(By.xpath(HomePageLocators.itemsSuite));
		for (int i = 0; i < itemsList.size(); i++) {
			obtainedList.add(itemsList.get(i).getText());
		}
		return obtainedList;
	}

	public ArrayList<Double> sortPriceLowToHigh() {
		List<WebElement> priceItems = driver.findElements(By.xpath(HomePageLocators.itemsPrice));
		ArrayList<String> sortLowHigh = new ArrayList<>();
		ArrayList<Double> price = new ArrayList<>();
		for (int i = 0; i < priceItems.size(); i++) {
			sortLowHigh.add(priceItems.get(i).getText().toString());
		}
		for (int i = 0; i < sortLowHigh.size(); i++) {
			price.add(Double.parseDouble(sortLowHigh.get(i).toString().replace("$", "")));
		}
		price.sort(Comparator.naturalOrder());
		return price;
	}

	public ArrayList<Double> sortPriceHighToLow() {
		List<WebElement> priceItems = driver.findElements(By.xpath(HomePageLocators.itemsPrice));
		ArrayList<String> sortLowHigh = new ArrayList<>();
		ArrayList<Double> price = new ArrayList<>();
		for (int i = 0; i < priceItems.size(); i++) {
			sortLowHigh.add(priceItems.get(i).getText().toString());
		}
		for (int i = 0; i < sortLowHigh.size(); i++) {
			price.add(Double.parseDouble(sortLowHigh.get(i).toString().replace("$", "")));
		}
		price.sort(Comparator.reverseOrder());
		return price;
	}

	public ArrayList<Double> getPriceItemsFromPage() {
		List<WebElement> priceItems = driver.findElements(By.xpath(HomePageLocators.itemsPrice));
		ArrayList<Double> price = new ArrayList<>();
		for (int i = 0; i < priceItems.size(); i++) {
			price.add(Double.parseDouble(priceItems.get(i).getText().replace("$", "")));
		}
		return price;
	}

	public void addSeveralItemsToCart() {
		List<WebElement> buttonAddToCart = new ArrayList<>();
		buttonAddToCart = driver.findElements(By.xpath("//button[text()='ADD TO CART']"));
		for (int i = 0; i < 3; i++) {
			buttonAddToCart.get(i).click();
		}
	}

	public int getitemsSuiteInt() {
		List<WebElement> itemsSuiteList = driver.findElements(By.xpath(HomePageLocators.itemsSuite));
		return itemsSuiteList.size();
	}

	public List<String> getItemsSuiteString() {
		List<WebElement> obtainedList = driver.findElements(By.xpath(HomePageLocators.itemsSuite));
		List<String> itemsList = new ArrayList<>();
		for (int i = 0; i < obtainedList.size(); i++) {
			itemsList.add(obtainedList.get(i).getText());
		}
		return itemsList;
	}

	public WebElement getVisibleCartButton() {
		WebElement visibleCartButton = driver.findElement(By.xpath(HomePageLocators.topCartButton));
		return visibleCartButton;
	}

	@Step("Click on the name of the Sauce Labs Backpack product item")
	public void clickSauceLabsBackpack() {
		driver.findElement(By.xpath(HomePageLocators.sauceLabsBackpack)).click();
	}

	@Step("Click \"ADD TO CART\" button on the Sauce Labs Backpack product item on the Home page")
	public void clickAddCartSauceLabsBackpackButton() {
		driver.findElement(By.xpath(HomePageLocators.addCartSauceLabsBackpackToCartButton)).click();
	}

	@Step("Click \"Cart\" icon on the Home page")
	public void clickCartButton() {
		driver.findElement(By.xpath(HomePageLocators.topCartButton)).click();
	}

	@Step("Add all product items to cart by clicking \"ADD TO CART\" button near each product on the Home page")
	public void addAllItemsOfProductsToCart() {
		List<WebElement> allProductsAddToCartButtons = driver.findElements(By.xpath(HomePageLocators.addToCartButtons));
		for (int i = 0; i < allProductsAddToCartButtons.size(); i++) {
			allProductsAddToCartButtons.get(i).click();
		}
	}
}