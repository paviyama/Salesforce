package com.salesforce.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.salesforce.qa.base.TestBase;
import com.salesforce.qa.pages.ContactPage;
import com.salesforce.qa.pages.HomePage;
import com.salesforce.qa.pages.LeadPage;
import com.salesforce.qa.pages.LoginPage;
import com.salesforce.qa.pages.ProfilePage;

public class HomePageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	
	ContactPage contactpage;
	ProfilePage profilepage;
	LeadPage leadpage;
	
	public HomePageTest(){
		super();
	}
	@BeforeMethod
	public void setUp(){
		
		intialization();
		loginpage=new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		}
	@Test(priority=1,enabled=false)
	public void verifyHomePageTitleTest(){
		String homepagetitle=homepage.verifyHomePageTitle();
		System.out.println(homepagetitle);
		Assert.assertEquals(homepagetitle, "Salesforce - Essentials Edition");
	}
	@Test(priority=2, enabled=false)
	public void verifyUserNameTest(){
		boolean flag=homepage.verifyCorrectusername();
		Assert.assertTrue(flag);
	}
	@Test(priority=3,enabled=true)
	public void clickOnContactsPageTest(){
		contactpage=homepage.clickOnContacts();
	}
	@Test(priority=4,enabled=true)
	public void clickonProfileSettingsTest() throws InterruptedException{
		profilepage=homepage.clickOnProfileSettings();
		Thread.sleep(2000);
	}
	@Test(priority=5,enabled=false)
	public void clickonLeadPageTest(){
		leadpage=homepage.clickOnLeadPage();
	}
		
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
		
	}
	
	

}
