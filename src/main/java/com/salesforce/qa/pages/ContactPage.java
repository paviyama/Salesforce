package com.salesforce.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.salesforce.qa.base.TestBase;

public class ContactPage extends TestBase{
	
	@FindBy(xpath="//input[@name='new']")
	WebElement newcontact;
	
	@FindBy(xpath="//input[@id='name_lastcon2']")
	WebElement lastname;
	
	@FindBy(xpath="//input[@id='con4']")
	WebElement Accountname;
	
	@FindBy(xpath="//td[@id='topButtonRow']//input[@name='save_new']")
	WebElement saveandnew;
	
	@FindBy(xpath="//select[@id='fcf']")
	WebElement contactdropdown;
	
	@FindBy(xpath="//a[@id='tryLexDialogX']")
	WebElement closepopup;

	public ContactPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void newCreateContact(String lname,String accname){
		newcontact.click();
		lastname.sendKeys(lname);
		Accountname.sendKeys(accname);
		saveandnew.click();
		
	}
	
	public void validateDropdown(){
		String[] exp={"All Contacts","Birthdays This Month","My Contacts","New This Week","Recently Viewed Contacts"};
		contactdropdown.click();
		Select s=new Select(contactdropdown);
		
		List<WebElement> options=s.getOptions();
		//String actual="";
		for(WebElement we:options){
			boolean match = false;
			  for (int i=0; i<exp.length; i++){
			      if (we.getText().equals(exp[i])){
			        match = true;
			      }
			}
			  Assert.assertTrue(match);
		}
	}
	}
