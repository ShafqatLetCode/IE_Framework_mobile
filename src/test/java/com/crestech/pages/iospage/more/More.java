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
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
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

	@ElementDescription(value = "secure icon")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='More']")
	private MobileElement searchIcon;

	@ElementDescription(value = "secure box")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSearchField[contains(@name,'Search')]")
	private MobileElement searchBox;
	
	@ElementDescription(value = "Transaction History label and button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Transaction History']")
	private MobileElement transactionHistoryBtnLabel;

	@ElementDescription(value = "'HOME' Button.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Home']")
	private MobileElement HOMEButton;
	
	@ElementDescription(value = "Logout button on paylah")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='LOG OUT']")
	private MobileElement logoutpeekbalance;
	
	@Step("Select Update Contact Details After Search.")
	public void SelectUpdateContactDetails(String searchBoxData, String valueSelectedFromList,String valueSelectedFromList2) throws Exception {
		try {
			clickOnElementOnEnable(searchIcon);
	        enterTextInTextbox(searchBox, searchBoxData); 
	        com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			List<RemoteWebElement> ElementCell = driver.findElementsByXPath("//XCUIElementTypeCell");
			if(ElementCell.size() > 0) {
			int sizeList = ElementCell.size();
			int index = 0;
			for (int i = 1; i <= sizeList; i++) {

				String xpath = "//XCUIElementTypeCell" + "[" + String.valueOf(i) + "]/XCUIElementTypeStaticText";
				String Text = driver.findElementByXPath(xpath).getText();
				if (Text.equalsIgnoreCase(valueSelectedFromList)) {
					index++;
					clickOnElement((MobileElement) driver.findElementByXPath(xpath));
					break;
				}else if (Text.equalsIgnoreCase(valueSelectedFromList2)) {  
					index++;
					clickOnElement((MobileElement) driver.findElementByXPath(xpath)); 
					break;
				} 
			}
			if(index == 0)
			Asserts.assertFail("No "+valueSelectedFromList +"element found in the search list");
			}
			else 
				Asserts.assertFail(valueSelectedFromList + " not found in the list as list size is 0");
			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select 'Update Contact Details' Module. ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select 'Update Contact Details' Module.  ", e);
		}
	}
	
	@Step("Select Peek Balance Module After Search.")
	public void SelectPeekBalanceModule() throws Exception {
		try {
			SelectModuleAfterSearch("Peek", CommonTestData.PEEK_BALANCE.getEnumValue());
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select Peek balance Module. ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select Peek balance Module.  ", e);
		}
	}

	@Step("Application Logout")
	public void clickOnLogoutButton() throws Exception {
		try {
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(logoutpeekbalance);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Log out Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On log out Button ", e);
		}
	}

	
	@Step("Click on 'Transaction History' Button")
	public void ClickOnTransactionHistory() throws Exception {
		try {
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(transactionHistoryBtnLabel);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION"," Failed to click transaction history ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION"," Failed to click transaction history ", e);
		}
	}
	
	@Step("Select 'Temporary Credit Limit Increase' Module")
	public void SelectTemporaryCreditLimitIncreaseModule() throws Exception {
		try {
			SelectModuleAfterSearch(CommonTestData.TEMP_LIMIT_INCREASE_SEARCH.getEnumValue(), CommonTestData.TEMP_LIMIT_INCREASE.getEnumValue());
		}catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select 'Temporary Credit Limit Increase' Module ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select 'Temporary Credit Limit Increase' Module ", e);
		}
	}
	
	@Step("Select 'Cards' Module")
	public void SelectCardsModule() throws Exception {
		try {
			SelectModuleAfterSearch("Cards", "Cards");
		}catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select 'Cards' Module ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select 'Cards' Module ", e);
		}
	}
	
	@Step("Click on 'Home' Button.")
	public void ClickOnHomeButton() throws Exception {
		try {
			if(isElementVisible2(HOMEButton)) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				clickOnElement(HOMEButton);
			}
			else
				Asserts.assertFail("Home button is not visible on Screen");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On 'Home' Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On 'Home' Button ", e);
		}
	}
	
	@Step("Select 'Local Transfer Limit' Module")
	public void SelectLocalTransferLimitModule()throws Exception {
		try {
			SelectModuleAfterSearch(
					CommonTestData.LOCAL_TRANSFER_LIMIT_SEARCHBOX_IOS.getEnumValue(),
					CommonTestData.LOCAL_TRANSFER_LIMIT_LABEL.getEnumValue());
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Select 'Temporary Credit Limit Increase' Module ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Select 'Temporary Credit Limit Increase' Module ", e);
		}
	}
	
	@Step("Click On Deposit Accounts Module.")
	public void ClickOnDepositAccountModule() throws Exception {
		try {
			SelectModuleAfterSearch("Deposit", "Deposit Accounts");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Click On Deposit Accounts Module. ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Deposit Accounts Module. ",
					e);
		}
	}
	
	public void SelectModuleAfterSearch(String searchBoxData, String expectedModule) throws Exception {
		try {
			clickOnElementOnEnable(searchIcon);
			wait.waitForElementVisibility(searchBox); 
			if (isElementEnable(searchBox)) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				enterTextInTextbox(searchBox, searchBoxData);
			}
			List<RemoteWebElement> ElementCell = driver.findElementsByXPath("//XCUIElementTypeCell");
			if (ElementCell.size() > 0) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				int sizeList = ElementCell.size();
				int index = 0;
				for (int i = 1; i <= sizeList; i++) {
					String xpath = "//XCUIElementTypeCell" + "[" + String.valueOf(i) + "]/XCUIElementTypeStaticText";
					String Text = driver.findElementByXPath(xpath).getText();
					if (Text.equalsIgnoreCase(expectedModule)) {
						index++;
						clickOnElement((MobileElement) driver.findElementByXPath(xpath));
						break;
					}
				}
					if (index == 0)
						Asserts.assertFail("Data Issue: "+expectedModule + " No element found in the list");
			} else
				Asserts.assertFail("Data Issue: "+expectedModule + " not found in the list as list size is 0");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Select Module After Search ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Select Module After Search ", e);
		}
	}
	
}
