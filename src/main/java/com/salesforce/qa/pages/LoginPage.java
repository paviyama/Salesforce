package com.salesforce.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.salesforce.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(xpath="//input[@id='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='Login']")
	WebElement login;
	
	@FindBy(xpath="//img[@id='logo']")
	WebElement salesforcelogo;
    //initializing the page objects
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	//Actions
	public String validLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateSalesforceImage(){
		return salesforcelogo.isDisplayed();
	}
	public HomePage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		login.click();
		
		return new HomePage();
	}

}
