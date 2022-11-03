package com.Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportGenerator {
	
	public static ExtentReports extent;
	
	public static ExtentReports getReports() {
		
		String path="C:\\Users\\USER\\eclipse-workspace\\3AAPawan\\Reports";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Automation Test Report");
		reporter.config().setReportName("3AAPawan Automation Test Report");
		reporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Project Name", "Facebook Testing");
		extent.setSystemInfo("Module Name", "Login Page");
		extent.setSystemInfo("Automation Tool", "Selenium WebDriver");
		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("QA Name", "Pawan");
		extent.setSystemInfo("Test Date", "6 April");
		return extent;
		
		
	}

}
