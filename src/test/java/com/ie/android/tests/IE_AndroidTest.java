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
	
//	@Epic("Log In with different Senario")
//	@Feature(value =  "Login" ) 
//	@Story("Login with setting")
//	@Parameters({ "userName", "password", "app_Name" })
//	@Test(priority = 2, enabled = true, description = "TestCase01 validating Login with correct user", retryAnalyzer = RetryAnalyzer.class)
//	@Author(name = "Shafqat Ali")
//	public void TestCase02_loginInApp(String userName, String password , String app_Name) throws Exception {
//		try {
//			IEAndroidPage IEpage = new IEAndroidPage(driver);
//		    IEpage.loginApp(userName,password,app_Name);
//		} catch (HandleException e) {
//			//dbspage1.verifyAlertPresent();
//			Asserts.assertFail(e.getCode()+"--> "+ e.getMessage());
//		}
//		catch (Exception e) {
//			//dbspage1.verifyAlertPresent();
//			Asserts.assertFail( "Unable to execute TestCase02 Script "+e.getMessage());
//		}
//	}
//	
//	@Epic("Log In with different Senario")
//	@Feature(value =  "Login" ) 
//	@Story("Varify non subscription After Login")
//	@Parameters({ "userName", "password", "app_Name" })
//	@Test(priority = 3, enabled = true, description = "TestCase02 varify Non Subcription After Login", retryAnalyzer = RetryAnalyzer.class)
//	@Author(name = "Shafqat Ali")
//	public void TestCase02_varifyNonSubcriptionAfterLogin(String userName, String password , String app_Name) throws Exception {
//		try {
//			IEAndroidPage IEpage = new IEAndroidPage(driver);
//		    IEpage.loginApp("demo12345@mailinator.com","87654321",app_Name);
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
//	@Test(priority = 7, enabled = true, description = "TestCase06 Login from premium Article subsciption", retryAnalyzer = RetryAnalyzer.class)
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
	
	@Epic("Log In with different Senario")
	@Feature(value =  "Login" ) 
	@Story("verify epaper login from  subscription")
	@Parameters({ "userName", "password", "app_Name" })
	@Test(priority = 3, enabled = true, description = "TestCase06 Login from epaper subsciption", retryAnalyzer = RetryAnalyzer.class)
	@Author(name = "Shafqat Ali")
	public void TestCase07_bugcatcher(String userName, String password , String app_Name) throws Exception {
		try {
			IEAndroidPage IEpage = new IEAndroidPage(driver);
			IEpage.launchApp();
		    IEpage.validateEpaperwall();
		    IEpage.LoginFromEpaper("mohit10@mailinator.com","123456", app_Name);
		    IEpage.backFromEpaperAndValidateSignIn("mohit10@mailinator.com","123456", app_Name);
		} catch (HandleException e) {
			//dbspage1.verifyAlertPresent();
			Asserts.assertFail(e.getCode()+"--> "+ e.getMessage());
		}
		catch (Exception e) {
			//dbspage1.verifyAlertPresent();
			Asserts.assertFail( "Unable to execute TestCase07 Script "+e.getMessage());
		}
	}
	
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
	
//	@Epic("Log In")
//	@Feature(value =  "Home Page" ) 
//	@Story("Verify the account detail on dashboard page.")
//	@Parameters({ "userName", "password", "app_Name" })
//	@Test(priority = 2, enabled = true, description = "AccountDetails-CASA-ONEAPP-14400", dependsOnMethods={"PreRequisiteScript"})
//	@Author(name = "Shafqat Ali")
//	public void AccountDetails_CASA(String userName, String password , String app_Name) throws Exception {
//		try {
//			DBSAndroidPage dbspage = new DBSAndroidPage(driver);
//			
//		} catch (HandleException e) {
//			dbspage1.verifyDigibankAlert();
//			Asserts.assertFail(e.getCode()+"--> "+ e.getMessage());
//		}
//		catch (Exception e) {
//			dbspage1.verifyDigibankAlert();
//			Asserts.assertFail( "Unable to execute Account Details CASA "+e.getMessage());
//		}
//	}
	
