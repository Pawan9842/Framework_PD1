package com.Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties pr;
	
	public ConfigDataProvider() throws Exception {
		String path="C:\\Users\\USER\\eclipse-workspace\\3AAPawan\\ConfigData\\config.properties";
		FileInputStream fis=new FileInputStream(path);
		pr=new Properties();
		pr.load(fis);
	}
	
	public String getURL() {
		return pr.getProperty("URL");
	}
	
}
