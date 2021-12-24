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
public class More extends CommonAppiumTest{
	
	public AppiumDriver<RemoteWebElement> driver = null;
	HandleException obj_handleexception = null;
	GestureUtils gestUtils = null;
	
	public More(AppiumDriver<RemoteWebElement> driver) throws Exception {
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
	
	@ElementDescription(value = "Cards Button")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Cards']")
	private MobileElement CardsButton;
	
	@ElementDescription(value = "Transaction History Label and Button")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Transaction History']")
	private MobileElement transactionHistoryButton;
	
	@ElementDescription(value = "Home button")
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Home']")
	private MobileElement homeButton;
	
	@ElementDescription(value = "search icon")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'id/contact_search')]")
	private MobileElement searchIcon;

	@ElementDescription(value = "search editbox")
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'id/search_text_et')]")
	private MobileElement searchBox;
	
	@ElementDescription(value = "search Text Element list")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'id/textView')]")
	private List<MobileElement> searchTextElement;

	@ElementDescription(value = "search Clickable Element list")
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@clickable='true']")
	private List<MobileElement> searchClickableElement;

	@ElementDescription(value = "Contact Search Field")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/contact_search')]")
	private MobileElement ContactSearchfield;
	
	@ElementDescription(value = "Edit Text Search Box")
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,':id/search_text_et')]")
	private MobileElement EditTextSearchBox;
	
	@ElementDescription(value = "Update Contact Details")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Update Contact Details']")
	private MobileElement UpdateContactDetails;
	
	@ElementDescription(value = "Select Peek balance")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Peek Balance']")
	private MobileElement SelectPeekBalance;
	
	@ElementDescription(value = "Logout Button")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='LOG OUT']")
	private MobileElement logoutButton;
	
	@ElementDescription(value = "Deposit Account Modules")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Deposit Accounts']")
	private MobileElement DepositAccountsModule;
	
	@Step("Click On Deposit Accounts Module.")
	public void ClickOnDepositAccountModule() throws Exception {
		try {
			gestUtils.scrollUPtoObject("text", "Deposit Accounts", DepositAccountsModule);
			clickOnElement(DepositAccountsModule);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Click On Deposit Accounts Module. ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Deposit Accounts Module. ",
					e);
		}
	}
	
	@Step("Click On logout Button")
	public void ClickOnLogOutButton() throws Exception {
		try {
			clickOnElement(logoutButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On logout Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On logout Button  ", e);
		}
	}
	
	@Step("Select Update Contact Details.")
	public void SelectUpdateContactDetails() throws Exception {
		try {
			clickOnElement(ContactSearchfield);
			clickOnElement(EditTextSearchBox);
			enterTextInTextbox(EditTextSearchBox,CommonTestData.UPDATE_CONTACT_DETAILS_PAGEHEADER.getEnumValue());
			clickOnElement(UpdateContactDetails);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION"," Failed to select update contact details. ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to select update contact details. ", e);
		}
	}
	
	@Step("Select Peek Balance Module After Search.")
	public void SelectPeekBalanceModule() throws Exception {
		try {
			clickOnElement(ContactSearchfield);
			clickOnElement(EditTextSearchBox);
			enterTextInTextbox(EditTextSearchBox, CommonTestData.PEEK_BALANCE.getEnumValue());
			clickOnElement(SelectPeekBalance);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select Peek balance Module. ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select Peek balance Module.  ", e);
		}
	}
	
	@Step("Select 'Local Transfer Limit' Module")
	public void SelectLocalTransferLimitModule(String expectedModule)throws Exception {
		try {
			clickOnElement(searchIcon);
			enterTextInTextbox(searchBox, expectedModule);

			if (searchTextElement.size() > 0) {
				int l = searchTextElement.size();
				int index = 0;
				String actualModule = null;
				for (int i = 0; i < l; i++) {
					actualModule = searchTextElement.get(i).getText();
					if (actualModule.equalsIgnoreCase(expectedModule)) {
						index++;
						clickOnElement(searchClickableElement.get(i));
						break;
					}
				}
				if(index==0)
				Asserts.assertFail(expectedModule + " No element found in the list");
			} else
				Asserts.assertFail(expectedModule + " not found in the list as list size is 0");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Select 'Temporary Credit Limit Increase' Module ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Select 'Temporary Credit Limit Increase' Module ", e);
		}
	}
	
	
	@Step("Select 'Temporary Credit Limit Increase' Module")
	public void SelectTemporaryCreditLimitIncreaseModule(String expectedModule)throws Exception {
		try {
			clickOnElement(searchIcon);
			enterTextInTextbox(searchBox, expectedModule);

			if (searchTextElement.size() > 0) {
				int l = searchTextElement.size();
				int index = 0;
				String actualModule = null;
				for (int i = 0; i < l; i++) {
					actualModule = searchTextElement.get(i).getText();
					if (actualModule.equalsIgnoreCase(expectedModule)) {
						index++;
						clickOnElement(searchClickableElement.get(i));
						break;
					}
				}
				if(index==0)
				Asserts.assertFail(expectedModule + " No element found in the list");
			} else
				Asserts.assertFail(expectedModule + " not found in the list as list size is 0");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Select 'Temporary Credit Limit Increase' Module ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Select 'Temporary Credit Limit Increase' Module ", e);
		}
	}
	
	@Step("Click On Home Button.")
	public void ClickOnHomeButton() throws Exception {
		try {
			clickOnElement(homeButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Home Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Home Button  ", e);
		}
	}

	@Step("Click On Cards Module")
	public void ClickOnCardsModule() throws Exception {
		try {
			gestUtils.scrollUPtoObject("text", "Cards", CardsButton);
			clickOnElement(CardsButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Cards Module ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Cards Module ", e);
		}
	}

	@Step("Click on 'Transaction History' Button")
	public void ClickOnTransactionHistory() throws Exception {
		try {
			clickOnElement(transactionHistoryButton); 
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION"," Failed to click transaction history ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION"," Failed to click transaction history ", e);
		}
	}

}
