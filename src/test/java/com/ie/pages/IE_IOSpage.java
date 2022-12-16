package com.ie.pages;

import java.util.logging.Logger;

import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.RemoteWebElement;

import com.ie.annotation.values.ElementDescription;
import com.ie.appium.utils.CommonAppiumTest;
import com.ie.common.utilities.AndroidAlert;
import com.ie.common.utilities.Asserts;
import com.ie.common.utilities.CommonTestData;
import com.ie.common.utilities.GestureUtils;
import com.ie.common.utilities.HandleException;
import com.ie.pageobjects.IE_IOSObject;
import com.ie.pages.iospage.homePage;
import com.ie.pages.iospage.settingPage;
import com.ie.pages.iospage.loginPage;
import com.ie.pages.iospage.preloginPage;
import com.ie.pages.iospage.ePaperPage;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class IE_IOSpage extends CommonAppiumTest {

	static Logger log = Logger.getLogger(IEAndroidPage.class.getName());
	public IE_IOSObject IOShomePgaeObject = new IE_IOSObject(driver);
	CommonAppiumTest commonAppTest = null;
	AndroidAlert androidAlert = null;
	GestureUtils gestUtils = null;
	HandleException obj_handleexception = null;
	homePage homepage = null;
	ePaperPage epaperpage = null;
	loginPage loginpage = null;
	preloginPage preloginpage = null;
	settingPage settingPage = null;
	

	public IE_IOSpage(AppiumDriver<RemoteWebElement> driver) throws Exception {
		super(driver);
		
		gestUtils = new GestureUtils(driver);
		commonAppTest = new CommonAppiumTest(driver);
		androidAlert = new AndroidAlert(driver);
		homepage = new homePage(driver);
		epaperpage = new ePaperPage(driver);
		obj_handleexception = new HandleException(null, null);
		loginpage = new loginPage(driver);
		preloginpage = new preloginPage(driver);
		settingPage = new settingPage(driver);
		
		// PageFactory.initElements(new AppiumFieldDecorator(driver,
		// Duration.ofSeconds(5)), IOShomePgaeObject);
	}
	
	@Step("LogIn the App")
	public void loginApp(String userName, String password, String appName)
			throws Exception {
		try {
			homepage.updateAlert();
			homepage.VerifyHomePage();
			homepage.ClickOnSetting();
			settingPage.ClickOnLogin();
			loginpage.enterTextInEmailField(userName);
			loginpage.clickOnDoneButton();
			loginpage.ClickOnContinueButton();
			loginpage.enterTextInPasswordField(password);
			loginpage.clickOnDoneButton();
			loginpage.ClickOnSignIn();
			//loginpage.LoginValidation("demo12345@mailinator.com");
			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Verify Header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Verify Header ", e);
		}
	}
	
	@Step("Handling Customise user journey if present")
	public void SkippingCustomiseUserJourney()throws Exception {
		try {
			homepage.updateAlert();
			if(preloginpage.isCustomiseJourneyPresent()) 
			{
				preloginpage.continueButton();
				preloginpage.handlingSelectInterest();
				loginpage.skippingLoginPage();
			}
			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " unable to handle customise user journey ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " unable to handle customise user journey ", e);
		}
	}

	
	@Step("validation non subscription")
	public void validateNonSubscription()
			throws Exception {
		try {
			loginpage.subscription();
			loginpage.nonSubscriptionValid();
			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Verify Non subscription ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Verify Non subscription ", e);
		}
	}
	
	@Step("validation non subscription for epaper")
	public void validateNonSubscriptionForEpaper()
			throws Exception {
		try {
			homepage.ClickOnEpaper();
			epaperpage.verifyingEpaperWall();
			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Verify Non subscription ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Verify Non subscription ", e);
		}
	}
	
	@Step("Logout From App")
	public void logoutApp()
			throws Exception {
		try {
			settingPage.profileLink();
			settingPage.ClickOnLogout();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Verify Logout ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Verify Logout ", e);
		}
	}
	
	@Step("validation non subscription for epaper")
	public void validateEpaperwall()
			throws Exception {
		try {
			homepage.ClickOnEpaper();
			epaperpage.verifyingEpaperWalltitle();
			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Verify Non subscription ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Verify Non subscription ", e);
		}
	}
	
	@Step("login from Epaper")
	public void LoginFromEpaper(String userName, String password, String appName)
			throws Exception {
		try {
			
			epaperpage.ClickonLoginOnEpaper();
			loginpage.enterTextInEmailField(userName);
			loginpage.clickOnDoneButton();
			loginpage.ClickOnContinueButton();
			loginpage.enterTextInPasswordField(password);
			loginpage.clickOnDoneButton();
			loginpage.ClickOnSignIn();
			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Verify Login from epaper ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Verify Login from epaper ", e);
		}
	}
	
	@Step("validation Non subscription for epaper")
	public void validateNonSubscriptionForEpaperwall()
			throws Exception {
		try {
			epaperpage.verifyingEpaperWall();
			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Verify  non subscription header", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Verify  non subscription header", e);
		}
	}
	
	@Step("validation subscription for epaper")
	public void validateSubscriptionForEpaperwall()
			throws Exception {
		try {
			epaperpage.verifyingEpaperNewsHeader();
			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Verify  subscription header", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Verify  subscription header", e);
		}
	}
	
	@Step("validation non subscription for epaper")
	public void validateNonSubscriptionForEpaper(boolean isBack)
			throws Exception {
		try {
			homepage.ClickOnEpaper();
			epaperpage.verifyingEpaperWall();
			if(isBack)
			{
				driver.navigate().back();
			}
			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Verify Epaper wall for Non subscription ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Verify Epaper wall for Non subscription ", e);
		}
	}
	
	@Step("Finding Premium tag and clicking on its article")
	public void validatePremiumTagAndClickOnAricle()
			throws Exception {
		try {
			homepage.ClickOnBottomNaHome();
			homepage.scrollToPremiumArticle();
			homepage.ClickOnPremiumArticle();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Verify premium tag and its article", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Verify premium tag and its article", e);
		}
	}
	
	@Step("Validating Premium wall for non subscriber user")
	public void validatindPremiumWall()
			throws Exception {
		try {
			homepage.scrollToPremiumRegisterButton();
			homepage.validatingPremiumArticleWall();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Validating Premium Wall for non subscriber user", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Validating Premium Wall for non subscriber user", e);
		}
	}
	
	@Step("validation non subscription for epaper")
	public void validateSubscriptionForEpaper(boolean isBack)
			throws Exception {
		try {
			
			homepage.ClickOnEpaper();
			epaperpage.verifyingEpaperWallNotPresent();
			epaperpage.verifyingEpaperNewsHeader();
			if(isBack)
			{
			epaperpage.backButton();
			}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Verify Epaper wall not present ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Verify Epaper wall not present ", e);
		}
	}
	
	@Step("Validating Premium wall for subscriber user")
	public void validatindPremiumWallDoesntExist()
			throws Exception {
		try {
			homepage.scrollToCheckPremiumRegisterWallDoesntExist();
			//homepage.validatingPremiumArticleWall();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Validating Premium Wall for subscriber user", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Validating Premium Wall for subscriber user", e);
		}
	}
	
	

