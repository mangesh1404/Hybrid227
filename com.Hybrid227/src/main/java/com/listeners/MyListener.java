package com.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.base.BaseClass;
import com.utils.DriverUtils;

public class MyListener extends BaseClass implements ITestListener{

	Status status;
	public void onTestStart(ITestResult result) {
		test= report.createTest(result.getName());
	}
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Testcase is passed");
	}
	public void onTestFailure(ITestResult result) {
		//screenshot code
		test.log(Status.FAIL, "Testcase is failed");
		String path=DriverUtils.getScreenshot(result.getName());
		test.addScreenCaptureFromPath(path);
		
	}
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Testcase is skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		
		
	}

	public void onFinish(ITestContext context) {
		report.flush();
		
	}

	

	
}
