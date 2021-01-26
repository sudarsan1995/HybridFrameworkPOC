package com.hybrid.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
	
	@FindBy(xpath="(//input[@type='checkbox'])[1]")
	WebElement crossbusplt;
	
	@FindBy(xpath="//input[@aria-label='Strategic Initiative']")
	WebElement straInit;
	
	@FindBy(xpath="//input[@aria-label='Innovation Classification']")
	WebElement innoclas;
	
	@FindBy(xpath="//input[@aria-label='Product Manager']")
	WebElement productmanager;
	
	@FindBy(xpath="//input[@aria-label='Business Controller']")
	WebElement controller;
	
	@FindBy(xpath="(//input[@type='checkbox'])[2]")
	WebElement solution;
	
	@FindBy(xpath="(//input[@type='checkbox'])[3]")
	WebElement champion;
	

	
	@FindBy(xpath="(//input[@type='checkbox'])[4]")
	WebElement createproject;
	

	
	@FindBy(xpath="//button[@class='plw63 font27']")
	WebElement ok;
	
	@FindBy(xpath="//textarea[@id='object92130']")
	WebElement alertpopup;
	
	@FindBy(xpath="(//button[@onmouseleave='plw.tooltip.clearTooltip();'])[1]")
	WebElement alertpopupOkButton;
	
	@FindBy(xpath="//div[@id='winobject14_close']")
	WebElement closecreationform;
	
	@FindBy(css="#cga196152")
	WebElement backtolist;
	
	
	public ProgramCreationForm()
	{
		PageFactory.initElements(driver, this);
	}
	
	public ProgramCreationForm clickOnNewProgram()
	{
		newprogram.click();
		return new ProgramCreationForm();
	
	}
	
	
	
	public void creationForm(String progDesc,String pgmLegId,String busOwn,String innoClas,String strgicInni,String prodMngr,String busCont) throws InterruptedException
	{
		programcreationbutton.click();
		
		WebElement creteproject = createproject;
		JavascriptExecutor creproj = (JavascriptExecutor)driver;
		creproj.executeScript("arguments[0].click();", creteproject);
		
		WebElement cross = crossbusplt;
		JavascriptExecutor cros = (JavascriptExecutor)driver;
		cros.executeScript("arguments[0].click();", cross);
		
		WebElement sol = solution;
		JavascriptExecutor solu = (JavascriptExecutor)driver;
		solu.executeScript("arguments[0].click();", sol);
		
		WebElement cham = champion;
		JavascriptExecutor champ = (JavascriptExecutor)driver;
		champ.executeScript("arguments[0].click();", cham);
		
		Thread.sleep(3000);
		
		
		Actions move=new Actions(driver);
		move.moveToElement(productmanager).doubleClick().sendKeys(Keys.DELETE).sendKeys(Keys.ENTER).sendKeys(prodMngr).sendKeys(Keys.ENTER).build().perform();
		move.moveToElement(controller).doubleClick().sendKeys(Keys.DELETE).sendKeys(Keys.ENTER).sendKeys(busCont).sendKeys(Keys.ENTER).build().perform();
		programdescription.sendKeys(progDesc);
		programdescription.sendKeys(Keys.ENTER);
		proglegacyid.sendKeys(pgmLegId);
		proglegacyid.sendKeys(Keys.ENTER);
		businessowner.sendKeys(busOwn);
		businessowner.sendKeys(Keys.ENTER);
		innoclas.sendKeys(innoClas);
		
		innoclas.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		straInit.sendKeys(strgicInni);
		straInit.sendKeys(Keys.ENTER);
		ok.click();
		Thread.sleep(2000);
		
	
	}
	
	
	
	public void validateProgram() throws InterruptedException
	{
		
		String before_xpath="(//table[@role='presentation'])[2]//colgroup//following-sibling::tbody[1]//tr[";
		String after_xpath="]//td[6]";
		String programid="]//td[4]";
		
		for(int i=1;i<=7;i++)
		{
			String prgname=driver.findElement(By.xpath(before_xpath+i+after_xpath)).getText();
			String progid=driver.findElement(By.xpath(before_xpath+i+programid)).getText();
			System.out.println(progid);
			
			if(prgname.contains("TestProgram") && progid.contains(progid))
			{
				Assert.assertTrue(true);
				WebElement open=driver.findElement(By.xpath("(//table[@role='presentation'])[2]//colgroup//following-sibling::tbody[1]//tr[1]//td[2]"));
				open.click();
				Thread.sleep(5000);
			}	else
			{
				Assert.assertTrue(false);
			}
	}
				Actions s=new Actions(driver);
				s.moveToElement(backtolist).click().build().perform();
				System.out.println("clicked successfully");
		
	}	
	
	
	
	public void validatePopupInProgramCreationForm() throws InterruptedException
	{
		newprogram.click();
		programcreationbutton.click();
		ok.click();
		Assert.assertTrue(alertpopup.isDisplayed(), "Alert getting displayed");
		alertpopupOkButton.click();
		Thread.sleep(3000);
		closecreationform.click();
		
		
	}
}













