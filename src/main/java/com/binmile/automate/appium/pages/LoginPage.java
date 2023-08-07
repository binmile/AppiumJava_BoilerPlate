package com.binmile.automate.appium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {

	AppiumDriver appiumDriver;

	public LoginPage(AppiumDriver appDriver) {
		this.appiumDriver = appDriver;
		PageFactory.initElements(new AppiumFieldDecorator(appDriver),this);
	}

	// Page Objects

	@AndroidFindBy(accessibility = "Username input field")
	WebElement username;

	@AndroidFindBy(accessibility = "Password input field")
	WebElement password;

	@AndroidFindBy(accessibility = "Login button")
	WebElement loginBtn;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"generic-error-message\"]/android.widget.TextView")
	WebElement errorMsg;
	
	// Actions

	public void enterUserName(String userN) {
		username.sendKeys(userN);
	}

	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}

	public void clickOnLoginButton() {
		loginBtn.click();
	}

	public String getErrorMsg() {
		return errorMsg.getText();
	}

}
