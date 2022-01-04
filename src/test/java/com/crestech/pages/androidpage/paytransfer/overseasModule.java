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

public class overseasModule extends CommonAppiumTest{

	public AppiumDriver<RemoteWebElement> driver = null;
	HandleException obj_handleexception = null;
	GestureUtils gestUtils = null;
	
	public overseasModule(AppiumDriver<RemoteWebElement> driver) throws Exception {
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
	
	@ElementDescription(value = "Add Oversea Recipient")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Add Overseas Recipient']")
	private MobileElement AddOverseasRecipient;
	
	@ElementDescription(value = "Overseas Transfer Page")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/tv_overseas_transfer')]")
	private MobileElement OverseasTransferPage;
	
	@ElementDescription(value = "Oversea reciepent List")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'id/tv_expandable_item_head_title')]")
	private List<MobileElement> overseaRecipientList;
	
	@ElementDescription(value = "Select Fund Source")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Select Fund Source']")
	private MobileElement SelectFundSourceText;
	
	@ElementDescription(value = "select fund source account list")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'id/account_name')]")
	private List<MobileElement> selectFundSourceAccountList;
	
	@ElementDescription(value = "OK Button")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
	private MobileElement Alert_OKButton;
	
	@ElementDescription(value = "Select Currency")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/currency_text')]")
	private MobileElement SelectCurrency;
	
	@ElementDescription(value = "overseas transfer header")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'id/text_title_mfe')]")
	private MobileElement overseasTransferHeader;
	
	@ElementDescription(value = "Edit Amount Text Fields")
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,':id/amountEdit')]")
	private List<MobileElement> AmountTextFields;
	
	@ElementDescription(value = "Exchange Rate Text")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/exchangerate_view_lbl')]")
	private MobileElement ExchangeRateText;
	
	@ElementDescription(value = "mobile no. Field")
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'mobile number')]")
	private MobileElement MobileNoField;

	@ElementDescription(value = "Page Header List")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'id/text')]")
	private List<MobileElement> PageHeader;
	
	@ElementDescription(value = "common List.")
	@AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.TextView")
	private List<MobileElement> commonList;
	
	@ElementDescription(value = "purpose")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'purpose')]")
	private MobileElement purpose;
	
	@ElementDescription(value = "Edit text Search Field")
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,':id/editText_search')]")
	private MobileElement editSearchField;
	
	@ElementDescription(value = "Amount type")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'account type')]")
	private MobileElement AccountType;
	
	@ElementDescription(value = "Next Button")
	@AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,':id/btn_remitnext')]")
	private MobileElement NextBtn;
	
	@ElementDescription(value = "Review Transfer Page Header")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/text_title_mfe')]")
	private MobileElement ReviewTransferPageHeader;

	@ElementDescription(value = "Transfer Now Button")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='TRANSFER NOW']")
	private MobileElement TransferNowBtn;
	
	@ElementDescription(value = "Transfer Submitted Message")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/textViewInfo')]")
	private MobileElement TransferSubmittedMsg;
	
	@ElementDescription(value = "TransferSubmittedImage")
	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,':id/appCompatImageView')]")
	private MobileElement TransferSubmittedImage;
	
	@ElementDescription(value = "Reference Number Text")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Reference No.']")
	private MobileElement ReferenceNumberText;
	
	@ElementDescription(value = "Share Transfer Details button Or Track This Transfer Button")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='SHARE TRANSFER DETAILS']")
	private MobileElement ShareTransferDetailsBtn;

	@ElementDescription(value = "DropDown List")
	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup")
	private List<MobileElement> dropDowmList;
	
	@ElementDescription(value = "List of element of country")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'single_list_item')]")
	private List<MobileElement> countryList;
	
	@ElementDescription(value = "Search for a Location")
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'id/editText_search')]")
	private MobileElement searchForLocationField;
	
	@ElementDescription(value = "currency option list")
	@AndroidFindBy(xpath = "//android.widget.RadioGroup[contains(@resource-id,'id/rg_currency')]/android.widget.RadioButton") //
	private List<MobileElement> currencyOptionList;
	
	@ElementDescription(value = "Next button")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='NEXT']")
	private MobileElement nextButton;
	
	@ElementDescription(value = "Enter Bank code TextField")
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'id/textInputEditText')]")
	private MobileElement enterBankcodeTextField;
	
	@ElementDescription(value = "Enter Full Address TextBox")
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'ddress')]")
	private MobileElement AddressField;
	
	@ElementDescription(value = "Account Number Field")
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter account no.']")
	private MobileElement AccountNumberField;

	@ElementDescription(value = "Enter recipient's full name TextBox")
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'full name')]")
	private MobileElement RecipientNameField;
	
	@ElementDescription(value = "Enter City TextBox")
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='In the City of']")
	private MobileElement CityField;
	
	@ElementDescription(value = " 'RECIPIENT'S ACCOUNT DETAILS' Page Header")
	@AndroidFindBy(xpath = "(//android.widget.TextView[contains(@resource-id,'id/tv_title')])[1]")
	private MobileElement ReviewRecipientDetails;

	@ElementDescription(value = "Success Msg Element")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'id/tv_added_recipient')]")
	private MobileElement SuccessMsgElement;
	
	@ElementDescription(value = "MAKE A TRANSFER")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='MAKE A TRANSFER']")
	private MobileElement makeTransferButton;
	
	@ElementDescription(value = "expand button")
	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,'id/image_expand')]")
	private MobileElement expandButton;
	
	@ElementDescription(value = "Close Button to Closing The Overseas screen.")
	@AndroidFindBy(xpath = "//android.widget.ImageButton[contains(@resource-id,':id/img_scan')]")
	private MobileElement CloseBtn_OverseasScreen;
	
	@ElementDescription(value = "Confirm button")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='CONFIRM']")
	private MobileElement confirmButton;
	
	@Step("Click On 'ADD RECIPIENT NOW' button under overseas")
	public void SelectAddRecipientNowButtonUnderOverseas() throws Exception {
		try {
			String xpath = "//android.widget.Button[@text='ADD RECIPIENT NOW']";
			List<RemoteWebElement> list = driver.findElements(By.xpath(xpath));
			if (list.size() > 0)
				clickOnElement(AddRecipientNowBtn);
			else
				clickOnElement(AddOverseasRecipient);

		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION"," Failed to Click On Add Recipient Now Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION"," Failed to Click On On Add Recipient Now Button  ", e);
		}
	}
	
	@Step("clicking On 'ADD RECIPIENT NOW' button")
	public void ClickOnAddRecipientNowBtn() throws Exception {
		try {
			gestUtils.scrollUPtoObject("text", "ADD RECIPIENT NOW", AddRecipientNowBtn);
			clickOnElement(AddRecipientNowBtn);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Add Recipient Now Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Add Recipient Now Button  ",e);
		}
	}
	
	@Step("Verify 'Overseas Transfer' page header")
	public void verifyOverseasTransferPageHeader(String expectedText) throws Exception {
		try {
			wait.fluentWaitForElement(OverseasTransferPage);
			Asserts.assertEquals(getTexOfElement(OverseasTransferPage).toLowerCase(), expectedText.toLowerCase(),
					"'Header Title' is not Matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION", " Failed to Verify 'Overseas Transfer' page header  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION", " Failed to Verify 'Overseas Transfer' page header ", e);
		}
	}
	
	@Step("Select Overseas Payee.")
	public void SelectOverseaPayee(String valueSelectedFromList) throws Exception {
		try {
			if (overseaRecipientList.size() > 0) {
				int l = overseaRecipientList.size();
				int index = 0;
				String OverseaRecipientList = null;
				for (int i = 0; i < l; i++) {
					OverseaRecipientList = overseaRecipientList.get(i).getText();
					if (OverseaRecipientList.contains(valueSelectedFromList)) {
						index++;
						clickOnElement(overseaRecipientList.get(i));
						break;
					}
				}
				if(index==0)
				Asserts.assertFail("Overseas Payee " + valueSelectedFromList + " not found in the list to initiate the fund transfer");
			} else 
				Asserts.assertFail("No Receipient found in the Oversea Payee list");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Selecting Overseas Payee ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Selecting Overseas Payee ", e);
		}
	}
	
	// If User has multiple accounts then select fund source account
	@Step("Click on 'Select Fund Source' and Select Account")
	public void SelectSourceOfFund(String SelectedAccountName)
			throws Exception {
		try {
			String xpath = "//android.widget.TextView[@text='Select Fund Source']";
			List<RemoteWebElement> list = driver.findElements(By.xpath(xpath));
			if (list.size() > 0) {
				clickOnElement(SelectFundSourceText);
				int index=0;
				int l = selectFundSourceAccountList.size();
				String AccountNameList = null;
				for (int i = 0; i < l; i++) {
					AccountNameList = selectFundSourceAccountList.get(i).getText();
					if (AccountNameList.equalsIgnoreCase(SelectedAccountName)) {
						clickOnElement(selectFundSourceAccountList.get(i));
						index++;
						break;
					}
				}
				
				if(index==0)
					Asserts.assertFail("Select Fund Source ' " + SelectedAccountName + " ' not found in the list to initiate the fund transfer");
			
				if (isElementVisible2(SelectCurrency))
					clickOnElement(SelectCurrency);
				
				handlingOfPrimarySourceOfFundPopup();
			}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Selecting Overseas Payee ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Selecting Overseas Payee ", e);
		}
	}
	
	@Step("Click On OK Button.")
	public void ClickOnOKButton() throws Exception {
		try {
			clickOnElement(Alert_OKButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On OK Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On OK Button   ", e);
		}
	}
	
	@Step("Handle 'Primary Source Of Fund' Popup.")
	public void handlingOfPrimarySourceOfFundPopup() throws Exception {
		try {
			String xpath1 = "//android.widget.TextView[contains(@resource-id,'id/tv_primary_account_bottom_sheet_title')]";
			List<RemoteWebElement> primarysourceofFundPopup = driver.findElements(By.xpath(xpath1));
			if (primarysourceofFundPopup.size() > 0)
				ClickOnOKButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Handle 'Primary Source Of Fund' Popup. ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Handle 'Primary Source Of Fund' Popup.  ", e);
		}
	}
	
	
	@Step("Select EOTT")
	public void SelectEOTT() throws Exception {
		try {
			clickOnElement(editSearchField);
			String ExpectedEottName = CommonTestData.EOTTREMITTANCE_NAME.getEnumValue();
			enterTextInTextbox(editSearchField, ExpectedEottName);
			pressKey(driver, Keys.ENTER);
			
			String xpath = "//android.widget.TextView[@text='" + ExpectedEottName + "']";
			MobileElement ExpectedEottEle = (MobileElement) driver.findElement(By.xpath(xpath));
			if (isElementVisible2(ExpectedEottEle))
				clickOnElement(ExpectedEottEle);
			else
				Asserts.assertFail("EOTT " + ExpectedEottName + " Not Found corresponding to this user.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to select All Tab  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to select All Tab   ", e);
		}
	}
	
	@Step("Verifying 'Overseas Transfer' page header")
	public void VerifyOverseasTransferHeader(String expectedText) throws Exception {
		try {
			wait.fluentWaitForElement(overseasTransferHeader);
			Asserts.assertEquals(getTexOfElement(overseasTransferHeader).toLowerCase(), expectedText.toLowerCase(),
					"'Header Title' is not Matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION", " Failed to verify 'Overseas Transfer' page header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION", " Failed to verify 'Overseas Transfer' page header ", e);
		}
	}
	
	@Step("Press enter key after Entering Amount.")
	public void pressEnterKeyAfterEnteringAmount(String Amt) throws Exception {
		try {
			clickOnElement(AmountTextFields.get(0));
			enterTextInTextbox(AmountTextFields.get(0), Amt);
			pressKey(driver, Keys.ENTER);
			wait.waitForElementVisibility(ExchangeRateText);
			hideKeyboard();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Pressing Enter Key After Entering Amount ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Pressing Enter Key After Entering Amount ", e);
		}
	}
	
	@Step("Select Additional Details if Required")
	public void SelectAdditionalDetails(String ExpectedAccountType, String Purpose, String MobileNo) throws Exception{
		try {
			gestUtils.scrollUPtoObject("text", "Next", null);
			
			if (isElementVisible2(AccountType))
				selectAccountType(ExpectedAccountType);

			
			if (isElementVisible2(purpose))
				selectPurpose(Purpose);

			if (isElementVisible2(MobileNoField))
				enterMobileNo(MobileNo);

		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select Additional Details ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION"," Failed to Select Additional Details ", e);
		}
	}


	
	@Step("Select AccountType")
	public void selectAccountType(String expectedAccountType) throws Exception// "Savings"
	{
		try {
			clickOnElement(AccountType);

			if (commonList.size() > 0) {
				int l = commonList.size();
				int index = 0;
				String actualAccountType = null;
				for (int i = 0; i < l; i++) {
					actualAccountType = commonList.get(i).getText();
					if (actualAccountType.contains(expectedAccountType)) {
						index++;
						clickOnElement(commonList.get(i));
						break;
					}
				}

				if (index == 0)
					Asserts.assertFail("Account Type " + expectedAccountType + " Not found in the list.");
				wait.fluentWaitForElement(PageHeader.get(0));
			} else
				Asserts.assertFail("Account type " + expectedAccountType + " Not found in the list as list size is 0");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select Account Type ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select Account Type ", e);
		}
	}
	
	@Step("Select purpose")
	public void selectPurpose(String expectedPurpose) throws Exception {
		try {
			clickOnElement(purpose);

			if (commonList.size() > 0) {
				int l = commonList.size();
				int index = 0;
				String actualPurpose = null;
				for (int i = 0; i < l; i++) {
					actualPurpose = commonList.get(i).getText();
					if (actualPurpose.contains(expectedPurpose)) {
						index++;
						clickOnElement(commonList.get(i));
						break;
					}
				}
				if(index ==0)
				Asserts.assertFail("Purpose " + expectedPurpose + " Not found in the list.");
				wait.fluentWaitForElement(PageHeader.get(0));
			} else
				Asserts.assertFail("Purpose " + expectedPurpose + " not found in the list as list size is 0");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select Purpose ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select Purpose ", e);
		}
	}
	
	@Step("enter mobile No.")
	public void enterMobileNo(String MobileNo) throws Exception {
		try {
			enterTextInTextbox(MobileNoField, MobileNo);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Enter Mobile Number ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Enter Mobile Number ", e);
		}
	}
	

	@Step("Verify 'Review Transfer' page header")
	public void verifyReviewTransferPageHeader(String expectedText) throws Exception {
		try {
			wait.fluentWaitForElement(ReviewTransferPageHeader);
			Asserts.assertEquals(getTexOfElement(ReviewTransferPageHeader).toLowerCase(), expectedText.toLowerCase(),
					"'Header Title' is not Matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION", " Failed to Verify 'Review Transfer' page header  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION", " Failed to Verify 'Review Transfer' page header ", e);
		}
	}
	
	@Step("Click on Transfer Now Button.")
	public void ClickOnTransferNowButton() throws Exception {
		try {
			gestUtils.scrollUPtoObject(null, null, null);
			clickOnElement(TransferNowBtn);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click on transfer now Button ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click on transfer now Button ", e);
		}
	}
	
	@Step("Verifies Transfer Submitted Message")
	public void VerifiesTransferSubmittedMessage(String SuccessMsg) throws Exception {
		try {
			if (isElementVisible(TransferSubmittedImage))
				Asserts.assertEquals(getTexOfElement(TransferSubmittedMsg), SuccessMsg, SuccessMsg + " Text is not matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verify Transfer Submitted Message ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify Transfer Submitted Message ", e);
		}
	}
	
	@Step("Verifies Reference Number Text after clicking on Image Expand Button.")
	public void ClickOnImageExpandBtnAndVerifiesReferenceNumberText() throws Exception {
		try {
			clickOnElement(expandButton);
			gestUtils.scrollUPtoObject(null, null, null);
			Asserts.assertEquals(getTexOfElement(ReferenceNumberText),
					CommonTestData.REFERENCE_NUMBER_TEXT.getEnumValue(),
					CommonTestData.REFERENCE_NUMBER_TEXT.getEnumValue() + " Text is not Matching.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Image Expand Button ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Image Expand Button ", e);
		}
	}
	
	@Step("Click On Share Transfer Details Button")
	public void ClickOnShareTransferDetailsButton() throws Exception {
		try {
			gestUtils.scrollUPtoObject("text", "SHARE TRANSFER DETAILS", ShareTransferDetailsBtn);
			clickOnElement(ShareTransferDetailsBtn);
			// Asserts.assertEquals(getTexOfElement(DBSappObject.OverseasTransferMsg()),
			// CommonTestData.OVERSEAS_TRANSFER_TEXT.getEnumValue(),
			// CommonTestData.OVERSEAS_TRANSFER_TEXT.getEnumValue() + " Text is not found");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION"," Failed to Click On Share Transfer Details Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION"," Failed to Click On Share Transfer Details Button ", e);
		}
	}
	

	@Step("Select Country")
	public void SelectCountry(String expectedCountry) throws Exception {
		try {
			enterTextInTextbox(searchForLocationField, expectedCountry);
			
			if (countryList.size() > 0) {
				int l = countryList.size();
				int index = 0;
				String actualCountry = null;
				for (int i = 0; i < l; i++) {
					actualCountry = countryList.get(i).getText();
					if (actualCountry.equalsIgnoreCase(expectedCountry)) {
						index++;
						clickOnElement(dropDowmList.get(i));
						break;
					}
				}
                 if(index==0)
				Asserts.assertFail("Country " + expectedCountry + " No element found in the list.");
			} else
				Asserts.assertFail("Country " + expectedCountry + " not found in the list as list size is 0");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select Country ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select Country ", e);
		}
	}
	
	
	@Step("Select Currency Type")
	public void SelectCurrencyType(String expectedCurrency) throws Exception {
		try {
			if (currencyOptionList.size() > 0) {
				int index = 0;
				String actualCurrency = null;
				for (int i = 0; i < currencyOptionList.size(); i++) {
					actualCurrency = currencyOptionList.get(i).getText();
					if (actualCurrency.equalsIgnoreCase(expectedCurrency)) {
						index++;
						clickOnElement(currencyOptionList.get(i));
						break;
					}
				}
				if (index == 0)
					Asserts.assertFail("Currency Type " + expectedCurrency + " Not found in the list");
			} else
				Asserts.assertFail(expectedCurrency + " not found in the list as list size is 0");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION"," Failed to Select Currency Type from list. ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select Currency Type from list ",e);
		}
	}
	
	@Step("Click On Next Button.")
	public void ClickOnNextButton() throws Exception {
		try {
			if (isElementVisible2(nextButton)) {
				gestUtils.scrollUPtoObject("text", "NEXT", nextButton);
				clickOnElement(nextButton);
			}				
				else if	(isElementVisible2(confirmButton)) {
				gestUtils.scrollUPtoObject("text", "CONFIRM", confirmButton);
				clickOnElement(confirmButton);
			}  
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Next Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Next Button  ", e);
		}
	}
	
	@Step("Verify 'Review Recipient Details' page header")
	public void verifyReviewRecipientDetailsPageHeader(String expectedText) throws Exception {
		try {
			wait.fluentWaitForElement(ReviewRecipientDetails);
			Asserts.assertEquals(getTexOfElement(ReviewRecipientDetails).toLowerCase(), expectedText.toLowerCase(),
					"'Header Title' is not Matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION", " Failed to Verify 'Review Recipient Details' page header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION", " Failed to Verify 'Review Recipient Details' page header ", e);
		}
	}

	@Step("Enter City")
	public void EnterCity(String text) throws Exception {
		try {
			if (isElementVisible2(CityField))
				enterTextInTextbox(CityField, text);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Enter City ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Enter City  ", e);
		}
	}

	@Step("Enter Full Name")
	public void EnterFullName(String text) throws Exception {
		try {
			enterTextInTextbox(RecipientNameField, text);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Enter Full Name ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Enter Full Name ", e);
		}
	}
	
	@Step("Enter Account Number")
	public void EnterAccountNumber(String text) throws Exception {
		try {
			enterTextInTextbox(AccountNumberField, text);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Enter Account Number ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Enter Account Number ", e);
		}
	}
	
	@Step("Enter Address")
	public void EnterAddress(String text) throws Exception {
		try {
		    enterTextInTextbox(AddressField, text);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Enter Address ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Enter Address ", e);
		}
	}
	
	@Step("Enter Bank Code")
	public void EnterBankCode(String text) throws Exception {
		try {
			enterTextInTextbox(enterBankcodeTextField, text);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Enter Bank Code ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Enter Bank Code ", e);
		}
	}
	
	@Step("Verify 'You've added a recipient' Message")
	public void verifyYouHaveAddedMessage() throws Exception {
		try {
			wait.fluentWaitForElement(SuccessMsgElement);
			if (getTexOfElement(SuccessMsgElement).toLowerCase()
					.equalsIgnoreCase(CommonTestData.YOU_HAVE_ADDED_RECIPIENT_MSG.getEnumValue()))
				Asserts.assertEquals(getTexOfElement(SuccessMsgElement).toLowerCase(),
						CommonTestData.YOU_HAVE_ADDED_RECIPIENT_MSG.getEnumValue().toLowerCase(),
						"'You’ve added a recipient label' Text is not matching");
			else if (getTexOfElement(SuccessMsgElement).toLowerCase()
					.equalsIgnoreCase(CommonTestData.YOU_HAVE_ADDED_RECIPIENT_MSG2.getEnumValue()))
				Asserts.assertEquals(getTexOfElement(SuccessMsgElement).toLowerCase(),
						CommonTestData.YOU_HAVE_ADDED_RECIPIENT_MSG2.getEnumValue().toLowerCase(),
						"You've added a recipient' Text is not matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verify 'You've added a recipient' Message ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify 'You've added a recipient' Message ", e);
		}
	}
	
	@Step("Verify 'Reference No. Field and its value' field and Verify 'MAKE A TRANSFER' Button After Expanding & Scrolling to the Page.")
	public void verifyReferenceFieldAndItsValue(String expectedText) throws Exception {
		try {
			clickOnElement(expandButton);
			gestUtils.scrollUPtoObject("text", CommonTestData.MAKE_TRANSFER.getEnumValue(), makeTransferButton);
			Asserts.assertEquals(getTexOfElement(makeTransferButton), CommonTestData.MAKE_TRANSFER.getEnumValue(), "'MAKE A TRANSFER' Text is not found");
			Asserts.assertEquals(getTexOfElement(ReferenceNumberText), expectedText, "'Reference no Field' is not found");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verify Reference Field Value ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify Reference Field Value  ", e);
		}
	}
	
	@Step("Click On Close Button to closing Overseas Screen.")
	public void ClickOnOverseasScreenClosingButton() throws Exception {
		try {
			clickOnElement(CloseBtn_OverseasScreen);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click on Close Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click on Close Button ", e);
		}
	}
	
}
