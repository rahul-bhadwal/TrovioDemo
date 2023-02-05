package LocatorsFactory;

//to define common locators present on different pages
public class LoginPageLocators {
	
	public static String username = "//*[@name='user-name']";
	
	public static String password = "//*[@name='password']";
	
	public static String login = "//input[@type='submit' and @value='Login']";
	
	public static String userNameIsRequired = "//h3[text()='Epic sadface: Username is required']";
	
	public static String passIsRequired  = "//*[text()='Epic sadface: Password is required']";
	
	public static String errorNotificationUsernameAndPassword  = "//h3[@data-test='error']";

}
