package com.ie.pages.androidpage;

import java.time.Duration;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import com.ie.annotation.values.ElementDescription;
import com.ie.appium.utils.CommonAppiumTest;
import com.ie.common.utilities.Asserts;
import com.ie.common.utilities.HandleException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;

/**
 * @author shafqat
 *
 */
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

	@ElementDescription(value = "Progress Bar")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,\"progressBar\")]")
	private MobileElement progressBar;
	
	@ElementDescription(value = "loginpageHeader")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Create your account\"] | //android.widget.TextView[@text=\"Welcome back\"]")
	private MobileElement loginPageHeader;
	
	@ElementDescription(value = "loginpageHeader")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Skip\"]")
	private MobileElement loginPageSkippedButton;
	
	@ElementDescription(value = "Email Edit Text")
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,\"enter_email\")]")
	private MobileElement emailEditText;

	@ElementDescription(value = "continue")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Contiune\"]")
	private MobileElement continueButton;
	
	@ElementDescription(value = "Password Edit Field")
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,\"enter_password\")]")
	private MobileElement passworEditText;

	@ElementDescription(value = "sign In")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Sign In\"]")
	private MobileElement signIn;
	
	@ElementDescription(value = "valid login")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'id/userName')]")
	private MobileElement validLoginId;
	
	@ElementDescription(value = "subscription button")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,\"tvSubscription\")]")
	private MobileElement subscriptionButton;
	
	@ElementDescription(value = "nonSubscriptionText")
	@AndroidFindBy(xpath = "//android.view.View[contains(@resource-id,\"purchases\")]//android.view.View/android.widget.TextView")
	private MobileElement nonSubscriptionText;
	
	@ElementDescription(value = "Create Account")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,\"Create your account\")]")
	private MobileElement createAccount;
	
	@ElementDescription(value = "Sign in on signup")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,\"tvSignIn\")]")
	private MobileElement signInLink;
	
	@ElementDescription(value = "page Container")
	@AndroidFindBy(xpath = "//android.widget.ScrollView")
	private MobileElement PageContainer;
	
	
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
			Assert.assertContains(validEmail,actual);

			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Validate login ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Validate login ", e);
		}
	}
	
	@Step("Click on Subscription button")
	public void subscription() throws Exception {
		try {
			wait.waitForElement(subscriptionButton, 
					20,
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
					5,
					"non Subscription Text",
					"verifiying on Login"
				);
			
			String actual=nonSubscriptionText.getText().toString().toLowerCase();
			Assert.assertContains(actual,"You have not purchased any subscription yet");

			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Validate login ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Validate login ", e);
		}
	}
	
	@Step("Skipping the login page")
	public void skippingLoginPage() throws Exception {
		try {
			
			boolean flag=wait.waitForElementBoolean(loginPageHeader, 
					22,
					"Login Header",
					"Login page"
				);
			
			if(flag) 
			{
				wait.waitForElement(loginPageSkippedButton, 
						5,
						"Login skip button",
						"Login page"
					);
				
				clickOn(loginPageSkippedButton, 
						"Login skip button",
						"Login page"
					);
			}
			
//			wait.waitForNoElement(progressBar, 
//					5,
//					"progress Bar",
//					"Home Page"
//				);

			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to skip login ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to skip login ", e);
		}
	}
	
	@Step("Click on signIn button")
	public void ClickOnSignInLink() throws Exception {
		try {
			wait.waitForElement(createAccount, 
					5,
					"Create Account Header",
					"verifiying Header on SignIn Page"
				);
			
			gesture.scrollDownto(
					PageContainer, 
					signInLink,
					(float) 0.5,
					"signIN button",
					"signUp page");

			clickOn(signIn, 
					"SignIn button",
					"clicking from signUp page"
				);
			
			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to click on Sign In ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to click on Sign In ", e);
		}
	}
}
