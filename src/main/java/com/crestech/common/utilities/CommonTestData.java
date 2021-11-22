package com.crestech.common.utilities;

public enum CommonTestData {
	
	
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
	
	//Payee-Add-Remittance
	PAY_TRANSFER_ICON("Pay & Transfer"),
	OVERSEAS_ICON("Overseas"),
	ADD_RECIPIENT_LABEL("ADD RECIPIENT NOW"),
	COUNTRY_AUS("Australia"),
	CURRENCY_AUS("AUD"),
	BANK_BCD_CODE("610104"),
	ACCOUNT_NO("900132012904"),
	FULL_NAME("AUTOAUS4"),
	ADDRESS("Cherry Blossom Flower Drive 90 Canbera 123334"),
	CITY("Canbera"),
	REVIEW_RECIPIENT_LABEL("REVIEW RECIPIENT'S DETAILS"),
	ADD_NOW_RECIPIENT_LABEL("ADD RECIPIENT NOW"),
	MAKE_TRANSFER("MAKE A TRANSFER"),
	REFERENCE_NUMBER("Reference No."),
	
    //paylah
	TOPUP_LABEL("Top up"),
	PAYLAH_LABEL("Paylah!"),
	TOPUP_PAYLAH_LABEL("Top Up Paylah!"),
	TOPUP_REVIEW_LABEL("Review Top-Up"),
	TOPUP_NOW_BUTTOM_LABEL("TOP UP NOW"),
	TOPUP_UP_DONE_LABEL("Top-up Done"),
	LOGOUT_PAYLAH("Log Out"),
	AMOUNT_PAYLAH("5"),
	CORRIDOR_AMOUNT("34"),
	eOTT_AMOUNT("11.65"),
	TRANSFER_SUBMITTED_MSG("Transfer Submitted"),
	REVIEW_TRANSFER("Review Transfer"),
	REFERENCE_NUMBER_TEXT("Reference No."),
	OVERSEAS_TRANSFER_TEXT("OVERSEAS TRANSFER"),
	DBS_APPS_ACTIVITY("com.dbs.sg.digibank.ui.demo.SplashActivity"),
	DBS_APP_PACKAGE("com.dbs.sit1.dbsmbanking"),
	POSB_APP_PACKAGE("com.dbs.sit1.posbmbanking"),
	IWEALTH_APP_PACKAGE("com.dbs.sg.uat.dbsiwealth"),
	EOTT_PAYEE("BHDeott"),
	OVERSEAS_TRANSFER_PAGEHEADER("Overseas Transfer"),
	LOCAL_TRANSFER_PayNow("Local Transfer & PayNow"),
	PURPOSE_OF_TRANSFER_TEXT("Family support (Workers' remittances)"),
	LOCAL_RECIPIENT_NAME("DBS2"),
	LOCAL_RECIPIENT_ACCOUNT_NUMBER("123223344"),
	BANK_NAME("Bank Of India"),
	REVIEW_RECIPIENT_DETAILS("Review Recipient's Details"),
	SECURE_PIN_PAGE_HEADER("Secure PIN"),
	YOU_HAVE_ADDED_RECIPIENT_MSG("You’ve added a recipient"),
	MORE_ICON("More"),
	NAMETO_APPEAR_ON_DEBITCARD("DBS Passion"),
	REVIEW_APPLICATION("Review Application"),
	SET_CARD_PIN("Set Card PIN"),
	CREATE_PIN("123456"),
	CONFIRM_PIN("123456"),
	ENTER_RECIPIENT_DETAILS("Enter Recipient's Details"),
	DBS_CASHLINE("DBS CASHLINE"),
	REFERENCENUMBER_DBS_CASHLINE("0824867822"),
	PAY_TO_BILLER_PAGE_HEADER("Pay to Biller"),
	AMOUNT_FOR_BILL_ORGANIZATION_PAYMENT("10"),
	REVIEW_PAYMENT_PAGEHEADER("Review Payment"),
	PAYMENT_SUBMITTED("Payment Submitted"),
	OPEN_ACCOUNT("Open Account"),
	ACCOUNT_BENIFITS("Account Benefits"),
	MONTHLY_SAVING_AMT_BALANCE("50"),
	IMPORTANT_NOTES("Important Notes"),
	WARNING_HEADING_TEXT("Warning Advisory from the Singapore Police Force"),
	REVIEW_ACCOUNT_APPLICATION("Review Account Application"),
	YOUR_ACCOUNT_OPEN_READYTOUSE_MESSAGE("Your account is open and ready to use!"),
	APPLICATION_SUBMITTED("Application Submitted"),
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
