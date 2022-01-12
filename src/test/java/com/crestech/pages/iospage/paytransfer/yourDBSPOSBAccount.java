package com.crestech.pages.iospage.paytransfer;

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
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

/**
 * @author Divya
 *
 */
public class yourDBSPOSBAccount extends CommonAppiumTest {

	public AppiumDriver<RemoteWebElement> driver = null;
	HandleException obj_handleexception = null;
	GestureUtils gestUtils = null;

	public yourDBSPOSBAccount(AppiumDriver<RemoteWebElement> driver) throws Exception {
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

	@ElementDescription(value = "'Transfer to Your Account' page Header")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Transfer to Your Account']")
	private MobileElement TransferToOwnAccountPageHeader;

	@ElementDescription(value = "Select Fund Source list")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText")
	private List<MobileElement> selectfundSourceList;

	@ElementDescription(value = "'Select billing organisation' Dropdown.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='source_account_name']")
	private MobileElement SelectFundSourcePage;

	@ElementDescription(value = "Primary source of fund")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Primary source of fund']")
	private MobileElement primarysourceOfFund;

	@ElementDescription(value = "OK Button")
	@AndroidFindBy(xpath = "//XCUIElementTypeStaticText[@name='OK']")
	private MobileElement OKButton;
	
	@ElementDescription(value = "Logout button on paylah")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Log Out']")
	private MobileElement logout;
	
	@ElementDescription(value = "'BACK TO HOME' Button.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='BACK TO HOME']")
	private MobileElement BackToHomeButton;

	@ElementDescription(value = "'MAKE ANOTHER TRANSFER' Button.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='MAKE ANOTHER TRANSFER']")
	private MobileElement MakeAnotherTransferButton;
	
	@ElementDescription(value = "next Button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='NEXT']")
	private MobileElement NEXTButton;
	
	@ElementDescription(value = "'Amount editable' Field")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='FT_Amount_Field']")
	private MobileElement AmountEditableField;
	
	@ElementDescription(value = "Done button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Done']")
	private MobileElement doneButton;
	
	@ElementDescription(value = "'Review Transfer' page Header")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Review Transfer']")
	private MobileElement ReviewTransferPageHeader;
	
	@ElementDescription(value = "'TRANSFER NOW' Button.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='TRANSFER NOW']")
	private MobileElement TRANSFERNOWButton;
	
	@ElementDescription(value = "'Transferred' Message.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Transferred']")
	private MobileElement TransferredMsg;
	
	
	@Step("Click on Transfer Now Button.")
	public void ClickOnTransferNowBtn() throws Exception {
		try {
			clickOnElement(TRANSFERNOWButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to CLick on transfer now Button ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to CLick on transfer now Button ", e);
		}
	}
	
	@Step("Verifies Transfer Submitted Message")
	public void VerifiesTransferSubmittedMsg(String SuccessMsg) throws Exception {
		try {
			Asserts.assertEquals(getTexOfElement(TransferredMsg), SuccessMsg,
					SuccessMsg + " Text is not matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verify success message ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify success message  ", e);
		}
	}
	
	@Step("Verify 'Review Transfer' page header")
	public void verifyReviewTransferPageHeader() throws Exception {
		try {
			wait.fluentWaitForElement(ReviewTransferPageHeader);
			Asserts.assertTrue(isElementVisible(ReviewTransferPageHeader),
					CommonTestData.REVIEW_TRANSFER.getEnumValue() + " Page Header not displaying.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION", " Failed to verify 'Review Transfer' page header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION", " Failed to verify 'Review Transfer' page header", e);
		}
	}
	
	@Step("click on done button")
	public void ClickOnDoneButton() throws Exception {
		try {
			if (isElementVisible2(doneButton))
			clickOnElement(doneButton); 
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Click on Done Button ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", " Failed to Click on Done Button ", e);
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
	
	@Step("Click On 'Back To Home' Button")
	public void ClickOnBackToHomeButton() throws Exception {
		try {
			clickOnElement(BackToHomeButton); 
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to click on 'Back To Home' button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to click on 'Back To Home' button ", e);
		}
	}
	
	@Step("Enter Amount In Editable field to transfer fund.")
	public void EnterAmount(String textToEnter) throws Exception {
		try {
			clickOnElement(AmountEditableField);
			enterTextInTextbox(AmountEditableField, textToEnter);
			ClickOnDoneButton();
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Enter Amount In Editable field to transfer fund ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Enter Amount In Editable field to transfer fund ",e);
		}
	}

	@Step("Verify 'Transfer To Your Account' page header")
	public void verifyTransferToYourAccountPageHeader() throws Exception {
		try {
			wait.fluentWaitForElement(TransferToOwnAccountPageHeader);
			Asserts.assertTrue(isElementVisible(TransferToOwnAccountPageHeader),
					CommonTestData.TRANSFER_TO_YOUR_ACCOUNT.getEnumValue() + " Page Header not displaying.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION",
					" Failed to verify 'Transfer To Your Account' page header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION",
					" Failed to verify 'Transfer To Your Account' page header", e);
		}
	}

	// If User has multiple accounts then select fund source account
	@Step("'Select Fund Source Account' If User has multiple accounts.")
	public void SelectFundSourceAccount(String expectedSourceAccount) throws Exception {
		try {
			if (isElementVisible2(SelectFundSourcePage)) {
				gestUtils.scrollDownIos();
				clickOnElement(SelectFundSourcePage);
				int selectedAccount = 0;
				String AccountNameList = null;
				for (int i = 0; i < selectfundSourceList.size(); i++) {
					AccountNameList = selectfundSourceList.get(i).getText();
					if (AccountNameList.equalsIgnoreCase(expectedSourceAccount)) {
						selectedAccount++;
						clickOnElement(selectfundSourceList.get(i));
						break;
					}
				}
				if (selectedAccount == 0)
					Asserts.assertFail("Select Fund Source " + expectedSourceAccount
							+ " not found in the list to initiate the fund transfer");

				handlingOfPrimarySourceOfFundPopup();
			}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Select Fund Source' and Select Account ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Select Fund Source' and Select Account ", e);
		}
	}

	@Step("Handle 'Primary Source Of Fund' Popup.")
	public void handlingOfPrimarySourceOfFundPopup() throws Exception {
		try {
			if (isElementVisible2(primarysourceOfFund)) {
				Asserts.assertEquals(getTexOfElement(primarysourceOfFund),
						CommonTestData.PRIMARY_SOURCE_ALERT_TITLE.getEnumValue(), "Message Not matching");
				ClickOnOKButton();
			}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Handle 'Primary Source Of Fund' Popup. ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Handle 'Primary Source Of Fund' Popup.  ", e);
		}
	}

	@Step("Click On OK Button.")
	public void ClickOnOKButton() throws Exception {
		try {
			clickOnElement(OKButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On OK Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On OK Button   ", e);
		}
	}
	
	@Step("Verify logout and make Another transfer button After Fund Transfer To Own Account.")
	public void VerifyAccountDetailsAfterFundTransferToOwnAccount()
			throws Exception {
		try {
			Asserts.assertTrue(logout.isDisplayed(), "Log Out Button not matching.");
			Asserts.assertTrue(MakeAnotherTransferButton.isDisplayed(),
					"MAKE ANOTHER TRANSFER Button not found.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to verify account details after fund transfer  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to verify account details after fund transfer  ", e);
		}
	}

}
