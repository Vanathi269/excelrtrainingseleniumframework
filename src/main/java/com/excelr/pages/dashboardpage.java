package com.excelr.pages;

import org.openqa.selenium.By;

import com.excelr.base.OHRMbase;

public class dashboardpage extends OHRMbase {
	public boolean dashboardleftmenu() {
		 return driver.findElement(By.xpath("//span[text()='dashboard']")).isDisplayed();
		}
	public boolean quicklaunchsection() {
		 return driver.findElement(By.xpath("//p[text()='Quick Launch']")).isDisplayed();
	}
	public boolean myactionsection() {
		 return driver.findElement(By.xpath("//p[text()='My Action']")).isDisplayed();
	}
}
