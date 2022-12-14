package com.ie.pages.iospage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import com.ie.annotation.values.ElementDescription;
import com.ie.appium.utils.CommonAppiumTest;
import com.ie.common.utilities.Asserts;
import com.ie.common.utilities.GestureUtils;
import com.ie.common.utilities.HandleException;
import com.ie.pages.androidpage.settingPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

/**
 * @author Divya
 *
 */
public class preloginPage extends CommonAppiumTest{
	
	public AppiumDriver<RemoteWebElement> driver = null;
	HandleException obj_handleexception = null;
	GestureUtils gestUtils = null;
	settingPage launchpage = null;
	
	public preloginPage(AppiumDriver<RemoteWebElement> driver) throws Exception {
		super(driver);
		try {
			this.driver = driver;
		    gestUtils = new GestureUtils(driver);
		    launchpage = new settingPage(driver);
		    obj_handleexception = new HandleException(null, null);
			PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
//	@ElementDescription(value = "Progress Bar")
//	@iOSXCUITFindBy(xpath = "")
//	private MobileElement progressBar;

	@ElementDescription(value = "city title")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Select your city\"]")
	private MobileElement cityTitle;
	
//	@ElementDescription(value = "city option")
//	@iOSXCUITFindBy(xpath = "")
//	private List<MobileElement> cityOption;
	
	@ElementDescription(value = "continue button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Continue\"]")
	private MobileElement continueButton;
	
	@ElementDescription(value = "interest title")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Select Interests\"]")
	private MobileElement interestTitle;
	
	@Step("Handling city selection page")
	public boolean isCustomiseJourneyPresent() throws Exception {
		boolean flag = false;
		try {

			flag= wait.waitForElementBoolean(cityTitle, 
					6,
					"Select Title",
					"city selection page"
				);

		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to handle city selection page ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to handle city selection page  ", e);
		}
		return flag;
	}
	
	@Step("Click on continue button")
	public void continueButton() throws Exception {
		try {
			wait.waitForElement(continueButton, 
					5,
					"continue button",
					"verifiying on continue button"
				);
			
			clickOn(continueButton, 
					"continue button",
					"continue button fron select city"
				);

			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to click on continue button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to click on continue button ", e);
		}
	}
	
	@Step("handling select interest page")
	public void handlingSelectInterest() throws Exception {
		try {
			
//			wait.waitForNoElement(progressBar, 
//					5,
//					"progress Bar",
//					"city selection page"
//				);
			
			wait.waitForElement(interestTitle, 
					5,
					"Interest Title",
					"Interest selection page"
				);
			
			wait.waitForElement(continueButton, 
					5,
					"continue button",
					"verifiying on continue button"
				);
			
			clickOn(continueButton, 
					"continue button",
					"continue button fron select city"
				);
	        
			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to handle select interest page", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to hanlde select interest page " , e);
		}
	}
	
