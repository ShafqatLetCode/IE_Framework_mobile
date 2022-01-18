package com.crestech.pages.iospage;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import com.crestech.annotation.values.ElementDescription;
import com.crestech.appium.utils.CommonAppiumTest;
import com.crestech.common.utilities.AndroidAlert;
import com.crestech.common.utilities.Asserts;
import com.crestech.common.utilities.GestureUtils;
import com.crestech.common.utilities.HandleException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

/**
 * @author Divya
 *
 */
public class homePage extends CommonAppiumTest{
	
	public AppiumDriver<RemoteWebElement> driver = null;
	HandleException obj_handleexception = null;
	GestureUtils gestUtils = null;
	Asserts Assert = null;
	AndroidAlert androidAlert = null;
	enterPasscode enterpasscode = null;
	public homePage(AppiumDriver<RemoteWebElement> driver) throws Exception {
		super(driver);
		try {
			this.driver = driver;
			obj_handleexception = new HandleException(null, null);
			gestUtils = new GestureUtils(driver);
			Assert = new Asserts();
			androidAlert = new AndroidAlert(driver);
			enterpasscode = new enterPasscode(driver);
			PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@ElementDescription(value = "Deposite Homepage")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Deposits']")
	private MobileElement depositeHomepage;

	@ElementDescription(value = "SGD Homepage")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'SGD')]")
	private MobileElement sgdHomepage;

