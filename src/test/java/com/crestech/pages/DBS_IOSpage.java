package com.crestech.pages;

import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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
			EnterPasscodeAndDone();
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
				enterTextInTextbox(IOShomePgaeObject.secureBox(), CommonTestData.OTP.getEnumValue());
			    Thread.sleep(5000);
			}
			TakeScreenshot(IOShomePgaeObject.secureBox());
			
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}
	
}