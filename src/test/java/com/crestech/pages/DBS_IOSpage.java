package com.crestech.pages;

import java.util.List;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebElement;
import com.crestech.appium.utils.CommonAppiumTest;
import com.crestech.common.utilities.AndroidAlert;
import com.crestech.common.utilities.Asserts;
import com.crestech.common.utilities.CommonTestData;
import com.crestech.common.utilities.GestureUtils;
import com.crestech.pageobjects.DBS_IOSObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;

public class DBS_IOSpage extends CommonAppiumTest {

	static Logger log = Logger.getLogger(DBSAndroidPage.class.getName());
	public DBS_IOSObject IOShomePgaeObject = new DBS_IOSObject(driver);
	CommonAppiumTest commonAppTest = null;
	AndroidAlert androidAlert = null;
	GestureUtils gestUtils = null;

	public DBS_IOSpage(AppiumDriver<RemoteWebElement> driver) {
		super(driver);
		gestUtils = new GestureUtils(driver);
		commonAppTest = new CommonAppiumTest(driver);
		androidAlert = new  AndroidAlert(driver);
		gestUtils = new GestureUtils(driver);
		//PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), IOShomePgaeObject);

		androidAlert = new AndroidAlert(driver);
		// PageFactory.initElements(new AppiumFieldDecorator(driver,
		// Duration.ofSeconds(5)), IOShomePgaeObject);
	}

