package com.crestech.pages;

import java.time.Duration;
import java.util.logging.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import com.crestech.appium.utils.CommonAppiumTest;
import com.crestech.common.utilities.WaitUtils;
import com.crestech.pageobjects.PcloudyIOSPageObject;
import com.crestech.report.factory.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import junit.framework.Assert;

public class pCloudySampleIOSpage extends CommonAppiumTest {

	static Logger log = Logger.getLogger(PcloudyHomePage.class.getName());
	public PcloudyIOSPageObject IOShomePgaeObject = new PcloudyIOSPageObject();

	public pCloudySampleIOSpage(AppiumDriver<RemoteWebElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), IOShomePgaeObject);
	}

	/**
	 * This method is to Send "Email"
	 */
	@Step("Enter email")
	@Attachment()
	public void clickOnEmail(String keysToSend) {
		wait.waitForElementInSeconds(IOShomePgaeObject.getEmailID(), 20);
		sendkeys(IOShomePgaeObject.getEmailID(), keysToSend);

	}

	/**
	 * This method is to Send "Password"
	 */
	@Step("enter password")
	public void clickOnPassword(String keysToSend) {
			wait.waitForElementInSeconds(IOShomePgaeObject.getPassword(), 60);
			sendkeys(IOShomePgaeObject.getPassword(), keysToSend);
		
	}

	/**
	 * Method to tap on Login Button
	 * 
	 * @throws InterruptedException
	 */
	@Step("Click on Login button")
	public void clickonLogin() throws InterruptedException {
		clickOnElement(IOShomePgaeObject.getLogIn());
	}

}
