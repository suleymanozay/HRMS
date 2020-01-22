package com.hrms.testcases;

import org.testng.annotations.Test;
import com.hrms.pages.AddEmployeePageElements;
import com.hrms.pages.DashboarPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;

public class S5_US16767 extends CommonMethods{
	@Test(groups="regression")
	public void addEmployeVerification() throws InterruptedException {
		LoginPageElements login=new LoginPageElements();
		DashboarPageElements dashboard=new DashboarPageElements();
		AddEmployeePageElements addEmployee=new AddEmployeePageElements();
			
		sendText(login.userName, "Admin");
		sendText(login.password, "Syntax@123");
		click(login.loginBtn);
		click(dashboard.pimLnk);
		click(dashboard.addEmpLnk);
		sendText(addEmployee.firstName, "Gun's");
		sendText(addEmployee.middleName, "and");
		sendText(addEmployee.lastName, "Roses");
		click(addEmployee.saveBtn);
		screenShot("addemploye");
		
		
			
	}
}
