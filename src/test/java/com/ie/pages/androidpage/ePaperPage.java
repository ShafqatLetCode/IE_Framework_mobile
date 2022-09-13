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
 * @author Divya
 *
 */
public class ePaperPage extends CommonAppiumTest{

	HandleException obj_handleexception = null;
	Asserts Assert = null;
	
	public ePaperPage(AppiumDriver<RemoteWebElement> driver) throws Exception {
		super(driver);
		try {
			this.driver = driver;
			obj_handleexception = new HandleException(null, null);
			Assert = new Asserts();
			PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@ElementDescription(value = "paywall text")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,\"subscription not found\")]")
	private MobileElement paywallText;
	
	@ElementDescription(value = "Choose plan button")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,\"showPlans\")]")
	private MobileElement choosePlanButton;
	
	@ElementDescription(value = "paywall text")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,\"ePaper behind a paywall\")]")
	private MobileElement paywallBehinedText;
	
	@ElementDescription(value = "Login button")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,\"tvLogin\")]")
	private MobileElement loginButton;
	
	@ElementDescription(value = "newstand")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,\"Your newstand\")]")
	private MobileElement newsLetterHeader;
	
	@ElementDescription(value = "backbutton")
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[contains(@resource-id,\"back\")]")
	private MobileElement backButton;
	//android.widget.LinearLayout[contains(@resource-id,"back")]
	
	@Step("Verifying pay wall on epaper")
	public void verifyingEpaperWall() throws Exception {
		try {
			wait.waitForElement(paywallText, 
					5,
					"Paywall Text",
					"verifiying on Epaper"
				);
			
			String getTitle=paywallText.getText().toString().toLowerCase();
			Assert.assertContains(getTitle,"E-paper subscription not found");
			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to verify epaper wall ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to verify epaper wall  ", e);
		}
	}
	
	@Step("Verifying pay wall on epaper")
	public void verifyingEpaperWalltitle() throws Exception {
		try {
			wait.waitForElement(paywallBehinedText, 
					5,
					"Paywall Text",
					"verifiying on Epaper"
				);
			
			String getTitle=paywallBehinedText.getText().toString().toLowerCase();
			Assert.assertContains(getTitle,"We have moved our ePaper behind a paywall");
			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to verify epaper wall ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to verify epaper wall  ", e);
		}
	}
	
	@Step("Click on epaper login")
	public void ClickonLoginOnEpaper() throws Exception {
		try {
				wait.waitForElement(loginButton, 
						5,
						"login button",
						"Login from epaper"
					);
			
				clickOn(loginButton, 
						"login button",
						"Login from epaper"
					);
			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Click on epaper login  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Click on epaper login ", e);
		}
	}
	
	@Step("Verifying news header")
	public void verifyingEpaperNewsHeader() throws Exception {
		try {
			wait.waitForElement(newsLetterHeader, 
					5,
					"news Letter Header",
					"verifiying on News Header"
				);
			
			String getTitle=newsLetterHeader.getText().toString().toLowerCase();
			Assert.assertContains(getTitle,"Your newstand");
			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to verify epaper header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to verify epaper header ", e);
		}
	}
	
	@Step("Click on backbuton")
	public void ClickOnBackbutton() throws Exception {
		try {
				wait.waitForElement(backButton, 
						5,
						"back button",
						"back from epaper"
					);
			
				clickOn(backButton, 
						"back button",
						"back from epaper"
					);
			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Click on backbutton  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Click on backbutton ", e);
		}
	}
	
//	@Step("verify 'Tap On The Stars To Rate' Message")
//	public void verifyTapOnTheStarsToRate(String Ratingmsg) throws Exception {
//		try {
//			wait.fluentWaitForElement(postLogoutAlertMessage); 
//			Asserts.assertEquals(getTexOfElement(postLogoutAlertMessage), Ratingmsg, 
//					"'Tap on the stars to rate' Text is not matching.");
//		} catch (HandleException e) {
//			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to verify 'Tap On The Stars To Rate' Message ", e);
//		} catch (Exception e) {
//			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to verify 'Tap On The Stars To Rate' Message ", e);
//		}
//	}
}
