package com.hybrid.pageobjects;

import java.awt.List;

import org.openqa.selenium.By;
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
		
		searchboxinInsertColumnwindow.sendKeys("has a business case");
		
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

			
		}
		
	
		
		
		
	
		
				
			
		
	}
	
	
			
}
