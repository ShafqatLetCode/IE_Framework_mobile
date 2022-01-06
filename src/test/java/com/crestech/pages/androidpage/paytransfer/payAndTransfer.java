package com.crestech.pages.androidpage.paytransfer;

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
import com.crestech.common.utilities.WaitUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
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


	@ElementDescription(value = "Overseas Button,Topup Button")
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[contains(@resource-id,'id/cvActionItem')]")
	private List<MobileElement> Btnlist;
	
	@ElementDescription(value = "ALL TAB")
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc='ALL']/android.widget.TextView")
	private MobileElement AllTab;
	
	@ElementDescription(value = "Local Button")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Local']")
	private MobileElement LocalButton;
	
	@ElementDescription(value = "Home button")
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Home']")
	private MobileElement homeButton;
	
	@ElementDescription(value = "Top up button")
	@AndroidFindBy(xpath = "(//android.widget.LinearLayout[contains(@resource-id,'id/cvActionItem')])[8]")
	private MobileElement topUpButton;

	@ElementDescription(value = "Local Recipient options list, Credit Card Options list")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/tv_expandable_item_head_title')]")
	private List<MobileElement> AllTabOptionsList;
	
	@ElementDescription(value = "Local recipient List Text")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'id/tv_expandable_item_sub_title')]")
	private List<MobileElement> SubTitleTextList;
	
	@ElementDescription(value = "Local recipient List clickable")
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[contains(@resource-id,':id/root_ll')]")
	private List<MobileElement> ListElementToClickable;

	@ElementDescription(value = "OK Button")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
	private MobileElement OKButton;
	
	@ElementDescription(value = "Bills Button")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Bills']")
	private MobileElement BillsButton;
	
	@ElementDescription(value = "Primary source of fund")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Primary source of fund']")
	private MobileElement PrimarySourceOfFundPopup;
	
	@Step("Click On Bills Module.")
	public void ClickOnBillsModule() throws Exception {
		try {
			wait.waitForElementToBeClickable(BillsButton); 
			clickOnElement(BillsButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Bill Module ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Bill Module ", e);
		}
	}
	
	@Step("Click on 'Billing Organisation' Option under All Tab")
	public void ClickOnBillingOrganisation() throws Exception {
		try {
			gestUtils.scrollUPtoObject("text", CommonTestData.BILLING_ORGANISATIONS_TAB.getEnumValue(), null);
			int o = 0;
			for (int i = 0; i < AllTabOptionsList.size(); i++) {
				String tabText = AllTabOptionsList.get(i).getText();
				o++;
				if (tabText.contains(CommonTestData.BILLING_ORGANISATIONS_TAB.getEnumValue())) {
					clickOnElement(AllTabOptionsList.get(i));
					break;
				}
			}

			gestUtils.DragAndDropElementToElement(AllTabOptionsList.get(o), AllTab);

		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION"," Failed to Click on 'Billing Organisation' Option under All Tab", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION"," Failed to Click on 'Billing Organisation' Option under All Tab ", e);
		}
	}
	
	@Step("Click on 'Credit Card' Option under All Tab")
	public void ClickOnCreditCard() throws Exception {
		try {
			int o = 0;
			for (int i = 0; i < AllTabOptionsList.size(); i++) {
				String tabText = AllTabOptionsList.get(i).getText();
				o++;
				if (tabText.contains(CommonTestData.CREDIT_CARDS_TAB.getEnumValue())) {
					clickOnElement(AllTabOptionsList.get(i));
					break;
				}
			}

			gestUtils.DragAndDropElementToElement(AllTabOptionsList.get(o), AllTab);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Click on 'Credit Card' Option under All Tab ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Click on 'Credit Card' Option under All Tab ", e);
		}
	}
	
	@Step("Click On 'Your DBS/POSB Accounts' option under All Tab .")
	public void ClickOnYourDBSPOSBAccounts() throws Exception {
		try {
			int o = 0;
			for (int i = 0; i < AllTabOptionsList.size(); i++) {
				String tabText = AllTabOptionsList.get(i).getText();
				o++;
				if (tabText.contains(CommonTestData.YOUR_DBSPOSB_ACCOUNTS.getEnumValue())) {
					clickOnElement(AllTabOptionsList.get(i));
					break;
				}
			}
			gestUtils.DragAndDropElementToElement(AllTabOptionsList.get(o), AllTab);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Click On 'Your DBS/POSB Accounts' option under All Tab ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Click On 'Your DBS/POSB Accounts' option under All Tab ", e);
		}
	}
	
	@Step("Select 'To Account' From Your DBS POSB Account list.")
	public void SelectToAccountFromYourDBSPOSBAccountlist(String expectedToOwnAccount) throws Exception {
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
				if (SubTitleTextList.size() > 0) {
					int length = SubTitleTextList.size();
					String actualToOWNAccount = null;
					if (length < 2) {
						for (int i = 0; i < length; i++) {
							actualToOWNAccount = AllTabOptionsList.get(i).getText();
							if (actualToOWNAccount.equalsIgnoreCase(expectedToOwnAccount)) {
								index++;
								clickOnElement(ListElementToClickable.get(i));
								break;
							}
						}
						// Exception Handling without scrolling case and no expected element found in
						// the list then index ==0
						if (index == 0 && count == 0)
							Asserts.assertFail("Your DBS/POSB Accounts " + expectedToOwnAccount
									+ " not found in the list to initiate the fund transfer");
						else
							break;
					} else

						// Code will work :: When Need to scroll
						for (int i = 0; i < length; i++) {
							actualToOWNAccount = AllTabOptionsList.get(i).getText();
							if (actualToOWNAccount.equalsIgnoreCase(expectedToOwnAccount)) {
								index++;
								clickOnElement(ListElementToClickable.get(i));
								break;
							}
						}
					if (index == 0) {
						touch.longPress(longPressOptions().withPosition(point(x, y2)).withDuration(ofSeconds(2)))
								.moveTo(element(AllTab)).release().perform();
						Thread.sleep(2000);
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
						Asserts.assertFail("Your DBS/POSB Accounts " + expectedToOwnAccount
								+ " not found in the list to initiate the fund transfer");

				} else
					Asserts.assertFail("No receipient found in the Your DBS/POSB Own Account List.");
			}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Select To Account From Your DBS POSB Account list ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Select To Account From Your DBS POSB Account list ", e);
		}
	}
	
	@Step("Select 'To Account' From Credit Card List")
	public void SelectToAccountFromCreditCardList(String expectedToCreditCardAccount) throws Exception {
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
				if (SubTitleTextList.size() > 0) {
					int length = SubTitleTextList.size();
					String actualToCreditCardAccount = null;
					if (length < 2) {
						for (int i = 0; i < length; i++) {
							actualToCreditCardAccount = SubTitleTextList.get(i).getText();
							if (actualToCreditCardAccount.contains(expectedToCreditCardAccount)) {
								index++;
								clickOnElement(ListElementToClickable.get(i));
								break;
							}
						}
						// Exception Handling without scrolling case and no expected element found in
						// the list then index ==0
						if (index == 0 && count == 0)
							Asserts.assertFail("Credit Cards " + expectedToCreditCardAccount
									+ " not found in the list to initiate the fund transfer.");
						else
							break;
					} else

						// Code will work :: When Need to scroll
						for (int i = 0; i < length; i++) {
							actualToCreditCardAccount = SubTitleTextList.get(i).getText();
							if (actualToCreditCardAccount.contains(expectedToCreditCardAccount)) {
								index++;
								clickOnElement(ListElementToClickable.get(i));
								break;
							}
						}
					if (index == 0) {
						touch.longPress(longPressOptions().withPosition(point(x, y2)).withDuration(ofSeconds(2)))
								.moveTo(element(AllTab)).release().perform();
						Thread.sleep(2000);
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
						Asserts.assertFail("Credit Cards " + expectedToCreditCardAccount
								+ " not found in the list to initiate the fund transfer.");

				} else
					Asserts.assertFail("No receipient found in the Credit Cards list");
			}

		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Select 'To Account' From Credit Card List ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Select 'To Account' From Credit Card List ", e);
		}
	}
	
	@Step("Select 'To Account' from 'Billing organisation' list")
	public void SelectToAccountFromBillingOrganisationList(String valueSelectedFromList) throws Exception {
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
				if (SubTitleTextList.size() > 0) {
					int length = SubTitleTextList.size();
					String BillingOrganisationlist = null;
					if (length < 2) {
						for (int i = 0; i < length; i++) {
							BillingOrganisationlist = SubTitleTextList.get(i).getText();
							if (BillingOrganisationlist.contains(valueSelectedFromList)) {
								index++;
								clickOnElement(ListElementToClickable.get(i));
								break;
							}
						}
						// Exception Handling without scrolling case and no expected element found in
						// the list then index ==0
						if (index == 0 && count == 0)
							Asserts.assertFail("Billing Organisation " + valueSelectedFromList + " not found in the list to initiate the fund transfer.");
						else
							break;
					} else

						// Code will work :: When Need to scroll
						for (int i = 0; i < length; i++) {
							BillingOrganisationlist = SubTitleTextList.get(i).getText();
							if (BillingOrganisationlist.contains(valueSelectedFromList)) {
								index++;
								clickOnElement(ListElementToClickable.get(i));
								break;
							}
						}
					if (index == 0) {
						touch.longPress(longPressOptions().withPosition(point(x, y2)).withDuration(ofSeconds(2)))
								.moveTo(element(AllTab)).release().perform();
						Thread.sleep(2000);
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
						Asserts.assertFail("Billing Organisation " + valueSelectedFromList + " not found in the list to initiate the fund transfer.");
				} else
					Asserts.assertFail("No receipient found in the Billing Organisation list");
			}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION"," Failed to select 'to account' from billing organisation list ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION"," Failed to select 'to account' from billing organisation list ", e);
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
				if (SubTitleTextList.size() > 0) {
					int length = SubTitleTextList.size();
					String actualLocalRecipient = null;
					if (length < 2) {
						for (int i = 0; i < length; i++) {
							actualLocalRecipient = SubTitleTextList.get(i).getText();
							if (actualLocalRecipient.equalsIgnoreCase(expectedLocalRecipient)) {
								index++;
								clickOnElement(ListElementToClickable.get(i));
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
							actualLocalRecipient = SubTitleTextList.get(i).getText();
							if (actualLocalRecipient.equalsIgnoreCase(expectedLocalRecipient)) {
								index++;
								clickOnElement(ListElementToClickable.get(i));
								break;
							}
						}
					if (index == 0) {
						touch.longPress(longPressOptions().withPosition(point(x, y2)).withDuration(ofSeconds(2)))
								.moveTo(element(AllTab)).release().perform();
                        Thread.sleep(2000);
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
			HandlingOfPrimarySourceOfFundPopup();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION"," Failed to Select 'To Account' from local Recipient list  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION"," Failed to Select 'To Account' from local Recipient list  ", e);
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
	
	@Step("Handle Of 'Primary Source Of Fund' Popup.")
	public void HandlingOfPrimarySourceOfFundPopup() throws Exception {
		try {
			if (isElementVisible2(PrimarySourceOfFundPopup))
				ClickOnOKButton();
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Handle Of 'Primary Source Of Fund' Popup  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Handle Of 'Primary Source Of Fund' Popup  ", e);
		}
	}

	
	@Step("Click On Local Recipient Option under All Tab.")
	public void ClickOnLocalRecipient() throws Exception {
		try {
			int o = 0;
			for (int i = 0; i < AllTabOptionsList.size(); i++) {
				String tabText = AllTabOptionsList.get(i).getText();
				o++;
				if (tabText.contains(CommonTestData.LOCAL_RECIPIENT_FROMLIST.getEnumValue())) {
					clickOnElement(AllTabOptionsList.get(i));
					break;
				}
			}

			gestUtils.DragAndDropElementToElement(AllTabOptionsList.get(o), AllTab);

		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION"," Failed to Click On Local Recipient Option under All Tab. ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Local Recipient Option under All Tab ", e);
		}
	}
	
	@Step("Click On Topup Paylah Module")
	public void ClickOnTopupPaylahModule() throws Exception {
		try {
			wait.waitForElementToBeClickable(topUpButton); 
			clickOnElement(topUpButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On TopUp Paylah Module  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On TopUp Paylah Module  ", e);
		}
	}
	
	@Step("Click On Local Module.")
	public void ClickOnLocalModule() throws Exception {
		try {
			wait.waitForElementToBeClickable(LocalButton);
			clickOnElement(LocalButton); 
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Local Module  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Local Module  ", e);
		}
	}
	
	@Step("Verifying Overseas Module and click")
	public void ClickOnOverseasModule(String expectecText) throws Exception {
		try {
			wait.waitForElementToBeClickable(Btnlist.get(3)); 
			clickOnElement(Btnlist.get(3));
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click on Overseas Button  ",
					e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click on Overseas Button ", e);
		}
	}
	
	@Step("Select All TAB.")
	public void SelectAllTAB() throws Exception {
		try {
			wait.waitForElementToBeClickable(AllTab);
			clickOnElement(AllTab); 
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to select All Tab  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to select All Tab   ", e);
		}
	}
	
	@Step("Click On Home Button.")
	public void ClickOnHomeButton() throws Exception {
		try {
			clickOnElement(homeButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Home Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Home Button  ", e);
		}
	}

}
