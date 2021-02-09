package com.hybrid.utils;

import java.io.IOException;



import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import org.testng.*;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.hybrid.baseclass.Base;


public class Listeners extends Base implements ITestListener {


  	public ExtentTest logger;
	ExtentReports extent=ExtendReporting.reportGeneration();
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		logger=extent.createTest(result.getMethod().getMethodName()); // create an entry in report
	}
		
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		
		
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.log(Status.PASS,"test case passed is  "   +result.getName());
			logger.log(Status.PASS,MarkupHelper.createLabel(result.getName(),ExtentColor.GREEN));
		}
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.log(Status.FAIL,"test case failed is   "    +result.getName());
			logger.log(Status.FAIL,MarkupHelper.createLabel(result.getName(),ExtentColor.RED));
			logger.log(Status.FAIL,"test case failed is" +result.getThrowable());
			
				try {
					String screenpath=TestUtils.takeScreenshot(driver, result.getName());
					logger.addScreenCaptureFromPath(screenpath);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
					
				}		
							
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
		if(result.getStatus()==ITestResult.SKIP)
		{
		logger.log(Status.SKIP,MarkupHelper.createLabel(result.getName(),ExtentColor.ORANGE));
		}
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	
		extent.flush();
		
	}
	
	

}
