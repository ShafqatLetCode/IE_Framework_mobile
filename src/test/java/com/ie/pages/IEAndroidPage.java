package com.ie.pages;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import com.ie.appium.utils.CommonAppiumTest;
import com.ie.common.utilities.AndroidAlert;
import com.ie.common.utilities.Asserts;
import com.ie.common.utilities.CommonAlertElements;
import com.ie.common.utilities.CommonTestData;
import com.ie.common.utilities.GestureUtils;
import com.ie.common.utilities.HandleException;
import com.ie.common.utilities.WaitUtils;
import com.ie.pageobjects.IEAndroidObject;
import com.ie.pages.androidpage.homePage;
import com.ie.pages.androidpage.settingPage;
import com.ie.pages.androidpage.loginPage;
import com.ie.pages.androidpage.preloginPage;
import com.ie.pages.androidpage.ePaperPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;

/**
 * @author Shafqat Ali
 *
 */
public class IEAndroidPage extends CommonAppiumTest {

	static Logger log = Logger.getLogger(IEAndroidPage.class.getName());
	public IEAndroidObject DBSappObject = new IEAndroidObject();
	public AppiumDriver<RemoteWebElement> driver = null;
	AndroidAlert androidAlert = null;
	WaitUtils wait = null;
	GestureUtils gestUtils = null;
	Asserts Assert = null;
	CommonAlertElements btnElements = null;
	HandleException obj_handleexception = null;
	settingPage settingPage = null;
	preloginPage preloginpage = null;
	loginPage loginpage = null;
	homePage homepage = null;
	ePaperPage epaperpage=null;

	
	public IEAndroidPage(AppiumDriver<RemoteWebElement> driver) throws Exception {
		super(driver);
		try {
			this.driver = driver;
			gestUtils = new GestureUtils(driver);
			androidAlert = new AndroidAlert(driver);
			wait = new WaitUtils(driver);
			gestUtils = new GestureUtils(driver);
			Assert = new Asserts();
			obj_handleexception = new HandleException(null, null);
			btnElements = new CommonAlertElements(driver);
			settingPage = new settingPage(driver);
			preloginpage = new preloginPage(driver);
			loginpage = new loginPage(driver);
			homepage = new homePage(driver);
			epaperpage= new ePaperPage(driver);
			PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), DBSappObject);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
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
			loginpage.ClickOnContinueButton();
			loginpage.enterTextInPasswordField(password);
			loginpage.ClickOnSignIn();
			loginpage.LoginValidation(userName);
			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Verify Login Validation ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Verify Login Validation ", e);
		}
	}
	
	@Step("Launch App")
	public void launchApp()
			throws Exception {
		try {
			homepage.updateAlert();
			homepage.VerifyHomePage();
			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Verify Launch App ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Verify Launch App ", e);
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
	
	@Step("PreLogin the App, select city and interest")
	public void preLogin()
			throws Exception {
		try {
			preloginpage.selectCity("Mumbai");
			preloginpage.continueButton();
			preloginpage.selectInterest("Technology", "Videos", "Opinion");
			preloginpage.continueButton();
			loginpage.ClickOnSignInLink();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Verify Login Validation ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Verify Login Validation ", e);
		}
	}
	
	@Step("LogIn the App")
	public void loginApp(String userName, String password)
			throws Exception {
		try {
			loginpage.enterTextInEmailField(userName);
			loginpage.ClickOnContinueButton();
			loginpage.enterTextInPasswordField(password);
			loginpage.ClickOnSignIn();
				
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Verify Login Validation ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Verify Login Validation ", e);
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
	
	@Step("login from Epaper")
	public void LoginFromEpaper(String userName, String password, String appName)
			throws Exception {
		try {
			
			epaperpage.ClickonLoginOnEpaper();
			loginpage.enterTextInEmailField(userName);
			loginpage.ClickOnContinueButton();
			loginpage.enterTextInPasswordField(password);
			loginpage.ClickOnSignIn();
			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Verify Login from epaper ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Verify Login from epaper ", e);
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
	
	@Step("Finding Premium tag and clicking on its article")
	public void validatePremiumTagAndClickOnAricle()
			throws Exception {
		try {
			homepage.scrollToPremiumArticle();
			homepage.ClickOnPremiumArticle();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Verify premium tag and its article", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Verify premium tag and its article", e);
		}
	}
	
	@Step("Clicking on Sign in  on Premium Wall on Article")
	public void signInFromPremiumWall(String userName, String password, String appName)
			throws Exception {
		try {
			homepage.scrollToPremiumRegisterButton();;
			homepage.ClickOnSignInOnPremiumArticle();
			loginpage.enterTextInEmailField(userName);
			loginpage.ClickOnContinueButton();
			loginpage.enterTextInPasswordField(password);
			loginpage.ClickOnSignIn();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Verify on Sign in  on Premium Wall on Article", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Verify on Sign in  on Premium Wall on Article", e);
		}
	}
	
	
	@Step("back From Epaper And Validate SignIn")
	public void backFromEpaperAndValidateSignIn(String userName, String password, String appName)
			throws Exception {
		try {
			epaperpage.verifyingEpaperNewsHeader();
			epaperpage.backButton();
			homepage.ClickOnSetting();
			loginpage.LoginValidation("mohit 10");
			homepage.ClickOnEpaper();
			epaperpage.verifyingEpaperNewsHeader();
			epaperpage.backButton();
			homepage.ClickOnSetting();
			loginpage.LoginValidation("mohit 10");
			homepage.ClickOnEpaper();
			epaperpage.verifyingEpaperNewsHeader();
			epaperpage.backButton();
			homepage.ClickOnSetting();
			loginpage.LoginValidation("mohit 10");
			homepage.ClickOnEpaper();
			epaperpage.verifyingEpaperNewsHeader();
			epaperpage.backButton();
			homepage.ClickOnSetting();
			loginpage.LoginValidation("mohit 10");
			homepage.ClickOnEpaper();
			epaperpage.verifyingEpaperNewsHeader();
			epaperpage.backButton();
			homepage.ClickOnSetting();
			loginpage.LoginValidation("mohit 10");
			homepage.ClickOnEpaper();
			epaperpage.verifyingEpaperNewsHeader();
			epaperpage.backButton();
			homepage.ClickOnSetting();
			loginpage.LoginValidation("mohit 10");
			homepage.ClickOnEpaper();
			epaperpage.verifyingEpaperNewsHeader();
			epaperpage.backButton();
			homepage.ClickOnSetting();
			loginpage.LoginValidation("mohit 10");
			homepage.ClickOnEpaper();
			epaperpage.verifyingEpaperNewsHeader();
			epaperpage.backButton();
			homepage.ClickOnSetting();
			loginpage.LoginValidation("mohit 10");
			homepage.ClickOnEpaper();
			epaperpage.verifyingEpaperNewsHeader();
			epaperpage.backButton();
			homepage.ClickOnSetting();
			loginpage.LoginValidation("mohit 10");
			homepage.ClickOnEpaper();
			epaperpage.verifyingEpaperNewsHeader();
			epaperpage.backButton();
			homepage.ClickOnSetting();
			loginpage.LoginValidation("mohit 10");
			homepage.ClickOnEpaper();
			epaperpage.verifyingEpaperNewsHeader();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Verify on Sign in  on Premium Wall on Article", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Verify on Sign in  on Premium Wall on Article", e);
		}
	}
	
	
	
//	@Step("logout from the setting")
//	public void logoutApp()
//			throws Exception {
//		try {
////			settingPage.cli;
////			epaperpage.verifyingEpaperWall();
//			
//		} catch (HandleException e) {
//			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Verify Non subscription ", e);
//		} catch (Exception e) {
//			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Verify Non subscription ", e);
//		}
//	}

	public void verifyAlertPresent() throws Exception {
		String alertMessage = null;
		try {
			wait.ImplicitlyWait(5);
			
//			if (isElementVisible2(launchpage.Authenticating_Bar()) || isElementVisible2(launchpage.progress_bar())
//					|| isElementVisible2(launchpage.progress_bar_imageview()))
//				alertMessage = "Wait Duration Limit exceeded :: Application Unable to load Page";
//			else if (isElementVisible2(launchpage.AlertTitle()))
//				alertMessage = launchpage.AlertTitle().getText() + ": " + launchpage.AlertBodyMessage().getText();
//			else if (isElementVisible2(launchpage.DigitalTokenUnderMaintenanceMessageHeader()))
//				alertMessage = launchpage.DigitalTokenUnderMaintenanceMessageHeader().getText() + ": "
//						+ launchpage.DigitalTokenUnderMaintenanceMessage().getText();
//			else if (isElementVisible2(launchpage.DigibankAlertHeaderElement()) && isElementVisible2(launchpage.ErrorMessgeElement()))
//				alertMessage = launchpage.DigibankAlertHeaderElement().getText() + ": "
//						+ launchpage.ErrorMessgeElement().getText();
//			else if (androidAlert.isAlertPresent())
//				alertMessage = this.driver.switchTo().alert().getText();
//			else if (isElementVisible2(launchpage.quitBtn()))
//				alertMessage = "Application Crash Issue";
//			
//			if (alertMessage != null) {
//				System.out.println("alertMessage :: " + alertMessage);
//				Asserts.assertFail(alertMessage);
//			}
			
			wait.ImplicitlyWait(15);
		} catch (Exception e) {
			obj_handleexception.throwException("ALERT",
					" Failed to proceed because of ALERT " + alertMessage, e);
		}
	}
}
