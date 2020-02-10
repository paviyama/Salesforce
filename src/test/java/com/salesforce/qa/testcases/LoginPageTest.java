package com.salesforce.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.salesforce.qa.base.TestBase;
import com.salesforce.qa.pages.ContactPage;
import com.salesforce.qa.pages.HomePage;
import com.salesforce.qa.pages.LoginPage;
import com.salesforce.qa.pages.ProfilePage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	ContactPage contactpage;
	ProfilePage profilepage;
	
	public LoginPageTest(){
		super(); //it will call superclass constructor because we also need to intialize properties file also
	}
	@BeforeMethod
	public void setUp(){
		
		intialization();
		loginpage=new LoginPage();
		}
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title=loginpage.validLoginPageTitle();
		Assert.assertEquals(title, "Login | Salesforce");
	}
	@Test(priority=2)
	public void salesforceLogoTest(){
       boolean flag= loginpage.validateSalesforceImage();
       Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void loginTest(){
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}


	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
		
	}

}
