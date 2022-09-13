package com.crestech.common.utilities;

public enum CommonTestData {

	//ACCOUNT CASA
	ACCOUNT_TYPE("Deposits"),
	ACCOUNT_NAME_HOME("DBS SAVINGS PLUS"),
	CURRENCY("SGD"),
	ACCOUNT_SECTION("ACCOUNTS"),
	
//	ACCOUNT_TYPE_IWEALTH("CPFIA/SRS Account"),
//	ACCOUNT_NAME_HOME_IWEALTH("SRS Account"),
	ACCOUNT_TYPE_IWEALTH("Deposits"),
	ACCOUNT_NAME_HOME_IWEALTH("DBS SAVINGS PLUS"),
	
	//Payee Add Local To Other Bank
	LOCAL_RECIPIENT_NAME("Payee OthersBank 1"),
	LOCAL_RECIPIENT_ACCOUNT_NUMBER("12322560"),
	LOCAL_RECIPIENT_BANK_NAME("BANK OF INDIA"),
	YOU_HAVE_ADDED_RECIPIENT_MSG("You’ve added a recipient"),
	YOU_HAVE_ADDED_RECIPIENT_MSG2("You've added a recipient"),
	YOU_HAVE_ADDED_RECIPIENT_MSG3("added a recipient"),
	
	//Payee Add DBS POSB
	PAYEEADD_DBSPOSB_RECIPIENT_NAME("Payee DBSPOSB"),
	PAYEEADD_DBSPOSB_BANK_NAME("DBS/POSB"),
	PAYEEADD_DBSPOSB_ACCOUNT_NUMBER("0289488348"),
	
	
	//Payee Add to BillPayment
	PAYEEADD_BILLPAYMENT_ACCOUNTNAME("DBS CASHLINE"),
	PAYEEADD_BILLPAYMENT_REFERENCENUMBER("0824867822"),
//	PAYEEADD_BILLPAYMENT_ACCOUNTNAME("CATHOLIC FOUNDATION"),
//	PAYEEADD_BILLPAYMENT_REFERENCENUMBER("34545434"),
	
	//Payee-Add-Remittance **Android**
	COUNTRY_AUS("Australia"),
	COUNTRY_AUS_SEARCH("AUS"),
	CURRENCY_AUS("AUD"),
	BANK_BCD_CODE("610104"),
	ACCOUNT_NO("900132015906"),
	FULL_NAME("Divya"),
	ADDRESS("Cherry Blossom Flower Drive 90 Canbera 123334"),
	CITY("Canbera"),
	
	//Payee-Add-Remittance **IOS**
	ADDRESS_SHORT("Cherry"),
	
	//FundTransfer NonFast/Fast
	FUNDTRANSFER_NONFAST_TO_ACCOUNTNUMBER_WITHBANK("INDIAN OVERSEAS BANK 582177606001"),
	FUNDTRANSFER_NONFAST_FROM_ACCOUNT_NAME("DBS SAVINGS PLUS"),
	FUNDTRANSFER_NONFAST_FROM_ACCOUNT_NAME_iWEALTH("DBS Multiplier Account"),
	FUNDTRANSFER_NONFAST_TO_RECIPIENT_NAME("Sakshi"),
	LOCAL_TRANSFER_PayNow("Local Transfer & PayNow"),
	IMMEDIATE_TEXT("Immediate"),
	COMMENT_NONFAST_TRANSFER("Non Fast"),
	COMMENT_FAST_TRANSFER("Fast"),
	