//	public void verifyDigibankAlert() throws Exception {
//		String alertMessage = null;
//		try {
//			wait.ImplicitlyWait(2);
//			if (androidAlert.isIOSAlertPresent()) {
//				System.out.println("Alert title :: " + this.driver.findElementByXPath(
//						"//XCUIElementTypeStaticText[@name='digibank Alert']/following-sibling::XCUIElementTypeStaticText")
//						.getText());
//
//				alertMessage = this.driver.findElementByXPath("//XCUIElementTypeStaticText[@name='digibank Alert']")
//						.getText()
//						+ ": "
//						+ this.driver.findElementByXPath(
//								"//XCUIElementTypeStaticText[@name='digibank Alert']/following-sibling::XCUIElementTypeStaticText")
//								.getText();
//				Asserts.assertFail(alertMessage);
//			} else if (androidAlert.isIOSOfflineAlertPresent()) {
//				System.out.println("Alert title :: " + this.driver.findElementByXPath(
//						"//XCUIElementTypeStaticText[@name='You seem to be offline']/following-sibling::XCUIElementTypeStaticText")
//						.getText());
//
//				alertMessage = this.driver
//						.findElementByXPath("//XCUIElementTypeStaticText[@name='You seem to be offline']").getText()
//						+ ": "
//						+ this.driver.findElementByXPath(
//								"//XCUIElementTypeStaticText[@name='You seem to be offline']/following-sibling::XCUIElementTypeStaticText")
//								.getText();
//				Asserts.assertFail(alertMessage);
//			}else if (androidAlert.isDigitalTokenMainAlertPresent()) {
//				System.out.println("Alert title :: " + this.driver.findElementByXPath(
//						"//XCUIElementTypeStaticText[@name='Digital token under maintenance']/following-sibling::XCUIElementTypeStaticText")
//						.getText());
//
//				alertMessage = this.driver
//						.findElementByXPath("//XCUIElementTypeStaticText[@name='Digital token under maintenance']").getText()
//						+ ": "
//						+ this.driver.findElementByXPath(
//								"//XCUIElementTypeStaticText[@name='Digital token under maintenance']/following-sibling::XCUIElementTypeStaticText")
//								.getText();
//				Asserts.assertFail(alertMessage);
//			} 
//			else if (androidAlert.isAlertPresent()) {
//				System.out.println("Alert title :: " + this.driver.switchTo().alert().getText());
//
//				alertMessage = this.driver.switchTo().alert().getText();
//				Asserts.assertFail(alertMessage);
//
//			} else {
//				wait.ImplicitlyWait(10);
//				verifyWaitForPageLoad();
//			}
//		} catch (Exception e) {
//			obj_handleexception.throwException("ALERT",
//					" Failed to proceed because of ALERT " + alertMessage, e);
//		}
//	}
//


}
