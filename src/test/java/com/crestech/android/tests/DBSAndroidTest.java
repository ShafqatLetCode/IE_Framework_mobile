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
	
}
