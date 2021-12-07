package com.crestech.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import com.crestech.annotation.values.ElementDescription;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

/**
 * 
 * @author Shafkat And Divya
 * 
 *         This class is used to store the objects of IOS Page.
 *
 */
public class DBS_IOSObject {

	public DBS_IOSObject(AppiumDriver<RemoteWebElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
	}

	@ElementDescription(value = "User id EditBox")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='User ID']")
	private MobileElement userIdEditBox;

	@ElementDescription(value = "User Pin EditBox")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='PIN']")
	private MobileElement userPinEditBox;

	@ElementDescription(value = "login Button on 1st page")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='LOG IN']")
	private MobileElement logInButton_1;

	@ElementDescription(value = "login Button on 2nd page")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='LOGIN']")
	private MobileElement logInButton_2;

	@ElementDescription(value = "login Button on 0 page")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Log In']")
	private MobileElement logInButton_0;

	public MobileElement userIdEditBox() {
		return userIdEditBox;
	}

	public MobileElement userPinEditBox() {
		return userPinEditBox;
	}

	public MobileElement logInButton_1() {
		return logInButton_1;
	}

	public MobileElement logInButton_2() {
		return logInButton_2;
	}

	public MobileElement logInButton_0() {
		return logInButton_0;
	}

///fitness activity alert
	@ElementDescription(value = "fitness activity alert")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='“DBS digibank” Would Like to Access Your Motion & Fitness Activity']")
	private MobileElement alertFitnessActivityTitle;

	@ElementDescription(value = "alert ok button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='OK']")
	private MobileElement alertOkButton;

	@ElementDescription(value = "swipe button of alert 'upgrade experience'")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='TravelMode_Close']")
	private MobileElement upgradeSwipeButton;

	@ElementDescription(value = "Title message'upgrade experience'")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Upgrade your banking experience with us']")
	private MobileElement upgradeTitle;

	@ElementDescription(value = "fingureprint alert message")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Let's Set Up']")
	private MobileElement fingerpringAlertMessage;

	@ElementDescription(value = "fingureprint alert closed button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='icon close']")
	private MobileElement fingerpringAlertClosedButton;

	@ElementDescription(value = "recording alert message")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='title']")
	private MobileElement recordingAlertMessage;

	@ElementDescription(value = "fingureprint alert closed button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='introClose']")
	private MobileElement recordingAlertClosedButton;

	public MobileElement alertFitnessActivityTitle() {
		return alertFitnessActivityTitle;
	}

	public MobileElement alertOkButton() {
		return alertOkButton;
	}

	public MobileElement upgradeSwipeButton() {
		return upgradeSwipeButton;
	}

	public MobileElement upgradeTitle() {
		return upgradeTitle;
	}

	public MobileElement fingerpringAlertMessage() {
		return fingerpringAlertMessage;
	}

	public MobileElement fingerpringAlertClosedButton() {
		return fingerpringAlertClosedButton;
	}

	public MobileElement recordingAlertMessage() {
		return recordingAlertMessage;
	}

	public MobileElement recordingAlertClosedButton() {
		return recordingAlertClosedButton;
	}

	/// homepage
	@ElementDescription(value = "'Welcome to' textfield")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Welcome to ']")
	private MobileElement welcomeToText;

	@ElementDescription(value = "'digibank' textfield")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='digibank']")
	private MobileElement digibankText;

	@ElementDescription(value = "logout Button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='logout']")
	private MobileElement logOutButton;

	public MobileElement welcomeToText() {
		return welcomeToText;
	}

	public MobileElement digibankText() {
		return digibankText;
	}

	public MobileElement logOutButton() {
		return logOutButton;
	}

	// postlogout
	@ElementDescription(value = "tap on star field message")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Tap on the stars to rate']")
	private MobileElement tapOnStarMessage;

	public MobileElement tapOnStarMessage() {
		return tapOnStarMessage;
	}

	// topup paylah
	@ElementDescription(value = "pay and transfer button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Pay & Transfer']")
	private MobileElement payAndTransferButton;

	public MobileElement payAndTransferButton() {
		return payAndTransferButton;
	}

	@ElementDescription(value = "More button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='More']")
	private MobileElement moreButton;

	public MobileElement moeButton() {
		return moreButton;
	}

	@ElementDescription(value = "topup button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Top Up']")
	private MobileElement topUpButton;

	public MobileElement topUpButton() {
		return topUpButton;
	}

	@ElementDescription(value = "paylah button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='TopUp_Option_Paylah!_Label']")
	private MobileElement payLahButton;

	public MobileElement payLahButton() {
		return payLahButton;
	}

	@ElementDescription(value = "Top Up PayLah! label")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Top Up PayLah!']")
	private MobileElement topUpPayLahTitle;

	public MobileElement topUpPayLahTitle() {
		return topUpPayLahTitle;
	}

	@ElementDescription(value = "Top up paylah title")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Top Up PayLah!']")
	private MobileElement TopUpPayLahTitle;

	public MobileElement TopUpPayLahTitle() {
		return TopUpPayLahTitle;
	}

	@ElementDescription(value = "SGD currency")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='SGD']")
	private MobileElement sgdCurrency;

	public MobileElement sgdCurrency() {
		return sgdCurrency;
	}

	@ElementDescription(value = "Amount Editbox")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='TopUp_Paylah_Amount_Field']")
	private MobileElement amountEditBox;

	public MobileElement amountEditBox() {
		return amountEditBox;
	}

	@ElementDescription(value = "Next Button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='NEXT']")
	private MobileElement nextButton;

	public MobileElement nextButton() {
		return nextButton;
	}

	@ElementDescription(value = "Review Top Up header")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Review Top-Up']")
	private MobileElement reviewToUpLabel;

	public MobileElement reviewToUpLabel() {
		return reviewToUpLabel;
	}

	@ElementDescription(value = "TopUp Now label")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='TOP UP NOW']")
	private MobileElement topupNowlabel;

	public MobileElement topupNowButtonlabel() {
		return topupNowlabel;
	}
	@ElementDescription(value = "TopUp Now button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='TopUp_Paylah_TOP UP NOW_Button']")
	private MobileElement topupNowButton;

	public MobileElement topupNowButton() {
		return topupNowButton;
	}

	@ElementDescription(value = "TopUp Done Label")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Top-up Done']")
	private MobileElement topupDoneButton;

	public MobileElement topupDoneButton() {
		return topupDoneButton;
	}

	@ElementDescription(value = "downward arror in TopUp Done page")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='icn arrow']")
	private MobileElement downwardArrowInTopUpDonePage;

	public MobileElement downwardArrowInTopUpDonePage() {
		return downwardArrowInTopUpDonePage;
	}

	@ElementDescription(value = "TopUp reference Field")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='TopUp_Paylah_Completion_Reference No._Label']")
	private MobileElement referenceField;

	public MobileElement referenceField() {
		return referenceField;
	}

	@ElementDescription(value = "TopUp reference number")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='TopUp_Paylah_Completion_MB3619478Z52_Label']")
	private MobileElement referenceNumber;

	public MobileElement referenceNumber() {
		return referenceField;
	}

	@ElementDescription(value = "Logout button on paylah")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Log Out']")
	private MobileElement logoutPaylah;

	public MobileElement logoutPaylah() {
		return logoutPaylah;
	}

	// 2fa
	@ElementDescription(value = "Done button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Done']")
	private MobileElement doneButton;

	public MobileElement doneButton() {
		return doneButton;
	}

	@ElementDescription(value = "2FA title")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Secure PIN']")
	private MobileElement title2FA;

	public MobileElement title2FA() {
		return title2FA;
	}

	@ElementDescription(value = "secure textbox")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField")
	private MobileElement secureBox;

	public MobileElement secureBox() {
		return secureBox;
	}

	// search handling
	@ElementDescription(value = "secure icon")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='More']")
	private MobileElement searchIcon;

	public MobileElement searchIcon() {// XCUIElementTypeStaticText[@name='More']
		return searchIcon;
	}

	@ElementDescription(value = "secure box")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSearchField[contains(@name,'Search')]")
	private MobileElement searchBox;

	public MobileElement searchBox() {
		return searchBox;
	}

	@ElementDescription(value = "search Text Element list")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeStaticText")
	private List<MobileElement> searchTextElement;

	public List<MobileElement> searchTextElement() {
		return searchTextElement;
	}

	@ElementDescription(value = "Local transfer limit label")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Local Transfer Limit']")
	private MobileElement localTransferLimitLabel;

	public MobileElement localTransferLimitLabel() {
		return localTransferLimitLabel;
	}

	@ElementDescription(value = "To other bank button ")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='To Other Banks']")
	private MobileElement toOtherBankButton;

	public MobileElement toOtherBankButton() {
		return toOtherBankButton;
	}

	@ElementDescription(value = "To other bank label Title")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Transfers to Other Banks']")
	private MobileElement ToOtherBankLimitTitle;

	public MobileElement ToOtherBankLimitTitle() {
		return ToOtherBankLimitTitle;
	}

	@ElementDescription(value = "'Current Limit' label and button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='localTransfer_dailyLimitView_detailLabel']")
	private MobileElement currentLimitTextButton;

	public MobileElement currentLimitTextButton() {
		return currentLimitTextButton;
	}

	@ElementDescription(value = "'Set daily limit' label title")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='localTransfer_dailyLimitView_detailLabel']")
	private MobileElement setDailyLimitTitle;

	public MobileElement setDailyLimitTitle() {
		return setDailyLimitTitle;
	}

	@ElementDescription(value = "'Review daily limit' label title")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Review Daily Limit']")
	private MobileElement reviewDailyLimitTitle;

	public MobileElement reviewDailyLimitTitle() {
		return reviewDailyLimitTitle;
	}

	@ElementDescription(value = "'change daily limit now' button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='localTransfer_dailyLimitConfirmationView_changeDailyLimitButton']")
	private MobileElement changeLimitNowButton;

	public MobileElement changeLimitNowButton() {
		return changeLimitNowButton;
	}
	
	@ElementDescription(value = "Local button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Local']")
	private MobileElement LocalButton;

	@ElementDescription(value = "Add Local Recipient button")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Add Local Recipient'])[1]")
	private MobileElement AddLocalRecipientButton;

	@ElementDescription(value = "Add Recipient Now button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='ADD RECIPIENT NOW']")
	private MobileElement AddRecipientNowButton;
	
	@ElementDescription(value = "Local Transfer & Pay Now Page Header")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Local Transfer & PayNow']")
	private MobileElement LocalTransferPayNowPageHeader;
	
	@ElementDescription(value = "Select Bank Account")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Bank Account']")
	private MobileElement SelectBankAccount;
	
	@ElementDescription(value = "'Enter Recipient's Details' Page Header")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Enter Recipient's Details']")
	private MobileElement EnterRecipientDetailsPageHeader;
	
	
	@ElementDescription(value = "'Enter recipient's name' Editable Field.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='Enter recipient's name']")
	private MobileElement EnterRecipientNameEditableField;
	
	@ElementDescription(value = "Select Bank Dropdown")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='Select bank']")
	private MobileElement SelectBankDropdown;
	
	@ElementDescription(value = "'Search Bank Name' Field.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSearchField[@name='Search Bank Name']")
	private MobileElement SearchBankNameField;
	
	@ElementDescription(value = "'Enter Account Number Editable' Field.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='Enter account no.']")
	private MobileElement EnterAccountNumberEditField;

	@ElementDescription(value = "'Review Recipient's Details' Page Header")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Review Recipient's Details']")
	private MobileElement ReviewRecipientDetailsPageHeader;
	
	@ElementDescription(value = "'Add Recipient Now' Button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='ADD RECIPIENT NOW']")
	private MobileElement ADDRecipientNowButton;
	
	@ElementDescription(value = "Payee Added Success Image")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage")
	private List<MobileElement> PayeeAddedSuccessImage;
	
	@ElementDescription(value = "You Have Added Recipient Message")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='You've added a recipient'])[1]")
	private MobileElement YouHaveAddedRecipient;
	
	@ElementDescription(value = "Log Out Button After adding Payee")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Log Out']")
	private MobileElement LogoutBtn;
	
	@ElementDescription(value = "'Make A Transfer' Button After adding Payee")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='MAKE A TRANSFER'])[1]")
	private MobileElement makeTransferButton;
	
	@ElementDescription(value = "'Close' Button After adding Payee")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='close']")
	private MobileElement closeButton;
	
	@ElementDescription(value = "'Recipient's Account No.' text dispalying After adding Payee.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Recipient's Account No.']")
	private MobileElement RecipientAccountNo;
	
	@ElementDescription(value = "'Recipient's Bank' text dispalying After adding Payee.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Recipient's Bank']")
	private MobileElement RecipientBankText;
	
	@ElementDescription(value = "'Recipient's Name' text dispalying After adding Payee.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Recipient's Name']")
	private MobileElement RecipientNameText;
	
	@ElementDescription(value = "Added Payee 'i icon' list.")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='i icon'])")
	private List<MobileElement> IiconList;
	
	@ElementDescription(value = "'More Payee Details' three Dot.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='morePayeedetail']")
	private MobileElement MorePayeeDetailDots;
	
	@ElementDescription(value = "'Back' Button to Coming Out Added Payee Detils.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='back']")
	private MobileElement BackBtn;
	
	
	@ElementDescription(value = "'Delete Payee' Button.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Delete Payee']")
	private MobileElement DeletePayeeButton;
	
	@ElementDescription(value = "'Yes' Button.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Yes']")
	private MobileElement YesButton;
	
	@ElementDescription(value = "'Are you sure you want to delete this payee?' Message.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Are you sure you want to delete this payee?']")
	private MobileElement AreYouSureToDeleteThisPayeeMsg;
	
	@ElementDescription(value = "'OK' Button.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='OK']")
	private MobileElement OKButton;
	
	@ElementDescription(value = "'BACK TO HOME' Button.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='BACK TO HOME']")
	private MobileElement BackToHomeButton;
	
	public MobileElement BackToHomeButton() { 
		return BackToHomeButton;
	}
	
	@ElementDescription(value = "'MAKE ANOTHER TRANSFER' Button.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='MAKE ANOTHER TRANSFER']")
	private MobileElement MakeAnotherTransferButton;
	
	public MobileElement MakeAnotherTransferButton() { 
		return MakeAnotherTransferButton;
	}
	
	@ElementDescription(value = "'HOME' Button.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Home']")
	private MobileElement HOMEButton;
	
	public MobileElement HOMEButton() { 
		return HOMEButton;
	}
	
	public MobileElement OKButton() { 
		return OKButton;
	}
	
	public MobileElement DeletePayeeButton() { 
		return DeletePayeeButton;
	}

	public MobileElement YesButton() { 
		return YesButton;
	}
	
	public MobileElement AreYouSureToDeleteThisPayeeMsg() { 
		return AreYouSureToDeleteThisPayeeMsg;
	}
	
	public MobileElement BackBtn() { 
		return BackBtn;
	}
	
	public MobileElement MorePayeeDetailDots() { 
		return MorePayeeDetailDots;
	}
	
	public List<MobileElement> IiconList() { 
		return IiconList;
	}
	
	public MobileElement RecipientAccountNo() { 
		return RecipientAccountNo;
	}
	
	public MobileElement RecipientBankText() { 
		return RecipientBankText;
	}
	
	public MobileElement RecipientNameText() { 
		return RecipientNameText;
	}
	
	public MobileElement closeButton() { 
		return closeButton;
	}
	
	public MobileElement makeTransferButton() { 
		return makeTransferButton;
	}
	
	public MobileElement LogoutBtn() { 
		return LogoutBtn;
	}
	
	
	public MobileElement YouHaveAddedRecipient() { 
		return YouHaveAddedRecipient;
	}
	
	public List<MobileElement> PayeeAddedSuccessImage() { 
		return PayeeAddedSuccessImage;
	}
	
	
	public MobileElement ADDRecipientNowButton() {
		return ADDRecipientNowButton;
	}
	
	public MobileElement ReviewRecipientDetailsPageHeader() {
		return ReviewRecipientDetailsPageHeader;
	}
	
	public MobileElement SelectBankDropdown() {
		return SelectBankDropdown;
	}
	
	public MobileElement SearchBankNameField() {
		return SearchBankNameField;
	}
	
	public MobileElement EnterAccountNumberEditField() {
		return EnterAccountNumberEditField;
	}
	public MobileElement EnterRecipientNameEditableField() {
		return EnterRecipientNameEditableField;
	}
	
	public MobileElement EnterRecipientDetailsPageHeader() {
		return EnterRecipientDetailsPageHeader;
	}
	
	public MobileElement SelectBankAccount() {
		return SelectBankAccount;
	}
	
	public MobileElement LocalTransferPayNowPageHeader() {
		return LocalTransferPayNowPageHeader;
	}
	
	public MobileElement AddRecipientNowButton() {
		return AddRecipientNowButton;
	}
	
	public MobileElement AddLocalRecipientButton() {
		return AddLocalRecipientButton;
	}
	
	public MobileElement LocalButton() {
		return LocalButton;
	}

	@ElementDescription(value = " 'backToMoreButton' button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='BACK TO MORE']")
	private MobileElement backToMoreButton;

	public MobileElement  backToMoreButton() {
		return  backToMoreButton;
	}
	@ElementDescription(value = " 'Local Transfer limit Changed!' Title")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Local Transfer limit Changed!']")
	private MobileElement localTransferLimitChangedTitle;

	public MobileElement  localTransferLimitChangedTitle() {
		return  localTransferLimitChangedTitle;
	}
	@ElementDescription(value = " Overseas button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Overseas']")
	private MobileElement overseasButton;

	public MobileElement  overseasButton() {
		return  overseasButton;
	}
	@ElementDescription(value = " ADD RECIPIENT NOW label")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton)[5]")
	private MobileElement addRecipientNow;

	public MobileElement  addRecipientNow() {
		return  addRecipientNow;
	}
	@ElementDescription(value = "Search for a Location")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSearchField[@name='Search for a Location']")
	private MobileElement searchBoxforLocation;

	public MobileElement  searchBoxforLocation() {
		return  searchBoxforLocation;
	}
	@ElementDescription(value = "country Element list")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell/XCUIElementTypeStaticText)")
	private List<MobileElement> countryList;

	public List<MobileElement> countryList() {
		return countryList;
	}
	@ElementDescription(value = "currency Element list")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell/XCUIElementTypeStaticText)")
	private List<MobileElement> currencyList;

	public List<MobileElement> currencyList() {
		return currencyList;
	}
	@ElementDescription(value = "bank Code")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='addPayee_AUD_BSB_textField']/XCUIElementTypeOther/XCUIElementTypeOther")
	private MobileElement bankCode;

	public MobileElement  bankCode() {
		return  bankCode;
	}
	@ElementDescription(value = "Enter Recipient's Details title")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Enter Recipient')]")
	private MobileElement recipientDetailTitle;

	public MobileElement  recipientDetailTitle() {
		return  recipientDetailTitle;
	}
	@ElementDescription(value = "Enter Recipient's Account no. editbox")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='AddPayeeRecipientDetails_Enter account no.']")
	private MobileElement recipientDetailAccountNumver;

	public MobileElement  recipientDetailAccountNumver() {
		return  recipientDetailAccountNumver;
	}
	@ElementDescription(value = "Enter Recipient's Name editbox")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='AddPayeeRecipientDetails_Enter recipient's full name']")
	private MobileElement recipientDetailAccountName;

	public MobileElement  recipientDetailAccountName() {
		return recipientDetailAccountName;
	}
	@ElementDescription(value = "Enter Recipient's Address editbox")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Full Address']")
	private MobileElement recipientDetailAddress;

	public MobileElement  recipientDetailAddress() {
		return recipientDetailAddress;
	}
	@ElementDescription(value = "Enter Recipient's city editbox")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='In The City Of']")
	private MobileElement recipientDetailcity;

	public MobileElement  recipientDetailCity() {
		return recipientDetailcity;
	}
	@ElementDescription(value = "Review Recipient's Details title")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Review Recipient')]")
	private MobileElement reviewRecipientDetailTitle;

	public MobileElement  reviewRecipientDetailTitle() {
		return  reviewRecipientDetailTitle;
	}
	
	@ElementDescription(value = "You've added a recipient title")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'added a recipient')]")
	private MobileElement addedRecipientTitle;

	public MobileElement  addedRecipientTitle() {
		return  addedRecipientTitle;
	}
	@ElementDescription(value = " expand button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='icn arrow']")
	private MobileElement expandButton;

	public MobileElement  expandButton() {
		return  expandButton;
	}
	@ElementDescription(value = "Reference No.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Reference No.']")
	private MobileElement referenceNo;

	public MobileElement  referenceNo() {
		return  referenceNo;
	}
	@ElementDescription(value = "Reference No. value")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText)[22]")
	private MobileElement referenceNoValue;

	public MobileElement  referenceNoValue() {
		return  referenceNoValue;
	}
	
	@ElementDescription(value = "'All' Tab")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='All']")
	private MobileElement AllTab;

	@ElementDescription(value = "'Amount editable' Field")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='FT_Amount_Field']")
	private MobileElement AmountEditableField;

	@ElementDescription(value = "'Select billing organisation' Dropdown.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='source_account_name']")
	private MobileElement SelectFundSourcePage;
	
	@ElementDescription(value = "'Select Fund Source' Add Button.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='Select billing organisation']")
	private MobileElement SelectBillingOrganisation;
	
	@ElementDescription(value = "'Search for a billing organisation' Edit Field.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSearchField[@name='Search for a billing organisation']")
	private MobileElement SearchForBillingOrganisationField;
	
	@ElementDescription(value = "'Enter reference no.' Edit Field.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='Enter reference no.']")
	private MobileElement EnterReferenceNoEditField;
	
	public MobileElement  EnterReferenceNoEditField() {
		return  EnterReferenceNoEditField;
	}
	
	public MobileElement  SearchForBillingOrganisationField() {
		return  SearchForBillingOrganisationField;
	}
	
	public MobileElement  SelectBillingOrganisation() {
		return  SelectBillingOrganisation;
	}
	
	public MobileElement  SelectFundSourcePage() {
		return  SelectFundSourcePage;
	}
	
	
	public MobileElement  AmountEditableField() {
		return  AmountEditableField;
	}
	
	public MobileElement  AllTab() {
		return  AllTab;
	}
	
	@ElementDescription(value = "All tab list")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeOther/XCUIElementTypeStaticText")
	private List<MobileElement> allTabList;

	public List<MobileElement> allTabList() {
		return localRecipientsList;
	}
