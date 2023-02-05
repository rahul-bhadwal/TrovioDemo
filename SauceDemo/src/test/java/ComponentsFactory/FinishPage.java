package ComponentsFactory;

import io.qameta.allure.Step;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class FinishPage {
	public WebDriver driver;
	public FinishPage(WebDriver driver) {
		this.driver = driver;
	}

	private By gratitudeNotification = By.xpath("//h2[text()='THANK YOU FOR YOUR ORDER']");

	@Step("Return notification with gratitude")
	public String getGratitudeNotification() {
		return driver.findElement(gratitudeNotification).getText();
	}
}