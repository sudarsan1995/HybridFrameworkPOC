package com.hybrid.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hybrid.baseclass.Base;
import com.hybrid.pageobjects.Homepage;
import com.hybrid.pageobjects.LoginPage_01;
import com.hybrid.pageobjects.LoginPage_02;
import com.hybrid.pageobjects.ProgramCreationForm;
import com.hybrid.utils.TestUtils;


public class LoginFunctionality extends Base{
	
	LoginPage_01 login1;
	LoginPage_02 login2;
	Homepage homepage;
	ProgramCreationForm programcreation;
	String sheetname="progdata";
	
	
	
	public LoginFunctionality()
	{
		super();
		logger.info("Calling the super class constructor to initialize the properties of config file");
	}
	
	@BeforeTest
	public void setUp()
	{
		initialization();
		
		login1 =new LoginPage_01();
		login2=new LoginPage_02();
		homepage=new Homepage();
		programcreation=new ProgramCreationForm();
		
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
	public void c_ProgramCreation()
	{
		
		homepage.programClick();
		logger.info("clicked on Program module ");
		
	}
	
	
	
	@Test(dataProvider="getTestDatFromExcel")
	public void d_enteringDataInProgramCreationForm(String progDesc,String pgmLeg,String busOwner,String innoClass,String strgicInno,String prodMnger,String busContr) throws InterruptedException
	{
		programcreation.clickOnNewProgram();
		logger.info("clicked on New Program ");
		programcreation.creationForm(progDesc, pgmLeg, busOwner, innoClass, strgicInno, prodMnger, busContr);
		logger.info("Values are filled in fields");
	}
	
	@Test
	public void e_validateCreatedProgramAndClosetheProgram() throws InterruptedException
	{
		programcreation.validateProgram();
		logger.info("valuidated the program created is avaiable in program list and open and close the program");
		
	}
	
	@DataProvider
	public Object[][] getTestDatFromExcel()
	{
	Object[][] data=TestUtils.getTestData(sheetname);
	
	logger.info("Retriving data from getTestData method available in testutils class");
	
	return data;
	
	}
	
	@Test
	public void f_validatePopupInProgramCreationForm() throws InterruptedException
	{
		
		programcreation.validatePopupInProgramCreationForm();	
		logger.info("validated if manadatory fields not filled but proceeding ok see pop-up is thrown or not");
	}
	
	@Test
	public void g_logOut()
	{
		homepage.mainMenu();
		logger.info("clicked on main menu ");
		homepage.logOut();
		logger.info("clicked on logout ");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		logger.info("browser closed");
	}

}