@ElementDescription(value = "Local Recipients list")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText")
	private List<MobileElement> localRecipientsList;

	public List<MobileElement> localRecipientsList() {
		return localRecipientsList;
	}
   @ElementDescription(value = "Primary source of fund")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Primary source of fund']")
	private MobileElement primarysourceOfFund;

	public MobileElement  primarysourceOfFund() {
		return  primarysourceOfFund;
	}
	@ElementDescription(value = "ok button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='OK']")
	private MobileElement okButton;

	public MobileElement okButton() {
		return  okButton;
	}

	@ElementDescription(value = "'Credit Card' Fund Transfer page Header")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Pay To DBS/POSB Card']")
	private MobileElement CreditCard_PageHeader;

	public MobileElement CreditCard_PageHeader() {
		return  CreditCard_PageHeader;
	}
	
	@ElementDescription(value = "'Review Payment' page Header")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Review Payment']")
	private MobileElement ReviewPaymentPageHeader;

	@ElementDescription(value = "'Your DBS/POSB Accounts' page Header")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Your DBS/POSB Accounts'])[1]")
	private MobileElement SelectOwnAccount;
	
	public MobileElement SelectOwnAccount() {
		return  SelectOwnAccount;
	}
	
	@ElementDescription(value = "'Transfer to Your Account' page Header")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Transfer to Your Account']")
	private MobileElement TransferToOwnAccountPageHeader;
	
	public MobileElement TransferToOwnAccountPageHeader() {
		return  TransferToOwnAccountPageHeader;
	}
	
	@ElementDescription(value = "'Review Transfer' page Header")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Review Transfer']")
	private MobileElement ReviewTransferPageHeader;
	
	@ElementDescription(value = "'TRANSFER NOW' Button.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='TRANSFER NOW']")
	private MobileElement TRANSFERNOWButton;
	
	
	public MobileElement TRANSFERNOWButton() {
		return  TRANSFERNOWButton;
	}
	
	public MobileElement ReviewTransferPageHeader() {
		return  ReviewTransferPageHeader;
	}
	
	public MobileElement ReviewPaymentPageHeader() {
		return  ReviewPaymentPageHeader;
	}
	
	
	@ElementDescription(value = "Transfer Date Clickable Element.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Immediate']")
	private MobileElement TransferDateTextElement;

	public MobileElement TransferDateTextElement() {
		return  TransferDateTextElement;
	}
	
	@ElementDescription(value = "'Transfer Now' Button.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='TRANSFER NOW']")
	private MobileElement TransferNowButton;

	public MobileElement TransferNowButton() {
		return  TransferNowButton;
	}
	
	@ElementDescription(value = "'Payment Submitted' Message.")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Payment Submitted'])[1]")
	private MobileElement PaymentSubmittedMsg;

	public MobileElement PaymentSubmittedMsg() {
		return  PaymentSubmittedMsg;
	}
	
	@ElementDescription(value = "'SHARE PAYMENT DETAILS' Button.")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='SHARE PAYMENT DETAILS'])[1]")
	private MobileElement SharePaymentDetailsButton;
	
	@ElementDescription(value = "'MAKE ANOTHER PAYMENT' Button.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='MAKE ANOTHER PAYMENT']")
	private MobileElement MakeAnotherPaymentBtn;
	
	@ElementDescription(value = "'MAKE ANOTHER PAYMENT' Button.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='arrowDown']")
	private MobileElement FooterExpandableBtn;
	
	@ElementDescription(value = "'Add Billing Organisation' Button.")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Add Billing Organisation'])[1]")
	private MobileElement AddBillingOrganisation;
	
	@ElementDescription(value = "'Bills' Button.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Bills']")
	private MobileElement BillsButton;

	
	@ElementDescription(value = "'Payee Bill Payment Details List'.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell//XCUIElementTypeStaticText")
	private List<MobileElement> PayeeBillPaymentDetailsList;
	
	@ElementDescription(value = "'MAKE A PAYMENT' Button.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='MAKE A PAYMENT']")
	private MobileElement MakeAPaymentButton;
	
	public MobileElement MakeAPaymentButton() { 
		return  MakeAPaymentButton;
	}
	
	@ElementDescription(value = "'Transferred' Message.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Transferred']")
	private MobileElement TransferredMsg;
	
	public MobileElement TransferredMsg() { 
		return  TransferredMsg;
	}
	
	
	@ElementDescription(value = "'Pay To Biller' Page Header.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Pay to Biller']")
	private MobileElement PayToBillerPageHeader;
	
	@ElementDescription(value = "'Cards' Button.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Cards']")
	private MobileElement CardsButton;
	
	public MobileElement CardsButton() { 
		return  CardsButton;
	}
	
	@ElementDescription(value = "'Debit Card Dropdown list'.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell//XCUIElementTypeStaticText")
	private List<MobileElement> DebitCardDetailsDropdownList;
	
	public List<MobileElement> DebitCardDetailsDropdownList() { 
		return  DebitCardDetailsDropdownList;
	}
	
	@ElementDescription(value = "'Debit Card' Button.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Debit Card]")
	private MobileElement SelectDebitCard;
	
	@ElementDescription(value = "'Account to be linked to the card' Dropdown.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Account to be linked to the card']/XCUIElementTypeOther")
	private MobileElement AccountToBeLinkedToTheCardField;
	
	
	@ElementDescription(value = "'Send me DBS Promotion via Email' Checkbox.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Email']")
	private MobileElement SendMeDBSPrmotionViaMail;
	
	public MobileElement SendMeDBSPrmotionViaMail() { 
		return  SendMeDBSPrmotionViaMail;
	}
	
	@ElementDescription(value = "'Annual Income' Dropdown.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Annual Income']/XCUIElementTypeOther")
	private MobileElement AnnualIncomeField;
	
	public MobileElement AnnualIncomeField() { 
		return  AnnualIncomeField;
	}
	
	@ElementDescription(value = "'Title' Dropdown.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Title']/XCUIElementTypeOther")
	private MobileElement TitleField;
	
	@ElementDescription(value = "'nameOnCard' Field.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='nameOnCard']/XCUIElementTypeOther")
	private MobileElement EnterNameToAppearOnTheCardField;
	
	@ElementDescription(value = "'Race' Dropdown.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Race']/XCUIElementTypeOther")
	private MobileElement RaceField;
	
	@ElementDescription(value = "'Marital Status' Dropdown.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Marital Status']/XCUIElementTypeOther/XCUIElementTypeTextField")
	private MobileElement MaritalStatusField;
	
	@ElementDescription(value = "'Residence Type' Dropdown.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Residence Type']/XCUIElementTypeOther")
	private MobileElement ResidentialTypeField;
	
	@ElementDescription(value = "'Education' Dropdown.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Education']/XCUIElementTypeOther")
	private MobileElement EducationField;
	
	@ElementDescription(value = "'Economic Status' Dropdown.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Economic Status']/XCUIElementTypeOther")
	private MobileElement EconomicStatusField;
	
	@ElementDescription(value = "'Review Application' Page Header.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Review Application']")
	private MobileElement ReviewApplicationPageHeader;
	
	@ElementDescription(value = "'Set Card PIN' Page Header.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Set Card PIN']")
	private MobileElement SetCardPINPageHeader;
	
	@ElementDescription(value = "'Create Your PIN' Page Header.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Create Your PIN']")
	private MobileElement CreateYourPINField;
	
	@ElementDescription(value = "'Confirm New PIN' Page Header.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Confirm New PIN']")
	private MobileElement ConfirmNewPINField;
	
	@ElementDescription(value = "'Submit' Button.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='SUBMIT']")
	private MobileElement submitButton;
	
	@ElementDescription(value = "'Application Submitted' Message.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Application Submitted']")
	private MobileElement ApplicationSubmittedMessage;
	
	@ElementDescription(value = "'BACK TO MORE SERVICES' Button.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='BACK TO MORE SERVICES']")
	private MobileElement BackToMoreServicesButton;
	
	@ElementDescription(value = "'Thank you for your application. Your application is being processed.' Message.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Thank you for your application. Your application is being processed.']")
	private MobileElement ThankYouMessage;
	
	public MobileElement ThankYouMessage() { 
		return  ThankYouMessage;
	}	
	
	public MobileElement BackToMoreServicesButton() { 
		return  BackToMoreServicesButton;
	}		
	
	public MobileElement ApplicationSubmittedMessage() { 
		return  ApplicationSubmittedMessage;
	}
	
	public MobileElement submitButton() { 
		return  submitButton;
	}
	
	public MobileElement CreateYourPINField() { 
		return  CreateYourPINField;
	}

	public MobileElement ConfirmNewPINField() { 
		return  ConfirmNewPINField;
	}
	
	public MobileElement SetCardPINPageHeader() { 
		return  SetCardPINPageHeader;
	}
	
	public MobileElement ReviewApplicationPageHeader() { 
		return  ReviewApplicationPageHeader;
	}
	
	public MobileElement TitleField() { 
		return  TitleField;
	}
	
	public MobileElement EnterNameToAppearOnTheCardField() { 
		return  EnterNameToAppearOnTheCardField;
	}
	
	public MobileElement RaceField() { 
		return  RaceField;
	}
	
	public MobileElement MaritalStatusField() { 
		return  MaritalStatusField;
	}
	
	
	public MobileElement ResidentialTypeField() { 
		return  ResidentialTypeField;
	}
	
	public MobileElement EducationField() { 
		return  EducationField;
	}
	
	public MobileElement EconomicStatusField() { 
		return  EconomicStatusField;
	}
	
	public MobileElement AccountToBeLinkedToTheCardField() { 
		return  AccountToBeLinkedToTheCardField;
	}
	
	public MobileElement SelectDebitCard() { 
		return  SelectDebitCard;
	}
	
	
	public MobileElement PayToBillerPageHeader() { 
		return  PayToBillerPageHeader;
	}
	
	public List<MobileElement> PayeeBillPaymentDetailsList() { 
		return  PayeeBillPaymentDetailsList;
	}
	
	public MobileElement BillsButton() {
		return  BillsButton;
	}
	
	public MobileElement AddBillingOrganisation() {
		return  AddBillingOrganisation;
	}
	
	public MobileElement FooterExpandableBtn() {
		return  FooterExpandableBtn;
	}
	
	public MobileElement MakeAnotherPaymentBtn() {
		return  MakeAnotherPaymentBtn;
	}
	
	public MobileElement SharePaymentDetailsButton() {
		return  SharePaymentDetailsButton;
	}
	
	
	
	
	
	
}
