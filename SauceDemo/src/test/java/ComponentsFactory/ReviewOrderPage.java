package ComponentsFactory;

import io.qameta.allure.Step;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import LocatorsFactory.*;

public class ReviewOrderPage {
	public WebDriver driver;
	public ReviewOrderPage(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Click \"FINISH\" button on the Overview page")
	public void clickFinishButton() {
		driver.findElement(By.xpath(ReviewOrderPageLocators.finishButton)).click();
	}

	public void clickCancelButton() {
		driver.findElement(By.xpath(ReviewOrderPageLocators.cancelButton)).click();
	}
}
