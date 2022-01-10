package com.crestech.pages.iospage;

import java.time.Duration;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crestech.annotation.values.ElementDescription;
import com.crestech.appium.utils.CommonAppiumTest;
import com.crestech.common.utilities.HandleException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class loginPage extends CommonAppiumTest{

	public AppiumDriver<RemoteWebElement> driver = null;
	HandleException obj_handleexception = null;

	public loginPage(AppiumDriver<RemoteWebElement> driver) throws Exception {
		super(driver);
		try {
			this.driver = driver;
		    obj_handleexception = new HandleException(null, null);
			PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@ElementDescription(value = "login Button on LogIn Page")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='LOGIN']")
	private MobileElement logInButton_OnLogInPage;
	
	@ElementDescription(value = "User id EditBox")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='User ID']")
	private MobileElement userIdEditBox;

	@ElementDescription(value = "User Pin EditBox")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='PIN']")
	private MobileElement userPinEditBox;
	
	@ElementDescription(value = "Not you?")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Not you?']")
	private MobileElement NotYouLink;
	
	@ElementDescription(value = "Deregister your profile?")
	@FindBy(name = "Deregister your profile?")
	private MobileElement DeregisteryourprofileAlert;
	
	@ElementDescription(value = "Not you?")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Deregister']")
	private MobileElement PeekbalanceDeregisterButton;

	@Step("Click On Deregister Button.")
	public void ClickOnDeregisterButtonInDigiAlertPopup(String peekBalanceDeregisterMsg) throws Exception {
		try {
			if (isElementVisible2(DeregisteryourprofileAlert))
				clickOnElement(PeekbalanceDeregisterButton);

		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Deregister Button ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Deregister Button  ", e);
		}
	}
	
	
	@Step("Click on Login button")
	public void clickOnLoginButton() throws Exception {
		try {
			clickOnElement(logInButton_OnLogInPage);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Login Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Login Button ", e);
		}
	}
	
	@Step("LogIn Application")
	public void EnterCredentialsAndLogin(String userName, String password) throws Exception {
		try {
			enterUserName(userName);
			enterPassword(password);
			clickOnLoginButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Login Application ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Login Application ", e);
		}
	}
	
	@Step("Enter User name")
	public void enterUserName(String text) throws Exception {
		try {
			enterTextInTextbox(userIdEditBox, text);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Enter User name ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Enter User name ", e);
		}
	}

	@Step("Enter Password")
	public void enterPassword(String text) throws Exception {
		try {
			enterTextInTextbox(userPinEditBox, text);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Enter Password ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Enter Password ", e);
		}
	}
	
	@Step("Click On Not You Link Button.")
	public void ClickOnNOTYouLink() throws Exception {
		try {
			if(isElementVisible2(NotYouLink))
				clickOnElement(NotYouLink);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Not You Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Not You Button  ", e);
		}
	}
	
	
}
