package com.hybrid.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.hybrid.baseclass.Base;

public class TestUtils extends Base{

	public static long Implicit_Wait=20;
	public static long Page_Load_Timeout=10;

	public static String desiredbrowser=pro.getProperty("browser");
	public static String chromedriver=pro.getProperty("chromebrowser");
	public static String firefoxdriver=pro.getProperty("firefoxbrowser");
	public static String iedriver=pro.getProperty("iebrowser");
	public static String edgedriver=pro.getProperty("edgebrowser");
	public static Workbook book;
	public static Sheet sheet;
	
	public static String ExcelPath=System.getProperty("user.dir")+"/src/main/java/com/hybrid/testdatas/testdata.xlsx";
	
	public static Object[][] getTestData(String sheetName)
	{
		FileInputStream file=null;
		
		try
		{
			file=new FileInputStream(ExcelPath);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			e.getMessage();
		}
		
		try 
		{
			book=WorkbookFactory.create(file);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			e.getMessage();
		}
		
		sheet=book.getSheet(sheetName);
		
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)
			{
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			}
		}
		return data;
		
		
		
		
	}
	
	
	public static String takeScreenshot(WebDriver driver,String testCaseName) throws IOException
	{
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		
		File src=ts.getScreenshotAs(OutputType.FILE);
		String target = System.getProperty("user.dir") + "/screenshots/" +testCaseName + "-" +timeStamp +".png";
		FileUtils.copyFile(src,new File(target));
		
		System.out.println("Screenshot Taken");
		
		return target;
		
	
	}
	
	
	
	
	
}
