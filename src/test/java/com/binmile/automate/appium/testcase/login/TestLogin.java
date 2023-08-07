package com.binmile.automate.appium.testcase.login;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.binmile.automate.appium.base.AppiumDriverManager;
import com.binmile.automate.appium.base.TestBase;
import com.binmile.automate.appium.pages.HomePage;
import com.binmile.automate.appium.pages.LoginPage;

public class TestLogin extends TestBase {

	private String userType;
	private String username;
	private String password;
	private HomePage homePage;
	private LoginPage loginPage;

	public TestLogin(String uType, String userN, String pwd) {
		super();
		this.userType = uType;
		this.username = userN;
		this.password = pwd;
	}

	@Test
	public void testUserLogin() {
		homePage = new HomePage(AppiumDriverManager.getDriver());
		homePage.clickOnMenuIcon();
		homePage.clickOnMenuOption_LogIn();
		loginPage = new LoginPage(AppiumDriverManager.getDriver());
		loginPage.enterUserName(username);
		loginPage.enterPassword(password);
		loginPage.clickOnLoginButton();

		switch (userType) {

		case "validUser":
			Assert.assertEquals(homePage.getHeader(), TestConstants_Login.HEADER_LOGIN_SUCCESS,"Login test falied for "+ userType);
			break;

		case "invalidUser":
			Assert.assertEquals(loginPage.getErrorMsg(), TestConstants_Login.MSG_INVALID_USER_ERROR,"Login test falied for "+ userType);
			break;

		case "lockedUser":
			Assert.assertEquals(loginPage.getErrorMsg(), TestConstants_Login.MSG_LOCKED_USER_ERROR,"Login test falied for "+ userType);
			break;

		}

	}

}