	//Optional Data for Fund Transfer Non Fast
//	FUNDTRANSFER_NONFAST_TO_ACCOUNTNUMBER_WITHBANK("CITIBANK NA 8484848383"),
//	FUNDTRANSFER_NONFAST_FROM_ACCOUNT_NAME("DBS SAVINGS PLUS"),
//	FUNDTRANSFER_NONFAST_FROM_ACCOUNT_NUMBER("028-9-333112"),
//	FUNDTRANSFER_NONFAST_TO_RECIPIENT_NAME("Citibank"),
	
	
	//FundTransfer Credit Card
	FUNDTRANSFER_CREDITCARD_TO_ACCOUNTNUMBER_WITHBANK("5520-3800-5003-5787"),
	CREDIT_CARDS_TAB("Credit Cards"),
	CREDIT_CARD_PAGEHEADER("Transfer to DBS/POSB Card"),
	FUNDTRANSFER_CREDITCARD_FROM_ACCOUNT_NAME("POSB STATEMENT SAVINGS"),
	REVIEW_PAYMENT_PAGEHEADER("Review Payment"),
	PAYMENT_SUBMITTED("Payment Submitted"),
	FUNDTRANSFER_TOCREDITCARD_NAME("DBS/POSB CREDIT CARDS"),
	FUNDTRANSFER_CREDITCARD_FROM_ACCOUNT_NUMBER("420-86201-6 SGD"),
	FUNDTRANSFER_CREDITCARD_TO_ACCOUNTNUMBER("5520380050035787"),
	CREDIT_CARD_PAGEHEADER_IOS("Pay To DBS/POSB Card"),
	
	
	//FundTransfer BillPayment
	//FUNDTRANSFER_BillPayment_TO_ACCOUNTNUMBER_WITHBANK("0824867822 POSB STATEMENT SAVINGS"),
	FUNDTRANSFER_BillPayment_TO_ACCOUNTNUMBER_WITHBANK("0824867822"),
	BILLING_ORGANISATIONS_TAB("Billing Organisations"),
	PAY_TO_BILLER_PAGE_HEADER("Pay to Biller"),
	AMOUNTTO_TRANSFERFUND("10"),
	
	
	//FundTransferTo OwnAccount
	FUNDTRANSFER_TO_OWN_ACCOUNT_NUMBER("420-86386-1"),
	FUNDTRANSFER_TO_OWN_ACCOUNT_NAME("DBS Multiplier Account"),
	FUNDTRANSFER_FROM_OWN_ACCOUNT_NUMBER("028-976191-5"),
	FUNDTRANSFER_FROM_OWN_ACCOUNT_NAME("DBS SAVINGS PLUS"),
	TRANSFER_TO_YOUR_ACCOUNT("Transfer to Your Account"),
	YOUR_DBSPOSB_ACCOUNTS("Your DBS/POSB Accounts"),
	TRANSFERRED("Transferred"),
	
	//PayNow NRIC
	PROMPT_PAY_MESSAGE("Transfer to Thailand with PromptPay"),
	NRIC_FIN_NUMBER("S0058001E"),
	PAYNOW_NRIC_FIN("Pay Now NRIC"),
	
	//PayNow UEN
	UEN_NUMBER("251286562CM04"),
	PAYNOW_UEN_COMMENT("Pay Now UEN"),
	UEN_REFERENCE_NUMBER("1234"),
	
	//PayNow VPA
	VPA_NUMBER("+6588877705#GRAB"),
	
	//UpdateContact Details
	UPDATE_CONTACT_DETAILS_PAGEHEADER("Update Contact Details"),
	UPDATE_PARTICULARS("Update Particulars"),
	CONTACT_DETAILS_PAGEHEADER("Contact Details"),
	PERSONAL_AND_CONTACTDETAILS_PAGEHEADER("Personal & Contact Details"),
	CONTACT_DETAILS_TITLE("CONTACT DETAILS"),
	EMAIL_NOTES("This email address provided will only be used for your iBanking/mobile banking transactions, eStatement(s) and marketing communication (if any)"),
	CHANGE_BUTTON("CHANGE"),
	PERSONAL_PARTICULARS("PERSONAL PARTICULARS"),
	MARKETING_MESSAGE_TITLES("MARKETING MESSAGES"),
	MARKETING_MESSAGE_NOTES("Please indicate your preference if you would like to opt in or out of receiving DBS/POSB marketing materials and information relating to services and/or products offered or distributed by DBS/POSB and/or its services and product providers."),
	IWOULD_LIKE_THEBANK_TO_MESSAGE("I would like the bank to:"),
	TERMS_AND_CONDITIOINS_MESSAGE("I have read and agree to these important terms."),
	REVIEW_REQUEST_PAGE_HEADER("Review Request"),
	SUCCESSFULLY_UPDATED_MESSAGE("Successfully updated"),
	REQUESTS_SUBMITTED_MESSAGE("Requests submitted"),
	SUCCESSFULLY_SUBMITTED_MESSAGE("Successfully Submitted"),
	
