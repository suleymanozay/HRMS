package com.practice;


import java.util.Properties;

import org.testng.annotations.Test;

import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;

public class aa  {
	@Test
	public void open() {
	Properties cred=ConfigsReader.readProperties(Constants.CREDENTIALS_FILEPATH);
	cred.getProperty("browser");
	
		
		
	}
	

}
