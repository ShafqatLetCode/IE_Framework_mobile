package com.crestech.pages.androidpage;

import java.time.Duration;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import com.crestech.annotation.values.ElementDescription;
import com.crestech.appium.utils.CommonAppiumTest;
import com.crestech.common.utilities.CommonTestData;
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
public class enterPasscode extends CommonAppiumTest{

	public AppiumDriver<RemoteWebElement> driver = null;
	HandleException obj_handleexception = null;
	
	
	public enterPasscode(AppiumDriver<RemoteWebElement> driver) throws Exception {
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
	
	@ElementDescription(value = "Passcode Field")
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='••••••']")
	private MobileElement PasscodeField;
	
	@ElementDescription(value = "Done Button")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Done']")
	private MobileElement DoneButton;
	
	@Step("Enter Passcode(123456) for Secure Pin Authentication.")
	public void EnterPasscodeAndDone() throws Exception {
		try {
			if (isElementVisible2(PasscodeField)) { 
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				enterTextInTextbox(PasscodeField, CommonTestData.OTP.getEnumValue());
				if (isElementVisible2(DoneButton)) 
					ClickOnDoneButton();
			}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("ENTER_PASSCODE_EXCEPTION", " Failed to enter passcode  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("ENTER_PASSCODE_EXCEPTION", " Failed to enter passcode  ", e);
		}
	}
	
	@Step("Click On Done Button.")
	public void ClickOnDoneButton() throws Exception {
		try {
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(DoneButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Done Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Done Button ", e);
		}
	}
}
