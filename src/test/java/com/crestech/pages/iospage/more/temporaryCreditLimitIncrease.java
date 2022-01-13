package com.crestech.pages.iospage.more;

import java.time.Duration;
import java.util.List;

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
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

/**
 * @author Divya
 *
 */
public class temporaryCreditLimitIncrease extends CommonAppiumTest{
	
	public AppiumDriver<RemoteWebElement> driver = null;
	HandleException obj_handleexception = null;
	GestureUtils gestUtils = null;
	
	public temporaryCreditLimitIncrease(AppiumDriver<RemoteWebElement> driver) throws Exception {
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
	
	@ElementDescription(value = "Temporary Limit Increase header")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Temporary Limit Increase']")
	private MobileElement temporaryLimitIncreaseHeader;
	
	@ElementDescription(value = "next Button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='NEXT']")
	private MobileElement NEXTButton;
	
	@ElementDescription(value = "Review Application header")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Review Application']")
	private MobileElement reviewApplicationHeader;
	
	@ElementDescription(value = "Additional credit limit")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Some placeholder'])[1]/following-sibling::XCUIElementTypeTextField[1]")
	private MobileElement additionalCreditLimit;
	
	@ElementDescription(value = "Done button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Done']")
	private MobileElement doneButton;
	
	@ElementDescription(value = "Purpose List")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText")
	private List<MobileElement> PurposeList;
	
	@ElementDescription(value = "purpose credit limit")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Some placeholder'])[3]/following-sibling::XCUIElementTypeTextField[1]")
	private MobileElement purposeCreditLimit;
	
	@ElementDescription(value = "Select a Purpose")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Select a Purpose']")
	private MobileElement selectPurpose;
	
	@ElementDescription(value = "duration credit limit")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Some placeholder'])[2]/following-sibling::XCUIElementTypeTextField[1]")
	private MobileElement durationCreditLimit;

	@ElementDescription(value = "Calender date 11 oct")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='calendarDayCell.TextLabel_11_selected']")
	private MobileElement calenderDateOctEleven;
	
	@ElementDescription(value = "confirm button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Confirm']")
	private MobileElement confirmButton;

	@ElementDescription(value = "Calender Temporary Limit Increase header")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Pick Date']")
	private MobileElement calenderTemporaryLimitIncreaseHeader;

	@Step("Set Duration for credit Limit Increase")
	public void SetDuration() throws Exception {
		try {
			verifyTempLimitIncreasePageHeader(CommonTestData.TEMP_LIMIT_INCREASE_TITLE.getEnumValue());
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(durationCreditLimit);
			Asserts.assertEquals(getTexOfElement(calenderTemporaryLimitIncreaseHeader).trim().toLowerCase(), CommonTestData.CALENDER_HEADER.getEnumValue().toLowerCase(),CommonTestData.CALENDER_HEADER.getEnumValue()+ " text is not found");
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(calenderDateOctEleven);
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(confirmButton);
			verifyTempLimitIncreasePageHeader(CommonTestData.TEMP_LIMIT_INCREASE_TITLE.getEnumValue());
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Set Duration ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Set Duration ", e);
		}
	}

	@Step("Select Purpose")
	public void SelectPurpose(String purpose) throws Exception {
		try {
			clickOnElement(purposeCreditLimit);

			String actualText = getTexOfElement(selectPurpose).trim();
			Asserts.assertEquals(actualText.toLowerCase(),
					CommonTestData.PURPOSE_HEADER_IOS.getEnumValue().toLowerCase(), "text is not found");

			if (PurposeList.size() > 0) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				int l = PurposeList.size();
				int index = 0;
				String purposedFromList = null;
				for (int i = 0; i < l; i++) {
					purposedFromList = PurposeList.get(i).getText();
					if (purposedFromList.equalsIgnoreCase(purpose)) {
						index++;
						clickOnElement(PurposeList.get(i));
						break;
					}
				}
				if (index == 0)
					Asserts.assertFail("Purpose " + purpose + " Not Found in the list.");
			} else
				Asserts.assertFail("Purpose " + purpose + " not found in the list as list size is 0");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select Purpose ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Enter Amount ", e);
		}
	}
	
	@Step("click on done button")
	public void ClickOnDoneButton() throws Exception {
		try {
			if (isElementVisible2(doneButton))
				clickOnElement(doneButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to click on done button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to click on done button ", e);
		}
	}
	
	@Step("Enter Amount")
	public void EnterAmount(String Amount) throws Exception {
		try {
			enterTextInTextbox(additionalCreditLimit, Amount);
		    ClickOnDoneButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Enter Amount ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Enter Amount ", e);
		}
	}
	
	@Step("Verify 'Review Application' page header")
	public void verifyReviewApplicationPageHeader(String expectedText) throws Exception {
		try {
			wait.fluentWaitForElement(reviewApplicationHeader);
			Asserts.assertEquals(getTexOfElement(reviewApplicationHeader).trim().toLowerCase(), expectedText.toLowerCase(),expectedText + " text is not found");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION"," Failed to verify 'Review Application' page header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION"," Failed to verify 'Review Application' page header ", e);
		}
	}
	
	@Step("Click On Next Button")
	public void ClickOnNEXTButton() throws Exception {
		try {
			gestUtils.scrollUPtoObjectIos("name", "NEXT", null );
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(NEXTButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to click on next button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to click on next button ", e);
		}
	}
	
	@Step("Verify 'Temp Limit Increase' page header")
	public void verifyTempLimitIncreasePageHeader(String expectedText) throws Exception {
		try {
				wait.fluentWaitForElement(temporaryLimitIncreaseHeader);
				Asserts.assertEquals(getTexOfElement(temporaryLimitIncreaseHeader).trim().toLowerCase(), expectedText.toLowerCase(), expectedText + " text is not found");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION"," Failed to verify 'Temp Limit Increase' page header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION"," Failed to verify 'Temp Limit Increase' page header ", e);
		}
	}

}
