package com.crestech.pages.androidpage.more;

import java.time.Duration;
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

	
	@ElementDescription(value = "Select Debit Card")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Debit Cards']")
	private MobileElement SelectDebitCard;
	
	@ElementDescription(value = "Debit Card Details Dropdown List")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/tv_view_id')]")
	private List<MobileElement> DebitCardDetailsDropdownList;
	
	@ElementDescription(value = "Annual Income Field")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Annual Income']")
	private MobileElement AnnualIncomeField;
	
	@ElementDescription(value = "Enter Name to appear on the Card Field")
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Name to appear on the Card']")
	private MobileElement EnterNameToAppearOnTheCardField;
	
	@ElementDescription(value = "Account to be linked to the card")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Account to be linked to the card']")
	private MobileElement AccountToBeLinkedToTheCardField;
	
	@ElementDescription(value = "Existing ATM Card number to be replaced")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Existing ATM Card number to be replaced']")
	private MobileElement ExistingATMCardnumbertobereplaced;

	@ElementDescription(value = "Title Field")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Title']")
	private MobileElement TitleField;

	@ElementDescription(value = "Race Field")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Race']")
	private MobileElement RaceField;

	@ElementDescription(value = "Marital Status field")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Marital Status']")
	private MobileElement MaritalStatusField;

	@ElementDescription(value = "Residential Type field")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Residential Type']")
	private MobileElement ResidentialTypeField;

	@ElementDescription(value = "Education field")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Education']")
	private MobileElement EducationField;

	@ElementDescription(value = "Economic Status field")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Economic Status']")
	private MobileElement EconomicStatusField;

	@ElementDescription(value = "Send Me DBS Prmotion Via Mail")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Email']")
	private MobileElement SendMeDBSPrmotionViaMail;
	
	@ElementDescription(value = "Next button")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='NEXT']")
	private MobileElement nextButton;
	
	@ElementDescription(value = "Next button")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='CONFIRM']")
	private MobileElement confirmButton;
	
	@ElementDescription(value = "Page Header List")
	@AndroidFindBy(xpath = " //android.widget.RelativeLayout//android.widget.TextView[contains(@resource-id,':id/text')]")
	private List<MobileElement> PageHeaderList;
	
	@ElementDescription(value = "Apply Now Button")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='APPLY NOW']")
	private MobileElement ApplyNowButton;
	
	@ElementDescription(value = "Send Me DBS Prmotion Via Mail")
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Confirm New PIN']")
	private MobileElement ConfirmNewPINField;

	@ElementDescription(value = "Apply Now Button")
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Create Your PIN']")
	private MobileElement CreateYourPINField;
	
	@ElementDescription(value = "Submit Button")
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='APPLY']")
	private MobileElement submitButton;
	
	
	@Step("Verify Application Submitted Message")
	public void VerifyApplicationSubmittedMessage(String ApplicationSubmittedMessage) throws Exception {
		try {
			MobileElement element = null;
			element = getPageHeaderElement(PageHeaderList, ApplicationSubmittedMessage);
			if (element != null)
				Asserts.assertEquals(getTexOfElement(element), ApplicationSubmittedMessage,
						ApplicationSubmittedMessage + " Text is not Matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXEPTION", " Failed to Verify Application Submitted Message ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXEPTION", " Failed to Verify Application Submitted Message ", e);
		}
	}
	
	@Step("Verify Set Card PIN Page Header")
	public void VerifySetCardPINPageHeader() throws Exception {
		try {
			MobileElement element = null;
			element = getPageHeaderElement(PageHeaderList, CommonTestData.SET_CARD_PIN.getEnumValue());
			if (element != null)
				verifyPageHeader(CommonTestData.SET_CARD_PIN.getEnumValue(), element);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXEPTION"," Failed to Verify Set Card PIN Page Header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXEPTION", " Failed to Verify Set Card PIN Page Header ", e);
		}
	}

	@Step("Click on Submit Button")
	public void ClickOnSubmitButton() throws Exception {
		try {
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(submitButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXEPTION", " Failed to Click On Submit Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXEPTION", " Failed to Click On Submit Button ", e);
		}
	}

	@Step("Set debit card PIN.")
	public void SetDebitCardPin(String createPin, String ConfirmPin) throws Exception {
		try {
			clickOnElement(CreateYourPINField);
			enterTextInTextbox(CreateYourPINField, createPin);
			clickOnElement(ConfirmNewPINField);
			enterTextInTextbox(ConfirmNewPINField, ConfirmPin);
			hideKeyboard();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXEPTION", " Failed to Set card PIN ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXEPTION", " Failed to Set card PIN ", e);
		}
	}

	@Step("Click on Apply Button")
	public void ClickonApplyButton() throws Exception {
		try {
			gestUtils.scrollUPtoObject("text", "APPLY NOW", ApplyNowButton);
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(ApplyNowButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXEPTION", " Failed to Click On Apply Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXEPTION", " Failed to Click On Apply Button  ", e);
		}
	}

	@Step("Click On 'Send Me DBS Prmotion Via Mail' checkbox")
	public void ClickOnSendMeDBSPrmotionViaMailCheckbox() throws Exception {
		try {
			gestUtils.scrollUPtoObject("text", "NEXT", nextButton);
			clickOnElement(SendMeDBSPrmotionViaMail);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Click On 'Send Me DBS Prmotion Via Mail' checkbox ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Click On 'Send Me DBS Prmotion Via Mail' checkbox ", e);
		}
	}

	@Step("Select Debit Card")
	public void SelectDebitCard() throws Exception {
		try {
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(SelectDebitCard);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select Debit Card ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select Debit Card ", e);
		}
	}

	@Step("Select Debit card Type")
	public void selectDebitCardType(String expectedDebitCard) throws Exception {
		try {
			wait.fluentWaitForElement(DebitCardDetailsDropdownList.get(0));  
			if (DebitCardDetailsDropdownList.size() > 0) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				int l = DebitCardDetailsDropdownList.size();
				int index = 0;
				String actualDebitCard = null;
				for (int i = 0; i < l; i++) {
					actualDebitCard = DebitCardDetailsDropdownList.get(i).getText();
					if (actualDebitCard.contains(expectedDebitCard)) {
						index++;
						clickOnElement(DebitCardDetailsDropdownList.get(i));
						break;
					}
				}
				if (index == 0)
					Asserts.assertFail("Data Issue: Debit Card Type " + expectedDebitCard + " Not found in the list.");
			} else 
				Asserts.assertFail("Data Issue: Debit card type '"+expectedDebitCard + "' not found in the list as list size is 0");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("ELEMENTNOTINLIST_EXCEPTION"," Failed to Select Debit card type:: " + expectedDebitCard, e);
		} catch (Exception e) {
			obj_handleexception.throwException("ELEMENTNOTINLIST_EXCEPTION"," Failed to Select Debit card type " + expectedDebitCard, e);
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
	
	@Step("Click On 'Existing ATM Card number to be replaced' Field")
	public void ClickOnExistingATMCardNumberToBeReplacedField() throws Exception {
		try {
			clickOnElement(ExistingATMCardnumbertobereplaced);
			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Click On 'Existing ATM Card number to be replaced'Field ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Click On 'Existing ATM Card number to be replaced' Field ", e);
		}
	}

	@Step("Select Account Linked With Debit Card")
	public void SelectAccountLinkedWithDebitCard(String linkedAccount) throws Exception {
		try {
			selectElementFromTheGivenList(DebitCardDetailsDropdownList, linkedAccount,
					" Account Linked With Debit Card");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Select Account Linked With Debit Card ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Select Account Linked With Debit Card ", e);
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

	@Step("Enter Name To Appear On The Card")
	public void EnterNameToAppearOnTheCard(String Name) throws Exception {
		try {
			clickOnElement(EnterNameToAppearOnTheCardField);
			enterTextInTextbox(EnterNameToAppearOnTheCardField, Name);
			hideKeyboard();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On 'Title' Field ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On 'Title' Field ", e);
		}
	}

	@Step("Click On 'Race' Field")
	public void ClickOnRaceField() throws Exception {
		try {
			gestUtils.scrollUPtoObject("text", "Education", EducationField);
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
	
	@Step("Fill Details To Applying Debit Card.")
	public void FillingDetailsToApplyingDebitCard(String appName) throws Exception {
		try {
			if (appName.equals("DBS")) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				ClickOnAccountToBeLinkedToTheCardField();
				SelectAccountLinkedWithDebitCard(CommonTestData.ACCOUNT_LINKED_WITH_DEBIT_CARD.getEnumValue());
			}
			else if (appName.equals("iWEALTH")) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				ClickOnExistingATMCardNumberToBeReplacedField();
				SelectAccountLinkedWithDebitCard(CommonTestData.EXISTING_ATM_CARD_NUMBER_TOBE_REPLACED.getEnumValue());
			}
			
			
			

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
	
	
	public void selectElementFromTheGivenList(List<MobileElement> elementList, String elementToBeSelected,
			String ElementName) throws Exception {
		try {
			if (elementList.size() > 0) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				List<MobileElement> Elementlist = elementList;
				int l = Elementlist.size();
				int index = 0;
				String accountFromList = null;
				for (int i = 0; i < l; i++) {
					accountFromList = Elementlist.get(i).getText();
					if (accountFromList.contains(elementToBeSelected)) {
						index++;
						clickOnElement(Elementlist.get(i));
						break;
					}
				}
				if(index == 0)
				Asserts.assertFail("Data Issue: " + ElementName + " " + elementToBeSelected + " Not found in the list.");
			} else
				Asserts.assertFail(
						"Data Issue: " + ElementName + " " + elementToBeSelected + " not found in the list as list size is 0");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("ELEMENTNOTINLIST_EXCEPTION",
					" Failed to select the " + ElementName + " " + elementToBeSelected + " from the list", e);
		} catch (Exception e) {
			obj_handleexception.throwException("ELEMENTNOTINLIST_EXCEPTION",
					" Failed to select the " + ElementName + " " + elementToBeSelected + " from the list ", e);
		}
	}
	
	@Step("Click On Next Button.")
	public void ClickOnNextButton() throws Exception {
		try {
			String confirmButtonXpath = "//android.widget.Button[@text='CONFIRM']";
			List<RemoteWebElement> confirmButtonList = driver.findElements(By.xpath(confirmButtonXpath));
			String nextButtonXpath = "//android.widget.Button[@text='NEXT']";
			List<RemoteWebElement> nextButtonList = driver.findElements(By.xpath(nextButtonXpath));
			if (confirmButtonList.size() > 0) {
				gestUtils.scrollUPtoObject("text", "CONFIRM", confirmButton);
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				clickOnElement(confirmButton);
			} else if (nextButtonList.size() > 0) {
				gestUtils.scrollUPtoObject("text", "NEXT", nextButton);
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				clickOnElement(nextButton);
			}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Next Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Next Button  ", e);
		}
	}
	
	public void verifyPageHeader(String expectedText, MobileElement ele) throws Exception {
		try {
			wait.fluentWaitForElement(ele);
			Asserts.assertEquals(getTexOfElement(ele).toLowerCase(), expectedText.toLowerCase(),
					"'Header Title' is not Matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION", " Failed to verify page header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION", " Failed to verify page header ", e);
		}
	}
	
	@Step("Verifying 'Review Application' page header")
	public void verifyReviewApplicationPageHeader() throws Exception {
		try {
			MobileElement element = null;
			element = getPageHeaderElement(PageHeaderList,
					CommonTestData.REVIEW_APPLICATION.getEnumValue());
			if (element != null)
				verifyPageHeader(CommonTestData.REVIEW_APPLICATION.getEnumValue(), element);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Next Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Next Button  ", e);
		}
	}
	
	public MobileElement getPageHeaderElement(List<MobileElement> elementList, String pageHeaderText) throws Exception {
		MobileElement element = null;
		try {
			if (elementList.size() > 0) {
				int l = elementList.size();

				String actualPageHeader = null;
				for (int i = 0; i < l; i++) {
					actualPageHeader = elementList.get(i).getText();
					if (actualPageHeader.contains(pageHeaderText)) {
						element = elementList.get(i);
						break;
					}
				}
				return element;
			} else
				Asserts.assertFail(pageHeaderText + " not found in the list as list size is 0");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("ELEMENTNOTINLIST_EXCEPTION", " Failed to get element from list corresponding to :: " + pageHeaderText, e);
		} catch (Exception e) {
			obj_handleexception.throwException("ELEMENTNOTINLIST_EXCEPTION", " Failed to get element from list corresponding to :: " + pageHeaderText, e);
		}
		return element;
	}
	
}
