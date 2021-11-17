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
	RECIPIENT_ADDED("You've added a recipient"),
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
