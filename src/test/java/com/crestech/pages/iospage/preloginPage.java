package com.crestech.pages.iospage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import com.crestech.annotation.values.ElementDescription;
import com.crestech.appium.utils.CommonAppiumTest;
import com.crestech.common.utilities.Asserts;
import com.crestech.common.utilities.GestureUtils;
import com.crestech.common.utilities.HandleException;
import com.crestech.pages.androidpage.launchPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
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
	launchPage launchpage = null;
	
	public preloginPage(AppiumDriver<RemoteWebElement> driver) throws Exception {
		super(driver);
		try {
			this.driver = driver;
		    gestUtils = new GestureUtils(driver);
		    launchpage = new launchPage(driver);
		    obj_handleexception = new HandleException(null, null);
			PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@ElementDescription(value = "login Button on PreloginPage")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Log In']")
	private MobileElement logInButton_OnPreloginPage;
	
	@ElementDescription(value = "change Server button")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell)[1]")
	private MobileElement changeServerButton;
	
	@ElementDescription(value = "More on Prelogin")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='More']")
	private MobileElement moreOnPreLogin;
	
	@ElementDescription(value = "save button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='SAVE']")
	private MobileElement saveButton;
	
	@ElementDescription(value = "log In Button On launch Page")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='LOG IN']")
	private MobileElement logInButton_launchPage;
	
	@ElementDescription(value = "Tap and hold to PEEK BALANCE")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Tap and hold to PEEK BALANCE']")
	private MobileElement peekBalance;
	
	
	@Step("Verify Visibility of Peek Balance on Login Page.")
	public void VerifyPeekBalanceEnabilityOnLogInPage(String peekBalanceSubtitle) throws Exception {
		try {
			Thread.sleep(20000); 
			String peekbalance  = getTexOfElement(peekBalance);
			System.out.println("peekbalance:: " +peekbalance);
			wait.waitForElementVisibility(peekBalance);
			Asserts.assertEquals(getTexOfElement(peekBalance).toLowerCase(), peekBalanceSubtitle.toLowerCase(),
					peekBalanceSubtitle + " Text is not matching.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify visibility of Peek Balance On Login page. ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify visibility of Peek Balance On Login page. ", e);
		}
	}
	
	@Step("Tap And Hold to Peek Balance On the Login Page.")
	public void TapAndHoldPeekBalance() throws Exception {
		try {
			gestUtils.longPressOnAndroidElement(peekBalance);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Tap And Hold On Peek Balance. ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Tap And Hold On Peek Balance. ", e);
		}
	}
	
	@Step("Click On Login Button On Launch Page")
	public void ClickOnLoginButtonOnLaunchPage() throws Exception {
		try {
			clickOnElement(logInButton_launchPage);
		}  catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Login Button On Launch Page ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Login Button On Launch Page ", e);
		}
	}
	

	@Step("Clicked on Login button")
	public void clickOnLoginButton() throws Exception {
		try { 
			if (wait.waitForElementToBeClickable2(logInButton_OnPreloginPage))
			{
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				clickOnElement(logInButton_OnPreloginPage);
			}
			else if (wait.waitForElementToBeClickable2(logInButton_launchPage)) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				ClickOnLoginButtonOnLaunchPage();
			}
				
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Login Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Login Button ", e);
		}
	}
	
	@Step("Click On LogIn Button.")
	public void ClickOnLoginButtonAfterEnablePeekBalance() throws Exception {
		try {
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(logInButton_OnPreloginPage);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On LogIn Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On LogIn Button  ", e);
		}
	}
	
	@Step("select UAT server")
	public void selectUATserver(String serverName) throws Exception {
		try {
			ClickOnMoreModuleOnLoginPage();
			ClickOnChangeServerButton();
			selectServerFromList(serverName);
			ClickOnChangeServerSaveButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to select UAT server ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to select UAT server ", e);
		}
	}
	
	@Step("Click On More Module On Login Page")
	public void ClickOnMoreModuleOnLoginPage() throws Exception {
		try {
			int count = 0;
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			do {
				clickOnElement(moreOnPreLogin);
				count++;
			} while (!isElementVisible2(changeServerButton) && count < 3);

		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On More Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On More Button ", e);
		}
	}
	
	@Step("Clicked on Change Server button")
	public void ClickOnChangeServerButton() throws Exception {
		try {
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(changeServerButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Click On Change Server Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Change Server Button ", e);
		}
	}
	
	@Step("Clicked on Save button to Change Server")
	public void ClickOnChangeServerSaveButton() throws Exception {
		try {
			clickOnElement(saveButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Save Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Save Button ", e);
		}
	}
	
	@Step("Select Server from list.")
	public void selectServerFromList(String serverName) throws Exception {
		try {
			gestUtils.scrollUPtoObjectIos("name", serverName, null);
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			String serverNameXpath = "//XCUIElementTypeStaticText[@name='" + serverName + "']";
			MobileElement serverNameElement = (MobileElement) driver.findElement(By.xpath(serverNameXpath));
			clickOnElement(serverNameElement);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select Server from list ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select Server from list ", e);
		}
	}
}
