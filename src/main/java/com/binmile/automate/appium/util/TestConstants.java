package com.binmile.automate.appium.util;

import java.io.File;

public class TestConstants {
	public static final int IMPLICIT_WAIT_TIME = 10;
	public static final int PAGE_WAIT_TIME = 5;
	
	public static String CONFIG_PROPERTIES_FILE_PATH = System.getProperty("user.dir") + File.separator + "src"
			+ File.separator + "main" + File.separator + "resources" + File.separator + "config.properties";
	public static String EXTENT_REPORT_FILE_PATH = System.getProperty("user.dir") + File.separator + "ExtentReport"
			+ File.separator + "extentReport" + "_" + System.currentTimeMillis() + ".html";

}
