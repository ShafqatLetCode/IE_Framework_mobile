package com.crestech.pages.iospage.paytransfer;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
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
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class billModule extends CommonAppiumTest{
	
	public AppiumDriver<RemoteWebElement> driver = null;
	HandleException obj_handleexception = null;
	GestureUtils gestUtils = null;
	
	public billModule(AppiumDriver<RemoteWebElement> driver) throws Exception {
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
	
	@ElementDescription(value = "Add Recipient Now button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='ADD RECIPIENT NOW']")
	private MobileElement AddRecipientNowButton;
	
	@ElementDescription(value = "'Add Billing Organisation' Button.")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Add Billing Organisation'])[1]")
	private MobileElement AddBillingOrganisation;
	
	@ElementDescription(value = "Done button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Done']")
	private MobileElement doneButton;
	
	@ElementDescription(value = "'Enter reference no.' Edit Field.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='Enter reference no.']")
	private MobileElement EnterReferenceNoEditField;
	
	@ElementDescription(value = "'Select Fund Source' Add Button.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='Select billing organisation']")
	private MobileElement SelectBillingOrganisation;
	
	@ElementDescription(value = "'Search for a billing organisation' Edit Field.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSearchField[@name='Search for a billing organisation']")
	private MobileElement SearchForBillingOrganisationField;
	
	@ElementDescription(value = "Next Button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='NEXT']")
	private MobileElement nextButton;
	
	@ElementDescription(value = "'Review Recipient's Details' Page Header")
	@FindBy(name = "Review Recipient's Details")
	private MobileElement ReviewRecipientDetailsPageHeader;
	
	@ElementDescription(value = "'Payee Bill Payment Details List'.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell//XCUIElementTypeStaticText")
	private List<MobileElement> PayeeBillPaymentDetailsList;
	
	@ElementDescription(value = "Logout button on paylah")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Log Out']")
	private MobileElement logout;
	
	@ElementDescription(value = "'Add Recipient Now' Button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='ADD RECIPIENT NOW']")//
	private MobileElement ADDRecipientNowButton;
	
	@ElementDescription(value = "'Review Payment' page Header")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Review Payment']")
	private MobileElement ReviewPaymentPageHeader;
	
	@ElementDescription(value = "'TRANSFER NOW' Button.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='TRANSFER NOW']")
	private MobileElement TRANSFERNOWButton;
	
	@ElementDescription(value = "'Payment Submitted' Message.")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Payment Submitted'])[1]")
	private MobileElement PaymentSubmittedMsg;
	
	@ElementDescription(value = "next Button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='NEXT']")
	private MobileElement NEXTButton;
	
	@ElementDescription(value = "'Amount editable' Field")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='FT_Amount_Field']")
	private MobileElement AmountEditableField;
	
	@ElementDescription(value = "'Close' Button After adding Payee")
	@FindBy(name = "close")
	private MobileElement closeButton;
	
	@ElementDescription(value = "'MAKE A PAYMENT' Button.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='MAKE A PAYMENT']")
	private MobileElement MakeAPaymentButton;
	
	@ElementDescription(value = "'Pay To Biller' Page Header.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Pay to Biller']")
	private MobileElement PayToBillerPageHeader;
	
	@ElementDescription(value = "'Pay To Biller' Page Header.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Pay to Biller']")
	private MobileElement PayToBillerPageHeader2;
	
	@ElementDescription(value = "Log Out Button After adding Payee")
	@FindBy(name = "Log Out")
	private MobileElement LogoutBtn;
	
	@ElementDescription(value = "Transfer Date Clickable Element.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Immediate']")
	private MobileElement TransferDateTextElement;
	
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
	
	@Step("Verify Close Button")
	public void verifyCloseButton() throws Exception {
		try {
			Asserts.assertTrue(closeButton.isDisplayed(), "Close Button not found.");
		}catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to verify Close button.",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to verify Close button. ",e);
		}
	}
	
	@Step("Verify Make A Payment Button")
	public void verifyMakeAPaymentButton() throws Exception {
		try {
			Asserts.assertTrue(MakeAPaymentButton.isDisplayed(),
					"Make A Payment Button not found.");
		}catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to verify Make A Payment button.",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to verify Make A Payment button. ",e);
		}
	}
	
	@Step("Verify LogOut Button")
	public void verifyLogOutButton() throws Exception {
		try {
			Asserts.assertTrue(LogoutBtn.isDisplayed(), "Log Out Button not found.");
		}catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to verify log out button.",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to verify log out button. ",e);
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
	
	
	@Step("Verify 'Pay To Biller' Page Header")
	public void VerifyPayToBillerPageHeader() throws Exception {
		try {
			Thread.sleep(3000);
			if(isElementVisible2(PayToBillerPageHeader))
				Asserts.assertTrue(isElementVisible(PayToBillerPageHeader),
						CommonTestData.PAY_TO_BILLER_PAGE_HEADER.getEnumValue() + " Page Header not displaying.");
			else if(isElementVisible2(PayToBillerPageHeader2))
				Asserts.assertTrue(isElementVisible(PayToBillerPageHeader2),
						CommonTestData.PAY_TO_BILLER_PAGE_HEADER.getEnumValue() + " Page Header not displaying.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION"," Failed to Verify 'Pay To Biller' Page Header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION"," Failed to Verify 'Pay To Biller' Page Header ", e);
		}
	}
	
	@Step("Click On Make A Payment Button.")
	public void ClickOnMakeAPayment() throws Exception {
		try {
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(MakeAPaymentButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION"," Failed to Click On Make A Payment Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click on Make A Payment Button ", e);
		}
	}
	
	@Step("Click on 'Close' Button.")
	public void ClickOnCloseButton() throws Exception {
		try {
			if(isElementVisible2(closeButton)) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				clickOnElement(closeButton);
			}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Click on 'Close' Button  ",	e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Click on 'Close' Button ", e);
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

	@Step("Click On Transfer Now Button.")
	public void ClickOnTransferNowButton() throws Exception {
		try {
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(TRANSFERNOWButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Transfer Now Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Transfer Now Button ", e);
		}
	}
	
	@Step("Verify 'Review Payment' Page Header")
	public void VerifyReviewPaymentPageHeader() throws Exception {
		try {
			Asserts.assertEquals(getTexOfElement(ReviewPaymentPageHeader),
					CommonTestData.REVIEW_PAYMENT_PAGEHEADER.getEnumValue(),
					CommonTestData.REVIEW_PAYMENT_PAGEHEADER.getEnumValue() + " Text is not matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION"," Failed to Verify 'Review Payment' Page Header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION"," Failed to Verify 'Review Payment' Page Header ", e);
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
	
	@Step("Verifies Billing Organisation And Bill Reference Number.")
	public void VerifyBillingOrganisationAndBillReferenceNumber(String AccountName, String ReferenceNum)
			throws Exception {
		try {
			Asserts.assertEquals(getTexOfElement(PayeeBillPaymentDetailsList.get(0)), AccountName,
					AccountName + " Text is not matching");
			Asserts.assertEquals(getTexOfElement(PayeeBillPaymentDetailsList.get(1)), "Billing Organisation",
					"Billing Organisation" + " Text is not matching");
			Asserts.assertEquals(getTexOfElement(PayeeBillPaymentDetailsList.get(2)), ReferenceNum,
					ReferenceNum + " Text is not matching");
			Asserts.assertEquals(getTexOfElement(PayeeBillPaymentDetailsList.get(3)), "Bill Reference No.",
					"Bill Reference No." + " Text is not matching");
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verifies Billing Organisation And Bill Reference Number ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verifies Billing Organisation And Bill Reference Number ",e);
		}
	}
	
	@Step("Verify 'Review Recipient's Details' Page Header")
	public void VerifyReviewRecipientDetailsPageHeader() throws Exception {
		try {
			Asserts.assertTrue(isElementVisible(ReviewRecipientDetailsPageHeader),
					CommonTestData.REVIEW_RECIPIENT_DETAILS.getEnumValue() + " Page Header not displaying.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION", " Failed to Verify 'Review Recipient's Details' Page Header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION", " Failed to Verify 'Review Recipient's Details' Page Header ", e);
		}
	}
	
	@Step("Click On Next Button")
	public void ClickOnNextButton() throws Exception {
		try {
			    com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				clickOnElement(nextButton);
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Next Button ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Next Button ",e);
		}
	}

	
	@Step("click on done button")
	public void ClickOnDoneButton() throws Exception {
		try {
			if (isElementVisible2(doneButton))
				clickOnElement(doneButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Done Button.", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Done Button. ", e);
		}
	}
	
	@Step("Enter Billing Organisation Details.")
	public void EnterBillingOrganisationDetails(String AccountName, String ReferenceNo) throws Exception {
		try {
			SelectBillingOrganisation(AccountName);
			EnterReferenceNumber(ReferenceNo);
			ClickOnDoneButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION"," Failed to Enter Billing Organisation Details ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Enter Billing Organisation Details ",e);
		}
	}
	
	@Step("Select Billing Organisation")
	public void SelectBillingOrganisation(String AccountName) throws Exception {
		try {
			clickOnElement(SelectBillingOrganisation);
			clickOnElement(SearchForBillingOrganisationField);
			enterTextInTextbox(SearchForBillingOrganisationField, AccountName);
			
			MobileElement SelectBillingOrganisation = (MobileElement) driver.findElement(By.name(AccountName));
			clickOnElement(SelectBillingOrganisation);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select Billing Organisation ",e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select Billing Organisation ", e);
		}
	}
	
	@Step("Enter Reference Number")
	public void EnterReferenceNumber(String ReferenceNo) throws Exception {
		try {
			clickOnElement(EnterReferenceNoEditField);
			enterTextInTextbox(EnterReferenceNoEditField, ReferenceNo);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Enter Reference Number ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Enter Reference Number ", e);
		}
	}
	
	@Step("Click On Add Billing Organisation.")
	public void ClickOnAddBillingOrganisation() throws Exception {
		try {
			if(isElementVisible2(AddRecipientNowButton)) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				clickOnElement(AddRecipientNowButton);
			}
			 else {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				clickOnElement(AddBillingOrganisation);
			 }
			List<RemoteWebElement> recipientDetailsHeader = driver.findElements(By.name("Enter Recipient’s Details"));
			Asserts.assertTrue(isElementVisible2((MobileElement) recipientDetailsHeader.get(recipientDetailsHeader.size()-1)),
					" 'Enter Recipient’s Details' Page Header not displaying.");
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Bill Module & Verify Enter Recipient Page Header After Click On Add Billing Organisation.",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Bill Module & Verify Enter Recipient Page Header After Click On Add Billing Organisation. ",e);
		}
	}

}
