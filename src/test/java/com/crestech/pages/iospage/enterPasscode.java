package com.crestech.pages.iospage;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import com.crestech.annotation.values.ElementDescription;
import com.crestech.appium.utils.CommonAppiumTest;
import com.crestech.common.utilities.CommonTestData;
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
	
	
	@ElementDescription(value = "Done button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Done']")
	private MobileElement doneButton;
	
	@ElementDescription(value = "Passcode Field")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='••••••']")
	private MobileElement PasscodeField;
	
	@ElementDescription(value = "secure textbox")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField")
	private MobileElement secureBox;

	@Step("Enter Passcode(123456) for Secure Pin Authentication.")
	public void EnterPasscodeAndDone() throws Exception {
		try {
			wait.ImplicitlyWait(30);
			if (isElementVisible2(PasscodeField)) {
				enterTextInTextbox(secureBox, CommonTestData.OTP.getEnumValue());
				if (isElementVisible2(doneButton)) 
					ClickOnDoneButton();
			}
			wait.ImplicitlyWait(20);
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("ENTER_PASSCODE_EXCEPTION", " Failed to enter passcode  ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("ENTER_PASSCODE_EXCEPTION", " Failed to enter passcode  ",e);
		}
	}
	
	@Step("Enter Passcode(123456) for Secure Pin Authentication.")
	public void EnterPasscode() throws Exception {
		try {
			if (isElementVisible2(PasscodeField)) {
				clickOnElement(secureBox);
				for (int i = 1; i <= 6; i++) {
					String bxpath = "//XCUIElementTypeButton[@name=" + i + "]";
					MobileElement button = (MobileElement) driver.findElement(By.xpath(bxpath));
					clickOnElement(button);
					Thread.sleep(2000);
				}
			}
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("ENTER_PASSCODE_EXCEPTION", " Failed to enter passcode  ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("ENTER_PASSCODE_EXCEPTION", " Failed to enter passcode  ",e);
		}
	}
	
	@Step("Click On Done Button.")
	public void ClickOnDoneButton() throws Exception {
		try {
			clickOnElement(doneButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Done Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Done Button ", e);
		}
	}

}
