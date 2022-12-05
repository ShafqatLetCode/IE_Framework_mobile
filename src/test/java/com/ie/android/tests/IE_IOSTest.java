package com.ie.android.tests;

import org.apache.log4j.Logger;
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
public class IE_IOSTest extends UserBaseTest {

	Logger logger = Logger.getLogger(IE_AndroidTest.class.getName());
	IE_IOSpage DBSPgaeObject1 = null;
	
	@Epic("Log In with different Senario")
	@Feature(value =  "Login" ) 
	@Story("Login with setting")
	@Parameters({ "userName", "password", "app_Name" })
	@Test(priority = 1, enabled = true, description = "Testcase01_validating Login with correct user", retryAnalyzer = RetryAnalyzer.class)
	@Author(name = "Shafqat Ali")
	public void TestCase01_loginInApp(String userName, String password , String app_Name) throws Exception {
		try {
			IE_IOSpage IEpage = new IE_IOSpage(driver);
		    IEpage.loginApp(userName,password,app_Name);
		} catch (HandleException e) {
			//dbspage1.verifyAlertPresent();
			Asserts.assertFail(e.getCode()+"--> "+ e.getMessage());
		}
		catch (Exception e) {
			//dbspage1.verifyAlertPresent();
			Asserts.assertFail( "Unable to execute Pre-Requisite Script "+e.getMessage());
		}
	}
//	
	@Epic("Log In with different Senario")
	@Feature(value =  "Login" ) 
	@Story("Varify non subscription After Login")
	@Parameters({ "userName", "password", "app_Name" })
	@Test(priority = 2, enabled = true, description = "Testcase02_Verify non subscription After Login", retryAnalyzer = RetryAnalyzer.class)
	@Author(name = "Shafqat Ali")
	public void TestCase02_varifyNonSubcriptionAfterLogin(String userName, String password , String app_Name) throws Exception {
		try {
			IE_IOSpage IEpage = new IE_IOSpage(driver);
		    IEpage.loginApp(userName,password,app_Name);
		    IEpage.validateNonSubscription();
		} catch (HandleException e) {
			//dbspage1.verifyAlertPresent();
			Asserts.assertFail(e.getCode()+"--> "+ e.getMessage());
		}
		catch (Exception e) {
			//dbspage1.verifyAlertPresent();
			Asserts.assertFail( "Unable to execute TestCase02 Script "+e.getMessage());
		}
	}
//	
	@Epic("Log In with different Senario")
	@Feature(value =  "Login" ) 
	@Story("Varify non subscription After Login")
	@Parameters({ "userName", "password", "app_Name" })
	@Test(priority = 3, enabled = true, description = "TestCase03 varify Non Subcription Epaper After Login", retryAnalyzer = RetryAnalyzer.class)
	@Author(name = "Shafqat Ali")
	public void TestCase03_varifyNonSubcriptionEpaperAfterLogin(String userName, String password , String app_Name) throws Exception {
		try {
			IE_IOSpage IEpage = new IE_IOSpage(driver);
		    IEpage.loginApp(userName,password,app_Name);
		    IEpage.validateNonSubscriptionForEpaper();
		} catch (HandleException e) {
			//dbspage1.verifyAlertPresent();
			Asserts.assertFail(e.getCode()+"--> "+ e.getMessage());
		}
		catch (Exception e) {
			//dbspage1.verifyAlertPresent();
			Asserts.assertFail( "Unable to execute TestCase03 Script "+e.getMessage());
		}
	}
	
	@Epic("Log out from app")
	@Feature(value =  "Logout" ) 
	@Story("verify logout")
	@Parameters({ "userName", "password", "app_Name" })
	@Test(priority = 3, enabled = true, description = "TestCase04 Logout from the app", retryAnalyzer = RetryAnalyzer.class)
	@Author(name = "Shafqat Ali")
	public void TestCase04_LogoutFromtheApp(String userName, String password , String app_Name) throws Exception {
		try {
			IE_IOSpage IEpage = new IE_IOSpage(driver);
		    IEpage.loginApp(userName,password,app_Name);
		    IEpage.logoutApp();
		} catch (HandleException e) {
			//dbspage1.verifyAlertPresent();
			Asserts.assertFail(e.getCode()+"--> "+ e.getMessage());
		}
		catch (Exception e) {
			//dbspage1.verifyAlertPresent();
			Asserts.assertFail( "Unable to execute TestCase04 Script "+e.getMessage());
		}
	}
	
	@Epic("Log In with different Senario")
	@Feature(value =  "Login" ) 
	@Story("verify epaper login from non subscription")
	@Parameters({ "userName", "password", "app_Name" })
	@Test(priority = 3, enabled = true, description = "TestCase05 Login from epaper non subsciption", retryAnalyzer = RetryAnalyzer.class)
	@Author(name = "Shafqat Ali")
	public void TestCase05_LoginFromEpaperNonSubscription(String userName, String password , String app_Name) throws Exception {
		try {
			IE_IOSpage IEpage = new IE_IOSpage(driver);
			IEpage.launchApp();
		    IEpage.validateEpaperwall();
		    IEpage.LoginFromEpaper("demo12345@mailinator.com","87654321", app_Name);
		    IEpage.validateNonSubscriptionForEpaperwall();
		} catch (HandleException e) {
			//dbspage1.verifyAlertPresent();
			Asserts.assertFail(e.getCode()+"--> "+ e.getMessage());
		}
		catch (Exception e) {
			//dbspage1.verifyAlertPresent();
			Asserts.assertFail( "Unable to execute TestCase05 Script "+e.getMessage());
		}
	}
	
	@Epic("Log In with different Senario")
	@Feature(value =  "Login" ) 
	@Story("verify epaper login from  subscription")
	@Parameters({ "userName", "password", "app_Name" })
	@Test(priority = 3, enabled = true, description = "TestCase06 Login from epaper subsciption", retryAnalyzer = RetryAnalyzer.class)
	@Author(name = "Shafqat Ali")
	public void TestCase06_LoginFromEpaperSubscription(String userName, String password , String app_Name) throws Exception {
		try {
			IE_IOSpage IEpage = new IE_IOSpage(driver);
			IEpage.launchApp();
		    IEpage.validateEpaperwall();
		    IEpage.LoginFromEpaper("mohit10@mailinator.com","123456", app_Name);
		    IEpage.validateSubscriptionForEpaperwall();
		} catch (HandleException e) {
			//dbspage1.verifyAlertPresent();
			Asserts.assertFail(e.getCode()+"--> "+ e.getMessage());
		}
		catch (Exception e) {
			//dbspage1.verifyAlertPresent();
			Asserts.assertFail( "Unable to execute TestCase06 Script "+e.getMessage());
		}
	}
}
