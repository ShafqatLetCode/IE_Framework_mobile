package com.crestech.pages;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import com.crestech.appium.utils.CommonAppiumTest;
import com.crestech.common.utilities.AndroidAlert;
import com.crestech.common.utilities.Asserts;
import com.crestech.common.utilities.CommonAlertElements;
import com.crestech.common.utilities.CommonTestData;
import com.crestech.common.utilities.GestureUtils;
import com.crestech.common.utilities.HandleException;
import com.crestech.common.utilities.WaitUtils;
import com.crestech.pageobjects.DBSAndroidObject;
import com.crestech.pages.androidpage.enterPasscode;
import com.crestech.pages.androidpage.homePage;
import com.crestech.pages.androidpage.launchPage;
import com.crestech.pages.androidpage.loginPage;
import com.crestech.pages.androidpage.preloginPage;
import com.crestech.pages.androidpage.ratingPage;
import com.crestech.pages.androidpage.more.More;
import com.crestech.pages.androidpage.more.cardsModule;
import com.crestech.pages.androidpage.more.depositAccounts;
import com.crestech.pages.androidpage.more.localTransferLimit;
import com.crestech.pages.androidpage.more.peekBalance;
import com.crestech.pages.androidpage.more.temporaryCreditLimitIncrease;
import com.crestech.pages.androidpage.more.transactionHistory;
import com.crestech.pages.androidpage.more.updateContactDetails;
import com.crestech.pages.androidpage.paytransfer.billModule;
import com.crestech.pages.androidpage.paytransfer.creditCard;
import com.crestech.pages.androidpage.paytransfer.deletePayee;
import com.crestech.pages.androidpage.paytransfer.localModule;
import com.crestech.pages.androidpage.paytransfer.overseasModule;
import com.crestech.pages.androidpage.paytransfer.payAndTransfer;
import com.crestech.pages.androidpage.paytransfer.payNow;
import com.crestech.pages.androidpage.paytransfer.topUpPaylah;
import com.crestech.pages.androidpage.paytransfer.yourDBSPOSBAccount;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;

/**
 * @author Divya Devi, Shafkat Ali
 *
 */
public class DBSAndroidPage extends CommonAppiumTest {

	static Logger log = Logger.getLogger(DBSAndroidPage.class.getName());
	public DBSAndroidObject DBSappObject = new DBSAndroidObject();
	public AppiumDriver<RemoteWebElement> driver = null;
	AndroidAlert androidAlert = null;
	WaitUtils wait = null;
	GestureUtils gestUtils = null;
	Asserts Assert = null;
	CommonAlertElements btnElements = null;
	HandleException obj_handleexception = null;
	launchPage launchpage = null;
	preloginPage preloginpage = null;
	loginPage loginpage = null;
	homePage homepage = null;
	ratingPage ratingpage = null;
	enterPasscode enterpasscode = null;
	payAndTransfer paytransfer = null;
	overseasModule overseasmodule = null;
	localModule local = null;
	topUpPaylah topUppaylah = null;
	More more = null;
	cardsModule cards = null;
	transactionHistory transactionhistory = null;
	billModule bills = null;
	temporaryCreditLimitIncrease temp = null;
	updateContactDetails update = null;
	localTransferLimit localtransferLimit = null;
	peekBalance peek = null;
	yourDBSPOSBAccount ownAccount = null;
	creditCard creditcard = null;
	depositAccounts depositaccounts= null;
	deletePayee deletepayee = null;
	payNow paynow = null;
	public DBSAndroidPage(AppiumDriver<RemoteWebElement> driver) throws Exception {
		super(driver);
		try {
			this.driver = driver;
			gestUtils = new GestureUtils(driver);
			androidAlert = new AndroidAlert(driver);
			wait = new WaitUtils(driver);
			gestUtils = new GestureUtils(driver);
			Assert = new Asserts();
			obj_handleexception = new HandleException(null, null);
			btnElements = new CommonAlertElements(driver);
			launchpage = new launchPage(driver);
			preloginpage = new preloginPage(driver);
			loginpage = new loginPage(driver);
			homepage = new homePage(driver);
			ratingpage = new ratingPage(driver);
			enterpasscode = new enterPasscode(driver);
			paytransfer = new payAndTransfer(driver);
			overseasmodule = new overseasModule(driver);
			local = new localModule(driver);
			topUppaylah = new topUpPaylah(driver);
			more = new More(driver);
			cards = new cardsModule(driver);
			transactionhistory = new transactionHistory(driver);
			bills = new billModule(driver);
			temp = new temporaryCreditLimitIncrease(driver);
			update = new updateContactDetails(driver);
			localtransferLimit = new localTransferLimit(driver);
			peek = new peekBalance(driver);
			ownAccount = new yourDBSPOSBAccount(driver);
			creditcard = new creditCard(driver);
			depositaccounts = new depositAccounts(driver);
			deletepayee = new deletePayee(driver);
			paynow = new payNow(driver);
			PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), DBSappObject);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("Pre - requisite script")
	public void preRequisiteScript(String userName, String password, String appName, String serverName)
			throws Exception {
		try {
			launchpage.handlingQuitButton();
			preloginpage.SelectUATServer(serverName);
			launchpage.clickOnLoginButton();
			loginpage.EnterCredentialsAndLogin(userName, password); 
			homepage.handleFakeLinkMessageScreen();
			homepage.digitalTokenSetUp();
			homepage.handlingGetStartedPopup(appName);
			homepage.handlingErrorAlert();
			homepage.handlingFingerPrintAlert(CommonTestData.FINGERPRINT_MESSAGE.getEnumValue());
			homepage.handleRecordingAlert(CommonTestData.RECORDERSECTION_MESSAGE.getEnumValue());
			wait.fluentWaitForElement(homepage.WelcomeToText());
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Exceute Pre-Requisite Script ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Exceute Pre-Requisite Script ", e);
		}
	}

	@Step("Log In the Application")
	public void LogInApplication(String userName, String password) throws Exception {
		try {	
			wait.ImplicitlyWait(45);
			preloginpage.ClickOnLoginButton(); 
			loginpage.EnterCredentialsAndLogin(userName, password); 
			//wait.fluentWaitForElement(homepage.WelcomeToText());
			WaitForElementForNExtPage(homepage.WelcomeToText());
			wait.ImplicitlyWait(15);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Exceute Log In Application ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Exceute Log In Application ", e);
		}
	}

	@Step("verify Account Details On Home Page")
	public void verifyAccountDetailsOnHomePage(String appName,boolean isSingleAccountHolder) throws Exception {
		try {
			if(appName.equals("DBS")) 
				homepage.verifyAccountTypeNameCurrencyAmount(CommonTestData.ACCOUNT_TYPE.getEnumValue(),
						CommonTestData.ACCOUNT_NAME_HOME.getEnumValue(), CommonTestData.CURRENCY.getEnumValue(),isSingleAccountHolder);
			else if(appName.equals("iWEALTH")) 
				homepage.verifyAccountTypeNameCurrencyAmount_iWEAlLTH(CommonTestData.ACCOUNT_TYPE_IWEALTH.getEnumValue(),
						CommonTestData.ACCOUNT_NAME_HOME_IWEALTH.getEnumValue(), CommonTestData.CURRENCY.getEnumValue(),isSingleAccountHolder);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to verify Account Details On Home Page ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to verify Account Details On Home Page ", e);
		}
	}

	@Step("Verify Logout.")
	public void VerifyLogout(String Ratingmsg) throws Exception {
		try {
			homepage.VerifyWelcomeMessagesOnDashboardPage(CommonTestData.WELCOME.getEnumValue(),
					CommonTestData.DIGIBANK.getEnumValue(), CommonTestData.DBS_DIGIBANK.getEnumValue());
			
			homepage.ClickOnLogOutButton();
			
			if(homepage.ClickOnCloseButton())		
					homepage.ClickOnLogOutButton();
			
			
			ratingpage.verifyTapOnTheStarsToRate(Ratingmsg);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Execute Log Out  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Execute Log Out  ", e);
		}
	}



