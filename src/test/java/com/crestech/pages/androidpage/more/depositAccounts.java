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
	
	@ElementDescription(value = "Page Header")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/text')]")
	private MobileElement PageHeaderForOpenAccount;
	
	@ElementDescription(value = "Page Header")
	@AndroidFindBy(xpath = "//android.widget.RelativeLayout//android.widget.TextView[contains(@resource-id,':id/text')]")
	private MobileElement PageHeader;
	
	@ElementDescription(value = "Page Header")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'id/text')]")
	private MobileElement ReviewApplicationPageHeader;
	
	@ElementDescription(value = "Open Account Now Button")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='OPEN ACCOUNT NOW']")
	private MobileElement OpenAccountNowButton;
	
	@ElementDescription(value = "Account Status Message")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/account_status')]")
	private MobileElement AccountStatusMessage;
	
	@ElementDescription(value = "You Ar Opening Text")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='You Are Opening']")
	private MobileElement YouAreOpeningText;
	
	@ElementDescription(value = "Account name list:- Contains From Account and To Account")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/tv_lable2')]")
	private List<MobileElement> AccountNameList;
	
	@ElementDescription(value = "I ACKNOWLEDGE BUTTON")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='I ACKNOWLEDGE']")
	private MobileElement IACKNOWLEDGEButton;
	
	@ElementDescription(value = "Important Notes")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'id/text')]")
	private MobileElement ImportantNotes;
	
	@ElementDescription(value = "Next button")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='NEXT']")
	private MobileElement nextButton;
	
	@ElementDescription(value = "POSB SAYE Account SelectOpenAccountOption")
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.dbs.sit1.dbsmbanking:id/tv_lable1']")
	private List<MobileElement> SelectOpenAccountOptionList;
	
	@ElementDescription(value = "Select source of funds for savings")
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Select source of funds for savings']")
	private MobileElement SelectSourceOfFundsForSavingsDropdown;
	
	@ElementDescription(value = "Deposits Account Name")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/text_src_acc_name')]")
	private List<MobileElement> DepositsAccountName;
	
	@ElementDescription(value = "open account in 3 step button")
	@AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,':id/sgmb_open_account')]")
	private MobileElement StepOpenAccountButton;

	@ElementDescription(value = "Enter monthly savings amount")
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter monthly savings amount']")
	private MobileElement EnterMonthlySavingsAmtEditField;

	@Step("Enter Monthly Savings Amount")
	public void EnterMonthlySavingAmount() throws Exception {
		try {
			clickOnElement(EnterMonthlySavingsAmtEditField);
			enterTextInTextbox(EnterMonthlySavingsAmtEditField,
					CommonTestData.MONTHLY_SAVING_AMT_BALANCE.getEnumValue());
			hideKeyboard();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Enter Monthly Savings Amount ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", "  Failed to Enter Monthly Savings Amount  ", e);
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

	@Step("Select Source Of Funds For Savings.")
	public void SelectSourceOfFundsForSavings() throws Exception {
		try {
			clickOnElement(SelectSourceOfFundsForSavingsDropdown);
			selectElementFromTheGivenList(DepositsAccountName,
					CommonTestData.SELECT_ACCOUNT.getEnumValue(), "Select Source Of Funds For Savings");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to select source of fund account for savings ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					"  Failed to select source of fund account for savings ", e);
		}
	}

	@Step("Select element from the given lists")
	public void selectElementFromTheGivenList(List<MobileElement> elementList, String elementToBeSelected,
			String ElementName) throws Exception {
		try {
			if (elementList.size() > 0) {
				//wait.waitForElementVisibility(elementList.get(1));
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
				Asserts.assertTrue(index > 0,
						"The " + ElementName + " " + elementToBeSelected + " Not found in the list.");
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

	@Step("Click On Next Button.")
	public void ClickOnNextButton() throws Exception {
		try {
			gestUtils.scrollUPtoObject("text", "NEXT", nextButton);
			String nextButtonXpath = "//android.widget.Button[@text='NEXT']";
			List<RemoteWebElement> nextButtonlist = driver.findElements(By.xpath(nextButtonXpath));
			if (nextButtonlist.size() > 0) 
					clickOnElement(nextButton);
			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click on Next Button. ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", "  Failed to Click on Next Button. ", e);
		}
	}

	@Step("Verify Warning Message And Important Notes.")
	public void VerifyWarningMessageAndImportantNotes() throws Exception {
		try {
			Asserts.assertEquals(getTexOfElement(ImportantNotes),
					CommonTestData.IMPORTANT_NOTES.getEnumValue(),
					CommonTestData.IMPORTANT_NOTES.getEnumValue() + " Text is not matching.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verify Warning Messages ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", "  Failed to Verify Warning Messages ", e);
		}
	}
	
	@Step("Click On Open Account Now Button And Got 'Your account is open and ready to use!' Message.")
	public void ClickOnOpenAccountNowButton() throws Exception {
		try {
			gestUtils.scrollUPtoObject("text", "OPEN ACCOUNT NOW", OpenAccountNowButton);
			clickOnElement(OpenAccountNowButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Click On Open Account Now Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", "  Failed to Click On Open Account Now Button ",
					e);
		}
	}

	@Step("Verify 'Your account is open and ready to use!' Message.")
	public void VerifyDetailsAfterOpenAccount() throws Exception {
		try {
			Asserts.assertEquals(getTexOfElement(AccountStatusMessage),
					CommonTestData.YOUR_ACCOUNT_OPEN_READYTOUSE_MESSAGE.getEnumValue(),
					CommonTestData.YOUR_ACCOUNT_OPEN_READYTOUSE_MESSAGE.getEnumValue() + " Message is not matching.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify 'Your account is open and ready to use!' Message ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					"  Failed to Verify 'Your account is open and ready to use!' Message ", e);
		}
	}

	@Step("Review Open Account Application.")
	public void ReviewOpenAccountApplication() throws Exception {
		try {
			if (isElementVisible(YouAreOpeningText)){
				Asserts.assertTrue(YouAreOpeningText.isDisplayed(),
						"You Are Opening" + " text not displaying.");
				Asserts.assertEquals(getTexOfElement(AccountNameList.get(0)),
						CommonTestData.OPEN_ACCOUNT_OPTION.getEnumValue(), " Given account is not matched or found.");
			}

		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Review Open Account Application. ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Review Open Account Application. ",
					e);
		}
	}

	@Step("Click On IAcknowledge Button")
	public void ClickOnIAcknowledgeButton() throws Exception {
		try {
			gestUtils.scrollUPtoObject("text", "I ACKNOWLEDGE", IACKNOWLEDGEButton);
			clickOnElement(IACKNOWLEDGEButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Click On I Acknowledge Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", "  Failed to Click On I Acknowledge Button ", e);
		}
	}

	@Step("Verify 'Review Application' page header")
	public void verifyReviewApplicationPageHeader(String expectedText) throws Exception {
		try {
			wait.fluentWaitForElement(ReviewApplicationPageHeader);
			Asserts.assertEquals(getTexOfElement(ReviewApplicationPageHeader).toLowerCase(), expectedText.toLowerCase(),
					"'Header Title' is not Matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION", " Failed to Verify 'Review Application' page header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION", " Failed to Verify 'Review Application' page header ", e);
		}
	}

	@Step("Verify 'Open Account' page header")
	public void verifyOpenAccountPageHeader(String expectedText) throws Exception {
		try {
			wait.fluentWaitForElement(PageHeaderForOpenAccount);
			Asserts.assertEquals(getTexOfElement(PageHeaderForOpenAccount).toLowerCase(), expectedText.toLowerCase(),
					"'Header Title' is not Matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION", " Failed to Verify 'Open Account' page header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION", " Failed to Verify 'Open Account' page header ", e);
		}
	}
	
	@Step("Verify 'Account Benefits' page header")
	public void verifyAccountBenefitsPageHeader(String expectedText) throws Exception {
		try {
			wait.fluentWaitForElement(PageHeaderForOpenAccount);
			Asserts.assertEquals(getTexOfElement(PageHeaderForOpenAccount).toLowerCase(), expectedText.toLowerCase(),
					"'Header Title' is not Matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION", " Failed to Verify 'Account Benefits' page header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION", " Failed to Verify 'Account Benefits' page header ", e);
		}
	}
	
	@Step("Verify 'Open Account' page header")
	public void verifyPageHeader(String expectedText) throws Exception {
		try {
			wait.fluentWaitForElement(PageHeader);
			Asserts.assertEquals(getTexOfElement(PageHeader).toLowerCase(), expectedText.toLowerCase(),
					"'Header Title' is not Matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION", " Failed to Verify 'Open Account' page header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION", " Failed to Verify 'Open Account' page header ", e);
		}
	}

}
