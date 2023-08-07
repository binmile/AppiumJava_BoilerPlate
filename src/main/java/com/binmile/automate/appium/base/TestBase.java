package com.binmile.automate.appium.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

	@BeforeMethod
	public void launchApp(){
		DriverFactory.initializeDriver();
		System.out.println("Appium Driver Launched");
	}
	
	@AfterMethod
	public void tearDown() {
		if (AppiumDriverManager.getDriver() != null) {
			AppiumDriverManager.getDriver().quit();
			System.out.println("Tear Down completed");
		}
	
	}
}
