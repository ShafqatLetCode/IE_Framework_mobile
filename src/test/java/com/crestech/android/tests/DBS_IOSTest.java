package com.crestech.android.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.crestech.annotation.values.Author;
import com.crestech.base.UserBaseTest;
import com.crestech.listeners.TestListener;
import com.crestech.pages.DBSAndroidPage;
import com.crestech.pages.DBS_IOSpage;

import io.qameta.allure.Description;

@Listeners(TestListener.class)
public class DBS_IOSTest extends UserBaseTest {

	Logger logger = Logger.getLogger(DBSAndroidTest.class.getName());

	@Parameters({ "userName", "password" })
	@Test(priority = 1, enabled = true, description = "Verify the account detail on dashboard page")
	@Description(value = "Execution of this testcase:: AccountDetails-CASA-ONEAPP-14400")
	@Author(name = "Shafqat Ali")
	public void accountDetails_CASA(String userName, String password) throws Exception {
		try {
			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
			DBSPgaeObject.logInApplication(userName, password);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Parameters({ "userName", "password" })
	@Test(priority = 2, enabled = true, description = "Verify the Logout functionality for Applications")
	@Description(value = "Execution of this testcase:: Logout-ONEAPP-9392")
	@Author(name = "Shafqat Ali")
	public void Logout_ONEAPP(String userName, String password) throws Exception {
		try {
			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
			DBSPgaeObject.logInApplication(userName, password);
			DBSPgaeObject.logOutApplication();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Parameters({ "userName", "password" })
	@Test(priority = 5, enabled = true, description = "Payee-Add-DBSorPOSB-ONEAPP-14675")
	@Description(value = "Execution of this testcase:: Verifies the Payee add DSB or POSB.")
	@Author(name = "Divya Devi")
	public void Payee_Add_DBSorPOSB(String userName, String password) throws Exception {
		try {
			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
			DBSPgaeObject.logInApplication(userName, password);
			//Delete Payee Code Start Before Adding Payee DBS/POSB
			DBSPgaeObject.DeletePayee_ToDBSPOSB();
			DBSPgaeObject.VerifyAddPayeeDBSorPOSB();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Parameters({ "userName", "password" })
	@Test(priority = 6, enabled = true, description = "Verify the Topup Paylah in Applications")
	@Description(value = "Execution of this testcase:: TopUp-PayLah-ONEAPP-13915")
	@Author(name = "Shafqat Ali")
	public void Topup_Paylah(String userName, String password) throws Exception {
		try {
			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
			DBSPgaeObject.logInApplication(userName, password);
			DBSPgaeObject.TopupPaylah();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Parameters({ "userName", "password" })
	@Test(priority = 7, enabled = true, description = "Payee-Add-Remittance-ONEAPP-13679")
	@Description(value = "Execution of this testcase:: Verify the Add Remittance payee")
	@Author(name = "Shafqat Ali")
	public void Payee_Add_Remittance(String userName, String password) throws Exception {
		try {
			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
			DBSPgaeObject.logInApplication(userName, password);
			DBSPgaeObject.PayeeAddRemittance();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Parameters({ "userName", "password" })
	@Test(priority = 9, enabled = true, description = "Payee-Add-Local-OtherBank-ONEAPP-15677")
	@Description(value = "Execution of this testcase:: Verifies the Payee Add Local Other Bank.")
	@Author(name = "Divya Devi")
	public void Payee_Add_Local_OtherBank(String userName, String password) throws Exception {
		try {
			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
			DBSPgaeObject.logInApplication(userName, password);
			//Delete Payee Code Start Before Adding Payee Local to Other Bank
			DBSPgaeObject.DeletePayee_LocalToOtherBank();
			DBSPgaeObject.PayeeAddLocalOtherBank();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Parameters({ "userName", "password" })
	@Test(priority = 10, enabled = true, description = "Payee-Add-BillPayment-ONEAPP-15938")
	@Description(value = "Execution of this testcase:: Verifies the Payee Add Bill Payment.")
	@Author(name = "Divya Devi")
	public void Payee_Add_BillPayment(String userName, String password) throws Exception {
		try {
			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
			DBSPgaeObject.logInApplication(userName, password);
			//Delete Payee Code Start Before Adding Payee to Bill Payment.
			DBSPgaeObject.DeletePayee_ToBillPayment();
			DBSPgaeObject.PayeeAddBillPayment();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Parameters({ "userName", "password" })
	@Test(priority = 12, enabled = true, description = "Successful Change Limit for Transfers to Other Banks Accounts to Increase the Current limit")
	@Description(value = "Execution of this testcase:: ChangeLocalFundsTransferLimit-Increase-ONEAPP-7847")
	@Author(name = "Shafqat Ali")
	public void ChangeLocalFundsTransferLimit(String userName, String password) throws Exception {
		try {
			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
			DBSPgaeObject.logInApplication(userName, password);
			DBSPgaeObject.ChangeLocalFundsTransferLimit();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Parameters({ "userName", "password" })
	@Test(priority = 14, enabled = true, description = "FundsTransfer-OwnAccount-ONEAPP-16730")
	@Description(value = "Execution of this testcase:: Verifies the Fund Transfer Own Account.")
	@Author(name = "Divya Devi")
	public void FundsTransferOwnAccount(String userName, String password) throws Exception {
		try {
			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
			DBSPgaeObject.logInApplication(userName, password);
			DBSPgaeObject.VerifyFundTransfer_OwnAccount();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Parameters({ "userName", "password" })
	@Test(priority = 23, enabled = true, description = "FundsTransfer-PayCreditCard-ONEAPP-14024")
	@Description(value = "Execution of this testcase:: Verifies the Fund Transfer Pay Credit Card.")
	@Author(name = "Divya Devi")
	public void FundsTransfer_PayCreditCard(String userName, String password) throws Exception {
		try {
			DBS_IOSpage DBSPgaeObject = new DBS_IOSpage(driver);
			DBSPgaeObject.logInApplication(userName, password);
			DBSPgaeObject.FundsTransfer_PayCreditCard();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
