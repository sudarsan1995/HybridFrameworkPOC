package com.hybrid.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hybrid.baseclass.Base;

public class ProgramCreationForm extends Base {


	@FindBy(xpath="//div[@aria-label='New']")
	WebElement newprogram;
	
	@FindBy(xpath="//div[6]/table/tbody/tr/td[2]")
	WebElement programcreationbutton;
	
	@FindBy(xpath="//input[@aria-label='Description']")
	WebElement programdescription;

	@FindBy(xpath="//input[@aria-label='Business Owner']")
	WebElement businessowner;
	
	@FindBy(xpath="//input[@aria-label='Legacy ID']")
	WebElement proglegacyid;
	
	@FindBy(xpath="//label[@for='checkbox692020']")
	WebElement crossbusplt;
	
	@FindBy(xpath="//input[@aria-label='Strategic Initiative']")
	WebElement straInit;
	
	@FindBy(xpath="//input[@aria-label='Innovation Classification']")
	WebElement innoclas;
	
	@FindBy(xpath="//input[@aria-label='Product Manager']")
	WebElement productmanager;
	
	@FindBy(xpath="//input[@aria-label='Business Controller']")
	WebElement controller;
	
	@FindBy(xpath="//label[@for='checkbox1244024']")
	WebElement solution;
	
	@FindBy(xpath="//label[@for='checkbox1244322']")
	WebElement champion;
	
	@FindBy(xpath="//label[@for='checkbox1496024']")
	WebElement createproject;
	
	@FindBy(xpath="//button[@class='plw63 font27']")
	WebElement ok;
	
	
	public ProgramCreationForm()
	{
		PageFactory.initElements(driver, this);
	}
	
	public ProgramCreationForm clickOnNewProgram()
	{
		newprogram.click();
		return new ProgramCreationForm();
	
	}
	
	
	public void creationForm(String progDesc,String pgmLegId,String busOwn,String innoClas,String strgicInni,String prodMngr,String busCont)
	{
		programcreationbutton.click();
	//	Actions s=new Actions(driver);
		
		programdescription.sendKeys(progDesc);
		programdescription.sendKeys(Keys.ENTER);
		
		proglegacyid.sendKeys(pgmLegId);
		proglegacyid.sendKeys(Keys.ENTER);
		businessowner.sendKeys(busOwn);
		businessowner.sendKeys(Keys.ENTER);
		innoclas.sendKeys(innoClas);
		innoclas.sendKeys(Keys.ENTER);
		straInit.sendKeys(strgicInni);
		straInit.sendKeys(Keys.ENTER);
		productmanager.sendKeys(prodMngr);
		productmanager.sendKeys(Keys.ENTER);
		controller.sendKeys(busCont);	
		controller.sendKeys(Keys.ENTER);
		crossbusplt.click();
		solution.click();
		createproject.click();
		ok.click();
		
	}
}










