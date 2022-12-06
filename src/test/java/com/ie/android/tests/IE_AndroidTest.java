package com.ie.android.tests;

import java.util.logging.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ie.annotation.values.Author;
import com.ie.base.UserBaseTest;
import com.ie.common.utilities.Asserts;
import com.ie.common.utilities.CommonTestData;
import com.ie.common.utilities.HandleException;
import com.ie.listeners.RetryAnalyzer;
import com.ie.listeners.TestListener;
import com.ie.pages.IEAndroidPage;
import com.ie.pages.IE_IOSpage;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

@Listeners(TestListener.class)
public class IE_AndroidTest extends UserBaseTest {
	
	Asserts Assert = null;
	IEAndroidPage dbspage1 = null;

	public IE_AndroidTest() throws Exception {
		super();
		Assert = new Asserts();
	}
	
	Logger logger = Logger.getLogger(IE_AndroidTest.class.getName());
	
	/******************Start Test Script For IE App************************************/
	
	@Epic("Log In with different Senario")
	@Feature(value =  "Validating Epaper wall for non subcriber user" ) 
	@Story("Login with setting")
	@Parameters({ "userName", "password", "app_Name" })
	@Test(priority = 1, enabled = true, description = "TestCase01 validating Epaper Wall with non Subscriber user", retryAnalyzer = RetryAnalyzer.class)
	@Author(name = "Shafqat Ali")
	public void TestCase01_verifyEpaperWallForNonSubscriber(String userName, String password , String app_Name) throws Exception {
		try {
			IEAndroidPage IEpage = new IEAndroidPage(driver);
			IEpage.SkippingCustomiseUserJourney();
		    IEpage.loginApp("nonsubscriberuser@mailinator.com", "123456",app_Name);
		    IEpage.validateNonSubscriptionForEpaper(false);
		} catch (HandleException e) {
			Asserts.assertFail(e.getCode()+"--> "+ e.getMessage());
		}
		catch (Exception e) {
			Asserts.assertFail( "Unable to execute TestCase01 \" validating Epaper Wall with non Subscriber user Script \" "+e.getMessage());
		}
	}
	
	@Epic("Log In with different Senario")
	@Feature(value =  "validating Epaper wall for non subcriber user" ) 
	@Story("Login with setting")
	@Parameters({ "userName", "password", "app_Name" })
	@Test(priority = 7, enabled = true, description = "TestCase02 validating premium Wall with non Subscriber user", retryAnalyzer = RetryAnalyzer.class)
	@Author(name = "Shafqat Ali")
	public void TestCase02_verifyPremiumForNonSubscriber(String userName, String password , String app_Name) throws Exception {
		try {
			IEAndroidPage IEpage = new IEAndroidPage(driver);
			IEpage.SkippingCustomiseUserJourney();
			IEpage.loginApp("nonsubscriberuser@mailinator.com", "123456",app_Name);
			IEpage.validatePremiumTagAndClickOnAricle();
			IEpage.validatindPremiumWall();
		} catch (HandleException e) {
			Asserts.assertFail(e.getCode()+"--> "+ e.getMessage());
		}
		catch (Exception e) {
			Asserts.assertFail( "Unable to execute TestCase02 \" validating premium Wall with non Subscriber user \" "+e.getMessage());
		}
	}
	
	@Epic("Log In with different Senario")
	@Feature(value =  "Validating Epaper wall for epaper subcriber user" ) 
	@Story("Login with setting")
	@Parameters({ "userName", "password", "app_Name" })
	@Test(priority = 3, enabled = true, description = "TestCase03 validating Epaper Wall with Subscriber user", retryAnalyzer = RetryAnalyzer.class)
	@Author(name = "Shafqat Ali")
	public void TestCase03_verifyEpaperWallForSubscriber(String userName, String password , String app_Name) throws Exception {
		try {
			IEAndroidPage IEpage = new IEAndroidPage(driver);
			IEpage.SkippingCustomiseUserJourney();
		    IEpage.loginApp("mohit10@mailinator.com", "123456",app_Name);
		    IEpage.validateSubscriptionForEpaper(false);
		} catch (HandleException e) {
			Asserts.assertFail(e.getCode()+"--> "+ e.getMessage());
		}
		catch (Exception e) {
			Asserts.assertFail( "Unable to execute TestCase03 \" validating Epaper Wall with non Subscriber user Script \" "+e.getMessage());
		}
	}
	
