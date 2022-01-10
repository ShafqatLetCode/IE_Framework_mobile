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
import com.crestech.listeners.TestListener;
import com.crestech.pages.DBS_IOSpage;
import io.qameta.allure.Description;

@Listeners(TestListener.class)
public class DBS_IOSTest extends UserBaseTest {

	Logger logger = Logger.getLogger(DBSAndroidTest.class.getName());
	DBS_IOSpage DBSPgaeObject1 = null;

	@Parameters({ "userName", "password", "app_Name" })
	@Test(priority = 1, enabled = true, description = "Pre-requisite Script")
	@Description(value = "Execution of this testcase:: Handling Quit button and UAT server selection ")
	@Author(name = "Shafqat Ali")
	public void PreRequisiteScript(String userName, String password, String app_Name) throws Exception {
		try {
			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
			DBSPgaeObject1 = DBSPgaeObject;
			DBSPgaeObject1.preRequisiteScript(userName, password, app_Name, CommonTestData.N4_SERVER.getEnumValue());
		} catch (HandleException e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail(e.getCode() + "--> " + e.getMessage());
		} catch (Exception e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail("Unable to execute Pre-Requisite Script " + e.getMessage());
		}
	}

	@Parameters({ "userName", "password", "app_Name" })
	@Test(priority = 2, enabled = true, description = "AccountDetails-CASA-ONEAPP-14400", dependsOnMethods = {
			"PreRequisiteScript" })
	@Description(value = "Execution of this testcase:: Verify the account detail on dashboard page ")
	@Author(name = "Shafqat Ali")
	public void accountDetails_CASA(String userName, String password, String app_Name) throws Exception {
		try {
			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
			DBSPgaeObject1 = DBSPgaeObject;
			DBSPgaeObject1.LogInApplication(userName, password);
			DBSPgaeObject1.VerifyAccountDetailsCasaOnHomePage();
		} catch (HandleException e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail(e.getCode() + "--> " + e.getMessage());
		} catch (Exception e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail("Unable to execute Account Details CASA " + e.getMessage());
		}
	}

	@Parameters({ "userName", "password", "app_Name" })
	@Test(priority = 13, enabled = true, description = "Logout-ONEAPP-9392", dependsOnMethods = { "PreRequisiteScript" })
	@Description(value = "Execution of this testcase:: Verify the Logout functionality for Applications")
	@Author(name = "Shafqat Ali")
	public void Logout_ONEAPP(String userName, String password, String app_Name) throws Exception {
		try {
			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
			DBSPgaeObject1 = DBSPgaeObject;
			DBSPgaeObject1.LogInApplication(userName, password);
			DBSPgaeObject1.VerifyLogout(app_Name);
		} catch (HandleException e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail(e.getCode() + "--> " + e.getMessage());
		} catch (Exception e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail("Unable to Execute Logout " + e.getMessage());
		}
	}

	@Parameters({ "userName", "password", "app_Name" })
	@Test(priority = 3, enabled = true, description = "Remittance-Corridor-ONEAPP-13407", dependsOnMethods = {
			"PreRequisiteScript" })
	@Description(value = "Execution of this testcase:: Verifies the Remittance Corridor")
	@Author(name = "shafqat")
	public void Remittance_Corridor(String userName, String password, String app_Name) throws Exception {
		try {
			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
			DBSPgaeObject1 = DBSPgaeObject;
			DBSPgaeObject1.LogInApplication(userName, password);
			DBSPgaeObject1.VerifyRemittanceCorridor(app_Name);
		} catch (HandleException e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail(e.getCode() + "--> " + e.getMessage());
		} catch (Exception e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail("Unable to execute Remittance Corridor " + e.getMessage());
		}
	}

	@Parameters({ "userName", "password", "app_Name" })
	@Test(priority = 4, enabled = true, description = "Remittance-eOTT-ONEAPP-14008", dependsOnMethods = {
			"PreRequisiteScript" })
	@Description(value = "Execution of this testcase:: Verifies the Remittance EOTT")
	@Author(name = "shafqat")
	public void Remittance_EOTT(String userName, String password, String app_Name) throws Exception {
		try {
			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
			DBSPgaeObject1 = DBSPgaeObject;
			DBSPgaeObject1.LogInApplication(userName, password);
			DBSPgaeObject1.VerifyRemittanceEOTT(app_Name);
		} catch (HandleException e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail(e.getCode() + "--> " + e.getMessage() );
		} catch (Exception e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail("Unable to execute Remittance EOTT " + e.getMessage());
		}
	}

