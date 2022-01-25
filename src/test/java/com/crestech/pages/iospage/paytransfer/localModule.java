package com.crestech.pages.iospage.paytransfer;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crestech.annotation.values.ElementDescription;
import com.crestech.appium.utils.CommonAppiumTest;
import com.crestech.common.utilities.Asserts;
import com.crestech.common.utilities.CommonTestData;
import com.crestech.common.utilities.GestureUtils;
import com.crestech.common.utilities.HandleException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

/**
 * @author Divya
 *
 */
public class localModule extends CommonAppiumTest {

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

	@ElementDescription(value = "'Close' Button After adding Payee")
	@FindBy(name = "close")
	private MobileElement closeButton;

	@ElementDescription(value = "Add Recipient Now button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='ADD RECIPIENT NOW']")
	private MobileElement AddRecipientNowButton;
	
	@ElementDescription(value = "Review Transfer")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Review Transfer']")
	private MobileElement reviewTransfer1;

	@ElementDescription(value = "Add Local Recipient button")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Add Local Recipient'])[1]")
	private MobileElement AddLocalRecipientButton;

	@ElementDescription(value = "Local Transfer & Pay Now Page Header")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Local Transfer & PayNow']")
	private MobileElement LocalTransferPayNowPageHeader;

	@ElementDescription(value = "Select Bank Account")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Bank Account']")
	private MobileElement SelectBankAccount;

	@ElementDescription(value = "Done button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Done']")
	private MobileElement doneButton;

	@ElementDescription(value = "Next Button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='NEXT']")
	private MobileElement nextButton;

	@ElementDescription(value = "next Button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='NEXT']")
	private MobileElement NEXTButton;

	@ElementDescription(value = "'Add Recipient Now' Button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='ADD RECIPIENT NOW']") //
	private MobileElement ADDRecipientNowButton;

	@ElementDescription(value = "Logout button on paylah")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Log Out']")
	private MobileElement logout;

	@ElementDescription(value = "Log Out Button After adding Payee")
	@FindBy(name = "Log Out")
	private MobileElement LogoutBtn;

	@ElementDescription(value = "'Make A Transfer' Button After adding Payee")
	@FindBy(name = "MAKE A TRANSFER")
	private MobileElement makeTransferButton;

	@ElementDescription(value = "'Recipient's Name' text dispalying After adding Payee.")
	@FindBy(name = "Recipient's Name")
	private MobileElement RecipientNameText;

	@ElementDescription(value = "'Recipient's Bank' text dispalying After adding Payee.")
	@FindBy(name = "Recipient's Bank")
	private MobileElement RecipientBankText;

	@ElementDescription(value = "'Recipient's Account No.' text dispalying After adding Payee.")
	@FindBy(name = "Recipient's Account No.")
	private MobileElement RecipientAccountNo;

	@ElementDescription(value = "Primary source of fund")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Primary source of fund']")
	private MobileElement primarysourceOfFund;

	@ElementDescription(value = "OK Button")
	@AndroidFindBy(xpath = "//XCUIElementTypeButton[@name='OK']")
	private MobileElement OKButton;

	@ElementDescription(value = "Select Fund Source list")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText")
	private List<MobileElement> selectfundSourceList;

	@ElementDescription(value = "Select Fund Source")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Select Fund Source']")
	private MobileElement selectfundSource;

	@ElementDescription(value = "Select Fund Source")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Select fund source']")
	private MobileElement selectfundSource_iwealth;

	@ElementDescription(value = "Review Transfer")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Review Transfer']")
	private MobileElement reviewTransfer;

