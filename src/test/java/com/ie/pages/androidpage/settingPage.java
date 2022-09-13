package com.ie.pages.androidpage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import com.ie.annotation.values.ElementDescription;
import com.ie.appium.utils.CommonAppiumTest;
import com.ie.common.utilities.CommonTestData;
import com.ie.common.utilities.HandleException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

/**
 * @author Shafqat
 *
 */
public class settingPage extends CommonAppiumTest{
	
	public AppiumDriver<RemoteWebElement> driver = null;
	HandleException obj_handleexception = null;
	
	public settingPage(AppiumDriver<RemoteWebElement> driver) throws Exception {
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
	
	
	//object
	@ElementDescription(value = "Login Link")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'userLoggedInVia')]")
	private MobileElement loginLink;
	
	@ElementDescription(value = "profile Link")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,\"userLoggedInVia\")]")
	private MobileElement profile;
	
	@ElementDescription(value = "Logout Button")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Logout\"]")
	private MobileElement logout;
	
	@ElementDescription(value = "Page Container")
	@AndroidFindBy(xpath = "//android.widget.ScrollView")
	private MobileElement pageContainer;

	
	@Step("Click on Login")
	public void ClickOnLogin() throws Exception {
		try {
			wait.waitForElement(loginLink, 
					5,
					"Login Link",
					"Login Page"
				);
			
			clickOn(loginLink, 
					"Setting option",
					"clicking from homepage"
				);

			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to click on Login Link ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to click on Login Link ", e);
		}
	}
	
	@Step("Click on Profile link")
	public void profileLink() throws Exception {
		try {
			wait.waitForElement(profile, 
					5,
					"Profile Link",
					"Login Page"
				);
			
			clickOn(profile, 
					"profile option",
					"clicking from Setting"
				);

			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to click on Login Link ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to click on Login Link ", e);
		}
	}
	
	@Step("Click on Logout button")
	public void ClickOnLogout() throws Exception {
		try {
			wait.waitForElement(profile, 
					5,
					"Profile Link",
					"Login Page"
				);
			
			gesture.scrollDownto(
					pageContainer, 
					logout,
					(float) 0.5,
					"Logout button",
					"update Profile page");

			clickOn(logout, 
					"logout button",
					"clicking from profile page"
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
