package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class AddEmployeePageElements {
	public AddEmployeePageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	@FindBy (id = "firstName")
	public WebElement firstName;
	
	@FindBy (id = "lastName")
	public WebElement lastName;
	
	@FindBy (id = "middleName")
	public WebElement middleName;
	
	@FindBy (id = "btnSave")
	public WebElement saveBtn;
	
	@FindBy (id = "profile-pic")
	public WebElement profilDetailsName;
	
	
	
	

}
