package com.crestech.pages.androidpage.more;

import java.time.Duration;
import java.util.List;
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
public class transactionHistory extends CommonAppiumTest{
	
	public AppiumDriver<RemoteWebElement> driver = null;
	HandleException obj_handleexception = null;
	GestureUtils gestUtils = null;
	More more = null;
	
	
	public transactionHistory(AppiumDriver<RemoteWebElement> driver) throws Exception {
		super(driver);
		try {
			this.driver = driver;
			obj_handleexception = new HandleException(null, null);
			gestUtils = new GestureUtils(driver);
			more = new More(driver);
			PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@ElementDescription(value = "Transaction History Header")
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.dbs.sit1.dbsmbanking:id/text']")
	private MobileElement TransactionHistoryHeaderDBS;
	
	@ElementDescription(value = "3 three month  Label")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='3 Months']")
	private MobileElement threeMonthLabel;
	
	@ElementDescription(value = "Deposit Account Button")
	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,'id/iv_expandable_item_head_expand')]")
	private MobileElement DepositAccountButton;
	
	@ElementDescription(value = "From account list")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'id/tv_expandable_item_head_title')]")
	private List<MobileElement> AccountNameListInTransactionHistory;
	
	@ElementDescription(value = "Show button")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='SHOW']")
	private MobileElement showButton;

	@ElementDescription(value = "DropDown List")
	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup")
	private List<MobileElement> dropDowmList;
	
	@ElementDescription(value = "back button")
	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,'id/back_btn')]")
	private MobileElement backButton;
	
	@ElementDescription(value = "Account name to checking transaction history.")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/tv_accountName')]")
	private MobileElement AccountNameToCheckTransactionHistory;
	
	@ElementDescription(value = "Currency Associated with account")
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.dbs.sit1.dbsmbanking:id/sf_country']")
	private MobileElement currencyInAccount;

	@Step("Click On Back Button.")
	public void ClickOnBackButton() throws Exception {
		try {
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(backButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Back Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Back Button  ", e);
		}
	}
	
	@Step("Back to Home page from Transaction History statement")
	public void BackToHomeFromTransactionHistory() throws Exception {
		try {
			ClickOnBackButton();
			verifyTransactionHistoryPageHeader(CommonTestData.TRANSCETION_HISTORY_LABEL.getEnumValue());
			ClickOnBackButton();
			more.ClickOnHomeButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Back To Home Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Back To Home Button  ", e);
		}
	}
	
	@Step("Verify Account Name To Check Transaction History")
	public void AccountNameToCheckTransactionHistory(String expectedText) throws Exception {
		try {
			wait.fluentWaitForElement(AccountNameToCheckTransactionHistory);
			Asserts.assertEquals(getTexOfElement(AccountNameToCheckTransactionHistory).toLowerCase(), expectedText.toLowerCase(),
					"'Header Title' is not Matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION", " Failed to verify Account Name To Check Transaction History ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION", " Failed to verify Account Name To Check Transaction History ", e);
		}
	}

	@Step("Verify Transaction History Data For Three Months.")
	public void VerifyTransactionHistoryDataForThreeMonths() throws Exception {
		try {
			int l = dropDowmList.size();
			Asserts.assertTrue(l > 0, "No Transaction History is Display");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION"," Failed to Verify Transaction History Data For Three Months ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify Transaction History Data For Three Months ", e);
		}
	}
	
	@Step("Click on 'Show' Button")
	public void ClickOnShowButton() throws Exception {
		try {
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(showButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to click show button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to click show button ", e);
		}
	}
	
	@Step("Select '3 Months Transaction History' ")
	public void SelectThreeMonths() throws Exception {
		try {
			gestUtils.scrollUPtoObject("text", "3 Months",null);
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(threeMonthLabel);
			gestUtils.scrollDOWNtoObject(null, null,null);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("SCREENSHOT", " Failed to Select '3 Months Transaction History' ",	e);
		} catch (Exception e) {
			obj_handleexception.throwException("SCREENSHOT", " Failed to Select '3 Months Transaction History' ", e);
		}
	}

	@Step("Click On Deposit Account And Select From Account")
	public void ClickOnDepositAccountAndSelectFromAccount(String AccountName, String currency) throws Exception {
		try {
			WaitForElementForNExtPage(DepositAccountButton);
			wait.waitForElementToBeClickable(DepositAccountButton);
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(DepositAccountButton); 
			selectFromAccountFromDepositeSection(AccountName);
			ClickOnCurrency(currency);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION"," Failed to Click On Deposit Account And Select From Account ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION"," Failed to Click On Deposit Account And Select From Account ", e);
		}
	}

	@Step("Click on 'From Account' From Deposit Section")
	public void selectFromAccountFromDepositeSection(String AccountToBeSelected) throws Exception {
		try {
			wait.waitForElementVisibility(AccountNameListInTransactionHistory.get(0));
			if (isElementVisible2(AccountNameListInTransactionHistory.get(0))) {  
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				int l = AccountNameListInTransactionHistory.size();
				int index = 0;
				String accountFromList = null;
				for (int i = 0; i < l; i++) { 
					accountFromList = AccountNameListInTransactionHistory.get(i).getText();
					if (accountFromList.contains(AccountToBeSelected)) {
						index++;
						clickOnElement(AccountNameListInTransactionHistory.get(i));
						break;
					}
				}
				if (index == 0)
					Asserts.assertFail("Data Issue: From Account '" + AccountToBeSelected + "' not found in the Deposite Section List.");
			} 

		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION"," Failed to select 'From Account' from Deposit Section. ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to select 'From Account' from Deposit Section.  ", e);
		}
	}
	
	@Step("Verifying 'Transaction History' page header")
	public void verifyTransactionHistoryPageHeader(String expectedText) throws Exception {
		try {
			wait.fluentWaitForElement(TransactionHistoryHeaderDBS);
			Asserts.assertEquals(getTexOfElement(TransactionHistoryHeaderDBS).toLowerCase(), expectedText.toLowerCase(),
					"'Header Title' is not Matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION", " Failed to verify 'Transaction History' page header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION", " Failed to verify 'Transaction History' page header ", e);
		}
	}
	@Step("Click on currency under Multiplier Account")
	public void ClickOnCurrency(String currency) throws Exception {
		try {
			wait.fluentWaitForElement(TransactionHistoryHeaderDBS);
			if(getTexOfElement(TransactionHistoryHeaderDBS).equalsIgnoreCase("Select Currency"))
				clickOnElement(currencyInAccount);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to click show button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to click show button ", e);
		}
	}

}
