package com.crestech.pages;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;
import static org.testng.Assert.assertFalse;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebElement;
import com.crestech.appium.utils.CommonAppiumTest;
import com.crestech.common.utilities.AndroidAlert;
import com.crestech.common.utilities.Asserts;
import com.crestech.common.utilities.CommonAlertElements;
import com.crestech.common.utilities.CommonTestData;
import com.crestech.common.utilities.GestureUtils;
import com.crestech.common.utilities.HandleException;
import com.crestech.common.utilities.WaitUtils;
import com.crestech.pageobjects.DBS_IOSObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.qameta.allure.Step;

public class DBS_IOSpage extends CommonAppiumTest {

	static Logger log = Logger.getLogger(DBSAndroidPage.class.getName());
	public DBS_IOSObject IOShomePgaeObject = new DBS_IOSObject(driver);
	CommonAppiumTest commonAppTest = null;
	AndroidAlert androidAlert = null;
	GestureUtils gestUtils = null;
	public  TouchAction touch =null;
    HandleException obj_handleexception=null;

	public DBS_IOSpage(AppiumDriver<RemoteWebElement> driver) {
		super(driver);
		gestUtils = new GestureUtils(driver);
		commonAppTest = new CommonAppiumTest(driver);
		androidAlert = new AndroidAlert(driver);
		touch = new TouchAction(this.driver);
		obj_handleexception=new HandleException(null,null);
		// PageFactory.initElements(new AppiumFieldDecorator(driver,
		// Duration.ofSeconds(5)), IOShomePgaeObject);
	}