	@Parameters({ "userName", "password", "app_Name" })
	@Test(priority = 5, enabled = true, description = "Payee-Add-DBSorPOSB-ONEAPP-14675", dependsOnMethods = {
			"PreRequisiteScript" })
	@Description(value = "Execution of this testcase:: Verifies the Payee add DSB or POSB.")
	@Author(name = "Divya Devi")
	public void Payee_Add_DBSorPOSB(String userName, String password, String app_Name) throws Exception {
		try {
			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
			DBSPgaeObject1 = DBSPgaeObject;
			DBSPgaeObject1.LogInApplication(userName, password);
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

	@Parameters({ "userName", "password", "app_Name" })
	@Test(priority = 6, enabled = true, description = "TopUp-PayLah-ONEAPP-13915", dependsOnMethods = {
			"PreRequisiteScript" })
	@Description(value = "Execution of this testcase:: Verify the Topup Paylah in Applications")
	@Author(name = "Shafqat Ali")
	public void Topup_Paylah(String userName, String password, String app_Name) throws Exception {
		try {
			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
			DBSPgaeObject1 = DBSPgaeObject;
			DBSPgaeObject1.LogInApplication(userName, password);
			DBSPgaeObject1.TopupPaylah();
		} catch (HandleException e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail(e.getCode() + "--> " + e.getMessage() );
		} catch (Exception e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail("Unable to execute TopUp Paylah " + e.getMessage());
		}
	}

	@Parameters({ "userName", "password", "app_Name" })
	@Test(priority = 7, enabled = true, description = "Payee-Add-Remittance-ONEAPP-13679", dependsOnMethods = {
			"PreRequisiteScript" })
	@Description(value = "Execution of this testcase:: Verify the Add Remittance payee")
	@Author(name = "Shafqat Ali")
	public void Payee_Add_Remittance(String userName, String password, String app_Name) throws Exception {
		try {
			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
			DBSPgaeObject1 = DBSPgaeObject;
			DBSPgaeObject1.LogInApplication(userName, password);
			DBSPgaeObject1.DeletePayee_ToRemittence();
			DBSPgaeObject1.PayeeAddRemittance();
		} catch (HandleException e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail(e.getCode() + "--> " + e.getMessage() );
		} catch (Exception e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail("Unable to execute Payee Add To Remittance " + e.getMessage());
		}
	}

	@Parameters({ "userName", "password", "app_Name" })
	@Test(priority = 8, enabled = true, description = "ApplyDebitCard-ONEAPP-15861", dependsOnMethods = {
			"PreRequisiteScript" })
	@Description(value = "Execution of this testcase:: Verifies the Apply Debit Card.")
	@Author(name = "Divya Devi")
	public void ApplyDebitCard_DBS(String userName, String password, String app_Name) throws Exception {
		try {
			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
			DBSPgaeObject1 = DBSPgaeObject;
			DBSPgaeObject1.LogInApplication(userName, password);
			DBSPgaeObject1.ApplyDebitCard();
		} catch (HandleException e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail(e.getCode() + "--> " + e.getMessage());
		} catch (Exception e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail("Unable to execute Apply Debit card" + e.getMessage());
		}
	}

	@Parameters({ "userName", "password", "app_Name" })
	@Test(priority = 9, enabled = true, description = "Payee-Add-Local-OtherBank-ONEAPP-15677", dependsOnMethods = {
			"PreRequisiteScript" })
	@Description(value = "Execution of this testcase:: Verifies the Payee Add Local Other Bank.")
	@Author(name = "Divya Devi")
	public void Payee_Add_Local_OtherBank(String userName, String password, String app_Name) throws Exception {
		try {
			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
			DBSPgaeObject1 = DBSPgaeObject;
			DBSPgaeObject1.LogInApplication(userName, password);
			// Delete Payee Code Start Before Adding Payee Local to Other Bank
			DBSPgaeObject1.DeletePayee_LocalToOtherBank();
			DBSPgaeObject1.PayeeAddLocalOtherBank();
		} catch (HandleException e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail(e.getCode() + "--> " + e.getMessage());
		} catch (Exception e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail("Unable to execute Payee Add Local OtherBank " + e.getMessage());
		}
	}

	@Parameters({ "userName", "password", "app_Name" })
	@Test(priority = 10, enabled = true, description = "Payee-Add-BillPayment-ONEAPP-15938", dependsOnMethods = {
			"PreRequisiteScript" })
	@Description(value = "Execution of this testcase:: Verifies the Payee Add Bill Payment.")
	@Author(name = "Divya Devi")
	public void Payee_Add_BillPayment(String userName, String password, String app_Name) throws Exception {
		try {
			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
			DBSPgaeObject1 = DBSPgaeObject;
			DBSPgaeObject1.LogInApplication(userName, password);
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

	@Parameters({ "userName", "password", "app_Name" })
	@Test(priority = 11, enabled = true, description = "OpenAccount-ONEAPP-14028", dependsOnMethods = {
			"PreRequisiteScript" })
	@Description(value = "Execution of this testcase:: Verifies the Open Account.")
	@Author(name = "Divya Devi")
	public void OpenAccount(String userName, String password, String app_Name) throws Exception {
		try {
			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
			DBSPgaeObject1 = DBSPgaeObject;
			DBSPgaeObject1.LogInApplication(userName, password);
			DBSPgaeObject1.OpenAccount(app_Name);
		} catch (HandleException e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail(e.getCode() + "--> " + e.getMessage());
		} catch (Exception e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail("Unable to execute Open Account " + e.getMessage());
		}
	}

	@Parameters({ "userName", "password", "app_Name" })
	@Test(priority = 12, enabled = true, description = " ChangeLocalFundsTransferLimit-Increase-ONEAPP-7847", dependsOnMethods = {
			"PreRequisiteScript" })
	@Description(value = "Execution of this testcase:: Successful Change Limit for Transfers to Other Banks Accounts to Increase the Current limit ")
	@Author(name = "Shafqat Ali")
	public void ChangeLocalFundsTransferLimit(String userName, String password, String app_Name) throws Exception {
		try {
			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
			DBSPgaeObject1 = DBSPgaeObject;
			DBSPgaeObject1.LogInApplication(userName, password);
			DBSPgaeObject1.ChangeLocalFundsTransferLimit();
		} catch (HandleException e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail(e.getCode() + "--> " + e.getMessage() );
		} catch (Exception e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail("Unable to execute Change Local Funds Transfer Limit " + e.getMessage());
		}
	}

	@Parameters({ "userName", "password", "app_Name" })
	@Test(priority = 14, enabled = true, description = "FundsTransfer-OwnAccount-ONEAPP-16730", dependsOnMethods = {
			"PreRequisiteScript" })
	@Description(value = "Execution of this testcase:: Verifies the Fund Transfer Own Account.")
	@Author(name = "Divya Devi")
	public void FundsTransferOwnAccount(String userName, String password, String app_Name) throws Exception {
		try {
			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
			DBSPgaeObject1 = DBSPgaeObject;
			DBSPgaeObject1.LogInApplication(userName, password);
			DBSPgaeObject1.VerifyFundTransfer_OwnAccount();
		} catch (HandleException e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail(e.getCode() + "--> " + e.getMessage() );
		} catch (Exception e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail("Unable to execute Change Local Funds Transfer Limit " + e.getMessage());
		}
	}

	@Parameters({ "userName", "password", "app_Name" })
	@Test(priority = 17, enabled = true, description = "FundsTransfer-OtherPOSBDBS-ONEAPP-16723", dependsOnMethods = {
			"PreRequisiteScript" })
	@Description(value = "Execution of this testcase:: Verifies FundTransfer Other DBS/POSB")
	@Author(name = "shafqat")
	public void FundTransferOtherDBSPOSB(String userName, String password, String app_Name) throws Exception {
		try {
			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
			DBSPgaeObject1 = DBSPgaeObject;
			DBSPgaeObject1.LogInApplication(userName, password);
			DBSPgaeObject1.FundTransferDBSPOSB(app_Name);

		} catch (HandleException e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail(e.getCode() + "--> " + e.getMessage() );
		} catch (Exception e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail("Unable to execute Fund Transfer Other DBS/POSB " + e.getMessage());
		}
	}

	@Parameters({ "userName", "password", "app_Name" })
	@Test(priority = 18, enabled = true, description = "TransactionHistory-ONEAPP-14312", dependsOnMethods = {
			"PreRequisiteScript" })
	@Description(value = "Execution of this testcase:: Verifies Transaction History")
	@Author(name = "shafqat")
	public void TransactionHistory(String userName, String password, String app_Name) throws Exception {
		try {
			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
			DBSPgaeObject1 = DBSPgaeObject;
			DBSPgaeObject1.LogInApplication(userName, password);
			DBSPgaeObject1.verifyTransactionHistory(app_Name);
		} catch (HandleException e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail(e.getCode() + "--> " + e.getMessage() );
		} catch (Exception e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail("Unable to execute Transaction History " + e.getMessage());
		}
	}

	@Parameters({ "userName", "password", "app_Name" })
	@Test(priority = 19, enabled = true, description = "Verifies Credit Card Temperory Limit Increase", dependsOnMethods = {
			"PreRequisiteScript" })
	@Description(value = "Execution of this testcase:: CreditCardTempLimitIncrease-ONEAPP-16669")
	@Author(name = "shafqat")
	public void CreditCardTempLimitIncrease(String userName, String password, String app_Name) throws Exception {
		try {
			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
			DBSPgaeObject1 = DBSPgaeObject;
			DBSPgaeObject1.LogInApplication(userName, password);
			DBSPgaeObject1.CreditCardTempLimitIncrease();
		} catch (HandleException e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail(e.getCode() + "--> " + e.getMessage());
		} catch (Exception e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail("Unable to execute Credit Card Temp Limit Increase " + e.getMessage());
		}
	}

	@Parameters({ "userName", "password", "app_Name" })
	@Test(priority = 20, enabled = true, description = "UpdatePersonalParticular-ONEAPP-13921", dependsOnMethods = {
			"PreRequisiteScript" })
	@Description(value = "Execution of this testcase:: Verifies the Update Personal Particular Details.")
	@Author(name = "Divya Devi")
	public void UpdatePersonalParticular(String userName, String password, String app_Name) throws Exception {
		try {
			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
			DBSPgaeObject1 = DBSPgaeObject;
			DBSPgaeObject1.LogInApplication(userName, password);
			DBSPgaeObject1.UpdatePersonalDetails(app_Name);
		} catch (HandleException e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail(e.getCode() + "--> " + e.getMessage());
		} catch (Exception e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail("Unable to execute update Personal Particular " + e.getMessage());
		}
	}

	@Parameters({ "userName", "password", "app_Name" })
	@Test(priority = 23, enabled = true, description = "FundsTransfer-PayCreditCard-ONEAPP-14024", dependsOnMethods = {
			"PreRequisiteScript" })
	@Description(value = "Execution of this testcase:: Verifies the Fund Transfer Pay Credit Card.")
	@Author(name = "Divya Devi")
	public void FundsTransfer_PayCreditCard(String userName, String password, String app_Name) throws Exception {
		try {
			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
			DBSPgaeObject1 = DBSPgaeObject;
			DBSPgaeObject1.LogInApplication(userName, password);
			DBSPgaeObject1.FundsTransfer_PayCreditCard();
		} catch (HandleException e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail(e.getCode() + "--> " + e.getMessage());
		} catch (Exception e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail("Unable to execute Fund Transfer Pay Credit Card " + e.getMessage());
		}
	}

	@Parameters({ "userName", "password", "app_Name" })
	@Test(priority = 24, enabled = true, description = "FundsTransfer-BillPayment-ONEAPP-14040", dependsOnMethods = {
			"PreRequisiteScript" })
	@Description(value = "Execution of this testcase:: Verifies the Fund Transfer Bill Payment.")
	@Author(name = "Divya Devi")
	public void FundsTransfer_BillPayment(String userName, String password, String app_Name) throws Exception {
		try {
			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
			DBSPgaeObject1 = DBSPgaeObject;
			DBSPgaeObject1.LogInApplication(userName, password);
			DBSPgaeObject1.FundsTransfer_BillPayment();
		} catch (HandleException e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail(e.getCode() + "--> " + e.getMessage());
		} catch (Exception e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail("Unable to execute Fund Transfer Bill Payment " + e.getMessage());
		}
	}

	@Parameters({ "userName", "password", "app_Name" })
	@Test(priority = 25, enabled = true, description = "PeekBalance-MCA-ONEAPP-13982", dependsOnMethods = {
			"PreRequisiteScript" })
	@Description(value = "Execution of this testcase:: Verifies the Peek Balance.")
	@Author(name = "Divya Devi")
	public void PeekBalance_MCA(String userName, String password, String app_Name) throws Exception {
		try {
			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
			DBSPgaeObject1 = DBSPgaeObject;
			DBSPgaeObject1.LogInApplication(userName, password);
			DBSPgaeObject1.VerifyPeekBalance();
		} catch (HandleException e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail(e.getCode() + "--> " + e.getMessage());
		} catch (Exception e) {
			DBSPgaeObject1.verifyDigibankAlert();
			Asserts.assertFail("Unable to execute Peek Balance " + e.getMessage());
		}
	}

}
