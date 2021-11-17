package com.crestech.pages;

import static org.testng.Assert.assertFalse;
import java.time.Duration;
import java.util.List;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import com.crestech.appium.utils.CommonAppiumTest;
import com.crestech.common.utilities.AndroidAlert;
import com.crestech.common.utilities.Asserts;
import com.crestech.common.utilities.CommonAlertElements;
import com.crestech.common.utilities.CommonTestData;
import com.crestech.common.utilities.WaitUtils;
import com.crestech.pageobjects.DBSAndroidObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;

/**
 * @author Divya Devi, Shafkat Ali
 *
 */
public class DBSAndroidPage extends CommonAppiumTest {

	static Logger log = Logger.getLogger(DBSAndroidPage.class.getName());
	public DBSAndroidObject DBSappObject = new DBSAndroidObject();

	public DBSAndroidPage(AppiumDriver<RemoteWebElement> driver) throws Exception {
		super(driver);
		try {
			PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), DBSappObject);
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}

	@Step("Relaunching DBS application")
	public void relaunchingDBS() throws Exception {
		try {
			relanchApplication(CommonTestData.DBS_APP_PACKAGE.getEnumValue(),
					CommonTestData.DBS_APPS_ACTIVITY.getEnumValue());
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}

	@Step("Relaunching POSB application")
	public void relaunchingPOSB() throws Exception {
		try {
			relanchApplication(CommonTestData.POSB_APP_PACKAGE.getEnumValue(),
					CommonTestData.DBS_APPS_ACTIVITY.getEnumValue());
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}

	@Step("Relaunching iWealth application")
	public void relaunchingIwealth() throws Exception {
		try {
			relanchApplication(CommonTestData.IWEALTH_APP_PACKAGE.getEnumValue(),
					CommonTestData.DBS_APPS_ACTIVITY.getEnumValue());
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}

	@Step("Log In the Application")
	public void logInApplication(String userName, String password) throws Exception {
		try {
			WaitUtils wait = new WaitUtils(driver);
			CommonAlertElements btnElements = new CommonAlertElements(driver);
			wait.ImplicitlyWait();
			wait.waitForElementToBeClickable(DBSappObject.loginButton());
			Thread.sleep(30000);
			String quitButtonXpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.Button";
			List<RemoteWebElement> list = driver.findElements(By.xpath(quitButtonXpath));
			if (list.size() > 0) {
				driver.closeApp();
				// wait.ImplicitlyWait();
				Thread.sleep(10000);
				relaunchingDBS();
				wait.waitForElementToBeClickable(DBSappObject.loginButton());
				// wait.ImplicitlyWait();
				Thread.sleep(5000);
			}
			clickOnLoginButton();
			sendDataInUserId(userName);
			sendDataInUserPin(password);
			clickOnLoginButton();
			digitalTokenSetUp();
			AndroidAlert androidAlert = new AndroidAlert(driver);
			androidAlert.fingerprintAlertHandlingWithButtonMessage(btnElements.closeButton(),
					CommonTestData.FINGERPRINT_MESSAGE.getEnumValue());
			androidAlert.recordingAlertHandlingWithButtonMessage(btnElements.closeButton(),
					CommonTestData.RECORDERSECTION_MESSAGE.getEnumValue());
			Asserts.assertEquals(getTexOfElement(DBSappObject.WelcomeToText()).trim(),
					CommonTestData.WELCOME.getEnumValue(),
					CommonTestData.WELCOME.getEnumValue() + " text is not found");
			Asserts.assertEquals(getTexOfElement(DBSappObject.DigibankText()).trim(),
					CommonTestData.DIGIBANK.getEnumValue(),
					CommonTestData.DIGIBANK.getEnumValue() + " text is not found");
		} catch (Exception e) {
			assertFalse(true);
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));

		}
	}

	@Step("Clicked on Login button")
	public void clickOnLoginButton() throws Exception {
		try {
			clickOnElement(DBSappObject.loginButton());
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}

	@Step("Clicked on Sign Up For Digibank button")
	public void clickOnSignUpForDigibankButton() throws Exception {
		try {
			clickOnElement(DBSappObject.signUpForDigibankButton());
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}

	@Step("Clicked on Pre Login button")
	public void preLoginButton() throws Exception {
		try {
			clickOnElement(DBSappObject.loginButton());
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}

	@Step("Enter data in User EditBox")
	public void sendDataInUserId(String text) throws Exception {
		try {
			if (isElementEnable(DBSappObject.userIdEditText()))
				enterTextInTextbox(DBSappObject.userIdEditText(), text);

			Asserts.assertTrue(isElementEnable(DBSappObject.userIdEditText()), "EditField is not enable");
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}

	@Step("Enter data in Pin EditBox")
	public void sendDataInUserPin(String text) throws Exception {
		try {
			if (isElementEnable(DBSappObject.userPinEditText()))
				enterTextInTextbox(DBSappObject.userPinEditText(), text);

			Asserts.assertTrue(isElementEnable(DBSappObject.userPinEditText()), "EditField is not enable");
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}

	@Step("Application Logout & Verifies the 'Tap on the stars to rate' field Message.")
	public void clickOnLogoutAndVerify(String logoutTextMsg, String Ratingmsg) throws Exception {
		try {
			AndroidAlert.AlertHandlingWithButtonMessage(DBSappObject.logoutButton(), logoutTextMsg,
					DBSappObject.logoutButton());
			Asserts.assertEquals(getTexOfElement(DBSappObject.postLogoutAlertMessage()), Ratingmsg,
					"'Tap on the stars to rate' Text is not found");
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}

	@Step("Verifying Page and clicking on 'SET UP NOW' button ")
	public void verifyPageAndClickOnSetUpNowButton(String expectecMessage) throws Exception {
		try {
			AndroidAlert.AlertHandlingWithButtonMessage(DBSappObject.setUpNowButton(), expectecMessage,
					DBSappObject.tokenSetupMessage());
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}

	@Step("Verifying Email/SMS OTP Page and Send OTP on TextField button ")
	public void verifyPageAndSendOtpToEditBox(String OTP, String expectecMessage) throws Exception {
		try {
			String actualMessage = CommonAppiumTest.getTexOfElement(DBSappObject.emailSmsOtpMessage());
			if (actualMessage.equalsIgnoreCase(expectecMessage))
				if (isElementEnable(DBSappObject.emailSmsOtpEditBox()))
					enterTextInTextbox(DBSappObject.emailSmsOtpEditBox(), OTP);
			// Asserts.assertTrue(isElementEnable(DBSappObject.emailSmsOtpEditBox()),
			// "TextField is not enable");
			Asserts.assertEquals(actualMessage, expectecMessage, "Title Message Not matching");
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}

	}

	@Step("Verifying Page after Digital Token setup after clicking on 'Done' button")
	public void digitalTokenSetUp() throws Exception {
		try {
			String digitalTokenSetUpXpath = "//android.widget.TextView[contains(@resource-id,'id/status_message')]";
			List<RemoteWebElement> digitalTokenSetUpList = driver.findElements(By.xpath(digitalTokenSetUpXpath));
			if (digitalTokenSetUpList.size() > 0) {
				Thread.sleep(5000);
				verifyPageAndClickOnSetUpNowButton(CommonTestData.DIGITAL_TOKEN_SETUP_MESSAGE.getEnumValue());
				String alertMsg = "//android.widget.TextView[@text='Please note you can only have one digital token registered to your profile. Any digital token on an alternative device will therefore be automatically deregistered.']";
				List<RemoteWebElement> elements = driver.findElements(By.xpath(alertMsg));
				if (elements.size() > 0) {
					String continueButtonXpath = "//android.widget.Button[@text='CONTINUE']";
					List<RemoteWebElement> continueButtons = driver.findElements(By.xpath(continueButtonXpath));
					continueButtons.get(0).click();
				}
				verifyPageAndSendOtpToEditBox(CommonTestData.OTP.getEnumValue(),
						CommonTestData.EMAIL_OTP_MESSAGE.getEnumValue());
				verifyPageAndSendOtpToEditBox(CommonTestData.OTP.getEnumValue(),
						CommonTestData.SMS_OTP_MESSAGE.getEnumValue());
				AndroidAlert.AlertHandlingWithButtonMessage(DBSappObject.doneButton(),
						CommonTestData.DIGITAL_TOKEN_MESSAGE_AFTER_STEPUP.getEnumValue(),
						DBSappObject.tokenGetSetupMessage());
			}
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}

	@Step("Verifies Remittance Corridor")
	public void VerifyRemittanceCorridor() throws Exception {
		try {
			ClickOnPayAndTransferBtnAndAuthenticationOfSecurePIN();
			SelectingPayeeAndFundSourceAfterSelectingOverseas();
			pressEnterKeyAfterEnteringAmount(CommonTestData.CORRIDOR_AMOUNT.getEnumValue());
			ClickOnNextBtnAndVerifiesReviewTransferPage();
			ClickOnTransferNowBtnAndVerifiesTransferSubmittedMsg();
			ClickOnImageExpandBtnAndVerifiesReferenceNumberText();
			ClickOnShareTransferDetailsBtnAndVerifiesReferenceNumberText();
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}

	@Step("Verifies Remittance eOTT")
	public void VerifyRemittanceEOTT() throws Exception {
		try {
			if (isElementVisible(DBSappObject.PayAndTransferBtn()))
				clickOnElement(DBSappObject.PayAndTransferBtn());

			String xpath = "//android.widget.EditText[@text='••••••']";
			List<RemoteWebElement> list = driver.findElements(By.xpath(xpath));
			if (list.size() > 0) {
				// isElementVisible(DBSappObject.iBSecurePin());
				enterTextInTextbox(DBSappObject.PasscodeField(), CommonTestData.OTP.getEnumValue());
				String doneButtonxpath = "//android.widget.Button[@text='Done']";
				List<RemoteWebElement> doneButtonList = driver.findElements(By.xpath(doneButtonxpath));
				if (doneButtonList.size() > 0)
					clickOnElement(DBSappObject.DoneButtonForPasscode());
			}
			clickOnElement(DBSappObject.AllTab());
			clickOnElement(DBSappObject.editSearchField());
			enterTextInTextbox(DBSappObject.editSearchField(), CommonTestData.EOTT_PAYEE.getEnumValue());
			pressGivenKey(driver, Keys.ENTER);
			isElementVisible(DBSappObject.BHDeott_Payee());
			clickOnElement(DBSappObject.BHDeott_Payee());
			Asserts.assertEquals(getTexOfElement(DBSappObject.OverseasTransferPage()),
					CommonTestData.OVERSEAS_TRANSFER_PAGEHEADER.getEnumValue(),
					CommonTestData.OVERSEAS_TRANSFER_PAGEHEADER.getEnumValue() + " Text is not found");
			clickOnElement(DBSappObject.SelectFundSourcePage());
			clickOnElement(DBSappObject.SourceFundList().get(0));

			pressEnterKeyAfterEnteringAmount(CommonTestData.eOTT_AMOUNT.getEnumValue());
			clickOnElement(DBSappObject.ExchangeRateICON());
			// add scroll code if required.
			clickOnElement(DBSappObject.SelectPurposeOfTransfer());
			clickOnElement(DBSappObject.FundTransferPurposeOption());
			Asserts.assertEquals(getTexOfElement(DBSappObject.TextViewPurpose()),
					CommonTestData.PURPOSE_OF_TRANSFER_TEXT.getEnumValue(),
					CommonTestData.PURPOSE_OF_TRANSFER_TEXT.getEnumValue() + " Text is not found");

			ClickOnNextBtnAndVerifiesReviewTransferPage();

			ClickOnTransferNowBtnAndVerifiesTransferSubmittedMsg();

			ClickOnImageExpandBtnAndVerifiesReferenceNumberText();

			ClickOnShareTransferDetailsBtnAndVerifiesReferenceNumberText();
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}

	@Step("Verifies Add payee DBSorPOSB")
	public void VerifyAddPayeeDBSorPOSB() throws Exception {
		try {
			if (isElementVisible(DBSappObject.PayAndTransferBtn()))
				clickOnElement(DBSappObject.PayAndTransferBtn());

			String xpath = "//android.widget.EditText[@text='••••••']";
			List<RemoteWebElement> list = driver.findElements(By.xpath(xpath));
			if (list.size() > 0) {
				// isElementVisible(DBSappObject.iBSecurePin());
				enterTextInTextbox(DBSappObject.PasscodeField(), CommonTestData.OTP.getEnumValue());
				String doneButtonxpath = "//android.widget.Button[@text='Done']";
				List<RemoteWebElement> doneButtonList = driver.findElements(By.xpath(doneButtonxpath));
				if (doneButtonList.size() > 0)
					clickOnElement(DBSappObject.DoneButtonForPasscode());
			}
			wait.waitForElementVisibility(DBSappObject.AddLocalRecipient());
			clickOnElement(DBSappObject.AddLocalRecipient());

			Asserts.assertEquals(getTexOfElement(DBSappObject.PageHeader()),
					CommonTestData.LOCAL_TRANSFER_PayNow.getEnumValue(),
					CommonTestData.LOCAL_TRANSFER_PayNow.getEnumValue() + " Text is not found");

			clickOnElement(DBSappObject.SelectBankAccount());

			enterTextInTextbox(DBSappObject.AddLocalRecipientDetailsFieldList().get(0),
					CommonTestData.LOCAL_RECIPIENT_NAME.getEnumValue());
			clickOnElement(DBSappObject.AddLocalRecipientDetailsFieldList().get(1));
			clickOnElement(DBSappObject.SearchField());
			enterTextInTextbox(DBSappObject.SearchField(), CommonTestData.BANK_NAME.getEnumValue());
			clickOnElement(DBSappObject.SelectBankOFIndia()); // or press enter key
			enterTextInTextbox(DBSappObject.AddLocalRecipientDetailsFieldList().get(2),
					CommonTestData.LOCAL_RECIPIENT_ACCOUNT_NUMBER.getEnumValue());
			clickOnElement(DBSappObject.NextButtonToAddedLocalRecipient());

			Asserts.assertEquals(getTexOfElement(DBSappObject.PageHeader()),
					CommonTestData.REVIEW_RECIPIENT_DETAILS.getEnumValue(),
					CommonTestData.REVIEW_RECIPIENT_DETAILS.getEnumValue() + " Text is not found");

			clickOnElement(DBSappObject.AddRecipientNowBtn());
			Asserts.assertEquals(getTexOfElement(DBSappObject.PageHeader()),
					CommonTestData.SECURE_PIN_PAGE_HEADER.getEnumValue(),
					CommonTestData.SECURE_PIN_PAGE_HEADER.getEnumValue() + " Text is not found");

			enterTextInTextbox(DBSappObject.PasscodeField(), CommonTestData.OTP.getEnumValue());

			if (isElementVisible(DBSappObject.SuccessTickImageView()))
				Asserts.assertEquals(getTexOfElement(DBSappObject.YouHaveAddedRecipientElement()),
						CommonTestData.YOU_HAVE_ADDED_RECIPIENT_MSG.getEnumValue(),
						CommonTestData.YOU_HAVE_ADDED_RECIPIENT_MSG.getEnumValue() + " Text is not found");

		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}

	@Step("Verifies Overseas Transfer Page Header on the top & Select Payee and fund source from Overseas Transfer page.")
	public void SelectingPayeeAndFundSourceAfterSelectingOverseas() throws Exception {
		try {
			overseasVerifyClick(CommonTestData.OVERSEAS_ICON.getEnumValue());
			Asserts.assertEquals(getTexOfElement(DBSappObject.OverseasTransferPage()),
					CommonTestData.OVERSEAS_TRANSFER_PAGEHEADER.getEnumValue(),
					CommonTestData.OVERSEAS_TRANSFER_PAGEHEADER.getEnumValue() + " Text is not found");
			clickOnElement(DBSappObject.PayeeList().get(2));
			clickOnElement(DBSappObject.SelectFundSourcePage());
			clickOnElement(DBSappObject.SourceFundList().get(2));
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}

	@Step("Press enter key after Entering Amount.")
	public void pressEnterKeyAfterEnteringAmount(String Amt) throws Exception {
		try {
			clickOnElement(DBSappObject.AmountTextFields().get(0));
			enterTextInTextbox(DBSappObject.AmountTextFields().get(0), Amt);
			pressGivenKey(driver, Keys.ENTER);
			wait.waitForElementVisibility(DBSappObject.ExchangeRateText());
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}

	@Step("Verifies Review Transfer Page Header after clicking on Next Button.")
	public void ClickOnNextBtnAndVerifiesReviewTransferPage() throws Exception {
		try {
			clickOnElement(DBSappObject.NextBtn());
			Asserts.assertEquals(getTexOfElement(DBSappObject.ReviewTransferPageHeader()),
					CommonTestData.REVIEW_TRANSFER.getEnumValue(),
					CommonTestData.REVIEW_TRANSFER.getEnumValue() + " Text is not found");
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}

	@Step("Verifies Transfer Submitted Message after clicking on Transfer Now Button.")
	public void ClickOnTransferNowBtnAndVerifiesTransferSubmittedMsg() throws Exception {
		try {
			clickOnElement(DBSappObject.TransferNowBtn());
			if (isElementVisible(DBSappObject.TransferSubmittedImage()))
				Asserts.assertEquals(getTexOfElement(DBSappObject.TransferSubmittedMsg()),
						CommonTestData.TRANSFER_SUBMITTED_MSG.getEnumValue(),
						CommonTestData.TRANSFER_SUBMITTED_MSG.getEnumValue() + " Text is not found");
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}

	@Step("Verifies Reference Number Text after clicking on Image Expand Button.")
	public void ClickOnImageExpandBtnAndVerifiesReferenceNumberText() throws Exception {
		try {
			clickOnElement(DBSappObject.ImageExpand());
			Asserts.assertEquals(getTexOfElement(DBSappObject.ReferenceNumberText()),
					CommonTestData.REFERENCE_NUMBER_TEXT.getEnumValue(),
					CommonTestData.REFERENCE_NUMBER_TEXT.getEnumValue() + " Text is not found");
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}

	@Step("Verifies Overseas transfer Message after clicking on Share Transfer Details Button.")
	public void ClickOnShareTransferDetailsBtnAndVerifiesReferenceNumberText() throws Exception {
		try {
			clickOnElement(DBSappObject.ShareTransferDetailsBtn());
			Asserts.assertEquals(getTexOfElement(DBSappObject.OverseasTransferMsg()),
					CommonTestData.OVERSEAS_TRANSFER_TEXT.getEnumValue(),
					CommonTestData.OVERSEAS_TRANSFER_TEXT.getEnumValue() + " Text is not found");
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}

	@Step("Click On Pay & Transfer Button and then 2FA Authentication Done.")
	public void ClickOnPayAndTransferBtnAndAuthenticationOfSecurePIN() throws Exception {
		try {
			ClickOnPayAndTransferAndVerify(CommonTestData.PAY_TRANSFER_ICON.getEnumValue());
			isElementVisible(DBSappObject.ToFASecurePINMsg());
			clickOnElement(DBSappObject.PasscodeField());
			enterTextInTextbox(DBSappObject.PasscodeField(), CommonTestData.OTP.getEnumValue());
			clickOnElement(DBSappObject.DoneButtonForPasscode());
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}

	@Step("Click on Pay And Transfer and verify label.")
	public void ClickOnPayAndTransferAndVerify(String expectecText) throws Exception {
		try {
			String actualText = CommonAppiumTest.getTexOfElement(DBSappObject.payAndTransferLabel());
			Asserts.assertEquals(actualText, expectecText, "Label Not matching");
			if (isElementVisible(DBSappObject.PayAndTransferBtn()))
				clickOnElement(DBSappObject.PayAndTransferBtn());
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}

	}

	@Step("Verifying Overseas  icon and click")
	public void overseasVerifyClick(String expectecText) throws Exception {
		try {

			String actualText = CommonAppiumTest.getTexOfElement(DBSappObject.overseasLabel());
			Asserts.assertEquals(actualText, expectecText, "Label Not matching");

			if (actualText.equalsIgnoreCase(expectecText))
				clickOnElement(DBSappObject.Btnlist().get(3));

		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}

	@Step("Verifying Add Overseas Recipient  Label and click")
	public void addOverseasRecipientVerifyClick(String expectecText) throws Exception {
		try {

			String actualText = CommonAppiumTest.getTexOfElement(DBSappObject.addRecipientNowButton());

			if (actualText.equalsIgnoreCase(expectecText))
				CommonAppiumTest.clickOnElement(DBSappObject.addRecipientNowButton());

			Asserts.assertEquals(actualText, expectecText, "Label Not matching");

		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}

	}

	@Step("Enter the text in search and select the corresponding value in the dropdown")
	public void sendDataInSearchBoxAndSelectFromDropDown(String searchBoxData, String valueSelectedFromList) {
		try {
			if (isElementEnable(DBSappObject.locationAutocompleteSearchBox()))
				enterTextInTextbox(DBSappObject.locationAutocompleteSearchBox(), searchBoxData);
			wait.waitForElementVisibility(DBSappObject.countryList().get(0));
			List<MobileElement> Elementlist = DBSappObject.countryList();
			List<MobileElement> ElementlistClickable = DBSappObject.countryclickableList();
			int l = Elementlist.size();
			int index = 0;
			String countryFromList = null;
			for (int i = 0; i < l; i++) {
				countryFromList = Elementlist.get(i).getText();
				if (countryFromList.equalsIgnoreCase(valueSelectedFromList)) {
					index++;
					clickOnElement(ElementlistClickable.get(i));

				}
			}
			Asserts.assertTrue(isElementEnable(DBSappObject.locationAutocompleteSearchBox()),
					"SearchField is not enable");
			Asserts.assertTrue(index > 0, "No element found in the lis of corresponding value");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step("Verifying AUD CurrencyType Label and click")
	public void CurrencyTypeVerifyClick(String expectecText) throws Exception {
		try {

			String actualText = CommonAppiumTest.getTexOfElement(DBSappObject.currencyLabel());

			if (actualText.equalsIgnoreCase(expectecText))
				CommonAppiumTest.clickOnElement(DBSappObject.currencyLabel());

			Asserts.assertEquals(actualText, expectecText, "Currency is Not matching");

		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}

	}

	@Step("Verifying AUD CurrencyType Label and click")
	public void nextButtonVerifyClick() throws Exception {
		try {

			String actualText = CommonAppiumTest.getTexOfElement(DBSappObject.nextButton());

			if (actualText.equalsIgnoreCase("NEXT"))
				CommonAppiumTest.clickOnElement(DBSappObject.nextButton());

			Asserts.assertEquals(actualText, "NEXT", "Button not found");

		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}

	}

	@Step("Enter data in Bank Code EditBox")
	public void sendBankCode(String text) {
		try {
			if (isElementEnable(DBSappObject.enterBankcodeTextField()))
				enterTextInTextbox(DBSappObject.enterBankcodeTextField(), text);

			Asserts.assertTrue(isElementEnable(DBSappObject.enterBankcodeTextField()), "EditField is not enable");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will send data in the editbox
	 */
	@Step("Enter Account No EditBox")
	public void sendAccountNo(String text) {
		try {
			if (isElementEnable(DBSappObject.recipientAccountNoEditBox()))
				enterTextInTextbox(DBSappObject.recipientAccountNoEditBox(), text);

			Asserts.assertTrue(isElementEnable(DBSappObject.recipientAccountNoEditBox()), "EditField is not enable");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will send data in the editbox
	 */
	@Step("Enter Full name EditBox")
	public void sendFullName(String text) {
		try {
			if (isElementEnable(DBSappObject.recipientNameEditBox()))
				enterTextInTextbox(DBSappObject.recipientNameEditBox(), text);

			Asserts.assertTrue(isElementEnable(DBSappObject.recipientNameEditBox()), "EditField is not enable");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step("Enter Address EditBox")
	public void sendAddress(String text) {
		try {
			if (isElementEnable(DBSappObject.recipientAddressEditBox()))
				enterTextInTextbox(DBSappObject.recipientAddressEditBox(), text);

			Asserts.assertTrue(isElementEnable(DBSappObject.recipientAddressEditBox()), "EditField is not enable");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step("Enter city EditBox")
	public void sendcity(String text) {
		try {
			if (isElementEnable(DBSappObject.recipientCityEditBox()))
				enterTextInTextbox(DBSappObject.recipientCityEditBox(), text);

			Asserts.assertTrue(isElementEnable(DBSappObject.recipientCityEditBox()), "EditField is not enable");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will verifying 'Tap on the stars to rate' field
	 */
	@Step("Verify 'REVIEW RECIPIENT'S DETAILS label' field")
	public void verifyRecipientReviewDetailLabel(String expectedText) {
		try {
			String actualText = getTexOfElement(DBSappObject.recipientReviewDetailLabel());

			Asserts.assertEquals(actualText, expectedText, "'REVIEW RECIPIENT'S DETAILS label' Text is not found");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will verifying and clicking 'ADD RECIPIENT NOW' button field
	 */
	@Step("Verifying AUD CurrencyType Label and click")
	public void addRecipientNownVerifyClick(String expectecText) throws Exception {
		try {

			String actualText = CommonAppiumTest.getTexOfElement(DBSappObject.addRecpientNowButton());

			if (actualText.equalsIgnoreCase(expectecText))
				CommonAppiumTest.clickOnElement(DBSappObject.addRecpientNowButton());

			Asserts.assertEquals(actualText, expectecText, "Button not found");

		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}

	}

	/**
	 * This method will verifying 'You've added a recipient label' field
	 */
	@Step("Verify 'You've added a recipient label' field")
	public void verifyRecipientAddedLabel(String expectedText) {
		try {
			String actualText = getTexOfElement(DBSappObject.recipientaddedLabel());

			Asserts.assertEquals(actualText, expectedText, "'You've added a recipient label' Text is not found");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step("Clicked on expand button")
	public void expandButton() {
		try {
			clickOnElement(DBSappObject.expandButton());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will verifying 'You've added a recipient label' field
	 */
	@Step("Verify 'MAKE A TRANSFER' field")
	public void verifymakeTransferButton(String expectedText) {
		try {
			String actualText = getTexOfElement(DBSappObject.makeTransferButton());

			Asserts.assertEquals(actualText, expectedText, "'MAKE A TRANSFER' Text is not found");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will verifying 'You've added a recipient label' field
	 */
	@Step("Verify 'Reference No. Field and its value' field")
	public void verifyReferenceFieldAndItsValue(String expectedText) {
		try {
			String actualText = getTexOfElement(DBSappObject.referenceNoLabel());

			Asserts.assertEquals(actualText, expectedText, "'Reference no Field' is not found");
			Asserts.assertTrue(isElementVisible(DBSappObject.referenceNoValue()), "Reference Number not Found");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *
	 * @author Shafqat DBS Android APPLICATION paylah topup Functional Repository.
	 *
	 *
	 *
	 *         /** This method will verify and click 'TopUp' field
	 */
	@Step("Verifying TopUp  Label and click")
	public void topUpVerifyClick(String expectecText) throws Exception {
		try {

			String actualText = CommonAppiumTest.getTexOfElement(DBSappObject.topUpLabel());

			if (actualText.equalsIgnoreCase(expectecText))
				CommonAppiumTest.clickOnElement(DBSappObject.topUpButton());

			Asserts.assertEquals(actualText, expectecText, "Top up Label Not matching");

		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}

	}

	/**
	 * This method will verify and click 'Paylah' field
	 */
	@Step("Verifying TopUp  Label and click")
	public void payLahVerifyClick(String expectecText) throws Exception {
		try {

			String actualText = CommonAppiumTest.getTexOfElement(DBSappObject.paylahLabel());

			if (actualText.equalsIgnoreCase(expectecText))
				CommonAppiumTest.clickOnElement(DBSappObject.paylahButton());

			Asserts.assertEquals(actualText, expectecText, "PayLah Label Not matching");

		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}

	}

	/**
	 * This method will verifying 'You've added a recipient label' field
	 */
	@Step("Verify 'Top Up Paylah Label' field")
	public void verifyTopUpPaylahLabel(String expectedText) {
		try {
			String actualText = getTexOfElement(DBSappObject.topUpPaylahLabel());

			Asserts.assertEquals(actualText, expectedText, "'Top Up Paylah' Text is not found");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will send data in the editbox
	 */
	@Step("Enter currency in EditBox")
	public void sendCurrencyInTextField(String text) {
		try {
			if (isElementEnable(DBSappObject.currencyTextBox()))
				enterTextInTextbox(DBSappObject.currencyTextBox(), text);

			Asserts.assertTrue(isElementEnable(DBSappObject.currencyTextBox()), "EditField is not enable");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step("Verify 'Top Up Paylah Label' field And Verify 'Enter Amount' field")
	public void verifyReviewTopUpLabel(String expectedText) {
		try {
			Asserts.assertEquals(getTexOfElement(DBSappObject.reviewTopUpLabel()), expectedText, "'Top Up Paylah' Text is not found");
			Asserts.assertEquals(getTexOfElement(DBSappObject.displayAmount()), CommonTestData.AMOUNT_PAYLAH.getEnumValue(), "'Display Amount' is incorrect");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step("Verifying TOP UP NOW  Label and click and then Verify 'Top-up Done' field and Display Amount")
	public void topUpNowVerifyClick(String expectecText) throws Exception {
		try {

			String actualText = CommonAppiumTest.getTexOfElement(DBSappObject.topUpNowButton());

			if (actualText.equalsIgnoreCase(expectecText))
				CommonAppiumTest.clickOnElement(DBSappObject.topUpNowButton());

			 Asserts.assertEquals(actualText, expectecText, "TOP UP NOW button Not exist");
			 Asserts.assertEquals(getTexOfElement(DBSappObject.topUpDoneLabel()), CommonTestData.TOPUP_UP_DONE_LABEL.getEnumValue(), "'Top-up Done' Text is not found");
			 Asserts.assertEquals(getTexOfElement(DBSappObject.displayAmount()), CommonTestData.AMOUNT_PAYLAH.getEnumValue(), "'Display Amount' is incorrect");
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}

	}

	@Step("Verifying Logout Label and click")
	public void logOutTopUpVerifyClick(String expectecText) throws Exception {
		try {
			String actualText = CommonAppiumTest.getTexOfElement(DBSappObject.logOutPaylahButton());
			if (actualText.equalsIgnoreCase(expectecText))
				CommonAppiumTest.clickOnElement(DBSappObject.logOutPaylahButton());
			Asserts.assertEquals(actualText, expectecText, "LogOut button Not exist");
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}

	@Step("Verifies the Applying Debit Card and Verify the completion page details.")
	public void ApplyDebitCard() throws Exception {
		try {

		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}

	@Step("verify balance on peek balance popup in prelogin page should be same as current account balance in dashboard with current date and time.")
	public void VerifyPeekBalance() throws Exception {
		try {

		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}

}
