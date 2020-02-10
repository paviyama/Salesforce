/*
 * @author Pavi Yama
 * 
 */

package com.salesforce.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.salesforce.qa.base.TestBase;
import com.salesforce.qa.pages.HomePage;
import com.salesforce.qa.pages.LoginPage;
import com.salesforce.qa.util.TestUtil;
import com.salesforce.qa.pages.ContactPage;

public class ContactPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	ContactPage contactpage;
	TestUtil testutil;
	
	String sheetName="contacts";
	public ContactPageTest(){
		super();
	}
	@BeforeMethod
	public void setUp(){
		
		intialization();
		loginpage=new LoginPage();
		contactpage=new ContactPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactpage=homepage.clickOnContacts();
		testutil=new TestUtil();
		}
	@Test(priority=1)
	public void verifyingContactDropDownTest(){
		
		contactpage.validateDropdown();
		
	}
	@DataProvider
	public Object getContactsTestData(){
		Object data[][]=testutil.getTestData(sheetName);
		return data;
	}
	@Test(priority=2, dataProvider="getContactsTestData")
	public void createnewContactTest(String lastname,String accountname){
		contactpage.newCreateContact(lastname, accountname);
		}
	@AfterMethod
	public void tearDown(){
		driver.quit();
		
	}

}
