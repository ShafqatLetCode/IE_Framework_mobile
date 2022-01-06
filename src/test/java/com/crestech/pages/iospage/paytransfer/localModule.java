package com.crestech.pages.iospage.paytransfer;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
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
public class localModule extends CommonAppiumTest{
	
	public AppiumDriver<RemoteWebElement> driver = null;
	HandleException obj_handleexception = null;
	GestureUtils gestUtils = null;
	
	public localModule(AppiumDriver<RemoteWebElement> driver) throws Exception {
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
	
	@ElementDescription(value = "'Close' Button After adding Payee")
	@FindBy(name = "close")
	private MobileElement closeButton;
	
	@ElementDescription(value = "Add Recipient Now button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='ADD RECIPIENT NOW']")
	private MobileElement AddRecipientNowButton;
	
	@ElementDescription(value = "Add Local Recipient button")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Add Local Recipient'])[1]")
	private MobileElement AddLocalRecipientButton;
	
	@ElementDescription(value = "Local Transfer & Pay Now Page Header")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Local Transfer & PayNow']")
	private MobileElement LocalTransferPayNowPageHeader;
	
	@ElementDescription(value = "Select Bank Account")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Bank Account']")
	private MobileElement SelectBankAccount;
	
	@ElementDescription(value = "Done button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Done']")
	private MobileElement doneButton;
	
	@ElementDescription(value = "Next Button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='NEXT']")
	private MobileElement nextButton;
	
	@ElementDescription(value = "next Button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='NEXT']")
	private MobileElement NEXTButton;
	
	@ElementDescription(value = "'Add Recipient Now' Button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='ADD RECIPIENT NOW']")//
	private MobileElement ADDRecipientNowButton;
	
	@ElementDescription(value = "Logout button on paylah")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Log Out']")
	private MobileElement logout;
	
	@ElementDescription(value = "Log Out Button After adding Payee")
	@FindBy(name = "Log Out")
	private MobileElement LogoutBtn;
	
	@ElementDescription(value = "'Make A Transfer' Button After adding Payee")
	@FindBy(name = "MAKE A TRANSFER")
	private MobileElement makeTransferButton;
	
	@ElementDescription(value = "'Recipient's Name' text dispalying After adding Payee.")
	@FindBy(name = "Recipient's Name")
	private MobileElement RecipientNameText;
	
	@ElementDescription(value = "'Recipient's Bank' text dispalying After adding Payee.")
	@FindBy(name = "Recipient's Bank")
	private MobileElement RecipientBankText;
	
	@ElementDescription(value = "'Recipient's Account No.' text dispalying After adding Payee.")
	@FindBy(name = "Recipient's Account No.")
	private MobileElement RecipientAccountNo;
	
	@Step("Verify Account Number")
	public void VerifyAccountNumber(String AccountNumber) throws Exception {
		try {
			Asserts.assertTrue(RecipientAccountNo.isDisplayed(),
					"'Recipient's Account No.' text is not dispalying After adding Payee.");
			String AccountNumberXpath = "//XCUIElementTypeStaticText[@name='" + AccountNumber + "']";
			MobileElement AccountNumberElement = (MobileElement) driver.findElement(By.xpath(AccountNumberXpath));
			Asserts.assertEquals(getTexOfElement(AccountNumberElement), AccountNumber,
					AccountNumber + " is not matching after adding payee");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verify Account Number ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify Account Number ", e);
		}
	}
	
	@Step("Verify Validation For Payee Add.")
	public void verifyValidationForPayeeAdd(String ExpectedRecipientName, String BankName, String AccountNumber)
			throws Exception {
		try {
			verifyLogOutButton();
			verifyMakeTransferButton();
			verifyCloseButton();
			VerifyRecipientName(ExpectedRecipientName);
			VerifyBankName(BankName);
			VerifyAccountNumber(AccountNumber);
		}catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verify Validation For Payee Add. ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify Validation For Payee Add. ", e);
		}
	}
	
