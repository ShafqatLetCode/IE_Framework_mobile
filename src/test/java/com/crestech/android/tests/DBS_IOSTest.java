package com.crestech.android.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.crestech.annotation.values.Author;
import com.crestech.base.UserBaseTest;
import com.crestech.common.utilities.Asserts;
import com.crestech.common.utilities.CommonTestData;
import com.crestech.common.utilities.HandleException;
import com.crestech.listeners.RetryAnalyzer;
import com.crestech.listeners.TestListener;
import com.crestech.pages.DBS_IOSpage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

@Listeners(TestListener.class)
public class DBS_IOSTest extends UserBaseTest {

	Logger logger = Logger.getLogger(DBSAndroidTest.class.getName());
	DBS_IOSpage DBSPgaeObject1 = null;
	
	@Epic("Log In")
	@Feature(value =  "Home Page" ) 
	@Story("Handling Quit button,Select UAT server, Set Up Digital Token & Alert Handling.")
	@Parameters({ "userName", "password", "app_Name" })
	@Test(priority = 1, enabled = true, description = "Pre-requisite Script", retryAnalyzer = RetryAnalyzer.class)
	// @Description(value = "Execution of this testcase:: Handling Quit button,Select UAT server, Set Up Digital Token & Alert Handling.")
	@Author(name = "Shafqat Ali")
	public void PreRequisiteScript(String userName, String password, String app_Name) throws Exception {
		try {
			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
			DBSPgaeObject1 = DBSPgaeObject;
			DBSPgaeObject1.preRequisiteScript(userName, password, app_Name, CommonTestData.N1_SERVER.getEnumValue());
		} catch (HandleException e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail(e.getCode() + "--> " + e.getMessage());
		} catch (Exception e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail("Unable to execute Pre-Requisite Script " + e.getMessage());
		}
	}

//	@Epic("Log In")
//	@Feature(value =  "Home Page" ) 
//	@Story("Verify the account detail on dashboard page.")
//	@Parameters({ "userName", "password", "app_Name" })
//	@Test(priority = 2, enabled = true, description = "AccountDetails-CASA-ONEAPP-14400", dependsOnMethods = {
//			"PreRequisiteScript" })
//	// @Description(value = "Execution of this testcase:: Verify the account detail on dashboard page ")
//	@Author(name = "Shafqat Ali")
//	public void accountDetails_CASA(String userName, String password, String app_Name) throws Exception {
//		try {
//			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
//			DBSPgaeObject1 = DBSPgaeObject;
//			DBSPgaeObject1.LogInApplication(userName, password,app_Name);
//			DBSPgaeObject1.VerifyAccountDetailsCasaOnHomePage(app_Name,true);
//		} catch (HandleException e) {
//			DBSPgaeObject1.verifyDigibankAlert();
//			Asserts.assertFail(e.getCode() + "--> " + e.getMessage());
//		} catch (Exception e) {
//			DBSPgaeObject1.verifyDigibankAlert();
//			Asserts.assertFail("Unable to execute Account Details CASA " + e.getMessage());
//		}
//	}

	@Epic("Pay & Transfer")
	@Feature(value =  "Overseas") 
	@Story("Verifies the Remittance Corridor")
	@Parameters({ "userName", "password", "app_Name" })
	@Test(priority = 3, enabled = true, description = "Remittance-Corridor-ONEAPP-13407", dependsOnMethods = {
			"PreRequisiteScript" })
	// @Description(value = "Execution of this testcase:: Verifies the Remittance Corridor")
	@Author(name = "shafqat")
	public void Remittance_Corridor(String userName, String password, String app_Name) throws Exception {
		try {
			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
			DBSPgaeObject1 = DBSPgaeObject;
			DBSPgaeObject1.LogInApplication(userName, password,app_Name);
			DBSPgaeObject1.VerifyRemittanceCorridor(app_Name);
		} catch (HandleException e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail(e.getCode() + "--> " + e.getMessage());
		} catch (Exception e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail("Unable to execute Remittance Corridor " + e.getMessage());
		}
	}

