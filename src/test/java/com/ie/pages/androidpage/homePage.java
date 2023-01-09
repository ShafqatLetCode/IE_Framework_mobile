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
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Settings\"]/preceding-sibling::android.widget.ImageView | //android.widget.TextView[@text=\"Login\"]/preceding-sibling::android.widget.ImageView")
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
	
	//nav bar element
	@ElementDescription(value = "NavBar")
	@AndroidFindBy(xpath = "//android.widget.HorizontalScrollView/android.widget.LinearLayout")
	private MobileElement navBar;
	
	@ElementDescription(value = "Audio section")
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Audio\"]")
	private MobileElement audioSection;
	
	@ElementDescription(value = "Political Pulse")
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Political Pulse\"]")
	private MobileElement politicalPulse;
	
	@ElementDescription(value = "India")
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"India\"]")
	private MobileElement india;
	
	@ElementDescription(value = "Opinion")
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Opinion\"]")
	private MobileElement opinion;
	
	@ElementDescription(value = "Explained")
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Explained\"]")
	private MobileElement explained;
	
	@ElementDescription(value = "Entertainment")
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Entertainment\"]")
	private MobileElement entertainment;
	
	@ElementDescription(value = "Sports")
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Sports\"]")
	private MobileElement sports;
	
	@ElementDescription(value = "Lifestyle")
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Lifestyle\"]")
	private MobileElement lifestyle;
	
	@ElementDescription(value = "World")
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"World\"]")
	private MobileElement world;
	
	@ElementDescription(value = "Technology")
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Technology\"]")
	private MobileElement technology;
	
	@ElementDescription(value = "Viral")
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Viral\"]")
	private MobileElement viral;
	
	@ElementDescription(value = "Express Premium")
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Express Premium\"]")
	private MobileElement expressPremium;
	
	@ElementDescription(value = "Videos")
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Videos\"]")
	private MobileElement videos;
	
	@ElementDescription(value = "Photos")
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Photos\"]")
	private MobileElement photos;
	
	@ElementDescription(value = "First Article Date")
	@AndroidFindBy(xpath = "(//android.widget.LinearLayout/following-sibling::android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[contains(@resource-id, 'id/date')])[1]")
	private MobileElement firstArticleDate;
	
	@ElementDescription(value = "First Article Date")
	@AndroidFindBy(xpath = "(//android.widget.LinearLayout/following-sibling::android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[contains(@resource-id, 'id/date')])[2]")
	private MobileElement secondArticleDate;
	
	//android.widget.HorizontalScrollView/android.widget.LinearLayout
	
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
	
	@Step("swiping to Audio section on NavBar")
	public void swipingAudioSectionNavBar() throws Exception {
		try {
			
			wait.waitForElement(
					navBar, 
					5,
					"Nav Bar",
					"verifiying on Section On NavBar"
				);
			
			gesture.SwipeLeftToRightDownTo(
					navBar, 
					audioSection,
					(float) 0.5,
					"Navigation bar",
					"audio section"
				);

			
			clickOn(audioSection, 
					"Audio Button",
					"Navigation bar"
				);

			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Swipe to Audio section ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Swipe to Audio section ", e);
		}
	}
	
	@Step("swiping to politicalPulse section on NavBar")
	public void swipingPoliticalPulseSectionNavBar() throws Exception {
		try {
			
			wait.waitForElement(
					navBar, 
					5,
					"Nav Bar",
					"verifiying on Section On NavBar"
				);
			
			gesture.SwipeLeftToRightDownTo(
					navBar, 
					politicalPulse,
					(float) 0.5,
					"Navigation bar",
					"politicalPulse section"
				);

			
			clickOn(politicalPulse, 
					"politicalPulse Button",
					"Navigation bar"
				);

			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Swipe to politicalPulse section ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Swipe to politicalPulse section ", e);
		}
	}
	
	@Step("swiping to india section on NavBar")
	public void swipingIndiaSectionNavBar() throws Exception {
		try {
			
			wait.waitForElement(
					navBar, 
					5,
					"Nav Bar",
					"verifiying on Section On NavBar"
				);
			
			gesture.SwipeLeftToRightDownTo(
					navBar, 
					india,
					(float) 0.5,
					"Navigation bar",
					"india section"
				);

			
			clickOn(india, 
					"india Button",
					"Navigation bar"
				);

			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Swipe to india section ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Swipe to india section ", e);
		}
	}
	
	@Step("swiping to opinion section on NavBar")
	public void swipingOpinionSectionNavBar() throws Exception {
		try {
			
			wait.waitForElement(
					navBar, 
					5,
					"Nav Bar",
					"verifiying on Section On NavBar"
				);
			
			gesture.SwipeLeftToRightDownTo(
					navBar, 
					opinion,
					(float) 0.5,
					"Navigation bar",
					"india section"
				);

			
			clickOn(opinion, 
					"opinion Button",
					"Navigation bar"
				);

			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Swipe to opinion section ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Swipe to opinion section ", e);
		}
	}
	
	@Step("Swiping to Explained section on NavBar")
	public void swipingExplainedSectionNavBar() throws Exception {
		try {
			
			wait.waitForElement(
					navBar, 
					5,
					"Nav Bar",
					"verifiying on Section On NavBar"
				);
			
			gesture.SwipeLeftToRightDownTo(
					navBar, 
					explained,
					(float) 0.5,
					"Navigation bar",
					"explained section"
				);

			
			clickOn(explained, 
					"explained Button",
					"Navigation bar"
				);

			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Swipe to explained section ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Swipe to explained section ", e);
		}
	}
	//entertainment
	
	@Step("Swiping to Entertainment section on NavBar")
	public void swipingEntertainmentSectionNavBar() throws Exception {
		try {
			
			wait.waitForElement(
					navBar, 
					5,
					"Nav Bar",
					"verifiying on Section On NavBar"
				);
			
			gesture.SwipeLeftToRightDownTo(
					navBar, 
					entertainment,
					(float) 0.5,
					"Navigation bar",
					"entertainment section"
				);

			
			clickOn(entertainment, 
					"entertainment Button",
					"Navigation bar"
				);

			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Swipe to entertainment section ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Swipe to entertainment section ", e);
		}
	}
	
	@Step("Swiping to sports section on NavBar")
	public void swipingSportsSectionNavBar() throws Exception {
		try {
			
			wait.waitForElement(
					navBar, 
					5,
					"Nav Bar",
					"verifiying on Section On NavBar"
				);
			
			gesture.SwipeLeftToRightDownTo(
					navBar, 
					sports,
					(float) 0.5,
					"Navigation bar",
					"sports section"
				);

			
			clickOn(sports, 
					"sports Button",
					"Navigation bar"
				);

			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Swipe to sports section ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Swipe to sports section ", e);
		}
	}
	
	@Step("Swiping to world section on NavBar")
	public void swipingWorldSectionNavBar() throws Exception {
		try {
			
			wait.waitForElement(
					navBar, 
					5,
					"Nav Bar",
					"verifiying on Section On NavBar"
				);
			
			gesture.SwipeLeftToRightDownTo(
					navBar, 
					world,
					(float) 0.5,
					"Navigation bar",
					"world section"
				);

			
			clickOn(world, 
					"world Button",
					"Navigation bar"
				);

			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Swipe to world section ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Swipe to world section ", e);
		}
	}
	
	@Step("Swiping to Technology section on NavBar")
	public void swipingTechnologySectionNavBar() throws Exception {
		try {
			
			wait.waitForElement(
					navBar, 
					5,
					"Nav Bar",
					"verifiying on Section On NavBar"
				);
			
			gesture.SwipeLeftToRightDownTo(
					navBar, 
					technology,
					(float) 0.5,
					"Navigation bar",
					"technology section"
				);

			
			clickOn(technology, 
					"technology Button",
					"Navigation bar"
				);

			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Swipe to technology section ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Swipe to technology section ", e);
		}
	}
	
	@Step("Swiping to viral section on NavBar")
	public void swipingViralSectionNavBar() throws Exception {
		try {
			
			wait.waitForElement(
					navBar, 
					5,
					"Nav Bar",
					"verifiying on Section On NavBar"
				);
			
			gesture.SwipeLeftToRightDownTo(
					navBar, 
					viral,
					(float) 0.5,
					"Navigation bar",
					"viral section"
				);

			
			clickOn(viral, 
					"viral Button",
					"Navigation bar"
				);

			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Swipe to viral section ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Swipe to viral section ", e);
		}
	}
	
	@Step("Swiping to videos section on NavBar")
	public void swipingVideosSectionNavBar() throws Exception {
		try {
			
			wait.waitForElement(
					navBar, 
					5,
					"Nav Bar",
					"verifiying on Section On NavBar"
				);
			
			gesture.SwipeLeftToRightDownTo(
					navBar, 
					videos,
					(float) 0.5,
					"Navigation bar",
					"videos section"
				);

			
			clickOn(videos, 
					"videos Button",
					"Navigation bar"
				);

			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Swipe to videos section ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Swipe to videos section ", e);
		}
	}
	
	@Step("Swiping to photos section on NavBar")
	public void swipingPhotosSectionNavBar() throws Exception {
		try {
			
			wait.waitForElement(
					navBar, 
					5,
					"Nav Bar",
					"verifiying on Section On NavBar"
				);
			
			gesture.SwipeLeftToRightDownTo(
					navBar, 
					photos,
					(float) 0.5,
					"Navigation bar",
					"photos section"
				);

			
			clickOn(photos, 
					"photos Button",
					"Navigation bar"
				);

			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Swipe to photos section ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Swipe to photos section ", e);
		}
	}
	
	@Step("Comparing 1st Article Date with 2nd Article Date")
	public void comapringArticleDate() throws Exception {
		try {
			
			wait.waitForElement(
					firstArticleDate, 
					5,
					"First Article Update date",
					"verifiying on Section page"
				);
			
			String[] firstdate=getTexOfElement(firstArticleDate).split(" ");
			String[] seconddate=getTexOfElement(firstArticleDate).split(" ");
			
			if(firstdate[1].equalsIgnoreCase("hours") && seconddate[1].equalsIgnoreCase("hours"))
			{
				if(Integer.parseInt(firstdate[0]) > Integer.parseInt(seconddate[0]))
					Asserts.assertFail("2nd Article date is less than 1st Article");
			}
			else if(firstdate[1].equalsIgnoreCase("minutes") && seconddate[1].equalsIgnoreCase("minutes"))
			{
				if(Integer.parseInt(firstdate[0]) > Integer.parseInt(seconddate[0]))
					Asserts.assertFail("2nd Article date is less than 1st Article");
			}
			else if(firstdate[1].equalsIgnoreCase("hours") && seconddate[1].equalsIgnoreCase("minute"))
			{
					Asserts.assertFail("2nd Article date is less than 1st Article");
			}
			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Comparing 1st Article Date with 2nd Article Date ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Comparing 1st Article Date with 2nd Article Date ", e);
		}
	}
	
}
