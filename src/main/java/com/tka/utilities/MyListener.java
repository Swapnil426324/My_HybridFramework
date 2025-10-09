package com.tka.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class MyListener implements ITestListener{
	
	ExtentReports reports;
	ExtentTest test;
	
	Logger logger = LogManager.getLogger(MyListener.class);

	@Override
	public void onTestStart(ITestResult result) {
		logger.info("Test case execution started "+result.getName());
		test = reports.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {	
		logger.info("Test case is pass "+result.getName());
		test.log(Status.PASS, "test case pass "+result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.info("Test case failed "+result.getName());
		test.log(Status.FAIL, "test case failed "+result.getName());
		String screenshotPath = MyScreenshots.getScreenshot(result.getName());
		test.addScreenCaptureFromPath(screenshotPath);
	}

	@Override
	public void onTestSkipped(ITestResult result) {	
		logger.info("Test case skipped "+result.getName());
		test.log(Status.SKIP, "test case failed "+result.getName());
	}

	@Override
	public void onStart(ITestContext context) {
		logger.info("Test case suite started ");
		reports=MyReport.getExtentReport(context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		logger.info("Test case suite execution finish ");
		reports.flush();
	}

	
}
