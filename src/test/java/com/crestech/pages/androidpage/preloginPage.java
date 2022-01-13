package com.crestech.pages.androidpage;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import com.crestech.annotation.values.ElementDescription;
import com.crestech.appium.utils.CommonAppiumTest;
import com.crestech.common.utilities.Asserts;
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
	
	@ElementDescription(value = "More Button")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='More']")
	private MobileElement MoreButton;
	
	@ElementDescription(value = "ChangeServer Button")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Change Server']")
	private MobileElement ChangeServerBtn;
	
	@ElementDescription(value = "Save Btn to Change Server")
	@AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,':id/btn_save_now')]")
	private MobileElement ChangeServerSaveBtn;
	
	@ElementDescription(value = "Peek balance Sub title On login page.")
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.dbs.sit1.dbsmbanking:id/tv_peek_balance_sub_title']")
	private MobileElement PeekBalanceSubtitle;
	
	@ElementDescription(value = "Log In Button")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Log In']")
	private MobileElement LogInButton;
	
	
	@Step("Click On LogIn Button.")
	public void ClickOnLoginButton() throws Exception {
		try {
			if (wait.waitForElementToBeClickable2(launchpage.loginButton())) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				clickOnElement(launchpage.loginButton());
			} else if (wait.waitForElementToBeClickable2(LogInButton)) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				clickOnElement(LogInButton);
			}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On LogIn Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On LogIn Button  ", e);
		}
	}
	
	@Step("Verify Visibility of Peek Balance on Login Page.")
	public void VerifyPeekBalanceEnabilityOnLogInPage(String peekBalanceSubtitle) throws Exception {
		try {
			wait.waitForElementVisibility(PeekBalanceSubtitle);
			Asserts.assertEquals(getTexOfElement(PeekBalanceSubtitle), peekBalanceSubtitle,
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
			gestUtils.longPressOnAndroidElement(PeekBalanceSubtitle);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Tap And Hold On Peek Balance. ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Tap And Hold On Peek Balance. ", e);
		}
	}
	
	
	@Step("Select UAT Server.")
	public void SelectUATServer(String serverName) throws Exception {
		try {
			launchpage.ClickOnPreloginButton();
			ClickOnMoreModuleOnLoginPage();
			ClickOnChangeServerButton();
			selectServerFromList(serverName);
			ClickOnChangeServerSaveButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("SELECTUATSERVER_EXCEPTION", " Failed to Select UAT Server ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("SELECTUATSERVER_EXCEPTION", " Failed to Select UAT Server ", e);
		}
	}

	@Step("Select Server from list.")
	public void selectServerFromList(String serverName) throws Exception {
		try {
			gestUtils.scrollUPtoObject("text", serverName, null);
			String serverNameXpath = "//android.widget.TextView[@text='" + serverName + "']";
			MobileElement serverNameElement = (MobileElement) driver.findElement(By.xpath(serverNameXpath));
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(serverNameElement);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select Server from list ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select Server from list ", e);
		}
	}

	@Step("Clicked on Save button to Change Server")
	public void ClickOnChangeServerSaveButton() throws Exception {
		try {
			clickOnElement(ChangeServerSaveBtn);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Save Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Save Button ", e);
		}
	}

	@Step("Clicked on Change Server button")
	public void ClickOnChangeServerButton() throws Exception {
		try {
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(ChangeServerBtn);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Click On Change Server Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Change Server Button ", e);
		}
	}
	

	@Step("Click On More Module On Login Page")
	public void ClickOnMoreModuleOnLoginPage() throws Exception {
		try {
			int count = 0;
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			do {
				clickOnElement(MoreButton);
				count++;
			} while (!isElementVisible2(ChangeServerBtn) && count < 3);

		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On More Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On More Button ", e);
		}
	}
	
}
