package com.crestech.pages.iospage.more;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crestech.annotation.values.ElementDescription;
import com.crestech.appium.utils.CommonAppiumTest;
import com.crestech.common.utilities.AndroidAlert;
import com.crestech.common.utilities.Asserts;
import com.crestech.common.utilities.CommonTestData;
import com.crestech.common.utilities.GestureUtils;
import com.crestech.common.utilities.HandleException;
import com.crestech.pages.androidpage.more.More;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class transactionHistory extends CommonAppiumTest{
	
	public AppiumDriver<RemoteWebElement> driver = null;
	HandleException obj_handleexception = null;
	GestureUtils gestUtils = null;
	More more = null;
	AndroidAlert androidAlert=null;
	
	public transactionHistory(AppiumDriver<RemoteWebElement> driver) throws Exception {
		super(driver);
		try {
			this.driver = driver;
			obj_handleexception = new HandleException(null, null);
			gestUtils = new GestureUtils(driver);
			more = new More(driver);
			androidAlert=new AndroidAlert(driver);
			PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@ElementDescription(value = "Transaction History label and button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Transaction History']")
	private MobileElement transactionHistoryBtnLabel;
	
	@ElementDescription(value = "3 month option")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='3 Months']")
	private MobileElement threeMonthOption;
	
	@ElementDescription(value = "Account list in transaction history")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText[1]")
	private List<MobileElement> accountListinTransectionHistory;

	@ElementDescription(value = "currency list in transaction history")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText")
	private List<MobileElement> currencyListinTransectionHistory;

	@ElementDescription(value = "select currency title")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Select Currency']")
	private MobileElement selectCurrencyTitle;
	
	@ElementDescription(value = "deposite option")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='fe'])[1]")
	private MobileElement depositeOption;
	
	@ElementDescription(value = "show button")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='SHOW'])[1]")
	private MobileElement showButton;
	
	@ElementDescription(value = "Transaction History final title")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[1])[2]")
	private MobileElement transactionHistoryfinalheaderTitle;
	
	@ElementDescription(value = "'Close' Button After adding Payee")
	@FindBy(name = "close")
	private MobileElement closeButton;
	
	@ElementDescription(value = "Home button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Home']")
	private MobileElement homeButton;
	
	@Step("Back to Home page from Transaction History statement")
	public void BackToHomeFromTransactionHistory() throws Exception {
		try {
			clickOnElement(closeButton);
			verifyTransactionHistoryPageHeader(CommonTestData.TRANSCETION_HISTORY_LABEL.getEnumValue()); 
			clickOnElement(closeButton);
			clickOnElement(homeButton);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Step("Verify Account Name To Check Transaction History")
	public void AccountNameToCheckTransactionHistory(String ExpectedAccountName) throws Exception {
		try {
			String actual = transactionHistoryfinalheaderTitle.getText();
			if (actual.toLowerCase().contains(ExpectedAccountName.toLowerCase())) {
				String[] arrOfStr = ExpectedAccountName.split(" ");
			} else if (androidAlert.isAlertPresent()) {
				String alertMessage = this.driver.switchTo().alert().getText();
				Asserts.assertFail(alertMessage);
			} else
				Asserts.assertEquals(getTexOfElement(transactionHistoryfinalheaderTitle).trim().toLowerCase(),
						ExpectedAccountName.toLowerCase(), ExpectedAccountName + " text is not found");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION",
					" Failed to verify Account Name To Check Transaction History ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION",
					" Failed to verify Account Name To Check Transaction History ", e);
		}
	}
	
	@Step("Click On Show Button")
	public void ClickOnShowButton() throws Exception {
		try {
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(showButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to click on Show button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to click on Show button ", e);
		}
	}
	
	@Step("Validating From Account Transaction History List.")
	public void ValadateTransactionHistoryListInThreeMonth() throws Exception {
		try {
			List<MobileElement> Elementlist = accountListinTransectionHistory;
			int l = Elementlist.size();
			Asserts.assertTrue(l > 0, "No Transaction History is Display");
		}  catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to verify from account transaction history list  ",e);
		}
		catch (Exception e) {		
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to verify from account transaction history list ",e);
		}
	}

	@Step("Click On Deposit Account And Select From Account")
	public void ClickOnDepositAccountAndSelectFromAccount(String AccountName, String currencyInAccount) throws Exception {
		try {
			clickOnElement(depositeOption);
			selectFromAccountFromDepositeSection(AccountName, currencyInAccount); 
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION"," Failed to Click On Deposit Account And Select From Account ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION"," Failed to Click On Deposit Account And Select From Account ", e);
		}
	}

	@Step("Click on 'From Account' From Deposit Section")
	public void selectFromAccountFromDepositeSection(String AccountToBeSelected,String currencyInAccount) throws Exception {
		try {

			int index = 0;
			if (accountListinTransectionHistory.size() > 0) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				String accountFromList = null;
				for (int i = 0; i < accountListinTransectionHistory.size(); i++) {
					accountFromList = accountListinTransectionHistory.get(i).getText();
					if (accountFromList.contains(AccountToBeSelected)) {
						index++;
						clickOnElement(accountListinTransectionHistory.get(i));
						break;
					}
				}
				if (index == 0)
					Asserts.assertFail(
							"Data Issue: From Account '" + AccountToBeSelected + " not found in the Deposite Section List.");
			}
			
		
			if (isElementVisible2(selectCurrencyTitle)) { 
					int index1 = 0;
					String currencyFromList = null;
					for (int i = 0; i < currencyListinTransectionHistory.size(); i++) {
						currencyFromList = currencyListinTransectionHistory.get(i).getText();
						if (currencyFromList.contains(currencyInAccount)) {
							index1++;
							clickOnElement(currencyListinTransectionHistory.get(i));
							break;
						}
					}
					
					if (index1 == 0)
						Asserts.assertFail("Data Issue: Currency:: " + currencyInAccount + " not found in the Deposite Section List.");
			}
		
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION"," Failed to select 'From Account' from Deposit Section. ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to select 'From Account' from Deposit Section.  ", e);
		}
	}

	@Step("Select '3 Months Transaction History' ")
	public void SelectThreeMonths() throws Exception {
		try {
			 com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			 clickOnElement(threeMonthOption);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("SCREENSHOT", " Failed to Select '3 Months Transaction History' ",	e);
		} catch (Exception e) {
			obj_handleexception.throwException("SCREENSHOT", " Failed to Select '3 Months Transaction History' ", e);
		}
	}

	@Step("Verifying 'Transaction History' page header")
	public void verifyTransactionHistoryPageHeader(String expectedText) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60); 
			wait.until(ExpectedConditions.or(
				    ExpectedConditions.presenceOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND name == 'Transaction History'  AND visible== 1")),
				    ExpectedConditions.presenceOfElementLocated(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeOther' AND name == 'Transaction History'  AND visible== 1"))));
//			wait.fluentWaitForElement(transactionHistoryBtnLabel);
//			Asserts.assertEquals(getTexOfElement(transactionHistoryBtnLabel).trim().toLowerCase(), expectedText.toLowerCase(), "text is not found");
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION", " Failed to verify 'Transaction History' page header ", e);
		}
	}
	
}
