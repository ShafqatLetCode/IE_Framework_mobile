package com.crestech.pages.iospage;

import java.time.Duration;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crestech.annotation.values.ElementDescription;
import com.crestech.appium.utils.CommonAppiumTest;
import com.crestech.common.utilities.Asserts;
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
public class ratingPage extends CommonAppiumTest{
	
	HandleException obj_handleexception = null;
	Asserts Assert = null;
	
	public ratingPage(AppiumDriver<RemoteWebElement> driver) throws Exception {
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
	
	@ElementDescription(value = "tap on star field message")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Tap on the stars to rate']")
	private MobileElement tapOnStarMessage;
	
	@ElementDescription(value = "'Close' Button After adding Payee")
	@FindBy(name = "close")
	private MobileElement closeButton;
	
	@Step("Click on 'Close' Button.")
	public void ClickOnCloseButton() throws Exception {
		try {
			if(isElementVisible2(closeButton)) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				clickOnElement(closeButton);
		}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Click on 'Close' Button  ",	e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Click on 'Close' Button ", e);
		}
	}
	
	@Step("verify 'Tap On The Stars To Rate' Message")
	public void verifyTapOnTheStarsToRate(String Ratingmsg) throws Exception {
		try {
			Asserts.assertEquals(getTexOfElement(tapOnStarMessage), Ratingmsg,
					"'Tap on the stars to rate' Text is not found");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to verify 'Tap On The Stars To Rate' Message ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to verify 'Tap On The Stars To Rate' Message ", e);
		}
	}

}
