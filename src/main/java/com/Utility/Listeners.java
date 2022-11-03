package com.Utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends BaseClass implements ITestListener {
	
	ExtentReports extent=ExtentReportGenerator.getReports();
	ThreadLocal<ExtentTest> extenttest=new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		Library.test =extent.createTest(result.getClass().getName()+"=="+result.getMethod().getMethodName());
		extenttest.set(Library.test);
	}
	public void onTestSuccess(ITestResult result) {
		extenttest.get().log(Status.PASS, "Test Case Passed");
	}
	public void onTestFailure(ITestResult result) {
		extenttest.get().log(Status.FAIL, "Test Case Failed");
		
		Library.test.addScreenCaptureFromBase64String(getCapture());
		
	}
	public void onTestSkipped(ITestResult result) {
		extenttest.get().log(Status.SKIP, "Test Case Skipped");
	}
	public void onFinish(ITestContext context) {
		extent.flush();
	}
	
	public static String getCapture() {
		TakesScreenshot ts= (TakesScreenshot) driver;
		return ts.getScreenshotAs(OutputType.BASE64);
	}
		
}