	@ElementDescription(value = "Amount field")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='FT_Amount_Field']")
	private MobileElement amountField;

	@ElementDescription(value = "TRANSFER NOW button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='TRANSFER NOW']")
	private MobileElement transferNowButton;

	@ElementDescription(value = "Transferred title")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Transferred'])[1]")
	private MobileElement transferredTitle;

	@ElementDescription(value = " expand button 2")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='arrowDown']")
	private MobileElement expandButton;

	@ElementDescription(value = "Reference No.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Reference No.']")
	private MobileElement referenceNo;

	@ElementDescription(value = "Transfer Date Text Element")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='When']/preceding-sibling::XCUIElementTypeStaticText[1]")
	private MobileElement TransferDateTextElement;

	@ElementDescription(value = "Amount Field")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='FT_Amount_Field']")
	private MobileElement AmountEditableField;

	@ElementDescription(value = "StaticDate")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell//XCUIElementTypeOther//XCUIElementTypeStaticText[@name='calendarDayCell.TextLabel_6_normal']")
	private MobileElement StaticDate;

	@ElementDescription(value = "ConfirmBtn")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Confirm']")
	private MobileElement ConfirmBtn;

	@ElementDescription(value = "NonFastTransactionService")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='NON-FAST']")
	private MobileElement NonFastTransactionService;

	@ElementDescription(value = "FastTransactionService")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='FAST']")
	private MobileElement FastTransactionService;

	@ElementDescription(value = "TransferNowBtn")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='TRANSFER NOW']")
	private MobileElement TransferNowBtn;

	@ElementDescription(value = "TransferSuccessMsgElement")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Transfer Submitted']")
	private MobileElement TransferSuccessMsgElement;

	@ElementDescription(value = "MakeAnotherTransferBtn")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='MAKE ANOTHER TRANSFER']")
	private MobileElement MakeAnotherTransferBtn;

	@ElementDescription(value = "MakeAnotherTransferBtn")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='MAKE ANOTHER TRANSFER']")
	private MobileElement SendingAmountElement;

	@ElementDescription(value = "BankName")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='INDIAN OVERSEAS BANK 582177606001']")
	private MobileElement ToBankName;

	@ElementDescription(value = "RecipientName")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Sakshi']")
	private MobileElement RecipientName;

	@ElementDescription(value = "LOGOUTButton")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Log Out']")
	private MobileElement LOGOUTButton;

	@ElementDescription(value = "FooterExpandableBtn")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Log Out']")
	private MobileElement FooterExpandableBtn;

	@ElementDescription(value = "ReferenceNumberText")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Reference No.']")
	private MobileElement ReferenceNumberText;

	@ElementDescription(value = "CloseBtn")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='close']")
	private MobileElement CloseBtn;

	@ElementDescription(value = "Transfer to Other Banks Header")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Transfer to Other Banks']")
	private MobileElement transferToOtherBanksHeader;

	@ElementDescription(value = "Transfer Via Fast Transfer Toggle")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name='Transfer via FAST']")
	private MobileElement TransferViaFastTransferToggle;

	@Step("Verify 'Transferred' Message And Generated Reference Number")
	public void verifyTransferredAndReferenceNumberField() throws Exception {
		try {
			Asserts.assertEquals(getTexOfElement(transferredTitle).trim().toLowerCase(),
					CommonTestData.TRANSFER_TITLE.getEnumValue().toLowerCase(),
					CommonTestData.TRANSFER_TITLE.getEnumValue() + " text is not matching.");
			clickOnElement(expandButton);
			gestUtils.scrollUPtoObjectIos("name", "Reference No.", null);
			Asserts.assertEquals(getTexOfElement(referenceNo).trim().toLowerCase(),
					CommonTestData.REFERENCE_NUMBER.getEnumValue().toLowerCase(),
					CommonTestData.REFERENCE_NUMBER.getEnumValue() + " text is not matching.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to verify page header and generated reference number ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to verify page header and generated reference number   ", e);
		}
	}

	@Step(" Click on 'TRANSFER NOW' Button")
	public void ClickTransferNowButton() throws Exception {
		try {
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(transferNowButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Click on 'TRANSFER NOW' Button", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click on 'TRANSFER NOW' Button ", e);
		}
	}

	// If User has multiple accounts then select fund source account
	@Step("'Select Fund Source Account' If User has multiple accounts.")
	public void SelectFundSourceAccount(String expectedSourceAccount, String appName) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.or(
					ExpectedConditions.presenceOfElementLocated(MobileBy.iOSNsPredicateString(
							"type == 'XCUIElementTypeStaticText' AND name == 'SGD'  AND visible== 1")),
					ExpectedConditions.presenceOfElementLocated(MobileBy.iOSNsPredicateString(
							"type == 'XCUIElementTypeStaticText' AND name == 'SGD'  AND visible== 0"))));

			int selectedAccount = 0;
			String AccountNameList = null;
			if (appName.equals("DBS") && isElementVisible2(selectfundSource)) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				clickOnElement(selectfundSource);
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				for (int i = 0; i < selectfundSourceList.size(); i++) {
					AccountNameList = selectfundSourceList.get(i).getText();
					if (AccountNameList.equalsIgnoreCase(expectedSourceAccount)) {
						selectedAccount++;
						clickOnElement(selectfundSourceList.get(i));
						break;
					}
				}
				if (selectedAccount == 0)
					Asserts.assertFail("Data Issue: Select Fund Source " + expectedSourceAccount
							+ " not found in the list to initiate the fund transfer");

				handlingOfPrimarySourceOfFundPopup();
			} else if (appName.equals("iWEALTH") && isElementVisible2(selectfundSource_iwealth)) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				clickOnElement(selectfundSource_iwealth);
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				for (int i = 0; i < selectfundSourceList.size(); i++) {
					AccountNameList = selectfundSourceList.get(i).getText();
					if (AccountNameList.equalsIgnoreCase(expectedSourceAccount)) {
						selectedAccount++;
						clickOnElement(selectfundSourceList.get(i));
						break;
					}
				}
				if (selectedAccount == 0)
					Asserts.assertFail("Data Issue: Select Fund Source " + expectedSourceAccount
							+ " not found in the list to initiate the fund transfer");

				handlingOfPrimarySourceOfFundPopup();
			}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Select Fund Source' and Select Account ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Select Fund Source' and Select Account ", e);
		}
	}

	@Step("Handle 'Primary Source Of Fund' Popup.")
	public void handlingOfPrimarySourceOfFundPopup() throws Exception {
		try {
			if (isElementVisible2(primarysourceOfFund)) {
				Asserts.assertEquals(getTexOfElement(primarysourceOfFund),
						CommonTestData.PRIMARY_SOURCE_ALERT_TITLE.getEnumValue(), "Message Not matching");
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				ClickOnOKButton();
			}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Handle 'Primary Source Of Fund' Popup. ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Handle 'Primary Source Of Fund' Popup.  ", e);
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

	@Step("Verify Account Number")
	public void VerifyAccountNumber(String AccountNumber) throws Exception {
		try {
			Asserts.assertTrue(RecipientAccountNo.isDisplayed(),
					"'Recipient's Account No.' text is not dispalying After adding Payee.");
			String AccountNumberXpath = "//XCUIElementTypeStaticText[@name='" + AccountNumber + "']";
			MobileElement AccountNumberElement = (MobileElement) driver.findElement(By.xpath(AccountNumberXpath));
			Asserts.assertEquals(getTexOfElement(AccountNumberElement), AccountNumber,
					AccountNumber + " is not matching after adding payee");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verify Account Number ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify Account Number ", e);
		}
	}

	@Step("Verify Validation For Payee Add.")
	public void verifyValidationForPayeeAdd(String ExpectedRecipientName, String BankName, String AccountNumber)
			throws Exception {
		try {
			verifyLogOutButton();
			verifyMakeTransferButton();
			verifyCloseButton();
			VerifyRecipientName(ExpectedRecipientName);
			VerifyBankName(BankName);
			VerifyAccountNumber(AccountNumber);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify Validation For Payee Add. ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify Validation For Payee Add. ",
					e);
		}
	}

	@Step("Verify Bank Name")
	public void VerifyBankName(String BankName) throws Exception {
		try {
			Asserts.assertTrue(RecipientBankText.isDisplayed(),
					"'Recipient's Bank' text is not dispalying After adding Payee.");
			String BankNameXpath = "//XCUIElementTypeStaticText[@name='" + BankName + "']";
			MobileElement BankNameElement = (MobileElement) driver.findElement(By.xpath(BankNameXpath));
			Asserts.assertEquals(getTexOfElement(BankNameElement), BankName,
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
			Asserts.assertTrue(RecipientNameText.isDisplayed(),
					"'Recipient's Name' text is not dispalying After adding Payee.");
			String RecipientNameXpath = "//XCUIElementTypeStaticText[@name='" + ExpectedRecipientName + "']";
			MobileElement RecipientNameElement = (MobileElement) driver.findElement(By.xpath(RecipientNameXpath));
			Asserts.assertEquals(getTexOfElement(RecipientNameElement), ExpectedRecipientName,
					ExpectedRecipientName + " is not matching after adding payee");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verify Recipient Name ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify Recipient Name ", e);
		}
	}

	@Step("Verify Close Button")
	public void verifyCloseButton() throws Exception {
		try {
			Asserts.assertTrue(closeButton.isDisplayed(), "Close Button not found.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to verify Close Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to verify Close Button ", e);
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

	@Step("Verify 'You Have Added Recipient Msg'.")
	public void VerifyYouHaveAddedRecipientMsg() throws Exception {
		try {
			wait.fluentWaitForElement(logout);

			List<RemoteWebElement> youHaveAddedRecipient = driver.findElements(By.name("You've added a recipient"));
			Asserts.assertEquals(
					getTexOfElement((MobileElement) youHaveAddedRecipient.get(youHaveAddedRecipient.size() - 1)),
					CommonTestData.YOU_HAVE_ADDED_RECIPIENT_MSG2.getEnumValue(),
					CommonTestData.YOU_HAVE_ADDED_RECIPIENT_MSG2.getEnumValue() + " Text is not matching");

		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify 'You Have Added Recipient Msg' ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify 'You Have Added Recipient Msg' ", e);
		}
	}

	@Step("Click On 'ADD RECIPIENT NOW' button")
	public void ClickOnAddRecipientNowBtn() throws Exception {
		try {
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(ADDRecipientNowButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Click On ADD RECIPIENT NOW Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On ADD RECIPIENT NOW Button ",
					e);
		}
	}

	@Step("Click On Next Button")
	public void ClickOnNEXTButton() throws Exception {
		try {
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(NEXTButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to click on next button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to click on next button ", e);
		}
	}

	@Step("Verify 'Review Recipient's Details' page header")
	public void verifyReviewRecipientDetailsPageHeader() throws Exception {
		try {
			List<RemoteWebElement> recipientDetailsHeader = driver.findElements(By.name("Review Recipient's Details"));
			Asserts.assertTrue(
					isElementVisible2((MobileElement) recipientDetailsHeader.get(recipientDetailsHeader.size() - 1)),
					CommonTestData.REVIEW_RECIPIENT_DETAILS.getEnumValue() + " Page Header not displaying.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION",
					" Failed to Verify 'Review Recipient Details' page header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION",
					" Failed to Verify 'Review Recipient Details' page header ", e);
		}
	}

	@Step("Click On Next Button")
	public void ClickOnNextButton() throws Exception {
		try {
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(nextButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Next Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Next Button ", e);
		}
	}

	@Step("Enter Recipient Details.")
	public void EnterRecipientDetails(String ExpectedRecipientName, String BankName, String AccountNumber)
			throws Exception {
		try {
			EnterRecipientName(ExpectedRecipientName);
			SelectBankName(BankName);
			EnterAccountNumber(AccountNumber);
			clickOnDoneButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Enter Recipient Details ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Enter Recipient Details  ", e);
		}
	}

	@Step("Enter Account Number")
	public void EnterAccountNumber(String AccountNumber) throws Exception {
		try {
			List<RemoteWebElement> enterAccountNumberEditField = driver.findElements(By.name("Enter account no."));
			enterTextInTextbox((MobileElement) enterAccountNumberEditField.get(enterAccountNumberEditField.size() - 1),
					AccountNumber);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Enter Account Number ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Enter Account Number ", e);
		}
	}

	@Step("Enter Recipient Name")
	public void EnterRecipientName(String ExpectedRecipientName) throws Exception {
		try {
			List<RemoteWebElement> recipientName = driver.findElements(By.name("Enter recipient's name"));
			enterTextInTextbox((MobileElement) recipientName.get(recipientName.size() - 1), ExpectedRecipientName);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Enter Recipient Name ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Enter Recipient Name ", e);
		}
	}

	@Step("Select Bank Name")
	public void SelectBankName(String BankName) throws Exception {
		try {
			List<RemoteWebElement> selectBankDropdown = driver.findElements(By.name("Select bank"));
			clickOnElement((MobileElement) selectBankDropdown.get(selectBankDropdown.size() - 1));
			List<RemoteWebElement> searchBankNameField = driver.findElements(By.name("Search Bank Name"));
			clickOnElement((MobileElement) searchBankNameField.get(searchBankNameField.size() - 1));
			enterTextInTextbox((MobileElement) searchBankNameField.get(searchBankNameField.size() - 1), BankName);

			MobileElement Selectbank = (MobileElement) driver.findElement(By.name(BankName));
			clickOnElement(Selectbank);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select Bank Name ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select Bank Name ", e);
		}
	}

	@Step("click on done button")
	public void clickOnDoneButton() throws Exception {
		try {
			if (isElementVisible2(doneButton))
				clickOnElement(doneButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Done Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Done Button ", e);
		}
	}

	@Step("Verify 'Enter Recipient Details' page header")
	public void verifyEnterRecipientDetailsPageHeader() throws Exception {
		try {
			List<RemoteWebElement> recipientDetailsHeader = driver.findElements(By.name("Enter Recipient's Details"));
			Asserts.assertTrue(
					isElementVisible2((MobileElement) recipientDetailsHeader.get(recipientDetailsHeader.size() - 1)),
					" 'Enter Recipient's Details' Page Header not displaying.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION",
					" Failed to Verify 'Enter Recipient Details' page header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION",
					" Failed to Verify 'Enter Recipient Details' page header ", e);
		}
	}

	@Step("Select Bank Account.")
	public void SelectBankAccount() throws Exception {
		try {
			int count = 0;
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			do {
				clickOnElement(SelectBankAccount);
				Thread.sleep(2000);
			} while (isElementVisible2(SelectBankAccount) && count < 3);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select Bank Account ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select Bank Account ", e);
		}
	}

	@Step("Verify 'Local Transfer Pay Now' page header")
	public void verifyLocalTransferPayNowPageHeader() throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.or(ExpectedConditions.presenceOfElementLocated(MobileBy.iOSNsPredicateString(
					"type == 'XCUIElementTypeStaticText' AND name == 'Local Transfer & PayNow'  AND visible== 1")),
					ExpectedConditions.presenceOfElementLocated(MobileBy.iOSNsPredicateString(
							"type == 'XCUIElementTypeOther' AND name == 'Local Transfer & PayNow'  AND visible== 1"))));

//			wait.fluentWaitForElement(LocalTransferPayNowPageHeader);
//			Asserts.assertTrue(isElementVisible(LocalTransferPayNowPageHeader),
//					" 'Local Transfer & Pay Now' Page Header not displaying.");
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION",
					" Failed to Verify 'Local Transfer Pay Now' page header ", e);
		}
	}

	@Step("Click On Add Local Recipient Button.")
	public void clickOnAddLocalRecipientBtn() throws Exception {
		try {
			if (isElementVisible2(AddRecipientNowButton)) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				clickOnElement(AddRecipientNowButton);
			} else {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				clickOnElement(AddLocalRecipientButton);
			}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Click On Add Local Recipient Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Click On Add Local Recipient Button ", e);
		}
	}

	@Step("Click on 'Close' Button.")
	public void ClickOnCloseButton() throws Exception {
		try {
			if (isElementVisible2(closeButton)) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				clickOnElement(closeButton);
			}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Click on 'Close' Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Click on 'Close' Button ", e);
		}
	}

	@Step("Verify 'Review Transfer' page header")
	public void verifyReviewTransferPageHeader(String expectedText) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.or(
					ExpectedConditions.presenceOfElementLocated(MobileBy.iOSNsPredicateString(
							"type == 'XCUIElementTypeStaticText' AND name == 'Review Transfer'  AND visible== 1")),
					ExpectedConditions.presenceOfElementLocated(MobileBy.iOSNsPredicateString(
							"type == 'XCUIElementTypeOther' AND name == 'Review Transfer'  AND visible== 1"))));
			
			if(isElementVisible2(reviewTransfer))
				Asserts.assertEquals(getTexOfElement(reviewTransfer).trim().toLowerCase(), expectedText.toLowerCase(),expectedText + " Header Title is not found");
			else
				Asserts.assertEquals(getTexOfElement(reviewTransfer1).trim().toLowerCase(), expectedText.toLowerCase(),expectedText + " Header Title is not found");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION", " Failed to verify 'Review Transfer' page header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION", " Failed to verify 'Review Transfer' page header ", e);
		}
	}
	
	
	@Step("Verify 'SGD Currency Field' and Enter Amount '11'")
	public void enterAmountAndVerifySgdCurrency(String Amount) throws Exception {
		try {
			enterTextInTextbox(amountField, Amount);
			clickOnDoneButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to verify SGD Currency field and enter amount", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to verify SGD Currency field and enter amount  ", e);
		}
	}

	@Step("Verify 'Transfer to Other Banks' page header")
	public void verifyTransferToOtherBankPageHeader(String expectedText) throws Exception {
		try {
			wait.fluentWaitForElement(transferToOtherBanksHeader);
			Asserts.assertEquals(getTexOfElement(transferToOtherBanksHeader).trim().toLowerCase(),
					expectedText.toLowerCase(), expectedText + " Header Title is not found");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION", " Transfer to Other Banks' page header ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION", " Transfer to Other Banks' page header ", e);
		}
	}

	@Step("Click on 'TransferViaFast Toggle' to disable fast service.")
	public void DisableToTransferViaFastToggle() throws Exception {
		try {
			gestUtils.scrollUPtoObjectIos(null, null, TransferViaFastTransferToggle);
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(TransferViaFastTransferToggle);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					"Failed to click on fast toggle to disable it", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to click on fast toggle to disable it  ", e);
		}
	}

	@Step("Verify Immediate text")
	public void VerifyImmediateText(String ActualSelectedDate) throws Exception {
		try {
			String ExpectedSelectedDate = getTexOfElement(TransferDateTextElement);
			Asserts.assertEquals(ActualSelectedDate, ExpectedSelectedDate,
					"Immediate text is not Matching in date section.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Verify Immediate Text ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", "Failed to Verify Immediate Text. ", e);
		}
	}

	@Step("Enter Amount On Fund Transfer Page.")
	public void EnterAmount(String textToEnter) throws Exception {
		try {
			clickOnElement(AmountEditableField);
			enterTextInTextbox(AmountEditableField, textToEnter);
			if (isElementVisible2(doneButton))
				ClickOnDoneButton();
			// hideKeyboard();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Enter Amount ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Enter Amount ", e);
		}
	}

	@Step("Click On Done Button.")
	public void ClickOnDoneButton() throws Exception {
		try {
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(doneButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Done Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Done Button ", e);
		}
	}

	@Step("Click On Next Button.")
	public void ClickOnNextButtonToInitiateFundTransfer() throws Exception {
		try {
			gestUtils.scrollUPtoObjectIos("name", "NEXT", NEXTButton);
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(NEXTButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Next Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Next Button  ", e);
		}
	}

	@Step("Select Future Date Through Calendar and verifies the selected 'future date'.")
	public void SelectFutureDate() throws Exception {
		try {
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(TransferDateTextElement);
			MobileElement currentDateElement = (MobileElement) driver
					.findElement(MobileBy.xpath("//*[contains(@name, '_selected')]"));
			String currentDate = currentDateElement.getText();
			if (currentDate.equals("31") || currentDate.equals("30") || currentDate.equals("29")
					|| currentDate.equals("28")) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				clickOnElement(StaticDate);// selected date is 6
				ClickOnConfirmButton();
				String ActualSelectedDate1 = getTexOfElement(TransferDateTextElement);
				// Remove leading zero
				String strPattern = "^0+(?!$)";
				String[] arr = ActualSelectedDate1.split(" ");
				String ActualSelectedDate = ActualSelectedDate1.split(" ")[0];
				ActualSelectedDate = ActualSelectedDate.replaceAll(strPattern, "");
				Asserts.assertEquals(ActualSelectedDate1, "6 " + arr[1] + " " + arr[2],
						"Selected Date is not Matching");
			} else {
				int futureDate = Integer.parseInt(currentDate) + 1;
				String CalendardateXpath = "//XCUIElementTypeCell//XCUIElementTypeOther//XCUIElementTypeStaticText[@name=calendarDayCell.TextLabel_"
						+ futureDate + "_normal]";

				MobileElement Calendardate = (MobileElement) driver.findElement(By.xpath(CalendardateXpath));
				if (Calendardate.isEnabled())
					clickOnElement(Calendardate);

				ClickOnConfirmButton();
				String ExpectedDate = Integer.toString((futureDate));
				String ActualSelectedDate1 = getTexOfElement(TransferDateTextElement);
				String[] arr = ActualSelectedDate1.split(" ");
				String strPattern = "^0+(?!$)";
				String ActualSelectedDate = ActualSelectedDate1.replaceAll(strPattern, "");
				Asserts.assertEquals(ActualSelectedDate1, ExpectedDate + " " + arr[1] + " " + arr[2],
						"Selected Date is not Matching");
			}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to select future date and verification  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to select future date and verification ", e);
		}
	}

	@Step("Verify 'Non-Fast' Service On Review Page")
	public void VerifyNonFastServiceOnReviewPage() throws Exception {
		try {
			gestUtils.scrollUPtoObject("text", "TRANSFER NOW", TransferNowBtn);
			Asserts.assertTrue(NonFastTransactionService.isDisplayed(),
					"Non-Fast Service not available on review page.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to verify non fast service on Review Page ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to verify non fast service on Review Page  ", e);
		}
	}

	@Step("Click on Transfer Now Button.")
	public void ClickOnTransferNowBtn() throws Exception {
		try {
			gestUtils.scrollUPtoObject(null, null, null);
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(TransferNowBtn);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to CLick on transfer now Button ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to CLick on transfer now Button ", e);
		}
	}

	@Step("Verifies Transfer Submitted Message")
	public void VerifiesTransferSubmittedMessage(String SuccessMsg) throws Exception {
		try {
			// if (isElementVisible(ImageForPaymentSuccess))
			wait.waitForElementVisibility(TransferSuccessMsgElement);
			Asserts.assertEquals(getTexOfElement(TransferSuccessMsgElement), SuccessMsg,
					SuccessMsg + " Text is not matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verify success message ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify success message  ", e);
		}
	}

	@Step("Verify Elements On Transfer Submitted Page")
	public void VerifyElementsOnTransferSubmittedPage(String ExpectedFromBankName, String ExpectedToBankName,
			String ExpectedToRecipientName) throws Exception {
		try {
			VerifyLogOutButton();
			VerifyMakeAnotherTransferButton();
			// VerifyAmount(CommonTestData.AMOUNTTO_TRANSFERFUND.getEnumValue());
			// VerifyFromBankName(ExpectedFromBankName);
			VerifyToRecipientName(ExpectedToRecipientName);
			VerifyToBankName(ExpectedToBankName);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					"failed to Verify Elements On Transfer Submitted Page ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" failed to Verify Elements On Transfer Submitted Page  ", e);
		}
	}

	@Step("Verify MAKE ANOTHER TRANSFER button.")
	public void VerifyMakeAnotherTransferButton() throws Exception {
		try {
			gestUtils.scrollUPtoObject("text", "MAKE ANOTHER TRANSFER", MakeAnotherTransferBtn);
			Asserts.assertTrue(MakeAnotherTransferBtn.isDisplayed(), "Make Another Transfer Button not found.");
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

	@Step("Verify 'To Bank Name' On Transfer submitted Page.")
	public void VerifyToBankName(String ExpectedToBankName) throws Exception {
		try {
			Asserts.assertEquals(getTexOfElement(ToBankName).trim(), ExpectedToBankName,
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
			Asserts.assertEquals(getTexOfElement(RecipientName), ExpectedToRecipientName,
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

	@Step("Verify 'Non-Fast' Service On Review Page")
	public void VerifyFastServiceInReview() throws Exception {
		try {
			gestUtils.scrollUPtoObject("text", "TRANSFER NOW", TransferNowBtn);
			Asserts.assertTrue(FastTransactionService.isDisplayed(), "Non-Fast Service not available on review page.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to verify non fast service on Review Page ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to verify non fast service on Review Page  ", e);
		}
	}

	@Step("Click On 'Expandable button' And scroll Down to 'Reference No.' text")
	public void ClickOnExpandbutton() throws Exception {
		try {
			clickOnElement(FooterExpandableBtn);
			gestUtils.scrollUPtoObject("text", "Reference No.", ReferenceNumberText);

			Asserts.assertEquals(getTexOfElement(ReferenceNumberText), CommonTestData.REFERENCE_NUMBER.getEnumValue(),
					"'Reference no Field' is not found");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to click on expandable button and scroll down to reference", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to click on expandable button and scroll down to reference ", e);
		}
	}

	@Step("Click On Confirm Button.")
	public void ClickOnConfirmButton() throws Exception {
		try {
			clickOnElement(ConfirmBtn);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Confirm Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Confirm Button   ", e);
		}
	}

	@Step("Click On Back Icon.")
	public void ClickOnBackIcon() throws Exception {
		try {
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(CloseBtn);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Back Icon  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Back Icon  ", e);
		}
	}

}
