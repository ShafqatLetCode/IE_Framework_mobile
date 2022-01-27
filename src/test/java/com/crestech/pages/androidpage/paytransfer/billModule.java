package com.crestech.pages.androidpage.paytransfer;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
	
	@ElementDescription(value = "Add Recipient Now Button")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='ADD RECIPIENT NOW']")
	private MobileElement AddRecipientNowBtn;
	
	@ElementDescription(value = "Add Billing Organisation")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Add Billing Organisation']")
	private MobileElement AddBillingOrganisation;
	
	@ElementDescription(value = "Enter reference no. Edit Field")
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,':id/editTextId')]")
	private MobileElement EnterReferenceNoEditField;
	
	@ElementDescription(value = "Select Billing Organisation")
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,':id/edit_user_id')]")
	private MobileElement SelectBillingOrganisation;

	@ElementDescription(value = "Search For Billing Organisation Field")
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Search for a billing organisation']")
	private MobileElement SearchForBillingOrganisationField;

	@ElementDescription(value = "Select Searched Option For Billing Organisation Field")
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[contains(@resource-id,':id/layout_acc_details')]")
	private MobileElement SelectSearchedOption;
	
	@ElementDescription(value = "Next button")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='NEXT']")
	private MobileElement nextButton;
	
	@ElementDescription(value = "Billing Organisation")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Billing Organisation']")
	private MobileElement BillingOrganisation;

	@ElementDescription(value = "Bill Reference No")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Bill Reference No.']")
	private MobileElement BillReferenceNo;
	
	@ElementDescription(value = "MAKE A PAYMENT BUTTON")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='MAKE A PAYMENT']")
	private MobileElement MakeAPaymentButton;
	
	@ElementDescription(value = "Pay Now Button")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='PAY NOW']")
	private MobileElement PayNowButton;
	
	@ElementDescription(value = "Page Header")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'id/text')]")
	private MobileElement PageHeader;
	
	@ElementDescription(value = "Page Header List")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'id/text')]")
	private List<MobileElement> PageHeaderList;
	
	@ElementDescription(value = "Success Tick Image View")
	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,':id/imgView_ic_success_tick')]")
	private MobileElement SuccessTickImageView;
	
	@ElementDescription(value = "MAKE ANOTHER PAYMENT BUTTON")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='MAKE ANOTHER PAYMENT']")
	private MobileElement MakeAnotherPaymentBtn;
	
	@ElementDescription(value = "Amount Field For Bill Org")
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,':id/appCompatEditText')]")
	private MobileElement AmountEditableField;

	@ElementDescription(value = "Log Out Button")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Log Out']")
	private MobileElement LOGOUTButton;
	
	@ElementDescription(value = "SHARE PAYMENT DETAILS Button.")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='SHARE PAYMENT DETAILS']")
	private MobileElement SharePaymentDetailsButton;
	
	@ElementDescription(value = "Back Icon")
	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,':id/back_icon')]")
	private MobileElement BackIcon;
	
	@ElementDescription(value = "Transfer Date Text Element")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/text_transfer_date')]")
	private MobileElement TransferDateTextElement;
	
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
	
	@Step("Click On Back Icon.")
	public void ClickOnBackIcon() throws Exception {
		try {
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(BackIcon);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Back Icon  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Back Icon  ", e);
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
	
	@Step("Verify Details After Submit Payment")
	public void VerifyDetailsAfterSubmitPayment() throws Exception {
		try {
			MobileElement element = null;
			element = getElement(PageHeaderList,CommonTestData.PAYMENT_SUBMITTED.getEnumValue());
			if (element != null)
				verifyPaymentSubmittedMessage(CommonTestData.PAYMENT_SUBMITTED.getEnumValue(), element);

			VerifyTransferredAmount(CommonTestData.AMOUNTTO_TRANSFERFUND.getEnumValue());
			VerifyLogOutButton();
			VerifyMakeAnotherPaymentButton();
			VerifySharePaymentDetailsButton();
			VerifyBackIcon();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify Details After Submit Payment ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify Details After Submit Payment ", e);
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
	
	@Step("Verify 'Review Payment' Page Header")
	public void VerifyReviewPaymentPageHeader() throws Exception {
		try {
			MobileElement element = null;
			element = getElement(PageHeaderList,CommonTestData.REVIEW_PAYMENT_PAGEHEADER.getEnumValue());
			if (element != null){
				wait.fluentWaitForElement(element);
				Asserts.assertEquals(getTexOfElement(element).toLowerCase(), CommonTestData.REVIEW_PAYMENT_PAGEHEADER.getEnumValue().toLowerCase(), 
						"'Header Title' is not Matching");
				}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION"," Failed to Verify 'Review Payment' Page Header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION"," Failed to Verify 'Review Payment' Page Header ", e);
		}
	}
	
	@Step("clicking On 'ADD RECIPIENT NOW' button")
	public void ClickOnAddRecipientNowBtn() throws Exception {
		try {
			gestUtils.scrollUPtoObject("text", "ADD RECIPIENT NOW", AddRecipientNowBtn);
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(AddRecipientNowBtn);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION"," Failed to Click On Add Recipient Now Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Add Recipient Now Button  ",e);
		}
	}
	
	@ElementDescription(value = "'Review Recipient's Details' Page Header")
	@AndroidFindBy(xpath = "//android.widget.RelativeLayout//android.widget.TextView[contains(@resource-id,':id/text')]")
	private MobileElement ReviewRecipientDetailsPageHeader;
	
	@Step("Verify 'Review Recipient's Details' Page Header")
	public void VerifyReviewRecipientDetailsPageHeader(String expectedText) throws Exception {
		try {
			wait.fluentWaitForElement(ReviewRecipientDetailsPageHeader);
			Asserts.assertEquals(getTexOfElement(ReviewRecipientDetailsPageHeader).toLowerCase(), expectedText.toLowerCase(),
					"'Header Title' is not Matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION", " Failed to Verify 'Review Recipient's Details' Page Header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION", " Failed to Verify 'Review Recipient's Details' Page Header ", e);
		}
	}
	
	@Step("Verify 'Pay To Biller' Page Header")
	public void VerifyPayToBillerPageHeader() throws Exception {
		try {
			MobileElement element = null;
			element = getElement(PageHeaderList, CommonTestData.PAY_TO_BILLER_PAGE_HEADER.getEnumValue());
			if (element != null) {
				wait.fluentWaitForElement(element);
				Asserts.assertEquals(getTexOfElement(element).toLowerCase(),
						CommonTestData.PAY_TO_BILLER_PAGE_HEADER.getEnumValue().toLowerCase(),
						"'Header Title' is not Matching");
			}

		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify 'Pay To Biller' Page Header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify 'Pay To Biller' Page Header ",
					e);
		}
	}
	
	
	public MobileElement getElement(List<MobileElement> elementList, String elementTextToBeVerified)
			throws Exception {
		MobileElement element = null;
		try {
			if (elementList.size() > 0) {
				int l = elementList.size();

				String accountFromList = null;
				for (int i = 0; i < l; i++) {
					accountFromList = elementList.get(i).getText();
					if (accountFromList.contains(elementTextToBeVerified)) {
						element = elementList.get(i);
						break;
					}
				}
				return element;
			} else
				Asserts.assertFail(elementTextToBeVerified + " not found in the list as list size is 0");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("ELEMENTNOTINLIST_EXCEPTION", " Failed to get element:: " + elementTextToBeVerified, e);
		} catch (Exception e) {
			obj_handleexception.throwException("ELEMENTNOTINLIST_EXCEPTION"," Failed to get element:: " + elementTextToBeVerified, e);
		}
		return element;
	}
	
	@Step("Verify Payment Submitted Message")
	public void verifyPaymentSubmittedMessage(String expectedText, MobileElement ele) throws Exception {
		try {
			wait.fluentWaitForElement(ele);
			Asserts.assertEquals(getTexOfElement(ele).toLowerCase(), expectedText.toLowerCase(), 
					"'Header Title' is not Matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION", " Failed to Verify Payment Submitted Message", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION", " Failed to Verify Payment Submitted Message ", e);
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


	@Step("Verify Transferred Amount.")
	public void VerifyTransferredAmount(String ExpectedAmt) throws Exception {
		try {
			Asserts.assertEquals(getTexOfElement(AmountEditableField), ExpectedAmt + ".00",
					ExpectedAmt + " Text is not matching.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Transferred Amount ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to  Transferred Amount ", e);
		}
	}

	@Step("Verify Back Icon.")
	public void VerifyBackIcon() throws Exception {
		try {
			Asserts.assertTrue(BackIcon.isDisplayed(), "'Back' Icon not found.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to verify Back Icon ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to verify Back Icon ", e);
		}
	}

	@Step("Verify Share Payment Details button.")
	public void VerifySharePaymentDetailsButton() throws Exception {
		try {
			Asserts.assertTrue(SharePaymentDetailsButton.isDisplayed(),
					"'Share Payment Details' Button not found.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to verify Share Payment Details Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to verify Share Payment Details Button ", e);
		}
	}

	@Step("Verify MAKE ANOTHER Payment button.")
	public void VerifyMakeAnotherPaymentButton() throws Exception {
		try {
			gestUtils.scrollUPtoObject("text", "MAKE ANOTHER PAYMENT", MakeAnotherPaymentBtn);
			Asserts.assertTrue(MakeAnotherPaymentBtn.isDisplayed(),
					"Make Another payment Button not found.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to verify MAKE ANOTHER PAYMENT Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to verify MAKE ANOTHER PAYMENT Button ",
					e);
		}
	}
	
	@Step("Click On Pay Now Button.")
	public void ClickOnPayNowButton() throws Exception {
		try {
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(PayNowButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Pay Now Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Pay Now Button ", e);
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

	@Step("Verifies Billing Organisation And Bill Reference Number.")
	public void VerifyBillingOrganisationAndBillReferenceNumber(String AccountName, String ReferenceNum)
			throws Exception {
		try {
			if (isElementVisible(BillingOrganisation)
					&& isElementVisible(BillReferenceNo)) {

				String ActualAccountNameXpath = "//android.widget.TextView[@text='" + AccountName + "']";
				MobileElement ActualAccountNameEle = (MobileElement) driver
						.findElement(By.xpath(ActualAccountNameXpath));
				Asserts.assertEquals(getTexOfElement(ActualAccountNameEle), AccountName,
						AccountName + " Text is not matching");

				String ActualReferenceNumberXpath = "//android.widget.TextView[@text='" + ReferenceNum + "']";
				MobileElement ActualReferenceNumberEle = (MobileElement) driver
						.findElement(By.xpath(ActualReferenceNumberXpath));
				Asserts.assertEquals(getTexOfElement(ActualReferenceNumberEle), ReferenceNum,
						ReferenceNum + " Text is not matching");
			}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify Billing Organisation Details After Adding Payee ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify Billing Organisation Details After Adding Payee ", e);
		}
	}

	@Step("Click On Add Billing Organisation.")
	public void ClickOnAddBillingOrganisation() throws Exception {
		try {
			if (isElementVisible2(AddRecipientNowBtn)) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				clickOnElement(AddRecipientNowBtn);
			} else {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				clickOnElement(AddBillingOrganisation);
			}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Click On Add Billing Organisation Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Click On Add Billing Organisation Button ", e);
		}
	}

	@Step("Enter Reference Number")
	public void EnterReferenceNumber(String ReferenceNo) throws Exception {
		try {
			clickOnElement(EnterReferenceNoEditField);
			enterTextInTextbox(EnterReferenceNoEditField, ReferenceNo);
			hideKeyboard();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Enter Reference Number ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Enter Reference Number ", e);
		}
	}

	@Step("Select Billing Organisation")
	public void SelectBillingOrganisation(String AccountName) throws Exception {
		try {
			wait.waitForElementToBeClickable(SelectBillingOrganisation); 
			clickOnElement(SelectBillingOrganisation);
			clickOnElement(SearchForBillingOrganisationField);
			enterTextInTextbox(SearchForBillingOrganisationField, AccountName);
			pressKey(driver, Keys.ENTER);
			clickOnElement(SelectSearchedOption);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select Billing Organisation ",e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select Billing Organisation ", e);
		}
	}

	@Step("Enter Billing Organisation Details.")
	public void EnterBillingOrganisationDetails(String AccountName, String ReferenceNo) throws Exception {
		try {
			SelectBillingOrganisation(AccountName);
			EnterReferenceNumber(ReferenceNo);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION"," Failed to Enter Billing Organisation Details ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Enter Billing Organisation Details ",e);
		}
	}
	
	@Step("Click On Next Button.")
	public void ClickOnNextButton() throws Exception {
		try {
			gestUtils.scrollUPtoObject("text", "NEXT", nextButton);
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(nextButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Next Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Next Button  ", e);
		}
	}
}