	@Epic("Log In with different Senario")
	@Feature(value =  "Validating Epaper wall for Premium  user" ) 
	@Story("Login with setting")
	@Parameters({ "userName", "password", "app_Name" })
	@Test(priority = 4, enabled = true, description = "TestCase04 validating premium Wall with Digital Subscriber user", retryAnalyzer = RetryAnalyzer.class)
	@Author(name = "Shafqat Ali")
	public void TestCase04_verifyPrimeiumWallForSubscriber(String userName, String password , String app_Name) throws Exception {
		try {
			IEAndroidPage IEpage = new IEAndroidPage(driver);
			IEpage.SkippingCustomiseUserJourney();
		    IEpage.loginApp("mohit20@mailinator.com", "123456",app_Name);
		    IEpage.validatePremiumTagAndClickOnAricle();
		    IEpage.validatindPremiumWallDoesntExist();
		} catch (HandleException e) {
			Asserts.assertFail(e.getCode()+"--> "+ e.getMessage());
		}
		catch (Exception e) {
			Asserts.assertFail( "Unable to execute TestCase04 \" validating validating premium Wall with Digital Subscriber user Script \" "+e.getMessage());
		}
	}
	
	@Epic("Log In with different Senario")
	@Feature(value =  "Validating Epaper wall for Premium  user" ) 
	@Story("Login with setting")
	@Parameters({ "userName", "password", "app_Name" })
	@Test(priority = 5, enabled = true, description = "TestCase05 validating premium Wall and Epaper with Combo Subscriber user", retryAnalyzer = RetryAnalyzer.class)
	@Author(name = "Shafqat Ali")
	public void TestCase05_verifyEpaperPrimeiumWallForSubscriber(String userName, String password , String app_Name) throws Exception {
		try {
			IEAndroidPage IEpage = new IEAndroidPage(driver);
			IEpage.SkippingCustomiseUserJourney();
		    IEpage.loginApp("mohit30@mailinator.com", "123456",app_Name);
		    IEpage.validateSubscriptionForEpaper(true);
		    IEpage.validatePremiumTagAndClickOnAricle();
		    IEpage.validatindPremiumWallDoesntExist();
		} catch (HandleException e) {
			Asserts.assertFail(e.getCode()+"--> "+ e.getMessage());
		}
		catch (Exception e) {
			Asserts.assertFail( "Unable to execute TestCase04 \" validating validating premium Wall and Epaper wall with combo Subscriber user Script \" "+e.getMessage());
		}
	}
	
