package com.excelr.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OHRMbase {
	public static WebDriver driver;
	public static Properties prop;
	
	public void initialization() {
		loadconfigfile();
		//read the browser value
		String browser = prop.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void captureScreenshot(String tcname) {
		String filepath="./framework/screenshot/"+tcname+".png";
		TakesScreenshot ts=(TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File(filepath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void loadconfigfile() {
		prop = new Properties();
		FileInputStream fis;
		String proppath ="./src/main/java/com/excelr/config/config.properties";
		try {
			 fis = new FileInputStream(proppath);
			 prop.load(fis);
		} catch (FileNotFoundException e) {
			System.out.println("property file not found");
		} catch (IOException e) {
			System.out.println("unable to read the property file");
		}

	}
	public void tearDown() {
		driver.quit();
	}
}