	@Step("Verifies Remittance Corridor")
	public void VerifyRemittanceCorridor(String appName) throws Exception {
		try {
			homepage.ClickOnPayAndTransferBtn();
			enterpasscode.EnterPasscodeAndDone();
			paytransfer.ClickOnOverseasModule();
			overseasmodule.verifyOverseasTransferPageHeader(CommonTestData.OVERSEAS_TRANSFER_PAGEHEADER.getEnumValue());
			overseasmodule.SelectOverseaPayee(CommonTestData.PAYEE_NAME_CORRIDOR.getEnumValue());
			
			overseasmodule.HandleUpdateOverseasPayee("CORRIDOR");
	
			if (appName.equals("DBS"))
				overseasmodule.SelectSourceOfFund(CommonTestData.SOURCE_ACCOUNT_NAME_CORRIDOR.getEnumValue());
			else if (appName.equals("iWEALTH"))
				overseasmodule.SelectSourceOfFund(CommonTestData.SOURCE_ACCOUNT_NAME_CORRIDOR_IWEALTH.getEnumValue());
			
			overseasmodule.VerifyOverseasTransferHeader(CommonTestData.OVERSEA_HEADER.getEnumValue());
			overseasmodule.pressEnterKeyAfterEnteringAmount(CommonTestData.CORRIDOR_AMOUNT.getEnumValue());
			overseasmodule.SelectAdditionalDetails(CommonTestData.EOTT_ACCOUNT_TYPE.getEnumValue(),
					CommonTestData.PURPOSE.getEnumValue(), CommonTestData.MOBILE_NUMBER.getEnumValue());
			overseasmodule.ClickOnNextButton();
			overseasmodule.verifyReviewTransferPageHeader(CommonTestData.REVIEW_TRANSFER.getEnumValue());
			overseasmodule.ClickOnTransferNowButton();
			overseasmodule.VerifiesTransferSubmittedMessage(CommonTestData.TRANSFER_SUBMITTED_MSG.getEnumValue());
			overseasmodule.ClickOnImageExpandBtnAndVerifiesReferenceNumberText();
			overseasmodule.ClickOnShareTransferDetailsButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Execute Remittance Corridor  ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Execute Remittance Corridor  ", e);
		}
	}

	@Step("Verifies Remittance eOTT")
	public void VerifyRemittanceEOTT(String appName) throws Exception {
		try {
			homepage.ClickOnPayAndTransferBtn();
			enterpasscode.EnterPasscodeAndDone();
			paytransfer.SelectAllTAB();
			overseasmodule.SelectEOTT();
			overseasmodule.HandleUpdateOverseasPayee("EOTT");
			
			if (appName.equals("DBS"))
				overseasmodule.SelectSourceOfFund(CommonTestData.SOURCE_ACCOUNT_NAME_CORRIDOR.getEnumValue());
			else if (appName.equals("iWEALTH"))
				overseasmodule.SelectSourceOfFund(CommonTestData.SOURCE_ACCOUNT_NAME_CORRIDOR_IWEALTH.getEnumValue());
			overseasmodule.VerifyOverseasTransferHeader(CommonTestData.OVERSEA_HEADER.getEnumValue());
			overseasmodule.pressEnterKeyAfterEnteringAmount(CommonTestData.eOTT_AMOUNT.getEnumValue());
			overseasmodule.SelectAdditionalDetails(CommonTestData.EOTT_ACCOUNT_TYPE.getEnumValue(),
					CommonTestData.PURPOSE.getEnumValue(), CommonTestData.MOBILE_NUMBER.getEnumValue());
			overseasmodule.ClickOnNextButton();
			overseasmodule.verifyReviewTransferPageHeader(CommonTestData.REVIEW_TRANSFER.getEnumValue());
			overseasmodule.ClickOnTransferNowButton();
			overseasmodule.VerifiesTransferSubmittedMessage(CommonTestData.TRANSFER_SUBMITTED_MSG.getEnumValue());
			overseasmodule.ClickOnImageExpandBtnAndVerifiesReferenceNumberText();
			overseasmodule.ClickOnShareTransferDetailsButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Execute Remittance EOTT  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Execute Remittance EOTT  ", e);
		}
	}

	@Step("Verifies Add payee DBSorPOSB.")
	public void VerifyAddPayeeDBSorPOSB() throws Exception {
		try {
			homepage.ClickOnPayAndTransferBtn();
			enterpasscode.EnterPasscodeAndDone();
			local.clickOnAddLocalRecipientBtn();
			local.verifyLocalTransferPayNowPageHeader(CommonTestData.LOCAL_TRANSFER_PayNow.getEnumValue());
			local.SelectBankAccount();
			local.verifyEnterRecipientDetailsPageHeader(CommonTestData.ENTER_RECIPIENT_DETAILS.getEnumValue());
			String ExpectedRecipientName = CommonTestData.PAYEEADD_DBSPOSB_RECIPIENT_NAME.getEnumValue();
			local.EnterRecipientDetails(ExpectedRecipientName, CommonTestData.PAYEEADD_DBSPOSB_BANK_NAME.getEnumValue(),
					CommonTestData.PAYEEADD_DBSPOSB_ACCOUNT_NUMBER.getEnumValue());
			local.ClickOnNextButton();
			local.verifyReviewRecipientDetailsPageHeader(CommonTestData.REVIEW_RECIPIENT_DETAILS.getEnumValue());
			local.ClickOnAddRecipientNowBtn();
			enterpasscode.EnterPasscodeAndDone();
			local.VerifyYouHaveAddedRecipientMessage();
			local.verifyValidationForPayeeAdd(ExpectedRecipientName, CommonTestData.PAYEEADD_DBSPOSB_BANK_NAME.getEnumValue(),
					CommonTestData.PAYEEADD_DBSPOSB_ACCOUNT_NUMBER.getEnumValue());

			// Leaving on Home Page After adding payee to DBS/POSB for next run.
			//local.ClickOnBackIcon();
			//paytransfer.ClickOnHomeButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Execute Add payee DBSorPOSB  ",	e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Execute Add payee DBSorPOSB  ", e);
		}
	}

	@Step("Verifies the Applying Debit Card and Verify the completion page details.")
	public void ApplyDebitCard(String appName) throws Exception {
		try {
			homepage.ClickOnMoreButton();
			enterpasscode.EnterPasscodeAndDone();
			more.ClickOnCardsModule();
			cards.SelectDebitCard();
			enterpasscode.EnterPasscodeAndDone();
			cards.selectDebitCardType(CommonTestData.DEBIT_CARD_NAME.getEnumValue());
			cards.FillingDetailsToApplyingDebitCard(appName);
			cards.ClickOnSendMeDBSPrmotionViaMailCheckbox();
			cards.ClickOnNextButton();
			cards.verifyReviewApplicationPageHeader();
			cards.ClickonApplyButton();
			cards.VerifySetCardPINPageHeader();
			cards.SetDebitCardPin(CommonTestData.CREATE_PIN.getEnumValue(), CommonTestData.CONFIRM_PIN.getEnumValue());
			cards.ClickOnSubmitButton();
			cards.VerifyApplicationSubmittedMessage(CommonTestData.APPLICATION_SUBMITTED.getEnumValue());
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Execute Apply Debit card  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Execute Apply Debit card  ", e);
		}
	}
	
	

