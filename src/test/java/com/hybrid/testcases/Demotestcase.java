package com.hybrid.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.hybrid.baseclass.Base;
import com.hybrid.pageobjects.Homepage;
import com.hybrid.pageobjects.LoginPage_01;
import com.hybrid.pageobjects.LoginPage_02;
import com.hybrid.pageobjects.ProgramCreationForm;
import com.hybrid.pageobjects.ProjectCreationProjectList;

public class Demotestcase extends Base {

	
	LoginPage_01 login1;
	LoginPage_02 login2;
	Homepage homepage;
	ProjectCreationProjectList projlist;
	
	
	
	
	public Demotestcase()
	{
		super();
		System.out.println("Calling the super class constructor to initialize the properties of config file");
	}
	
	@BeforeTest
	public void setUp()
	{
		initialization();
		
		login1 =new LoginPage_01();
		login2=new LoginPage_02();
		homepage=new Homepage();
		projlist=new ProjectCreationProjectList();
		
		
	}
	
	@Test
	public void a_LoginCrendentials()
	{
		
		String titleofpage=login1.validateTitleOfPage();
		Assert.assertEquals(titleofpage, "Planisware");
		System.out.println("title of this page is : " +titleofpage);
		login1.enterCrendentials(pro.getProperty("un"), pro.getProperty("pwd"));
		System.out.println("user name entered is : " +pro.getProperty("un"));
		System.out.println("password entered is : " +pro.getProperty("pwd"));
		
	}
	
	@Test
	public void b_loginClick() throws InterruptedException
	{
		
		String titleofpage=login2.validatePageTitle();
		Assert.assertEquals(titleofpage, "Planisware Application Server");
		System.out.println("title of this page is : " +titleofpage);
		login2.loginClick();
		System.out.println("clicked on login button");
		String homepagetitle=login2.validatePageTitle();
		Assert.assertEquals(homepagetitle, "Planisware 6 - Home");
		System.out.println("title of this page is : " +homepagetitle);
		
	}
	
	/*
	@Test
	public void c_addingColumn() throws InterruptedException
	{
		homepage.programClick();
		System.out.println("righ clicked");
		Thread.sleep(3000);
		projlist.addingColumn();
		System.out.println("column added into the view");
	}
	
	*/
	
	@Test
	public void d_selectingStartAndEndDate() throws InterruptedException
	{
		homepage.projectClick();
		
		projlist.scrolling();
		projlist.choosingStartdate_EndDate();
		
		
	}
	
	@Test
	public void tearDown()
	{
		
		//driver.close();
	}
	
}