//	@Epic("Pay & Transfer")
//	@Feature(value =  "Overseas") 
//	@Story("Verifies the Remittance Corridor")
//	@Parameters({ "userName", "password", "app_Name" })
//	@Test(priority = 3, enabled = true, description = "Remittance-Corridor-ONEAPP-13407", dependsOnMethods={"PreRequisiteScript"})
//	@Author(name = "Divya Devi")
//	public void Remittance_Corridor(String userName, String password , String app_Name) throws Exception {
//		try {
//			DBSAndroidPage dbspage = new DBSAndroidPage(driver);
//			dbspage1=dbspage;
//			dbspage1.LogInApplication(userName, password);
//			dbspage1.VerifyRemittanceCorridor(app_Name);
//		} catch (HandleException e) {
//			dbspage1.verifyDigibankAlert();
//			Asserts.assertFail(e.getCode()+"--> "+ e.getMessage());
//		}
//		catch (Exception e) {
//			dbspage1.verifyDigibankAlert();
//			Asserts.assertFail( "Unable to execute Remittance Corridor "+e.getMessage());
//		}
//	}
//
//	@Epic("Pay & Transfer")
//	@Feature(value =  "Overseas") 
//	@Story("Verifies the Remittance EOTT")
//	@Parameters({ "userName", "password", "app_Name" })
//	@Test(priority = 4, enabled = true, description = "Remittance-eOTT-ONEAPP-14008", dependsOnMethods={"PreRequisiteScript"})
//	@Author(name = "Divya Devi")
//	public void VerifyRemittance_eOTT(String userName, String password , String app_Name) throws Exception {
//		try {
//			DBSAndroidPage dbspage = new DBSAndroidPage(driver);
//			dbspage1=dbspage;
//			dbspage1.LogInApplication(userName, password);
//			dbspage1.VerifyRemittanceEOTT(app_Name);
//		} catch (HandleException e) {
//			dbspage1.verifyDigibankAlert();
//			Asserts.assertFail(e.getCode()+"--> "+ e.getMessage());
//		}
//		catch (Exception e) {
//			dbspage1.verifyDigibankAlert();
//			Asserts.assertFail( "Unable to execute Remittance EOTT "+e.getMessage());
//		}
//	}

//	@Epic("Pay & Transfer")
//	@Feature(value =  "Local") 
//	@Story("Verifies the Payee add DSB or POSB")
//	@Parameters({ "userName", "password", "app_Name" })
//	@Test(priority = 5, enabled = true, description = "Payee-Add-DBSorPOSB-ONEAPP-14675", dependsOnMethods={"PreRequisiteScript"})
//	@Author(name = "Divya Devi")
//	public void Payee_Add_ToOwnAccount(String userName, String password , String app_Name) throws Exception {
//		try {
//			DBSAndroidPage dbspage = new DBSAndroidPage(driver);
//			dbspage1=dbspage;
//			dbspage1.LogInApplication(userName, password);
//			dbspage1.DeletePayeeDBSPOSB(CommonTestData.PAYEEADD_DBSPOSB_RECIPIENT_NAME.getEnumValue());
//			dbspage1.VerifyAddPayeeDBSorPOSB();
//		} catch (HandleException e) {
//			dbspage1.verifyDigibankAlert();
//			Asserts.assertFail(e.getCode()+"--> "+ e.getMessage());
//		}
//		catch (Exception e) {
//			dbspage1.verifyDigibankAlert();
//			Asserts.assertFail( "Unable to execute Payee Add To DBS/POSB "+e.getMessage());
//		}
//	}

	/*
	 * @Epic("Pay & Transfer")
	 * 
	 * @Feature(value = "TopUp")
	 * 
	 * @Story("Verify the Topup Paylah")
	 * 
	 * @Parameters({ "userName", "password", "app_Name" })
	 * 
	 * @Test(priority = 6, enabled = true, description =
	 * "TopUp-PayLah-ONEAPP-13915", dependsOnMethods={"PreRequisiteScript"})
	 * 
	 * @Author(name = "Shafqat Ali") public void Topup_Paylah(String userName,
	 * String password , String app_Name) throws Exception { try { DBSAndroidPage
	 * dbspage = new DBSAndroidPage(driver); dbspage1=dbspage;
	 * dbspage1.LogInApplication(userName, password); dbspage1.VerifyTopupPaylah();
	 * } catch (HandleException e) { dbspage1.verifyDigibankAlert();
	 * Asserts.assertFail(e.getCode()+"--> "+ e.getMessage()); } catch (Exception e)
	 * { dbspage1.verifyDigibankAlert(); Asserts.assertFail(
	 * "Unable to execute TopUp Paylah "+e.getMessage()); } }
	 * 
	 * @Epic("Pay & Transfer")
	 * 
	 * @Feature(value = "Overseas")
	 * 
	 * @Story("Verify the Add Remittance payee")
	 * 
	 * @Parameters({ "userName", "password", "app_Name" })
	 * 
	 * @Test(priority = 7, enabled = true, description =
	 * "Payee-Add-Remittance-ONEAPP-13679", dependsOnMethods={"PreRequisiteScript"})
	 * 
	 * @Author(name = "Shafqat Ali") public void Payee_Add_Remittance(String
	 * userName, String password , String app_Name) throws Exception { try {
	 * DBSAndroidPage dbspage = new DBSAndroidPage(driver); dbspage1 = dbspage;
	 * dbspage1.LogInApplication(userName, password);
	 * dbspage1.DeletePayeeRemittance(CommonTestData.FULL_NAME.getEnumValue());
	 * dbspage1.VerifyPayeeAddRemittance(); } catch (HandleException e) {
	 * dbspage1.verifyDigibankAlert(); Asserts.assertFail(e.getCode()+"--> "+
	 * e.getMessage()); } catch (Exception e) { dbspage1.verifyDigibankAlert();
	 * Asserts.assertFail(
	 * "Unable to execute Payee Add To Remittance "+e.getMessage()); } }
	 */

