package com.binmile.automate.appium.testcase.login;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import com.binmile.automate.appium.util.CSVUtility;

public class UserFactory {
	
	
	@Factory(dataProvider ="readTestData_UserCredentials")
	public Object[] createUser(String userType,String username, String password) {
		return new Object[] {new TestLogin(userType,username,password)};
	}
	
	@DataProvider
	public Object[][] readTestData_UserCredentials() {
		return CSVUtility.readDataFromCSV("TestData_UserCredentials");
	}
}