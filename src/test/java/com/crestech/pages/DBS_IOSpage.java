package com.crestech.pages;

import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TakesScreenshot;
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
			TakeScreenshot(Button);
			String actualText = commonAppTest.getTexOfElement(Button);

			if (actualText.equalsIgnoreCase(expectecText))
				commonAppTest.clickOnElement(Button);

			Asserts.assertEquals(actualText.toLowerCase(),expectecText.toLowerCase(), "button Not exist");

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
			String actualText = commonAppTest.getTexOfElement(IOShomePgaeObject.topupNowButton());
//			if (actualText.equalsIgnoreCase(expectecText))
//				commonAppTest.clickOnElement(IOShomePgaeObject.topupNowButton());

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
		TakeScreenshot(IOShomePgaeObject.searchIcon());
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

	public void TakeScreenshot(MobileElement Element) throws Exception {
		try {
			wait.waitForElementVisibility(Element); 
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e)); 
		}
	}
	public void TakeScreenshot(RemoteWebElement Element) throws Exception {
		try {
			wait.waitForElementVisibility((MobileElement)Element); 
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e)); 
		}
	}
	@Step("Verifying button label and clicking on 'More' button ")
	public void MoreVerifyAndClickButton() throws Exception {
		try {
			TakeScreenshot(IOShomePgaeObject.moeButton());
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
            TakeScreenshot(IOShomePgaeObject.localTransferLimitLabel());
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
	public String handlingSetCurrentLimit(String AmountToBeselected) throws Exception {
		try {
			String currentText=getTexOfElement(IOShomePgaeObject.currentLimitTextButton());
			String[] arrOfStr = currentText.split(" ");
			
			verifyClickSetCurrentLimit();
			//verifySetDailyLimitTitle();
			
			String selectedValue=null;
					if (arrOfStr[1].equalsIgnoreCase(CommonTestData.SELECTED_LIMIT_0.getEnumValue())) {
						selectedValue = selectAmountFromSetCurrentLimitList(AmountToBeselected);
					} else 
		               {
						GestureUtils.scrollDOWNtoObject("text", CommonTestData.SELECTED_LIMIT_0.getEnumValue(), null);
						String flag=selectAmountFromSetCurrentLimitList(CommonTestData.SELECTED_LIMIT_0.getEnumValue());
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
			String expectedText=CommonTestData.SET_DAILY_LIMIT_TITLE.getEnumValue();
			fieldText( expectedText ,IOShomePgaeObject.setDailyLimitTitle());

		} catch (Exception e) {
			e.printStackTrace(); 
			throw e;
		}
	}
	@Step("Select amount from the List of 'set current Limit' ")
	public String selectAmountFromSetCurrentLimitList(String amount) throws Exception {
		try {
			
			String selectedAmount=null;
			List<RemoteWebElement> ElementCell=driver.findElementsByXPath("//XCUIElementTypeCell");
			TakeScreenshot(ElementCell.get(0));
			int sizeList=ElementCell.size();
			int index = 0;
			for (int i = 1; i <= sizeList; i++) {
				
				String xpath="//XCUIElementTypeCell"+"["+String.valueOf(i)+"]/XCUIElementTypeStaticText";
				String Text=driver.findElementByXPath(xpath).getText();
				System.out.println(Text);
				if (Text.equalsIgnoreCase(amount)) {
					selectedAmount=Text;
					index++;
					clickOnElement((MobileElement)driver.findElementByXPath(xpath));
					break;
				
			}
			}
			Asserts.assertTrue(index > 0, "No"+amount +"found in the list of corresponding value");
			return selectedAmount;
			
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
			e.printStackTrace(); throw e;
		}
	}
	@Step("Verify topup Paylah Case and logout topup Paylah.")
	public void TopupPaylah() throws Exception {
		try {
			payAndTransferVerifyClick();
			EnterPasscodeAndDone();
			topUpVerifyClick();
			 payLahVerifyClick();
			 sendCurrencyInTextField(CommonTestData.AMOUNT_PAYLAH.getEnumValue()); 
			 nextButtonVerifyClick();
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
			MoreVerifyAndClickButton();
			EnterPasscodeAndDone();
			sendDataInCommonSearchBoxAndSelectFromDropDown(CommonTestData.LOCAL_TRANSFER_LIMIT_SEARCHBOX_IOS.getEnumValue(),
					CommonTestData.LOCAL_TRANSFER_LIMIT_LABEL.getEnumValue());
			verifyLocalTransferLimitTitle();
			toOtherBanksVerifyClick();
			EnterPasscodeAndDone();
			String amountSlected = handlingSetCurrentLimit(CommonTestData.SELECTED_LIMIT_50000.getEnumValue());
			nextButtonVerifyClick();
			verifyReviewDailyLimitTitle();
			verifyClickChangeDailyLimitNowButton();
			EnterPasscodeAndDone2();
			verifyLocalTransferlimitChangedHeader(CommonTestData.LOCAL_LIMIT_INCREASE_SUCCESS_TITLE_IOS.getEnumValue());
			verifyClickBackToMoreButton();
			sendDataInCommonSearchBoxAndSelectFromDropDown(CommonTestData.LOCAL_TRANSFER_LIMIT_SEARCHBOX_IOS.getEnumValue(),
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
			fieldText( expectedText ,IOShomePgaeObject.localTransferLimitChangedTitle());
			
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
	@Step("Enter Passcode(123456) and click on Done button for Secure Pin Authentication.")
	public void EnterPasscodeAndDone2() throws Exception {
		try {
			Thread.sleep(10000);
			String xpath = "//XCUIElementTypeSecureTextField[@value='••••••']";
			List<RemoteWebElement> list = driver.findElements(By.xpath(xpath));
			if (list.size() > 0) {
				clickOnElement(IOShomePgaeObject.secureBox());
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				Thread.sleep(2000);
				for(int i=1;i<=6;i++) {
					String bxpath = "//XCUIElementTypeButton[@name="+i+"]";
					 MobileElement button = (MobileElement) driver.findElement(By.xpath(bxpath));
					clickOnElement(button);
				}	
			}
			
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}
	@Step("Verify 'You have added a Recipient ' after excecuting Payee Add Remittance Case.")
	public void PayeeAddRemittance() throws Exception {
		try {
			payAndTransferVerifyClick();
			EnterPasscodeAndDone();
			overseasVerifyClick(CommonTestData.OVERSEAS_ICON.getEnumValue());
			ClickOnAddRecipientNowBtn();
			sendCountryInSearchBoxAndSelectFromDropDown(CommonTestData.COUNTRY_AUS.getEnumValue(),
					CommonTestData.COUNTRY_AUS.getEnumValue());
			CurrencyTypeVerifyClick(CommonTestData.CURRENCY_AUS.getEnumValue());
			nextButtonVerifyClick();
			sendBankCode(CommonTestData.BANK_BCD_CODE.getEnumValue());
			nextButtonVerifyClick();
			verifyRecipientDetailHeaderAndEnterDetail(); 
			nextButtonVerifyClick();
			verifyRecipientReviewDetailAndClickOnAddRecipientVutton();
			EnterPasscodeAndDone2();
			Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.addedRecipientTitle()).toLowerCase(),
					CommonTestData.YOU_HAVE_ADDED_RECIPIENT_MSG.getEnumValue().toLowerCase(),
					"'You've added a recipient label' Text is not matching");
			verifyReferenceFieldAndItsValue(CommonTestData.REFERENCE_NUMBER.getEnumValue());
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
	}
	@Step("Verifying Overseas  icon and click")
	public void overseasVerifyClick(String expectecText) throws Exception {
		try {
             ButtonLabelVerifyClick(IOShomePgaeObject.overseasButton(), expectecText);

		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
	}
	@Step("clicking On 'ADD RECIPIENT NOW' button")
	public void ClickOnAddRecipientNowBtn() throws Exception {
		try {
			 ButtonVerifyClick(IOShomePgaeObject.addRecipientNowButton());
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}

	}
	@Step("Enter the text in search and select the corresponding value in the dropdown")
	public void sendCountryInSearchBoxAndSelectFromDropDown(String searchBoxData, String valueSelectedFromList) throws Exception {
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
			e.printStackTrace(); throw e;
		}
	}
	@Step("Select CurrencyType From the List")
	public void CurrencyTypeVerifyClick(String expectecCurrency) throws Exception {
		try {
			
			TakeScreenshot(IOShomePgaeObject.currencyList().get(1));
			List<MobileElement> Elementlist =IOShomePgaeObject.currencyList();
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
			e.printStackTrace(); throw e;
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
			e.printStackTrace(); throw e;
		}
	}
	@Step("click on done button")
	public void doneButtonIfAviliable() throws Exception
	{
		try {
		String doneButtonxpath = "//XCUIElementTypeButton[@name='Done']";
		List<RemoteWebElement> doneButtonList = driver.findElements(By.xpath(doneButtonxpath));
		if (doneButtonList.size() > 0)
			    TakeScreenshot(doneButtonList.get(0));
				clickOnElement(IOShomePgaeObject.doneButton());
			} catch (Exception e) {
			
				e.printStackTrace(); throw e;
			}
	}
	@Step("Enter data in Bank Code EditBox")
	public void verifyRecipientDetailHeaderAndEnterDetail() throws Exception {
		try {
			fieldText(CommonTestData.ENTER_RECIPIENT_DETAIL.getEnumValue(), IOShomePgaeObject.recipientDetailTitle());
			
			sendAccountNo(CommonTestData.ACCOUNT_NO.getEnumValue());
			sendFullName(CommonTestData.FULL_NAME.getEnumValue());
			GestureUtils.scrollUPtoObject("name", "NEXT", null);
			sendAddress(CommonTestData.ADDRESS.getEnumValue());
			sendcity(CommonTestData.CITY.getEnumValue());
			

		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
	}
	@Step("Enter Account No EditBox")
	public void sendAccountNo(String text) throws Exception {
		try {
			TakeScreenshot(IOShomePgaeObject.recipientDetailAccountNumver());
			if (isElementEnable((IOShomePgaeObject.recipientDetailAccountNumver())))
				enterTextInTextbox(IOShomePgaeObject.recipientDetailAccountNumver(), text);
			
			doneButtonIfAviliable();
			// Asserts.assertTrue(isElementEnable(DBSappObject.recipientAccountNoEditBox()),
			// "EditField is not enable");
		} catch (Exception e) {
			e.printStackTrace(); throw e;
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
			e.printStackTrace(); throw e;
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
			e.printStackTrace(); throw e;
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
			e.printStackTrace(); throw e;
		}
	}
	@Step("Verify 'REVIEW RECIPIENT'S DETAILS label' and Click on 'Add Recipient Now' button")
	public void verifyRecipientReviewDetailAndClickOnAddRecipientVutton() throws Exception {
		try {
			fieldText(CommonTestData.REVIEW_RECIPIENT_LABEL.getEnumValue(), IOShomePgaeObject.reviewRecipientDetailTitle());
			ButtonVerifyClick(IOShomePgaeObject.addRecipientNowButton());

		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
	}
	@Step("Verify 'Reference No. Field and its value' field and Verify 'MAKE A TRANSFER' Button After Expanding & Scrolling to the Page.")
	public void verifyReferenceFieldAndItsValue(String expectedText) throws Exception {
		try {
			clickOnElement(IOShomePgaeObject.expandButton());
			GestureUtils.scrollUPtoObject("name", "Reference No.", IOShomePgaeObject.referenceNumber());
			TakeScreenshot(IOShomePgaeObject.makeTransfer());
			Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.makeTransfer()).toLowerCase(),
					CommonTestData.MAKE_TRANSFER.getEnumValue().toLowerCase(), "'MAKE A TRANSFER' Text is not found");
			Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.referenceNumber()).toLowerCase(), expectedText.toLowerCase(),
					"'Reference no Field' is not found");
			boolean i = IOShomePgaeObject.referenceNoValue().getText().isEmpty();
			Asserts.assertTrue(i == false, "Reference Number not Found");
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
	}
	@Step("Verify Transaction History")
	public void transactionHistoryVerify() throws Exception {
		try {
			MoreVerifyAndClickButton();
			EnterPasscodeAndDone();
			ClickOnTransactionHistory();
			SelectTimeAndAccountTypeForStatement(CommonTestData.ACCOUNT_NAME.getEnumValue(),CommonTestData.CURRENCY_NAME.getEnumValue());
			GestureUtils.scrollUPtoObject("name", "SHOW", null);
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
			EnterPasscodeAndDone2();
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
			payAndTransferVerifyClick();
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

			GestureUtils.DragAndDropElementToElement(IOShomePgaeObject.allTabList().get(o), IOShomePgaeObject.allTab());
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
//			String ErrorMsg = getTexOfElement(DBSappObject.ErrorMessgeElement());
//
//			if (CommonTestData.ERROR_MSG.getEnumValue().equals(ErrorMsg)) {
//				TakeScreenshot(DBSappObject.OKButton());
//				clickOnElement(DBSappObject.OKButton());
//			}
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
			nextButtonVerifyClick();
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
			GestureUtils.scrollUPtoObject("name", "Reference No.", IOShomePgaeObject.referenceNo());
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
			//GestureUtils.scrollUPtoObject("text", "digiPortfolio", null);
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
			payAndTransferVerifyClick();
			EnterPasscodeAndDone();
			overseasVerifyClick(CommonTestData.OVERSEAS_ICON.getEnumValue());
			SelectingPayeeAfterSelectingOverseas(CommonTestData.PAYEE_NAME_CORRIDOR.getEnumValue());
			selectFundSourceAndSelectAccountForCorredor(CommonTestData.SOURCE_ACCOUNT_NAME_CORRIDOR.getEnumValue());
			pressEnterKeyAfterEnteringAmount(CommonTestData.CORRIDOR_AMOUNT.getEnumValue());
			GestureUtils.scrollUPtoObject("name", "NEXT",  null);
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
			
			nextButtonVerifyClick();
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
			GestureUtils.scrollUPtoObject("name", "Reference No.", IOShomePgaeObject.referenceNo());
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
			GestureUtils.scrollUPtoObject("name", "SHARE TRANSFER DETAILS", null);
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
			int l = Elementlist.size();
			int index = 0;
			String LocalRecipientList = null;
			for (int i = 0; i < l; i++) {
				LocalRecipientList = Elementlist.get(i).getText();
				if (LocalRecipientList.contains(AccountType)) {
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
				payAndTransferVerifyClick();
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
				GestureUtils.scrollUPtoObject("name", "Next", null);
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
				MoreVerifyAndClickButton();
				EnterPasscodeAndDone();
				sendDataInCommonSearchBoxAndSelectFromDropDown(CommonTestData.TEMP_LIMIT_INCREASE.getEnumValue(), CommonTestData.TEMP_LIMIT_INCREASE.getEnumValue());
				fieldText(CommonTestData.TEMP_LIMIT_INCREASE.getEnumValue(), IOShomePgaeObject.temporaryLimitIncreaseHeader());
				setAmountDurationPurposeForLimitIncrease("100", "wedding");
				GestureUtils.scrollUPtoObject("name", "NEXT", null );
				nextButtonVerifyClick();
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


}