	@Epic("Pay & Transfer")
	@Feature(value =  "Overseas") 
	@Story("Verifies the Remittance EOTT")
	@Parameters({ "userName", "password", "app_Name" })
	@Test(priority = 4, enabled = true, description = "Remittance-eOTT-ONEAPP-14008", dependsOnMethods = {
			"PreRequisiteScript" })
	// @Description(value = "Execution of this testcase:: Verifies the Remittance EOTT")
	@Author(name = "shafqat")
	public void Remittance_EOTT(String userName, String password, String app_Name) throws Exception {
		try {
			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
			DBSPgaeObject1 = DBSPgaeObject;
			DBSPgaeObject1.LogInApplication(userName, password,app_Name);
			DBSPgaeObject1.VerifyRemittanceEOTT(app_Name);
		} catch (HandleException e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail(e.getCode() + "--> " + e.getMessage() );
		} catch (Exception e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail("Unable to execute Remittance EOTT " + e.getMessage());
		}
	}

	@Epic("Pay & Transfer")
	@Feature(value =  "Local") 
	@Story("Verifies the Payee add DSB or POSB")
	@Parameters({ "userName", "password", "app_Name" })
	@Test(priority = 5, enabled = true, description = "Payee-Add-DBSorPOSB-ONEAPP-14675", dependsOnMethods = {
			"PreRequisiteScript" })
	// @Description(value = "Execution of this testcase:: Verifies the Payee add DSB or POSB.")
	@Author(name = "Divya Devi")
	public void Payee_Add_DBSorPOSB(String userName, String password, String app_Name) throws Exception {
		try {
			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
			DBSPgaeObject1 = DBSPgaeObject;
			DBSPgaeObject1.LogInApplication(userName, password,app_Name);
			// Delete Payee Code Start Before Adding Payee DBS/POSB
			DBSPgaeObject1.DeletePayee_ToDBSPOSB();
			DBSPgaeObject1.VerifyAddPayeeDBSorPOSB();
		} catch (HandleException e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail(e.getCode() + "--> " + e.getMessage());
		} catch (Exception e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail("Unable to execute Payee Add To DBS/POSB " + e.getMessage());
		}
	}

//	@Epic("Pay & Transfer")
//	@Feature(value =  "TopUp") 
//	@Story("Verify the Topup Paylah")
//	@Parameters({ "userName", "password", "app_Name" })
//	@Test(priority = 6, enabled = true, description = "TopUp-PayLah-ONEAPP-13915", dependsOnMethods = {
//			"PreRequisiteScript" })
//	// @Description(value = "Execution of this testcase:: Verify the Topup Paylah in Applications")
//	@Author(name = "Shafqat Ali")
//	public void Topup_Paylah(String userName, String password, String app_Name) throws Exception {
//		try {
//			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
//			DBSPgaeObject1 = DBSPgaeObject;
//			DBSPgaeObject1.LogInApplication(userName, password,app_Name);
//			DBSPgaeObject1.TopupPaylah();
//		} catch (HandleException e) {
//			DBSPgaeObject1.verifyDigibankAlert();
//			Asserts.assertFail(e.getCode() + "--> " + e.getMessage() );
//		} catch (Exception e) {
//			DBSPgaeObject1.verifyDigibankAlert();
//			Asserts.assertFail("Unable to execute TopUp Paylah " + e.getMessage());
//		}
//	}

//	@Epic("Pay & Transfer")
//	@Feature(value =  "Overseas") 
//	@Story("Verify the Add Remittance payee")
//	@Parameters({ "userName", "password", "app_Name" })
//	@Test(priority = 7, enabled = true, description = "Payee-Add-Remittance-ONEAPP-13679", dependsOnMethods = {
//			"PreRequisiteScript" } , retryAnalyzer = RetryAnalyzer.class)
//	// @Description(value = "Execution of this testcase:: Verify the Add Remittance payee")
//	@Author(name = "Shafqat Ali")
//	public void Payee_Add_Remittance(String userName, String password, String app_Name) throws Exception {
//		try {
//			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
//			DBSPgaeObject1 = DBSPgaeObject;
//			DBSPgaeObject1.LogInApplication(userName, password,app_Name);
//			DBSPgaeObject1.DeletePayee_ToRemittence();
//			DBSPgaeObject1.PayeeAddRemittance();
//		} catch (HandleException e) {
//			DBSPgaeObject1.verifyDigibankAlert();
//			Asserts.assertFail(e.getCode() + "--> " + e.getMessage() );
//		} catch (Exception e) {
//			DBSPgaeObject1.verifyDigibankAlert();
//			Asserts.assertFail("Unable to execute Payee Add To Remittance " + e.getMessage());
//		}
//	}

