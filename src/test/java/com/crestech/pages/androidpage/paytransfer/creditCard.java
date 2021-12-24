package com.crestech.pages.androidpage.paytransfer;

import java.time.Duration;
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

/**
 * @author Divya
 *
 */
public class creditCard extends CommonAppiumTest{

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
	
	@ElementDescription(value = "Amount Field")
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,':id/appCompatEditText')]")
	private MobileElement AmountEditableField;
	
	@ElementDescription(value = "Select Fund Source")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Select Fund Source']")
	private MobileElement SelectFundSourceText;
	
	@ElementDescription(value = "Select Account List")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/text_src_acc_name')]")
	private List<MobileElement> sourceAccountList;
	
	@ElementDescription(value = "OK Button")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
	private MobileElement OKButton;
	
	@ElementDescription(value = "Transfer Date Text Element")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/text_transfer_date')]")
	private MobileElement TransferDateTextElement;
	
	@ElementDescription(value = "Next button")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='NEXT']")
	private MobileElement nextButton;
	
	@ElementDescription(value = "Log Out Button")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Log Out']")
	private MobileElement LOGOUTButton;
	
	@ElementDescription(value = "Pay Now Button")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='PAY NOW']")
	private MobileElement PayNowButton;
	
	@ElementDescription(value = "Page Header List")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'id/text')]")
	private List<MobileElement> PageHeaderList;
	
	@ElementDescription(value = "Footer Expandable Button")
	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,':id/ic_logo_footer_iv')]")
	private MobileElement FooterExpandableBtn;
	
	@ElementDescription(value = "Reference Number Text")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Reference No.']")
	private MobileElement ReferenceNumberText;
	
	@ElementDescription(value = "MAKE ANOTHER PAYMENT BUTTON")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='MAKE ANOTHER PAYMENT']")
	private MobileElement MakeAnotherPaymentBtn;
	
	@ElementDescription(value = "Back Icon")
	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,':id/back_icon')]")
	private MobileElement BackIcon;
	
	@ElementDescription(value = "Credit Card Page Header.")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/text_toolbar_title')]")
	private MobileElement CreditCard_PageHeader;
	
	@ElementDescription(value = "FundTransferDetailsList")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/tv_lable1')]")
	private List<MobileElement> FundTransferDetailslabel1List;

	@ElementDescription(value = "FundTransferDetailsList")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/tv_lable2')]")
	private List<MobileElement> FundTransferDetailslabel2List;

	@ElementDescription(value = "FundTransferDetailsList")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/tv_lable3')]")
	private List<MobileElement> FundTransferDetailslabel3List;
	
	@ElementDescription(value = "Account name list:- Contains From Account and To Account")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/tv_lable2')]")
	private List<MobileElement> AccountNameList;
	
	@ElementDescription(value = "SHARE PAYMENT DETAILS Button.")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='SHARE PAYMENT DETAILS']")
	private MobileElement SharePaymentDetailsButton;

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

	@Step("Click On 'Expandable button' And scroll Down to 'Reference No.' text")
	public void ClickOnExpandbutton() throws Exception {
		try {
			clickOnElement(FooterExpandableBtn);
			gestUtils.scrollUPtoObject("text", "Reference No.", ReferenceNumberText);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION"," Failed to click on expandable button and scroll down to reference", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION"," Failed to click on expandable button and scroll down to reference ", e);
		}
	}

	@Step("Click On Pay Now Button.")
	public void ClickOnPayNowButton() throws Exception {
		try {
			clickOnElement(PayNowButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Pay Now Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Pay Now Button ", e);
		}
	}
	
	@Step("Verify Details After Submit Payment")
	public void VerifyDetailsAfterSubmitPayment() throws Exception {
		try {
			MobileElement element = null;
			element = getElement(PageHeaderList,CommonTestData.PAYMENT_SUBMITTED.getEnumValue());
			if (element != null)
				verifySuccessMessage(CommonTestData.PAYMENT_SUBMITTED.getEnumValue(), element);

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
			obj_handleexception.throwHandleException("ELEMENTNOTINLIST_EXCEPTION"," Failed to get Element :: " + elementTextToBeVerified , e);
		} catch (Exception e) {
			obj_handleexception.throwException("ELEMENTNOTINLIST_EXCEPTION", " Failed to get Element :: " + elementTextToBeVerified, e);
		}
		return element;
	}
	
	@Step("Verify Success Message")
	public void verifySuccessMessage(String expectedText, MobileElement ele) throws Exception {
		try {
			wait.fluentWaitForElement(ele);
			Asserts.assertEquals(getTexOfElement(ele).toLowerCase(), expectedText.toLowerCase(),
					"'Header Title' is not Matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION", " Failed to verify Success Message ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION", " Failed to verify Success Message ", e);
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
	
	@Step("Click On Next Button.")
	public void ClickOnNextButton() throws Exception {
		try {
				gestUtils.scrollUPtoObject("text", "NEXT", nextButton);
				clickOnElement(nextButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Next Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Next Button  ", e);
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
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to select any fund source account  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", "Failed to select any fund source account  ", e);
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
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Handle Of 'Primary Source Of Fund' Popup  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Handle Of 'Primary Source Of Fund' Popup  ", e);
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
	
	public void verifyPageHeader(String expectedText, MobileElement ele) throws Exception {
		try {
			wait.fluentWaitForElement(ele);
			Asserts.assertEquals(getTexOfElement(ele).toLowerCase(), expectedText.toLowerCase(),
					"'Header Title' is not Matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION", " Failed to verify page header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION", " Failed to verify page header ", e);
		}
	}
	
	@Step("Verify 'Review Payment' page header")
	public void verifyReviewPaymentPageHeader(String expectedText) throws Exception {
		try {
			MobileElement element = null;
			element = getElement(PageHeaderList, CommonTestData.REVIEW_PAYMENT_PAGEHEADER.getEnumValue());
			if (element != null)
				verifyPageHeader(CommonTestData.REVIEW_PAYMENT_PAGEHEADER.getEnumValue(), element);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION", " Failed to verify 'Review Payment' page header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION", " Failed to verify 'Review Payment' page header ", e);
		}
	}
	
	@Step("Verify 'Credit Card' page header")
	public void verifyCreditCardPageHeader(String expectedText) throws Exception {
		try {
			wait.fluentWaitForElement(CreditCard_PageHeader);
			Asserts.assertEquals(getTexOfElement(CreditCard_PageHeader).toLowerCase(), expectedText.toLowerCase(),
					"'Header Title' is not Matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION", " Failed to verify 'Credit Card' page header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION", " Failed to verify 'Credit Card' page header ", e);
		}
	}
	
	@Step("Verify Some Details After Credit Card Fund Transfer.")
	public void VerifySomeDetailsAfterCreditCardFundTransfer(String ExpectedFromBankName,
			String ExpectedFromAccountNumber, String ExpectedToAccountNumber, String ExpectedToCreditCardName)
			throws Exception {
		try {
			String[] ExpTitleList = new String[] { "From", "To", "When", "Latest Balance", "Reference No." };
			verifyTitles(ExpTitleList, FundTransferDetailslabel1List);

			VerifyFromBankName(ExpectedFromBankName);
			VerifyCreditCardName(ExpectedToCreditCardName);
			VerifyFromAccountNumber(ExpectedFromAccountNumber);
			VerifyToAccountNumber(ExpectedToAccountNumber);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					"  Failed to Verify Some Details After Credit Card Fund Transfer ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify Some Details After Credit Card Fund Transfer ", e);
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


	@Step("Verify 'To Account Number' On Transfer submitted Page.")
	public void VerifyToAccountNumber(String ExpectedToAccountNumber) throws Exception {
		try {
			Asserts.assertEquals(getTexOfElement(FundTransferDetailslabel3List.get(1)),
					ExpectedToAccountNumber, ExpectedToAccountNumber + " is not matching after Fund Transfer.");

		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify 'To Account Number' On Transfer submitted Page. ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify 'To Account Number' On Transfer submitted Page. ", e);
		}
	}

	@Step("Verify 'From Account Number' On Transfer submitted Page.")
	public void VerifyFromAccountNumber(String ExpectedFromAccountNumber) throws Exception {
		try {
			Asserts.assertEquals(getTexOfElement(FundTransferDetailslabel3List.get(0)),
					ExpectedFromAccountNumber, ExpectedFromAccountNumber + " is not matching after Fund Transfer.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify 'From Account Number' On Transfer submitted Page. ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify 'From Account Number' On Transfer submitted Page. ", e);
		}
	}

	@Step("Verify 'Credit Card Name' On Transfer submitted Page.")
	public void VerifyCreditCardName(String ExpectedToCreditCardName) throws Exception {
		try {
			Asserts.assertEquals(getTexOfElement(FundTransferDetailslabel2List.get(1)),
					ExpectedToCreditCardName,
					ExpectedToCreditCardName + " is not matching after Fund Transfer Credit Cards.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify 'Credit Card Name' On Transfer submitted Page. ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify 'Credit Card Name' On Transfer submitted Page. ", e);
		}
	}
	
}
