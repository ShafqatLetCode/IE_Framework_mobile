package com.crestech.pages.androidpage.paytransfer;

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
public class payNow extends CommonAppiumTest{

	public AppiumDriver<RemoteWebElement> driver = null;
	HandleException obj_handleexception = null;
	GestureUtils gestUtils = null;
	
	
	public payNow(AppiumDriver<RemoteWebElement> driver) throws Exception {
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
	
	@ElementDescription(value = "Transfer to Thailand with PromptPay Title")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/title')]")
	private MobileElement TransfertoThailandwithPromptPayTitle;
	
	@ElementDescription(value = "Got It Button")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='GOT IT']")
	private MobileElement GOTITButton;
	
	@ElementDescription(value = "PayNow to NRIC/FIN Button")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='PayNow to NRIC/FIN']")
	private MobileElement PayNowToNRIC_FIN;
	
	@ElementDescription(value = "PayNow to UEN Button")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='PayNow to UEN']")
	private MobileElement PayNowToUEN;
	
	@ElementDescription(value = "PayNow to VPA Button")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='PayNow to VPA']")
	private MobileElement PayNowToVPA;
	
	@ElementDescription(value = "NRIC/FIN Number Field, UEN Field")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/textinput_placeholder')]")
	private MobileElement EditField;
	
	@ElementDescription(value = "VPA Number Field")
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,':id/textInputEditText')]")
	private MobileElement VPANumber_Field;
	
	@ElementDescription(value = "NEXT Button")
	//@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='NEXT']")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='NEXT']")
	private MobileElement nextButton;
	//android.widget.Button[@resource-id='com.dbs.sit1.dbsmbanking:id/btn_next']
	
	@ElementDescription(value = "Amount Editable Field")
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,':id/appCompatEditText_s')]")
	private MobileElement AmountEditableField;
	
	@ElementDescription(value = "Comments Field")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/text_purpose')]")
	private MobileElement CommentsField;
	
	@ElementDescription(value = "Page Header")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'id/text')]")
	private List<MobileElement> PageHeaderList;
	
	@ElementDescription(value = "Transfer Now Button")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='TRANSFER NOW']")
	private MobileElement TransferNowBtn;
	
	@ElementDescription(value = "Transferred Message ")
	@AndroidFindBy(xpath = "//android.widget.RelativeLayout[contains(@resource-id,':id/rl_src_layout')]")
	private MobileElement TransferredMessage;
	
	@ElementDescription(value = "Amount Verify ")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/tv_amount')]")
	private MobileElement AmountVerify;
	
	@ElementDescription(value = "back button")
	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='BACK']")
	private MobileElement backButton;
	
	@ElementDescription(value = "Log Out button")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Log Out']")
	private MobileElement LogOutButton;
	
	@ElementDescription(value = "SHARE TRANSFER DETAILS button")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='SHARE TRANSFER DETAILS']")
	private MobileElement ShareTransferDetailsButton;
	
	@ElementDescription(value = "Entity Name Title")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Entity Name']")
	private MobileElement EntityNameTitle;
	
	@Step("Verifies Entity Name Title Visibility")
	public void VerifiesEntityNameTitleVisibility() throws Exception {
		try {
		        wait.fluentWaitForElement(EntityNameTitle);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verify Entity Name Title Visibility ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify Entity Name Title Visibility ", e);
		}
	}
	
	@Step("Verifies Transferred Message")
	public void VerifiesTransferSubmittedMsg(String SuccessMsg) throws Exception {
		try {
		        wait.fluentWaitForElement(TransferredMessage);
				Asserts.assertEquals(getTexOfElement(TransferredMessage), SuccessMsg,
						SuccessMsg + " Text is not matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verify Transferred message ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify Transferred message  ", e);
		}
	}
	
	@Step("Verifies Transferred Amount")
	public void VerifiesTransferredAmount() throws Exception {
		try {
				Asserts.assertEquals(getTexOfElement(AmountVerify), CommonTestData.AMOUNTTO_TRANSFERFUND.getEnumValue() + ".00",
						CommonTestData.AMOUNTTO_TRANSFERFUND.getEnumValue() + " Text is not matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verify Transferred Amount ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify Transferred Amount  ", e);
		}
	}
	
	@Step("Verify Share Transfer Details Button.")
	public void VerifyShareTransferDetailsButton() throws Exception {
		try {
			Asserts.assertTrue(isElementVisible2(ShareTransferDetailsButton)," Share Transfer Details Button is not displaying.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verify Share Transfer Details Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify Share Transfer Details Button  ", e);
		}
	}
	
	@Step("Verify Log Out Button.")
	public void VerifyLogOutButton() throws Exception {
		try {
			Asserts.assertTrue(isElementVisible2(LogOutButton)," Log Out Button is not displaying.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verify Log Out Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify Log Out Button  ", e);
		}
	}
	
	@Step("Verify Back Button.")
	public void VerifyBackButton() throws Exception {
		try {
			Asserts.assertTrue(isElementVisible2(backButton)," Back Button is not displaying.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verify Back Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify Back Button  ", e);
		}
	}
	
	@Step("Click On Back Button.")
	public void ClickOnBackButton() throws Exception {
		try {
			clickOnElement(backButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Back Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Back Button  ", e);
		}
	}
	
	@Step("Click on Transfer Now Button.")
	public void ClickOnTransferNowButton() throws Exception {
		try {
			gestUtils.scrollUPtoObject(null, null, null);
			clickOnElement(TransferNowBtn);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click on transfer now Button ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click on transfer now Button ", e);
		}
	}
	
	@Step("Verify 'Review Transfer' page header")
	public void verifyReviewTransferPageHeader(String expectedText) throws Exception {
		try {
			MobileElement element = null;
			element = returnElementFromList(PageHeaderList, expectedText);
			if (element != null) {
				wait.fluentWaitForElement(element);
				Asserts.assertEquals(getTexOfElement(element).toLowerCase(), expectedText.toLowerCase(),
						"'Header Title' is not Matching");
			}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION", " Failed to Verify 'Review Transfer' page header  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION", " Failed to Verify 'Review Transfer' page header ", e);
		}
	}
	
	@Step("Enter Comments On Fund Transfer Page")
	public void EnterCommentForRecipientInEditField(String Comment) throws Exception {
		try {
			clickOnElement(CommentsField); 
			enterTextInTextbox(CommentsField, Comment);
			hideKeyboard();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION", " Failed to Enter comments in edit field. ",e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION", "Failed to Enter comments in edit field. ", e);
		}
	}
	
	
	
	@Step("Enter Amount On Fund Transfer Page.")
	public void EnterAmount(String textToEnter) throws Exception {
		try {
			clickOnElement(AmountEditableField);
			enterTextInTextbox(AmountEditableField, textToEnter);
			hideKeyboard();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Enter Amount ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Enter Amount ", e);
		}
	}
	
	
	@Step("Click On Next Button.")
	public void ClickOnNextButton() throws Exception {
		try {
			wait.fluentWaitForElement(nextButton);
			if (wait.waitForElementToBeClickable2(nextButton)) {
				gestUtils.scrollUPtoObject("text", "NEXT", nextButton);
				clickOnElement(nextButton);
			}				  
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Next Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Next Button  ", e);
		}
	}
	
	
	@Step("Enter NRIC/FIN Number ")
	public void EnterNRIC_FIN_Number() throws Exception {
		try {
			enterTextInTextbox(EditField, CommonTestData.NRIC_FIN_NUMBER.getEnumValue());
			hideKeyboard();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Enter NRIC/FIN Number ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Enter NRIC/FIN Number ", e);
		}
	}
	
	@Step("Enter UEN Number ")
	public void EnterUEN_Number() throws Exception {
		try {
			enterTextInTextbox(EditField, CommonTestData.UEN_NUMBER.getEnumValue());
			hideKeyboard();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Enter UEN Number ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Enter UEN Number ", e);
		}
	}
	
	@Step("Enter VPA Number ")
	public void EnterVPA_Number() throws Exception {
		try {
			enterTextInTextbox(VPANumber_Field, CommonTestData.VPA_NUMBER.getEnumValue());
			hideKeyboard();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Enter VPA Number ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Enter VPA Number ", e);
		}
	}
	
	@Step("Select 'Pay Now To NRIC/FIN' ")
	public void SelectPayNowToNRIC_FIN() throws Exception {
		try {
			clickOnElement(PayNowToNRIC_FIN);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select 'Pay Now To NRIC/FIN' ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select 'Pay Now To NRIC/FIN' ", e);
		}
	}
	
	@Step("Select 'Pay Now To VPA' ")
	public void SelectPayNowToVPA() throws Exception {
		try {
			clickOnElement(PayNowToVPA);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select 'Pay Now To VPA' ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select 'Pay Now To VPA' ", e);
		}
	}
	
	@Step("Select 'Pay Now To UEN' ")
	public void SelectPayNowToUEN() throws Exception {
		try {
			clickOnElement(PayNowToUEN);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select 'Pay Now To UEN' ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select 'Pay Now To UEN' ", e);
		}
	}
	
	@Step("Handling 'Transfer to Thailand with PromptPay' Alert")
	public void handlingTransferToThailandWithPromptPayAlert(String expectecMessage) throws Exception   
	{
		try {
			if(isElementVisible2(TransfertoThailandwithPromptPayTitle)) {
				String actualMessage = getTexOfElement(TransfertoThailandwithPromptPayTitle);
				Asserts.assertEquals(actualMessage, expectecMessage, "Transfer to Thailand with PromptPay Message Not matching");
				ClickOnGotItButton();
			}
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Handling 'Transfer to Thailand with PromptPay' Alert  ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Handling 'Transfer to Thailand with PromptPay' Alert ",e);
		}
	}
	
	@Step("Click On Got It Button")
	public void ClickOnGotItButton() throws Exception {
		try {
			clickOnElement(GOTITButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Got It Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Got It Button ", e);
		}
	}
	
}
