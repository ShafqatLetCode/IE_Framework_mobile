package com.crestech.pageobjects;

import java.time.Duration;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import com.crestech.annotation.values.ElementDescription;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

/**
 * 
 * @author Shibu Prasad Panda
 * 
 *         This class is used to store the objects of IOS Page.
 *
 */
public class DBS_IOSObject {

	@ElementDescription(value = "Email id Button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='Email']")
	private MobileElement emailID;
	
	@ElementDescription(value = "Password Button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Password']")
	private MobileElement password;

	@ElementDescription(value = "login Button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='SIGN IN']")
	private MobileElement logIn;
	
	public DBS_IOSObject(AppiumDriver<RemoteWebElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
	}

	public MobileElement getPassword() {
		return password;
	}

	public MobileElement getLogIn() {
		return logIn;
	}

	public MobileElement getEmailID() {
		return emailID;
	}
	 public void setEmailID(String textToEnter) {
		 emailID.sendKeys(textToEnter);
	 }
	 
	 public void setPassword(String textToEnter) {
		 password.sendKeys(textToEnter);
	 }
	 
	 public void clickOnLogin() {
		 logIn.click();
	 }

}
