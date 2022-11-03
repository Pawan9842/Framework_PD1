package com.Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static ExcelDataProvider excel;
	public static ConfigDataProvider config;
	
	@BeforeSuite
	public void bs() throws Exception {
		
		//getting userid and pass from excel
		excel=new ExcelDataProvider();
		
		//getting url from config file
		config=new ConfigDataProvider();
		
	}
	@Parameters("BrowserName")
	@BeforeMethod
	public void setUp(String BrowserName) {
		if(BrowserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(BrowserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}else if(BrowserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
//		driver.get(excel.getDataFromExcel("Sheet1", 0, 2));
		driver.get(config.getURL());
		
		driver.manage().window().maximize();
		
	}
	@AfterMethod
	public void closeSetup() {
		driver.close();
	}

}
