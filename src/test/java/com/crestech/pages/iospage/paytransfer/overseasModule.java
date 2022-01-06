package com.crestech.pages.iospage.paytransfer;

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
			Asserts.assertTrue(isElementVisible2(exchangeRate), "Exchange Rate is not visible");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Pressing Enter Key After Entering Amount ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Pressing Enter Key After Entering Amount ", e);
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
			// wait.waitForElementVisibility(IOShomePgaeObject.checkDBSRemitRate());
			// verifyTextOnScreen(CommonTestData.OVERSEAS_TRANSFER_PAGEHEADER.getEnumValue().toLowerCase(),IOShomePgaeObject.overseaTransferTitle());
			if (commonList.size() > 0) {
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
