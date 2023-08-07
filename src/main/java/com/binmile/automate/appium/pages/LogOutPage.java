package com.binmile.automate.appium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LogOutPage {

	AppiumDriver appiumDriver;
	
	public LogOutPage(AppiumDriver appDriver) {
		this.appiumDriver = appDriver;
		PageFactory.initElements(new AppiumFieldDecorator(appDriver),this);
	}
	
	// Page Objects

		@AndroidFindBy(id="android:id/message")
		WebElement logOutComfirmationAlert;

		@AndroidFindBy(id = "android:id/button1")
		WebElement logOutBtn;

		@AndroidFindBy(id = "android:id/button2")
		WebElement cancelBtn;

		@AndroidFindBy(id = "android:id/alertTitle")
		WebElement successfulLogoutMsg;
		
		@AndroidFindBy(xpath ="//*[@text='OK']")
		WebElement okBtn;

		// Actions

		public String getLogOutComfirmationAlert() {
			return logOutComfirmationAlert.getText();
		}

		public void clickOnLogOutButton() {
			logOutBtn.click();
		}

		public void clickOnCancelButton() {
			cancelBtn.click();
		}
		
		public void clickOnOkButton() {
			okBtn.click();
		}
		
		public String getSuccessfulLogoutMsg() {
			return successfulLogoutMsg.getText();
		}
		
}