//	@Epic("More")
//	@Feature(value =  "Cards") 
//	@Story("Verifies the Apply Debit Card")
//	@Parameters({ "userName", "password", "app_Name" })
//	@Test(priority = 8, enabled = true, description = "ApplyDebitCard-ONEAPP-15861", dependsOnMethods={"PreRequisiteScript"})
//	@Author(name = "Divya Devi")
//	public void ApplyDebitCard(String userName, String password , String app_Name) throws Exception {
//		try {
//			DBSAndroidPage dbspage = new DBSAndroidPage(driver);
//			dbspage1 = dbspage;
//			dbspage1.LogInApplication(userName, password);
//			dbspage1.ApplyDebitCard(app_Name);
//		} catch (HandleException e) {
//			dbspage1.verifyDigibankAlert();
//			Asserts.assertFail(e.getCode()+"--> "+ e.getMessage());
//		}
//		catch (Exception e) {
//			dbspage1.verifyDigibankAlert();
//			Asserts.assertFail( "Unable to execute Apply Debit card"+e.getMessage());
//		}
//	}

//	@Epic("Pay & Transfer")
//	@Feature(value =  "Local") 
//	@Story("Verifies the Payee Add Local Other Bank")
//	@Parameters({ "userName", "password", "app_Name" })
//	@Test(priority = 9, enabled = true, description = "Payee-Add-Local-OtherBank-ONEAPP-15677", dependsOnMethods={"PreRequisiteScript"})
//	@Author(name = "Divya Devi")
//	public void Payee_Add_Local_OtherBank(String userName, String password , String app_Name) throws Exception {
//		try {
//			DBSAndroidPage dbspage = new DBSAndroidPage(driver);
//			dbspage1 = dbspage;
//			dbspage1.LogInApplication(userName, password);
//			dbspage1.DeletePayeeLocalToOtherBank(CommonTestData.LOCAL_RECIPIENT_NAME.getEnumValue());
//			dbspage1.PayeeAddLocalOtherBank();
//		} catch (HandleException e) {
//			dbspage1.verifyDigibankAlert();
//			Asserts.assertFail(e.getCode()+"--> "+ e.getMessage());
//		}
//		catch (Exception e) {
//			dbspage1.verifyDigibankAlert();
//			Asserts.assertFail( "Unable to execute Payee Add Local OtherBank "+e.getMessage());
//		}
//	}

//	@Epic("Pay & Transfer")
//	@Feature(value =  "Bills") 
//	@Story("Verifies the Payee Add Bill Payment.")
//	@Parameters({ "userName", "password", "app_Name" })
//	@Test(priority = 10, enabled = true, description = "Payee-Add-BillPayment-ONEAPP-15938", dependsOnMethods={"PreRequisiteScript"})
//	@Author(name = "Divya Devi")
//	public void Payee_Add_BillPayment(String userName, String password , String app_Name) throws Exception {
//		try {
//			DBSAndroidPage dbspage = new DBSAndroidPage(driver);
//			dbspage1 = dbspage;
//			dbspage1.LogInApplication(userName, password);
//			dbspage1.DeletePayeeToBillPayment(CommonTestData.PAYEEADD_BILLPAYMENT_ACCOUNTNAME.getEnumValue());
//			dbspage1.PayeeAddBillPayment();
//		} catch (HandleException e) {
//			dbspage1.verifyDigibankAlert();
//			Asserts.assertFail(e.getCode()+"--> "+ e.getMessage());
//		}
//		catch (Exception e) {
//			dbspage1.verifyDigibankAlert();
//			Asserts.assertFail( "Unable to execute Payee Add Bill Payment "+e.getMessage());
//		}
//	}
	
