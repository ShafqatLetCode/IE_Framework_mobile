package com.crestech.android.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.crestech.annotation.values.Author;
import com.crestech.appium.utils.CommonAppiumTest;
import com.crestech.base.UserBaseTest;
import com.crestech.common.utilities.CommonTestData;
import com.crestech.listeners.TestListener;
import com.crestech.pageobjects.DBS_IOSObject;
import com.crestech.pages.DBSAndroidPage;
import com.crestech.pages.DBS_IOSpage;

import io.qameta.allure.Description;

@Listeners(TestListener.class)
public class DBS_IOSTest extends UserBaseTest {
	
	Logger logger = Logger.getLogger(DBSAndroidTest.class.getName());

	
	@Parameters({"userName", "password" })
	@Test(priority=1, enabled=true, description = "Verify the account detail on dashboard page")
	@Description(value = "Execution of this testcase:: AccountDetails-CASA-ONEAPP-14400")
	@Author(name = "Shafqat Ali")
	public void accountDetails_CASA(String userName,String password) throws Exception {
		try {
			DBS_IOSpage DBSPgaeObject = new  DBS_IOSpage(driver);
			DBSPgaeObject.logInApplication(userName, password);
			DBSPgaeObject.verifyAccountTypeNameCurrencyAmount(CommonTestData.ACCOUNT_TYPE.getEnumValue() ,CommonTestData.ACCOUNT_NAME_HOME.getEnumValue(),CommonTestData.CURRENCY.getEnumValue() );
			
		} catch (Exception e) {
			e.printStackTrace(); 
			throw e; 
		}
	}
	@Parameters({"userName", "password" })
	@Test(priority=2, enabled=true, description = "Verify the Logout functionality for Applications")
	@Description(value = "Execution of this testcase:: Logout-ONEAPP-9392")
	@Author(name = "Shafqat Ali")
	public void Logout_ONEAPP(String userName,String password) throws Exception {
		try {
			DBS_IOSpage DBSPgaeObject = new  DBS_IOSpage(driver);
			DBSPgaeObject.logInApplication(userName, password);
			DBSPgaeObject.logOutApplication();
			
		} catch (Exception e) {
			e.printStackTrace(); 
			throw e;
		}
	}
	@Parameters({ "userName", "password" })
	@Test(priority = 3, enabled = true, description = "Remittance-Corridor-ONEAPP-13407")
	@Description(value = "Execution of this testcase:: Verifies the Remittance Corridor")
	@Author(name = "shafqat")
	public void Remittance_Corridor(String userName, String password) throws Exception {
		try {
			DBS_IOSpage DBSPgaeObject = new  DBS_IOSpage(driver);
			DBSPgaeObject.logInApplication(userName, password);
			DBSPgaeObject.VerifyRemittanceCorridor();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	@Parameters({"userName", "password" })
	@Test(priority=6, enabled=true, description = "Verify the Topup Paylah in Applications")
	@Description(value = "Execution of this testcase:: TopUp-PayLah-ONEAPP-13915")
	@Author(name = "Shafqat Ali")
	public void Topup_Paylah(String userName,String password) throws Exception { 
		try {
			DBS_IOSpage DBSPgaeObject = new  DBS_IOSpage(driver);
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
			DBS_IOSpage DBSPgaeObject = new  DBS_IOSpage(driver);
			DBSPgaeObject.logInApplication(userName, password);
			DBSPgaeObject.PayeeAddRemittance();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	@Parameters({"userName", "password" })
	@Test(priority=12,enabled=true,description = "Successful Change Limit for Transfers to Other Banks Accounts to Increase the Current limit")
	@Description(value = "Execution of this testcase:: ChangeLocalFundsTransferLimit-Increase-ONEAPP-7847")
	@Author(name = "Shafqat Ali")
	public void ChangeLocalFundsTransferLimit(String userName,String password) throws Exception { 
		try {
			DBS_IOSpage DBSPgaeObject = new  DBS_IOSpage(driver);
			DBSPgaeObject.logInApplication(userName, password);
			DBSPgaeObject.ChangeLocalFundsTransferLimit();
		} catch (Exception e) {
			e.printStackTrace(); 
			throw e;
		}
	}
	@Parameters({"userName", "password" })
	@Test(priority=17, enabled=true, description = "FundsTransfer-OtherPOSBDBS-ONEAPP-16723")
	@Description(value = "Execution of this testcase:: Verifies FundTransfer Other DBS/POSB")
	@Author(name = "shafqat")
	public void FundTransferOtherDBSPOSB(String userName,String password) throws Exception {
		try {
			DBS_IOSpage DBSPgaeObject = new  DBS_IOSpage(driver);
			DBSPgaeObject.logInApplication(userName, password);
			DBSPgaeObject.FundTransferOtherBank();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Parameters({"userName", "password" })
	@Test(priority=27, enabled=true, description = "TransactionHistory-ONEAPP-14312")
	@Description(value = "Execution of this testcase:: Verifies Transaction History")
	@Author(name = "shafqat")
	public void TransactionHistory(String userName,String password) throws Exception {
		try {
			DBS_IOSpage DBSPgaeObject = new  DBS_IOSpage(driver);
			DBSPgaeObject.logInApplication(userName, password);
			DBSPgaeObject.transactionHistoryVerify();
		} catch (Exception e) {
			e.printStackTrace();
			throw e; 
		}
	}
	


}
