package com.crestech.pageobjects;


import java.util.List;

import com.crestech.annotation.values.ElementDescription;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;;

/**
 *
 * @author Divya
 *This class is used to store the objects of Android Page.
 *
 */

public class DBSAndroidObject {

	    @ElementDescription(value = "Application logo")
		@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,'id/bank_logo')]")
		private MobileElement Logo;
	    
	    @ElementDescription(value = "DBS text")
		@AndroidFindBy(xpath = "//android.widget.TextView[@text='digibank']")
		private MobileElement dbsText;
	    
	    @ElementDescription(value = "PRE LOGIN Button")
		@AndroidFindBy(xpath = "//android.widget.Button[@text='PRE LOGIN']")
		private MobileElement preLoginButton;

	    @ElementDescription(value = "SIGN UP FOR DIGIBANK Button")
	  	@AndroidFindBy(xpath = "//android.widget.Button[@text='SIGN UP FOR DIGIBANK']")
	  	private MobileElement signUpForDigibankButton;
	    
	    @ElementDescription(value = "LOG IN Button")
		@AndroidFindBy(xpath = "//android.widget.Button[@text='LOG IN']")
		private MobileElement loginButton;
	    
	    @ElementDescription(value = "User ID EditTexT")
		@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'id/edit_user_id')]")
		private MobileElement userIdEditText;
	 
	    @ElementDescription(value = "User PIN EditTexT")
		@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'id/edit_user_pin')]")
		private MobileElement userPinEditText;
	    
	    @ElementDescription(value = "Welcome to")
		@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'id/banner_text_1')]")
		private MobileElement welcomeTo_Element;
	   
	    @ElementDescription(value = "digbank")
		@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'id/banner_text_2')]")
		private MobileElement digibank_Element;
	 
	    @ElementDescription(value = "Logout Button")
		@AndroidFindBy(xpath = "//android.widget.Button[@text='LOG OUT']")
		private MobileElement logoutButton;
	    
	    @ElementDescription(value = "Alert Title")
		@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'id/tv_title')]")
		private MobileElement postLogoutAlertTitle;

		@ElementDescription(value = "Alert Message")
		@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'id/tv_star')]")
		private MobileElement postLogoutAlertMessage;

		@ElementDescription(value = "Submit Button")
		@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='SUBMIT']")
		private MobileElement submitButton;

		@ElementDescription(value = "Close Button")
		@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,'id/btn_close')]")
		private MobileElement postLogoutcloseButton;
		
		@ElementDescription(value = "set up your digital token")
		@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'id/status_message')]")
		private MobileElement tokenSetupMessage;

		@ElementDescription(value = "SET UP NOW Button")
		@AndroidFindBy(xpath = "//android.widget.Button[@text='SET UP NOW']")
		private MobileElement setUpNowButton;

		@ElementDescription(value = "Email/SMS OTP Message")
		@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'id/txtv_kht_regcode_header')]")
		private MobileElement emailSmsOtpMessage;

		@ElementDescription(value = "Email/SMS OTP Editbox")
		@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'id/kht_otp_box')]")
		private MobileElement emailSmsOtpEditBox;

		@ElementDescription(value = "You've set up your digital token")
		@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'id/digital_token_msg')]")
		private MobileElement tokenGetSetupMessage;

		@ElementDescription(value = "Done Button")
		@AndroidFindBy(xpath = "//android.widget.Button[@text='DONE']")
		private MobileElement doneButton;
		
	    public MobileElement Logo() {
			return Logo;
		}
	    public String getDbsText() {
			return dbsText.getText();
		}
	    public MobileElement preLoginButton() {
			return preLoginButton;
		}
	    public MobileElement signUpForDigibankButton() {
			return signUpForDigibankButton;
		}
	    public MobileElement loginButton() {
			return loginButton;
		}
	    
	    public MobileElement userIdEditText() {
			return userIdEditText;
		}
	 
	    public MobileElement userPinEditText() {
			return userPinEditText;
		}
	    
	    public MobileElement WelcomeToText() {
			return welcomeTo_Element;
		}
	 
	    public MobileElement DigibankText() {
			return digibank_Element;
		}

	    public MobileElement logoutButton() {
			return logoutButton;
		}

		public MobileElement postLogoutAlertTitle() {
			return postLogoutAlertTitle;
		}

		public MobileElement postLogoutAlertMessage() {
			return postLogoutAlertMessage;
		}

		public MobileElement submitButton() {
			return submitButton;
		}

		public MobileElement postLogoutcloseButton() {
			return postLogoutcloseButton;
		}
		
		public MobileElement tokenSetupMessage() {
			return tokenSetupMessage;
		}

		public MobileElement setUpNowButton() {
			return setUpNowButton;
		}

		public MobileElement emailSmsOtpMessage() {
			return emailSmsOtpMessage;
		}

		public MobileElement emailSmsOtpEditBox() {
			return emailSmsOtpEditBox;
		}

		public MobileElement tokenGetSetupMessage() {
			return tokenGetSetupMessage;
		}

		public MobileElement doneButton() {
			return doneButton;
		}

	/*****************Corridor Remittance******************/	
		@ElementDescription(value = "Pay & Transfer Button")
		@AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Pay & Transfer']")
		private MobileElement PayAndTransferBtn;
		
	    @ElementDescription(value = "2FA Secure Pin Message")
		@AndroidFindBy(xpath = "//android.widget.TextView[@text='An SMS containing the 6-digit SMS Secure PIN has been sent to your mobile. Please key in below']")
		private MobileElement ToFASecurePINMsg;
		
	    
	    @ElementDescription(value = "Passcode Field")
		@AndroidFindBy(xpath = "//android.widget.EditText[@text='••••••']")
		private MobileElement PasscodeField;
	    
	    @ElementDescription(value = "Success Tick Image View")
		@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,':id/imgView_ic_success_tick')]")
		private MobileElement SuccessTickImageView;
	  
	    @ElementDescription(value = "DoneButtonForPasscode")
		@AndroidFindBy(xpath = "//android.widget.Button[@text='Done']")
		private MobileElement DoneButtonForPasscode;
	    
	    @ElementDescription(value = "Add Local Recipien")
		@AndroidFindBy(xpath = "//android.widget.TextView[@text='Add Local Recipient']")
		private MobileElement AddLocalRecipient;
	    
	    @ElementDescription(value = "Overseas Button Text")
		@AndroidFindBy(xpath = "//android.widget.TextView[@text='Overseas']")
		private MobileElement OverseasBtnText;
	    
	    @ElementDescription(value = "Overseas Button")
		@AndroidFindBy(xpath = "//android.widget.LinearLayout[contains(@resource-id,'id/cvActionItem')]")
		private List<MobileElement> Btnlist; // index=3
	    
	    @ElementDescription(value = "Select any one payee from list")
		@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'id/tv_expandable_item_head_title')]")
		private List<MobileElement> PayeeList; // index=2
	    
	    @ElementDescription(value = "Select Fund Source Page")
		@AndroidFindBy(xpath = "//android.widget.TextView[@text='Select Fund Source']")
		private MobileElement SelectFundSourcePage;
	 
	    @ElementDescription(value = "Select Bank Account")
		@AndroidFindBy(xpath = "//android.widget.TextView[@text='Bank Account']")
		private MobileElement SelectBankAccount;
	    
	    @ElementDescription(value = "Search field")
		@AndroidFindBy(xpath = "//android.widget.EditText[@text='Search']")
		private MobileElement SearchField;
	    
	    @ElementDescription(value = "Select Bank OF India")
		@AndroidFindBy(xpath = "//android.widget.RelativeLayout//android.widget.TextView[@text='BANK OF INDIA']")
		private MobileElement SelectBankOFIndia;
	  
	    
	    @ElementDescription(value = "Add Local Recipient Details Field List")
		@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,':id/edit_user_id')]")
		private List<MobileElement> AddLocalRecipientDetailsFieldList; 
	 
	    @ElementDescription(value = "Select any one Fund Source from list")
		@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/account_name')]")
		private List<MobileElement> SourceFundList; 

	    @ElementDescription(value = "Overseas Transfer Page")
		@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/text_title_mfe')]")
		private MobileElement OverseasTransferPage;
	    
	    @ElementDescription(value = "Page Header")
		@AndroidFindBy(xpath = " //android.widget.RelativeLayout//android.widget.TextView[contains(@resource-id,':id/text')]")
		private MobileElement PageHeader;
	 
	    @ElementDescription(value = "Edit Amount Text Fields")
		@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,':id/amountEdit')]")
		private List<MobileElement> AmountTextFields; 
	    
	    @ElementDescription(value = "Next Button")
	  	@AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,':id/btn_remitnext')]")
	  	private MobileElement NextBtn; 
	    
	    @ElementDescription(value = "Review Transfer Page Header")
	  	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/text_title_mfe')]")
	  	private MobileElement ReviewTransferPageHeader; 
	    
	    @ElementDescription(value = "Add Recipient Now Button")
	  	@AndroidFindBy(xpath = "//android.widget.Button[@text='ADD RECIPIENT NOW']")
	  	private MobileElement AddRecipientNowBtn; 
	  
	    @ElementDescription(value = "Transfer Now Button")
	  	@AndroidFindBy(xpath = "//android.widget.Button[@text='TRANSFER NOW']")
	  	private MobileElement TransferNowBtn; 
	    
	    @ElementDescription(value = "Transfer Submitted Message")
	  	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/textViewInfo')]")
	  	private MobileElement TransferSubmittedMsg; 
	    
	    @ElementDescription(value = "You Have Added Recipient Element")
	  	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/text')]")
	  	private MobileElement YouHaveAddedRecipientElement; 
	  
	    @ElementDescription(value = "Image Expand")
	  	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,':id/image_expand')]")
	  	private MobileElement ImageExpand; 
	    
	    @ElementDescription(value = "Reference Number Text")
	  	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Reference No.']")
	  	private MobileElement ReferenceNumberText; 

	    @ElementDescription(value = "Share Transfer Details button Or Track This Transfer Button")
	  	@AndroidFindBy(xpath = "//android.widget.Button[@text='SHARE TRANSFER DETAILS']")
	  	private MobileElement ShareTransferDetailsBtn; 

	    @ElementDescription(value = "Overseas Transfer Message")
	  	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/lable_non_remit_tranfer')]")
	  	private MobileElement OverseasTransferMsg; 
	    
	    @ElementDescription(value = "Exchange Rate Text")
	  	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/exchangerate_view_lbl')]")
	  	private MobileElement ExchangeRateText; 
	    
	    @ElementDescription(value = "TransferSubmittedImage")
	  	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,':id/appCompatImageView')]")
	  	private MobileElement TransferSubmittedImage; 
	    
	    @ElementDescription(value = "iB Secure PIN, key in the numbers below.")
	  	@AndroidFindBy(xpath = "//android.widget.TextView[@text='iB Secure PIN, key in the numbers below.']")
	  	private MobileElement iBSecurePin; 
	    
	    public MobileElement iBSecurePin() {
			return iBSecurePin;
		}
	  
	    public MobileElement TransferSubmittedImage() {
			return TransferSubmittedImage;
		}
	  
	    public MobileElement ExchangeRateText() {
			return ExchangeRateText;
		}
	    
	    public MobileElement PayAndTransferBtn() {
			return PayAndTransferBtn;
		}
	    
	    public MobileElement ToFASecurePINMsg() {
			return ToFASecurePINMsg;
		}
	    
	    public MobileElement PasscodeField() {
			return PasscodeField;
		}
	    
	    public MobileElement SuccessTickImageView() {
			return SuccessTickImageView;
		}
	    
	    public MobileElement DoneButtonForPasscode() {
			return  DoneButtonForPasscode;
		}
	    
	    public MobileElement AddLocalRecipient() {
			return  AddLocalRecipient;
		}
	    
	    public MobileElement OverseasBtnText() {
			return OverseasBtnText;
		}
	    
	    public List<MobileElement> Btnlist() {
			return Btnlist;
		}
	    
	    public List<MobileElement> PayeeList() {
			return PayeeList;
		}
		
	    public MobileElement SelectFundSourcePage() {
			return SelectFundSourcePage;
		}
	    
	    public MobileElement SelectBankAccount() {
			return SelectBankAccount;
		}
	    
	    public List<MobileElement> SourceFundList() {
			return SourceFundList;
		}
	    
	    public List<MobileElement> AddLocalRecipientDetailsFieldList() {
			return AddLocalRecipientDetailsFieldList;
		}
	    
	    public MobileElement OverseasTransferPage() {
			return OverseasTransferPage;
		}
	    
	    public MobileElement SearchField() {
			return SearchField;
		}
	    
	    public MobileElement SelectBankOFIndia() {
			return SelectBankOFIndia;
		}
	    
	    public MobileElement PageHeader() {
			return PageHeader;
		}
	    
	    public List<MobileElement> AmountTextFields() {
			return AmountTextFields;
		}
	    
	    public MobileElement NextBtn() {
			return NextBtn;
		}
		
	    public MobileElement ReviewTransferPageHeader() {
			return ReviewTransferPageHeader;
		}
	    
	    public MobileElement TransferNowBtn() {
			return TransferNowBtn;
		}
	    
	    public MobileElement AddRecipientNowBtn() {
			return AddRecipientNowBtn;
		}
	    
	    public MobileElement TransferSubmittedMsg() {
			return TransferSubmittedMsg;
		}
	    
	    public MobileElement YouHaveAddedRecipientElement() {
			return YouHaveAddedRecipientElement;
		}
	    
	    public MobileElement ImageExpand() {
			return ImageExpand;
		}
		
	    public MobileElement ReferenceNumberText() {
			return ReferenceNumberText;
		}
		
	    public MobileElement ShareTransferDetailsBtn() {
			return ShareTransferDetailsBtn;
		}
		
	    public MobileElement OverseasTransferMsg() {
			return OverseasTransferMsg;
		}
		
	
	/*****************Corridor Remittance******************/
	    /*****************Corridor eOTT******************/	
	    @ElementDescription(value = "ALL TAB")
	  	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc='ALL']/android.widget.TextView")
	  	private MobileElement AllTab; 
	    
	    @ElementDescription(value = "Edit text Search Field")
	  	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,':id/editText_search')]")
	  	private MobileElement editSearchField; 

	    @ElementDescription(value = "BHDeOTT Payee")
	  	@AndroidFindBy(xpath = "//android.widget.TextView[@text='BHDeott']")
	  	private MobileElement BHDeott_Payee; 
	    
	    @ElementDescription(value = "Exchange Rate ICON")
	  	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,'id/ic_exchange')]")
	  	private MobileElement ExchangeRateICON; 
	    
	    @ElementDescription(value = "Select Purpose Of Transfer")
	  	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/text_view_hint_big')]")
	  	private MobileElement SelectPurposeOfTransfer; 
	    
	    @ElementDescription(value = "Fund Transfer Purpose Option")
	  	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Family support')]")
	  	private MobileElement FundTransferPurposeOption; 
	    
	    @ElementDescription(value = "Next Button To Added Local Recipient")
	  	@AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,':id/btn_submit')]")
	  	private MobileElement NextButtonToAddedLocalRecipient;
	    
	    @ElementDescription(value = "Text View Purpose")
	  	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/text_view_purpose')]")
	  	private MobileElement TextViewPurpose; 
	    
	    public MobileElement TextViewPurpose() {
			return TextViewPurpose;
		}
	  
	    public MobileElement FundTransferPurposeOption() {
			return FundTransferPurposeOption;
		}
	    
	    public MobileElement NextButtonToAddedLocalRecipient() {
			return NextButtonToAddedLocalRecipient;
		}
	    
	    public MobileElement SelectPurposeOfTransfer() {
			return SelectPurposeOfTransfer;
		}
	    
	    public MobileElement ExchangeRateICON() {
			return ExchangeRateICON;
		}
	  
	    public MobileElement AllTab() {
			return AllTab;
		}
	    
	    public MobileElement editSearchField() {
			return editSearchField;
		}
	    
	    public MobileElement BHDeott_Payee() {
			return BHDeott_Payee;
		}
	    
	  
	    
	    
	    /*****************Corridor eOTT******************/	
}