//	@Step("Verify Visibility of Peek Balance on Login Page.")
//	public void VerifyPeekBalanceEnabilityOnLogInPage(String peekBalanceSubtitle) throws Exception {
//		try {
//			Thread.sleep(20000); 
//			String selector = "type == 'XCUIElementTypeStaticText' AND name == 'Tap and hold to PEEK BALANCE'";
//			
//			if(isElementVisible2(peekBalance1)) {
//				System.out.println(getTexOfElement(peekBalance1));
//				Asserts.assertEquals(getTexOfElement(peekBalance1).toLowerCase(), peekBalanceSubtitle.toLowerCase(),
//						peekBalanceSubtitle + " Text is not matching.");
//			}
//			else {
//				String peekbalance = driver.findElement(MobileBy.iOSNsPredicateString(selector)).getText();
//				System.out.println(peekbalance);
//				Asserts.assertEquals(peekbalance.toLowerCase(), peekBalanceSubtitle.toLowerCase(),
//					peekBalanceSubtitle + " Text is not matching.");
//				
//				}
//		} catch (HandleException e) {
//			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
//					" Failed to Verify visibility of Peek Balance On Login page. ", e);
//		} catch (Exception e) {
//			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
//					" Failed to Verify visibility of Peek Balance On Login page. ", e);
//		}
//	}
//	
//	@Step("Tap And Hold to Peek Balance On the Login Page.")
//	public void TapAndHoldPeekBalance() throws Exception {
//		try {
//			gestUtils.longPressOnAndroidElement(peekBalance1);
//		} catch (HandleException e) {
//			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
//					" Failed to Tap And Hold On Peek Balance. ", e);
//		} catch (Exception e) {
//			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Tap And Hold On Peek Balance. ", e);
//		}
//	}
//	
//	@Step("Click On Login Button On Launch Page")
//	public void ClickOnLoginButtonOnLaunchPage() throws Exception {
//		try {
//			clickOnElement(logInButton_launchPage);
//		}  catch (HandleException e) {
//			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Login Button On Launch Page ", e);
//		} catch (Exception e) {
//			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Login Button On Launch Page ", e);
//		}
//	}
//	
//
//	@Step("Clicked on Login button")
//	public void clickOnLoginButton() throws Exception {
//		try { 
//			if (wait.waitForElementToBeClickable2(logInButton_OnPreloginPage))
//			{
//				com.ie.listeners.TestListener.saveScreenshotPNG(driver);
//				clickOnElement(logInButton_OnPreloginPage);
//			}
//			else if (wait.waitForElementToBeClickable2(logInButton_launchPage)) {
//				com.ie.listeners.TestListener.saveScreenshotPNG(driver);
//				ClickOnLoginButtonOnLaunchPage();
//			}
//				
//		} catch (HandleException e) {
//			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Login Button ", e);
//		} catch (Exception e) {
//			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Login Button ", e);
//		}
//	}
//	
//	@Step("Click On LogIn Button.")
//	public void ClickOnLoginButtonAfterEnablePeekBalance() throws Exception {
//		try {
//			com.ie.listeners.TestListener.saveScreenshotPNG(driver);
//			clickOnElement(logInButton_OnPreloginPage);
//		} catch (HandleException e) {
//			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On LogIn Button ", e);
//		} catch (Exception e) {
//			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On LogIn Button  ", e);
//		}
//	}
//	
//	@Step("select UAT server")
//	public void selectUATserver(String serverName) throws Exception {
//		try {
//			ClickOnMoreModuleOnLoginPage();
//			ClickOnChangeServerButton();
//			selectServerFromList(serverName);
//			ClickOnChangeServerSaveButton();
//		} catch (HandleException e) {
//			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to select UAT server ", e);
//		} catch (Exception e) {
//			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to select UAT server ", e);
//		}
//	}
//	
//	@Step("Click On More Module On Login Page")
//	public void ClickOnMoreModuleOnLoginPage() throws Exception {
//		try {
//			int count = 0;
//			com.ie.listeners.TestListener.saveScreenshotPNG(driver);
//			do {
//				clickOnElement(moreOnPreLogin);
//				count++;
//			} while (!isElementVisible2(changeServerButton) && count < 3);
//
//		} catch (HandleException e) {
//			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On More Button ", e);
//		} catch (Exception e) {
//			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On More Button ", e);
//		}
//	}
//	
//	@Step("Clicked on Change Server button")
//	public void ClickOnChangeServerButton() throws Exception {
//		try {
//			com.ie.listeners.TestListener.saveScreenshotPNG(driver);
//			clickOnElement(changeServerButton);
//		} catch (HandleException e) {
//			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
//					" Failed to Click On Change Server Button ", e);
//		} catch (Exception e) {
//			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Change Server Button ", e);
//		}
//	}
//	
//	@Step("Clicked on Save button to Change Server")
//	public void ClickOnChangeServerSaveButton() throws Exception {
//		try {
//			clickOnElement(saveButton);
//		} catch (HandleException e) {
//			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Save Button ", e);
//		} catch (Exception e) {
//			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Save Button ", e);
//		}
//	}
//	
//	@Step("Select Server from list.")
//	public void selectServerFromList(String serverName) throws Exception {
//		try {
//			gestUtils.scrollUPtoObjectIos("name", serverName, null);
//			com.ie.listeners.TestListener.saveScreenshotPNG(driver);
//			String serverNameXpath = "//XCUIElementTypeStaticText[@name='" + serverName + "']";
//			MobileElement serverNameElement = (MobileElement) driver.findElement(By.xpath(serverNameXpath));
//			clickOnElement(serverNameElement);
//		} catch (HandleException e) {
//			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select Server from list ", e);
//		} catch (Exception e) {
//			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select Server from list ", e);
//		}
//	}
}
