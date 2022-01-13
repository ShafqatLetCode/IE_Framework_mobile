package com.crestech.pages.iospage;

import java.time.Duration;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import com.crestech.annotation.values.ElementDescription;
import com.crestech.appium.utils.CommonAppiumTest;
import com.crestech.common.utilities.HandleException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

/**
 * @author Divya
 *
 */
public class launchPage extends CommonAppiumTest{
	
	public AppiumDriver<RemoteWebElement> driver = null;
	HandleException obj_handleexception = null;
	
	
	public launchPage(AppiumDriver<RemoteWebElement> driver) throws Exception {
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

	@ElementDescription(value = "Pre login button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='PRE LOGIN']")
	private MobileElement preLoginButton;
	
	@ElementDescription(value = "More on Prelogin")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='More']")
	private MobileElement moreOnPreLogin;

	@ElementDescription(value = "DBS digibank” Would Like to Send You Notifications")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert[@name='“DBS digibank” Would Like to Send You Notifications']")
	private MobileElement sendNotificationAlert;
	
	@ElementDescription(value = "Allow “DBS digibank” to use your location?")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert[@name='Allow “DBS digibank” to use your location?']")
	private MobileElement atmLocationAlert;
	
	@ElementDescription(value = "localNetworkAlert")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert[@name='“DBS digibank” would like to find and connect to devices on your local network.']")
	private MobileElement localNetworkAlert;

	@Step("Click on Alert DBS digibank” would like to find and connect to devices on your local network.")
	public void localNetworkAlert() throws Exception {
		try {
			if(isElementVisible2(localNetworkAlert)) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				driver.findElementByName("OK").click();	
			}
		}  catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Alert ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Alert ", e);
		}
	}
	
	@Step("Clicked on Alert Allow “DBS digibank” to use your location?")
	public void atmLocationAlert() throws Exception {
		try {
			if(isElementVisible2(atmLocationAlert))
				driver.findElementByName("Allow While Using App").click();

		}  catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Alert ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Alert ", e);
		}
	}
	
	@Step("Clicked on Alert DBS digibank” Would Like to Send You Notifications")
	public void sendNotificationAlert() throws Exception {
		try {
			if(isElementVisible2(sendNotificationAlert)) 
				driver.findElementByName("Allow").click();
				
		}  catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Alert ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Alert ", e);
		}
	}
	
	@Step("Clicked on Pre-Login button")
	public void ClickOnPreloginButton() throws Exception {
		try {
			if(isElementVisible2(preLoginButton))
			{
			int count = 0;
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			do {
				clickOnElement(preLoginButton);
				count++;
			} while (!isElementVisible2(moreOnPreLogin) && count < 3);
			}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Prelogin Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Prelogin Button ", e);
		}
	}
}
