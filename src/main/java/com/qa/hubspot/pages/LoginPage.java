package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class LoginPage extends BasePage{

	private WebDriver driver;
	
	//1. By locators -- OR
	By username = By.id("username");
	By password = By.id("password");
	By logibButton = By.id("loginBtn");
	By SignUpLink = By.linkText("Sign up");
	
	//2. create const.. of page class:
	public LoginPage(WebDriver driver) {
		this .driver = driver;
	}
	
	//3. page actions:
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifySignUpLink() {
		return driver.findElement(SignUpLink).isDisplayed();
	}
	
	public HomePage doLogin(String username, String password) {
		driver.findElement(this.username).sendKeys(username);
		driver.findElement(this.password).sendKeys(password);
		driver.findElement(this.logibButton).click();
		
		return new HomePage(driver);
	}
}
