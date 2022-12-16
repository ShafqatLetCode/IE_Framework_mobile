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
		
	@ElementDescription(value = "home buttom icon")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Home\"]")
	private MobileElement homeButtomNavTab;
	
	@ElementDescription(value = "home page Container")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar//following-sibling::XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther")
	private MobileElement homepagePageContainer;
	
	@ElementDescription(value = "premium tag")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Premium\"]")
	private MobileElement premiumTag;
	
	@ElementDescription(value = "premium tag Article")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Premium\"]/parent::XCUIElementTypeOther/parent::XCUIElementTypeOther/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeStaticText")
	private MobileElement premiumArticleTag;
	
	@ElementDescription(value = "premium tag Article")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView//XCUIElementTypeScrollView")
	private MobileElement articlepagePageContainer;
	
	@ElementDescription(value = "premium tag Article")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Subscribe now\"]")
	private MobileElement registerButtonOnPremiumArticle;
	
	@ElementDescription(value = "premium Article wall")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'You need a subscription to read on')]")
	private MobileElement premiumArticleWall;
	
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
	
	@Step("Click on Bottom Nav")
	public void ClickOnBottomNaHome() throws Exception {
		try {
			wait.waitForElement(homeButtomNavTab, 
					12,
					"Home bottom nav icon",
					"verifiying on home tab"
				);
			
			clickOn(homeButtomNavTab, 
					"home Buttom NavTab option",
					"clicking from homepage"
				);

			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to click on Home buttom nav Icon ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to click on Home buttom nav Icon ", e);
		}
	}
	
	@Step("Scroll to Premium article")
	public void scrollToPremiumArticle() throws Exception {
		try {
			wait.waitForElement(homepagePageContainer, 
					5,
					"Page container",
					"Home page"
				);
			
			gesture.scrollDownto(
					homepagePageContainer, 
					premiumTag,
					(float) 0.5,
					"Premium tag",
					"Home page");
			
			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Scroll to premium tag ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Scroll to premium tag  ", e);
		}
	}

	@Step("Click on Premium Article")
	public void ClickOnPremiumArticle() throws Exception {
		try {
			wait.waitForElement(premiumArticleTag, 
					5,
					"Premium Article Tag",
					"verifiying on Homepage"
				);
			
			clickOn(premiumArticleTag, 
					"Premium Article Tag",
					"clicking from homepage"
				);

			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to click on Premium Article ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to click on Premium Article ", e);
		}
	}
	
	@Step("Scroll to register button on Premium article")
	public void scrollToPremiumRegisterButton() throws Exception {
		try {
			wait.waitForElement(articlepagePageContainer, 
					5,
					"Page container",
					"article page"
				);
			
			gesture.scrollDownto(
					articlepagePageContainer, 
					registerButtonOnPremiumArticle,
					(float) 0.5,
					"registration button",
					"premium article");
			
			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Scroll to register button on premium article ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Scroll to register button on premium article  ", e);
		}
	}
	
	@Step("Validating Premium Wall")
	public void validatingPremiumArticleWall() throws Exception {
		try {
			wait.waitForElementBoolean(premiumArticleWall, 
					5,
					"premium article",
					"article Detail page"
				);
			
			String getTitle=premiumArticleWall.getText().toString().toLowerCase();
			Assert.assertContains(getTitle,"You need a subscription to read on");
			
			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Scroll to register button on premium article ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Scroll to register button on premium article  ", e);
		}
	}
	
	@Step("Scroll to down to page to check Premium wall doesnt Exist")
	public void scrollToCheckPremiumRegisterWallDoesntExist() throws Exception {
		try {
			wait.waitForElement(articlepagePageContainer, 
					5,
					"Page container",
					"article page"
				);
			
			gesture.scrollDowntoCheckElementDoesntExist(
					articlepagePageContainer, 
					registerButtonOnPremiumArticle,
					(float) 0.5,
					"registration button",
					"premium article");
			
			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed As premium Wall found on premium article ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed As premium Wall found on premium article  ", e);
		}
	}
}
