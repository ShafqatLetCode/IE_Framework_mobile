package com.crestech.pages;

import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import com.crestech.appium.utils.CommonAppiumTest;
import com.crestech.common.utilities.AndroidAlert;
import com.crestech.common.utilities.Asserts;
import com.crestech.common.utilities.CommonTestData;
import com.crestech.common.utilities.GestureUtils;
import com.crestech.pageobjects.DBS_IOSObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;

public class DBS_IOSpage extends CommonAppiumTest {

	static Logger log = Logger.getLogger(DBSAndroidPage.class.getName());
	public DBS_IOSObject IOShomePgaeObject = new DBS_IOSObject(driver);
	CommonAppiumTest commonAppTest = null;
	AndroidAlert androidAlert = null;

	public DBS_IOSpage(AppiumDriver<RemoteWebElement> driver) {
		super(driver);
		commonAppTest = new CommonAppiumTest(driver);
		androidAlert = new  AndroidAlert(driver);
		//PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), IOShomePgaeObject);
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
	public void swipeUpgadeExperienceAlert() throws Exception    
	{
		
		try {
			
			String actualMessage = commonAppTest.getTexOfElement(IOShomePgaeObject.upgradeTitle());
			if(actualMessage.equalsIgnoreCase(CommonTestData.UPGRADE_EXPERIENCE_MESSAGE.getEnumValue())) {
				Dimension windowSize1 = driver.manage().window().getSize();
				int y =(int)((windowSize1.getHeight())-10);
				int x =(int)((windowSize1.getWidth())/2);
				GestureUtils.swipeElementtoCoordinate(IOShomePgaeObject.upgradeSwipeButton(),  x,  y);
			}
			
			Asserts.assertEquals(actualMessage, CommonTestData.UPGRADE_EXPERIENCE_MESSAGE.getEnumValue(), "Alert Message Not matching");
			
		} catch (Exception e) {
			e.printStackTrace(); 
			throw e;
		}
	}
	@Step("Handling FingurePrint Alert")
	public void handlingFingurePrintAlert() throws Exception    //android.widget.Toast[1]
	{
		try {
			androidAlert.AlertHandlingWithButtonMessage(IOShomePgaeObject.fingerpringAlertClosedButton(), CommonTestData.SETUP.getEnumValue(),
					IOShomePgaeObject.fingerpringAlertMessage());
		} catch (Exception e) {
			e.printStackTrace(); 
			throw e;
		}

}
	@Step("Handling Recording Alert")
	public void handlingRecordingAlert() throws Exception    //android.widget.Toast[1]
	{
		try {
			androidAlert.AlertHandlingWithButtonMessage(IOShomePgaeObject.recordingAlertClosedButton(), CommonTestData.RECORDERSECTION_MESSAGE.getEnumValue(),
					IOShomePgaeObject.recordingAlertMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

}
	@Step("Handling MOTION AND FITNESS ALERT Alert")
	public void handlingMotionAndFitnessAlert() throws Exception    //android.widget.Toast[1]
	{
		try {
			androidAlert.AlertHandlingWithButtonMessage(IOShomePgaeObject.alertFitnessActivityTitle(), CommonTestData.SETUP.getEnumValue(),
					IOShomePgaeObject.alertOkButton());
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}

}
	public void fieldText(String expectedText, MobileElement Element) throws Exception {
		try {
			String actualText = getTexOfElement(Element).trim();

			Asserts.assertEquals(actualText, expectedText, "text is not found");

		} catch (Exception e) {
			e.printStackTrace(); 
			throw e;
		}
	}
	@Step("verify 'Welcome To' Field")
	public void verifyWelcomeToText() throws Exception {
		try {
			fieldText(CommonTestData.WELCOME.getEnumValue(),IOShomePgaeObject.welcomeToText());
			
		} catch (Exception e) {
			e.printStackTrace(); 
			throw e;
		}
	}
	@Step("verify 'digibank' Field")
	public void verifyDigibankText() throws Exception {
		try {
			fieldText(CommonTestData.DIGIBANK.getEnumValue(),IOShomePgaeObject.digibankText());
			
		} catch (Exception e) {
			e.printStackTrace(); 
			throw e;
		}
	}
	@Step("Application click Logout & Verifies the 'Tap on the stars to rate' field Message.")
	public void clickOnLogoutAndVerify(String Ratingmsg) throws Exception {
		try {
			androidAlert.AlertHandlingWithButtonMessage(IOShomePgaeObject.logOutButton(), CommonTestData.LOGOUT_ISO.getEnumValue(),
					IOShomePgaeObject.logOutButton());
			Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.tapOnStarMessage()), Ratingmsg,
					"'Tap on the stars to rate' Text is not found");
		} catch (Exception e) {
			e.printStackTrace(); 
			throw e;
		}
	}
	public void ButtonLabelVerifyClick(MobileElement Button,String expectecText) throws Exception {
		try {

			String actualText = commonAppTest.getTexOfElement(Button);

			if (actualText.equalsIgnoreCase(expectecText))
				commonAppTest.clickOnElement(Button);

			Asserts.assertEquals(actualText, expectecText, "button Not exist");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}
	public void ButtonVerifyClick(MobileElement Button) throws Exception {
		try {
			Asserts.assertTrue(commonAppTest.isElementEnable(Button), "button Not enable");
			if (commonAppTest.isElementEnable(Button))
				commonAppTest.clickOnElementOnEnable(Button);

			

		} catch (Exception e) {
			e.printStackTrace(); 
			throw e;
		}

	}
	@Step("verify and click 'pay and transfer' Field")
	public void payAndTransferVerifyClick() throws Exception {
		try {
			ButtonLabelVerifyClick(IOShomePgaeObject.payAndTransferButton(),CommonTestData.PAY_TRANSFER_ICON.getEnumValue());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Step("verify and click 'Topup' Field")
	public void topUpVerifyClick() throws Exception {
		try {
			ButtonLabelVerifyClick(IOShomePgaeObject.topUpButton(),CommonTestData.TOPUP_LABEL_IOS.getEnumValue());
			
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
			fieldText(CommonTestData.TOPUP_PAYLAH_LABEL.getEnumValue(),IOShomePgaeObject.topUpPayLahTitle());
			
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
	}
	@Step("verify 'SGD' Field")
	public void sgdCurrencyVerify() throws Exception {
		try {
			fieldText(CommonTestData.SGD_CURRENCY_LABEL.getEnumValue(),IOShomePgaeObject.sgdCurrency());
			
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

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Step("Verify 'Enter Amount' field")
	public void verifyDisplayAmount(String expectedText) {
		try {
			fieldText( expectedText ,IOShomePgaeObject.amountEditBox());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Step("Verify 'Top Up Paylah Label' field")
	public void verifyReviewTopUpLabel(String expectedText) {
		try {
			
			fieldText( expectedText ,IOShomePgaeObject.reviewToUpLabel());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Step("Verifying Next Label and click")
	public void ClickOnNextButton() throws Exception {
		try {
			String actualText = commonAppTest.getTexOfElement(IOShomePgaeObject.nextButton());
			TakeScreenshot(IOShomePgaeObject.nextButton()); 
			if (actualText.equalsIgnoreCase("NEXT"))
				commonAppTest.clickOnElement(IOShomePgaeObject.nextButton());
			Asserts.assertEquals(actualText, "NEXT", "Button not found");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}
	@Step("Verifying TOP UP NOW  Label and click")
	public void topUpNowVerifyClick(String expectecText) throws Exception {
		try {

			String actualText = commonAppTest.getTexOfElement(IOShomePgaeObject.topupNowButton());

			if (actualText.equalsIgnoreCase(expectecText))
				commonAppTest.clickOnElement(IOShomePgaeObject.topupNowButton());

			Asserts.assertEquals(actualText, expectecText, "TOP UP NOW button Not exist");

		} catch (Exception e) {
			e.printStackTrace(); 
			throw e;
		}

	}
	@Step("Verify 'Top-up Done' field")
	public void verifyTopUpDoneLabel(String expectedText) {
		try {
			fieldText( expectedText ,IOShomePgaeObject.topupDoneButton());
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
			Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.tapOnStarMessage()),  CommonTestData.RATE_MESSAGE.getEnumValue(),
					"'Tap on the stars to rate' Text is not found");
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

			fieldText(titleText ,IOShomePgaeObject.title2FA());
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
			  //IOShomePgaeObject.handlingMotionAndFitnessAlert();
			//swipeUpgadeExperienceAlert();
			//handlingFingurePrintAlert();
		    //handlingRecordingAlert();
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
	public void sendDataInCommonSearchBoxAndSelectFromDropDown(String searchBoxData, String valueSelectedFromList) throws Exception {
		try {
			
			clickOnElementOnEnable(IOShomePgaeObject.searchIcon());
			if (isElementEnable(IOShomePgaeObject.searchBox()))
				enterTextInTextbox(IOShomePgaeObject.searchBox(), searchBoxData);
			//wait.waitForElementVisibility(IOShomePgaeObject.searchTextElement().get(0));
			List<RemoteWebElement> ElementCell=driver.findElementsByXPath("//XCUIElementTypeCell");
			int sizeList=ElementCell.size();
			int index = 0;
			for (int i = 1; i <= sizeList; i++) {
				
				String xpath="//XCUIElementTypeCell"+"["+String.valueOf(i)+"]/XCUIElementTypeStaticText";
				String Text=driver.findElementByXPath(xpath).getText();
				System.out.println(Text);
				if (Text.equalsIgnoreCase(valueSelectedFromList)) {
					index++;
					clickOnElement((MobileElement)driver.findElementByXPath(xpath));
					break;
				
			}
			}
		} catch (Exception e) {
			e.printStackTrace(); 
			throw e;
		}
	}
	@Step("Verifying button label and clicking on 'More' button ")
	public void MoreVerifyAndClickButton() throws Exception {
		try {
			androidAlert.AlertHandlingWithButtonMessage(IOShomePgaeObject.moeButton(), CommonTestData.MORE_LABEL.getEnumValue(),
					IOShomePgaeObject.moeButton());
		} catch (Exception e) {
			e.printStackTrace(); 
			throw e;
		}
	}
	@Step("Verifying page header 'Local Transfer Limit' ")
	public void verifyLocalTransferLimitTitle() throws Exception {
		try {
			String expectedText=CommonTestData.LOCAL_TRANSFER_LIMIT_LABEL.getEnumValue();
			fieldText( expectedText ,IOShomePgaeObject.localTransferLimitLabel());

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	@Step("Verifying 'To Other Banks Limit' and click ")
	public void toOtherBanksVerifyClick() throws Exception {
		try {
			ButtonLabelVerifyClick(IOShomePgaeObject.toOtherBankButton(),CommonTestData.TO_OTHERBANK_LABEL.getEnumValue());;
		} catch (Exception e) {
			e.printStackTrace(); 
			throw e;
		}

	}
	@Step("Verifying page header 'To Other Banks' title ")
	public void verifyTransferToOtherBankLimitTitle() throws Exception {
		try {
			String expectedText=CommonTestData.TRANSFER_TO_OTHERBANK_LABEL_LABEL.getEnumValue();
			fieldText( expectedText ,IOShomePgaeObject.ToOtherBankLimitTitle());

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	public String handlingSetCurrentLimit() throws Exception {
		try {
			String currentText=getTexOfElement(IOShomePgaeObject.currentLimitTextButton());
			String[] arrOfStr = currentText.split(" ");
			verifyClickSetCurrentLimit();
			verifySetDailyLimitTitle();
			String selectedValue=null;
//			if(arrOfStr[1].equalsIgnoreCase(CommonTestData.SELECTED_LIMIT_3.getEnumValue())) {
//				selectAmountFromSetCurrentLimitList(CommonTestData.SELECTED_LIMIT_2.getEnumValue());
//				selectedValue=CommonTestData.SELECTED_LIMIT_2.getEnumValue();
//			}
//			else if(arrOfStr[1].equalsIgnoreCase(CommonTestData.SELECTED_LIMIT_2.getEnumValue())) {
//				selectAmountFromSetCurrentLimitList(CommonTestData.SELECTED_LIMIT_1.getEnumValue());
//				selectedValue=CommonTestData.SELECTED_LIMIT_1.getEnumValue();}
//			else if(arrOfStr[1].equalsIgnoreCase(CommonTestData.SELECTED_LIMIT_1.getEnumValue())) {
//				selectAmountFromSetCurrentLimitList(CommonTestData.SELECTED_LIMIT_2.getEnumValue());
//				selectedValue=CommonTestData.SELECTED_LIMIT_2.getEnumValue();}
			return selectedValue;
		} catch (Exception e) {
			e.printStackTrace(); 
			throw e;
		}
	}
	@Step("Verifying and click 'set current Limit' ")
	public void verifyClickSetCurrentLimit() throws Exception {
		try {
			ButtonVerifyClick(IOShomePgaeObject.currentLimitTextButton());
		} catch (Exception e) {
			e.printStackTrace(); 
			throw e;
		}
	}
	@Step("Verifying page header 'Set Daily Limit' ")
	public void verifySetDailyLimitTitle() throws Exception {
		try {
			String expectedText=CommonTestData.SET_DAILY_LIMIT_TITLE.getEnumValue();
			fieldText( expectedText ,IOShomePgaeObject.setDailyLimitTitle());

		} catch (Exception e) {
			e.printStackTrace(); 
			throw e;
		}
	}
	@Step("Select amount from the List of 'set current Limit' ")
	public void selectAmountFromSetCurrentLimitList(String amount) throws Exception {
		try {
			
			
			List<RemoteWebElement> ElementCell=driver.findElementsByXPath("//XCUIElementTypeCell");
			int sizeList=ElementCell.size();
			int index = 0;
			for (int i = 1; i <= sizeList; i++) {
				
				String xpath="//XCUIElementTypeCell"+"["+String.valueOf(i)+"]/XCUIElementTypeStaticText";
				String Text=driver.findElementByXPath(xpath).getText();
				System.out.println(Text);
				if (Text.equalsIgnoreCase(amount)) {
					index++;
					clickOnElement((MobileElement)driver.findElementByXPath(xpath));
					break;
				
			}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	@Step("Verifying page header 'Review Daily Limit'")
	public void verifyReviewDailyLimitTitle() throws Exception {
		try {
			String expectedText=CommonTestData.REVIEW_DAILY_LIMIT_TITLE.getEnumValue();
			fieldText( expectedText ,IOShomePgaeObject.reviewDailyLimitTitle());

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
			e.printStackTrace(); throw e;
		}
	}
	@Step("Verify topup Paylah Case and logout topup Paylah.")
	public void TopupPaylah() throws Exception {
		try {
			payAndTransferVerifyClick();
			topUpVerifyClick();
			 payLahVerifyClick();
			 sendCurrencyInTextField(CommonTestData.AMOUNT_PAYLAH.getEnumValue());
			 ClickOnNextButton();
			 verifyReviewTopUpLabel(CommonTestData.TOPUP_REVIEW_LABEL.getEnumValue());
			topUpNowVerifyClick(CommonTestData.TOPUP_NOW_BUTTOM_LABEL.getEnumValue());
			logOutTopUpVerifyClick();
		} catch (Exception e) {
			e.printStackTrace(); 
			throw e;
		}
	}
	@Step("Change local fund transfer limit verification")
	public void ChangeLocalFundsTransferLimit() throws Exception {
		try {
			MoreVerifyAndClickButton();
			sendDataInCommonSearchBoxAndSelectFromDropDown(CommonTestData.LOCAL_TRANSFER_LIMIT_SEARCHBOX_IOS.getEnumValue(),
					CommonTestData.LOCAL_TRANSFER_LIMIT_LABEL.getEnumValue());
			verifyLocalTransferLimitTitle();
			toOtherBanksVerifyClick();
			String amountSlected = handlingSetCurrentLimit();
			ClickOnNextButton();
			verifyReviewDailyLimitTitle();
			verifyClickChangeDailyLimitNowButton();
			//verifyClickBackToMoreButton();
			//sendDataInCommonSearchBoxAndSelectFromDropDown(CommonTestData.LOCAL_TRANSFER_LIMIT_LABEL.getEnumValue(),
					//CommonTestData.LOCAL_TRANSFER_LIMIT_LABEL.getEnumValue(), CommonTestData.LOCAL_TRANSFER_LIMIT_LABEL.getEnumValue(), DBSappObject.PageHeader());
		//	ClickOnToOtherBankLimit();
			//verifyDisplayAmountLocalTransferLimitChange(amountSlected);
		} catch (Exception e) {
			e.printStackTrace(); 
			throw e;
		}
	}
	
	@Step("Verifies Add payee DBSorPOSB.")
	public void VerifyAddPayeeDBSorPOSB() throws Exception {
		try {
			payAndTransferVerifyClick();
			EnterPasscodeAndDone();
			clickOnAddLocalRecipientBtnAndVerifyLocalTransferPayNowPageHeader();
			String ExpectedRecipientName = CommonTestData.PAYEEADD_DBSPOSB_RECIPIENT_NAME.getEnumValue();
			EnterRecipientDetailsAfterSelectingBankAccountOption(ExpectedRecipientName,
					CommonTestData.PAYEEADD_DBSPOSB_BANK_NAME.getEnumValue(),
					CommonTestData.PAYEEADD_DBSPOSB_ACCOUNT_NUMBER.getEnumValue());
			ClickOnNextButton();
			Asserts.assertTrue(isElementVisible(IOShomePgaeObject.ReviewRecipientDetailsPageHeader()),CommonTestData.REVIEW_RECIPIENT_DETAILS.getEnumValue() + " Page Header not displaying.");
			
			ClickOnAddRecipientNowBtn();
			VerifyYouHaveAddedRecipientMsgAfterEnterSecurePIN();
			verifyValidationForPayeeAdd(ExpectedRecipientName, CommonTestData.PAYEEADD_DBSPOSB_BANK_NAME.getEnumValue(),
					CommonTestData.PAYEEADD_DBSPOSB_ACCOUNT_NUMBER.getEnumValue());
			clickOnElement(IOShomePgaeObject.closeButton());
			clickOnLocalButton();
			DeletePayee(ExpectedRecipientName);
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
	}
	
	@Step("Click On Local Button.")
	public void clickOnLocalButton() throws Exception {
		try {
			TakeScreenshot(IOShomePgaeObject.LocalButton()); 
			clickOnElement(IOShomePgaeObject.LocalButton());
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
	}

	public void TakeScreenshot(MobileElement Element) throws Exception {
		try {
			wait.waitForElementVisibility(Element);
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
	}
	
	@Step("Verifies the Payee Add Local OtherBank and verifies 'YOU HAVE ADDED RECIPIENT MSG' .")
	public void PayeeAddLocalOtherBank() throws Exception {
		try {
			payAndTransferVerifyClick();
			EnterPasscodeAndDone();
			clickOnLocalButton();
			clickOnAddLocalRecipientBtnAndVerifyLocalTransferPayNowPageHeader();

			
			String ExpectedRecipientName = CommonTestData.LOCAL_RECIPIENT_NAME.getEnumValue();
			String ExpectedAccountNumber = CommonTestData.LOCAL_RECIPIENT_ACCOUNT_NUMBER.getEnumValue();

			EnterRecipientDetailsAfterSelectingBankAccountOption(ExpectedRecipientName,
					CommonTestData.LOCAL_RECIPIENT_BANK_NAME.getEnumValue(), ExpectedAccountNumber);
			ClickOnNextButton();
			Asserts.assertTrue(isElementVisible(IOShomePgaeObject.ReviewRecipientDetailsPageHeader()),CommonTestData.REVIEW_RECIPIENT_DETAILS.getEnumValue() + " Page Header not displaying.");
			ClickOnAddRecipientNowBtn();
			VerifyYouHaveAddedRecipientMsgAfterEnterSecurePIN();
			verifyValidationForPayeeAdd(ExpectedRecipientName, CommonTestData.LOCAL_RECIPIENT_BANK_NAME.getEnumValue(),
					ExpectedAccountNumber);
			clickOnElement(IOShomePgaeObject.closeButton());
			clickOnLocalButton();
			DeletePayee(ExpectedRecipientName);
			
			//Leave On Home Page to this test case for next run.
			
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
	}
	
	@Step("Delete Payee.")
	public void DeletePayee(String ExpectedRecipientName) throws Exception {
		try {
			String RecipientNameXpath = "//XCUIElementTypeStaticText[@name='"+ExpectedRecipientName+"']";
			MobileElement RecipientNameElement = (MobileElement) driver.findElement(By.xpath(RecipientNameXpath));
			int ExpectedTotalPayeeSize = IOShomePgaeObject.IiconList().size();
			
			for(int i=0; i<ExpectedTotalPayeeSize; i++) {
				TakeScreenshot(IOShomePgaeObject.IiconList().get(i)); 
					clickOnElement(IOShomePgaeObject.IiconList().get(i)); 
					TakeScreenshot(RecipientNameElement); 
					if(isElementVisible(RecipientNameElement)) { 
						clickOnElement(IOShomePgaeObject.MorePayeeDetailDots()); 
						TakeScreenshot(IOShomePgaeObject.DeletePayeeButton()); 
						clickOnElement(IOShomePgaeObject.DeletePayeeButton());
						TakeScreenshot(IOShomePgaeObject.AreYouSureToDeleteThisPayeeMsg()); 
						if(isElementVisible(IOShomePgaeObject.AreYouSureToDeleteThisPayeeMsg()))
							clickOnElement(IOShomePgaeObject.YesButton());
						
						for(int innerLoop=0; innerLoop<2; innerLoop++) {
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
							if(isElementVisible(IOShomePgaeObject.AreYouSureToDeleteThisPayeeMsg()))
								clickOnElement(IOShomePgaeObject.YesButton());
							}
						}
						
						String message = ExpectedRecipientName + " Deleted";
						String DeletePayeeMessageXPath = "//XCUIElementTypeStaticText[@name='"+message+"']";
						MobileElement DeletePayeeMessageElement = (MobileElement) driver.findElement(By.xpath(DeletePayeeMessageXPath));
					if(isElementVisible(DeletePayeeMessageElement)) {
						TakeScreenshot(IOShomePgaeObject.OKButton()); 
					     clickOnElement(IOShomePgaeObject.OKButton());
					}
					}
					else {
						clickOnElement(IOShomePgaeObject.BackBtn());
					}
				}
			
			int ActualTotalPayeeSize = IOShomePgaeObject.IiconList().size();
			int ExpectedTotalSizeAfterDeletingPayee = ExpectedTotalPayeeSize - 1;
			Asserts.assertEquals(String.valueOf(ExpectedTotalSizeAfterDeletingPayee) , String.valueOf(ActualTotalPayeeSize),
					 " Payee is not deleting after adding payee.");
			
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
	}
	
	@Step("Verifies Visibilty of 'logout' and 'make a transfer' button and Verifies the recipient name, account number, bank name.")
	public void verifyValidationForPayeeAdd(String ExpectedRecipientName, String BankName, String AccountNumber)
			throws Exception {
		try {
			Asserts.assertTrue(IOShomePgaeObject.LogoutBtn().isDisplayed(), "Log Out Button not found.");
			Asserts.assertTrue(IOShomePgaeObject.makeTransferButton().isDisplayed(), "Make A Transfer Button not found.");
			Asserts.assertTrue(IOShomePgaeObject.closeButton().isDisplayed(), "Close Button not found.");
			
			Asserts.assertTrue(IOShomePgaeObject.RecipientNameText().isDisplayed(), "'Recipient's Name' text is not dispalying After adding Payee.");
			String RecipientNameXpath = "//XCUIElementTypeStaticText[@name='"+ExpectedRecipientName+"']";
			MobileElement RecipientNameElement = (MobileElement) driver.findElement(By.xpath(RecipientNameXpath));
			Asserts.assertEquals(getTexOfElement(RecipientNameElement), ExpectedRecipientName,
					ExpectedRecipientName + " is not matching after adding payee");
			
			Asserts.assertTrue(IOShomePgaeObject.RecipientBankText().isDisplayed(), "'Recipient's Bank' text is not dispalying After adding Payee.");
			String BankNameXpath = "//XCUIElementTypeStaticText[@name='"+BankName+"']";
			MobileElement BankNameElement = (MobileElement) driver.findElement(By.xpath(BankNameXpath));
			Asserts.assertEquals(getTexOfElement(BankNameElement), BankName,
					BankName + " is not matching after adding payee");
			
			Asserts.assertTrue(IOShomePgaeObject.RecipientAccountNo().isDisplayed(), "'Recipient's Account No.' text is not dispalying After adding Payee.");
			String AccountNumberXpath = "//XCUIElementTypeStaticText[@name='"+AccountNumber+"']";
			MobileElement AccountNumberElement = (MobileElement) driver.findElement(By.xpath(AccountNumberXpath));
			Asserts.assertEquals(getTexOfElement(AccountNumberElement), AccountNumber,
					AccountNumber + " is not matching after adding payee");
		} catch (Exception e) {
			e.printStackTrace(); 
			throw e;
		}
	}
	
	
	@Step("Click On Close Button.")
	public void ClickOnCloseButton() throws Exception {
		try {
			clickOnElement(IOShomePgaeObject.closeButton());
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
			
			Asserts.assertTrue(isElementVisible(IOShomePgaeObject.LocalTransferPayNowPageHeader()), " 'Local Transfer & Pay Now' Page Header not displaying.");
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
			
			Asserts.assertTrue(isElementVisible(IOShomePgaeObject.EnterRecipientDetailsPageHeader()), " 'Enter Recipient's Details' Page Header not displaying.");
			
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
			e.printStackTrace(); throw e;
		}
	}
	
	@Step("Verify 'You Have Added Recipient Msg' After Entering Secure PIN.")
	public void VerifyYouHaveAddedRecipientMsgAfterEnterSecurePIN() throws Exception {
		try {
			EnterPasscodeAndDone();
			Thread.sleep(20000);
			TakeScreenshot(IOShomePgaeObject.PayeeAddedSuccessImage().get(3)); 
			if (isElementVisible(IOShomePgaeObject.PayeeAddedSuccessImage().get(3))) 
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
}
