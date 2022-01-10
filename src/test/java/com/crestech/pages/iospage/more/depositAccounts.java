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
public class depositAccounts extends CommonAppiumTest{

	public AppiumDriver<RemoteWebElement> driver = null;
	HandleException obj_handleexception = null;
	GestureUtils gestUtils = null;
	
	public depositAccounts(AppiumDriver<RemoteWebElement> driver) throws Exception {
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
	
	@ElementDescription(value = "'Open Account' Page Header.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Open Account']")
	private MobileElement OpenAccountPageHeader;
	
	@ElementDescription(value = "'Select Open Account Option List' .")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText")
	private List<MobileElement> SelectOpenAccountOptionList;
	
	@ElementDescription(value = "'OPEN ACCOUNT IN 3 STEPS' Button.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='OPEN ACCOUNT IN 3 STEPS']/parent::XCUIElementTypeButton")
	private MobileElement StepOpenAccountButton;
	
	@ElementDescription(value = "next Button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='NEXT']")
	private MobileElement NEXTButton;
	
	@ElementDescription(value = "'Account Benefits' Page Header.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Account Benefits']")
	private MobileElement AccountBenefitsPageHeader;
	
	@ElementDescription(value = "'Enter monthly savings amount' Edit Field.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[2]/XCUIElementTypeTextField")
	private MobileElement EnterMonthlySavingsAmtEditField;
	
	@ElementDescription(value = "'Select source of funds for savings' Dropdown.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Select source of funds for savings']")
	private MobileElement SelectSourceOfFundsForSavingsDropdown;
	
	@ElementDescription(value = "'Select source of funds for savings List' .")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText")
	private List<MobileElement> SelectSourceOfFundsForSavingsDropdownList;
	
	@ElementDescription(value = "Done button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Done']")
	private MobileElement doneButton;
	
	@ElementDescription(value = "'Important Notes' Page Header.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Important Notes']")
	private MobileElement ImportantNotesPageHeader;
	
	@ElementDescription(value = "'OPEN ACCOUNT NOW' Button.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='OPEN ACCOUNT NOW']")
	private MobileElement OpenAccountNowButton;
	
	@ElementDescription(value = "'I ACKNOWLEDGE' Button.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='I ACKNOWLEDGE']")
	private MobileElement IACKNOWLEDGEButton;
	
	@ElementDescription(value = "'Review Account Application' Page Header.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Review Account Application']")
	private MobileElement ReviewAccountApplicationPageHeader;
	
	@ElementDescription(value = "'Warning' Page Header.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Warning']")
	private MobileElement Warning;
	
	@ElementDescription(value = "'Advisory from the Singapore Police Force' Message.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Advisory from the Singapore Police Force']")
	private MobileElement WarningHeading;
	
	@ElementDescription(value = "'You Are Opening' Text.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='You Are Opening']")
	private MobileElement YouAreOpeningText;
	
	@ElementDescription(value = "'Account' List.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText")
	private List<MobileElement> AccountList;
	
	@ElementDescription(value = " 'Your account is open and ready to use!' Message.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Your account is open and ready to use!']")
	private MobileElement AccountStatusMessage;
	
	@ElementDescription(value = "'Close' Button After adding Payee")
	@FindBy(name = "close")
	private MobileElement closeButton;
	
	@Step("Click on Done button")
	public void ClickOnDoneButton() throws Exception {
		try {
			if (isElementVisible2(doneButton))
				clickOnElement(doneButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Done Button.  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", "  Failed to Click On Done Button.  ", e);
		}
	}
	
	@Step("Verify 'Open Account' page header")
	public void verifyOpenAccountPageHeader() throws Exception {
		try {
			wait.fluentWaitForElement(OpenAccountPageHeader);
			Asserts.assertTrue(isElementVisible(OpenAccountPageHeader),
					CommonTestData.OPEN_ACCOUNT.getEnumValue() + " Page Header not displaying.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION", " Failed to Verify 'Open Account' page header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION", " Failed to Verify 'Open Account' page header ", e);
		}
	}
	
	@Step("Select Open Account Option.")
	public void SelectOpenAccountOption() throws Exception {
		try {
			selectElementFromTheGivenList(SelectOpenAccountOptionList,
					CommonTestData.OPEN_ACCOUNT_OPTION.getEnumValue(), "Open Account Option");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select Open Account Option  ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", "  Failed to Select Open Account Option  ", e);
		}
	}
	
	@Step("Click On Open Account In 2/3 Step Button.")
	public void ClickOnopenAccountInStepButton() throws Exception {
		try {
			clickOnElement(StepOpenAccountButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Click On Open Account In Step 2/3 Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					"  Failed to Click On Open Account In Step 2/3 Button  ", e);
		}
	}
	
	@Step("Enter Monthly Savings Amount")
	public void EnterMonthlySavingAmount() throws Exception {
		try {
			clickOnElement(EnterMonthlySavingsAmtEditField);
			enterTextInTextbox(EnterMonthlySavingsAmtEditField,
					CommonTestData.MONTHLY_SAVING_AMT_BALANCE.getEnumValue());
			ClickOnDoneButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Enter Monthly Savings Amount ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", "  Failed to Enter Monthly Savings Amount  ", e);
		}
	}
	
	@Step("Select Source Of Funds For Savings.")
	public void SelectSourceOfFundsForSavings(String appName) throws Exception {
		try {
			clickOnElement(SelectSourceOfFundsForSavingsDropdown);
			if (appName.equals("DBS"))
				selectElementFromTheGivenList(SelectSourceOfFundsForSavingsDropdownList, CommonTestData.SELECT_ACCOUNT.getEnumValue(),
						"Select Source Of Funds For Savings");
			else if (appName.equals("iWEALTH"))
				selectElementFromTheGivenList(SelectSourceOfFundsForSavingsDropdownList,
						CommonTestData.SELECT_ACCOUNT_iWEALTH.getEnumValue(), "Select Source Of Funds For Savings");
		
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to select source of fund account for savings ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					"  Failed to select source of fund account for savings ", e);
		}
	}
	
	@Step("Click On Next Button")
	public void ClickOnNEXTButton() throws Exception {
		try {
			gestUtils.scrollUPtoObjectIos("name", "NEXT", null);
			clickOnElement(NEXTButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to click on next button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to click on next button ", e);
		}
	}
	
	@Step("Verify 'Open Account' page header")
	public void verifyPageHeader(String expectedText) throws Exception {
		try {
			wait.fluentWaitForElement(OpenAccountPageHeader);
			Asserts.assertEquals(getTexOfElement(OpenAccountPageHeader), expectedText,
					expectedText + " Page Header Text is not matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION", " Failed to Verify 'Open Account' page header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION", " Failed to Verify 'Open Account' page header ", e);
		}
	}
	
	@Step("Verify 'Account Benefits' page header")
	public void verifyAccountBenefitsPageHeader(String expectedText) throws Exception {
		try {
			wait.fluentWaitForElement(AccountBenefitsPageHeader);
			Asserts.assertEquals(getTexOfElement(AccountBenefitsPageHeader),
					CommonTestData.ACCOUNT_BENIFITS.getEnumValue(),
					CommonTestData.ACCOUNT_BENIFITS.getEnumValue() + " Page Header Text is not matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION", " Failed to Verify 'Account Benefits' page header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION", " Failed to Verify 'Account Benefits' page header ", e);
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
	
	@Step("Verify Warning Message And Important Notes.")
	public void VerifyWarningMessageAndImportantNotes() throws Exception {
		try {
			wait.fluentWaitForElement(ImportantNotesPageHeader); 
			Asserts.assertEquals(getTexOfElement(ImportantNotesPageHeader),
					CommonTestData.IMPORTANT_NOTES.getEnumValue(),
					CommonTestData.IMPORTANT_NOTES.getEnumValue() + " Text is not matching.");
			
			Asserts.assertEquals(getTexOfElement(Warning),
					CommonTestData.WARNING.getEnumValue(),
					CommonTestData.WARNING.getEnumValue() + " Message is not matching");
		
			Asserts.assertEquals(getTexOfElement(WarningHeading),
					CommonTestData.WARNING_HEADING_TEXT.getEnumValue(),
					CommonTestData.WARNING_HEADING_TEXT.getEnumValue() + " Message is not matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verify Warning Messages ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", "  Failed to Verify Warning Messages ", e);
		}
	}
	
	@Step("Click On Open Account Now Button And Got 'Your account is open and ready to use!' Message.")
	public void ClickOnOpenAccountNowButton() throws Exception {
		try {
			gestUtils.scrollUPtoObjectIos("name", "OPEN ACCOUNT NOW", null);
			clickOnElement(OpenAccountNowButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Click On Open Account Now Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", "  Failed to Click On Open Account Now Button ",
					e);
		}
	}
	
	@Step("Click On IAcknowledge Button")
	public void ClickOnIAcknowledgeButton() throws Exception {
		try {
			gestUtils.scrollUPtoObjectIos("name", "I ACKNOWLEDGE", null);
			clickOnElement(IACKNOWLEDGEButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Click On I Acknowledge Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", "  Failed to Click On I Acknowledge Button ", e);
		}
	}

	@Step("Verify 'Review Application' page header")
	public void verifyReviewApplicationPageHeader() throws Exception {
		try {
			wait.fluentWaitForElement(ReviewAccountApplicationPageHeader);
			Asserts.assertEquals(getTexOfElement(ReviewAccountApplicationPageHeader),
					CommonTestData.REVIEW_ACCOUNT_APPLICATION.getEnumValue(),
					CommonTestData.REVIEW_ACCOUNT_APPLICATION.getEnumValue() + " Text is not matched.");
			if (isElementVisible(YouAreOpeningText)) {
				MobileElement element = returnElementFromList(AccountList,
						CommonTestData.OPEN_ACCOUNT_OPTION.getEnumValue());
				Asserts.assertEquals(getTexOfElement(element), CommonTestData.OPEN_ACCOUNT_OPTION.getEnumValue(),
						" Given account is not matched or found.");
			}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION", " Failed to Verify 'Review Application' page header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION", " Failed to Verify 'Review Application' page header ", e);
		}
	}
	
	@Step("Verify 'Your account is open and ready to use!' Message.")
	public void VerifyDetailsAfterOpenAccount() throws Exception {
		try {
			Asserts.assertEquals(getTexOfElement(AccountStatusMessage),
					CommonTestData.YOUR_ACCOUNT_OPEN_READYTOUSE_MESSAGE.getEnumValue(),
					CommonTestData.YOUR_ACCOUNT_OPEN_READYTOUSE_MESSAGE.getEnumValue()
							+ " Message is not matching.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify 'Your account is open and ready to use!' Message ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					"  Failed to Verify 'Your account is open and ready to use!' Message ", e);
		}
	}
	
	@Step("Click on 'Close' Button.")
	public void ClickOnCloseButton() throws Exception {
		try {
			if(isElementVisible2(closeButton))
				clickOnElement(closeButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Click on 'Close' Button  ",	e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Click on 'Close' Button ", e);
		}
	}
	
}
