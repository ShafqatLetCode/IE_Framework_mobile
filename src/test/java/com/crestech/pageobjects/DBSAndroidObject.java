package com.crestech.pageobjects;


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

	/**
	 *
	 * @author Shafqat
	 *DBS Android APPLICATION 1st Page Object.
	 *
	 */
	
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
	    
	    
	    /**
		 *
		 * @author Shafqat
		 *DBS Android APPLICATION Login Page Object.
		 *
		 */
	    
	    
	   // Login button is same as previous page
	   
	    @ElementDescription(value = "User ID EditTexT")
		@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'id/edit_user_id')]")
		private MobileElement userIdEditText;
	 
	    @ElementDescription(value = "User PIN EditTexT")
		@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'id/edit_user_pin')]")
		private MobileElement userPinEditText;
	    
	    public MobileElement userIdEditText() {
			return userIdEditText;
		}
	 
	    public MobileElement userPinEditText() {
			return userPinEditText;
		}

	 

	    /**
		 *
		 * @author Shafqat
		 *DBS Android APPLICATION OneAppPostLogin Page Object.
		 *
		 */
	    
	    
	    @ElementDescription(value = "Welcome to")
		@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'id/banner_text_1')]")
		private MobileElement welcomeTo_Element;
	   
	    @ElementDescription(value = "digbank")
		@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'id/banner_text_2')]")
		private MobileElement digibank_Element;
	 
	    @ElementDescription(value = "Logout Button")
		@AndroidFindBy(xpath = "//android.widget.Button[@text='LOG OUT']")
		private MobileElement logoutButton;
	    
	    public MobileElement WelcomeToText() {
			return welcomeTo_Element;
		}
	 
	    public MobileElement DigibankText() {
			return digibank_Element;
		}

	    public MobileElement logoutButton() {
			return logoutButton;
		}

/******************************************/

		/**
		 * 
		 */

		/**
		 * This is applications alert element (Post Logout)screen-Tap on the stars to rate
		 */
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
			/**
			 * 
			 */
			 /**
			 *
			 * @author Shafqat
			 *DBS Android APPLICATION OneAppPostLogin Page Object.
			 *
			 */
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
				
}