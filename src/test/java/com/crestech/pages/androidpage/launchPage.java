package com.crestech.pages.androidpage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import com.crestech.annotation.values.ElementDescription;
import com.crestech.appium.utils.CommonAppiumTest;
import com.crestech.common.utilities.CommonTestData;
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
public class launchPage extends CommonAppiumTest{
	
	public AppiumDriver<RemoteWebElement> driver = null;
	HandleException obj_handleexception = null;
	//preloginPage preloginpg=null;
	
	public launchPage(AppiumDriver<RemoteWebElement> driver) throws Exception {
		super(driver);
		try {
			this.driver = driver;
			obj_handleexception = new HandleException(null, null);
			//preloginpg =new preloginPage(driver);
			PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	//object
	@ElementDescription(value = "Quit Button.")
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.Button")
	private MobileElement quitBtn;
	
	@ElementDescription(value = "PreLogin Button")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='PRE LOGIN']")
	private MobileElement PreLoginBtn;
	
	@ElementDescription(value = "More Button")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='More']")
	private MobileElement MoreButton;
	
	@ElementDescription(value = "LOG IN Button")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='LOG IN']")
	private MobileElement loginButton;

	@ElementDescription(value = "User ID EditTexT")
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'id/edit_user_id')]")
	private MobileElement userIdEditText;
	
	
	@ElementDescription(value = "Log In Button prelogin page")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Log In']")
	private MobileElement LogInButton_preloginpage;
	
	@ElementDescription(value = "Error Messge Element")
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='android:id/message']")
	private MobileElement ErrorMessgeElement;
	
	@ElementDescription(value = "DigibankAlertHeaderElement")
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='android:id/alertTitle']")
	private MobileElement DigibankAlertHeaderElement;
	
	@ElementDescription(value = "Progress Bar")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/progress_bar_message')]")
	private MobileElement progress_bar;
	
	@ElementDescription(value = "Progress Bar")
	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,':id/progress_bar')]")
	private MobileElement progress_bar_imageview;
	
	@ElementDescription(value = "Authenticating Bar")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Authenticating...']")
	private MobileElement Authenticating_Bar;
	
	public MobileElement Authenticating_Bar() { 
		return Authenticating_Bar;
	}
	
	public MobileElement progress_bar_imageview() { 
		return progress_bar_imageview;
	}
	
	public MobileElement progress_bar() { 
		return progress_bar;
	}
	
	public MobileElement DigibankAlertHeaderElement() { 
		return DigibankAlertHeaderElement;
	}
	
	public MobileElement ErrorMessgeElement() { 
		return ErrorMessgeElement;
	}
	
	public MobileElement quitBtn() { 
		return quitBtn;
	}
	public MobileElement loginButton() { 
		return loginButton;
	}

	
	@Step("Handling Of QUIT Button.")
	public void handlingQuitButton() throws Exception {
		try {
			wait.ImplicitlyWait(70);
			
			if (isElementVisible2(quitBtn)) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				driver.closeApp();
				relaunchingDBS();
				wait.fluentWaitForElement(loginButton); 
			}
			wait.ImplicitlyWait(15);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Handle Quit Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Handle Quit Button ", e);
		}
	}
	

	@Step("Relaunching POSB application")
	public void relaunchingPOSB() throws Exception {
		try {
			relanchApplication(CommonTestData.POSB_APP_PACKAGE.getEnumValue(),
					CommonTestData.DBS_APPS_ACTIVITY.getEnumValue());
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("RELAUNCHING_POSB_EXCEPTION",
					" Failed to Relaunching POSB Application  ", e);

		} catch (Exception e) {

			obj_handleexception.throwException("RELAUNCHING_POSB_EXCEPTION",
					" Failed to Relaunching POSB Application  ", e);
		}
	}

	@Step("Relaunching iWealth application")
	public void relaunchingIwealth() throws Exception {
		try {
			relanchApplication(CommonTestData.IWEALTH_APP_PACKAGE.getEnumValue(),
					CommonTestData.DBS_APPS_ACTIVITY.getEnumValue());
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("RELAUNCHING_iWEALTH_EXCEPTION",
					" Failed to Relaunching iWealth Application  ", e);

		} catch (Exception e) {

			obj_handleexception.throwException("RELAUNCHING_iWEALTH_EXCEPTION",
					" Failed to Relaunching iWealth Application  ", e);
		}
	}
	
	@Step("Relaunching DBS application")
	public void relaunchingDBS() throws Exception {
		try {
			relanchApplication(CommonTestData.DBS_APP_PACKAGE.getEnumValue(),
					CommonTestData.DBS_APPS_ACTIVITY.getEnumValue());
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("RELAUNCHING_DBS_EXCEPTION",
					" Failed to Relaunching DBS Application  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("RELAUNCHING_DBS_EXCEPTION", " Failed to Relaunching DBS Application  ",
					e);
		}
	}
	
	@Step("Clicked on Pre-Login button")
	public void ClickOnPreloginButton() throws Exception {
		try {
			if(wait.waitForElementToBeClickable2(PreLoginBtn))
			{
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			int count = 0;
			do {
				clickOnElement(PreLoginBtn);
				count++;
			} while (!isElementVisible2(MoreButton) && count < 3);
			}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Prelogin Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Prelogin Button ", e);
		}
	}
	
	@Step("Clicked on Login button")
	public void clickOnLoginButton() throws Exception {
		try {
			if(wait.waitForElementToBeClickable2(loginButton))
			{
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			int count = 0;
			do {
				clickOnElement(loginButton);
				count++;
			} while (!isElementVisible2(userIdEditText) && count < 3);
			}
			else if (wait.waitForElementToBeClickable2(LogInButton_preloginpage))
			{
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				clickOnElement(LogInButton_preloginpage);
			}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Login Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Login Button ", e);
		}
	}

}
