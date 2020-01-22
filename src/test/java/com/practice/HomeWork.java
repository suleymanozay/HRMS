package com.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeWork{
	
	Properties prop;
	WebDriver driver=new ChromeDriver();
	
	
	@BeforeMethod
	public void setUp() {
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	@Test
	public void login() {
		String filePath=System.getProperty("user.dir")+"/src/test/java/com/practice/OpenSourceDemoLogin.properties";
		
		try{
			FileInputStream fis=new FileInputStream(filePath);
			prop=new Properties(); 
			prop.load(fis);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String uid=prop.getProperty("Username");
		String pwd=prop.getProperty("Password");
		
		driver.findElement(By.name("txtUsername")).sendKeys(uid);
		driver.findElement(By.cssSelector("input#txtPassword")).sendKeys(uid);
		driver.findElement(By.cssSelector("input[name='Submit']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("div.head")).isDisplayed(), "Login is failed");
	
	}
	@AfterMethod 
	public void tearDown(){
		driver.quit();
	}

}