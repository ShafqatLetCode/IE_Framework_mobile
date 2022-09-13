package com.crestech.pages.androidpage.paytransfer;

import java.time.Duration;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import com.crestech.annotation.values.ElementDescription;
import com.crestech.appium.utils.CommonAppiumTest;
import com.crestech.common.utilities.Asserts;
import com.crestech.common.utilities.CommonTestData;
import com.crestech.common.utilities.GestureUtils;
import com.crestech.common.utilities.HandleException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
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
	
	@ElementDescription(value = "Top Up Paylah! label")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Top Up Paylah!']")
	private MobileElement topUpPaylahLabel;
	
	@ElementDescription(value = "Paylah! label")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Paylah!']")
	private MobileElement paylahLabel;
	
	@ElementDescription(value = "Currency Field")
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'id/currencyText')]")
	private MobileElement currencyField;

	@ElementDescription(value = "Next button")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='NEXT']")
	private MobileElement nextButton;

	@ElementDescription(value = "Review Top up label")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Review Top-Up']")
	private MobileElement reviewTopUpLabel;

	@ElementDescription(value = "Amount display for Topup")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'id/card_amount')]")
	private MobileElement displayAmount;
	
	@ElementDescription(value = "Top up done label")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Top-up Done']")
	private MobileElement topUpDoneLabel;
	
	@ElementDescription(value = "TOP UP NOW button")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='TOP UP NOW']")
	private MobileElement topUpNowButton;

	@ElementDescription(value = "Logout paylah button")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/logout_icon')]")
	private MobileElement logOutPaylahButton;

	@Step("Click On Topup LogOutButton")
	public void ClickOnTopupLogOutButton() throws Exception {
		try {
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(logOutPaylahButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to click on LogOut Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to click on LogOut Button  ", e);
		}
	}
	
	@Step("click On TOP UP NOW Button and then Verify 'Top-up Done' field and Display Amount")
	public void ClickOnTopUpNowButton() throws Exception {
		try {
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(topUpNowButton);
			
			wait.fluentWaitForElement(topUpDoneLabel); 
			Asserts.assertEquals(getTexOfElement(topUpDoneLabel),
					CommonTestData.TOPUP_UP_DONE_LABEL.getEnumValue(), "'Top-up Done' Text is not found");
			Asserts.assertEquals(getTexOfElement(displayAmount),
					CommonTestData.AMOUNT_PAYLAH.getEnumValue(), "'Display Amount' is incorrect");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to verify click on TopUp Now Button and Top-up Done field and Display amount  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to verify click on TopUp Now Button and Top-up Done field and Display amount  ", e);
		}
	}

	@Step("Verify 'Top Up Paylah Label' field And Verify 'Enter Amount' field")
	public void verifyTopUpReview(String expectedText) throws Exception {
		try {
			wait.waitForElementVisibility(reviewTopUpLabel);
			Asserts.assertEquals(getTexOfElement(reviewTopUpLabel), expectedText,
					"'Top Up Paylah' Text is not found");
			Asserts.assertEquals(getTexOfElement(displayAmount),
					CommonTestData.AMOUNT_PAYLAH.getEnumValue(), "'Display Amount' is incorrect");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FIELDVERIFICATION_EXCEPTION"," Failed to verify fileds:TopUp Label and Enter Amount  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FIELDVERIFICATION_EXCEPTION"," Failed to verify fileds:TopUp Label and Enter Amount  ", e);
		}
	}
	
	@Step("Click On Next Button.")
	public void ClickOnNextButton() throws Exception {
		try {
				gestUtils.scrollUPtoObject("text", "NEXT", nextButton);
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				clickOnElement(nextButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Next Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Next Button  ", e);
		}
	}
	@Step("Enter currency")
	public void EnterCurrency(String text) throws Exception {
		try {
			enterTextInTextbox(currencyField, text);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to enter currency   ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to enter currency  ", e);
		}
	}

	@Step("Click On Paylah and then verify Top Up Paylah label")
	public void ClickOnPaylah(String expectecText) throws Exception {
		try {
			wait.waitForElementToBeClickable(paylahLabel); 
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(paylahLabel);
			Asserts.assertEquals(getTexOfElement(topUpPaylahLabel),
					CommonTestData.TOPUP_PAYLAH_LABEL.getEnumValue(), "'Top Up Paylah' Text is not found");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to verify Paylah label and click  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to verify Paylah label and click  ", e);
		}
	}

}