	@Epic("More")
	@Feature(value =  "Cards") 
	@Story("Verifies the Apply Debit Card")
	@Parameters({ "userName", "password", "app_Name" })
	@Test(priority = 8, enabled = true, description = "ApplyDebitCard-ONEAPP-15861", dependsOnMethods = {
			"PreRequisiteScript" })
	// @Description(value = "Execution of this testcase:: Verifies the Apply Debit Card.")
	@Author(name = "Divya Devi")
	public void ApplyDebitCard_DBS(String userName, String password, String app_Name) throws Exception {
		try {
			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
			DBSPgaeObject1 = DBSPgaeObject;
			DBSPgaeObject1.LogInApplication(userName, password,app_Name);
			DBSPgaeObject1.ApplyDebitCard(app_Name);
		} catch (HandleException e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail(e.getCode() + "--> " + e.getMessage());
		} catch (Exception e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail("Unable to execute Apply Debit card" + e.getMessage());
		}
	}

//	@Epic("Pay & Transfer")
//	@Feature(value =  "Local") 
//	@Story("Verifies the Payee Add Local Other Bank")
//	@Parameters({ "userName", "password", "app_Name" })
//	@Test(priority = 9, enabled = true, description = "Payee-Add-Local-OtherBank-ONEAPP-15677", dependsOnMethods = {
//			"PreRequisiteScript" })
//	// @Description(value = "Execution of this testcase:: Verifies the Payee Add Local Other Bank.")
//	@Author(name = "Divya Devi")
//	public void Payee_Add_Local_OtherBank(String userName, String password, String app_Name) throws Exception {
//		try {
//			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
//			DBSPgaeObject1 = DBSPgaeObject;
//			DBSPgaeObject1.LogInApplication(userName, password,app_Name);
//			// Delete Payee Code Start Before Adding Payee Local to Other Bank
//			DBSPgaeObject1.DeletePayee_LocalToOtherBank();
//			DBSPgaeObject1.PayeeAddLocalOtherBank();
//		} catch (HandleException e) {
//			DBSPgaeObject1.verifyDigibankAlert();
//			Asserts.assertFail(e.getCode() + "--> " + e.getMessage());
//		} catch (Exception e) {
//			DBSPgaeObject1.verifyDigibankAlert();
//			Asserts.assertFail("Unable to execute Payee Add Local OtherBank " + e.getMessage());
//		}
//	}

