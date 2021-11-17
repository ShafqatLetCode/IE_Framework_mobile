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
			   /**
				 * 
				 */
				 /**
				 *
				 * @author Shafqat
				 *DBS Android APPLICATION button and text on home page- pay&transfer, home, more
				 *
				 */
			   @ElementDescription(value = "Pay & Transfer Label")
				@AndroidFindBy(xpath = "//android.widget.TextView[@text='Pay & Transfer']")
				private MobileElement payAndTransferLabel;
			  
			  @ElementDescription(value = "Pay & Transfer button")
				@AndroidFindBy(xpath = "//android.widget.FrameLayout[contains(@resource-id,'id/action_pay_transfer')]")
				private MobileElement payAndTransferButton;
			  
			  public MobileElement payAndTransferLabel() {
					return payAndTransferLabel;
				}
			   public MobileElement payAndTransferButton() {
					return payAndTransferButton;
			   }
			   /**
				 * 
				 */
				 /**
				 *
				 * @author Shafqat
				 *DBS Android APPLICATION of screen- pay&transfer
				 *
				 */
			   @ElementDescription(value = "overseas Label")
				@AndroidFindBy(xpath = "//android.widget.TextView[@text='Overseas']")
				private MobileElement overseasLabel;
			  
			  @ElementDescription(value = "overseas button")
				@AndroidFindBy(xpath = "(//android.widget.LinearLayout[contains(@resource-id,'id/cvActionItem')])[4]")
				private MobileElement overseasButton;
			  
			  
			  
			  public MobileElement overseasLabel() {
					return overseasLabel;
				}
			   public MobileElement overseasButton() {
					return overseasButton;
			   }
			   
			   @ElementDescription(value = "Top up Label")
				@AndroidFindBy(xpath = "//android.widget.TextView[@text='Top up']")
				private MobileElement topUpLabel;
			   
			   @ElementDescription(value = "Top up button")
				@AndroidFindBy(xpath = "(//android.widget.LinearLayout[contains(@resource-id,'id/cvActionItem')])[8]")
				private MobileElement topUpButton;
			  
			   public MobileElement topUpLabel() {
					return topUpLabel;
				}
			   public MobileElement topUpButton() {
					return topUpButton;
			   }
			   /**
				 * 
				 */
				 /**
				 *
				 * @author Shafqat
				 *DBS Android APPLICATION of screen- Add reciepent
				 *
				 */
				
			  
			   
			   @ElementDescription(value = "Overseas Transfer Label")
				@AndroidFindBy(xpath = "//android.widget.TextView[@text='Overseas Transfer']")
				private MobileElement overseasTransferLabel;
			   
			   
			   @ElementDescription(value = "Add Recipient Now button")
				@AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'add_recipient')]")
				private MobileElement addRecipientNowButton;
			   
			   public MobileElement addRecipientNowButton() {
					return addRecipientNowButton;
			   }
			   
			   public MobileElement overseasTransferLabel() {
					return overseasTransferLabel;
			   }
			   /**
				 * 
				 */
				 /**
				 *
				 * @author Shafqat
				 *DBS Android APPLICATION  screen- select currency
				 *
				 */
			   @ElementDescription(value = "Select Location Label")
				@AndroidFindBy(xpath = "//android.widget.TextView[@text='Select Location']")
				private MobileElement selectLocationLabel;
			   
			   @ElementDescription(value = "Search for a Location")
				@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'id/editText_search')]")
				private MobileElement countryAutocompleteSearchBox;
			   
			   @ElementDescription(value = "List of element of country")
				@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'single_list_item')]")
				private List<MobileElement> countryList;
			   
			   @ElementDescription(value = "clickable element corresponding to list of country")
				@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup")
				private List<MobileElement> countryclickableList;
			   
			   public List<MobileElement> countryList(){
					return  countryList;
			   }
			   
			   public List<MobileElement> countryclickableList(){
					return  countryclickableList;
			   }
			   public MobileElement  locationAutocompleteSearchBox() {
					return  countryAutocompleteSearchBox;
			   }
			   
			   public MobileElement selectLocationLabel() {
					return selectLocationLabel;
			   }
			   /**
				 * 
				 */
				 /**
				 *
				 * @author Shafqat
				 *DBS Android APPLICATION  screen- currency type
				 *
				 */
			   
			   @ElementDescription(value = "currency Label")
				@AndroidFindBy(xpath = "//android.widget.RadioButton[contains(@resource-id,'iid/rb_inr')]")//
				private MobileElement currencyLabel;
			   
			   @ElementDescription(value = "Next button")
				@AndroidFindBy(xpath = "//android.widget.Button[@text='NEXT']")
				private MobileElement nextButton;
			   
			   public MobileElement currencyLabel() {
					return currencyLabel;
			   }
			   
			   public MobileElement nextButton() {
					return nextButton;
			   }
			   /**
				 * 
				 */
				 /**
				 *
				 * @author Shafqat
				 *DBS Android APPLICATION  screen- enter details
				 *
				 */
			   @ElementDescription(value = "Enter Bank Details")
				@AndroidFindBy(xpath = "//android.widget.TextView[@text='Enter Bank Details']")
				private MobileElement enterDetailsLabel;
			   
			   @ElementDescription(value = "Enter Bank code TextField")
				@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'id/editText_search')]")
				private MobileElement enterBankcodeTextField;
			   
			   public MobileElement enterDetailsLabel() {
					return enterDetailsLabel;
			   }
			   public MobileElement enterBankcodeTextField() {
					return enterBankcodeTextField;
			   }
			   
			   // use above next button
			   
			   /**
				 * 
				 */
				 /**
				 *
				 * @author Shafqat
				 *DBS Android APPLICATION  screen- recipient details
				 *
				 */
			   @ElementDescription(value = "RECIPIENT'S ACCOUNT DETAILS label")
				@AndroidFindBy(xpath = "//android.widget.TextView[@text='RECIPIENT'S ACCOUNT DETAILS']")
				private MobileElement recipientAccountDetailLabel;
			   
			   @ElementDescription(value = "Enter RECIPIENT'S ACCOUNT DETAILS TextBox")
				@AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter account no.']")
				private MobileElement recipientAccountNoEditBox;
			   
			   @ElementDescription(value = "Enter recipient's full name TextBox")
				@AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter recipient's full name']")
				private MobileElement recipientNameEditBox;
			   
			   @ElementDescription(value = "Enter Full Address TextBox")
				@AndroidFindBy(xpath = "//android.widget.EditText[@text='Full Address']")
				private MobileElement recipientAddressEditBox;
			   
			   @ElementDescription(value = "Enter City TextBox")
				@AndroidFindBy(xpath = "//android.widget.EditText[@text='In the City of']")
				private MobileElement recipientCityEditBox;
			   
			   //next buuton from above
			   public MobileElement recipientAccountDetailLabel() {
					return recipientAccountDetailLabel;
			   }
			   public MobileElement recipientAccountNoEditBox() {
					return recipientAccountNoEditBox;
			   }
			   public MobileElement recipientNameEditBox() {
					return recipientNameEditBox;
			   }
			   public MobileElement recipientAddressEditBox() {
					return recipientAddressEditBox;
			   }
			   public MobileElement recipientCityEditBox() {
					return recipientCityEditBox;
			   }
			   /**
				 * 
				 */
				 /**
				 *
				 * @author Shafqat
				 *DBS Android APPLICATION  screen- recipient review details
				 *
				 */
			   @ElementDescription(value = "RECIPIENT'S ACCOUNT DETAILS label")
				@AndroidFindBy(xpath = "//android.widget.TextView[@text='REVIEW RECIPIENT'S DETAILS']")
				private MobileElement recipientReviewDetailLabel;
			   
			   @ElementDescription(value = "List of Title")
				@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'id/tv_title')]")
				private List<MobileElement> reviewTitleList;
			   
			   @ElementDescription(value = "List of Title Field")
				@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'id/tv_value')]")
				private List<MobileElement> reviewTitleFieldList;
			   
			   @ElementDescription(value = "ADD RECIPIENT NOW button")
				@AndroidFindBy(xpath = "//android.widget.Button[@text='ADD RECIPIENT NOW']")
				private MobileElement addRecpientNowButton;
			   
			   public List<MobileElement> reviewTitleList(){
					return  reviewTitleList;
			   }
			   
			   public List<MobileElement> reviewTitleFieldList(){
					return  reviewTitleFieldList;
			   }
			   public MobileElement recipientReviewDetailLabel() {
					return recipientReviewDetailLabel;
			   }
			   public MobileElement addRecpientNowButton() {
					return addRecpientNowButton;
			   }
			   /**
				 * 
				 */
				 /**
				 *
				 * @author Shafqat
				 *DBS Android APPLICATION  screen- recipient review details
				 *
				 */
			   @ElementDescription(value = "You've added a recipient label")
				@AndroidFindBy(xpath = "//android.widget.TextView[@text='You've added a recipient']")
				private MobileElement recipientaddedLabel;
			   
			   @ElementDescription(value = "MAKE A TRANSFER")
				@AndroidFindBy(xpath = "//android.widget.Button[@text='MAKE A TRANSFER']")
				private MobileElement makeTransferButton;
			   
			   @ElementDescription(value = "expand button")
				@AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'id/image_expand')]")
				private MobileElement expandButton;
			   
			   @ElementDescription(value = "Reference No. label")
				@AndroidFindBy(xpath = "//android.widget.TextView[@text='Reference No.']")
				private MobileElement referenceNoLabel;
			   
			   @ElementDescription(value = "Reference No. value")
				@AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'id/tv_value')]")
				private MobileElement referenceNoValue;
			   
			   public MobileElement recipientaddedLabel() {
					return recipientaddedLabel;
			   }
			   public MobileElement makeTransferButton() {
					return makeTransferButton;
			   }
			   public MobileElement expandButton() {
					return expandButton;
			   }
			   public MobileElement referenceNoLabel() {
					return referenceNoLabel;
			   }
			   public MobileElement referenceNoValue() {
					return referenceNoValue;
			   }
			   /**
				 * 
				 */
				 /**
				 *
				 * @author Shafqat
				 *DBS Android Paylah topup screen
				 *
				 */
			   @ElementDescription(value = "Paylah! label")
				@AndroidFindBy(xpath = "//android.widget.TextView[@text='Paylah!']")
				private MobileElement paylahLabel;
			   
			   @ElementDescription(value = "Paylah! button")
				@AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'id/topupPaylah')]")
				private MobileElement paylahButton;
			   
			   public MobileElement paylahLabel() {
					return paylahLabel;
			   }
			   public MobileElement paylahButton() {
					return paylahButton;
			   }
			   
			   @ElementDescription(value = "Top Up Paylah! label")
				@AndroidFindBy(xpath = "//android.widget.TextView[@text='Top Up Paylah!']")
				private MobileElement topUpPaylahLabel;
			   
			   @ElementDescription(value = "Currency edittext box")
				@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'id/currencyText')]")
				private MobileElement currencyTextBox;
			   
			  // use next button from above
			   @ElementDescription(value = "Review Top up label")
				@AndroidFindBy(xpath = "//android.widget.TextView[@text='Review Top-Up']")
				private MobileElement reviewTopUpLabel;
			   
			   
			   @ElementDescription(value = "Amount display for Topup")
				@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'id/card_amount')]")
				private MobileElement displayAmount;
			   
			   @ElementDescription(value = "TOP UP NOW button")
				@AndroidFindBy(xpath = "//android.widget.Button[@text='TOP UP NOW']")
				private MobileElement topUpNowButton;
			   
			   @ElementDescription(value = "Top up done label")
				@AndroidFindBy(xpath = "//android.widget.TextView[@text='Top-up Done']")
				private MobileElement topUpDoneLabel;
			   
			   @ElementDescription(value = "Logout button paylah page")
				@AndroidFindBy(xpath = "//android.widget.Button[@text='Log Out']")
				private MobileElement logOutPaylahButton;
			   
			   public MobileElement topUpPaylahLabel() {
					return topUpPaylahLabel;
			   }
			   public MobileElement currencyTextBox() {
					return currencyTextBox;
			   }
			   public MobileElement reviewTopUpLabel() {
					return reviewTopUpLabel;
			   }
			   public MobileElement displayAmount() {
					return displayAmount;
			   }
			   public MobileElement topUpNowButton() {
					return topUpNowButton;
			   }
			   public MobileElement topUpDoneLabel() {
					return topUpDoneLabel;
			   }
			   public MobileElement logOutPaylahButton() {
					return logOutPaylahButton;
			   }
}