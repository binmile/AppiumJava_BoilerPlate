package com.binmile.automate.appium.base;

import io.appium.java_client.AppiumDriver;

public class AppiumDriverManager {

	private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<AppiumDriver>();

	public static synchronized AppiumDriver getDriver() {
		return driver.get();
	}

	public static synchronized void setDriver(AppiumDriver appDriver) {
		driver.set(appDriver);
		System.out.println("Appium Driver is set");
	}
}
