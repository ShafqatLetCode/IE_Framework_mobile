package com.crestech.pages.iospage.more;

import java.time.Duration;
import java.util.List;

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
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

/**
 * @author Divya
 *
 */
public class cardsModule extends CommonAppiumTest{

	public AppiumDriver<RemoteWebElement> driver = null;
	HandleException obj_handleexception = null;
	GestureUtils gestUtils = null;
	
	public cardsModule(AppiumDriver<RemoteWebElement> driver) throws Exception {
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
	
	@ElementDescription(value = "'Debit Card' Button.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Debit Card']")
	private MobileElement SelectDebitCard;
	
	@ElementDescription(value = "'Debit Card Dropdown list'.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell//XCUIElementTypeStaticText")
	private List<MobileElement> DebitCardDetailsDropdownList;
	
	@ElementDescription(value = "'Send me DBS Promotion via Email' Checkbox.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Email']")
	private MobileElement SendMeDBSPrmotionViaMail;
	
	@ElementDescription(value = "'Account to be linked to the card' Dropdown.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Account to be linked to the card']/XCUIElementTypeOther")
	private MobileElement AccountToBeLinkedToTheCardField;
	
	@ElementDescription(value = "'Title' Dropdown.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Title']/XCUIElementTypeOther")
	private MobileElement TitleField;
	
	@ElementDescription(value = "'Annual Income' Dropdown.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Annual Income']/XCUIElementTypeOther")
	private MobileElement AnnualIncomeField;
	
	@ElementDescription(value = "Done button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Done']")
	private MobileElement doneButton;
	
	@ElementDescription(value = "'nameOnCard' Field.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='nameOnCard']/XCUIElementTypeOther")
	private MobileElement EnterNameToAppearOnTheCardField;
	
	@ElementDescription(value = "'Race' Dropdown.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Race']/XCUIElementTypeOther")
	private MobileElement RaceField;
	
	@ElementDescription(value = "'Marital Status' Dropdown.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Marital Status']/XCUIElementTypeOther/XCUIElementTypeTextField")
	private MobileElement MaritalStatusField;
	
	@ElementDescription(value = "'Residence Type' Dropdown.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Residence Type']/XCUIElementTypeOther")
	private MobileElement ResidentialTypeField;
	
	@ElementDescription(value = "'Education' Dropdown.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Education']/XCUIElementTypeOther")
	private MobileElement EducationField;
	
	@ElementDescription(value = "'Economic Status' Dropdown.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Economic Status']/XCUIElementTypeOther")
	private MobileElement EconomicStatusField;
	
	@ElementDescription(value = "next Button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='NEXT']")
	private MobileElement NEXTButton;
	
	@ElementDescription(value = "next Button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Next']")
	private MobileElement nextButton;
	
	@ElementDescription(value = "'Review Application' Page Header.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Review Application']")
	private MobileElement ReviewApplicationPageHeader;
	
	@ElementDescription(value = "'Set Card PIN' Page Header.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Set Card PIN']")
	private MobileElement SetCardPINPageHeader;
	
	@ElementDescription(value = "'Create Your PIN' Page Header.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Create Your PIN']/parent::XCUIElementTypeOther")
	private MobileElement CreateYourPINField;
	
	@ElementDescription(value = "'Confirm New PIN' Page Header.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Confirm New PIN']/parent::XCUIElementTypeOther")
	private MobileElement ConfirmNewPINField;
	
	@ElementDescription(value = "'Submit' Button.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='SUBMIT']")
	private MobileElement submitButton;
	
	@ElementDescription(value = "'Application Submitted' Message.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Application Submitted']")
	private MobileElement ApplicationSubmittedMessage;
	
	@ElementDescription(value = "'BACK TO MORE SERVICES' Button.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='BACK TO MORE SERVICES']")
	private MobileElement BackToMoreServicesButton;
	
	@ElementDescription(value = "'Close' Button After adding Payee")
	@FindBy(name = "close")
	private MobileElement closeButton;
	
	@ElementDescription(value = "Log Out Button After adding Payee")
	@FindBy(name = "Log Out")
	private MobileElement LogoutBtn;
	
	@ElementDescription(value = "'Thank you for your application. Your application is being processed.' Message.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Thank you for your application. Your application is being processed.']")
	private MobileElement ThankYouMessage;
	
	@Step("Verify Set Card PIN Page Header")
	public void VerifySetCardPINPageHeader() throws Exception {
		try {
			Asserts.assertTrue(isElementVisible(SetCardPINPageHeader),
					CommonTestData.SET_CARD_PIN.getEnumValue() + " Page Header not displaying.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXEPTION"," Failed to Verify Set Card PIN Page Header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXEPTION", " Failed to Verify Set Card PIN Page Header ", e);
		}
	}
	
	@Step("Verify Back To More Services Button")
	public void verifyBackToMoreServicesButton() throws Exception {
		try {
			Asserts.assertTrue(BackToMoreServicesButton.isDisplayed(), "'Back To More Services' Button not found.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to verify Back To More Services button.", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to verify Back To More Services button. ", e);
		}
	}
	
	@Step("Click on 'Close' Button.")
	public void ClickOnCloseButton() throws Exception {
		try {
				clickOnElement(closeButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Click on 'Close' Button  ",	e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Click on 'Close' Button ", e);
		}
	}
	
	@Step("Verify LogOut Button")
	public void verifyLogOutButton() throws Exception {
		try {
			Asserts.assertTrue(LogoutBtn.isDisplayed(), "Log Out Button not found.");
		}catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to verify log out button.",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to verify log out button. ",e);
		}
	}
	
