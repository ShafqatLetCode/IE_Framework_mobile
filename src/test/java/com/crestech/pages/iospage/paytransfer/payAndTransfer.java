package com.crestech.pages.iospage.paytransfer;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

/**
 * @author Divya
 *
 */
public class payAndTransfer extends CommonAppiumTest{
	
	public AppiumDriver<RemoteWebElement> driver = null;
	HandleException obj_handleexception = null;
	GestureUtils gestUtils = null;
	public TouchAction touch = null;
	
	public payAndTransfer(AppiumDriver<RemoteWebElement> driver) throws Exception {
		super(driver);
		try {
			this.driver = driver;
			obj_handleexception = new HandleException(null, null);
			gestUtils = new GestureUtils(driver);
			touch = new TouchAction(this.driver);
			PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@ElementDescription(value = " Overseas button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Overseas']")
	private MobileElement overseasButton;
	
	@ElementDescription(value = "All tab")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='All']")
	private MobileElement allTab;
	
	@ElementDescription(value = "Local button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Local']")
	private MobileElement LocalButton;
	
	@ElementDescription(value = "'HOME' Button.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Home']")
	private MobileElement HOMEButton;
	
	@ElementDescription(value = "topup button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Top Up']")
	private MobileElement topUpButton;
	
	@ElementDescription(value = "'Bills' Button.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Bills']")
	private MobileElement BillsButton;
	
	@ElementDescription(value = "'Your DBS/POSB Accounts' page Header")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Your DBS/POSB Accounts'])[1]")
	private MobileElement SelectOwnAccount;
	
	@ElementDescription(value = "All tab list")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeOther/XCUIElementTypeStaticText")
	private List<MobileElement> allTabList;
	
	@ElementDescription(value = "OK Button")
	@AndroidFindBy(xpath = "//XCUIElementTypeStaticText[@name='OK']")
	private MobileElement OKButton;
	
	@ElementDescription(value = "OK Button")
	@AndroidFindBy(xpath = "//XCUIElementTypeButton[@name='OK']")
	private MobileElement OKButton1;
	
	@ElementDescription(value = "Primary source of fund")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Primary source of fund']")
	private MobileElement primarysourceOfFund;
	
	@ElementDescription(value = "Local Recipients list")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText")
	private List<MobileElement> localRecipientsList;
	
	
	@Step("Select 'To Account' From Your DBS POSB Account list.")
	public void SelectToAccountFromYourDBSPOSBAccountlist(String ToOwnAccount) throws Exception {
		try {
			wait.waitForElementVisibility(SelectOwnAccount);
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(SelectOwnAccount);

			gestUtils.DragAndDropElementToElement(allTabList.get(1), allTab);
			 Dimension windowSize = driver.manage().window().getSize();
				
				int h = windowSize.getHeight();
				int y1 = (int) (h * 0.2);
				int y2 = (int) (h - y1);
				int x = (int) ((windowSize.getWidth()) / 2);
				
				String s1 = driver.getPageSource();
				int count = 0;
				int index = 0;

				while (count == 0 && index == 0) {
					if (localRecipientsList.size() > 0) {
						com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
						int length = localRecipientsList.size();
						String LocalRecipientList = null;
						if (length < 5) {
							for (int i = 0; i < length; i++) {
								LocalRecipientList = localRecipientsList.get(i).getText();
								if (LocalRecipientList.contains(ToOwnAccount)) {
									index++;
									clickOnElement(localRecipientsList.get(i));
									break;
								}
							}
							// Exception Handling without scrolling case and no expected element found in
							// the list then index ==0
							if (index == 0 && count == 0)
								Asserts.assertFail("Your DBS/POSB Accounts ' " + ToOwnAccount
										+ " ' not found in the list to initiate the fund transfer");
							else
								break;
						} else

							// Code will work :: When Need to scroll
							for (int i = 0; i < length; i++) {
								LocalRecipientList = localRecipientsList.get(i).getText();
								if (LocalRecipientList.contains(ToOwnAccount) && isElementVisible2(localRecipientsList.get(i))) {
									index++;
									clickOnElement(localRecipientsList.get(i));
									break;
								}
							}
						if (index == 0) {
							touch.longPress(longPressOptions().withPosition(point(x, y2)).withDuration(ofSeconds(2)))
									.moveTo(element(allTab)).release().perform();

							String s2 = driver.getPageSource();
							if (s1.equals(s2) != true)
								s1 = s2;
							else
								count = 1;
						} else
							break;

						// Exception Handling in scrolling case and no expected element found in the
						// list then index ==0, count ==1
						if (count == 1 && index == 0)
							Asserts.assertFail("Your DBS/POSB Accounts ' " + ToOwnAccount
									+ " ' not found in the list to initiate the fund transfer");

					} else
						Asserts.assertFail("No receipient Found in the Local recipient list");
				}

				handlingOfPrimarySourceOfFundPopup();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Select To Account From Your DBS POSB Account list ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Select To Account From Your DBS POSB Account list ", e);
		}
	}
	
	@Step("Select 'To Account' from local Recipient list.")
	public void SelectToAccountFromLocalRecipient(String expectedLocalRecipient) throws Exception {
		try {
			Dimension windowSize = driver.manage().window().getSize();

			int h = windowSize.getHeight();
			int y1 = (int) (h * 0.2);
			int y2 = (int) (h - y1);
			int x = (int) ((windowSize.getWidth()) / 2);

			String s1 = driver.getPageSource();
			int count = 0;
			int index = 0;

			while (count == 0 && index == 0) {
				if (localRecipientsList.size() > 0) {
					com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
					int length = localRecipientsList.size();
					String LocalRecipientList = null;
					if (length < 5) {
						for (int i = 0; i < length; i++) {
							LocalRecipientList = localRecipientsList.get(i).getText();
							if (LocalRecipientList.equals(expectedLocalRecipient)) {
								index++;
								clickOnElement(localRecipientsList.get(i));
								break;
							}
						}
						// Exception Handling without scrolling case and no expected element found in
						// the list then index ==0
						if (index == 0 && count == 0)
							Asserts.assertFail("Local Recipient " + expectedLocalRecipient
									+ " not found in the list to initiate the fund transfer");
						else
							break;
					} else

						// Code will work :: When Need to scroll
						for (int i = 0; i < length; i++) {
							LocalRecipientList = localRecipientsList.get(i).getText();
							if (LocalRecipientList.equals(expectedLocalRecipient)
									&& isElementVisible2(localRecipientsList.get(i))) {
								index++;
								clickOnElement(localRecipientsList.get(i));
								break;
							}
						}
					if (index == 0) {
						touch.longPress(longPressOptions().withPosition(point(x, y2)).withDuration(ofSeconds(2)))
								.moveTo(element(allTab)).release().perform();

						String s2 = driver.getPageSource();
						if (s1.equals(s2) != true)
							s1 = s2;
						else
							count = 1;
					} else
						break;

					// Exception Handling in scrolling case and no expected element found in the
					// list then index ==0, count ==1
					if (count == 1 && index == 0)
						Asserts.assertFail("Local Recipient " + expectedLocalRecipient
								+ " not found in the list to initiate the fund transfer");

				} else
					Asserts.assertFail("No receipient Found in the Local Recipient list");
			}

			handlingOfPrimarySourceOfFundPopup();

		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Select 'To Account' from local Recipient list  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Select 'To Account' from local Recipient list  ", e);
		}
	}
	
	@Step("Click On Local Recipient Option under All Tab.")
	public void ClickOnLocalRecipient() throws Exception {
		try {
			//gestUtils.DragAndDropElementToElement(allTabList.get(1), allTab);
			int o=0;
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			for (int i = 0; i < allTabList.size(); i++) {
				String tabText = allTabList.get(i).getText();
				o++;
				if (tabText.contains(CommonTestData.LOCAL_RECIPIENT_FROMLIST.getEnumValue())) {
					clickOnElement(allTabList.get(i));
					break;
				}
			}
			
			gestUtils.DragAndDropElementToElement(allTabList.get(o-1), allTab);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Click On Local Recipient Option under All Tab. ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Click On Local Recipient Option under All Tab ", e);
		}
	}
	
	@Step("Select 'To Account' from 'Billing organisation' list")
	public void SelectToAccountFromBillingOrganisationList(String valueSelectedFromList) throws Exception {
		try {
            MobileElement ele=(MobileElement) driver.findElementByName("Billing Organisations");
			gestUtils.DragAndDropElementToElement(ele, allTab);
			Dimension windowSize = driver.manage().window().getSize();
			System.out.println("getSessionId :"+driver.getSessionId());
			
			int h = windowSize.getHeight();
			int y1 = (int) (h * 0.2);
			int y2 = (int) (h - y1);
			int x = (int) ((windowSize.getWidth()) / 2);
			
			String s1 = driver.getPageSource();
			int count = 0;
			int index = 0;
			
			while (count == 0 && index == 0) {
				if (localRecipientsList.size() > 0) {
					com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
					int length = localRecipientsList.size();
					String BillingOrganisationlist = null;
					if (length < 5) {
						for (int i = 0; i < length; i++) {
							BillingOrganisationlist = localRecipientsList.get(i).getText();
							if (BillingOrganisationlist.contains(valueSelectedFromList)) {
								clickOnElement(localRecipientsList.get(i));
								index++;
								break;
							}
						}
						// Exception Handling without scrolling case and no expected element found in
						// the list then index ==0
						if (index == 0 && count == 0)
							Asserts.assertFail("Billing Organisations " + valueSelectedFromList
									+ " not found in the list to initiate the fund transfer");
						else
							break;
					} else

						// Code will work :: When Need to scroll
						for (int i = 0; i < length; i++) {
							BillingOrganisationlist = localRecipientsList.get(i).getText();
							if (BillingOrganisationlist.contains(valueSelectedFromList) && isElementVisible2(localRecipientsList.get(i))) {
								clickOnElement(localRecipientsList.get(i));
								index++;
								break;
							}
						}
					if (index == 0) {
						touch.longPress(longPressOptions().withPosition(point(x, y2)).withDuration(ofSeconds(2)))
								.moveTo(element(allTab)).release().perform();

						String s2 = driver.getPageSource();
						if (s1.equals(s2) != true)
							s1 = s2;
						else
							count = 1;
					} else
						break;

					// Exception Handling in scrolling case and no expected element found in the
					// list then index ==0, count ==1
					if (count == 1 && index == 0)
						Asserts.assertFail("Billing Organisations " + valueSelectedFromList
								+ " not found in the list to initiate the fund transfer");

				} else
					Asserts.assertFail("No receipient Found in the Billing Organisations list");
			}

		
			handlingOfPrimarySourceOfFundPopup();
		
	} catch (HandleException e) {
		obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION"," Failed to select 'to account' from billing organisation list ", e);
	} catch (Exception e) {
		obj_handleexception.throwException("FUNCTIONAL_EXCEPTION"," Failed to select 'to account' from billing organisation list ", e);
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
	
	@Step("Handle 'Primary Source Of Fund' Popup.")
	public void handlingOfPrimarySourceOfFundPopup() throws Exception {
		try {
			if (isElementVisible2(primarysourceOfFund)) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				Asserts.assertEquals(getTexOfElement(primarysourceOfFund),
						CommonTestData.PRIMARY_SOURCE_ALERT_TITLE.getEnumValue(), "Message Not matching");
	
				if (isElementVisible2(OKButton))
					ClickOnOKButton();
				else
					clickOnElement(OKButton1);
			}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Handle 'Primary Source Of Fund' Popup. ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Handle 'Primary Source Of Fund' Popup.  ", e);
		}
	}
	
	@Step("Select Billing Organisation ")
	public void SelectBillingOrganisation() throws Exception {
		try {
			wait.waitForElementVisibility(SelectOwnAccount);
			gestUtils.DragAndDropElementToElement(allTabList.get(4), allTab);
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			driver.findElementByName("Billing Organisations").click();
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select Billing Organisation ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select Billing Organisation ",e);
		}
	}
	
	@Step("Click On Bill Module")
	public void ClickOnBillModule() throws Exception {
		try {
			wait.waitForElementToBeClickable(BillsButton);
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(BillsButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to click on bill module.", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to click on bill module. ", e);
		}
	}

	@Step("Click On Topup Paylah Module")
	public void clickOnTopUpModule() throws Exception {
		try {
			wait.waitForElementToBeClickable(topUpButton);
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(topUpButton);
		}catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On TopUp Paylah Module  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On TopUp Paylah Module  ", e);
		}
	}
	
	@Step("Click on 'Home' Button.")
	public void ClickOnHomeButton() throws Exception {
		try {
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(HOMEButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On 'Home' Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On 'Home' Button ", e);
		}
	}
	
	@Step("Click On Local Button.")
	public void clickOnLocalButton() throws Exception {
		try {
			wait.waitForElementToBeClickable(LocalButton);
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(LocalButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Local Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Local Button ", e);
		}
	}
	
	@Step("Select All TAB under Pay & Transfer.")
	public void SelectAllTAB() throws Exception {
		try {
			wait.waitForElementToBeClickable(allTab);
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(allTab);
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to select All Tab  ",e);
		}
		catch (Exception e) {		
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to select All Tab   ",e);
		}
	}
	
	@Step("Click on 'Credit Card' Option under All Tab")
	public void ClickOnCreditCard() throws Exception {
		try {
			int o = 0;
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			for (int i = 0; i < allTabList.size(); i++) {
				String tabText = allTabList.get(i).getText();
				o++;
				if (tabText.contains(CommonTestData.CREDIT_CARDS_TAB.getEnumValue())) {
					clickOnElement(allTabList.get(i));
					break;
				}
			}

			gestUtils.DragAndDropElementToElement(allTabList.get(o), allTab);

		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Click on 'Credit Card' Option under All Tab ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Click on 'Credit Card' Option under All Tab ", e);
		}
	}

	@Step("Click On Overseas Module")
	public void ClickOnOverseasModule() throws Exception {
		try {
			wait.waitForElementToBeClickable(overseasButton);
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(overseasButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Overseas Module  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Overseas Module ", e);
		}
	}

	
	@Step("Select 'To Account' From Credit Card List")
	public void SelectToAccountFromCreditCardList(String valueSelectedFromList) throws Exception {
		try {
			 Dimension windowSize = driver.manage().window().getSize();
				
				int h = windowSize.getHeight();
				int y1 = (int) (h * 0.2);
				int y2 = (int) (h - y1);
				int x = (int) ((windowSize.getWidth()) / 2);
				
				String s1 = driver.getPageSource();
				int count = 0;
				int index = 0;

				while (count == 0 && index == 0) {
					if (localRecipientsList.size() > 0) {
						com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
						int length = localRecipientsList.size();
						String LocalRecipientList = null;
						if (length < 5) {
							for (int i = 0; i < length; i++) {
								LocalRecipientList = localRecipientsList.get(i).getText();
								if (LocalRecipientList.contains(valueSelectedFromList)) {
									index++;
									clickOnElement(localRecipientsList.get(i));
									break;
								}
							}
							// Exception Handling without scrolling case and no expected element found in
							// the list then index ==0
							if (index == 0 && count == 0)
								Asserts.assertFail("Credit Cards ' " + valueSelectedFromList
										+ " ' not found in the list to initiate the fund transfer");
							else
								break;
						} else

							// Code will work :: When Need to scroll
							for (int i = 0; i < length; i++) {
								LocalRecipientList = localRecipientsList.get(i).getText();
								if (LocalRecipientList.contains(valueSelectedFromList) && isElementVisible2(localRecipientsList.get(i))) {
									index++;
									clickOnElement(localRecipientsList.get(i));
									break;
								}
							}
						if (index == 0) {
							touch.longPress(longPressOptions().withPosition(point(x, y2)).withDuration(ofSeconds(2)))
									.moveTo(element(allTab)).release().perform();

							String s2 = driver.getPageSource();
							if (s1.equals(s2) != true)
								s1 = s2;
							else
								count = 1;
						} else
							break;

						// Exception Handling in scrolling case and no expected element found in the
						// list then index ==0, count ==1
						if (count == 1 && index == 0)
								Asserts.assertFail("Credit Cards ' " + valueSelectedFromList
										+ " ' not found in the list to initiate the fund transfer");

					} else
						Asserts.assertFail("No receipient Found in the Cards recipient list");
				}

			
				handlingOfPrimarySourceOfFundPopup();

		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Select 'To Account' From Credit Card List ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Select 'To Account' From Credit Card List ", e);
		}
	}

}
