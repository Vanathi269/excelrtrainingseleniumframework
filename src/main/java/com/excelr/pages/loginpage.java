package com.excelr.pages;

import org.openqa.selenium.By;

import com.excelr.base.OHRMbase;

public class loginpage extends OHRMbase {
	public String getTitle() {
		return driver.getTitle();
	}

	public dashboardpage login() {
		driver.findElement(By.name("username")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.name("password")).sendKeys(prop.getProperty("password"));
		captureScreenshot("login");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		return new dashboardpage();
	}
}
