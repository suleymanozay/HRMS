package com.hrms.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrms.pages.LoginPage;
import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;

public class LoginPageTest extends CommonMethods{
	//Test case to validate valid login
	@Test(groups="smoke")
	public void login() {
		LoginPage login=new LoginPage();
		sendText(login.username, "admin");
		sendText(login.password, "Hum@nhrm123");
		click(login.loginBtn);
		
	}
	/*
	 * Navigate to HRMS
	 * Enter uid
	 * leave password field blank
	 * click login
	 * verify ''Password cannot be empty' text
	 * close browser
	 */
	@Test(groups="regression")
	public void emptyPassword() {
		LoginPage login=new LoginPage();
		sendText(login.username, "admin");
		click(login.loginBtn);
		String exceptedString="Password cannot be empty";
		String actualMsg=driver.findElement(By.id("spanMessage")).getText();
		Assert.assertEquals(actualMsg, exceptedString, "This msg is not displayed");
		
	}
	@Test(groups="regression")
	public void negativeLogin() throws InterruptedException {
		LoginPageElements login =new LoginPageElements();
		sendText(login.userName, "Admin");
		click(login.loginBtn);
		String expectedError="Password cannot be empty";
		Assert.assertEquals(login.errorMsg.getText(), expectedError, "Error message text is not matched");
		
	}
	@Test(groups="regression")
	public void logoDisplayed() {
		LoginPage login=new LoginPage();
		boolean isDisplayed=login.loginLogo.isDisplayed();
		Assert.assertTrue(isDisplayed, "Login logo is not displayed");
	}
	
}
