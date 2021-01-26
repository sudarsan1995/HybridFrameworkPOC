package com.hybrid.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hybrid.baseclass.Base;

public class Homepage extends Base {


	@FindBy(xpath="//div[@aria-label='Programs']")
	WebElement programsmodule1;
	
	@FindBy(xpath="//div[contains(@aria-label,'Programs: ')]")
	WebElement programmodule2;
	
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
	
	@FindBy(xpath="//div[@id='sa165142']")
	WebElement logoout;
	
	
	
	@FindBy(xpath="//div[@aria-label='Planisware menu']")
	WebElement mainmenu;
	
	
	public Homepage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean isProgramIsDisplayed()
	{
		return programsmodule1.isDisplayed();
		
	}
	
	public String getTitleOfPage()
	{
		return driver.getTitle();
	}
	
	
	public void programClick()
	{
		programsmodule1.click();
		
	}
	
	public void programClick2()
	{
		programmodule2.click();
		
	}
	
	public void logOut()
	{
		logoout.click();
	
	}
	
	

	public  void mainMenu()
	{
		mainmenu.click();
	}
	
	
	}
	
	

