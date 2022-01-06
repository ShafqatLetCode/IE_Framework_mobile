package com.crestech.pages.iospage.paytransfer;

import java.time.Duration;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import com.crestech.annotation.values.ElementDescription;
import com.crestech.appium.utils.CommonAppiumTest;
import com.crestech.common.utilities.GestureUtils;
import com.crestech.common.utilities.HandleException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

/**
 * @author Divya
 *
 */
public class payAndTransfer extends CommonAppiumTest{
	
	public AppiumDriver<RemoteWebElement> driver = null;
	HandleException obj_handleexception = null;
	GestureUtils gestUtils = null;
	public TouchAction touch = null;
	
	public payAndTransfer(AppiumDriver<RemoteWebElement> driver) throws Exception {
		super(driver);
		try {
			this.driver = driver;
			obj_handleexception = new HandleException(null, null);
			gestUtils = new GestureUtils(driver);
			touch = new TouchAction(this.driver);
			PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@ElementDescription(value = "pay and transfer button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Pay & Transfer']")
	private MobileElement payAndTransferButton;
	
	@ElementDescription(value = " Overseas button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Overseas']")
	private MobileElement overseasButton;

	@Step("Click On Overseas Module")
	public void ClickOnOverseasModule() throws Exception {
		try {
			wait.waitForElementToBeClickable(overseasButton);
			clickOnElement(overseasButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Overseas Module  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Overseas Module ", e);
		}
	}
	
	@Step("Click On 'Pay & Transfer' Button.")
	public void ClickOnPayAndTransferButton() throws Exception {
		try {
			wait.waitForElementToBeClickable(payAndTransferButton);
			clickOnElement(payAndTransferButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On pay and transfer Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On pay and transfer Button ", e);
		}
	}
	
	

}