	@Step("Enter data in User EditBox")
	public void sendDataInUserId(String text) throws Exception {
		try {
			Asserts.assertTrue(isElementEnable(IOShomePgaeObject.userIdEditBox()), "EditField is not enable");
			if (isElementEnable(IOShomePgaeObject.userIdEditBox()))
				enterTextInTextbox(IOShomePgaeObject.userIdEditBox(), text);
			//TakeScreenshot(IOShomePgaeObject.userIdEditBox());

		}  catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Send USER ID In Input Box " ,e);
					
		}
		catch (Exception e) {			
			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Send USER ID In Input Box ",e);
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
			//TakeScreenshot(IOShomePgaeObject.userPinEditBox());

		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Send USER PIN In Input Box " ,e);
					
		}
		catch (Exception e) {			
			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Send USER PIN In Input Box ",e);
		}
	}

	
	public void locationSwipPopup_1() throws Exception    
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
			TakeScreenshot(IOShomePgaeObject.logInButton_2());
			clickOnElement(IOShomePgaeObject.logInButton_2());
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Login Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Login Button ", e);
		}
	}

	@Step("Clicked on Login button")
	public void clickOnLoginButton_0() throws Exception {
		try { 
			TakeScreenshot(IOShomePgaeObject.logInButton_0());
			clickOnElement(IOShomePgaeObject.logInButton_0());
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Login Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Login Button ", e);
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
//			Thread.sleep(5000);
//			String xpath = "//XCUIElementTypeStaticText[@name='Let's Set Up']']";
//			List<RemoteWebElement> list = driver.findElements(By.xpath(xpath));
//			if (list.size() > 0) {
			if(isElementVisible2(IOShomePgaeObject.fingerpringAlertMessage())) {
				ButtonVerifyClick(IOShomePgaeObject.fingerpringAlertClosedButton());
//				androidAlert.AlertHandlingWithButtonMessage(IOShomePgaeObject.fingerpringAlertClosedButton(),
//						CommonTestData.SETUP.getEnumValue(), IOShomePgaeObject.fingerpringAlertMessage());
				}
			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Handling FingurePrint Alert  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Handling FingurePrint Alert ", e);
		}

	}

	@Step("Handling Recording Alert")
	public void handlingRecordingAlert() throws Exception // android.widget.Toast[1]
	{
		try {
//			Thread.sleep(1000);
//			String xpath = "//XCUIElementTypeButton[@name='introClose']";
//			List<RemoteWebElement> list = driver.findElements(By.xpath(xpath));
//			if (list.size() > 0) {
			if(isElementVisible2(IOShomePgaeObject.recordingAlertClosedButton())) {
				ButtonVerifyClick(IOShomePgaeObject.recordingAlertClosedButton());
//				androidAlert.AlertHandlingWithButtonMessage(IOShomePgaeObject.recordingAlertClosedButton(),
//						CommonTestData.RECORDERSECTION_MESSAGE.getEnumValue(), IOShomePgaeObject.recordingAlertMessage());
				}
			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Handling Recording Alert  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Handling Recording Alert ", e);
		}

	}

	@Step("Handling MOTION AND FITNESS ALERT Alert")
	public void handlingMotionAndFitnessAlert() throws Exception // android.widget.Toast[1]
	{
		try {
			
//			Thread.sleep(1000);
//			String Xpath = "//XCUIElementTypeStaticText[contains(@name,'Like to Access Your Motion & Fitness Activity')]";
//			List<RemoteWebElement> list = driver.findElements(By.xpath(Xpath));
//			if (list.size() > 0) {
			if(isElementVisible2(IOShomePgaeObject.alertFitnessActivityTitle())) {
				ButtonVerifyClick(IOShomePgaeObject.alertOkButton());
//			androidAlert.AlertHandlingWithButtonMessage(IOShomePgaeObject.alertFitnessActivityTitle(),
//					CommonTestData.SETUP.getEnumValue(), IOShomePgaeObject.alertOkButton());
			}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Handling MOTION AND FITNESS ALERT Alert  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Handling MOTION AND FITNESS ALERT Alert ", e);
		}

	}
	@Step("verify 'Text' Field")
	public void fieldText(String expectedText, MobileElement Element) throws Exception {
		try {
			TakeScreenshot(Element);
			String actualText = getTexOfElement(Element).trim();

			Asserts.assertEquals(actualText.toLowerCase(), expectedText.toLowerCase(), "text is not found");

		} 
		catch (Exception e) {			
			
			obj_handleexception.throwException("TEXT_VERIFICATION_EXCEPTION", " Failed to Verify Acutal and Expected Text ",e);
		}
	}
	@Step("verify 'Text' Display")
	public void fieldText(MobileElement Element) throws Exception {
		try {
			TakeScreenshot(Element);
			Asserts.assertTrue(isElementVisible2(Element), "text is not found");

		} 
		catch (Exception e) {			
			
			obj_handleexception.throwException("TEXT_VERIFICATION_EXCEPTION", " Failed to Verify Acutal and Expected Text ",e);
		}
	}

	@Step("verify 'Welcome To' Field")
	public void verifyWelcomeToText() throws Exception {
		try {
			fieldText(CommonTestData.WELCOME.getEnumValue(), IOShomePgaeObject.welcomeToText());

		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to verify 'Welcome To' Field  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to verify 'Welcome To' Field ", e);
		}
	}
	@Step("verify 'Welcome To' Field")
	public void verifyWelcomeToTextIwealth() throws Exception {
		try {
			fieldText(CommonTestData.WELCOME.getEnumValue(), IOShomePgaeObject.welcomeToTextIwealth());

		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to verify 'Welcome To' Field  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to verify 'Welcome To' Field ", e);
		}
	}

	@Step("verify 'digibank' Field")
	public void verifyDigibankText() throws Exception {
		try {
			fieldText(CommonTestData.DIGIBANK.getEnumValue(), IOShomePgaeObject.digibankText());

		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to verify 'digibank' Field  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to verify 'digibank' Field ", e);
		}
	}
	@Step("verify 'DBS digibank' Field")
	public void verifyDigibankwealthText() throws Exception {
		try {
			fieldText(CommonTestData.DIGIBANK.getEnumValue(), IOShomePgaeObject.digibankTextwealth());

		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to verify 'DBS digibank' Field  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to verify ' DBS digibank' Field ", e);
		}
	}

	@Step("Application click and Verifies Logout")
	public void clickOnLogoutAndVerify() throws Exception {
		try {
			androidAlert.AlertHandlingWithButtonMessage(IOShomePgaeObject.logOutButton(),
					CommonTestData.LOGOUT_ISO.getEnumValue(), IOShomePgaeObject.logOutButton());
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Login Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Login Button ", e);
		}
	}
	@Step(" Verifies the 'Tap on the stars to rate' field Message.")
	public void VerifyTabOnStarText(String Ratingmsg) throws Exception {
		try {

			Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.tapOnStarMessage()), Ratingmsg,
					"'Tap on the stars to rate' Text is not found");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " FAILED to find Element ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " FAILED to find Element ", e);
		}
	}

	@Step("Button Label Verify and Click")
	public void ButtonLabelVerifyClick(MobileElement Button, String expectecText) throws Exception {
		try {
			TakeScreenshot(Button);
			String actualText = commonAppTest.getTexOfElement(Button);

			if (actualText.equalsIgnoreCase(expectecText))
				commonAppTest.clickOnElement(Button);

			Asserts.assertEquals(actualText.toLowerCase(), expectecText.toLowerCase(), "button Not exist");

		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On button  ", e);
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
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On pay and transfer Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On pay and transfer Button ", e);
		}
	}

	@Step("verify and click 'Topup' Field")
	public void topUpVerifyClick() throws Exception {
		try {
			ButtonLabelVerifyClick(IOShomePgaeObject.topUpButton(), CommonTestData.TOPUP_LABEL_IOS.getEnumValue());

		}catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to verify TopUp lable and click  ",e);
					
		}
		catch (Exception e) {			
			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to verify TopUp lable and click  ",e);
		}
	}

	@Step("verify and click 'PayLah!' Field")
	public void payLahVerifyClick() throws Exception {
		try {
			ButtonVerifyClick(IOShomePgaeObject.payLahButton());

		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to verify Paylah label and click  ",e);
					
		}
		catch (Exception e) {			
			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to verify Paylah label and click  ",e);
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
	public void sendCurrencyInTextField(String text) throws HandleException {
		try {
			Asserts.assertTrue(isElementEnable(IOShomePgaeObject.amountEditBox()), "EditField is not enable");
			if (isElementEnable(IOShomePgaeObject.amountEditBox()))
				enterTextInTextbox(IOShomePgaeObject.amountEditBox(), text);
			Thread.sleep(2000);
			String doneButtonxpath = "//XCUIElementTypeButton[@name='Done']";
			List<RemoteWebElement> doneButtonList = driver.findElements(By.xpath(doneButtonxpath));
			if (doneButtonList.size() > 0)
				clickOnElement(IOShomePgaeObject.doneButton());

		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to enter currency   ",e);
					
		}
		catch (Exception e) {			
			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to enter currency  ",e);
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
	public void verifyReviewTopUpLabel(String expectedText) throws HandleException {
		try {

			fieldText(expectedText, IOShomePgaeObject.reviewToUpLabel());

		}  catch (HandleException e) {	
			obj_handleexception.throwHandleException("FIELDVERIFICATION_EXCEPTION", " Failed to verify fileds:TopUp Label and Enter Amount  ",e);
					
		}
		catch (Exception e) {			
			
			obj_handleexception.throwException("FIELDVERIFICATION_EXCEPTION", " Failed to verify fileds:TopUp Label and Enter Amount  ",e);
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
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Next Button ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Next Button ",e);
		}
	}
	@Step("Next click")
	public void ClickOnNextButton2() throws Exception {
		try {
			ButtonVerifyClick(IOShomePgaeObject.nextButton2());
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to click on next button ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to click on next button ",e);
		}

	}

	@Step("Verifying TOP UP NOW  Label and click")
	public void topUpNowVerifyClick() throws Exception {
		try {
			ButtonVerifyClick(IOShomePgaeObject.topupNowButton());
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to verify click on TopUp Now Button and Top-up Done field and Display amount  ",e);
					
		}
		catch (Exception e) {			
			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to verify click on TopUp Now Button and Top-up Done field and Display amount  ",e);
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

		}catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to click on LogOut Button  ",e);
					
		}
		catch (Exception e) {			
			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to click on LogOut Button  ",e);
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
	public void logInApplication(String userName, String password ,String app_Name) throws Exception {
		try {
			clickOnPreLoginButton();
			//selectUATserver("UAT N1");
			clickOnLoginButton_0();
			sendDataInUserId(userName);
			sendDataInUserPin(password);
			//String s1 = driver.getPageSource();
			//System.out.println(s1);
			 clickOnLoginButton_2();
			 this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
             digitalToken();
             handlingMotionAndFitnessAlert();
             if(app_Name=="DBS") {
            	 locationSwipPopup();
            	 }
             else
            	 managementSwipeAlert();
       
             
             handlingFingurePrintAlert();
             handlingRecordingAlert();
             this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
             if(app_Name=="DBS") {
            	 verifyWelcomeToText();
                 verifyDigibankText();
            	 }
             else
             {
            	 verifyWelcomeToTextIwealth();
                verifyDigibankwealthText();
             }


		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Login the application with USER ID and PIN ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Login the application with USER ID and PIN ", e);
		}
	}

	@Step("Logout the application")
	public void logOutApplication() throws Exception {
		try {

			clickOnLogoutAndVerify();
			VerifyTabOnStarText(CommonTestData.RATE_MESSAGE.getEnumValue());
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Verify Logout the application  ",e);			
		}
		catch (Exception e) {			
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Verify Logout the application  ",e);
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
			if(ElementCell.size() > 0) {
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
			Asserts.assertTrue(index > 0, "No "+valueSelectedFromList +"element found in the search list");
			}
			else {
				if(androidAlert.isAlertPresent()) {
					System.out.println("Alert title :: "+this.driver.switchTo().alert().getText()); 
					Asserts.assertFail(this.driver.switchTo().alert().getText());
				}	
				Asserts.assertFail(valueSelectedFromList + " not found in the list as list size is 0");
			}
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select Data From Dropdown.  ",e);			
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select Data From Dropdown.  ",e);
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
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On 'More' button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On 'More' button ", e);
		}
	}

	@Step("Verifying page header 'Local Transfer Limit' ")
	public void verifyLocalTransferLimitTitle() throws Exception {
		try {
			String expectedText = CommonTestData.LOCAL_TRANSFER_LIMIT_LABEL.getEnumValue();
			fieldText(expectedText, IOShomePgaeObject.localTransferLimitLabel());
			TakeScreenshot(IOShomePgaeObject.localTransferLimitLabel());
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verifying page header 'Local Transfer Limit'  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verifying page header 'Local Transfer Limit' ", e);
		}
	}

	@Step("Verifying 'To Other Banks Limit' and click ")
	public void toOtherBanksVerifyClick() throws Exception {
		try {
			ButtonLabelVerifyClick(IOShomePgaeObject.toOtherBankButton(),
					CommonTestData.TO_OTHERBANK_LABEL.getEnumValue());
			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verifying 'To Other Banks Limit' and click  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verifying 'To Other Banks Limit' and click ", e);
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

		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Set Current Limit " ,e);	
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Set Current Limit ",e);
		}
		return null;
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

		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Set Amount from Current Limit " ,e);	
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Set Amount from Current Limit ",e);
		}
		return null; 
	}

	@Step("Verifying page header 'Review Daily Limit'")
	public void verifyReviewDailyLimitTitle() throws Exception {
		try {
			String expectedText = CommonTestData.REVIEW_DAILY_LIMIT_TITLE.getEnumValue();
			fieldText(expectedText, IOShomePgaeObject.reviewDailyLimitTitle());
			//TakeScreenshot(IOShomePgaeObject.reviewDailyLimitTitle());
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Verifying page header 'Review Daily Limit' " ,e);	
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Verifying page header 'Review Daily Limit' ",e);
		}
	}

	@Step("Verifying and click 'CHANGE DAILY LIMIT NOW' BUTTON ")
	public void verifyClickChangeDailyLimitNowButton() throws Exception {
		try {
			ButtonVerifyClick(IOShomePgaeObject.changeLimitNowButton());
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Verifying and click 'CHANGE DAILY LIMIT NOW' BUTTON  " ,e);	
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Verifying and click 'CHANGE DAILY LIMIT NOW' BUTTON  ",e);
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
			
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Execute TopUp Paylah  ",e);
					
		}
		catch (Exception e) {			
			
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Execute TopUp Paylah  ",e);
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
		}catch (HandleException e) {	
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Exceute Change Local Funds Transfer Limit " ,e);			
		}
		catch (Exception e) {			
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Exceute Change Local Funds Transfer Limit ",e);
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
			//TakeScreenshot(IOShomePgaeObject.localTransferLimitChangedTitle());
			fieldText(expectedText, IOShomePgaeObject.localTransferLimitChangedTitle());

		}catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verify 'Local Transfer limit Changed' field ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify 'Local Transfer limit Changed' field ", e);
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
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verify Display Amount Local Transfer Limit Change ",e);		
		}
		catch (Exception e) {				
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify Display Amount Local Transfer Limit Change ",e);
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
			List<RemoteWebElement> recipientDetailsHeader = driver.findElements(By.name("Review Recipient's Details"));
			Asserts.assertTrue(isElementVisible2((MobileElement) recipientDetailsHeader.get(recipientDetailsHeader.size()-1)),
					CommonTestData.REVIEW_RECIPIENT_DETAILS.getEnumValue() + " Page Header not displaying.");

			ClickOnAddRecipientNowBtn();
			VerifyYouHaveAddedRecipientMsgAfterEnterSecurePIN();
			verifyValidationForPayeeAdd(ExpectedRecipientName, CommonTestData.PAYEEADD_DBSPOSB_BANK_NAME.getEnumValue(),
					CommonTestData.PAYEEADD_DBSPOSB_ACCOUNT_NUMBER.getEnumValue());
			
			// Leave On Home Page to this test case for next run.
			//ClickOnCloseButton();
			//ClickOnHomeButton();
		}catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Execute Add payee DBSorPOSB  ",	e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Execute Add payee DBSorPOSB  ", e);
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
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Delete Payee to DBS/POSB ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Delete Payee to DBS/POSB ", e);
		}
	} 
	

	@Step("Click On Local Button.")
	public void clickOnLocalButton() throws Exception {
		try {
			TakeScreenshot(IOShomePgaeObject.LocalButton());
			clickOnElement(IOShomePgaeObject.LocalButton());
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Local Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Local Button ", e);
		}
	}

	public void TakeScreenshot(MobileElement Element) throws Exception {
		try {
			//wait.waitForElementVisibility(Element);
			//com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
	}
	//			catch (HandleException e) {
//			obj_handleexception.throwHandleException("SCREENSHOT", " Failed to capture the screenshot ",e);
//		}
		catch (Exception e) {
			obj_handleexception.throwException("SCREENSHOT", " Failed to capture the screenshot ",e);
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
			ClickOnNextButton2();
			List<RemoteWebElement> reviewRecipientDetailsPageHeader = driver.findElements(By.name("Review Recipient's Details"));
			Asserts.assertTrue(isElementVisible2((MobileElement) reviewRecipientDetailsPageHeader.get(reviewRecipientDetailsPageHeader.size()-1)),
					CommonTestData.REVIEW_RECIPIENT_DETAILS.getEnumValue() + " Page Header not displaying.");
			ClickOnAddRecipientNowBtn();
			VerifyYouHaveAddedRecipientMsgAfterEnterSecurePIN();
			verifyValidationForPayeeAdd(ExpectedRecipientName, CommonTestData.LOCAL_RECIPIENT_BANK_NAME.getEnumValue(),
					ExpectedAccountNumber);

			// Leave On Home Page to this test case for next run.
			ClickOnCloseButton();
			ClickOnHomeButton();	
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Execute Payee Add Local Other Bank ",	e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Execute Payee Add Local Other Bank  ", e);
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
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Delete Payee to Local To Other Bank ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Delete Payee to Local To Other Bank ",e);
		}
	} 
	
	
	@Step("Click on 'Home' Button.")
	public void ClickOnHomeButton() throws Exception {
		try {
			TakeScreenshot(IOShomePgaeObject.HOMEButton()); 
			clickOnElement(IOShomePgaeObject.HOMEButton());
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On 'Home' Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On 'Home' Button ", e);
		}
	}
	
	@Step("Click on 'Close' Button.")
	public void ClickOnCloseButton() throws Exception {
		try {
			TakeScreenshot(IOShomePgaeObject.closeButton()); 
			clickOnElement(IOShomePgaeObject.closeButton());
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Click on 'Close' Button  ",	e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Click on 'Close' Button ", e);
		}
	}

	@Step("Delete Payee.")
	public void DeletePayee(String ExpectedPayee) throws Exception {
		try {
			//int size = IOShomePgaeObject.localRecipientsList().size();
			if(IOShomePgaeObject.localRecipientsList().size() > 0) {
//				String RecipientNameXpath = "//XCUIElementTypeStaticText[@name='" + ExpectedPayee + "']";
//				MobileElement RecipientNameElement = (MobileElement) driver.findElement(By.xpath(RecipientNameXpath));
//				String recipientNameText = RecipientNameElement.getText();
				//int ExpectedTotalPayeeSize = IOShomePgaeObject.IiconList().size();
				int ExpectedTotalPayeeSize = IOShomePgaeObject.localRecipientsList().size();
				int ExpectedTotalPayee = IOShomePgaeObject.IiconList().size();
				for (int i = 0; i < ExpectedTotalPayeeSize; i++) {
					if(isElementVisible2(IOShomePgaeObject.localRecipientsList().get(i))) {
						String actualPayee = IOShomePgaeObject.localRecipientsList().get(i).getText();
						if(actualPayee.contains(ExpectedPayee) ) {
							clickOnElement(IOShomePgaeObject.IiconList().get(i/2));
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
							if (isElementVisible2(DeletePayeeMessageElement)) {
								TakeScreenshot(IOShomePgaeObject.OKButton());
								clickOnElement(IOShomePgaeObject.OKButton());
								Thread.sleep(5000);
								int ActualTotalPayeeSize = IOShomePgaeObject.IiconList().size();
								int ExpectedTotalSizeAfterDeletingPayee = ExpectedTotalPayee - 1;
								Asserts.assertEquals(String.valueOf(ExpectedTotalSizeAfterDeletingPayee),
										String.valueOf(ActualTotalPayeeSize), " Payee is not deleting after adding payee.");
								break;
							}
						} 
					}
					else {
						Dimension windowSize1 = driver.manage().window().getSize();
						int y =(int)((windowSize1.getHeight())-10);
						int x =(int)((windowSize1.getWidth())/2);
						gesture.swipeCoordinatetoCoordinate(x,20,x,y);
					}
				}
			}
//			else
//			{
//				Asserts.assertFail("No Receipient found in the Local Payee list");
//			}
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Delete Payee ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Delete Payee ",e);
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
		}catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verify 'You Have Added Recipient Msg' After Entering Secure PIN. ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify 'You Have Added Recipient Msg' After Entering Secure PIN. ", e);
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
		}  catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On ADD RECIPIENT NOW Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On ADD RECIPIENT NOW Button ", e);
		}
	}

	@Step("Enter Recipient Details Into Bank Account Section.")
	public void EnterRecipientDetailsAfterSelectingBankAccountOption(String ExpectedRecipientName, String BankName,
			String AccountNumber) throws Exception {
		try {
			TakeScreenshot(IOShomePgaeObject.SelectBankAccount());
			do {
				clickOnElement(IOShomePgaeObject.SelectBankAccount());
				Thread.sleep(2000);
			}while(isElementVisible2(IOShomePgaeObject.SelectBankAccount()));
			List<RemoteWebElement> recipientDetailsHeader = driver.findElements(By.name("Enter Recipient's Details"));
			//System.out.print(IOShomePgaeObject.EnterRecipientDetailsPageHeader().getText());
			Asserts.assertTrue(isElementVisible2((MobileElement) recipientDetailsHeader.get(recipientDetailsHeader.size()-1)),
					" 'Enter Recipient's Details' Page Header not displaying.");
			List<RemoteWebElement> recipientName = driver.findElements(By.name("Enter recipient's name"));
			enterTextInTextbox((MobileElement) recipientName.get(recipientName.size()-1), ExpectedRecipientName);

			List<RemoteWebElement> selectBankDropdown = driver.findElements(By.name("Select bank"));
			clickOnElement((MobileElement) selectBankDropdown.get(selectBankDropdown.size()-1));
			List<RemoteWebElement> searchBankNameField = driver.findElements(By.name("Search Bank Name"));
			clickOnElement((MobileElement) searchBankNameField.get(searchBankNameField.size()-1));
			enterTextInTextbox((MobileElement) searchBankNameField.get(searchBankNameField.size()-1), BankName);
			
			MobileElement Selectbank = (MobileElement) driver.findElement(By.name(BankName));
			clickOnElement(Selectbank);
			
			List<RemoteWebElement> enterAccountNumberEditField = driver.findElements(By.name("Enter account no."));
			enterTextInTextbox((MobileElement) enterAccountNumberEditField.get(enterAccountNumberEditField.size()-1), AccountNumber);
			doneButtonIfAviliable();
			
		}catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Enter Recipient Details Into Bank Account Section.  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Enter Recipient Details Into Bank Account Section. ", e);
		}
	}

	@Step("clicking On 'ADD RECIPIENT NOW' button")
	public void ClickOnAddRecipientNowBtn() throws Exception {
		try {
			
			String actualText = getTexOfElement(IOShomePgaeObject.ADDRecipientNowButton());
			if (actualText.equalsIgnoreCase(CommonTestData.ADD_RECIPIENT_LABEL.getEnumValue()))
				clickOnElement(IOShomePgaeObject.ADDRecipientNowButton());
			Thread.sleep(4000);
			Asserts.assertEquals(actualText, CommonTestData.ADD_RECIPIENT_LABEL.getEnumValue(), "Button not matching");
		}catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On ADD RECIPIENT NOW Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On ADD RECIPIENT NOW Button ", e);
		}
	}
	
	
	@Step("Verify 'You Have Added Recipient Msg' After Entering Secure PIN.")
	public void VerifyYouHaveAddedRecipientMsgAfterEnterSecurePIN() throws Exception {
		try {
			//EnterPasscodeAndDone();
			EnterPasscode();
			Thread.sleep(20000);
			TakeScreenshot(IOShomePgaeObject.SuccessImage().get(3));
			List<RemoteWebElement> youHaveAddedRecipient = driver.findElements(By.name("You've added a recipient"));
			//if (isElementVisible(IOShomePgaeObject.SuccessImage().get(3)))
				Asserts.assertEquals(getTexOfElement((MobileElement) youHaveAddedRecipient.get(youHaveAddedRecipient.size()-1)),
						CommonTestData.YOU_HAVE_ADDED_RECIPIENT_MSG2.getEnumValue(),
						CommonTestData.YOU_HAVE_ADDED_RECIPIENT_MSG2.getEnumValue() + " Text is not matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verify 'You Have Added Recipient Msg' After Entering Secure PIN. ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify 'You Have Added Recipient Msg' After Entering Secure PIN. ", e);
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
				Thread.sleep(5000);
				String doneButtonxpath = "//XCUIElementTypeButton[@name='Done']";
				List<RemoteWebElement> doneButtonList = driver.findElements(By.xpath(doneButtonxpath));
				if (doneButtonList.size() > 0)
					clickOnElement(IOShomePgaeObject.doneButton());
			}
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("ENTER_PASSCODE_EXCEPTION", " Failed to enter passcode  ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("ENTER_PASSCODE_EXCEPTION", " Failed to enter passcode  ",e);
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

		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("ENTER_PASSCODE_EXCEPTION", " Failed to enter passcode  ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("ENTER_PASSCODE_EXCEPTION", " Failed to enter passcode  ",e);
		}
	}

	@Step("Verify 'You have added a Recipient ' after excecuting Payee Add Remittance Case.")
	public void PayeeAddRemittance() throws Exception {
		try {
			ClickOnPayAndTransferButton();
			EnterPasscodeAndDone();
			overseasVerifyClick(CommonTestData.OVERSEAS_ICON.getEnumValue());
			//TakeScreenshot(IOShomePgaeObject.ADDRecipientNowButton());
			//ButtonVerifyClick(IOShomePgaeObject.ADDRecipientNowButton());
			//clickOnAddLocalRecipientBtnAndVerifyLocalTransferPayNowPageHeader();
			//ClickOnAddRecipientNowBtn();
			ClickOnAddOverseaRecipientButton();
//			sendCountryAUSInSearchBoxAndSelectFromDropDown(CommonTestData.COUNTRY_AUS.getEnumValue(),
//					CommonTestData.COUNTRY_AUS.getEnumValue());
			sendCountryInSearchBoxAndSelectFromDropDown(CommonTestData.COUNTRY_AUS_SEARCH.getEnumValue(),
					CommonTestData.COUNTRY_AUS.getEnumValue());
			CurrencyTypeVerifyClick(CommonTestData.CURRENCY_AUS.getEnumValue());
			ClickOnNextButton();
			sendBankCode(CommonTestData.BANK_BCD_CODE.getEnumValue());
			ClickOnNextButton();
			verifyRecipientDetailHeaderAndEnterDetail();
			ClickOnNextButton();
			verifyRecipientReviewDetailAndClickOnAddRecipientVutton();
			EnterPasscode();
			verifyYouHaveAddedRecipient();
//			Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.addedRecipientTitle()).toLowerCase(),
//					CommonTestData.YOU_HAVE_ADDED_RECIPIENT_MSG2.getEnumValue().toLowerCase(),
//					"'You've added a recipient label' Text is not matching");
			verifyReferenceFieldAndItsValue(CommonTestData.REFERENCE_NUMBER.getEnumValue());
		}
		catch (HandleException e) {	
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Execute Add payee Remittance  ",e);
					
		}
		catch (Exception e) {			
			
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Execute Add payee Remittance  ",e);
		}
	}
	@Step("Delete Payee to Remittence")
	public void DeletePayee_ToRemittence() throws Exception {
		try {
			ClickOnPayAndTransferButton();
			EnterPasscodeAndDone();
			overseasVerifyClick(CommonTestData.OVERSEAS_ICON.getEnumValue());
			DeletePayee(CommonTestData.FULL_NAME.getEnumValue());
			
			// Leave On Home Page to this test case for next run.
			ClickOnCloseButton();
			ClickOnHomeButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Delete Payee to DBS/POSB ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Delete Payee to DBS/POSB ", e);
		}
	} 
	@Step("Verifying Header You've added a recipient")
	public void verifyYouHaveAddedRecipient() throws Exception {
		try {
			fieldText(CommonTestData.YOU_HAVE_ADDED_RECIPIENT_MSG2.getEnumValue(),IOShomePgaeObject.addedRecipientTitle());
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verifying Header You've added a recipient ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verifying Header You've added a recipient ", e);
		}
	}

	@Step("Verifying Overseas  icon and click")
	public void overseasVerifyClick(String expectecText) throws Exception {
		try {
			ButtonLabelVerifyClick(IOShomePgaeObject.overseasButton(), expectecText);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Overseas icon Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Overseas icon Button ", e);
		}
	}

	@Step("Enter the text in search and select the corresponding value in the dropdown")
	public void sendCountryInSearchBoxAndSelectFromDropDown(String searchBoxData, String valueSelectedFromList)
			throws Exception {
		try {
			
			if (isElementEnable(IOShomePgaeObject.searchBoxforLocation())) {
				clickOnElement(IOShomePgaeObject.searchBoxforLocation());
				//enterTextInTextbox(IOShomePgaeObject.searchBoxforLocation(), searchBoxData);
				sendTextWithKeypad(searchBoxData);
				}
			
			
//			 String arr[] = {"a", "A", "u","U","s","S"};	
//				for (int i = 0; i <6; i++) {
//					String bxpath = "//XCUIElementTypeButton[@name=" + arr[i] + "]";
//					List<RemoteWebElement> list = driver.findElements(By.xpath(bxpath));
//							if (list.size() > 0) {		
//					MobileElement button = (MobileElement) driver.findElement(By.xpath(bxpath));
//					clickOnElement(button);
//					Thread.sleep(2000);
//							}
//				}
			
			
			if(IOShomePgaeObject.countryList().size() >0) 
			{
			TakeScreenshot(IOShomePgaeObject.countryList().get(0));
			List<MobileElement> Elementlist = IOShomePgaeObject.countryList();
			int l = Elementlist.size();
			int index = 0;
			String countryFromList = null;
			for (int i = 0; i < l; i++) {
				countryFromList = Elementlist.get(i).getText();
				if (countryFromList.equalsIgnoreCase(valueSelectedFromList)) {
					index++;
					clickOnElement(Elementlist.get(i));
					break;
				}
			}

			Asserts.assertTrue(index > 0, "No " +valueSelectedFromList + "found in the list of corresponding value");
			}
			else
			{
				Asserts.assertFail("No Country List is found");
			}
		} 
		catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select Country",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Selecting Country",e);
		}
	}
	@Step("Enter the AUS in search and select the corresponding value in the dropdown")
	public void sendCountryAUSInSearchBoxAndSelectFromDropDown(String searchBoxData, String valueSelectedFromList)
			throws Exception {
		try {
			
			if (isElementEnable(IOShomePgaeObject.searchBoxforLocation())) {
				clickOnElement(IOShomePgaeObject.searchBoxforLocation());
				
			
			Thread.sleep(5000);
			 String arr[] = {"a", "A", "u","U","s","S"};	
				for (int i = 0; i <6; i++) {
					String bxpath = "//XCUIElementTypeButton[@name=" + arr[i] + "]";
					List<RemoteWebElement> list = driver.findElements(By.xpath(bxpath));
							if (list.size() > 0) {		
					MobileElement button = (MobileElement) driver.findElement(By.xpath(bxpath));
					clickOnElement(button);
					Thread.sleep(2000);
							}
				}
				}
			
			
			TakeScreenshot(IOShomePgaeObject.countryList().get(0));
			List<MobileElement> Elementlist = IOShomePgaeObject.countryList();
			int l = Elementlist.size();
			int index = 0;
			String countryFromList = null;
			for (int i = 0; i < l; i++) {
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
			if(IOShomePgaeObject.currencyList().size() >0) {
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

			Asserts.assertTrue(index > 0, "No" +expectecCurrency+ " currency found in the list ");
			}
			else
			{
				Asserts.assertFail("No currency found in the Oversea Payee list");
			}
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select currency",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select currency ",e);
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

		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Send Bank Code in EditBox ",e);
					
		}
		catch (Exception e) {			
			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Send Bank Code in EditBox  ",e);
		}
	}

	@Step("click on done button")
	public void doneButtonIfAviliable() throws Exception {
		try {
			Thread.sleep(5000);
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

	@Step("Enter data in Account No. , Name, Address, City EditBox")
	public void verifyRecipientDetailHeaderAndEnterDetail() throws Exception {
		try {
			fieldText(CommonTestData.ENTER_RECIPIENT_DETAIL.getEnumValue(), IOShomePgaeObject.recipientDetailTitle());

			sendAccountNo(CommonTestData.ACCOUNT_NO.getEnumValue());
			sendFullName(CommonTestData.FULL_NAME.getEnumValue());
			gestUtils.scrollUPtoObjectIos("name", "NEXT", null);
			sendAddress(CommonTestData.ADDRESS_SHORT.getEnumValue());
			sendcity(CommonTestData.CITY.getEnumValue());

		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Enter data in Account No. , Name, Address, City EditBox ",e);
					
		}
		catch (Exception e) {			
			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Enter data in Account No. , Name, Address, City EditBox  ",e);
		}
	}

	@Step("Enter Account No EditBox")
	public void sendAccountNo(String text) throws Exception {
		try {
			TakeScreenshot(IOShomePgaeObject.recipientDetailAccountNumver());
			if (isElementEnable((IOShomePgaeObject.recipientDetailAccountNumver())))
				enterTextInTextbox(IOShomePgaeObject.recipientDetailAccountNumver(), text);

			doneButtonIfAviliable();
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Send Account Number in EditBox ",e);
					
		}
		catch (Exception e) {			
			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Send Account Number in EditBox  ",e);
		}
	}

	@Step("Enter Full name EditBox")
	public void sendFullName(String text) throws Exception {
		try {
			TakeScreenshot(IOShomePgaeObject.recipientDetailAccountName());
			if (isElementEnable(IOShomePgaeObject.recipientDetailAccountName()))
				enterTextInTextbox(IOShomePgaeObject.recipientDetailAccountName(), text);
			doneButtonIfAviliable();

		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Send Full Name in EditBox ",e);
					
		}
		catch (Exception e) {			
			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Send Full Name in EditBox  ",e);
		}
	}

	@Step("Enter Address EditBox")
	public void sendAddress(String text) throws Exception {
		try {
			TakeScreenshot(IOShomePgaeObject.recipientDetailAddress());
			clickOnElementOnEnable(IOShomePgaeObject.recipientDetailAddress());
			sendTextWithKeypad(text);
			//if (isElementEnable(IOShomePgaeObject.recipientDetailAddress()))
			//	enterTextInTextbox(IOShomePgaeObject.recipientDetailAddress(), text);
			doneButtonIfAviliable();
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Send Address in EditBox ",e);
					
		}
		catch (Exception e) {			
			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Send Address in EditBox  ",e);
		}
	}

	@Step("Enter city EditBox")
	public void sendcity(String text) throws Exception {
		try {
			TakeScreenshot(IOShomePgaeObject.recipientDetailCity());
			clickOnElementOnEnable(IOShomePgaeObject.recipientDetailCity());
			sendTextWithKeypad(text);
			//if (isElementEnable(IOShomePgaeObject.recipientDetailCity()))
			//	enterTextInTextbox(IOShomePgaeObject.recipientDetailCity(), text);
			doneButtonIfAviliable();
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Send City in EditBox ",e);
					
		}
		catch (Exception e) {			
			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Send City in EditBox  ",e);
		}
	}
	@Step("click on Add Recipient Now")
	public void addRecipientNow() throws Exception {
		try {
			ButtonVerifyClick(IOShomePgaeObject.ADDRecipientNowButton());
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to click on Add Recipient Now ",e);
					
		}
		catch (Exception e) {			
			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to click on Add Recipient Now  ",e);
		}
	}

	@Step("Verify 'REVIEW RECIPIENT'S DETAILS label' and Click on 'Add Recipient Now' button")
	public void verifyRecipientReviewDetailAndClickOnAddRecipientVutton() throws Exception {
		try {
			fieldText(CommonTestData.REVIEW_RECIPIENT_LABEL.getEnumValue(),
					IOShomePgaeObject.reviewRecipientDetailTitle());
			gestUtils.scrollUPtoObjectIos("name", "ADD RECIPIENT NOW", null);
			addRecipientNow();

		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verify 'REVIEW RECIPIENT'S DETAILS label' and Click on 'Add Recipient Now' button",e);
					
		}
		catch (Exception e) {			
			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify 'REVIEW RECIPIENT'S DETAILS label' and Click on 'Add Recipient Now' button",e);
		}
	}

	@Step("Verify 'Reference No. Field and its value' field and Verify 'MAKE A TRANSFER' Button After Expanding & Scrolling to the Page.")
	public void verifyReferenceFieldAndItsValue(String expectedText) throws Exception {
		try {
			clickOnExpandButtonAddpayeeRemittence();
			gestUtils.scrollUPtoObjectIos("name", "Reference No.", null);
			//gestUtils.scrollUPtoObject("name", "Reference No.", IOShomePgaeObject.referenceNo());
			TakeScreenshot(IOShomePgaeObject.makeTransferButton());
//			Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.makeTransferButton()).toLowerCase(),
//					CommonTestData.MAKE_TRANSFER.getEnumValue().toLowerCase(), "'MAKE A TRANSFER' Text is not found");
			verifyMakeTransferButton(CommonTestData.MAKE_TRANSFER.getEnumValue());
			verifyReferenceNofield(expectedText); 
//			Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.referenceNo()).toLowerCase(),
//					expectedText.toLowerCase(), "'Reference no Field' is not found");
			//boolean i = IOShomePgaeObject.referenceNoValue().getText().isEmpty();
			//Asserts.assertTrue(i == false, "Reference Number not Found");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verify Reference no  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify Reference no  ", e);
		}
	}
	@Step("Verify 'Reference no Field ")
	public void verifyReferenceNofield(String expectedText) throws Exception {
		try {
            fieldText(expectedText, IOShomePgaeObject.referenceNo());
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", "Verify 'Reference No. Field and its value' field and Verify 'MAKE A TRANSFER' Button After Expanding & Scrolling to the Page ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", "Verify 'Reference No. Field and its value' field and Verify 'MAKE A TRANSFER' Button After Expanding & Scrolling to the Page", e);
		}

	}
	@Step("Verify 'MAKE A TRANSFER' Button ")
	public void verifyMakeTransferButton(String expectedText) throws Exception {
		try {
            fieldText(expectedText, IOShomePgaeObject.makeTransferButton());
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verify 'MAKE A TRANSFER' Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify 'MAKE A TRANSFER' Button ", e);
		}

	}
	@Step("click On Expand button")
	public void clickOnExpandButtonAddpayeeRemittence() throws Exception {
		try {
			ButtonVerifyClick(IOShomePgaeObject.expandButton());
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On expand Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On expand Button ", e);
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
			
			//ClickOnNextButton();
			ClickOnNextButton2();
			Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.ReviewPaymentPageHeader()),
					CommonTestData.REVIEW_PAYMENT_PAGEHEADER.getEnumValue(),
					CommonTestData.REVIEW_PAYMENT_PAGEHEADER.getEnumValue() + " Text is not matching");
		
			ClickOnTransferNowBtnAndVerifyPaymentSubmittedMsg();
			VerifyVisibiltyOfSomeElements_FundTransferCreditCard();

			//Leaving On Home Page for Next case Run.
//			ClickOnCloseButton();
//			ClickOnHomeButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to fund transfer pay credit card  ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to fund transfer pay credit card    ", e);
		}
	}
	
	
	@Step("Select Any Fund Source Account After clicking on add sign for select fund source.")
	public void SelectFundSourceAccount(String fromOwnAccount) throws Exception {
		try {
			String xpath = "//XCUIElementTypeStaticText[@value='Select fund source']";
			//String xpath = "//XCUIElementTypeStaticText[@name='source_account_name']";
			List<RemoteWebElement> list = driver.findElements(By.xpath(xpath));
			if (list.size() > 0) {
				//gestUtils.scrollDOWNtoObject("text", "Select Fund Source", IOShomePgaeObject.SelectFundSourcePage());
				gestUtils.scrollDownIos();
				//TakeScreenshot(IOShomePgaeObject.SelectFundSourcePage());
				clickOnElement(IOShomePgaeObject.SelectFundSourcePage());
				//TakeScreenshot(IOShomePgaeObject.localRecipientsList().get(0));
				int index=0;
				for (int i = 0; i < IOShomePgaeObject.localRecipientsList().size(); i++) {
					String actualfromOwnAccount = IOShomePgaeObject.localRecipientsList().get(i).getText();
					if (actualfromOwnAccount.contains(fromOwnAccount)) {
						clickOnElement(IOShomePgaeObject.localRecipientsList().get(i));
						index++;
						break;
					}
				}
				Asserts.assertTrue(index>0, "No Account " +fromOwnAccount+" not found in the list to initiate the fund transfer");

				Thread.sleep(3000);
				String xpath1 = "//XCUIElementTypeStaticText[@name='Primary source of fund']";
				List<RemoteWebElement> list1 = driver.findElements(By.xpath(xpath1));
				
				if (list1.size() > 0) {
					clickOnPrimarySourceOfFund();
//					com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
//					if (isElementVisible(IOShomePgaeObject.primarysourceOfFund()))
//						clickOnElement(IOShomePgaeObject.okButton());
				}
			}
			else
			{
				Asserts.assertFail("No Account found in the list");
			}
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select Any Fund Source Account After clicking on add sign for select fund source. ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select Any Fund Source Account After clicking on add sign for select fund source. ",e);
		}
	}
	@Step("Verify Transaction History")
	public void transactionHistoryVerify() throws Exception {
		try {
			ClickOnMoreButton();
			EnterPasscodeAndDone();
			ClickOnTransactionHistory();
			SelectTimeAndAccountTypeForStatement(CommonTestData.ACCOUNT_NAME.getEnumValue(),CommonTestData.CURRENCY_NAME.getEnumValue());
			gestUtils.scrollUPtoObjectIos("name", "SHOW", null);
			ClickOnShowButtonAndVerifyHeader(CommonTestData.STATEMENT_TITLE.getEnumValue());
			ValadateTransactionHistoryListInThreeMonth();
			//BackToHomeFromTransactionHistory();
		}catch (HandleException e) {	
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to verify transaction history ",e);
		}
		catch (Exception e) {		
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to verify transaction history ",e);
		}
	}
	@Step("Click on 'Transaction History' Button and then Verifying page header 'Transaction History'")
	public void ClickOnTransactionHistory() throws Exception {
		try {
			ButtonLabelVerifyClick(IOShomePgaeObject.transactionHistoryBtnLabel(), CommonTestData.TRANSCETION_HISTORY_LABEL.getEnumValue());
			EnterPasscodeAndDone();
			fieldText(CommonTestData.TRANSCETION_HISTORY_LABEL.getEnumValue(), IOShomePgaeObject.transactionHistoryBtnLabel());
				
			
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to click transaction history and verify page header  ",e);
		}
		catch (Exception e) {		
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to click transaction history and verify page header  ",e);
		}

	}
	@Step("Select'3 Months Transaction History' And 'From Account' from 'Deposit Account' section")
	public void SelectTimeAndAccountTypeForStatement(String AccountName, String currencyInAccount) throws Exception {
		try {
			    
			    ButtonVerifyClick(IOShomePgaeObject.threeMonthOption());
			    ButtonVerifyClick(IOShomePgaeObject.depositeOption());
			    selectAccountTypeInTransactionHistory(AccountName, currencyInAccount);
			
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to select '3 Months Transaction History' And 'From Account' from 'Deposit Account' section ",e);
		}
		catch (Exception e) {		
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",  " Failed to select '3 Months Transaction History' And 'From Account' from 'Deposit Account' section ",e);
		}
	}
	@Step("Click on 'Account type' From List under Local fund Limit page'")
	public void selectAccountTypeInTransactionHistory(String AccountToBeSelected,String currencyInAccount) throws Exception {
		try {
			List<MobileElement> Elementlist = null;
			int index = 0;
			if(IOShomePgaeObject.accountListinTransectionHistory().size() >0) {
			TakeScreenshot(IOShomePgaeObject.accountListinTransectionHistory().get(0));
			Elementlist = IOShomePgaeObject.accountListinTransectionHistory();	
			int l = Elementlist.size();
			
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
			Asserts.assertTrue(index > 0, "No " + AccountToBeSelected + " found in the list of corresponding value");
			}
			else
			{
				Asserts.assertFail("No Account type list is found");
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
			
			fieldText(CommonTestData.TRANSCETION_HISTORY_LABEL.getEnumValue(), IOShomePgaeObject.transactionHistoryBtnLabel());
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to 'Account type' ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to 'Account type' ",e);
		}
	}
	@Step("Click on 'Show' Button and then Verifying From Account.")
	public void ClickOnShowButtonAndVerifyHeader(String ExpectedAccountName) throws Exception {
		try {
			clickOnShouButton();
			EnterPasscode();
			String actual=IOShomePgaeObject.transactionHistoryfinalheaderTitle().getText();
			if(actual.toLowerCase().contains(ExpectedAccountName.toLowerCase())) {
				String[] arrOfStr = ExpectedAccountName.split(" ");
			}
			else
				fieldText(ExpectedAccountName, IOShomePgaeObject.transactionHistoryfinalheaderTitle());
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to click show button and verify amount  ",e);
		}
		catch (Exception e) {		
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to click show button and verify amount",e);
		}
	}
	@Step("click and Verifies Show button")
	public void clickOnShouButton() throws Exception {
		try {
			ButtonLabelVerifyClick(IOShomePgaeObject.showButton(), CommonTestData.SHOW_BUTTON.getEnumValue());
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to click and Verifies Show button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to click and Verifies Show button ", e);
		}
	}
	@Step("Validating From Account Transaction History List.")
	public void ValadateTransactionHistoryListInThreeMonth() throws Exception {
		try {
			List<MobileElement> Elementlist = IOShomePgaeObject.accountListinTransectionHistory();
			int l = Elementlist.size();
			Asserts.assertTrue(l > 0, "No Transaction History is Display");
			TakeScreenshot(null);
		}  catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to verify from account transaction history list  ",e);
		}
		catch (Exception e) {		
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to verify from account transaction history list ",e);
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
           // BackToHomeFromFundTransfer();
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to verify fund transfer other DBS_POSB  ",e);
		}
		catch (Exception e) {		
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to verify fund transfer other DBS_POSB  ",e);
		}
	}
	@Step("Click on 'All Tab' section And select option form the list")
	public void clickAndVerifyOnAllTabAndselectFromTheList(String TabValue) throws Exception {
		try {
			ButtonLabelVerifyClick(IOShomePgaeObject.allTab(), CommonTestData.ALL_SECTION.getEnumValue());
			int index=0;
			if(IOShomePgaeObject.allTabList().size() >0) {
		    TakeScreenshot(IOShomePgaeObject.allTabList().get(0));
			//int l= IOShomePgaeObject.allTabList().size();
			for (int i = 0; i < IOShomePgaeObject.allTabList().size(); i++) {
				String tabText = IOShomePgaeObject.allTabList().get(i).getText(); 
				if (tabText.contains(TabValue)) {
					clickOnElement(IOShomePgaeObject.allTabList().get(i));
					index++;
					break;
				}
			}
			Asserts.assertTrue(index>0, "No " +TabValue+" not found in the list");
			}
			else
			{
				Asserts.assertFail("No List found in the 'All Tab' section");
			}
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to  select option form the list",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to select option form the list ",e);
		}

	}
	
	@Step("Click on 'Select Fund Source' and Select Account")
	public void selectFundSourceAndSelectAccount(String SelectedAccountName) throws Exception {
		try {
			fieldText(IOShomePgaeObject.sgdText());
			// TakeScreenshot(IOShomePgaeObject.sgdText());
			String xpath = "//XCUIElementTypeStaticText[@name='Select Fund Source']";
			List<RemoteWebElement> list = driver.findElements(By.xpath(xpath));
			if (list.size() > 0) {
				clickOnSelectFundSource2();
				int index = 0;
				if (IOShomePgaeObject.selectfundSourceList().size() > 0) {
					TakeScreenshot(IOShomePgaeObject.selectfundSourceList().get(0));
					List<MobileElement> AccountName = IOShomePgaeObject.selectfundSourceList();

					int l = AccountName.size();

					String AccountNameList = null;
					for (int i = 0; i < l; i++) {
						AccountNameList = AccountName.get(i).getText();
						if (AccountNameList.equalsIgnoreCase(SelectedAccountName)) {
							index++;
							clickOnElement(AccountName.get(i));
							break;
						}
					}
					Asserts.assertTrue(index > 0,
							"No" + SelectedAccountName + " not found in the list to initiate the fund transfer");
				} else {
					Asserts.assertFail("No Account found in the list");
				}
				String xpath1 = "//XCUIElementTypeStaticText[@name='Primary source of fund']";
				List<RemoteWebElement> list1 = driver.findElements(By.xpath(xpath1));
				if (list1.size() > 0) {
//				androidAlert.AlertHandlingWithButtonMessage(IOShomePgaeObject.okButton(),CommonTestData.PRIMARY_SOURCE_ALERT_TITLE.getEnumValue(),
//						IOShomePgaeObject.primarysourceOfFund());
					clickOnPrimarySourceOfFund();

				}
			}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Select Fund Source' and Select Account ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Select Fund Source' and Select Account ", e);
		}

	}
	@Step("click on Select Fund Source")
	public void clickOnSelectFundSource2() throws Exception {
		try {
			ButtonLabelVerifyClick(IOShomePgaeObject.selectfundSource(), CommonTestData.SELECT_SOURCE_FUND.getEnumValue());
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to click on Select Fund Source ",e);
					
		}
		catch (Exception e) {			
			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to click on Select Fund Source  ",e);
		}
	}
	@Step("Verify 'SGD Currency Field' andIOShomePgaeObject Enter Amount '11'")
	public void enterAmountAndVerifySgdCurrency(String Amount) throws Exception {
		try {
			fieldText(CommonTestData.SGD_CURRENCY_LABEL.getEnumValue(), IOShomePgaeObject.sgdText());
			enterTextInTextbox(IOShomePgaeObject.amountField(), Amount);
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			doneButtonIfAviliable();
			ClickOnNextButton2();
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to verify SGD Currency field and enter amount",e);
		}
		catch (Exception e) {		
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to verify SGD Currency field and enter amount  ",e);
		}

	}
	@Step(" Verifying page header 'Review Transfer' And Click on 'TRANSFER NOW' Button")
	public void verifyReviewTransferAndClickTransferNowButton() throws Exception {
		try {
			fieldText(CommonTestData.REVIEW_TRANSFER_LABEL.getEnumValue(), IOShomePgaeObject.reviewTransfer());
			ClickTransferNowButton();
			//ButtonLabelVerifyClick(IOShomePgaeObject.transferNowButton(), CommonTestData.TRANSFER_NOW_BUTTON.getEnumValue());
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to  Verifying page header 'Review Transfer' And Click on 'TRANSFER NOW' Button",e);
		}
		catch (Exception e) {		
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to  Verifying page header 'Review Transfer' And Click on 'TRANSFER NOW' Button ",e);
		}

	}
	@Step(" Click on 'TRANSFER NOW' Button")
	public void ClickTransferNowButton() throws Exception {
		try {
			ButtonVerifyClick(IOShomePgaeObject.transferNowButton2());
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}

	}
	
	@Step(" Verifying page header 'Transferred' And Generated Reference Number")
	public void verifyTransferredAndReferenceNumberField() throws Exception {
		try {
			fieldText(CommonTestData.TRANSFER_TITLE.getEnumValue(), IOShomePgaeObject.transferredTitle());
			ButtonVerifyClick(IOShomePgaeObject.expandButton2());
			gestUtils.scrollUPtoObjectIos("name", "Reference No.", null);
			fieldText(CommonTestData.REFERENCE_NUMBER.getEnumValue(), IOShomePgaeObject.referenceNo());
//			boolean i= IOShomePgaeObject.referenceNoValue().getText().isEmpty();
//			Asserts.assertTrue(i==false, "Reference Number not Found");
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to verify page header and generated reference number ",e);
		}
		catch (Exception e) {		
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to verify page header and generated reference number   ",e);
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
			verifyAccountSection();
			int x=getXCoordinateOfElement(IOShomePgaeObject.welcomeToText());
			int y=getYCoordinateOfElement(IOShomePgaeObject.welcomeToText());
			gestUtils.DragAndDropElementToCoordinate(IOShomePgaeObject.accountSectionHomePage(), x, y+150);
			Thread.sleep(1000);
			VerifyAccountType(AccountType);
			VerifyAccountName(AccountName);
			VerifyCurrency(currency);
			
			//int size=arrOfStr.length;
			//Asserts.assertTrue(size==2, "Reference Number not Found");
		}
			catch (HandleException e) {	
				obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Verify the account detail on dashboard page  ",e);			
			}
			catch (Exception e) {			
				obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Verify the account detail on dashboard page  ",e);
			}

	}
	@Step("Verify Account Section and Click")
	public void verifyAccountSection() throws Exception {
		try {
			ButtonLabelVerifyClick(IOShomePgaeObject.accountSectionHomePage(), CommonTestData.ACCOUNT_SECTION.getEnumValue());
		} 
		 catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verify Account Section" ,e);
					
		}
		catch (Exception e) {			
			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify Account Section ",e);
		}
		}
	
	@Step("Verify Account Type")
	public void VerifyAccountType(String AccountType) throws Exception {
		try {
			String xpath= "//XCUIElementTypeStaticText[@name='"+AccountType+"']";
			List<RemoteWebElement> list = driver.findElements(By.xpath(xpath));
			if (list.size() > 0) {
				fieldText(AccountType, IOShomePgaeObject.depositeHomepage());
			}
			else
				Asserts.assertFail(AccountType);
			
		}  
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify Account Type ",e);
		}	
		}
	@Step("Verify Account Name")
	public void VerifyAccountName(String AccountName) throws Exception {
		try {
			String xpath= "//XCUIElementTypeStaticText[@name='"+AccountName+"']";
			List<RemoteWebElement> list = driver.findElements(By.xpath(xpath));
			if (list.size() > 0) {
				fieldText(AccountName, IOShomePgaeObject.accountNameHomepage());
			}
			else
				Asserts.assertFail(AccountName);
			
		} catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify Account Type ",e);
		}	
	}
	@Step("Verify currency")
	public void VerifyCurrency(String currency) throws Exception {
		try {
			String fag=IOShomePgaeObject.sgdHomepage().getText();
			String[] arrOfStr = fag.split(" ");
			TakeScreenshot(null);
			Asserts.assertEquals(arrOfStr[0],
					currency, currency + " is not present");

		}  catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verify currency" ,e);
					
		}
		catch (Exception e) {			
			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify currency ",e);
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
			Thread.sleep(2000);
			gestUtils.scrollUPtoObjectIos("label", "NEXT",  null);
			//gestUtils.scrollUPtoObject("name", "NEXT",  null);
			selectPurposeAccountTypeMobileNumberIfAvaliable("Savings","Personal Gifts","9999999990");
			ClickOnNextBtnAndVerifiesReviewTransferPage();
			ClickOnTransferNowBtnAndVerifiesTransferSubmittedMsg(CommonTestData.TRANSFER_SUBMITTED_MSG.getEnumValue());
			ClickOnImageExpandBtnAndVerifiesReferenceNumberText();
			ClickOnShareTransferDetailsBtnAndVerifiesReferenceNumberText();
			//BackToHomeFromRemittenceCoridor();
		}catch (HandleException e) {	
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Execute Remittance Corridor  ",e);			
		}
		catch (Exception e) {			
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Execute Remittance Corridor  ",e);
		}
	}
	
	@Step("Verifies Overseas Transfer Page Header on the top & Select Payee and fund source from Overseas Transfer page.")
	public void SelectingPayeeAfterSelectingOverseas(String valueSelectedFromList) throws Exception {
		try {
			//overseasVerifyClick(CommonTestData.OVERSEAS_ICON.getEnumValue());
			fieldText(CommonTestData.OVERSEAS_TRANSFER_PAGEHEADER.getEnumValue().toLowerCase(),IOShomePgaeObject.overseaTransferTitle());
			if(IOShomePgaeObject.commonList().size() >0) {
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
			Asserts.assertTrue(index>0, "Overseas Payee " +valueSelectedFromList+" not found in the list to initiate the fund transfer");
			}
			else
			{
				Asserts.assertFail("No Receipient found in the Oversea Payee list");
			}
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Selecting Overseas Payee ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Selecting Overseas Payee ",e);
		}
	}
	@Step("Click on 'Select Fund Source' and Select Account")
	public void selectFundSourceAndSelectAccountForCorredor(String SelectedAccountName) throws Exception {
		try {
			Thread.sleep(10000);
			TakeScreenshot(IOShomePgaeObject.amountFieldInOversea());
			String xpath = "//XCUIElementTypeStaticText[@name='Select Fund Source']";
			List<RemoteWebElement> list = driver.findElements(By.xpath(xpath));
			if (list.size() > 0) {
				clickOnSelectFundSource();
			int index = 0;
			if(IOShomePgaeObject.commonList().size() >0) {
			TakeScreenshot(IOShomePgaeObject.commonList().get(0));
			List<MobileElement> AccountName = IOShomePgaeObject.commonList();
			int l = AccountName.size();
			
			String AccountNameList = null;
			for (int i = 0; i < l; i++) {
				AccountNameList = AccountName.get(i).getText();
				if (AccountNameList.contains(SelectedAccountName) ) {// && AccountNumberList.equalsIgnoreCase(SelectedAccountNumber)
					index++;
					clickOnElement(AccountName.get(i));
					Thread.sleep(5000);
					break;
				}
			}
			}
			Asserts.assertTrue(index>0, "Account Type" +SelectedAccountName+" not found in the list to initiate the fund transfer");
			}
			else
			{
				Asserts.assertFail("No Receipient found in the Oversea Payee list");
			}
			
			String xpath1 = "//XCUIElementTypeStaticText[@name='Primary source of fund']";
			List<RemoteWebElement> list1 = driver.findElements(By.xpath(xpath1));
			if (list1.size() > 0) {
				clickOnPrimarySourceOfFund();
			} 
			//TakeScreenshot(IOShomePgaeObject.transferOverseaTitle());
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select Account ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select Account ",e);
		}
	}
	@Step("click on Primary source of fund")
	public void clickOnPrimarySourceOfFund() throws Exception {
		try {
			androidAlert.AlertHandlingWithButtonMessage(IOShomePgaeObject.okButton(),CommonTestData.PRIMARY_SOURCE_ALERT_TITLE.getEnumValue(),
					IOShomePgaeObject.primarysourceOfFund());
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Select Fund Source Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Select Fund Source Button ", e);
		}
	}
	@Step("click on Select Fund Source")
	public void clickOnSelectFundSource() throws Exception {
		try {
			ButtonLabelVerifyClick(IOShomePgaeObject.selectfundSource(), CommonTestData.SELECT_SOURCE_FUND.getEnumValue());
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Select Fund Source Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Select Fund Source Button ", e);
		}
	}
	@Step("Press enter key after Entering Amount.")
	public void pressEnterKeyAfterEnteringAmount(String Amt) throws Exception {
		try {
			clickOnElement(IOShomePgaeObject.amountFieldInOversea());
			enterTextInTextbox(IOShomePgaeObject.amountFieldInOversea(), Amt);
			doneButtonIfAviliable();
			Asserts.assertTrue(isElementVisible2(IOShomePgaeObject.exchangeRate()), "Exchange Rate is not visible");
		   
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Pressing Enter Key After Entering Amount ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Pressing Enter Key After Entering Amount ",e);
		}
	}
	@Step("Verifies Review Transfer Page Header after clicking on Next Button.")
	public void ClickOnNextBtnAndVerifiesReviewTransferPage() throws Exception {
		try {
			
			ClickOnNextButton();
			fieldText(CommonTestData.REVIEW_TRANSFER.getEnumValue(), IOShomePgaeObject.reviewTransfer());
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", "Failed to Verifies Review Transfer Page Header after clicking on Next Button ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", "Failed to Verifies Review Transfer Page Header after clicking on Next Button ",e);
		}
	}
	@Step("Verifies Transfer Submitted Message after clicking on Transfer Now Button.")
	public void ClickOnTransferNowBtnAndVerifiesTransferSubmittedMsg(String SuccessMsg) throws Exception {
		try {
			//scrool
			gesture.scrollUPtoObjectIos("name", "TRANSFER NOW", null);			
			clickOnTransferNowButton();
		    fieldText(SuccessMsg, IOShomePgaeObject.transferSubmittedLabel());
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to CLick on transfer now and Verify success message ",e);
		}
		catch (Exception e) {		
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to CLick on transfer now and Verify success message  ",e);
		}
	}
	@Step("click On Transfer Now Button")
	public void clickOnTransferNowButton() throws Exception {
		try {
			ButtonVerifyClick( IOShomePgaeObject.transferNowButton());
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Transfer Now Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On  Transfer Now Button ", e);
		}
	}
	@Step("Verifies Reference Number Text after clicking on Image Expand Button.")
	public void ClickOnImageExpandBtnAndVerifiesReferenceNumberText() throws Exception {
		try {
			
			clickOnExpandButton();
			gestUtils.scrollUPtoObjectIos("name", "Reference No.", null);
			fieldText(CommonTestData.REFERENCE_NUMBER.getEnumValue(), IOShomePgaeObject.referenceNo());
//			boolean i= IOShomePgaeObject.referenceNoValueInOversea().getText().isEmpty();
//			Asserts.assertTrue(i==false, "Reference Number not Found");
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Image Expand Button ",e);			
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Image Expand Button ",e);
		}
	}
	@Step("click On Expand button")
	public void clickOnExpandButton() throws Exception {
		try {
			ButtonVerifyClick(IOShomePgaeObject.downwardArrowInTopUpDonePage());
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On expand Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On expand Button ", e);
		}
	}
	@Step("Verifies Overseas transfer Message after clicking on Share Transfer Details Button.")
	public void ClickOnShareTransferDetailsBtnAndVerifiesReferenceNumberText() throws Exception {
		try {
			gestUtils.scrollUPtoObjectIos("name", "SHARE TRANSFER DETAILS", null);
			ButtonVerifyClick(IOShomePgaeObject.shareTransferDetailButton());
			Thread.sleep(5000);
			//fieldText("Transfer Details",IOShomePgaeObject.transferDetailLabel());
		}catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Share Transfer Details Button ",e);			
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Share Transfer Details Button ",e);
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
		catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Selecting Purpose Account Type, Mobile Number ",e);
					
		}
		catch (Exception e) {			
			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Selecting Purpose Account Type, Mobile Number ",e);
		}
	
}
	@Step("Select AccountType")
	public void selectAccountType(String AccountType) throws Exception//"Savings"
	{
		try {
			clickOnAccountType();
			int index = 0;
			if(IOShomePgaeObject.commonList().size() >0) {
			List<MobileElement> Elementlist = IOShomePgaeObject.commonList();
			TakeScreenshot(IOShomePgaeObject.commonList().get(0));
			int l = Elementlist.size();
			
			String LocalRecipientList = null;
			for (int i = 0; i < l; i++) {
				LocalRecipientList = Elementlist.get(i).getText();
				if (LocalRecipientList.contains(AccountType)) {
					index++;
					clickOnElement(Elementlist.get(i));
					break;
				}
			}
			Asserts.assertTrue(index > 0,   AccountType +" not found in the list ");
			}
			else
			{
				Asserts.assertFail("No Account found in the  list");
			}
			TakeScreenshot(IOShomePgaeObject.transferOverseaTitle());
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Selecting Overseas Payee ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Selecting Overseas Payee ",e);
		}}
	@Step("Application click on Account Type")
	public void clickOnAccountType() throws Exception {
		try {
			ButtonVerifyClick(IOShomePgaeObject.selectAccountType());
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Account Type  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Account Type ", e);
		}
	}
	
	@Step("Enter Amount In Editable field to transfer fund.")
	public void EnterAmount(MobileElement editField, String textToEnter) throws Exception {
		try {
			TakeScreenshot(editField);
			clickOnElement(editField);
			enterTextInTextbox(editField, textToEnter);
			//backButton();
			doneButtonIfAviliable();
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Enter Amount In Editable field to transfer fund ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Enter Amount In Editable field to transfer fund ",e);
		}
	}
	
	@Step("Click On Transfer Now Button And Verify Payment Submitted Message.")
	public void ClickOnTransferNowBtnAndVerifyPaymentSubmittedMsg() throws Exception {
		try {
//			TakeScreenshot(IOShomePgaeObject.TransferNowButton());
//			clickOnElement(IOShomePgaeObject.TransferNowButton());
//			clickOnTransferNowButton();
			clickOnElement(IOShomePgaeObject.TRANSFERNOWButton());
			// verifies the payment completion with expected amount.
			//TakeScreenshot(IOShomePgaeObject.SuccessImage().get(3));
		//	if (isElementVisible(IOShomePgaeObject.SuccessImage().get(3))) {
				Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.PaymentSubmittedMsg()),
						CommonTestData.PAYMENT_SUBMITTED.getEnumValue(),
						CommonTestData.PAYMENT_SUBMITTED.getEnumValue() + " Text is not matching");

				Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.AmountEditableField()),
						CommonTestData.AMOUNTTO_TRANSFERFUND.getEnumValue() + ".00",
						CommonTestData.AMOUNTTO_TRANSFERFUND.getEnumValue() + " Text is not matching.");
			//}
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Transfer Now Button And Verify Payment Submitted Message ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Transfer Now Button And Verify Payment Submitted Message ",e);
		}
	}
	
	@Step("Verifies the 'Log out', 'Make Another Transfer' Button, 'Share Payment Details' Button.")
	public void VerifyVisibiltyOfSomeElements_FundTransferCreditCard() throws Exception {
		try {
			Asserts.assertTrue(IOShomePgaeObject.logoutPaylah().isDisplayed(), "Log Out Button not found.");
			//add scroll
			gestUtils.scrollUPtoObjectIos("label", "MAKE ANOTHER TRANSFER", null);
			Asserts.assertTrue(IOShomePgaeObject.MakeAnotherPaymentBtn2().isDisplayed(),
					"Make Another Transfer Button not found.");
			Asserts.assertTrue(IOShomePgaeObject.SharePaymentDetailsButton2().isDisplayed(),
					"'Share Payment Details' Button not found.");
			
			//Asserts.assertTrue(IOShomePgaeObject.closeButton().isDisplayed(),
					//"'Close' Button not found.");
			
			clickOnElement(IOShomePgaeObject.FooterExpandableBtn());
			
			gestUtils.scrollUPtoObjectIos("label", "Reference No.", null);
			fieldText(CommonTestData.REFERENCE_NUMBER.getEnumValue(), IOShomePgaeObject.referenceNo());
			//TakeScreenshot(IOShomePgaeObject.referenceNo());

		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verifies the 'Log out', 'Make Another Transfer' Button, 'Share Payment Details' Button. ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verifies the 'Log out', 'Make Another Transfer' Button, 'Share Payment Details' Button. ",e);
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
//			TakeScreenshot(IOShomePgaeObject.localRecipientsList().get(0));
//			List<MobileElement> Elementlist = IOShomePgaeObject.localRecipientsList();
//			int l = Elementlist.size();
//			int index = 0;
//			String LocalRecipientList = null;
//			for (int i = 0; i < l; i++) {
//				LocalRecipientList = Elementlist.get(i).getText();
//				if (LocalRecipientList.equalsIgnoreCase(valueSelectedFromList)) {
//					index++;
//					clickOnElement(Elementlist.get(i));
//					break;
//				}
//			}
//			Asserts.assertTrue(index > 0, "No element found in the list of corresponding value");
//
//			Thread.sleep(3000);
//			String xpath1 = "//XCUIElementTypeStaticText[@name='Primary source of fund']";
//			List<RemoteWebElement> list1 = driver.findElements(By.xpath(xpath1));
//			if (list1.size() > 0) {
//				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
//				if (isElementVisible(IOShomePgaeObject.primarysourceOfFund()))
//					clickOnElement(IOShomePgaeObject.okButton());
//			}
//			
//			Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.CreditCard_PageHeader()),
//					CommonTestData.CREDIT_CARD_PAGEHEADER.getEnumValue(),
//					CommonTestData.CREDIT_CARD_PAGEHEADER.getEnumValue() + " Text is not matching");
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace(); throw e;
//		}
//	}
			 Dimension windowSize = driver.manage().window().getSize();
				System.out.println("getSessionId :"+driver.getSessionId());
				
				int h = windowSize.getHeight();
				int y1 = (int) (h * 0.2);
				int y2 = (int) (h - y1);
				int x = (int) ((windowSize.getWidth()) / 2);
				
				String s1 = driver.getPageSource();
				int count = 0;
				int index = 0;
				WaitUtils wait = new WaitUtils(driver);
				wait.ImplicitlyWait();
				while (count == 0 && index == 0) {
					if (IOShomePgaeObject.localRecipientsList().size() > 0) {
						//TakeScreenshot(IOShomePgaeObject.localRecipientsList().get(0));
						List<MobileElement> Elementlist = IOShomePgaeObject.localRecipientsList();
						//List<MobileElement> ElementlistClickable = DBSappObject.ListElementToClickable();
						int length = Elementlist.size();
						String LocalRecipientList = null;
						if (length < 5) {
							for (int i = 0; i < length; i++) {
								LocalRecipientList = Elementlist.get(i).getText();
								if (LocalRecipientList.equalsIgnoreCase(valueSelectedFromList)) {
									index++;
									
									clickOnElement(Elementlist.get(i));
									break;
								}
							}
							// Exception Handling without scrolling case and no expected element found in
							// the list then index ==0
							if (index == 0 && count == 0)
								Asserts.assertFail("Local Recipient " + valueSelectedFromList
										+ " not found in the list to initiate the fund transfer");
							else
								break;
						} else

							// Code will work :: When Need to scroll
							for (int i = 0; i < length; i++) {
								LocalRecipientList = Elementlist.get(i).getText();
								if (LocalRecipientList.equalsIgnoreCase(valueSelectedFromList) && isElementVisible2(Elementlist.get(i))) {
									index++;
									clickOnElement(Elementlist.get(i));
									break;
								}
							}
						if (index == 0) {
							touch.longPress(longPressOptions().withPosition(point(x, y2)).withDuration(ofSeconds(2)))
									.moveTo(element(IOShomePgaeObject.AllTab())).release().perform();

							String s2 = driver.getPageSource();
							if (s1.equals(s2) != true)
								s1 = s2;
							else
								count = 1;
						} else
							break;

						// Exception Handling in scrolling case and no expected element found in the
						// list then index ==0, count ==1
						if (count == 1 && index == 0)
							Asserts.assertFail("card Recipient " + valueSelectedFromList
									+ " not found in the list to initiate the fund transfer");

					} else
						Asserts.assertFail("No receipient Found in the Cards recipient list");
				}

				Thread.sleep(3000);
			String xpath1 = "//XCUIElementTypeStaticText[@name='Primary source of fund']";
			List<RemoteWebElement> list1 = driver.findElements(By.xpath(xpath1));
			if (list1.size() > 0) {
				clickOnPrimarySourceOfFund();
//				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
//				if (isElementVisible(IOShomePgaeObject.primarysourceOfFund()))
//					clickOnElement(IOShomePgaeObject.okButton());
			}
			Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.CreditCard_PageHeader()),
			CommonTestData.CREDIT_CARD_PAGEHEADER_IOS.getEnumValue(),
				CommonTestData.CREDIT_CARD_PAGEHEADER_IOS.getEnumValue() + " Text is not matching");
		
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to select account from Cards recipient and verify header  ",e);
		}
		catch (Exception e) {		
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to select account from Cards recipient and verify header  ",e);
		}
	}
		@Step("Select purpose")
		public void selectPurpose(String purpose) throws Exception//"Personal Gifts"
		{
			try {
				clickOnPurpose();
				if(IOShomePgaeObject.commonList().size() >0) {
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
				Asserts.assertTrue(index > 0, "Purposed " +purpose+" not found in the list");
				
			}
				else
				{
					Asserts.assertFail("No purpose List is found");
				}
				TakeScreenshot(IOShomePgaeObject.transferOverseaTitle());
			}
			catch (HandleException e) {	
				obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select purposed ",e);		
			}
			catch (Exception e) {			
				obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select Purposed ",e);
			}
	
}
		@Step("Application click on Purpose")
		public void clickOnPurpose() throws Exception {
			try {
				ButtonVerifyClick(IOShomePgaeObject.selectPurposeType());
			} catch (HandleException e) {
				obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Purpose  ", e);
			} catch (Exception e) {
				obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Purpose ", e);
			}
		}
		@Step("enter mobile No.")
		public void enterMobileNo(String MobileNo) throws Exception
		{
			try {
				TakeScreenshot(IOShomePgaeObject.enterMobileNo());
				enterTextInTextbox(IOShomePgaeObject.enterMobileNo(), MobileNo);
				doneButtonIfAviliable();
				wait.waitForElementVisibility(IOShomePgaeObject.transferOverseaTitle());
			}
			catch (HandleException e) {	
				obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Enter Mobile Number ",e);		
			}
			catch (Exception e) {			
				obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Enter Mobile Number ",e);
			}
	
}
		@Step("Verifies Remittance eOTT")
		public void VerifyRemittanceEOTT() throws Exception {
			try {
				ClickOnPayAndTransferButton();
				EnterPasscodeAndDone();
				SelectAllTAB();
				findPayeeUnderAllTab(CommonTestData.EOTTREMITTANCE_NAME.getEnumValue());
				//fieldText(CommonTestData.OVERSEAS_TRANSFER_PAGEHEADER.getEnumValue(), IOShomePgaeObject.overseaTransferTitle());
				selectFundSourceAndSelectAccountForCorredor(CommonTestData.SOURCE_ACCOUNT_NAME_CORRIDOR.getEnumValue());
				pressEnterKeyAfterEnteringAmount(CommonTestData.eOTT_AMOUNT.getEnumValue());
				gestUtils.scrollUPtoObjectIos("name", "Next", null);
				selectPurposeAccountTypeMobileNumberIfAvaliable("Savings","Personal Gifts","9999999990");
				ClickOnNextBtnAndVerifiesReviewTransferPage();
				ClickOnTransferNowBtnAndVerifiesTransferSubmittedMsg(CommonTestData.TRANSFER_SUBMITTED_MSG.getEnumValue());
				ClickOnImageExpandBtnAndVerifiesReferenceNumberText();
				ClickOnShareTransferDetailsBtnAndVerifiesReferenceNumberText();
				//BackToHomeFromRemittenceCoridor();
				
			}catch (HandleException e) {	
				obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Execute Remittance EOTT  ",e);			
			}
			catch (Exception e) {			
				obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Execute Remittance EOTT  ",e);
			}
		}
		@Step("Select All TAB.")
		public void SelectAllTAB() throws Exception {
			try {
				ButtonVerifyClick(IOShomePgaeObject.allTab());
			} catch (HandleException e) {	
				obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to select All Tab  ",e);
			}
			catch (Exception e) {		
				obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to select All Tab   ",e);
			}
		}
		@Step("Finding Payee under All Tab")
		public void findPayeeUnderAllTab(String ExpectedEottName ) throws Exception {
			try {
				ButtonVerifyClick(IOShomePgaeObject.searchBoxInPayAndTransfer());
				enterTextInTextbox(IOShomePgaeObject.searchBoxInPayAndTransfer(), ExpectedEottName);
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				driver.hideKeyboard();
				String xpath = "//XCUIElementTypeStaticText[@name='" + ExpectedEottName + "']";
				MobileElement ExpectedEottEle = (MobileElement) driver.findElement(By.xpath(xpath));
				isElementVisible(ExpectedEottEle);
				clickOnElement(ExpectedEottEle);
			} catch (HandleException e) {	
				obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Find Payee In All tab  ",e);
			}
			catch (Exception e) {		
				obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Find Payee In All tab   ",e);
			}
		}
		@Step("Verify CreditCard Temperary Limit Increase")
		public void CreditCardTempLimitIncrease() throws Exception {
			try {
				ClickOnMoreButton();
				EnterPasscodeAndDone();
				sendDataInCommonSearchBoxAndSelectFromDropDown(CommonTestData.TEMP_LIMIT_INCREASE_SEARCH.getEnumValue(), CommonTestData.TEMP_LIMIT_INCREASE.getEnumValue());
				EnterPasscodeAndDone();
				fieldText(CommonTestData.TEMP_LIMIT_INCREASE_TITLE.getEnumValue(), IOShomePgaeObject.temporaryLimitIncreaseHeader());
				setAmountDurationPurposeForLimitIncrease("100", "wedding");
				gestUtils.scrollUPtoObjectIos("label", "NEXT", null );
				ClickOnNextButton2();
				//ClickOnNextButton();
				fieldText(CommonTestData.REVIEW_APPLICATION_CREDITLIMIT_TITLE.getEnumValue(),IOShomePgaeObject.reviewApplicationHeader());
				 
			} catch (HandleException e) {	
				obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Execute Credit Card Temp Limit Increase ",e);
			}
			catch (Exception e) {		
				obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Execute Credit Card Temp Limit Increase ",e);
			} 
		}
		@Step("Enter amount , duration and purposed for creditLimit Increase")
		public void setAmountDurationPurposeForLimitIncrease(String Amount, String purpos) throws Exception {
			try {
				if (isElementEnable(IOShomePgaeObject.additionalCreditLimit())) {
					enterTextInTextbox(IOShomePgaeObject.additionalCreditLimit(), Amount);
				    doneButtonIfAviliable();
				}
				fieldText(CommonTestData.TEMP_LIMIT_INCREASE_TITLE.getEnumValue(), IOShomePgaeObject.temporaryLimitIncreaseHeader());
				ButtonVerifyClick( IOShomePgaeObject.purposeCreditLimit());
				fieldText(CommonTestData.PURPOSE_HEADER_IOS.getEnumValue(), IOShomePgaeObject.selectPurpose());
				if(IOShomePgaeObject.commonList().size() >0) {
				List<MobileElement> Elementlist = IOShomePgaeObject.commonList();
				int l = Elementlist.size();
				int index = 0;
				String purposedFromList = null;
				for (int i = 0; i < l; i++) {
					purposedFromList = Elementlist.get(i).getText();
					if (purposedFromList.equalsIgnoreCase(purpos)) {
						index++;
						clickOnElement(Elementlist.get(i));
						break;
					}
				}
				Asserts.assertTrue(index>0, "Overseas Payee " +purpos+" not found in the list");
				}
				else
				{
					Asserts.assertFail("No Purposed list is Found");
				}
				fieldText(CommonTestData.TEMP_LIMIT_INCREASE_TITLE.getEnumValue(), IOShomePgaeObject.temporaryLimitIncreaseHeader());
				ButtonVerifyClick( IOShomePgaeObject.durationCreditLimit());
				fieldText(CommonTestData.CALENDER_HEADER.getEnumValue(), IOShomePgaeObject.calenderTemporaryLimitIncreaseHeader());
				ButtonVerifyClick( IOShomePgaeObject.calenderDateOctEleven());
				ButtonVerifyClick( IOShomePgaeObject.confirmButton());
				fieldText(CommonTestData.TEMP_LIMIT_INCREASE_TITLE.getEnumValue(), IOShomePgaeObject.temporaryLimitIncreaseHeader());
				
			} catch (HandleException e) {	
				obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Set Amount Duration Purpose For Limit Increase  ",e);
			}
			catch (Exception e) {		
				obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Set Amount Duration Purpose For Limit Increase ",e);
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
				if (tabText.equalsIgnoreCase(CommonTestData.LOCAL_RECIPIENT_FROMLIST.getEnumValue())) {
					
					break;
				}
			}
			gestUtils.DragAndDropElementToElement(IOShomePgaeObject.allTabList().get(o), IOShomePgaeObject.AllTab());
			 Dimension windowSize = driver.manage().window().getSize();
				System.out.println("getSessionId :"+driver.getSessionId());
				
				int h = windowSize.getHeight();
				int y1 = (int) (h * 0.2);
				int y2 = (int) (h - y1);
				int x = (int) ((windowSize.getWidth()) / 2);
				
				String s1 = driver.getPageSource();
				int count = 0;
				int index = 0;
				WaitUtils wait = new WaitUtils(driver);
				wait.ImplicitlyWait();
				while (count == 0 && index == 0) {
					if (IOShomePgaeObject.localRecipientsList().size() > 0) {
						//TakeScreenshot(IOShomePgaeObject.localRecipientsList().get(0));
						List<MobileElement> Elementlist = IOShomePgaeObject.localRecipientsList();
						//List<MobileElement> ElementlistClickable = DBSappObject.ListElementToClickable();
						int length = Elementlist.size();
						String LocalRecipientList = null;
						if (length < 5) {
							for (int i = 0; i < length; i++) {
								LocalRecipientList = Elementlist.get(i).getText();
								if (LocalRecipientList.equalsIgnoreCase(valueSelectedFromList)) {
									index++;
									
									clickOnElement(Elementlist.get(i));
									break;
								}
							}
							// Exception Handling without scrolling case and no expected element found in
							// the list then index ==0
							if (index == 0 && count == 0)
								Asserts.assertFail("Local Recipient " + valueSelectedFromList
										+ " not found in the list to initiate the fund transfer");
							else
								break;
						} else

							// Code will work :: When Need to scroll
							for (int i = 0; i < length; i++) {
								LocalRecipientList = Elementlist.get(i).getText();
								if (LocalRecipientList.equalsIgnoreCase(valueSelectedFromList) && isElementVisible2(Elementlist.get(i))) {
									index++;
									clickOnElement(Elementlist.get(i));
									break;
								}
							}
						if (index == 0) {
							touch.longPress(longPressOptions().withPosition(point(x, y2)).withDuration(ofSeconds(2)))
									.moveTo(element(IOShomePgaeObject.AllTab())).release().perform();

							String s2 = driver.getPageSource();
							if (s1.equals(s2) != true)
								s1 = s2;
							else
								count = 1;
						} else
							break;

						// Exception Handling in scrolling case and no expected element found in the
						// list then index ==0, count ==1
						if (count == 1 && index == 0)
							Asserts.assertFail("Local Recipient " + valueSelectedFromList
									+ " not found in the list to initiate the fund transfer");

					} else
						Asserts.assertFail("No receipient Found in the Local recipient list");
				}

				Thread.sleep(3000);
			String xpath1 = "//XCUIElementTypeStaticText[@name='Primary source of fund']";
			List<RemoteWebElement> list1 = driver.findElements(By.xpath(xpath1));
			if (list1.size() > 0) {
				clickOnPrimarySourceOfFund();
//				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
//				if (isElementVisible(IOShomePgaeObject.primarysourceOfFund()))
//					clickOnElement(IOShomePgaeObject.okButton());
			}
				//verifyPageHeader(CommonTestData.TRANSFER_DBS_POSB.getEnumValue(), DBSappObject.PageHeader());
				//TakeScreenshot(DBSappObject.PageHeader());
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to select account from local recipient and verify header  ",e);
		}
		catch (Exception e) {		
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to select account from local recipient and verify header  ",e);
		}
	}
	

