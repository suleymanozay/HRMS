package com.hrms.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.hrms.pages.AddEmployeePageElements;
import com.hrms.pages.DashboarPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.Constants;
import com.hrms.utils.ExcelUtility;

public class AddEmployeeFromXl extends CommonMethods{
	@Test (dataProvider = "getEmployee",groups="regression")    
	public void addEmployee(String firstName,String middleName, String lastName, String userName, String password ) {
		//Login
		LoginPageElements login=new LoginPageElements();
		test.info("Login in into HRMS");
		login.login("Admin", "Syntax@123");
		//Dashboord
		DashboarPageElements dashBrd=new DashboarPageElements();
		click(dashBrd.pimLnk);
		waitForClickability(dashBrd.addEmpLnk);
		click(dashBrd.addEmpLnk);
		//AddEmployee
		test.info("Navigating to add Employe Page");
		AddEmployeePageElements addEmp=new AddEmployeePageElements();
		test.info("Adding Employee");
		sendText(addEmp.firstName, firstName);
		sendText(addEmp.middleName, middleName);
		sendText(addEmp.lastName, lastName);
		click(addEmp.chkLogin);
		sendText(addEmp.userName, userName);
		sendText(addEmp.userPassword, password);
		sendText(addEmp.confirmPassword, password);
		click(addEmp.saveBtn);
		//takeAScreenshot(userName);
		String exceptedN=firstName+" "+middleName+" "+lastName;
		String actualN=addEmp.profilDetailsName.getText();
		test.info("Validating add Employee");
		Assert.assertEquals(actualN, exceptedN, "Employee is not added");
	}
	
	@DataProvider
	public Object[][] getEmployee(){
		return ExcelUtility.excelIntoArray(Constants.XL_DATA_FILEPATH, "addEmployee");
	}

}
