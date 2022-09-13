package com.ie.pages.iospage;

import java.time.Duration;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ie.annotation.values.ElementDescription;
import com.ie.appium.utils.CommonAppiumTest;
import com.ie.common.utilities.Asserts;
import com.ie.common.utilities.HandleException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class loginPage extends CommonAppiumTest{

	public AppiumDriver<RemoteWebElement> driver = null;
	HandleException obj_handleexception = null;
	Asserts Assert = null;

	public loginPage(AppiumDriver<RemoteWebElement> driver) throws Exception {
		super(driver);
		try {
			this.driver = driver;
			Assert = new Asserts();
		    obj_handleexception = new HandleException(null, null);
			PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	@ElementDescription(value = "Email Edit Text")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[contains(@value,'Email')]")
	private MobileElement emailEditText;

	@ElementDescription(value = "continue")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Continue\"]")
	private MobileElement continueButton;
	
	@ElementDescription(value = "Password Edit Field")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value=\"Password\"]")
	private MobileElement passworEditText;

	@ElementDescription(value = "sign In")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"SignIn\"]")
	private MobileElement signIn;
	
	@ElementDescription(value = "valid login")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"My Profile\"]/preceding-sibling::XCUIElementTypeStaticText")
	private MobileElement validLoginId;
	
	@ElementDescription(value = "Done Button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Done\"]")
	private MobileElement doneButton;
	
	@ElementDescription(value = "subscription button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"My Subscription\"]")
	private MobileElement subscriptionButton;
	
	@ElementDescription(value = "non Subscription Text")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeLink[@name=\"Subscribe\"])[1]")
	private MobileElement nonSubscriptionText;
	
	@ElementDescription(value = "view plan")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"View Plans\"]")
	private MobileElement viewPlan;
	
	@Step("Entering Email")
	public void enterTextInEmailField(String email) throws Exception {
		try {
			wait.waitForElement(emailEditText, 
					5,
					"email field",
					"sendkey in emailEditText"
				);
			
			enterText(emailEditText, 
					email,
					"email field",
					"sendkey in emailEditText"
				);

			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to sendKey in emailEditText ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to sendKey in emailEditText ", e);
		}
	}
	
	@Step("Entering password")
	public void enterTextInPasswordField(String password) throws Exception {
		try {
			wait.waitForElement(passworEditText, 
					5,
					"password field",
					"sendkey in passwordEditText"
				);
			
			enterText(passworEditText, 
					password,
					"password field",
					"sendkey in passworEditText"
				);

			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to sendKey in emailEditText ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to sendKey in emailEditText ", e);
		}
	}
	
	@Step("Click on signIn button")
	public void ClickOnContinueButton() throws Exception {
		try {
			wait.waitForElement(continueButton, 
					5,
					"continue button",
					"verifiying on continue button"
				);
			
			clickOn(continueButton, 
					"Setting option",
					"clicking from signIn page"
				);

			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to click on Continue button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to click on Continue button ", e);
		}
	}
	
	@Step("Click on Continue button")
	public void ClickOnSignIn() throws Exception {
		try {
			wait.waitForElement(signIn, 
					5,
					"Sign In",
					"verifiying on Sign In"
				);
			
			clickOn(signIn, 
					"SignIn button",
					"clicking from signIn page"
				);

			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to click on Sign In ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to click on Sign In ", e);
		}
	}
	
	@Step("validate login Id")
	public void LoginValidation(String validEmail) throws Exception {
		try {
			wait.waitForElement(validLoginId, 
					5,
					"Valid Email Header",
					"verifiying on Login"
				);
			
			String actual=validLoginId.getText().toString().toLowerCase();
			//Assert.assertContains(actual,validEmail);

			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Validate login ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Validate login ", e);
		}
	}
	
	@Step("Click on done button if visible")
	public void clickOnDoneButton() throws Exception {
		try {
			if (isElementVisible2(doneButton))
			{
				clickOn(doneButton, 
						"Done button",
						"Keyboard"
					);
			}
			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Click on done button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Click on done button ", e);
		}
	}
	
	@Step("Click on Subscription button")
	public void subscription() throws Exception {
		try {
			wait.waitForElement(subscriptionButton, 
					10,
					"subscription button",
					"verifiying on subscription button"
				);
			
			clickOn(subscriptionButton, 
					"subscription button",
					"subscription from signIn page"
				);

			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to click on subscription button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to click on subscription button ", e);
		}
	}
	
	@Step("validate non Subscription Text")
	public void nonSubscriptionValid() throws Exception {
		try {
			wait.waitForElement(nonSubscriptionText, 
					20,
					"Subscription link",
					"verifiying on Login"
				);
			
			String actual=nonSubscriptionText.getText().toString().toLowerCase();
			Assert.assertContains(actual,"Subscribe");
			
			clickOn(nonSubscriptionText, 
					"subscription Link",
					"subscription from Homepage"
				);
			
			wait.waitForElement(viewPlan, 
					20,
					"View Plan Title",
					"verifiying on Subscription"
				);

			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Validate login ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Validate login ", e);
		}
	}
	
	
	
	
}