	@Epic("Pay & Transfer")
	@Feature(value =  "Bills") 
	@Story("Verifies the Payee Add Bill Payment.")
	@Parameters({ "userName", "password", "app_Name" })
	@Test(priority = 10, enabled = true, description = "Payee-Add-BillPayment-ONEAPP-15938", dependsOnMethods = {
			"PreRequisiteScript" })
	// @Description(value = "Execution of this testcase:: Verifies the Payee Add Bill Payment.")
	@Author(name = "Divya Devi")
	public void Payee_Add_BillPayment(String userName, String password, String app_Name) throws Exception {
		try {
			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
			DBSPgaeObject1 = DBSPgaeObject;
			DBSPgaeObject1.LogInApplication(userName, password,app_Name);
			// Delete Payee Code Start Before Adding Payee to Bill Payment.
			DBSPgaeObject1.DeletePayee_ToBillPayment();
			DBSPgaeObject1.PayeeAddBillPayment();
		} catch (HandleException e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail(e.getCode() + "--> " + e.getMessage());
		} catch (Exception e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail("Unable to execute Payee Add Bill Payment " + e.getMessage());
		}
	}

//	@Epic("More")
//	@Feature(value =  "Deposit Account") 
//	@Story("Verifies the Open Account")
//	@Parameters({ "userName", "password", "app_Name" })
//	@Test(priority = 11, enabled = true, description = "OpenAccount-ONEAPP-14028", dependsOnMethods = {
//			"PreRequisiteScript" })
//	// @Description(value = "Execution of this testcase:: Verifies the Open Account.")
//	@Author(name = "Divya Devi")
//	public void OpenAccount(String userName, String password, String app_Name) throws Exception {
//		try {
//			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
//			DBSPgaeObject1 = DBSPgaeObject;
//			DBSPgaeObject1.LogInApplication(userName, password,app_Name);
//			DBSPgaeObject1.OpenAccount(app_Name);
//		} catch (HandleException e) {
//			DBSPgaeObject1.verifyDigibankAlert();
//			Asserts.assertFail(e.getCode() + "--> " + e.getMessage());
//		} catch (Exception e) {
//			DBSPgaeObject1.verifyDigibankAlert();
//			Asserts.assertFail("Unable to execute Open Account " + e.getMessage());
//		}
//	}

//	@Epic("More")
//	@Feature(value =  "Local Transfer Limit") 
//	@Story("Verifies the Change Limit for Transfers to Other Banks Accounts to Increase the Current limit.")
//	@Parameters({ "userName", "password", "app_Name" })
//	@Test(priority = 12, enabled = true, description = "ChangeLocalFundsTransferLimit-Increase-ONEAPP-7847", dependsOnMethods = {
//			"PreRequisiteScript" })
//	// @Description(value = "Execution of this testcase:: Successful Change Limit for Transfers to Other Banks Accounts to Increase the Current limit ")
//	@Author(name = "Shafqat Ali")
//	public void ChangeLocalFundsTransferLimit(String userName, String password, String app_Name) throws Exception {
//		try {
//			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
//			DBSPgaeObject1 = DBSPgaeObject;
//			DBSPgaeObject1.LogInApplication(userName, password,app_Name);
//			DBSPgaeObject1.ChangeLocalFundsTransferLimit();
//		} catch (HandleException e) {
//			DBSPgaeObject1.verifyDigibankAlert();
//			Asserts.assertFail(e.getCode() + "--> " + e.getMessage() );
//		} catch (Exception e) {
//			DBSPgaeObject1.verifyDigibankAlert();
//			Asserts.assertFail("Unable to execute Change Local Funds Transfer Limit " + e.getMessage());
//		}
//	}
	
//	@Epic("Log In")
//	@Feature(value =  "Home Page") 
//	@Story("Verifies the Logout functionality for Applications.")
//	@Parameters({ "userName", "password", "app_Name" })
//	@Test(priority = 13, enabled = true, description = "Logout-ONEAPP-9392", dependsOnMethods = { "PreRequisiteScript" })
//	// @Description(value = "Execution of this testcase:: Verify the Logout functionality for Applications")
//	@Author(name = "Shafqat Ali")
//	public void Logout_ONEAPP(String userName, String password, String app_Name) throws Exception {
//		try {
//			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
//			DBSPgaeObject1 = DBSPgaeObject;
//			DBSPgaeObject1.LogInApplication(userName, password,app_Name);
//			DBSPgaeObject1.VerifyLogout(app_Name);
//		} catch (HandleException e) {
//			DBSPgaeObject1.verifyDigibankAlert();
//			Asserts.assertFail(e.getCode() + "--> " + e.getMessage());
//		} catch (Exception e) {
//			DBSPgaeObject1.verifyDigibankAlert();
//			Asserts.assertFail("Unable to Execute Logout " + e.getMessage());
//		}
//	}

	@Epic("Pay & Transfer")
	@Feature(value =  "Select All Tab : Your DBS/POSB Accounts") 
	@Story("Verifies the Fund Transfer Own Account.")
	@Parameters({ "userName", "password", "app_Name" })
	@Test(priority = 14, enabled = true, description = "FundsTransfer-OwnAccount-ONEAPP-16730", dependsOnMethods = {
			"PreRequisiteScript" })
	// @Description(value = "Execution of this testcase:: Verifies the Fund Transfer Own Account.")
	@Author(name = "Divya Devi")
	public void FundsTransferOwnAccount(String userName, String password, String app_Name) throws Exception {
		try {
			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
			DBSPgaeObject1 = DBSPgaeObject;
			DBSPgaeObject1.LogInApplication(userName, password,app_Name);
			DBSPgaeObject1.VerifyFundTransfer_OwnAccount();
		} catch (HandleException e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail(e.getCode() + "--> " + e.getMessage() );
		} catch (Exception e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail("Unable to execute Change Local Funds Transfer Limit " + e.getMessage());
		}
	}
	
