package com.crestech.pages.iospage.more;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crestech.annotation.values.ElementDescription;
import com.crestech.appium.utils.CommonAppiumTest;
import com.crestech.common.utilities.Asserts;
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
public class peekBalance extends CommonAppiumTest{
	
	public AppiumDriver<RemoteWebElement> driver = null;
	HandleException obj_handleexception = null;
	GestureUtils gestUtils = null;
	
	public peekBalance(AppiumDriver<RemoteWebElement> driver) throws Exception {
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
	
	@ElementDescription(value = "back button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='back']")
	private MobileElement backButton;
	
	@ElementDescription(value = "Personalise Your Device")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert[@name='Personalise Your Device']")
	private MobileElement PersonalizeYourDevicePopup;
	
	@ElementDescription(value = "alert ok button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='OK']")
	private MobileElement alertOkButton;
	
	@ElementDescription(value = "back button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Save']")
	private MobileElement SaveBtn;
	
	@ElementDescription(value = "Peek Balance Toggle")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name='Peek Balance']")
	private MobileElement PeekBalanceToggle;
	
//	@ElementDescription(value = "Account For Peek Balance Dropdown")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[2]/XCUIElementTypeTextField")
//	private MobileElement AccountForPeekBalanceDropdown;
	
	@ElementDescription(value = "Account For Peek Balance Dropdown")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='See your account balance and last three transactions without logging in. Learn more']/preceding-sibling::XCUIElementTypeCell[1]")
	private MobileElement AccountForPeekBalanceDropdown;
	
	@ElementDescription(value = "Existing Personalization will be removed, Do you want to proceed?")
	@FindBy(name = "Existing Personalisation will be removed. Do you want to proceed?")
	private MobileElement persoanliseMessage;
	
	@Step("Handle Confirmation Message")
	public void handleConfirmationMessage() throws Exception {
		try {
			if (isElementVisible2(persoanliseMessage)) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				clickOnElement(alertOkButton);
			}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Handle Confirmation Message ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Handle Confirmation Message ", e);
		}
	}
	
	@Step("Enable Peek balance Toggle.")
	public void EnablePeekBalanceToggle() throws Exception {
		try {
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(PeekBalanceToggle);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Enable Peek balance Toggle. ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Enable Peek balance Toggle.  ", e);
		}
	}

	@Step("Select Account To Enable Peek Balance.")
	public void SelectAccountToEnablePeekBalance(String ExpectedUserAccountName) throws Exception {
		try {
			clickOnElement(AccountForPeekBalanceDropdown);
			String xpath = "//XCUIElementTypeStaticText[@name='" + ExpectedUserAccountName + "']";
			MobileElement selectAccount = (MobileElement) driver.findElement(By.xpath(xpath));
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(selectAccount);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Select Account To Enable Peek Balance ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Select Account To Enable Peek Balance  ", e);
		}
	}
	
	@Step("verify Selected Account For Peek Balance")
	public void verifySelectedAccountForPeekBalance(String AccountTitle, String SelectedAccountNameWithAccountNumber)
			throws Exception {
		try {
			String xpath = "//XCUIElementTypeCell[2]/XCUIElementTypeStaticText";
			String Text = driver.findElementByXPath(xpath).getText();
			System.out.println("SelectedAccountNameWithAccountNumber " + Text);
			Asserts.assertEquals(Text, SelectedAccountNameWithAccountNumber,
					SelectedAccountNameWithAccountNumber + " Text is not matching.");
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to verify Selected Account For Peek Balance ", e);
		}
	}
	
	@Step("Click On Save Button.")
	public void ClickOnSaveButton() throws Exception {
		try {
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(SaveBtn);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Save Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Save Button  ", e);
		}
	}
	
	@Step("Click On Ok Button After Displaying Personalize Your Device Popup.")
	public void ClickOnOkButtonInPersonalizeYourDevicePopup() throws Exception {
		try {
			if (isElementVisible2(PersonalizeYourDevicePopup)) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				clickOnElement(alertOkButton);
			}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Click On Ok Button After Displaying PersonalizeYourDevicePopup ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Click On Ok Button After Displaying PersonalizeYourDevicePopup ", e);
		}
	}
	
	@Step("Click On Back Button")
	public void ClickOnBackButtonImageView() throws Exception {
		try {
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(backButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to click on Back Button. ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to click on Back Button. ", e);
		}
	}

}
