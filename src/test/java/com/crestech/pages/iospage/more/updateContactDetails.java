package com.crestech.pages.iospage.more;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
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
public class updateContactDetails extends CommonAppiumTest{

	public AppiumDriver<RemoteWebElement> driver = null;
	HandleException obj_handleexception = null;
	GestureUtils gestUtils = null;
	
	public updateContactDetails(AppiumDriver<RemoteWebElement> driver) throws Exception {
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
	
	@ElementDescription(value = "Update Contact Details")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Update Contact Details']")
	private MobileElement UpdateContactDetails;
	
	@ElementDescription(value = "Email Notes")
	@FindBy(name = "This email address provided will only be used for your iBanking/mobile banking transactions, eStatement(s) and marketing communication (if any)")
	private MobileElement EmailNotes;
	
	@ElementDescription(value = "CONTACT DETAILS Titles")
	@FindBy(name = "CONTACT DETAILS")
	private MobileElement ContactDetailsTitle;
	
	@ElementDescription(value = "ContactDetailsChangeBtn.")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='CHANGE'])[1]")
	private MobileElement ContactDetailsChangeBtn;
	
	@ElementDescription(value = "PERSONAL PARTICULARS")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='PERSONAL PARTICULARS']")
	private MobileElement PersonalPerticularSectionTitle;
	
	@ElementDescription(value = "PersonalPerticularChangeBtn")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='CHANGE'])[2]")
	private MobileElement PersonalPerticularChangeBtn;
	
	@ElementDescription(value = "MarketingMessageTitle")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='MARKETING MESSAGES']")
	private MobileElement MarketingMessageTitle;
	
	@ElementDescription(value = "I have read and agree to these important terms.")
	@FindBy(name = "I have read and agree to these important terms.")
	private MobileElement TermsAndConditionsMsg;
	
	@ElementDescription(value = "MarketingMessageNotes")
	@FindBy(name = "Please indicate your preference if you would like to opt in or out of receiving DBS/POSB marketing materials and information relating to services and/or products offered or distributed by DBS/POSB and/or its services and product providers.")
	private MobileElement MarketingMessageNotes;
	
	@ElementDescription(value = "I would like the bank to:")
	@FindBy(name = "I would like the bank to:")
	private MobileElement UPPSectionLabel;
	
	@ElementDescription(value = "UPDATE MORE DETAILS Button.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='UPDATE MORE DETAILS']")
	private MobileElement UpdateMoreDetailsBtn;
	
	@ElementDescription(value = "TRANSFER NOW button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='UPDATE MAILING ADDRESS']")
	private MobileElement UpdateMailingAddressBtn;
	
	@ElementDescription(value = "Successfully submitted.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Successfully Submitted']")
	private MobileElement SuccessfullyUpdated;
	
	@ElementDescription(value = "Contact Details")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Contact Details']")
	private MobileElement ContactDetails;
	
	@ElementDescription(value = "Requests submitted")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Requests submitted']")
	private MobileElement RequestsSubmitted;
	
	@ElementDescription(value = "CAllMeCheckbox")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Call')]")
	private MobileElement CAllMeCheckbox;
	
	@ElementDescription(value = "SMS MeCheckbox")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'SMS')]")
	private MobileElement SMSMeCheckbox;
	
	@ElementDescription(value = "EMAIL MeCheckbox")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Email')]")
	private MobileElement EMAILMeCheckbox;
	
	@ElementDescription(value = "Fax MeCheckbox")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Fax')]")
	private MobileElement FAxMeCheckbox;
	
	@ElementDescription(value = "MAIL MeCheckbox")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Mail')]")
	private MobileElement MAILMeCheckbox;
	
	@ElementDescription(value = "Update Contact Details")
	@FindBy(name = "Update Contact Details")
	private MobileElement UpdateContactDetailsPageHeader;
	
	@ElementDescription(value = "Mailing Address")
	@FindBy(name = "Mailing Address")
	private MobileElement MailingAddressTab;
	
	@ElementDescription(value = "Personal & Contact Details")
	@FindBy(name = "Personal & Contact Details")
	private MobileElement PersonalAndContactDetailsTab;
	
	@ElementDescription(value = "Personal & Contact Details")
	@FindBy(name = "//XCUIElementTypeStaticText[@name='Personal & Contact Details']")
	private MobileElement PersonalAndContactDetails;
	
	@ElementDescription(value = "Update Contact Details")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Update Contact Details']")
	private MobileElement UpdateContactDetails1;
	
	@ElementDescription(value = "back button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='back']")
	private MobileElement backButton;
	
	@ElementDescription(value = "'BACK TO MORE SERVICES' Button.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='BACK TO MORE SERVICES']")
	private MobileElement BackToMoreServicesButton;
	
	@ElementDescription(value = " 'backToMoreButton' button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='BACK TO MORE']")
	private MobileElement backToMoreButton;
	
	@ElementDescription(value = "'Back' Button to Coming Out Added Payee Detils.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='back']")
	private MobileElement BackBtn;
	
	@Step("Click On Next Button")
	public void ClickOnNextButton() throws Exception {
		try {
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			List<RemoteWebElement> NEXT_Button = driver.findElements(By.name("NEXT"));
			List<RemoteWebElement> nextBtn = driver.findElements(By.name("Next"));
			List<RemoteWebElement> confirmBtn = driver.findElements(By.name("CONFIRM"));
			if (NEXT_Button.size() > 0)
				clickOnElement((MobileElement) NEXT_Button.get(1));
			else if (nextBtn.size() > 0)
				clickOnElement((MobileElement) nextBtn.get(1));
			else if (confirmBtn.size() > 0) 
				 clickOnElement((MobileElement) confirmBtn.get(1));

		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Next Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Next Button  ", e);
		}
	}
	
	@Step("Click On Back Button.")
	public void ClickOnBackButton() throws Exception {
		try {
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(BackBtn);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Back Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Back Button  ", e);
		}
	}
	
	@Step("Verify 'Update Contact Details' page header")
	public void verifyUpdateContactDetailsPageHeader(String expectedText) throws Exception {
		try {
			if(isElementVisible2(UpdateContactDetails))
				Asserts.assertEquals(getTexOfElement(UpdateContactDetails).toLowerCase() ,expectedText.toLowerCase(),expectedText + " Page Header not displaying.");
			else
				Asserts.assertEquals(getTexOfElement(UpdateContactDetails1).toLowerCase() ,expectedText.toLowerCase(),expectedText + " Page Header not displaying.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION", " Failed to verify 'Update Contact Details' page header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION", " Failed to verify 'Update Contact Details' page header ", e);
		}
	}

	@Step("click 'BACK TO MORE' BUTTON ")
	public void ClickOnBackToMoreServicesButton(String appName) throws Exception {
		try {
			if (appName.equalsIgnoreCase("iWEALTH")) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				clickOnElement(backToMoreButton);
			} else if (appName.equalsIgnoreCase("DBS")) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				clickOnElement(BackToMoreServicesButton);
			}
		}catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to click 'BACK TO MORE' BUTTON ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to click 'BACK TO MORE' BUTTON ", e);
		}
	}
	
	@Step("verify 'Back To More Services' Button")
	public void verifyBackToMoreButton() throws Exception {
		try {
			Asserts.assertTrue(isElementVisible2(backToMoreButton),"BACK TO More Services Btn is not displayed.");
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
			Asserts.assertTrue(isElementVisible2(BackToMoreServicesButton),"BACK TO More Services Btn is not displayed.");
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
			Asserts.assertTrue(isElementVisible2(backButton), "Back Btn Image View is not displayed.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to verify visibility of 'Back Button Image View' ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to verify visibility of 'Back Button Image View' ", e);
		}
	}
	
	@Step("Verify Change Button Under Personal Particular Section")
	public void verifyChangeButtonUnderPersonalParticularSection(String ChangeButton) throws Exception {
		try {
			gestUtils.scrollUPtoObjectIos("name", "MARKETING MESSAGES", null);
			Asserts.assertEquals(getTexOfElement(PersonalPerticularChangeBtn),
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
			Asserts.assertEquals(getTexOfElement(MarketingMessageTitle).toLowerCase(), marketingMessageTitle.toLowerCase(),
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
			gestUtils.scrollUPtoObjectIos("name", "I would like the bank to:", null);
			String selector = "type == 'XCUIElementTypeStaticText' AND name == 'Please indicate your preference if you would like to opt in or out of receiving DBS/POSB marketing materials and information relating to services and/or products offered or distributed by DBS/POSB and/or its services and product providers.'";
			String actualText = driver.findElement(MobileBy.iOSNsPredicateString(selector)).getText();
			Asserts.assertEquals(actualText.toLowerCase(), marketingMessageNotes.toLowerCase(),
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
			gestUtils.scrollUPtoObjectIos("name", "I would like the bank to:", null);
			Asserts.assertEquals(getTexOfElement(UPPSectionLabel), message,
					message + " Text is not matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify 'I would like the bank to:' Message ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify 'I would like the bank to:' Message ", e);
		}
	}
	
	@Step("Verify Personal Particular")
	public void verifyPersonalParticular(String personalParticular) throws Exception {
		try {
			Asserts.assertEquals(getTexOfElement(PersonalPerticularSectionTitle).toLowerCase(), personalParticular.toLowerCase(),
					personalParticular + " Text is not matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verify Personal Particular ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify Personal Particular ", e);
		}
	}

	@Step("Verify Change Button Under Contact Details")
	public void verifyChangeButton(String ChangeButton) throws Exception {
		try {
			gestUtils.scrollUPtoObject("name", "PERSONAL PARTICULARS", null);
			Asserts.assertEquals(getTexOfElement(ContactDetailsChangeBtn),
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
	
	@Step("Verify Contact Details Title")
	public void verifyContactDetailsTitle(String contactDetailsTitle) throws Exception {
		try {
			Asserts.assertEquals(getTexOfElement(ContactDetailsTitle).toLowerCase(), contactDetailsTitle.toLowerCase(), contactDetailsTitle + " Text is not matching");
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
			String selector = "type == 'XCUIElementTypeStaticText' AND name == 'This email address provided will only be used for your iBanking/mobile banking transactions, eStatement(s) and marketing communication (if any)'";
			String actualText = driver.findElement(MobileBy.iOSNsPredicateString(selector)).getText();
			Asserts.assertEquals(actualText.toLowerCase(), emailNotes.toLowerCase(),
					emailNotes + " Text is not matching");
			// Asserts.assertEquals(getTexOfElement(EmailNotes).toLowerCase(),
			// emailNotes.toLowerCase(), emailNotes + " Text is not matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verify Email Notes ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify Email Notes ", e);
		}
	}
	
	@Step("Verify visibility of 'Contact Details' &  'Personal Perticulars' Section.")
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
			Asserts.assertEquals(getTexOfElement(TermsAndConditionsMsg), termAndConditionsMessage,
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
	
	@Step("Verify Successfully Updated Message")
	public void verifySuccessfullyUpdatedMessage(String appName) throws Exception {
		try {
		
				if (appName.equalsIgnoreCase("DBS")) {
					Asserts.assertEquals(getTexOfElement(SuccessfullyUpdated),
							CommonTestData.SUCCESSFULLY_SUBMITTED_MESSAGE.getEnumValue(),
							CommonTestData.SUCCESSFULLY_SUBMITTED_MESSAGE.getEnumValue() + " Text is not matching");
					verifyUpdateMoreDetailsButton();
					verifyBackToMoreServicesButton();
				} else if (appName.equalsIgnoreCase("iWEALTH")) {
					Asserts.assertEquals(getTexOfElement(RequestsSubmitted),
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
			Asserts.assertTrue(isElementVisible(UpdateMailingAddressBtn),"Update Mailing Address Btn is not displayed.");
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
			Asserts.assertTrue(isElementVisible(UpdateMoreDetailsBtn),"Update More Details Btn is not displayed.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to verify Update More Details Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to verify Update More Details Button ",
					e);
		}
	}
	
	@Step("Verify Personal And Contact Details Page Header")
	public void verifyPersonalContactDetailsPageHeader() throws Exception {
		try {

			if (isElementVisible2(ContactDetails))
				Asserts.assertEquals(getTexOfElement(ContactDetails).toLowerCase(),
						CommonTestData.CONTACT_DETAILS_PAGEHEADER.getEnumValue().toLowerCase(),
						"'Header Title' is not Matching");

		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION",
					" Failed to Verify Personal And Contact Details Page Header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION",
					" Failed to Verify Personal And Contact Details Page Header ", e);
		}
	}
	
	@Step("Verify 'Mailing Address' on update Contact details Page. ")
	public void VerifyMailingAddress() throws Exception {
		try {
			Asserts.assertTrue(isElementVisible2(MailingAddressTab),
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
			Asserts.assertTrue(isElementVisible2(PersonalAndContactDetailsTab),"Personal And Contact Details Tab is not displayed.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION"," Failed to verify visibility of 'Personal And Contact Details'  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION"," Failed to verify visibility of 'Personal And Contact Details' ", e);
		}
	}
	
	@Step("Select Personal & Contact Details under Update Contact Details Page.")
	public void SelectPersonalContactDetails() throws Exception {
		try {
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(PersonalAndContactDetailsTab);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Select Personal & Contact Details under Update Contact Details Page ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Select Personal & Contact Details under Update Contact Details Page ", e);
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
			
			String ActualLastUpdatedDateValue = getTexOfElement(CAllMeCheckbox);
			String checkboxarry[] =  ActualLastUpdatedDateValue.split("Last");
			ExpectedLastUpdatedDateValue = checkboxarry[0] + "Last Updated on " + ExpectedDate;
			
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
			
			String ActualLastUpdatedDateValue = getTexOfElement(SMSMeCheckbox);
			String checkboxarry[] =  ActualLastUpdatedDateValue.split("Last");
			ExpectedLastUpdatedDateValue = checkboxarry[0] + "Last Updated on " + ExpectedDate;
		    
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
			
			String ActualLastUpdatedDateValue = getTexOfElement(EMAILMeCheckbox);
			String checkboxarry[] =  ActualLastUpdatedDateValue.split("Last");
			ExpectedLastUpdatedDateValue = checkboxarry[0] + "Last Updated on " + ExpectedDate;
		  
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
			
			String ActualLastUpdatedDateValue = getTexOfElement(FAxMeCheckbox);
			String checkboxarry[] =  ActualLastUpdatedDateValue.split("Last");
			ExpectedLastUpdatedDateValue = checkboxarry[0] + "Last Updated on " + ExpectedDate;
		 
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
			
			String ActualLastUpdatedDateValue = getTexOfElement(MAILMeCheckbox);
			String checkboxarry[] =  ActualLastUpdatedDateValue.split("Last");
			ExpectedLastUpdatedDateValue = checkboxarry[0] + "Last Updated on " + ExpectedDate;
		   
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
				clickOnElement(CAllMeCheckbox);
			} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select Call me Checkbox ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select Call me Checkbox ", e);
		}
	}
	
	@Step("Select SMS me Checkbox.")
	public void ClickOnSMSMeCheckbox() throws Exception {
		try {
				clickOnElement(SMSMeCheckbox);
			} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select SMS me Checkbox ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select SMS me Checkbox ", e);
		}
	}
	
	@Step("Select EMAIL me Checkbox.")
	public void ClickOnEMAILMeCheckbox() throws Exception {
		try {
				clickOnElement(EMAILMeCheckbox);
			} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select EMAIL me Checkbox ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select EMAIL me Checkbox ", e);
		}
	}
	
	@Step("Select MAIL me Checkbox.")
	public void ClickOnMAILMeCheckbox() throws Exception {
		try {
				clickOnElement(MAILMeCheckbox);
			} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select MAIL me Checkbox ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select MAIL me Checkbox ", e);
		}
	}
	
	@Step("Select FAX me Checkbox.")
	public void ClickOnFAXMeCheckbox() throws Exception {
		try {
				clickOnElement(FAxMeCheckbox);
			} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select FAX me Checkbox ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select FAX me Checkbox ", e);
		}
	}
	
}
