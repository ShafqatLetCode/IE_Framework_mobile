package com.crestech.pages.androidpage.paytransfer;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import com.crestech.annotation.values.ElementDescription;
import com.crestech.appium.utils.CommonAppiumTest;
import com.crestech.common.utilities.Asserts;
import com.crestech.common.utilities.CommonTestData;
import com.crestech.common.utilities.GestureUtils;
import com.crestech.common.utilities.HandleException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;

public class localModule extends CommonAppiumTest{
	
	
	public AppiumDriver<RemoteWebElement> driver = null;
	HandleException obj_handleexception = null;
	GestureUtils gestUtils = null;
	
	public localModule(AppiumDriver<RemoteWebElement> driver) throws Exception {
		super(driver);
		try {
			this.driver = driver;
			obj_handleexception = new HandleException(null, null);
		    gestUtils = new GestureUtils(driver);
			PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	@ElementDescription(value = "Add Recipient Now Button")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='ADD RECIPIENT NOW']")
	private MobileElement AddRecipientNowBtn;
	
	@ElementDescription(value = "Add Local Recipient")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Add Local Recipient']")
	private MobileElement AddLocalRecipient;
	
	@ElementDescription(value = "Page Header")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'id/text')]")
	private MobileElement PageHeader;
	
	@ElementDescription(value = "EditFields List")
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,':id/edit_user_id')]")
	private List<MobileElement> EditFields;
	
	@ElementDescription(value = " Select Bank Field")
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Select bank']")
	private MobileElement SelectBankField;
	
	@ElementDescription(value = "Search field")
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Search']")
	private MobileElement SearchField;
	
	@ElementDescription(value = "Next Button")
	@AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,':id/btn_submit')]")
	private MobileElement NextButton;
	
	@ElementDescription(value = "Select Bank Account")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Bank Account']")
	private MobileElement SelectBankAccount;
	
	@ElementDescription(value = "Success Tick Image View")
	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,':id/imgView_ic_success_tick')]")
	private MobileElement SuccessTickImageView;
	
	@ElementDescription(value = "MAKE A TRANSFER")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='MAKE A TRANSFER']")
	private MobileElement makeTransferButton;
	
	@ElementDescription(value = "Log Out Button")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='LOG OUT']")
	private MobileElement LogoutBtn;

	@ElementDescription(value = "Payee Values")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/payeeValue')]")
	private List<MobileElement> PayeeValueList;
	
	@ElementDescription(value = "Payee Titles")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/payeeTitle')]")
	private List<MobileElement> PayeeTitleList;
	
	@ElementDescription(value = "Back Icon")
	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,':id/back_icon')]")
	private MobileElement BackIcon;
	
	@ElementDescription(value = "Page Header List")
	@AndroidFindBy(xpath = "//android.widget.RelativeLayout//android.widget.TextView[contains(@resource-id,':id/text')]")
	private List<MobileElement> PageHeaderList;
	
	@ElementDescription(value = "ReviewTransferPageHeader")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/text_toolbar_title')]")
	private MobileElement ReviewTransferPageHeader;
	
	@ElementDescription(value = "transffered Message Element")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/text_transfer_result')]")
	private MobileElement transfferedMessageElement;
	
	@ElementDescription(value = "Select Fund Source")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Select Fund Source']")
	private MobileElement SelectFundSourceText;
	
	@ElementDescription(value = "Select Local Recipient To Account")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/text_src_acc_name')]")
	private List<MobileElement> sourceAccountList;
	
	@ElementDescription(value = "OK Button")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
	private MobileElement OKButton;
	
	@ElementDescription(value = "Transfer Via Fast Transfer Toggle")
	@AndroidFindBy(xpath = "//android.widget.Switch[contains(@resource-id,':id/switch_transfer_type')]")
	private MobileElement TransferViaFastTransferToggle;
	
	@ElementDescription(value = "Transfer Date Text Element")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/text_transfer_date')]")
	private MobileElement TransferDateTextElement;
	
	@ElementDescription(value = "Select Next Month")
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Next month']")
	private MobileElement SelectNextMonth;
	
	@ElementDescription(value = "Static date")
	@AndroidFindBy(xpath = "//android.view.View[@text='20']")
	private MobileElement StaticDate;
	
	@ElementDescription(value = "Amount Field For Bill Org")
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,':id/appCompatEditText')]")
	private MobileElement AmountEditableField;
	
	@ElementDescription(value = "Next button")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='NEXT']")
	private MobileElement nextButton;
	
	@ElementDescription(value = "Transfer Now Button")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='TRANSFER NOW']")
	private MobileElement TransferNowBtn;
	
	@ElementDescription(value = "Non Fast Transaction Service Message")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='NON-FAST']")
	private MobileElement NonFastTransactionService;

	@ElementDescription(value = "Fast Transaction Service Message")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='FAST']")
	private MobileElement FastTransactionService;
	
	@ElementDescription(value = "Transfer Success Message")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/text_transfer_result')]")
	private MobileElement TransferSuccessMsgElement;
	
	@ElementDescription(value = "Image ICON For Payment Success")
	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,':id/image_result')]")
	private MobileElement ImageForPaymentSuccess;
	
	@ElementDescription(value = "Account name list:- Contains From Account and To Account")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/tv_lable2')]")
	private List<MobileElement> AccountNameList;
	
	@ElementDescription(value = "MAKE ANOTHER TRANSFER BUTTON")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='MAKE ANOTHER TRANSFER']")
	private MobileElement MakeAnotherTransferBtn;
	
	@ElementDescription(value = "Sending Amount Element")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/card_amount')]")
	private MobileElement SendingAmountElement;
	
	@ElementDescription(value = "Account Number list:- Contains From Account and To Account")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/tv_lable3')]")
	private List<MobileElement> AccountNumberList;
	
	@ElementDescription(value = "Log Out Button")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Log Out']")
	private MobileElement LOGOUTButton;
	
	@ElementDescription(value = "Footer Expandable Button")
	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,':id/ic_logo_footer_iv')]")
	private MobileElement FooterExpandableBtn;
	
	@ElementDescription(value = "Reference Number Text")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Reference No.']")
	private MobileElement ReferenceNumberText;
	
	@ElementDescription(value = "Logout button paylah page")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/logout_icon')]")
	private MobileElement logOutPaylahButton;

	@Step("Click On 'Log Out' Button")
	public void clickOnLogOutButton() throws Exception {
		try {
			gestUtils.scrollDOWNtoObject("text", "Log Out",logOutPaylahButton);
			clickOnElement(logOutPaylahButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION"," Failed to Click On 'Log Out' Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On 'Log Out' Button ", e);
		}
	}

	@Step("Click On 'Expandable button' And scroll Down to 'Reference No.' text")
	public void ClickOnExpandbutton() throws Exception {
		try {
			clickOnElement(FooterExpandableBtn);
			gestUtils.scrollUPtoObject("text", "Reference No.", ReferenceNumberText);
			
			Asserts.assertEquals(getTexOfElement(ReferenceNumberText),
					CommonTestData.REFERENCE_NUMBER.getEnumValue(), "'Reference no Field' is not found");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION"," Failed to click on expandable button and scroll down to reference", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION"," Failed to click on expandable button and scroll down to reference ", e);
		}
	}
	
	@Step("Verify 'Non-Fast' Service On Review Page")
	public void VerifyNonFastServiceOnReviewPage() throws Exception {
		try {
			gestUtils.scrollUPtoObject("text", "TRANSFER NOW", TransferNowBtn);
			Asserts.assertTrue(NonFastTransactionService.isDisplayed(), "Non-Fast Service not available on review page.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION"," Failed to verify non fast service on Review Page ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION"," Failed to verify non fast service on Review Page  ", e);
		}
	}

	@Step("Verify 'Review Transfer' Page And 'Fast' Service In Review")
	public void VerifyFastServiceInReview() throws Exception {
		try {
			gestUtils.scrollUPtoObject("text", "TRANSFER NOW", TransferNowBtn);
			Asserts.assertTrue(FastTransactionService.isDisplayed(),
					"Fast Service not available in review.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION"," Failed to verify fast service  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION"," Failed to verify fast service ", e);
		}
	}
	
	@Step("Click on Transfer Now Button.")
	public void ClickOnTransferNowBtn() throws Exception {
		try {
			gestUtils.scrollUPtoObject(null, null, null);
			clickOnElement(TransferNowBtn);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to CLick on transfer now Button ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to CLick on transfer now Button ", e);
		}
	}

	
	@Step("Verify Elements On Transfer Submitted Page")
	public void VerifyElementsOnTransferSubmittedPage(String ExpectedFromBankName, String ExpectedToBankName,
			String ExpectedToRecipientName) throws Exception {
		try {
			VerifyLogOutButton();
			VerifyMakeAnotherTransferButton();
			VerifyAmount(CommonTestData.AMOUNTTO_TRANSFERFUND.getEnumValue());
			VerifyFromBankName(ExpectedFromBankName);
			VerifyToRecipientName(ExpectedToRecipientName);
			VerifyToBankName(ExpectedToBankName);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", "failed to Verify Elements On Transfer Submitted Page ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" failed to Verify Elements On Transfer Submitted Page  ",e);
		}
	}

	@Step("Verify MAKE ANOTHER TRANSFER button.")
	public void VerifyMakeAnotherTransferButton() throws Exception {
		try {
			gestUtils.scrollUPtoObject("text", "MAKE ANOTHER TRANSFER", MakeAnotherTransferBtn);
			Asserts.assertTrue(MakeAnotherTransferBtn.isDisplayed(),
					"Make Another Transfer Button not found.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to verify MAKE ANOTHER TRANSFER Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to verify MAKE ANOTHER TRANSFER Button ", e);
		}
	}
	

	@Step("Verify Amount On Transfer Submitted Page.")
	public void VerifyAmount(String ExpectedAmount) throws Exception {
		try {
			Asserts.assertEquals(getTexOfElement(SendingAmountElement), ExpectedAmount + ".00",
					"Amount is not matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to verify Amount On Transfer submitted Page. ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to verify Amount On Transfer submitted Page. ", e);
		}
	}

	@Step("Verify 'From Bank Name' On Transfer submitted Page.")
	public void VerifyFromBankName(String ExpectedFromBankName) throws Exception {
		try {
			Asserts.assertEquals(getTexOfElement(AccountNameList.get(0)), ExpectedFromBankName,
					ExpectedFromBankName + " is not matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to verify 'From Bank Name' On Transfer submitted Page. ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to verify 'From Bank Name' On Transfer submitted Page. ", e);
		}
	}

	@Step("Verify 'To Bank Name' On Transfer submitted Page.")
	public void VerifyToBankName(String ExpectedToBankName) throws Exception {
		try {
			Asserts.assertEquals(getTexOfElement(AccountNumberList.get(1)).trim(), ExpectedToBankName,
					ExpectedToBankName + " is not matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to verify 'To Bank Name' On Transfer submitted Page. ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to verify 'To Bank Name' On Transfer submitted Page. ", e);
		}
	}

	@Step("Verify 'To Recipient Name' On Transfer submitted Page.")
	public void VerifyToRecipientName(String ExpectedToRecipientName) throws Exception {
		try {
			Asserts.assertEquals(getTexOfElement(AccountNameList.get(1)), ExpectedToRecipientName,
					ExpectedToRecipientName + " is not matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to verify 'To Recipient Name' On Transfer submitted Page. ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to verify 'To Recipient Name' On Transfer submitted Page. ", e);
		}
	}
	
	@Step("Verify logout button.")
	public void VerifyLogOutButton() throws Exception {
		try {
			Asserts.assertTrue(LOGOUTButton.isDisplayed(), "Log Out Button not found.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to verify Logout Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to verify Logout Button ", e);
		}
	}
	
	@Step("Verifies Transfer Submitted Message")
	public void VerifiesTransferSubmittedMessage(String SuccessMsg) throws Exception {
		try {
			//if (isElementVisible(ImageForPaymentSuccess))
			wait.waitForElementVisibility(TransferSuccessMsgElement);
				Asserts.assertEquals(getTexOfElement(TransferSuccessMsgElement), SuccessMsg,
						SuccessMsg + " Text is not matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verify success message ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify success message  ", e);
		}
	}
	
	@Step("Enter Amount On Fund Transfer Page.")
	public void EnterAmount(String textToEnter) throws Exception {
		try {
			clickOnElement(AmountEditableField);
			enterTextInTextbox(AmountEditableField, textToEnter);
			hideKeyboard();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Enter Amount ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Enter Amount ", e);
		}
	}
	
	@Step("Click on 'TransferViaFast Toggle' to disable fast service.")
	public void DisableToTransferViaFastToggle() throws Exception {
		try {
			gestUtils.scrollUPtoObject(null, null, TransferViaFastTransferToggle);
			clickOnElement(TransferViaFastTransferToggle);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", "Failed to click on fast toggle to disable it", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION"," Failed to click on fast toggle to disable it  ", e);
		}
	}
	
	@Step("Enter Comments On Fund Transfer Page")
	public void EnterCommentForRecipientInEditField(String Comment) throws Exception {
		try {
			clickOnElement(EditFields.get(0)); 
			enterTextInTextbox(EditFields.get(0), Comment);
			hideKeyboard();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Enter comments in edit field. ",e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", "Failed to Enter comments in edit field. ", e);
		}
	}
	
	@Step("Verify Immediate text")
	public void VerifyImmediateText(String ActualSelectedDate) throws Exception {
		try {
			String ExpectedSelectedDate = getTexOfElement(TransferDateTextElement);
			Asserts.assertEquals(ActualSelectedDate, ExpectedSelectedDate,"Immediate text is not Matching in date section.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Verify Immediate Text ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", "Failed to Verify Immediate Text. ", e);
		}
	}
	
	@Step("Click On OK Button.")
	public void ClickOnOKButton() throws Exception {
		try {
			clickOnElement(OKButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On OK Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On OK Button   ", e);
		}
	}
	
	@Step("Handle Of 'Primary Source Of Fund' Popup.")
	public void HandlingOfPrimarySourceOfFundPopup() throws Exception {
		try {
			String xpath1 = "//android.widget.TextView[@text='Primary source of fund']";
			List<RemoteWebElement> primarySourceOfFundPopup = driver.findElements(By.xpath(xpath1));
			if (primarySourceOfFundPopup.size() > 0)
				ClickOnOKButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Handle Of 'Primary Source Of Fund' Popup  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Handle Of 'Primary Source Of Fund' Popup  ", e);
		}
	}

	// If User has multiple accounts then select fund source account
	@Step("'Select Fund Source Account' If User has multiple accounts.")
	public void SelectFundSourceAccount(String expectedSourceAccount) throws Exception {
		try {
			String xpath = "//android.widget.TextView[@text='Select Fund Source']";
			List<RemoteWebElement> list = driver.findElements(By.xpath(xpath));
			if (list.size() > 0) {
				clickOnElement(SelectFundSourceText);
				
				int selectedAccount = 0;
				for (int i = 0; i < sourceAccountList.size(); i++) {
					String actualSourceAccount = sourceAccountList.get(i).getText();
					if (actualSourceAccount.contains(expectedSourceAccount)) {
						selectedAccount++;
						clickOnElement(sourceAccountList.get(i));
						break;
					}
				}

				if (selectedAccount == 0)
					Asserts.assertFail("Select Fund Source " + expectedSourceAccount
							+ " not found in the list to initiate the fund transfer");

				HandlingOfPrimarySourceOfFundPopup();
			}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION"," Failed to select any fund source account  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", "Failed to select any fund source account  ", e);
		}
	}

	@ElementDescription(value = "SGD")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='SGD']")
	private MobileElement sgdFieldText;
	
	@Step("Verify 'SGD Currency Field' and Enter Amount '11'")
	public void enterAmountAndVerifySgdCurrency(String Amount) throws Exception {
		try {
			Asserts.assertEquals(getTexOfElement(sgdFieldText),
					CommonTestData.SGD_CURRENCY_LABEL.getEnumValue(), "'Currency' is not Matching");
			enterTextInTextbox(AmountEditableField, Amount);
			hideKeyboard();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION"," Failed to verify SGD Currency field and enter amount", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to verify SGD Currency field and enter amount  ", e);
		}
	}
	
	@Step("Verify 'Local Transfer Pay Now' page header")
	public void verifyLocalTransferPayNowPageHeader(String expectedText) throws Exception {
		try {
			wait.fluentWaitForElement(PageHeader);
			Asserts.assertEquals(getTexOfElement(PageHeader).toLowerCase(), expectedText.toLowerCase(),
					"'Header Title' is not Matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION", " Failed to Verify 'Local Transfer Pay Now' page header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION", " Failed to Verify 'Local Transfer Pay Now' page header ", e);
		}
	}

	@Step("Click On Add Local Recipient Button.")
	public void clickOnAddLocalRecipientBtn() throws Exception {
		try {
			String xpath = "//android.widget.Button[@text='ADD RECIPIENT NOW']";
			List<RemoteWebElement> list = driver.findElements(By.xpath(xpath));
			if (list.size() > 0)
				clickOnElement(AddRecipientNowBtn);
			else
				clickOnElement(AddLocalRecipient);

		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Add Local Recipient Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Add Local Recipient Button ", e);
		}
	}
	
	
	@Step("Click On Next Button.")
	public void ClickOnNextButton() throws Exception {
		try {
			clickOnElement(NextButton);
			wait.waitForElementVisibility(AddRecipientNowBtn);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Next Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Next Button ", e);
		}
	}
	
	@Step("Click On Next Button.")
	public void ClickOnNextButtonToInitiateFundTransfer() throws Exception {
		try {
				gestUtils.scrollUPtoObject("text", "NEXT", nextButton);
				clickOnElement(nextButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Next Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Next Button  ", e);
		}
	}

	@Step("Select Bank Account.")
	public void SelectBankAccount() throws Exception {
		try {
			clickOnElement(SelectBankAccount);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select Bank Account ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select Bank Account ", e);
		}
	}
	
	@Step("Verify 'Enter Recipient Details' page header")
	public void verifyEnterRecipientDetailsPageHeader(String expectedText) throws Exception {
		try {
			wait.fluentWaitForElement(PageHeader);
			Asserts.assertEquals(getTexOfElement(PageHeader).toLowerCase(), expectedText.toLowerCase(),
					"'Header Title' is not Matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION", " Failed to Verify 'Enter Recipient Details' page header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION", " Failed to Verify 'Enter Recipient Details' page header ", e);
		}
	}
	
	@Step("Verify 'Review Transfer' page header")
	public void verifyReviewTransferPageHeader(String expectedText) throws Exception {
		try {
			wait.fluentWaitForElement(ReviewTransferPageHeader);
			Asserts.assertEquals(getTexOfElement(ReviewTransferPageHeader).toLowerCase(), expectedText.toLowerCase(),
					"'Header Title' is not Matching"); 
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION", " Failed to verify 'Review Transfer' page header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION", " Failed to verify 'Review Transfer' page header ", e);
		}
	}
	
	@Step("Verify 'Review Recipient's Details' page header")
	public void verifyReviewRecipientDetailsPageHeader(String expectedText) throws Exception {
		try {
			wait.fluentWaitForElement(PageHeader);
			Asserts.assertEquals(getTexOfElement(PageHeader).toLowerCase(), expectedText.toLowerCase(),
					"'Header Title' is not Matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION", " Failed to Verify 'Review Recipient Details' page header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION", " Failed to Verify 'Review Recipient Details' page header ", e);
		}
	}
	
	@Step("Enter Recipient Details.")
	public void EnterRecipientDetails(String ExpectedRecipientName, String BankName, String AccountNumber)
			throws Exception {
		try {
			EnterRecipientName(ExpectedRecipientName);
			SelectBankName(BankName);
			EnterAccountNumber(AccountNumber);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Enter Recipient Details  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Enter Recipient Details ", e);
		}
	}

	@Step("Enter Account Number")
	public void EnterAccountNumber(String AccountNumber) throws Exception {
		try {
			enterTextInTextbox(EditFields.get(2), AccountNumber);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Enter Account Number ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Enter Account Number ", e);
		}
	}

	@Step("Enter Recipient Name")
	public void EnterRecipientName(String ExpectedRecipientName) throws Exception {
		try {
			enterTextInTextbox(EditFields.get(0), ExpectedRecipientName);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Enter Recipient Name ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Enter Recipient Name ", e);
		}
	}

	@Step("Select Bank Name")
	public void SelectBankName(String BankName) throws Exception {
		try {
			wait.waitForElementToBeClickable(SelectBankField); 
			clickOnElement(SelectBankField);
			clickOnElement(SearchField);
			enterTextInTextbox(SearchField, BankName);
            backButton();
            
			gestUtils.scrollUPtoObject("text", BankName, null);
			String xpath = "//android.widget.RelativeLayout//android.widget.TextView[@text='" + BankName + "']";
			MobileElement Selectbank = (MobileElement) driver.findElement(By.xpath(xpath));
			clickOnElement(Selectbank);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select Bank Name ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select Bank Name ", e);
		}
	}
	
	@Step("clicking On 'ADD RECIPIENT NOW' button")
	public void ClickOnAddRecipientNowBtn() throws Exception {
		try {
			gestUtils.scrollUPtoObject("text", "ADD RECIPIENT NOW", AddRecipientNowBtn);
			clickOnElement(AddRecipientNowBtn);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION"," Failed to Click On Add Recipient Now Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Add Recipient Now Button  ",e);
		}
	}
	

	@Step("Verify 'You Have Added Recipient Message'.")
	public void VerifyYouHaveAddedRecipientMessage() throws Exception {
		try {
			wait.fluentWaitForElement(SuccessTickImageView);
			if (isElementVisible2(SuccessTickImageView)) {
				if (getTexOfElement(PageHeader).toLowerCase()
						.equalsIgnoreCase(CommonTestData.YOU_HAVE_ADDED_RECIPIENT_MSG.getEnumValue()))
					Asserts.assertEquals(getTexOfElement(PageHeader),
							CommonTestData.YOU_HAVE_ADDED_RECIPIENT_MSG.getEnumValue(),
							CommonTestData.YOU_HAVE_ADDED_RECIPIENT_MSG.getEnumValue() + " Text is not matching");

				else if (getTexOfElement(PageHeader).toLowerCase()
						.equalsIgnoreCase(CommonTestData.YOU_HAVE_ADDED_RECIPIENT_MSG2.getEnumValue()))
					Asserts.assertEquals(getTexOfElement(PageHeader),
							CommonTestData.YOU_HAVE_ADDED_RECIPIENT_MSG2.getEnumValue(),
							CommonTestData.YOU_HAVE_ADDED_RECIPIENT_MSG2.getEnumValue() + " Text is not matching");
			} 
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FILEDVERIFICATION_EXCEPTION"," Failed to verify you've added recipient Message ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FILEDVERIFICATION_EXCEPTION"," Failed to verify you've added recipient Message ", e);
		}
	}
	
	
	@Step("Verify Validation For Payee Add.")
	public void verifyValidationForPayeeAdd(String ExpectedRecipientName, String BankName, String AccountNumber)
			throws Exception {
		try {
			verifyLogOutButton();
			verifyMakeTransferButton();
			String[] ExpTitleList = new String[] { "Recipient's Name", "Country", "Recipient's Bank",
					"Recipient's Account No.", "Reference No." };
			verifyTitles(ExpTitleList, PayeeTitleList);
			VerifyRecipientName(ExpectedRecipientName);
			VerifyBankName(BankName);
			VerifyAccountNumber(AccountNumber);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to verify validation for payee add ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to verify validation for payee add ",
					e);
		}
	}

	@Step("Verify Account Number")
	public void VerifyAccountNumber(String AccountNumber) throws Exception {
		try {
			Asserts.assertEquals(getTexOfElement(PayeeValueList.get(3)), AccountNumber,
					AccountNumber + " is not matching after adding payee");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verify Account Number ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify Account Number ", e);
		}
	}

	@Step("Verify Bank Name")
	public void VerifyBankName(String BankName) throws Exception {
		try {
			Asserts.assertEquals(getTexOfElement(PayeeValueList.get(2)), BankName,
					BankName + " is not matching after adding payee");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verify Bank Name ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify Bank Name ", e);
		}
	}
	
	@Step("Verify Recipient Name")
	public void VerifyRecipientName(String ExpectedRecipientName) throws Exception {
		try {
			Asserts.assertEquals(getTexOfElement(PayeeValueList.get(0)), ExpectedRecipientName,
					ExpectedRecipientName + " is not matching after adding payee");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verify Recipient Name ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify Recipient Name ", e);
		}
	}

	@Step("Verify titles")
	public void verifyTitles(String[] ExpTitleList, List<MobileElement> eleList) throws Exception {
		try {
			for (int i = 0; i < eleList.size(); i++) {
				Asserts.assertEquals(getTexOfElement(eleList.get(i)), ExpTitleList[i],
						ExpTitleList[i] + "Titles is not matching.");
			}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to verify Titles ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to verify Titles ", e);
		}
	}
	
	@Step("Verify Logout Button")
	public void verifyLogOutButton() throws Exception {
		try {
			Asserts.assertTrue(LogoutBtn.isDisplayed(), "Log Out Button not found.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to verify LogOut Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to verify LogOut Button ", e);
		}
	}
	
	@Step("Verify Make Transfer Button")
	public void verifyMakeTransferButton() throws Exception {
		try {
			Asserts.assertTrue(makeTransferButton.isDisplayed(), "Make A Transfer Button not found.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to verify Make A Transfer Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to verify Make A Transfer Button ", e);
		}
	}
	
	@Step("Click On Back Icon.")
	public void ClickOnBackIcon() throws Exception {
		try {
			clickOnElement(BackIcon);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Back Icon  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Back Icon  ", e);
		}
	}
	
	@Step("Verify 'Transfer To Other Bank' page header")
	public void verifyTransferToOtherBankPageHeader(String expectedText) throws Exception {
		try {
			wait.fluentWaitForElement(PageHeaderList.get(0));
			Asserts.assertEquals(getTexOfElement(PageHeaderList.get(0)).toLowerCase(), expectedText.toLowerCase(),
					"'Header Title' is not Matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION", " Failed to verify 'Transfer To Other Bank' page header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION", " Failed to verify 'Transfer To Other Bank' page header ", e);
		}
	}
	
	@Step("Verify 'Transferred' Message")
	public void verifyTransferredMessage(String expectedText) throws Exception {
		try {
			wait.fluentWaitForElement(transfferedMessageElement);
			Asserts.assertEquals(getTexOfElement(transfferedMessageElement).toLowerCase(), expectedText.toLowerCase(),
					"'Header Title' is not Matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION", " Failed to verify 'Transferred' Message ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION", " Failed to verify 'Transferred' Message ", e);
		}
	}
	
	@Step("Select Future Date Through Calendar and verifies the selected 'future date'.")
	public void SelectFutureDate() throws Exception {
		try {
			clickOnElement(TransferDateTextElement);

			if(isElementEnable(StaticDate)) {
				clickOnElement(StaticDate);
				ClickOnOKButton();
				String ActualSelectedDate = getTexOfElement(TransferDateTextElement);
				Asserts.assertEquals(ActualSelectedDate.split(" ")[0], "20", "Selected Date is not Matching");
			}else {
				Calendar calendar = Calendar.getInstance();
				Date today = calendar.getTime();
	
				calendar.add(Calendar.DAY_OF_YEAR, 1);
				Date tomorrow = calendar.getTime();
	
				DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
	
				String todayAsString = dateFormat.format(today);
				String tomorrowAsString = dateFormat.format(tomorrow);
				String ExpectedDate = tomorrowAsString.replaceAll("-", " ");
				System.out.println(todayAsString);
				System.out.println(tomorrowAsString);
				System.out.println(ExpectedDate);
				String[] sDate = tomorrowAsString.split("-");
				System.out.println(sDate[0]);
				
				String[] todayDate = todayAsString.split("-");
				System.out.println(todayDate[0]);
				
				String newDate = sDate[0];
				
				if(todayDate[0].equals("30") || todayDate[0].equals("31") || todayDate[0].equals("28") || todayDate[0].equals("29")) {
					calendar.add(Calendar.DAY_OF_YEAR, 14);
					Date DateAfterFourteenDays = calendar.getTime();
		
					DateFormat newDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		
					String DateAfterFourteenDaysInFormat = newDateFormat.format(DateAfterFourteenDays);
					System.out.println("DateAfterFourteenDaysInFormat:: "+DateAfterFourteenDaysInFormat);
				    ExpectedDate = DateAfterFourteenDaysInFormat.replaceAll("-", " ");
					System.out.println("ExpectedDate:: "+ExpectedDate);
					
					String[] sDate1 = DateAfterFourteenDaysInFormat.split("-");
					System.out.println("new Selected Date:: "+sDate1[0]);
					newDate = sDate1[0]; 
					System.out.println("newDate:: "+ newDate);
					
					clickOnElement(SelectNextMonth); 
				}
				
				
				String CalendardateXpath = "//android.view.View[@text='" + newDate + "']";
		        
				MobileElement Calendardate = (MobileElement) driver.findElement(By.xpath(CalendardateXpath));
				if (Calendardate.isEnabled())
					clickOnElement(Calendardate);
	
				ClickOnOKButton();
				
				String ActualSelectedDate = getTexOfElement(TransferDateTextElement);
				System.out.println("ActualSelectedDate:: "+ActualSelectedDate);
				System.out.println("ExpectedDate:: "+ExpectedDate);
				Asserts.assertEquals(ActualSelectedDate, ExpectedDate, "Selected Date is not Matching");
			}
			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION"," Failed to select future date and verification  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION"," Failed to select future date and verification ", e);
		}
	}
	
}
