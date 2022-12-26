package com.framework.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.excelr.base.OHRMbase;
import com.excelr.pages.dashboardpage;
import com.excelr.pages.loginpage;

public class Login extends OHRMbase{
	loginpage lp;
	dashboardpage dp;
	
	
	@BeforeMethod
	public void browsersetup() {
		initialization();
		lp=new loginpage();
		}
	@Test
	public void validatetitleTest() {
		 String expTitle= "OrangeHRM";
		 String actTitle=lp.getTitle();
		 Assert.assertEquals(expTitle, actTitle);
		}
	@Test
	public void validateloginTest() {
		dp=lp.login();
		Assert.assertTrue(dp.dashboardleftmenu());
	}
	@AfterMethod
	public void closesetup() {
		tearDown();
	}
}