//			gestUtils.DragAndDropElementToElement(IOShomePgaeObject.allTabList().get(o), IOShomePgaeObject.AllTab());
//			TakeScreenshot(IOShomePgaeObject.localRecipientsList().get(0));
//			List<MobileElement> Elementlist = IOShomePgaeObject.localRecipientsList();
//			int l = Elementlist.size();
//			int index = 0;
//			String LocalRecipientList = null;
//			for (int i = 0; i < l; i++) {
//				LocalRecipientList = Elementlist.get(i).getText();
//				if (LocalRecipientList.equalsIgnoreCase(valueSelectedFromList)) {
//					index++;
//					clickOnElement(Elementlist.get(i));
//					break;
//				}
//			}
//			Asserts.assertTrue(index > 0, "No element found in the list of corresponding value");
//
//			Thread.sleep(3000);
//			String xpath1 = "//XCUIElementTypeStaticText[@name='Primary source of fund']";
//			List<RemoteWebElement> list1 = driver.findElements(By.xpath(xpath1));
//			if (list1.size() > 0) {
//				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
//				if (isElementVisible(IOShomePgaeObject.primarysourceOfFund()))
//					clickOnElement(IOShomePgaeObject.okButton());
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace(); throw e;
//		}
//	}
	
	@Step("Verifies the Payee Add Bill Payment and after completion payment verifies the transfering amount.")
	public void PayeeAddBillPayment() throws Exception {
		try {
			ClickOnPayAndTransferButton();
			EnterPasscodeAndDone();
			ClickOnBillModuleAndClickOnAddBillingOrganisation();
			EnterBillingOrganisationDetails(CommonTestData.PAYEEADD_BILLPAYMENT_ACCOUNTNAME.getEnumValue(),
					CommonTestData.PAYEEADD_BILLPAYMENT_REFERENCENUMBER.getEnumValue());
			ClickOnNextButton();
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
		}catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION",
					" Failed to Execute Payee Add To Bill Payment ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Execute Payee Add to Bill Payment  ",
					e);
		}
	}
	
	
	@Step("Delete Payee to Bill Payment.")
	public void DeletePayee_ToBillPayment() throws Exception {
		try {
			ClickOnPayAndTransferButton();
			EnterPasscodeAndDone();
			TakeScreenshot(IOShomePgaeObject.BillsButton());
			clickOnElement(IOShomePgaeObject.BillsButton());
			DeletePayee(CommonTestData.PAYEEADD_BILLPAYMENT_ACCOUNTNAME.getEnumValue());
			
			// Leave On Home Page to this test case for next run.
			ClickOnCloseButton();
			ClickOnHomeButton();
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Delete Payee to Bill Payment.",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Delete Payee to Bill Payment. ",e);
		}
	}
	
	@Step("Click On Bill Module & Verify Enter Recipient Page Header After Click On Add Billing Organisation.")
	public void ClickOnBillModuleAndClickOnAddBillingOrganisation() throws Exception {
		try {
			TakeScreenshot(IOShomePgaeObject.BillsButton());
			clickOnElement(IOShomePgaeObject.BillsButton());

			String xpath = "//android.widget.Button[@text='ADD RECIPIENT NOW']";
			List<RemoteWebElement> list = driver.findElements(By.xpath(xpath));
			if (list.size() > 0) {
				TakeScreenshot(IOShomePgaeObject.AddRecipientNowButton());
				clickOnElement(IOShomePgaeObject.AddRecipientNowButton());
			} else {
				TakeScreenshot(IOShomePgaeObject.AddBillingOrganisation());
				clickOnElement(IOShomePgaeObject.AddBillingOrganisation());
			}
			List<RemoteWebElement> recipientDetailsHeader = driver.findElements(By.name("Enter Recipient’s Details"));
			Asserts.assertTrue(isElementVisible2((MobileElement) recipientDetailsHeader.get(recipientDetailsHeader.size()-1)),
					" 'Enter Recipient’s Details' Page Header not displaying.");
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Bill Module & Verify Enter Recipient Page Header After Click On Add Billing Organisation.",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Bill Module & Verify Enter Recipient Page Header After Click On Add Billing Organisation. ",e);
		}
	}
	
	@Step("Enter Billing Organisation Details.")
	public void EnterBillingOrganisationDetails(String AccountName, String ReferenceNo) throws Exception {
		try {
			TakeScreenshot(IOShomePgaeObject.SelectBillingOrganisation());
			clickOnElement(IOShomePgaeObject.SelectBillingOrganisation());
			clickOnElement(IOShomePgaeObject.SearchForBillingOrganisationField());
			enterTextInTextbox(IOShomePgaeObject.SearchForBillingOrganisationField(), AccountName);
			Thread.sleep(1000);
			// xpath = "//XCUIElementTypeTextField[@name='"+AccountName+"']";
			MobileElement SelectBillingOrganisation = (MobileElement) driver.findElement(By.name(AccountName));
			clickOnElement(SelectBillingOrganisation);
			clickOnElement(IOShomePgaeObject.EnterReferenceNoEditField());
			enterTextInTextbox(IOShomePgaeObject.EnterReferenceNoEditField(), ReferenceNo);
			//backButton();
			doneButtonIfAviliable();
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
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verifies Billing Organisation And Bill Reference Number ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verifies Billing Organisation And Bill Reference Number ",e);
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
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Click On Make A Payment Button And Enter Amount In Amount Edit Field. ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Click On Make A Payment Button And Enter Amount In Amount Edit Field. ",e);
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
			//ClickOnNextButton();
			ClickOnNextButton2();
			Asserts.assertTrue(isElementVisible(IOShomePgaeObject.ReviewTransferPageHeader()),
					CommonTestData.REVIEW_TRANSFER.getEnumValue() + " Page Header not displaying.");
			ClickOnTransferNowBtnAndVerifiesTransferSubmittedMsg(CommonTestData.TRANSFERRED.getEnumValue(), IOShomePgaeObject.TransferredMsg()); 
			
			VerifyAccountDetailsAfterFundTransferToOwnAccount();
			
			//Leaving On Home page for next case run.
			//clickOnElement(IOShomePgaeObject.BackToHomeButton()); 
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to verify Fund transfer to own account  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to verify Fund transfer to own account ", e);
		}
	}
	
	@Step("Verify Account Details After Fund Transfer To Own Account.")
	public void VerifyAccountDetailsAfterFundTransferToOwnAccount() throws Exception {
		try {
			Asserts.assertTrue(IOShomePgaeObject.logoutPaylah().isDisplayed(), "Log Out Button not matching.");
			//Asserts.assertTrue(IOShomePgaeObject.BackToHomeButton().isDisplayed(), "BACK To HOME Button not found.");
			Asserts.assertTrue(IOShomePgaeObject.MakeAnotherTransferButton2().isDisplayed(),
					"MAKE ANOTHER TRANSFER Button not found.");
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verify Account Details After Fund Transfer To Own Account. ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify Account Details After Fund Transfer To Own Account. ",e);
		}
	}

	
	@Step("Verifies Transfer Submitted Message after clicking on Transfer Now Button.")
	public void ClickOnTransferNowBtnAndVerifiesTransferSubmittedMsg(String SuccessMsg,
			MobileElement transfferdSubmitMsgEle) throws Exception {
		try {
			clickOnElement(IOShomePgaeObject.TRANSFERNOWButton());
			//TakeScreenshot(successImage);
			//if (isElementVisible(successImage))
				Asserts.assertEquals(getTexOfElement(transfferdSubmitMsgEle), SuccessMsg,
						SuccessMsg + " Text is not matching");
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verifies Transfer Submitted Message after clicking on Transfer Now Button. ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verifies Transfer Submitted Message after clicking on Transfer Now Button. ",e);
		}
	}
	
	@Step("Select 'Your DBS/POSB Accounts' and then verify 'Transfer to Your Account' Page header after selecting any own account option.")
	public void SelectOWNAccountAndAnyAccountOption(String ToOwnAccount) throws Exception {
		try {
			clickOnElement(IOShomePgaeObject.SelectOwnAccount());
//			String xpath = "//XCUIElementTypeStaticText[@name='"+ ToOwnAccount + "']";
//			MobileElement ToAccountNo = (MobileElement) driver.findElement(By.xpath(xpath));
//			clickOnElement(ToAccountNo);
//			TakeScreenshot(IOShomePgaeObject.TransferToOwnAccountPageHeader());
			
//			Asserts.assertTrue(isElementVisible(IOShomePgaeObject.TransferToOwnAccountPageHeader()),
//					CommonTestData.TRANSFER_TO_YOUR_ACCOUNT.getEnumValue() + " Page Header not displaying.");
//		} catch (Exception e) {
//			e.printStackTrace(); throw e;
//		}
//	}
			gestUtils.DragAndDropElementToElement(IOShomePgaeObject.allTabList().get(1), IOShomePgaeObject.AllTab());
			 Dimension windowSize = driver.manage().window().getSize();
				System.out.println("getSessionId :"+driver.getSessionId());
				
				int h = windowSize.getHeight();
				int y1 = (int) (h * 0.2);
				int y2 = (int) (h - y1);
				int x = (int) ((windowSize.getWidth()) / 2);
				
				String s1 = driver.getPageSource();
				int count = 0;
				int index = 0;
				WaitUtils wait = new WaitUtils(driver);
				wait.ImplicitlyWait();
				while (count == 0 && index == 0) {
					if (IOShomePgaeObject.localRecipientsList().size() > 0) {
						//TakeScreenshot(IOShomePgaeObject.localRecipientsList().get(0));
						List<MobileElement> Elementlist = IOShomePgaeObject.localRecipientsList();
						//List<MobileElement> ElementlistClickable = DBSappObject.ListElementToClickable();
						int length = Elementlist.size();
						String LocalRecipientList = null;
						if (length < 5) {
							for (int i = 0; i < length; i++) {
								LocalRecipientList = Elementlist.get(i).getText();
								if (LocalRecipientList.equalsIgnoreCase(ToOwnAccount)) {
									index++;
									
									clickOnElement(Elementlist.get(i));
									break;
								}
							}
							// Exception Handling without scrolling case and no expected element found in
							// the list then index ==0
							if (index == 0 && count == 0)
								Asserts.assertFail("Local Recipient " + ToOwnAccount
										+ " not found in the list to initiate the fund transfer");
							else
								break;
						} else

							// Code will work :: When Need to scroll
							for (int i = 0; i < length; i++) {
								LocalRecipientList = Elementlist.get(i).getText();
								if (LocalRecipientList.equalsIgnoreCase(ToOwnAccount) && isElementVisible2(Elementlist.get(i))) {
									index++;
									clickOnElement(Elementlist.get(i));
									break;
								}
							}
						if (index == 0) {
							touch.longPress(longPressOptions().withPosition(point(x, y2)).withDuration(ofSeconds(2)))
									.moveTo(element(IOShomePgaeObject.AllTab())).release().perform();

							String s2 = driver.getPageSource();
							if (s1.equals(s2) != true)
								s1 = s2;
							else
								count = 1;
						} else
							break;

						// Exception Handling in scrolling case and no expected element found in the
						// list then index ==0, count ==1
						if (count == 1 && index == 0)
							Asserts.assertFail("Local Recipient " + ToOwnAccount
									+ " not found in the list to initiate the fund transfer");

					} else
						Asserts.assertFail("No receipient Found in the Local recipient list");
				}

				Thread.sleep(3000);
			String xpath1 = "//XCUIElementTypeStaticText[@name='Primary source of fund']";
			List<RemoteWebElement> list1 = driver.findElements(By.xpath(xpath1));
			if (list1.size() > 0) {
				clickOnPrimarySourceOfFund();
//				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
//				if (isElementVisible(IOShomePgaeObject.primarysourceOfFund()))
//					clickOnElement(IOShomePgaeObject.okButton());
			}
			Asserts.assertTrue(isElementVisible(IOShomePgaeObject.TransferToOwnAccountPageHeader()),
				CommonTestData.TRANSFER_TO_YOUR_ACCOUNT.getEnumValue() + " Page Header not displaying.");
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to select account from own Account and verify header  ",e);
		}
		catch (Exception e) {		
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to select account from own Account and verify header  ",e);
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
			scrollToBillingOrganisation();
			clickingOnAccountTypeInBillingOrganisations(ExpectedToBankNameWithAccountNo);
			EnterAmount(IOShomePgaeObject.AmountEditableField(), CommonTestData.AMOUNTTO_TRANSFERFUND.getEnumValue());
			String ExpectedSelectedDate = getTexOfElement(IOShomePgaeObject.TransferDateTextElement());
			Asserts.assertEquals("Immediate", ExpectedSelectedDate, "Selected Date is not Matching");

			//ClickOnNextButton();
			ClickOnNextButton2();
			Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.ReviewPaymentPageHeader()),
					CommonTestData.REVIEW_PAYMENT_PAGEHEADER.getEnumValue(),
					CommonTestData.REVIEW_PAYMENT_PAGEHEADER.getEnumValue() + " Text is not matching");
			ClickOnTransferNowBtnAndVerifyPaymentSubmittedMsg();

			// Leave On Home Page to this test case for next run.
