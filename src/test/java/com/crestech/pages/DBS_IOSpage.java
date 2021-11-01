package com.crestech.pages;

import java.time.Duration;
import java.util.logging.Logger;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import com.crestech.appium.utils.CommonAppiumTest;
import com.crestech.pageobjects.DBS_IOSObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

public class DBS_IOSpage extends CommonAppiumTest {

	static Logger log = Logger.getLogger(DBSAndroidPage.class.getName());
	public DBS_IOSObject IOShomePgaeObject = new DBS_IOSObject(driver);

	public DBS_IOSpage(AppiumDriver<RemoteWebElement> driver) {
		super(driver);
		//PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), IOShomePgaeObject);
	}

	/**
	 * This method is to Send "Email"
	 */
	@Step("Enter email")
	@Attachment()
	public void clickOnEmail(String keysToSend) {
		//wait.waitForElementVisissbility(IOShomePgaeObject.getEmailID(), 20);
		try {
			enterTextInTextbox(IOShomePgaeObject.getEmailID(), keysToSend);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * This method is to Send "Password"
	 */
	@Step("enter password")
	public void clickOnPassword(String keysToSend) {
		//wait.waitForElementVisissbility(IOShomePgaeObject.getPassword(), 60);
		try {
			enterTextInTextbox(IOShomePgaeObject.getPassword(), keysToSend);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Method to tap on Login Button
	 * 
	 * @throws InterruptedException
	 */
	@Step("Click on Login button")
	public void clickonLogin() throws InterruptedException {
		try {
			clickOnElement(IOShomePgaeObject.getLogIn());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
