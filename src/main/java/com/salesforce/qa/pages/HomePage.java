package com.salesforce.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.salesforce.qa.base.TestBase;

public class HomePage extends TestBase{
	
	WebDriverWait wait;
	
	@FindBy(xpath="//div[@id='userNavButton']//span[contains(text(),'vaishnavi sai')]")
	WebElement usernamelabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactslink;
	
	@FindBy(xpath="//div[@id='userNavButton']")
	WebElement user;
	
	@FindBy(xpath="//a[contains(text(),'My Profile')]")
	WebElement profilesettings;
	
	@FindBy(xpath="//a[contains(text(),'Leads')]")
	WebElement leadstab;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	WebElement logout;
	
	@FindBy(xpath="//a[@id='tryLexDialogX']")
	WebElement closepopup;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	public ContactPage clickOnContacts(){
		closepopup.click();
		 contactslink.click();
		 return new ContactPage();
	}
	public LeadPage clickOnLeadPage(){
		closepopup.click();
		leadstab.click();
		return new LeadPage();
	}
	public boolean verifyCorrectusername(){
		return usernamelabel.isDisplayed();
	}
	public ProfilePage clickOnProfileSettings(){
		closepopup.click();
		//wait.until(ExpectedConditions.elementToBeClickable(profilesettings));
		user.click();
		profilesettings.click();
		return new ProfilePage();
		
	}
	public void clickOnLogout(){
		//closepopup.click();
		logout.click();
		
	}
	

}
