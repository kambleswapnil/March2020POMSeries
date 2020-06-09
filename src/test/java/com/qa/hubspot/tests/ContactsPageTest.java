package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.utils.Constants;

public class ContactsPageTest extends BaseTest {

	HomePage homePage;
	ContactsPage contactsPage;
	
	@BeforeClass
	public void contactSetup() {
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.goToContactsPage();
	}
	
	@Test(priority=1)
	public void verifyContactsPageTitleTest() {
		String title = contactsPage.getContactsPageTitle();
		System.out.println("contact page title is: "+ title);
		Assert.assertEquals(title, Constants.CONTACT_PAGE_TITLE, "contact page title is not matched...");
	}
	
	@Test(priority=2)
	public void createContactTest() {
		contactsPage.createContact("james@gm.com", "James", "jo", "SDET manager");
	}
	
}
