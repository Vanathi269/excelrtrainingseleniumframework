package com.framework.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.excelr.base.OHRMbase;
import com.excelr.pages.dashboardpage;
import com.excelr.pages.loginpage;

public class dashboardpagetest extends OHRMbase {
	
	WebDriver driver;
	dashboardpage dp;
	loginpage lp;
	
	@BeforeMethod
	public void browsersetup() {
		initialization();
		lp=new loginpage();
		}
	@Test
	public void validatequicklaunchsection() {
		dp=lp.login();
		Assert.assertTrue(dp.quicklaunchsection());
	}
	@Test
	public void myaction() {
		dp=lp.login();
		Assert.assertTrue(dp.myactionsection());
	}
	
	
	@AfterMethod
	public void closesetup() {
		tearDown();
	}
}
