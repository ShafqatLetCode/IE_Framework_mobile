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
	IE_IOSpage IEPgaeObject1 = null;
	
	/******************Start Test Script For IE App************************************/
	
	@Epic("Log In with different Senario")
	@Feature(value =  "Validating Epaper wall for non subcriber user" ) 
	@Story("Login with setting")
	@Parameters({ "userName", "password", "app_Name" })
	@Test(priority = 1, enabled = true, description = "TestCase01 validating Epaper Wall with non Subscriber user", retryAnalyzer = RetryAnalyzer.class)
	@Author(name = "Shafqat Ali")
	public void TestCase01_verifyEpaperWallForNonSubscriber(String userName, String password , String app_Name) throws Exception {
		try {
			IE_IOSpage IEpage = new IE_IOSpage(driver);
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
	@Test(priority = 2, enabled = true, description = "TestCase02 validating premium Wall with non Subscriber user", retryAnalyzer = RetryAnalyzer.class)
	@Author(name = "Shafqat Ali")
	public void TestCase02_verifyPremiumForNonSubscriber(String userName, String password , String app_Name) throws Exception {
		try {
			IE_IOSpage IEpage = new IE_IOSpage(driver);
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
			IE_IOSpage IEpage = new IE_IOSpage(driver);
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
			IE_IOSpage IEpage = new IE_IOSpage(driver);
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
			IE_IOSpage IEpage = new IE_IOSpage(driver);
			IEpage.SkippingCustomiseUserJourney();
		    IEpage.loginApp("mohit30@mailinator.com", "123456",app_Name);
		    IEpage.validateSubscriptionForEpaper(true);
		    IEpage.validatePremiumTagAndClickOnAricle();
		    IEpage.validatindPremiumWallDoesntExist();
		} catch (HandleException e) {
			Asserts.assertFail(e.getCode()+"--> "+ e.getMessage());
		}
		catch (Exception e) {
			Asserts.assertFail( "Unable to execute TestCase05 \" validating validating premium Wall and Epaper wall with combo Subscriber user Script \" "+e.getMessage());
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
			IE_IOSpage IEpage = new IE_IOSpage(driver);
			IEpage.SkippingCustomiseUserJourney();
		    IEpage.loginApp("nonsubscriberuser@mailinator.com", "123456",app_Name);
		    IEpage.validateNonSubscriptionForEpaper(true);
		    IEpage.validatePremiumTagAndClickOnAricle();
		    IEpage.validatindPremiumWall();
		} catch (HandleException e) {
			Asserts.assertFail(e.getCode()+"--> "+ e.getMessage());
		}
		catch (Exception e) {
			Asserts.assertFail( "Unable to execute TestCase06 \" validating validating premium Wall and Epaper wall with combo Subscriber user Script \" "+e.getMessage());
		}
	}
}
