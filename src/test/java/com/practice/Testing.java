package com.practice;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.hrms.utils.CommonMethods;

public class Testing extends CommonMethods {
		@Test
		public void testing() {
			driver.findElement(By.id("txtUsername")).sendKeys("admin");
		}

}
