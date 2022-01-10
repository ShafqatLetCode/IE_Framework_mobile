package com.crestech.pages.iospage.paytransfer;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
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
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

/**
 * @author Divya
 *
 */
public class creditCard extends CommonAppiumTest {

	public AppiumDriver<RemoteWebElement> driver = null;
	HandleException obj_handleexception = null;
	GestureUtils gestUtils = null;

	public creditCard(AppiumDriver<RemoteWebElement> driver) throws Exception {
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
	
	@ElementDescription(value = "Select Fund Source list")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText")
	private List<MobileElement> selectfundSourceList;

	@ElementDescription(value = "'Select billing organisation' Dropdown.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='source_account_name']")
	private MobileElement SelectFundSourcePage;
	
	@ElementDescription(value = "Logout button on paylah")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Log Out']")
	private MobileElement logout;
	
	@ElementDescription(value = "'MAKE ANOTHER PAYMENT' Button.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='MAKE ANOTHER PAYMENT']")
	private MobileElement MakeAnotherPaymentBtn;
	
	@ElementDescription(value = "'SHARE PAYMENT DETAILS' Button.")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='SHARE PAYMENT DETAILS'])[1]")
	private MobileElement SharePaymentDetailsButton;
	
	@ElementDescription(value = "'MAKE ANOTHER PAYMENT' Button.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='arrowDown']")
	private MobileElement FooterExpandableBtn;
	
	@ElementDescription(value = "Reference No.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Reference No.']")
	private MobileElement referenceNo;

	@ElementDescription(value = "Primary source of fund")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Primary source of fund']")
	private MobileElement primarysourceOfFund;

	@ElementDescription(value = "OK Button")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
	private MobileElement OKButton;
	
	@ElementDescription(value = "next Button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='NEXT']")
	private MobileElement NEXTButton;
	
	@ElementDescription(value = "'Amount editable' Field")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='FT_Amount_Field']")
	private MobileElement AmountEditableField;
	
	@ElementDescription(value = "'Credit Card' Fund Transfer page Header")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Pay To DBS/POSB Card']")
	private MobileElement CreditCard_PageHeader;
	
	@ElementDescription(value = "'Payment Submitted' Message.")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Payment Submitted'])[1]")
	private MobileElement PaymentSubmittedMsg;
	
	@ElementDescription(value = "Done button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Done']")
	private MobileElement doneButton;
	
	@ElementDescription(value = "'Close' Button After adding Payee")
	@FindBy(name = "close")
	private MobileElement closeButton;
	
	@ElementDescription(value = "Transfer Date Clickable Element.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Immediate']")
	private MobileElement TransferDateTextElement;
	
	@ElementDescription(value = "'Review Payment' page Header")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Review Payment']")
	private MobileElement ReviewPaymentPageHeader;
	
	@Step("Verify 'Review Payment' page header")
	public void verifyReviewPaymentPageHeader() throws Exception {
		try {
			Asserts.assertEquals(getTexOfElement(ReviewPaymentPageHeader),
					CommonTestData.REVIEW_PAYMENT_PAGEHEADER.getEnumValue(),
					CommonTestData.REVIEW_PAYMENT_PAGEHEADER.getEnumValue() + " Text is not matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION", " Failed to verify 'Review Payment' page header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION", " Failed to verify 'Review Payment' page header ", e);
		}
	}
	
	@Step("Verify Immediate text")
	public void VerifyImmediateText(String ActualSelectedDate) throws Exception {
		try {
			String ExpectedSelectedDate = getTexOfElement(TransferDateTextElement);
			Asserts.assertEquals(ActualSelectedDate, ExpectedSelectedDate, "Selected Date is not Matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Verify Immediate Text ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", "Failed to Verify Immediate Text. ", e);
		}
	}
	
	@Step("Click on 'Close' Button.")
	public void ClickOnCloseButton() throws Exception {
		try {
			if(isElementVisible2(closeButton))
				clickOnElement(closeButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Click on 'Close' Button  ",	e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Click on 'Close' Button ", e);
		}
	}
	
	@Step("click on done button")
	public void ClickOnDoneButton() throws Exception {
		try {
			if (isElementVisible2(doneButton))
			clickOnElement(doneButton); 
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Click on Done Button ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Click on Done Button ", e);
		}
	}
	
	@Step("Enter Amount In Editable field to transfer fund.")
	public void EnterAmount(String textToEnter) throws Exception {
		try {
			clickOnElement(AmountEditableField);
			enterTextInTextbox(AmountEditableField, textToEnter);
			ClickOnDoneButton();
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Enter Amount In Editable field to transfer fund ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Enter Amount In Editable field to transfer fund ",e);
		}
	}
	
	@Step("Verify 'Credit Card' page header")
	public void verifyCreditCardPageHeader() throws Exception {
		try {
			wait.fluentWaitForElement(CreditCard_PageHeader);
			Asserts.assertEquals(getTexOfElement(CreditCard_PageHeader),
					CommonTestData.CREDIT_CARD_PAGEHEADER_IOS.getEnumValue(),
						CommonTestData.CREDIT_CARD_PAGEHEADER_IOS.getEnumValue() + " Text is not matching");
				
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION", " Failed to verify 'Credit Card' page header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION", " Failed to verify 'Credit Card' page header ", e);
		}
	}

	// If User has multiple accounts then select fund source account
	@Step("'Select Fund Source Account' If User has multiple accounts.")
	public void SelectFundSourceAccount(String expectedSourceAccount) throws Exception {
		try {
			if (isElementVisible2(SelectFundSourcePage)) {
				gestUtils.scrollDownIos();
				clickOnElement(SelectFundSourcePage);
				int selectedAccount = 0;
				String AccountNameList = null;
				for (int i = 0; i < selectfundSourceList.size(); i++) {
					AccountNameList = selectfundSourceList.get(i).getText();
					if (AccountNameList.equalsIgnoreCase(expectedSourceAccount)) {
						selectedAccount++;
						clickOnElement(selectfundSourceList.get(i));
						break;
					}
				}
				if (selectedAccount == 0)
					Asserts.assertFail("Select Fund Source " + expectedSourceAccount
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
	
	@Step("Click On Next Button")
	public void ClickOnNEXTButton() throws Exception {
		try {
			clickOnElement(NEXTButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to click on next button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to click on next button ", e);
		}
	}
	
	@Step("Verify Details After Submit Payment")
	public void VerifyDetailsAfterSubmitPayment() throws Exception {
		try {
				Asserts.assertEquals(getTexOfElement(PaymentSubmittedMsg),
						CommonTestData.PAYMENT_SUBMITTED.getEnumValue(),
						CommonTestData.PAYMENT_SUBMITTED.getEnumValue() + " Text is not matching");

				Asserts.assertEquals(getTexOfElement(AmountEditableField),
						CommonTestData.AMOUNTTO_TRANSFERFUND.getEnumValue() + ".00",
						CommonTestData.AMOUNTTO_TRANSFERFUND.getEnumValue() + " Text is not matching.");
		
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify Details After Submit Payment ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify Details After Submit Payment ", e);
		}
	}
	
	@Step("Verify Some Details After Credit Card Fund Transfer.")
	public void VerifySomeDetailsAfterCreditCardFundTransfer() throws Exception {
		try {
			Asserts.assertTrue(logout.isDisplayed(), "Log Out Button not found.");
			
			gestUtils.scrollUPtoObjectIos("name", "MAKE ANOTHER TRANSFER", null);
			Asserts.assertTrue(MakeAnotherPaymentBtn.isDisplayed(),
					"Make Another Transfer Button not found.");
			Asserts.assertTrue(SharePaymentDetailsButton.isDisplayed(),
					"'Share Payment Details' Button not found.");
			
			verifyReferenceNumber();
		 } catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					"  Failed to Verify Some Details After Credit Card Fund Transfer ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify Some Details After Credit Card Fund Transfer ", e);
		}
	}
	
	@Step("Verify Reference Number")
	public void verifyReferenceNumber() throws Exception {
		try {
			clickOnElement(FooterExpandableBtn);

			gestUtils.scrollUPtoObjectIos("name", "Reference No.", null);
			Asserts.assertEquals(getTexOfElement(referenceNo).trim().toLowerCase(),
					CommonTestData.REFERENCE_NUMBER.getEnumValue().toLowerCase(),
					CommonTestData.REFERENCE_NUMBER.getEnumValue() + " text is not matching.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to verify reference number ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to verify reference number ", e);
		}
	}
}
