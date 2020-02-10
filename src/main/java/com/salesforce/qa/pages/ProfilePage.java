package com.salesforce.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.salesforce.qa.base.TestBase;

public class ProfilePage extends TestBase {
	
	@FindBy(xpath="//div[@class='photoUploadSection']")
	WebElement MouseHover;
	
	@FindBy(xpath="//a[@id='uploadLink']")
	WebElement update;
	
	@FindBy(xpath="//input[@id='j_id0:uploadFileForm:uploadInputFile']")
	WebElement upload;
	
	@FindBy(xpath="//input[@id='j_id0:j_id7:save']")
	WebElement save;
	
	
	public ProfilePage(){
		PageFactory.initElements(driver, this);
	}
	
	public void uploading(){
		Actions action=new Actions(driver);
		action.moveToElement(MouseHover).build().perform();
		update.click();
		driver.switchTo().frame("uploadPhotoContentId");
		upload.sendKeys(System.getProperty("user.dir")+"\\src\\main\\java\\com\\salesforce\\qa\\testdata\\ganesh.jpg");
		save.click();
	}
	
	
	

}