//	@Epic("More")
//	@Feature(value =  "Deposit Account") 
//	@Story("Verifies the Open Account")
//	@Parameters({ "userName", "password", "app_Name" })
//	@Test(priority = 11, enabled = true, description = "OpenAccount-ONEAPP-14028" , dependsOnMethods={"PreRequisiteScript"})
//	@Author(name = "Divya Devi")
//	public void OpenAccount(String userName, String password , String app_Name) throws Exception {
//		try {
//			DBSAndroidPage dbspage = new DBSAndroidPage(driver);
//			dbspage1=dbspage;
//			dbspage1.LogInApplication(userName, password);
//			dbspage1.OpenAccount(app_Name);
//		} catch (HandleException e) {
//			dbspage1.verifyDigibankAlert();
//			Asserts.assertFail(e.getCode()+"--> "+ e.getMessage());
//		}
//		catch (Exception e) {
//			dbspage1.verifyDigibankAlert();
//			Asserts.assertFail( "Unable to execute Open Account "+e.getMessage());
//		}
//	}

//	@Epic("More")
//	@Feature(value =  "Local Transfer Limit") 
//	@Story("Verifies the Change Limit for Transfers to Other Banks Accounts to Increase the Current limit.")
//	@Parameters({ "userName", "password", "app_Name" })
//	@Test(priority = 12, enabled = true, description = "ChangeLocalFundsTransferLimit-Increase-ONEAPP-7847", dependsOnMethods={"PreRequisiteScript"})
//	@Author(name = "Shafqat Ali")
//	public void ChangeLocalFundsTransferLimit(String userName, String password , String app_Name) throws Exception {
//		try {
//			DBSAndroidPage dbspage = new DBSAndroidPage(driver);
//			dbspage1=dbspage;
//			dbspage1.LogInApplication(userName, password);
//			dbspage1.ChangeLocalFundsTransferLimit();
//		} catch (HandleException e) {
//			dbspage1.verifyDigibankAlert();
//			Asserts.assertFail(e.getCode()+"--> "+ e.getMessage());
//		}
//		catch (Exception e) {
//			dbspage1.verifyDigibankAlert();
//			Asserts.assertFail( "Unable to execute Change Local Funds Transfer Limit "+e.getMessage());
//		}
//	}
//	
//	@Epic("Log In")
//	@Feature(value =  "Home Page") 
//	@Story("Verifies the Logout functionality for Applications.")
//	@Parameters({ "userName", "password", "app_Name" })
//	@Test(priority = 13, enabled = true, description = "Logout-ONEAPP-9392", dependsOnMethods={"PreRequisiteScript"})
//	@Author(name = "Shafqat Ali")
//	public void Logout_ONEAPP(String userName, String password , String app_Name) throws Exception {
//		try {
//			DBSAndroidPage dbspage = new DBSAndroidPage(driver);
//			dbspage1=dbspage;
//			dbspage1.LogInApplication(userName, password);
//			dbspage1.VerifyLogout(CommonTestData.RATE_MESSAGE.getEnumValue());
//		} catch (HandleException e) {
//			dbspage1.verifyDigibankAlert();
//			Asserts.assertFail(e.getCode()+"--> "+ e.getMessage());
//		}
//		catch (Exception e) {
//			dbspage1.verifyDigibankAlert();
//			Asserts.assertFail( "Unable to execute Log Out "+e.getMessage());
//		}
//	}

