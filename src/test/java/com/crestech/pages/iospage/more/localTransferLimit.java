package com.crestech.pages.iospage.more;

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
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

/**
 * @author Divya
 *
 */
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
	
	@ElementDescription(value = "Local transfer limit label")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Local Transfer Limit']")
	private MobileElement localTransferLimitLabel;

	@ElementDescription(value = "To other bank button ")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='To Other Banks']")
	private MobileElement toOtherBankButton;
	
	@ElementDescription(value = "'Current Limit' label and button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='localTransfer_dailyLimitView_detailLabel']")
	private MobileElement currentLimitTextButton;
	
	@ElementDescription(value = "Next Button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='NEXT']")
	private MobileElement nextButton;
	
	@ElementDescription(value = "'Review daily limit' label title")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Review Daily Limit']")
	private MobileElement reviewDailyLimitTitle;
	
	@ElementDescription(value = "'change daily limit now' button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='localTransfer_dailyLimitConfirmationView_changeDailyLimitButton']")
	private MobileElement changeLimitNowButton;
	
	@ElementDescription(value = " 'Local Transfer limit Changed!' Title")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Local Transfer limit Changed!']")
	private MobileElement localTransferLimitChangedTitle;
	
	@ElementDescription(value = " 'backToMoreButton' button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='BACK TO MORE']")
	private MobileElement backToMoreButton;


	@Step("click on 'BACK TO MORE' BUTTON ")
	public void ClickOnBackToMoreButton() throws Exception {
		try {
			    com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				clickOnElement(backToMoreButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to click 'BACK TO MORE' BUTTON ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to click 'BACK TO MORE' BUTTON ", e);
		}
	}

	@Step("Verify 'Local Transfer limit Changed' field")
	public void verifyLocalTransferlimitChangedHeader(String expectedText) throws Exception {
		try {
			Asserts.assertEquals(getTexOfElement(localTransferLimitChangedTitle).trim().toLowerCase(), expectedText.toLowerCase(),expectedText+ " text is not matching.");
		}catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verify 'Local Transfer limit Changed' field ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify 'Local Transfer limit Changed' field ", e);
		}
	}

	@Step("Verifying and click 'CHANGE DAILY LIMIT NOW' BUTTON ")
	public void verifyClickChangeDailyLimitNowButton() throws Exception {
		try {
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(changeLimitNowButton);
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Verifying and click 'CHANGE DAILY LIMIT NOW' BUTTON  " ,e);	
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Verifying and click 'CHANGE DAILY LIMIT NOW' BUTTON  ",e);
		}
	}
	
	@Step("Verifying page header 'Review Daily Limit'")
	public void verifyReviewDailyLimitTitle() throws Exception {
		try {
			Asserts.assertEquals(getTexOfElement(reviewDailyLimitTitle).trim().toLowerCase(), CommonTestData.REVIEW_DAILY_LIMIT_TITLE.getEnumValue().toLowerCase(),
					CommonTestData.REVIEW_DAILY_LIMIT_TITLE.getEnumValue() + " text is not found");
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Verifying page header 'Review Daily Limit' " ,e);	
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Verifying page header 'Review Daily Limit' ",e);
		}
	}
	
	@Step("Click On Next Button")
	public void ClickOnNextButton() throws Exception {
		try {
			    com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				clickOnElement(nextButton);
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Next Button ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Next Button ",e);
		}
	}
	
	@Step("Verifying 'Local Transfer Limit' page header")
	public void verifyLocalTransferLimitPageHeader(String expectedText) throws Exception {
		try {
			wait.fluentWaitForElement(localTransferLimitLabel);
			Asserts.assertEquals(getTexOfElement(localTransferLimitLabel).trim().toLowerCase(), expectedText.toLowerCase(),expectedText+  " text is not matching.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("VERIFYHEADER_EXCEPTION", " Failed to verify 'Local Transfer Limit' page header ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("VERIFYHEADER_EXCEPTION", " Failed to verify 'Local Transfer Limit' page header ", e);
		}
	}
	
	@Step("Verify Amount display After Limit get Changed")
	public void verifyDisplayAmountLocalTransferLimitChange(String expectedText) throws Exception {
		try {
			String[] arrOfStr = getTexOfElement(currentLimitTextButton).split(" ");
			String acutalText = arrOfStr[1];
			Asserts.assertEquals(acutalText, expectedText, "'Amount display' After Limit get Changed is Wrong");
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Verify Display Amount Local Transfer Limit Change ",e);		
		}
		catch (Exception e) {				
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Verify Display Amount Local Transfer Limit Change ",e);
		}
	}
	
	@Step("Click on 'Account type' From List under Local fund Limit page'")
	public void selectAccountTypeInLocalFundTransfer() throws Exception {
		try {
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(toOtherBankButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select Account Type ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select Account Type ", e);
		}
	}
	
	@Step("Handling Set Current Limit")
	public String handlingSetCurrentLimit(String AmountToBeselected) throws Exception {
		try {
			String currentText = getTexOfElement(currentLimitTextButton);
			String[] arrOfStr = currentText.split(" ");
			ClickOnSetCurrentLimit();
		
			String selectedValue = null;
			if (arrOfStr[1].equalsIgnoreCase(CommonTestData.SELECTED_LIMIT_0.getEnumValue())) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				selectedValue = selectAmountFromSetCurrentLimitList2(AmountToBeselected);
			} else {
				gestUtils.scrollDOWNtoObject("text", CommonTestData.SELECTED_LIMIT_0.getEnumValue(), null);
				String flag = selectAmountFromSetCurrentLimitList(CommonTestData.SELECTED_LIMIT_0.getEnumValue());
				currentText = getTexOfElement(currentLimitTextButton);
				ClickOnSetCurrentLimit();
				arrOfStr = currentText.split(" ");
				if (arrOfStr[1].equalsIgnoreCase(CommonTestData.SELECTED_LIMIT_0.getEnumValue()))
					selectedValue = selectAmountFromSetCurrentLimitList2(AmountToBeselected);
			}
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

			String selectedAmount = null;
			List<RemoteWebElement> ElementCell = driver.findElementsByXPath("//XCUIElementTypeCell");
			int sizeList = ElementCell.size();
			int index = 0;
			for (int i = 1; i <= sizeList; i++) {
				String xpath = "//XCUIElementTypeCell" + "[" + String.valueOf(i) + "]/XCUIElementTypeStaticText";
				String Text = driver.findElementByXPath(xpath).getText();
				System.out.println(Text);
				if (Text.equalsIgnoreCase(amount)) {
					selectedAmount = Text;
					index++;
					clickOnElement((MobileElement) driver.findElementByXPath(xpath));
					break;
				}
			}
			if(index==0)
			Asserts.assertFail( "No" + amount + "found in the list of corresponding value");
			return selectedAmount;

		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Set Amount from Current Limit " ,e);	
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Set Amount from Current Limit ",e);
		}
		return null; 
	}
	
	@Step("Select amount from the List of 'set current Limit' ")
	public String selectAmountFromSetCurrentLimitList2(String amount) throws Exception {
		try {

			String selectedAmount = null;
			List<RemoteWebElement> ElementCell = driver.findElementsByXPath("//XCUIElementTypeCell/XCUIElementTypeStaticText");
			int sizeList = ElementCell.size();
			int index = 0;
			for (int i = 0; i < sizeList; i++) {
				String Text = ElementCell.get(i).getText();
				if (Text.equalsIgnoreCase(amount)) {
					selectedAmount = Text;
					index++;
					ElementCell.get(i).click();
					break;
				}
			}
			
			if(index == 0)
			Asserts.assertFail("No" + amount + "found in the list of corresponding value");
			return selectedAmount;

		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Set Amount from Current Limit " ,e);	
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Set Amount from Current Limit ",e);
		}
		return null; 
	}
	
	@Step("Click On 'set current Limit' ")
	public void ClickOnSetCurrentLimit() throws Exception {
		try {
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(currentLimitTextButton);
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click on Set Current Limit " ,e);	
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click on Set Current Limit ",e);
		}
	}

}
