package com.crestech.pages;

import static org.testng.Assert.assertFalse;
import java.time.Duration;
import java.util.logging.Logger;
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
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;

/**
 * @author Divya Devi, Shafkat Ali
 *
 */
public class DBSAndroidPage extends CommonAppiumTest {

	static Logger log = Logger.getLogger(DBSAndroidPage.class.getName());
	public DBSAndroidObject DBSappObject = new DBSAndroidObject();

	public DBSAndroidPage(AppiumDriver<RemoteWebElement> driver) {
		super(driver);
		try {
			PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), DBSappObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step("Relaunching DBS application")
	public void relaunchingDBS() {
		try {
			relanchApplication(CommonTestData.DBS_APP_PACKAGE.getEnumValue(),
					CommonTestData.DBS_APPS_ACTIVITY.getEnumValue());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step("Relaunching POSB application")
	public void relaunchingPOSB() {
		try {
			relanchApplication(CommonTestData.POSB_APP_PACKAGE.getEnumValue(),
					CommonTestData.DBS_APPS_ACTIVITY.getEnumValue());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step("Relaunching iWealth application")
	public void relaunchingIwealth() {
		try {
			relanchApplication(CommonTestData.IWEALTH_APP_PACKAGE.getEnumValue(),
					CommonTestData.DBS_APPS_ACTIVITY.getEnumValue());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step("Log In the Application")
	public void logInApplication(String userName, String password) throws Exception {
		try {
			WaitUtils wait = new WaitUtils(driver);
			CommonAlertElements btnElements = new CommonAlertElements(driver);
			wait.ImplicitlyWait();
			driver.closeApp();
			wait.ImplicitlyWait();
			relaunchingDBS();
			wait.ImplicitlyWait();
			clickOnLoginButton();
			sendDataInUserId(userName);
			sendDataInUserPin(password);
			clickOnLoginButton();
			digitalTokenSetUp();
			AndroidAlert.fingerprintAlertHandlingWithButtonMessage(btnElements.closeButton(),
					CommonTestData.FINGERPRINT_MESSAGE.getEnumValue());
			AndroidAlert.recordingAlertHandlingWithButtonMessage(btnElements.closeButton(),
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
	public void clickOnLoginButton() {
		try {
			clickOnElement(DBSappObject.loginButton());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step("Clicked on Sign Up For Digibank button")
	public void clickOnSignUpForDigibankButton() {
		try {
			clickOnElement(DBSappObject.signUpForDigibankButton());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step("Clicked on Pre Login button")
	public void preLoginButton() {
		try {
			clickOnElement(DBSappObject.loginButton());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step("Enter data in User EditBox")
	public void sendDataInUserId(String text) {
		try {
			if (isElementEnable(DBSappObject.userIdEditText()))
				enterTextInTextbox(DBSappObject.userIdEditText(), text);

			Asserts.assertTrue(isElementEnable(DBSappObject.userIdEditText()), "EditField is not enable");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step("Enter data in Pin EditBox")
	public void sendDataInUserPin(String text) {
		try {
			if (isElementEnable(DBSappObject.userPinEditText()))
				enterTextInTextbox(DBSappObject.userPinEditText(), text);

			Asserts.assertTrue(isElementEnable(DBSappObject.userPinEditText()), "EditField is not enable");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step("Application Logout & Verifies the 'Tap on the stars to rate' field Message.")
	public void clickOnLogoutAndVerify(String logoutTextMsg, String Ratingmsg) {
		try {
			AndroidAlert.AlertHandlingWithButtonMessage(DBSappObject.logoutButton(), logoutTextMsg,
					DBSappObject.logoutButton());
			Asserts.assertEquals(getTexOfElement(DBSappObject.postLogoutAlertMessage()), Ratingmsg,
					"'Tap on the stars to rate' Text is not found");
		} catch (Exception e) {
			e.printStackTrace();
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
			Asserts.assertTrue(isElementEnable(DBSappObject.emailSmsOtpEditBox()), "TextField is not enable");
			Asserts.assertEquals(actualMessage, expectecMessage, "Title Message Not matching");
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}

	}

	@Step("Verifying Page after Digital Token setup after clicking on 'Done' button")
	public void digitalTokenSetUp() throws Exception {
		try {
			Thread.sleep(5000);
			verifyPageAndClickOnSetUpNowButton(CommonTestData.DIGITAL_TOKEN_SETUP_MESSAGE.getEnumValue());
			verifyPageAndSendOtpToEditBox(CommonTestData.OTP.getEnumValue(),
					CommonTestData.EMAIL_OTP_MESSAGE.getEnumValue());
			verifyPageAndSendOtpToEditBox(CommonTestData.OTP.getEnumValue(),
					CommonTestData.SMS_OTP_MESSAGE.getEnumValue());
			AndroidAlert.AlertHandlingWithButtonMessage(DBSappObject.doneButton(),
					CommonTestData.DIGITAL_TOKEN_MESSAGE_AFTER_STEPUP.getEnumValue(),
					DBSappObject.tokenGetSetupMessage());
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}

	@Step("Verifies Remittance Corridor")
	public void VerifyRemittanceCorridor() throws Exception {
		try {
			ClickOnPayAndTransferBtnAndAuthenticationOfSecurePIN();
			ClickOnNextButtonAfterEnteringAmount();
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
			ClickOnPayAndTransferBtnAndAuthenticationOfSecurePIN();
			ClickOnNextButtonAfterEnteringAmount();
			ClickOnTransferNowBtnAndVerifiesTransferSubmittedMsg();
			ClickOnImageExpandBtnAndVerifiesReferenceNumberText();
			ClickOnShareTransferDetailsBtnAndVerifiesReferenceNumberText();
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}

	@Step("Next Button Procced With Entering Amount After Selecting any one fund source After selecting payee & Verifies Review Transfer Message on the top of the Header.")
	public void ClickOnNextButtonAfterEnteringAmount() throws Exception {
		try {
			isElementVisible(DBSappObject.OverseasBtnText());
			clickOnElement(DBSappObject.Btnlist().get(3));
			isElementVisible(DBSappObject.OverseasTransferPage());
			clickOnElement(DBSappObject.PayeeList().get(2));
			isElementVisible(DBSappObject.SelectFundSourcePage());
			clickOnElement(DBSappObject.SourceFundList().get(2));
			clickOnElement(DBSappObject.AmountTextFields().get(0));
			enterTextInTextbox(DBSappObject.AmountTextFields().get(0), CommonTestData.AMOUNT.getEnumValue());
			pressGivenKey(driver, Keys.ENTER);
			isElementVisible(DBSappObject.ExchangeRateText());
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
			if (isElementVisible(DBSappObject.PayAndTransferBtn())) {
				clickOnElement(DBSappObject.PayAndTransferBtn());
				isElementVisible(DBSappObject.ToFASecurePINMsg());
				clickOnElement(DBSappObject.PasscodeField());
				if (isElementEnable(DBSappObject.PasscodeField()))
					enterTextInTextbox(DBSappObject.emailSmsOtpEditBox(), CommonTestData.OTP.getEnumValue());
				clickOnElement(DBSappObject.doneButton());
			}
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}

}