	@Epic("Log In with different Senario")
	@Feature(value =  "Validating Epaper wall and Premium for non subscriber user" ) 
	@Story("Login with setting")
	@Parameters({ "userName", "password", "app_Name" })
	@Test(priority = 6, enabled = true, description = "TestCase06 validating premium Wall and Epaper with non Subscriber user", retryAnalyzer = RetryAnalyzer.class)
	@Author(name = "Shafqat Ali")
	public void TestCase06_verifyEpaperPrimeiumWallForNonSubscriber(String userName, String password , String app_Name) throws Exception {
		try {
			IEAndroidPage IEpage = new IEAndroidPage(driver);
			IEpage.SkippingCustomiseUserJourney();
		    IEpage.loginApp("nonsubscriberuser@mailinator.com", "123456",app_Name);
		    IEpage.validateNonSubscriptionForEpaper(true);
		    IEpage.validatePremiumTagAndClickOnAricle();
		    IEpage.validatindPremiumWall();
		} catch (HandleException e) {
			Asserts.assertFail(e.getCode()+"--> "+ e.getMessage());
		}
		catch (Exception e) {
			Asserts.assertFail( "Unable to execute TestCase04 \" validating validating premium Wall and Epaper wall with combo Subscriber user Script \" "+e.getMessage());
		}
	}
	
//	@Epic("Log In with different Senario")
//	@Feature(value =  "Login" ) 
//	@Story("Varify non subscription After Login")
//	@Parameters({ "userName", "password", "app_Name" })
//	@Test(priority = 3, enabled = true, description = "TestCase02 varify Non Subcription After Login", retryAnalyzer = RetryAnalyzer.class)
//	@Author(name = "Shafqat Ali")
//	public void TestCase02_varifyNonSubcriptionAfterLogin(String userName, String password , String app_Name) throws Exception {
//		try {
//			IEAndroidPage IEpage = new IEAndroidPage(driver);
//		    IEpage.loginApp("nonsubscriberuser@mailinator.com","87654321",app_Name);
//		    IEpage.validateNonSubscription();
//		} catch (HandleException e) {
//			dbspage1.verifyAlertPresent();
//			Asserts.assertFail(e.getCode()+"--> "+ e.getMessage());
//		}
//		catch (Exception e) {
//			//dbspage1.verifyAlertPresent();
//			Asserts.assertFail( "Unable to execute TestCase03 Script "+e.getMessage());
//		}
//	}
//	
//	@Epic("Log In with different Senario")
//	@Feature(value =  "Login" ) 
//	@Story("Varify non subscription After Login")
//	@Parameters({ "userName", "password", "app_Name" })
//	@Test(priority = 3, enabled = true, description = "TestCase03 varify Non Subcription Epaper After Login", retryAnalyzer = RetryAnalyzer.class)
//	@Author(name = "Shafqat Ali")
//	public void TestCase03_varifyNonSubcriptionEpaperAfterLogin(String userName, String password , String app_Name) throws Exception {
//		try {
//			IEAndroidPage IEpage = new IEAndroidPage(driver);
//		    IEpage.loginApp("demo12345@mailinator.com","87654321",app_Name);
//		    IEpage.validateNonSubscriptionForEpaper();
//		} catch (HandleException e) {
//			//dbspage1.verifyAlertPresent();
//			Asserts.assertFail(e.getCode()+"--> "+ e.getMessage());
//		}
//		catch (Exception e) {
//			//dbspage1.verifyAlertPresent();
//			Asserts.assertFail( "Unable to execute TestCase03 Script "+e.getMessage());
//		}
//	}
//	
//	@Epic("Log out from app")
//	@Feature(value =  "Logout" ) 
//	@Story("verify logout")
//	@Parameters({ "userName", "password", "app_Name" })
//	@Test(priority = 3, enabled = true, description = "TestCase04 Logout from the app", retryAnalyzer = RetryAnalyzer.class)
//	@Author(name = "Shafqat Ali")
//	public void TestCase04_LogoutFromtheApp(String userName, String password , String app_Name) throws Exception {
//		try {
//			IEAndroidPage IEpage = new IEAndroidPage(driver);
//		    IEpage.loginApp("demo12345@mailinator.com","87654321",app_Name);
//		    IEpage.logoutApp();
//		} catch (HandleException e) {
//			//dbspage1.verifyAlertPresent();
//			Asserts.assertFail(e.getCode()+"--> "+ e.getMessage());
//		}
//		catch (Exception e) {
//			//dbspage1.verifyAlertPresent();
//			Asserts.assertFail( "Unable to execute TestCase04 Script "+e.getMessage());
//		}
//	}
//	
//	@Epic("Log In with different Senario")
//	@Feature(value =  "Login" ) 
//	@Story("verify epaper login from non subscription")
//	@Parameters({ "userName", "password", "app_Name" })
//	@Test(priority = 3, enabled = true, description = "TestCase05 Login from epaper non subsciption", retryAnalyzer = RetryAnalyzer.class)
//	@Author(name = "Shafqat Ali")
//	public void TestCase05_LoginFromEpaperNonSubscription(String userName, String password , String app_Name) throws Exception {
//		try {
//			IEAndroidPage IEpage = new IEAndroidPage(driver);
//			IEpage.launchApp();
//		    IEpage.validateEpaperwall();
//		    IEpage.LoginFromEpaper("demo12345@mailinator.com","87654321", app_Name);
//		    IEpage.validateNonSubscriptionForEpaperwall();
//		} catch (HandleException e) {
//			//dbspage1.verifyAlertPresent();
//			Asserts.assertFail(e.getCode()+"--> "+ e.getMessage());
//		}
//		catch (Exception e) {
//			//dbspage1.verifyAlertPresent();
//			Asserts.assertFail( "Unable to execute TestCase05 Script "+e.getMessage());
//		}
//	}
//	
//	@Epic("Log In with different Senario")
//	@Feature(value =  "Login" ) 
//	@Story("verify epaper login from  subscription")
//	@Parameters({ "userName", "password", "app_Name" })
//	@Test(priority = 6, enabled = true, description = "TestCase06 Login from epaper subsciption", retryAnalyzer = RetryAnalyzer.class)
//	@Author(name = "Shafqat Ali")
//	public void TestCase05_LoginFromEpaperSubscription(String userName, String password , String app_Name) throws Exception {
//		try {
//			IEAndroidPage IEpage = new IEAndroidPage(driver);
//			IEpage.launchApp();
//		    IEpage.validateEpaperwall();
//		    IEpage.LoginFromEpaper("mohit10@mailinator.com","123456", app_Name);
//		    IEpage.validateSubscriptionForEpaperwall();
//		} catch (HandleException e) {
//			//dbspage1.verifyAlertPresent();
//			Asserts.assertFail(e.getCode()+"--> "+ e.getMessage());
//		}
//		catch (Exception e) {
//			//dbspage1.verifyAlertPresent();
//			Asserts.assertFail( "Unable to execute TestCase05 Script "+e.getMessage());
//		}
//	}
//
//	@Epic("Log In with different Senario")
//	@Feature(value =  "Login" ) 
//	@Story("verify epaper login from  subscription")
//	@Parameters({ "userName", "password", "app_Name" })
//	@Test(priority = 7, enabled = true, description = "TestCase07 Login from premium Article subsciption", retryAnalyzer = RetryAnalyzer.class)
//	@Author(name = "Shafqat Ali")
//	public void TestCase07_LoginFromPremiumArticleSubscription(String userName, String password , String app_Name) throws Exception {
//		try {
//			IEAndroidPage IEpage = new IEAndroidPage(driver);
//			IEpage.launchApp();
//		    IEpage.validatePremiumTagAndClickOnAricle();
//		    IEpage.signInFromPremiumWall("mohit30@mailinator.com","123456", app_Name);
//		} catch (HandleException e) {
//			//dbspage1.verifyAlertPresent();
//			Asserts.assertFail(e.getCode()+"--> "+ e.getMessage());
//		}
//		catch (Exception e) {
//			//dbspage1.verifyAlertPresent();
//			Asserts.assertFail( "Unable to execute TestCase05 Script "+e.getMessage());
//		}
//	}
//	@Epic("Log In with different Senario")
//	@Feature(value =  "Login" ) 
//	@Story("verify epaper login from  subscription")
//	@Parameters({ "userName", "password", "app_Name" })
//	@Test(priority = 3, enabled = true, description = "TestCase06 Login from epaper subsciption", retryAnalyzer = RetryAnalyzer.class)
//	@Author(name = "Shafqat Ali")
//	public void TestCase06_LoginFromEpaperSubscription(String userName, String password , String app_Name) throws Exception {
//		try {
//			IEAndroidPage IEpage = new IEAndroidPage(driver);
//			IEpage.launchApp();
//		    IEpage.validateEpaperwall();
//		    IEpage.LoginFromEpaper("mohit10@mailinator.com","123456", app_Name);
//		    IEpage.validateSubscriptionForEpaperwall();
//		} catch (HandleException e) {
//			//dbspage1.verifyAlertPresent();
//			Asserts.assertFail(e.getCode()+"--> "+ e.getMessage());
//		}
//		catch (Exception e) {
//			//dbspage1.verifyAlertPresent();
//			Asserts.assertFail( "Unable to execute TestCase06 Script "+e.getMessage());
//		}
//	}
//	
//	@Epic("Log In with different Senario")
//	@Feature(value =  "Login" ) 
//	@Story("verify epaper login from  subscription")
//	@Parameters({ "userName", "password", "app_Name" })
//	@Test(priority = 3, enabled = true, description = "TestCase08 Login from epaper subsciption and checking e-wall", retryAnalyzer = RetryAnalyzer.class)
//	@Author(name = "Shafqat Ali")
//	public void TestCase07_bugcatcher(String userName, String password , String app_Name) throws Exception {
//		try {
//			IEAndroidPage IEpage = new IEAndroidPage(driver);
//			IEpage.launchApp();
//		    IEpage.validateEpaperwall();
//		    IEpage.LoginFromEpaper("mohit10@mailinator.com","123456", app_Name);
//		    IEpage.backFromEpaperAndValidateSignIn("mohit10@mailinator.com","123456", app_Name);
//		} catch (HandleException e) {
//			//dbspage1.verifyAlertPresent();
//			Asserts.assertFail(e.getCode()+"--> "+ e.getMessage());
//		}
//		catch (Exception e) {
//			//dbspage1.verifyAlertPresent();
//			Asserts.assertFail( "Unable to execute TestCase07 Script "+e.getMessage());
//		}
//	}
//	
//	@Epic("Log In with different Senario")
//	@Feature(value =  "Login" ) 
//	@Story("Selecting City, Interest on post Launch")
//	@Parameters({ "userName", "password", "app_Name" })
//	@Test(priority = 1, enabled = true, description = "PostLaunch Login", retryAnalyzer = RetryAnalyzer.class)
//	@Author(name = "Shafqat Ali")
//	public void TestCase01_PostLaunchSetup(String userName, String password , String app_Name) throws Exception {
//		try {
//			IEAndroidPage IEpage = new IEAndroidPage(driver);
//		    IEpage.preLogin();
//		    IEpage.loginApp("mohit10@mailinator.com", "123456");
//		} catch (HandleException e) {
//			dbspage1.verifyAlertPresent();
//			Asserts.assertFail(e.getCode()+"--> "+ e.getMessage());
//		}
//		catch (Exception e) {
//			dbspage1.verifyAlertPresent();
//			Asserts.assertFail( "Unable to execute TestCase01 Script "+e.getMessage());
//		}
//	}
	/******************End Test Script For IE App************************************/
}
