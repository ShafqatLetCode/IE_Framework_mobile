package com.crestech.android.tests;

import static org.testng.Assert.assertFalse;

import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.crestech.annotation.values.Author;
import com.crestech.appium.utils.CommonAppiumTest;
import com.crestech.base.UserBaseTest;
import com.crestech.common.utilities.AndroidAlert;
import com.crestech.common.utilities.Asserts;
import com.crestech.common.utilities.CommonAlertElements;
import com.crestech.common.utilities.CommonTestData;
import com.crestech.common.utilities.GestureUtils;
import com.crestech.common.utilities.TestDataUtils;
import com.crestech.common.utilities.WaitUtils;
import com.crestech.config.ContextManager;
import com.crestech.listeners.TestListener;
import com.crestech.pages.DBSAndroidPage;

import io.appium.java_client.MobileElement;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

@Listeners(TestListener.class)
public class DBSAndroidTest extends UserBaseTest {

	public DBSAndroidTest() throws Exception {
		super();
	}

	Logger logger = Logger.getLogger(DBSAndroidTest.class.getName());
	Asserts Assert = new Asserts();
	@Parameters({"userName", "password" })
	@Test(priority=1,enabled=true,description = "Verify the account detail on dashboard page")
	@Description(value = "Execution of this testcase:: AccountDetails-CASA-ONEAPP-14400t")
	@Author(name = "Shafqat Ali")
	public void accountDetails_CASA(String userName,String password) throws InterruptedException {
		try {
			 logInApplication(userName, password);
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	@Parameters({"userName", "password" })
	@Test(priority=2,enabled=true,description = "Verify the Logout functionality for Applications")
	@Description(value = "Execution of this testcase:: Logout-ONEAPP-9392")
	@Author(name = "Shafqat Ali")
	public void Logout_ONEAPP(String userName,String password) throws InterruptedException {
		try {
			
			 logInApplication(userName, password);
			logOutApplication();
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	@Parameters({"userName", "password" })
	@Test(priority=5,enabled=true,description = "Verify the Add Remittance payee")
	@Description(value = "Execution of this testcase::Payee-Add-Remittance-ONEAPP-13679")
	@Author(name = "Shafqat Ali")
	public void Payee_Add_Remittance(String userName,String password) throws InterruptedException {
		try {
			DBSAndroidPage dbspage = new DBSAndroidPage(driver);
			WaitUtils wait = new WaitUtils(driver);
			 logInApplication(userName, password);
			 dbspage.payAndTransferVerifyClick(CommonTestData.PAY_TRANSFER_ICON.getEnumValue());
			 dbspage.overseasVerifyClick(CommonTestData.OVERSEAS_ICON.getEnumValue());
			 dbspage.addRecipientNownVerifyClick(CommonTestData.ADD_RECIPIENT_LABEL.getEnumValue());
			 dbspage.sendDataInSearchBoxAndSelectFromDropDown(CommonTestData.COUNTRY_AUS.getEnumValue(), CommonTestData.COUNTRY_AUS.getEnumValue());
			 dbspage.CurrencyTypeVerifyClick(CommonTestData.CURRENCY_AUS.getEnumValue());
			 dbspage.nextButtonVerifyClick();
			 dbspage.sendBankCode(CommonTestData.BANK_BCD_CODE.getEnumValue());
			 dbspage.nextButtonVerifyClick();
			 dbspage.sendAccountNo(CommonTestData.ACCOUNT_NO.getEnumValue());
			 dbspage.sendFullName(CommonTestData.FULL_NAME.getEnumValue());
			 GestureUtils.scrollUPtoObject("text", "NEXT", dbspage.DBSappObject.nextButton());
			 dbspage.sendAddress(CommonTestData.ADDRESS.getEnumValue());
			 dbspage.sendcity(CommonTestData.CITY.getEnumValue());
			 dbspage.nextButtonVerifyClick();
			 dbspage.verifyRecipientReviewDetailLabel(CommonTestData.REVIEW_RECIPIENT_LABEL.getEnumValue());
			 GestureUtils.scrollUPtoObject("text", "ADD RECIPIENT NOW", dbspage.DBSappObject.addRecpientNowButton());
			 dbspage.addRecipientNownVerifyClick(CommonTestData.ADD_NOW_RECIPIENT_LABEL.getEnumValue());
			 //2fa
			 dbspage.verifyRecipientAddedLabel(CommonTestData.RECIPIENT_ADDED.getEnumValue());
			 dbspage.expandButton();
			 GestureUtils.scrollUPtoObject("text", "Reference No.", dbspage.DBSappObject.referenceNoLabel());
			 dbspage.verifymakeTransferButton(CommonTestData.MAKE_TRANSFER.getEnumValue());
			 dbspage.verifyReferenceFieldAndItsValue(CommonTestData.REFERENCE_NUMBER.getEnumValue());
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	@Parameters({"userName", "password" })
	@Test(priority=6,enabled=true,description = "Verify the Topup Paylah in Applications")
	@Description(value = "Execution of this testcase:: TopUp-PayLah-ONEAPP-13915")
	@Author(name = "Shafqat Ali")
	public void Topup_Paylah(String userName,String password) throws InterruptedException {
		try {
			DBSAndroidPage dbspage = new DBSAndroidPage(driver);
			WaitUtils wait = new WaitUtils(driver);
			 logInApplication(userName, password);
			 dbspage.payAndTransferVerifyClick(CommonTestData.PAY_TRANSFER_ICON.getEnumValue());
			 dbspage.topUpVerifyClick(CommonTestData.TOPUP_LABEL.getEnumValue());
			 dbspage.payLahVerifyClick(CommonTestData.PAYLAH_LABEL.getEnumValue());
			 dbspage.verifyTopUpPaylahLabel(CommonTestData.TOPUP_PAYLAH_LABEL.getEnumValue());
			 dbspage.sendCurrencyInTextField(CommonTestData.AMOUNT_PAYLAH.getEnumValue());
			 dbspage.nextButtonVerifyClick();
			 dbspage.verifyReviewTopUpLabel(CommonTestData.TOPUP_REVIEW_LABEL.getEnumValue());
			 dbspage.verifyDisplayAmount(CommonTestData.AMOUNT_PAYLAH.getEnumValue());
			 dbspage.topUpNowVerifyClick(CommonTestData.TOPUP_NOW_BUTTOM_LABEL.getEnumValue());
			 dbspage.verifyTopUpDoneLabel(CommonTestData.TOPUP_UP_DONE_LABEL.getEnumValue());
			 dbspage.verifyDisplayAmount(CommonTestData.AMOUNT_PAYLAH.getEnumValue());
			 dbspage.logOutTopUpVerifyClick(CommonTestData.LOGOUT_PAYLAH.getEnumValue());
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
    @Step("Log In the Application")
	public void logInApplication(String userName, String password) throws Exception {

		try {
			
			DBSAndroidPage dbspage = new DBSAndroidPage(driver);
			WaitUtils wait = new WaitUtils(driver);
			CommonAlertElements btnElements = new CommonAlertElements(driver);
			AndroidAlert alert = new AndroidAlert(driver);
			Thread.sleep(10000);
			driver.closeApp();
			wait.ImplicitlyWait();
			dbspage.relaunchingDBS();
			Thread.sleep(10000);
			dbspage.clickOnLoginButton();
			wait.ImplicitlyWait();
			dbspage.sendDataInUserId(userName);
			dbspage.sendDataInUserPin(password);
			dbspage.clickOnLoginButton();
			wait.ImplicitlyWait();
			digitalTokenSetUp();
			wait.ImplicitlyWait();
			alert.fingerprintAlertHandlingWithButtonMessage(btnElements.closeButton(),
					CommonTestData.FINGERPRINT_MESSAGE.getEnumValue());
			alert.recordingAlertHandlingWithButtonMessage(btnElements.closeButton(),
					CommonTestData.RECORDERSECTION_MESSAGE.getEnumValue());
			wait.ImplicitlyWait();
			dbspage.verifyTextWelcomeTo(CommonTestData.WELCOME.getEnumValue());
	    	dbspage.verifyTextDigibank(CommonTestData.DIGIBANK.getEnumValue());
	    	Thread.sleep(5000);
		} catch (Exception e) {
			assertFalse(true);
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
			
		}
	}
    @Step("Log Out the Application")
	public void logOutApplication() throws Exception
	{
		try {
			WaitUtils wait = new WaitUtils(driver);
			DBSAndroidPage dbspage = new DBSAndroidPage(driver);	
		dbspage.clickOnLogoutAndVerify(CommonTestData.LOGOUT.getEnumValue());
		wait.ImplicitlyWait();
		dbspage.verifyTextTapOnTheStars(CommonTestData.RATE_MESSAGE.getEnumValue());
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}
    @Step("Digital Token SetUp")
   	public void digitalTokenSetUp() throws Exception {

   		try {
   			Thread.sleep(5000);
   			DBSAndroidPage dbspage = new DBSAndroidPage(driver);
   			WaitUtils wait = new WaitUtils(driver);
   			wait.ImplicitlyWait();
   			dbspage.verifyPageAndClickOnSetUpNowButton(CommonTestData.DIGITAL_TOKEN_SETUP_MESSAGE.getEnumValue());
   			wait.ImplicitlyWait();
   			dbspage.verifyPageAndSendOtpToEditBox(CommonTestData.OTP.getEnumValue(),CommonTestData.EMAIL_OTP_MESSAGE.getEnumValue());
   			wait.ImplicitlyWait();
   			dbspage.verifyPageAndSendOtpToEditBox(CommonTestData.OTP.getEnumValue(),CommonTestData.SMS_OTP_MESSAGE.getEnumValue());
   			wait.ImplicitlyWait();
   			dbspage.verifyPageAndClickOnDone(CommonTestData.DIGITAL_TOKEN_MESSAGE_AFTER_STEPUP.getEnumValue());
   		} catch (Exception e) {
   			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
   		}
   	}
}
