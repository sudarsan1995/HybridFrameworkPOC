package com.hybrid.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hybrid.baseclass.Base;

public class Homepage extends Base {


	@FindBy(xpath="//div[@aria-label='Programs']")
	WebElement programsmodule;
	
	@FindBy(xpath="//div[@aria-label='Home']")
	WebElement Homemodule;
	
	@FindBy(xpath="//div[@aria-label='Projects']")
	WebElement ProjectsModule;
	
	
	@FindBy(xpath="//div[@aria-label='Administration']")
	WebElement AdministrationModule;
	
	@FindBy(xpath="//div[@aria-label='Portfolios']")
	WebElement PortfoliosModule;
	
	@FindBy(xpath="//div[@aria-label='Scenarios']")
	WebElement ScenariosModule;
	
	@FindBy(xpath="//div[@aria-label='Resources']")
	WebElement ResourcesModule;
	
	
	
	
	public Homepage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean isProgramIsDisplayed()
	{
		return programsmodule.isDisplayed();
		
	}
	
	public String getTitleOfPage()
	{
		return driver.getTitle();
	}
	
	
	public void programClick()
	{
		programsmodule.click();
	
	}
	
	
	
	
}
