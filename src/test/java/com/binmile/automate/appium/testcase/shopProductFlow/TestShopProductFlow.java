package com.binmile.automate.appium.testcase.shopProductFlow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.binmile.automate.appium.base.AppiumDriverManager;
import com.binmile.automate.appium.base.TestBase;
import com.binmile.automate.appium.pages.HomePage;
import com.binmile.automate.appium.pages.LoginPage;
import com.binmile.automate.appium.util.CSVUtility;
import com.binmile.automate.appium.util.Utilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class TestShopProductFlow extends TestBase {
	
	private HomePage homePage;
	private LoginPage loginPage;
	
	@Test(dataProvider = "testdata")
	public void shoppingForProductFlow(String username,String password,String productName) {
		login(username,password);
		//scrollToProductNClick(productName);
	}	
 
	
	


	private void login(String username,String password) {
		homePage = new HomePage(AppiumDriverManager.getDriver());
		homePage.clickOnMenuIcon();
		homePage.clickOnMenuOption_LogIn();
		loginPage = new LoginPage(AppiumDriverManager.getDriver());
		loginPage.enterUserName(username);
		loginPage.enterPassword(password);
		loginPage.clickOnLoginButton();
	}
	
	
	@DataProvider(name = "testdata")
	public Object[][] readTestData_ShopProductFlow(){
		return CSVUtility.readDataFromCSV("TestData_ShopProductFlow.csv");
	}
}
