package com.Test;

import org.testng.annotations.Test;

import com.Utility.BaseClass;

public class Test2 extends BaseClass {
	
	@Test
	public void test2() {
		System.out.println("test 2");
		excel.getDataFromExcel("Sheet1", 1, 1);
	}

}