	@Step("Verify Bank Name")
	public void VerifyBankName(String BankName) throws Exception {
		try {
			Asserts.assertTrue(RecipientBankText.isDisplayed(),
					"'Recipient's Bank' text is not dispalying After adding Payee.");
			String BankNameXpath = "//XCUIElementTypeStaticText[@name='" + BankName + "']";
			MobileElement BankNameElement = (MobileElement) driver.findElement(By.xpath(BankNameXpath));
			Asserts.assertEquals(getTexOfElement(BankNameElement), BankName,
					BankName + " is not matching after adding payee");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verify Bank Name ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify Bank Name ", e);
		}
	}
	
	@Step("Verify Recipient Name")
	public void VerifyRecipientName(String ExpectedRecipientName) throws Exception {
		try {
			Asserts.assertTrue(RecipientNameText.isDisplayed(),
					"'Recipient's Name' text is not dispalying After adding Payee.");
			String RecipientNameXpath = "//XCUIElementTypeStaticText[@name='" + ExpectedRecipientName + "']";
			MobileElement RecipientNameElement = (MobileElement) driver.findElement(By.xpath(RecipientNameXpath));
			Asserts.assertEquals(getTexOfElement(RecipientNameElement), ExpectedRecipientName,
					ExpectedRecipientName + " is not matching after adding payee");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verify Recipient Name ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify Recipient Name ", e);
		}
	}
	
	@Step("Verify Close Button")
	public void verifyCloseButton() throws Exception {
		try {
			Asserts.assertTrue(closeButton.isDisplayed(), "Close Button not found.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to verify Close Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to verify Close Button ", e);
		}
	}
	
	@Step("Verify Make Transfer Button")
	public void verifyMakeTransferButton() throws Exception {
		try {
			Asserts.assertTrue(makeTransferButton.isDisplayed(),
					"Make A Transfer Button not found.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to verify Make A Transfer Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to verify Make A Transfer Button ", e);
		}
	}
	
	@Step("Verify Logout Button")
	public void verifyLogOutButton() throws Exception {
		try {
			Asserts.assertTrue(LogoutBtn.isDisplayed(), "Log Out Button not found.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to verify LogOut Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to verify LogOut Button ", e);
		}
	}
	
	@Step("Verify 'You Have Added Recipient Msg'.")
	public void VerifyYouHaveAddedRecipientMsg() throws Exception {
		try {
			wait.fluentWaitForElement(logout);

			List<RemoteWebElement> youHaveAddedRecipient = driver.findElements(By.name("You've added a recipient"));
			Asserts.assertEquals(
					getTexOfElement((MobileElement) youHaveAddedRecipient.get(youHaveAddedRecipient.size() - 1)),
					CommonTestData.YOU_HAVE_ADDED_RECIPIENT_MSG2.getEnumValue(),
					CommonTestData.YOU_HAVE_ADDED_RECIPIENT_MSG2.getEnumValue() + " Text is not matching");

		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify 'You Have Added Recipient Msg' ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify 'You Have Added Recipient Msg' ", e);
		}
	}

