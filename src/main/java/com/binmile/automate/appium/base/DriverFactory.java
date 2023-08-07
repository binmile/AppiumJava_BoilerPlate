package com.binmile.automate.appium.base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import com.binmile.automate.appium.util.TestConstants;
import com.binmile.automate.appium.util.Utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

public class DriverFactory{
	
	private static AppiumDriver appDriver = null;
	
	public static void initializeDriver(){
		Properties properties = Utilities.loadConfigProperties(TestConstants.CONFIG_PROPERTIES_FILE_PATH);
		String appURL = System.getProperty("user.dir") + File.separator + "src" + File.separator
				+ "main" + File.separator + "resources" + File.separator + "builds" + File.separator
				+ properties.getProperty("appName")
				+ ".apk";
		try {
			URL url = new URI("http://0.0.0.0:4723").toURL();
			
			String platformName = properties.getProperty("platformName");

			switch(platformName) {
					
			case "Android":
				UiAutomator2Options options = new UiAutomator2Options();
				options.setPlatformName(properties.getProperty("platformName"))
					   .setPlatformVersion(properties.getProperty("platformVersion"))
				       .setAutomationName(properties.getProperty("automationName"))
				       .setDeviceName(properties.getProperty("deviceName"))
				       .setUdid(properties.getProperty("UDID"))
				       .setApp(appURL)
				       .setAppPackage(properties.getProperty("appPackage"))
				       .setAppActivity(properties.getProperty("appActivity"))
				       .setNoReset(Boolean.FALSE)
				       .setNewCommandTimeout(Duration.ofSeconds(20));
				
				appDriver =  new AndroidDriver(url,options);
				break;
				
				
			case "iOS": 
				XCUITestOptions xoptions = new XCUITestOptions();
				xoptions.setDeviceName(properties.getProperty("deviceName"))
						.setUdid(properties.getProperty("UDID"))
						.setApp(appURL)
						.setNoReset(Boolean.FALSE)
						.setNewCommandTimeout(Duration.ofSeconds(20));
				
				appDriver =  new IOSDriver(url,xoptions);
				break;
			}
			
			AppiumDriverManager.setDriver(appDriver);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Exception caught while initializing driver");
			e.printStackTrace();
		} 
		
		
	} 

}


