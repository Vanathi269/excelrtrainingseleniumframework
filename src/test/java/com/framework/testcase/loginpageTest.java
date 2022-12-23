package com.framework.testcase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.excelr.base.OHRMbase;
import com.excelr.pages.dashboardpage;
import com.excelr.pages.loginpage;

public class loginpageTest extends OHRMbase{
	/*
	 * problem while using this
	 * 1.driver code is repeated
	 * 2.hard coding the data
	 * 3.mixing of code with testcases
	 */
	
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
	@Test(dataProvider = "users")
	public void validatemultipleuser() {
		
	}
	
	@DataProvider(name="users")//name given to data provider if you give name you should use the data with the name complusory not with method name
	public void getuserdata() {
		
	}
	@AfterMethod
	public void closesetup() {
		tearDown();
	}
}
