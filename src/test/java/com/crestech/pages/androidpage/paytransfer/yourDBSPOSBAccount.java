package com.crestech.pages.androidpage.paytransfer;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import com.crestech.annotation.values.ElementDescription;
import com.crestech.appium.utils.CommonAppiumTest;
import com.crestech.common.utilities.Asserts;
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
public class yourDBSPOSBAccount extends CommonAppiumTest{

	public AppiumDriver<RemoteWebElement> driver = null;
	HandleException obj_handleexception = null;
	GestureUtils gestUtils = null;
	public yourDBSPOSBAccount(AppiumDriver<RemoteWebElement> driver) throws Exception {
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
	
	@ElementDescription(value = "Transfer Now Button")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='TRANSFER NOW']")
	private MobileElement TransferNowBtn;
	
	@ElementDescription(value = "Image ICON For Payment Success")
	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,':id/image_result')]")
	private MobileElement ImageForPaymentSuccess;
	
	@ElementDescription(value = "transfferdSubmitMsgEle")
	@AndroidFindBy(xpath = "//android.widget.RelativeLayout//android.widget.TextView[contains(@resource-id,':id/text')]")
	private MobileElement transfferdSubmitMsgEle;
	
	@ElementDescription(value = "FundTransferDetailsList")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/tv_lable1')]")
	private List<MobileElement> FundTransferDetailslabel1List;

	@ElementDescription(value = "FundTransferDetailsList")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/tv_lable2')]")
	private List<MobileElement> FundTransferDetailslabel2List;

	@ElementDescription(value = "FundTransferDetailsList")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/tv_lable3')]")
	private List<MobileElement> FundTransferDetailslabel3List;
	
	@ElementDescription(value = "MAKE ANOTHER TRANSFER BUTTON")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='MAKE ANOTHER TRANSFER']")
	private MobileElement MakeAnotherTransferBtn;
	
	@ElementDescription(value = "Log Out Button")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Log Out']")
	private MobileElement LOGOUTButton;
	
	@ElementDescription(value = "BACK To HOME Button")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='BACK TO HOME']")
	private MobileElement BACKToHOME;
	
	@ElementDescription(value = "Amount Field For Bill Org")
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,':id/appCompatEditText')]")
	private MobileElement AmountEditableField;
	
	@ElementDescription(value = "Next button")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='NEXT']")
	private MobileElement nextButton;
	
	@ElementDescription(value = "Select Fund Source")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Select Fund Source']")
	private MobileElement SelectFundSourceText;
	
	@ElementDescription(value = "Select Account List")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/text_src_acc_name')]")
	private List<MobileElement> sourceAccountList;
	
	@ElementDescription(value = "OK Button")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
	private MobileElement OKButton;
	
	@ElementDescription(value = "Page Header")
	@AndroidFindBy(xpath = "//android.widget.RelativeLayout//android.widget.TextView[contains(@resource-id,':id/text')]")
	private MobileElement PageHeader;
	
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
		
		@Step("Verify 'Transfer To Your Account' page header")
		public void verifyTransferToYourAccountPageHeader(String expectedText) throws Exception {
			try {
				wait.fluentWaitForElement(PageHeader);
				Asserts.assertEquals(getTexOfElement(PageHeader).toLowerCase(), expectedText.toLowerCase(),
						"'Header Title' is not Matching");
			} catch (HandleException e) {
				obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION", " Failed to verify 'Transfer To Your Account' page header ", e);
			} catch (Exception e) {
				obj_handleexception.throwException("VERIFYHEADER_EXCEPTION", " Failed to verify 'Transfer To Your Account' page header", e);
			}
		}
		
		@Step("Verify 'Review Transfer' page header")
		public void verifyReviewTransferPageHeader(String expectedText) throws Exception {
			try {
				wait.fluentWaitForElement(PageHeader);
				Asserts.assertEquals(getTexOfElement(PageHeader).toLowerCase(), expectedText.toLowerCase(),
						"'Header Title' is not Matching");
			} catch (HandleException e) {
				obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION", " Failed to verify 'Review Transfer' page header ", e);
			} catch (Exception e) {
				obj_handleexception.throwException("VERIFYHEADER_EXCEPTION", " Failed to verify 'Review Transfer' page header", e);
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

	@Step("Click 'BACK TO Home' BUTTON ")
	public void ClickOnBackToHomeButton() throws Exception {
		try {
			clickOnElement(BACKToHOME);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click 'BACK TO Home' BUTTON ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click 'BACK TO Home' BUTTON ", e);
		}
	}
	
	@Step("Verifies Transfer Submitted Message")
	public void VerifiesTransferSubmittedMsg(String SuccessMsg) throws Exception {
		try {
			if (isElementVisible(ImageForPaymentSuccess))
				Asserts.assertEquals(getTexOfElement(transfferdSubmitMsgEle), SuccessMsg,
						SuccessMsg + " Text is not matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verify success message ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify success message  ", e);
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
	
	@Step("Verify Account Details After Fund Transfer To Own Account.")
	public void VerifyAccountDetailsAfterFundTransferToOwnAccount(String ExpectedToAccountNumber,
			String ExpectedToAccountName, String ExpectedFromAccountNumber, String ExpectedFromAccountName)
			throws Exception {
		try {
			VerifyLogOutButton();
			VerifyBackToHomeButton();
			VerifyMakeAnotherTransferButton();
			String[] ExpTitleList = new String[] { "From", "To", "When", "Source Account Balance",
					"Destination Account Balance", "Reference No." };
			verifyTitles(ExpTitleList, FundTransferDetailslabel1List);
			VerifyFromAccountName(ExpectedFromAccountName);
			VerifyToAccountName(ExpectedToAccountName);
			VerifyFromAccountNumber(ExpectedFromAccountNumber);
			VerifyToAccountNumber(ExpectedFromAccountNumber);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to verify account details after fund transfer  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to verify account details after fund transfer  ", e);
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
	
	@Step("Verify 'Back To Home' Button. ")
	public void VerifyBackToHomeButton() throws Exception {
		try {
			Asserts.assertTrue(BACKToHOME.isDisplayed(), "BACK To HOME Button not found.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify 'Back To Home' Button. ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify 'Back To Home' Button.  ", e);
		}
	}



	@Step("Verify 'From Account Name' On Transfer submitted Page.")
	public void VerifyFromAccountName(String ExpectedFromAccountName) throws Exception {
		try {
			Asserts.assertEquals(getTexOfElement(FundTransferDetailslabel2List.get(0)),
					ExpectedFromAccountName, ExpectedFromAccountName + " is not matching after Fund Transfer");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to verify 'From Account Name' On Transfer submitted Page. ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to verify 'From Account Name' On Transfer submitted Page. ", e);
		}
	}

	@Step("Verify 'To Account Name' On Transfer submitted Page.")
	public void VerifyToAccountName(String ExpectedToAccountName) throws Exception {
		try {
			Asserts.assertEquals(getTexOfElement(FundTransferDetailslabel2List.get(1)),
					ExpectedToAccountName, ExpectedToAccountName + " is not matching after Fund Transfer.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to verify 'To Account Name' On Transfer submitted Page. ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to verify 'To Account Name' On Transfer submitted Page. ", e);
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
}
