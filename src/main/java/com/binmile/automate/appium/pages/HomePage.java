package com.binmile.automate.appium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {

	AppiumDriver appiumDriver;
	
	public HomePage(AppiumDriver appDriver) {
		this.appiumDriver = appDriver;
		PageFactory.initElements(new AppiumFieldDecorator(appDriver),this);
	}
	
	//Page Objects
	@AndroidFindBy(accessibility = "open menu")
	WebElement menuIcon;
	
	@AndroidFindBy(accessibility = "menu item log in")
	WebElement menuOption_LogIn;

	@AndroidFindBy(accessibility = "menu item log in")
	WebElement menuOption_LogOut;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"container header\"]/android.widget.TextView")
	WebElement header;
	
	//Actions
	public void clickOnMenuIcon() {
		menuIcon.click();	
	}
	
	public void clickOnMenuOption_LogIn() {
		menuOption_LogIn.click();	
	}

	public void clickOnMenuOption_LogOut() {
		menuOption_LogOut.click();
		
	}
	
	public String getHeader() {
		return header.getText();
	}

}
