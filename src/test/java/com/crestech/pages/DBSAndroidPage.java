package com.crestech.pages;

import static org.testng.Assert.assertFalse;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
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
import com.crestech.common.utilities.GestureUtils;
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
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Relaunching DBS application")
	public void relaunchingDBS() throws Exception {
		try {
			relanchApplication(CommonTestData.DBS_APP_PACKAGE.getEnumValue(),
					CommonTestData.DBS_APPS_ACTIVITY.getEnumValue());
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Relaunching POSB application")
	public void relaunchingPOSB() throws Exception {
		try {
			relanchApplication(CommonTestData.POSB_APP_PACKAGE.getEnumValue(),
					CommonTestData.DBS_APPS_ACTIVITY.getEnumValue());
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Relaunching iWealth application")
	public void relaunchingIwealth() throws Exception {
		try {
			relanchApplication(CommonTestData.IWEALTH_APP_PACKAGE.getEnumValue(),
					CommonTestData.DBS_APPS_ACTIVITY.getEnumValue());
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Log In the Application")
	public void logInApplication(String userName, String password, String appName) throws Exception {
		try {
			WaitUtils wait = new WaitUtils(driver);
			CommonAlertElements btnElements = new CommonAlertElements(driver);
			Thread.sleep(30000);
			String quitButtonXpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.Button";
			List<RemoteWebElement> list = driver.findElements(By.xpath(quitButtonXpath));
			if (list.size() > 0) {
				driver.closeApp();
				if(appName.contains("DBS"))
					relaunchingDBS();
				else if(appName.contains("POSB"))
					relaunchingPOSB();
				else if(appName.contains("iWEALTH"))
					relaunchingIwealth();
				wait.waitForElementToBeClickable(DBSappObject.loginButton());
				Thread.sleep(5000);
			}
			
			UpdateUATN4Server();
			
			clickOnLoginButton();
			sendDataInUserId(userName);
			sendDataInUserPin(password);
			clickOnLoginButton();
			digitalTokenSetUp();
			AndroidAlert androidAlert = new AndroidAlert(driver);
			Thread.sleep(2000);
			String getStartedXpath = null;
			if(appName.contains("POSB")) 
				getStartedXpath = "//android.widget.Button[@resource-id='com.dbs.sit1.posbmbanking:id/btn_get_started']";
			else if(appName.contains("DBS"))
				getStartedXpath = "//android.widget.Button[@resource-id='com.dbs.sit1.dbsmbanking:id/btn_get_started']";
			else if(appName.contains("iWEALTH"))
				getStartedXpath = "//android.widget.Button[@resource-id='com.dbs.sg.uat.dbsiwealth:id/btn_get_started']";
			List<RemoteWebElement>getStartedlist = driver.findElements(By.xpath(getStartedXpath));
			if(getStartedlist.size()>0)
				clickOnElement((MobileElement) getStartedlist.get(0));
			String errorAlertOKButton = "//android.widget.Button[@resource-id='android:id/button1']";
			List<RemoteWebElement>errorAlertOKButtonlist = driver.findElements(By.xpath(errorAlertOKButton));
			if(getStartedlist.size()>0)
				clickOnElement((MobileElement) errorAlertOKButtonlist.get(0));
			androidAlert.fingerprintAlertHandlingWithButtonMessage(btnElements.closeButton(),
					CommonTestData.FINGERPRINT_MESSAGE.getEnumValue());
			androidAlert.recordingAlertHandlingWithButtonMessage(btnElements.closeButton(),
					CommonTestData.RECORDERSECTION_MESSAGE.getEnumValue());
			Asserts.assertEquals(getTexOfElement(DBSappObject.WelcomeToText()).trim(),
					CommonTestData.WELCOME.getEnumValue(),
					CommonTestData.WELCOME.getEnumValue() + " text is not found");
			
		    TakeScreenshot(DBSappObject.DigibankText()); 
			if(DBSappObject.DigibankText().getText().equalsIgnoreCase(CommonTestData.DIGIBANK.getEnumValue())) {
				Asserts.assertEquals(getTexOfElement(DBSappObject.DigibankText()).trim(),
						CommonTestData.DIGIBANK.getEnumValue(),
						CommonTestData.DIGIBANK.getEnumValue() + " text is not found");
			}
			else if(DBSappObject.DigibankText().getText().equalsIgnoreCase(CommonTestData.DBS_DIGIBANK.getEnumValue())) {
				Asserts.assertEquals(getTexOfElement(DBSappObject.DigibankText()).trim(),
						CommonTestData.DBS_DIGIBANK.getEnumValue(),
						CommonTestData.DBS_DIGIBANK.getEnumValue() + " text is not found");
			}
			
		} catch (Exception e) {
			assertFalse(true);
			throw new Exception(getExceptionMessage(e));
		}
	}
	
	@Step("Select And Save UAT N4 Server")
	public void UpdateUATN4Server() throws Exception {
		try {
			TakeScreenshot(DBSappObject.PreLoginBtn());
			clickOnElement(DBSappObject.PreLoginBtn());
			TakeScreenshot(DBSappObject.MoreButton());
			clickOnElement(DBSappObject.MoreButton());
			TakeScreenshot(DBSappObject.ChangeServerBtn());
			clickOnElement(DBSappObject.ChangeServerBtn());
			GestureUtils.scrollUPtoObject("text", "UAT N4", DBSappObject.SelectUATN4_Server());
			TakeScreenshot(DBSappObject.SelectUATN4_Server());
			clickOnElement(DBSappObject.SelectUATN4_Server());
			TakeScreenshot(DBSappObject.ChangeServerSaveBtn());
			clickOnElement(DBSappObject.ChangeServerSaveBtn());
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Clicked on Login button")
	public void clickOnLoginButton() throws Exception {
		try {
			TakeScreenshot(DBSappObject.loginButton()); 
			clickOnElement(DBSappObject.loginButton());
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Clicked on Sign Up For Digibank button")
	public void clickOnSignUpForDigibankButton() throws Exception {
		try {
			clickOnElement(DBSappObject.signUpForDigibankButton());
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Clicked on Pre Login button")
	public void preLoginButton() throws Exception {
		try {
			clickOnElement(DBSappObject.loginButton());
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Enter data in User EditBox")
	public void sendDataInUserId(String text) throws Exception {
		try {
			if (isElementEnable(DBSappObject.userIdEditText()))
				enterTextInTextbox(DBSappObject.userIdEditText(), text);
             
			Asserts.assertTrue(isElementEnable(DBSappObject.userIdEditText()), "EditField is not enable");
			TakeScreenshot(DBSappObject.userIdEditText()); 
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Enter data in Pin EditBox")
	public void sendDataInUserPin(String text) throws Exception {
		try {
			if (isElementEnable(DBSappObject.userPinEditText()))
				enterTextInTextbox(DBSappObject.userPinEditText(), text);

			Asserts.assertTrue(isElementEnable(DBSappObject.userPinEditText()), "EditField is not enable");
			 TakeScreenshot(DBSappObject.userPinEditText()); 
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Application Logout & Verifies the 'Tap on the stars to rate' field Message.")
	public void clickOnLogoutAndVerify(String logoutTextMsg, String Ratingmsg) throws Exception {
		try {
             TakeScreenshot(DBSappObject.logoutButton());
			AndroidAlert.AlertHandlingWithButtonMessage(DBSappObject.logoutButton(), logoutTextMsg,
					DBSappObject.logoutButton());
			Asserts.assertEquals(getTexOfElement(DBSappObject.postLogoutAlertMessage()), Ratingmsg,
					"'Tap on the stars to rate' Text is not found");
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Verifying Page and clicking on 'SET UP NOW' button ")
	public void verifyPageAndClickOnSetUpNowButton(String expectecMessage) throws Exception {
		try {
			AndroidAlert.AlertHandlingWithButtonMessage(DBSappObject.setUpNowButton(), expectecMessage,
					DBSappObject.tokenSetupMessage());
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Verifying Email/SMS OTP Page and Send OTP on TextField button ")
	public void verifyPageAndSendOtpToEditBox(String OTP, String expectecMessage) throws Exception {
		try {
			String actualMessage = getTexOfElement(DBSappObject.emailSmsOtpMessage());
			if (actualMessage.equalsIgnoreCase(expectecMessage))
				if (isElementEnable(DBSappObject.emailSmsOtpEditBox()))
					enterTextInTextbox(DBSappObject.emailSmsOtpEditBox(), OTP);
			Asserts.assertEquals(actualMessage, expectecMessage, "Title Message Not matching");
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Verifying Page after Digital Token setup after clicking on 'Done' button")
	public void digitalTokenSetUp() throws Exception {
		try {
			Thread.sleep(5000);
			String digitalTokenSetUpXpath = "//android.widget.TextView[contains(@resource-id,'id/status_message')]";
			Thread.sleep(5000); 
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
				Thread.sleep(4000); 
				GestureUtils.scrollUPtoObject("text", "DONE", DBSappObject.doneButton()); 
				String xpath = "//android.widget.Button[@text='DONE']";
				List<RemoteWebElement> list = driver.findElements(By.xpath(xpath));
				if (list.size() > 0) {
					TakeScreenshot(DBSappObject.doneButton());
					AndroidAlert.AlertHandlingWithButtonMessage(DBSappObject.doneButton(),
							CommonTestData.DIGITAL_TOKEN_MESSAGE_AFTER_STEPUP.getEnumValue(),
							DBSappObject.tokenGetSetupMessage());
				}
				
			}
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Verifies Remittance Corridor")
	public void VerifyRemittanceCorridor() throws Exception {
		try {
			ClickOnPayAndTransferBtn();
			EnterPasscodeAndDone();
			SelectingPayeeAndFundSourceAfterSelectingOverseas();
			pressEnterKeyAfterEnteringAmount(CommonTestData.CORRIDOR_AMOUNT.getEnumValue());
			ClickOnNextBtnAndVerifiesReviewTransferPage();
			ClickOnTransferNowBtnAndVerifiesTransferSubmittedMsg(CommonTestData.TRANSFER_SUBMITTED_MSG.getEnumValue(),
					DBSappObject.TransferSubmittedImage(), DBSappObject.TransferSubmittedMsg());
			ClickOnImageExpandBtnAndVerifiesReferenceNumberText();
			ClickOnShareTransferDetailsBtnAndVerifiesReferenceNumberText();
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Verifies Remittance eOTT")
	public void VerifyRemittanceEOTT() throws Exception {
		try {
			ClickOnPayAndTransferBtn();
			EnterPasscodeAndDone();
			SelectAllTAB();
			clickOnElement(DBSappObject.editSearchField());
			String ExpectedEottName = CommonTestData.EOTTREMITTANCE_NAME.getEnumValue();
			enterTextInTextbox(DBSappObject.editSearchField(), ExpectedEottName );
			pressKey(driver, Keys.ENTER);
			String xpath ="//android.widget.TextView[@text='"+ExpectedEottName+"']";
			MobileElement ExpectedEottEle = (MobileElement) driver.findElement(By.xpath(xpath));
			isElementVisible(ExpectedEottEle);
			clickOnElement(ExpectedEottEle);
			Asserts.assertEquals(getTexOfElement(DBSappObject.OverseasTransferPage()),
					CommonTestData.OVERSEAS_TRANSFER_PAGEHEADER.getEnumValue(),
					CommonTestData.OVERSEAS_TRANSFER_PAGEHEADER.getEnumValue() + " Text is not found");
			clickOnElement(DBSappObject.SelectFundSourcePage());
			clickOnElement(DBSappObject.SourceFundList().get(0));

			pressEnterKeyAfterEnteringAmount(CommonTestData.eOTT_AMOUNT.getEnumValue());
			GestureUtils.scrollUPtoObject("resource-id", "id/btn_remitnext", DBSappObject.NextBtn());
			clickOnElement(DBSappObject.SelectPurposeOfTransfer());
			clickOnElement(DBSappObject.FundTransferPurposeOption());
			Asserts.assertEquals(getTexOfElement(DBSappObject.TextViewPurpose()),
					CommonTestData.PURPOSE_OF_TRANSFER_TEXT.getEnumValue(),
					CommonTestData.PURPOSE_OF_TRANSFER_TEXT.getEnumValue() + " Text is not found");

			ClickOnNextBtnAndVerifiesReviewTransferPage();
			ClickOnTransferNowBtnAndVerifiesTransferSubmittedMsg(CommonTestData.TRANSFER_SUBMITTED_MSG.getEnumValue(),
					DBSappObject.TransferSubmittedImage(), DBSappObject.TransferSubmittedMsg());
			ClickOnImageExpandBtnAndVerifiesReferenceNumberText();
			ClickOnShareTransferDetailsBtnAndVerifiesReferenceNumberText();
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Verifies Add payee DBSorPOSB.")
	public void VerifyAddPayeeDBSorPOSB() throws Exception {
		try {
			ClickOnPayAndTransferBtn();
			EnterPasscodeAndDone();
			clickOnAddLocalRecipientBtnAndVerifyLocalTransferPayNowPageHeader();
			String randomString = GenerateRandomRecipientName();
			 String ExpectedRecipientName = CommonTestData.PAYEEADD_DBSPOSB_RECIPIENT_NAME.getEnumValue().concat(randomString);
			EnterRecipientDetailsAfterSelectingBankAccountOption(ExpectedRecipientName,CommonTestData.PAYEEADD_DBSPOSB_BANK_NAME.getEnumValue(),
					CommonTestData.PAYEEADD_DBSPOSB_ACCOUNT_NUMBER.getEnumValue());
			ClickOnNextBtnAndReviewRecipientDetails();
			ClickOnAddRecipientNowBtn();
			VerifyYouHaveAddedRecipientMsgAfterEnterSecurePIN();
			verifyValidationForPayeeAdd(ExpectedRecipientName,CommonTestData.PAYEEADD_DBSPOSB_BANK_NAME.getEnumValue(),
					CommonTestData.PAYEEADD_DBSPOSB_ACCOUNT_NUMBER.getEnumValue());
//			clickOnElement(DBSappObject.BackIcon());
			//com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
//			DeletePayee(ExpectedRecipientName);
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Verify 'You Have Added Recipient Msg' After Entering Secure PIN.")
	public void VerifyYouHaveAddedRecipientMsgAfterEnterSecurePIN() throws Exception {
		try {
			EnterPasscodeAndDone();
			Thread.sleep(20000); 
			wait.waitForElementVisibility(DBSappObject.SuccessTickImageView()); 
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			if (isElementVisible(DBSappObject.SuccessTickImageView()))
				Asserts.assertEquals(getTexOfElement(DBSappObject.PageHeaderList().get(0)), 
						CommonTestData.YOU_HAVE_ADDED_RECIPIENT_MSG.getEnumValue(),
						CommonTestData.YOU_HAVE_ADDED_RECIPIENT_MSG.getEnumValue() + " Text is not matching");
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Verify Local Transfer Pay Now Page Header After Clicking On Add Local Recipient Page Header.")
	public void clickOnAddLocalRecipientBtnAndVerifyLocalTransferPayNowPageHeader() throws Exception {
		try {
			String xpath = "//android.widget.Button[@text='ADD RECIPIENT NOW']";
			List<RemoteWebElement> list = driver.findElements(By.xpath(xpath));
			if (list.size() > 0) {
				wait.waitForElementVisibility(DBSappObject.AddRecipientNowBtn());
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
					clickOnElement(DBSappObject.AddRecipientNowBtn());
			}else {
				wait.waitForElementVisibility(DBSappObject.AddLocalRecipient());
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				clickOnElement(DBSappObject.AddLocalRecipient());
			}
			Asserts.assertEquals(getTexOfElement(DBSappObject.PageHeader()),
					CommonTestData.LOCAL_TRANSFER_PayNow.getEnumValue(),
					CommonTestData.LOCAL_TRANSFER_PayNow.getEnumValue() + " Page Header is not matching");
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Enter Recipient Details Into Bank Account Section.")
	public void EnterRecipientDetailsAfterSelectingBankAccountOption(String ExpectedRecipientName , String BankName, String AccountNumber) throws Exception {
		try {
			wait.waitForElementVisibility(DBSappObject.SelectBankAccount()); 
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(DBSappObject.SelectBankAccount());
			Asserts.assertEquals(getTexOfElement(DBSappObject.PageHeader()),
					CommonTestData.ENTER_RECIPIENT_DETAILS.getEnumValue(),
					CommonTestData.ENTER_RECIPIENT_DETAILS.getEnumValue() + " Text is not found");
			enterTextInTextbox(DBSappObject.EditFields().get(0), ExpectedRecipientName);
			clickOnElement(DBSappObject.EditFields().get(1));
			clickOnElement(DBSappObject.SearchField());
			enterTextInTextbox(DBSappObject.SearchField(), BankName);
			backButton();
			GestureUtils.scrollUPtoObject("text", "BANK OF INDIA", DBSappObject.SelectBankOFIndia());
			String xpath = "//android.widget.RelativeLayout//android.widget.TextView[@text='"+BankName+"']";
			MobileElement Selectbank = (MobileElement) driver.findElement(By.xpath(xpath));
			clickOnElement(Selectbank);
			enterTextInTextbox(DBSappObject.EditFields().get(2), AccountNumber);
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	
	public String GenerateRandomRecipientName() {
		 // create a string of all characters
	    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 

	    // create random string builder
	    StringBuilder sb = new StringBuilder();

	    // create an object of Random class
	    Random random = new Random();

	    // specify length of random string
	    int length = 2;

	    for(int i = 0; i < length; i++) {

	      // generate random index number
	      int index = random.nextInt(alphabet.length());

	      // get character specified by index
	      // from the string
	      char randomChar = alphabet.charAt(index);

	      // append the character to string builder
	      sb.append(randomChar);
	    }

	    String randomString = sb.toString();
	    System.out.println("Random String is: " + randomString);
	    return randomString;
	}
	
	public int GenerateRandomInt() {
		
		 // create instance of Random class
        Random rand = new Random();
  
        // Generate random integers in range 0 to 999
        int rand_int1 = rand.nextInt(100);
    
	    return rand_int1; 
	}
	
	
	@Step("Enter Passcode(123456) and click on Done button for Secure Pin Authentication.")
	public void EnterPasscodeAndDone() throws Exception {
		try {
			String xpath = "//android.widget.EditText[@text='••••••']";
			List<RemoteWebElement> list = driver.findElements(By.xpath(xpath));
			if (list.size() > 0) {
				TakeScreenshot(DBSappObject.PasscodeField());
				enterTextInTextbox(DBSappObject.PasscodeField(), CommonTestData.OTP.getEnumValue());
				String doneButtonxpath = "//android.widget.Button[@text='Done']";
				List<RemoteWebElement> doneButtonList = driver.findElements(By.xpath(doneButtonxpath));
				if (doneButtonList.size() > 0)
					clickOnElement(DBSappObject.DoneButtonForPasscode());
			}
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
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
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Press enter key after Entering Amount.")
	public void pressEnterKeyAfterEnteringAmount(String Amt) throws Exception {
		try {
			clickOnElement(DBSappObject.AmountTextFields().get(0));
			enterTextInTextbox(DBSappObject.AmountTextFields().get(0), Amt);
			pressKey(driver, Keys.ENTER);
			wait.waitForElementVisibility(DBSappObject.ExchangeRateText());
			backButton();
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Verifies Review Transfer Page Header after clicking on Next Button.")
	public void ClickOnNextBtnAndVerifiesReviewTransferPage() throws Exception {
		try {
			GestureUtils.scrollUPtoObject("resource-id", "id/btn_remitnext", DBSappObject.NextBtn());
			clickOnElement(DBSappObject.NextBtn());
			Asserts.assertEquals(getTexOfElement(DBSappObject.ReviewTransferPageHeader()),
					CommonTestData.REVIEW_TRANSFER.getEnumValue(),
					CommonTestData.REVIEW_TRANSFER.getEnumValue() + " Text is not matching");
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Verifies Transfer Submitted Message after clicking on Transfer Now Button.")
	public void ClickOnTransferNowBtnAndVerifiesTransferSubmittedMsg(String SuccessMsg, MobileElement successImage,
			MobileElement transfferdSubmitMsgEle) throws Exception {
		try {
			TakeScreenshot(DBSappObject.TransferNowBtn()); 
			clickOnElement(DBSappObject.TransferNowBtn());
			if (isElementVisible(successImage))
				Asserts.assertEquals(getTexOfElement(transfferdSubmitMsgEle), SuccessMsg,
						SuccessMsg + " Text is not matching");
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
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
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Verifies Overseas transfer Message after clicking on Share Transfer Details Button.")
	public void ClickOnShareTransferDetailsBtnAndVerifiesReferenceNumberText() throws Exception {
		try {
			GestureUtils.scrollUPtoObject("text", "SHARE TRANSFER DETAILS", DBSappObject.ShareTransferDetailsBtn());
			clickOnElement(DBSappObject.ShareTransferDetailsBtn());
			Asserts.assertEquals(getTexOfElement(DBSappObject.OverseasTransferMsg()),
					CommonTestData.OVERSEAS_TRANSFER_TEXT.getEnumValue(),
					CommonTestData.OVERSEAS_TRANSFER_TEXT.getEnumValue() + " Text is not found");
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Click On Pay & Transfer Button.")
	public void ClickOnPayAndTransferBtn() throws Exception {
		try {
			TakeScreenshot(DBSappObject.PayAndTransferBtn());
			if (isElementVisible(DBSappObject.PayAndTransferBtn()))
				clickOnElement(DBSappObject.PayAndTransferBtn());
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Verifying Overseas  icon and click")
	public void overseasVerifyClick(String expectecText) throws Exception {
		try {

			String actualText = getTexOfElement(DBSappObject.overseasLabel());
			Asserts.assertEquals(actualText, expectecText, "Label Not matching");

			if (actualText.equalsIgnoreCase(expectecText))
				clickOnElement(DBSappObject.Btnlist().get(3));

		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Verifying Add Overseas Recipient  Label and click")
	public void addOverseasRecipientVerifyClick(String expectecText) throws Exception {
		try {

			String actualText = getTexOfElement(DBSappObject.addRecipientNowButton());

			if (actualText.equalsIgnoreCase(expectecText))
				clickOnElement(DBSappObject.addRecipientNowButton());

			Asserts.assertEquals(actualText, expectecText, "Label Not matching");

		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}

	}

	@Step("Enter the text in search and select the corresponding value in the dropdown")
	public void sendDataInSearchBoxAndSelectFromDropDown(String searchBoxData, String valueSelectedFromList, MobileElement searchField)
			throws Exception {
		try {
			
			if (isElementEnable(searchField))
				enterTextInTextbox(searchField, searchBoxData);
			wait.waitForElementVisibility(DBSappObject.countryList().get(0));
			List<MobileElement> Elementlist = DBSappObject.countryList();
			List<MobileElement> ElementlistClickable = DBSappObject.dropDowmList();
			int l = Elementlist.size();
			int index = 0;
			String countryFromList = null;
			for (int i = 0; i < l; i++) {
				countryFromList = Elementlist.get(i).getText();
				if (countryFromList.equalsIgnoreCase(valueSelectedFromList)) {
					index++;
					clickOnElement(ElementlistClickable.get(i));
					break;
				}
			}
			
			Asserts.assertTrue(index>0, "No element found in the lis of corresponding value");

		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Select CurrencyType From the List")
	public void CurrencyTypeVerifyClick(String expectecCurrency) throws Exception {
		try {
			
			wait.waitForElementVisibility(DBSappObject.currencyOptionList().get(0));
			List<MobileElement> Elementlist = DBSappObject.currencyOptionList();
			int l = Elementlist.size();
			int index = 0;
			String currencyFromList = null;
			for (int i = 0; i < l; i++) {
				currencyFromList = Elementlist.get(i).getText();
				if (currencyFromList.equalsIgnoreCase(expectecCurrency)) {
					index++;
					clickOnElement(Elementlist.get(i));
					break;
				}
			}
			
			Asserts.assertTrue(index>0, "No currency found in the list of corresponding value");

		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}

	}

	@Step("Click On Next Button.")
	public void ClickOnNextButton() throws Exception {
		try {
			GestureUtils.scrollUPtoObject("text", "NEXT", DBSappObject.nextButton());
			TakeScreenshot(DBSappObject.nextButton());
			if (getTexOfElement(DBSappObject.nextButton()).equalsIgnoreCase("NEXT"))
				clickOnElement(DBSappObject.nextButton());
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}

	}

	@Step("Enter data in Bank Code EditBox")
	public void sendBankCode(String text) throws Exception {
		try {
			
			
			if (isElementEnable(DBSappObject.enterBankcodeTextField()))
				enterTextInTextbox(DBSappObject.enterBankcodeTextField(), text);
 
			Asserts.assertTrue(isElementEnable(DBSappObject.enterBankcodeTextField()), "EditField is not enable");
			
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Enter Account No EditBox")
	public void sendAccountNo(String text) throws Exception {
		try {
			if (isElementEnable(DBSappObject.recipientAccountNoEditBox()))
				enterTextInTextbox(DBSappObject.recipientAccountNoEditBox(), text);

			//Asserts.assertTrue(isElementEnable(DBSappObject.recipientAccountNoEditBox()), "EditField is not enable");
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Enter Full name EditBox")
	public void sendFullName(String text) throws Exception {
		try {
			if (isElementEnable(DBSappObject.recipientNameEditBox()))
				enterTextInTextbox(DBSappObject.recipientNameEditBox(), text);

			//Asserts.assertTrue(isElementEnable(DBSappObject.recipientNameEditBox()), "EditField is not enable");
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Enter Address EditBox")
	public void sendAddress(String text) throws Exception {
		try {
			if (isElementEnable(DBSappObject.recipientAddressEditBox()))
				enterTextInTextbox(DBSappObject.recipientAddressEditBox(), text);

			//Asserts.assertTrue(isElementEnable(DBSappObject.recipientAddressEditBox()), "EditField is not enable");
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Enter city EditBox")
	public void sendcity(String text) throws Exception {
		try {
			if (isElementEnable(DBSappObject.recipientCityEditBox()))
				enterTextInTextbox(DBSappObject.recipientCityEditBox(), text);

			//Asserts.assertTrue(isElementEnable(DBSappObject.recipientCityEditBox()), "EditField is not enable");
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Verify 'REVIEW RECIPIENT'S DETAILS label' field")
	public void verifyRecipientReviewDetailLabel(String expectedText) throws Exception {
		try {
			String actualText = getTexOfElement(DBSappObject.recipientReviewDetailLabel());

			Asserts.assertEquals(actualText, expectedText, "'REVIEW RECIPIENT'S DETAILS label' Text is not found");

		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("clicking On 'ADD RECIPIENT NOW' button")
	public void ClickOnAddRecipientNowBtn() throws Exception {
		try {
			GestureUtils.scrollUPtoObject("text", "ADD RECIPIENT NOW", DBSappObject.AddRecipientNowBtn());
			wait.waitForElementVisibility(DBSappObject.AddRecipientNowBtn()); 
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			String actualText = getTexOfElement(DBSappObject.AddRecipientNowBtn());
			if (actualText.equalsIgnoreCase(CommonTestData.ADD_RECIPIENT_LABEL.getEnumValue()))
				clickOnElement(DBSappObject.AddRecipientNowBtn());
			Thread.sleep(4000); 
			Asserts.assertEquals(actualText, CommonTestData.ADD_RECIPIENT_LABEL.getEnumValue(), "Button not matching");
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}

	}

	@Step("Verify 'Reference No. Field and its value' field and Verify 'MAKE A TRANSFER' Button After Expanding & Scrolling to the Page.")
	public void verifyReferenceFieldAndItsValue(String expectedText) throws Exception {
		try {
			clickOnElement(DBSappObject.expandButton());
			GestureUtils.scrollUPtoObject("text", "Reference No.", DBSappObject.ReferenceNumberText());
			Asserts.assertEquals(getTexOfElement(DBSappObject.makeTransferButton()),
					CommonTestData.MAKE_TRANSFER.getEnumValue(), "'MAKE A TRANSFER' Text is not found");
			Asserts.assertEquals(getTexOfElement(DBSappObject.ReferenceNumberText()), expectedText,
					"'Reference no Field' is not found");
			boolean i=DBSappObject.referenceNoValue().getText().isEmpty();
			Asserts.assertTrue(i==false, "Reference Number not Found");
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Verifying TopUp Label and click")
	public void topUpVerifyClick(String expectecText) throws Exception {
		try {

			String actualText = getTexOfElement(DBSappObject.topUpLabel());

			if (actualText.equalsIgnoreCase(expectecText))
				clickOnElement(DBSappObject.topUpButton());

			Asserts.assertEquals(actualText, expectecText, "Top up Label Not matching");

		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}

	}

	@Step("Verifying TopUp  Label and click and then verify Top Up Paylah label")
	public void payLahVerifyClick(String expectecText) throws Exception {
		try {

			String actualText = getTexOfElement(DBSappObject.paylahLabel());

			if (actualText.equalsIgnoreCase(expectecText))
				clickOnElement(DBSappObject.paylahLabel());

			Asserts.assertEquals(actualText, expectecText, "PayLah Label Not matching");
			Asserts.assertEquals(getTexOfElement(DBSappObject.topUpPaylahLabel()),
					CommonTestData.TOPUP_PAYLAH_LABEL.getEnumValue(), "'Top Up Paylah' Text is not found");
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Enter currency in EditBox")
	public void sendCurrencyInTextField(String text) throws Exception {
		try {
				enterTextInTextbox(DBSappObject.currencyTextBox(), text);
                TakeScreenshot(DBSappObject.currencyTextBox()); 
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Verify 'Top Up Paylah Label' field And Verify 'Enter Amount' field")
	public void verifyReviewTopUpLabel(String expectedText) throws Exception {
		try {
			Asserts.assertEquals(getTexOfElement(DBSappObject.reviewTopUpLabel()), expectedText,
					"'Top Up Paylah' Text is not found");
			Asserts.assertEquals(getTexOfElement(DBSappObject.displayAmount()),
					CommonTestData.AMOUNT_PAYLAH.getEnumValue(), "'Display Amount' is incorrect");
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Verifying TOP UP NOW  Label and click and then Verify 'Top-up Done' field and Display Amount")
	public void topUpNowVerifyClick(String expectecText) throws Exception {
		try {

			String actualText = getTexOfElement(DBSappObject.topUpNowButton());

			if (actualText.equalsIgnoreCase(expectecText))
				clickOnElement(DBSappObject.topUpNowButton());

			Asserts.assertEquals(actualText, expectecText, "TOP UP NOW button Not exist");
			Asserts.assertEquals(getTexOfElement(DBSappObject.topUpDoneLabel()),
					CommonTestData.TOPUP_UP_DONE_LABEL.getEnumValue(), "'Top-up Done' Text is not found");
			Asserts.assertEquals(getTexOfElement(DBSappObject.displayAmount()),
					CommonTestData.AMOUNT_PAYLAH.getEnumValue(), "'Display Amount' is incorrect");
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}

	}

	@Step("Verifying Logout Label and click")
	public void logOutTopUpVerifyClick(String expectecText) throws Exception {
		try {
			String actualText = getTexOfElement(DBSappObject.logOutPaylahButton());
			if (actualText.equalsIgnoreCase(expectecText))
				clickOnElement(DBSappObject.logOutPaylahButton());
			Asserts.assertEquals(actualText, expectecText, "LogOut button Not exist");
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	
	@Step("Verifies the Applying Debit Card and Verify the completion page details.")
	public void ApplyDebitCard() throws Exception {
		try {
			ClickOnMoreButton();
			EnterPasscodeAndDone();
			SelectDebitCardOptionFromCardsSectionAndAuthenticationOfSecurePIN();
			FillingDetailsToApplyingDebitCard();
			ClickOnNextButton();
			Asserts.assertEquals(getTexOfElement(DBSappObject.PageHeaderList().get(4)),
					CommonTestData.REVIEW_APPLICATION.getEnumValue(),
					CommonTestData.REVIEW_APPLICATION.getEnumValue() + " Text is not found");
			GestureUtils.scrollUPtoObject("text", "APPLY NOW", DBSappObject.ApplyNowButton());
			clickOnElement(DBSappObject.ApplyNowButton());
			ClickOnSubmitButtonAfterSettingCardPIN();
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	
	@Step("Verifies the Set Card Pin Page Header and then Submit While Entering Confirm and Create New Pin & Verifies the 'Application Submitted' Message.")
	public void ClickOnSubmitButtonAfterSettingCardPIN() throws Exception {
		try {
			Asserts.assertEquals(getTexOfElement(DBSappObject.PageHeaderList().get(5)),
					CommonTestData.SET_CARD_PIN.getEnumValue(),
					CommonTestData.SET_CARD_PIN.getEnumValue() + " Text is not found");
			clickOnElement(DBSappObject.CreateYourPINField());
			enterTextInTextbox(DBSappObject.CreateYourPINField(), CommonTestData.CREATE_PIN.getEnumValue());
			clickOnElement(DBSappObject.ConfirmNewPINField());
			enterTextInTextbox(DBSappObject.ConfirmNewPINField(), CommonTestData.CONFIRM_PIN.getEnumValue());
			driver.hideKeyboard();
			clickOnElement(DBSappObject.submitButton());
			Asserts.assertEquals(getTexOfElement(DBSappObject.PageHeaderList().get(8)),
					CommonTestData.APPLICATION_SUBMITTED.getEnumValue(),
					CommonTestData.APPLICATION_SUBMITTED.getEnumValue() + " Text is not Matching");
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Filling Required Details to applying Debit Card like as 'AccountToBeLinkedToTheCardField',"
			+ " 'Title', 'EnterNameToAppearOnTheCardField', 'Race', 'Marital Status','Residential Type',"
			+ "'Education','Economic Status','Annual Income', 'And Select Checkbox SendMeDBSPrmotionViaMail'.")
	public void FillingDetailsToApplyingDebitCard() throws Exception {
		try {
			// To filling Debit Card Details for applying Debit card.
			clickOnElement(DBSappObject.AccountToBeLinkedToTheCardField());
			clickOnElement(DBSappObject.DebitCardDetailsDropdownList().get(3));
			clickOnElement(DBSappObject.TitleField());
			clickOnElement(DBSappObject.DebitCardDetailsDropdownList().get(2));
			clickOnElement(DBSappObject.EnterNameToAppearOnTheCardField());
			enterTextInTextbox(DBSappObject.EnterNameToAppearOnTheCardField(),
					CommonTestData.NAMETO_APPEAR_ON_DEBITCARD.getEnumValue());
			driver.hideKeyboard();
			GestureUtils.scrollUPtoObject("text", "Education", DBSappObject.EducationField());
			clickOnElement(DBSappObject.RaceField());
			clickOnElement(DBSappObject.DebitCardDetailsDropdownList().get(3));
			clickOnElement(DBSappObject.MaritalStatusField());
			clickOnElement(DBSappObject.DebitCardDetailsDropdownList().get(0));
			clickOnElement(DBSappObject.ResidentialTypeField());
			clickOnElement(DBSappObject.DebitCardDetailsDropdownList().get(0));
			clickOnElement(DBSappObject.EducationField());
			clickOnElement(DBSappObject.DebitCardDetailsDropdownList().get(1));
			clickOnElement(DBSappObject.EconomicStatusField());
			clickOnElement(DBSappObject.DebitCardDetailsDropdownList().get(2));
			clickOnElement(DBSappObject.AnnualIncomeField());
			clickOnElement(DBSappObject.DebitCardDetailsDropdownList().get(2));
			GestureUtils.scrollUPtoObject("text", "NEXT", DBSappObject.nextButton());
			clickOnElement(DBSappObject.SendMeDBSPrmotionViaMail());
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Select Debit Card Option After Clicking on Cards Section and then 2FA Authentication Done.")
	public void SelectDebitCardOptionFromCardsSectionAndAuthenticationOfSecurePIN() throws Exception {
		try {
			GestureUtils.scrollUPtoObject("text", "Cards", DBSappObject.CardsButton());
			if (isElementVisible(DBSappObject.CardsButton()))
				clickOnElement(DBSappObject.CardsButton());
			wait.waitForElementVisibility(DBSappObject.SelectDebitCard());
			clickOnElement(DBSappObject.SelectDebitCard());
			EnterPasscodeAndDone();
			clickOnElement(DBSappObject.DebitCardOption());
			wait.waitForElementVisibility(DBSappObject.AccountToBeLinkedToTheCardField());
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Verifies the Payee Add Bill Payment and after completion payment verifies the transfering amount.")
	public void PayeeAddBillPayment() throws Exception {
		try {
			ClickOnPayAndTransferBtn();
			EnterPasscodeAndDone();
			ClickOnBillModuleAndClickOnAddBillingOrganisation();
			EnterBillingOrganisationDetails(CommonTestData.PAYEEADD_BILLPAYMENT_ACCOUNTNAME.getEnumValue(),CommonTestData.PAYEEADD_BILLPAYMENT_REFERENCENUMBER.getEnumValue());
			ClickOnNextButton();
			Asserts.assertEquals(getTexOfElement(DBSappObject.PageHeader()),
					CommonTestData.REVIEW_RECIPIENT_DETAILS.getEnumValue(),
					CommonTestData.REVIEW_RECIPIENT_DETAILS.getEnumValue() + " Text is not matching.");
			VerifyBillingOrganisationAndBillReferenceNumber(CommonTestData.PAYEEADD_BILLPAYMENT_ACCOUNTNAME.getEnumValue(),CommonTestData.PAYEEADD_BILLPAYMENT_REFERENCENUMBER.getEnumValue());
			ClickOnAddRecipientNowBtn();
			VerifyYouHaveAddedRecipientMsgAfterEnterSecurePIN();
			VerifyBillingOrganisationAndBillReferenceNumber(CommonTestData.PAYEEADD_BILLPAYMENT_ACCOUNTNAME.getEnumValue(),CommonTestData.PAYEEADD_BILLPAYMENT_REFERENCENUMBER.getEnumValue());
			ClickOnMakeAPaymentAndEnterAmountInAmountEditField();
			ClickOnNextButton();
			Asserts.assertEquals(getTexOfElement(DBSappObject.PageHeader()),
					CommonTestData.REVIEW_PAYMENT_PAGEHEADER.getEnumValue(),
					CommonTestData.REVIEW_PAYMENT_PAGEHEADER.getEnumValue() + " Text is not matching");
			ClickOnPayNowBtnAndVerifyPaymentSubmittedMsg();
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Enter Billing Organisation Details.")
	public void EnterBillingOrganisationDetails(String AccountName, String ReferenceNo) throws Exception {
		try {
			Thread.sleep(1000); 
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(DBSappObject.SelectBillingOrganisation());
			clickOnElement(DBSappObject.SearchForBillingOrganisationField());
			enterTextInTextbox(DBSappObject.SearchForBillingOrganisationField(),AccountName);
			clickOnElement(DBSappObject.SelectSearchedOption());
			clickOnElement(DBSappObject.EnterReferenceNoEditField());
			enterTextInTextbox(DBSappObject.EnterReferenceNoEditField(),ReferenceNo);
			backButton();
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Click On Bill Module & Verify Enter Recipient Page Header After Click On Add Billing Organisation.")
	public void ClickOnBillModuleAndClickOnAddBillingOrganisation() throws Exception {
		try {
			wait.waitForElementVisibility(DBSappObject.BillsButton());
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(DBSappObject.BillsButton());
			
			String xpath = "//android.widget.Button[@text='ADD RECIPIENT NOW']";
			List<RemoteWebElement> list = driver.findElements(By.xpath(xpath));
			if (list.size() > 0) {
				wait.waitForElementVisibility(DBSappObject.AddRecipientNowBtn());
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
					clickOnElement(DBSappObject.AddRecipientNowBtn());
			}else {
				wait.waitForElementVisibility(DBSappObject.AddBillingOrganisation());
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				clickOnElement(DBSappObject.AddBillingOrganisation());
			}
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Click On Make A Payment Button And Enter Amount In Amount Edit Field.")
	public void ClickOnMakeAPaymentAndEnterAmountInAmountEditField() throws Exception {
		try {
			wait.waitForElementVisibility(DBSappObject.MakeAPaymentButton()); 
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(DBSappObject.MakeAPaymentButton());
			Asserts.assertEquals(getTexOfElement(DBSappObject.MainHeaderOrSuccessMsgElement()),
					CommonTestData.PAY_TO_BILLER_PAGE_HEADER.getEnumValue(),
					CommonTestData.PAY_TO_BILLER_PAGE_HEADER.getEnumValue() + " Text is not matching");
			EnterAmount(DBSappObject.AmountEditableField(), CommonTestData.AMOUNTTO_TRANSFERFUND.getEnumValue());
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Click On Pay Now Button And Verify Payment Submitted Message.")
	public void ClickOnPayNowBtnAndVerifyPaymentSubmittedMsg() throws Exception {
		try {
			wait.waitForElementVisibility(DBSappObject.PayNowButton());
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(DBSappObject.PayNowButton());
			// verifies the payment completion with expected amount.
			if (isElementVisible(DBSappObject.ImageForPaymentSuccess())) {
				Asserts.assertEquals(getTexOfElement(DBSappObject.PageHeader()),
						CommonTestData.PAYMENT_SUBMITTED.getEnumValue(),
						CommonTestData.PAYMENT_SUBMITTED.getEnumValue() + " Text is not matching");

				Asserts.assertEquals(getTexOfElement(DBSappObject.AmountEditableField()),
						CommonTestData.AMOUNTTO_TRANSFERFUND.getEnumValue() + ".00",
						CommonTestData.AMOUNTTO_TRANSFERFUND.getEnumValue() + " Text is not matching.");
			}
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Verifies Billing Organisation And Bill Reference Number.")
	public void VerifyBillingOrganisationAndBillReferenceNumber(String AccountName , String ReferenceNum) throws Exception {
		try {
			if (isElementVisible(DBSappObject.BillingOrganisation())
					&& isElementVisible(DBSappObject.BillReferenceNo())) {
				Asserts.assertEquals(getTexOfElement(DBSappObject.DBSCASHLINE()),
						AccountName,AccountName + " Text is not matching");
				Asserts.assertEquals(getTexOfElement(DBSappObject.ReferenceNumberValue()),
						ReferenceNum, ReferenceNum + " Text is not matching");
			}
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Verifies the Open Account.")
	public void OpenAccount() throws Exception {
		try {
			ClickOnMoreButton();
			EnterPasscodeAndDone();
			// add scroll if required.
			ClickOnDepositAccountsAnd2FAAuthenticationDone();

			SelectOpenAccountOptionAndVerifyAccountBenifitsPageHeader();

			ClickOnopenAccountInStepButton();
			EnterMonthlySavingsAmtAndSelectSourceOfFundsForSavings();

			ClickOnNextButton();
			VerifyWarningMessageAndImportantNotes();
			// add scroll
			ClickOnIAcknowledgeButtonAndReviewOpenAccountApplication();
			// add scroll
			ClickOnOpenAccountNowButton();
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Select Open Account Option By Clicking And Verify Account Benifits Page Header.")
	public void SelectOpenAccountOptionAndVerifyAccountBenifitsPageHeader() throws Exception {
		try {
			clickOnElement(DBSappObject.SelectOpenAccountOption());
			Asserts.assertEquals(getTexOfElement(DBSappObject.PageHeader()),
					CommonTestData.ACCOUNT_BENIFITS.getEnumValue(),
					CommonTestData.ACCOUNT_BENIFITS.getEnumValue() + " Page Header Text is not matching");
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Enter Monthly Savings Amount And Select Source Of Funds For Savings.")
	public void EnterMonthlySavingsAmtAndSelectSourceOfFundsForSavings() throws Exception {
		try {
			clickOnElement(DBSappObject.EnterMonthlySavingsAmtEditField());
			enterTextInTextbox(DBSappObject.EnterMonthlySavingsAmtEditField(),
					CommonTestData.MONTHLY_SAVING_AMT_BALANCE.getEnumValue());
			backButton();
			clickOnElement(DBSappObject.SelectSourceOfFundsForSavingsDropdown());
			clickOnElement(DBSappObject.SelectSourceOfFundsForSavingsDropdownList().get(0));
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Click On Open Account In 2/3 Step Button.")
	public void ClickOnopenAccountInStepButton() throws Exception {
		try {
			clickOnElement(DBSappObject.StepOpenAccountButton());
			Asserts.assertEquals(getTexOfElement(DBSappObject.PageHeader()), CommonTestData.OPEN_ACCOUNT.getEnumValue(),
					CommonTestData.OPEN_ACCOUNT.getEnumValue() + " Page Header Text is not matching");
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Click On Deposit Accounts Module And 2FA Authentication Done And Verifies the Open Account Page Header.")
	public void ClickOnDepositAccountsAnd2FAAuthenticationDone() throws Exception {
		try {
			clickOnElement(DBSappObject.DepositAccountsModule());
			EnterPasscodeAndDone();
			Asserts.assertEquals(getTexOfElement(DBSappObject.PageHeader()), CommonTestData.OPEN_ACCOUNT.getEnumValue(),
					CommonTestData.OPEN_ACCOUNT.getEnumValue() + " Page Header Text is not matching");
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Verify Warning Message And Important Notes.")
	public void VerifyWarningMessageAndImportantNotes() throws Exception {
		try {
			Asserts.assertEquals(getTexOfElement(DBSappObject.PageHeader()),
					CommonTestData.IMPORTANT_NOTES.getEnumValue(),
					CommonTestData.IMPORTANT_NOTES.getEnumValue() + " Text is not matching.");

			Asserts.assertEquals(getTexOfElement(DBSappObject.WarningHeading()),
					CommonTestData.WARNING_HEADING_TEXT.getEnumValue(),
					CommonTestData.WARNING_HEADING_TEXT.getEnumValue() + " Message is not matching");
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Click On Open Account Now Button And Got 'Your account is open and ready to use!' Message.")
	public void ClickOnOpenAccountNowButton() throws Exception {
		try {
			clickOnElement(DBSappObject.OpenAccountNowButton());
			if (isElementVisible(DBSappObject.OpenAcconuntSuccessImageIcon()))
				Asserts.assertEquals(getTexOfElement(DBSappObject.AccountStatusMessage()),
						CommonTestData.YOUR_ACCOUNT_OPEN_READYTOUSE_MESSAGE.getEnumValue(),
						CommonTestData.YOUR_ACCOUNT_OPEN_READYTOUSE_MESSAGE.getEnumValue()
								+ " Message is not matching.");
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Click On IAcknowledge Button And Review Open Account Application.")
	public void ClickOnIAcknowledgeButtonAndReviewOpenAccountApplication() throws Exception {
		try {
			clickOnElement(DBSappObject.IACKNOWLEDGEButton());
			Asserts.assertEquals(getTexOfElement(DBSappObject.PageHeader()),
					CommonTestData.REVIEW_ACCOUNT_APPLICATION.getEnumValue(),
					CommonTestData.REVIEW_ACCOUNT_APPLICATION.getEnumValue() + " Text is not matched.");
			if (isElementVisible(DBSappObject.YouAreOpeningText()))
				Asserts.assertEquals(getTexOfElement(DBSappObject.POSBSayeAccount()), "POSB SAYE Account",
						" 'POSB SAYE Account' is not matched or found.");
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Verifies the Payee Add Local OtherBank and verifies 'YOU HAVE ADDED RECIPIENT MSG' .")
	public void PayeeAddLocalOtherBank() throws Exception {
		try {
			ClickOnPayAndTransferBtn();
			EnterPasscodeAndDone();
			clickOnLocalButton();
			clickOnAddLocalRecipientBtnAndVerifyLocalTransferPayNowPageHeader();
			
			 String randomString = GenerateRandomRecipientName();
			 String ExpectedRecipientName = CommonTestData.LOCAL_RECIPIENT_NAME.getEnumValue().concat(randomString);
			 System.out.println("ExpectedRecipientName is: " + ExpectedRecipientName);
			
			 int randomInt = GenerateRandomInt();
			 String s=String.valueOf(randomInt);		  
			    System.out.println("random number:"+s);
			    String ExpectedAccountNumber = CommonTestData.LOCAL_RECIPIENT_ACCOUNT_NUMBER.getEnumValue().concat(s);
				 System.out.println("ExpectedAccountNumber is: " + ExpectedAccountNumber);
			 
			EnterRecipientDetailsAfterSelectingBankAccountOption(ExpectedRecipientName,
					CommonTestData.LOCAL_RECIPIENT_BANK_NAME.getEnumValue(), ExpectedAccountNumber);
			ClickOnNextBtnAndReviewRecipientDetails();
			ClickOnAddRecipientNowBtn();
			VerifyYouHaveAddedRecipientMsgAfterEnterSecurePIN();
			verifyValidationForPayeeAdd(ExpectedRecipientName,
					CommonTestData.LOCAL_RECIPIENT_BANK_NAME.getEnumValue(), ExpectedAccountNumber);
//			clickOnElement(DBSappObject.BackIcon());
//			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
//			DeletePayee(ExpectedRecipientName);
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}
	@Step("Click On Local Button.")
	public void clickOnLocalButton() throws Exception {
		try {
			wait.waitForElementVisibility(DBSappObject.LocalButton());
			clickOnElement(DBSappObject.LocalButton());
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}
	
	
	@Step("Verifies Visibilty of 'logout' and 'make a transfer' button and Verifies the recipient name, account number, bank name.")
	public void verifyValidationForPayeeAdd(String ExpectedRecipientName , String BankName, String AccountNumber) throws Exception { 
		try {
			Asserts.assertTrue(DBSappObject.LogoutBtn().isDisplayed(), "Log Out Button not found.");
			Asserts.assertTrue(DBSappObject.makeTransferButton().isDisplayed(), "Make A Transfer Button not found.");
			String[] ExpTitleList = new String[] {  "Recipient's Name", "Country",  "Recipient's Bank", "Recipient's Account No.", "Reference No." };
			
				for(int i = 0; i< DBSappObject.PayeeTitleList().size(); i++){
				Asserts.assertEquals(getTexOfElement(DBSappObject.PayeeTitleList().get(i)),
						ExpTitleList[i], ExpTitleList[i] + "Titles is not matching after adding payee"); 
			      }
				
				Asserts.assertEquals(getTexOfElement(DBSappObject.PayeeValueList().get(0)),
						ExpectedRecipientName, ExpectedRecipientName + " is not matching after adding payee"); 
				Asserts.assertEquals(getTexOfElement(DBSappObject.PayeeValueList().get(2)),
						BankName,BankName + " is not matching after adding payee"); 
				Asserts.assertEquals(getTexOfElement(DBSappObject.PayeeValueList().get(3)),
						AccountNumber, AccountNumber + " is not matching after adding payee");
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		} 
	}
	
	@Step("Delete Payee.")
	public void DeletePayee(String ExpectedRecipientName) throws Exception { 
		try {
			ClickOnLocalAndDeletePayeeToIcon();
			ClickOnMoreOptionBtnAndDeletePayeeBtn();
			ClickOnYesBtn();
			
		String ErrorissueXpath ="//android.widget.TextView[@text='You may be facing some delays and we are trying to sort it out now. Sorry for the inconvenience. Do check back later.']";
		List<RemoteWebElement> list = driver.findElements(By.xpath(ErrorissueXpath));
		
	//	"This service isn't available right now. You can try again soon, or call 1800 111 1111 for assistance."
		
			if (list.size() > 0) {
				clickOnElement(DBSappObject.OKButton());
				wait.waitForElementVisibility(DBSappObject.PayeeAddedExpandableIconList().get(0)); 
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				clickOnElement(DBSappObject.PayeeAddedExpandableIconList().get(0));
				wait.waitForElementVisibility(DBSappObject.payee_details_title_name());
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				Asserts.assertEquals(getTexOfElement(DBSappObject.payee_details_title_name()),
						CommonTestData.RECIPIENT_DETAILS_PAGEHEADER.getEnumValue(),
						CommonTestData.RECIPIENT_DETAILS_PAGEHEADER.getEnumValue()
								+ " is not matching after adding payee");
				ClickOnMoreOptionBtnAndDeletePayeeBtn();
				ClickOnYesBtn();
			}
			ClickOnOkButtonAfterVerifyingPayeeDeletedMsg(ExpectedRecipientName);
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}
	
	@Step("Click On OK Button after verifying 'Payee Name deleted' message.")
	public void ClickOnOkButtonAfterVerifyingPayeeDeletedMsg(String ExpectedRecipientName) throws Exception {
		try {
			String payeeName = ExpectedRecipientName + " deleted";
			System.out.println(payeeName);
			String xpath = "//android.widget.TextView[@text='" + payeeName + "']";
			MobileElement payeeNames = (MobileElement) driver.findElement(By.xpath(xpath));
			if (isElementVisible(payeeNames))
				clickOnElement(DBSappObject.OKButton());
			Thread.sleep(1000);
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}
	
	@Step("Click On Yes Button after verifying 'Are you sure to delete payee' message.")
	public void ClickOnYesBtn() throws Exception {
		try {
			if (isElementVisible(DBSappObject.AreYouSureToDeleteThisPayeeMessage()))
				clickOnElement(DBSappObject.YesBtn());
			wait.waitForElementVisibility(DBSappObject.OKButton()); 
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}
	
	@Step("Click On Local And 'PayeeAdded Recipient Details Showing Icon' Button.")
	public void ClickOnLocalAndDeletePayeeToIcon() throws Exception { 
		try {
			wait.waitForElementVisibility(DBSappObject.LocalButton());
			clickOnElement(DBSappObject.LocalButton());
			wait.waitForElementVisibility(DBSappObject.PayeeAddedExpandableIconList().get(0));
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(DBSappObject.PayeeAddedExpandableIconList().get(0));
			wait.waitForElementVisibility(DBSappObject.payee_details_title_name()); 
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			Asserts.assertEquals(getTexOfElement(DBSappObject.payee_details_title_name()),
					CommonTestData.RECIPIENT_DETAILS_PAGEHEADER.getEnumValue(),
					CommonTestData.RECIPIENT_DETAILS_PAGEHEADER.getEnumValue()
							+ " is not matching after adding payee");
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}
	
	@Step("Click On 'More Options' Button And 'Delete payee' Button.")
	public void ClickOnMoreOptionBtnAndDeletePayeeBtn() throws Exception {
		try {
			clickOnElement(DBSappObject.MoreOptionBtn());
			wait.waitForElementVisibility(DBSappObject.DeletePayeeBtn()); 
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(DBSappObject.DeletePayeeBtn());
			wait.waitForElementVisibility(DBSappObject.AreYouSureToDeleteThisPayeeMessage()); 
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e)); 
		}
	}

	@Step("Click On Next Btn And Review Recipient Details.")
	public void ClickOnNextBtnAndReviewRecipientDetails() throws Exception {
		try {
			wait.waitForElementVisibility(DBSappObject.NextButtonToAddedLocalRecipient()); 
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(DBSappObject.NextButtonToAddedLocalRecipient());
			Asserts.assertEquals(getTexOfElement(DBSappObject.PageHeader()),
					CommonTestData.REVIEW_RECIPIENT_DETAILS.getEnumValue(),
					CommonTestData.REVIEW_RECIPIENT_DETAILS.getEnumValue() + " Text is not found");
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("verify balance on peek balance popup in prelogin page should be same as current account balance in dashboard with current date and time.")
	public void VerifyPeekBalance() throws Exception {
		try {
			ClickOnMoreButton();
			EnterPasscodeAndDone();
			// ToDo
			// validations pending due to some error getting on provided credentials.
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Click On More Button and then 2FA Authentication Done.")
	public void ClickOnMoreButton() throws Exception {
		try {
			if (isElementVisible(DBSappObject.MoreBtn()))
				clickOnElement(DBSappObject.MoreBtn());
               Thread.sleep(1000); 
			String xpath = "//android.widget.ImageView[@content-desc='CLOSE']";
			List<RemoteWebElement> list = driver.findElements(By.xpath(xpath));
			if (list.size() > 0)
				clickOnElement(DBSappObject.CloseButton());
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Verify 'You have added a Recipient ' after excecuting Payee Add Remittance Case.")
	public void PayeeAddRemittance() throws Exception {
		try {
			ClickOnPayAndTransferBtn();
			EnterPasscodeAndDone();
			overseasVerifyClick(CommonTestData.OVERSEAS_ICON.getEnumValue());
			ClickOnAddRecipientNowBtn();
			sendDataInSearchBoxAndSelectFromDropDown(CommonTestData.COUNTRY_AUS.getEnumValue(),
					CommonTestData.COUNTRY_AUS.getEnumValue(),DBSappObject.locationAutocompleteSearchBox());
			CurrencyTypeVerifyClick(CommonTestData.CURRENCY_AUS.getEnumValue());
			ClickOnNextButton();
			sendBankCode(CommonTestData.BANK_BCD_CODE.getEnumValue());
			ClickOnNextButton();
			ClickOnNextButton();
			sendAccountNo(CommonTestData.ACCOUNT_NO.getEnumValue());
			sendFullName(CommonTestData.FULL_NAME.getEnumValue());
			GestureUtils.scrollUPtoObject("text", "NEXT", DBSappObject.nextButton());
			sendAddress(CommonTestData.ADDRESS.getEnumValue());
			sendcity(CommonTestData.CITY.getEnumValue());
			ClickOnNextButton();
			verifyRecipientReviewDetailLabel(CommonTestData.REVIEW_RECIPIENT_LABEL.getEnumValue());
			ClickOnAddRecipientNowBtn();
			EnterPasscodeAndDone();
			Asserts.assertEquals(getTexOfElement(DBSappObject.MainHeaderOrSuccessMsgElement()),
					CommonTestData.YOU_HAVE_ADDED_RECIPIENT_MSG.getEnumValue(),
					"'You've added a recipient label' Text is not matching");
			verifyReferenceFieldAndItsValue(CommonTestData.REFERENCE_NUMBER.getEnumValue());
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Verify topup Paylah Case and logout topup Paylah.")
	public void TopupPaylah() throws Exception {
		try {
			ClickOnPayAndTransferBtn();
			EnterPasscodeAndDone();
			topUpVerifyClick(CommonTestData.TOPUP_LABEL.getEnumValue());
			payLahVerifyClick(CommonTestData.PAYLAH_LABEL.getEnumValue());
			sendCurrencyInTextField(CommonTestData.AMOUNT_PAYLAH.getEnumValue());
			ClickOnNextButton();
			verifyReviewTopUpLabel(CommonTestData.TOPUP_REVIEW_LABEL.getEnumValue());
			topUpNowVerifyClick(CommonTestData.TOPUP_NOW_BUTTOM_LABEL.getEnumValue());
			logOutTopUpVerifyClick(CommonTestData.LOGOUT_PAYLAH.getEnumValue());
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Enter the text in search and select the corresponding value in the dropdown")
	public void sendDataInCommonSearchBoxAndSelectFromDropDown(String searchBoxData, String valueSelectedFromList,
			String ExpecetedText, MobileElement PageHeader) throws Exception {
		try {
			clickOnElementOnEnable(DBSappObject.searchIcon());
			if (isElementEnable(DBSappObject.searchBox()))
				enterTextInTextbox(DBSappObject.searchBox(), searchBoxData);
			wait.waitForElementVisibility(DBSappObject.searchTextElement().get(0));
			List<MobileElement> Elementlist = DBSappObject.searchTextElement();
			List<MobileElement> ElementlistClickable = DBSappObject.searchClickableElement();
			int l = Elementlist.size();
			int index = 0;
			String elementFromList = null;
			for (int i = 0; i < l; i++) {
				elementFromList = Elementlist.get(i).getText();
				if (elementFromList.equalsIgnoreCase(valueSelectedFromList)) {
					index++;
					clickOnElement(ElementlistClickable.get(i));
					break;
				}
			}
			Asserts.assertTrue(index > 0, "No element found in the list of corresponding value");
			verifyPageHeader(ExpecetedText, PageHeader);
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Verifying page header")
	public void verifyPageHeader(String expectedText, MobileElement ele) throws Exception {
		try {
			if (ele != null)
				Asserts.assertEquals(getTexOfElement(ele), expectedText, "'Header Title' is not Matching");
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	public void VerifyButtonLabelAndClick(MobileElement Button, String expectecText) throws Exception {
		try {
			String actualText = getTexOfElement(Button);
			TakeScreenshot(Button);
			Asserts.assertEquals(actualText, expectecText, "button Not exist");
			if (actualText.equalsIgnoreCase(expectecText))
				clickOnElement(Button);
			
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}
	
	@Step("Click on 'To Other Banks Limit' Button and then Verifying page header 'Transfer to Other Banks'")
	public void ClickOnToOtherBankLimit() throws Exception {
		try {
			selectAccountTypeInLocalFundTransfer(CommonTestData.TO_OTHERBANK_LABEL.getEnumValue());
			verifyPageHeader(CommonTestData.TRANSFER_TO_OTHERBANK_LABEL.getEnumValue(), DBSappObject.PageHeaderList2().get(0));
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Click on 'Account type' From List under Local fund Limit page'")
	public void selectAccountTypeInLocalFundTransfer(String AccountToBeSelected) throws Exception {
		try {
			
			wait.waitForElementVisibility(DBSappObject.localTransferLimitAccountList().get(0));
			List<MobileElement> Elementlist = DBSappObject.localTransferLimitAccountList();
			int l = Elementlist.size();
			int index = 0;
			String accountFromList = null;
			for (int i = 0; i < l; i++) {
				accountFromList = Elementlist.get(i).getText();
				if (accountFromList.equalsIgnoreCase(AccountToBeSelected)) {
					index++;
					clickOnElement(Elementlist.get(i));
					break;
				}
			}
			
			Asserts.assertTrue(index>0, "No " +AccountToBeSelected +" found in the list of corresponding value");
			
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("click On 'set current Limit' and verify page header. ")
	public void verifyClickSetCurrentLimit() throws Exception {
		try {
			clickOnElementOnEnable(DBSappObject.currentLimitTextButton());
			//for(int i=0;i<DBSappObject.PageHeaderList2().size(); i++) {
			//	System.out.println( DBSappObject.PageHeaderList2().get(i).getText());
			//}
			
			verifyPageHeader(CommonTestData.SET_DAILY_LIMIT_TITLE.getEnumValue(), DBSappObject.PageHeaderList2().get(4));
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	public String handlingSetCurrentLimit(String AmountToBeselected) throws Exception {
		try {
			String currentText = getTexOfElement(DBSappObject.currentLimitTextButton());
			String[] arrOfStr = currentText.split(" ");
			String flag=null;
			verifyClickSetCurrentLimit();
			String selectedValue = null;
			if (arrOfStr[1].equalsIgnoreCase(CommonTestData.SELECTED_LIMIT_0.getEnumValue())) {
				selectedValue = selectAmountFromSetCurrentLimitList(AmountToBeselected);
			} else 
               {
				GestureUtils.scrollDOWNtoObject("text", CommonTestData.SELECTED_LIMIT_0.getEnumValue(),DBSappObject.Amount_0_inLocaltransferlimitList());
				flag=selectAmountFromSetCurrentLimitList(CommonTestData.SELECTED_LIMIT_0.getEnumValue());
				currentText = getTexOfElement(DBSappObject.currentLimitTextButton());
				verifyClickSetCurrentLimit();
				arrOfStr = currentText.split(" ");
				if (arrOfStr[1].equalsIgnoreCase(CommonTestData.SELECTED_LIMIT_0.getEnumValue()))
				selectedValue = selectAmountFromSetCurrentLimitList(AmountToBeselected);
			} 
			return selectedValue;
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Select amount from the List of 'set current Limit' ")
	public String selectAmountFromSetCurrentLimitList(String amount) throws Exception {
		try {
			wait.waitForElementVisibility(DBSappObject.currentLimitAmountValue().get(3));
			List<MobileElement> Elementlist = DBSappObject.currentLimitAmountValue();
			int l = Elementlist.size();
			int index = 0;
			String elementFromList = null;
			String selectedAmount=null;
			for (int i = 0; i < l; i++) {
				elementFromList = Elementlist.get(i).getText();
				if (elementFromList.equalsIgnoreCase(amount)) {
					selectedAmount=elementFromList;
					index++;
					clickOnElement(Elementlist.get(i));
					break;
				}
			}
			Asserts.assertTrue(index > 0, "No"+amount +"found in the list of corresponding value");
			return selectedAmount;
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Click On 'CHANGE DAILY LIMIT NOW' BUTTON from Review Daily limit page and Verify 'Local Transfer Limit Changed!' Title  ")
	public void verifyClickChangeDailyLimitNowButton() throws Exception {
		try {
//			for(int i=0;i<DBSappObject.PageHeaderList2().size(); i++) {
//				System.out.println( DBSappObject.PageHeaderList2().get(i).getText());
//			}
			verifyPageHeader(CommonTestData.REVIEW_DAILY_LIMIT_TITLE.getEnumValue(), DBSappObject.PageHeaderList2().get(4));
			clickOnElementOnEnable(DBSappObject.changeDailyLimitButton());
			EnterPasscodeAndDone();
			Asserts.assertEquals(getTexOfElement(DBSappObject.successTitleLabel()),
					CommonTestData.LOCAL_TRANSFER_CAHNGE_TITLE.getEnumValue(), "'Header Title' is not Matching");
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Verifying and click 'BACK TO MORE' BUTTON ")
	public void verifyClickBackToMoreButton() throws Exception {
		try {
			clickOnElementOnEnable(DBSappObject.backToMoreButton());
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Verify Amount display After Limit get Changed")
	public void verifyDisplayAmountLocalTransferLimitChange(String expectedText) throws Exception {
		try {
			String currentText = getTexOfElement(DBSappObject.currentLimitTextButton());
			String[] arrOfStr = currentText.split(" ");
			String acutalText = arrOfStr[1];
			Asserts.assertEquals(acutalText, expectedText, "'Amount display' After Limit get Changed is Wrong");
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Change local fund transfer limit verification")
	public void ChangeLocalFundsTransferLimit() throws Exception {
		try {
			ClickOnMoreButton();
			EnterPasscodeAndDone();
			sendDataInCommonSearchBoxAndSelectFromDropDown(CommonTestData.LOCAL_TRANSFER_LIMIT_LABEL.getEnumValue(),
					CommonTestData.LOCAL_TRANSFER_LIMIT_LABEL.getEnumValue(),
					CommonTestData.LOCAL_TRANSFER_LIMIT_LABEL.getEnumValue(), DBSappObject.PageHeader2());
			ClickOnToOtherBankLimit();
			String amountSlected = handlingSetCurrentLimit(CommonTestData.SELECTED_LIMIT_50000.getEnumValue());
			ClickOnNextButton();
			verifyClickChangeDailyLimitNowButton();
			verifyClickBackToMoreButton();
			sendDataInCommonSearchBoxAndSelectFromDropDown(CommonTestData.LOCAL_TRANSFER_LIMIT_LABEL.getEnumValue(),
					CommonTestData.LOCAL_TRANSFER_LIMIT_LABEL.getEnumValue(),
					CommonTestData.LOCAL_TRANSFER_LIMIT_LABEL.getEnumValue(), DBSappObject.PageHeader2()); 
			ClickOnToOtherBankLimit();
			verifyDisplayAmountLocalTransferLimitChange(amountSlected);
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}
	@Step("Click on 'All Tab' section")
	public void clickAndVerifyOnAllTab() throws Exception {
		try {
			VerifyButtonLabelAndClick(DBSappObject.AllTab(),CommonTestData.ALL_SECTION.getEnumValue());	
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}

	}
	@Step("Click on 'DBS CURRENT ACCOUNT' after selecting 'Local Recipients' and verify 'Transfer to DBS/POSB' Title")
	public void selectLocalRecientAndClickingOnDbsCurrentAccount() throws Exception {
		try {
			VerifyButtonLabelAndClick(DBSappObject.AllTabOptionsList().get(2),CommonTestData.LOCAL_RECIPIENT_FROMLIST.getEnumValue());
			GestureUtils.scrollUPtoObject("text", CommonTestData.DBS_CURRENT_ACCOUNT_TEXT.getEnumValue(), DBSappObject.dbsCurrentAccountOption() );
			VerifyButtonLabelAndClick(DBSappObject.dbsCurrentAccountOption(),CommonTestData.DBS_CURRENT_ACCOUNT_TEXT.getEnumValue());
			verifyPageHeader(CommonTestData.TRANSFER_DBS_POSB.getEnumValue(), DBSappObject.PageHeader());
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}

	}
	@Step("Click on 'Select Fund Source' and Select DBS Multiplier Account")
	public void selectFundSourceAndSelectDBSMultiplierAccount() throws Exception {
		try {
			String xpath = "//android.widget.TextView[@text='Select Fund Source']";
			List<RemoteWebElement> list = driver.findElements(By.xpath(xpath));
			if (list.size() > 0) {
			VerifyButtonLabelAndClick(DBSappObject.selectFundSourceTextButton(),CommonTestData.SELECT_SOURCE_FUND.getEnumValue());
			VerifyButtonLabelAndClick(DBSappObject.dbsMultiplierAccountTextButton(),CommonTestData.DBS_MULTIPLIER_ACCOUNT_TEXT.getEnumValue());
			AndroidAlert.AlertHandlingWithButtonMessage(DBSappObject.OKButton(),CommonTestData.PRIMARY_SOURCE_ALERT_TITLE.getEnumValue(),
					DBSappObject.primarysourceAlertTitle());
			verifyPageHeader(CommonTestData.TRANSFER_DBS_POSB.getEnumValue(), DBSappObject.PageHeader());
			}
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}

	}
	@Step("Verify 'SGD Currency Field' and Enter Amount '11'")
	public void enterAmountAndVerifySgdCurrency(String Amount) throws Exception {
		try {
			Asserts.assertEquals(getTexOfElement(DBSappObject.sgdFieldText()), CommonTestData.SGD_CURRENCY_LABEL.getEnumValue(), "'Currency' is not Matching");
			enterTextInTextbox(DBSappObject.amountTransferTextBox(), Amount);
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}

	}
	@Step(" Verifying page header 'Review Transfer' And Click on 'TRANSFER NOW' Button")
	public void verifyReviewTransferAndClickTransferNowButton() throws Exception {
		try {
			verifyPageHeader( CommonTestData.REVIEW_TRANSFER_LABEL.getEnumValue(), DBSappObject.PageHeader());
			VerifyButtonLabelAndClick(DBSappObject.TransferNowBtn(),CommonTestData.TRANSFER_NOW_BUTTON.getEnumValue());
			
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}

	}
	@Step(" Verifying page header 'Transferred' And Click on 'Logout' Button")
	public void verifyTransferredTitleAndClickOnLogout() throws Exception {
		try {
			verifyPageHeader( CommonTestData.TRANSFER_TITLE.getEnumValue(), DBSappObject.PageHeader());
			logOutTopUpVerifyClick("Log Out");
			VerifyButtonLabelAndClick(DBSappObject.TransferNowBtn(),CommonTestData.TRANSFER_NOW_BUTTON.getEnumValue());
			Asserts.assertEquals(getTexOfElement(DBSappObject.postLogoutAlertMessage()), CommonTestData.RATE_MESSAGE.getEnumValue(),
					"'Tap on the stars to rate' Text is not found");
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}

	}
	@Step("Verifies FundTransfer Other DBS/POSB")
	public void FundTransferOtherBank() throws Exception {
		try {
			ClickOnPayAndTransferBtn();
			EnterPasscodeAndDone();
			clickAndVerifyOnAllTab();
			selectLocalRecientAndClickingOnDbsCurrentAccount();
			selectFundSourceAndSelectDBSMultiplierAccount();
            enterAmountAndVerifySgdCurrency("11");
            ClickOnNextButton();
            verifyReviewTransferAndClickTransferNowButton();
            verifyTransferredTitleAndClickOnLogout();
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e)); 
		}
	}

	@Step("Verify Fund Transfer For Own Account.")
	public void VerifyFundTransfer_OwnAccount() throws Exception {
		try {
			ClickOnPayAndTransferBtn();
			EnterPasscodeAndDone();
			SelectAllTAB();
			SelectOWNAccountAndAnyAccountOption(CommonTestData.FUNDTRANSFER_TO_OWN_ACCOUNT_NUMBER.getEnumValue());
			String ExpectedFromAccountName = CommonTestData.FUNDTRANSFER_FROM_OWN_ACCOUNT_NAME.getEnumValue();
			SelectFundSourceAccount(ExpectedFromAccountName);
			EnterAmount(DBSappObject.AmountEditableField(), CommonTestData.AMOUNTTO_TRANSFERFUND.getEnumValue());
			ClickOnNextButton();
			Asserts.assertEquals(getTexOfElement(DBSappObject.PageHeader()),
					CommonTestData.REVIEW_TRANSFER.getEnumValue(),
					CommonTestData.REVIEW_TRANSFER.getEnumValue() + " Text is not matching");
			
			ClickOnTransferNowBtnAndVerifiesTransferSubmittedMsg(CommonTestData.TRANSFERRED.getEnumValue(),
					DBSappObject.ImageForPaymentSuccess(), DBSappObject.PageHeader());
			 String ExpectedToAccountNumber = CommonTestData.FUNDTRANSFER_TO_OWN_ACCOUNT_NUMBER.getEnumValue() + "	SGD";
			 String ExpectedToAccountName = CommonTestData.FUNDTRANSFER_TO_OWN_ACCOUNT_NAME.getEnumValue();
			 String ExpectedFromAccountNumber = CommonTestData.FUNDTRANSFER_FROM_OWN_ACCOUNT_NUMBER.getEnumValue() + "	SGD";
			 VerifyAccountDetailsAfterFundTransferToOwnAccount( ExpectedToAccountNumber,  ExpectedToAccountName,  ExpectedFromAccountNumber, ExpectedFromAccountName);	
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Verify Account Details After Fund Transfer To Own Account.")
	public void VerifyAccountDetailsAfterFundTransferToOwnAccount(String ExpectedToAccountNumber, String ExpectedToAccountName, String ExpectedFromAccountNumber,String ExpectedFromAccountName) throws Exception{
		try { 
			Asserts.assertTrue(DBSappObject.LOGOUTButton().isDisplayed(), "Log Out Button not matching.");
			Asserts.assertTrue(DBSappObject.BACKToHOME().isDisplayed(), "BACK To HOME Button not found.");
			Asserts.assertTrue(DBSappObject.MakeAnotherTransferBtn().isDisplayed(), "MAKE ANOTHER TRANSFER Button not found.");

			
			String[] ExpTitleList = new String[] {  "From", "To",  "When" ,"Source Account Balance","Destination Account Balance","Reference No." };
			
				for(int i = 0; i< DBSappObject.FundTransferDetailslabel1List().size(); i++){
				Asserts.assertEquals(getTexOfElement(DBSappObject.FundTransferDetailslabel1List().get(i)),
						ExpTitleList[i], ExpTitleList[i] + "Titles is not matching after adding payee"); 
			      }
				
				Asserts.assertEquals(getTexOfElement(DBSappObject.FundTransferDetailslabel2List().get(0)),
						ExpectedFromAccountName, ExpectedFromAccountName + " is not matching after Fund Transfer to Own Account"); 

				Asserts.assertEquals(getTexOfElement(DBSappObject.FundTransferDetailslabel2List().get(1)),
						ExpectedToAccountName, ExpectedToAccountName + " is not matching after Fund Transfer to Own Account"); 
				
				Asserts.assertEquals(getTexOfElement(DBSappObject.FundTransferDetailslabel3List().get(0)), 
						ExpectedFromAccountNumber, ExpectedFromAccountNumber + " is not matching after Fund Transfer to Own Account."); 
			
				Asserts.assertEquals(getTexOfElement(DBSappObject.FundTransferDetailslabel3List().get(1)), 
						ExpectedToAccountNumber, ExpectedToAccountNumber + " is not matching after fund transfer to own account");
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		} 
	}
	
	@Step("Select All TAB.")
	public void SelectAllTAB() throws Exception {
		try {
			TakeScreenshot(DBSappObject.AllTab());
			clickOnElement(DBSappObject.AllTab());
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Select 'Your DBS/POSB Accounts' and then verify 'Transfer to Your Account' Page header after selecting any own account option.")
	public void SelectOWNAccountAndAnyAccountOption(String ToOwnAccount) throws Exception {
		try {
			clickOnElement(DBSappObject.SelectOwnAccount());
			String xpath = "//android.widget.TextView[@text='"+ToOwnAccount+"']";
			MobileElement ToAccountNo = (MobileElement) driver.findElement(By.xpath(xpath));
			clickOnElement(ToAccountNo); 
			TakeScreenshot(DBSappObject.PageHeader());
			verifyPageHeader(CommonTestData.TRANSFER_TO_YOUR_ACCOUNT.getEnumValue(), DBSappObject.PageHeader());
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Select Any Fund Source Account After clicking on add sign for select fund source.")
	public void SelectFundSourceAccount(String fromOwnAccount) throws Exception {
		try {
			String xpath = "//android.widget.TextView[@text='Select Fund Source']";
			List<RemoteWebElement> list = driver.findElements(By.xpath(xpath));
			if (list.size() > 0) {
				GestureUtils.scrollDOWNtoObject("text", "Select Fund Source", DBSappObject.SelectFundSourcePage());
				TakeScreenshot(DBSappObject.SelectFundSourcePage());
				clickOnElement(DBSappObject.SelectFundSourcePage());
				TakeScreenshot(DBSappObject.SelectLocalRecipientToAccount().get(0)); 
				
				for (int i = 0; i < DBSappObject.SelectLocalRecipientToAccount().size(); i++) {
					String actualfromOwnAccount = DBSappObject.SelectLocalRecipientToAccount().get(i).getText(); 
					if (actualfromOwnAccount.contains(fromOwnAccount)) {
						clickOnElement(DBSappObject.SelectLocalRecipientToAccount().get(i));
				        break;
					}
				}
				
				String xpath1 = "//android.widget.TextView[@text='Primary source of fund']";
				List<RemoteWebElement>list1 = driver.findElements(By.xpath(xpath1));
				if(list1.size()>0) {
					TakeScreenshot(DBSappObject.PrimarySourceOfFund()); 
					if (isElementVisible(DBSappObject.PrimarySourceOfFund()))
						clickOnElement(DBSappObject.OKButton());
				}
			}
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Enter Amount In Editable field to transfer fund.")
	public void EnterAmount(MobileElement editField, String textToEnter) throws Exception {
		try {
			TakeScreenshot(editField);
			clickOnElement(editField);
			enterTextInTextbox(editField, textToEnter);
			backButton();
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Verify Fund Transfer For Other Bank Non Fast transfer when future date selected.")
	public void FundsTransfer_OtherBank_NonFASTFuture(String appname) throws Exception {
		try {
			ClickOnPayAndTransferBtn();
			EnterPasscodeAndDone();
			SelectAllTAB();
			String ExpectedToBankNameWithAccountNo = CommonTestData.FUNDTRANSFER_NONFAST_TO_ACCOUNTNUMBER_WITHBANK.getEnumValue();
			clickingOnAccountTypeInLocalRecipient(ExpectedToBankNameWithAccountNo);
			
			DisableToTransferViaFastToggle();
			
			TakeScreenshot(DBSappObject.EditFields().get(0));
			clickOnElement(DBSappObject.EditFields().get(0));
			enterTextInTextbox(DBSappObject.EditFields().get(0), "Non Fast");
		
			String ExpectedFromBankName = CommonTestData.FUNDTRANSFER_NONFAST_FROM_ACCOUNT_NAME.getEnumValue();
			SelectFundSourceAccount(ExpectedFromBankName);
			
			SelectFutureDateThroughCalendar();
			EnterAmount(DBSappObject.AmountEditableField(), CommonTestData.AMOUNTTO_TRANSFERFUND.getEnumValue());
			ClickOnNextButton();
			VerifyReviewTransferPageAndNonFastServiceInReview();
			ClickOnTransferNowBtnAndVerifiesTransferSubmittedMsg(CommonTestData.TRANSFER_SUBMITTED_MSG.getEnumValue(),
					DBSappObject.ImageForPaymentSuccess(), DBSappObject.TransferSuccessMsgElement());
			
			String ExpectedFromAccountNumber = CommonTestData.FUNDTRANSFER_NONFAST_FROM_ACCOUNT_NUMBER.getEnumValue()+ "	SGD";
			String ExpectedToRecipientName = CommonTestData.FUNDTRANSFER_NONFAST_TO_RECIPIENT_NAME.getEnumValue();
			VerifyVisibiltyOfSomeElements(ExpectedFromBankName, ExpectedToBankNameWithAccountNo ,ExpectedFromAccountNumber,ExpectedToRecipientName);
			
			
			ClickOnExpandbtnAndBackBtn();
			ClickOnMoreButton();
			EnterPasscodeAndDone();
			ClickOnTransactionHistory(appname);
			SelectTimeAndAccountTypeForStatement(appname,ExpectedFromBankName);
			ClickOnShowButtonAndVerifyHeader(ExpectedFromBankName);
			ValadateTransactionHistoryListInThreeMonth();
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Verify Fund Transfer For Other Bank Non Fast transfer.")
	public void FundsTransfer_OtherBank_NonFAST(String appname) throws Exception {
		try {
			ClickOnPayAndTransferBtn();
			EnterPasscodeAndDone();
			SelectAllTAB();
			String ExpectedToBankNameWithAccountNo = CommonTestData.FUNDTRANSFER_NONFAST_TO_ACCOUNTNUMBER_WITHBANK.getEnumValue();
			clickingOnAccountTypeInLocalRecipient(ExpectedToBankNameWithAccountNo);
			DisableToTransferViaFastToggle();
			
			TakeScreenshot(DBSappObject.EditFields().get(0));
			clickOnElement(DBSappObject.EditFields().get(0));
			enterTextInTextbox(DBSappObject.EditFields().get(0), "Non Fast");
		
			String ExpectedFromBankName = CommonTestData.FUNDTRANSFER_NONFAST_FROM_ACCOUNT_NAME.getEnumValue();
			SelectFundSourceAccount(ExpectedFromBankName);
			
			String ExpectedSelectedDate = getTexOfElement(DBSappObject.TransferDateTextElement());
			Asserts.assertEquals("Immediate", ExpectedSelectedDate, "Selected Date is not Matching");
			EnterAmount(DBSappObject.AmountEditableField(), CommonTestData.AMOUNTTO_TRANSFERFUND.getEnumValue());
			ClickOnNextButton();
			VerifyReviewTransferPageAndNonFastServiceInReview();
			ClickOnTransferNowBtnAndVerifiesTransferSubmittedMsg(CommonTestData.TRANSFER_SUBMITTED_MSG.getEnumValue(),
					DBSappObject.ImageForPaymentSuccess(), DBSappObject.TransferSuccessMsgElement());
		
			String ExpectedFromAccountNumber = CommonTestData.FUNDTRANSFER_NONFAST_FROM_ACCOUNT_NUMBER.getEnumValue()+ "	SGD";
			String ExpectedToRecipientName = CommonTestData.FUNDTRANSFER_NONFAST_TO_RECIPIENT_NAME.getEnumValue();
			VerifyVisibiltyOfSomeElements(ExpectedFromBankName, ExpectedToBankNameWithAccountNo ,ExpectedFromAccountNumber,ExpectedToRecipientName);
			
			ClickOnExpandbtnAndBackBtn();
			ClickOnMoreButton();
			EnterPasscodeAndDone();
			ClickOnTransactionHistory(appname);
			SelectTimeAndAccountTypeForStatement(appname,ExpectedFromBankName);
			ClickOnShowButtonAndVerifyHeader(ExpectedFromBankName);
			ValadateTransactionHistoryListInThreeMonth();
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}
	
	@Step("Click On 'Expandable btn' And scroll Down to 'Reference No.' text then Click On Back Button.")
	public void ClickOnExpandbtnAndBackBtn() throws Exception {
		try {
			clickOnElement(DBSappObject.FooterExpandableBtn());
			GestureUtils.scrollUPtoObject("text", "Reference No.", DBSappObject.ReferenceNumberText());
			clickOnElement(DBSappObject.BackIcon());
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}
	
	@Step("Verifies the 'Log out', 'Make Another Transfer' Button and 'Transferred Amount Value' after transferring the fund.")
	public void VerifyVisibiltyOfSomeElements(String ExpectedFromBankName , String ExpectedToBankName, String ExpectedFromAccountNumber, String ExpectedToRecipientName) throws Exception {
		try {
			Asserts.assertTrue(DBSappObject.LOGOUTButton().isDisplayed(), "Log Out Button not found.");
			GestureUtils.scrollUPtoObject("text", "MAKE ANOTHER TRANSFER", DBSappObject.MakeAnotherTransferBtn()); 
			Asserts.assertTrue(DBSappObject.MakeAnotherTransferBtn().isDisplayed(), "Make Another Transfer Button not found.");
			Asserts.assertEquals(getTexOfElement(DBSappObject.SendingAmountElement()),
					CommonTestData.AMOUNTTO_TRANSFERFUND.getEnumValue() + ".00", "Amount is not matching");
			
			Asserts.assertEquals(getTexOfElement(DBSappObject.AccountNameList().get(0)),
					ExpectedFromBankName, ExpectedFromBankName + " is not matching");
			
			Asserts.assertEquals(getTexOfElement(DBSappObject.AccountNameList().get(1)),
					ExpectedToRecipientName, ExpectedToRecipientName + " is not matching");
			
			Asserts.assertEquals(getTexOfElement(DBSappObject.AccountNumberList().get(0)),
					ExpectedFromAccountNumber, ExpectedFromAccountNumber + " is not matching");
			
			Asserts.assertEquals(getTexOfElement(DBSappObject.AccountNumberList().get(1)).trim(),
					ExpectedToBankName, ExpectedToBankName + " is not matching");
			
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e)); 
		}
	}
	
	@Step("Verify 'Review Transfer' Page And 'Non-Fast' Service In Review")
	public void VerifyReviewTransferPageAndNonFastServiceInReview() throws Exception {
		try {
			Asserts.assertEquals(getTexOfElement(DBSappObject.PageHeaderList().get(0)),
					CommonTestData.REVIEW_TRANSFER.getEnumValue(),
					CommonTestData.REVIEW_TRANSFER.getEnumValue() + " Text is not matching");

			GestureUtils.scrollUPtoObject("text", "TRANSFER NOW", DBSappObject.TransferNowBtn());
			wait.waitForElementVisibility(DBSappObject.NonFastTransactionService());
			Asserts.assertTrue(DBSappObject.NonFastTransactionService().isDisplayed(), 
					"Non-Fast Service not available in review.");
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));  
		}
	}
	
	@Step("Verify 'Transfer To Other Bank' Page Header and Click on 'TransferViaFast Toggle' to disable fast service.")
	public void DisableToTransferViaFastToggle() throws Exception {
		try {
			TakeScreenshot(DBSappObject.PageHeaderList().get(0));
			verifyPageHeader(CommonTestData.TRANSFER_TO_OTHERBANK_LABEL_LABEL.getEnumValue(),
					DBSappObject.PageHeaderList().get(0));
			GestureUtils.scrollUPtoObject(null, null, DBSappObject.TransferViaFastTransferToggle());
			
			TakeScreenshot(DBSappObject.TransferViaFastTransferToggle());
			clickOnElement(DBSappObject.TransferViaFastTransferToggle());
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e)); 
		}
	}

	@Step("Click on 'Transaction History' Button and then Verifying page header 'Transaction History'")
	public void ClickOnTransactionHistory(String appName) throws Exception {
		try {
			VerifyButtonLabelAndClick(DBSappObject.transactionHistoryLabelAndButton(),
					CommonTestData.TRANSCETION_HISTORY_LABEL.getEnumValue());
			EnterPasscodeAndDone();
			if (appName.contains("DBS")) {
				verifyPageHeader(CommonTestData.TRANSCETION_HISTORY_LABEL.getEnumValue(),
						DBSappObject.TransactionHistoryHeaderForDBS());
				TakeScreenshot(DBSappObject.TransactionHistoryHeaderForDBS());
			} else if (appName.contains("POSB")) {
				verifyPageHeader(CommonTestData.TRANSCETION_HISTORY_LABEL.getEnumValue(),
						DBSappObject.TransactionHistoryHeaderForPOSB());
				TakeScreenshot(DBSappObject.TransactionHistoryHeaderForPOSB());
			} else if (appName.contains("iWEALTH")) {
				verifyPageHeader(CommonTestData.TRANSCETION_HISTORY_LABEL.getEnumValue(),
						DBSappObject.TransactionHistoryHeaderForiWEALTH());
				TakeScreenshot(DBSappObject.TransactionHistoryHeaderForiWEALTH());
			}
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}

	}


	public void TakeScreenshot(MobileElement Element) throws Exception {
		try {
			wait.waitForElementVisibility(Element); 
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e)); 
		}
	}

	@Step("Select'3 Months Transaction History' And 'From Account' from 'Deposit Account' section")
	public void SelectTimeAndAccountTypeForStatement(String appName, String AccountName) throws Exception {
		try {
			clickOnElement(DBSappObject.threeMonthLabel()); 
			if(appName.contains("DBS"))
				clickOnElement(DBSappObject.DepositAccountButtonDBS());
			
			else if(appName.contains("POSB"))
				clickOnElement(DBSappObject.DepositAccountButtonPOSB());
			
			else if(appName.contains("iWEALTH"))
				clickOnElement(DBSappObject.DepositAccountButtoniWEALTH());
			
			selectAccountTypeInTransactionHistory(AccountName,appName);
			
			if(appName.contains("DBS")) {
				verifyPageHeader(CommonTestData.TRANSCETION_HISTORY_LABEL.getEnumValue(),DBSappObject.TransactionHistoryHeaderForDBS());
				TakeScreenshot(DBSappObject.TransactionHistoryHeaderForDBS());
			}else if(appName.contains("POSB")) {
				verifyPageHeader(CommonTestData.TRANSCETION_HISTORY_LABEL.getEnumValue(),DBSappObject.TransactionHistoryHeaderForPOSB());
				TakeScreenshot(DBSappObject.TransactionHistoryHeaderForPOSB());
			}else if(appName.contains("iWEALTH")) {
				verifyPageHeader(CommonTestData.TRANSCETION_HISTORY_LABEL.getEnumValue(),DBSappObject.TransactionHistoryHeaderForiWEALTH());
			TakeScreenshot(DBSappObject.TransactionHistoryHeaderForiWEALTH());}
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}
		@Step("Click on 'Account type' From List under Local fund Limit page'")
		public void selectAccountTypeInTransactionHistory(String AccountToBeSelected, String appName) throws Exception {
			try {
				List<MobileElement> Elementlist = null;
				if(appName.contains("DBS")) {
					wait.waitForElementVisibility(DBSappObject.AccountNameListInTransactionHistoryForDBS().get(1));
					Elementlist = DBSappObject.AccountNameListInTransactionHistoryForDBS();
				}
				else if(appName.contains("POSB")) {
					wait.waitForElementVisibility(DBSappObject.AccountNameListInTransactionHistoryForPOSB().get(1));
					Elementlist = DBSappObject.AccountNameListInTransactionHistoryForPOSB();
				}
				else if(appName.contains("iWEALTH")) {
					wait.waitForElementVisibility(DBSappObject.AccountNameListInTransactionHistoryForiWEALTH().get(1));
					Elementlist = DBSappObject.AccountNameListInTransactionHistoryForiWEALTH();
				}
				int l = Elementlist.size();
				int index = 0;
				String accountFromList = null;
				for (int i = 1; i <= l; i++) {
					accountFromList = Elementlist.get(i).getText();
					if (accountFromList.contains(AccountToBeSelected)) {
						index++;
						clickOnElement(Elementlist.get(i));
						break;
					}
				}
				
				Asserts.assertTrue(index>0, "No " +AccountToBeSelected +" found in the list of corresponding value");
				
			} catch (Exception e) {
				throw new Exception(getExceptionMessage(e));
			}
		}



	@Step("Back to Home page from Transaction History statement")
	public void BackToHomeFromTransactionHistory(String appName) throws Exception {
		try {
			clickOnElementOnEnable(DBSappObject.backButton());
			if(appName.contains("DBS"))
				verifyPageHeader(CommonTestData.TRANSCETION_HISTORY_LABEL.getEnumValue(), DBSappObject.TransactionHistoryHeaderForDBS());
			else if(appName.contains("POSB"))
				verifyPageHeader(CommonTestData.TRANSCETION_HISTORY_LABEL.getEnumValue(), DBSappObject.TransactionHistoryHeaderForPOSB());
			else if(appName.contains("POSB"))
				verifyPageHeader(CommonTestData.TRANSCETION_HISTORY_LABEL.getEnumValue(), DBSappObject.TransactionHistoryHeaderForiWEALTH());
			clickOnElementOnEnable(DBSappObject.backButton());
			clickOnElementOnEnable(DBSappObject.homeButton());
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Click on 'Show' Button and then Verifying From Account.")
	public void ClickOnShowButtonAndVerifyHeader(String ExpectedAccountName) throws Exception {
		try {
			VerifyButtonLabelAndClick(DBSappObject.showButton(), CommonTestData.SHOW_BUTTON.getEnumValue());
			EnterPasscodeAndDone(); 
			Asserts.assertEquals(getTexOfElement(DBSappObject.AccountNameToCheckTransactionHistory()),
					ExpectedAccountName, ExpectedAccountName + " is not matching.");
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Validating From Account Transaction History List.")
	public void ValadateTransactionHistoryListInThreeMonth() throws Exception {
		try {
			List<MobileElement> Elementlist = DBSappObject.dropDowmList();
			int l = Elementlist.size();
			Asserts.assertTrue(l > 0, "No Transaction History is Display");
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}
	
	public void transactionHistoryVerify(String appName) throws Exception {
		try {
			 ClickOnMoreButton();
			 EnterPasscodeAndDone();
			 ClickOnTransactionHistory(appName);
			 SelectTimeAndAccountTypeForStatement(appName, CommonTestData.ACCOUNT_NAME.getEnumValue());
			 ClickOnShowButtonAndVerifyHeader(CommonTestData.STATEMENT_TITLE.getEnumValue());
			 ValadateTransactionHistoryListInThreeMonth();
			 BackToHomeFromTransactionHistory(appName);
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e)); 
		}
	}
	

	@Step("Select Future Date Through Calendar and verifies the selected 'future date'.")
	public void SelectFutureDateThroughCalendar() throws Exception {
		try {
			clickOnElement(DBSappObject.TransferDateTextElement());
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
			String CalendardateXpath = "//android.view.View[@text='" + sDate[0] + "']";

			MobileElement Calendardate = (MobileElement) driver.findElement(By.xpath(CalendardateXpath));
			if (Calendardate.isEnabled())
				clickOnElement(Calendardate);

			
			String ActualSelectedDate = getTexOfElement(DBSappObject.TransferDateTextElement());
			System.out.println(ActualSelectedDate);
			Asserts.assertEquals(ActualSelectedDate, ExpectedDate, "Selected Date is not Matching");
		
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}
	@Step("Enter amount , duration and purposed for creditLimit Increase")
	public void setAmountDurationPurposeForLimitIncrease(String Amount, String purpos,String Date, String month, String Year) throws Exception {
		try {
			if (isElementEnable(DBSappObject.amountCreditLimt()))
				enterTextInTextbox(DBSappObject.amountCreditLimt(), Amount);
			
			clickOnElement(DBSappObject.purposeOption());
			
			wait.waitForElementVisibility(DBSappObject.PurposeList().get(1));
			List<MobileElement> Elementlist = DBSappObject.PurposeList();
			int l = Elementlist.size();
			int index = 0;
			String purposedFromList = null;
			for (int i = 1; i <= l; i++) {
				purposedFromList = Elementlist.get(i).getText();
				if (purposedFromList.equalsIgnoreCase(purpos)) {
					index++;
					clickOnElement(Elementlist.get(i));
					break;
				}
			}
			String cureentDate=getTexOfElement(DBSappObject.durationOption());
			clickOnElement(DBSappObject.durationOption());
			String[] arrOfStr = cureentDate.split(" ");
			String year=arrOfStr[2];
			String Month=arrOfStr[1];
			String date=arrOfStr[0];
			Asserts.assertEquals(getTexOfElement(DBSappObject.yearHeader()),
					year, "year is not matching.");
			
			List<MobileElement> monthlist = DBSappObject.monthList();
			int m =  monthlist.size();
			int ind = 1;
			
			for (int i = 1; i <= m; i++) {
				String monthFromList = monthlist.get(i).getText();
				if (monthFromList.equalsIgnoreCase(month)) {
					ind++;
					clickOnElement(Elementlist.get(i));
					break;
				}
			}
			String xapth= "//android.widget.ListView[contains(@resource-id,'id/calendar_view')]/android.widget.LinearLayout["+ind+"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout";
			List<RemoteWebElement> list = driver.findElements(By.xpath(xapth));
			for (int i = 0; i <= 42; i++) {
				String dateFromList = list.get(i).getText();
				if (dateFromList.equalsIgnoreCase(Date) && Integer.parseInt(Date)>Integer.parseInt(date)) {
					clickOnElement(Elementlist.get(i));
					break;
				}
			}
			
			clickOnElement(DBSappObject.OKButton());
			
			
			
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}
	
	
	@Step("Click on Account after selecting 'Local Recipients' and verify pageHeader")
	public void clickingOnAccountTypeInLocalRecipient(String valueSelectedFromList) throws Exception {
		try {
			int o=0;
			for (int i = 0; i < DBSappObject.AllTabOptionsList().size(); i++) {
				String tabText = DBSappObject.AllTabOptionsList().get(i).getText(); 
				o++;
				if (tabText.contains(CommonTestData.LOCAL_RECIPIENT_FROMLIST.getEnumValue())) {
					clickOnElement(DBSappObject.AllTabOptionsList().get(i));
					break;
				}
			}
			
			GestureUtils.DragAndDropElementToElement( DBSappObject.AllTabOptionsList().get(o), DBSappObject.AllTab());
			TakeScreenshot(DBSappObject.localRecipientListText().get(0));
			List<MobileElement> Elementlist = DBSappObject.localRecipientListText();
			List<MobileElement> ElementlistClickable = DBSappObject.localRecipientListClickable();
			int l = Elementlist.size();
			int index = 0;
			String LocalRecipientList = null;
			for (int i = 0; i < l; i++) {
				LocalRecipientList = Elementlist.get(i).getText();
				if (LocalRecipientList.equalsIgnoreCase(valueSelectedFromList)) {
					index++;
					clickOnElement(ElementlistClickable.get(i));
					break;
				}
			}
			Asserts.assertTrue(index>0, "No element found in the list of corresponding value");
						String ErrorMsg = getTexOfElement(DBSappObject.ErrorMessgeElement());
						
			if(CommonTestData.ERROR_MSG.getEnumValue().equals(ErrorMsg)) 
			clickOnElement(DBSappObject.OKButton());
			
			String xpath1 = "//android.widget.TextView[@text='Primary source of fund']";
			List<RemoteWebElement>list1 = driver.findElements(By.xpath(xpath1));
			if(list1.size()>0) {
				TakeScreenshot(DBSappObject.PrimarySourceOfFund()); 
				if (isElementVisible(DBSappObject.PrimarySourceOfFund()))
					clickOnElement(DBSappObject.OKButton());
			}
			
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}

	}
	
	public void UpdatePersonalDetails(String appName) {
		
	}
	
}