	@Step("Click On 'ADD RECIPIENT NOW' button")
	public void ClickOnAddRecipientNowBtn() throws Exception {
		try {
			clickOnElement(ADDRecipientNowButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Click On ADD RECIPIENT NOW Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On ADD RECIPIENT NOW Button ",
					e);
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
	
	@Step("Verify 'Review Recipient's Details' page header")
	public void verifyReviewRecipientDetailsPageHeader() throws Exception {
		try {
			List<RemoteWebElement> recipientDetailsHeader = driver.findElements(By.name("Review Recipient's Details"));
			Asserts.assertTrue(isElementVisible2((MobileElement) recipientDetailsHeader.get(recipientDetailsHeader.size()-1)),
					CommonTestData.REVIEW_RECIPIENT_DETAILS.getEnumValue() + " Page Header not displaying.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION", " Failed to Verify 'Review Recipient Details' page header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION", " Failed to Verify 'Review Recipient Details' page header ", e);
		}
	}
	
	@Step("Click On Next Button")
	public void ClickOnNextButton() throws Exception {
		try {
				clickOnElement(nextButton);
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Next Button ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Next Button ",e);
		}
	}
	
	@Step("Enter Recipient Details.")
	public void EnterRecipientDetails(String ExpectedRecipientName, String BankName,
			String AccountNumber) throws Exception {
		try {
			EnterRecipientName(ExpectedRecipientName);
			SelectBankName(BankName);
			EnterAccountNumber(AccountNumber);
			clickOnDoneButton();
		}catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Enter Recipient Details ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Enter Recipient Details  ", e);
		}
	}
	
	@Step("Enter Account Number")
	public void EnterAccountNumber(String AccountNumber) throws Exception {
		try {
			List<RemoteWebElement> enterAccountNumberEditField = driver.findElements(By.name("Enter account no."));
			enterTextInTextbox((MobileElement) enterAccountNumberEditField.get(enterAccountNumberEditField.size()-1), AccountNumber);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Enter Account Number ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Enter Account Number ", e);
		}
	}

	@Step("Enter Recipient Name")
	public void EnterRecipientName(String ExpectedRecipientName) throws Exception {
		try {
			List<RemoteWebElement> recipientName = driver.findElements(By.name("Enter recipient's name"));
			enterTextInTextbox((MobileElement) recipientName.get(recipientName.size()-1), ExpectedRecipientName);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Enter Recipient Name ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Enter Recipient Name ", e);
		}
	}

	@Step("Select Bank Name")
	public void SelectBankName(String BankName) throws Exception {
		try {
			List<RemoteWebElement> selectBankDropdown = driver.findElements(By.name("Select bank"));
			clickOnElement((MobileElement) selectBankDropdown.get(selectBankDropdown.size()-1));
			List<RemoteWebElement> searchBankNameField = driver.findElements(By.name("Search Bank Name"));
			clickOnElement((MobileElement) searchBankNameField.get(searchBankNameField.size()-1));
			enterTextInTextbox((MobileElement) searchBankNameField.get(searchBankNameField.size()-1), BankName);
			
			MobileElement Selectbank = (MobileElement) driver.findElement(By.name(BankName));
			clickOnElement(Selectbank);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select Bank Name ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select Bank Name ", e);
		}
	}
	
	@Step("click on done button")
	public void clickOnDoneButton() throws Exception {
		try {
			if (isElementVisible2(doneButton)) 
			clickOnElement(doneButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Done Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Done Button ", e);
		}
	}
	
	@Step("Verify 'Enter Recipient Details' page header")
	public void verifyEnterRecipientDetailsPageHeader() throws Exception {
		try {
			List<RemoteWebElement> recipientDetailsHeader = driver.findElements(By.name("Enter Recipient's Details"));
			Asserts.assertTrue(isElementVisible2((MobileElement) recipientDetailsHeader.get(recipientDetailsHeader.size()-1)),
					" 'Enter Recipient's Details' Page Header not displaying.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION", " Failed to Verify 'Enter Recipient Details' page header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION", " Failed to Verify 'Enter Recipient Details' page header ", e);
		}
	}
	
	@Step("Select Bank Account.")
	public void SelectBankAccount() throws Exception {
		try {
			int count =0;
			do {
				clickOnElement(SelectBankAccount);
				Thread.sleep(2000);
			} while (isElementVisible2(SelectBankAccount) && count < 3);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select Bank Account ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select Bank Account ", e);
		}
	}
	
	@Step("Verify 'Local Transfer Pay Now' page header")
	public void verifyLocalTransferPayNowPageHeader() throws Exception {
		try {
			wait.fluentWaitForElement(LocalTransferPayNowPageHeader);
			Asserts.assertTrue(isElementVisible(LocalTransferPayNowPageHeader),
					" 'Local Transfer & Pay Now' Page Header not displaying.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION", " Failed to Verify 'Local Transfer Pay Now' page header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION", " Failed to Verify 'Local Transfer Pay Now' page header ", e);
		}
	}
	
	@Step("Click On Add Local Recipient Button.")
	public void clickOnAddLocalRecipientBtn() throws Exception {
		try {
			if (isElementVisible2(AddRecipientNowButton))  
				clickOnElement(AddRecipientNowButton);
			 else 
				clickOnElement(AddLocalRecipientButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Add Local Recipient Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Add Local Recipient Button ", e);
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
