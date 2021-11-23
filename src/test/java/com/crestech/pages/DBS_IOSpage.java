package com.crestech.pages;

import java.util.List;
import java.util.logging.Logger;
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
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;

public class DBS_IOSpage extends CommonAppiumTest {

	static Logger log = Logger.getLogger(DBSAndroidPage.class.getName());
	public DBS_IOSObject IOShomePgaeObject = new DBS_IOSObject(driver);

	public DBS_IOSpage(AppiumDriver<RemoteWebElement> driver) {
		super(driver);
		//PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), IOShomePgaeObject);
	}

	@Step("Enter data in User EditBox")
	public void sendDataInUserId(String text) throws Exception {
		try {
			Asserts.assertTrue(isElementEnable(IOShomePgaeObject.userIdEditBox()), "EditField is not enable");
			if (isElementEnable(IOShomePgaeObject.userIdEditBox()))
				enterTextInTextbox(IOShomePgaeObject.userIdEditBox(), text);

			
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
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
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
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
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
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
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}
	
	@Step("Clicked on Login button")
	public void clickOnLoginButton_0() throws Exception {
		try {
			clickOnElement(IOShomePgaeObject.logInButton_0());
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}
	@Step("Swiping down alert of upgarde experience")
	public void swipeUpgadeExperienceAlert() throws Exception    
	{
		
		try {
			
			String actualMessage = CommonAppiumTest.getTexOfElement(IOShomePgaeObject.upgradeTitle());
			if(actualMessage.equalsIgnoreCase(CommonTestData.UPGRADE_EXPERIENCE_MESSAGE.getEnumValue())) {
				Dimension windowSize1 = driver.manage().window().getSize();
				int y =(int)((windowSize1.getHeight())-10);
				int x =(int)((windowSize1.getWidth())/2);
				GestureUtils.swipeElementtoCoordinate(IOShomePgaeObject.upgradeSwipeButton(),  x,  y);
			}
			
			Asserts.assertEquals(actualMessage, CommonTestData.UPGRADE_EXPERIENCE_MESSAGE.getEnumValue(), "Alert Message Not matching");
			
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}
	@Step("Handling FingurePrint Alert")
	public void handlingFingurePrintAlert() throws Exception    //android.widget.Toast[1]
	{
		try {
			AndroidAlert.AlertHandlingWithButtonMessage(IOShomePgaeObject.fingerpringAlertClosedButton(), CommonTestData.SETUP.getEnumValue(),
					IOShomePgaeObject.fingerpringAlertMessage());
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}

}
	@Step("Handling Recording Alert")
	public void handlingRecordingAlert() throws Exception    //android.widget.Toast[1]
	{
		try {
			AndroidAlert.AlertHandlingWithButtonMessage(IOShomePgaeObject.recordingAlertClosedButton(), CommonTestData.RECORDERSECTION_MESSAGE.getEnumValue(),
					IOShomePgaeObject.recordingAlertMessage());
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}

}
	@Step("Handling MOTION AND FITNESS ALERT Alert")
	public void handlingMotionAndFitnessAlert() throws Exception    //android.widget.Toast[1]
	{
		try {
			AndroidAlert.AlertHandlingWithButtonMessage(IOShomePgaeObject.alertFitnessActivityTitle(), CommonTestData.SETUP.getEnumValue(),
					IOShomePgaeObject.alertOkButton());
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}

}
	public void fieldText(String expectedText, MobileElement Element) throws Exception {
		try {
			String actualText = getTexOfElement(Element).trim();

			Asserts.assertEquals(actualText, expectedText, "text is not found");

		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}
	@Step("verify 'Welcome To' Field")
	public void verifyWelcomeToText() throws Exception {
		try {
			fieldText(CommonTestData.WELCOME.getEnumValue(),IOShomePgaeObject.welcomeToText());
			
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}
	@Step("verify 'digibank' Field")
	public void verifyDigibankText() throws Exception {
		try {
			fieldText(CommonTestData.DIGIBANK.getEnumValue(),IOShomePgaeObject.digibankText());
			
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}
	@Step("Application click Logout & Verifies the 'Tap on the stars to rate' field Message.")
	public void clickOnLogoutAndVerify(String Ratingmsg) throws Exception {
		try {
			AndroidAlert.AlertHandlingWithButtonMessage(IOShomePgaeObject.logOutButton(), CommonTestData.LOGOUT_ISO.getEnumValue(),
					IOShomePgaeObject.logOutButton());
			Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.tapOnStarMessage()), Ratingmsg,
					"'Tap on the stars to rate' Text is not found");
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}
	public void ButtonLabelVerifyClick(MobileElement Button,String expectecText) throws Exception {
		try {

			String actualText = CommonAppiumTest.getTexOfElement(Button);

			if (actualText.equalsIgnoreCase(expectecText))
				CommonAppiumTest.clickOnElement(Button);

			Asserts.assertEquals(actualText, expectecText, "button Not exist");

		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}

	}
	public void ButtonVerifyClick(MobileElement Button) throws Exception {
		try {
			Asserts.assertTrue(CommonAppiumTest.isElementEnable(Button), "button Not enable");
			if (CommonAppiumTest.isElementEnable(Button))
				CommonAppiumTest.clickOnElementOnEnable(Button);

			

		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}

	}
	@Step("verify and click 'pay and transfer' Field")
	public void payAndTransferVerifyClick() throws Exception {
		try {
			ButtonLabelVerifyClick(IOShomePgaeObject.payAndTransferButton(),CommonTestData.PAY_TRANSFER_ICON.getEnumValue());
			
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}
	@Step("verify and click 'Topup' Field")
	public void topUpVerifyClick() throws Exception {
		try {
			ButtonLabelVerifyClick(IOShomePgaeObject.topUpButton(),CommonTestData.TOPUP_LABEL_IOS.getEnumValue());
			
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}
	@Step("verify and click 'PayLah!' Field")
	public void payLahVerifyClick() throws Exception {
		try {
			ButtonVerifyClick(IOShomePgaeObject.payLahButton());
			
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}
	@Step("verify 'Top Up PayLah!' Field")
	public void topUpPayLahTitleVerify() throws Exception {
		try {
			fieldText(CommonTestData.TOPUP_PAYLAH_LABEL.getEnumValue(),IOShomePgaeObject.topUpPayLahTitle());
			
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}
	@Step("verify 'SGD' Field")
	public void sgdCurrencyVerify() throws Exception {
		try {
			fieldText(CommonTestData.SGD_CURRENCY_LABEL.getEnumValue(),IOShomePgaeObject.sgdCurrency());
			
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
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
	public void nextButtonVerifyClick() throws Exception {
		try {

			String actualText = CommonAppiumTest.getTexOfElement(IOShomePgaeObject.nextButton());

			if (actualText.equalsIgnoreCase("NEXT"))
				CommonAppiumTest.clickOnElement(IOShomePgaeObject.nextButton());

			Asserts.assertEquals(actualText, "NEXT", "Button not found");

		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}

	}
	@Step("Verifying TOP UP NOW  Label and click")
	public void topUpNowVerifyClick(String expectecText) throws Exception {
		try {

			String actualText = CommonAppiumTest.getTexOfElement(IOShomePgaeObject.topupNowButton());

			if (actualText.equalsIgnoreCase(expectecText))
				CommonAppiumTest.clickOnElement(IOShomePgaeObject.topupNowButton());

			Asserts.assertEquals(actualText, expectecText, "TOP UP NOW button Not exist");

		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
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

			String actualText = CommonAppiumTest.getTexOfElement(IOShomePgaeObject.logoutPaylah());
			String expectecText = CommonTestData.LOGOT_PAYLAH_IOS.getEnumValue();
			if (actualText.equalsIgnoreCase(expectecText))
				CommonAppiumTest.clickOnElement(IOShomePgaeObject.logoutPaylah());

			Asserts.assertEquals(actualText, expectecText, "LogOut button Not exist");

		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}

	}
	@Step("Verifies the 'Tap on the stars to rate' field Message.")
	public void tapOnStarFieldVerify() throws Exception {
		try {
			Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.tapOnStarMessage()),  CommonTestData.RATE_MESSAGE.getEnumValue(),
					"'Tap on the stars to rate' Text is not found");
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}
	@Step("Verifying Done button and click")
	public void doneVerifyClick() throws Exception {
		try {

			String actualText = CommonAppiumTest.getTexOfElement(IOShomePgaeObject.doneButton());
			String expectecText = CommonTestData.DONE_2FA_IOS.getEnumValue();
			if (actualText.equalsIgnoreCase(expectecText))
				CommonAppiumTest.clickOnElement(IOShomePgaeObject.doneButton());

			Asserts.assertEquals(actualText, expectecText, "Done button Not exist");

		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}

	}
	@Step("2FA VERIFICATION")
	public void handling2faVerification(String titleText) throws Exception {
		try {

			fieldText(titleText ,IOShomePgaeObject.title2FA());
			sendPinIn2faSecureBox(CommonTestData.PIN_2FA.getEnumValue());
			doneVerifyClick();

		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}

	}
	@Step("Enter data in User EditBox")
	public void sendPinIn2faSecureBox(String text) throws Exception {
		try {
			Asserts.assertTrue(isElementEnable(IOShomePgaeObject.secureBox()), "EditField is not enable");
			if (isElementEnable(IOShomePgaeObject.secureBox()))
				enterTextInTextbox(IOShomePgaeObject.secureBox(), text);

			
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
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
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}
	@Step("Login the application")
	public void logOutApplication() throws Exception {
		try {
			
			clickOnLogoutAndVerify(CommonTestData.RATE_MESSAGE.getEnumValue());
			
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
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
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}
	@Step("Verifying button label and clicking on 'More' button ")
	public void MoreVerifyAndClickButton() throws Exception {
		try {
			AndroidAlert.AlertHandlingWithButtonMessage(IOShomePgaeObject.moeButton(), CommonTestData.MORE_LABEL.getEnumValue(),
					IOShomePgaeObject.moeButton());
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}
	@Step("Verifying page header 'Local Transfer Limit' button ")
	public void verifyLocalTransferLimitTitle() throws Exception {
		try {
			String expectedText=CommonTestData.LOCAL_TRANSFER_LIMIT_LABEL.getEnumValue();
			fieldText( expectedText ,IOShomePgaeObject.localTransferLimitLabel());

		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}
	@Step("Verifying 'To Other Banks Limit' and click ")
	public void toOtherBanksVerifyClick() throws Exception {
		try {
			ButtonLabelVerifyClick(IOShomePgaeObject.toOtherBankButton(),CommonTestData.TO_OTHERBANK_LABEL.getEnumValue());;
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}

	}
	@Step("Verifying page header 'To Other Banks' title ")
	public void verifyTransferToOtherBankLimitTitle() throws Exception {
		try {
			String expectedText=CommonTestData.TRANSFER_TO_OTHERBANK_LABEL_LABEL.getEnumValue();
			fieldText( expectedText ,IOShomePgaeObject.ToOtherBankLimitTitle());

		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}
	public String handlingSetCurrentLimit() throws Exception {
		try {
			String currentText=getTexOfElement(IOShomePgaeObject.currentLimitTextButton());
			String[] arrOfStr = currentText.split(" ");
			verifyClickSetCurrentLimit();
			verifySetDailyLimitTitle();
			String selectedValue=null;
			if(arrOfStr[1].equalsIgnoreCase(CommonTestData.SELECTED_LIMIT_3.getEnumValue())) {
				selectAmountFromSetCurrentLimitList(CommonTestData.SELECTED_LIMIT_2.getEnumValue());
				selectedValue=CommonTestData.SELECTED_LIMIT_2.getEnumValue();
			}
			else if(arrOfStr[1].equalsIgnoreCase(CommonTestData.SELECTED_LIMIT_2.getEnumValue())) {
				selectAmountFromSetCurrentLimitList(CommonTestData.SELECTED_LIMIT_1.getEnumValue());
				selectedValue=CommonTestData.SELECTED_LIMIT_1.getEnumValue();}
			else if(arrOfStr[1].equalsIgnoreCase(CommonTestData.SELECTED_LIMIT_1.getEnumValue())) {
				selectAmountFromSetCurrentLimitList(CommonTestData.SELECTED_LIMIT_2.getEnumValue());
				selectedValue=CommonTestData.SELECTED_LIMIT_2.getEnumValue();}
			return selectedValue;
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}
	@Step("Verifying and click 'set current Limit' ")
	public void verifyClickSetCurrentLimit() throws Exception {
		try {
			ButtonVerifyClick(IOShomePgaeObject.currentLimitTextButton());
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}
	@Step("Verifying page header 'Set Daily Limit' ")
	public void verifySetDailyLimitTitle() throws Exception {
		try {
			String expectedText=CommonTestData.SET_DAILY_LIMIT_TITLE.getEnumValue();
			fieldText( expectedText ,IOShomePgaeObject.setDailyLimitTitle());

		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
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
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}
	@Step("Verifying page header 'Review Daily Limit'")
	public void verifyReviewDailyLimitTitle() throws Exception {
		try {
			String expectedText=CommonTestData.REVIEW_DAILY_LIMIT_TITLE.getEnumValue();
			fieldText( expectedText ,IOShomePgaeObject.reviewDailyLimitTitle());

		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}
	@Step("Verifying and click 'CHANGE DAILY LIMIT NOW' BUTTON ")
	public void verifyClickChangeDailyLimitNowButton() throws Exception {
		try {
			ButtonVerifyClick(IOShomePgaeObject.changeLimitNowButton());
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}
	

}
