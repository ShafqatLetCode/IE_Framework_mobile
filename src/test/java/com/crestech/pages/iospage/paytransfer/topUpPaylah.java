package com.crestech.pages.iospage.paytransfer;

import java.time.Duration;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crestech.annotation.values.ElementDescription;
import com.crestech.appium.utils.CommonAppiumTest;
import com.crestech.common.utilities.Asserts;
import com.crestech.common.utilities.GestureUtils;
import com.crestech.common.utilities.HandleException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

/**
 * @author Divya
 *
 */
public class topUpPaylah extends CommonAppiumTest{
	
	public AppiumDriver<RemoteWebElement> driver = null;
	HandleException obj_handleexception = null;
	GestureUtils gestUtils = null;
	
	public topUpPaylah(AppiumDriver<RemoteWebElement> driver) throws Exception {
		super(driver);
		try {
			this.driver = driver;
			obj_handleexception = new HandleException(null, null);
			gestUtils = new GestureUtils(driver);
			PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@ElementDescription(value = "paylah button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='TopUp_Option_Paylah!_Label']")
	private MobileElement payLahButton;
	
	@ElementDescription(value = "Done button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Done']")
	private MobileElement doneButton;
	
	@ElementDescription(value = "Amount Editbox")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='TopUp_Paylah_Amount_Field']")
	private MobileElement amountEditBox;
	
	@ElementDescription(value = "Next Button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='NEXT']")
	private MobileElement nextButton;
	
	@ElementDescription(value = "Review Top Up header")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Review Top-Up']")
	private MobileElement reviewToUpLabel;
	
	@ElementDescription(value = "TopUp Now button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='TopUp_Paylah_TOP UP NOW_Button']")
	private MobileElement topupNowButton;
	
	@ElementDescription(value = "Logout button on paylah")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Log Out']")
	private MobileElement logoutPaylah;
	
	@Step("Click On Topup LogOutButton")
	public void ClickOnTopupLogOutButton() throws Exception {
		try {
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(logoutPaylah);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to click on LogOut Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to click on LogOut Button  ", e);
		}
	}
	
	@Step("Click On Top Up Now Button")
	public void ClickOnTopUpNowButton() throws Exception {
		try {
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(topupNowButton);
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to verify click on TopUp Now Button  ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to verify click on TopUp Now Button  ",e);
		}
	}
	
	@Step("Verify 'Top Up Paylah Label' field")
	public void verifyTopUpReview(String expectedText) throws Exception {
		try {
			Asserts.assertEquals(getTexOfElement(reviewToUpLabel).trim().toLowerCase(), expectedText.toLowerCase(), expectedText+ " text is not matching.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FIELDVERIFICATION_EXCEPTION"," Failed to verify fileds:TopUp Label and Enter Amount  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FIELDVERIFICATION_EXCEPTION"," Failed to verify fileds:TopUp Label and Enter Amount  ", e);
		}
	}
	
	@Step("Click On Next Button")
	public void ClickOnNextButton() throws Exception {
		try {
			    com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				clickOnElement(nextButton);
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Next Button ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Next Button ",e);
		}
	}

	@Step("Enter currency")
	public void EnterCurrency(String text) throws HandleException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60); 
			wait.until(ExpectedConditions.or(
				    ExpectedConditions.presenceOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND name == 'SGD'  AND visible== 1")),
				    ExpectedConditions.presenceOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND name == 'SGD'  AND visible== 0"))));
			
			enterTextInTextbox(amountEditBox, text);
			if(isElementVisible2(doneButton))
				clickOnElement(doneButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to enter currency  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to enter currency  ", e);
		}
	}

	@Step("Click On Paylah")
	public void ClickOnPaylah() throws Exception {
		try {
			wait.waitForElementToBeClickable(payLahButton);
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(payLahButton);
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Paylah ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Paylah  ",e);
		}
	}


}
