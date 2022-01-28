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
public class deletePayee extends CommonAppiumTest{

	public AppiumDriver<RemoteWebElement> driver = null;
	HandleException obj_handleexception = null;
	GestureUtils gestUtils = null;
	public TouchAction touch = null;
	
	public deletePayee(AppiumDriver<RemoteWebElement> driver) throws Exception {
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
	
	@ElementDescription(value = "Payee List")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/tv_expandable_item_head_title')]")
	private List<MobileElement> payeeList;
	
	@ElementDescription(value = "Payee Added Expandable Icon List")
	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,':id/tv_expandable_item_selected')]")
	private List<MobileElement> PayeeAddedExpandableIconList;
	
	@ElementDescription(value = "payee_details_title_name.")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,':id/payee_details_title_name')]")
	private MobileElement payee_details_title_name;
	
	@ElementDescription(value = "More Option Button.")
	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='More options']")
	private MobileElement MoreOptionBtn;
	
	@ElementDescription(value = "More Option Button.")
	@AndroidFindBy(xpath = "//androidx.appcompat.widget.LinearLayoutCompat//android.widget.ImageView‎‏‎‎‎‎‎‏‎‏‏‏‎‎‎‎‎‏‎‎‏‎‎‎‎‏‏‏‏‏‎‏‏‏‏‏‏‏‏‎‏‏‎‏‏‏‏‎‏‎‎‎‏‏‎‏‏‏‎‏‏‎‏‎‏‎‎‎‎‎‎‏‎‎‎‏‏‏")
	private MobileElement MoreOptionBtn2;
	
	@ElementDescription(value = "More Option Button.")
	@AndroidFindBy(xpath = "//androidx.appcompat.widget.LinearLayoutCompat//android.widget.ImageView[@content-desc='‎‏‎‎‎‎‎‏‎‏‏‏‎‎‎‎‎‏‎‎‏‎‎‎‎‏‏‏‏‏‎‏‏‏‏‏‏‏‏‎‏‏‎‏‏‏‏‎‏‎‎‎‏‏‎‏‏‏‎‏‏‎‏‎‏‎‎‎‎‎‎‏‎‎‎‏‏‏‎‏‏‏‏‎‎‎‏‎‎‎More options‎‏‎‎‏‎']")
	private MobileElement MoreOptionBtn1;
	
	@ElementDescription(value = "More Option Button.")
	@AndroidFindBy(xpath = "//androidx.appcompat.widget.LinearLayoutCompat//android.widget.ImageView[contains(@content-desc,'‎‏‎‎‎‎‎‏‎‏‏‏‎‎‎‎‎‏‎‎‏‎‎‎‎‏‏‏‏‏‎‏‏‏‏‏‏‏‏‎‏‏‎‏‏‏‏‎‏‎‎‎‏‏‎‏‏‏‎‏‏‎‏‎‏‎‎‎‎‎‎‏‎‎‎‏‏‏‎‏‏‏‏‎‎‎‏‎‎‎More')]")
	private MobileElement MoreOptionBtn3;
	
	@ElementDescription(value = "More Option Button.")
	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc,'‎‏‎‎‎‎‎‏‎‏‏‏‎‎‎‎‎‏‎‎‏‎‎‎‎‏‏‏‏‏‎‏‏‏‏‏‏‏‏‎‏‏‎‏‏‏‏‎‏‎‎‎‏‏‎‏‏‏‎‏‏‎‏‎‏‎‎‎‎‎‎‏‎‎‎‏‏‏‎‏‏‏‏‎‎‎‏‎‎‎More')]")
	private MobileElement MoreOptionBtn4;
	
	
	//android.view.ViewGroup
	@ElementDescription(value = "Delete Payee Button.")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Delete Payee']")
	private MobileElement DeletePayeeBtn;

	@ElementDescription(value = "YES Button.")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='YES']")
	private MobileElement YesBtn;

	@ElementDescription(value = "Are you sure you want to delete this payee? Message Element.")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Are you sure you want to delete this payee?']")
	private MobileElement AreYouSureToDeleteThisPayeeMessage;
	
	@ElementDescription(value = "RECIPIENTS")
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc='Recipients']/android.widget.TextView")
	private MobileElement RECIPIENTS_TAB;
	
	@ElementDescription(value = "RECIPIENTS")
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc='RECIPIENTS']/android.widget.TextView")
	private MobileElement RECIPIENTS_Bills;
	
	@ElementDescription(value = "OK Button")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
	private MobileElement OKButton;
	
	@ElementDescription(value = "Error Messge Element")
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='android:id/message']")
	private MobileElement ErrorMessgeElement;
	
	@ElementDescription(value = "Back Btn Image View")
	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,':id/back_btn')]")
	private MobileElement BackBtnImageView;

	

	@Step("Delete Payee.")
	public void DeletePayee(String expectedDeleteRecipient) throws Exception {
		try {
			Dimension windowSize = driver.manage().window().getSize();
			int h = windowSize.getHeight();
			int y1 = (int) (h * 0.2);
			int y2 = (int) (h - y1);
			int x = (int) ((windowSize.getWidth()) / 2);
			String s1 = driver.getPageSource();
			int count = 0;
			int deletePayee = 0;

			if (payeeList.size() > 0) {
				com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
				while (count == 0 && deletePayee == 0) {
					int length = payeeList.size();
					String actualDeleteRecipient = null;

					if (length < 4) {
						for (int i = 0; i < length; i++) {
							actualDeleteRecipient = payeeList.get(i).getText();
							if (actualDeleteRecipient.equals(expectedDeleteRecipient)) {
								ClickOnDeletePayeeToIcon(i);
								verifyPageHeader(CommonTestData.RECIPIENT_DETAILS_PAGEHEADER.getEnumValue(),
										payee_details_title_name);
								String RecipientNameXpath = "//android.widget.TextView[@text='" + expectedDeleteRecipient
										+ "']";
								MobileElement RecipientNameElement = (MobileElement) driver.findElement(By.xpath(RecipientNameXpath));
								if (isElementVisible2(RecipientNameElement)) { 
									ClickOnMoreOptionBtn();
									ClickOnDeletePayeeBtn();
									ClickOnYesBtn();
									HandlingErrorPopupInDeletePayee(i);
									ClickOnOkButtonAfterVerifyingPayeeDeletedMsg(expectedDeleteRecipient);
									deletePayee++;
									// VerifyPayeeSizeAfterDeletePayee(ExpectedTotalPayeeSize);
									break;
								} else
									ClickOnBackButtonImageView();
							}
						}
						if (deletePayee == 0 && count == 0)
							break;
					} else {
						for (int i = 0; i < length; i++) {
							actualDeleteRecipient = payeeList.get(i).getText();
							if (actualDeleteRecipient.equals(expectedDeleteRecipient)) {
								ClickOnDeletePayeeToIcon(i);
								verifyPageHeader(CommonTestData.RECIPIENT_DETAILS_PAGEHEADER.getEnumValue(),
										payee_details_title_name);
								String RecipientNameXpath = "//android.widget.TextView[@text='" + expectedDeleteRecipient
										+ "']";
								MobileElement RecipientNameElement = (MobileElement) driver.findElement(By.xpath(RecipientNameXpath));
								if (isElementVisible2(RecipientNameElement)) { 
									ClickOnMoreOptionBtn();
									ClickOnDeletePayeeBtn();
									ClickOnYesBtn();
									HandlingErrorPopupInDeletePayee(i);
									ClickOnOkButtonAfterVerifyingPayeeDeletedMsg(expectedDeleteRecipient);
									deletePayee++;
									// VerifyPayeeSizeAfterDeletePayee(ExpectedTotalPayeeSize);
									break;
								} else
									ClickOnBackButtonImageView();
							}
						}

						if (deletePayee == 0) {
							if(isElementVisible2(RECIPIENTS_Bills)) 
							touch.longPress(longPressOptions().withPosition(point(x, y2)).withDuration(ofSeconds(2)))
									.moveTo(element(RECIPIENTS_Bills)).release().perform();
							else 
								touch.longPress(longPressOptions().withPosition(point(x, y2)).withDuration(ofSeconds(2)))
								.moveTo(element(RECIPIENTS_TAB)).release().perform();
							
							Thread.sleep(2000);
							String s2 = driver.getPageSource();
							if (s1.equals(s2) != true)
								s1 = s2;
							else
								count = 1;
						} else
							break;

						if (deletePayee == 0 && count == 1)
							break;
					}
				}
			}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("DELETEPAYEE_EXCEPTION", " Failed to Execute Delete Payee  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("DELETEPAYEE_EXCEPTION", " Failed to Execute Delete Payee  ", e);
		}
	}

	@Step("Handling Error Popup In Delete Payee")
	public void HandlingErrorPopupInDeletePayee(int index) throws Exception {
		try {
			for (int innerLoop = 0; innerLoop < 2; innerLoop++) {
				// Sometimes this alert with message (You may be facing some delays and
				// we are trying to sort it out now. Sorry for the inconvenience.
				// Do check back later.) coming. So this Thread.sleep(); added here.

				Thread.sleep(5000);
				if (isElementVisible2(ErrorMessgeElement)) {
					if (getTexOfElement(ErrorMessgeElement).contains("You may be facing some delays")) {
						ClickOnOKButton();
						ClickOnDeletePayeeToIcon(index);
						verifyPageHeader(CommonTestData.RECIPIENT_DETAILS_PAGEHEADER.getEnumValue(),
								payee_details_title_name);
						ClickOnMoreOptionBtn();
						ClickOnDeletePayeeBtn();
						ClickOnYesBtn();
						Thread.sleep(5000);
					}
				}
			}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Handle Error Popup in delete payee.  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Handle Error Popup in delete payee.  ", e);
		}
	}

	@Step("Click On OK Button after verifying 'Payee Name deleted' message.")
	public void ClickOnOkButtonAfterVerifyingPayeeDeletedMsg(String ExpectedRecipientName) throws Exception {
		try {
			wait.waitForElementVisibility(OKButton); 
			String payeeName = ExpectedRecipientName + " deleted.";
			String PayeeNameXpath = "//android.widget.TextView[@text='" + payeeName + "']";
			MobileElement DeletePayeeMessageElement = (MobileElement) driver.findElement(By.xpath(PayeeNameXpath));
			if (isElementVisible2(DeletePayeeMessageElement))
				ClickOnOKButton();

		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Click On OK Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On OK Button",
					e);
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

	@Step("Click On Yes Button after verifying 'Are you sure to delete payee' message.")
	public void ClickOnYesBtn() throws Exception {
		try {
			if (isElementVisible2(AreYouSureToDeleteThisPayeeMessage))
				clickOnElement(YesBtn);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Yes Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Yes Button   ", e);
		}
	}

	@Step("Click On i Icon from the list.")
	public void ClickOnDeletePayeeToIcon(int index) throws Exception {
		try {
			clickOnElement(PayeeAddedExpandableIconList.get(index));
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Icon(i)  ", e);

		} catch (Exception e) {

			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Icon(i)  ", e);
		}
	}

	@Step("Click On 'More Options' Button.")
	public void ClickOnMoreOptionBtn() throws Exception {
		try {
			wait.fluentWaitForElement(MoreOptionBtn);
			wait.waitForElementToBeClickable(MoreOptionBtn); 
		//	try {
				Thread.sleep(10000);
				clickOnElement(MoreOptionBtn);
				
//			} catch (HandleException e) {
//				clickOnElement(MoreOptionBtn);
//			}
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Click On More Options Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On More Options Button  ", e);
		}
	}

	@Step("Click On 'Delete payee' Button.")
	public void ClickOnDeletePayeeBtn() throws Exception {
		try {
			clickOnElement(DeletePayeeBtn);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Click On Delete Payee Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click on Delete Payee Button  ", e);
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
	
	@Step("Click On Back Button")
	public void ClickOnBackButtonImageView() throws Exception {
		try {
			clickOnElement(BackBtnImageView);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to click on Back Button. ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to click on Back Button. ", e);
		}
	}
	
	@Step("Verify Payee Size After Delete Payee.")
	public void VerifyPayeeSizeAfterDeletePayee(int ExpectedTotalPayeeSize) throws Exception {
		try {
			String xpath = "//android.widget.ImageView[contains(@resource-id,':id/tv_expandable_item_selected')]";
			List<RemoteWebElement> Payeelist = driver.findElements(By.xpath(xpath));

			int ActualTotalPayeeSize = Payeelist.size();
			int ExpectedTotalSizeAfterDeletingPayee = ExpectedTotalPayeeSize - 1;
			Asserts.assertEquals(String.valueOf(ExpectedTotalSizeAfterDeletingPayee),
					String.valueOf(ActualTotalPayeeSize),
					" Payee size is not matching after performing delete operation.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify Payee Size after Delete Payee.  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify Payee Size after Delete Payee.  ", e);
		}
	}
	
}

