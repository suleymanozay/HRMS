package com.hrms.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrms.pages.DashboarPageElements;
import com.hrms.pages.LeaveListPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;

public class LeaveListPageTest extends CommonMethods{
	@Test(groups="regression")
	public void leaveLabelValidation() {
		LoginPageElements login=new LoginPageElements();
		DashboarPageElements dashboard=new DashboarPageElements();
		LeaveListPageElements leaveList=new LeaveListPageElements();
		test.info("Loggin into the application");
		sendText(login.userName, "Admin");
		sendText(login.password, "Syntax@123");
		click(login.loginBtn);
		test.info("Navigating to the Leave List");
		click(dashboard.leaveLnk);
		click(dashboard.leaveListLnk);
		test.info("Validating Leave List Label");
		Assert.assertTrue(leaveList.leaveListLbl.isDisplayed(), "Label is not displayed");
			
	}

}