	@Step("Verifies the Payee Add Bill Payment and after completion payment verifies the transfering amount.")
	public void PayeeAddBillPayment() throws Exception {
		try {
			homepage.ClickOnPayAndTransferBtn();
			enterpasscode.EnterPasscodeAndDone();
			paytransfer.ClickOnBillsModule();
			bills.ClickOnAddBillingOrganisation();
			bills.EnterBillingOrganisationDetails(CommonTestData.PAYEEADD_BILLPAYMENT_ACCOUNTNAME.getEnumValue(),
					CommonTestData.PAYEEADD_BILLPAYMENT_REFERENCENUMBER.getEnumValue());
			bills.ClickOnNextButton();
			bills.VerifyReviewRecipientDetailsPageHeader(CommonTestData.REVIEW_RECIPIENT_DETAILS.getEnumValue());
			bills.VerifyBillingOrganisationAndBillReferenceNumber(
					CommonTestData.PAYEEADD_BILLPAYMENT_ACCOUNTNAME.getEnumValue(),
					CommonTestData.PAYEEADD_BILLPAYMENT_REFERENCENUMBER.getEnumValue());
			bills.ClickOnAddRecipientNowBtn();
			enterpasscode.EnterPasscodeAndDone();
			bills.VerifyYouHaveAddedRecipientMessage();
			bills.VerifyBillingOrganisationAndBillReferenceNumber(
					CommonTestData.PAYEEADD_BILLPAYMENT_ACCOUNTNAME.getEnumValue(),
					CommonTestData.PAYEEADD_BILLPAYMENT_REFERENCENUMBER.getEnumValue());
			bills.ClickOnMakeAPayment();
			bills.VerifyPayToBillerPageHeader();
			bills.EnterAmount(CommonTestData.AMOUNTTO_TRANSFERFUND.getEnumValue());
			bills.ClickOnNextButton();
            bills.VerifyReviewPaymentPageHeader();
			bills.ClickOnPayNowButton();
			bills.VerifyDetailsAfterSubmitPayment();
			
			// Leaving On Home Page for Next case Run.
		//	bills.ClickOnBackIcon();
		//	paytransfer.ClickOnHomeButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION",
					" Failed to Execute Payee Add To Bill Payment ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Execute Payee Add to Bill Payment  ",
					e);
		}
	}
	

	@Step("Verifies the Open Account.")
	public void OpenAccount(String appName) throws Exception {
		try {
			homepage.ClickOnMoreButton();
			enterpasscode.EnterPasscodeAndDone();
			more.ClickOnDepositAccountModule();
			enterpasscode.EnterPasscodeAndDone();
			depositaccounts.verifyOpenAccountPageHeader(CommonTestData.OPEN_ACCOUNT.getEnumValue());
			depositaccounts.SelectOpenAccountOption();
			depositaccounts.verifyAccountBenefitsPageHeader(CommonTestData.ACCOUNT_BENIFITS.getEnumValue());
			depositaccounts.ClickOnopenAccountInStepButton();
			depositaccounts.verifyPageHeader(CommonTestData.OPEN_ACCOUNT.getEnumValue());
			depositaccounts.EnterMonthlySavingAmount();
			depositaccounts.SelectSourceOfFundsForSavings(appName);
			depositaccounts.ClickOnNextButton();
			depositaccounts.VerifyWarningMessageAndImportantNotes();
			depositaccounts.ClickOnIAcknowledgeButton();
			depositaccounts.verifyReviewApplicationPageHeader(CommonTestData.REVIEW_ACCOUNT_APPLICATION.getEnumValue());
			depositaccounts.ReviewOpenAccountApplication();
			depositaccounts.ClickOnOpenAccountNowButton();
			depositaccounts.VerifyDetailsAfterOpenAccount();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Exceute Open Account ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Exceute Open Account ", e);
		}
	}
	

	@Step("Verifies the Payee Add Local OtherBank and verifies 'YOU HAVE ADDED RECIPIENT MSG' .")
	public void PayeeAddLocalOtherBank() throws Exception {
		try {
			homepage.ClickOnPayAndTransferBtn();
			enterpasscode.EnterPasscodeAndDone();
			paytransfer.ClickOnLocalModule();
			local.clickOnAddLocalRecipientBtn();
			local.verifyLocalTransferPayNowPageHeader(CommonTestData.LOCAL_TRANSFER_PayNow.getEnumValue());
			local.SelectBankAccount();
			local.verifyEnterRecipientDetailsPageHeader(CommonTestData.ENTER_RECIPIENT_DETAILS.getEnumValue());
			String ExpectedRecipientName = CommonTestData.LOCAL_RECIPIENT_NAME.getEnumValue();
			String ExpectedAccountNumber = CommonTestData.LOCAL_RECIPIENT_ACCOUNT_NUMBER.getEnumValue();
			local.EnterRecipientDetails(ExpectedRecipientName, CommonTestData.LOCAL_RECIPIENT_BANK_NAME.getEnumValue(),
					ExpectedAccountNumber);
			local.ClickOnNextButton();
			local.verifyReviewRecipientDetailsPageHeader(CommonTestData.REVIEW_RECIPIENT_DETAILS.getEnumValue());
			local.ClickOnAddRecipientNowBtn();
			enterpasscode.EnterPasscodeAndDone();
			local.VerifyYouHaveAddedRecipientMessage();
			local.verifyValidationForPayeeAdd(ExpectedRecipientName, CommonTestData.LOCAL_RECIPIENT_BANK_NAME.getEnumValue(),
					ExpectedAccountNumber);

			// Leaving on Home Page After adding payee Local To Other Bank for next run.
			//local.ClickOnBackIcon();
			//paytransfer.ClickOnHomeButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Execute Payee Add Local Other Bank ",	e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Execute Payee Add Local Other Bank  ", e);
		}
	}

	@Step("Delete Payee To DBS/POSB.")
	public void DeletePayeeDBSPOSB(String ExpectedRecipientName) throws Exception {
		try {
			homepage.ClickOnPayAndTransferBtn();
			enterpasscode.EnterPasscodeAndDone();
			paytransfer.ClickOnLocalModule();
			deletepayee.DeletePayee(ExpectedRecipientName);
			homepage.ClickOnCloseButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("DELETEPAYEE_EXCEPTION",
					" Failed to Execute Delete Payee  For DBS/POSB.", e);
		} catch (Exception e) {
			obj_handleexception.throwException("DELETEPAYEE_EXCEPTION",
					" Failed to Execute Delete Payee For DBS/POSB. ", e);
		}
	}

	@Step("Delete Payee To Local To Other Bank.")
	public void DeletePayeeLocalToOtherBank(String ExpectedRecipientName) throws Exception {
		try {
			homepage.ClickOnPayAndTransferBtn();
			enterpasscode.EnterPasscodeAndDone();
			paytransfer.ClickOnLocalModule();
			deletepayee.DeletePayee(ExpectedRecipientName);
			homepage.ClickOnCloseButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("DELETEPAYEE_EXCEPTION",
					" Failed to Execute Delete Payee  For Local To Other Bank", e);

		} catch (Exception e) {

			obj_handleexception.throwException("DELETEPAYEE_EXCEPTION",
					" Failed to Execute Delete Payee Local To Other Bank ", e);
		}
	}

	@Step("Delete Payee To Remittance.")
	public void DeletePayeeRemittance(String ExpectedRecipientName) throws Exception {
		try {
			homepage.ClickOnPayAndTransferBtn();
			enterpasscode.EnterPasscodeAndDone();
			paytransfer.ClickOnOverseasModule();
			overseasmodule.verifyOverseasTransferPageHeader(CommonTestData.OVERSEAS_TRANSFER_PAGEHEADER.getEnumValue());
			deletepayee.DeletePayee(ExpectedRecipientName);
			//overseasmodule.ClickOnOverseasScreenClosingButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("DELETEPAYEE_EXCEPTION", " Failed to Execute Delete Payee Remittance ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("DELETEPAYEE_EXCEPTION", " Failed to Execute Delete Payee Remittance ", e);
		}
	}


	@Step("Delete Payee To Bill Payment.")
	public void DeletePayeeToBillPayment(String ExpectedRecipientName) throws Exception {
		try {
			homepage.ClickOnPayAndTransferBtn();
			enterpasscode.EnterPasscodeAndDone();
			paytransfer.ClickOnBillsModule();
			deletepayee.DeletePayee(ExpectedRecipientName);
			homepage.ClickOnCloseButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("DELETEPAYEE_EXCEPTION",
					" Failed to Execute Delete Payee Bill Payment ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("DELETEPAYEE_EXCEPTION", " Failed to Execute Delete Payee Bill Payment ",
					e);
		}
	}

	@Step("Verify Peek Balance.")
	public void VerifyPeekBalance(String appName,boolean isSingleAccountHolder, String AccountName) throws Exception {
		try {
			homepage.VerifyDepositAccountTypeOnDashboardPage();
			
			if (!isSingleAccountHolder) {
				clickOnElement(homepage.depositeAccountDropdown1());
				gestUtils.scrollUPtoObject("text", AccountName, null);
				String xpath1="//android.widget.TextView[@text='"+AccountName+"']";
				List<RemoteWebElement> list1 = driver.findElements(By.xpath(xpath1)); 
				if (list1.size() > 0)
					list1.get(0).click();
			}
			
			if (isElementVisible2(homepage.DepositsAccountName())) { 
				String DepositeAccountNameOnDashboard = homepage.getAndClickOnDepositeAccountNameFromDashboard();
				enterpasscode.EnterPasscodeAndDone();
				enterpasscode.EnterPasscodeAndDone();
				String ExpectedAvailableBalanceValue =null;
				String ExpectedTotalBalanceValue = null;

				if(appName.equals("DBS")) {
								ExpectedAvailableBalanceValue = homepage.getAvailableBalance(
										CommonTestData.AVAILABLE_BALANCE_TITLE.getEnumValue());
								 ExpectedTotalBalanceValue = homepage.getTotalBalance(CommonTestData.TOTAL_BALANCE_TITLE.getEnumValue());
							}
				else if(appName.equals("iWEALTH")) {
								ExpectedAvailableBalanceValue = homepage.getAvailableBalance(
										CommonTestData.AVAILABLE_BALANCE_TITLE.getEnumValue());
						        ExpectedTotalBalanceValue = homepage.getTotalBalance(CommonTestData.TOTAL_BALANCE_TITLE.getEnumValue());
							}
					 
				String ExpectedUserAccountName = homepage.GetUserAccountName(DepositeAccountNameOnDashboard);
				String ExpectedUserAccountNumber = homepage.GetUserAccountNumber();
				homepage.ClickOnToolBarBackIcon();

				homepage.ClickOnMoreButton();
				enterpasscode.EnterPasscodeAndDone();
				more.SelectPeekBalanceModule();
				peek.handleConfirmationMessage();
				peek.EnablePeekBalanceToggle();
				
				if(appName.equals("DBS")) {
					peek.SelectAccountToEnablePeekBalance(ExpectedUserAccountName);
					String SelectedAccountNameWithAccountNumber = ExpectedUserAccountName + " " + ExpectedUserAccountNumber;
					peek.verifySelectedAccountForPeekBalance(CommonTestData.ACCOUNT_FOR_PEEK_BALANCE.getEnumValue(),
							SelectedAccountNameWithAccountNumber);
					}else if(appName.equals("iWEALTH")) 
						peek.SelectAccountToEnablePeekBalance(CommonTestData.USER_ACCOUNT_NAME.getEnumValue());

				peek.ClickOnSaveButton();
				peek.ClickOnOkButtonInPersonalizeYourDevicePopup();
				peek.AcceptDigiBankAlert(CommonTestData.PEEK_BALANCE_DIGIALERT_MSG.getEnumValue());

				peek.ClickOnBackButtonImageView();
				
				more.ClickOnLogOutButton();
				
				ratingpage.verifyTapOnTheStarsToRate(CommonTestData.RATE_MESSAGE.getEnumValue());
				
				ratingpage.ClickOnCloseBtnToClosingTapToStarPage();
				preloginpage.VerifyPeekBalanceEnabilityOnLogInPage(CommonTestData.PEEK_BALANCE_SUBTITLE.getEnumValue());

				// TODO: Code Add for tap and hold on above element and get total amount balance
				preloginpage.TapAndHoldPeekBalance();

				// DeRegister/Disable Process to removing peek balance from login page for next
				// run.
				preloginpage.ClickOnLoginButton();
				// for handling peek balance login window
				loginpage.ClickOnNOTYouLink();
				loginpage.ClickOnDeregisterButtonInDigiAlertPopup(CommonTestData.PEEK_BALANCE_DEREGISTER_MESSAGE.getEnumValue());
				} else
				Asserts.assertFail("Account Name not showing on the Dashboard Page.");

		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Peek balance ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Peek balance  ", e);
		}
	}
	

	@Step("Verify Payee Add Remittance.")
	public void VerifyPayeeAddRemittance() throws Exception {
		try {
//			homepage.ClickOnPayAndTransferBtn();
//			enterpasscode.EnterPasscodeAndDone();
//			paytransfer.ClickOnOverseasModule();
			overseasmodule.verifyOverseasTransferPageHeader(CommonTestData.OVERSEAS_TRANSFER_PAGEHEADER.getEnumValue());
			overseasmodule.SelectAddRecipientNowButtonUnderOverseas();
			overseasmodule.SelectCountry(CommonTestData.COUNTRY_AUS.getEnumValue());
			overseasmodule.SelectCurrencyType(CommonTestData.CURRENCY_AUS.getEnumValue());
			overseasmodule.ClickOnNextButton();
			overseasmodule.EnterBankCode(CommonTestData.BANK_BCD_CODE.getEnumValue());
			overseasmodule.ClickOnNextButton();
			overseasmodule.ClickOnNextButton();
			overseasmodule.EnterAccountNumber(CommonTestData.ACCOUNT_NO.getEnumValue());
			overseasmodule.EnterFullName(CommonTestData.FULL_NAME.getEnumValue());
			gestUtils.scrollUPtoObject("text", "NEXT", null);
			overseasmodule.EnterAddress(CommonTestData.ADDRESS.getEnumValue());
			//backButton();
			pressKey(driver, Keys.ENTER);
			//gestUtils.scrollUPtoObject("text", "NEXT", null);
			overseasmodule.EnterCity(CommonTestData.CITY.getEnumValue());
			pressKey(driver, Keys.ENTER);
			//backButton();
		  //driver.hideKeyboard();
			//gestUtils.scrollUPtoObject("text", "NEXT", null);
			overseasmodule.ClickOnNextButton();
			overseasmodule.verifyReviewRecipientDetailsPageHeader(CommonTestData.REVIEW_RECIPIENT_LABEL.getEnumValue());
			overseasmodule.ClickOnAddRecipientNowBtn();
			enterpasscode.EnterPasscodeAndDone();
			overseasmodule.verifyYouHaveAddedMessage();
			overseasmodule.verifyReferenceFieldAndItsValue(CommonTestData.REFERENCE_NUMBER.getEnumValue());
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Execute Add payee Remittance  ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Execute Add payee Remittance  ", e);
		}
	}

	@Step("Verify topup Paylah.")
	public void VerifyTopupPaylah() throws Exception {
		try {
			homepage.ClickOnPayAndTransferBtn();
			enterpasscode.EnterPasscodeAndDone();
			paytransfer.ClickOnTopupPaylahModule();
			topUppaylah.ClickOnPaylah(CommonTestData.PAYLAH_LABEL.getEnumValue());
			topUppaylah.EnterCurrency(CommonTestData.AMOUNT_PAYLAH.getEnumValue());
			topUppaylah.ClickOnNextButton();
			topUppaylah.verifyTopUpReview(CommonTestData.TOPUP_REVIEW_LABEL.getEnumValue());
			topUppaylah.ClickOnTopUpNowButton();
			topUppaylah.ClickOnTopupLogOutButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Execute TopUp Paylah  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Execute TopUp Paylah  ", e);
		}
	}


	@Step("Change local fund transfer limit verification")
	public void ChangeLocalFundsTransferLimit() throws Exception {
		try {
			homepage.ClickOnMoreButton();
			enterpasscode.EnterPasscodeAndDone();
			more.SelectLocalTransferLimitModule(CommonTestData.LOCAL_TRANSFER_LIMIT_LABEL.getEnumValue());
			enterpasscode.EnterPasscodeAndDone();
			localtransferLimit.verifyLocalTransferLimitPageHeader(CommonTestData.LOCAL_TRANSFER_LIMIT_LABEL.getEnumValue());
			localtransferLimit.selectAccountTypeInLocalFundTransfer(CommonTestData.TO_OTHERBANK_LABEL.getEnumValue());
			enterpasscode.EnterPasscodeAndDone();
			localtransferLimit.verifyTransferToOtherPageHeader(CommonTestData.TRANSFER_TO_OTHERBANK_LABEL.getEnumValue());
			String amountSlected = localtransferLimit.handlingSetCurrentLimit(CommonTestData.SELECTED_LIMIT_50000.getEnumValue());
			localtransferLimit.ClickOnNextButton();
			localtransferLimit.verifyClickChangeDailyLimitNowButton();
			localtransferLimit.ClickOnBackToMoreButton();
			localtransferLimit.sendDataInCommonSearchBoxAndSelectFromDropDown(CommonTestData.LOCAL_TRANSFER_LIMIT_LABEL.getEnumValue(),
					CommonTestData.LOCAL_TRANSFER_LIMIT_LABEL.getEnumValue());
			enterpasscode.EnterPasscodeAndDone();
			localtransferLimit.verifyLocalTransferLimitPageHeader(CommonTestData.LOCAL_TRANSFER_LIMIT_LABEL.getEnumValue());
			localtransferLimit.selectAccountTypeInLocalFundTransfer(CommonTestData.TO_OTHERBANK_LABEL.getEnumValue());
			localtransferLimit.verifyDisplayAmountLocalTransferLimitChange(amountSlected);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION"," Failed to Exceute Change Local Funds Transfer Limit ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION"," Failed to Exceute Change Local Funds Transfer Limit ", e);
		}
	}

	@Step("Verifies FundTransfer Other DBS/POSB")
	public void FundTransferDBSPOSB(String appname) throws Exception {
		try {
			homepage.ClickOnPayAndTransferBtn();
			enterpasscode.EnterPasscodeAndDone();
			paytransfer.SelectAllTAB();
			paytransfer.ClickOnLocalRecipient();
			paytransfer.SelectToAccountFromLocalRecipient(CommonTestData.LOCAL_RECIPIENT_LIST_SELECTED_ACCOUNTNAME.getEnumValue());
			
			String ExpectedFromBankName = null;
			if (appname.equals("DBS")) {
				ExpectedFromBankName = CommonTestData.SOURCE_ACCOUNT_NAME.getEnumValue();
				local.SelectFundSourceAccount(ExpectedFromBankName);
			} else if (appname.equals("iWEALTH")) {
				ExpectedFromBankName = CommonTestData.SOURCE_ACCOUNT_NAME_iWEALTH.getEnumValue();
				local.SelectFundSourceAccount(ExpectedFromBankName);
			}
			
			local.enterAmountAndVerifySgdCurrency(CommonTestData.AMOUNT_FUNDTRANSFER.getEnumValue());
			local.ClickOnNextButtonToInitiateFundTransfer();
			local.verifyReviewTransferPageHeader(CommonTestData.REVIEW_TRANSFER_LABEL.getEnumValue()); //DBSappObject.PageHeader());
			local.ClickOnTransferNowBtn();
			local.verifyTransferredMessage(CommonTestData.TRANSFER_TITLE.getEnumValue());
			local.ClickOnExpandbutton();
			local.clickOnLogOutButton();
			ratingpage.verifyTapOnTheStarsToRate(CommonTestData.RATE_MESSAGE.getEnumValue());
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to verify fund transfer other DBS_POSB  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to verify fund transfer other DBS_POSB  ", e);
		}
	}

	@Step("Verify Fund Transfer For Own Account.")
	public void VerifyFundTransfer_OwnAccount() throws Exception {
		try {
			homepage.ClickOnPayAndTransferBtn();
			enterpasscode.EnterPasscodeAndDone();
			paytransfer.SelectAllTAB();
			paytransfer.ClickOnYourDBSPOSBAccounts();
			paytransfer.SelectToAccountFromYourDBSPOSBAccountlist(CommonTestData.FUNDTRANSFER_TO_OWN_ACCOUNT_NAME.getEnumValue());
			ownAccount.verifyTransferToYourAccountPageHeader(CommonTestData.TRANSFER_TO_YOUR_ACCOUNT.getEnumValue());
			String ExpectedFromAccountName = CommonTestData.FUNDTRANSFER_FROM_OWN_ACCOUNT_NAME.getEnumValue();
			ownAccount.SelectFundSourceAccount(ExpectedFromAccountName);
			ownAccount.EnterAmount(CommonTestData.AMOUNTTO_TRANSFERFUND.getEnumValue());
			ownAccount.ClickOnNextButton();
			ownAccount.verifyReviewTransferPageHeader(CommonTestData.REVIEW_TRANSFER.getEnumValue());
			ownAccount.ClickOnTransferNowBtn();
			ownAccount.VerifiesTransferSubmittedMsg(CommonTestData.TRANSFERRED.getEnumValue());
			String ExpectedToAccountNumber = CommonTestData.FUNDTRANSFER_TO_OWN_ACCOUNT_NUMBER.getEnumValue()
					+ "	SGD";
			String ExpectedToAccountName = CommonTestData.FUNDTRANSFER_TO_OWN_ACCOUNT_NAME.getEnumValue();
			String ExpectedFromAccountNumber = CommonTestData.FUNDTRANSFER_FROM_OWN_ACCOUNT_NUMBER.getEnumValue()
					+ "	SGD";
			ownAccount.VerifyAccountDetailsAfterFundTransferToOwnAccount(ExpectedToAccountNumber, ExpectedToAccountName,
					ExpectedFromAccountNumber, ExpectedFromAccountName);

			// Leave On Home Page for next case run.
			ownAccount.ClickOnBackToHomeButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to verify Fund transfer to own account  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to verify Fund transfer to own account ", e);
		}
	}

	@Step("Verify Fund Transfer For Other Bank Non Fast transfer when future date selected.")
	public void FundsTransfer_OtherBank_NonFASTFuture(String appname) throws Exception {
		try {
			homepage.ClickOnPayAndTransferBtn();
			enterpasscode.EnterPasscodeAndDone();
			paytransfer.SelectAllTAB();
			String ExpectedToBankNameWithAccountNo = CommonTestData.FUNDTRANSFER_NONFAST_TO_ACCOUNTNUMBER_WITHBANK
					.getEnumValue();
			paytransfer.ClickOnLocalRecipient();
			paytransfer.SelectToAccountFromLocalRecipient(ExpectedToBankNameWithAccountNo);
			local.verifyTransferToOtherBankPageHeader(CommonTestData.TRANSFER_TO_OTHERBANK_LABEL_LABEL.getEnumValue());
			local.DisableToTransferViaFastToggle(appname);
			//local.EnterCommentForRecipientInEditField(CommonTestData.COMMENT_NONFAST_TRANSFER.getEnumValue());
			// Add Scroll to select fund source on the top of the page after disabling the
			// fast toggle.
			gestUtils.scrollDOWNtoObject(null, null, null);
			
			String ExpectedFromBankName = null;
			if (appname.equals("DBS")) {
				ExpectedFromBankName = CommonTestData.FUNDTRANSFER_NONFAST_FROM_ACCOUNT_NAME.getEnumValue();
				local.SelectFundSourceAccount(ExpectedFromBankName);
			} else if (appname.equals("iWEALTH")) {
				ExpectedFromBankName = CommonTestData.FUNDTRANSFER_NONFAST_FROM_ACCOUNT_NAME_iWEALTH.getEnumValue();
				local.SelectFundSourceAccount(ExpectedFromBankName);
			}
			
			local.SelectFutureDate();
			local.EnterAmount(CommonTestData.AMOUNTTO_TRANSFERFUND.getEnumValue());
			
			gestUtils.scrollUPtoObject("text", "NEXT", null);
			local.EnterCommentForRecipientInEditField(CommonTestData.COMMENT_NONFAST_TRANSFER.getEnumValue());
			
			
			local.ClickOnNextButtonToInitiateFundTransfer();
			local.verifyReviewTransferPageHeader(CommonTestData.REVIEW_TRANSFER.getEnumValue()); 
			local.VerifyNonFastServiceOnReviewPage();
			local.ClickOnTransferNowBtn();
			local.VerifiesTransferSubmittedMessage(CommonTestData.TRANSFER_SUBMITTED_MSG.getEnumValue());

			String ExpectedToRecipientName = CommonTestData.FUNDTRANSFER_NONFAST_TO_RECIPIENT_NAME.getEnumValue();
			local.VerifyElementsOnTransferSubmittedPage(ExpectedFromBankName, ExpectedToBankNameWithAccountNo,
					ExpectedToRecipientName);
			local.ClickOnExpandbutton();
			local.ClickOnBackIcon();
			
			//verify Transaction History After Fund Transfer
			homepage.ClickOnMoreButton();
			enterpasscode.EnterPasscodeAndDone();
			more.ClickOnTransactionHistory();
			enterpasscode.EnterPasscodeAndDone();
			transactionhistory.verifyTransactionHistoryPageHeader(CommonTestData.TRANSCETION_HISTORY_LABEL.getEnumValue());
			transactionhistory.SelectThreeMonths();
			transactionhistory.ClickOnDepositAccountAndSelectFromAccount(ExpectedFromBankName);
			transactionhistory.verifyTransactionHistoryPageHeader(CommonTestData.TRANSCETION_HISTORY_LABEL.getEnumValue());
			transactionhistory.ClickOnShowButton();
			enterpasscode.EnterPasscodeAndDone();
			transactionhistory.AccountNameToCheckTransactionHistory(ExpectedFromBankName);
			transactionhistory.VerifyTransactionHistoryDataForThreeMonths();
		//	transactionhistory.BackToHomeFromTransactionHistory();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION"," Failed to verify fund transfer other bank NON-FAST FUTURE  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION","Failed to verify fund transfer other bank NON-FAST FUTURE   ", e);
		}

	}

	@Step("Verify Fund Transfer For Other Bank Fast transfer when future date selected.")
	public void FundsTransfer_OtherBank_FASTFuture(String appname) throws Exception {
		try {
			homepage.ClickOnPayAndTransferBtn();
			enterpasscode.EnterPasscodeAndDone();
			paytransfer.SelectAllTAB();
			String ExpectedToBankNameWithAccountNo = CommonTestData.FUNDTRANSFER_NONFAST_TO_ACCOUNTNUMBER_WITHBANK
					.getEnumValue();
			paytransfer.ClickOnLocalRecipient();
			paytransfer.SelectToAccountFromLocalRecipient(ExpectedToBankNameWithAccountNo);
			local.verifyTransferToOtherBankPageHeader(CommonTestData.TRANSFER_TO_OTHERBANK_LABEL_LABEL.getEnumValue());

			String ExpectedFromBankName = null;
			if (appname.equals("DBS")) {
				ExpectedFromBankName = CommonTestData.FUNDTRANSFER_NONFAST_FROM_ACCOUNT_NAME.getEnumValue();
				local.SelectFundSourceAccount(ExpectedFromBankName);
			} else if (appname.equals("iWEALTH")) {
				ExpectedFromBankName = CommonTestData.FUNDTRANSFER_NONFAST_FROM_ACCOUNT_NAME_iWEALTH.getEnumValue();
				local.SelectFundSourceAccount(ExpectedFromBankName);
			}

			local.SelectFutureDate();
			local.EnterAmount(CommonTestData.AMOUNTTO_TRANSFERFUND.getEnumValue());
			local.EnterCommentForRecipientInEditField(CommonTestData.COMMENT_FAST_TRANSFER.getEnumValue());
			pressKey(driver, Keys.ENTER);
			local.ClickOnNextButtonToInitiateFundTransfer();
			local.verifyReviewTransferPageHeader(CommonTestData.REVIEW_TRANSFER.getEnumValue()); 
			local.VerifyFastServiceInReview();
			local.ClickOnTransferNowBtn();
			local.VerifiesTransferSubmittedMessage(CommonTestData.TRANSFER_SUBMITTED_MSG.getEnumValue());

			String ExpectedToRecipientName = CommonTestData.FUNDTRANSFER_NONFAST_TO_RECIPIENT_NAME.getEnumValue();
			local.VerifyElementsOnTransferSubmittedPage(ExpectedFromBankName, ExpectedToBankNameWithAccountNo,
					ExpectedToRecipientName);

			local.ClickOnExpandbutton();
			local.ClickOnBackIcon();
			
			//verify Transaction History After Fund Transfer
			homepage.ClickOnMoreButton();
			enterpasscode.EnterPasscodeAndDone();
			more.ClickOnTransactionHistory();
			enterpasscode.EnterPasscodeAndDone();
			transactionhistory.verifyTransactionHistoryPageHeader(CommonTestData.TRANSCETION_HISTORY_LABEL.getEnumValue());
			transactionhistory.SelectThreeMonths();
			transactionhistory.ClickOnDepositAccountAndSelectFromAccount(ExpectedFromBankName);
			transactionhistory.verifyTransactionHistoryPageHeader(CommonTestData.TRANSCETION_HISTORY_LABEL.getEnumValue());
			transactionhistory.ClickOnShowButton();
			enterpasscode.EnterPasscodeAndDone();
			transactionhistory.AccountNameToCheckTransactionHistory(ExpectedFromBankName);
			transactionhistory.VerifyTransactionHistoryDataForThreeMonths();
			transactionhistory.BackToHomeFromTransactionHistory();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION"," Failed to verify fund transfer other bank FAST FUTURE  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION","Failed to verify fund transfer other bank FAST FUTURE   ", e);
		}
	}

	@Step("Verify Fund Transfer For Other Bank Non Fast transfer.")
	public void FundsTransfer_OtherBank_NonFAST(String appname) throws Exception {
		try {
			homepage.ClickOnPayAndTransferBtn();
			enterpasscode.EnterPasscodeAndDone();
			paytransfer.SelectAllTAB();
			String ExpectedToBankNameWithAccountNo = CommonTestData.FUNDTRANSFER_NONFAST_TO_ACCOUNTNUMBER_WITHBANK.getEnumValue();
			paytransfer.ClickOnLocalRecipient();
			paytransfer.SelectToAccountFromLocalRecipient(ExpectedToBankNameWithAccountNo);
			local.verifyTransferToOtherBankPageHeader(CommonTestData.TRANSFER_TO_OTHERBANK_LABEL_LABEL.getEnumValue());
			local.DisableToTransferViaFastToggle(appname);
			//local.EnterCommentForRecipientInEditField(CommonTestData.COMMENT_NONFAST_TRANSFER.getEnumValue());
			// Add Scroll to select fund source on the top of the page after disabling the
			// fast toggle.
			gestUtils.scrollDOWNtoObject(null, null, null);
			String ExpectedFromBankName = null;
			if (appname.equals("DBS")) {
				ExpectedFromBankName = CommonTestData.FUNDTRANSFER_NONFAST_FROM_ACCOUNT_NAME.getEnumValue();
				local.SelectFundSourceAccount(ExpectedFromBankName);
			} else if (appname.equals("iWEALTH")) {
				ExpectedFromBankName = CommonTestData.FUNDTRANSFER_NONFAST_FROM_ACCOUNT_NAME_iWEALTH.getEnumValue();
				local.SelectFundSourceAccount(ExpectedFromBankName);
			}
			local.VerifyImmediateText(CommonTestData.IMMEDIATE_TEXT.getEnumValue());
			local.EnterAmount(CommonTestData.AMOUNTTO_TRANSFERFUND.getEnumValue());
			
			gestUtils.scrollUPtoObject("text", "NEXT", null);
			local.EnterCommentForRecipientInEditField(CommonTestData.COMMENT_NONFAST_TRANSFER.getEnumValue());
			
			local.ClickOnNextButtonToInitiateFundTransfer();
			local.verifyReviewTransferPageHeader(CommonTestData.REVIEW_TRANSFER.getEnumValue()); 
			local.VerifyNonFastServiceOnReviewPage();
			local.ClickOnTransferNowBtn();
			local.VerifiesTransferSubmittedMessage(CommonTestData.TRANSFER_SUBMITTED_MSG.getEnumValue());

			String ExpectedToRecipientName = CommonTestData.FUNDTRANSFER_NONFAST_TO_RECIPIENT_NAME.getEnumValue();
			local.VerifyElementsOnTransferSubmittedPage(ExpectedFromBankName, ExpectedToBankNameWithAccountNo,
					ExpectedToRecipientName);

			local.ClickOnExpandbutton();
			local.ClickOnBackIcon();
			
			//verify Transaction History After Fund Transfer
			homepage.ClickOnMoreButton();
			enterpasscode.EnterPasscodeAndDone();
			more.ClickOnTransactionHistory();
			enterpasscode.EnterPasscodeAndDone();
			transactionhistory.verifyTransactionHistoryPageHeader(CommonTestData.TRANSCETION_HISTORY_LABEL.getEnumValue());
			transactionhistory.SelectThreeMonths();
			transactionhistory.ClickOnDepositAccountAndSelectFromAccount(ExpectedFromBankName);
			transactionhistory.verifyTransactionHistoryPageHeader(CommonTestData.TRANSCETION_HISTORY_LABEL.getEnumValue());
			transactionhistory.ClickOnShowButton();
			enterpasscode.EnterPasscodeAndDone();
			transactionhistory.AccountNameToCheckTransactionHistory(ExpectedFromBankName);
			transactionhistory.VerifyTransactionHistoryDataForThreeMonths();
			transactionhistory.BackToHomeFromTransactionHistory();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION"," Failed to verify fund transfer other bank NON-FAST  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION","Failed to verify fund transfer other bank NON-FAST   ", e);
		}
	}
	

	@Step("Verify Fund Transfer For Other Bank Fast transfer.")
	public void FundsTransfer_OtherBank_FAST(String appname) throws Exception {
		try {
			homepage.ClickOnPayAndTransferBtn();
			enterpasscode.EnterPasscodeAndDone();
			paytransfer.SelectAllTAB();
			String ExpectedToBankNameWithAccountNo = CommonTestData.FUNDTRANSFER_NONFAST_TO_ACCOUNTNUMBER_WITHBANK.getEnumValue();
			paytransfer.ClickOnLocalRecipient();
			paytransfer.SelectToAccountFromLocalRecipient(ExpectedToBankNameWithAccountNo);
			local.verifyTransferToOtherBankPageHeader(CommonTestData.TRANSFER_TO_OTHERBANK_LABEL_LABEL.getEnumValue());
			String ExpectedFromBankName = null;
			if (appname.equals("DBS")) {
				ExpectedFromBankName = CommonTestData.FUNDTRANSFER_NONFAST_FROM_ACCOUNT_NAME.getEnumValue();
				local.SelectFundSourceAccount(ExpectedFromBankName);
			} else if (appname.equals("iWEALTH")) {
				ExpectedFromBankName = CommonTestData.FUNDTRANSFER_NONFAST_FROM_ACCOUNT_NAME_iWEALTH.getEnumValue();
				local.SelectFundSourceAccount(ExpectedFromBankName);
			}
			local.VerifyImmediateText(CommonTestData.IMMEDIATE_TEXT.getEnumValue());
			local.EnterAmount(CommonTestData.AMOUNTTO_TRANSFERFUND.getEnumValue());
			local.EnterCommentForRecipientInEditField(CommonTestData.COMMENT_FAST_TRANSFER.getEnumValue());
			pressKey(driver, Keys.ENTER);
			local.ClickOnNextButtonToInitiateFundTransfer();
			local.verifyReviewTransferPageHeader(CommonTestData.REVIEW_TRANSFER.getEnumValue()); 
			local.VerifyFastServiceInReview();
			local.ClickOnTransferNowBtn();
			local.VerifiesTransferSubmittedMessage(CommonTestData.TRANSFER_SUBMITTED_MSG.getEnumValue());
			String ExpectedToRecipientName = CommonTestData.FUNDTRANSFER_NONFAST_TO_RECIPIENT_NAME.getEnumValue();
			local.VerifyElementsOnTransferSubmittedPage(ExpectedFromBankName, ExpectedToBankNameWithAccountNo,
					ExpectedToRecipientName);
			local.ClickOnExpandbutton();
			local.ClickOnBackIcon();
			
			//verify Transaction History After Fund Transfer
			homepage.ClickOnMoreButton();
			enterpasscode.EnterPasscodeAndDone();
			more.ClickOnTransactionHistory();
			enterpasscode.EnterPasscodeAndDone();
			transactionhistory.verifyTransactionHistoryPageHeader(CommonTestData.TRANSCETION_HISTORY_LABEL.getEnumValue());
			transactionhistory.SelectThreeMonths();
			transactionhistory.ClickOnDepositAccountAndSelectFromAccount(ExpectedFromBankName);
			transactionhistory.verifyTransactionHistoryPageHeader(CommonTestData.TRANSCETION_HISTORY_LABEL.getEnumValue());
			transactionhistory.ClickOnShowButton();
			enterpasscode.EnterPasscodeAndDone();
			transactionhistory.AccountNameToCheckTransactionHistory(ExpectedFromBankName);
			transactionhistory.VerifyTransactionHistoryDataForThreeMonths();
			transactionhistory.BackToHomeFromTransactionHistory();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION"," Failed to verify fund transfer other bank FAST  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", "Failed to verify fund transfer other bank FAST   ", e);
		}
	}

	@Step("Verify Transaction History.")
	public void verifyTransactionHistory(String appName) throws Exception {
		try {
			homepage.ClickOnMoreButton();
			enterpasscode.EnterPasscodeAndDone();
			more.ClickOnTransactionHistory();
			enterpasscode.EnterPasscodeAndDone();
			transactionhistory.verifyTransactionHistoryPageHeader(CommonTestData.TRANSCETION_HISTORY_LABEL.getEnumValue());
			transactionhistory.SelectThreeMonths();
			
			if (appName.equals("DBS"))
				transactionhistory
						.ClickOnDepositAccountAndSelectFromAccount(CommonTestData.ACCOUNT_NAME.getEnumValue());
			else if (appName.equals("iWEALTH"))
				transactionhistory
						.ClickOnDepositAccountAndSelectFromAccount(CommonTestData.ACCOUNT_NAME_IWEALTH.getEnumValue());
			
			transactionhistory.verifyTransactionHistoryPageHeader(CommonTestData.TRANSCETION_HISTORY_LABEL.getEnumValue());
			transactionhistory.ClickOnShowButton();
			enterpasscode.EnterPasscodeAndDone();
			
			if (appName.equals("DBS"))
				transactionhistory.AccountNameToCheckTransactionHistory(CommonTestData.STATEMENT_TITLE.getEnumValue());
			else if (appName.equals("iWEALTH"))
				transactionhistory.AccountNameToCheckTransactionHistory(CommonTestData.ACCOUNT_NAME_IWEALTH.getEnumValue());
			
			transactionhistory.VerifyTransactionHistoryDataForThreeMonths();
			transactionhistory.BackToHomeFromTransactionHistory();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to verify transaction history ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to verify transaction history ", e);
		}
	}
	
	@Step("Update Personal Details")
	public void UpdatePersonalDetails(String appName) throws Exception {
		try {
			homepage.ClickOnMoreButton();
			enterpasscode.EnterPasscodeAndDone();
			more.SelectUpdateContactDetails();
			update.verifyUpdateContactDetailsPageHeader(CommonTestData.UPDATE_CONTACT_DETAILS_PAGEHEADER.getEnumValue());
			update.VerifyBackButtonImageView();
			update.VerifyPersonalAndContactDetails();
			update.VerifyMailingAddress();
			update.SelectPersonalContactDetails();
			enterpasscode.EnterPasscodeAndDone();
			update.verifyPersonalContactDetailsPageHeader();
			update.VerifyPersonalDetailsPage(appName);
			update.ClickOnCheckboxes();
			update.verifyTermsAndConditionsMessage(CommonTestData.TERMS_AND_CONDITIOINS_MESSAGE.getEnumValue(), appName);
			update.ClickOnNextButton();
			update.ClickOnConfirmButton();
			enterpasscode.EnterPasscodeAndDone();
			update.verifySuccessfullyUpdatedMessage(appName);

			// Verify Final Result after go through on Personal Details Page.
			update.ClickOnBackToMoreServicesBtn();
			more.SelectUpdateContactDetails();
			update.verifyUpdateContactDetailsPageHeader(CommonTestData.UPDATE_CONTACT_DETAILS_PAGEHEADER.getEnumValue());
			update.VerifyBackButtonImageView();
			update.VerifyPersonalAndContactDetails();
			update.VerifyMailingAddress();
			update.SelectPersonalContactDetails();
			enterpasscode.EnterPasscodeAndDone();
		    update.verifyPersonalContactDetailsPageHeader();
		    update.VerifyPersonalDetailsPage(appName);
			update.VerifyLastUpdatedDateOfCheckboxes();

			// Leave On Home Page for next case run.
		//	update.ClickOnBackButton();
			//update.ClickOnBackButton();
		//	more.ClickOnHomeButton();

		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to update personal details  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", "  Failed to update personal details  ", e);
		}
	}

	@Step("Verify Credit Card Temperary Limit Increase")
	public void CreditCardTempLimitIncrease() throws Exception {
		try {
			homepage.ClickOnMoreButton();
			enterpasscode.EnterPasscodeAndDone();
			more.SelectTemporaryCreditLimitIncreaseModule(CommonTestData.TEMP_LIMIT_INCREASE.getEnumValue());
			enterpasscode.EnterPasscodeAndDone();
			temp.verifyTempLimitIncreasePageHeader(CommonTestData.TEMP_LIMIT_INCREASE_TITLE.getEnumValue());
			temp.EnterAmount(CommonTestData.CREDITCARD_LIMITINCREASE_AMOUNT.getEnumValue()); 
			temp.SelectPurpose(CommonTestData.CREDITCARD_LIMITINCREASE_PURPOSE.getEnumValue());
			temp.SetDuration();
			temp.ClickOnNextButton();
			temp.verifyReviewApplicationPageHeader(CommonTestData.REVIEW_APPLICATION_CREDITLIMIT_TITLE.getEnumValue());
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Execute Credit Card Temp Limit Increase ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION"," Failed to Execute Credit Card Temp Limit Increase ", e);
		}
	}

	@Step("Verify Fund Transfer Pay Credit Card.")
	public void FundsTransfer_PayCreditCard() throws Exception {
		try {
			homepage.ClickOnPayAndTransferBtn();
			enterpasscode.EnterPasscodeAndDone();
			paytransfer.SelectAllTAB();
			paytransfer.ClickOnCreditCard();
			String ExpectedToBankNameWithAccountNo = CommonTestData.FUNDTRANSFER_CREDITCARD_TO_ACCOUNTNUMBER_WITHBANK
					.getEnumValue();
			paytransfer.SelectToAccountFromCreditCardList(ExpectedToBankNameWithAccountNo);
			creditcard.verifyCreditCardPageHeader(CommonTestData.CREDIT_CARD_PAGEHEADER.getEnumValue());
			creditcard.EnterAmount(CommonTestData.AMOUNTTO_TRANSFERFUND.getEnumValue());
			String ExpectedFromBankName = CommonTestData.FUNDTRANSFER_CREDITCARD_FROM_ACCOUNT_NAME.getEnumValue();
			creditcard.SelectFundSourceAccount(ExpectedFromBankName);
			creditcard.VerifyImmediateText(CommonTestData.IMMEDIATE_TEXT.getEnumValue());
			creditcard.ClickOnNextButton();
			creditcard.verifyReviewPaymentPageHeader(CommonTestData.REVIEW_PAYMENT_PAGEHEADER.getEnumValue());
			creditcard.ClickOnPayNowButton();
			creditcard.VerifyDetailsAfterSubmitPayment();
			creditcard.ClickOnExpandbutton();

			String ExpectedFromAccountNumber = CommonTestData.FUNDTRANSFER_CREDITCARD_FROM_ACCOUNT_NUMBER
					.getEnumValue();
			String ExpectedToAccountNumber = CommonTestData.FUNDTRANSFER_CREDITCARD_TO_ACCOUNTNUMBER.getEnumValue();
			String ExpectedToCreditCardName = CommonTestData.FUNDTRANSFER_TOCREDITCARD_NAME.getEnumValue();

			creditcard.VerifySomeDetailsAfterCreditCardFundTransfer(ExpectedFromBankName, ExpectedFromAccountNumber,
					ExpectedToAccountNumber, ExpectedToCreditCardName);

			// Leaving On Home Page for Next case Run.
			//creditcard.ClickOnBackIcon();
			//paytransfer.ClickOnHomeButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to fund transfer pay credit card  ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to fund transfer pay credit card    ", e);
		}
	}

	@Step("Verify Fund Transfer Bill Payment.")
	public void FundsTransfer_BillPayment() throws Exception {
		try {
			homepage.ClickOnPayAndTransferBtn();
			enterpasscode.EnterPasscodeAndDone();
			paytransfer.SelectAllTAB();
			paytransfer.ClickOnBillingOrganisation();
			String ExpectedToBankNameWithAccountNo = CommonTestData.FUNDTRANSFER_BillPayment_TO_ACCOUNTNUMBER_WITHBANK
					.getEnumValue();
			paytransfer.SelectToAccountFromBillingOrganisationList(ExpectedToBankNameWithAccountNo);
			bills.VerifyPayToBillerPageHeader();
			bills.EnterAmount(CommonTestData.AMOUNTTO_TRANSFERFUND.getEnumValue());
			bills.VerifyImmediateText(CommonTestData.IMMEDIATE_TEXT.getEnumValue());
			bills.ClickOnNextButton();
            bills.VerifyReviewPaymentPageHeader();
			bills.ClickOnPayNowButton();
			bills.VerifyDetailsAfterSubmitPayment();

			// Leaving On Home Page for Next case Run.
		//	bills.ClickOnBackIcon();
			//paytransfer.ClickOnHomeButton();

		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION",
					" Failed to verify Fund transfer bill payment  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to verify Fund transfer bill payment  ",
					e);
		}
	}

	public void verifyDigibankAlert() throws Exception {
		String alertMessage = null;
		try {
			wait.ImplicitlyWait(5);
			
			if (isElementVisible2(launchpage.Authenticating_Bar()) || isElementVisible2(launchpage.progress_bar())
					|| isElementVisible2(launchpage.progress_bar_imageview()))
				alertMessage = "Wait Duration Limit exceeded :: Application Unable to load Page";
			else if (isElementVisible2(launchpage.AlertTitle()))
				alertMessage = launchpage.AlertTitle().getText() + ": " + launchpage.AlertBodyMessage().getText();
			else if (isElementVisible2(launchpage.DigitalTokenUnderMaintenanceMessageHeader()))
				alertMessage = launchpage.DigitalTokenUnderMaintenanceMessageHeader().getText() + ": "
						+ launchpage.DigitalTokenUnderMaintenanceMessage().getText();
			else if (isElementVisible2(launchpage.DigibankAlertHeaderElement()) && isElementVisible2(launchpage.ErrorMessgeElement()))
				alertMessage = launchpage.DigibankAlertHeaderElement().getText() + ": "
						+ launchpage.ErrorMessgeElement().getText();
			else if (androidAlert.isAlertPresent())
				alertMessage = this.driver.switchTo().alert().getText();
			else if (isElementVisible2(launchpage.quitBtn()))
				alertMessage = "Application Crash Issue";
			
			if (alertMessage != null) {
				System.out.println("alertMessage :: " + alertMessage);
				Asserts.assertFail(alertMessage);
			}
			
			wait.ImplicitlyWait(15);
		} catch (Exception e) {
			obj_handleexception.throwException("DIGIBANK_ALERT",
					" Failed to proceed because of DIGI BANK ALERT " + alertMessage, e);
		}
	}
	
	public String GenerateRandomRecipientName() {
		// create a string of all characters
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		// create random string builder
		StringBuilder sb = new StringBuilder();

		// create an object of Random class
		Random random = new Random();

		// specify length of random string
		int length = 2;

		for (int i = 0; i < length; i++) {

			// generate random index number
			int index = random.nextInt(alphabet.length());

			// get character specified by index
			// from the string
			char randomChar = alphabet.charAt(index);

			// append the character to string builder
			sb.append(randomChar);
		}
		String randomString = sb.toString();
		System.out.println("Random String is: " + randomString);
		return randomString;
	}

	public int GenerateRandomInt() {
		// create instance of Random class
		Random rand = new Random();
		// Generate random integers in range 0 to 99
		int rand_int1 = rand.nextInt(100);
		return rand_int1;
	}
	
	@Step("Verify Pay Now NRIC.")
	public void PayNowNRIC() throws Exception {
		try {
			homepage.ClickOnPayAndTransferBtn();
			enterpasscode.EnterPasscodeAndDone();
            paytransfer.ClickOnPayNowModule();
            paynow.handlingTransferToThailandWithPromptPayAlert(CommonTestData.PROMPT_PAY_MESSAGE.getEnumValue());
            paynow.SelectPayNowToNRIC_FIN();
            paynow.EnterNRIC_FIN_Number();
            paynow.ClickOnNextButton();
            paynow.EnterAmount(CommonTestData.AMOUNTTO_TRANSFERFUND.getEnumValue());
            paynow.EnterCommentForRecipientInEditField(CommonTestData.PAYNOW_NRIC_FIN.getEnumValue());
            paynow.ClickOnNextButton();
            paynow.verifyReviewTransferPageHeader(CommonTestData.REVIEW_TRANSFER.getEnumValue());
            paynow.ClickOnTransferNowButton();
            paynow.VerifiesTransferSubmittedMsg(CommonTestData.TRANSFERRED.getEnumValue());
            paynow.VerifiesTransferredAmount();
            paynow.VerifyBackButton();
            paynow.VerifyShareTransferDetailsButton();
            paynow.VerifyLogOutButton();
            
            //Leave Page On home Page For next case run.
          //  paynow.ClickOnBackButton();
          //  paytransfer.ClickOnHomeButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to verify Pay Now NRIC ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Pay Now NRIC ", e);
		}
	}
	
	@Step("Verify Pay Now UEN.")
	public void PayNowUEN() throws Exception {
		try {
			homepage.ClickOnPayAndTransferBtn();
			enterpasscode.EnterPasscodeAndDone();
			paytransfer.ClickOnPayNowModule();
			paynow.handlingTransferToThailandWithPromptPayAlert(CommonTestData.PROMPT_PAY_MESSAGE.getEnumValue());
			paynow.SelectPayNowToUEN();
			paynow.EnterUEN_Number();
			pressKey(driver, Keys.ENTER); 
			paynow.VerifiesEntityNameTitleVisibility();
			paynow.ClickOnNextButton();
			paynow.ClickOnNextButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to verify Pay Now UEN ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Pay Now UEN ", e);
		}
	}
	
	@Step("Verify Pay Now VPA.")
	public void PayNowVPA() throws Exception {
		try {
			homepage.ClickOnPayAndTransferBtn();
			enterpasscode.EnterPasscodeAndDone();
			paytransfer.ClickOnPayNowModule();
			paynow.handlingTransferToThailandWithPromptPayAlert(CommonTestData.PROMPT_PAY_MESSAGE.getEnumValue());
			paynow.SelectPayNowToVPA();
			paynow.EnterVPA_Number();
			paynow.ClickOnNextButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to verify Pay Now VPA ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Pay Now VPA ", e);
		}
	}
}
