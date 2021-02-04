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

public class GenericUIValidation extends Base {

	
	LoginPage_01 login1;
	LoginPage_02 login2;
	Homepage homepage;
	ProjectCreationProjectList projlist;
	
	public GenericUIValidation()
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
		logger.info("title of this page is : " +titleofpage);
		login1.enterCrendentials(pro.getProperty("un"), pro.getProperty("pwd"));
		logger.info("user name entered is : " +pro.getProperty("un"));
		logger.info("password entered is : " +pro.getProperty("pwd"));
		
	}
	
	@Test
	public void b_loginClick() throws InterruptedException
	{
		
		String titleofpage=login2.validatePageTitle();
		Assert.assertEquals(titleofpage, "Planisware Application Server");
		logger.info("title of this page is : " +titleofpage);
		login2.loginClick();
		logger.info("clicked on login button");
		String homepagetitle=login2.validatePageTitle();
		Assert.assertEquals(homepagetitle, "Planisware 6 - Home");
		logger.info("title of this page is : " +homepagetitle);
		
	}
	

	
	@Test
	public void c_addingColumn() throws InterruptedException
	{
		homepage.programClick();
		logger.info("right clicked no column in program list ");
		Thread.sleep(3000);
		projlist.addingColumn();
		logger.info("column added into the view");
	}
	
	
	
	
	@Test
	public void d_selectingStartAndEndDate() throws InterruptedException
	{
		homepage.projectClick();
		logger.info("clicked on project module");
		
		projlist.scrolling();
		logger.info("scrolled to point the satr date of project");
		
		projlist.choosingDateFromDateField();
		logger.info(" desired date choosen in start date field");
		
	}
	
	

	
	@Test
	public void e_SelectingPortfolio() throws InterruptedException
	
	{
		homepage.projectClick();
		logger.info("clicked on project module");
		
		Thread.sleep(5000);
		projlist.selectingPortfolio();
		
		logger.info("selected the portfolio on project list");
	}
	
	
	@Test
	public void f_logOut()
	{
		homepage.mainMenu();
		logger.info("clicked on main menu ");
		homepage.logOut();
		logger.info("clicked on logout ");
	}

	
	@Test
	public void tearDown()
	{
		
		driver.close();
	}
	
}
