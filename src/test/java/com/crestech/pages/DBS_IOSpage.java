package com.crestech.pages;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import com.crestech.annotation.values.ElementDescription;
import com.crestech.appium.utils.CommonAppiumTest;
import com.crestech.common.utilities.AndroidAlert;
import com.crestech.common.utilities.Asserts;
import com.crestech.common.utilities.CommonTestData;
import com.crestech.common.utilities.GestureUtils;
import com.crestech.common.utilities.HandleException;
import com.crestech.pageobjects.DBS_IOSObject;
import com.crestech.pages.iospage.ratingPage;
import com.crestech.pages.iospage.loginPage;
import com.crestech.pages.iospage.preloginPage;
import com.crestech.pages.iospage.launchPage;
import com.crestech.pages.iospage.paytransfer.payAndTransfer;
import com.crestech.pages.iospage.paytransfer.deletePayee;
import com.crestech.pages.iospage.paytransfer.overseasModule;
import com.crestech.pages.iospage.enterPasscode;
import com.crestech.pages.iospage.homePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class DBS_IOSpage extends CommonAppiumTest {

	static Logger log = Logger.getLogger(DBSAndroidPage.class.getName());
	public DBS_IOSObject IOShomePgaeObject = new DBS_IOSObject(driver);
	CommonAppiumTest commonAppTest = null;
	AndroidAlert androidAlert = null;
	GestureUtils gestUtils = null;
	public  TouchAction touch =null;
    HandleException obj_handleexception=null;
    homePage homepage = null;
    ratingPage ratingpage = null;
    enterPasscode enterpasscode = null;
    loginPage loginpage = null;
    preloginPage preloginpage = null;
    launchPage launchpage = null;
    payAndTransfer paytransfer = null;
    overseasModule overseasmodule = null;
    deletePayee deletepayee = null;

	public DBS_IOSpage(AppiumDriver<RemoteWebElement> driver) throws Exception {
		super(driver);
		gestUtils = new GestureUtils(driver);
		commonAppTest = new CommonAppiumTest(driver);
		androidAlert = new AndroidAlert(driver);
		touch = new TouchAction(this.driver);
		homepage = new homePage(driver); 
		ratingpage = new ratingPage(driver);
		enterpasscode = new enterPasscode(driver);
		obj_handleexception=new HandleException(null,null);
		loginpage = new loginPage(driver);
		preloginpage = new preloginPage(driver);
		launchpage = new launchPage(driver);
		paytransfer = new payAndTransfer(driver);
		overseasmodule = new overseasModule(driver);
		deletepayee = new deletePayee(driver);
		// PageFactory.initElements(new AppiumFieldDecorator(driver,
		// Duration.ofSeconds(5)), IOShomePgaeObject);
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
	
	
	

	@Step("Swiping down alert of upgarde experience")
	public void swipeUpgadeExperienceAlert() throws Exception {

		try {

			String actualMessage = getTexOfElement(IOShomePgaeObject.upgradeTitle());
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
	
	@Step("verify 'Text' Field")
	public void verifyTextOnScreen(String expectedText, MobileElement Element) throws Exception {
		try {
			
			String actualText = getTexOfElement(Element).trim();
			Asserts.assertEquals(actualText.toLowerCase(), expectedText.toLowerCase(), "text is not found");

		} 
		
		catch (Exception e) {		
			throw e;
			
			//obj_handleexception.throwException("TEXT_VERIFICATION_EXCEPTION", " Failed to Verify Acutal and Expected Text ",e);
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
	
	
	
	
	@Step("Application Logout")
	public void clickOnLogoutButton() throws Exception {
		try {
			clickOnElement(IOShomePgaeObject.logoutpeekbalance());
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Log out Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On log out Button ", e);
		}
	}


	@Step("Button Label Verify and Click")
	public void ButtonLabelVerifyClick(MobileElement Button, String expectecText) throws Exception {
		try {
			TakeScreenshot(Button);
			String actualText = getTexOfElement(Button);

			if (actualText.equalsIgnoreCase(expectecText))
				clickOnElement(Button);

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
			//Asserts.assertTrue(isElementEnable(Button), "button Not enable");
			//if (isElementEnable(Button))
			clickOnElement(Button);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}
	

	@Step("verify and click 'Topup' Field")
	public void topUpVerifyClick() throws Exception {
		try {
			wait.waitForElementToBeClickable(IOShomePgaeObject.topUpButton());
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
			wait.waitForElementToBeClickable(IOShomePgaeObject.payLahButton());
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
			verifyTextOnScreen(CommonTestData.TOPUP_PAYLAH_LABEL.getEnumValue(), IOShomePgaeObject.topUpPayLahTitle());

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("verify 'SGD' Field")
	public void sgdCurrencyVerify() throws Exception {
		try {
			verifyTextOnScreen(CommonTestData.SGD_CURRENCY_LABEL.getEnumValue(), IOShomePgaeObject.sgdCurrency());

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("Enter currency in EditBox")
	public void sendCurrencyInTextField(String text) throws HandleException {
		try {
			wait.fluentWaitForElement(IOShomePgaeObject.sgdCurrency());
			enterTextInTextbox(IOShomePgaeObject.amountEditBox(), text);
			if(isElementVisible2(IOShomePgaeObject.doneButton()))
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
			verifyTextOnScreen(expectedText, IOShomePgaeObject.amountEditBox());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step("Verify 'Top Up Paylah Label' field")
	public void verifyReviewTopUpLabel(String expectedText) throws HandleException {
		try {

			verifyTextOnScreen(expectedText, IOShomePgaeObject.reviewToUpLabel());

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
			
				clickOnElement(IOShomePgaeObject.nextButton());
			
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Next Button ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Next Button ",e);
		}
	}

	@Step("Next click")
	public void ClickOnNextButton4() throws Exception {
		try {
			ButtonVerifyClick(IOShomePgaeObject.nextButton4());
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
			verifyTextOnScreen(expectedText, IOShomePgaeObject.topupDoneButton());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Step("Verifying Logout Label and click")
	public void logOutTopUpVerifyClick() throws Exception {
		try {

			String actualText = getTexOfElement(IOShomePgaeObject.logoutPaylah());
			String expectecText = CommonTestData.LOGOT_PAYLAH_IOS.getEnumValue();
			if (actualText.equalsIgnoreCase(expectecText))
				clickOnElement(IOShomePgaeObject.logoutPaylah());

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

			String actualText = getTexOfElement(IOShomePgaeObject.doneButton());
			String expectecText = CommonTestData.DONE_2FA_IOS.getEnumValue();
			if (actualText.equalsIgnoreCase(expectecText))
				clickOnElement(IOShomePgaeObject.doneButton());

			Asserts.assertEquals(actualText, expectecText, "Done button Not exist");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@Step("2FA VERIFICATION")
	public void handling2faVerification(String titleText) throws Exception {
		try {

			verifyTextOnScreen(titleText, IOShomePgaeObject.title2FA());
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

	@Step("Pre - requisite script")
	public void preRequisiteScript(String userName, String password, String app_Name, String serverName) throws Exception {
		try {
			this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			launchpage.atmLocationAlert();
			launchpage.sendNotificationAlert();
			launchpage.localNetworkAlert();
			launchpage.ClickOnPreloginButton();
			preloginpage.selectUATserver(serverName); 
			preloginpage.clickOnLoginButton();
//			ClickOnNOTYouLink();
//		    ClickOnDeregisterButtonInDigiAlertPopup(CommonTestData.PEEK_BALANCE_DEREGISTER_MESSAGE.getEnumValue());
			loginpage.EnterCredentialsAndLogin(userName,password);
			homepage.digitalToken();
			//homepage.handlingMotionAndFitnessAlert();
			homepage.locationSwipPopup(app_Name);
			homepage.HandlingWelcomeToDigibankForWealthManagement(app_Name);
			homepage.handlingFingurePrintAlert();
			homepage.handlingRecordingAlert();
			
			this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Exceute pre-Requisite Script ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Exceute pre-RequisiteScript ", e);
		}
	}
	 //android.widget.TextView[@resource-id='com.dbs.sit1.dbsmbanking:id/tv_label1']
	@Step("Log In the Application")
	public void LogInApplication(String userName, String password) throws Exception {
		try {
			preloginpage.clickOnLoginButton();
			loginpage.EnterCredentialsAndLogin(userName, password); 
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Exceute Log In Application ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Exceute Log In Application ", e);
		}
	}

	@Step("Logout the application")
	public void VerifyLogout(String app_Name) throws Exception { 
		try {
			homepage.VerifyWelcomeMessagesOnDashboardPage(CommonTestData.WELCOME.getEnumValue(),
					CommonTestData.DIGIBANK.getEnumValue(), CommonTestData.DBS_DIGIBANK.getEnumValue(), app_Name);
			homepage.ClickOnLogOutButton();
			ratingpage.verifyTapOnTheStarsToRate(CommonTestData.RATE_MESSAGE.getEnumValue());
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
			else	
				Asserts.assertFail(valueSelectedFromList + " not found in the list as list size is 0");
			
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select Data From Dropdown.  ",e);			
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select Data From Dropdown.  ",e);
		}
	}
	
	
	@Step("Enter the text in search and select the corresponding value in the dropdown")
	public void sendDataInCommonSearchBoxAndSelectFromDropDown1(String searchBoxData, String valueSelectedFromList, String valueSelectedFromList2)
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
				}else if (Text.equalsIgnoreCase(valueSelectedFromList2)) { 
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
			TakeScreenshot(IOShomePgaeObject.moreButton());
			androidAlert.AlertHandlingWithButtonMessage(IOShomePgaeObject.moreButton(),
					CommonTestData.MORE_LABEL.getEnumValue(), IOShomePgaeObject.moreButton());
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
			verifyTextOnScreen(expectedText, IOShomePgaeObject.localTransferLimitLabel());
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
			verifyTextOnScreen(expectedText, IOShomePgaeObject.ToOtherBankLimitTitle());

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
				//selectedValue = selectAmountFromSetCurrentLimitList(AmountToBeselected);
				selectedValue = selectAmountFromSetCurrentLimitList2(AmountToBeselected);
			} else {
				gestUtils.scrollDOWNtoObject("text", CommonTestData.SELECTED_LIMIT_0.getEnumValue(), null);
				String flag = selectAmountFromSetCurrentLimitList(CommonTestData.SELECTED_LIMIT_0.getEnumValue());
				currentText = getTexOfElement(IOShomePgaeObject.currentLimitTextButton());
				verifyClickSetCurrentLimit();
				arrOfStr = currentText.split(" ");
				if (arrOfStr[1].equalsIgnoreCase(CommonTestData.SELECTED_LIMIT_0.getEnumValue()))
					//selectedValue = selectAmountFromSetCurrentLimitList(AmountToBeselected);
					selectedValue = selectAmountFromSetCurrentLimitList2(AmountToBeselected);
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
			verifyTextOnScreen(expectedText, IOShomePgaeObject.setDailyLimitTitle());

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
			//TakeScreenshot(ElementCell.get(0));
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
	@Step("Select amount from the List of 'set current Limit' ")
	public String selectAmountFromSetCurrentLimitList2(String amount) throws Exception {
		try {

			String selectedAmount = null;
			List<RemoteWebElement> ElementCell = driver.findElementsByXPath("//XCUIElementTypeCell/XCUIElementTypeStaticText");
			//TakeScreenshot(ElementCell.get(0));
			int sizeList = ElementCell.size();
			int index = 0;
			for (int i = 0; i < sizeList; i++) {

				
				String Text = ElementCell.get(i).getText();
				System.out.println(Text);
				if (Text.equalsIgnoreCase(amount)) {
					selectedAmount = Text;
					index++;
					ElementCell.get(i).click();
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
			verifyTextOnScreen(expectedText, IOShomePgaeObject.reviewDailyLimitTitle());
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
			paytransfer.ClickOnPayAndTransferButton();
			enterpasscode.EnterPasscodeAndDone();
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
			enterpasscode.EnterPasscodeAndDone();
			sendDataInCommonSearchBoxAndSelectFromDropDown(
					CommonTestData.LOCAL_TRANSFER_LIMIT_SEARCHBOX_IOS.getEnumValue(),
					CommonTestData.LOCAL_TRANSFER_LIMIT_LABEL.getEnumValue());
			verifyLocalTransferLimitTitle();
			toOtherBanksVerifyClick();
			enterpasscode.EnterPasscodeAndDone();
			String amountSlected = handlingSetCurrentLimit(CommonTestData.SELECTED_LIMIT_50000.getEnumValue());
			ClickOnNextButton();
			verifyReviewDailyLimitTitle();
			verifyClickChangeDailyLimitNowButton();
			enterpasscode.EnterPasscode();
			verifyLocalTransferlimitChangedHeader(CommonTestData.LOCAL_LIMIT_INCREASE_SUCCESS_TITLE_IOS.getEnumValue());
			ClickOnBackToMoreButton();
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
	public void ClickOnBackToMoreButton() throws Exception {
		try {
				clickOnElement(IOShomePgaeObject.backToMoreButton());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Step("click 'BACK TO MORE' BUTTON ")
	public void ClickOnBackToMoreServicesButton(String appName) throws Exception {
		try {
			if (appName.equalsIgnoreCase("iWEALTH")) {
				clickOnElement(IOShomePgaeObject.backToMoreButton());
			} else if (appName.equalsIgnoreCase("DBS")) {
				clickOnElement(IOShomePgaeObject.BackToMoreServicesButton());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Step("Verify 'Local Transfer limit Changed' field")
	public void verifyLocalTransferlimitChangedHeader(String expectedText) throws Exception {
		try {
			//TakeScreenshot(IOShomePgaeObject.localTransferLimitChangedTitle());
			verifyTextOnScreen(expectedText, IOShomePgaeObject.localTransferLimitChangedTitle());

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
			paytransfer.ClickOnPayAndTransferButton();
			enterpasscode.EnterPasscodeAndDone();
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
			enterpasscode.EnterPasscode();
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
			paytransfer.ClickOnPayAndTransferButton();
			enterpasscode.EnterPasscodeAndDone();
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
			wait.waitForElementToBeClickable(IOShomePgaeObject.LocalButton());
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
			paytransfer.ClickOnPayAndTransferButton();
			enterpasscode.EnterPasscodeAndDone();
			clickOnLocalButton();
			clickOnAddLocalRecipientBtnAndVerifyLocalTransferPayNowPageHeader();

			String ExpectedRecipientName = CommonTestData.LOCAL_RECIPIENT_NAME.getEnumValue();
			String ExpectedAccountNumber = CommonTestData.LOCAL_RECIPIENT_ACCOUNT_NUMBER.getEnumValue();

			EnterRecipientDetailsAfterSelectingBankAccountOption(ExpectedRecipientName,
					CommonTestData.LOCAL_RECIPIENT_BANK_NAME.getEnumValue(), ExpectedAccountNumber);
			overseasmodule.ClickOnNEXTButton();
			List<RemoteWebElement> reviewRecipientDetailsPageHeader = driver.findElements(By.name("Review Recipient's Details"));
			Asserts.assertTrue(isElementVisible2((MobileElement) reviewRecipientDetailsPageHeader.get(reviewRecipientDetailsPageHeader.size()-1)),
					CommonTestData.REVIEW_RECIPIENT_DETAILS.getEnumValue() + " Page Header not displaying.");
			ClickOnAddRecipientNowBtn();
			enterpasscode.EnterPasscode();
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
			paytransfer.ClickOnPayAndTransferButton();
			enterpasscode.EnterPasscodeAndDone();
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
			//TakeScreenshot(IOShomePgaeObject.closeButton()); 
			if(isElementVisible2(IOShomePgaeObject.closeButton()))
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
			if(IOShomePgaeObject.localRecipientsList().size() > 0) {
				int ExpectedTotalPayeeSize = IOShomePgaeObject.localRecipientsList().size();
				int ExpectedTotalPayee = IOShomePgaeObject.IiconList().size();
				for (int i = 0; i < ExpectedTotalPayeeSize; i++) {
					if(isElementVisible2(IOShomePgaeObject.localRecipientsList().get(i))) {
						String actualPayee = IOShomePgaeObject.localRecipientsList().get(i).getText();
						if(actualPayee.contains(ExpectedPayee) ) {
							int index=i/2;
							ClickOnDeletePayeeToIcon(index);
							ClickOnMoreOptionBtn();
							ClickOnDeletePayeeBtn();
							ClickOnYesBtn();

							//HandlingErrorPopupInDeletePayee();
							
						
							ClickOnOkButtonAfterVerifyingPayeeDeletedMsg(ExpectedPayee);
							VerifyPayeeSizeAfterDeletePayee(ExpectedTotalPayee);
								break;
							}
						} 
					}
			}
					else {
						Dimension windowSize1 = driver.manage().window().getSize();
						int y =(int)((windowSize1.getHeight())-10);
						int x =(int)((windowSize1.getWidth())/2);
						gesture.swipeCoordinatetoCoordinate(x,20,x,y);
					}
				
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Delete Payee ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Delete Payee ",e);
		}
	}
	
	
	@Step("Verify Payee Size After Delete Payee.")
	public void VerifyPayeeSizeAfterDeletePayee(int ExpectedTotalPayee) throws Exception {
		try {
			int ActualTotalPayeeSize = IOShomePgaeObject.IiconList().size();
			int ExpectedTotalSizeAfterDeletingPayee = ExpectedTotalPayee - 1;
			Asserts.assertEquals(String.valueOf(ActualTotalPayeeSize) ,String.valueOf(ExpectedTotalSizeAfterDeletingPayee),
					" Payee size is not matching after performing delete operation.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify Payee Size after Delete Payee.  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify Payee Size after Delete Payee.  ", e);
		}
	}

	
		@Step("Click On OK Button after verifying 'Payee Name deleted' message.")
		public void ClickOnOkButtonAfterVerifyingPayeeDeletedMsg(String ExpectedPayee) throws Exception {
			try {
				wait.waitForElementVisibility(IOShomePgaeObject.OKButton()); 
				String message = ExpectedPayee + " Deleted";
				String DeletePayeeMessageXPath = "//XCUIElementTypeStaticText[@name='" + message + "']";
				MobileElement DeletePayeeMessageElement = (MobileElement) driver
						.findElement(By.xpath(DeletePayeeMessageXPath));
				
				if (isElementVisible2(DeletePayeeMessageElement))
					ClickOnOKButton();

			} catch (HandleException e) {
				obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
						" Failed to Click On OK Button ", e);
			} catch (Exception e) {
				obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On OK Button",
						e);
			}
		}

		@Step("Click On OK Button.")
		public void ClickOnOKButton() throws Exception {
			try {
				clickOnElement(IOShomePgaeObject.OKButton());
			} catch (HandleException e) {
				obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On OK Button  ", e);
			} catch (Exception e) {
				obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On OK Button   ", e);
			}
		}
		public void HandlingErrorPopupInDeletePayee() throws Exception {
			try {
				for (int innerLoop = 0; innerLoop < 2; innerLoop++) {
					String ErrorissueXpath = "//XCUIElementTypeStaticText[@name='You may be facing some delays and we are trying to sort it out now. Sorry for the inconvenience. Do check back later.']";
					List<RemoteWebElement> list = driver.findElements(By.xpath(ErrorissueXpath));
					if (list.size() > 0) {
						TakeScreenshot(IOShomePgaeObject.alertOkButton());
						clickOnElement(IOShomePgaeObject.alertOkButton());
						ClickOnMoreOptionBtn();
						ClickOnDeletePayeeBtn();
						ClickOnYesBtn();
					
					}
				}
			} catch (HandleException e) {
				obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
						" Failed to Handle Error Popup in delete payee.  ", e);
			} catch (Exception e) {
				obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
						" Failed to Handle Error Popup in delete payee.  ", e);
			}
		}
		@Step("Click On i Icon from the list.")
		public void ClickOnDeletePayeeToIcon(int index) throws Exception {
			try {
				clickOnElement(IOShomePgaeObject.IiconList().get(index));
			} catch (HandleException e) {
				obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Icon(i)  ", e);

			} catch (Exception e) {

				obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Icon(i)  ", e);
			}
		}
		
		@Step("Click On 'More Options' Button.")
		public void ClickOnMoreOptionBtn() throws Exception {
			try {
				wait.fluentWaitForElement(IOShomePgaeObject.MorePayeeDetailDots());
				wait.waitForElementToBeClickable(IOShomePgaeObject.MorePayeeDetailDots()); 
				clickOnElement(IOShomePgaeObject.MorePayeeDetailDots());
			} catch (HandleException e) {
				obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
						" Failed to Click On More Options Button  ", e);
			} catch (Exception e) {
				obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On More Options Button  ", e);
			}
		}
		@Step("Click On 'Delete payee' Button.")
		public void ClickOnDeletePayeeBtn() throws Exception {
			try {
				clickOnElement(IOShomePgaeObject.DeletePayeeButton());
			} catch (HandleException e) {
				obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
						" Failed to Click On Delete Payee Button  ", e);
			} catch (Exception e) {
				obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click on Delete Payee Button  ", e);
			}
		}
		@Step("Click On Yes Button after verifying 'Are you sure to delete payee' message.")
		public void ClickOnYesBtn() throws Exception {
			try {
				if (isElementVisible(IOShomePgaeObject.AreYouSureToDeleteThisPayeeMsg()))
					clickOnElement(IOShomePgaeObject.YesButton());
			} catch (HandleException e) {
				obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Yes Button  ", e);
			} catch (Exception e) {
				obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Yes Button   ", e);
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
			wait.fluentWaitForElement(IOShomePgaeObject.logoutPaylah());
			///TakeScreenshot(IOShomePgaeObject.SuccessImage().get(3));
			List<RemoteWebElement> youHaveAddedRecipient = driver.findElements(By.name("You've added a recipient"));
			int l=youHaveAddedRecipient.size();
			//if (isElementVisible(IOShomePgaeObject.SuccessImage().get(3)))
				Asserts.assertEquals(getTexOfElement((MobileElement) youHaveAddedRecipient.get(youHaveAddedRecipient.size()-1)),
						CommonTestData.YOU_HAVE_ADDED_RECIPIENT_MSG2.getEnumValue(),
						CommonTestData.YOU_HAVE_ADDED_RECIPIENT_MSG2.getEnumValue() + " Text is not matching");
//			MobileElement youHaveAddedRecipient = (MobileElement) driver.findElements(By.name("You've added a recipient"));
//			Asserts.assertTrue(youHaveAddedRecipient.isDisplayed(), "'You've added a recipient' is not display");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verify 'You Have Added Recipient Msg' After Entering Secure PIN. ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify 'You Have Added Recipient Msg' After Entering Secure PIN. ", e);
		}
	}

	@Step("Verify Payee Add Remittance.")
	public void PayeeAddRemittance() throws Exception {
		try {
			paytransfer.ClickOnPayAndTransferButton();
			enterpasscode.EnterPasscodeAndDone();
			paytransfer.ClickOnOverseasModule();
			overseasmodule.SelectAddRecipientNowButtonUnderOverseas();
			overseasmodule.SelectCountry(CommonTestData.COUNTRY_AUS_SEARCH.getEnumValue(), CommonTestData.COUNTRY_AUS.getEnumValue());
			overseasmodule.SelectCurrencyType(CommonTestData.CURRENCY_AUS.getEnumValue());
			overseasmodule.ClickOnNEXTButton();
			overseasmodule.EnterBankCode(CommonTestData.BANK_BCD_CODE.getEnumValue());
			overseasmodule.ClickOnNextButton();
			overseasmodule.verifyEnterRecipientDetailsPageHeader(CommonTestData.ENTER_RECIPIENT_DETAIL.getEnumValue());
			overseasmodule.EnterAccountNumber(CommonTestData.ACCOUNT_NO.getEnumValue());
			overseasmodule.EnterFullName(CommonTestData.FULL_NAME.getEnumValue());
			gestUtils.scrollUPtoObjectIos("name", "NEXT", null);
			overseasmodule.EnterAddress(CommonTestData.ADDRESS_SHORT.getEnumValue());
			overseasmodule.EnterCity(CommonTestData.CITY.getEnumValue());
			overseasmodule.ClickOnNextButton();
			overseasmodule.verifyReviewRecipientDetailsPageHeader(CommonTestData.REVIEW_RECIPIENT_LABEL.getEnumValue());
			overseasmodule.ClickOnAddRecipientNowBtn();
			enterpasscode.EnterPasscode();
			overseasmodule.verifyYouHaveAddedMessage(CommonTestData.YOU_HAVE_ADDED_RECIPIENT_MSG2.getEnumValue());
			overseasmodule.verifyReferenceFieldAndItsValue(CommonTestData.REFERENCE_NUMBER.getEnumValue());
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
			paytransfer.ClickOnPayAndTransferButton();
			enterpasscode.EnterPasscodeAndDone();
			paytransfer.ClickOnOverseasModule();
			deletepayee.DeletePayeeForRemittence(CommonTestData.FULL_NAME.getEnumValue());
			
			// Leave On Home Page to this test case for next run.
			overseasmodule.ClickOnCloseButtonInOversea();
			overseasmodule.ClickOnHomeButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Delete Payee to DBS/POSB ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Delete Payee to DBS/POSB ", e);
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



	@ElementDescription(value = "Done button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Done']")
	private MobileElement doneButton;
	
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

	
	@Step("Verify Fund Transfer Pay Credit Card.")
	public void FundsTransfer_PayCreditCard() throws Exception {
		try {
			paytransfer.ClickOnPayAndTransferButton();
			enterpasscode.EnterPasscodeAndDone();
			paytransfer.SelectAllTAB();
			String ExpectedToBankNameWithAccountNo = CommonTestData.FUNDTRANSFER_CREDITCARD_TO_ACCOUNTNUMBER_WITHBANK
					.getEnumValue();
			clickingOnAccountTypeInCreditCard(ExpectedToBankNameWithAccountNo);
			
			EnterAmount(IOShomePgaeObject.AmountEditableField(), CommonTestData.AMOUNTTO_TRANSFERFUND.getEnumValue());

			String ExpectedFromBankName = CommonTestData.FUNDTRANSFER_CREDITCARD_FROM_ACCOUNT_NAME.getEnumValue();
			SelectFundSourceAccount(ExpectedFromBankName);

			String ExpectedSelectedDate = getTexOfElement(IOShomePgaeObject.TransferDateTextElement());
			Asserts.assertEquals("Immediate", ExpectedSelectedDate, "Selected Date is not Matching");
			
			//ClickOnNextButton();
			overseasmodule.ClickOnNEXTButton();
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
			
			List<RemoteWebElement> list = driver.findElements(By.xpath(xpath));
			if (list.size() > 0) {
				
				gestUtils.scrollDownIos();
				
				clickOnElement(IOShomePgaeObject.SelectFundSourcePage());
				
				int index=0;
				for (int i = 0; i < IOShomePgaeObject.localRecipientsList().size(); i++) {
					String actualfromOwnAccount = IOShomePgaeObject.localRecipientsList().get(i).getText();
					if (actualfromOwnAccount.contains(fromOwnAccount)) {
						clickOnElement(IOShomePgaeObject.localRecipientsList().get(i));
						index++;
						break;
					}
				}
				if(index==0)
				Asserts.assertFail("No Account " +fromOwnAccount+" not found in the list to initiate the fund transfer");
				overseasmodule.handlingOfPrimarySourceOfFundPopup();
			}
			else
				Asserts.assertFail("No Account found in the list");
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
			enterpasscode.EnterPasscodeAndDone();
			ClickOnTransactionHistory();
			SelectTimeAndAccountTypeForStatement(CommonTestData.ACCOUNT_NAME.getEnumValue(),CommonTestData.CURRENCY_NAME.getEnumValue());
			gestUtils.scrollUPIos();
			//gestUtils.scrollUPtoObjectIos("name", "SHOW", null);
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
			enterpasscode.EnterPasscodeAndDone();
			verifyTextOnScreen(CommonTestData.TRANSCETION_HISTORY_LABEL.getEnumValue(), IOShomePgaeObject.transactionHistoryBtnLabel());
				
			
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
			
			verifyTextOnScreen(CommonTestData.TRANSCETION_HISTORY_LABEL.getEnumValue(), IOShomePgaeObject.transactionHistoryBtnLabel());
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
			enterpasscode.EnterPasscode();
			String actual=IOShomePgaeObject.transactionHistoryfinalheaderTitle().getText();
			if(actual.toLowerCase().contains(ExpectedAccountName.toLowerCase())) {
				String[] arrOfStr = ExpectedAccountName.split(" ");
			}
			else
				verifyTextOnScreen(ExpectedAccountName, IOShomePgaeObject.transactionHistoryfinalheaderTitle());
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
			verifyTextOnScreen(CommonTestData.TRANSCETION_HISTORY_LABEL.getEnumValue(), IOShomePgaeObject.transactionHistoryBtnLabel());
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
			paytransfer.ClickOnPayAndTransferButton();
			enterpasscode.EnterPasscodeAndDone();
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
			gestUtils.DragAndDropElementToElement(IOShomePgaeObject.allTabList().get(1), IOShomePgaeObject.AllTab());
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
					overseasmodule.handlingOfPrimarySourceOfFundPopup();

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
			clickOnElement(IOShomePgaeObject.selectfundSource());
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
			verifyTextOnScreen(CommonTestData.SGD_CURRENCY_LABEL.getEnumValue(), IOShomePgaeObject.sgdText());
			enterTextInTextbox(IOShomePgaeObject.amountField(), Amount);
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			doneButtonIfAviliable();
			overseasmodule.ClickOnNEXTButton();
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
			verifyTextOnScreen(CommonTestData.REVIEW_TRANSFER_LABEL.getEnumValue(), IOShomePgaeObject.reviewTransfer());
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
			verifyTextOnScreen(CommonTestData.TRANSFER_TITLE.getEnumValue(), IOShomePgaeObject.transferredTitle());
			ButtonVerifyClick(IOShomePgaeObject.expandButton2());
			gestUtils.scrollUPtoObjectIos("name", "Reference No.", null);
			verifyTextOnScreen(CommonTestData.REFERENCE_NUMBER.getEnumValue(), IOShomePgaeObject.referenceNo());
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
	@Step("verify Account Details On Home Page")
	public void VerifyAccountDetailsCasaOnHomePage() throws Exception {
		try {
			homepage.verifyAccountTypeNameCurrencyAmount(CommonTestData.ACCOUNT_TYPE.getEnumValue(),
					CommonTestData.ACCOUNT_NAME_HOME.getEnumValue(), CommonTestData.CURRENCY.getEnumValue());
		}
			catch (HandleException e) {	
				obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Verify the account detail on dashboard page  ",e);			
			}
			catch (Exception e) {			
				obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Verify the account detail on dashboard page  ",e);
			}
	}
	
	@Step("Verifies Remittance Corridor")
	public void VerifyRemittanceCorridor(Object appName) throws Exception {
		try {
			paytransfer.ClickOnPayAndTransferButton();
			enterpasscode.EnterPasscodeAndDone();
			paytransfer.ClickOnOverseasModule();
			overseasmodule.SelectOverseaPayee(CommonTestData.PAYEE_NAME_CORRIDOR.getEnumValue());
			if (appName.equals("DBS"))
				overseasmodule.SelectSourceOfFund(CommonTestData.SOURCE_ACCOUNT_NAME_CORRIDOR.getEnumValue());
			else if (appName.equals("iWEALTH"))
				overseasmodule.SelectSourceOfFund(CommonTestData.SOURCE_ACCOUNT_NAME_CORRIDOR_IWEALTH.getEnumValue());
			
			overseasmodule.pressEnterKeyAfterEnteringAmount(CommonTestData.CORRIDOR_AMOUNT.getEnumValue());
			
			overseasmodule.SelectAdditionalDetails(CommonTestData.EOTT_ACCOUNT_TYPE.getEnumValue(),CommonTestData.PURPOSE.getEnumValue(), CommonTestData.MOBILE_NUMBER.getEnumValue());
			overseasmodule.ClickOnNextButton();
			overseasmodule.verifyReviewTransferPageHeader(CommonTestData.REVIEW_TRANSFER.getEnumValue());
			overseasmodule.ClickOnTransferNowButton();
			overseasmodule.VerifiesTransferSubmittedMessage(CommonTestData.TRANSFER_SUBMITTED_MSG.getEnumValue());
	
			overseasmodule.ClickOnImageExpandBtnAndVerifiesReferenceNumberText();
			overseasmodule.ClickOnShareTransferDetailsButton();
			overseasmodule.BackToHomeFromTestCase();
		}catch (HandleException e) {	
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Execute Remittance Corridor  ",e);			
		}
		catch (Exception e) {			
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Execute Remittance Corridor  ",e);
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
	
	@Step("Click On Transfer Now Button And Verify You've added a recipient Message.")
	public void ClickOnTransferNowBtnAndVerifyYouHaveAddedRecipientMsg() throws Exception {
		try {
//			TakeScreenshot(IOShomePgaeObject.TransferNowButton());
//			clickOnElement(IOShomePgaeObject.TransferNowButton());
//			clickOnTransferNowButton();
			clickOnElement(IOShomePgaeObject.TRANSFERNOWButton());
			// verifies the payment completion with expected amount.
			//TakeScreenshot(IOShomePgaeObject.SuccessImage().get(3));
		//	if (isElementVisible(IOShomePgaeObject.SuccessImage().get(3))) {
//				Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.PaymentSubmittedMsg()),
//						CommonTestData.PAYMENT_SUBMITTED.getEnumValue(),
//						CommonTestData.PAYMENT_SUBMITTED.getEnumValue() + " Text is not matching");
			List<RemoteWebElement> reviewRecipientDetailsPageHeader = driver.findElements(By.name("You've added a recipient"));
			Asserts.assertTrue(isElementVisible2((MobileElement) reviewRecipientDetailsPageHeader.get(reviewRecipientDetailsPageHeader.size()-1)),
					CommonTestData.YOU_HAVE_ADDED_RECIPIENT_MSG2.getEnumValue() + " Page Header not displaying.");
//				Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.AmountEditableField()),
//						CommonTestData.AMOUNTTO_TRANSFERFUND.getEnumValue() + ".00",
//						CommonTestData.AMOUNTTO_TRANSFERFUND.getEnumValue() + " Text is not matching.");
			//}
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Transfer Now Button And Verify You've added a recipient Message ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Transfer Now Button And Verify You've added a recipient Message ",e);
		}
	}
	
	@Step("Verifies the 'Log out', 'Make Another Transfer' Button, 'Share Payment Details' Button.")
	public void VerifyVisibiltyOfSomeElements_FundTransferCreditCard() throws Exception {
		try {
			Asserts.assertTrue(IOShomePgaeObject.logoutPaylah().isDisplayed(), "Log Out Button not found.");
			//add scroll
			gestUtils.scrollUPtoObjectIos("name", "MAKE ANOTHER TRANSFER", null);
			Asserts.assertTrue(IOShomePgaeObject.MakeAnotherPaymentBtn2().isDisplayed(),
					"Make Another Transfer Button not found.");
			Asserts.assertTrue(IOShomePgaeObject.SharePaymentDetailsButton2().isDisplayed(),
					"'Share Payment Details' Button not found.");
			
			//Asserts.assertTrue(IOShomePgaeObject.closeButton().isDisplayed(),
					//"'Close' Button not found.");
			
			clickOnElement(IOShomePgaeObject.FooterExpandableBtn());
			
			gestUtils.scrollUPtoObjectIos("name", "Reference No.", null);
			verifyTextOnScreen(CommonTestData.REFERENCE_NUMBER.getEnumValue(), IOShomePgaeObject.referenceNo());
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
								if (LocalRecipientList.contains(valueSelectedFromList)) {
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
								if (LocalRecipientList.contains(valueSelectedFromList) && isElementVisible2(Elementlist.get(i))) {
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
				overseasmodule.handlingOfPrimarySourceOfFundPopup();
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
		
	@Step("Verifies Remittance eOTT")
	public void VerifyRemittanceEOTT(String appName) throws Exception {
		try {
			paytransfer.ClickOnPayAndTransferButton();
			enterpasscode.EnterPasscodeAndDone();
			paytransfer.SelectAllTAB();
			overseasmodule.SelectEOTT();
			if (appName.equals("DBS"))
				overseasmodule.SelectSourceOfFund(CommonTestData.SOURCE_ACCOUNT_NAME_CORRIDOR.getEnumValue());
			else if (appName.equals("iWEALTH"))
				overseasmodule.SelectSourceOfFund(CommonTestData.SOURCE_ACCOUNT_NAME_CORRIDOR_IWEALTH.getEnumValue());
			overseasmodule.pressEnterKeyAfterEnteringAmount(CommonTestData.eOTT_AMOUNT.getEnumValue());
			overseasmodule.SelectAdditionalDetails(CommonTestData.EOTT_ACCOUNT_TYPE.getEnumValue(),
					CommonTestData.PURPOSE.getEnumValue(), CommonTestData.MOBILE_NUMBER.getEnumValue());
			overseasmodule.ClickOnNextButton();
			overseasmodule.verifyReviewTransferPageHeader(CommonTestData.REVIEW_TRANSFER.getEnumValue());
			overseasmodule.ClickOnTransferNowButton();
			overseasmodule.VerifiesTransferSubmittedMessage(CommonTestData.TRANSFER_SUBMITTED_MSG.getEnumValue());
			overseasmodule.ClickOnImageExpandBtnAndVerifiesReferenceNumberText();
			overseasmodule.ClickOnShareTransferDetailsButton();
			overseasmodule.BackToHomeFromTestCase();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Execute Remittance EOTT  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Execute Remittance EOTT  ", e);
		}
	}

		@Step("Verify CreditCard Temperary Limit Increase")
		public void CreditCardTempLimitIncrease() throws Exception {
			try {
				ClickOnMoreButton();
				enterpasscode.EnterPasscodeAndDone();
				sendDataInCommonSearchBoxAndSelectFromDropDown(CommonTestData.TEMP_LIMIT_INCREASE_SEARCH.getEnumValue(), CommonTestData.TEMP_LIMIT_INCREASE.getEnumValue());
				enterpasscode.EnterPasscodeAndDone();
				verifyTextOnScreen(CommonTestData.TEMP_LIMIT_INCREASE_TITLE.getEnumValue(), IOShomePgaeObject.temporaryLimitIncreaseHeader());
				setAmountDurationPurposeForLimitIncrease("100", "wedding");
				gestUtils.scrollUPtoObjectIos("name", "NEXT", null );
				overseasmodule.ClickOnNEXTButton();
				//ClickOnNextButton();
				verifyTextOnScreen(CommonTestData.REVIEW_APPLICATION_CREDITLIMIT_TITLE.getEnumValue(),IOShomePgaeObject.reviewApplicationHeader());
				 
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
				verifyTextOnScreen(CommonTestData.TEMP_LIMIT_INCREASE_TITLE.getEnumValue(), IOShomePgaeObject.temporaryLimitIncreaseHeader());
				ButtonVerifyClick( IOShomePgaeObject.purposeCreditLimit());
				verifyTextOnScreen(CommonTestData.PURPOSE_HEADER_IOS.getEnumValue(), IOShomePgaeObject.selectPurpose());
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
				verifyTextOnScreen(CommonTestData.TEMP_LIMIT_INCREASE_TITLE.getEnumValue(), IOShomePgaeObject.temporaryLimitIncreaseHeader());
				ButtonVerifyClick( IOShomePgaeObject.durationCreditLimit());
				verifyTextOnScreen(CommonTestData.CALENDER_HEADER.getEnumValue(), IOShomePgaeObject.calenderTemporaryLimitIncreaseHeader());
				ButtonVerifyClick( IOShomePgaeObject.calenderDateOctEleven());
				ButtonVerifyClick( IOShomePgaeObject.confirmButton());
				verifyTextOnScreen(CommonTestData.TEMP_LIMIT_INCREASE_TITLE.getEnumValue(), IOShomePgaeObject.temporaryLimitIncreaseHeader());
				
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
				overseasmodule.handlingOfPrimarySourceOfFundPopup();
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
			paytransfer.ClickOnPayAndTransferButton();
			enterpasscode.EnterPasscodeAndDone();
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
			enterpasscode.EnterPasscode();
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
			paytransfer.ClickOnPayAndTransferButton();
			enterpasscode.EnterPasscodeAndDone();
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

//			String xpath = "//android.widget.Button[@text='ADD RECIPIENT NOW']";
//			List<RemoteWebElement> list = driver.findElements(By.xpath(xpath));
//			if (list.size() > 0) {
			if(isElementVisible2(IOShomePgaeObject.AddRecipientNowButton())) 
			{
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
			paytransfer.ClickOnPayAndTransferButton();
			enterpasscode.EnterPasscodeAndDone();
			paytransfer.SelectAllTAB();
			SelectOWNAccountAndAnyAccountOption(CommonTestData.FUNDTRANSFER_TO_OWN_ACCOUNT_NUMBER.getEnumValue());
			String ExpectedFromAccountName = CommonTestData.FUNDTRANSFER_FROM_OWN_ACCOUNT_NAME.getEnumValue();
			SelectFundSourceAccount(ExpectedFromAccountName);
			
			EnterAmount(IOShomePgaeObject.AmountEditableField(), CommonTestData.AMOUNTTO_TRANSFERFUND.getEnumValue());
			//ClickOnNextButton();
			overseasmodule.ClickOnNEXTButton();
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
			wait.waitForElementVisibility(IOShomePgaeObject.SelectOwnAccount());
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
				overseasmodule.handlingOfPrimarySourceOfFundPopup();
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
			paytransfer.ClickOnPayAndTransferButton();
			enterpasscode.EnterPasscodeAndDone();
			paytransfer.SelectAllTAB();
			String ExpectedToBankNameWithAccountNo = CommonTestData.FUNDTRANSFER_BillPayment_TO_ACCOUNTNUMBER_WITHBANK
					.getEnumValue();
			scrollToBillingOrganisation();
			clickingOnAccountTypeInBillingOrganisations(ExpectedToBankNameWithAccountNo);
			EnterAmount(IOShomePgaeObject.AmountEditableField(), CommonTestData.AMOUNTTO_TRANSFERFUND.getEnumValue());
			String ExpectedSelectedDate = getTexOfElement(IOShomePgaeObject.TransferDateTextElement());
			Asserts.assertEquals("Immediate", ExpectedSelectedDate, "Selected Date is not Matching");

			//ClickOnNextButton();
			overseasmodule.ClickOnNEXTButton();
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
							if (LocalRecipientList.contains(valueSelectedFromList)) {
								index++;
								
								clickOnElement(Elementlist.get(i));
								break;
							}
						}
						// Exception Handling without scrolling case and no expected element found in
						// the list then index ==0
						if (index == 0 && count == 0)
							Asserts.assertFail("Billing Organisations " + valueSelectedFromList
									+ " not found in the list to initiate the fund transfer");
						else
							break;
					} else

						// Code will work :: When Need to scroll
						for (int i = 0; i < length; i++) {
							LocalRecipientList = Elementlist.get(i).getText();
							if (LocalRecipientList.contains(valueSelectedFromList) && isElementVisible2(Elementlist.get(i))) {
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
						Asserts.assertFail("Billing Organisations " + valueSelectedFromList
								+ " not found in the list to initiate the fund transfer");

				} else
					Asserts.assertFail("No receipient Found in the Billing Organisations list");
			}

			Thread.sleep(3000);
		String xpath1 = "//XCUIElementTypeStaticText[@name='Primary source of fund']";
		List<RemoteWebElement> list1 = driver.findElements(By.xpath(xpath1));
		if (list1.size() > 0) {
			overseasmodule.handlingOfPrimarySourceOfFundPopup();
//			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
//			if (isElementVisible(IOShomePgaeObject.primarysourceOfFund()))
//				clickOnElement(IOShomePgaeObject.okButton());
		}
		Asserts.assertTrue(isElementVisible(IOShomePgaeObject.PayToBillerPageHeader()),
		CommonTestData.PAY_TO_BILLER_PAGE_HEADER.getEnumValue() + " Page Header not displaying.");
			//verifyPageHeader(CommonTestData.TRANSFER_DBS_POSB.getEnumValue(), DBSappObject.PageHeader());
			//TakeScreenshot(DBSappObject.PageHeader());
	} catch (HandleException e) {	
		obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to select account from Billing Organisations and verify header  ",e);
	}
	catch (Exception e) {		
		obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to select account from Billing Organisations and verify header  ",e);
	}
}


	@Step("Verifies the Applying Debit Card and Verify the completion page details.")
	public void ApplyDebitCard() throws Exception {
		try {
			ClickOnMoreButton();
			enterpasscode.EnterPasscodeAndDone();
			SelectDebitCardOptionFromCardsSectionAndAuthenticationOfSecurePIN();
			FillingDetailsToApplyingDebitCard();
			overseasmodule.ClickOnNEXTButton();
		    Asserts.assertTrue(isElementVisible(IOShomePgaeObject.ReviewApplicationPageHeader()),
						CommonTestData.REVIEW_APPLICATION.getEnumValue() + " Page Header not displaying.");
			
			gestUtils.scrollUPtoObjectIos("name", "NEXT", null);
		    ClickOnNextButton4();
			ClickOnSubmitButtonAfterSettingCardPIN();
			
			// Leave On Home Page to this test case for next run.
			//ClickOnCloseButton();
			//ClickOnHomeButton();
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
				String actualText = getTexOfElement((MobileElement) nextButton.get(1));
				//if (actualText.equalsIgnoreCase("NEXT"))
				clickOnElement((MobileElement) nextButton.get(1));
				Asserts.assertEquals(actualText, "NEXT", "Button not found");
			}
			else if(nextButton1.size() > 0) {
				//TakeScreenshot(nextButton.get(nextButton1.size()-1));
				String actualText = getTexOfElement((MobileElement) nextButton1.get(1));
				//if (actualText.equalsIgnoreCase("Next"))
				clickOnElement((MobileElement) nextButton1.get(1));
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
			//XCUIElementTypeOther
			List<RemoteWebElement> list = driver.findElements(By.xpath("//XCUIElementTypeOther"));
			System.out.println("PIN Size : "+list.size());
			//List<RemoteWebElement> list1 = driver.findElements(By.name("Create Your PIN"));
			clickOnElement((MobileElement) list.get(0));
			System.out.println("CreateYourPINField");
			enterTextInTextbox((MobileElement) list.get(0), CommonTestData.CREATE_PIN.getEnumValue());
			

			//clickOnElement(IOShomePgaeObject.CreateYourPINField());
			enterTextInTextbox(IOShomePgaeObject.CreateYourPINField(), CommonTestData.CREATE_PIN.getEnumValue());
			doneButtonIfAviliable();
			String j= IOShomePgaeObject.CreateYourPINField().getText();
			System.out.println(j);
			//clickOnElement(IOShomePgaeObject.ConfirmNewPINField());
			enterTextInTextbox(IOShomePgaeObject.ConfirmNewPINField(), CommonTestData.CONFIRM_PIN.getEnumValue());
			String o= IOShomePgaeObject.ConfirmNewPINField().getText();
			System.out.println(o);
			doneButtonIfAviliable();
			
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
			sendDataInCommonSearchBoxAndSelectFromDropDown("Cards", "Cards");
			//gestUtils.scrollUPtoObjectIos("name", "Cards", null);

//	  if (isElementVisible(IOShomePgaeObject.CardsButton()))
//				clickOnElement(IOShomePgaeObject.CardsButton());

			TakeScreenshot(IOShomePgaeObject.SelectDebitCard()); 
			clickOnElement(IOShomePgaeObject.SelectDebitCard());
			enterpasscode.EnterPasscodeAndDone();
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
			Thread.sleep(9000);
			//TakeScreenshot(IOShomePgaeObject.DebitCardDetailsDropdownList().get(1)); 
			//if(IOShomePgaeObject.DebitCardDetailsDropdownList().size() >0) {
			if(isElementVisible2(IOShomePgaeObject.DebitCardDetailsDropdownList().get(0))) 
			{
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
			if(index==0) 
				Asserts.assertFail("No " + debitCardToBeSelected + " found in the list of corresponding value");
			
			//Asserts.f(index > 0, "No " + debitCardToBeSelected + " found in the list of corresponding value");
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
			
			gestUtils.scrollUPtoObjectIos("name", "Education", null);
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
			enterpasscode.EnterPasscodeAndDone();
			ClickOnDepositAccountsAnd2FAAuthenticationDone();
			SelectOpenAccountOptionAndVerifyAccountBenifitsPageHeader();
			ClickOnopenAccountInStepButton();
			EnterMonthlySavingsAmtAndSelectSourceOfFundsForSavings();
			gestUtils.scrollUPtoObjectIos("name", "NEXT", null);
			overseasmodule.ClickOnNEXTButton();
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
			enterpasscode.EnterPasscodeAndDone();
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
			gestUtils.scrollUPtoObjectIos("name", "OPEN ACCOUNT NOW", null);
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
			gestUtils.scrollUPtoObjectIos("name", "I ACKNOWLEDGE", null);
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
	
	
	
	
	
	
	

	

	
	
	public void verifyDigibankAlert() throws Exception
	{
		String alertMessage=null;
		try {
			this.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		if(androidAlert.isIOSAlertPresent()) {
			System.out.println("Alert title :: "+ this.driver.findElementByXPath("//XCUIElementTypeStaticText[@name='digibank Alert']/following-sibling::XCUIElementTypeStaticText").getText()); 
			
			alertMessage=this.driver.findElementByXPath("//XCUIElementTypeStaticText[@name='digibank Alert']").getText()+": "+ this.driver.findElementByXPath("//XCUIElementTypeStaticText[@name='digibank Alert']/following-sibling::XCUIElementTypeStaticText").getText();
				Asserts.assertFail(alertMessage);
		}
		else if(androidAlert.isIOSOfflineAlertPresent()) {
			System.out.println("Alert title :: "+ this.driver.findElementByXPath("//XCUIElementTypeStaticText[@name='You seem to be offline']/following-sibling::XCUIElementTypeStaticText").getText()); 
			
			alertMessage=this.driver.findElementByXPath("//XCUIElementTypeStaticText[@name='You seem to be offline']").getText()+": "+ this.driver.findElementByXPath("//XCUIElementTypeStaticText[@name='You seem to be offline']/following-sibling::XCUIElementTypeStaticText").getText();
				Asserts.assertFail(alertMessage);
		}
		else if(androidAlert.isAlertPresent()) {
			System.out.println("Alert title :: " + this.driver.switchTo().alert().getText());

			alertMessage = this.driver.switchTo().alert().getText();
			Asserts.assertFail(alertMessage);
			
		}
		else 
			verifyWaitForPageLoad();
			
		}catch (Exception e) {		
				obj_handleexception.throwException("DIGIBANK_ALERT", " Failed to proceed because of DIGI BANK ALERT "+ alertMessage,e);
			}
	}
	public void verifyWaitForPageLoad() throws Exception
	{
		String alertMessage=null;
		try {
		if(isElementVisible2(IOShomePgaeObject.activityIndicator()) || isElementVisible2(IOShomePgaeObject.animationView() ) || isElementVisible2(IOShomePgaeObject.Authenticating()) ) {
			System.out.println("Wait Duration Limit exceeded :: Application Unable to load Page"); 
			
			alertMessage="Wait Duration Limit exceeded :: Application Unable to load Page";
				Asserts.assertFail(alertMessage);
		}
			}
			catch (Exception e) {		
				obj_handleexception.throwException("Application Not Responding", " Failed to proceed because Application Unable to load Page "+ alertMessage,e);
			}
	}

	@Step("Scroll To Billing Organisation ")
	public void scrollToBillingOrganisation() throws Exception {
		try {
			//gestUtils.scrollUPIos();
			wait.waitForElementVisibility(IOShomePgaeObject.SelectOwnAccount());
			gestUtils.DragAndDropElementToElement(IOShomePgaeObject.allTabList().get(4), IOShomePgaeObject.AllTab());
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
	
	@Step("Verify Peek Balance.")
	public void VerifyPeekBalance() throws Exception {
		try {
			homepage.verifyAccountTypeNameCurrencyAmount(CommonTestData.ACCOUNT_TYPE.getEnumValue(),
					CommonTestData.ACCOUNT_NAME_HOME.getEnumValue(), CommonTestData.CURRENCY.getEnumValue());
			 String xpath= "//XCUIElementTypeStaticText[@name='"+CommonTestData.USER_ACCOUNT_NAME.getEnumValue()+"']";
			 List<RemoteWebElement> list = driver.findElements(By.xpath(xpath));
			 if (list.size() > 0) {
				String DepositeAccountNameOnDashboard = getAndClickOnDepositeAccountNameFromDashboard(IOShomePgaeObject.accountNameHomepage());
				enterpasscode.EnterPasscodeAndDone();
				String ExpectedUserAccountNumber = GetUserAccountNumber();
				ClickOnToolBarBackIcon();

				ClickOnMoreButton();
				enterpasscode.EnterPasscodeAndDone();
				SelectPeekBalanceModule();
				enterpasscode.EnterPasscodeAndDone();
				handleConfirmationMessage(CommonTestData.EXISTING_PEEKBALANCE_ENABLE_MESSAGE.getEnumValue());
                EnablePeekBalanceToggle();
				SelectAccountToEnablePeekBalance(CommonTestData.USER_ACCOUNT_NAME.getEnumValue());

				String SelectedAccountNameWithAccountNumber = DepositeAccountNameOnDashboard + " " + ExpectedUserAccountNumber;
				verifySelectedAccountForPeekBalance(CommonTestData.ACCOUNT_FOR_PEEK_BALANCE.getEnumValue(),
						SelectedAccountNameWithAccountNumber);

				ClickOnSaveButton();
				ClickOnOkButtonInPersonalizeYourDevicePopup();
				ClickOnBackButtonImageView();
				clickOnLogoutButton();
				ratingpage.verifyTapOnTheStarsToRate(CommonTestData.RATE_MESSAGE.getEnumValue());
				ClickOnCloseButton();
                VerifyPeekBalanceEnabilityOnLogInPage(CommonTestData.PEEK_BALANCE_SUBTITLE_IOS.getEnumValue());
				// TODO: Code Add for tap and hold on above element and get total amount balance
				TapAndHoldPeekBalance();

				// DeRegister/Disable Process to removing peek balance from login page for next
				// run.
				ClickOnLoginButtonAfterEnablePeekBalance();
				ClickOnNOTYouLink();
			    ClickOnDeregisterButtonInDigiAlertPopup(CommonTestData.PEEK_BALANCE_DEREGISTER_MESSAGE.getEnumValue());
				}else
				Asserts.assertFail("Deposite Account Name not showing on the Dashboard Page.");

		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Execute Peek Balance. ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Execute Peek Balance", e);
		}
	}
	
	@Step("Tap And Hold to Peek Balance On the Login Page.")
	public void TapAndHoldPeekBalance() throws Exception {
		try {
			gestUtils.longPressOnAndroidElement(IOShomePgaeObject.peekBalance());
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Tap And Hold On Peek Balance. ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Tap And Hold On Peek Balance. ", e);
		}
	}

	@Step("Verify Deposit Account Type On Dashboard Page")
	public void VerifyDepositAccountTypeOnDashboardPage() throws Exception {
		try {
			gestUtils.scrollUPIos(); 
			Asserts.assertTrue(isElementVisible2(IOShomePgaeObject.Deposits()),"Deposits Account Type is not displayed on home page after login.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verify Deposit Account Type On Dashboard Page. ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify Deposit Account Type On Dashboard Page ", e);
		}
	}
	
	@Step("Click On LogIn Button.")
	public void ClickOnLoginButtonAfterEnablePeekBalance() throws Exception {
		try {
			clickOnElement(IOShomePgaeObject.logInButton_0());
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On LogIn Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On LogIn Button  ", e);
		}
	}
	
	@Step("Click On Not You Link Button.")
	public void ClickOnNOTYouLink() throws Exception {
		try {
			if(isElementVisible2(IOShomePgaeObject.NotYouLink()))
				clickOnElement(IOShomePgaeObject.NotYouLink());
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Not You Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Not You Button  ", e);
		}
	}

	@Step("Click On Deregister Button.")
	public void ClickOnDeregisterButtonInDigiAlertPopup(String peekBalanceDeregisterMsg) throws Exception {
		try {
			Thread.sleep(3000);
			if (isElementVisible2(IOShomePgaeObject.DeregisteryourprofileAlert()))
				clickOnElement(IOShomePgaeObject.PeekbalanceDeregisterButton());

		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Deregister Button ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Deregister Button  ", e);
		}
	}
	
	@Step("Select Peek Balance Module After Search.")
	public void SelectPeekBalanceModule() throws Exception {
		try {
			sendDataInCommonSearchBoxAndSelectFromDropDown("Peek", CommonTestData.PEEK_BALANCE.getEnumValue());
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select Peek balance Module. ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select Peek balance Module.  ", e);
		}
	}
	
	@Step("Handle Confirmation Message")
	public void handleConfirmationMessage(String message) throws Exception{
		try {
			List<MobileElement> ConfirmationAlert = IOShomePgaeObject.persoanliseMessage() ;
			if (ConfirmationAlert.size() > 0) {
				ButtonVerifyClick(IOShomePgaeObject.alertOkButton());
			}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Handle Confirmation Message ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Handle Confirmation Message ", e);
		}
	}
	
	@Step("Enable Peek balance Toggle.")
	public void EnablePeekBalanceToggle() throws Exception {
		try {
			clickOnElement(IOShomePgaeObject.PeekBalanceToggle());
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Enable Peek balance Toggle. ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Enable Peek balance Toggle.  ", e);
		}
	}

	@Step("Select Account To Enable Peek Balance.")
	public void SelectAccountToEnablePeekBalance(String ExpectedUserAccountName) throws Exception {
		try {
			clickOnElement(IOShomePgaeObject.AccountForPeekBalanceDropdown());
			String xpath = "//XCUIElementTypeStaticText[@name='" + ExpectedUserAccountName + "']";
			MobileElement selectAccount = (MobileElement) driver.findElement(By.xpath(xpath));
			clickOnElement(selectAccount);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Select Account To Enable Peek Balance ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Select Account To Enable Peek Balance  ", e);
		}
	}
	
	@Step("Get And Click On Deposite Account Name From Dashboard.")
	public String getAndClickOnDepositeAccountNameFromDashboard(MobileElement depositsAccountName) throws Exception {
		try {
			String DepositeAccountNameOnDashboard = depositsAccountName.getText();
			clickOnElement(depositsAccountName);
			return DepositeAccountNameOnDashboard;
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to get And Click On Deposite Account Name From Dashboard ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to get And Click On Deposite Account Name From Dashboard ", e);
		}
		return null;
	}
	
	@Step("Get User Account Number")
	public String GetUserAccountNumber() throws Exception {
		try {
			String getAccountNumber = driver.findElementByXPath("//XCUIElementTypeStaticText[2]").getText();
			return getAccountNumber;
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Get User Account Number ", e);
		}
		return null;
	}
	
	
	@Step("verify Selected Account For Peek Balance")
	public void verifySelectedAccountForPeekBalance(String AccountTitle, String SelectedAccountNameWithAccountNumber)
			throws Exception {
		try {
		
				String xpath = "//XCUIElementTypeCell[2]/XCUIElementTypeStaticText";
				String Text = driver.findElementByXPath(xpath).getText();
			     System.out.println("SelectedAccountNameWithAccountNumber " +Text);
			Asserts.assertEquals(Text,
					SelectedAccountNameWithAccountNumber,
					SelectedAccountNameWithAccountNumber + " Text is not matching.");
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to verify Selected Account For Peek Balance ", e);
		}
	}
	
	@Step("Click On Toolbar Back Icon.")
	public void ClickOnToolBarBackIcon() throws Exception {
		try {
				String xpath = "//XCUIElementTypeButton[1]";
				MobileElement back = (MobileElement) driver.findElement(By.xpath(xpath));
				clickOnElement(back);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Toolbar Back Icon ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Toolbar Back Icon ", e);
		}
	}
	
	@Step("Click On Save Button.")
	public void ClickOnSaveButton() throws Exception {
		try {
			clickOnElement(IOShomePgaeObject.SaveBtn());
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Save Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Save Button  ", e);
		}
	}
	
	@Step("Click On Ok Button After Displaying Personalize Your Device Popup.")
	public void ClickOnOkButtonInPersonalizeYourDevicePopup() throws Exception {
		try {
			if (isElementVisible2(IOShomePgaeObject.PersonalizeYourDevicePopup()))
				clickOnElement(IOShomePgaeObject.alertOkButton());

		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Click On Ok Button After Displaying PersonalizeYourDevicePopup ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Click On Ok Button After Displaying PersonalizeYourDevicePopup ", e);
		}
	}
	
	@Step("Click On Back Button")
	public void ClickOnBackButtonImageView() throws Exception {
		try {
			clickOnElement(IOShomePgaeObject.backButton());
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to click on Back Button. ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to click on Back Button. ", e);
		}
	}
	
	@Step("Verify Visibility of Peek Balance on Login Page.")
	public void VerifyPeekBalanceEnabilityOnLogInPage(String peekBalanceSubtitle) throws Exception {
		try {
			Thread.sleep(20000); 
			String a = getTexOfElement(IOShomePgaeObject.peekBalance());
			System.out.println("a" +a);
			wait.waitForElementVisibility(IOShomePgaeObject.peekBalance());
			Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.peekBalance()).toLowerCase(), peekBalanceSubtitle.toLowerCase(),
					peekBalanceSubtitle + " Text is not matching.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify visibility of Peek Balance On Login page. ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify visibility of Peek Balance On Login page. ", e);
		}
	}
	
	@Step("Update Personal Details")
	public void UpdatePersonalDetails(String appName) throws Exception {
		try {
			ClickOnMoreButton();
			enterpasscode.EnterPasscodeAndDone();
			SelectUpdateContactDetails();
			verifyUpdateContactDetailsPageHeader(CommonTestData.UPDATE_CONTACT_DETAILS_PAGEHEADER.getEnumValue());
			VerifyBackButtonImageView();
			VerifyPersonalAndContactDetails();
		    VerifyMailingAddress();
			SelectPersonalContactDetails();
			enterpasscode.EnterPasscodeAndDone();
			verifyPersonalContactDetailsPageHeader();
            VerifyPersonalDetailsPage(appName);
			ClickOnCheckboxes();
            verifyTermsAndConditionsMessage(CommonTestData.TERMS_AND_CONDITIOINS_MESSAGE.getEnumValue(), appName);
            ClickOnNextButton5();
            gestUtils.scrollUPtoObjectIos("name", "CONFIRM", null);
            ClickOnNextButton5();
			enterpasscode.EnterPasscodeAndDone();
			verifySuccessfullyUpdatedMessage(appName);

			// Verify Final Result after go through on Personal Details Page.
			ClickOnBackToMoreServicesButton(appName);
			SelectUpdateContactDetails();
			verifyUpdateContactDetailsPageHeader(CommonTestData.UPDATE_CONTACT_DETAILS_PAGEHEADER.getEnumValue());
			VerifyBackButtonImageView();
			VerifyPersonalAndContactDetails();
			VerifyMailingAddress();
			SelectPersonalContactDetails();
			enterpasscode.EnterPasscodeAndDone();
            verifyPersonalContactDetailsPageHeader();
            VerifyPersonalDetailsPage(appName);
            VerifyLastUpdatedDateOfCallMeCheckbox();
            VerifyLastUpdatedDateOfSMSMeCheckbox();
            VerifyLastUpdatedDateOfEmailMeCheckbox();
            VerifyLastUpdatedDateOfFAXMeCheckbox();
            VerifyLastUpdatedDateOfMailMeCheckbox();

			// Leave On Home Page for next case run.
			ClickOnBackButton();
			ClickOnHomeButton();

		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to update personal details  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", "  Failed to update personal details  ", e);
		}
	}
	
	@Step("Verify Last Update Date Of CAll me Checkbox.")
	public void VerifyLastUpdatedDateOfCallMeCheckbox() throws Exception {
		try {
			Calendar calendar = Calendar.getInstance();
			Date today = calendar.getTime();
			DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
			String todayAsString = dateFormat.format(today);
			String ExpectedDate = todayAsString.replaceAll("-", " ");
			String ExpectedLastUpdatedDateValue = null;
			
			String ActualLastUpdatedDateValue = getTexOfElement(IOShomePgaeObject.CAllMeCheckbox());
			String checkboxarry[] =  ActualLastUpdatedDateValue.split("Last");
			ExpectedLastUpdatedDateValue = checkboxarry[0] + "Last Updated on " + ExpectedDate;
		    System.out.println("ExpectedLastUpdatedDateValue: "+ExpectedLastUpdatedDateValue);  
		    System.out.println("ActualLastUpdatedDateValue: "+ActualLastUpdatedDateValue);  
			
			 Asserts.assertEquals(ActualLastUpdatedDateValue, 
						ExpectedLastUpdatedDateValue,
						ExpectedLastUpdatedDateValue + " Dates is not matching after Updating Personal Details.");
			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION"," Failed to verify last update on call me checkbox ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to verify last update on call me checkbox  ",e);
		}
	}
	
	@Step("Verify Last Update Date Of SMS me Checkbox.")
	public void VerifyLastUpdatedDateOfSMSMeCheckbox() throws Exception {
		try {
			Calendar calendar = Calendar.getInstance();
			Date today = calendar.getTime();
			DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
			String todayAsString = dateFormat.format(today);
			String ExpectedDate = todayAsString.replaceAll("-", " ");
			String ExpectedLastUpdatedDateValue = null;
			
			String ActualLastUpdatedDateValue = getTexOfElement(IOShomePgaeObject.SMSMeCheckbox());
			String checkboxarry[] =  ActualLastUpdatedDateValue.split("Last");
			ExpectedLastUpdatedDateValue = checkboxarry[0] + "Last Updated on " + ExpectedDate;
		    System.out.println("ExpectedLastUpdatedDateValue: "+ExpectedLastUpdatedDateValue);  
		    System.out.println("ActualLastUpdatedDateValue: "+ActualLastUpdatedDateValue);  
			
			 Asserts.assertEquals(ActualLastUpdatedDateValue, 
						ExpectedLastUpdatedDateValue,
						ExpectedLastUpdatedDateValue + " Dates is not matching after Updating Personal Details.");
			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION"," Failed to verify last update on sms me checkbox ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to verify last update on sms me checkbox  ",e);
		}
	}
	
	@Step("Verify Last Update Date Of Email me Checkbox.")
	public void VerifyLastUpdatedDateOfEmailMeCheckbox() throws Exception {
		try {
			Calendar calendar = Calendar.getInstance();
			Date today = calendar.getTime();
			DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
			String todayAsString = dateFormat.format(today);
			String ExpectedDate = todayAsString.replaceAll("-", " ");
			String ExpectedLastUpdatedDateValue = null;
			
			String ActualLastUpdatedDateValue = getTexOfElement(IOShomePgaeObject.EMAILMeCheckbox());
			String checkboxarry[] =  ActualLastUpdatedDateValue.split("Last");
			ExpectedLastUpdatedDateValue = checkboxarry[0] + "Last Updated on " + ExpectedDate;
		    System.out.println("ExpectedLastUpdatedDateValue: "+ExpectedLastUpdatedDateValue);  
		    System.out.println("ActualLastUpdatedDateValue: "+ActualLastUpdatedDateValue);  
			
			 Asserts.assertEquals(ActualLastUpdatedDateValue, 
						ExpectedLastUpdatedDateValue,
						ExpectedLastUpdatedDateValue + " Dates is not matching after Updating Personal Details.");
			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION"," Failed to verify last update on Email me checkbox ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to verify last update on Email me checkbox  ",e);
		}
	}
	
	@Step("Verify Last Update Date Of FAX me Checkbox.")
	public void VerifyLastUpdatedDateOfFAXMeCheckbox() throws Exception {
		try {
			Calendar calendar = Calendar.getInstance();
			Date today = calendar.getTime();
			DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
			String todayAsString = dateFormat.format(today);
			String ExpectedDate = todayAsString.replaceAll("-", " ");
			String ExpectedLastUpdatedDateValue = null;
			
			String ActualLastUpdatedDateValue = getTexOfElement(IOShomePgaeObject.FAxMeCheckbox());
			String checkboxarry[] =  ActualLastUpdatedDateValue.split("Last");
			ExpectedLastUpdatedDateValue = checkboxarry[0] + "Last Updated on " + ExpectedDate;
		    System.out.println("ExpectedLastUpdatedDateValue: "+ExpectedLastUpdatedDateValue);  
		    System.out.println("ActualLastUpdatedDateValue: "+ActualLastUpdatedDateValue);  
			
			 Asserts.assertEquals(ActualLastUpdatedDateValue, 
						ExpectedLastUpdatedDateValue,
						ExpectedLastUpdatedDateValue + " Dates is not matching after Updating Personal Details.");
			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION"," Failed to verify last update on Fax me checkbox ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to verify last update on Fax me checkbox  ",e);
		}
	}
	
	@Step("Verify Last Update Date Of Mail me Checkbox.")
	public void VerifyLastUpdatedDateOfMailMeCheckbox() throws Exception {
		try {
			Calendar calendar = Calendar.getInstance();
			Date today = calendar.getTime();
			DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
			String todayAsString = dateFormat.format(today);
			String ExpectedDate = todayAsString.replaceAll("-", " ");
			String ExpectedLastUpdatedDateValue = null;
			
			String ActualLastUpdatedDateValue = getTexOfElement(IOShomePgaeObject.MAILMeCheckbox());
			String checkboxarry[] =  ActualLastUpdatedDateValue.split("Last");
			ExpectedLastUpdatedDateValue = checkboxarry[0] + "Last Updated on " + ExpectedDate;
		    System.out.println("ExpectedLastUpdatedDateValue: "+ExpectedLastUpdatedDateValue);  
		    System.out.println("ActualLastUpdatedDateValue: "+ActualLastUpdatedDateValue);  
			
			 Asserts.assertEquals(ActualLastUpdatedDateValue, 
						ExpectedLastUpdatedDateValue,
						ExpectedLastUpdatedDateValue + " Dates is not matching after Updating Personal Details.");
			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION"," Failed to verify last update on Mail me checkbox ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to verify last update on Mail me checkbox  ",e);
		}
	}
	
	
	@Step("Select Checkboxes. ")
	public void ClickOnCheckboxes() throws Exception {
		try {
			    ClickOnCallMeCheckbox();
			    ClickOnSMSMeCheckbox();
			    ClickOnEMAILMeCheckbox();
				ClickOnMAILMeCheckbox();
				ClickOnFAXMeCheckbox();
			} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to select All checkboxes  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to select All checkboxes  ", e);
		}
	}
	
	@Step("Select Call me Checkbox.")
	public void ClickOnCallMeCheckbox() throws Exception {
		try {
				clickOnElement(IOShomePgaeObject.CAllMeCheckbox());
			} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select Call me Checkbox ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select Call me Checkbox ", e);
		}
	}
	
	@Step("Select SMS me Checkbox.")
	public void ClickOnSMSMeCheckbox() throws Exception {
		try {
				clickOnElement(IOShomePgaeObject.SMSMeCheckbox());
			} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select SMS me Checkbox ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select SMS me Checkbox ", e);
		}
	}
	
	@Step("Select EMAIL me Checkbox.")
	public void ClickOnEMAILMeCheckbox() throws Exception {
		try {
				clickOnElement(IOShomePgaeObject.EMAILMeCheckbox());
			} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select EMAIL me Checkbox ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select EMAIL me Checkbox ", e);
		}
	}
	
	@Step("Select MAIL me Checkbox.")
	public void ClickOnMAILMeCheckbox() throws Exception {
		try {
				clickOnElement(IOShomePgaeObject.MAILMeCheckbox());
			} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select MAIL me Checkbox ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select MAIL me Checkbox ", e);
		}
	}
	
	@Step("Select FAX me Checkbox.")
	public void ClickOnFAXMeCheckbox() throws Exception {
		try {
				clickOnElement(IOShomePgaeObject.FAxMeCheckbox());
			} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select FAX me Checkbox ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select FAX me Checkbox ", e);
		}
	}
	
	
	
	
	@Step("Verifying Next Label and click")
	public void ClickOnNextButton5() throws Exception {
		try {
			List<RemoteWebElement> nextButton = driver.findElements(By.name("NEXT"));
			List<RemoteWebElement> nextButton1 = driver.findElements(By.name("Next"));
			List<RemoteWebElement> CONFIRM1 = driver.findElements(By.name("CONFIRM"));
			if(nextButton.size() > 0) {
				TakeScreenshot(nextButton.get(nextButton.size()-1));
				String actualText = getTexOfElement((MobileElement) nextButton.get(1));
				if (actualText.equalsIgnoreCase("NEXT"))
					clickOnElement((MobileElement) nextButton.get(1));
				Asserts.assertEquals(actualText, "NEXT", "Button not found");
			}
			else if(nextButton1.size() > 0) {
				TakeScreenshot(nextButton.get(nextButton1.size()-1));
				String actualText = getTexOfElement((MobileElement) nextButton1.get(1));
				if (actualText.equalsIgnoreCase("NEXT"))
					clickOnElement((MobileElement) nextButton1.get(1));
				Asserts.assertEquals(actualText, "Next", "Button not found");
			}else if(CONFIRM1.size() > 0) {
				clickOnElement((MobileElement) CONFIRM1.get(1));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Step("Click On Back Button.")
	public void ClickOnBackButton() throws Exception {
		try {
			clickOnElement(IOShomePgaeObject.BackBtn());
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Back Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Back Button  ", e);
		}
	}
	
	@Step("Verify 'Update Contact Details' page header")
	public void verifyUpdateContactDetailsPageHeader(String expectedText) throws Exception {
		try {
			System.out.println(getTexOfElement(IOShomePgaeObject.UpdateContactDetails()));
			
			
			Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.UpdateContactDetails()).toLowerCase() ,expectedText.toLowerCase(),
					expectedText + " Page Header not displaying.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION", " Failed to verify 'Update Contact Details' page header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION", " Failed to verify 'Update Contact Details' page header ", e);
		}
	}
	
	@Step("Select Update Contact Details After Search.")
	public void SelectUpdateContactDetails() throws Exception {
		try {
			sendDataInCommonSearchBoxAndSelectFromDropDown1("Update", CommonTestData.UPDATE_CONTACT_DETAILS_PAGEHEADER.getEnumValue(),CommonTestData.UPDATE_PARTICULARS.getEnumValue());
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select Peek balance Module. ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select Peek balance Module.  ", e);
		}
	}
	
	@Step("verify 'Back To More Services' Button")
	public void verifyBackToMoreButton() throws Exception {
		try {
			Asserts.assertTrue(isElementVisible2(IOShomePgaeObject.backToMoreButton()),"BACK TO More Services Btn is not displayed.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to verify 'Back To More Services' Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to verify 'Back To More Services' Button ", e);
		}
	}
	
	@Step("verify 'Back To More Services' Button")
	public void verifyBackToMoreServicesButton() throws Exception {
		try {
			Asserts.assertTrue(isElementVisible2(IOShomePgaeObject.BackToMoreServicesButton()),"BACK TO More Services Btn is not displayed.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to verify 'Back To More Services' Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to verify 'Back To More Services' Button ", e);
		}
	}

	@Step("Verify 'Back Button Image View' on update Contact details Page. ")
	public void VerifyBackButtonImageView() throws Exception {
		try {
			Asserts.assertTrue(isElementVisible2(IOShomePgaeObject.backButton()), "Back Btn Image View is not displayed.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to verify visibility of 'Back Button Image View' ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to verify visibility of 'Back Button Image View' ", e);
		}
	}
	
	@Step("Verify 'Mailing Address' on update Contact details Page. ")
	public void VerifyMailingAddress() throws Exception {
		try {
			Asserts.assertTrue(isElementVisible2(IOShomePgaeObject.MailingAddressTab()),
					"Mailing Address Tab is not displayed.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION"," Failed to verify visibility of 'Mailing Address' ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION"," Failed to verify visibility of 'Mailing Address' ", e);
		}
	}
	
	@Step("Verify 'Personal And Contact Details' on update Contact details Page. ")
	public void VerifyPersonalAndContactDetails() throws Exception {
		try {
			Asserts.assertTrue(isElementVisible2(IOShomePgaeObject.PersonalAndContactDetailsTab()),"Personal And Contact Details Tab is not displayed.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION"," Failed to verify visibility of 'Personal And Contact Details'  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION"," Failed to verify visibility of 'Personal And Contact Details' ", e);
		}
	}
	
	@Step("Select Personal & Contact Details under Update Contact Details Page.")
	public void SelectPersonalContactDetails() throws Exception {
		try {
			clickOnElement(IOShomePgaeObject.PersonalAndContactDetailsTab());
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Select Personal & Contact Details under Update Contact Details Page ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Select Personal & Contact Details under Update Contact Details Page ", e);
		}
	}
	
	@Step("Verify Personal And Contact Details Page Header")
	public void verifyPersonalContactDetailsPageHeader() throws Exception {
		try {
			String Xpath = "//XCUIElementTypeStaticText[@name='Contact Details']";
			List<RemoteWebElement> list = driver.findElements(By.xpath(Xpath));
			if (list.size() > 0) {
					Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.ContactDetails()).toLowerCase(),
							CommonTestData.CONTACT_DETAILS_PAGEHEADER.getEnumValue().toLowerCase(),
							"'Header Title' is not Matching");
				
			}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION",
					" Failed to Verify Personal And Contact Details Page Header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION",
					" Failed to Verify Personal And Contact Details Page Header ", e);
		}
}
	
	@Step("Verify Successfully Updated Message")
	public void verifySuccessfullyUpdatedMessage(String appName) throws Exception {
		try {
		
				if (appName.equalsIgnoreCase("DBS")) {
					Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.SuccessfullyUpdated()),
							CommonTestData.SUCCESSFULLY_SUBMITTED_MESSAGE.getEnumValue(),
							CommonTestData.SUCCESSFULLY_SUBMITTED_MESSAGE.getEnumValue() + " Text is not matching");
					verifyUpdateMoreDetailsButton();
					verifyBackToMoreServicesButton();
				} else if (appName.equalsIgnoreCase("iWEALTH")) {
					Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.RequestsSubmitted()),
							CommonTestData.REQUESTS_SUBMITTED_MESSAGE.getEnumValue(),
							CommonTestData.REQUESTS_SUBMITTED_MESSAGE.getEnumValue() + " Text is not matching");
					verifyUpdateMailingAddressButton();
					verifyBackToMoreButton();
				}
				
			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify Successfully Updated Message ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify Successfully Updated Message ", e);
		}
	}
	
	
	@Step("verify Update Mailing Address Button")
	public void verifyUpdateMailingAddressButton() throws Exception {
		try {
			gestUtils.scrollUPtoObject(null, null, null);
			Asserts.assertTrue(isElementVisible(IOShomePgaeObject.UpdateMailingAddressBtn()),"Update Mailing Address Btn is not displayed.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION"," Failed to verify Update Mailing Address Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION"," Failed to verify Update Mailing Address Button ", e);
		}
	}

	@Step("verify Update More Details Button")
	public void verifyUpdateMoreDetailsButton() throws Exception {
		try {
			gestUtils.scrollUPtoObject(null, null, null);
			Asserts.assertTrue(isElementVisible(IOShomePgaeObject.UpdateMoreDetailsBtn()),"Update More Details Btn is not displayed.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to verify Update More Details Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to verify Update More Details Button ",
					e);
		}
	}
	
	@Step("Verify Contact Details Title")
	public void verifyContactDetailsTitle(String contactDetailsTitle) throws Exception {
		try {
			Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.ContactDetailsTitle()).toLowerCase(), contactDetailsTitle.toLowerCase(), contactDetailsTitle + " Text is not matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verify Contact Details Title ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify Contact Details Title ", e);
		}
	}

	@Step("Verify Email Notes")
	public void verifyEmailNotes(String emailNotes) throws Exception {
		try {
			Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.EmailNotes()).toLowerCase(), emailNotes.toLowerCase(), emailNotes + " Text is not matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verify Email Notes ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify Email Notes ", e);
		}
	}

	@Step("Verify Change Button Under Contact Details")
	public void verifyChangeButton(String ChangeButton) throws Exception {
		try {
		//	gestUtils.scrollUPtoObject("text", "PERSONAL PARTICULARS", PersonalPerticularSectionTitle);
			Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.ContactDetailsChangeBtn()),
					CommonTestData.CHANGE_BUTTON.getEnumValue(),
					CommonTestData.CHANGE_BUTTON.getEnumValue() + " Text is not matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify Change Button Under Contact Details ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify Change Button Under Contact Details", e);
		}
	}

	@Step("Verify Personal Particular")
	public void verifyPersonalParticular(String personalParticular) throws Exception {
		try {
			Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.PersonalPerticularSectionTitle()).toLowerCase(), personalParticular.toLowerCase(),
					personalParticular + " Text is not matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verify Personal Particular ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify Personal Particular ", e);
		}
	}

	@Step("Verify Change Button Under Personal Particular Section")
	public void verifyChangeButtonUnderPersonalParticularSection(String ChangeButton) throws Exception {
		try {
			//gestUtils.scrollUPtoObject("text", "MARKETING MESSAGES", MarketingMessageTitle);
			Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.PersonalPerticularChangeBtn()),
					CommonTestData.CHANGE_BUTTON.getEnumValue(),
					CommonTestData.CHANGE_BUTTON.getEnumValue() + " Text is not matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify Change Button Under Personal Particular Section ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify Change Button Under Personal Particular Section ", e);
		}
	}

	@Step("Verify Marketing Message Title")
	public void verifyMarketingMessageTitle(String marketingMessageTitle) throws Exception {
		try {
			gestUtils.scrollUPtoObjectIos("name", "MARKETING MESSAGES", null); 
			Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.MarketingMessageTitle()).toLowerCase(), marketingMessageTitle.toLowerCase(),
					marketingMessageTitle + " Text is not matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify Marketing Message Title ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify Marketing Message Title ", e);
		}
	}

	@Step("Verify Marketing Message Notes")
	public void verifyMarketingMessageNotes(String marketingMessageNotes) throws Exception {
		try {
			Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.MarketingMessageNotes()).toLowerCase(), marketingMessageNotes.toLowerCase(),
					marketingMessageNotes + " Text is not matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify Marketing Message Notes ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify Marketing Message Notes ", e);
		}
	}

	@Step("Verify 'I would like the bank to:' Message.")
	public void verifyIWouldLikeTheBankTomessage(String message) throws Exception {
		try {
			Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.UPPSectionLabel()), message,
					message + " Text is not matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify 'I would like the bank to:' Message ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify 'I would like the bank to:' Message ", e);
		}
	}

	@Step("Verify visibility of 'Personal & Contact Details' Page Header, 'Contact Details' &  'Personal Perticulars' Section.")
	public void VerifyPersonalDetailsPage(String appName) throws Exception {
		try {
			verifyContactDetailsTitle(CommonTestData.CONTACT_DETAILS_TITLE.getEnumValue());
			verifyEmailNotes(CommonTestData.EMAIL_NOTES.getEnumValue());
			verifyChangeButton(CommonTestData.CHANGE_BUTTON.getEnumValue());
			verifyPersonalParticular(CommonTestData.PERSONAL_PARTICULARS.getEnumValue());
			verifyChangeButtonUnderPersonalParticularSection(CommonTestData.CHANGE_BUTTON.getEnumValue());
			verifyMarketingMessageTitle(CommonTestData.MARKETING_MESSAGE_TITLES.getEnumValue());
			verifyMarketingMessageNotes(CommonTestData.MARKETING_MESSAGE_NOTES.getEnumValue());
			verifyIWouldLikeTheBankTomessage(CommonTestData.IWOULD_LIKE_THEBANK_TO_MESSAGE.getEnumValue());
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify Personal Details Page  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify Personal Details Page ", e);
		}
	}
	
	@Step("Verify Terms & Conditions Message.")
	public void verifyTermsAndConditionsMessage(String termAndConditionsMessage, String appName) throws Exception {
		try {
			Asserts.assertEquals(getTexOfElement(IOShomePgaeObject.TermsAndConditionsMsg()), termAndConditionsMessage,
					termAndConditionsMessage + " Text is not matching");
			if (appName.equalsIgnoreCase("DBS"))
				  gestUtils.scrollUPtoObjectIos("name", "NEXT", null);
			else if (appName.equalsIgnoreCase("iWEALTH"))
				  gestUtils.scrollUPtoObjectIos("name", "CONFIRM", null);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION"," Failed to Verify Terms & Conditions Message ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify Terms & Conditions Message ",e);
		}
	}
	
	
	
	
}