//	@Epic("Pay & Transfer")
//	@Feature(value =  "Select All Tab : Your DBS/POSB Accounts") 
//	@Story("Verifies the Fund Transfer Own Account.")
//	@Parameters({ "userName", "password", "app_Name" })
//	@Test(priority = 14, enabled = true, description = "FundsTransfer-OwnAccount-ONEAPP-16730", dependsOnMethods={"PreRequisiteScript"})
//	@Author(name = "Divya Devi")
//	public void FundsTransferOwnAccount(String userName, String password , String app_Name) throws Exception {
//		try {
//			DBSAndroidPage dbspage = new DBSAndroidPage(driver);
//			dbspage1 = dbspage;
//			dbspage1.LogInApplication(userName, password);
//			dbspage1.VerifyFundTransfer_OwnAccount();
//		} catch (HandleException e) {
//			dbspage1.verifyDigibankAlert();
//			Asserts.assertFail(e.getCode()+"--> "+ e.getMessage());
//		}
//		catch (Exception e) {
//			dbspage1.verifyDigibankAlert();
//			Asserts.assertFail( "Unable to execute Fund Transfer Own Account "+e.getMessage());
//		}
//	}
//
//	@Epic("Pay & Transfer")
//	@Feature(value =  "Select All Tab:: Local Recipient") 
//	@Story("Verifies the Fund Transfer Other Bank Non Fast Future Transfer Date.")
//	@Parameters({ "userName", "password", "app_Name" })
//	@Test(priority = 15, enabled = true, description = "FundsTransfer-OtherBank-NonFAST-Future-THANOS-5244", dependsOnMethods={"PreRequisiteScript"})
//	@Author(name = "Divya Devi")
//	public void FundsTransfer_OtherBank_NonFAST_Future(String userName, String password , String app_Name) throws Exception {
//		try {
//			DBSAndroidPage dbspage = new DBSAndroidPage(driver);
//			dbspage1 = dbspage;
//			dbspage1.LogInApplication(userName, password);
//			dbspage1.FundsTransfer_OtherBank_NonFASTFuture(app_Name);
//		} catch (HandleException e) {
//			dbspage1.verifyDigibankAlert();
//			Asserts.assertFail(e.getCode()+"--> "+ e.getMessage());
//		}
//		catch (Exception e) {
//			dbspage1.verifyDigibankAlert();
//			Asserts.assertFail( "Unable to execute Fund Transfer Other Bank Non Fast Future "+e.getMessage());
//		}
//	}
//
//	@Epic("Pay & Transfer")
//	@Feature(value =  "Select All Tab:: Local Recipient") 
//	@Story("Verifies the Fund Transfer Other Bank Non Immediate Transfer Date.")
//	@Parameters({ "userName", "password", "app_Name" })
//	@Test(priority = 16, enabled = true, description = "FundsTransfer-OtherBank-NonFAST-ONEAPP-16728", dependsOnMethods={"PreRequisiteScript"})
//	@Author(name = "Divya Devi")
//	public void FundsTransfer_OtherBank_NonFAST(String userName, String password , String app_Name) throws Exception {
//		try {
//			DBSAndroidPage dbspage = new DBSAndroidPage(driver);
//			dbspage1 = dbspage;
//			dbspage1.LogInApplication(userName, password);
//			dbspage1.FundsTransfer_OtherBank_NonFAST(app_Name);
//		} catch (HandleException e) {
//			dbspage1.verifyDigibankAlert();
//			Asserts.assertFail(e.getCode()+"--> "+ e.getMessage());
//		}
//		catch (Exception e) {
//			dbspage1.verifyDigibankAlert();
//			Asserts.assertFail( "Unable to execute Fund Transfer Other Bank Non Fast "+e.getMessage());
//		}
//	}
	
