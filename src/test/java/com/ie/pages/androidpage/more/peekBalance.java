package com.crestech.pages.androidpage.more;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
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
	

	@ElementDescription(value = "Peek balance Toggle")
	@AndroidFindBy(xpath = "//android.widget.Switch[contains(@resource-id,':id/btn_switch')]")
	private MobileElement PeekBalanceToggle;
	
	@ElementDescription(value = "Account for Peek Balance Dropdown.")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Account for Peek Balance']")
	private MobileElement AccountForPeekBalanceDropdown;
	
	@ElementDescription(value = "Selected Account For Peek Balance.")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/dropdown_pb_acc')]")
	private List<MobileElement> SelectedAccountForPeekBalance;
	
	@ElementDescription(value = "Save Button to Save Peek Balance on login page.")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Save']")
	private MobileElement SaveBtn;
	
	@ElementDescription(value = "Personalize Your Device Pop Up.")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Personalize Your Device']")
	private MobileElement PersonalizeYourDevicePopup;
	
	@ElementDescription(value = "OKBtn Personalize Your Device Pop Up.")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='OK']")
	private MobileElement OKBtn_PersonalizeYourDevicePopup;
	
	@ElementDescription(value = "Contact Search Field")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/contact_search')]")
	private MobileElement ContactSearchfield;
	
	@ElementDescription(value = "Edit Text Search Box")
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,':id/search_text_et')]")
	private MobileElement EditTextSearchBox;
	
	@ElementDescription(value = "Error Messge Element")
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='android:id/message']")
	private MobileElement ErrorMessgeElement;
	
	@ElementDescription(value = "OK Button")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
	private MobileElement OKButton;
	
	@ElementDescription(value = "Back Btn Image View")
	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,':id/back_btn')]")
	private MobileElement BackBtnImageView;

	@Step("Click On Back Button")
	public void ClickOnBackButtonImageView() throws Exception {
		try {
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(BackBtnImageView);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to click on Back Button. ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to click on Back Button. ", e);
		}
	}

	
	@Step("Handle Confirmation Message")
	public void handleConfirmationMessage() throws Exception{
		try {
			wait.ImplicitlyWait(30);
			if (isElementVisible2(ErrorMessgeElement) && getTexOfElement(ErrorMessgeElement).contains("Existing Personalization will be removed")) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				ClickOnOKButton(); 
			}
			wait.ImplicitlyWait(15);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Handle Confirmation Message ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Handle Confirmation Message ", e);
		}
	}
	
	@Step("Click On OK Button.")
	public void ClickOnOKButton() throws Exception {
		try {
			clickOnElement(OKButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On OK Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On OK Button   ", e);
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
			String xpath = "//android.widget.TextView[@text='" + ExpectedUserAccountName + "']";
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
	
	@Step("Accept Digi Bank Alert.")
	public void AcceptDigiBankAlert(String alertText) throws Exception {
		try {
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			String ErrorMsg = getTexOfElement(ErrorMessgeElement);
			if (ErrorMsg.contains(alertText))
				ClickOnOKButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Accept Digi Bank Alert ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Accept Digi Bank Alert  ", e);
		}
	}
	
	@Step("Click On Ok Button After Displaying Personalize Your Device Popup.")
	public void ClickOnOkButtonInPersonalizeYourDevicePopup() throws Exception {
		try {
			if (isElementVisible2(PersonalizeYourDevicePopup)) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				clickOnElement(OKBtn_PersonalizeYourDevicePopup);
			}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Click On Ok Button After Displaying PersonalizeYourDevicePopup ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Click On Ok Button After Displaying PersonalizeYourDevicePopup ", e);
		}
	}
	

	@Step("verify Selected Account For Peek Balance")
	public void verifySelectedAccountForPeekBalance(String AccountTitle, String SelectedAccountNameWithAccountNumber)
			throws Exception {
		try {
			Asserts.assertEquals(getTexOfElement(SelectedAccountForPeekBalance.get(0)), AccountTitle,
					AccountTitle + " Text is not matching.");
			Asserts.assertEquals(getTexOfElement(SelectedAccountForPeekBalance.get(1)),
					SelectedAccountNameWithAccountNumber,
					SelectedAccountNameWithAccountNumber + " Text is not matching.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to verify Selected Account For Peek Balance ", e);
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

	
}
