package com.ie.pages;

import java.time.Duration;
import java.util.logging.Logger;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import com.ie.appium.utils.CommonAppiumTest;
import com.ie.pageobjects.IEAndroidObject;
import com.ie.pageobjects.chromeHomePageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;

public class ChromeHomePage extends CommonAppiumTest  {

		static Logger log = Logger.getLogger(IEAndroidPage.class.getName());
		public chromeHomePageObject chromeHomePageObject = new chromeHomePageObject();

		public ChromeHomePage(AppiumDriver<RemoteWebElement> driver) {
			super(driver);
			//PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), chromeHomePageObject);
		}

		/**
		 * This method will send data in the editbox
		 */
		@Step("Enter data in Username EditBox")
		public void sendDataInUsername(String text) {
			try {
				enterTextInTextbox(chromeHomePageObject.EmailId(), text);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		/**
		 * This method will send data in the editbox
		 */
		@Step("Enter data in Username EditBox")
		public void sendDataInPAssword(String text) {
			try {
				enterTextInTextbox(chromeHomePageObject.Password(), text);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public String getEmailData() {
			try {
				return getTexOfElement(chromeHomePageObject.EmailId());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
}
