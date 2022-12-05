package com.ie.pages.androidpage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import com.ie.annotation.values.ElementDescription;
import com.ie.appium.utils.CommonAppiumTest;
import com.ie.common.utilities.AndroidAlert;
import com.ie.common.utilities.Asserts;
import com.ie.common.utilities.CommonTestData;
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
 * @author Shafqat
 *
 */
public class homePage extends CommonAppiumTest {

	
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
	
	//objects
	@ElementDescription(value = "Update Alert")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Update Available']")
	private MobileElement updateAlert;
	
	@ElementDescription(value = "Skip Button")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'id/skip')]")
	private MobileElement skipButton;
	
	@ElementDescription(value = "Header Title")
	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,'id/ivAppHeader')]")
	private MobileElement headerTitle;
	
	@ElementDescription(value = "Setting option")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Settings\"]/preceding-sibling::android.widget.ImageView")
	private MobileElement settingOption;
	
	@ElementDescription(value = "Epaper icon")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,\"E-Paper\")]/preceding-sibling::android.widget.ImageView | //android.widget.TextView[contains(@text,'E-Paper')]/preceding-sibling::android.widget.RelativeLayout")
	private MobileElement Epaper;
	
	@ElementDescription(value = "Premium Tag")
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[contains(@resource-id,\"listItem\")]/following-sibling::android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[contains(@resource-id,\"tvPremium\")]")
	private MobileElement premiumTag;
	
	@ElementDescription(value = "Premium Article Tag")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,\"tvPremium\")]/parent::android.widget.LinearLayout/parent::android.widget.RelativeLayout/preceding-sibling::android.widget.LinearLayout[contains(@resource-id,\"listItem\")]")
	private MobileElement premiumArticleTag;
	
	@ElementDescription(value = "Article Title")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,\"title\")]")
	private MobileElement articleTitle;
	
	@ElementDescription(value = "HomePage Container")
	@AndroidFindBy(xpath = "//androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout")
	private MobileElement homepagePageContainer;
	
	@ElementDescription(value = "Article page Container")
	@AndroidFindBy(xpath = "//androidx.viewpager.widget.ViewPager[contains(@resource-id,\"viewPager\")]")
	private MobileElement articlepagePageContainer;
	
	@ElementDescription(value = "signup Button on Premium article")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,\"tvSignEvolok\")]")
	private MobileElement signinButtonOnPremiumArticle;
	
	@ElementDescription(value = "Register Button on Premium article")
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[contains(@resource-id,\"loginEvolok\")]")
	private MobileElement registerButtonOnPremiumArticle;
	
	@ElementDescription(value = "Home buttom nav tab")
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[contains(@resource-id,'home')]")
	private MobileElement homeButtomNavTab;
	
	@ElementDescription(value = "Premium article wall")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'evolokTV2')]")
	private MobileElement premiumArticleWall;
	
	@Step("Verify Home Page After Launch")
	public void VerifyHomePage() throws Exception {
		try {
			wait.waitForElement(headerTitle, 
					5,
					"Header Title",
					"verifiying on HomePage"
				);
			
			String getTitle=headerTitle.getAttribute("resource-id").toString().toLowerCase();
			Assert.assertContains(getTitle,"indianexpress");
			
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
					12,
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
	
	@Step("Click on sign in on premium article")
	public void ClickOnSignInOnPremiumArticle() throws Exception {
		try {
			gesture.scrollDownto(
					articlepagePageContainer, 
					signinButtonOnPremiumArticle,
					(float) 0.2,
					"sign up button",
					"premium article");
			
			wait.waitForElement(signinButtonOnPremiumArticle, 
					5,
					"sign in button",
					"verifiying on On Premium Article"
				);
			
			clickOn(signinButtonOnPremiumArticle, 
					"signin Button",
					"clicking from PremiumArticle"
				);

			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to click on sign in on premium article ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to click on sign in on premium article ", e);
		}
	}
}
