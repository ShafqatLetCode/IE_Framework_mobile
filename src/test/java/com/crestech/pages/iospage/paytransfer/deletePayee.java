package com.crestech.pages.iospage.paytransfer;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import com.crestech.annotation.values.ElementDescription;
import com.crestech.appium.utils.CommonAppiumTest;
import com.crestech.common.utilities.Asserts;
import com.crestech.common.utilities.GestureUtils;
import com.crestech.common.utilities.HandleException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

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
	
	@ElementDescription(value = "Payee list")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText")
	private List<MobileElement> payeeList;
	
	@ElementDescription(value = "Added Payee 'i icon' list.")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='i icon'])")
	private List<MobileElement> IiconList;
	
	@ElementDescription(value = "'More Payee Details' three Dot.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='morePayeedetail']")
	private MobileElement MorePayeeDetailDots;
	
	@ElementDescription(value = "'Yes' Button.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Yes']")
	private MobileElement YesButton;
	
	@ElementDescription(value = "'Are you sure you want to delete this payee?' Message.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Are you sure you want to delete this payee?']")
	private MobileElement AreYouSureToDeleteThisPayeeMsg;
	
	@ElementDescription(value = "'OK' Button.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='OK']")
	private MobileElement OKButton;
	
	@ElementDescription(value = "alert ok button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='OK']")
	private MobileElement alertOkButton;
	
	@ElementDescription(value = "'Delete Payee' Button.")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Delete Payee']")
	private MobileElement DeletePayeeButton;
	
	@ElementDescription(value = "'check DBSRemit Rate")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Check DBS Remit rates']")
	private MobileElement checkDBSRemitRate;
	
	@Step("Delete Payee.")
	public void DeletePayee(String ExpectedPayee) throws Exception {
		try {
			if (payeeList.size() > 0) {
				int ExpectedTotalPayeeSize = payeeList.size();
				int ExpectedTotalPayee = IiconList.size();
				for (int i = 0; i < ExpectedTotalPayeeSize; i++) {
					String actualPayee = payeeList.get(i).getText();
					if (actualPayee.equals(ExpectedPayee)) {
						int index = i / 2;
						ClickOnDeletePayeeToIcon(index);
						ClickOnMoreOptionBtn();
						ClickOnDeletePayeeBtn();
						ClickOnYesBtn();
						// HandlingErrorPopupInDeletePayee();
						ClickOnOkButtonAfterVerifyingPayeeDeletedMsg(ExpectedPayee);
						VerifyPayeeSizeAfterDeletePayee(ExpectedTotalPayee);
						break;
					}
				}

			} else {
				Dimension windowSize1 = driver.manage().window().getSize();
				int y = (int) ((windowSize1.getHeight()) - 10);
				int x = (int) ((windowSize1.getWidth()) / 2);
				gesture.swipeCoordinatetoCoordinate(x, 20, x, y);
			}

		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Delete Payee ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Delete Payee ", e);
		}
	}
	
	@Step("Delete Payee.")
	public void DeletePayeeForRemittence(String ExpectedPayee) throws Exception {
		try {
			if(payeeList.size() > 0) {
				int ExpectedTotalPayeeSize = payeeList.size();
				int ExpectedTotalPayee = IiconList.size();
				for (int i = 0; i < ExpectedTotalPayeeSize; i++) {
						String actualPayee = payeeList.get(i).getText();
						System.out.println(i+ "actualPayee:: "+actualPayee);
						if(actualPayee.equals(ExpectedPayee) ) {
							int index=1+i;
							ClickOnDeletePayeeToIcon_forPayeeRemittance(index);
							ClickOnMoreOptionBtn();
							ClickOnDeletePayeeBtn();
							ClickOnYesBtn();

							//HandlingErrorPopupInDeletePayee();
							ClickOnOkButtonAfterVerifyingPayeeDeletedMsg(ExpectedPayee);
							wait.waitForElementVisibility(checkDBSRemitRate);
							VerifyPayeeSizeAfterDeletePayee(ExpectedTotalPayee);
							break;
							}
					}
			}
					else {
						Dimension windowSize1 = driver.manage().window().getSize();
						int y =(int)((windowSize1.getHeight())-10);
						int x =(int)((windowSize1.getWidth())/2);
						gesture.swipeCoordinatetoCoordinate(x,20,x,y);
					}
			
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Delete Payee ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Delete Payee ",e);
		}
	}
	
	@Step("Verify Payee Size After Delete Payee.")
	public void VerifyPayeeSizeAfterDeletePayee(int ExpectedTotalPayee) throws Exception {
		try {
			int ActualTotalPayeeSize = IiconList.size();
			int ExpectedTotalSizeAfterDeletingPayee = ExpectedTotalPayee - 1;
			Asserts.assertEquals(String.valueOf(ActualTotalPayeeSize) ,String.valueOf(ExpectedTotalSizeAfterDeletingPayee),
					" Payee size is not matching after performing delete operation.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify Payee Size after Delete Payee.  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to Verify Payee Size after Delete Payee.  ", e);
		}
	}
	
	@Step("Click On OK Button after verifying 'Payee Name deleted' message.")
	public void ClickOnOkButtonAfterVerifyingPayeeDeletedMsg(String ExpectedPayee) throws Exception {
		try {
			wait.waitForElementVisibility(OKButton); 
			String message = ExpectedPayee + " Deleted";
			String DeletePayeeMessageXPath = "//XCUIElementTypeStaticText[@name='" + message + "']";
			MobileElement DeletePayeeMessageElement = (MobileElement) driver
					.findElement(By.xpath(DeletePayeeMessageXPath));
			
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
	public void HandlingErrorPopupInDeletePayee() throws Exception {
		try {
			for (int innerLoop = 0; innerLoop < 2; innerLoop++) {
				String ErrorissueXpath = "//XCUIElementTypeStaticText[@name='You may be facing some delays and we are trying to sort it out now. Sorry for the inconvenience. Do check back later.']";
				List<RemoteWebElement> list = driver.findElements(By.xpath(ErrorissueXpath));
				if (list.size() > 0) {
					clickOnElement(alertOkButton);
					ClickOnMoreOptionBtn();
					ClickOnDeletePayeeBtn();
					ClickOnYesBtn();
				
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
	@Step("Click On i Icon from the list.")
	public void ClickOnDeletePayeeToIcon(int index) throws Exception {
		try {
			clickOnElement(IiconList.get(index));
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Icon(i)  ", e);

		} catch (Exception e) {

			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Icon(i)  ", e);
		}
	}
	
	@Step("Click On i Icon from the list.")
	public void ClickOnDeletePayeeToIcon_forPayeeRemittance(int index) throws Exception {
		try {
			String iconXpath = "(//XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText)[" + index + "]/following-sibling::XCUIElementTypeButton";
			MobileElement icon = (MobileElement) driver.findElement(By.xpath(iconXpath));
			clickOnElement(icon);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Icon(i)  ", e);

		} catch (Exception e) {

			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Icon(i)  ", e);
		}
	}
	
	@Step("Click On 'More Options' Button.")
	public void ClickOnMoreOptionBtn() throws Exception {
		try {
			wait.fluentWaitForElement(MorePayeeDetailDots);
			wait.waitForElementToBeClickable(MorePayeeDetailDots); 
			clickOnElement(MorePayeeDetailDots);
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
			clickOnElement(DeletePayeeButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to Click On Delete Payee Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click on Delete Payee Button  ", e);
		}
	}
	
	@Step("Click On Yes Button after verifying 'Are you sure to delete payee' message.")
	public void ClickOnYesBtn() throws Exception {
		try {
			if (isElementVisible(AreYouSureToDeleteThisPayeeMsg))
				clickOnElement(YesButton);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Yes Button  ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Yes Button   ", e);
		}
	}


}
