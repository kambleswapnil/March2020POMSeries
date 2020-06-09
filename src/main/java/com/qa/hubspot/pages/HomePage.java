package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

public class HomePage extends BasePage{

	private WebDriver driver;

	By header = By.cssSelector("h1.dashboard-selector__title");
	By accountName = By.cssSelector("span.account-name ");
	
	By primaryContactLink = By.id("nav-primary-contacts-branch");
	By secondarContactLInk = By.id("nav-secondary-contacts");

	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	public String getHomePageTitle() {
		//		return driver.getTitle();
		return elementUtil.waitForTitleToBePresent(Constants.HOME_PAGE_TITLE, 10);
	}

	public String getHomePageHeaderText() {
		//		if(driver.findElement(header).isDisplayed()) {
		//			return driver.findElement(header).getText();
		//		}
		//		return null;

		if(elementUtil.doIsDisplayed(header)) {
			return elementUtil.doGetText(header);
		}
		return null;
	}

	public String getLoggedInUser() {
		//		if(driver.findElement(accountName).isDisplayed()) {
		//			return driver.findElement(accountName).getText();
		//		}
		//		return null;
		//	}

		if(elementUtil.doIsDisplayed(accountName)) {
			return elementUtil.doGetText(accountName);
		}
		return null;
	}
	
	public ContactsPage goToContactsPage() {
		clickOnContacts();
		return new ContactsPage(driver);
	}
	
	private void clickOnContacts() {
		elementUtil.waitForElementPresent(primaryContactLink, 10);
		elementUtil.doClick(primaryContactLink);
		elementUtil.waitForElementPresent(secondarContactLInk, 5);
		elementUtil.doClick(secondarContactLInk);
	}
}