//	@Epic("Pay & Transfer")
//	@Feature(value =  "Select All Tab:: Local Recipient") 
//	@Story("Verifies the Fund Transfer Other DBS/POSB.")
//	@Parameters({"userName", "password", "app_Name" })
//	@Test(priority=17, enabled=true, description = "FundsTransfer-OtherPOSBDBS-ONEAPP-16723", dependsOnMethods={"PreRequisiteScript"})
//	@Author(name = "shafqat")
//	public void FundTransferOtherDBSPOSB(String userName,String password, String app_Name) throws Exception {
//		try {
//			 DBSAndroidPage dbspage = new DBSAndroidPage(driver);
//			 dbspage1 = dbspage;
//			 dbspage1.LogInApplication(userName, password);
//			 dbspage1.FundTransferDBSPOSB(app_Name);
//		} catch (HandleException e) {
//			dbspage1.verifyDigibankAlert();
//			Asserts.assertFail(e.getCode()+"--> "+ e.getMessage());
//		}
//		catch (Exception e) {
//			dbspage1.verifyDigibankAlert();
//			Asserts.assertFail( "Unable to execute Fund Transfer Other DBS/POSB "+e.getMessage());
//		}
//	}
//	
//	@Epic("More")
//	@Feature(value =  "Transaction History") 
//	@Story("Verifies Transaction History")
//	@Parameters({"userName", "password", "app_Name" })
//	@Test(priority=18, enabled=true, description = "TransactionHistory-ONEAPP-14312", dependsOnMethods={"PreRequisiteScript"})
//	@Author(name = "shafqat")
//	public void TransactionHistory_DBS(String userName,String password, String app_Name) throws Exception {
//		try {
//			 DBSAndroidPage dbspage = new DBSAndroidPage(driver);
//			 dbspage1 = dbspage;
//			 dbspage1.LogInApplication(userName, password);
//			 dbspage1.verifyTransactionHistory(app_Name);
//			 dbspage1.VerifyLogout(CommonTestData.RATE_MESSAGE.getEnumValue());
//		} catch (HandleException e) {
//			dbspage1.verifyDigibankAlert();
//			Asserts.assertFail(e.getCode()+"--> "+ e.getMessage());
//		}
//		catch (Exception e) {
//			dbspage1.verifyDigibankAlert();
//			Asserts.assertFail( "Unable to execute Transaction History "+e.getMessage());
//		}
//	}
//	
//	@Epic("More")
//	@Feature(value =  "Temporary Credit Limit Increase") 
//	@Story("Verifies Credit Card Temperory Limit Increase")
//	@Parameters({"userName", "password","app_Name" })
//	@Test(priority=19, enabled=true, description = "CreditCardTempLimitIncrease-ONEAPP-16669", dependsOnMethods={"PreRequisiteScript"})
//	@Author(name = "shafqat")
//	public void CreditCardTempLimitIncrease(String userName,String password, String app_Name) throws Exception {
//		try {
//			 DBSAndroidPage dbspage = new DBSAndroidPage(driver);
//			 dbspage1 = dbspage;
//			 dbspage1.LogInApplication(userName, password);
//			 dbspage1.CreditCardTempLimitIncrease();
//		} catch (HandleException e) {
//			 dbspage1.verifyDigibankAlert();
//			Asserts.assertFail(e.getCode()+"--> "+ e.getMessage());
//		}
//		catch (Exception e) {
//			 dbspage1.verifyDigibankAlert();
//			Asserts.assertFail( "Unable to execute Credit Card Temp Limit Increase "+e.getMessage());
//		}
//	}

//	@Epic("More")
//	@Feature(value =  "Update Personal Particular") 
//	@Story("Verifies the Update Personal Particular Details.")
//	@Parameters({ "userName", "password", "app_Name" })
//	@Test(priority = 20, enabled = true, description = "UpdatePersonalParticular-ONEAPP-13921", dependsOnMethods={"PreRequisiteScript"})
//	@Author(name = "Divya Devi")
//	public void UpdatePersonalParticular(String userName, String password , String app_Name) throws Exception {
//			try {
//				DBSAndroidPage dbspage = new DBSAndroidPage(driver);
//				dbspage1 = dbspage;
//				dbspage1.LogInApplication(userName, password);
//				dbspage1.UpdatePersonalDetails(app_Name);
//			} catch (HandleException e) {
//				dbspage1.verifyDigibankAlert();
//				Asserts.assertFail(e.getCode()+"--> "+ e.getMessage());
//			}
//			catch (Exception e) {
//				dbspage1.verifyDigibankAlert();
//				Asserts.assertFail( "Unable to execute update Personal Particular "+e.getMessage());
//			}
//	}
	
