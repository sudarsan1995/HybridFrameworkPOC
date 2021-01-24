package com.hybrid.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hybrid.baseclass.Base;

public class LoginPage_01 extends Base {

	@FindBy(name="httpd_username")
	WebElement usernametextbox;
	
	@FindBy(name="httpd_password")
	WebElement passwordtextbox;
	
	@FindBy(xpath="//button[contains(text(),'Sign in')]")
	WebElement submitbutton;
	
	@FindBy(xpath="//em[contains(text(),'Forgot password?')]")
	WebElement forgotpwdlink;
	
	@FindBy(xpath="//img[@src='/auth/assets/img/planisware_logo_new_100.png']")
	WebElement logo;
	
	@FindBy(xpath="//h1[contains(text(),'Welcome to Planisware')]")
	WebElement Label;
	
	@FindBy(xpath="//a[contains(text(),'support@planisware.com')]")
	WebElement pleaseContactlink;
	
	@FindBy(xpath="//h2[contains(text(),'Please login...')]")
	WebElement PleaseLoginLabel;
	
	public LoginPage_01()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateTitleOfPage() {
		
		
		return driver.getTitle();
	}
	
	public boolean validateLogo()
	{
		return logo.isDisplayed();
	}
	
	public void enterCrendentials(String un,String pwd)
	{
		usernametextbox.sendKeys(un);
		passwordtextbox.sendKeys(pwd);
		submitbutton.click();
		
		
		
		
	}
	
	
}