	@Step("Verify Close Button")
	public void verifyCloseButton() throws Exception {
		try {
			Asserts.assertTrue(closeButton.isDisplayed(), "Close Button not found.");
		}catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to verify Close button.",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to verify Close button. ",e);
		}
	}
	
	@Step("Set debit card PIN.")
	public void SetDebitCardPin(String createPin, String ConfirmPin) throws Exception {
		try {
			enterTextInTextbox(CreateYourPINField, CommonTestData.CREATE_PIN.getEnumValue());
			ClickOnDoneButton();
			
			enterTextInTextbox(ConfirmNewPINField, CommonTestData.CONFIRM_PIN.getEnumValue());
			ClickOnDoneButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXEPTION", " Failed to Set card PIN ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXEPTION", " Failed to Set card PIN ", e);
		}
	}
	
	@Step("Verify Application Submitted Message")
	public void VerifyApplicationSubmittedMessage() throws Exception {
		try {
			Asserts.assertTrue(isElementVisible2(ApplicationSubmittedMessage),
					CommonTestData.APPLICATION_SUBMITTED.getEnumValue() + " Page Header not displaying.");
			Asserts.assertTrue(ThankYouMessage.isDisplayed(),CommonTestData.THANKU_MESSAGE_AFTER_APPLYDEBITCARD.getEnumValue() + " not found.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXEPTION", " Failed to Verify Application Submitted Message ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXEPTION", " Failed to Verify Application Submitted Message ", e);
		}
	}
	
	@Step("Click on Submit Button")
	public void ClickOnSubmitButton() throws Exception {
		try {
			clickOnElement(submitButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXEPTION", " Failed to Click On Submit Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXEPTION", " Failed to Click On Submit Button ", e);
		}
	}
	
	@Step("Click On Next Button")
	public void ClickOnNextButton() throws Exception {
		try {
			gestUtils.scrollUPtoObjectIos("name", "NEXT", null);
			clickOnElement(nextButton);
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to click on next button ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to click on next button ",e);
		}
	}
	
	@Step("Select Debit card Type")
	public void selectDebitCardType(String expectedDebitCard) throws Exception {
		try {
			wait.fluentWaitForElement(DebitCardDetailsDropdownList.get(0));
			if (isElementVisible2(DebitCardDetailsDropdownList.get(0))) {
				int index = 0;
				String actualDebitCard = null;
				for (int i = 0; i < DebitCardDetailsDropdownList.size(); i++) {
					actualDebitCard = DebitCardDetailsDropdownList.get(i).getText();
					if (actualDebitCard.contains(expectedDebitCard)) {
						index++;
						clickOnElement(DebitCardDetailsDropdownList.get(i));
						break;
					}
				}
				if (index == 0)
					Asserts.assertFail("Debit Card Type " + expectedDebitCard + " Not found in the list.");
			} else
				Asserts.assertFail(expectedDebitCard + " not found in the list as list size is 0");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("ELEMENTNOTINLIST_EXCEPTION",
					" Failed to Select Debit card type:: " + expectedDebitCard, e);
		} catch (Exception e) {
			obj_handleexception.throwException("ELEMENTNOTINLIST_EXCEPTION",
					" Failed to Select Debit card type " + expectedDebitCard, e);
		}
	}
	
	@Step("Select Debit Card")
	public void SelectDebitCard() throws Exception {
		try {
			clickOnElement(SelectDebitCard);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select Debit Card ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select Debit Card ", e);
		}
	}
	
	@Step("Click On 'Account To Be Linked To The Card' Field")
	public void ClickOnAccountToBeLinkedToTheCardField() throws Exception {
		try {
			clickOnElement(AccountToBeLinkedToTheCardField);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Click On 'Account To Be Linked To The Card' Field ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Click On 'Account To Be Linked To The Card' Field ", e);
		}
	}
	
	@Step("Select Account Linked With Debit Card")
	public void SelectAccountLinkedWithDebitCard(String linkedAccount) throws Exception {
		try {
			selectElementFromTheGivenList(DebitCardDetailsDropdownList,
					linkedAccount ," Account Linked With Debit Card");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Select Account Linked With Debit Card ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Select Account Linked With Debit Card ", e);
		}
	}
	
	@Step("Enter Name To Appear On The Card")
	public void EnterNameToAppearOnTheCard(String Name) throws Exception {
		try {
			clickOnElement(EnterNameToAppearOnTheCardField);
			enterTextInTextbox(EnterNameToAppearOnTheCardField, Name);
			ClickOnDoneButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On 'Title' Field ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On 'Title' Field ", e);
		}
	}
	
	@Step("click on done button")
	public void ClickOnDoneButton() throws Exception {
		try {
			if (isElementVisible2(doneButton))
			clickOnElement(doneButton); 
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Done Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Done Button ", e);
		}
	}
	
	public void selectElementFromTheGivenList(List<MobileElement> elementList, String elementToBeSelected,
			String ElementName) throws Exception {
		try {
			int index = 0;
			String accountFromList = null;
			if (elementList.size() > 0) {
				for (int i = 0; i <= elementList.size(); i++) {
					accountFromList = elementList.get(i).getText();
					if (accountFromList.contains(elementToBeSelected)) {
						index++;
						clickOnElement(elementList.get(i));
						break;
					}
				}

				if (index == 0)
					Asserts.assertFail("The " + ElementName + " " + elementToBeSelected + " Not found in the list.");
			} else
				Asserts.assertFail(
						"The " + ElementName + " " + elementToBeSelected + " not found in the list as list size is 0");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("ELEMENTNOTINLIST_EXCEPTION",
					" Failed to select the " + ElementName + " " + elementToBeSelected + " from the list", e);
		} catch (Exception e) {
			obj_handleexception.throwException("ELEMENTNOTINLIST_EXCEPTION",
					" Failed to select the " + ElementName + " " + elementToBeSelected + " from the list ", e);
		}
	}
	
	@Step("Click On 'Title' Field")
	public void ClickOnTitleField() throws Exception {
		try {
			clickOnElement(TitleField);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On 'Title' Field ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On 'Title' Field ", e);
		}
	}
	
	@Step("Select Title")
	public void SelectTitle(String title) throws Exception {
		try {
			selectElementFromTheGivenList(DebitCardDetailsDropdownList, title, "Title");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select Title ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select Title ", e);
		}
	}
	
	@Step("Click On 'Race' Field")
	public void ClickOnRaceField() throws Exception {
		try {
			gestUtils.scrollUPtoObjectIos("name", "Education", null);
			clickOnElement(RaceField);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On 'Race' Field ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On 'Race' Field ", e);
		}
	}
	
	@Step("Select Race")
	public void SelectRace(String race) throws Exception {
		try {
			selectElementFromTheGivenList(DebitCardDetailsDropdownList, race, "Race");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select Race ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select Race ", e);
		}
	}
	
	@Step("Click On 'Marital Status' Field")
	public void ClickOnMaritalStatusField() throws Exception {
		try {
			clickOnElement(MaritalStatusField);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Click On 'Marital Status' Field ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On 'Marital Status' Field ",
					e);
		}
	}
	
	@Step("Select Marital Status")
	public void SelectMaritalStatus(String MaritalStatus) throws Exception {
		try {
			selectElementFromTheGivenList(DebitCardDetailsDropdownList, MaritalStatus, "Marital Status");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select Marital Status ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select Marital Status ", e);
		}
	}
	
	@Step("Click On 'Residential Type' Field")
	public void ClickOnResidentialTypeField() throws Exception {
		try {
			clickOnElement(ResidentialTypeField);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Click On 'Residential Type' Field ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On 'Residential Type' Field ",
					e);
		}
	}

	@Step("Click On 'Education' Field")
	public void ClickOnEducationField() throws Exception {
		try {
			clickOnElement(EducationField);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On 'Education' Field ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On 'Education' Field ", e);
		}
	}

	@Step("Click On 'Economic Status' Field")
	public void ClickOnEconomicStatusField() throws Exception {
		try {
			clickOnElement(EconomicStatusField);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Click On 'Economic Status' Field ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On 'Economic Status' Field ",
					e);
		}
	}

	@Step("Click On 'Annual Income' Field")
	public void ClickOnAnnualIncomeField() throws Exception {
		try {
			gestUtils.scrollUPtoObject("text", "Annual Income", AnnualIncomeField);
			clickOnElement(AnnualIncomeField);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Click On 'Annual Income' Field ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On 'Annual Income' Field ", e);
		}
	}
	
	@Step("Select Residential Type")
	public void SelectResidentialType(String ResidentialType) throws Exception {
		try {
			selectElementFromTheGivenList(DebitCardDetailsDropdownList, ResidentialType,"Residence Type");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select Residential Type ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select Residential Type ", e);
		}
	}

	@Step("Select Economic Status")
	public void SelectEconomicStatus(String EconomicStatus) throws Exception {
		try {
			selectElementFromTheGivenList(DebitCardDetailsDropdownList, EconomicStatus,"Economic Status");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select Economic Status ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select Economic Status ", e);
		}
	}

	@Step("Select Education")
	public void SelectEducation(String Education) throws Exception {
		try {
			selectElementFromTheGivenList(DebitCardDetailsDropdownList, Education, "Education");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select Education ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select Education ", e);
		}
	}

	@Step("Select Annual Income ")
	public void SelectAnnualIncome(String AnnualIncome) throws Exception {
		try {
			selectElementFromTheGivenList(DebitCardDetailsDropdownList, AnnualIncome, "Annaul Income");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select Annual Income ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select Annual Income ", e);
		}
	}
	
	@Step("Filling Details To Applying Debit Card.")
	public void FillingDetailsToApplyingDebitCard() throws Exception {
		try {
			ClickOnAccountToBeLinkedToTheCardField();
			SelectAccountLinkedWithDebitCard(CommonTestData.ACCOUNT_LINKED_WITH_DEBIT_CARD.getEnumValue());
			
	     	ClickOnTitleField();
		    SelectTitle(CommonTestData.TITLE.getEnumValue());
			
	    	EnterNameToAppearOnTheCard(CommonTestData.NAMETO_APPEAR_ON_DEBITCARD.getEnumValue());
			
		    ClickOnRaceField();
			SelectRace(CommonTestData.RACE.getEnumValue());
			
			
		    ClickOnMaritalStatusField();
			SelectMaritalStatus(CommonTestData.MARITAL_STATUS.getEnumValue());
			ClickOnResidentialTypeField();
			SelectResidentialType(CommonTestData.RESIDENCE_TYPE.getEnumValue());

			ClickOnEducationField();
			SelectEducation(CommonTestData.EDUCATION.getEnumValue());

			ClickOnEconomicStatusField();
			SelectEconomicStatus(CommonTestData.ECONOMIC_STATUS.getEnumValue());

			ClickOnAnnualIncomeField();
			SelectAnnualIncome(CommonTestData.ANNUAL_INCOME.getEnumValue());

		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to enter debit card details  ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to enter debit card details  ", e);
		}
	}
	
	@Step("Click On 'Send Me DBS Prmotion Via Mail' checkbox")
	public void ClickOnSendMeDBSPrmotionViaMailCheckbox() throws Exception {
		try {
			gestUtils.scrollUPtoObjectIos("text", "NEXT", null);
			clickOnElement(SendMeDBSPrmotionViaMail); 
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Click On 'Send Me DBS Prmotion Via Mail' checkbox ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Click On 'Send Me DBS Prmotion Via Mail' checkbox ", e);
		}
	}
	
	@Step("Click On Next Button")
	public void ClickOnNEXTButton() throws Exception {
		try {
			clickOnElement(NEXTButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to click on next button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to click on next button ", e);
		}
	}

	@Step("Verifying 'Review Application' page header")
	public void verifyReviewApplicationPageHeader() throws Exception {
		try {
			  Asserts.assertTrue(isElementVisible(ReviewApplicationPageHeader),
						CommonTestData.REVIEW_APPLICATION.getEnumValue() + " Page Header not displaying.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Next Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Next Button  ", e);
		}
	}

}