//			ClickOnCloseButton();
//			ClickOnHomeButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION",
					" Failed to verify Fund transfer bill payment  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to verify Fund transfer bill payment  ",
					e);
		}
	}
	
	@Step("Click on 'To Account Bill' after selecting 'Billing organisation' and verify Page Header")
	public void clickingOnAccountTypeInBillingOrganisations(String valueSelectedFromList) throws Exception {
		try {
//			int o = 0;
//			for (int i = 0; i < IOShomePgaeObject.allTabList().size(); i++) {
//				String tabText = IOShomePgaeObject.allTabList().get(i).getText();
//				o++;
//				if (tabText.contains(CommonTestData.BILLING_ORGANISATIONS_TAB.getEnumValue())) {
//					//clickOnElement(IOShomePgaeObject.allTabList().get(i));
//					break;
//				}
//			}
            MobileElement ele=(MobileElement) driver.findElementByName("Billing Organisations");
			gestUtils.DragAndDropElementToElement(ele, IOShomePgaeObject.AllTab());
//			TakeScreenshot(IOShomePgaeObject.localRecipientsList().get(0));
//			List<MobileElement> Elementlist = IOShomePgaeObject.localRecipientsList();
//			int l = Elementlist.size();
//			int index = 0;
//			String LocalRecipientList = null;
//			for (int i = 0; i < l; i++) {
//				LocalRecipientList = Elementlist.get(i).getText();
//				if (LocalRecipientList.equalsIgnoreCase(valueSelectedFromList)) {
//					index++;
//					clickOnElement(Elementlist.get(i));
//					break;
//				}
//			}
//			Asserts.assertTrue(index > 0, "No element found in the list of corresponding value");
//
//			Thread.sleep(3000);
//			String xpath1 = "//XCUIElementTypeStaticText[@name='Primary source of fund']";
//			List<RemoteWebElement> list1 = driver.findElements(By.xpath(xpath1));
//			if (list1.size() > 0) {
//				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
//				if (isElementVisible(IOShomePgaeObject.primarysourceOfFund()))
//					clickOnElement(IOShomePgaeObject.okButton());
//			}
//			
//			
//			Asserts.assertTrue(isElementVisible(IOShomePgaeObject.PayToBillerPageHeader()),
//					CommonTestData.PAY_TO_BILLER_PAGE_HEADER.getEnumValue() + " Page Header not displaying.");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw e;
//		}
//	}
			Dimension windowSize = driver.manage().window().getSize();
			System.out.println("getSessionId :"+driver.getSessionId());
			
			int h = windowSize.getHeight();
			int y1 = (int) (h * 0.2);
			int y2 = (int) (h - y1);
			int x = (int) ((windowSize.getWidth()) / 2);
			
			String s1 = driver.getPageSource();
			int count = 0;
			int index = 0;
			WaitUtils wait = new WaitUtils(driver);
			wait.ImplicitlyWait();
			while (count == 0 && index == 0) {
				if (IOShomePgaeObject.localRecipientsList().size() > 0) {
					//TakeScreenshot(IOShomePgaeObject.localRecipientsList().get(0));
					List<MobileElement> Elementlist = IOShomePgaeObject.localRecipientsList();
					//List<MobileElement> ElementlistClickable = DBSappObject.ListElementToClickable();
					int length = Elementlist.size();
					String LocalRecipientList = null;
					if (length < 5) {
						for (int i = 0; i < length; i++) {
							LocalRecipientList = Elementlist.get(i).getText();
							if (LocalRecipientList.equalsIgnoreCase(valueSelectedFromList)) {
								index++;
								
								clickOnElement(Elementlist.get(i));
								break;
							}
						}
						// Exception Handling without scrolling case and no expected element found in
						// the list then index ==0
						if (index == 0 && count == 0)
							Asserts.assertFail("Local Recipient " + valueSelectedFromList
									+ " not found in the list to initiate the fund transfer");
						else
							break;
					} else

						// Code will work :: When Need to scroll
						for (int i = 0; i < length; i++) {
							LocalRecipientList = Elementlist.get(i).getText();
							if (LocalRecipientList.equalsIgnoreCase(valueSelectedFromList) && isElementVisible2(Elementlist.get(i))) {
								index++;
								clickOnElement(Elementlist.get(i));
								break;
							}
						}
					if (index == 0) {
						touch.longPress(longPressOptions().withPosition(point(x, y2)).withDuration(ofSeconds(2)))
								.moveTo(element(IOShomePgaeObject.AllTab())).release().perform();

						String s2 = driver.getPageSource();
						if (s1.equals(s2) != true)
							s1 = s2;
						else
							count = 1;
					} else
						break;

					// Exception Handling in scrolling case and no expected element found in the
					// list then index ==0, count ==1
					if (count == 1 && index == 0)
						Asserts.assertFail("Local Recipient " + valueSelectedFromList
								+ " not found in the list to initiate the fund transfer");

				} else
					Asserts.assertFail("No receipient Found in the Local recipient list");
			}

			Thread.sleep(3000);
		String xpath1 = "//XCUIElementTypeStaticText[@name='Primary source of fund']";
		List<RemoteWebElement> list1 = driver.findElements(By.xpath(xpath1));
		if (list1.size() > 0) {
			clickOnPrimarySourceOfFund();
//			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
//			if (isElementVisible(IOShomePgaeObject.primarysourceOfFund()))
//				clickOnElement(IOShomePgaeObject.okButton());
		}
		Asserts.assertTrue(isElementVisible(IOShomePgaeObject.PayToBillerPageHeader()),
		CommonTestData.PAY_TO_BILLER_PAGE_HEADER.getEnumValue() + " Page Header not displaying.");
			//verifyPageHeader(CommonTestData.TRANSFER_DBS_POSB.getEnumValue(), DBSappObject.PageHeader());
			//TakeScreenshot(DBSappObject.PageHeader());
	} catch (HandleException e) {	
		obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to select account from local recipient and verify header  ",e);
	}
	catch (Exception e) {		
		obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to select account from local recipient and verify header  ",e);
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
			
			gestUtils.scrollUPtoObjectIos("label", "NEXT", null);
		    ClickOnNextButton3();
			ClickOnSubmitButtonAfterSettingCardPIN();
			
			// Leave On Home Page to this test case for next run.
			ClickOnCloseButton();
			ClickOnHomeButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Execute Apply Debit card  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Execute Apply Debit card  ", e);
		}
	}
	
	
	
	@Step("Verifying Next Label and click")
	public void ClickOnNextButton3() throws Exception {
		try {
			List<RemoteWebElement> nextButton = driver.findElements(By.name("NEXT"));
			List<RemoteWebElement> nextButton1 = driver.findElements(By.name("Next"));
			if(nextButton.size() > 0) {
				TakeScreenshot(nextButton.get(nextButton.size()-1));
				String actualText = commonAppTest.getTexOfElement((MobileElement) nextButton.get(1));
				if (actualText.equalsIgnoreCase("NEXT"))
					commonAppTest.clickOnElement((MobileElement) nextButton.get(1));
				Asserts.assertEquals(actualText, "NEXT", "Button not found");
			}
			else if(nextButton1.size() > 0) {
				TakeScreenshot(nextButton.get(nextButton1.size()-1));
				String actualText = commonAppTest.getTexOfElement((MobileElement) nextButton1.get(1));
				if (actualText.equalsIgnoreCase("NEXT"))
					commonAppTest.clickOnElement((MobileElement) nextButton1.get(1));
				Asserts.assertEquals(actualText, "Next", "Button not found");
			}
			
		}catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Next Button ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Next Button ",e);
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

		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Verifies the Set Card Pin Page Header and then Submit While Entering Confirm and Create New Pin & Verifies the 'Application Submitted' Message. ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Verifies the Set Card Pin Page Header and then Submit While Entering Confirm and Create New Pin & Verifies the 'Application Submitted' Message. ",e);
		}
	}

	@Step("Select Debit Card Option After Clicking on Cards Section and then 2FA Authentication Done.")
	public void SelectDebitCardOptionFromCardsSectionAndAuthenticationOfSecurePIN() throws Exception {
		try {
			sendDataInCommonSearchBoxAndSelectFromDropDown("Cards", null);
			//gestUtils.scrollUPtoObjectIos("label", "Cards", null);
			if (isElementVisible(IOShomePgaeObject.CardsButton()))
				clickOnElement(IOShomePgaeObject.CardsButton());
			TakeScreenshot(IOShomePgaeObject.SelectDebitCard()); 
			clickOnElement(IOShomePgaeObject.SelectDebitCard());
			EnterPasscodeAndDone();
			selectDebitCardType(CommonTestData.DEBIT_CARD_NAME.getEnumValue());
			TakeScreenshot(IOShomePgaeObject.AccountToBeLinkedToTheCardField()); 
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select Debit Card Option After Clicking on Cards Section and then 2FA Authentication Done", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select Debit Card Option After Clicking on Cards Section and then 2FA Authentication Done", e);
		}
	}
	
	@Step("Click on 'Account type' From List under Local fund Limit page'")
	public void selectDebitCardType(String debitCardToBeSelected) throws Exception {
		try {
			//TakeScreenshot(IOShomePgaeObject.DebitCardDetailsDropdownList().get(1)); 
			if(IOShomePgaeObject.DebitCardDetailsDropdownList().size() >0) {
			List<MobileElement> Elementlist = IOShomePgaeObject.DebitCardDetailsDropdownList();
			int l = Elementlist.size();
			int index = 0;
			String accountFromList = null;
			for (int i = 0; i < l; i++) {
				accountFromList = Elementlist.get(i).getText();
				if (accountFromList.contains(debitCardToBeSelected)) {
					index++;
					clickOnElement(Elementlist.get(i));
					break;
				}
			}
			Asserts.assertTrue(index > 0, "No " + debitCardToBeSelected + " found in the list of corresponding value");
			}
			else
			{
				Asserts.assertFail("No DebitCard found in the list");
			}
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click on 'Account type' From List under Local fund Limit page",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click on 'Account type' From List under Local fund Limit page",e);
		}
	}
	
	@Step("Filling Details To Applying Debit Card.")
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
			doneButtonIfAviliable();
			TakeScreenshot(IOShomePgaeObject.EducationField()); 
			
			gestUtils.scrollUPtoObjectIos("label", "Education", null);
