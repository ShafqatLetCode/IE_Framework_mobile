package com.crestech.pages;

import java.util.logging.Logger;
import org.openqa.selenium.remote.RemoteWebElement;

import com.crestech.annotation.values.ElementDescription;
import com.crestech.appium.utils.CommonAppiumTest;
import com.crestech.common.utilities.AndroidAlert;
import com.crestech.common.utilities.Asserts;
import com.crestech.common.utilities.CommonTestData;
import com.crestech.common.utilities.GestureUtils;
import com.crestech.common.utilities.HandleException;
import com.crestech.pageobjects.DBS_IOSObject;
import com.crestech.pages.iospage.ratingPage;
import com.crestech.pages.iospage.more.More;
import com.crestech.pages.iospage.more.cardsModule;
import com.crestech.pages.iospage.more.depositAccounts;
import com.crestech.pages.iospage.more.localTransferLimit;
import com.crestech.pages.iospage.more.peekBalance;
import com.crestech.pages.iospage.more.temporaryCreditLimitIncrease;
import com.crestech.pages.iospage.more.transactionHistory;
import com.crestech.pages.iospage.more.updateContactDetails;
import com.crestech.pages.iospage.loginPage;
import com.crestech.pages.iospage.preloginPage;
import com.crestech.pages.iospage.launchPage;
import com.crestech.pages.iospage.paytransfer.payAndTransfer;
import com.crestech.pages.iospage.paytransfer.topUpPaylah;
import com.crestech.pages.iospage.paytransfer.yourDBSPOSBAccount;
import com.crestech.pages.iospage.paytransfer.billModule;
import com.crestech.pages.iospage.paytransfer.creditCard;
import com.crestech.pages.iospage.paytransfer.deletePayee;
import com.crestech.pages.iospage.paytransfer.localModule;
import com.crestech.pages.iospage.paytransfer.overseasModule;
import com.crestech.pages.iospage.enterPasscode;
import com.crestech.pages.iospage.homePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class DBS_IOSpage extends CommonAppiumTest {

	static Logger log = Logger.getLogger(DBSAndroidPage.class.getName());
	public DBS_IOSObject IOShomePgaeObject = new DBS_IOSObject(driver);
	CommonAppiumTest commonAppTest = null;
	AndroidAlert androidAlert = null;
	GestureUtils gestUtils = null;
	HandleException obj_handleexception = null;
	homePage homepage = null;
	ratingPage ratingpage = null;
	enterPasscode enterpasscode = null;
	loginPage loginpage = null;
	preloginPage preloginpage = null;
	launchPage launchpage = null;
	payAndTransfer paytransfer = null;
	overseasModule overseasmodule = null;
	deletePayee deletepayee = null;
	localModule local = null;
	topUpPaylah topupPaylah = null;
	billModule bill = null;
	More more = null;
	peekBalance peekbalance = null;
	cardsModule cards = null;
	transactionHistory transactionhistory = null;
	temporaryCreditLimitIncrease temporary = null;
	depositAccounts depositaccount = null;
	localTransferLimit localtransferlimit = null;
	yourDBSPOSBAccount ownAccount = null;
	creditCard creditcard = null;
	updateContactDetails updateContactdetails = null;

	public DBS_IOSpage(AppiumDriver<RemoteWebElement> driver) throws Exception {
		super(driver);
		updateContactdetails = new updateContactDetails(driver);
		peekbalance = new peekBalance(driver);
		gestUtils = new GestureUtils(driver);
		commonAppTest = new CommonAppiumTest(driver);
		androidAlert = new AndroidAlert(driver);
		homepage = new homePage(driver);
		ratingpage = new ratingPage(driver);
		enterpasscode = new enterPasscode(driver);
		obj_handleexception = new HandleException(null, null);
		loginpage = new loginPage(driver);
		preloginpage = new preloginPage(driver);
		launchpage = new launchPage(driver);
		paytransfer = new payAndTransfer(driver);
		overseasmodule = new overseasModule(driver);
		deletepayee = new deletePayee(driver);
		local = new localModule(driver);
		topupPaylah = new topUpPaylah(driver);
		bill = new billModule(driver);
		temporary = new temporaryCreditLimitIncrease(driver);
		more = new More(driver);
		cards = new cardsModule(driver);
		ownAccount = new yourDBSPOSBAccount(driver);
		transactionhistory = new transactionHistory(driver);
		depositaccount = new depositAccounts(driver);
		localtransferlimit = new localTransferLimit(driver);
		creditcard = new creditCard(driver);
		// PageFactory.initElements(new AppiumFieldDecorator(driver,
		// Duration.ofSeconds(5)), IOShomePgaeObject);
	}

	@Step("Pre - requisite script")
	public void preRequisiteScript(String userName, String password, String app_Name, String serverName)
			throws Exception {
		try {
			// wait.ImplicitlyWait(10);
			// launchpage.atmLocationAlert();
			// launchpage.sendNotificationAlert();
			wait.ImplicitlyWait(75);
			launchpage.localNetworkAlert();
			wait.ImplicitlyWait(10);
			launchpage.ClickOnPreloginButton();
			preloginpage.selectUATserver(serverName);
			preloginpage.clickOnLoginButton();
			loginpage.ClickOnNOTYouLink();
			loginpage.ClickOnDeregisterButtonInDigiAlertPopup(
					CommonTestData.PEEK_BALANCE_DEREGISTER_MESSAGE.getEnumValue());
			loginpage.EnterCredentialsAndLogin(userName, password);
			homepage.digitalToken();
			homepage.handlingMotionAndFitnessAlert();
			homepage.locationSwipPopup(app_Name);
			homepage.HandlingWelcomeToDigibankForWealthManagement(app_Name);
			homepage.handlingFingurePrintAlert();
			homepage.handlingRecordingAlert();
			if (app_Name.equalsIgnoreCase("DBS"))
				wait.waitForElementVisibility(homepage.welcomeToText());
			else if (app_Name.equalsIgnoreCase("iWEALTH")) 
				wait.waitForElementVisibility(homepage.welcomeToTextIwealth());
			
			wait.ImplicitlyWait(20);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Exceute pre-Requisite Script ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Exceute pre-RequisiteScript ", e);
		}
	}

	@Step("Log In the Application")
	public void LogInApplication(String userName, String password, String app_Name) throws Exception {
		try {
			preloginpage.clickOnLoginButton();
			loginpage.EnterCredentialsAndLogin(userName, password);
			homepage.handlingMotionAndFitnessAlert();
			if (app_Name.equalsIgnoreCase("DBS"))
				wait.waitForElementVisibility(homepage.welcomeToText());
			else if (app_Name.equalsIgnoreCase("iWEALTH")) 
				wait.waitForElementVisibility(homepage.welcomeToTextIwealth());
			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Exceute Log In Application ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Exceute Log In Application ", e);
		}
	}

	@Step("Logout the application")
	public void VerifyLogout(String app_Name) throws Exception {
		try {
			homepage.VerifyWelcomeMessagesOnDashboardPage(CommonTestData.WELCOME.getEnumValue(),
					CommonTestData.DIGIBANK.getEnumValue(), CommonTestData.DBS_DIGIBANK.getEnumValue(), app_Name);
			homepage.ClickOnLogOutButton(app_Name);
			ratingpage.verifyTapOnTheStarsToRate(CommonTestData.RATE_MESSAGE.getEnumValue());
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Verify Logout the application  ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Verify Logout the application  ", e);
		}
	}

	@Step("Verify topup Paylah.")
	public void TopupPaylah() throws Exception {
		try {
			homepage.ClickOnPayAndTransferButton();
			enterpasscode.EnterPasscodeAndDone();
			paytransfer.clickOnTopUpModule();
			topupPaylah.ClickOnPaylah();
			topupPaylah.EnterCurrency(CommonTestData.AMOUNT_PAYLAH.getEnumValue());
			topupPaylah.ClickOnNextButton();
			topupPaylah.verifyTopUpReview(CommonTestData.TOPUP_REVIEW_LABEL.getEnumValue());
			topupPaylah.ClickOnTopUpNowButton();
			topupPaylah.ClickOnTopupLogOutButton();
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
			more.SelectLocalTransferLimitModule();
			localtransferlimit
					.verifyLocalTransferLimitPageHeader(CommonTestData.LOCAL_TRANSFER_LIMIT_LABEL.getEnumValue());
			localtransferlimit.selectAccountTypeInLocalFundTransfer();
			enterpasscode.EnterPasscodeAndDone();
			String amountSlected = localtransferlimit
					.handlingSetCurrentLimit(CommonTestData.SELECTED_LIMIT_50000.getEnumValue());
			localtransferlimit.ClickOnNextButton();
			localtransferlimit.verifyReviewDailyLimitTitle();
			localtransferlimit.verifyClickChangeDailyLimitNowButton();
			enterpasscode.EnterPasscode();
			localtransferlimit.verifyLocalTransferlimitChangedHeader(
					CommonTestData.LOCAL_LIMIT_INCREASE_SUCCESS_TITLE_IOS.getEnumValue());
			localtransferlimit.ClickOnBackToMoreButton();
			more.SelectLocalTransferLimitModule();
			localtransferlimit
					.verifyLocalTransferLimitPageHeader(CommonTestData.LOCAL_TRANSFER_LIMIT_LABEL.getEnumValue());
			localtransferlimit.selectAccountTypeInLocalFundTransfer();
			localtransferlimit.verifyDisplayAmountLocalTransferLimitChange(amountSlected);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION",
					" Failed to Exceute Change Local Funds Transfer Limit ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION",
					" Failed to Exceute Change Local Funds Transfer Limit ", e);
		}
	}

	@Step("Verifies Add payee DBSorPOSB.")
	public void VerifyAddPayeeDBSorPOSB() throws Exception {
		try {
			homepage.ClickOnPayAndTransferButton();
			enterpasscode.EnterPasscodeAndDone();
			local.clickOnAddLocalRecipientBtn();
			local.verifyLocalTransferPayNowPageHeader();
			local.SelectBankAccount();
			local.verifyEnterRecipientDetailsPageHeader();
			String ExpectedRecipientName = CommonTestData.PAYEEADD_DBSPOSB_RECIPIENT_NAME.getEnumValue();
			local.EnterRecipientDetails(ExpectedRecipientName, CommonTestData.PAYEEADD_DBSPOSB_BANK_NAME.getEnumValue(),
					CommonTestData.PAYEEADD_DBSPOSB_ACCOUNT_NUMBER.getEnumValue());
			local.ClickOnNextButton();
			local.verifyReviewRecipientDetailsPageHeader();
			local.ClickOnAddRecipientNowBtn();
			enterpasscode.EnterPasscode();
			local.VerifyYouHaveAddedRecipientMsg();
			local.verifyValidationForPayeeAdd(ExpectedRecipientName,
					CommonTestData.PAYEEADD_DBSPOSB_BANK_NAME.getEnumValue(),
					CommonTestData.PAYEEADD_DBSPOSB_ACCOUNT_NUMBER.getEnumValue());

			// Leave On Home Page to this test case for next run.
			local.ClickOnCloseButton();
			paytransfer.ClickOnHomeButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Execute Add payee DBSorPOSB  ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Execute Add payee DBSorPOSB  ", e);
		}
	}

	@Step("Delete Payee to DBS/POSB.")
	public void DeletePayee_ToDBSPOSB() throws Exception {
		try {
			homepage.ClickOnPayAndTransferButton();
			enterpasscode.EnterPasscodeAndDone();
			paytransfer.clickOnLocalButton();
			deletepayee.DeletePayee(CommonTestData.PAYEEADD_DBSPOSB_RECIPIENT_NAME.getEnumValue());

			// Leave On Home Page to this test case for next run.
			local.ClickOnCloseButton();
			paytransfer.ClickOnHomeButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Delete Payee to DBS/POSB ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Delete Payee to DBS/POSB ", e);
		}
	}

	@Step("Verifies the Payee Add Local OtherBank and verifies 'YOU HAVE ADDED RECIPIENT MSG' .")
	public void PayeeAddLocalOtherBank() throws Exception {
		try {
			homepage.ClickOnPayAndTransferButton();
			enterpasscode.EnterPasscodeAndDone();
			paytransfer.clickOnLocalButton();
			local.clickOnAddLocalRecipientBtn();
			local.verifyLocalTransferPayNowPageHeader();
			local.SelectBankAccount();
			local.verifyEnterRecipientDetailsPageHeader();
			String ExpectedRecipientName = CommonTestData.LOCAL_RECIPIENT_NAME.getEnumValue();
			String ExpectedAccountNumber = CommonTestData.LOCAL_RECIPIENT_ACCOUNT_NUMBER.getEnumValue();
			local.EnterRecipientDetails(ExpectedRecipientName, CommonTestData.LOCAL_RECIPIENT_BANK_NAME.getEnumValue(),
					ExpectedAccountNumber);
			local.ClickOnNEXTButton();
			local.verifyReviewRecipientDetailsPageHeader();
			local.ClickOnAddRecipientNowBtn();
			enterpasscode.EnterPasscode();
			local.VerifyYouHaveAddedRecipientMsg();
			local.verifyValidationForPayeeAdd(ExpectedRecipientName,
					CommonTestData.LOCAL_RECIPIENT_BANK_NAME.getEnumValue(), ExpectedAccountNumber);

			// Leave On Home Page to this test case for next run.
			local.ClickOnCloseButton();
			paytransfer.ClickOnHomeButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION",
					" Failed to Execute Payee Add Local Other Bank ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Execute Payee Add Local Other Bank  ",
					e);
		}
	}

	@Step("Delete Payee to Local To Other Bank.")
	public void DeletePayee_LocalToOtherBank() throws Exception {
		try {
			homepage.ClickOnPayAndTransferButton();
			enterpasscode.EnterPasscodeAndDone();
			paytransfer.clickOnLocalButton();
			deletepayee.DeletePayee(CommonTestData.LOCAL_RECIPIENT_NAME.getEnumValue());

			// Leave On Home Page to this test case for next run.
			local.ClickOnCloseButton();
			paytransfer.ClickOnHomeButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Delete Payee to Local To Other Bank ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Delete Payee to Local To Other Bank ", e);
		}
	}

	@Step("Verify Payee Add Remittance.")
	public void PayeeAddRemittance() throws Exception {
		try {
			// homepage.ClickOnPayAndTransferButton();
			// enterpasscode.EnterPasscodeAndDone();
			// paytransfer.ClickOnOverseasModule();
			overseasmodule.SelectAddRecipientNowButtonUnderOverseas();
			overseasmodule.SelectCountry(CommonTestData.COUNTRY_AUS_SEARCH.getEnumValue(),
					CommonTestData.COUNTRY_AUS.getEnumValue());
			overseasmodule.SelectCurrencyType(CommonTestData.CURRENCY_AUS.getEnumValue());
			overseasmodule.ClickOnNEXTButton();
			overseasmodule.EnterBankCode(CommonTestData.BANK_BCD_CODE.getEnumValue());
			overseasmodule.ClickOnNextButton();
			overseasmodule.verifyEnterRecipientDetailsPageHeader(CommonTestData.ENTER_RECIPIENT_DETAIL.getEnumValue());
			overseasmodule.EnterAccountNumber(CommonTestData.ACCOUNT_NO.getEnumValue());
			overseasmodule.EnterFullName(CommonTestData.FULL_NAME.getEnumValue());
			gestUtils.scrollUPtoObjectIos("name", "NEXT", null);
			overseasmodule.EnterAddress(CommonTestData.ADDRESS_SHORT.getEnumValue());
			overseasmodule.EnterCity(CommonTestData.CITY.getEnumValue());
			overseasmodule.ClickOnNextButton();
			overseasmodule.verifyReviewRecipientDetailsPageHeader(CommonTestData.REVIEW_RECIPIENT_LABEL.getEnumValue());
			overseasmodule.ClickOnAddRecipientNowBtn();
			enterpasscode.EnterPasscode();
			overseasmodule.verifyYouHaveAddedMessage(CommonTestData.YOU_HAVE_ADDED_RECIPIENT_MSG2.getEnumValue());
			overseasmodule.verifyReferenceFieldAndItsValue(CommonTestData.REFERENCE_NUMBER.getEnumValue());
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Execute Add payee Remittance  ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Execute Add payee Remittance  ", e);
		}
	}

	@Step("Delete Payee to Remittence")
	public void DeletePayee_ToRemittence() throws Exception {
		try {
			homepage.ClickOnPayAndTransferButton();
			enterpasscode.EnterPasscodeAndDone();
			paytransfer.ClickOnOverseasModule();
			deletepayee.DeletePayeeForRemittence(CommonTestData.FULL_NAME.getEnumValue());

			// Leave On Home Page to this test case for next run.
			// overseasmodule.ClickOnCloseButtonInOversea();
			// paytransfer.ClickOnHomeButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Delete Payee to DBS/POSB ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Delete Payee to DBS/POSB ", e);
		}
	}

	@Step("Verify Fund Transfer Pay Credit Card.")
	public void FundsTransfer_PayCreditCard() throws Exception {
		try {
			homepage.ClickOnPayAndTransferButton();
			enterpasscode.EnterPasscodeAndDone();
			paytransfer.SelectAllTAB();
			paytransfer.ClickOnCreditCard();
			String ExpectedToBankNameWithAccountNo = CommonTestData.FUNDTRANSFER_CREDITCARD_TO_ACCOUNTNUMBER_WITHBANK
					.getEnumValue();
			paytransfer.SelectToAccountFromCreditCardList(ExpectedToBankNameWithAccountNo);
			creditcard.verifyCreditCardPageHeader();
			creditcard.EnterAmount(CommonTestData.AMOUNTTO_TRANSFERFUND.getEnumValue());
			String ExpectedFromBankName = CommonTestData.FUNDTRANSFER_CREDITCARD_FROM_ACCOUNT_NAME.getEnumValue();
			creditcard.SelectFundSourceAccount(ExpectedFromBankName);
			creditcard.VerifyImmediateText(CommonTestData.IMMEDIATE_TEXT.getEnumValue());
			creditcard.ClickOnNEXTButton();
			creditcard.verifyReviewPaymentPageHeader();
			creditcard.ClickOnTransferNowButton();
			creditcard.VerifyDetailsAfterSubmitPayment();
			creditcard.VerifySomeDetailsAfterCreditCardFundTransfer();

			// Leaving On Home Page for Next case Run.
			creditcard.ClickOnCloseButton();
			paytransfer.ClickOnHomeButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to fund transfer pay credit card  ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to fund transfer pay credit card    ", e);
		}
	}

	@Step("Verify Transaction History")
	public void verifyTransactionHistory(String appName) throws Exception {
		try {
			homepage.ClickOnMoreButton();
			enterpasscode.EnterPasscodeAndDone();
			more.ClickOnTransactionHistory();
			enterpasscode.EnterPasscodeAndDone();
			transactionhistory
					.verifyTransactionHistoryPageHeader(CommonTestData.TRANSCETION_HISTORY_LABEL.getEnumValue());
			transactionhistory.SelectThreeMonths();

			if (appName.equals("DBS"))
				transactionhistory.ClickOnDepositAccountAndSelectFromAccount(CommonTestData.ACCOUNT_NAME.getEnumValue(),
						CommonTestData.CURRENCY_NAME.getEnumValue());
			else if (appName.equals("iWEALTH"))
				transactionhistory.ClickOnDepositAccountAndSelectFromAccount(
						CommonTestData.ACCOUNT_NAME_IWEALTH.getEnumValue(),
						CommonTestData.CURRENCY_NAME.getEnumValue());

			transactionhistory
					.verifyTransactionHistoryPageHeader(CommonTestData.TRANSCETION_HISTORY_LABEL.getEnumValue());
			gestUtils.scrollUPIos();
			transactionhistory.ClickOnShowButton();
			enterpasscode.EnterPasscode();

			if (appName.equals("DBS"))
				transactionhistory.AccountNameToCheckTransactionHistory(CommonTestData.STATEMENT_TITLE.getEnumValue());
			else if (appName.equals("iWEALTH"))
				transactionhistory
						.AccountNameToCheckTransactionHistory(CommonTestData.ACCOUNT_NAME_IWEALTH.getEnumValue());

			transactionhistory.ValadateTransactionHistoryListInThreeMonth();
			//transactionhistory.BackToHomeFromTransactionHistory();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to verify transaction history ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to verify transaction history ", e);
		}
	}

	@Step("Verifies FundTransfer Other DBS/POSB")
	public void FundTransferDBSPOSB(String appname) throws Exception {
		try {
			homepage.ClickOnPayAndTransferButton();
			enterpasscode.EnterPasscodeAndDone();
			paytransfer.SelectAllTAB();
			paytransfer.ClickOnLocalRecipient();
			paytransfer.SelectToAccountFromLocalRecipient(
					CommonTestData.LOCAL_RECIPIENT_LIST_SELECTED_ACCOUNTNAME.getEnumValue());

			String ExpectedFromBankName = null;
			if (appname.equals("DBS")) {
				ExpectedFromBankName = CommonTestData.SOURCE_ACCOUNT_NAME.getEnumValue();
				local.SelectFundSourceAccount(ExpectedFromBankName,appname);
			} else if (appname.equals("iWEALTH")) {
				ExpectedFromBankName = CommonTestData.SOURCE_ACCOUNT_NAME_iWEALTH.getEnumValue();
				local.SelectFundSourceAccount(ExpectedFromBankName,appname);
			}

			local.enterAmountAndVerifySgdCurrency(CommonTestData.AMOUNT_FUNDTRANSFER.getEnumValue());
			local.ClickOnNEXTButton();
			local.verifyReviewTransferPageHeader(CommonTestData.REVIEW_TRANSFER_LABEL.getEnumValue());
			local.ClickTransferNowButton();
			local.verifyTransferredAndReferenceNumberField();
			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION",
					" Failed to verify fund transfer other DBS_POSB  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to verify fund transfer other DBS_POSB  ",
					e);
		}
	}

	@Step("verify Account Details On Home Page")
	public void VerifyAccountDetailsCasaOnHomePage(String app_Name) throws Exception {
		try {
			if(app_Name.equalsIgnoreCase("DBS"))
				homepage.verifyAccountTypeNameCurrencyAmount(CommonTestData.ACCOUNT_TYPE.getEnumValue(),
					CommonTestData.ACCOUNT_NAME_HOME.getEnumValue(), CommonTestData.CURRENCY.getEnumValue(), app_Name);
			else if(app_Name.equalsIgnoreCase("iWEALTH"))
				homepage.verifyAccountTypeNameCurrencyAmount(CommonTestData.ACCOUNT_TYPE_IWEALTH.getEnumValue(),
						CommonTestData.ACCOUNT_NAME_HOME_IWEALTH.getEnumValue(), CommonTestData.CURRENCY.getEnumValue(), app_Name);
		}
			catch (HandleException e) {	
				obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Verify the account detail on dashboard page  ",e);			
			}
			catch (Exception e) {			
				obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Verify the account detail on dashboard page  ",e);
			}
	}

	@Step("Verifies Remittance Corridor")
	public void VerifyRemittanceCorridor(Object appName) throws Exception {
		try {
			homepage.ClickOnPayAndTransferButton();
			enterpasscode.EnterPasscodeAndDone();
			paytransfer.ClickOnOverseasModule();
			overseasmodule.SelectOverseaPayee(CommonTestData.PAYEE_NAME_CORRIDOR.getEnumValue());
			if (appName.equals("DBS"))
				overseasmodule.SelectSourceOfFund(CommonTestData.SOURCE_ACCOUNT_NAME_CORRIDOR.getEnumValue());
			else if (appName.equals("iWEALTH"))
				overseasmodule.SelectSourceOfFund(CommonTestData.SOURCE_ACCOUNT_NAME_CORRIDOR_IWEALTH.getEnumValue());

			overseasmodule.pressEnterKeyAfterEnteringAmount(CommonTestData.CORRIDOR_AMOUNT.getEnumValue());

			overseasmodule.SelectAdditionalDetails(CommonTestData.EOTT_ACCOUNT_TYPE.getEnumValue(),
					CommonTestData.PURPOSE.getEnumValue(), CommonTestData.MOBILE_NUMBER.getEnumValue());
			overseasmodule.ClickOnNextButton();
			overseasmodule.verifyReviewTransferPageHeader(CommonTestData.REVIEW_TRANSFER.getEnumValue());
			overseasmodule.ClickOnTransferNowButton();
			overseasmodule.VerifiesTransferSubmittedMessage(CommonTestData.TRANSFER_SUBMITTED_MSG.getEnumValue());

			overseasmodule.ClickOnImageExpandBtnAndVerifiesReferenceNumberText();
			overseasmodule.ClickOnShareTransferDetailsButton();
			overseasmodule.BackFromTestCase();
			paytransfer.ClickOnHomeButton();
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
			homepage.ClickOnPayAndTransferButton();
			enterpasscode.EnterPasscodeAndDone();
			paytransfer.SelectAllTAB();
			overseasmodule.SelectEOTT();
			if (appName.equals("DBS"))
				overseasmodule.SelectSourceOfFund(CommonTestData.SOURCE_ACCOUNT_NAME_CORRIDOR.getEnumValue());
			else if (appName.equals("iWEALTH"))
				overseasmodule.SelectSourceOfFund(CommonTestData.SOURCE_ACCOUNT_NAME_CORRIDOR_IWEALTH.getEnumValue());
			overseasmodule.pressEnterKeyAfterEnteringAmount(CommonTestData.eOTT_AMOUNT.getEnumValue());
			overseasmodule.SelectAdditionalDetails(CommonTestData.EOTT_ACCOUNT_TYPE.getEnumValue(),
					CommonTestData.PURPOSE.getEnumValue(), CommonTestData.MOBILE_NUMBER.getEnumValue());
			overseasmodule.ClickOnNextButton();
			overseasmodule.verifyReviewTransferPageHeader(CommonTestData.REVIEW_TRANSFER.getEnumValue());
			overseasmodule.ClickOnTransferNowButton();
			overseasmodule.VerifiesTransferSubmittedMessage(CommonTestData.TRANSFER_SUBMITTED_MSG.getEnumValue());
			overseasmodule.ClickOnImageExpandBtnAndVerifiesReferenceNumberText();
			overseasmodule.ClickOnShareTransferDetailsButton();
			overseasmodule.BackFromTestCase();
			paytransfer.ClickOnHomeButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Execute Remittance EOTT  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Execute Remittance EOTT  ", e);
		}
	}

	@Step("Verify CreditCard Temperary Limit Increase")
	public void CreditCardTempLimitIncrease() throws Exception {
		try {
			homepage.ClickOnMoreButton();
			enterpasscode.EnterPasscodeAndDone();
			more.SelectTemporaryCreditLimitIncreaseModule();
			enterpasscode.EnterPasscodeAndDone();
			temporary.verifyTempLimitIncreasePageHeader(CommonTestData.TEMP_LIMIT_INCREASE_TITLE.getEnumValue());
			temporary.EnterAmount(CommonTestData.CREDITCARD_LIMITINCREASE_AMOUNT.getEnumValue());
			temporary.verifyTempLimitIncreasePageHeader(CommonTestData.TEMP_LIMIT_INCREASE_TITLE.getEnumValue());
			temporary.SelectPurpose(CommonTestData.CREDITCARD_LIMITINCREASE_PURPOSE.getEnumValue());
			temporary.SetDuration();
			temporary.ClickOnNEXTButton();
			temporary.verifyReviewApplicationPageHeader(
					CommonTestData.REVIEW_APPLICATION_CREDITLIMIT_TITLE.getEnumValue());
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION",
					" Failed to Execute Credit Card Temp Limit Increase ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION",
					" Failed to Execute Credit Card Temp Limit Increase ", e);
		}
	}

	@Step("Verifies the Payee Add Bill Payment and after completion payment verifies the transfering amount.")
	public void PayeeAddBillPayment() throws Exception {
		try {
			homepage.ClickOnPayAndTransferButton();
			enterpasscode.EnterPasscodeAndDone();
			paytransfer.ClickOnBillModule();
			bill.ClickOnAddBillingOrganisation();
			bill.EnterBillingOrganisationDetails(CommonTestData.PAYEEADD_BILLPAYMENT_ACCOUNTNAME.getEnumValue(),
					CommonTestData.PAYEEADD_BILLPAYMENT_REFERENCENUMBER.getEnumValue());
			bill.ClickOnNextButton();
			bill.VerifyReviewRecipientDetailsPageHeader();

			bill.VerifyBillingOrganisationAndBillReferenceNumber(
					CommonTestData.PAYEEADD_BILLPAYMENT_ACCOUNTNAME.getEnumValue(),
					CommonTestData.PAYEEADD_BILLPAYMENT_REFERENCENUMBER.getEnumValue());
			bill.ClickOnAddRecipientNowBtn();
			enterpasscode.EnterPasscode();
			bill.VerifyYouHaveAddedRecipientMsg();
			bill.VerifyBillingOrganisationAndBillReferenceNumber(
					CommonTestData.PAYEEADD_BILLPAYMENT_ACCOUNTNAME.getEnumValue(),
					CommonTestData.PAYEEADD_BILLPAYMENT_REFERENCENUMBER.getEnumValue());
			bill.verifyLogOutButton();
			bill.verifyMakeAPaymentButton();
			bill.verifyCloseButton();

			// Fund Transfer After Adding Bill Payment
			bill.ClickOnMakeAPayment();
			bill.VerifyPayToBillerPageHeader();
			bill.EnterAmount(CommonTestData.AMOUNTTO_TRANSFERFUND.getEnumValue());
			bill.ClickOnNextButton();
			bill.VerifyReviewPaymentPageHeader();
			bill.ClickOnTransferNowButton();
			bill.VerifyDetailsAfterSubmitPayment();

			// Leave On Home Page to this test case for next run.
			bill.ClickOnCloseButton();
			paytransfer.ClickOnHomeButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION",
					" Failed to Execute Payee Add To Bill Payment ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Execute Payee Add to Bill Payment  ",
					e);
		}
	}

	@Step("Delete Payee to Bill Payment.")
	public void DeletePayee_ToBillPayment() throws Exception {
		try {
			homepage.ClickOnPayAndTransferButton();
			enterpasscode.EnterPasscodeAndDone();
			paytransfer.ClickOnBillModule();
			deletepayee.DeletePayee(CommonTestData.PAYEEADD_BILLPAYMENT_ACCOUNTNAME.getEnumValue());

			// Leave On Home Page to this test case for next run.
			local.ClickOnCloseButton();
			paytransfer.ClickOnHomeButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Delete Payee to Bill Payment.", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Delete Payee to Bill Payment. ", e);
		}
	}

	@Step("Verify Fund Transfer For Own Account.")
	public void VerifyFundTransfer_OwnAccount() throws Exception {
		try {
			homepage.ClickOnPayAndTransferButton();
			enterpasscode.EnterPasscodeAndDone();
			paytransfer.SelectAllTAB();
			paytransfer.SelectToAccountFromYourDBSPOSBAccountlist(
					CommonTestData.FUNDTRANSFER_TO_OWN_ACCOUNT_NAME.getEnumValue());
			ownAccount.verifyTransferToYourAccountPageHeader();
			String ExpectedFromAccountName = CommonTestData.FUNDTRANSFER_FROM_OWN_ACCOUNT_NAME.getEnumValue();
			ownAccount.SelectFundSourceAccount(ExpectedFromAccountName);
			ownAccount.EnterAmount(CommonTestData.AMOUNTTO_TRANSFERFUND.getEnumValue());
			ownAccount.ClickOnNEXTButton();
			ownAccount.verifyReviewTransferPageHeader();
			ownAccount.ClickOnTransferNowBtn();
			ownAccount.VerifiesTransferSubmittedMsg(CommonTestData.TRANSFERRED.getEnumValue());
			ownAccount.VerifyAccountDetailsAfterFundTransferToOwnAccount();

			// Leaving On Home page for next case run.
			ownAccount.ClickOnBackToHomeButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to verify Fund transfer to own account  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to verify Fund transfer to own account ", e);
		}
	}

	@Step("Verify Fund Transfer Bill Payment.")
	public void FundsTransfer_BillPayment() throws Exception {
		try {
			homepage.ClickOnPayAndTransferButton();
			enterpasscode.EnterPasscodeAndDone();
			paytransfer.SelectAllTAB();
			String ExpectedToBankNameWithAccountNo = CommonTestData.FUNDTRANSFER_BillPayment_TO_ACCOUNTNUMBER_WITHBANK
					.getEnumValue();
			paytransfer.SelectBillingOrganisation();
			paytransfer.SelectToAccountFromBillingOrganisationList(ExpectedToBankNameWithAccountNo);
			bill.VerifyPayToBillerPageHeader();
			bill.EnterAmount(CommonTestData.AMOUNTTO_TRANSFERFUND.getEnumValue());
			bill.VerifyImmediateText(CommonTestData.IMMEDIATE_TEXT.getEnumValue());
			bill.ClickOnNEXTButton();
			bill.VerifyReviewPaymentPageHeader();
			bill.ClickOnTransferNowButton();
			bill.VerifyDetailsAfterSubmitPayment();

			// Leave On Home Page to this test case for next run.
			bill.ClickOnCloseButton();
			paytransfer.ClickOnHomeButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION",
					" Failed to verify Fund transfer bill payment  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to verify Fund transfer bill payment  ",
					e);
		}
	}

	@Step("Verifies the Applying Debit Card and Verify the completion page details.")
	public void ApplyDebitCard(String appName) throws Exception {
		try {
			homepage.ClickOnMoreButton();
			enterpasscode.EnterPasscodeAndDone();
			more.SelectCardsModule();
			cards.SelectDebitCard();
			enterpasscode.EnterPasscodeAndDone();
			cards.selectDebitCardType(CommonTestData.DEBIT_CARD_NAME.getEnumValue());
			cards.FillingDetailsToApplyingDebitCard(appName);
			cards.ClickOnSendMeDBSPrmotionViaMailCheckbox();
			cards.ClickOnNEXTButton();
			cards.verifyReviewApplicationPageHeader();
			cards.ClickOnNextButton();
			cards.VerifySetCardPINPageHeader();
			cards.SetDebitCardPin(CommonTestData.CREATE_PIN.getEnumValue(), CommonTestData.CONFIRM_PIN.getEnumValue());
			cards.ClickOnSubmitButton();
			cards.VerifyApplicationSubmittedMessage();
			cards.verifyLogOutButton();
			cards.verifyBackToMoreServicesButton();
			cards.verifyCloseButton();

			// Leave On Home Page to this test case for next run.
			cards.ClickOnCloseButton();
			more.ClickOnHomeButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Execute Apply Debit card  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Execute Apply Debit card  ", e);
		}
	}

	@Step("Verifies the Open Account.")
	public void OpenAccount(String appName) throws Exception {
		try {
			homepage.ClickOnMoreButton();
			enterpasscode.EnterPasscodeAndDone();
			more.ClickOnDepositAccountModule();
			enterpasscode.EnterPasscodeAndDone();
			depositaccount.verifyOpenAccountPageHeader();
			depositaccount.SelectOpenAccountOption();
			depositaccount.verifyAccountBenefitsPageHeader(CommonTestData.ACCOUNT_BENIFITS.getEnumValue());
			depositaccount.ClickOnopenAccountInStepButton();
			depositaccount.verifyPageHeader(CommonTestData.OPEN_ACCOUNT.getEnumValue());
			depositaccount.EnterMonthlySavingAmount();
			depositaccount.SelectSourceOfFundsForSavings(appName);
			depositaccount.ClickOnNEXTButton();
			depositaccount.VerifyWarningMessageAndImportantNotes();
			depositaccount.ClickOnIAcknowledgeButton();
			depositaccount.verifyReviewApplicationPageHeader();
			depositaccount.ClickOnOpenAccountNowButton();
			depositaccount.VerifyDetailsAfterOpenAccount();

			// Leave On Home Page to this test case for next run.
			depositaccount.ClickOnCloseButton();
			more.ClickOnHomeButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Exceute Open Account ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Exceute Open Account ", e);
		}
	}

	@Step("Verify Peek Balance.")
	public void VerifyPeekBalance(String appName) throws Exception {
		try {
			
			VerifyAccountDetailsCasaOnHomePage(appName); 
	
			if (isElementVisible2(homepage.accountNameHomepage())) {
				String DepositeAccountNameOnDashboard = homepage.getAndClickOnDepositeAccountNameFromDashboard();
				enterpasscode.EnterPasscodeAndDone();
				enterpasscode.EnterPasscodeAndDone();
				String ExpectedUserAccountNumber = homepage.GetUserAccountNumber();
				//homepage.ClickOnToolBarBackIcon();
                more.ClickOnHomeButton();
				homepage.ClickOnMoreButton();
		    	enterpasscode.EnterPasscodeAndDone();
				more.SelectPeekBalanceModule();
				enterpasscode.EnterPasscodeAndDone();
				peekbalance.handleConfirmationMessage();
				peekbalance.EnablePeekBalanceToggle();
				peekbalance.SelectAccountToEnablePeekBalance(CommonTestData.USER_ACCOUNT_NAME.getEnumValue());

//				String SelectedAccountNameWithAccountNumber = DepositeAccountNameOnDashboard + " "
//						+ ExpectedUserAccountNumber;
//				peekbalance.verifySelectedAccountForPeekBalance(CommonTestData.ACCOUNT_FOR_PEEK_BALANCE.getEnumValue(),
//						SelectedAccountNameWithAccountNumber);

				peekbalance.ClickOnSaveButton();
				peekbalance.ClickOnOkButtonInPersonalizeYourDevicePopup();
				peekbalance.ClickOnBackButtonImageView();
				more.clickOnLogoutButton();
				ratingpage.verifyTapOnTheStarsToRate(CommonTestData.RATE_MESSAGE.getEnumValue());
				ratingpage.ClickOnCloseButton();
				preloginpage
						.VerifyPeekBalanceEnabilityOnLogInPage(CommonTestData.PEEK_BALANCE_SUBTITLE_IOS.getEnumValue());
				// TODO: Code Add for tap and hold on above element and get total amount balance
				preloginpage.TapAndHoldPeekBalance();

				// DeRegister/Disable Process to removing peek balance from login page for next
				// run.
				preloginpage.ClickOnLoginButtonAfterEnablePeekBalance();
				loginpage.ClickOnNOTYouLink();
				loginpage.ClickOnDeregisterButtonInDigiAlertPopup(
						CommonTestData.PEEK_BALANCE_DEREGISTER_MESSAGE.getEnumValue());
			} else
				Asserts.assertFail("Deposite Account Name not showing on the Dashboard Page.");

		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Execute Peek Balance. ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Execute Peek Balance", e);
		}
	}

	@Step("Update Personal Details")
	public void UpdatePersonalDetails(String appName) throws Exception {
		try {
			homepage.ClickOnMoreButton();
			enterpasscode.EnterPasscodeAndDone();
			more.SelectUpdateContactDetails("Update", CommonTestData.UPDATE_CONTACT_DETAILS_PAGEHEADER.getEnumValue(),
					CommonTestData.UPDATE_PARTICULARS.getEnumValue());
			updateContactdetails.verifyUpdateContactDetailsPageHeader(
					CommonTestData.UPDATE_CONTACT_DETAILS_PAGEHEADER.getEnumValue());
			updateContactdetails.VerifyBackButtonImageView();
			updateContactdetails.VerifyPersonalAndContactDetails();
			updateContactdetails.VerifyMailingAddress();
			updateContactdetails.SelectPersonalContactDetails();
			enterpasscode.EnterPasscodeAndDone();
			updateContactdetails.verifyPersonalContactDetailsPageHeader();
			updateContactdetails.VerifyPersonalDetailsPage(appName);
			updateContactdetails.ClickOnCheckboxes();
			updateContactdetails.verifyTermsAndConditionsMessage(
					CommonTestData.TERMS_AND_CONDITIOINS_MESSAGE.getEnumValue(), appName);
			updateContactdetails.ClickOnNextButton();
			gestUtils.scrollUPtoObjectIos("name", "CONFIRM", null);
			updateContactdetails.ClickOnNextButton();
			enterpasscode.EnterPasscode();
			updateContactdetails.verifySuccessfullyUpdatedMessage(appName);

			// Verify Final Result after go through on Personal Details Page.
			updateContactdetails.ClickOnBackToMoreServicesButton(appName);
			more.SelectUpdateContactDetails("Update", CommonTestData.UPDATE_CONTACT_DETAILS_PAGEHEADER.getEnumValue(),
					CommonTestData.UPDATE_PARTICULARS.getEnumValue());
			updateContactdetails.verifyUpdateContactDetailsPageHeader(
					CommonTestData.UPDATE_CONTACT_DETAILS_PAGEHEADER.getEnumValue());
			updateContactdetails.VerifyBackButtonImageView();
			updateContactdetails.VerifyPersonalAndContactDetails();
			updateContactdetails.VerifyMailingAddress();
			updateContactdetails.SelectPersonalContactDetails();
			enterpasscode.EnterPasscodeAndDone();
			updateContactdetails.verifyPersonalContactDetailsPageHeader();
			updateContactdetails.VerifyPersonalDetailsPage(appName);
			updateContactdetails.VerifyLastUpdatedDateOfCallMeCheckbox();
			updateContactdetails.VerifyLastUpdatedDateOfSMSMeCheckbox();
			updateContactdetails.VerifyLastUpdatedDateOfEmailMeCheckbox();
			updateContactdetails.VerifyLastUpdatedDateOfFAXMeCheckbox();
			updateContactdetails.VerifyLastUpdatedDateOfMailMeCheckbox();

			// Leave On Home Page for next case run.
			updateContactdetails.ClickOnBackButton();
			more.ClickOnHomeButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to update personal details  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", "  Failed to update personal details  ", e);
		}
	}

	public void verifyDigibankAlert() throws Exception {
		String alertMessage = null;
		try {
			wait.ImplicitlyWait(2);
			if (androidAlert.isIOSAlertPresent()) {
				System.out.println("Alert title :: " + this.driver.findElementByXPath(
						"//XCUIElementTypeStaticText[@name='digibank Alert']/following-sibling::XCUIElementTypeStaticText")
						.getText());

				alertMessage = this.driver.findElementByXPath("//XCUIElementTypeStaticText[@name='digibank Alert']")
						.getText()
						+ ": "
						+ this.driver.findElementByXPath(
								"//XCUIElementTypeStaticText[@name='digibank Alert']/following-sibling::XCUIElementTypeStaticText")
								.getText();
				Asserts.assertFail(alertMessage);
			} else if (androidAlert.isIOSOfflineAlertPresent()) {
				System.out.println("Alert title :: " + this.driver.findElementByXPath(
						"//XCUIElementTypeStaticText[@name='You seem to be offline']/following-sibling::XCUIElementTypeStaticText")
						.getText());

				alertMessage = this.driver
						.findElementByXPath("//XCUIElementTypeStaticText[@name='You seem to be offline']").getText()
						+ ": "
						+ this.driver.findElementByXPath(
								"//XCUIElementTypeStaticText[@name='You seem to be offline']/following-sibling::XCUIElementTypeStaticText")
								.getText();
				Asserts.assertFail(alertMessage);
			} else if (androidAlert.isAlertPresent()) {
				System.out.println("Alert title :: " + this.driver.switchTo().alert().getText());

				alertMessage = this.driver.switchTo().alert().getText();
				Asserts.assertFail(alertMessage);

			} else {
				wait.ImplicitlyWait(10);
				verifyWaitForPageLoad();
			}
		} catch (Exception e) {
			obj_handleexception.throwException("DIGIBANK_ALERT",
					" Failed to proceed because of DIGI BANK ALERT " + alertMessage, e);
		}
	}
	
	@ElementDescription(value = "'activityIndicator")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='customLoadingView_activityIndicator']")
	private MobileElement activityIndicator;
	
	@ElementDescription(value = "'animationView")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='animationView']")
	private MobileElement animationView;
	
	@ElementDescription(value = "'Authenticating")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Authenticating']")
	private MobileElement Authenticating;
	
	public void verifyWaitForPageLoad() throws Exception {
		String alertMessage = null;
		try {
			if (isElementVisible2(activityIndicator)
					|| isElementVisible2(animationView)
					|| isElementVisible2(Authenticating)) {
				System.out.println("Wait Duration Limit exceeded :: Application Unable to load Page");

				alertMessage = "Wait Duration Limit exceeded :: Application Unable to load Page";
				Asserts.assertFail(alertMessage);
			}
		} catch (Exception e) {
			obj_handleexception.throwException("Application Not Responding",
					" Failed to proceed because Application Unable to load Page " + alertMessage, e);
		}
	}

}
