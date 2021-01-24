package com.hybrid.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hybrid.baseclass.Base;

public class LoginPage_02 extends Base {

	
	@FindBy(xpath="//a[contains(text(),'Login')]")
	WebElement loginbutton;
	
	
	@FindBy(xpath="//a[contains(text(),'Documentation')]")
	WebElement DocumentatioLink;
	
	@FindBy(xpath="//a[contains(text(),'Pro Web')]")
	WebElement prowebLink;
	
	@FindBy(xpath="//a[contains(text(),'System Console')]")
	WebElement sysConsolelink;
	
	@FindBy(xpath="//a[contains(text(),'Administration')]")
	WebElement AdminLink;
	
	@FindBy(xpath="//a[contains(text(),'Contact Us')]")
	WebElement Contactuslink;
	
	
	public LoginPage_02()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validatePageTitle()
	{
		return driver.getTitle();
		
	}
	
	public void loginClick() throws InterruptedException
	{
		Thread.sleep(3000);
		loginbutton.click();
		
	}
	
	

}
