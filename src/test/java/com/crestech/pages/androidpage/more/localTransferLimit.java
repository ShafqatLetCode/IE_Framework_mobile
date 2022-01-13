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
import com.crestech.pages.androidpage.enterPasscode;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;

public class localTransferLimit extends CommonAppiumTest{

	public AppiumDriver<RemoteWebElement> driver = null;
	HandleException obj_handleexception = null;
	GestureUtils gestUtils = null;
	enterPasscode enterpasscode = null;
	public localTransferLimit(AppiumDriver<RemoteWebElement> driver) throws Exception {
		super(driver);
		try {
			this.driver = driver;
			obj_handleexception = new HandleException(null, null);
			gestUtils = new GestureUtils(driver);
			enterpasscode = new enterPasscode(driver);
			PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@ElementDescription(value = "AccountList in Local fund transfer Limit")
	@AndroidFindBy(xpath = "//android.widget.RelativeLayout//android.widget.TextView[contains(@resource-id,':id/text')]")
	private List<MobileElement> localTransferLimitAccountList;
	
	@ElementDescription(value = "Next button")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='NEXT']")
	private MobileElement nextButton;
	
	@ElementDescription(value = "Next button")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='CONFIRM']")
	private MobileElement confirmButton;
	
	@ElementDescription(value = "'Current Limit' label and button")
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'id/edit_user_id')]")
	private MobileElement currentLimitTextButton;
	
	@ElementDescription(value = "Page Header List")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'id/text')]")
	private List<MobileElement> PageHeaderList;
	
	@ElementDescription(value = "'Current Limit' Value")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'id/text_src_acc_name')]")
	private List<MobileElement> currentLimitAmountValue;
	
	@ElementDescription(value = "'CHANGE DAILY LIMIT NOW' button")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='CHANGE DAILY LIMIT NOW']")
	private MobileElement changeDailyLimitButton;
	
	@ElementDescription(value = "'successful Title' label")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'id/text_top_nav_title')]")
	private MobileElement successTitleLabel;
	
	@ElementDescription(value = "'Back To more' button")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='BACK TO MORE']")
	private MobileElement backToMoreButton;
	
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
	
	@ElementDescription(value = "Page Header")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'id/text')]")
	private MobileElement PageHeader;
	
	@Step("Verify Amount display After Limit get Changed")
	public void verifyDisplayAmountLocalTransferLimitChange(String expectedText) throws Exception {
		try {
			String currentText = getTexOfElement(currentLimitTextButton);
			String[] arrOfStr = currentText.split(" ");
			String acutalText = arrOfStr[1];
			Asserts.assertEquals(acutalText, expectedText, "'Amount display' After Limit get Changed is Wrong");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify Display Amount Local Transfer Limit Change ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify Display Amount Local Transfer Limit Change ", e);
		}
	}

	@Step("Handling Set Current Limit")
	public String handlingSetCurrentLimit(String AmountToBeselected) throws Exception {
		try {
			String currentText = getTexOfElement(currentLimitTextButton);
			String[] arrOfStr = currentText.split(" ");
			String flag = null;
			verifyClickSetCurrentLimit();
			String selectedValue = null;
			if (arrOfStr[1].equalsIgnoreCase(CommonTestData.SELECTED_LIMIT_0.getEnumValue())) {
				selectedValue = selectAmountFromSetCurrentLimitList(AmountToBeselected);
			} else if (arrOfStr[1].equalsIgnoreCase(CommonTestData.SELECTED_LIMIT_50000.getEnumValue())) {
				gestUtils.scrollDOWNtoObject("text", "500.00", null);
				ChangeLocalFundsTransferLimitReset();
				currentText = getTexOfElement(currentLimitTextButton);
				verifyClickSetCurrentLimit();
				arrOfStr = currentText.split(" ");
				if (arrOfStr[1].equalsIgnoreCase(CommonTestData.SELECTED_LIMIT_500.getEnumValue()))
					selectedValue = selectAmountFromSetCurrentLimitList(AmountToBeselected);
			} else
				selectedValue = selectAmountFromSetCurrentLimitList(AmountToBeselected);
			return selectedValue;
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Set Current Limit ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Set Current Limit ", e);
		}
		return null;
	}
	
	@Step("Select amount from the List of 'set current Limit' ")
	public String selectAmountFromSetCurrentLimitList(String amount) throws Exception {
		try {
			int l = currentLimitAmountValue.size();
			int index = 0;
			String elementFromList = null;
			String selectedAmount = null;
			for (int i = 0; i < l; i++) {
				elementFromList = currentLimitAmountValue.get(i).getText();
				if (elementFromList.equalsIgnoreCase(amount)) {
					selectedAmount = elementFromList;
					index++;
					clickOnElement(currentLimitAmountValue.get(i));
					break;
				}
			}
			Asserts.assertTrue(index > 0, "No" + amount + "found in the list of corresponding value");
			return selectedAmount;
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Set Amount from Current Limit ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Set Amount from Current Limit ", e);
		}
		return null;
	}
	
	
	@Step("click On 'set current Limit' ")
	public void verifyClickSetCurrentLimit() throws Exception {
		try {
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(currentLimitTextButton);
			verifyPageHeader(CommonTestData.SET_DAILY_LIMIT_TITLE.getEnumValue(),
					PageHeaderList.get(4));
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to click On 'set current Limit' ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to click On 'set current Limit' ", e);
		}
	}
	

	@Step("Verifying page header")
	public void verifyPageHeader(String expectedText, MobileElement ele) throws Exception {
		try {
			wait.fluentWaitForElement(ele);
			Asserts.assertEquals(getTexOfElement(ele).toLowerCase(), expectedText.toLowerCase(),
					"'Header Title' is not Matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION", " Failed to verify page header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION", " Failed to verify page header ", e);
		}
	}
	
	@Step("Verifying 'Local Transfer Limit' page header")
	public void verifyLocalTransferLimitPageHeader(String expectedText) throws Exception {
		try {
			wait.fluentWaitForElement(PageHeader);
			Asserts.assertEquals(getTexOfElement(PageHeader).toLowerCase(), expectedText.toLowerCase(),
					"'Header Title' is not Matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION", " Failed to verify 'Local Transfer Limit' page header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION", " Failed to verify 'Local Transfer Limit' page header ", e);
		}
	}
	
	@Step("Verifying 'Transfer To Other' page header")
	public void verifyTransferToOtherPageHeader(String expectedText) throws Exception {
		try {
			
			MobileElement element = null;
			element = returnElementFromList(PageHeaderList, expectedText);
			if (element != null) {
				wait.fluentWaitForElement(element);
				Asserts.assertEquals(getTexOfElement(element).toLowerCase(), expectedText.toLowerCase(),
						"'Header Title' is not Matching");
			}
			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION", " Failed to verify 'Transfer To Other' page header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION", " Failed to verify 'Transfer To Other' page header ", e);
		}
	}

	@Step("Click On Next Button.")
	public void ClickOnNextButton() throws Exception {
		try {
			if(isElementVisible2(nextButton)) {
				gestUtils.scrollUPtoObject("text", "NEXT", nextButton);
				 com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				clickOnElement(nextButton);			
			}else if(isElementVisible2(confirmButton)) {			
					gestUtils.scrollUPtoObject("text", "CONFIRM", confirmButton);
					 com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
					clickOnElement(confirmButton);
			}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Next Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Next Button  ", e);
		}
	}

	@Step("Click on 'Account type' From List under Local fund Limit page'")
	public void selectAccountTypeInLocalFundTransfer(String AccountToBeSelected) throws Exception {
		try {
			if (localTransferLimitAccountList.size() > 0) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				int l = localTransferLimitAccountList.size();
				int index = 0;
				String accountFromList = null;
				for (int i = 0; i < l; i++) {
					accountFromList = localTransferLimitAccountList.get(i).getText();
					if (accountFromList.equalsIgnoreCase(AccountToBeSelected)) {
						index++;
						clickOnElement(localTransferLimitAccountList.get(i));
						break;
					}
				}
                if(index == 0)
				Asserts.assertFail("No " + AccountToBeSelected + " found in the list of corresponding value");

			} else 
				Asserts.assertFail(AccountToBeSelected + " not found in the list as list size is 0");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select Account Type ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select Account Type ", e);
		}
	}
	
	@Step("Change reset local fund transfer limit")
	public void ChangeLocalFundsTransferLimitReset() throws Exception {
		try {
			String amountSlected = handlingSetCurrentLimit(CommonTestData.SELECTED_LIMIT_500.getEnumValue());
			ClickOnNextButton();
			verifyClickChangeDailyLimitNowButton();
			ClickOnBackToMoreButton();
			sendDataInCommonSearchBoxAndSelectFromDropDown(CommonTestData.LOCAL_TRANSFER_LIMIT_LABEL.getEnumValue(),
					CommonTestData.LOCAL_TRANSFER_LIMIT_LABEL.getEnumValue());
			enterpasscode.EnterPasscodeAndDone();
			verifyPageHeader(CommonTestData.LOCAL_TRANSFER_LIMIT_LABEL.getEnumValue(), PageHeader);
			selectAccountTypeInLocalFundTransfer(CommonTestData.TO_OTHERBANK_LABEL.getEnumValue());
			verifyClickSetCurrentLimit();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("TESTCASE_EXCEPTION",
					" Failed to Exceute Change Local Funds Transfer Limit ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("TESTCASE_EXCEPTION",
					" Failed to Exceute Change Local Funds Transfer Limit ", e);
		}
	}
	
	@Step("Enter the text in search and select the corresponding value in the dropdown")
	public void sendDataInCommonSearchBoxAndSelectFromDropDown(String searchBoxData, String valueSelectedFromList)
			throws Exception {
		try {
			clickOnElement(searchIcon);
			enterTextInTextbox(searchBox, searchBoxData);

			if (searchTextElement.size() > 0) {
				 com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				List<MobileElement> Elementlist = searchTextElement;
				List<MobileElement> ElementlistClickable = searchClickableElement;
				int l = Elementlist.size();
				int index = 0;
				String elementFromList = null;
				for (int i = 0; i < l; i++) {
					elementFromList = Elementlist.get(i).getText();
					if (elementFromList.equalsIgnoreCase(valueSelectedFromList)) {
						index++;
						clickOnElement(ElementlistClickable.get(i));
						break;
					}
				}
				Asserts.assertTrue(index > 0, "No element found in the list of corresponding value");
			} else
				Asserts.assertFail(valueSelectedFromList + " not found in the list as list size is 0");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select Data From Dropdown.  ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select Data From Dropdown.  ", e);
		}
	}
	
	@Step("Verifying and click 'BACK TO MORE' BUTTON ")
	public void ClickOnBackToMoreButton() throws Exception {
		try {
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElementOnEnable(backToMoreButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Click On Back To More Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Back To More Button  ", e);
		}
	}


	@Step("Click On 'CHANGE DAILY LIMIT NOW' BUTTON from Review Daily limit page and Verify 'Local Transfer Limit Changed!' Title  ")
	public void verifyClickChangeDailyLimitNowButton() throws Exception {
		try {
			verifyPageHeader(CommonTestData.REVIEW_DAILY_LIMIT_TITLE.getEnumValue(),
					PageHeaderList.get(4));
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(changeDailyLimitButton);
			enterpasscode.EnterPasscodeAndDone();
			Asserts.assertEquals(getTexOfElement(successTitleLabel),
					CommonTestData.LOCAL_TRANSFER_CAHNGE_TITLE.getEnumValue(), "'Header Title' is not Matching");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Click On Change Daily Limit Now Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Click On Change Daily Limit Now Button  ", e);
		}
	}
	
	
	

	
}
