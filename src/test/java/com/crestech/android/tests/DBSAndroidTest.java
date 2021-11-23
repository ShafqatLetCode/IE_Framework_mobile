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
	
	@Parameters({"userName", "password" })
	@Test(priority=1, enabled=true, description = "Verify the account detail on dashboard page")
	@Description(value = "Execution of this testcase:: AccountDetails-CASA-ONEAPP-14400")
	@Author(name = "Shafqat Ali")
	public void accountDetails_CASA(String userName,String password) throws Exception {
		try {
			DBSAndroidPage dbspage = new DBSAndroidPage(driver);
			dbspage.logInApplication(userName, password);
			
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e)); 
		}
	}
	
	@Parameters({"userName", "password" })
	@Test(priority=2, enabled=true, description = "Verify the Logout functionality for Applications")
	@Description(value = "Execution of this testcase:: Logout-ONEAPP-9392")
	@Author(name = "Shafqat Ali")
	public void Logout_ONEAPP(String userName,String password) throws Exception {
		try {
			 DBSAndroidPage dbspage = new DBSAndroidPage(driver);
			 dbspage.logInApplication(userName, password);
			 dbspage.clickOnLogoutAndVerify(CommonTestData.LOGOUT.getEnumValue(), CommonTestData.RATE_MESSAGE.getEnumValue());
			
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e)); 
		}
	}

	
	
  
	@Parameters({"userName", "password" })
	@Test(priority=3, enabled=true, description = "Verifies the Remittance Corridor")
	@Description(value = "Execution of this testcase:: Remittance-Corridor-ONEAPP-13407")
	@Author(name = "Divya Devi")
	public void Remittance_Corridor(String userName,String password) throws Exception {
		try {
			 DBSAndroidPage dbspage = new DBSAndroidPage(driver);
			 dbspage.logInApplication(userName, password);
			 dbspage.VerifyRemittanceCorridor();
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e)); 
		}
	}
	
	@Parameters({"userName", "password" })
	@Test(priority=4, enabled=true, description = "Verifies the Remittance eOTT.")
	@Description(value = "Execution of this testcase:: Remittance-eOTT-ONEAPP-14008")
	@Author(name = "Divya Devi")
	public void Remittance_eOTT(String userName,String password) throws Exception {
		try {
			 DBSAndroidPage dbspage = new DBSAndroidPage(driver);
			 dbspage.logInApplication(userName, password);
			 dbspage.VerifyRemittanceEOTT();
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e)); 
		}
	}
	
	@Parameters({"userName", "password" })
	@Test(priority=5, enabled=true, description = "Verifies the Payee add DSB or POSB.")
	@Description(value = "Execution of this testcase:: Payee-Add-DBSorPOSB-ONEAPP-14675")
	@Author(name = "Divya Devi")
	public void Payee_Add_DBSorPOSB(String userName,String password) throws Exception {
		try {
			 DBSAndroidPage dbspage = new DBSAndroidPage(driver);
			 dbspage.logInApplication(userName, password);
			 dbspage.VerifyAddPayeeDBSorPOSB();
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e)); 
		}
	}
	
	@Parameters({"userName", "password" })
	@Test(priority=6, enabled=true, description = "Verify the Topup Paylah in Applications")
	@Description(value = "Execution of this testcase:: TopUp-PayLah-ONEAPP-13915")
	@Author(name = "Shafqat Ali")
	public void Topup_Paylah(String userName,String password) throws Exception { 
		try {
			 DBSAndroidPage dbspage = new DBSAndroidPage(driver);
			 dbspage.logInApplication(userName, password);
			 dbspage.TopupPaylah();
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}
	
	@Parameters({"userName", "password" })
	@Test(priority=7, enabled=true, description = "Verify the Add Remittance payee")
	@Description(value = "Execution of this testcase::Payee-Add-Remittance-ONEAPP-13679")
	@Author(name = "Shafqat Ali")
	public void Payee_Add_Remittance(String userName,String password) throws Exception { 
		try {
			 DBSAndroidPage dbspage = new DBSAndroidPage(driver);
			 dbspage.logInApplication(userName, password);
			 dbspage.PayeeAddRemittance();
		} catch (Exception e) { 
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}
	
	@Parameters({"userName", "password" })
	@Test(priority=8, enabled=true, description = "Verifies the Apply Debit Card.")
	@Description(value = "Execution of this testcase:: ApplyDebitCard-ONEAPP-15861")
	@Author(name = "Divya Devi")
	public void ApplyDebitCard(String userName,String password) throws Exception {
		try {
			 DBSAndroidPage dbspage = new DBSAndroidPage(driver);
			 dbspage.logInApplication(userName, password);
			 dbspage.ApplyDebitCard();
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e)); 
		}
	}
	
	@Parameters({"userName", "password" })
	@Test(priority=9, enabled=true, description = "Verifies the Payee Add Local Other Bank.")
	@Description(value = "Execution of this testcase:: Payee-Add-Local-OtherBank-ONEAPP-15677")
	@Author(name = "Divya Devi")
	public void Payee_Add_Local_OtherBank(String userName,String password) throws Exception {
		try {
			 DBSAndroidPage dbspage = new DBSAndroidPage(driver);
			 dbspage.logInApplication(userName, password);
			 dbspage.PayeeAddLocalOtherBank();
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e)); 
		}
	}
	
	
	@Parameters({"userName", "password" })
	@Test(priority=10, enabled=true, description = "Verifies the Payee Add Bill Payment.")
	@Description(value = "Execution of this testcase:: Payee-Add-BillPayment-ONEAPP-15938")
	@Author(name = "Divya Devi")
	public void Payee_Add_BillPayment(String userName,String password) throws Exception {
		try {
			 DBSAndroidPage dbspage = new DBSAndroidPage(driver);
			 dbspage.logInApplication(userName, password);
			 dbspage.PayeeAddBillPayment();
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e)); 
		}
	}
	
	@Parameters({"userName", "password" })
	@Test(priority=11, enabled=true, description = "Verifies the Open Account.")
	@Description(value = "Execution of this testcase:: OpenAccount-ONEAPP-14028")
	@Author(name = "Divya Devi")
	public void OpenAccount(String userName,String password) throws Exception {
		try {
			 DBSAndroidPage dbspage = new DBSAndroidPage(driver);
			 dbspage.logInApplication(userName, password);
			 dbspage.OpenAccount();
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e)); 
		}
	}
	
	@Parameters({"userName", "password" })
	@Test(priority=12,enabled=false,description = "Successful Change Limit for Transfers to Other Banks Accounts to Increase the Current limit")
	@Description(value = "Execution of this testcase:: ChangeLocalFundsTransferLimit-Increase-ONEAPP-7847")
	@Author(name = "Shafqat Ali")
	public void ChangeLocalFundsTransferLimit(String userName,String password) throws Exception { 
		try {
			DBSAndroidPage dbspage = new DBSAndroidPage(driver);
			 dbspage.logInApplication(userName, password);
			 dbspage.ChangeLocalFundsTransferLimit();
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}
	
	@Parameters({"userName", "password" })
	@Test(priority=13, enabled=true, description = "Verifies the Peek Balance.")
	@Description(value = "Execution of this testcase:: PeekBalance-MCA-ONEAPP-13982")
	@Author(name = "Divya Devi")
	public void PeekBalance_MCA(String userName,String password) throws Exception {
		try {
			 DBSAndroidPage dbspage = new DBSAndroidPage(driver);
			 dbspage.logInApplication(userName, password);
			 dbspage.VerifyPeekBalance();
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e)); 
		}
	}
	
}
