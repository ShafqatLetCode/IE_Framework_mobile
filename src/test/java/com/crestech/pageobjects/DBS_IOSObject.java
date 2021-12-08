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
 * @author Shibu Prasad Panda
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
	@ElementDescription(value = " ADD RECIPIENT NOW button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='ADD RECIPIENT NOW']")
	private MobileElement addRecipientNowButton;

	public MobileElement  addRecipientNowButton() {
		return  addRecipientNowButton;
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
	@ElementDescription(value = "MAKE A TRANSFER button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='MAKE A TRANSFER']")
	private MobileElement makeTransfer;

	public MobileElement  makeTransfer() {
		return  makeTransfer;
	}
	////transection history label
	
	
	
	@ElementDescription(value = "Transaction History label and button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Transaction History']")
	private MobileElement transactionHistoryBtnLabel;

	public MobileElement  transactionHistoryBtnLabel() {
		return  transactionHistoryBtnLabel;
	}
	@ElementDescription(value = "3 month option")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='3 Months']")
	private MobileElement threeMonthOption;

	public MobileElement  threeMonthOption() {
		return  threeMonthOption;
	}
	@ElementDescription(value = "show button")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='SHOW'])[1]")
	private MobileElement showButton;

	public MobileElement  showButton() {
		return  showButton;
	}
	@ElementDescription(value = "deposite option")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='fe'])[1]")
	private MobileElement depositeOption;

	public MobileElement  depositeOption() {
		return  depositeOption;
	}
	@ElementDescription(value = "Account list in transaction history")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText[1]")
	private List<MobileElement> accountListinTransectionHistory;

	public List<MobileElement> accountListinTransectionHistory() {
		return accountListinTransectionHistory;
	}
	@ElementDescription(value = "select currency title")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Select Currency']")
	private MobileElement selectCurrencyTitle;

	public MobileElement  selectCurrencyTitle() {
		return  selectCurrencyTitle;
	}
	@ElementDescription(value = "currency list in transaction history")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText")
	private List<MobileElement> currencyListinTransectionHistory;

	public List<MobileElement> currencyListinTransectionHistory() {
		return currencyListinTransectionHistory;
	}
	@ElementDescription(value = "Transaction History final title")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[1])[2]")
	private MobileElement transactionHistoryfinalheaderTitle;

	public MobileElement  transactionHistoryfinalheaderTitle() {
		return  transactionHistoryfinalheaderTitle;
	}
	@ElementDescription(value = "transaction history list")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText[2])[2]")
	private List<MobileElement> transectionHistoryList;

	public List<MobileElement> transectionHistoryList() {
		return transectionHistoryList;
	}
	@ElementDescription(value = "close button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='ic close']")
	private MobileElement closeButton;

	public MobileElement  closeButton() {
		return  closeButton;
	}
	@ElementDescription(value = "back button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='back']")
	private MobileElement backButton;

	public MobileElement  backButton() {
		return  backButton;
	}
	@ElementDescription(value = "Home button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Home']")
	private MobileElement homeButton;

	public MobileElement homeButton() {
		return  homeButton;
	}
	///fund transfer to posb dbs
	@ElementDescription(value = "All tab")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='All']")
	private MobileElement allTab;

	public MobileElement allTab() {
		return  allTab;
	}
	@ElementDescription(value = "Local Recipients")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Local Recipients'])[1]")
	private MobileElement localRecipients;

	public MobileElement localRecipients() {
		return  localRecipients;
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
	@ElementDescription(value = "Select Fund Source")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Select Fund Source']")
	private MobileElement selectfundSource;

	public MobileElement  selectfundSource() {
		return  selectfundSource;
	}
	@ElementDescription(value = "Select Fund Source list")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText")
	private List<MobileElement> selectfundSourceList;

	public List<MobileElement> selectfundSourceList() {
		return selectfundSourceList;
	}
	@ElementDescription(value = "SGD field")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='SGD'])[2]")
	private MobileElement sgdText;

	public MobileElement  sgdText() {
		return  sgdText;
	}
	@ElementDescription(value = "Amount field")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='FT_Amount_Field']")
	private MobileElement amountField;

	public MobileElement   amountField() {
		return   amountField;
	}
	@ElementDescription(value = "Review Transfer")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Review Transfer']")
	private MobileElement reviewTransfer;

	public MobileElement   reviewTransfer() {
		return   reviewTransfer;
	}
	@ElementDescription(value = "TRANSFER NOW button")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='TRANSFER NOW'])[1]")
	private MobileElement transferNowButton;

	public MobileElement transferNowButton() {
		return  transferNowButton;
	}
	@ElementDescription(value = "Transferred title")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Transferred'])[1]")
	private MobileElement transferredTitle;

	public MobileElement transferredTitle() {
		return  transferredTitle;
	}
	@ElementDescription(value = "MAKE ANOTHER TRANSFER button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='MAKE ANOTHER TRANSFER']")
	private MobileElement makeAnotherTransferButton;

	public MobileElement  makeAnotherTransferButton() {
		return   makeAnotherTransferButton;
	}
	@ElementDescription(value = "Reference No. value for fund transfer")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText)[15]")
	private MobileElement referenceNoValueForFundTransfer;

	public MobileElement  referenceNoValueForFundTransfer() {
		return  referenceNoValueForFundTransfer;
	}
	@ElementDescription(value = "close button2")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='close']")
	private MobileElement closeButton2;

	public MobileElement  closeButton2() {
		return  closeButton2;
	}
	//home page
	@ElementDescription(value = "Deposite Homepage")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Deposits']")
	private MobileElement depositeHomepage;

	public MobileElement   depositeHomepage() {
		return   depositeHomepage;
	}
	@ElementDescription(value = "SGD Homepage")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'SGD')]")
	private MobileElement sgdHomepage;

	public MobileElement sgdHomepage() {
		return sgdHomepage;
	}
	@ElementDescription(value = "Account name Homepage")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther/XCUIElementTypeStaticText)[4]")
	private MobileElement accountNameHomepage;

	public MobileElement  accountNameHomepage() {
		return   accountNameHomepage;
	}
	@ElementDescription(value = "All tab list")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeOther/XCUIElementTypeStaticText")
	private List<MobileElement> allTabList;

	public List<MobileElement> allTabList() {
		return localRecipientsList;
	}
	@ElementDescription(value = " expand button 2")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='arrowDown']")
	private MobileElement expandButton2;

	public MobileElement  expandButton2() {
		return  expandButton2;
	}
	///corridor remettence
	@ElementDescription(value = "Account list in Oversease")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText")
	private List<MobileElement> accountListInOversea;

	public List<MobileElement> accountListInOversea() {
		return accountListInOversea;
	}
	@ElementDescription(value = "Amount field in overseas")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='DBSRemittance_SenderAmount']")
	private MobileElement amountFieldInOversea;

	public MobileElement   amountFieldInOversea() {
		return   amountFieldInOversea;
	}
	@ElementDescription(value = "exchange Rate")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Exchange Rate']")
	private MobileElement exchangeRate;

	public MobileElement  exchangeRate() {
		return  exchangeRate;
	}
	@ElementDescription(value = "enter mobile no.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[contains(@value,'Mobile')]")
	private MobileElement enterMobileNo;

	public MobileElement  enterMobileNo() {
		return  enterMobileNo;
	}
	@ElementDescription(value = "select account type")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'account type')]/following-sibling::XCUIElementTypeOther[1]")
	private MobileElement selectAccountType;

	public MobileElement  selectAccountType() {
		return  selectAccountType;
	}
	@ElementDescription(value = "select purpose type")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'purpose')]/following-sibling::XCUIElementTypeOther[1]")
	private MobileElement selectPurposeType;

	public MobileElement  selectPurposeType() {
		return  selectPurposeType;
	}
	@ElementDescription(value = "common list")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText")
	private List<MobileElement> commonList;

	public List<MobileElement> commonList() {
		return commonList;
	}
	@ElementDescription(value = "Review transfer")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name='Review Transfer']")
	private MobileElement reviewTransferLabel;

	public MobileElement  reviewTransferLabel() {
		return  reviewTransferLabel;
	}
	@ElementDescription(value = "Transfer Submitted")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Transfer Submitted']")
	private MobileElement transferSubmittedLabel;

	public MobileElement  transferSubmittedLabel() {
		return  transferSubmittedLabel;
	}
	@ElementDescription(value = "Reference value in oversea")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText)[23]")
	private MobileElement referenceNoValueInOversea;

	public MobileElement  referenceNoValueInOversea() {
		return  referenceNoValueInOversea;
	}
	@ElementDescription(value = "SHARE TRANSFER DETAILS btn")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='SHARE TRANSFER DETAILS']")
	private MobileElement shareTransferDetailButton;

	public MobileElement  shareTransferDetailButton() {
		return  shareTransferDetailButton;
	}
	@ElementDescription(value = "Transfer Details label")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Transfer Details']")
	private MobileElement transferDetailLabel;

	public MobileElement  transferDetailLabel() {
		return  transferDetailLabel;
	}
	@ElementDescription(value = "backbutton in Transfer Details label")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='DBSRemittance_CompletionCrossButton']")
	private MobileElement backButtontransferDetailLabel;

	public MobileElement  backButtontransferDetailLabel() {
		return  backButtontransferDetailLabel;
	}
	@ElementDescription(value = "close icon in oversea")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='close icon']")
	private MobileElement closeIconInOversea;

	public MobileElement  closeIconInOversea() {
		return  closeIconInOversea;
	}
	@ElementDescription(value = "Overseas header")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Overseas Transfer']")
	private MobileElement overseaTitle;

	public MobileElement  overseaTitle() {
		return  overseaTitle;
	}
	@ElementDescription(value = "search icon in payAndtransfer")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Pay & Transfer']")
	private MobileElement searchBoxInPayAndTransfer;

	public MobileElement  searchBoxInPayAndTransfer() {
		return  searchBoxInPayAndTransfer;
	}
	//////
	@ElementDescription(value = "Temporary Limit Increase header")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Temporary Limit Increase']")
	private MobileElement temporaryLimitIncreaseHeader;

	public MobileElement  temporaryLimitIncreaseHeader() {
		return  temporaryLimitIncreaseHeader;
	}
	@ElementDescription(value = "Additional credit limit")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Some placeholder'])[1]/following-sibling::XCUIElementTypeTextField[1]")
	private MobileElement additionalCreditLimit;

	public MobileElement  additionalCreditLimit() {
		return  additionalCreditLimit;
	}
	@ElementDescription(value = "duration credit limit")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Some placeholder'])[2]/following-sibling::XCUIElementTypeTextField[1]")
	private MobileElement durationCreditLimit;

	public MobileElement  durationCreditLimit() {
		return  durationCreditLimit;
	}
	@ElementDescription(value = "purpose credit limit")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Some placeholder'])[3]/following-sibling::XCUIElementTypeTextField[1]")
	private MobileElement purposeCreditLimit;

	public MobileElement  purposeCreditLimit() {
		return  purposeCreditLimit;
	}
	@ElementDescription(value = "Calender Temporary Limit Increase header")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Pick Date']")
	private MobileElement calenderTemporaryLimitIncreaseHeader;

	public MobileElement  calenderTemporaryLimitIncreaseHeader() {
		return  calenderTemporaryLimitIncreaseHeader;
	}
	@ElementDescription(value = "Calender date 11 oct")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='calendarDayCell.TextLabel_11_selected']")
	private MobileElement calenderDateOctEleven;

	public MobileElement  calenderDateOctEleven() {
		return  calenderDateOctEleven;
	}
	@ElementDescription(value = "confirm button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Confirm']")
	private MobileElement confirmButton;

	public MobileElement  confirmButton() {
		return  confirmButton;
	}
	@ElementDescription(value = "confirm button 2")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='CONFIRM']")
	private MobileElement confirmButton2;

	public MobileElement  confirmButton2() {
		return  confirmButton2;
	}
	@ElementDescription(value = "Review Application header")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Review Application']")
	private MobileElement reviewApplicationHeader;

	public MobileElement  reviewApplicationHeader() {
		return  reviewApplicationHeader;
	}
	@ElementDescription(value = "Select a Purpose")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Select a Purpose']")
	private MobileElement selectPurpose;

	public MobileElement  selectPurpose() {
		return  selectPurpose;
	}
}
