package com.crestech.pages.iospage.paytransfer;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crestech.annotation.values.ElementDescription;
import com.crestech.appium.utils.CommonAppiumTest;
import com.crestech.common.utilities.Asserts;
import com.crestech.common.utilities.CommonTestData;
import com.crestech.common.utilities.GestureUtils;
import com.crestech.common.utilities.HandleException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

/**
 * @author Divya
 *
 */
public class overseasModule extends CommonAppiumTest{

	public AppiumDriver<RemoteWebElement> driver = null;
	HandleException obj_handleexception = null;
	GestureUtils gestUtils = null;
	
	public overseasModule(AppiumDriver<RemoteWebElement> driver) throws Exception {
		super(driver);
		try {
			this.driver = driver;
			obj_handleexception = new HandleException(null, null);
		    gestUtils = new GestureUtils(driver);
			PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@ElementDescription(value = "common list")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText")
	private List<MobileElement> commonList;
	
	@ElementDescription(value = "Select Fund Source")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Select Fund Source']")
	private MobileElement selectfundSource;
	
	@ElementDescription(value = "Primary source of fund")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Primary source of fund']")
	private MobileElement primarysourceOfFund;
	
	@ElementDescription(value = "ok button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='OK']")
	private MobileElement okButton;
	
	@ElementDescription(value = "Done button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Done']")
	private MobileElement doneButton;
	
	@ElementDescription(value = "Amount field in overseas")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='DBSRemittance_SenderAmount']")
	private MobileElement amountFieldInOversea;
	
	@ElementDescription(value = "exchange Rate")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Exchange Rate']")
	private MobileElement exchangeRate;
	
	@ElementDescription(value = "select account type")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'account type')]/following-sibling::XCUIElementTypeOther[1]")
	private MobileElement selectAccountType;

	@ElementDescription(value = "select purpose type")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'purpose')]/following-sibling::XCUIElementTypeOther[1]")
	private MobileElement selectPurposeType;
	
	@ElementDescription(value = "enter mobile no.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[contains(@value,'Mobile')]")
	private MobileElement enterMobileNo;
	
	@ElementDescription(value = "Transfer Overseas  header")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Transfer Overseas']")
	private MobileElement transferOverseaTitle;
	
	@ElementDescription(value = "Next Button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='NEXT']")
	private MobileElement nextButton;
	
	@ElementDescription(value = "Review Transfer")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Review Transfer']")
	private MobileElement reviewTransfer;
	
	@ElementDescription(value = "TRANSFER NOW button")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='TRANSFER NOW'])[1]")
	private MobileElement transferNowButton;
	
	@ElementDescription(value = "Transfer Submitted")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Transfer Submitted']")
	private MobileElement transferSubmittedLabel;
	
	@ElementDescription(value = "Expand Button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='icn arrow']")
	private MobileElement expandButton;
	
	@ElementDescription(value = "Reference No.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Reference No.']")
	private MobileElement referenceNo;
	
	@ElementDescription(value = "SHARE TRANSFER DETAILS btn")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='SHARE TRANSFER DETAILS']")
	private MobileElement shareTransferDetailButton;
	
	@ElementDescription(value = "close icon in oversea")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='close icon']")
	private MobileElement closeIconInOversea;
	
	@ElementDescription(value = "backbutton in Transfer Details label")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='DBSRemittance_CompletionCrossButton']")
	private MobileElement backButtontransferDetailLabel;
	
	@ElementDescription(value = "search icon in payAndtransfer")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Pay & Transfer']")
	private MobileElement searchBoxInPayAndTransfer;
	
	@ElementDescription(value = "Add oversea recipient when no recpient added")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton)[5]")
	private MobileElement AddNowRecipientBtn;

	@ElementDescription(value = "Add oversea recipient when  recpient added")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Add overseas recipient']")
	private MobileElement AddOverseasRecipientBtn;
	
	@ElementDescription(value = "'check DBSRemit Rate")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Check DBS Remit rates']")
	private MobileElement checkDBSRemitRate;
	
	@ElementDescription(value = "Search for a Location")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSearchField[@name='Search for a Location']")
	private MobileElement searchBoxforLocation;

	@ElementDescription(value = "country Element list")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText")
	private List<MobileElement> countryList;
	
	@ElementDescription(value = "currency Element list")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell/XCUIElementTypeStaticText)")
	private List<MobileElement> currencyList;
	
	@ElementDescription(value = "next Button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='NEXT']")
	private MobileElement NEXTButton;
	
	@ElementDescription(value = "bank Code")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='addPayee_AUD_BSB_textField']/XCUIElementTypeOther/XCUIElementTypeOther")
	private MobileElement bankCode;
	
	@ElementDescription(value = "Enter Recipient's Details title")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Enter Recipient')]")
	private MobileElement recipientDetailTitle;
	
	@ElementDescription(value = "Enter Recipient's Address editbox")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'ddress')]")
	private MobileElement recipientDetailAddress;
	
	@ElementDescription(value = "Enter Recipient's Account no. editbox")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell)[1]")
	private MobileElement recipientDetailAccountNumber;
	
	@ElementDescription(value = "Enter Recipient's Name editbox")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell)[2]")
	private MobileElement recipientDetailAccountName;
	
	@ElementDescription(value = "Enter Recipient's city editbox")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='In The City Of']")
	private MobileElement recipientDetailcity;
	
	@ElementDescription(value = "'Add Recipient Now' Button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='ADD RECIPIENT NOW']")//
	private MobileElement ADDRecipientNowButton;
	
	@ElementDescription(value = "Review Recipient's Details title")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Review Recipient')]")
	private MobileElement reviewRecipientDetailTitle;
	
	@ElementDescription(value = "You've added a recipient title")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'added a recipient')]")
	private MobileElement addedRecipientTitle;
	
	@ElementDescription(value = "Enter Recipient's city editbox")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='In The City Of']/parent::XCUIElementTypeTextView")
	private MobileElement recipientDetailcityEditBox;
	
	@ElementDescription(value = "Enter Recipient's Address editBox")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'ddress')]/parent::XCUIElementTypeTextView")
	private MobileElement recipientDetailAddressEditBox;
	
	@ElementDescription(value = "'Make A Transfer' Button After adding Payee")
	@FindBy(name = "MAKE A TRANSFER")
	private MobileElement makeTransferButton;
	
	@Step("Click on 'Close' Button.")
	public void ClickOnCloseButtonInOversea() throws Exception {
		try {
			wait.waitForElementToBeClickable(closeIconInOversea);
			clickOnElement(closeIconInOversea);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click on 'Close' Button  ",	e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click on 'Close' Button ", e);
		}
	}
	

	@Step("Verify 'Reference No. Field and its value' field and Verify 'MAKE A TRANSFER' Button After Expanding & Scrolling to the Page.")
	public void verifyReferenceFieldAndItsValue(String expectedText) throws Exception {
		try {
			clickOnExpandButton();
            gestUtils.scrollUPtoObjectIos("name", "Reference No.", null);
			Asserts.assertEquals(getTexOfElement(makeTransferButton).trim().toLowerCase(), CommonTestData.MAKE_TRANSFER.getEnumValue().toLowerCase(), CommonTestData.MAKE_TRANSFER.getEnumValue()+ " text is not matching");
			Asserts.assertEquals(getTexOfElement(referenceNo).trim().toLowerCase(), expectedText.toLowerCase(),expectedText + " text is not matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verify Reference Field Value ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify Reference Field Value  ", e);
		}
	}
	
	@Step("Verify 'You've added a recipient' Message")
	public void verifyYouHaveAddedMessage(String expectedText) throws Exception { 
		try {
			wait.fluentWaitForElement(addedRecipientTitle);
			Asserts.assertEquals(getTexOfElement(addedRecipientTitle).trim().toLowerCase(), expectedText.toLowerCase(),expectedText+ " text is not matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verify 'You've added a recipient' Message ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify 'You've added a recipient' Message ", e);
		}
	}
	
	@Step("Verify 'Review Recipient Details' page header")
	public void verifyReviewRecipientDetailsPageHeader(String expectedText) throws Exception {
		try {
			wait.fluentWaitForElement(reviewRecipientDetailTitle);
			Asserts.assertEquals(getTexOfElement(reviewRecipientDetailTitle).trim().toLowerCase(), expectedText.toLowerCase(),expectedText+ " text is not matching.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION", " Failed to Verify 'Review Recipient Details' page header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION", " Failed to Verify 'Review Recipient Details' page header ", e);
		}
	}
	
	@Step("clicking On 'ADD RECIPIENT NOW' button")
	public void ClickOnAddRecipientNowBtn() throws Exception {
		try {
			gestUtils.scrollUPtoObjectIos("name", "ADD RECIPIENT NOW", null);
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(ADDRecipientNowButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Add Recipient Now Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Add Recipient Now Button  ",e);
		}
	}
	
	@Step("Enter City")
	public void EnterCity(String text) throws Exception {
		try {
			
			if (isElementVisible2(recipientDetailcity)) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				clickOnElement(recipientDetailcity);
				enterTextInTextbox(recipientDetailcityEditBox, text);
				ClickOnDoneButton();
			}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Enter City ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Enter City  ", e);
		}
	}

	@Step("Enter Full Name")
	public void EnterFullName(String text) throws Exception {
		try {
			enterTextInTextbox(recipientDetailAccountName, text);
			ClickOnDoneButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Enter Full Name ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Enter Full Name ", e);
		}
	}
	
	@Step("Enter Account Number")
	public void EnterAccountNumber(String text) throws Exception {
		try {
			enterTextInTextbox(recipientDetailAccountNumber, text);
			ClickOnDoneButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Enter Account Number ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Enter Account Number ", e);
		}
	}
	
	@Step("Enter Address")
	public void EnterAddress(String text) throws Exception {
		try {
            clickOnElement(recipientDetailAddress);
			//Actions action = new Actions(driver);
			//action.sendKeys(recipientDetailAddress, text).build().perform();
            enterTextInTextbox(recipientDetailAddressEditBox, text);
			// sendTextWithKeypad(text);
			// enterTextInTextbox(IOShomePgaeObject.recipientDetailAddress(), text);
			ClickOnDoneButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Enter Address ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Enter Address ", e);
		}
	}
	
	@Step("Verify 'Enter Recipient Details' page header")
	public void verifyEnterRecipientDetailsPageHeader(String expectedText) throws Exception {
		try {
			wait.fluentWaitForElement(recipientDetailTitle);
			Asserts.assertEquals(getTexOfElement(recipientDetailTitle).trim().toLowerCase(), expectedText.toLowerCase(),expectedText + " text is not matching.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION", " Failed to Verify 'Overseas Transfer' page header  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION", " Failed to Verify 'Overseas Transfer' page header ", e);
		}
	}
	
	@Step("Enter Bank Code")
	public void EnterBankCode(String text) throws Exception {
		try {
			enterTextInTextbox(bankCode, text);
			ClickOnDoneButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Enter Bank Code ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Enter Bank Code ", e);
		}
	}
	
	
	@Step("Click On Next Button")
	public void ClickOnNEXTButton() throws Exception {
		try {
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(NEXTButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to click on next button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to click on next button ", e);
		}
	}
	
	@Step("Select Currency Type")
	public void SelectCurrencyType(String expectedCurrency) throws Exception {
		try {
			if (currencyList.size() > 0) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				int index = 0;
				String currencyFromList = null;
				for (int i = 0; i < currencyList.size(); i++) {
					currencyFromList = currencyList.get(i).getText();
					if (currencyFromList.equalsIgnoreCase(expectedCurrency)) {
						index++;
						clickOnElement(currencyList.get(i));
						break;
					}
				}
				if (index == 0)
					Asserts.assertFail("Currency Type " + expectedCurrency + " Not found in the list");
			} else
				Asserts.assertFail(expectedCurrency + " not found in the list as list size is 0");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Select Currency Type from list. ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select Currency Type from list ", e);
		}
	}

	@Step("Select Country")
	public void SelectCountry(String searchBoxData, String expectedCountry)
			throws Exception {
		try {
			clickOnElement(searchBoxforLocation);
			EnterTextThroughKeyboard(searchBoxData);

			if (countryList.size() > 0) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				int index = 0;
				String actualCountry = null;
				for (int i = 0; i < countryList.size(); i++) {
					actualCountry = countryList.get(i).getText();
					if (actualCountry.equalsIgnoreCase(expectedCountry)) {
						index++;
						clickOnElement(countryList.get(i));
						break;
					}
				}

				if (index == 0)
					Asserts.assertFail("Country " + expectedCountry + " No element found in the list.");
			} else
				Asserts.assertFail("Country " + expectedCountry + " not found in the list as list size is 0");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select Country", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Selecting Country", e);
		}
	}

	@Step("Enter Text Through Keyboard")
	public void EnterTextThroughKeyboard(String textToEnter) throws Exception {
		try {
			String enterText = textToEnter.toLowerCase();
			int length = enterText.length();
			for (int i = 0; i < length; i++) {
				String L = Character.toString(enterText.charAt(i));
				String U = Character.toString(enterText.toUpperCase().charAt(i));
				String lowerxpath = "//XCUIElementTypeKey[@name='" + L + "']";
				String upperxpath = "//XCUIElementTypeKey[@name='" + U + "']";
				List<RemoteWebElement> listLower = driver.findElements(By.xpath(lowerxpath));
				List<RemoteWebElement> listupper = driver.findElements(By.xpath(upperxpath));
				if (listLower.size() > 0)
					clickOnElement((MobileElement) listLower.get(0));
				else if (listupper.size() > 0)
					clickOnElement((MobileElement) listupper.get(0));
				else
					Asserts.assertFail("no elemet is present on keyboard");
			}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Enter Text Through Keyboard ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Enter Text Through Keyboard ", e);
		}
	}

