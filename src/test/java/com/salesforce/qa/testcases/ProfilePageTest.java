package com.salesforce.qa.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.salesforce.qa.base.TestBase;
import com.salesforce.qa.pages.ContactPage;
import com.salesforce.qa.pages.HomePage;
import com.salesforce.qa.pages.LoginPage;
import com.salesforce.qa.pages.ProfilePage;

public class ProfilePageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	ContactPage contactpage;
	ProfilePage profilepage;
	
	public ProfilePageTest(){
		super();
	}
	@BeforeMethod
	public void setUp(){
		
		intialization();
		loginpage=new LoginPage();
		contactpage=new ContactPage();
		profilepage=new ProfilePage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		profilepage=homepage.clickOnProfileSettings();
		}
	
  @Test
  public void uploadingPicture(){
	
	  profilepage.uploading();
	  
	  }
  @AfterMethod
	public void tearDown(){
		driver.quit();
		
	}
	

}
