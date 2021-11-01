package com.crestech.pages;

import java.time.Duration;
import java.util.logging.Logger;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import com.crestech.appium.utils.CommonAppiumTest;
import com.crestech.pageobjects.DBSAndroidObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;

public class DBSAndroidPage extends CommonAppiumTest {

	static Logger log = Logger.getLogger(DBSAndroidPage.class.getName());
	public DBSAndroidObject DBSappObject = new DBSAndroidObject();
	
	public DBSAndroidPage(AppiumDriver<RemoteWebElement> driver) {
		super(driver);
		try {
			PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), DBSappObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method will send data in the editbox
	 */
	@Step("Enter data in Username EditBox")
	public void sendDataInUsername(String text) {
		try {
			enterTextInTextbox(DBSappObject.EmailId(), text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * This method will send data in the editbox
	 */
	@Step("Enter data in Username EditBox")
	public void sendDataInPAssword(String text) {
		try {
			enterTextInTextbox(DBSappObject.Password(), text);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This method is to click Views
	 */
	@Step("Clicked on Views Link")
	public void clickOnGraphics() {
		try {
			clickOnElement(DBSappObject.Graphics());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Step("Clicked on Views Link")
	public void clickOnWebViews() {
		try {
			clickOnElement(DBSappObject.WebView());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Step("Clicked on Views Link")
	public void clickOnDragAndDrop() {
		try {
			clickOnElement(DBSappObject.dragAndDrop());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