//	@Epic("Pay & Transfer")
//	@Feature(value =  "Select All Tab:: Local Recipient") 
//	@Story("Verifies the Fund Transfer Other Bank Other Bank Fast Future Transfer Date.")
//	@Parameters({ "userName", "password", "app_Name" })
//	@Test(priority = 21, enabled = true, description = "FundsTransfer-OtherBank-FAST-FUTURE-THANOS-5245", dependsOnMethods={"PreRequisiteScript"})
//	@Author(name = "Divya Devi")
//	public void FundsTransfer_OtherBank_FAST_FUTURE(String userName, String password , String app_Name) throws Exception {
//		try {
//			
//			DBSAndroidPage dbspage = new DBSAndroidPage(driver);
//			dbspage1 = dbspage;
//			dbspage1.LogInApplication(userName, password);
//			dbspage1.FundsTransfer_OtherBank_FASTFuture(app_Name);
//		} catch (HandleException e) {
//			dbspage1.verifyDigibankAlert();
//			Asserts.assertFail(e.getCode()+"--> "+ e.getMessage());
//		}
//		catch (Exception e) {
//			dbspage1.verifyDigibankAlert();
//			Asserts.assertFail( "Unable to execute Fund Transfer Other bank Fast Future "+e.getMessage());
//		}
//	}
//	
//	@Epic("Pay & Transfer")
//	@Feature(value =  "Select All Tab:: Local Recipient") 
//	@Story("Verifies the Fund Transfer Other Bank Immediate Transfer Date.")
//	@Parameters({ "userName", "password", "app_Name" })
//	@Test(priority = 22, enabled = true, description = "FundsTransfer-OtherBank-FAST-ONEAPP-16725", dependsOnMethods={"PreRequisiteScript"})
//	@Author(name = "Divya Devi")
//	public void FundsTransfer_OtherBank_FAST_ONEAPP(String userName, String password , String app_Name) throws Exception {
//		try {
//			DBSAndroidPage dbspage = new DBSAndroidPage(driver);
//			dbspage1 = dbspage;
//			dbspage1.LogInApplication(userName, password);
//			dbspage1.FundsTransfer_OtherBank_FAST(app_Name);
//		} catch (HandleException e) {
//	            dbspage1.verifyDigibankAlert();
//			Asserts.assertFail(e.getCode()+"--> "+ e.getMessage());
//		}
//		catch (Exception e) {
//			 dbspage1.verifyDigibankAlert();
//			Asserts.assertFail( "Unable to execute Fund Transfer Other bank Fast One App "+e.getMessage());
//		}
//	}
	
//	@Epic("Pay & Transfer")
//	@Feature(value =  "Select All Tab:: Credit Cards") 
//	@Story("Verifies the Fund Transfer Pay Credit Card.")
//	@Parameters({ "userName", "password", "app_Name" })
//	@Test(priority = 23, enabled = true, description = "FundsTransfer-PayCreditCard-ONEAPP-14024", dependsOnMethods={"PreRequisiteScript"})
//	@Author(name = "Divya Devi")
//	public void FundsTransfer_PayCreditCard(String userName, String password , String app_Name) throws Exception {
//		try {
//			DBSAndroidPage dbspage = new DBSAndroidPage(driver);
//			dbspage1 = dbspage;
//			dbspage1.LogInApplication(userName, password);
//			dbspage1.FundsTransfer_PayCreditCard();
//		} catch (HandleException e) {
//			dbspage1.verifyDigibankAlert();
//			Asserts.assertFail(e.getCode()+"--> "+ e.getMessage());
//		}
//		catch (Exception e) {
//			dbspage1.verifyDigibankAlert();
//			Asserts.assertFail( "Unable to execute Fund Transfer Pay Credit Card "+e.getMessage());
//		}
//	}
	
//	@Epic("Pay & Transfer")
//	@Feature(value =  "Select All Tab:: Billing Organisations") 
//	@Story("Verifies the Fund Transfer Bill Payment.")
//	@Parameters({ "userName", "password", "app_Name" })
//	@Test(priority = 24, enabled = true, description = "FundsTransfer-BillPayment-ONEAPP-14040", dependsOnMethods={"PreRequisiteScript"})
//	@Author(name = "Divya Devi")
//	public void FundsTransfer_BillPayment(String userName, String password , String app_Name) throws Exception {
//		try {
//			DBSAndroidPage dbspage = new DBSAndroidPage(driver);
//			dbspage1 = dbspage;
//			dbspage1.LogInApplication(userName, password);
//			dbspage1.FundsTransfer_BillPayment();
//		} catch (HandleException e) {
//			dbspage1.verifyDigibankAlert();
//			Asserts.assertFail(e.getCode()+"--> "+ e.getMessage());
//		}
//		catch (Exception e) {
//			dbspage1.verifyDigibankAlert();
//			Asserts.assertFail( "Unable to execute Fund Transfer Bill Payment "+e.getMessage());
//		}
//	}
	
