package com.crestech.pages.androidpage.more;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import com.crestech.annotation.values.ElementDescription;
import com.crestech.appium.utils.CommonAppiumTest;
import com.crestech.common.utilities.Asserts;
import com.crestech.common.utilities.CommonTestData;
import com.crestech.common.utilities.GestureUtils;
import com.crestech.common.utilities.HandleException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
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
	
	@ElementDescription(value = "Page Header")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/text')]")
	private MobileElement PageHeader;
	
	@ElementDescription(value = "Back Btn Image View")
	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,':id/back_btn')]")
	private MobileElement BackBtnImageView;
	
	@ElementDescription(value = "BACK TO MORE SERVICES Button")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='BACK TO MORE SERVICES']")
	private MobileElement BACKTOMoreServicesBtn;
	
	@ElementDescription(value = "Completion Status Image")
	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.dbs.sit1.dbsmbanking:id/iv_status_completion']")
	private MobileElement CompletionStatusImage;

	@ElementDescription(value = "Successfully Updated Message")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/text_transfer_result')]")
	private MobileElement SuccessfullyUpdatedMessageEle;
	
	@ElementDescription(value = "UPDATE MORE DETAILS Button.")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='UPDATE MORE DETAILS']")
	private MobileElement UpdateMoreDetailsBtn;
	
	@ElementDescription(value = "UPDATE MORE DETAILS Button.")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='UPDATE MAILING ADDRESS']")
	private MobileElement UpdateMailingAddressBtn;
	
	@ElementDescription(value = "back button")
	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,'id/back_btn')]")
	private MobileElement backButton;
	
	@ElementDescription(value = "Next button")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='NEXT']")
	private MobileElement nextButton;
	
	@ElementDescription(value = "Next button")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='CONFIRM']")
	private MobileElement confirmButton;
	
	@ElementDescription(value = "Contact Details Titles List.")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/tv_title_id')]")
	private List<MobileElement> ContactDetailsTitlesList;
	
	@ElementDescription(value = "Contact Details Values List.")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/tv_value_id')]")
	private List<MobileElement> ContactDetailsValuesList;
	
	@ElementDescription(value = "Terms And Conditions Msg.")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/tv_upp_ters_condns_label__id')]")
	private MobileElement TermsAndConditionsMsg;
	
	@ElementDescription(value = "Personal & Contact Details")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Personal & Contact Details']")
	private MobileElement PersonalAndContactDetailsTab;
	
	@ElementDescription(value = "Mailing Address")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Mailing Address']")
	private MobileElement MailingAddressTab;
	
	@ElementDescription(value = "Update Contact Details Page Header.")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/text_toolbar_title')]")
	private MobileElement UpdateContactDetailsPageHeader;
	
	@ElementDescription(value = "Contact Details Title.")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/tv_upp_cd_section_title_id')]")
	private MobileElement ContactDetailsTitle;
	
	@ElementDescription(value = "Email Notes.")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/tv_upp_email_notes_id')]")
	private MobileElement EmailNotes;
	
	@ElementDescription(value = "Contact Details Change Button.")
	@AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,':id/tv_upp_change_contact_details_btn_id')]")
	private MobileElement ContactDetailsChangeBtn;
	
	@ElementDescription(value = "Personal Perticular Change Button.")
	@AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,':id/tv_upp_change_personal_perticulars_btn_id')]")
	private MobileElement PersonalPerticularChangeBtn;
	
	@ElementDescription(value = "Personal Perticular Section Title.")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/tv_upp_pp_section_title_id')]")
	private MobileElement PersonalPerticularSectionTitle;
	
	@ElementDescription(value = "Marketing Message Title.")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/tv_upp_mm_section_title_i')]")
	private MobileElement MarketingMessageTitle;
	
	@ElementDescription(value = "Marketing Message Notes.")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/tv_upp_marketing_messages_notes_id')]")
	private MobileElement MarketingMessageNotes;
	
	@ElementDescription(value = "Upp Section Label.")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/tv_upp_section_label__id')]")
	private MobileElement UPPSectionLabel;

	

	@Step("Verify Contact Details Title")
	public void verifyContactDetailsTitle(String contactDetailsTitle) throws Exception {
		try {
			Asserts.assertEquals(getTexOfElement(ContactDetailsTitle), contactDetailsTitle, contactDetailsTitle + " Text is not matching");
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
			Asserts.assertEquals(getTexOfElement(EmailNotes), emailNotes, emailNotes + " Text is not matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verify Email Notes ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify Email Notes ", e);
		}
	}

	@Step("Verify Change Button Under Contact Details")
	public void verifyChangeButton(String ChangeButton) throws Exception {
		try {
			gestUtils.scrollUPtoObject("text", "PERSONAL PARTICULARS", PersonalPerticularSectionTitle);
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

	@Step("Verify Personal Particular")
	public void verifyPersonalParticular(String personalParticular) throws Exception {
		try {
			Asserts.assertEquals(getTexOfElement(PersonalPerticularSectionTitle), personalParticular,
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
			gestUtils.scrollUPtoObject("text", "MARKETING MESSAGES", MarketingMessageTitle);
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
			Asserts.assertEquals(getTexOfElement(MarketingMessageTitle), marketingMessageTitle,
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
			Asserts.assertEquals(getTexOfElement(MarketingMessageNotes), marketingMessageNotes,
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

			if (appName.equalsIgnoreCase("DBS"))
				gestUtils.scrollUPtoObject("text", "NEXT", nextButton);
			else if (appName.equalsIgnoreCase("iWEALTH"))
				gestUtils.scrollUPtoObject("text", "CONFIRM", confirmButton);

			verifyIWouldLikeTheBankTomessage(CommonTestData.IWOULD_LIKE_THEBANK_TO_MESSAGE.getEnumValue());
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify Personal Details Page  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify Personal Details Page ", e);
		}
	}

	@Step("Select Personal & Contact Details under Update Contact Details Page.")
	public void SelectPersonalContactDetails() throws Exception {
		try {
			clickOnElement(PersonalAndContactDetailsTab);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Select Personal & Contact Details under Update Contact Details Page ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Select Personal & Contact Details under Update Contact Details Page ", e);
		}
	}

	@Step("Verify 'Personal And Contact Details' on update Contact details Page. ")
	public void VerifyPersonalAndContactDetails() throws Exception {
		try {
			Asserts.assertTrue(isElementVisible(PersonalAndContactDetailsTab),"Personal And Contact Details Tab is not displayed.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION"," Failed to verify visibility of 'Personal And Contact Details'  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION"," Failed to verify visibility of 'Personal And Contact Details' ", e);
		}
	}

	@Step("Verify 'Mailing Address' on update Contact details Page. ")
	public void VerifyMailingAddress() throws Exception {
		try {
			Asserts.assertTrue(isElementVisible(MailingAddressTab),
					"Mailing Address Tab is not displayed.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION"," Failed to verify visibility of 'Mailing Address' ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION"," Failed to verify visibility of 'Mailing Address' ", e);
		}
	}
	
	@Step("Verify Terms & Conditions Message.")
	public void verifyTermsAndConditionsMessage(String termAndConditionsMessage, String appName) throws Exception {
		try {
			Asserts.assertEquals(getTexOfElement(TermsAndConditionsMsg), termAndConditionsMessage,
					termAndConditionsMessage + " Text is not matching");
			if (appName.equalsIgnoreCase("DBS"))
				gestUtils.scrollUPtoObject("text", "NEXT", nextButton);
			else if (appName.equalsIgnoreCase("iWEALTH"))
				gestUtils.scrollUPtoObject("text", "CONFIRM", confirmButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION"," Failed to Verify Terms & Conditions Message ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify Terms & Conditions Message ",e);
		}
	}

	@Step("Click on 'Call Me','SMS Me','Email Me','Fax Me','Mail Me'")
	public void ClickOnCheckboxes() throws Exception {
		try {
			String[] ExpectedTitles = new String[] { "Call Me", "SMS Me", "Email Me", "Fax Me", "Mail Me" };
			int j = 0;
			for (int i = 0; i < ContactDetailsTitlesList.size() && j < 5; i++) {
				String actualTitles = getTexOfElement(ContactDetailsTitlesList.get(i));
				if (actualTitles.equalsIgnoreCase(ExpectedTitles[j])) {
					Asserts.assertEquals(getTexOfElement(ContactDetailsTitlesList.get(i)),ExpectedTitles[j],
							ExpectedTitles[i] + " Titles is not matching in Personal Perticulars Section.");
					clickOnElement(ContactDetailsTitlesList.get(i));
					j++;
					i = 0;
				}
			}

		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to select All checkboxes  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to select All checkboxes  ", e);
		}
	}
	
	@Step("Verify Last Update Date Of Checkboxes.")
	public void VerifyLastUpdatedDateOfCheckboxes() throws Exception {
		try {
			Calendar calendar = Calendar.getInstance();
			Date today = calendar.getTime();
			DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
			String todayAsString = dateFormat.format(today);
			String ExpectedDate = todayAsString.replaceAll("-", " ");
			String ExpectedLastUpdatedDateValue = "Last updated on " + ExpectedDate;

			for (int i = 0; i < ContactDetailsValuesList.size(); i++) {
				Asserts.assertEquals(getTexOfElement(ContactDetailsValuesList.get(i)),
						ExpectedLastUpdatedDateValue,
						ExpectedLastUpdatedDateValue + " Dates is not matching after Updating Personal Details.");
			}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION"," Failed to verify last update on checkbox ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to verify last update on checkbox  ",e);
		}
	}

	@Step("Click On Confirm Button")
	public void ClickOnConfirmButton() throws Exception {
		try {
			gestUtils.scrollUPtoObject(null, null, null);
			if(isElementVisible2(confirmButton)) 
			clickOnElement(confirmButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to click on confirm button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to click on confirm button ", e);
		}
	}

	@Step("Click On Next Button.")
	public void ClickOnNextButton() throws Exception {
		try {
			if(isElementVisible2(nextButton)) {
				gestUtils.scrollUPtoObject("text", "NEXT", nextButton);
				clickOnElement(nextButton);			
			}else if(isElementVisible2(confirmButton)) {			
					gestUtils.scrollUPtoObject("text", "CONFIRM", confirmButton);
					clickOnElement(confirmButton);
			}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Next Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Next Button  ", e);
		}
	}

	@Step("Click On Back Button.")
	public void ClickOnBackButton() throws Exception {
		try {
			clickOnElement(backButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Back Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Back Button  ", e);
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
	
	@Step("Verify Successfully Updated Message")
	public void verifySuccessfullyUpdatedMessage(String appName) throws Exception {
		try {
			if (isElementVisible(CompletionStatusImage)) {
				if (appName.equalsIgnoreCase("DBS")) {
					Asserts.assertEquals(getTexOfElement(SuccessfullyUpdatedMessageEle),
							CommonTestData.SUCCESSFULLY_UPDATED_MESSAGE.getEnumValue(),
							CommonTestData.SUCCESSFULLY_UPDATED_MESSAGE.getEnumValue() + " Text is not matching");
					verifyUpdateMoreDetailsButton();
				} else if (appName.equalsIgnoreCase("iWEALTH")) {
					Asserts.assertEquals(getTexOfElement(SuccessfullyUpdatedMessageEle),
							CommonTestData.REQUESTS_SUBMITTED_MESSAGE.getEnumValue(),
							CommonTestData.REQUESTS_SUBMITTED_MESSAGE.getEnumValue() + " Text is not matching");
					verifyUpdateMailingAddressButton();
				}
				verifyBackToMoreServicesButton();
			}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify Successfully Updated Message ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify Successfully Updated Message ", e);
		}
	}
	
	@Step("Click On 'Back to More Services' Button.")
	public void ClickOnBackToMoreServicesBtn() throws Exception {
		try {
			clickOnElement(BACKTOMoreServicesBtn);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to click on Back toMore button  ",e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to click on Back toMore button  ", e);
		}
	}
	
	@Step("verify 'Back To More Services' Button")
	public void verifyBackToMoreServicesButton() throws Exception {
		try {
			Asserts.assertTrue(isElementVisible(BACKTOMoreServicesBtn),"BACK TO More Services Btn is not displayed.");
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
			Asserts.assertTrue(isElementVisible(BackBtnImageView), "Back Btn Image View is not displayed.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to verify visibility of 'Back Button Image View' ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to verify visibility of 'Back Button Image View' ", e);
		}
	}

	@Step("Verify 'Update Contact Details' page header")
	public void verifyUpdateContactDetailsPageHeader(String expectedText) throws Exception {
		try {
			wait.fluentWaitForElement(PageHeader);
			Asserts.assertEquals(getTexOfElement(PageHeader).toLowerCase(), expectedText.toLowerCase(),"'Header Title' is not Matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION", " Failed to verify 'Update Contact Details' page header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION", " Failed to verify 'Update Contact Details' page header ", e);
		}
	}
	
	@Step("Verify Personal And Contact Details Page Header")
	public void verifyPersonalContactDetailsPageHeader() throws Exception {
		try {
			if (getTexOfElement(UpdateContactDetailsPageHeader)
					.equals(CommonTestData.PERSONAL_AND_CONTACTDETAILS_PAGEHEADER.getEnumValue())) {
				wait.fluentWaitForElement(UpdateContactDetailsPageHeader);
				Asserts.assertEquals(getTexOfElement(UpdateContactDetailsPageHeader).toLowerCase(),
						CommonTestData.PERSONAL_AND_CONTACTDETAILS_PAGEHEADER.getEnumValue().toLowerCase(),
						"'Header Title' is not Matching");
			} else if (getTexOfElement(UpdateContactDetailsPageHeader)
					.equals(CommonTestData.CONTACT_DETAILS_PAGEHEADER.getEnumValue())) {
				wait.fluentWaitForElement(UpdateContactDetailsPageHeader);
				Asserts.assertEquals(getTexOfElement(UpdateContactDetailsPageHeader).toLowerCase(),
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
	
	
	
}