	@Epic("Pay & Transfer")
	@Feature(value =  "Select All Tab:: Local Recipient") 
	@Story("Verifies the Fund Transfer Other Bank Non Fast Future Transfer Date.")
	@Parameters({ "userName", "password", "app_Name" })
	@Test(priority = 15, enabled = true, description = "FundsTransfer-OtherBank-NonFAST-ONEAPP-16728", dependsOnMethods = {
			"PreRequisiteScript" })
	// @Description(value = "Execution of this testcase:: Verifies the Fund Transfer Other Bank Non Immediate Transfer Date.")
	@Author(name = "Shubham Gupta")
	public void FundsTransfer_OtherBank_NonFAST(String userName, String password, String app_Name) throws Exception {
		try {
			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
			DBSPgaeObject1 = DBSPgaeObject;
			DBSPgaeObject1.LogInApplication(userName, password,app_Name);
			DBSPgaeObject1.FundsTransfer_OtherBank_NonFAST(app_Name);
		} catch (HandleException e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail(e.getCode() + "--> " + e.getMessage());
		} catch (Exception e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail("Unable to execute Peek Balance " + e.getMessage());
		}
	}
	
	@Epic("Pay & Transfer")
	@Feature(value =  "Select All Tab:: Local Recipient") 
	@Story("Verifies the Fund Transfer Other Bank Non Immediate Transfer Date.")
	@Parameters({ "userName", "password", "app_Name" })
	@Test(priority = 16, enabled = true, description = "FundsTransfer-OtherBank-NonFAST-Future-THANOS-5244", dependsOnMethods = {
			"PreRequisiteScript" })
	// @Description(value = "Execution of this testcase:: Verifies the Fund Transfer Other Bank Non Immediate Transfer Date.")
	@Author(name = "Shubham Gupta")
	public void FundsTransfer_OtherBank_NonFAST_FUTURE(String userName, String password, String app_Name) throws Exception {
		try {
			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
			DBSPgaeObject1 = DBSPgaeObject;
			DBSPgaeObject1.LogInApplication(userName, password,app_Name);
			DBSPgaeObject1.FundsTransfer_OtherBank_NonFAST_FUTURE(app_Name);
		} catch (HandleException e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail(e.getCode() + "--> " + e.getMessage());
		} catch (Exception e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail("Unable to execute Peek Balance " + e.getMessage());
		}
	}

//	@Epic("Pay & Transfer")
//	@Feature(value =  "Select All Tab:: Local Recipient") 
//	@Story("Verifies the Fund Transfer Other DBS/POSB.")
//	@Parameters({ "userName", "password", "app_Name" })
//	@Test(priority = 17, enabled = true, description = "FundsTransfer-OtherPOSBDBS-ONEAPP-16723", dependsOnMethods = {
//			"PreRequisiteScript" })
//	// @Description(value = "Execution of this testcase:: Verifies FundTransfer Other DBS/POSB")
//	@Author(name = "shafqat")
//	public void FundTransferOtherDBSPOSB(String userName, String password, String app_Name) throws Exception {
//		try {
//			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
//			DBSPgaeObject1 = DBSPgaeObject;
//			DBSPgaeObject1.LogInApplication(userName, password,app_Name);
//			DBSPgaeObject1.FundTransferDBSPOSB(app_Name);
//		} catch (HandleException e) {
//			DBSPgaeObject1.verifyDigibankAlert();
//			Asserts.assertFail(e.getCode() + "--> " + e.getMessage() );
//		} catch (Exception e) {
//			DBSPgaeObject1.verifyDigibankAlert();
//			Asserts.assertFail("Unable to execute Fund Transfer Other DBS/POSB " + e.getMessage());
//		}
//	}

//	@Epic("More")
//	@Feature(value =  "Transaction History") 
//	@Story("Verifies Transaction History")
//	@Parameters({ "userName", "password", "app_Name" })
//	@Test(priority = 18, enabled = true, description = "TransactionHistory-ONEAPP-14312", dependsOnMethods = {
//			"PreRequisiteScript" })
//	// @Description(value = "Execution of this testcase:: Verifies Transaction History")
//	@Author(name = "shafqat")
//	public void TransactionHistory(String userName, String password, String app_Name) throws Exception {
//		try {
//			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
//			DBSPgaeObject1 = DBSPgaeObject;
//			DBSPgaeObject1.LogInApplication(userName, password,app_Name);
//			DBSPgaeObject1.verifyTransactionHistory(app_Name);
//		} catch (HandleException e) {
//			DBSPgaeObject1.verifyDigibankAlert();
//			Asserts.assertFail(e.getCode() + "--> " + e.getMessage() );
//		} catch (Exception e) {
//			DBSPgaeObject1.verifyDigibankAlert();
//			Asserts.assertFail("Unable to execute Transaction History " + e.getMessage());
//		}
//	}

//	@Epic("More")
//	@Feature(value =  "Temporary Credit Limit Increase") 
//	@Story("Verifies Credit Card Temperory Limit Increase")
//	@Parameters({ "userName", "password", "app_Name" })
//	@Test(priority = 19, enabled = true, description = "CreditCardTempLimitIncrease-ONEAPP-16669", dependsOnMethods = {
//			"PreRequisiteScript" })
//	// @Description(value = "Execution of this testcase:: Verifies Credit Card Temperory Limit Increase")
//	@Author(name = "shafqat")
//	public void CreditCardTempLimitIncrease(String userName, String password, String app_Name) throws Exception {
//		try {
//			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
//			DBSPgaeObject1 = DBSPgaeObject;
//			DBSPgaeObject1.LogInApplication(userName, password,app_Name);
//			DBSPgaeObject1.CreditCardTempLimitIncrease();
//		} catch (HandleException e) {
//			DBSPgaeObject1.verifyDigibankAlert();
//			Asserts.assertFail(e.getCode() + "--> " + e.getMessage());
//		} catch (Exception e) {
//			DBSPgaeObject1.verifyDigibankAlert();
//			Asserts.assertFail("Unable to execute Credit Card Temp Limit Increase " + e.getMessage());
//		}
//	}

//	@Epic("More")
//	@Feature(value =  "Update Personal Particular") 
//	@Story("Verifies the Update Personal Particular Details.")
//	@Parameters({ "userName", "password", "app_Name" })
//	@Test(priority = 20, enabled = true, description = "UpdatePersonalParticular-ONEAPP-13921", dependsOnMethods = {
//			"PreRequisiteScript" })
//	// @Description(value = "Execution of this testcase:: Verifies the Update Personal Particular Details.")
//	@Author(name = "Divya Devi")
//	public void UpdatePersonalParticular(String userName, String password, String app_Name) throws Exception {
//		try {
//			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
//			DBSPgaeObject1 = DBSPgaeObject;
//			DBSPgaeObject1.LogInApplication(userName, password,app_Name);
//			DBSPgaeObject1.UpdatePersonalDetails(app_Name);
//		} catch (HandleException e) {
//			DBSPgaeObject1.verifyDigibankAlert();
//			Asserts.assertFail(e.getCode() + "--> " + e.getMessage());
//		} catch (Exception e) {
//			DBSPgaeObject1.verifyDigibankAlert();
//			Asserts.assertFail("Unable to execute update Personal Particular " + e.getMessage());
//		}
//	}
	
//	@Epic("Pay & Transfer")
//	@Feature(value =  "Select All Tab:: Local Recipient") 
//	@Story("Verifies the Fund Transfer Other Bank Other Bank Fast Future Transfer Date.")
//	@Parameters({ "userName", "password", "app_Name" })
//	@Test(priority = 21, enabled = true, description = "FundsTransfer-OtherBank-FAST-FUTURE-THANOS-5245", dependsOnMethods = {
//			"PreRequisiteScript" })
//	// @Description(value = "Execution of this testcase:: Verifies the Fund Transfer Other Bank Non Immediate Transfer Date.")
//	@Author(name = "Shubham Gupta")
//	public void FundsTransfer_OtherBank_FAST_FUTURE(String userName, String password, String app_Name) throws Exception {
//		try {
//			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
//			DBSPgaeObject1 = DBSPgaeObject;
//			DBSPgaeObject1.LogInApplication(userName, password,app_Name);
//			DBSPgaeObject1.FundsTransfer_OtherBank_FASTFuture(app_Name);
//		} catch (HandleException e) {
//			DBSPgaeObject1.verifyDigibankAlert();
//			Asserts.assertFail(e.getCode() + "--> " + e.getMessage());
//		} catch (Exception e) {
//			DBSPgaeObject1.verifyDigibankAlert();
//			Asserts.assertFail("Unable to execute Peek Balance " + e.getMessage());
//		}
//	}
//	
//	@Epic("Pay & Transfer")
//	@Feature(value =  "Select All Tab:: Local Recipient") 
//	@Story("Verifies the Fund Transfer Other Bank Immediate Transfer Date.")
//	@Parameters({ "userName", "password", "app_Name" })
//	@Test(priority = 22, enabled = true, description = "FundsTransfer-OtherBank-FAST-ONEAPP-16725", dependsOnMethods = {
//			"PreRequisiteScript" })
//	// @Description(value = "Execution of this testcase:: Verifies the Fund Transfer Other Bank Non Immediate Transfer Date.")
//	@Author(name = "Shubham Gupta")
//	public void FundsTransfer_OtherBank_FAST_ONEAPP(String userName, String password, String app_Name) throws Exception {
//		try {
//			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
//			DBSPgaeObject1 = DBSPgaeObject;
//			DBSPgaeObject1.LogInApplication(userName, password,app_Name);
//			DBSPgaeObject1.FundsTransfer_OtherBank_FAST(app_Name);
//		} catch (HandleException e) {
//			DBSPgaeObject1.verifyDigibankAlert();
//			Asserts.assertFail(e.getCode() + "--> " + e.getMessage());
//		} catch (Exception e) {
//			DBSPgaeObject1.verifyDigibankAlert();
//			Asserts.assertFail("Unable to execute Peek Balance " + e.getMessage());
//		}
//	}

