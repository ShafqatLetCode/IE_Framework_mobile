package com.ie.pages.iospage;

import java.time.Duration;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ie.annotation.values.ElementDescription;
import com.ie.appium.utils.CommonAppiumTest;
import com.ie.common.utilities.Asserts;
import com.ie.common.utilities.HandleException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

/**
 * @author Shafqat
 *
 */
public class ePaperPage extends CommonAppiumTest{
	
	HandleException obj_handleexception = null;
	Asserts Assert = null;
	
	public ePaperPage(AppiumDriver<RemoteWebElement> driver) throws Exception {
		super(driver);
		try {
			this.driver = driver;
			obj_handleexception = new HandleException(null, null);
			Assert = new Asserts();
			PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Step("Verifying news header")
	public void verifyingEpaperNewsHeader() throws Exception {
		try {
			wait.waitForElement(newsLetterHeader, 
					5,
					"news Letter Header",
					"verifiying on News Header"
				);
			
			String getTitle=newsLetterHeader.getText().toString().toLowerCase();
			//Assert.assertContains(getTitle,"Your newstand");
			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to verify epaper header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to verify epaper header ", e);
		}
	}
	
	@ElementDescription(value = "paywall text")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"Login to access\")]")
	private MobileElement paywallBehinedText;
	
	
	@ElementDescription(value = "paywall text")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"Today's ePaper\")]")
	private MobileElement newsLetterHeader;
	
	
//	@ElementDescription(value = "tap on star field message")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Tap on the stars to rate']")
//	private MobileElement tapOnStarMessage;
	
//	@ElementDescription(value = "'Close' Button After adding Payee")
//	@FindBy(name = "close")
//	private MobileElement closeButton;
	
	@ElementDescription(value = "paywall text")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"Sorry, your email\")]")
	private MobileElement paywallText;
	
	@ElementDescription(value = "Choose plan button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"CHOOSE PLAN\"]")
	private MobileElement choosePlanButton;
	
	@ElementDescription(value = "Login button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,\"SIGN IN\")]")
	private MobileElement loginButton;
	
	@Step("Verifying pay wall on epaper")
	public void verifyingEpaperWall() throws Exception {
		try {
			wait.waitForElement(paywallText, 
					5,
					"Paywall Text",
					"verifiying on Epaper"
				);
			
			String getTitle=paywallText.getText().toString().toLowerCase();
			//Assert.assertContains(getTitle,"E-paper subscription not found");
			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to verify epaper wall ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to verify epaper wall  ", e);
		}
	}
	
	@Step("Verifying pay wall on epaper")
	public void verifyingEpaperWalltitle() throws Exception {
		try {
			wait.waitForElement(paywallBehinedText, 
					5,
					"Paywall Text",
					"verifiying on Epaper"
				);
			
			String getTitle=paywallBehinedText.getText().toString().toLowerCase();
			Assert.assertContains(getTitle,"Login to access The Indian Express E-Paper");
			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to verify epaper wall ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to verify epaper wall  ", e);
		}
	}
	
	@Step("Click on epaper login")
	public void ClickonLoginOnEpaper() throws Exception {
		try {
				wait.waitForElement(loginButton, 
						5,
						"login button",
						"Login from epaper"
					);
			
				clickOn(loginButton, 
						"login button",
						"Login from epaper"
					);
			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Click on epaper login  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Click on epaper login ", e);
		}
	}
	
//	@Step("Click on 'Close' Button.")
//	public void ClickOnCloseButton() throws Exception {
//		try {
//			if(isElementVisible2(closeButton)) {
//				com.ie.listeners.TestListener.saveScreenshotPNG(driver);
//				clickOnElement(closeButton);
//		}
//		} catch (HandleException e) {
//			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Click on 'Close' Button  ",	e);
//		} catch (Exception e) {
//			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Click on 'Close' Button ", e);
//		}
//	}
//	
//	@Step("verify 'Tap On The Stars To Rate' Message")
//	public void verifyTapOnTheStarsToRate(String Ratingmsg) throws Exception {
//		try {
//			Asserts.assertEquals(getTexOfElement(tapOnStarMessage), Ratingmsg,
//					"'Tap on the stars to rate' Text is not found");
//		} catch (HandleException e) {
//			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to verify 'Tap On The Stars To Rate' Message ", e);
//		} catch (Exception e) {
//			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to verify 'Tap On The Stars To Rate' Message ", e);
//		}
//	}

}
