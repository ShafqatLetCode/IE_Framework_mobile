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
public class temporaryCreditLimitIncrease extends CommonAppiumTest{

	
	public AppiumDriver<RemoteWebElement> driver = null;
	HandleException obj_handleexception = null;
	GestureUtils gestUtils = null;
	
	public temporaryCreditLimitIncrease(AppiumDriver<RemoteWebElement> driver) throws Exception {
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
	
	@ElementDescription(value = "Amount Enter credilimt EditBox")
	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='Please enter an amount']")
	private MobileElement amountCreditLimt;

	@ElementDescription(value = "Purpose option")
	@AndroidFindBy(xpath = "(//android.widget.EditText[contains(@resource-id,'id/edit_user_id')])[2]")
	private MobileElement purposeOption;

	@ElementDescription(value = "Purpose List")
	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.TextView")
	private List<MobileElement> PurposeList;

	@ElementDescription(value = "duration option")
	@AndroidFindBy(xpath = "(//android.widget.EditText[contains(@resource-id,'id/edit_user_id')])[1]")
	private MobileElement durationOption;

	@ElementDescription(value = "select date oct 11")
	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='11'])[1]")
	private MobileElement selectDateOctEleven;

	@ElementDescription(value = "OK Button")
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.dbs.sit1.dbsmbanking:id/tv_ok_id']")
	private MobileElement OKButton;
	
	@ElementDescription(value = "Next button")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='NEXT']")
	private MobileElement nextButton;
	
	@ElementDescription(value = "Page Header")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'id/text')]")
	private List<MobileElement> PageHeaderList;
	
	@ElementDescription(value = "Page Header")
	@AndroidFindBy(xpath = "//android.widget.RelativeLayout//android.widget.TextView[contains(@resource-id,':id/text')]")
	private MobileElement PageHeader;
	
	@Step("Verify 'Review Application' page header")
	public void verifyReviewApplicationPageHeader(String expectedText) throws Exception {
		try {
			MobileElement element = null;
			element = getElement(PageHeaderList, CommonTestData.REVIEW_APPLICATION_CREDITLIMIT_TITLE.getEnumValue());
			if (element != null) {
				wait.fluentWaitForElement(element);
				Asserts.assertEquals(getTexOfElement(element).toLowerCase(), expectedText.toLowerCase(),
						"'Header Title' is not Matching");
			}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION"," Failed to verify 'Review Application' page header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION"," Failed to verify 'Review Application' page header ", e);
		}
	}
	
	@Step("Verify 'Temp Limit Increase' page header")
	public void verifyTempLimitIncreasePageHeader(String expectedText) throws Exception {
		try {
				wait.fluentWaitForElement(PageHeader);
				Asserts.assertEquals(getTexOfElement(PageHeader).toLowerCase(), expectedText.toLowerCase(),
						"'Header Title' is not Matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION"," Failed to verify 'Temp Limit Increase' page header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION"," Failed to verify 'Temp Limit Increase' page header ", e);
		}
	}
	
	public MobileElement getElement(List<MobileElement> elementList, String elementTextToBeVerified)
			throws Exception {
		MobileElement element = null;
		try {
			if (elementList.size() > 0) {
				int l = elementList.size();

				String accountFromList = null;
				for (int i = 0; i < l; i++) {
					accountFromList = elementList.get(i).getText();
					if (accountFromList.contains(elementTextToBeVerified)) {
						element = elementList.get(i);
						break;
					}
				}
				return element;
			} else
				Asserts.assertFail(elementTextToBeVerified + " not found in the list as list size is 0");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("ELEMENTNOTINLIST_EXCEPTION"," Failed to get Element :: " + elementTextToBeVerified , e);
		} catch (Exception e) {
			obj_handleexception.throwException("ELEMENTNOTINLIST_EXCEPTION", " Failed to get Element :: " + elementTextToBeVerified, e);
		}
		return element;
	}
	
	@Step("Click On Next Button.")
	public void ClickOnNextButton() throws Exception {
		try {
			gestUtils.scrollUPtoObject("text", "NEXT", nextButton);
			if(isElementVisible2(nextButton))
					clickOnElement(nextButton);
			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click on Next Button. ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", "  Failed to Click on Next Button. ", e);
		}
	}
	

	@Step("Enter Amount")
	public void EnterAmount(String textToEnter) throws Exception {
		try {
			clickOnElement(amountCreditLimt);
			enterTextInTextbox(amountCreditLimt, textToEnter);
			hideKeyboard();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Enter Amount ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Enter Amount ", e);
		}
	}
	
	@Step("Select Purpose")
	public void SelectPurpose(String purpose) throws Exception {
		try {
			clickOnElement(purposeOption);
			
			if (PurposeList.size() > 0) {
				int l = PurposeList.size();
				int index = 0;
				String purposedFromList = null;
				for (int i = 0; i < l; i++) {
					purposedFromList = PurposeList.get(i).getText();
					if (purposedFromList.equalsIgnoreCase(purpose)) {
						index++;
						clickOnElement(PurposeList.get(i));
						break;
					}
				}
			
			if(index==0)
				Asserts.assertFail("Purpose "+purpose+" Not Found in the list.");
		} else
			Asserts.assertFail("Purpose " + purpose + " not found in the list as list size is 0");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select Purpose ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Enter Amount ", e);
		}
	}

	@Step("Set Duration for credit Limit Increase")
	public void SetDuration() throws Exception {
		try {
			clickOnElement(durationOption);
			clickOnElement(selectDateOctEleven);
			clickOnElement(OKButton);
			clickOnElement(durationOption);
			clickOnElement(selectDateOctEleven);
			clickOnElement(OKButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Set Duration ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Set Duration ", e);
		}
	}
	
}
