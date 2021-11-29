package com.crestech.android.tests;

import java.util.logging.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.crestech.annotation.values.Author;
import com.crestech.appium.utils.CommonAppiumTest;
import com.crestech.base.UserBaseTest;
import com.crestech.common.utilities.Asserts;
import com.crestech.common.utilities.CommonTestData;
import com.crestech.common.utilities.GestureUtils;
import com.crestech.listeners.TestListener;
import com.crestech.pages.DBSAndroidPage;
import io.qameta.allure.Description;

@Listeners(TestListener.class)
public class DBSAndroidTest extends UserBaseTest {

	public DBSAndroidTest() throws Exception {
		super();
	}

	Logger logger = Logger.getLogger(DBSAndroidTest.class.getName());
	Asserts Assert = new Asserts();

	@Parameters({ "userName", "password" })
	@Test(priority = 1, enabled = true, description = "Verify the account detail on dashboard page")
	@Description(value = "Execution of this testcase:: AccountDetails-CASA-ONEAPP-14400")
	@Author(name = "Shafqat Ali")
	public void accountDetails_CASA(String userName, String password) throws Exception {
		try {
			DBSAndroidPage dbspage = new DBSAndroidPage(driver);
			dbspage.logInApplication(userName, password);

		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}

	@Parameters({ "userName", "password" })
	@Test(priority = 2, enabled = true, description = "Verify the Logout functionality for Applications")
	@Description(value = "Execution of this testcase:: Logout-ONEAPP-9392")
	@Author(name = "Shafqat Ali")
	public void Logout_ONEAPP(String userName, String password) throws Exception {
		try {
			DBSAndroidPage dbspage = new DBSAndroidPage(driver);
			dbspage.logInApplication(userName, password);
			dbspage.clickOnLogoutAndVerify(CommonTestData.LOGOUT.getEnumValue(),
					CommonTestData.RATE_MESSAGE.getEnumValue());

		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}

	@Parameters({ "userName", "password" })
	@Test(priority = 3, enabled = true, description = "Verifies the Remittance Corridor")
	@Description(value = "Execution of this testcase:: Remittance-Corridor-ONEAPP-13407")
	@Author(name = "Divya Devi")
	public void Remittance_Corridor(String userName, String password) throws Exception {
		try {
			DBSAndroidPage dbspage = new DBSAndroidPage(driver);
			dbspage.logInApplication(userName, password);
			dbspage.VerifyRemittanceCorridor();
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}

	@Parameters({ "userName", "password" })
	@Test(priority = 4, enabled = true, description = "Verifies the Remittance eOTT.")
	@Description(value = "Execution of this testcase:: Remittance-eOTT-ONEAPP-14008")
	@Author(name = "Divya Devi")
	public void Remittance_eOTT(String userName, String password) throws Exception {
		try {
			DBSAndroidPage dbspage = new DBSAndroidPage(driver);
			dbspage.logInApplication(userName, password);
			dbspage.VerifyRemittanceEOTT();
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}

	@Parameters({ "userName", "password" })
	@Test(priority = 5, enabled = true, description = "Verifies the Payee add DSB or POSB.")
	@Description(value = "Execution of this testcase:: Payee-Add-DBSorPOSB-ONEAPP-14675")
	@Author(name = "Divya Devi")
	public void Payee_Add_DBSorPOSB(String userName, String password) throws Exception {
		try {
			DBSAndroidPage dbspage = new DBSAndroidPage(driver);
			dbspage.logInApplication(userName, password);
			dbspage.VerifyAddPayeeDBSorPOSB();
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}

	@Parameters({ "userName", "password" })
	@Test(priority = 6, enabled = true, description = "Verify the Topup Paylah in Applications")
	@Description(value = "Execution of this testcase:: TopUp-PayLah-ONEAPP-13915")
	@Author(name = "Shafqat Ali")
	public void Topup_Paylah(String userName, String password) throws Exception {
		try {
			DBSAndroidPage dbspage = new DBSAndroidPage(driver);
			dbspage.logInApplication(userName, password);
	        dbspage.TopupPaylah();
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
	}
	}
		

	@Parameters({ "userName", "password" })
	@Test(priority = 7, enabled = true, description = "Execution of this testcase::Payee-Add-Remittance-ONEAPP-13679")
	@Description(value = "Verify the Add Remittance payee")
	@Author(name = "Shafqat Ali")
	public void Payee_Add_Remittance(String userName, String password) throws Exception {
		try {
			DBSAndroidPage dbspage = new DBSAndroidPage(driver);
			dbspage.logInApplication(userName, password);
		dbspage.PayeeAddRemittance();
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}

	@Parameters({ "userName", "password" })
	@Test(priority = 8, enabled = true, description = "Verifies the Apply Debit Card.")
	@Description(value = "Execution of this testcase:: ApplyDebitCard-ONEAPP-15861")
	@Author(name = "Divya Devi")
	public void ApplyDebitCard(String userName, String password) throws Exception {
		try {
			DBSAndroidPage dbspage = new DBSAndroidPage(driver);
			dbspage.logInApplication(userName, password);
			dbspage.ApplyDebitCard();
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}

	@Parameters({ "userName", "password" })
	@Test(priority = 9, enabled = true, description = "Verifies the Payee Add Local Other Bank.")
	@Description(value = "Execution of this testcase:: Payee-Add-Local-OtherBank-ONEAPP-15677")
	@Author(name = "Divya Devi")
	public void Payee_Add_Local_OtherBank(String userName, String password) throws Exception {
		try {
			DBSAndroidPage dbspage = new DBSAndroidPage(driver);
			dbspage.logInApplication(userName, password);
			dbspage.PayeeAddLocalOtherBank();
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}

	@Parameters({ "userName", "password" })
	@Test(priority = 10, enabled = true, description = "Verifies the Payee Add Bill Payment.")
	@Description(value = "Execution of this testcase:: Payee-Add-BillPayment-ONEAPP-15938")
	@Author(name = "Divya Devi")
	public void Payee_Add_BillPayment(String userName, String password) throws Exception {
		try {
			DBSAndroidPage dbspage = new DBSAndroidPage(driver);
			dbspage.logInApplication(userName, password);
			dbspage.PayeeAddBillPayment();
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}

	@Parameters({ "userName", "password" })
	@Test(priority = 11, enabled = true, description = "Verifies the Open Account.")
	@Description(value = "Execution of this testcase:: OpenAccount-ONEAPP-14028")
	@Author(name = "Divya Devi")
	public void OpenAccount(String userName, String password) throws Exception {
		try {
			DBSAndroidPage dbspage = new DBSAndroidPage(driver);
			dbspage.logInApplication(userName, password);
			dbspage.OpenAccount();
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}

	@Parameters({ "userName", "password" })
	@Test(priority = 12, enabled = true, description = "Successful Change Limit for Transfers to Other Banks Accounts to Increase the Current limit")
	@Description(value = "Execution of this testcase:: ChangeLocalFundsTransferLimit-Increase-ONEAPP-7847")
	@Author(name = "Shafqat Ali")
	public void ChangeLocalFundsTransferLimit(String userName, String password) throws Exception {
		try {
			DBSAndroidPage dbspage = new DBSAndroidPage(driver);
			dbspage.logInApplication(userName, password);
			dbspage.ChangeLocalFundsTransferLimit();
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}

	@Parameters({ "userName", "password" })
	@Test(priority = 13, enabled = true, description = "Verifies the Peek Balance.")
	@Description(value = "Execution of this testcase:: PeekBalance-MCA-ONEAPP-13982")
	@Author(name = "Divya Devi")
	public void PeekBalance_MCA(String userName, String password) throws Exception {
		try {
			DBSAndroidPage dbspage = new DBSAndroidPage(driver);
			dbspage.logInApplication(userName, password);
			dbspage.VerifyPeekBalance();
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}

	@Parameters({ "userName", "password" })
	@Test(priority = 14, enabled = false, description = "Verifies the Fund Transfer Own Account.")
	@Description(value = "Execution of this testcase:: FundsTransfer-OwnAccount-ONEAPP-16730")
	@Author(name = "Divya Devi")
	public void FundsTransferOwnAccount(String userName, String password) throws Exception {
		try {
			DBSAndroidPage dbspage = new DBSAndroidPage(driver);
			dbspage.logInApplication(userName, password);
			dbspage.VerifyFundTransfer_OwnAccount();
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}

	@Parameters({ "userName", "password" })
	@Test(priority = 15, enabled = true, description = "Verifies the Fund Transfer Other Bank Non Fast Future Transfer Date.")
	@Description(value = "Execution of this testcase:: FundsTransfer-OtherBank-NonFAST-Future-THANOS-5244")
	@Author(name = "Divya Devi")
	public void FundsTransfer_OtherBank_NonFAST_Future(String userName, String password) throws Exception {
		try {
			DBSAndroidPage dbspage = new DBSAndroidPage(driver);
			dbspage.logInApplication(userName, password);
			dbspage.FundsTransfer_OtherBank_NonFASTFuture();
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}

	@Parameters({ "userName", "password" })
	@Test(priority = 16, enabled = true, description = "Verifies the Fund Transfer Other Bank Non Immediate Transfer Date.")
	@Description(value = "Execution of this testcase:: FundsTransfer-OtherBank-NonFAST-ONEAPP-16728")
	@Author(name = "Divya Devi")
	public void FundsTransfer_OtherBank_NonFAST(String userName, String password) throws Exception {
		try {
			DBSAndroidPage dbspage = new DBSAndroidPage(driver);
			dbspage.logInApplication(userName, password);
			dbspage.FundsTransfer_OtherBank_NonFAST();
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}

	@Parameters({"userName", "password" })
	@Test(priority=17, enabled=true, description = "Verifies FundTransfer Other DBS/POSB")
	@Description(value = "Execution of this testcase:: FundsTransfer-OtherPOSBDBS-ONEAPP-16723")
	@Author(name = "shafqat")
	public void FundTransferOtherDBSPOSB(String userName,String password) throws Exception {
		try {
			 DBSAndroidPage dbspage = new DBSAndroidPage(driver);
			 dbspage.logInApplication(userName, password);
			 dbspage.FundTransferOtherBank();
             
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e)); 
		}
	}
	@Parameters({"userName", "password" })
	@Test(priority=18, enabled=true, description = "Verifies TransactionHistory")
	@Description(value = "Execution of this testcase:: TransactionHistory-ONEAPP-14312")
	@Author(name = "shafqat")
	public void transactionHistory(String userName,String password) throws Exception {
		try {
			 DBSAndroidPage dbspage = new DBSAndroidPage(driver);
			 dbspage.logInApplication(userName, password);
			 dbspage.transactionHistoryVerify();
			 dbspage.clickOnLogoutAndVerify(CommonTestData.LOGOUT.getEnumValue(), CommonTestData.RATE_MESSAGE.getEnumValue());
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e)); 
		}
	}
	@Parameters({"userName", "password" })
	@Test(priority=18, enabled=true, description = "Verifies Credit Card Temperory Limit Increase")
	@Description(value = "Execution of this testcase:: CreditCardTempLimitIncrease-ONEAPP-16669")
	@Author(name = "shafqat")
	public void CreditCardTempLimitIncrease(String userName,String password) throws Exception {
		try {
			 DBSAndroidPage dbspage = new DBSAndroidPage(driver);
			 dbspage.logInApplication(userName, password);
			 dbspage.ClickOnMoreBtnAndAuthenticationOfSecurePIN();
			 dbspage.sendDataInCommonSearchBoxAndSelectFromDropDown(CommonTestData.TEMP_LIMIT_INCREASE.getEnumValue(), CommonTestData.TEMP_LIMIT_INCREASE.getEnumValue(), CommonTestData.TEMP_LIMIT_INCREASE_TITLE.getEnumValue(), dbspage.DBSappObject.PageHeader());
			 dbspage.setAmountDurationPurposeForLimitIncrease("100", "wedding", "11" , "oct", "2021");
			 GestureUtils.scrollUPtoObject("text", "NEXT", dbspage.DBSappObject.NextBtn());
			 dbspage.ClickOnNextButton();
			 dbspage.verifyPageHeader(CommonTestData.REVIEW_APPLICATION_CREDITLIMIT_TITLE.getEnumValue(),dbspage.DBSappObject.PageHeader());
			 
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e)); 
		}
	}
	
}
