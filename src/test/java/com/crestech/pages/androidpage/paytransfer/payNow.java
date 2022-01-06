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
public class payNow extends CommonAppiumTest{

	public AppiumDriver<RemoteWebElement> driver = null;
	HandleException obj_handleexception = null;
	GestureUtils gestUtils = null;
	
	
	public payNow(AppiumDriver<RemoteWebElement> driver) throws Exception {
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
	
	@ElementDescription(value = "Transfer to Thailand with PromptPay Title")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/title')]")
	private MobileElement TransfertoThailandwithPromptPayTitle;
	
	@ElementDescription(value = "Got It Button")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='GOT IT']")
	private MobileElement GOTITButton;
	
	@ElementDescription(value = "PayNow to NRIC/FIN Button")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='PayNow to NRIC/FIN']")
	private MobileElement PayNowToNRIC_FIN;
	
	@ElementDescription(value = "PayNow to UEN Button")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='PayNow to UEN']")
	private MobileElement PayNowToUEN;
	
	@ElementDescription(value = "PayNow to VPA Button")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='PayNow to VPA']")
	private MobileElement PayNowToVPA;
	
	@ElementDescription(value = "NRIC/FIN Number Field")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/textinput_placeholder')]")
	private MobileElement NRIC_FIN_Field;
	
	@Step("Enter NRIC/FIN Number ")
	public void EnterNRIC_FIN_Number() throws Exception {
		try {
			enterTextInTextbox(NRIC_FIN_Field, CommonTestData.NRIC_FIN_NUMBER.getEnumValue());
			hideKeyboard();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Enter NRIC/FIN Number ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Enter NRIC/FIN Number ", e);
		}
	}
	
	@Step("Select 'Pay Now To NRIC/FIN' ")
	public void SelectPayNowToNRIC_FIN() throws Exception {
		try {
			clickOnElement(PayNowToNRIC_FIN);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select 'Pay Now To NRIC/FIN' ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select 'Pay Now To NRIC/FIN' ", e);
		}
	}
	
	@Step("Select 'Pay Now To VPA' ")
	public void SelectPayNowToVPA() throws Exception {
		try {
			clickOnElement(PayNowToVPA);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select 'Pay Now To VPA' ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select 'Pay Now To VPA' ", e);
		}
	}
	
	@Step("Select 'Pay Now To UEN' ")
	public void SelectPayNowToUEN() throws Exception {
		try {
			clickOnElement(PayNowToUEN);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select 'Pay Now To UEN' ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select 'Pay Now To UEN' ", e);
		}
	}
	
	@Step("Handling 'Transfer to Thailand with PromptPay' Alert")
	public void handlingTransferToThailandWithPromptPayAlert(String expectecMessage) throws Exception   
	{
		try {
			if(isElementVisible2(TransfertoThailandwithPromptPayTitle)) {
				String actualMessage = getTexOfElement(TransfertoThailandwithPromptPayTitle);
				Asserts.assertEquals(actualMessage, expectecMessage, "Transfer to Thailand with PromptPay Message Not matching");
				ClickOnGotItButton();
			}
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Handling 'Transfer to Thailand with PromptPay' Alert  ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Handling 'Transfer to Thailand with PromptPay' Alert ",e);
		}
	}
	
	@Step("Click On Got It Button")
	public void ClickOnGotItButton() throws Exception {
		try {
			clickOnElement(GOTITButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Got It Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Got It Button ", e);
		}
	}
	
}