	//PeekBalance
	TOTAL_BALANCE_TITLE("Total Balance"),
	BALANCE_CONTRIBUTION_LIMIT("Balance Contribution Limit"),
	AVAILABLE_BALANCE_TITLE("Available Balance"),
	TOTAL_CONTRIBUTION_TO_DATE("Total Contribution To Date"),
	USER_ACCOUNT_NAME("DBS SAVINGS PLUS"),
	PEEK_BALANCE("Peek Balance"),
	APP_SETTINGS("App Settings"),
	ACCOUNT_FOR_PEEK_BALANCE("Account for Peek Balance"),
	PEEK_BALANCE_DIGIALERT_MSG("You have successfully personalised your digibank profile"),
	PEEK_BALANCE_SUBTITLE("PEEK BALANCE"),
	PEEK_BALANCE_SUBTITLE_IOS("Tap and hold to PEEK BALANCE"),
	PEEK_BALANCE_DEREGISTER_MESSAGE("You will no longer enjoy benefits"),
	//EXISTING_PEEKBALANCE_ENABLE_MESSAGE("Existing Personalisation will be removed. Do you want to proceed?"),
	EXISTING_PEEKBALANCE_ENABLE_MESSAGE("Confirmation Existing Personalization will be removed, Do you want to proceed?"),
	
	
	//Page Headers in Application
	RECIPIENT_DETAILS_PAGEHEADER("Recipient's Details"),
	REVIEW_RECIPIENT_LABEL("REVIEW RECIPIENT'S DETAILS"),
	OVERSEAS_TRANSFER_PAGEHEADER("Overseas Transfer"),
	SET_CARD_PIN("Set Card PIN"),
	ENTER_RECIPIENT_DETAIL("Enter Recipient's Details"),
	
	//App Package And Activity
	DBS_APPS_ACTIVITY("com.dbs.sg.digibank.ui.demo.SplashActivity"),
	DBS_APP_PACKAGE("com.dbs.sit1.dbsmbanking"),
	POSB_APP_PACKAGE("com.dbs.sit1.posbmbanking"),
	IWEALTH_APP_PACKAGE("com.dbs.sg.uat.dbsiwealth"),
	DBS_APP_APK("dbs_android_UAT_7_10_003_532.apk"),
	POSB_APP_APK("POSB_Android.apk"),
	iWEALTH_APP_APK("iwealthandroidUAT_10Nov.apk"),
	
	//Server Details
	N4_SERVER("UAT N4"),
	M2_SERVER("UAT M2"),
	N1_SERVER("UAT N1"),
	N3_SERVER("UAT N3"),
	
	//Log in Application
	DBS_DIGIBANK("DBS digibank"),
	
	//ApplyDebitCard
	DEBIT_CARD_NAME("PASSION POSB MASTERCARD DEBIT CARD"),
	//ACCOUNT_LINKED_WITH_DEBIT_CARD("POSB eSAVINGS"),
	ACCOUNT_LINKED_WITH_DEBIT_CARD("DBS SAVINGS PLUS"),
	TITLE("Ms"),
	RACE("Chinese"),
	MARITAL_STATUS("Single"),
	RESIDENCE_TYPE("HDB"),
	EDUCATION("PSLE"),
	ECONOMIC_STATUS("Professional"),
	ANNUAL_INCOME("S$60,001 - S$90,000"),
	APPLICATION_SUBMITTED("Application Submitted"),
	THANKU_MESSAGE_AFTER_APPLYDEBITCARD("Thank you for your application. Your application is being processed."),
	SECURE_PIN_PAGE_HEADER("Secure PIN"),
	NAMETO_APPEAR_ON_DEBITCARD("DBS Passion"),
	REVIEW_APPLICATION("Review Application"),
	CREATE_PIN("123456"),
	CONFIRM_PIN("123456"),
	EXISTING_ATM_CARD_NUMBER_TOBE_REPLACED("BankCard"),
	
	
	