//	@Epic("Pay & Transfer")
//	@Feature(value =  "Pay Now") 
//	@Story("Verifies the Pay Now NRIC.")
//	@Parameters({ "userName", "password", "app_Name" })
//	@Test(priority = 25, enabled = true, description = "PayNow-NRIC-ONEAPP-13966", dependsOnMethods={"PreRequisiteScript"})
//	@Author(name = "Divya Devi")
//	public void PayNow_NRIC_ONEAPP(String userName, String password , String app_Name) throws Exception {
//		try {
//			DBSAndroidPage dbspage = new DBSAndroidPage(driver);
//			dbspage1 = dbspage;
//			dbspage1.LogInApplication(userName, password);
//			dbspage1.PayNowNRIC();
//		} catch (HandleException e) {
//			dbspage1.verifyDigibankAlert();
//			Asserts.assertFail(e.getCode()+"--> "+ e.getMessage());
//		}
//		catch (Exception e) {
//			dbspage1.verifyDigibankAlert();
//			Asserts.assertFail( "Unable to execute Pay Now NRIC ONEAPP "+e.getMessage());
//		}
//	}
//	
//	@Epic("Pay & Transfer")
//	@Feature(value =  "Pay Now") 
//	@Story("Verifies the Pay Now UEN.")
//	@Parameters({ "userName", "password", "app_Name" })
//	@Test(priority = 26, enabled = true, description = "PayNow-UEN-ONEAPP-13969", dependsOnMethods={"PreRequisiteScript"})
//	@Author(name = "Divya Devi")
//	public void PayNow_UEN_ONEAPP(String userName, String password , String app_Name) throws Exception {
//		try {
//			DBSAndroidPage dbspage = new DBSAndroidPage(driver);
//			dbspage1 = dbspage;
//			dbspage1.LogInApplication(userName, password);
//			dbspage1.PayNowUEN();
//		} catch (HandleException e) {
//			dbspage1.verifyDigibankAlert();
//			Asserts.assertFail(e.getCode()+"--> "+ e.getMessage());
//		}
//		catch (Exception e) {
//			dbspage1.verifyDigibankAlert();
//			Asserts.assertFail( "Unable to execute Pay Now UEN ONEAPP "+e.getMessage());
//		}
//	}
//	
//	@Epic("Pay & Transfer")
//	@Feature(value =  "Pay Now") 
//	@Story("Verifies the Pay Now VPA.")
//	@Parameters({ "userName", "password", "app_Name" })
//	@Test(priority = 27, enabled = true, description = "PayNow-VPA-ONEAPP-13991", dependsOnMethods={"PreRequisiteScript"})
//	@Author(name = "Divya Devi")
//	public void PayNow_VPA_ONEAPP(String userName, String password , String app_Name) throws Exception {
//		try {
//			DBSAndroidPage dbspage = new DBSAndroidPage(driver);
//			dbspage1 = dbspage;
//			dbspage1.LogInApplication(userName, password);
//			dbspage1.PayNowVPA();
//		} catch (HandleException e) {
//			dbspage1.verifyDigibankAlert();
//			Asserts.assertFail(e.getCode()+"--> "+ e.getMessage());
//		}
//		catch (Exception e) {
//			dbspage1.verifyDigibankAlert();
//			Asserts.assertFail( "Unable to execute Pay Now VPA ONEAPP "+e.getMessage());
//		}
//	}
	
//	@Epic("More")
//	@Feature(value =  "Peek Balance") 
//	@Story("Verifies the Peek Balance.")
//	@Parameters({ "userName", "password", "app_Name" })
//	@Test(priority = 28, enabled = true, description = "PeekBalance-MCA-ONEAPP-13982", dependsOnMethods={"PreRequisiteScript"})
//	@Author(name = "Divya Devi")
//	public void VerifyPeekBalance_MCA(String userName, String password , String app_Name) throws Exception {
//		try {
//			DBSAndroidPage dbspage = new DBSAndroidPage(driver);
//			dbspage1 = dbspage;
//			dbspage1.LogInApplication(userName, password);
//			dbspage1.VerifyPeekBalance(app_Name,true,CommonTestData.USER_ACCOUNT_NAME.getEnumValue());
//		}  catch (HandleException e) {
//			dbspage1.verifyDigibankAlert();
//			Asserts.assertFail(e.getCode()+"--> "+ e.getMessage());
//		}
//		catch (Exception e) {
//			dbspage1.verifyDigibankAlert();
//			Asserts.assertFail( "Unable to execute Peek Balance "+e.getMessage());
//		}
//	}
	
	/******************End Test Script For DBS App************************************/
}
