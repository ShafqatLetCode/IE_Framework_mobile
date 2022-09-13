package com.ie.pages.androidpage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import com.ie.annotation.values.ElementDescription;
import com.ie.appium.utils.CommonAppiumTest;
import com.ie.common.utilities.Asserts;
import com.ie.common.utilities.GestureUtils;
import com.ie.common.utilities.HandleException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;

/**
 * @author Divya
 *
 */
public class preloginPage extends CommonAppiumTest{

	public AppiumDriver<RemoteWebElement> driver = null;
	HandleException obj_handleexception = null;
	GestureUtils gestUtils = null;
	settingPage launchpage = null;
	
	public preloginPage(AppiumDriver<RemoteWebElement> driver) throws Exception {
		super(driver);
		try {
			this.driver = driver;
		    gestUtils = new GestureUtils(driver);
		    launchpage = new settingPage(driver);
		    obj_handleexception = new HandleException(null, null);
			PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@ElementDescription(value = "city title")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,\"title_city\")]")
	private MobileElement cityTitle;
	
	@ElementDescription(value = "city option")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,\"city_name\")]")
	private List<MobileElement> cityOption;
	
	@ElementDescription(value = "continue button")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,\"btn_continue\")]")
	private MobileElement continueButton;
	
	@ElementDescription(value = "interest title")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,\"title_select_interest\")]")
	private MobileElement interestTitle;
	
	@Step("Selecting city {city}")
	public void selectCity(String city) throws Exception {
		try {	
			wait.waitForElement(cityTitle, 
					5,
					"Select Title",
					"city selection page"
				);
			
			for (int i = 0; i < cityOption.size(); i++) {
				 if(cityOption.get(i).getText().toLowerCase().contains(city.toLowerCase()))
				 {
					 clickOn(cityOption.get(i), 
							 city,
							"Selecting city"
							);
				 }
	        }
			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select city "+city, e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select city  "+city, e);
		}
	}
	
	@Step("Click on continue button")
	public void continueButton() throws Exception {
		try {
			wait.waitForElement(continueButton, 
					5,
					"continue button",
					"verifiying on continue button"
				);
			
			clickOn(continueButton, 
					"continue button",
					"continue button fron select city"
				);

			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION",
					" Failed to click on continue button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION",
					" Failed to click on continue button ", e);
		}
	}
	
	@Step("Selecting interest {interest1}, {interest2}, {interest3}")
	public void selectInterest(String interest1,String interest2, String interest3) throws Exception {
		try {	
			wait.waitForElement(interestTitle, 
					5,
					"Interest Title",
					"Interest selection page"
				);
			
			for (int i = 0; i < cityOption.size(); i++) {
				
				 if(cityOption.get(i).getText().toLowerCase().contains(interest1.toLowerCase()))
				 {
					 clickOn(cityOption.get(i), 
							 interest1,
							"Selecting city"
							);
				 }
				 if(cityOption.get(i).getText().toLowerCase().contains(interest2.toLowerCase()))
				 {
					 clickOn(cityOption.get(i), 
							 interest2,
							"Selecting city"
							);
				 }
				 if(cityOption.get(i).getText().toLowerCase().contains(interest3.toLowerCase()))
				 {
					 clickOn(cityOption.get(i), 
							 interest3,
							"Selecting city"
							);
				 }
	        }
			
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Select interest "+interest1 +" "+interest2+" "+interest3, e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Select interest  "+interest1 +" "+interest2+" "+interest3, e);
		}
	}
	
	
	
}
