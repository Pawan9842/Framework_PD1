package com.Test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Pages.LoginPOM;
import com.Utility.BaseClass;
import com.Utility.Library;

public class Test1 extends BaseClass {

	@Test
	public void verifyLoginPAge_FB() {
		LoginPOM login =PageFactory.initElements(driver, LoginPOM.class);
		
		Library.custom_sendKeys(login.getEmail(), excel.getDataFromExcel("Sheet1", 0, 0), "email");
		Library.custom_sendKeys(login.getPassword(), excel.getDataFromExcel("Sheet1", 1, 0), "password");
		Library.custom_click(login.getBtnlogin(), "loginButton");
		
		
		
		String title=driver.getTitle();
		System.out.println(title);
		
		String exptitle="HomePage";
		
		Assert.assertEquals(title, exptitle);
				
	}
}
