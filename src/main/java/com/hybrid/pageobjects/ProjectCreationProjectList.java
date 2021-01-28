package com.hybrid.pageobjects;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hybrid.baseclass.Base;

import gherkin.formatter.model.Row;

public class ProjectCreationProjectList extends Base{

	
	
	
	@FindBy(xpath="(//table[@role='presentation'])[1]//colgroup//following-sibling::tbody//tr//td[5]")
	WebElement projectlistcolumn;
	
	@FindBy(xpath="//table[@class='menu']//tbody//tr[3]")
	WebElement insertcolumnafter;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement searchboxinInsertColumnwindow;
	
	@FindBy(xpath="//tr[contains(@role,'cell')]//td[4]")
	WebElement columnname;
	
	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	WebElement Cancel;
	
	@FindBy(xpath="//button[contains(text(),'OK')]")
	WebElement Ok;
	
	@FindBy(xpath="//div[@style='width:16px']")
	WebElement dateicon;
	
	@FindBy(xpath="//div[@id='object44244']//preceding-sibling::div[@id='object44052']")
	WebElement monthSelection;
	
	@FindBy(xpath="(//table[starts-with(@id,'string44')])[1]//tbody/tr//td")
	WebElement yearSelection;
	
	@FindBy(xpath="//div[@class='ss-scroll']")
	WebElement verticalScrollbar;
	
	@FindBy(xpath="//div[@class='ss-scroll rtl']")
	WebElement horizontalScrollbar;
	
	public ProjectCreationProjectList()
	{
		PageFactory.initElements(driver, this);
	}
	
	

	
	
	public void addingColumn() throws InterruptedException 
	{
		String passingvalue="has business case";
		String BefXpathofListOfOPtionsToSelectInsertColumn="//table[@class='menu']//tbody//tr[";
		String AfXpathofListOfOPtionsToSelectInsertColumn="]";
		String beforeXpathOfListOfValueInSuggestionList="(//table[@class='treeView'])[";
		String afterXpathOfListOfValueInSuggestionList="]";
	
		
		Actions s=new Actions(driver);
		s.moveToElement(projectlistcolumn).contextClick().build().perform();
		
		
		for(int i=1;i<=4;i++)
		{
			String value=driver.findElement(By.xpath(BefXpathofListOfOPtionsToSelectInsertColumn+i+AfXpathofListOfOPtionsToSelectInsertColumn)).getText();
			System.out.println(value);
			
			if(value.equals("Insert column after"))
			{
				Assert.assertTrue(true);
				driver.findElement(By.xpath(BefXpathofListOfOPtionsToSelectInsertColumn+i+AfXpathofListOfOPtionsToSelectInsertColumn)).click();
				break;
			}
		}
		
		searchboxinInsertColumnwindow.sendKeys(Keys.CONTROL+ "a");
		searchboxinInsertColumnwindow.sendKeys(Keys.DELETE);
		searchboxinInsertColumnwindow.sendKeys(passingvalue);
		
		Thread.sleep(3000);
		
		for(int j=1;j<=5;j++)
		{
			String columnname=driver.findElement(By.xpath(beforeXpathOfListOfValueInSuggestionList+j+afterXpathOfListOfValueInSuggestionList)).getText();
			
			if(columnname.equals("Has A Business Case ?"))
			{
				Assert.assertTrue(true);
				WebElement value=driver.findElement(By.xpath(beforeXpathOfListOfValueInSuggestionList+j+afterXpathOfListOfValueInSuggestionList));
				Thread.sleep(3000);
				value.click();
				Thread.sleep(2000);
				Ok.click();
				break;	
			}
			
			else {
				Assert.assertTrue(false);
			}

			
		}
		
	}
	
	public void scrolling() throws InterruptedException
	{
		
		WebElement startdate=driver.findElement(By.xpath("(//table[@role='presentation'])[2]//colgroup//following-sibling::tbody[1]//tr[1]//td[20]"));
		
		 
		JavascriptExecutor je= (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", startdate);
		Thread.sleep(3000);
		
	}
	
	public void choosingStartdate_EndDate() throws InterruptedException
	{
		
		String beforeXpath="(//table[@gui='63'])[1]//colgroup//following-sibling::tbody//tr[";
		String afterXpath="]";
		WebElement startdate=driver.findElement(By.xpath("(//table[@role='presentation'])[2]//colgroup//following-sibling::tbody[1]//tr[1]//td[17]"));
		String desiredDate="14-February-2022";
		String separator[]=desiredDate.split("-");
		String date=separator[0];
		String month=separator[1];
		String year=separator[2];
		
		
		startdate.click();
		
		dateicon.click();
		Thread.sleep(3000);
		monthSelection.click();
		Thread.sleep(3000);
		for(int i=1;i<=12;i++)
		{
			String monthvalues=driver.findElement(By.xpath(beforeXpath+i+afterXpath)).getText();
			System.out.println(monthvalues);
			
			if(monthvalues.contains(month)) {
				
				Assert.assertTrue(true);
				driver.findElement(By.xpath(beforeXpath+i+afterXpath)).click();
				Thread.sleep(3000);
				break;
			}
			}
		}
		
		
		
		
	}
	
	
			