	//paylah
	TOPUP_LABEL("Top up"),
	PAYLAH_LABEL("Paylah!"),
	TOPUP_PAYLAH_LABEL("Top Up Paylah!"),
	TOPUP_REVIEW_LABEL("Review Top-Up"),
	TOPUP_NOW_BUTTOM_LABEL("TOP UP NOW"),
	TOPUP_UP_DONE_LABEL("Top-up Done"),
	LOGOUT_PAYLAH("Log Out"),
	AMOUNT_PAYLAH("5.00"),
	
	
	// OpenAccount
	OPEN_ACCOUNT_OPTION("POSB SAYE Account"), 
	SELECT_ACCOUNT("DBS SAVINGS PLUS"),
	SELECT_ACCOUNT_iWEALTH("DBS Multiplier Account"),
	OPEN_ACCOUNT("Open Account"),
	ACCOUNT_BENIFITS("Account Benefits"),
	MONTHLY_SAVING_AMT_BALANCE("50"),
	IMPORTANT_NOTES("Important Notes"),
	WARNING_HEADING_TEXT("Advisory from the Singapore Police Force"),
	WARNING("Warning"),
	YOUR_ACCOUNT_OPEN_READYTOUSE_MESSAGE("Your account is open and ready to use!"),
	
	
	//fund transfer to other posbdbs
    SOURCE_ACCOUNT_NAME("DBS SAVINGS PLUS"),
    SOURCE_ACCOUNT_NAME_iWEALTH("DBS Multiplier Account"),
    SOURCE_ACCOUNT_NUMBER("028-6-333121"),
    LOCAL_RECIPIENT_LIST_SELECTED_ACCOUNTNAME("001-992414-6"),
    AMOUNT_FUNDTRANSFER("11"),
    TRANSFER_DBS_POSB("Transfer to DBS/POSB"),
    
	//Relanching alert message
	RELAUNCH_MESSAGE("Your application's security profile has been updated. Please re-launch the application to continue."),
	
	//post login alert message
	FINGERPRINT_MESSAGE("Turn on a few nifty features, such as Fingerprint Login and Peek balance, to improve your experience."),
	RECORDERSECTION_MESSAGE("You can reorder sections on your home page"),
	
	//ScreenName-OneAppPostLogin
	WELCOME("Welcome to"),
	DIGIBANK("digibank"),
	LOGOUT("LOG OUT"),
	
	//ScreenName-Tap on the stars to rate
	RATE_MESSAGE("Tap on the stars to rate"),
	DIGITAL_TOKEN_SETUP_MESSAGE("Set up your Digital Token"),
	EMAIL_OTP_MESSAGE("Step 1: Email OTP"),
	SMS_OTP_MESSAGE("Step 2: SMS OTP"),
	DIGITAL_TOKEN_MESSAGE_AFTER_STEPUP("You've set up your digital token"),
	OTP("123456"),
	

    //Remittance Corridor
    SOURCE_ACCOUNT_NAME_CORRIDOR("DBS SAVINGS PLUS"),
    SOURCE_ACCOUNT_NAME_CORRIDOR_IWEALTH("DBS SAVINGS PLUS"),
	CORRIDOR_AMOUNT("34"),
	PAYEE_NAME_CORRIDOR("testmalaysia"),
	OVERSEA_HEADER("Overseas Transfer"),
	RECIPIENT_HAS_BEEN_UPDATED_MSG("Recipient has been updated"),
	UPDATED_ADDRESS("32nd Floor, Menara Bank Islam, No. 22, Jalan Perak 50450 Kuala Lumpur"),
	UPDATED_CITY("Kuala Lumpur"),
//	UPDATED_ADDRESS("Opp. Bus Stand, 372, Poottai Road Sankarapuram, Sankarapuram"),
//	UPDATED_CITY("Sankarapuram"),
//  PAYEE_NAME_CORRIDOR("ad rec new ajay"),
	
	
	
