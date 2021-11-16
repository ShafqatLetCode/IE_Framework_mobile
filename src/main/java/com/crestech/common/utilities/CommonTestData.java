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
	
	//data for handling digital token
	DIGITAL_TOKEN_SETUP_MESSAGE("Set up your Digital Token"),
	EMAIL_OTP_MESSAGE("Step 1: Email OTP"),
	SMS_OTP_MESSAGE("Step 2: SMS OTP"),
	DIGITAL_TOKEN_MESSAGE_AFTER_STEPUP("You've set up your digital token"),
	OTP("123456"),
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
