package com.hybrid.baseclass;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.hybrid.utils.TestUtils;

public class Base {

	 public static WebDriver driver;
	 public static Properties pro;
	 public static Logger logger=LogManager.getLogger(Base.class.getName());
		
	 
	public Base()
	{
		try {
			
			pro=new Properties();
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/hybrid/config/config.properties");
			pro.load(fis);
			
		}
		catch(Exception e)
		{
			System.out.println("the exception is" +e.getMessage());
		}
	}
	
	
	public static void initialization()
	{
		String desiredbrowser=pro.getProperty("browser");
		
		if(desiredbrowser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", TestUtils.chromedriver);
			driver=new ChromeDriver();
		}
		
		else if (desiredbrowser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", TestUtils.firefoxdriver);
			driver=new FirefoxDriver();
		}
		
		else if(desiredbrowser.equals("ie"))
		{
			System.setProperty("webdriver.chrome.driver", TestUtils.iedriver);
			driver=new InternetExplorerDriver();
		}
		

		else if(desiredbrowser.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", TestUtils.edgedriver);
			driver = new EdgeDriver();
		}
		
		
		driver.manage().timeouts().pageLoadTimeout(TestUtils.Page_Load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.Implicit_Wait, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get(pro.getProperty("url"));
		
	}
	
	public void tearDown()
	{
		driver.close();
	}

}