	@Step("Enter data in User EditBox")
	public void sendDataInUserId(String text) throws Exception {
		try {
			Asserts.assertTrue(isElementEnable(IOShomePgaeObject.userIdEditBox()), "EditField is not enable");
			if (isElementEnable(IOShomePgaeObject.userIdEditBox()))
				enterTextInTextbox(IOShomePgaeObject.userIdEditBox(), text);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	/**
	 * This method is to Send "userPin"
	 */
	@Step("Enter data in Pin EditBox")
	public void sendDataInUserPin(String text) throws Exception {
		try {
			Asserts.assertTrue(isElementEnable(IOShomePgaeObject.userPinEditBox()), "EditField is not enable");
			if (isElementEnable(IOShomePgaeObject.userPinEditBox()))
				enterTextInTextbox(IOShomePgaeObject.userPinEditBox(), text);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	
	public void locationSwipPopup() throws Exception    
	{
		
		try {
			Thread.sleep(5000);
			String Xpath = "//XCUIElementTypeStaticText[@name=' Upgrade your banking experience with us']";
			List<RemoteWebElement> list = driver.findElements(By.xpath(Xpath));
			if (list.size() > 0) {
					Dimension windowSize1 = driver.manage().window().getSize();
					int y =(int)((windowSize1.getHeight())-10);
					int x =(int)((windowSize1.getWidth())/2);
					gestUtils.swipeElementtoCoordinate(IOShomePgaeObject.swipeButton(),  x,  y);
				}
			
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
	}
	/**
	 * Method to tap on Login Button on 1st page
	 * 
	 * @throws InterruptedException
	 */
	@Step("Clicked on Login button")
	public void clickOnLoginButton_1() throws Exception {
		try {
			clickOnElement(IOShomePgaeObject.logInButton_1());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * Method to tap on Login Button on 2st page
	 * 
	 * @throws InterruptedException
	 */
	@Step("Clicked on Login button")
	public void clickOnLoginButton_2() throws Exception {
		try {
			clickOnElement(IOShomePgaeObject.logInButton_2());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("Clicked on Login button")
	public void clickOnLoginButton_0() throws Exception {
		try {
			clickOnElement(IOShomePgaeObject.logInButton_0());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("Swiping down alert of upgarde experience")
	public void swipeUpgadeExperienceAlert() throws Exception {

		try {

			String actualMessage = commonAppTest.getTexOfElement(IOShomePgaeObject.upgradeTitle());
			if (actualMessage.equalsIgnoreCase(CommonTestData.UPGRADE_EXPERIENCE_MESSAGE.getEnumValue())) {
				Dimension windowSize1 = driver.manage().window().getSize();

				int y = (int) ((windowSize1.getHeight()) - 10);
				int x = (int) ((windowSize1.getWidth()) / 2);
				gestUtils.swipeElementtoCoordinate(IOShomePgaeObject.upgradeSwipeButton(), x, y);

			}

			Asserts.assertEquals(actualMessage, CommonTestData.UPGRADE_EXPERIENCE_MESSAGE.getEnumValue(),
					"Alert Message Not matching");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("Handling FingurePrint Alert")
	public void handlingFingurePrintAlert() throws Exception // android.widget.Toast[1]
	{
		try {
			androidAlert.AlertHandlingWithButtonMessage(IOShomePgaeObject.fingerpringAlertClosedButton(),
					CommonTestData.SETUP.getEnumValue(), IOShomePgaeObject.fingerpringAlertMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@Step("Handling Recording Alert")
	public void handlingRecordingAlert() throws Exception // android.widget.Toast[1]
	{
		try {
			androidAlert.AlertHandlingWithButtonMessage(IOShomePgaeObject.recordingAlertClosedButton(),
					CommonTestData.RECORDERSECTION_MESSAGE.getEnumValue(), IOShomePgaeObject.recordingAlertMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@Step("Handling MOTION AND FITNESS ALERT Alert")
	public void handlingMotionAndFitnessAlert() throws Exception // android.widget.Toast[1]
	{
		try {
			androidAlert.AlertHandlingWithButtonMessage(IOShomePgaeObject.alertFitnessActivityTitle(),
					CommonTestData.SETUP.getEnumValue(), IOShomePgaeObject.alertOkButton());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void fieldText(String expectedText, MobileElement Element) throws Exception {
		try {
			TakeScreenshot(Element);
			String actualText = getTexOfElement(Element).trim();

			Asserts.assertEquals(actualText.toLowerCase(), expectedText.toLowerCase(), "text is not found");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("verify 'Welcome To' Field")
	public void verifyWelcomeToText() throws Exception {
		try {
			fieldText(CommonTestData.WELCOME.getEnumValue(), IOShomePgaeObject.welcomeToText());

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("verify 'digibank' Field")
	public void verifyDigibankText() throws Exception {
		try {
			fieldText(CommonTestData.DIGIBANK.getEnumValue(), IOShomePgaeObject.digibankText());

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("Application click Logout & Verifies the 'Tap on the stars to rate' field Message.")
	public void clickOnLogoutAndVerify(String Ratingmsg) throws Exception {
		try {
			androidAlert.AlertHandlingWithButtonMessage(IOShomePgaeObject.logOutButton(),
					CommonTestData.LOGOUT_ISO.getEnumValue(), IOShomePgaeObject.logOutButton());
			Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.tapOnStarMessage()), Ratingmsg,
					"'Tap on the stars to rate' Text is not found");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void ButtonLabelVerifyClick(MobileElement Button, String expectecText) throws Exception {
		try {
			TakeScreenshot(Button);
			String actualText = commonAppTest.getTexOfElement(Button);

			if (actualText.equalsIgnoreCase(expectecText))
				commonAppTest.clickOnElement(Button);

			Asserts.assertEquals(actualText.toLowerCase(), expectecText.toLowerCase(), "button Not exist");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void ButtonVerifyClick(MobileElement Button) throws Exception {
		try {
			TakeScreenshot(Button);
			Asserts.assertTrue(commonAppTest.isElementEnable(Button), "button Not enable");
			if (commonAppTest.isElementEnable(Button))
				commonAppTest.clickOnElementOnEnable(Button);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@Step("verify and click 'pay and transfer' Field")
	public void ClickOnPayAndTransferButton() throws Exception {
		try {
			ButtonLabelVerifyClick(IOShomePgaeObject.payAndTransferButton(),
					CommonTestData.PAY_TRANSFER_ICON.getEnumValue());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("verify and click 'Topup' Field")
	public void topUpVerifyClick() throws Exception {
		try {
			ButtonLabelVerifyClick(IOShomePgaeObject.topUpButton(), CommonTestData.TOPUP_LABEL_IOS.getEnumValue());

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("verify and click 'PayLah!' Field")
	public void payLahVerifyClick() throws Exception {
		try {
			ButtonVerifyClick(IOShomePgaeObject.payLahButton());

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("verify 'Top Up PayLah!' Field")
	public void topUpPayLahTitleVerify() throws Exception {
		try {
			fieldText(CommonTestData.TOPUP_PAYLAH_LABEL.getEnumValue(), IOShomePgaeObject.topUpPayLahTitle());

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("verify 'SGD' Field")
	public void sgdCurrencyVerify() throws Exception {
		try {
			fieldText(CommonTestData.SGD_CURRENCY_LABEL.getEnumValue(), IOShomePgaeObject.sgdCurrency());

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("Enter currency in EditBox")
	public void sendCurrencyInTextField(String text) {
		try {
			Asserts.assertTrue(isElementEnable(IOShomePgaeObject.amountEditBox()), "EditField is not enable");
			if (isElementEnable(IOShomePgaeObject.amountEditBox()))
				enterTextInTextbox(IOShomePgaeObject.amountEditBox(), text);
			Thread.sleep(2000);
			String doneButtonxpath = "//XCUIElementTypeButton[@name='Done']";
			List<RemoteWebElement> doneButtonList = driver.findElements(By.xpath(doneButtonxpath));
			if (doneButtonList.size() > 0)
				clickOnElement(IOShomePgaeObject.doneButton());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step("Verify 'Enter Amount' field")
	public void verifyDisplayAmount(String expectedText) {
		try {
			fieldText(expectedText, IOShomePgaeObject.amountEditBox());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step("Verify 'Top Up Paylah Label' field")
	public void verifyReviewTopUpLabel(String expectedText) {
		try {

			fieldText(expectedText, IOShomePgaeObject.reviewToUpLabel());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step("Verifying Next Label and click")
	public void ClickOnNextButton() throws Exception {
		try {
			TakeScreenshot(IOShomePgaeObject.nextButton());
			String actualText = commonAppTest.getTexOfElement(IOShomePgaeObject.nextButton());
			if (actualText.equalsIgnoreCase("NEXT"))
				commonAppTest.clickOnElement(IOShomePgaeObject.nextButton());
			Asserts.assertEquals(actualText, "NEXT", "Button not found");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@Step("Verifying TOP UP NOW  Label and click")
	public void topUpNowVerifyClick() throws Exception {
		try {
			ButtonVerifyClick(IOShomePgaeObject.topupNowButton());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@Step("Verify 'Top-up Done' field")
	public void verifyTopUpDoneLabel(String expectedText) {
		try {
			fieldText(expectedText, IOShomePgaeObject.topupDoneButton());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step("Verifying Logout Label and click")
	public void logOutTopUpVerifyClick() throws Exception {
		try {

			String actualText = commonAppTest.getTexOfElement(IOShomePgaeObject.logoutPaylah());
			String expectecText = CommonTestData.LOGOT_PAYLAH_IOS.getEnumValue();
			if (actualText.equalsIgnoreCase(expectecText))
				commonAppTest.clickOnElement(IOShomePgaeObject.logoutPaylah());

			Asserts.assertEquals(actualText, expectecText, "LogOut button Not exist");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@Step("Verifies the 'Tap on the stars to rate' field Message.")
	public void tapOnStarFieldVerify() throws Exception {
		try {
			Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.tapOnStarMessage()),
					CommonTestData.RATE_MESSAGE.getEnumValue(), "'Tap on the stars to rate' Text is not found");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("Verifying Done button and click")
	public void doneVerifyClick() throws Exception {
		try {

			String actualText = commonAppTest.getTexOfElement(IOShomePgaeObject.doneButton());
			String expectecText = CommonTestData.DONE_2FA_IOS.getEnumValue();
			if (actualText.equalsIgnoreCase(expectecText))
				commonAppTest.clickOnElement(IOShomePgaeObject.doneButton());

			Asserts.assertEquals(actualText, expectecText, "Done button Not exist");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@Step("2FA VERIFICATION")
	public void handling2faVerification(String titleText) throws Exception {
		try {

			fieldText(titleText, IOShomePgaeObject.title2FA());
			sendPinIn2faSecureBox(CommonTestData.PIN_2FA.getEnumValue());
			doneVerifyClick();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@Step("Enter data in User EditBox")
	public void sendPinIn2faSecureBox(String text) throws Exception {
		try {
			Asserts.assertTrue(isElementEnable(IOShomePgaeObject.secureBox()), "EditField is not enable");
			if (isElementEnable(IOShomePgaeObject.secureBox()))
				enterTextInTextbox(IOShomePgaeObject.secureBox(), text);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("Login the application with USER ID and PIN")
	public void logInApplication(String userName, String password) throws Exception {
		try {
			clickOnLoginButton_0();
			sendDataInUserId(userName);
			sendDataInUserPin(password);
			clickOnLoginButton_2();
			// IOShomePgaeObject.handlingMotionAndFitnessAlert();
			// swipeUpgadeExperienceAlert();
			// handlingFingurePrintAlert();
			// handlingRecordingAlert();
			locationSwipPopup();
			verifyWelcomeToText();
			verifyDigibankText();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("Login the application")
	public void logOutApplication() throws Exception {
		try {

			clickOnLogoutAndVerify(CommonTestData.RATE_MESSAGE.getEnumValue());

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
	}

	@Step("Enter the text in search and select the corresponding value in the dropdown")
	public void sendDataInCommonSearchBoxAndSelectFromDropDown(String searchBoxData, String valueSelectedFromList)
			throws Exception {
		try {
			TakeScreenshot(IOShomePgaeObject.searchIcon());
			clickOnElementOnEnable(IOShomePgaeObject.searchIcon());
			if (isElementEnable(IOShomePgaeObject.searchBox()))
				enterTextInTextbox(IOShomePgaeObject.searchBox(), searchBoxData);
			
			List<RemoteWebElement> ElementCell = driver.findElementsByXPath("//XCUIElementTypeCell");
			int sizeList = ElementCell.size();
			int index = 0;
			for (int i = 1; i <= sizeList; i++) {

				String xpath = "//XCUIElementTypeCell" + "[" + String.valueOf(i) + "]/XCUIElementTypeStaticText";
				String Text = driver.findElementByXPath(xpath).getText();
				System.out.println(Text);
				if (Text.equalsIgnoreCase(valueSelectedFromList)) {
					index++;
					clickOnElement((MobileElement) driver.findElementByXPath(xpath));
					break;

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void TakeScreenshot(RemoteWebElement Element) throws Exception {
		try {
			wait.waitForElementVisibility((MobileElement) Element);
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Verifying button label and clicking on 'More' button ")
	public void ClickOnMoreButton() throws Exception {
		try {
			TakeScreenshot(IOShomePgaeObject.moeButton());
			androidAlert.AlertHandlingWithButtonMessage(IOShomePgaeObject.moeButton(),
					CommonTestData.MORE_LABEL.getEnumValue(), IOShomePgaeObject.moeButton());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("Verifying page header 'Local Transfer Limit' ")
	public void verifyLocalTransferLimitTitle() throws Exception {
		try {
			String expectedText = CommonTestData.LOCAL_TRANSFER_LIMIT_LABEL.getEnumValue();
			fieldText(expectedText, IOShomePgaeObject.localTransferLimitLabel());
			TakeScreenshot(IOShomePgaeObject.localTransferLimitLabel());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("Verifying 'To Other Banks Limit' and click ")
	public void toOtherBanksVerifyClick() throws Exception {
		try {
			ButtonLabelVerifyClick(IOShomePgaeObject.toOtherBankButton(),
					CommonTestData.TO_OTHERBANK_LABEL.getEnumValue());
			;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@Step("Verifying page header 'To Other Banks' title ")
	public void verifyTransferToOtherBankLimitTitle() throws Exception {
		try {
			String expectedText = CommonTestData.TRANSFER_TO_OTHERBANK_LABEL_LABEL.getEnumValue();
			fieldText(expectedText, IOShomePgaeObject.ToOtherBankLimitTitle());

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public String handlingSetCurrentLimit(String AmountToBeselected) throws Exception {
		try {
			String currentText = getTexOfElement(IOShomePgaeObject.currentLimitTextButton());
			String[] arrOfStr = currentText.split(" ");
			verifyClickSetCurrentLimit();
			// verifySetDailyLimitTitle();
			String selectedValue = null;
			if (arrOfStr[1].equalsIgnoreCase(CommonTestData.SELECTED_LIMIT_0.getEnumValue())) {
				selectedValue = selectAmountFromSetCurrentLimitList(AmountToBeselected);
			} else {
				gestUtils.scrollDOWNtoObject("text", CommonTestData.SELECTED_LIMIT_0.getEnumValue(), null);
				String flag = selectAmountFromSetCurrentLimitList(CommonTestData.SELECTED_LIMIT_0.getEnumValue());
				currentText = getTexOfElement(IOShomePgaeObject.currentLimitTextButton());
				verifyClickSetCurrentLimit();
				arrOfStr = currentText.split(" ");
				if (arrOfStr[1].equalsIgnoreCase(CommonTestData.SELECTED_LIMIT_0.getEnumValue()))
					selectedValue = selectAmountFromSetCurrentLimitList(AmountToBeselected);
			}
			return selectedValue;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("Verifying and click 'set current Limit' ")
	public void verifyClickSetCurrentLimit() throws Exception {
		try {
			TakeScreenshot(IOShomePgaeObject.currentLimitTextButton());
			ButtonVerifyClick(IOShomePgaeObject.currentLimitTextButton());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("Verifying page header 'Set Daily Limit' ")
	public void verifySetDailyLimitTitle() throws Exception {
		try {
			String expectedText = CommonTestData.SET_DAILY_LIMIT_TITLE.getEnumValue();
			fieldText(expectedText, IOShomePgaeObject.setDailyLimitTitle());

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("Select amount from the List of 'set current Limit' ")
	public String selectAmountFromSetCurrentLimitList(String amount) throws Exception {
		try {

			String selectedAmount = null;
			List<RemoteWebElement> ElementCell = driver.findElementsByXPath("//XCUIElementTypeCell");
			TakeScreenshot(ElementCell.get(0));
			int sizeList = ElementCell.size();
			int index = 0;
			for (int i = 1; i <= sizeList; i++) {

				String xpath = "//XCUIElementTypeCell" + "[" + String.valueOf(i) + "]/XCUIElementTypeStaticText";
				String Text = driver.findElementByXPath(xpath).getText();
				System.out.println(Text);
				if (Text.equalsIgnoreCase(amount)) {
					selectedAmount = Text;
					index++;
					clickOnElement((MobileElement) driver.findElementByXPath(xpath));
					break;

				}
			}
			Asserts.assertTrue(index > 0, "No" + amount + "found in the list of corresponding value");
			return selectedAmount;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("Verifying page header 'Review Daily Limit'")
	public void verifyReviewDailyLimitTitle() throws Exception {
		try {
			String expectedText = CommonTestData.REVIEW_DAILY_LIMIT_TITLE.getEnumValue();
			fieldText(expectedText, IOShomePgaeObject.reviewDailyLimitTitle());
			TakeScreenshot(IOShomePgaeObject.reviewDailyLimitTitle());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("Verifying and click 'CHANGE DAILY LIMIT NOW' BUTTON ")
	public void verifyClickChangeDailyLimitNowButton() throws Exception {
		try {
			ButtonVerifyClick(IOShomePgaeObject.changeLimitNowButton());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("Verify topup Paylah Case and logout topup Paylah.")
	public void TopupPaylah() throws Exception {
		try {
			ClickOnPayAndTransferButton();
			EnterPasscodeAndDone();
			topUpVerifyClick();
			payLahVerifyClick();
			sendCurrencyInTextField(CommonTestData.AMOUNT_PAYLAH.getEnumValue());
			ClickOnNextButton();
			verifyReviewTopUpLabel(CommonTestData.TOPUP_REVIEW_LABEL.getEnumValue());
			topUpNowVerifyClick();
			logOutTopUpVerifyClick();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("Change local fund transfer limit verification")
	public void ChangeLocalFundsTransferLimit() throws Exception {
		try {
			ClickOnMoreButton();
			EnterPasscodeAndDone();
			sendDataInCommonSearchBoxAndSelectFromDropDown(
					CommonTestData.LOCAL_TRANSFER_LIMIT_SEARCHBOX_IOS.getEnumValue(),
					CommonTestData.LOCAL_TRANSFER_LIMIT_LABEL.getEnumValue());
			verifyLocalTransferLimitTitle();
			toOtherBanksVerifyClick();
			EnterPasscodeAndDone();
			String amountSlected = handlingSetCurrentLimit(CommonTestData.SELECTED_LIMIT_50000.getEnumValue());
			ClickOnNextButton();
			verifyReviewDailyLimitTitle();
			verifyClickChangeDailyLimitNowButton();
			EnterPasscode();
			verifyLocalTransferlimitChangedHeader(CommonTestData.LOCAL_LIMIT_INCREASE_SUCCESS_TITLE_IOS.getEnumValue());
			verifyClickBackToMoreButton();
			sendDataInCommonSearchBoxAndSelectFromDropDown(
					CommonTestData.LOCAL_TRANSFER_LIMIT_SEARCHBOX_IOS.getEnumValue(),
					CommonTestData.LOCAL_TRANSFER_LIMIT_LABEL.getEnumValue());
			verifyLocalTransferLimitTitle();
			toOtherBanksVerifyClick();
			verifyDisplayAmountLocalTransferLimitChange(amountSlected);
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Verifying Header and click 'BACK TO MORE' BUTTON ")
	public void verifyClickBackToMoreButton() throws Exception {
		try {
			ButtonVerifyClick(IOShomePgaeObject.backToMoreButton());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("Verify 'Local Transfer limit Changed' field")
	public void verifyLocalTransferlimitChangedHeader(String expectedText) throws Exception {
		try {
			TakeScreenshot(IOShomePgaeObject.localTransferLimitChangedTitle());
			fieldText(expectedText, IOShomePgaeObject.localTransferLimitChangedTitle());

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("Verify Amount display After Limit get Changed")
	public void verifyDisplayAmountLocalTransferLimitChange(String expectedText) throws Exception {
		try {
			TakeScreenshot(IOShomePgaeObject.currentLimitTextButton());
			String currentText = getTexOfElement(IOShomePgaeObject.currentLimitTextButton());
			String[] arrOfStr = currentText.split(" ");
			String acutalText = arrOfStr[1];
			Asserts.assertEquals(acutalText, expectedText, "'Amount display' After Limit get Changed is Wrong");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("Verifies Add payee DBSorPOSB.")
	public void VerifyAddPayeeDBSorPOSB() throws Exception {
		try {
			ClickOnPayAndTransferButton();
			EnterPasscodeAndDone();
			clickOnAddLocalRecipientBtnAndVerifyLocalTransferPayNowPageHeader();
			String ExpectedRecipientName = CommonTestData.PAYEEADD_DBSPOSB_RECIPIENT_NAME.getEnumValue();
			EnterRecipientDetailsAfterSelectingBankAccountOption(ExpectedRecipientName,
					CommonTestData.PAYEEADD_DBSPOSB_BANK_NAME.getEnumValue(),
					CommonTestData.PAYEEADD_DBSPOSB_ACCOUNT_NUMBER.getEnumValue());
			ClickOnNextButton();
			Asserts.assertTrue(isElementVisible(IOShomePgaeObject.ReviewRecipientDetailsPageHeader()),
					CommonTestData.REVIEW_RECIPIENT_DETAILS.getEnumValue() + " Page Header not displaying.");

			ClickOnAddRecipientNowBtn();
			VerifyYouHaveAddedRecipientMsgAfterEnterSecurePIN();
			verifyValidationForPayeeAdd(ExpectedRecipientName, CommonTestData.PAYEEADD_DBSPOSB_BANK_NAME.getEnumValue(),
					CommonTestData.PAYEEADD_DBSPOSB_ACCOUNT_NUMBER.getEnumValue());
			
			// Leave On Home Page to this test case for next run.
			ClickOnCloseButton();
			ClickOnHomeButton();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Step("Delete Payee to DBS/POSB.")
	public void DeletePayee_ToDBSPOSB() throws Exception {
		try {
			ClickOnPayAndTransferButton();
			EnterPasscodeAndDone();
			clickOnLocalButton();
			DeletePayee(CommonTestData.PAYEEADD_DBSPOSB_RECIPIENT_NAME.getEnumValue());
			
			// Leave On Home Page to this test case for next run.
			ClickOnCloseButton();
			ClickOnHomeButton();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	} 

	@Step("Click On Local Button.")
	public void clickOnLocalButton() throws Exception {
		try {
			TakeScreenshot(IOShomePgaeObject.LocalButton());
			clickOnElement(IOShomePgaeObject.LocalButton());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void TakeScreenshot(MobileElement Element) throws Exception {
		try {
			wait.waitForElementVisibility(Element);
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("Verifies the Payee Add Local OtherBank and verifies 'YOU HAVE ADDED RECIPIENT MSG' .")
	public void PayeeAddLocalOtherBank() throws Exception {
		try {
			ClickOnPayAndTransferButton();
			EnterPasscodeAndDone();
			clickOnLocalButton();
			clickOnAddLocalRecipientBtnAndVerifyLocalTransferPayNowPageHeader();

			String ExpectedRecipientName = CommonTestData.LOCAL_RECIPIENT_NAME.getEnumValue();
			String ExpectedAccountNumber = CommonTestData.LOCAL_RECIPIENT_ACCOUNT_NUMBER.getEnumValue();

			EnterRecipientDetailsAfterSelectingBankAccountOption(ExpectedRecipientName,
					CommonTestData.LOCAL_RECIPIENT_BANK_NAME.getEnumValue(), ExpectedAccountNumber);
			ClickOnNextButton();
			Asserts.assertTrue(isElementVisible(IOShomePgaeObject.ReviewRecipientDetailsPageHeader()),
					CommonTestData.REVIEW_RECIPIENT_DETAILS.getEnumValue() + " Page Header not displaying.");
			ClickOnAddRecipientNowBtn();
			VerifyYouHaveAddedRecipientMsgAfterEnterSecurePIN();
			verifyValidationForPayeeAdd(ExpectedRecipientName, CommonTestData.LOCAL_RECIPIENT_BANK_NAME.getEnumValue(),
					ExpectedAccountNumber);

			// Leave On Home Page to this test case for next run.
			ClickOnCloseButton();
			ClickOnHomeButton();	
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Step("Delete Payee to Local To Other Bank.")
	public void DeletePayee_LocalToOtherBank() throws Exception {
		try {
			ClickOnPayAndTransferButton();
			EnterPasscodeAndDone();
			clickOnLocalButton();
			DeletePayee(CommonTestData.LOCAL_RECIPIENT_NAME.getEnumValue());
			
			// Leave On Home Page to this test case for next run.
			ClickOnCloseButton();
			ClickOnHomeButton();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	} 
	
	
	@Step("Click on 'Home' Button.")
	public void ClickOnHomeButton() throws Exception {
		try {
			TakeScreenshot(IOShomePgaeObject.HOMEButton()); 
			clickOnElement(IOShomePgaeObject.HOMEButton());
		} catch (Exception e) {
			e.printStackTrace();
			throw e; 
		}
	}
	
	@Step("Click on 'Close' Button.")
	public void ClickOnCloseButton() throws Exception {
		try {
			TakeScreenshot(IOShomePgaeObject.closeButton()); 
			clickOnElement(IOShomePgaeObject.closeButton());
		} catch (Exception e) {
			e.printStackTrace();
			throw e; 
		}
	}

	@Step("Delete Payee.")
	public void DeletePayee(String ExpectedPayee) throws Exception {
		try {
			String RecipientNameXpath = "//XCUIElementTypeStaticText[@name='" + ExpectedPayee + "']";
			MobileElement RecipientNameElement = (MobileElement) driver.findElement(By.xpath(RecipientNameXpath));
			int ExpectedTotalPayeeSize = IOShomePgaeObject.IiconList().size();

			for (int i = 0; i < ExpectedTotalPayeeSize; i++) {
				TakeScreenshot(IOShomePgaeObject.IiconList().get(i));
				clickOnElement(IOShomePgaeObject.IiconList().get(i));
				TakeScreenshot(RecipientNameElement);
				if (isElementVisible(RecipientNameElement)) {
					clickOnElement(IOShomePgaeObject.MorePayeeDetailDots());
					TakeScreenshot(IOShomePgaeObject.DeletePayeeButton());
					clickOnElement(IOShomePgaeObject.DeletePayeeButton());
					TakeScreenshot(IOShomePgaeObject.AreYouSureToDeleteThisPayeeMsg());
					if (isElementVisible(IOShomePgaeObject.AreYouSureToDeleteThisPayeeMsg()))
						clickOnElement(IOShomePgaeObject.YesButton());

					for (int innerLoop = 0; innerLoop < 2; innerLoop++) {
						String ErrorissueXpath = "//XCUIElementTypeStaticText[@name='You may be facing some delays and we are trying to sort it out now. Sorry for the inconvenience. Do check back later.']";
						List<RemoteWebElement> list = driver.findElements(By.xpath(ErrorissueXpath));
						if (list.size() > 0) {
							TakeScreenshot(IOShomePgaeObject.alertOkButton());
							clickOnElement(IOShomePgaeObject.alertOkButton());
							TakeScreenshot(IOShomePgaeObject.MorePayeeDetailDots());
							clickOnElement(IOShomePgaeObject.MorePayeeDetailDots());
							TakeScreenshot(IOShomePgaeObject.DeletePayeeButton());
							clickOnElement(IOShomePgaeObject.DeletePayeeButton());
							TakeScreenshot(IOShomePgaeObject.AreYouSureToDeleteThisPayeeMsg());
							if (isElementVisible(IOShomePgaeObject.AreYouSureToDeleteThisPayeeMsg()))
								clickOnElement(IOShomePgaeObject.YesButton());
						}
					}

					String message = ExpectedPayee + " Deleted";
					String DeletePayeeMessageXPath = "//XCUIElementTypeStaticText[@name='" + message + "']";
					MobileElement DeletePayeeMessageElement = (MobileElement) driver
							.findElement(By.xpath(DeletePayeeMessageXPath));
					if (isElementVisible(DeletePayeeMessageElement)) {
						TakeScreenshot(IOShomePgaeObject.OKButton());
						clickOnElement(IOShomePgaeObject.OKButton());
					}
				} else {
					clickOnElement(IOShomePgaeObject.BackBtn());
				}
			}

			int ActualTotalPayeeSize = IOShomePgaeObject.IiconList().size();
			int ExpectedTotalSizeAfterDeletingPayee = ExpectedTotalPayeeSize - 1;
			Asserts.assertEquals(String.valueOf(ExpectedTotalSizeAfterDeletingPayee),
					String.valueOf(ActualTotalPayeeSize), " Payee is not deleting after adding payee.");
           
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("Verifies Visibilty of 'logout' and 'make a transfer' button and Verifies the recipient name, account number, bank name.")
	public void verifyValidationForPayeeAdd(String ExpectedRecipientName, String BankName, String AccountNumber)
			throws Exception {
		try {
			Asserts.assertTrue(IOShomePgaeObject.LogoutBtn().isDisplayed(), "Log Out Button not found.");
			Asserts.assertTrue(IOShomePgaeObject.makeTransferButton().isDisplayed(),
					"Make A Transfer Button not found.");
			Asserts.assertTrue(IOShomePgaeObject.closeButton().isDisplayed(), "Close Button not found.");

			Asserts.assertTrue(IOShomePgaeObject.RecipientNameText().isDisplayed(),
					"'Recipient's Name' text is not dispalying After adding Payee.");
			String RecipientNameXpath = "//XCUIElementTypeStaticText[@name='" + ExpectedRecipientName + "']";
			MobileElement RecipientNameElement = (MobileElement) driver.findElement(By.xpath(RecipientNameXpath));
			Asserts.assertEquals(getTexOfElement(RecipientNameElement), ExpectedRecipientName,
					ExpectedRecipientName + " is not matching after adding payee");

			Asserts.assertTrue(IOShomePgaeObject.RecipientBankText().isDisplayed(),
					"'Recipient's Bank' text is not dispalying After adding Payee.");
			String BankNameXpath = "//XCUIElementTypeStaticText[@name='" + BankName + "']";
			MobileElement BankNameElement = (MobileElement) driver.findElement(By.xpath(BankNameXpath));
			Asserts.assertEquals(getTexOfElement(BankNameElement), BankName,
					BankName + " is not matching after adding payee");

			Asserts.assertTrue(IOShomePgaeObject.RecipientAccountNo().isDisplayed(),
					"'Recipient's Account No.' text is not dispalying After adding Payee.");
			String AccountNumberXpath = "//XCUIElementTypeStaticText[@name='" + AccountNumber + "']";
			MobileElement AccountNumberElement = (MobileElement) driver.findElement(By.xpath(AccountNumberXpath));
			Asserts.assertEquals(getTexOfElement(AccountNumberElement), AccountNumber,
					AccountNumber + " is not matching after adding payee");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("Verify Local Transfer Pay Now Page Header After Clicking On Add Local Recipient Page Header.")
	public void clickOnAddLocalRecipientBtnAndVerifyLocalTransferPayNowPageHeader() throws Exception {
		try {
			String xpath = "//XCUIElementTypeButton[@name='ADD RECIPIENT NOW']";
			List<RemoteWebElement> list = driver.findElements(By.xpath(xpath));
			if (list.size() > 0) {
				TakeScreenshot(IOShomePgaeObject.AddRecipientNowButton());
				clickOnElement(IOShomePgaeObject.AddRecipientNowButton());
			} else {
				TakeScreenshot(IOShomePgaeObject.AddLocalRecipientButton());
				clickOnElement(IOShomePgaeObject.AddLocalRecipientButton());
			}

			Asserts.assertTrue(isElementVisible(IOShomePgaeObject.LocalTransferPayNowPageHeader()),
					" 'Local Transfer & Pay Now' Page Header not displaying.");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("Enter Recipient Details Into Bank Account Section.")
	public void EnterRecipientDetailsAfterSelectingBankAccountOption(String ExpectedRecipientName, String BankName,
			String AccountNumber) throws Exception {
		try {
			TakeScreenshot(IOShomePgaeObject.SelectBankAccount());
			clickOnElement(IOShomePgaeObject.SelectBankAccount());

			Asserts.assertTrue(isElementVisible(IOShomePgaeObject.EnterRecipientDetailsPageHeader()),
					" 'Enter Recipient's Details' Page Header not displaying.");

			enterTextInTextbox(IOShomePgaeObject.EnterRecipientNameEditableField(), ExpectedRecipientName);

			clickOnElement(IOShomePgaeObject.SelectBankDropdown());
			clickOnElement(IOShomePgaeObject.SearchBankNameField());
			enterTextInTextbox(IOShomePgaeObject.SearchBankNameField(), BankName);

			String xpath = "//XCUIElementTypeStaticText[@name='" + BankName + "']";
			MobileElement Selectbank = (MobileElement) driver.findElement(By.xpath(xpath));
			clickOnElement(Selectbank);

			enterTextInTextbox(IOShomePgaeObject.EnterAccountNumberEditField(), AccountNumber);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("clicking On 'ADD RECIPIENT NOW' button")
	public void ClickOnAddRecipientNowBtn() throws Exception {
		try {
			TakeScreenshot(IOShomePgaeObject.ADDRecipientNowButton());
			String actualText = getTexOfElement(IOShomePgaeObject.ADDRecipientNowButton());
			if (actualText.equalsIgnoreCase(CommonTestData.ADD_RECIPIENT_LABEL.getEnumValue()))
				clickOnElement(IOShomePgaeObject.ADDRecipientNowButton());
			Thread.sleep(4000);
			Asserts.assertEquals(actualText, CommonTestData.ADD_RECIPIENT_LABEL.getEnumValue(), "Button not matching");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("Verify 'You Have Added Recipient Msg' After Entering Secure PIN.")
	public void VerifyYouHaveAddedRecipientMsgAfterEnterSecurePIN() throws Exception {
		try {
			EnterPasscodeAndDone();
			Thread.sleep(20000);
			TakeScreenshot(IOShomePgaeObject.SuccessImage().get(3));
			if (isElementVisible(IOShomePgaeObject.SuccessImage().get(3)))
				Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.YouHaveAddedRecipient()),
						CommonTestData.YOU_HAVE_ADDED_RECIPIENT_MSG.getEnumValue(),
						CommonTestData.YOU_HAVE_ADDED_RECIPIENT_MSG.getEnumValue() + " Text is not matching");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("Enter Passcode(123456) and click on Done button for Secure Pin Authentication.")
	public void EnterPasscodeAndDone() throws Exception {
		try {
			Thread.sleep(10000);
			String xpath = "//XCUIElementTypeSecureTextField[@value='••••••']";
			List<RemoteWebElement> list = driver.findElements(By.xpath(xpath));
			if (list.size() > 0) {
				TakeScreenshot(IOShomePgaeObject.secureBox());
				enterTextInTextbox(IOShomePgaeObject.secureBox(), CommonTestData.OTP.getEnumValue());
				String doneButtonxpath = "//XCUIElementTypeButton[@name='Done']";
				List<RemoteWebElement> doneButtonList = driver.findElements(By.xpath(doneButtonxpath));
				if (doneButtonList.size() > 0)
					clickOnElement(IOShomePgaeObject.doneButton());
			}
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Enter Passcode(123456) for Secure Pin Authentication.")
	public void EnterPasscode() throws Exception {
		try {
			Thread.sleep(10000);
			String xpath = "//XCUIElementTypeSecureTextField[@value='••••••']";
			List<RemoteWebElement> list = driver.findElements(By.xpath(xpath));
			if (list.size() > 0) {
				clickOnElement(IOShomePgaeObject.secureBox());
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				Thread.sleep(2000);
				for (int i = 1; i <= 6; i++) {
					String bxpath = "//XCUIElementTypeButton[@name=" + i + "]";
					MobileElement button = (MobileElement) driver.findElement(By.xpath(bxpath));
					clickOnElement(button);
					Thread.sleep(2000);
				}
			}

		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	@Step("Verify 'You have added a Recipient ' after excecuting Payee Add Remittance Case.")
	public void PayeeAddRemittance() throws Exception {
		try {
			ClickOnPayAndTransferButton();
			EnterPasscodeAndDone();
			overseasVerifyClick(CommonTestData.OVERSEAS_ICON.getEnumValue());
			ClickOnAddRecipientNowBtn();
			sendCountryInSearchBoxAndSelectFromDropDown(CommonTestData.COUNTRY_AUS.getEnumValue(),
					CommonTestData.COUNTRY_AUS.getEnumValue());
			CurrencyTypeVerifyClick(CommonTestData.CURRENCY_AUS.getEnumValue());
			ClickOnNextButton();
			sendBankCode(CommonTestData.BANK_BCD_CODE.getEnumValue());
			ClickOnNextButton();
			verifyRecipientDetailHeaderAndEnterDetail();
			ClickOnNextButton();
			verifyRecipientReviewDetailAndClickOnAddRecipientVutton();
			EnterPasscode();
			Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.addedRecipientTitle()).toLowerCase(),
					CommonTestData.YOU_HAVE_ADDED_RECIPIENT_MSG.getEnumValue().toLowerCase(),
					"'You've added a recipient label' Text is not matching");
			verifyReferenceFieldAndItsValue(CommonTestData.REFERENCE_NUMBER.getEnumValue());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("Verifying Overseas  icon and click")
	public void overseasVerifyClick(String expectecText) throws Exception {
		try {
			ButtonLabelVerifyClick(IOShomePgaeObject.overseasButton(), expectecText);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("Enter the text in search and select the corresponding value in the dropdown")
	public void sendCountryInSearchBoxAndSelectFromDropDown(String searchBoxData, String valueSelectedFromList)
			throws Exception {
		try {

			if (isElementEnable(IOShomePgaeObject.searchBoxforLocation()))
				enterTextInTextbox(IOShomePgaeObject.searchBoxforLocation(), searchBoxData);
			TakeScreenshot(IOShomePgaeObject.countryList().get(1));
			List<MobileElement> Elementlist = IOShomePgaeObject.countryList();
			int l = Elementlist.size();
			int index = 0;
			String countryFromList = null;
			for (int i = 1; i <= l; i++) {
				countryFromList = Elementlist.get(i).getText();
				if (countryFromList.equalsIgnoreCase(valueSelectedFromList)) {
					index++;
					clickOnElement(Elementlist.get(i));
					break;
				}
			}

			Asserts.assertTrue(index > 0, "No element found in the lis of corresponding value");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("Select CurrencyType From the List")
	public void CurrencyTypeVerifyClick(String expectecCurrency) throws Exception {
		try {

			TakeScreenshot(IOShomePgaeObject.currencyList().get(1));
			List<MobileElement> Elementlist = IOShomePgaeObject.currencyList();
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

			Asserts.assertTrue(index > 0, "No currency found in the list of corresponding value");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@Step("Enter data in Bank Code EditBox")
	public void sendBankCode(String text) throws Exception {
		try {

			if (isElementEnable(IOShomePgaeObject.bankCode()))
				enterTextInTextbox(IOShomePgaeObject.bankCode(), text);

			TakeScreenshot(IOShomePgaeObject.bankCode());
			Asserts.assertTrue(isElementEnable(IOShomePgaeObject.bankCode()), "EditField is not enable");
			doneButtonIfAviliable();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("click on done button")
	public void doneButtonIfAviliable() throws Exception {
		try {
			String doneButtonxpath = "//XCUIElementTypeButton[@name='Done']";
			List<RemoteWebElement> doneButtonList = driver.findElements(By.xpath(doneButtonxpath));
			if (doneButtonList.size() > 0)
				TakeScreenshot(doneButtonList.get(0));
			clickOnElement(IOShomePgaeObject.doneButton());
		} catch (Exception e) {

			e.printStackTrace();
			throw e;
		}
	}

	@Step("Enter data in Bank Code EditBox")
	public void verifyRecipientDetailHeaderAndEnterDetail() throws Exception {
		try {
			fieldText(CommonTestData.ENTER_RECIPIENT_DETAIL.getEnumValue(), IOShomePgaeObject.recipientDetailTitle());

			sendAccountNo(CommonTestData.ACCOUNT_NO.getEnumValue());
			sendFullName(CommonTestData.FULL_NAME.getEnumValue());
			gestUtils.scrollUPtoObject("name", "NEXT", null);
			sendAddress(CommonTestData.ADDRESS.getEnumValue());
			sendcity(CommonTestData.CITY.getEnumValue());

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("Enter Account No EditBox")
	public void sendAccountNo(String text) throws Exception {
		try {
			TakeScreenshot(IOShomePgaeObject.recipientDetailAccountNumver());
			if (isElementEnable((IOShomePgaeObject.recipientDetailAccountNumver())))
				enterTextInTextbox(IOShomePgaeObject.recipientDetailAccountNumver(), text);

			doneButtonIfAviliable();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("Enter Full name EditBox")
	public void sendFullName(String text) throws Exception {
		try {
			TakeScreenshot(IOShomePgaeObject.recipientDetailAccountName());
			if (isElementEnable(IOShomePgaeObject.recipientDetailAccountName()))
				enterTextInTextbox(IOShomePgaeObject.recipientDetailAccountName(), text);
			doneButtonIfAviliable();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("Enter Address EditBox")
	public void sendAddress(String text) throws Exception {
		try {
			TakeScreenshot(IOShomePgaeObject.recipientDetailAddress());
			if (isElementEnable(IOShomePgaeObject.recipientDetailAddress()))
				enterTextInTextbox(IOShomePgaeObject.recipientDetailAddress(), text);
			doneButtonIfAviliable();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("Enter city EditBox")
	public void sendcity(String text) throws Exception {
		try {
			TakeScreenshot(IOShomePgaeObject.recipientDetailCity());
			if (isElementEnable(IOShomePgaeObject.recipientDetailCity()))
				enterTextInTextbox(IOShomePgaeObject.recipientDetailCity(), text);
			doneButtonIfAviliable();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("Verify 'REVIEW RECIPIENT'S DETAILS label' and Click on 'Add Recipient Now' button")
	public void verifyRecipientReviewDetailAndClickOnAddRecipientVutton() throws Exception {
		try {
			fieldText(CommonTestData.REVIEW_RECIPIENT_LABEL.getEnumValue(),
					IOShomePgaeObject.reviewRecipientDetailTitle());
			ButtonVerifyClick(IOShomePgaeObject.ADDRecipientNowButton());

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("Verify 'Reference No. Field and its value' field and Verify 'MAKE A TRANSFER' Button After Expanding & Scrolling to the Page.")
	public void verifyReferenceFieldAndItsValue(String expectedText) throws Exception {
		try {
			clickOnElement(IOShomePgaeObject.expandButton());
			gestUtils.scrollUPtoObject("name", "Reference No.", IOShomePgaeObject.referenceNumber());
			TakeScreenshot(IOShomePgaeObject.makeTransferButton());
			Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.makeTransferButton()).toLowerCase(),
					CommonTestData.MAKE_TRANSFER.getEnumValue().toLowerCase(), "'MAKE A TRANSFER' Text is not found");
			Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.referenceNumber()).toLowerCase(),
					expectedText.toLowerCase(), "'Reference no Field' is not found");
			boolean i = IOShomePgaeObject.referenceNoValue().getText().isEmpty();
			Asserts.assertTrue(i == false, "Reference Number not Found");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	@Step("Verify Fund Transfer Pay Credit Card.")
	public void FundsTransfer_PayCreditCard() throws Exception {
		try {
			ClickOnPayAndTransferButton();
			EnterPasscodeAndDone();
			SelectAllTAB();
			String ExpectedToBankNameWithAccountNo = CommonTestData.FUNDTRANSFER_CREDITCARD_TO_ACCOUNTNUMBER_WITHBANK
					.getEnumValue();
			clickingOnAccountTypeInCreditCard(ExpectedToBankNameWithAccountNo);
			
			EnterAmount(IOShomePgaeObject.AmountEditableField(), CommonTestData.AMOUNTTO_TRANSFERFUND.getEnumValue());

			String ExpectedFromBankName = CommonTestData.FUNDTRANSFER_CREDITCARD_FROM_ACCOUNT_NAME.getEnumValue();
			SelectFundSourceAccount(ExpectedFromBankName);

			String ExpectedSelectedDate = getTexOfElement(IOShomePgaeObject.TransferDateTextElement());
			Asserts.assertEquals("Immediate", ExpectedSelectedDate, "Selected Date is not Matching");
			
			ClickOnNextButton();
			Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.ReviewPaymentPageHeader()),
					CommonTestData.REVIEW_PAYMENT_PAGEHEADER.getEnumValue(),
					CommonTestData.REVIEW_PAYMENT_PAGEHEADER.getEnumValue() + " Text is not matching");
		
			ClickOnTransferNowBtnAndVerifyPaymentSubmittedMsg();
			VerifyVisibiltyOfSomeElements_FundTransferCreditCard();

			//Leaving On Home Page for Next case Run.
			ClickOnCloseButton();
			ClickOnHomeButton();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	@Step("Select Any Fund Source Account After clicking on add sign for select fund source.")
	public void SelectFundSourceAccount(String fromOwnAccount) throws Exception {
		try {
			String xpath = "//XCUIElementTypeStaticText[@name='source_account_name']";
			List<RemoteWebElement> list = driver.findElements(By.xpath(xpath));
			if (list.size() > 0) {
				gestUtils.scrollDOWNtoObject("text", "Select Fund Source", IOShomePgaeObject.SelectFundSourcePage());
				TakeScreenshot(IOShomePgaeObject.SelectFundSourcePage());
				clickOnElement(IOShomePgaeObject.SelectFundSourcePage());
				TakeScreenshot(IOShomePgaeObject.localRecipientsList().get(0));

				for (int i = 0; i < IOShomePgaeObject.localRecipientsList().size(); i++) {
					String actualfromOwnAccount = IOShomePgaeObject.localRecipientsList().get(i).getText();
					if (actualfromOwnAccount.contains(fromOwnAccount)) {
						clickOnElement(IOShomePgaeObject.localRecipientsList().get(i));
						break;
					}
				}

				Thread.sleep(3000);
				String xpath1 = "//XCUIElementTypeStaticText[@name='Primary source of fund']";
				List<RemoteWebElement> list1 = driver.findElements(By.xpath(xpath1));
				if (list1.size() > 0) {
					com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
					if (isElementVisible(IOShomePgaeObject.primarysourceOfFund()))
						clickOnElement(IOShomePgaeObject.okButton());
				}
			}
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
	}
	@Step("Verify Transaction History")
	public void transactionHistoryVerify() throws Exception {
		try {
			ClickOnMoreButton();
			EnterPasscodeAndDone();
			ClickOnTransactionHistory();
			SelectTimeAndAccountTypeForStatement(CommonTestData.ACCOUNT_NAME.getEnumValue(),CommonTestData.CURRENCY_NAME.getEnumValue());
			gestUtils.scrollUPtoObject("name", "SHOW", null);
			ClickOnShowButtonAndVerifyHeader(CommonTestData.STATEMENT_TITLE.getEnumValue());
			ValadateTransactionHistoryListInThreeMonth();
			BackToHomeFromTransactionHistory();
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
	}
	@Step("Click on 'Transaction History' Button and then Verifying page header 'Transaction History'")
	public void ClickOnTransactionHistory() throws Exception {
		try {
			ButtonLabelVerifyClick(IOShomePgaeObject.transactionHistoryBtnLabel(), CommonTestData.TRANSCETION_HISTORY_LABEL.getEnumValue());
			EnterPasscodeAndDone();
			fieldText(CommonTestData.TRANSCETION_HISTORY_LABEL.getEnumValue(), IOShomePgaeObject.transactionHistoryBtnLabel());
				
			
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}

	}
	@Step("Select'3 Months Transaction History' And 'From Account' from 'Deposit Account' section")
	public void SelectTimeAndAccountTypeForStatement(String AccountName, String currencyInAccount) throws Exception {
		try {
			    
			    ButtonVerifyClick(IOShomePgaeObject.threeMonthOption());
			    ButtonVerifyClick(IOShomePgaeObject.depositeOption());
			    selectAccountTypeInTransactionHistory(AccountName, currencyInAccount);
			
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
	}
	@Step("Click on 'Account type' From List under Local fund Limit page'")
	public void selectAccountTypeInTransactionHistory(String AccountToBeSelected,String currencyInAccount) throws Exception {
		try {
			List<MobileElement> Elementlist = null;
			TakeScreenshot(IOShomePgaeObject.accountListinTransectionHistory().get(0));
			Elementlist = IOShomePgaeObject.accountListinTransectionHistory();	
			int l = Elementlist.size();
			int index = 0;
			String accountFromList = null;
			for (int i = 0; i < l; i++) {
				accountFromList = Elementlist.get(i).getText();
				if (accountFromList.contains(AccountToBeSelected)) {
					index++;
					com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
					clickOnElement(Elementlist.get(i));
					break;
				}
			}
			Thread.sleep(2000);
			String xpath = "//XCUIElementTypeStaticText[@name='Select Currency']";
			List<RemoteWebElement> currencyTitle = driver.findElements(By.xpath(xpath));
			if (currencyTitle.size() > 0) {
			        List<MobileElement> Elementlist1 = null;
					TakeScreenshot(IOShomePgaeObject.currencyListinTransectionHistory().get(0));
					Elementlist1 = IOShomePgaeObject.currencyListinTransectionHistory();	
					int l1 = Elementlist1.size();
					int index1 = 0;
					String currencyFromList = null;
					for (int i = 0; i < l1; i++) {
						currencyFromList = Elementlist1.get(i).getText();
						if (currencyFromList.contains(currencyInAccount)) {
							index1++;
							com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
							clickOnElement(Elementlist.get(i));
							break;
						}
					}
					Asserts.assertTrue(index > 0, "No " + currencyInAccount + " found in the list of corresponding value");
   
			}
			Asserts.assertTrue(index > 0, "No " + AccountToBeSelected + " found in the list of corresponding value");
			fieldText(CommonTestData.TRANSCETION_HISTORY_LABEL.getEnumValue(), IOShomePgaeObject.transactionHistoryBtnLabel());
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
	}
	@Step("Click on 'Show' Button and then Verifying From Account.")
	public void ClickOnShowButtonAndVerifyHeader(String ExpectedAccountName) throws Exception {
		try {
			ButtonLabelVerifyClick(IOShomePgaeObject.showButton(), CommonTestData.SHOW_BUTTON.getEnumValue());
			EnterPasscode();
			fieldText(ExpectedAccountName, IOShomePgaeObject.transactionHistoryfinalheaderTitle());
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
	}
	@Step("Validating From Account Transaction History List.")
	public void ValadateTransactionHistoryListInThreeMonth() throws Exception {
		try {
			List<MobileElement> Elementlist = IOShomePgaeObject.accountListinTransectionHistory();
			int l = Elementlist.size();
			Asserts.assertTrue(l > 0, "No Transaction History is Display");
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
	}

	@Step("Back to Home page from Transaction History statement")
	public void BackToHomeFromTransactionHistory() throws Exception {
		try {
			ButtonVerifyClick(IOShomePgaeObject.closeButton());
			fieldText(CommonTestData.TRANSCETION_HISTORY_LABEL.getEnumValue(), IOShomePgaeObject.transactionHistoryBtnLabel());
			ButtonVerifyClick(IOShomePgaeObject.closeButton());
			ButtonVerifyClick(IOShomePgaeObject.homeButton());
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);

		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
	}
	@Step("Verifies FundTransfer Other DBS/POSB")
	public void FundTransferOtherBank() throws Exception {
		try {
			ClickOnPayAndTransferButton();
			EnterPasscodeAndDone();
			clickAndVerifyOnAllTabAndselectFromTheList(CommonTestData.LOCAL_RECIPIENT_FROMLIST.getEnumValue());
			clickingOnAccountTypeInLocalRecipient(CommonTestData.LOCAL_RECIPIENT_LIST_SELECTED_ACCOUNTNAME.getEnumValue());
			selectFundSourceAndSelectAccount(CommonTestData.SOURCE_ACCOUNT_NAME.getEnumValue());
            enterAmountAndVerifySgdCurrency("11");
            verifyReviewTransferAndClickTransferNowButton();
            verifyTransferredAndReferenceNumberField();
            BackToHomeFromFundTransfer();
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
	}
	@Step("Click on 'All Tab' section And select option form the list")
	public void clickAndVerifyOnAllTabAndselectFromTheList(String TabValue) throws Exception {
		try {
			ButtonLabelVerifyClick(IOShomePgaeObject.allTab(), CommonTestData.ALL_SECTION.getEnumValue());
			TakeScreenshot(IOShomePgaeObject.allTabList().get(0));
			for (int i = 0; i < IOShomePgaeObject.allTabList().size(); i++) {
				String tabText = IOShomePgaeObject.allTabList().get(i).getText(); 
				if (tabText.contains(TabValue)) {
					clickOnElement(IOShomePgaeObject.allTabList().get(i));
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}

	}
	
	@Step("Click on 'Select Fund Source' and Select Account")
	public void selectFundSourceAndSelectAccount(String SelectedAccountName) throws Exception {
		try {
			String xpath = "//XCUIElementTypeStaticText[@name='Select Fund Source']";
			List<RemoteWebElement> list = driver.findElements(By.xpath(xpath));
			
			if (list.size() > 0) {
			ButtonLabelVerifyClick(IOShomePgaeObject.selectfundSource(), CommonTestData.SELECT_SOURCE_FUND.getEnumValue());
			TakeScreenshot(IOShomePgaeObject.selectfundSourceList().get(0));
			List<MobileElement> AccountName = IOShomePgaeObject.selectfundSourceList();
			
			int l = AccountName.size();
			int index = 0;
			String AccountNameList = null;
			for (int i = 0; i < l; i++) {
				AccountNameList = AccountName.get(i).getText();
				if (AccountNameList.equalsIgnoreCase(SelectedAccountName)) {
					index++;
					clickOnElement(AccountName.get(i));
					break;
				}
			}
			String xpath1 = "//XCUIElementTypeStaticText[@name='Primary source of fund']";
			List<RemoteWebElement> list1 = driver.findElements(By.xpath(xpath1));
			if (list1.size() > 0) {
				androidAlert.AlertHandlingWithButtonMessage(IOShomePgaeObject.okButton(),CommonTestData.PRIMARY_SOURCE_ALERT_TITLE.getEnumValue(),
						IOShomePgaeObject.primarysourceOfFund());
		
			} }}catch (Exception e) {
				e.printStackTrace(); throw e;
			}

		}
	@Step("Verify 'SGD Currency Field' andIOShomePgaeObject Enter Amount '11'")
	public void enterAmountAndVerifySgdCurrency(String Amount) throws Exception {
		try {
			fieldText(CommonTestData.SGD_CURRENCY_LABEL.getEnumValue(), IOShomePgaeObject.sgdText());
			enterTextInTextbox(IOShomePgaeObject.amountField(), Amount);
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			doneButtonIfAviliable();
			ClickOnNextButton();
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}

	}
	@Step(" Verifying page header 'Review Transfer' And Click on 'TRANSFER NOW' Button")
	public void verifyReviewTransferAndClickTransferNowButton() throws Exception {
		try {
			fieldText(CommonTestData.REVIEW_TRANSFER_LABEL.getEnumValue(), IOShomePgaeObject.reviewTransfer());
			ButtonLabelVerifyClick(IOShomePgaeObject.transferNowButton(), CommonTestData.TRANSFER_NOW_BUTTON.getEnumValue());
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}

	}
	@Step(" Verifying page header 'Transferred' And Generated Reference Number")
	public void verifyTransferredAndReferenceNumberField() throws Exception {
		try {
			fieldText(CommonTestData.TRANSFER_TITLE.getEnumValue(), IOShomePgaeObject.transferredTitle());
			ButtonVerifyClick(IOShomePgaeObject.expandButton2());
			gestUtils.scrollUPtoObject("name", "Reference No.", IOShomePgaeObject.referenceNo());
			fieldText(CommonTestData.REFERENCE_NUMBER.getEnumValue(), IOShomePgaeObject.referenceNo());
			boolean i= IOShomePgaeObject.referenceNoValue().getText().isEmpty();
			Asserts.assertTrue(i==false, "Reference Number not Found");
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
	}
	@Step("Back to Home page from Transaction History statement")
	public void BackToHomeFromFundTransfer() throws Exception {
		try {
			ButtonVerifyClick(IOShomePgaeObject.closeButton2());
			ButtonVerifyClick(IOShomePgaeObject.homeButton());
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);

		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
	}
	@Step("Verify Account Type , Account Name, Currency display and displayed Amount under Account Section")
	public void verifyAccountTypeNameCurrencyAmount(String AccountType,String AccountName, String currency ) throws Exception {
		try {
			
			//VerifyButtonLabelAndClick(DBSappObject.accountSectionHomePage(), CommonTestData.ACCOUNT_SECTION.getEnumValue());
			//gestUtils.scrollUPtoObject("text", "digiPortfolio", null);
			//TakeScreenshot(DBSappObject.depositeHomePage());
			fieldText(AccountType, IOShomePgaeObject.depositeHomepage());
			fieldText(AccountName, IOShomePgaeObject.accountNameHomepage());
			String fag=IOShomePgaeObject.sgdHomepage().getText();
			String[] arrOfStr = fag.split(" ");
			Asserts.assertEquals(arrOfStr[0],
					currency, currency + " is not present");
			int size=arrOfStr.length;
			Asserts.assertTrue(size>2, "Reference Number not Found");
			
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}
	@Step("Verifies Remittance Corridor")
	public void VerifyRemittanceCorridor() throws Exception {
		try {
			ClickOnPayAndTransferButton();
			EnterPasscodeAndDone();
			overseasVerifyClick(CommonTestData.OVERSEAS_ICON.getEnumValue());
			SelectingPayeeAfterSelectingOverseas(CommonTestData.PAYEE_NAME_CORRIDOR.getEnumValue());
			selectFundSourceAndSelectAccountForCorredor(CommonTestData.SOURCE_ACCOUNT_NAME_CORRIDOR.getEnumValue());
			pressEnterKeyAfterEnteringAmount(CommonTestData.CORRIDOR_AMOUNT.getEnumValue());
			gestUtils.scrollUPtoObject("name", "NEXT",  null);
			selectPurposeAccountTypeMobileNumberIfAvaliable("Savings","Personal Gifts","9999999990");
			ClickOnNextBtnAndVerifiesReviewTransferPage();
			ClickOnTransferNowBtnAndVerifiesTransferSubmittedMsg(CommonTestData.TRANSFER_SUBMITTED_MSG.getEnumValue());
			ClickOnImageExpandBtnAndVerifiesReferenceNumberText();
			ClickOnShareTransferDetailsBtnAndVerifiesReferenceNumberText();
			BackToHomeFromRemittenceCoridor();
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
	}
	@Step("Verifies Overseas Transfer Page Header on the top & Select Payee and fund source from Overseas Transfer page.")
	public void SelectingPayeeAfterSelectingOverseas(String valueSelectedFromList) throws Exception {
		try {
			//overseasVerifyClick(CommonTestData.OVERSEAS_ICON.getEnumValue());
			fieldText(CommonTestData.OVERSEAS_TRANSFER_PAGEHEADER.getEnumValue().toLowerCase(),IOShomePgaeObject.overseaTitle());
			List<MobileElement> Elementlist = IOShomePgaeObject.commonList();
			int l = Elementlist.size();
			int index = 0;
			String OverseaRecipientList = null;
			for (int i = 0; i < l; i++) {
				OverseaRecipientList = Elementlist.get(i).getText();
				if (OverseaRecipientList.contains(valueSelectedFromList)) {
					index++;
					clickOnElement(Elementlist.get(i));
					break;
				}
			}
			Asserts.assertTrue(index>0, "No element found in the list of corresponding value");
			
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
	}
	@Step("Click on 'Select Fund Source' and Select Account")
	public void selectFundSourceAndSelectAccountForCorredor(String SelectedAccountName) throws Exception {
		try {
			TakeScreenshot(IOShomePgaeObject.amountFieldInOversea());
			String xpath = "//XCUIElementTypeStaticText[@name='Select Fund Source']";
			List<RemoteWebElement> list = driver.findElements(By.xpath(xpath));
			
			if (list.size() > 0) {
				ButtonLabelVerifyClick(IOShomePgaeObject.selectfundSource(), CommonTestData.SELECT_SOURCE_FUND.getEnumValue());
			TakeScreenshot(IOShomePgaeObject.commonList().get(0));
			List<MobileElement> AccountName = IOShomePgaeObject.commonList();
			int l = AccountName.size();
			int index = 0;
			String AccountNameList = null;
			for (int i = 0; i < l; i++) {
				AccountNameList = AccountName.get(i).getText();
				if (AccountNameList.contains(SelectedAccountName) ) {// && AccountNumberList.equalsIgnoreCase(SelectedAccountNumber)
					index++;
					clickOnElement(AccountName.get(i));
					break;
				}
			}
			
			String xpath1 = "//XCUIElementTypeStaticText[@name='Primary source of fund']";
			List<RemoteWebElement> list1 = driver.findElements(By.xpath(xpath1));
			if (list1.size() > 0) {
				androidAlert.AlertHandlingWithButtonMessage(IOShomePgaeObject.okButton(),CommonTestData.PRIMARY_SOURCE_ALERT_TITLE.getEnumValue(),
						IOShomePgaeObject.primarysourceOfFund());
		
			} 
			}
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}

	}
	@Step("Press enter key after Entering Amount.")
	public void pressEnterKeyAfterEnteringAmount(String Amt) throws Exception {
		try {
			clickOnElement(IOShomePgaeObject.amountFieldInOversea());
			enterTextInTextbox(IOShomePgaeObject.amountFieldInOversea(), Amt);
			doneButtonIfAviliable();
			TakeScreenshot(IOShomePgaeObject.exchangeRate());
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
	}
	@Step("Verifies Review Transfer Page Header after clicking on Next Button.")
	public void ClickOnNextBtnAndVerifiesReviewTransferPage() throws Exception {
		try {
			
			ClickOnNextButton();
			fieldText(CommonTestData.REVIEW_TRANSFER.getEnumValue(), IOShomePgaeObject.reviewTransfer());
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
	}
	@Step("Verifies Transfer Submitted Message after clicking on Transfer Now Button.")
	public void ClickOnTransferNowBtnAndVerifiesTransferSubmittedMsg(String SuccessMsg) throws Exception {
		try {
			ButtonVerifyClick( IOShomePgaeObject.transferNowButton());
		    fieldText(SuccessMsg, IOShomePgaeObject.transferSubmittedLabel());
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
	}
	@Step("Verifies Reference Number Text after clicking on Image Expand Button.")
	public void ClickOnImageExpandBtnAndVerifiesReferenceNumberText() throws Exception {
		try {
			
			ButtonVerifyClick(IOShomePgaeObject.downwardArrowInTopUpDonePage());
			gestUtils.scrollUPtoObject("name", "Reference No.", IOShomePgaeObject.referenceNo());
			fieldText(CommonTestData.REFERENCE_NUMBER.getEnumValue(), IOShomePgaeObject.referenceNo());
			boolean i= IOShomePgaeObject.referenceNoValueInOversea().getText().isEmpty();
			Asserts.assertTrue(i==false, "Reference Number not Found");
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
	}
	@Step("Verifies Overseas transfer Message after clicking on Share Transfer Details Button.")
	public void ClickOnShareTransferDetailsBtnAndVerifiesReferenceNumberText() throws Exception {
		try {
			gestUtils.scrollUPtoObject("name", "SHARE TRANSFER DETAILS", null);
			ButtonVerifyClick(IOShomePgaeObject.shareTransferDetailButton());
			fieldText("Transfer Details",IOShomePgaeObject.transferDetailLabel());
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
	}
	@Step("Back to Home page from Transaction History statement")
	public void BackToHomeFromRemittenceCoridor() throws Exception {
		try {
			ButtonVerifyClick(IOShomePgaeObject.backButtontransferDetailLabel());
			ButtonVerifyClick(IOShomePgaeObject.closeIconInOversea());
			ButtonVerifyClick(IOShomePgaeObject.homeButton());
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);

		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
	}
	public void selectPurposeAccountTypeMobileNumberIfAvaliable(String AccountType,String purpose,String MobileNo) throws Exception//"Savings""Personal Gifts""9999999990"
	{
		try {
			String xpath_account = "//XCUIElementTypeStaticText[contains(@name,'account type')]";
			List<RemoteWebElement> list = driver.findElements(By.xpath(xpath_account));
		if (list.size() > 0) {
			selectAccountType(AccountType);
		}
		String xpath_purpose = "//XCUIElementTypeStaticText[contains(@name,'purpose')]";
		List<RemoteWebElement> list1 = driver.findElements(By.xpath(xpath_purpose));
		if (list1.size() > 0) {
			selectPurpose(purpose);
		}
		String xpath = "//XCUIElementTypeTextField[contains(@value,'Mobile')]";
		List<RemoteWebElement> list2 = driver.findElements(By.xpath(xpath));
		if (list2.size() > 0) {
			enterMobileNo(MobileNo);
			
		}
		
	}
	 catch (Exception e) {
		 e.printStackTrace();
			throw e;
	}
	
}
	@Step("Select AccountType")
	public void selectAccountType(String AccountType) throws Exception//"Savings"
	{
		try {
			ButtonVerifyClick(IOShomePgaeObject.selectAccountType());
			List<MobileElement> Elementlist = IOShomePgaeObject.commonList();
			TakeScreenshot(IOShomePgaeObject.commonList().get(0));
		} catch (Exception e) {
			e.printStackTrace(); throw e;
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
			e.printStackTrace(); throw e;
		}
	}
	
	@Step("Click On Transfer Now Button And Verify Payment Submitted Message.")
	public void ClickOnTransferNowBtnAndVerifyPaymentSubmittedMsg() throws Exception {
		try {
			TakeScreenshot(IOShomePgaeObject.TransferNowButton());
			clickOnElement(IOShomePgaeObject.TransferNowButton());
			
			// verifies the payment completion with expected amount.
			TakeScreenshot(IOShomePgaeObject.SuccessImage().get(3));
			if (isElementVisible(IOShomePgaeObject.SuccessImage().get(3))) {
				Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.PaymentSubmittedMsg()),
						CommonTestData.PAYMENT_SUBMITTED.getEnumValue(),
						CommonTestData.PAYMENT_SUBMITTED.getEnumValue() + " Text is not matching");

				Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.AmountEditableField()),
						CommonTestData.AMOUNTTO_TRANSFERFUND.getEnumValue() + ".00",
						CommonTestData.AMOUNTTO_TRANSFERFUND.getEnumValue() + " Text is not matching.");
			}
		} catch (Exception e) {
			e.printStackTrace(); 
			throw e;
		}
	}
	
	@Step("Verifies the 'Log out', 'Make Another Transfer' Button, 'Share Payment Details' Button.")
	public void VerifyVisibiltyOfSomeElements_FundTransferCreditCard() throws Exception {
		try {
			Asserts.assertTrue(IOShomePgaeObject.LogoutBtn().isDisplayed(), "Log Out Button not found.");
			//add scroll
			//gestUtils.scrollUPtoObject("text", "MAKE ANOTHER TRANSFER", DBSappObject.MakeAnotherTransferBtn());
			Asserts.assertTrue(IOShomePgaeObject.MakeAnotherPaymentBtn().isDisplayed(),
					"Make Another Transfer Button not found.");
			Asserts.assertTrue(IOShomePgaeObject.SharePaymentDetailsButton().isDisplayed(),
					"'Share Payment Details' Button not found.");
			
			Asserts.assertTrue(IOShomePgaeObject.closeButton().isDisplayed(),
					"'Close' Button not found.");
			
			clickOnElement(IOShomePgaeObject.FooterExpandableBtn());
			
			//gestUtils.scrollUPtoObject("text", "Reference No.", IOShomePgaeObject.referenceNo());
			TakeScreenshot(IOShomePgaeObject.referenceNo());

		} catch (Exception e) {
			e.printStackTrace(); 
			throw e;
		}
	}
	
	@Step("Click on 'To Account Credit Card' after selecting 'Credit Cards' and verify pageHeader")
	public void clickingOnAccountTypeInCreditCard(String valueSelectedFromList) throws Exception {
		try {
			
			int o = 0;
			for (int i = 0; i < IOShomePgaeObject.allTabList().size(); i++) {
				String tabText = IOShomePgaeObject.allTabList().get(i).getText();
				o++;
				if (tabText.contains(CommonTestData.CREDIT_CARDS_TAB.getEnumValue())) {
					clickOnElement(IOShomePgaeObject.allTabList().get(i));
					break;
				}
			}

			gestUtils.DragAndDropElementToElement(IOShomePgaeObject.allTabList().get(o), IOShomePgaeObject.AllTab());
			TakeScreenshot(IOShomePgaeObject.localRecipientsList().get(0));
			List<MobileElement> Elementlist = IOShomePgaeObject.localRecipientsList();
			int l = Elementlist.size();
			int index = 0;
			String LocalRecipientList = null;
			for (int i = 0; i < l; i++) {
				LocalRecipientList = Elementlist.get(i).getText();
				if (LocalRecipientList.equalsIgnoreCase(valueSelectedFromList)) {
					index++;
					clickOnElement(Elementlist.get(i));
					break;
				}
			}
			Asserts.assertTrue(index > 0, "No element found in the list of corresponding value");

			Thread.sleep(3000);
			String xpath1 = "//XCUIElementTypeStaticText[@name='Primary source of fund']";
			List<RemoteWebElement> list1 = driver.findElements(By.xpath(xpath1));
			if (list1.size() > 0) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				if (isElementVisible(IOShomePgaeObject.primarysourceOfFund()))
					clickOnElement(IOShomePgaeObject.okButton());
			}
			
			Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.CreditCard_PageHeader()),
					CommonTestData.CREDIT_CARD_PAGEHEADER.getEnumValue(),
					CommonTestData.CREDIT_CARD_PAGEHEADER.getEnumValue() + " Text is not matching");
			
			
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
	}
		@Step("Select purpose")
		public void selectPurpose(String purpose) throws Exception//"Personal Gifts"
		{
			try {
				ButtonVerifyClick(IOShomePgaeObject.selectPurposeType());
				List<MobileElement> Elementlist = IOShomePgaeObject.commonList();
				TakeScreenshot(IOShomePgaeObject.commonList().get(0));
				int l = Elementlist.size();
				int index = 0;
				String LocalRecipientList = null;
				for (int i = 0; i < l; i++) {
					LocalRecipientList = Elementlist.get(i).getText();
					if (LocalRecipientList.contains(purpose)) {
						index++;
						clickOnElement(Elementlist.get(i));
						break;
					}
				}
				Asserts.assertTrue(index > 0, "No element found in the list of corresponding value");
				wait.waitForElementVisibility(IOShomePgaeObject.overseaTitle());
			}
		 catch (Exception e) {
			 e.printStackTrace();
				throw e;
		}
	
}
		@Step("enter mobile No.")
		public void enterMobileNo(String MobileNo) throws Exception
		{
			try {
				TakeScreenshot(IOShomePgaeObject.enterMobileNo());
				enterTextInTextbox(IOShomePgaeObject.enterMobileNo(), MobileNo);
				wait.waitForElementVisibility(IOShomePgaeObject.overseaTitle());
			}
		 catch (Exception e) {
			 e.printStackTrace();
				throw e;
		}
	
}
		@Step("Verifies Remittance eOTT")
		public void VerifyRemittanceEOTT() throws Exception {
			try {
				ClickOnPayAndTransferButton();
				EnterPasscodeAndDone();
				SelectAllTAB();
				ButtonVerifyClick(IOShomePgaeObject.searchBoxInPayAndTransfer());
				String ExpectedEottName = CommonTestData.EOTTREMITTANCE_NAME.getEnumValue();
				enterTextInTextbox(IOShomePgaeObject.searchBoxInPayAndTransfer(), ExpectedEottName);
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				pressKey(driver, Keys.ENTER);
				String xpath = "//android.widget.TextView[@text='" + ExpectedEottName + "']";
				MobileElement ExpectedEottEle = (MobileElement) driver.findElement(By.xpath(xpath));
				isElementVisible(ExpectedEottEle);
				clickOnElement(ExpectedEottEle);
				fieldText(CommonTestData.OVERSEAS_TRANSFER_PAGEHEADER.getEnumValue(), IOShomePgaeObject.overseaTitle());
				selectFundSourceAndSelectAccountForCorredor(CommonTestData.EOTTREMITTANCE_NAME.getEnumValue());
				pressEnterKeyAfterEnteringAmount(CommonTestData.eOTT_AMOUNT.getEnumValue());
				gestUtils.scrollUPtoObject("name", "Next", null);
				selectPurposeAccountTypeMobileNumberIfAvaliable(null,CommonTestData.PURPOSE_OF_TRANSFER_TEXT.getEnumValue(),null);
				ClickOnNextBtnAndVerifiesReviewTransferPage();
				ClickOnTransferNowBtnAndVerifiesTransferSubmittedMsg(CommonTestData.TRANSFER_SUBMITTED_MSG.getEnumValue());
				ClickOnImageExpandBtnAndVerifiesReferenceNumberText();
				ClickOnShareTransferDetailsBtnAndVerifiesReferenceNumberText();
				BackToHomeFromRemittenceCoridor();
				
			} catch (Exception e) {
				e.printStackTrace(); throw e;
			}
		}
		@Step("Select All TAB.")
		public void SelectAllTAB() throws Exception {
			try {
				ButtonVerifyClick(IOShomePgaeObject.allTab());
			} catch (Exception e) {
				e.printStackTrace(); throw e;
			}
		}
		@Step("Verify CreditCard Temperary Limit Increase")
		public void CreditCardTempLimitIncrease() throws Exception {
			try {
				ClickOnMoreButton();
				EnterPasscodeAndDone();
				sendDataInCommonSearchBoxAndSelectFromDropDown(CommonTestData.TEMP_LIMIT_INCREASE.getEnumValue(), CommonTestData.TEMP_LIMIT_INCREASE.getEnumValue());
				fieldText(CommonTestData.TEMP_LIMIT_INCREASE.getEnumValue(), IOShomePgaeObject.temporaryLimitIncreaseHeader());
				setAmountDurationPurposeForLimitIncrease("100", "wedding");
				gestUtils.scrollUPtoObject("name", "NEXT", null );
				ClickOnNextButton();
				fieldText(CommonTestData.REVIEW_APPLICATION_CREDITLIMIT_TITLE.getEnumValue(),IOShomePgaeObject.reviewApplicationHeader());
				 
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
		@Step("Enter amount , duration and purposed for creditLimit Increase")
		public void setAmountDurationPurposeForLimitIncrease(String Amount, String purpos) throws Exception {
			try {
				if (isElementEnable(IOShomePgaeObject.additionalCreditLimit()))
					enterTextInTextbox(IOShomePgaeObject.additionalCreditLimit(), Amount);
				fieldText(CommonTestData.TEMP_LIMIT_INCREASE.getEnumValue(), IOShomePgaeObject.temporaryLimitIncreaseHeader());
				ButtonVerifyClick( IOShomePgaeObject.purposeCreditLimit());
				fieldText(CommonTestData.PURPOSE_HEADER_IOS.getEnumValue(), IOShomePgaeObject.selectPurpose());
				List<MobileElement> Elementlist = IOShomePgaeObject.commonList();
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
				
				fieldText(CommonTestData.TEMP_LIMIT_INCREASE.getEnumValue(), IOShomePgaeObject.temporaryLimitIncreaseHeader());
				ButtonVerifyClick( IOShomePgaeObject.durationCreditLimit());
				fieldText(CommonTestData.CALENDER_HEADER.getEnumValue(), IOShomePgaeObject.calenderTemporaryLimitIncreaseHeader());
				ButtonVerifyClick( IOShomePgaeObject.calenderDateOctEleven());
				ButtonVerifyClick( IOShomePgaeObject.confirmButton());
				fieldText(CommonTestData.TEMP_LIMIT_INCREASE.getEnumValue(), IOShomePgaeObject.temporaryLimitIncreaseHeader());
				
			} catch (Exception e) {
				e.printStackTrace(); throw e;
			}
		}





//			Thread.sleep(3000);
//			String xpath1 = "//XCUIElementTypeStaticText[@name='Primary source of fund']";
//			List<RemoteWebElement> list1 = driver.findElements(By.xpath(xpath1));
//			if (list1.size() > 0) {
//				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
//				if (isElementVisible(IOShomePgaeObject.primarysourceOfFund()))
//					clickOnElement(IOShomePgaeObject.okButton());
//			}
		
	
	@Step("Click on Account after selecting 'Local Recipients' and verify pageHeader")
	public void clickingOnAccountTypeInLocalRecipient(String valueSelectedFromList) throws Exception {
		try {
			int o = 0;
			for (int i = 0; i < IOShomePgaeObject.allTabList().size(); i++) {
				String tabText = IOShomePgaeObject.allTabList().get(i).getText();
				o++;
				if (tabText.contains(CommonTestData.LOCAL_RECIPIENT_FROMLIST.getEnumValue())) {
					clickOnElement(IOShomePgaeObject.allTabList().get(i));
					break;
				}
			}

			gestUtils.DragAndDropElementToElement(IOShomePgaeObject.allTabList().get(o), IOShomePgaeObject.AllTab());
			TakeScreenshot(IOShomePgaeObject.localRecipientsList().get(0));
			List<MobileElement> Elementlist = IOShomePgaeObject.localRecipientsList();
			int l = Elementlist.size();
			int index = 0;
			String LocalRecipientList = null;
			for (int i = 0; i < l; i++) {
				LocalRecipientList = Elementlist.get(i).getText();
				if (LocalRecipientList.equalsIgnoreCase(valueSelectedFromList)) {
					index++;
					clickOnElement(Elementlist.get(i));
					break;
				}
			}
			Asserts.assertTrue(index > 0, "No element found in the list of corresponding value");

			Thread.sleep(3000);
			String xpath1 = "//XCUIElementTypeStaticText[@name='Primary source of fund']";
			List<RemoteWebElement> list1 = driver.findElements(By.xpath(xpath1));
			if (list1.size() > 0) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				if (isElementVisible(IOShomePgaeObject.primarysourceOfFund()))
					clickOnElement(IOShomePgaeObject.okButton());
			}

		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
	}
	
	@Step("Verifies the Payee Add Bill Payment and after completion payment verifies the transfering amount.")
	public void PayeeAddBillPayment() throws Exception {
		try {
			ClickOnPayAndTransferButton();
			EnterPasscodeAndDone();
			ClickOnBillModuleAndClickOnAddBillingOrganisation();
			EnterBillingOrganisationDetails(CommonTestData.PAYEEADD_BILLPAYMENT_ACCOUNTNAME.getEnumValue(),
					CommonTestData.PAYEEADD_BILLPAYMENT_REFERENCENUMBER.getEnumValue());
			ClickOnNextButton();
			Thread.sleep(2000);
			Asserts.assertTrue(isElementVisible(IOShomePgaeObject.ReviewRecipientDetailsPageHeader()),
					CommonTestData.REVIEW_RECIPIENT_DETAILS.getEnumValue() + " Page Header not displaying.");
			VerifyBillingOrganisationAndBillReferenceNumber(
					CommonTestData.PAYEEADD_BILLPAYMENT_ACCOUNTNAME.getEnumValue(),
					CommonTestData.PAYEEADD_BILLPAYMENT_REFERENCENUMBER.getEnumValue());
			ClickOnAddRecipientNowBtn();
			VerifyYouHaveAddedRecipientMsgAfterEnterSecurePIN();
			VerifyBillingOrganisationAndBillReferenceNumber(
					CommonTestData.PAYEEADD_BILLPAYMENT_ACCOUNTNAME.getEnumValue(),
					CommonTestData.PAYEEADD_BILLPAYMENT_REFERENCENUMBER.getEnumValue());
			
			Asserts.assertTrue(IOShomePgaeObject.LogoutBtn().isDisplayed(), "Log Out Button not found.");
			Asserts.assertTrue(IOShomePgaeObject.MakeAPaymentButton().isDisplayed(),
					"Make A Payment Button not found.");
			Asserts.assertTrue(IOShomePgaeObject.closeButton().isDisplayed(), "Close Button not found.");
			ClickOnMakeAPaymentAndEnterAmountInAmountEditField();
			ClickOnNextButton();
			Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.ReviewPaymentPageHeader()),
					CommonTestData.REVIEW_PAYMENT_PAGEHEADER.getEnumValue(),
					CommonTestData.REVIEW_PAYMENT_PAGEHEADER.getEnumValue() + " Text is not matching");
			ClickOnTransferNowBtnAndVerifyPaymentSubmittedMsg();

			// Leave On Home Page to this test case for next run.
			ClickOnCloseButton();
			ClickOnHomeButton();
		} catch (Exception e) {
			e.printStackTrace();
            throw e;
		}
	}
	
	
	@Step("Delete Payee to Bill Payment.")
	public void DeletePayee_ToBillPayment() throws Exception {
		try {
			ClickOnPayAndTransferButton();
			EnterPasscodeAndDone();
			TakeScreenshot(IOShomePgaeObject.BillsButton());
			clickOnElement(IOShomePgaeObject.BillsButton());
			DeletePayee(CommonTestData.PAYEEADD_BILLPAYMENT_REFERENCENUMBER.getEnumValue());
			
			// Leave On Home Page to this test case for next run.
			ClickOnCloseButton();
			ClickOnHomeButton();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	} 
	
	@Step("Click On Bill Module & Verify Enter Recipient Page Header After Click On Add Billing Organisation.")
	public void ClickOnBillModuleAndClickOnAddBillingOrganisation() throws Exception {
		try {
			TakeScreenshot(IOShomePgaeObject.BillsButton());
			clickOnElement(IOShomePgaeObject.BillsButton());

			String xpath = "//XCUIElementTypeButton[@name='ADD RECIPIENT NOW']";
			List<RemoteWebElement> list = driver.findElements(By.xpath(xpath));
			if (list.size() > 0) {
				TakeScreenshot(IOShomePgaeObject.AddRecipientNowButton());
				clickOnElement(IOShomePgaeObject.AddRecipientNowButton());
			} else {
				TakeScreenshot(IOShomePgaeObject.AddBillingOrganisation());
				clickOnElement(IOShomePgaeObject.AddBillingOrganisation());
			}
			Asserts.assertTrue(isElementVisible(IOShomePgaeObject.EnterRecipientDetailsPageHeader()),
					" 'Enter Recipient's Details' Page Header not displaying.");
		} catch (Exception e) {
			e.printStackTrace(); 
			throw e;
		}
	}
	
	@Step("Enter Billing Organisation Details.")
	public void EnterBillingOrganisationDetails(String AccountName, String ReferenceNo) throws Exception {
		try {
			TakeScreenshot(IOShomePgaeObject.SelectBillingOrganisation());
			clickOnElement(IOShomePgaeObject.SelectBillingOrganisation());
			clickOnElement(IOShomePgaeObject.SearchForBillingOrganisationField());
			enterTextInTextbox(IOShomePgaeObject.SearchForBillingOrganisationField(), AccountName);
			String xpath = "//XCUIElementTypeTextField[@name='"+AccountName+"']";
			MobileElement SelectBillingOrganisation = (MobileElement) driver.findElement(By.xpath(xpath));
			clickOnElement(SelectBillingOrganisation);
			clickOnElement(IOShomePgaeObject.EnterReferenceNoEditField());
			enterTextInTextbox(IOShomePgaeObject.EnterReferenceNoEditField(), ReferenceNo);
			backButton();
		} catch (Exception e) {
			e.printStackTrace(); 
			throw e;
		}
	}
	
	@Step("Verifies Billing Organisation And Bill Reference Number.")
	public void VerifyBillingOrganisationAndBillReferenceNumber(String AccountName, String ReferenceNum)
			throws Exception {
		try {
			Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.PayeeBillPaymentDetailsList().get(0)), AccountName,
					AccountName + " Text is not matching");
			Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.PayeeBillPaymentDetailsList().get(1)), "Billing Organisation",
					"Billing Organisation" + " Text is not matching");
			Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.PayeeBillPaymentDetailsList().get(2)), ReferenceNum,
					ReferenceNum + " Text is not matching");
			Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.PayeeBillPaymentDetailsList().get(3)), "Bill Reference No.",
					"Bill Reference No." + " Text is not matching");
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
	}
	
	@Step("Click On Make A Payment Button And Enter Amount In Amount Edit Field.")
	public void ClickOnMakeAPaymentAndEnterAmountInAmountEditField() throws Exception {
		try {
			TakeScreenshot(IOShomePgaeObject.MakeAPaymentButton()); 
			clickOnElement(IOShomePgaeObject.MakeAPaymentButton());
			TakeScreenshot(IOShomePgaeObject.PayToBillerPageHeader()); 
			Asserts.assertTrue(isElementVisible(IOShomePgaeObject.PayToBillerPageHeader()),
					CommonTestData.PAY_TO_BILLER_PAGE_HEADER.getEnumValue() + " Page Header not displaying.");
			
			EnterAmount(IOShomePgaeObject.AmountEditableField(), CommonTestData.AMOUNTTO_TRANSFERFUND.getEnumValue());
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
	}
	
	@Step("Verify Fund Transfer For Own Account.")
	public void VerifyFundTransfer_OwnAccount() throws Exception {
		try {
			ClickOnPayAndTransferButton();
			EnterPasscodeAndDone();
			SelectAllTAB();
			SelectOWNAccountAndAnyAccountOption(CommonTestData.FUNDTRANSFER_TO_OWN_ACCOUNT_NUMBER.getEnumValue());
			String ExpectedFromAccountName = CommonTestData.FUNDTRANSFER_FROM_OWN_ACCOUNT_NAME.getEnumValue();
			SelectFundSourceAccount(ExpectedFromAccountName);
			
			EnterAmount(IOShomePgaeObject.AmountEditableField(), CommonTestData.AMOUNTTO_TRANSFERFUND.getEnumValue());
			ClickOnNextButton();
			Asserts.assertTrue(isElementVisible(IOShomePgaeObject.ReviewTransferPageHeader()),
					CommonTestData.REVIEW_TRANSFER.getEnumValue() + " Page Header not displaying.");

			ClickOnTransferNowBtnAndVerifiesTransferSubmittedMsg(CommonTestData.TRANSFERRED.getEnumValue(),
					IOShomePgaeObject.SuccessImage().get(0), IOShomePgaeObject.TransferredMsg()); 
			
			VerifyAccountDetailsAfterFundTransferToOwnAccount();
			
			//Leaving On Home page for next case run.
			clickOnElement(IOShomePgaeObject.BackToHomeButton()); 
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
	}
	
	@Step("Verify Account Details After Fund Transfer To Own Account.")
	public void VerifyAccountDetailsAfterFundTransferToOwnAccount() throws Exception {
		try {
			Asserts.assertTrue(IOShomePgaeObject.LogoutBtn().isDisplayed(), "Log Out Button not matching.");
			Asserts.assertTrue(IOShomePgaeObject.BackToHomeButton().isDisplayed(), "BACK To HOME Button not found.");
			Asserts.assertTrue(IOShomePgaeObject.MakeAnotherTransferButton().isDisplayed(),
					"MAKE ANOTHER TRANSFER Button not found.");
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
	}

	
	@Step("Verifies Transfer Submitted Message after clicking on Transfer Now Button.")
	public void ClickOnTransferNowBtnAndVerifiesTransferSubmittedMsg(String SuccessMsg, MobileElement successImage,
			MobileElement transfferdSubmitMsgEle) throws Exception {
		try {
			clickOnElement(IOShomePgaeObject.TRANSFERNOWButton());
			TakeScreenshot(successImage);
			if (isElementVisible(successImage))
				Asserts.assertEquals(getTexOfElement(transfferdSubmitMsgEle), SuccessMsg,
						SuccessMsg + " Text is not matching");
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
	}
	
	@Step("Select 'Your DBS/POSB Accounts' and then verify 'Transfer to Your Account' Page header after selecting any own account option.")
	public void SelectOWNAccountAndAnyAccountOption(String ToOwnAccount) throws Exception {
		try {
			clickOnElement(IOShomePgaeObject.SelectOwnAccount());
			String xpath = "//XCUIElementTypeStaticText[@name='"+ ToOwnAccount + "']";
			MobileElement ToAccountNo = (MobileElement) driver.findElement(By.xpath(xpath));
			clickOnElement(ToAccountNo);
			TakeScreenshot(IOShomePgaeObject.TransferToOwnAccountPageHeader());
			Asserts.assertTrue(isElementVisible(IOShomePgaeObject.TransferToOwnAccountPageHeader()),
					CommonTestData.TRANSFER_TO_YOUR_ACCOUNT.getEnumValue() + " Page Header not displaying.");
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
	}
	
	@Step("Verify Fund Transfer Bill Payment.")
	public void FundsTransfer_BillPayment() throws Exception {
		try {
			ClickOnPayAndTransferButton();
			EnterPasscodeAndDone();
			SelectAllTAB();
			String ExpectedToBankNameWithAccountNo = CommonTestData.FUNDTRANSFER_BillPayment_TO_ACCOUNTNUMBER_WITHBANK
					.getEnumValue();
			clickingOnAccountTypeInBillingOrganisations(ExpectedToBankNameWithAccountNo);
			EnterAmount(IOShomePgaeObject.AmountEditableField(), CommonTestData.AMOUNTTO_TRANSFERFUND.getEnumValue());
			String ExpectedSelectedDate = getTexOfElement(IOShomePgaeObject.TransferDateTextElement());
			Asserts.assertEquals("Immediate", ExpectedSelectedDate, "Selected Date is not Matching");

			ClickOnNextButton();
			Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.ReviewPaymentPageHeader()),
					CommonTestData.REVIEW_PAYMENT_PAGEHEADER.getEnumValue(),
					CommonTestData.REVIEW_PAYMENT_PAGEHEADER.getEnumValue() + " Text is not matching");
			ClickOnTransferNowBtnAndVerifyPaymentSubmittedMsg();

			// Leave On Home Page to this test case for next run.
			ClickOnCloseButton();
			ClickOnHomeButton();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Step("Click on 'To Account Bill' after selecting 'Billing organisation' and verify Page Header")
	public void clickingOnAccountTypeInBillingOrganisations(String valueSelectedFromList) throws Exception {
		try {
			int o = 0;
			for (int i = 0; i < IOShomePgaeObject.allTabList().size(); i++) {
				String tabText = IOShomePgaeObject.allTabList().get(i).getText();
				o++;
				if (tabText.contains(CommonTestData.BILLING_ORGANISATIONS_TAB.getEnumValue())) {
					clickOnElement(IOShomePgaeObject.allTabList().get(i));
					break;
				}
			}

			gestUtils.DragAndDropElementToElement(IOShomePgaeObject.allTabList().get(o), IOShomePgaeObject.AllTab());
			TakeScreenshot(IOShomePgaeObject.localRecipientsList().get(0));
			List<MobileElement> Elementlist = IOShomePgaeObject.localRecipientsList();
			int l = Elementlist.size();
			int index = 0;
			String LocalRecipientList = null;
			for (int i = 0; i < l; i++) {
				LocalRecipientList = Elementlist.get(i).getText();
				if (LocalRecipientList.equalsIgnoreCase(valueSelectedFromList)) {
					index++;
					clickOnElement(Elementlist.get(i));
					break;
				}
			}
			Asserts.assertTrue(index > 0, "No element found in the list of corresponding value");

			Thread.sleep(3000);
			String xpath1 = "//XCUIElementTypeStaticText[@name='Primary source of fund']";
			List<RemoteWebElement> list1 = driver.findElements(By.xpath(xpath1));
			if (list1.size() > 0) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				if (isElementVisible(IOShomePgaeObject.primarysourceOfFund()))
					clickOnElement(IOShomePgaeObject.okButton());
			}
			
			
			Asserts.assertTrue(isElementVisible(IOShomePgaeObject.PayToBillerPageHeader()),
					CommonTestData.PAY_TO_BILLER_PAGE_HEADER.getEnumValue() + " Page Header not displaying.");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
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
		    Asserts.assertTrue(isElementVisible(IOShomePgaeObject.ReviewApplicationPageHeader()),
						CommonTestData.REVIEW_APPLICATION.getEnumValue() + " Page Header not displaying.");
			

			//gestUtils.scrollUPtoObject("text", "NEXT", IOShomePgaeObject.nextButton());
		    ClickOnNextButton();
			ClickOnSubmitButtonAfterSettingCardPIN();
			
			// Leave On Home Page to this test case for next run.
			ClickOnCloseButton();
			ClickOnHomeButton();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Step("Verifies the Set Card Pin Page Header and then Submit While Entering Confirm and Create New Pin & Verifies the 'Application Submitted' Message.")
	public void ClickOnSubmitButtonAfterSettingCardPIN() throws Exception {
		try {
			
			Asserts.assertTrue(isElementVisible(IOShomePgaeObject.SetCardPINPageHeader()),
							CommonTestData.SET_CARD_PIN.getEnumValue() + " Page Header not displaying.");
			
			clickOnElement(IOShomePgaeObject.CreateYourPINField());
			enterTextInTextbox(IOShomePgaeObject.CreateYourPINField(), CommonTestData.CREATE_PIN.getEnumValue());
			clickOnElement(IOShomePgaeObject.ConfirmNewPINField());
			enterTextInTextbox(IOShomePgaeObject.ConfirmNewPINField(), CommonTestData.CONFIRM_PIN.getEnumValue());
			driver.hideKeyboard();
			
			clickOnElement(IOShomePgaeObject.submitButton());
			
			Asserts.assertTrue(isElementVisible(IOShomePgaeObject.ApplicationSubmittedMessage()),
					CommonTestData.APPLICATION_SUBMITTED.getEnumValue() + " Page Header not displaying.");
			Asserts.assertTrue(IOShomePgaeObject.ThankYouMessage().isDisplayed(),CommonTestData.THANKU_MESSAGE_AFTER_APPLYDEBITCARD.getEnumValue() + " not found.");
			Asserts.assertTrue(IOShomePgaeObject.LogoutBtn().isDisplayed(), "Log Out Button not found.");
			Asserts.assertTrue(IOShomePgaeObject.BackToMoreServicesButton().isDisplayed(),
					"'Back To More Services' Button not found.");
			Asserts.assertTrue(IOShomePgaeObject.closeButton().isDisplayed(), "Close Button not found.");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("Select Debit Card Option After Clicking on Cards Section and then 2FA Authentication Done.")
	public void SelectDebitCardOptionFromCardsSectionAndAuthenticationOfSecurePIN() throws Exception {
		try {
			//gestUtils.scrollUPtoObject("text", "Cards", DBSappObject.CardsButton());
			if (isElementVisible(IOShomePgaeObject.CardsButton()))
				clickOnElement(IOShomePgaeObject.CardsButton());
			TakeScreenshot(IOShomePgaeObject.SelectDebitCard()); 
			clickOnElement(IOShomePgaeObject.SelectDebitCard());
			EnterPasscodeAndDone();
			selectDebitCardType(CommonTestData.DEBIT_CARD_NAME.getEnumValue());
			TakeScreenshot(IOShomePgaeObject.AccountToBeLinkedToTheCardField()); 
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Step("Click on 'Account type' From List under Local fund Limit page'")
	public void selectDebitCardType(String debitCardToBeSelected) throws Exception {
		try {
			TakeScreenshot(IOShomePgaeObject.DebitCardDetailsDropdownList().get(1)); 
			List<MobileElement> Elementlist = IOShomePgaeObject.DebitCardDetailsDropdownList();
			int l = Elementlist.size();
			int index = 0;
			String accountFromList = null;
			for (int i = 0; i <= l; i++) {
				accountFromList = Elementlist.get(i).getText();
				if (accountFromList.contains(debitCardToBeSelected)) {
					index++;
					clickOnElement(Elementlist.get(i));
					break;
				}
			}
			Asserts.assertTrue(index > 0, "No " + debitCardToBeSelected + " found in the list of corresponding value");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Step("Filling Required Details to applying Debit Card like as 'AccountToBeLinkedToTheCardField',"
			+ " 'Title', 'EnterNameToAppearOnTheCardField', 'Race', 'Marital Status','Residential Type',"
			+ "'Education','Economic Status','Annual Income', 'And Select Checkbox SendMeDBSPrmotionViaMail'.")
	public void FillingDetailsToApplyingDebitCard() throws Exception {
		try {
			// To filling Debit Card Details for applying Debit card.
			clickOnElement(IOShomePgaeObject.AccountToBeLinkedToTheCardField());
			TakeScreenshot(IOShomePgaeObject.AccountToBeLinkedToTheCardField()); 
			selectElementFromTheGivenList(IOShomePgaeObject.DebitCardDetailsDropdownList(),
					CommonTestData.ACCOUNT_LINKED_WITH_DEBIT_CARD.getEnumValue());

			clickOnElement(IOShomePgaeObject.TitleField());
			selectElementFromTheGivenList(IOShomePgaeObject.DebitCardDetailsDropdownList(),
					CommonTestData.TITLE.getEnumValue());

			clickOnElement(IOShomePgaeObject.EnterNameToAppearOnTheCardField());
			enterTextInTextbox(IOShomePgaeObject.EnterNameToAppearOnTheCardField(),
					CommonTestData.NAMETO_APPEAR_ON_DEBITCARD.getEnumValue());
			driver.hideKeyboard();
			TakeScreenshot(IOShomePgaeObject.EducationField()); 
			
			//gestUtils.scrollUPtoObject("text", "Education", IOShomePgaeObject.EducationField());
			
			clickOnElement(IOShomePgaeObject.RaceField());
			selectElementFromTheGivenList(IOShomePgaeObject.DebitCardDetailsDropdownList(),
					CommonTestData.RACE.getEnumValue());

			clickOnElement(IOShomePgaeObject.MaritalStatusField());
			selectElementFromTheGivenList(IOShomePgaeObject.DebitCardDetailsDropdownList(),
					CommonTestData.MARITAL_STATUS.getEnumValue());

			clickOnElement(IOShomePgaeObject.ResidentialTypeField());
			selectElementFromTheGivenList(IOShomePgaeObject.DebitCardDetailsDropdownList(),
					CommonTestData.RESIDENCE_TYPE.getEnumValue());

			clickOnElement(IOShomePgaeObject.EducationField());
			selectElementFromTheGivenList(IOShomePgaeObject.DebitCardDetailsDropdownList(),
					CommonTestData.EDUCATION.getEnumValue());

			clickOnElement(IOShomePgaeObject.EconomicStatusField());
			selectElementFromTheGivenList(IOShomePgaeObject.DebitCardDetailsDropdownList(),
					CommonTestData.ECONOMIC_STATUS.getEnumValue());

			clickOnElement(IOShomePgaeObject.AnnualIncomeField());
			selectElementFromTheGivenList(IOShomePgaeObject.DebitCardDetailsDropdownList(),
					CommonTestData.ANNUAL_INCOME.getEnumValue());

			//gestUtils.scrollUPtoObject("text", "NEXT", IOShomePgaeObject.nextButton());
			TakeScreenshot(IOShomePgaeObject.SendMeDBSPrmotionViaMail());
			clickOnElement(IOShomePgaeObject.SendMeDBSPrmotionViaMail()); 

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Step("Click on 'Account type' From List under Local fund Limit page'")
	public void selectElementFromTheGivenList(List<MobileElement> elementList, String elementToBeSelected)
			throws Exception {
		try {
			wait.waitForElementVisibility(elementList.get(1));
			List<MobileElement> Elementlist = elementList;
			int l = Elementlist.size();
			int index = 0;
			String accountFromList = null;
			for (int i = 0; i <= l; i++) {
				accountFromList = Elementlist.get(i).getText();
				if (accountFromList.contains(elementToBeSelected)) {
					index++;
					clickOnElement(Elementlist.get(i));
					break;
				}
			}

			Asserts.assertTrue(index > 0, "No " + elementToBeSelected + " found in the list of corresponding value");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Step("Verifies the Open Account.")
	public void OpenAccount() throws Exception {
		try {
			ClickOnMoreButton();
			EnterPasscodeAndDone();
			ClickOnDepositAccountsAnd2FAAuthenticationDone();
			SelectOpenAccountOptionAndVerifyAccountBenifitsPageHeader();
			ClickOnopenAccountInStepButton();
			EnterMonthlySavingsAmtAndSelectSourceOfFundsForSavings();
			ClickOnNextButton();
			VerifyWarningMessageAndImportantNotes();
			ClickOnIAcknowledgeButtonAndReviewOpenAccountApplication();
			ClickOnOpenAccountNowButton();
			
			// Leave On Home Page to this test case for next run.
			ClickOnCloseButton();
			ClickOnHomeButton();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("Select Open Account Option By Clicking And Verify Account Benifits Page Header.")
	public void SelectOpenAccountOptionAndVerifyAccountBenifitsPageHeader() throws Exception {
		try {
			selectElementFromTheGivenList(IOShomePgaeObject.SelectOpenAccountOptionList(),
					CommonTestData.OPEN_ACCOUNT_OPTION.getEnumValue());
			TakeScreenshot(IOShomePgaeObject.AccountBenefitsPageHeader()); 
			Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.AccountBenefitsPageHeader()),
					CommonTestData.ACCOUNT_BENIFITS.getEnumValue(),
					CommonTestData.ACCOUNT_BENIFITS.getEnumValue() + " Page Header Text is not matching");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("Enter Monthly Savings Amount And Select Source Of Funds For Savings.")
	public void EnterMonthlySavingsAmtAndSelectSourceOfFundsForSavings() throws Exception {
		try {
			clickOnElement(IOShomePgaeObject.EnterMonthlySavingsAmtEditField());
			enterTextInTextbox(IOShomePgaeObject.EnterMonthlySavingsAmtEditField(),
					CommonTestData.MONTHLY_SAVING_AMT_BALANCE.getEnumValue());
			driver.hideKeyboard();
			
			clickOnElement(IOShomePgaeObject.SelectSourceOfFundsForSavingsDropdown());
			selectElementFromTheGivenList(IOShomePgaeObject.SelectSourceOfFundsForSavingsDropdownList(),
					CommonTestData.SELECT_ACCOUNT.getEnumValue());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("Click On Open Account In 2/3 Step Button.")
	public void ClickOnopenAccountInStepButton() throws Exception {
		try {
			clickOnElement(IOShomePgaeObject.StepOpenAccountButton());
			TakeScreenshot(IOShomePgaeObject.OpenAccountPageHeader()); 
			Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.OpenAccountPageHeader()), CommonTestData.OPEN_ACCOUNT.getEnumValue(),
					CommonTestData.OPEN_ACCOUNT.getEnumValue() + " Page Header Text is not matching");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("Click On Deposit Accounts Module And 2FA Authentication Done And Verifies the Open Account Page Header.")
	public void ClickOnDepositAccountsAnd2FAAuthenticationDone() throws Exception {
		try {
			//gestUtils.scrollUPtoObject("text", "Deposit Accounts", IOShomePgaeObject.DepositAccountsModule());
			TakeScreenshot(IOShomePgaeObject.DepositAccountsModule()); 
			clickOnElement(IOShomePgaeObject.DepositAccountsModule());
			EnterPasscodeAndDone();
			Asserts.assertTrue(isElementVisible(IOShomePgaeObject.OpenAccountPageHeader()),
					CommonTestData.OPEN_ACCOUNT.getEnumValue() + " Page Header not displaying.");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("Verify Warning Message And Important Notes.")
	public void VerifyWarningMessageAndImportantNotes() throws Exception {
		try {
			TakeScreenshot(IOShomePgaeObject.ImportantNotesPageHeader()); 
			Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.ImportantNotesPageHeader()),
					CommonTestData.IMPORTANT_NOTES.getEnumValue(),
					CommonTestData.IMPORTANT_NOTES.getEnumValue() + " Text is not matching.");
			
			Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.Warning()),
					CommonTestData.WARNING.getEnumValue(),
					CommonTestData.WARNING.getEnumValue() + " Message is not matching");
		
			Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.WarningHeading()),
					CommonTestData.WARNING_HEADING_TEXT.getEnumValue(),
					CommonTestData.WARNING_HEADING_TEXT.getEnumValue() + " Message is not matching");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("Click On Open Account Now Button And Got 'Your account is open and ready to use!' Message.")
	public void ClickOnOpenAccountNowButton() throws Exception {
		try {
			//gestUtils.scrollUPtoObject("text", "OPEN ACCOUNT NOW", IOShomePgaeObject.OpenAccountNowButton());
			TakeScreenshot(IOShomePgaeObject.OpenAccountNowButton()); 
			clickOnElement(IOShomePgaeObject.OpenAccountNowButton());
			TakeScreenshot(IOShomePgaeObject.AccountStatusMessage()); 
			if (isElementVisible(IOShomePgaeObject.SuccessImage().get(0))) 
				Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.AccountStatusMessage()),
						CommonTestData.YOUR_ACCOUNT_OPEN_READYTOUSE_MESSAGE.getEnumValue(),
						CommonTestData.YOUR_ACCOUNT_OPEN_READYTOUSE_MESSAGE.getEnumValue()
								+ " Message is not matching.");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("Click On IAcknowledge Button And Review Open Account Application.")
	public void ClickOnIAcknowledgeButtonAndReviewOpenAccountApplication() throws Exception {
		try {
			//gestUtils.scrollUPtoObject("text", "I ACKNOWLEDGE", IOShomePgaeObject.IACKNOWLEDGEButton());
			clickOnElement(IOShomePgaeObject.IACKNOWLEDGEButton());
			TakeScreenshot(IOShomePgaeObject.ReviewAccountApplicationPageHeader()); 
			Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.ReviewAccountApplicationPageHeader()),
					CommonTestData.REVIEW_ACCOUNT_APPLICATION.getEnumValue(),
					CommonTestData.REVIEW_ACCOUNT_APPLICATION.getEnumValue() + " Text is not matched.");
			if (isElementVisible(IOShomePgaeObject.YouAreOpeningText())) {
				MobileElement element = verifyElementExistInTheList(IOShomePgaeObject.AccountList(),
						CommonTestData.OPEN_ACCOUNT_OPTION.getEnumValue());
				Asserts.assertEquals(getTexOfElement(element), CommonTestData.OPEN_ACCOUNT_OPTION.getEnumValue(),
						" Given account is not matched or found.");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	

	public MobileElement verifyElementExistInTheList(List<MobileElement> elementList, String elementTextToBeVerified)
			throws Exception {
		MobileElement element = null;
		try {
			wait.waitForElementVisibility(elementList.get(1));
			int l = elementList.size();

			String accountFromList = null;
			for (int i = 0; i < l; i++) {
				accountFromList = elementList.get(i).getText();
				System.out.println(accountFromList + " : " + i);
				if (accountFromList.contains(elementTextToBeVerified)) {
					element = elementList.get(i);
					break;
				}
			}
			return element;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}

