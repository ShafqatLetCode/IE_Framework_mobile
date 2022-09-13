package com.ie.pages.iospage;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import com.ie.annotation.values.ElementDescription;
import com.ie.appium.utils.CommonAppiumTest;
import com.ie.common.utilities.AndroidAlert;
import com.ie.common.utilities.Asserts;
import com.ie.common.utilities.GestureUtils;
import com.ie.common.utilities.HandleException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

/**
 * @author Divya
 *
 */
public class homePage extends CommonAppiumTest{
	
	public AppiumDriver<RemoteWebElement> driver = null;
	HandleException obj_handleexception = null;
	GestureUtils gestUtils = null;
	Asserts Assert = null;
	AndroidAlert androidAlert = null;
	public homePage(AppiumDriver<RemoteWebElement> driver) throws Exception {
		super(driver);
		try {
			this.driver = driver;
			obj_handleexception = new HandleException(null, null);
			gestUtils = new GestureUtils(driver);
			Assert = new Asserts();
			androidAlert = new AndroidAlert(driver);
			PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@ElementDescription(value = "Update Alert")
	@iOSXCUITFindBy(xpath = "//android.widget.TextView[@text=\"Settings\"]/preceding-sibling::android.widget.ImageView")
	private MobileElement updateAlert;
	
	@ElementDescription(value = "Skip Button")
	@iOSXCUITFindBy(xpath = "//android.widget.TextView[@text=\"Settings\"]/preceding-sibling::android.widget.ImageView")
	private MobileElement skipButton;
	
	@ElementDescription(value = "Header Title")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"HomeTopNavView\"]/XCUIElementTypeButton[2]")
	private MobileElement headerTitle;
	
	@ElementDescription(value = "Setting option")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Settings\"]")
	private MobileElement settingOption;
	
	@ElementDescription(value = "Epaper icon")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"E-Paper\"]")
	private MobileElement Epaper;
		
	
	@Step("Verify Home Page After Launch")
	public void VerifyHomePage() throws Exception {
		try {
			wait.waitForElement(headerTitle, 
					5,
					"Header Title",
					"verifiying on HomePage"
				);
			
			//String getTitle=headerTitle.getAttribute("resource-id").toString().toLowerCase();
			//Assert.assertContains(getTitle,"indianexpress");
			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify Home Page After Launch ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify Home Page After Launch ", e);
		}
	}
	
	@Step("Handling Update Alert if Present ")
	public void updateAlert() throws Exception {
		try {
			Thread.sleep(5000);
			if (isElementVisible2(updateAlert))
			{
				wait.waitForElement(skipButton, 
						5,
						"Skip button",
						"Handling Update Alert"
					);
			
				clickOn(skipButton, 
						"Skip button",
						"Handling Update Alert"
					);
			}
			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Handle Alert ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Handle Alert ", e);
		}
	}

	@Step("Click on setting")
	public void ClickOnSetting() throws Exception {
		try {
			wait.waitForElement(settingOption, 
					5,
					"Setting option",
					"verifiying on SettinOption"
				);
			
			clickOn(settingOption, 
					"Setting option",
					"clicking from homepage"
				);

			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to click on setting option ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to click on setting option ", e);
		}
	}
	
	@Step("Click on Epaper")
	public void ClickOnEpaper() throws Exception {
		try {
			wait.waitForElement(Epaper, 
					5,
					"Epaper icon",
					"verifiying on epaper"
				);
			
			clickOn(Epaper, 
					"Epaper option",
					"clicking from homepage"
				);

			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to click on Epaper Icon ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to click on Epaper Icon ", e);
		}
	}
}