//			Dimension windowSize1 = driver.manage().window().getSize();
//			int y =(int)(windowSize1.getHeight()/2);
//			int x =(int)((windowSize1.getWidth())/2);
//			gestUtils.swipeCoordinatetoCoordinate(x, y, x, y-125);
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

			gestUtils.scrollUPtoObjectIos("text", "NEXT", null);
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
			gestUtils.scrollUPtoObjectIos("label", "NEXT", null);
			ClickOnNextButton2();
			//ClickOnNextButton();
			VerifyWarningMessageAndImportantNotes();
			ClickOnIAcknowledgeButtonAndReviewOpenAccountApplication();
			ClickOnOpenAccountNowButton();
			
			// Leave On Home Page to this test case for next run.
			//ClickOnCloseButton();
			//ClickOnHomeButton();
		}catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Exceute Open Account ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Exceute Open Account ", e);
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
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Selecting Overseas Payee ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Selecting Overseas Payee ",e);
		}
	}

	@Step("Enter Monthly Savings Amount And Select Source Of Funds For Savings.")
	public void EnterMonthlySavingsAmtAndSelectSourceOfFundsForSavings() throws Exception {
		try {
			clickOnElement(IOShomePgaeObject.EnterMonthlySavingsAmtEditField());
			enterTextInTextbox(IOShomePgaeObject.EnterMonthlySavingsAmtEditField(),
					CommonTestData.MONTHLY_SAVING_AMT_BALANCE.getEnumValue());
			doneButtonIfAviliable();
			
			clickOnElement(IOShomePgaeObject.SelectSourceOfFundsForSavingsDropdown());
			selectElementFromTheGivenList(IOShomePgaeObject.SelectSourceOfFundsForSavingsDropdownList(),
					CommonTestData.SELECT_ACCOUNT.getEnumValue());
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Enter Monthly Savings Amount And Select Source Of Funds For Savings. ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Enter Monthly Savings Amount And Select Source Of Funds For Savings.",e);
		}
	}

	@Step("Click On Open Account In 2/3 Step Button.")
	public void ClickOnopenAccountInStepButton() throws Exception {
		try {
			
			clickOnElement(IOShomePgaeObject.StepOpenAccountButton2());
			TakeScreenshot(IOShomePgaeObject.OpenAccountPageHeader()); 
		
			Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.OpenAccountPageHeader()), CommonTestData.OPEN_ACCOUNT.getEnumValue(),
					CommonTestData.OPEN_ACCOUNT.getEnumValue() + " Page Header Text is not matching");
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Open Account In 2/3 Step Button ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Open Account In 2/3 Step Button",e);
		}
	}

	@Step("Click On Deposit Accounts Module And 2FA Authentication Done And Verifies the Open Account Page Header.")
	public void ClickOnDepositAccountsAnd2FAAuthenticationDone() throws Exception {
		try {
			//gestUtils.scrollUPtoObject("text", "Deposit Accounts", IOShomePgaeObject.DepositAccountsModule());
			//TakeScreenshot(IOShomePgaeObject.DepositAccountsModule()); 
			//clickOnElement(IOShomePgaeObject.DepositAccountsModule());
			sendDataInCommonSearchBoxAndSelectFromDropDown("Deposit", "Deposit Accounts");
			EnterPasscodeAndDone();
			Asserts.assertTrue(isElementVisible(IOShomePgaeObject.OpenAccountPageHeader()),
					CommonTestData.OPEN_ACCOUNT.getEnumValue() + " Page Header not displaying.");
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Deposit Accounts Module And 2FA Authentication Done And Verifies the Open Account Page Header. ",e);		
		}
		catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Deposit Accounts Module And 2FA Authentication Done And Verifies the Open Account Page Header.", e);
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
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verify Warning Message And Important Notes. ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify Warning Message And Important Notes. ",e);
		}
	}

	@Step("Click On Open Account Now Button And Got 'Your account is open and ready to use!' Message.")
	public void ClickOnOpenAccountNowButton() throws Exception {
		try {
			gestUtils.scrollUPtoObjectIos("label", "OPEN ACCOUNT NOW", null);
			TakeScreenshot(IOShomePgaeObject.OpenAccountNowButton()); 
			clickOnElement(IOShomePgaeObject.OpenAccountNowButton());
			TakeScreenshot(IOShomePgaeObject.AccountStatusMessage()); 
			//if (isElementVisible(IOShomePgaeObject.SuccessImage().get(0))) 
				Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.AccountStatusMessage()),
						CommonTestData.YOUR_ACCOUNT_OPEN_READYTOUSE_MESSAGE.getEnumValue(),
						CommonTestData.YOUR_ACCOUNT_OPEN_READYTOUSE_MESSAGE.getEnumValue()
								+ " Message is not matching.");
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Open Account Now Button And Got 'Your account is open and ready to use!' Message.",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Open Account Now Button And Got 'Your account is open and ready to use!' Message. ",e);
		}	}

	@Step("Click On IAcknowledge Button And Review Open Account Application.")
	public void ClickOnIAcknowledgeButtonAndReviewOpenAccountApplication() throws Exception {
		try {
			gestUtils.scrollUPtoObjectIos("label", "I ACKNOWLEDGE", null);
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

		}catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On IAcknowledge Button And Review Open Account Application. ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On IAcknowledge Button And Review Open Account Application. ",e);
		}
	}
	

	public MobileElement verifyElementExistInTheList(List<MobileElement> elementList, String elementTextToBeVerified)
			throws Exception {
		MobileElement element = null;
		try {
			//wait.waitForElementVisibility(elementList.get(1));
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
	public void locationSwipPopup() throws Exception    
	{
		
		try {
//			Thread.sleep(1000);
//			String Xpath = "//XCUIElementTypeStaticText[@name='Upgrade your banking experience with us']";
//			List<RemoteWebElement> list = driver.findElements(By.xpath(Xpath));
//			if (list.size() > 0) {
			if(isElementVisible2(IOShomePgaeObject.goToLocationSettingButton())) {
					Dimension windowSize1 = driver.manage().window().getSize();
					int y =(int)((windowSize1.getHeight())-100);
					int x =(int)((windowSize1.getWidth())/2);
					int x2=getXCoordinateOfElement(IOShomePgaeObject.goToLocationSettingButton());
					int y2=getYCoordinateOfElement(IOShomePgaeObject.goToLocationSettingButton());
					int x1=getXCoordinateOfElement(IOShomePgaeObject.swipeButton());
					int y1=getYCoordinateOfElement(IOShomePgaeObject.swipeButton());
					//gestUtils.swipeElementtoCoordinate(IOShomePgaeObject.swipeButton(),  x1,  y1);
					gestUtils.swipeCoordinatetoCoordinate(x1, y1, x2, y2);
				}
			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Swipe Location Alert Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Swipe Location Alert Button ", e);
		}
	}
	@Step("clicking On 'ADD OVERSEA RECIPIENT NOW' button")
	public void ClickOnAddOverseaRecipientButton() throws Exception {
		try {
			fieldText(CommonTestData.OVERSEAS_TRANSFER_PAGEHEADER.getEnumValue().toLowerCase(),IOShomePgaeObject.overseaTransferTitle());
			//EnterPasscodeAndDone();
			String xpath = "(//XCUIElementTypeStaticText[@name='Add overseas recipient'])[2]";
			List<RemoteWebElement> list = driver.findElements(By.xpath(xpath));
			if (list.size() > 0) {
				ButtonVerifyClick(IOShomePgaeObject.addOverseaRecipientSecond());
			}
			else
				ButtonVerifyClick(IOShomePgaeObject.addOverseaRecipientFirst());

		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On ADD OVERSEA RECIPIENT NOW Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On ADD OVERSEA RECIPIENT NOW Button ", e);
		}
	}
	@Step("digital Token Setup")
	public void digitalToken() throws Exception {
		try {
			
			if(isElementVisible2(IOShomePgaeObject.setupTokenMessage())) {
			//if (list.size() > 0) {
				ButtonVerifyClick(IOShomePgaeObject.setupNowButton());
				clickOnDigitalTokenAlert();
				clickOnNextOnConfirmEmailDigiToken();
//				String xpath1 = "//XCUIElementTypeStaticText[@name='Please note you can only have one digital token registered to your profile. Any digital token on an alternative device will therefore be automatically deregistered.']";
//				List<RemoteWebElement> list1 = driver.findElements(By.xpath(xpath1));
//				if (list1.size() > 0) {
//					ButtonVerifyClick(IOShomePgaeObject.continueButton());
//				Thread.sleep(2000);
//				}
				EnterPasscodeAndDone();
				EnterPasscodeAndDone();
				clickOnDoneOnYouHaveSetupDigiToken();
			}

		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to digital Token Setup ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to digital Token Setup ", e);
		}
	}
	@Step("send key with keyboard")
	public void sendTextWithKeypad(String Text) throws Exception {
		try {
			Thread.sleep(5000);
			String text =Text.toLowerCase();
			int length=text.length();
			for (int i = 0; i < length; i++) {
			String L=Character.toString(text.charAt(i));
			String U=Character.toString(text.toUpperCase().charAt(i));		
					String lowerxpath = "//XCUIElementTypeKey[@name='" + L + "']";
					String upperxpath = "//XCUIElementTypeKey[@name='" + U + "']";
					List<RemoteWebElement> listLower = driver.findElements(By.xpath(lowerxpath));
					List<RemoteWebElement> listupper = driver.findElements(By.xpath(upperxpath));
					if (listLower.size() > 0)
					{
					clickOnElement((MobileElement)listLower.get(0));
					Thread.sleep(2000);
					}
					else if(listupper.size() > 0)
					{
					clickOnElement((MobileElement)listupper.get(0));
					Thread.sleep(2000);
					}
					else
						Asserts.assertTrue(false,"no elemet is present on keyboard");
			}
		}catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to send Text  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to send Text ", e);
		}
	}
	@Step("slect UAT server")
	public void selectUATserver(String UAT) throws Exception {
		try {
			ButtonVerifyClick(IOShomePgaeObject.moreOnLogin());
			TakeScreenshot(IOShomePgaeObject.serverLabel());
			IOShomePgaeObject.changeServerButton().click();
			Thread.sleep(2000);
			TakeScreenshot(IOShomePgaeObject.changeServerLabel());
			gestUtils.scrollUPtoObjectIos("name", UAT, null);
			String xpath = "//XCUIElementTypeStaticText[@name='" + UAT + "']";
			MobileElement button = (MobileElement) driver.findElement(By.xpath(xpath));
			clickOnElement(button);
			
			ButtonVerifyClick(IOShomePgaeObject.saveButton());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	@Step("Clicked on Pre Login button")
	public void clickOnPreLoginButton() throws Exception {
		try {
			if(isElementVisible2(IOShomePgaeObject.preLoginButton())) {
				ButtonVerifyClick(IOShomePgaeObject.preLoginButton());
				}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	@Step("Clicked on Digital token Registration message")
	public void clickOnDigitalTokenAlert() throws Exception {
		try {
			if(isElementVisible2(IOShomePgaeObject.digitokeRegisterAlertMsg())) {
				ButtonVerifyClick(IOShomePgaeObject.continueButton());
				}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	@Step("Clicked on Done on You have setup digital token")
	public void clickOnDoneOnYouHaveSetupDigiToken() throws Exception {
		try {
			TakeScreenshot(IOShomePgaeObject.youHaveSetTokenMessage());
			ButtonVerifyClick(IOShomePgaeObject.doneButton2());
				}
		 catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	@Step("Swiping the aler message ")
	public void managementSwipeAlert() throws Exception {
		try {
			if(isElementVisible2(IOShomePgaeObject.managementAlertMsg())) {
				Dimension windowSize1 = driver.manage().window().getSize();
				int y =(int)((windowSize1.getHeight())-10);
				int x =(int)((windowSize1.getWidth())/2);
				int x2=getXCoordinateOfElement(IOShomePgaeObject.managementAlertMsg());
				int y2=getYCoordinateOfElement(IOShomePgaeObject.managementAlertMsg());
				int x1=getXCoordinateOfElement(IOShomePgaeObject.swipeButton2());
				int y1=getYCoordinateOfElement(IOShomePgaeObject.swipeButton2());
				//gestUtils.swipeElementtoCoordinate(IOShomePgaeObject.swipeButton(),  x1,  y1);
				gestUtils.swipeCoordinatetoCoordinate(x1, y1, x2, y2);
				//gestUtils.swipeElementtoCoordinate(IOShomePgaeObject.swipeButton2(),  x,  y);
				
				}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Swipe the alert message  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Swipe the alert message ", e);
		}

	}
	@Step("Clicked on Next on Confirm Email digital token")
	public void clickOnNextOnConfirmEmailDigiToken() throws Exception {
		try {
			if(isElementVisible2(IOShomePgaeObject.confirmEmail())) 
			{
			ButtonVerifyClick(IOShomePgaeObject.nextButton());
				}
		}
		catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Clicked on Next on Confirm Email digital token ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Clicked on Next on Confirm Email digital token", e);
		}
	}
	public void verifyDigibankAlert() throws Exception
	{
		String alertMessage=null;
		try {
		if(androidAlert.isAlertPresent()) {
			System.out.println("Alert title :: "+ this.driver.switchTo().alert().getText()); 
			
			alertMessage=this.driver.switchTo().alert().getText();
				Asserts.assertFail(alertMessage);
		}
			}
			catch (Exception e) {		
				obj_handleexception.throwException("DIGIBANK_ALERT", " Failed to proceed because of DIGI BANK ALERT "+ alertMessage,e);
			}
	}

	@Step("Scroll To Billing Organisation ")
	public void scrollToBillingOrganisation() throws Exception {
		try {
			gestUtils.scrollUPIos();
			driver.findElementByName("Billing Organisations").click();
//				Dimension windowSize1 = driver.manage().window().getSize();
//				int y = (int) ((windowSize1.getHeight()) - 10);
//				int x = (int) ((windowSize1.getWidth()) / 2);
//				int y1 = getYCoordinateOfElement(IOShomePgaeObject.allTab()) + 30;
//				// gestUtils.swipeElementtoCoordinate(IOShomePgaeObject.swipeButton(), x1, y1);
//				String s1 = driver.getPageSource();
//
//				// gestUtils.swipeElementtoCoordinate(IOShomePgaeObject.swipeButton2(), x, y);
//				int o = 0;
//				int count = 0;
//
//			
//					int l = IOShomePgaeObject.allTabList2().size();
//					for (int i = 0; i < l; i++) {
//						if(isElementVisible2(IOShomePgaeObject.allTabList2().get(i))) {
//							
//						String tabText = IOShomePgaeObject.allTabList2().get(i).getText();
//						if (tabText.equalsIgnoreCase(Expected)) {
//							clickOnElement(IOShomePgaeObject.allTabList2().get(i));
//							o++;
//							break;
//						}
//					}
//					
//
//					else {
//						gestUtils.swipeCoordinatetoCoordinate(x, y, x, y1);
////						String s2 = driver.getPageSource();
////						if (s1.equals(s2) != true)
////							s1 = s2;
////						else
////							count = 1;
//					}
//				}
//			}
			
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Scroll To Billing Organisation  ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Scroll To Billing Organisation  ",e);
		}
	}
	
}

