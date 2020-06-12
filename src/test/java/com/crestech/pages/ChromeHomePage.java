package com.crestech.pages;

import java.time.Duration;
import java.util.logging.Logger;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import com.crestech.appium.utils.CommonAppiumTest;
import com.crestech.pageobjects.chromeHomePageObject;
import com.crestech.pageobjects.pCloudyHomePageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;

public class ChromeHomePage extends CommonAppiumTest  {

		static Logger log = Logger.getLogger(PcloudyHomePage.class.getName());
		public chromeHomePageObject chromeHomePageObject = new chromeHomePageObject();

		public ChromeHomePage(AppiumDriver<RemoteWebElement> driver) {
			super(driver);
			PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), chromeHomePageObject);
		}
		
		
		/**
		 * This method will send data in the editbox
		 */
		@Step("Enter data in Username EditBox")
		public void sendDataInUsername(String text) {
			sendkeys(chromeHomePageObject.EmailId(), text);
		}
		
		
		/**
		 * This method will send data in the editbox
		 */
		@Step("Enter data in Username EditBox")
		public void sendDataInPAssword(String text) {
			sendkeys(chromeHomePageObject.Password(), text);
		}
		
		
}