	@ElementDescription(value = "Account name Homepage")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='DBS SAVINGS PLUS']")
	private MobileElement accountNameHomepage;

	@ElementDescription(value = "Account section on HomePage")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Accounts']")
	private MobileElement accountSectionHomePage;
	
	@ElementDescription(value = "'Welcome to' textfield")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Welcome to ']")
	private MobileElement welcomeToText;
	
	public MobileElement welcomeToText() { 
		return welcomeToText;
	}
	
	@ElementDescription(value = "logout Button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='logout']")
	private MobileElement logOutButton;
	
	@ElementDescription(value = "logout Button iWealth")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='logout text']")
	private MobileElement logOutButtoniWealth;
	
	@ElementDescription(value = "fingureprint alert message")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Set Up')]")
	private MobileElement fingerpringAlertMessage;

	@ElementDescription(value = "fingureprint alert closed button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='icon close']")
	private MobileElement fingerpringAlertClosedButton;

	@ElementDescription(value = "fingureprint alert closed button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='introClose']")
	private MobileElement recordingAlertClosedButton;
	
	@ElementDescription(value = "setup Token message")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Set up your Digital Token']")
	private MobileElement setupTokenMessage;
	
	@ElementDescription(value = "setup now button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='SET UP NOW']")
	private MobileElement setupNowButton;
	
	@ElementDescription(value = "you have set Token message")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'ve set up your digital token')]")
	private MobileElement youHaveSetTokenMessage;
	
	@ElementDescription(value = "done Token button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='DONE']")
	private MobileElement DoneButton;
	
	@ElementDescription(value = "First Time digital token alert")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Please note you can only have one digital token registered to your profile. Any digital token on an alternative device will therefore be automatically deregistered.']")
	private MobileElement digitokeRegisterAlertMsg;
	
	@ElementDescription(value = "continue button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Continue']")
	private MobileElement continueButton;

	@ElementDescription(value = "Next Button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='NEXT']")
	private MobileElement nextButton;
	
	@ElementDescription(value = "confirm email")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Confirm your email address']")
	private MobileElement confirmEmail;
	
	@ElementDescription(value = "fitness activity alert")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Like to Access Your Motion & Fitness Activity')]")
	private MobileElement alertFitnessActivityTitle;

	@ElementDescription(value = "ok button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='OK']")
	private MobileElement OKButton;
	
	@ElementDescription(value = "GO TO LOCATION SETTINGS button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='GO TO LOCATION SETTINGS']")
	private MobileElement goToLocationSettingButton;
	
	@ElementDescription(value = "swipe button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='TravelMode_Close']")
	private MobileElement swipeButton;
	
	@ElementDescription(value = "Iwealth management alert")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Welcome to digibank for Wealth Management']")
	private MobileElement managementAlertMsg;
	
	@ElementDescription(value = "GET STARTED Button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='GET STARTED']")
	private MobileElement GET_STARTED_Button;
	
	@ElementDescription(value = "'Welcome to' textfield")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Welcome to']")
	private MobileElement welcomeToTextIwealth;
	
	public MobileElement welcomeToTextIwealth() { 
		return welcomeToTextIwealth;
	}
	
	@ElementDescription(value = "'digibank' textfield")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='digibank']")
	private MobileElement digibankText;
	
	@ElementDescription(value = "'digibank' textfield")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='DBS digibank']")
	private MobileElement digibankTextwealth;
	
	@ElementDescription(value = "pay and transfer button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Pay & Transfer']")
	private MobileElement payAndTransferButton;
	
	@ElementDescription(value = "More button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='More']")
	private MobileElement moreButton;
	
	public MobileElement accountNameHomepage() { 
		return accountNameHomepage;
	}
	
	@Step("Click on More Button.")
	public void ClickOnMoreButton() throws Exception {
		try {
		    wait.waitForElementToBeClickable(moreButton); 
		    com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(moreButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On 'More' button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On 'More' button ", e);
		}
	}
	
	@Step("Get And Click On Deposite Account Name From Dashboard.")
	public String getAndClickOnDepositeAccountNameFromDashboard() throws Exception {
		try {
			String DepositeAccountNameOnDashboard = accountNameHomepage.getText();
			clickOnElement(accountNameHomepage);
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
	
	@Step("Click On 'Pay & Transfer' Button.")
	public void ClickOnPayAndTransferButton() throws Exception {
		try {
			wait.waitForElementToBeClickable(payAndTransferButton);
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(payAndTransferButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On pay and transfer Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On pay and transfer Button ", e);
		}
	}

	@Step("Verify 'Welcome to DigiBank' Messages on dashboard Page.")
	public void VerifyWelcomeMessagesOnDashboardPage(String welcome, String DigiBank, String DBSDigibank,
			String app_Name) throws Exception {
		try {
			if (app_Name.equalsIgnoreCase("DBS")) {
				Asserts.assertEquals(getTexOfElement(welcomeToText).trim().toLowerCase(), welcome.toLowerCase(),
						welcome + " text is not found");
				Asserts.assertEquals(getTexOfElement(digibankText).trim().toLowerCase(), DigiBank.toLowerCase(),
						DigiBank + " text is not found");
			}
			else if (app_Name.equalsIgnoreCase("iWEALTH")) {
				Asserts.assertEquals(getTexOfElement(welcomeToTextIwealth).trim().toLowerCase(), welcome.toLowerCase(),
						welcome + " text is not found");
				Asserts.assertEquals(getTexOfElement(digibankTextwealth).trim().toLowerCase(),
						DBSDigibank.toLowerCase(), DBSDigibank + "text is not found");
			}

		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to verify welcome messages ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to verify welcome messages ", e);
		}
	}
	
	@Step("Handling of 'Welcome to digibank for Wealth Management' message ")
	public void HandlingWelcomeToDigibankForWealthManagement(String app_Name) throws Exception {
		try {
			if (app_Name.equalsIgnoreCase("iWEALTH") && isElementVisible2(managementAlertMsg)) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				int x2 = getXCoordinateOfElement(managementAlertMsg);
				int y2 = getYCoordinateOfElement(managementAlertMsg);
				int x1 = getXCoordinateOfElement(swipeButton);
				int y1 = getYCoordinateOfElement(swipeButton);
				gestUtils.swipeCoordinatetoCoordinate(x1, y1, x2, y2);
			} else if(app_Name.equalsIgnoreCase("iWEALTH") && isElementVisible2(GET_STARTED_Button)) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				clickOnElement(GET_STARTED_Button); 
			}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Handling of 'Welcome to digibank for Wealth Management' message  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Handling of 'Welcome to digibank for Wealth Management' message ", e);
		}
	}
	
	@Step("Swipe Location Alert")
	public void locationSwipPopup(String app_Name) throws Exception {
		try {
			if(app_Name.equalsIgnoreCase("DBS") && isElementVisible2(goToLocationSettingButton)) { 
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
//				Dimension windowSize1 = driver.manage().window().getSize();
//				int y =(int)((windowSize1.getHeight()));
//				int x =(int)((windowSize1.getWidth())/2);
				int x2 = getXCoordinateOfElement(goToLocationSettingButton);
				int y2 = getYCoordinateOfElement(goToLocationSettingButton);
				int x1 = getXCoordinateOfElement(swipeButton);
				int y1 = getYCoordinateOfElement(swipeButton);
				gestUtils.swipeCoordinatetoCoordinate(x1, y1, x2, y2);
			}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Swipe Location Alert Button  ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Swipe Location Alert Button ", e);
		}
	}

	@Step("Handling 'MOTION AND FITNESS ALERT' Alert")
	public void handlingMotionAndFitnessAlert() throws Exception
	{
		try {
			if(isElementVisible2(alertFitnessActivityTitle)) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				clickOnElement(OKButton);
			}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Handling MOTION AND FITNESS ALERT ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Handling MOTION AND FITNESS ALERT ", e);
		}
	}
	
	@Step("Click on Next Button while Confirming Email digital token")
	public void clickOnNextOnConfirmEmailDigiToken() throws Exception {
		try {
			if(isElementVisible2(confirmEmail)) 
			{
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				clickOnElement(nextButton);	
			}
		}
		catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Clicked on Next while Confirming Email digital token ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Clicked on Next while Confirming Email digital token", e);
		}
	}

	@Step("Digital Token Set Up")
	public void digitalToken() throws Exception {
		try {
			if (isElementVisible2(setupTokenMessage)) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				clickOnElement(setupNowButton);
				ClickOnContinueButton();
				clickOnNextOnConfirmEmailDigiToken();
				enterpasscode.EnterPasscodeAndDone();
				enterpasscode.EnterPasscodeAndDone();
				ClickOnDoneButton();
			}

		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to digital Token Setup ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to digital Token Setup ", e);
		}
	}
	
	@Step("Click On Continue Button.")
	public void ClickOnContinueButton()throws Exception{
		try {
			if(isElementVisible2(digitokeRegisterAlertMsg)) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				clickOnElement(continueButton);
			}
		}catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Continue Button ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Continue Button ", e);
		}
	}
	
	@Step("Click on Done Button")
	public void ClickOnDoneButton() throws Exception {
		try {
			if (isElementVisible2(youHaveSetTokenMessage))
				clickOnElement(DoneButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Done Button ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Done Button ", e);
		}
	}
	
	@Step("Handling Fingure Print Alert")
	public void handlingFingurePrintAlert() throws Exception {
		try {
			if (isElementVisible2(fingerpringAlertMessage)) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				clickOnElement(fingerpringAlertClosedButton);
			}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Handling Fingure Print Alert  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Handling Fingure Print Alert ", e);
		}
	}

	@Step("Handling Recording Alert")
	public void handlingRecordingAlert() throws Exception {
		try {
			if (isElementVisible2(recordingAlertClosedButton)) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				clickOnElement(recordingAlertClosedButton);
			}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Handling Recording Alert  ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Handling Recording Alert ", e);
		}
	}
	
	@Step("Click On logout Button")
	public void ClickOnLogOutButton(String app_Name) throws Exception {
		try {
			if(app_Name.equalsIgnoreCase("DBS")) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				clickOnElement(logOutButton);
			}
			else if(app_Name.equalsIgnoreCase("iWEALTH")) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				clickOnElement(logOutButtoniWealth);
			}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On logout Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On logout Button ", e);
		}
	}
	
	@Step("Verify Account Type , Account Name, Currency display and displayed Amount under Account Section")
	public void verifyAccountTypeNameCurrencyAmount(String AccountType, String AccountName, String currency,String app_Name)
			throws Exception {
		try {
			if(app_Name.equalsIgnoreCase("DBS"))
			{
			int x=getXCoordinateOfElement(welcomeToText);
			int y=getYCoordinateOfElement(welcomeToText);
			gestUtils.DragAndDropElementToCoordinate(accountSectionHomePage, x, y+150);
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			}
			else if(app_Name.equalsIgnoreCase("iWEALTH"))
			{
				int x=getXCoordinateOfElement(welcomeToTextIwealth);
				int y=getYCoordinateOfElement(welcomeToTextIwealth);
				gestUtils.DragAndDropElementToCoordinate(accountSectionHomePage, x, y+160);
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			}
			VerifyAccountType(AccountType);
			VerifyAccountName(AccountName);
			VerifyCurrency(currency);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Execute Account Details CASA ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Execute Account Details CASA ", e);
		}
	}
	
	@Step("Verify Account Type")
	public void VerifyAccountType(String AccountType) throws Exception {
		try {
			String xpath = "//XCUIElementTypeStaticText[@name='" + AccountType + "']";
			List<RemoteWebElement> list = driver.findElements(By.xpath(xpath));
			if (list.size() > 0)
				Asserts.assertEquals(getTexOfElement(depositeHomepage).trim().toLowerCase(), AccountType.toLowerCase(),
						AccountType + "text is not found");
			else
				Asserts.assertFail(AccountType + " is not displaying on home page.");

		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify Account Type ", e);
		}
	}

	@Step("Verify Account Name")
	public void VerifyAccountName(String AccountName) throws Exception {
		try {
			String xpath = "//XCUIElementTypeStaticText[@name='" + AccountName + "']";
			List<RemoteWebElement> list = driver.findElements(By.xpath(xpath));
			if (list.size() > 0)
				Asserts.assertEquals(getTexOfElement(accountNameHomepage).trim().toLowerCase(),
						AccountName.toLowerCase(), AccountName + "text is not found");
			else
				Asserts.assertFail(AccountName + " not displaying on home page.");

		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify Account Type ", e);
		}
	}
	
	@Step("Verify currency")
	public void VerifyCurrency(String currency) throws Exception {
		try {
			String fag = sgdHomepage.getText();
			String[] arrOfStr = fag.split(" ");
			Asserts.assertEquals(arrOfStr[0], currency, currency + " is not present");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verify currency", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify currency ", e);
		}
	}

}