	@Epic("Pay & Transfer")
	@Feature(value =  "Select All Tab:: Credit Cards") 
	@Story("Verifies the Fund Transfer Pay Credit Card.")
	@Parameters({ "userName", "password", "app_Name" })
	@Test(priority = 23, enabled = true, description = "FundsTransfer-PayCreditCard-ONEAPP-14024", dependsOnMethods = {
			"PreRequisiteScript" })
	// @Description(value = "Execution of this testcase:: Verifies the Fund Transfer Pay Credit Card.")
	@Author(name = "Divya Devi")
	public void FundsTransfer_PayCreditCard(String userName, String password, String app_Name) throws Exception {
		try {
			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
			DBSPgaeObject1 = DBSPgaeObject;
			DBSPgaeObject1.LogInApplication(userName, password,app_Name);
			DBSPgaeObject1.FundsTransfer_PayCreditCard();
		} catch (HandleException e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail(e.getCode() + "--> " + e.getMessage());
		} catch (Exception e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail("Unable to execute Fund Transfer Pay Credit Card " + e.getMessage());
		}
	}

	@Epic("Pay & Transfer")
	@Feature(value =  "Select All Tab:: Billing Organisations") 
	@Story("Verifies the Fund Transfer Bill Payment.")
	@Parameters({ "userName", "password", "app_Name" })
	@Test(priority = 24, enabled = true, description = "FundsTransfer-BillPayment-ONEAPP-14040", dependsOnMethods = {
			"PreRequisiteScript" })
	// @Description(value = "Execution of this testcase:: Verifies the Fund Transfer Bill Payment.")
	@Author(name = "Divya Devi")
	public void FundsTransfer_BillPayment(String userName, String password, String app_Name) throws Exception {
		try {
			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
			DBSPgaeObject1 = DBSPgaeObject;
			DBSPgaeObject1.LogInApplication(userName, password,app_Name);
			DBSPgaeObject1.FundsTransfer_BillPayment();
		} catch (HandleException e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail(e.getCode() + "--> " + e.getMessage());
		} catch (Exception e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail("Unable to execute Fund Transfer Bill Payment " + e.getMessage());
		}
	}

//	@Epic("More")
//	@Feature(value =  "Peek Balance") 
//	@Story("Verifies the Peek Balance.")
//	@Parameters({ "userName", "password", "app_Name" })
//	@Test(priority = 25, enabled = true, description = "PeekBalance-MCA-ONEAPP-13982", dependsOnMethods = {
//			"PreRequisiteScript" })
//	// @Description(value = "Execution of this testcase:: Verifies the Peek Balance.")
//	@Author(name = "Divya Devi")
//	public void PeekBalance_MCA(String userName, String password, String app_Name) throws Exception {
//		try {
//			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
//			DBSPgaeObject1 = DBSPgaeObject;
//			DBSPgaeObject1.LogInApplication(userName, password,app_Name);
//			DBSPgaeObject1.VerifyPeekBalance(app_Name,true);
//		} catch (HandleException e) {
//			DBSPgaeObject1.verifyDigibankAlert();
//			Asserts.assertFail(e.getCode() + "--> " + e.getMessage());
//		} catch (Exception e) {
//			DBSPgaeObject1.verifyDigibankAlert();
//			Asserts.assertFail("Unable to execute Peek Balance " + e.getMessage());
//		}
//	}

}