	//Remittance EOTT
	eOTT_AMOUNT("11.65"),
	TRANSFER_SUBMITTED_MSG("Transfer Submitted"),
	REVIEW_TRANSFER("Review Transfer"),
	REFERENCE_NUMBER_TEXT("Reference No."),
	OVERSEAS_TRANSFER_TEXT("OVERSEAS TRANSFER"),
	PURPOSE_OF_TRANSFER_TEXT("Family support (Workers' remittances)"),
	REVIEW_RECIPIENT_DETAILS("Review Recipient's Details"),
	EOTT_ACCOUNT_TYPE("Savings"),
	MOBILE_NUMBER("9999999990"),
	EOTTREMITTANCE_NAME("testmalaysia"),
	PURPOSE("Gifts to individuals"),
	//PURPOSE("Personal Gifts"),
	//EOTTREMITTANCE_NAME("ad rec new ajay"),// BHDeott
	
	
	//Credit card Limit Increase
	CREDITCARD_LIMITINCREASE_AMOUNT("100"),
	CREDITCARD_LIMITINCREASE_PURPOSE("wedding"),
	TEMP_LIMIT_INCREASE("Temporary Credit Limit Increase"),
	TEMP_LIMIT_INCREASE_SEARCH("Temporary"),
	TEMP_LIMIT_INCREASE_TITLE("Temporary Limit Increase"),
	REVIEW_APPLICATION_CREDITLIMIT_TITLE("Review Application"),
	CALENDER_HEADER("Pick Date"),
	
	
	//Change Local Fund Transfer Limit
	LOCAL_TRANSFER_LIMIT_LABEL("Local Transfer Limit"),
	SELECTED_LIMIT_1("40,000.00"), 
	SELECTED_LIMIT_50000("50,000.00"), 
	SELECTED_LIMIT_0("0.00"),
	SELECTED_LIMIT_500("500.00"),
	LOCAL_TRANSFER_CAHNGE_TITLE("Local Transfer Limit Changed!"), 
	SET_DAILY_LIMIT_TITLE("Set Daily Limit"),
	REVIEW_DAILY_LIMIT_TITLE("Review Daily Limit"),
	CHANGE_DAILY_LIMIT_BUTTON("CHANGE DAILY LIMIT NOW"), 
	LOCAL_LIMIT_INCREASE_SUCCESS_TITLE_IOS("Local Transfer limit Changed!"),
	
	
	//Transaction History
	TRANSCETION_HISTORY_LABEL("Transaction History"),
	//ACCOUNT_NAME("POSB STATEMENT SAVINGS"),
	CURRENCY_NAME("Singapore Dollar"),
	//STATEMENT_TITLE("POSB STATEMENT SAVINGS"),
	SHOW_BUTTON("SHOW"),
	ACCOUNT_NAME("DBS SAVINGS PLUS"),
	//ACCOUNT_NAME_IWEALTH("DBS Multiplier Account"),
	ACCOUNT_NAME_IWEALTH("DBS SAVINGS PLUS"),
	STATEMENT_TITLE("DBS SAVINGS PLUS"),
	TRANSCETION_HISTORY_ACCOUNT_CURRENCY("SGD"),
	
	
	ENTER_RECIPIENT_DETAILS("Enter Recipient's Details"),
	REVIEW_ACCOUNT_APPLICATION("Review Account Application"),
	UPGRADE_EXPERIENCE_MESSAGE("Upgrade your banking experience with us"), 
	SETUP("Let's Set Up"),
	MOTION_FITNESS_MESSAGE("“DBS digibank” Would Like to Access Your Motion & Fitness Activity"),
	
	// ScreenName-OneAppPostLogin
	SGD_CURRENCY_LABEL("SGD"), 
	LOGOT_PAYLAH_IOS("Log Out"), 
	DONE_2FA_IOS("Done"),
	PIN_2FA("123456"),
	

	MORE_LABEL("More"),
	PAY_TRANSFER_ICON("Pay & Transfer"),
	LOCAL_TRANSFER_LIMIT_SEARCHBOX_IOS("local"),
	TO_OTHERBANK_LABEL("To Other Banks"), 
	TRANSFER_TO_OTHERBANK_LABEL_LABEL("Transfer to Other Banks"),
	TRANSFER_TO_OTHERBANK_LABEL("Transfer to Other Banks"),
	ALL_SECTION("ALL"),
	LOCAL_RECIPIENT_FROMLIST("Local Recipients"),
	CREDIT_CARDS("Your DBS/POSB Accounts"),
	DBS_CURRENT_ACCOUNT_TEXT("DBS CURRENT ACCOUNT"),
	//SELECT_SOURCE_FUND("Select Fund Source"),
	PRIMARY_SOURCE_ALERT_TITLE("Primary source of fund"),
	REVIEW_TRANSFER_LABEL("Review Transfer"),
	TRANSFER_NOW_BUTTON("TRANSFER NOW"),
	TRANSFER_TITLE("Transferred"),
	ADD_RECIPIENT_LABEL("ADD RECIPIENT NOW"),
	MAKE_TRANSFER("MAKE A TRANSFER"),
	REFERENCE_NUMBER("Reference No."),
	PURPOSE_HEADER_IOS("Select a Purpose"),
	;
	
	private final String message;

	private CommonTestData(String message) {
		this.message = message;
	}

	public String getEnumValue() throws Exception {
		try {
			if (this.message == null)
				throw new Exception("The Message isn't provided");
			return this.message;
		} catch (Exception e) {
			throw new Exception("CommonTestData::EnumValue() Exception : " + e.getLocalizedMessage());
		}
	}

}
