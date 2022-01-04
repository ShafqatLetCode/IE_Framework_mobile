package com.crestech.pages.androidpage;

import java.time.Duration;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import com.crestech.annotation.values.ElementDescription;
import com.crestech.appium.utils.CommonAppiumTest;
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
public class loginPage extends CommonAppiumTest{

	public AppiumDriver<RemoteWebElement> driver = null;
	HandleException obj_handleexception = null;

	public loginPage(AppiumDriver<RemoteWebElement> driver) throws Exception {
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


	@ElementDescription(value = "User ID EditTexT")
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'id/edit_user_id')]")
	private MobileElement userIdEditText;

	@ElementDescription(value = "User PIN EditTexT")
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'id/edit_user_pin')]")
	private MobileElement userPinEditText;
	
	@ElementDescription(value = "LOG IN Button")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='LOG IN']")
	private MobileElement loginButton;
	
	@ElementDescription(value = "NotYou Link")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Not you?']")
	private MobileElement NotYouLink;
	
	@ElementDescription(value = "Peek Balance Deregister Button")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='DEREGISTER']")
	private MobileElement PeekbalanceDeregisterButton;
	
	@ElementDescription(value = "Error Messge Element")
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='android:id/message']")
	private MobileElement ErrorMessgeElement;
	
	@Step("Click On Not You Link Button.")
	public void ClickOnNOTYouLink() throws Exception {
		try {	
			clickOnElement(NotYouLink);
			
		} catch (HandleException e) {			
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Not You Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Not You Button  ", e);
		}
	}

	@Step("Click On Deregister Button.")
	public void ClickOnDeregisterButtonInDigiAlertPopup(String peekBalanceDeregisterMsg) throws Exception {
		try {
			String PeekBalance_DeregisterAlertMsg = getTexOfElement(ErrorMessgeElement);

			if (peekBalanceDeregisterMsg.contains(PeekBalance_DeregisterAlertMsg))
			{
				clickOnElement(PeekbalanceDeregisterButton);
				wait.waitForElementVisibility(userIdEditText);
			}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Deregister Button ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Deregister Button  ", e);
		}
	}
	
	@Step("Enter User name")
	public void enterUserName(String text) throws Exception {
		try {
			enterTextInTextbox(userIdEditText, text);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Enter User name ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Enter User name ", e);
		}
	}

	@Step("Enter Password")
	public void enterPassword(String text) throws Exception {
		try {
			enterTextInTextbox(userPinEditText, text);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Enter Password ", e);

		} catch (Exception e) {

			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Enter Password ", e);
		}
	}
	
	@Step("Clicked on Login button after Enter User Pin")
	public void clickOnLoginButton2() throws Exception {
		try {
			int count = 0;
			do {
				clickOnElement(loginButton);
				Thread.sleep(5000);
				count++;
			} while (isElementVisible2(loginButton) && count < 3);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Login Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Login Button ", e);
		}
	}
	
	@Step("LogIn Application")
	public void EnterCredentialsAndLogin(String userName, String password) throws Exception {
		try {
			enterUserName(userName);
			enterPassword(password);
			clickOnLoginButton2();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Login Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Login Button ", e);
		}
}
	
}
