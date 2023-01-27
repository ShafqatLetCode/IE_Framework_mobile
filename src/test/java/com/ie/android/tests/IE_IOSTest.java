package com.ie.android.tests;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.ie.annotation.values.Author;
import com.ie.appium.utils.CommonAppiumTest;
import com.ie.base.UserBaseTest;
import com.ie.common.utilities.Asserts;
import com.ie.common.utilities.HandleException;
import com.ie.listeners.RetryAnalyzer;
import com.ie.listeners.TestListener;
import com.ie.pages.IEAndroidPage;
import com.ie.pages.IE_IOSpage;
import emailer.CommonMailer;
import emailer.FailedUrl;
import html.CommonHtml;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

@Listeners(TestListener.class)
public class IE_IOSTest extends UserBaseTest {

	Logger logger = Logger.getLogger(IE_AndroidTest.class.getName());
	IE_IOSpage IEPgaeObject1 = null;
	static final String USER_EMAIL = "mayur.pundir@indianexpress.com, shafqat.ali@indianexpress.com"
		    + "saurabh.dagar@indianexpress.com,kinjal.priyadarshi@indianexpress.com, nitin.Chaudhary@indianexpress.com, akshay.chirigidi@evolok.com";
	Asserts Assert = null;
	IEAndroidPage dbspage1 = null;
    CommonAppiumTest method=null;
	HashSet<String> error=null;
	FailedUrl failedUrl; 
	List<ArrayList<String>> url_failed_list;
	
	public IE_IOSTest() throws Exception {
		super();
		Assert = new Asserts();
		failedUrl = new FailedUrl();
		url_failed_list = new ArrayList<ArrayList<String>>();
	}
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
	
	@Story("Mailers")
	@Parameters({ "userName", "password", "app_Name" })
	@AfterClass(description = "Sending Mail")
	@Author(name = "Shafqat Ali")
	public void SendAlert(String userName, String password , String app_Name) throws Exception {
		try {
			  url_failed_list = failedUrl.getUrlFailedList();
	          CommonHtml createReport = new CommonHtml();
	          method = new CommonAppiumTest(driver);
	          createReport.createReport(failedUrl.getTableHeadings(), url_failed_list, "codes_check.html", 
	                    "Indian Express - iOS", "Subscription Wall Test Detail Report:- http://3.6.231.137:8080/job/IE_Automation_IOS/allure/", "Shafqat Ali", "Codes Alert", method.getLogo("indianexpress"));
	          CommonMailer mailer = new CommonMailer();
	          mailer.send_email(USER_EMAIL, "Codes Checks", "Codes check.", "codes_check.html");
		}
		catch (Exception e) {
			Asserts.assertFail( "Unable to execute Sending mailer "+e.getMessage());
		}
	}
	
	@AfterMethod
    public void addUrls(ITestResult testResult) throws Exception {
        failedUrl.addUrlToList(testResult, testResult.getMethod().getMethodName(), testResult.getMethod().getDescription());
    }
	
	
}