//	@Step("Click On 'ADD RECIPIENT NOW' button under overseas")
//	public void SelectAddRecipientNowButtonUnderOverseas() throws Exception {
//		try {
//			wait.waitForElementVisibility(checkDBSRemitRate);
//			
//			if (isElementVisible2(AddOverseasRecipientBtn)) 
//				clickOnElement(AddOverseasRecipientBtn);
//			else
//				clickOnElement(AddNowRecipientBtn);
//
//		} catch (HandleException e) {
//			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On 'ADD RECIPIENT NOW' button under overseas  ", e);
//		} catch (Exception e) {
//			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On 'ADD RECIPIENT NOW' button under overseas ", e);
//		}
//	}
//	
	
	@Step("Click On 'ADD RECIPIENT NOW' button under overseas")
	public void SelectAddRecipientNowButtonUnderOverseas() throws Exception {
		try {
			wait.waitForElementVisibility(checkDBSRemitRate);
			String selector = "type == 'XCUIElementTypeStaticText' AND name == 'Add overseas recipient'  AND visible== 1 AND enabled=1 ";
			if (isElementVisible2((MobileElement) driver.findElement(MobileBy.iOSNsPredicateString(selector)))) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				driver.findElement(MobileBy.iOSNsPredicateString(selector)).click();
			} else {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				clickOnElement(AddNowRecipientBtn);
			}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Click On 'ADD RECIPIENT NOW' button under overseas  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Click On 'ADD RECIPIENT NOW' button under overseas ", e);
		}
	}
	
	@Step("Select EOTT")
	public void SelectEOTT() throws Exception {
		try {
			clickOnElement(searchBoxInPayAndTransfer);
			enterTextInTextbox(searchBoxInPayAndTransfer, CommonTestData.EOTTREMITTANCE_NAME.getEnumValue());
			pressKey(driver, Keys.ENTER);

			MobileElement ExpectedEottEle = (MobileElement) driver.findElement(By.name(CommonTestData.EOTTREMITTANCE_NAME.getEnumValue()));
		  
			if (wait.waitForElementToBeClickable2(ExpectedEottEle)) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				clickOnElement(ExpectedEottEle);
			}
			else
				Asserts.assertFail("EOTT " + CommonTestData.EOTTREMITTANCE_NAME.getEnumValue() + " Not Found corresponding to this user.");
		
		  
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to select EOTT  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to select EOTT  ", e);
		}
	}
	
	@Step("Back From Test Case")
	public void BackFromTestCase() throws Exception {
		try {
			ClickOnDBSRemittance_CompletionCrossButton();
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			ClickOnCloseIcon();
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Back From Test Case ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Back From Test Case ",e);
		}
	}

	@Step("Click On DBS Remittance Completion Cross Button.")
	public void ClickOnDBSRemittance_CompletionCrossButton() throws Exception {
		try {
			clickOnElement(backButtontransferDetailLabel);
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On DBS Remittance Completion Cross Button. ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On DBS Remittance Completion Cross Button. ",e);
		}
	}
	
	@Step("Click On Close Icon.")
	public void ClickOnCloseIcon() throws Exception {
		try {
			clickOnElement(closeIconInOversea);
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Close Icon. ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Close Icon. ",e);
		}
	}
	
	@Step("Click On Share Transfer Details Button")
	public void ClickOnShareTransferDetailsButton() throws Exception {
		try {
			gestUtils.scrollUPtoObjectIos("name", "SHARE TRANSFER DETAILS", null);
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(shareTransferDetailButton);	
		}catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION"," Failed to Click On Share Transfer Details Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION"," Failed to Click On Share Transfer Details Button ", e);
		}
	}
	
	@Step("click On Expand button")
	public void clickOnExpandButton() throws Exception {
		try {
			clickOnElement(expandButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On expand Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On expand Button ", e);
		}
	}
	
	@Step("Verifies Reference Number Text after clicking on Image Expand Button.")
	public void ClickOnImageExpandBtnAndVerifiesReferenceNumberText() throws Exception {
		try {
			clickOnExpandButton();
			gestUtils.scrollUPtoObjectIos("name", "Reference No.", null);
			Asserts.assertEquals(getTexOfElement(referenceNo).trim().toLowerCase(), CommonTestData.REFERENCE_NUMBER.getEnumValue().toLowerCase(),CommonTestData.REFERENCE_NUMBER.getEnumValue() + " Text is not matching.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Image Expand Button ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Image Expand Button ", e);
		}
	}
	
	@Step("Verifies Transfer Submitted Message")
	public void VerifiesTransferSubmittedMessage(String SuccessMsg) throws Exception {
		try {
			Asserts.assertEquals(getTexOfElement(transferSubmittedLabel).trim().toLowerCase(), SuccessMsg.toLowerCase(),SuccessMsg + " Text is not matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verify Transfer Submitted Message ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify Transfer Submitted Message ", e);
		}
	}
	
	@Step("Click on Transfer Now Button.")
	public void ClickOnTransferNowButton() throws Exception {
		try {
			gesture.scrollUPtoObjectIos("name", "TRANSFER NOW", null);	
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(transferNowButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click on transfer now Button ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click on transfer now Button ", e);
		}
	}
	
	@Step("Verify 'Review Transfer' page header")
	public void verifyReviewTransferPageHeader(String expectedText) throws Exception {
		try {
			wait.fluentWaitForElement(reviewTransfer);
			Asserts.assertEquals(getTexOfElement(reviewTransfer).trim().toLowerCase(), expectedText.toLowerCase(),expectedText+ " Page Header is not matching.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION", " Failed to Verify 'Review Transfer' page header  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION", " Failed to Verify 'Review Transfer' page header ", e);
		}
	}
	
	@Step("Click On Next Button")
	public void ClickOnNextButton() throws Exception {
		try {
			    com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				clickOnElement(nextButton);
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Next Button ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Next Button ",e);
		}
	}
	
	@Step("Select Additional Details if Required")
	public void SelectAdditionalDetails(String AccountType, String purpose, String MobileNo) throws Exception																										// Gifts""9999999990"
	{
		try {
			gestUtils.scrollUPtoObjectIos("name", "NEXT", null);

			if (isElementVisible2(selectAccountType))
				selectAccountType(AccountType);

			if (isElementVisible2(selectPurposeType))
				selectPurpose(purpose);

			if (isElementVisible2(enterMobileNo))
				EnterMobileNumber(MobileNo);

		}  catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select Additional Details ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION"," Failed to Select Additional Details ", e);
		}
	}
	
	@Step("Select purpose")
	public void selectPurpose(String ExpectedPurpose) throws Exception
	{
		try {
			clickOnPurpose();
			
			if (commonList.size() > 0) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				int index = 0;
				String ActualPurpose = null;
				for (int i = 0; i < commonList.size(); i++) {
					ActualPurpose = commonList.get(i).getText();
					if (ActualPurpose.contains(ExpectedPurpose)) {
						index++;
						clickOnElement(commonList.get(i));
						break;
					}
				}

				if (index == 0)
					Asserts.assertFail("Purpose " + ExpectedPurpose + " Not found in the list.");
				
				    wait.fluentWaitForElement(transferOverseaTitle);

			} else
				Asserts.assertFail("Purpose " + ExpectedPurpose + " not found in the list as list size is 0");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select Purpose ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select Purpose ", e);
		}
	}
	
	@Step("Click on Purpose Field")
	public void clickOnPurpose() throws Exception {
		try {
			clickOnElement(selectPurposeType);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click on Purpose Field ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click on Purpose Field ", e);
		}
	}
	
	
	@Step("Enter Mobile Number")
	public void EnterMobileNumber(String MobileNo) throws Exception {
		try {
			enterTextInTextbox(enterMobileNo, MobileNo);
			ClickOnDoneButton();
			wait.fluentWaitForElement(transferOverseaTitle);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Enter Mobile Number ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Enter Mobile Number ", e);
		}
	}
	
	@Step("Select Account Type")
	public void selectAccountType(String ExpectedAccountType) throws Exception// "Savings"
	{
		try {
			clickOnAccountType();
			
			int index = 0;
			if (commonList.size() > 0) {
				int l = commonList.size();
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				String ActualAccountType = null;
				for (int i = 0; i < l; i++) {
					ActualAccountType = commonList.get(i).getText();
					if (ActualAccountType.contains(ExpectedAccountType)) {
						index++;
						clickOnElement(commonList.get(i));
						break;
					}
				}
				if (index == 0)
					Asserts.assertFail("Account Type " + ExpectedAccountType + " Not found in the list.");
				
				wait.fluentWaitForElement(transferOverseaTitle);
			} else
				Asserts.assertFail("Account type " + ExpectedAccountType + " Not found in the list as list size is 0");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select Account Type ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select Account Type ", e);
		}
	}

	@Step("Click on Account Type")
	public void clickOnAccountType() throws Exception {
		try {
			clickOnElement(selectAccountType);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Account Type  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Account Type ", e);
		}
	}
	
	@Step("Press enter key after Entering Amount.")
	public void pressEnterKeyAfterEnteringAmount(String Amount) throws Exception {
		try {
			clickOnElement(amountFieldInOversea);
			enterTextInTextbox(amountFieldInOversea, Amount);
			ClickOnDoneButton();
			if (isElementVisible2(exchangeRate))
				Asserts.assertTrue(isElementVisible2(exchangeRate), "Exchange Rate is not visible");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Pressing Enter Key After Entering Amount ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Pressing Enter Key After Entering Amount ", e);
		}
	}
	
	@Step("click on Done button")
	public void ClickOnDoneButton() throws Exception {
		try {
			if (isElementVisible2(doneButton))
				clickOnElement(doneButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to click on Done button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to click on Done button ", e);
		}
	}

	
	// If User has multiple accounts then select fund source account
	@Step("Click on 'Select Fund Source' and Select Account")
	public void SelectSourceOfFund(String SelectedAccountName) throws Exception {
		try {

			if (isElementVisible2(selectfundSource)) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				clickOnSelectFundSource();

				int index = 0;
				String AccountNameList = null;
				for (int i = 0; i < commonList.size(); i++) {
					AccountNameList = commonList.get(i).getText();
					if (AccountNameList.contains(SelectedAccountName)) {
						index++;
						clickOnElement(commonList.get(i));
						break;
					}
				}
				if (index == 0)
					Asserts.assertFail("Select Fund Source " + SelectedAccountName
							+ " not found in the list to initiate the fund transfer");

			}
			handlingOfPrimarySourceOfFundPopup();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Selecting Overseas Payee ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Selecting Overseas Payee ", e);
		}
	}
	
	@Step("click on Select Fund Source")
	public void clickOnSelectFundSource() throws Exception {
		try {
			clickOnElement(selectfundSource);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select Fund Source Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select Fund Source Button ", e);
		}
	}
	
	@Step("Handle 'Primary Source Of Fund' Popup.")
	public void handlingOfPrimarySourceOfFundPopup() throws Exception {
		try {
			if(isElementVisible2(primarysourceOfFund)) {
				Asserts.assertEquals(getTexOfElement(primarysourceOfFund), CommonTestData.PRIMARY_SOURCE_ALERT_TITLE.getEnumValue(), "Message Not matching");
				ClickOnOKButton();
			}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Handle 'Primary Source Of Fund' Popup. ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Handle 'Primary Source Of Fund' Popup.  ", e);
		}
	}
	
	@Step("Click On OK Button.")
	public void ClickOnOKButton() throws Exception {
		try {
			clickOnElement(okButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On OK Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On OK Button   ", e);
		}
	}
	
	@Step("Select Overseas Payee.")
	public void SelectOverseaPayee(String valueSelectedFromList) throws Exception {
		try {
		    wait.waitForElementVisibility(checkDBSRemitRate);
			
			if (commonList.size() > 0) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				int index = 0;
				String OverseaRecipientList = null;
				for (int i = 0; i < commonList.size(); i++) {
					OverseaRecipientList = commonList.get(i).getText();
					if (OverseaRecipientList.contains(valueSelectedFromList)) {
						index++;
						clickOnElement(commonList.get(i));
						break;
					}
				}
				if (index == 0)
					Asserts.assertFail("Overseas Payee " + valueSelectedFromList
							+ " not found in the list to initiate the fund transfer");
			} else
				Asserts.assertFail("No Receipient found in the Overseas Payee list");

		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Selecting Overseas Payee ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Selecting Overseas Payee ", e);
		}
	}
	
}
