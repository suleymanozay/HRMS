package com.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.testng.annotations.Test;

public class MyFileRead {
	Properties prop;
	@Test
	public void read() {
		String filePath=System.getProperty("user.dir")+"/src/test/java/com/practice/Myfile.properties";
		
		try{
			FileInputStream fis=new FileInputStream(filePath);
			prop=new Properties(); 
			prop.load(fis);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String value=prop.getProperty("myname");
		String value1=prop.getProperty("lastname");
		String value2=prop.getProperty("state");
		System.out.println(value);
		System.out.println(value1);
		System.out.println(value2);
		System.out.println(prop.size());
		Set<Object> set=prop.keySet();
		for (Object object : set) {
			System.out.println(object);
			
		}
	}

}


