package com.crestech.pages;

import java.time.Duration;
import java.util.logging.Logger;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import com.crestech.appium.utils.CommonAppiumTest;
import com.crestech.common.utilities.Asserts;
import com.crestech.common.utilities.CommonAlertElements;
import com.crestech.pageobjects.DBSAndroidObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
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
	 *  @author Shafqat
	 * This method is for Re launching DBS Application 
	 */
	@Step("Relaunching DBS application")
	public void relaunchingDBS() {
	try {
		relanchApplication("com.dbs.sit1.dbsmbanking","com.dbs.sg.digibank.ui.demo.SplashActivity");
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	/**
	 *  @author Shafqat
	 * This method is for Re launching POSB Application 
	 */
	@Step("Relaunching POSB application")
	public void relaunchingPOSB() {
	try {
		relanchApplication("com.dbs.sit1.posbmbanking","com.dbs.sg.digibank.ui.demo.SplashActivity");
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	/**
	 *  @author Shafqat
	 * This method is for Re launching iWealth Application 
	 */
	@Step("Relaunching iWealth application")
	public void relaunchingIwealth() {
	try {
		relanchApplication("com.dbs.sg.uat.dbsiwealth","com.dbs.sg.digibank.ui.demo.SplashActivity");
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	
	/**
	 *
	 * @author Shafqat
	 *DBS Android APPLICATION 1st Page Functional Repository.
	 *
	 */
	
	/**
	 * This method is for clicking Login button 
	 */
	@Step("Clicked on Login button")
	public void clickOnLoginButton() {
	try {
		clickOnElement(DBSappObject.loginButton());
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	/**
	 * This method is for clicking Sign Up For Digibank button 
	 */
	@Step("Clicked on Sign Up For Digibank button")
	public void clickOnSignUpForDigibankButton() {
	try {
		clickOnElement(DBSappObject.signUpForDigibankButton());
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	/**
	 * This method is for clicking Pre Login button 
	 */
	@Step("Clicked on Pre Login button")
	public void preLoginButton(){
	try {
		clickOnElement(DBSappObject.loginButton());
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	
	/**
	 *
	 * @author Shafqat
	 *DBS Android APPLICATION Login Page Functional Repository.
	 *
	 */
	
	/**
	 * This method will send data in the editbox
	 */
	@Step("Enter data in User EditBox")
    public void sendDataInUserId(String text) {
	try {
		if(isElementEnable(DBSappObject.userIdEditText()))
			enterTextInTextbox(DBSappObject.userIdEditText(), text);
		
		Asserts.assertTrue(isElementEnable(DBSappObject.userIdEditText()), "EditField is not enable");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method will send data in the editbox
	 */
	@Step("Enter data in Pin EditBox")
    public void sendDataInUserPin(String text) {
	try {
		if(isElementEnable(DBSappObject.userPinEditText()))
			enterTextInTextbox(DBSappObject.userPinEditText(), text);
		
		
		Asserts.assertTrue(isElementEnable(DBSappObject.userPinEditText()), "EditField is not enable");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 *
	 * @author Shafqat
	 *DBS Android APPLICATION OneAppPostLogin(Homepage) Functional Repository.
	 *
	 *
	 *
	 	/**
	 * This method will verifying 'wlecome to' field
	 */
	@Step("Verify 'welcome to' field")
    public void verifyTextWelcomeTo(String expectedText) {
	try {
		String actualText=getTexOfElement(DBSappObject.WelcomeToText()).trim();
		Asserts.assertEquals(actualText, expectedText, "'Welcome To' text is not found");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
 	/**
	 * This method will verifying 'wlecome to' field
	 */
	@Step("Verify 'digibank' field")
    public void verifyTextDigibank(String expectedText) {
	try {
		String actualText=getTexOfElement(DBSappObject.DigibankText()).trim();
		Asserts.assertEquals(actualText, expectedText, "'digibank' text is not found");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * This method will verifying 'Logout button' and perform click action
	 */
	@Step("Verify 'Logout' field and perform click action")
    public void clickOnLogoutAndVerify(String expectedText) {
	try {
		String actualText=getTexOfElement(DBSappObject.logoutButton());
		if(actualText.equalsIgnoreCase(expectedText))
			CommonAppiumTest.clickOnElement(DBSappObject.logoutButton());
		
		Asserts.assertEquals(actualText, expectedText, "'Logout' button is not found");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 *
	 * @author Shafqat
	 *DBS Android APPLICATION post logout Screen-Tap on the stars to rate Functional Repository.
	 *
	 *
	 *
	/**
	 * This method will verifying 'Tap on the stars to rate' field
	 */
	@Step( "Verify 'Tap on the stars to rate' field" )
    public void verifyTextTapOnTheStars(String expectedText) {
	try {
		String actualText=getTexOfElement(DBSappObject.postLogoutAlertMessage());
		
		Asserts.assertEquals(actualText, expectedText, "'Tap on the stars to rate' Text is not found");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 *
	 * @author Shafqat
	 *DBS Android APPLICATION Token Setup Functional Repository.
	 *
	 *
	 *
	/**
	 * This method will click on 'Set up now button' After verifying page header message field
	 */
	@Step("Verifying Page and clicking on 'SET UP NOW' button ")
	public void verifyPageAndClickOnSetUpNowButton(String expectecMessage) throws Exception    
	{
		try {

			String actualMessage = CommonAppiumTest.getTexOfElement(DBSappObject.tokenSetupMessage());
			
				if(actualMessage.equalsIgnoreCase(expectecMessage))
					CommonAppiumTest.clickOnElement(DBSappObject.setUpNowButton());
				   
				
				Asserts.assertEquals(actualMessage, expectecMessage, "Title Message Not matching");
					
			
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	
	}
	/**
	 * This method will Verify Email/SMS OTP Page and Send OTP on TextField button
	 */
	@Step("Verifying Email/SMS OTP Page and Send OTP on TextField button ")
	public void verifyPageAndSendOtpToEditBox(String OTP, String expectecMessage) throws Exception   
	{
		try {

			String actualMessage = CommonAppiumTest.getTexOfElement(DBSappObject.emailSmsOtpMessage());
			
				if(actualMessage.equalsIgnoreCase(expectecMessage))
					if(isElementEnable(DBSappObject.emailSmsOtpEditBox()))
						enterTextInTextbox(DBSappObject.emailSmsOtpEditBox(), OTP);
				Asserts.assertTrue(isElementEnable(DBSappObject.emailSmsOtpEditBox()), "TextField is not enable");
				   
				
				Asserts.assertEquals(actualMessage, expectecMessage, "Title Message Not matching");
					
			
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	
	}
	/**
	 * This method will click on 'Done button' After verifying page header message After token is verified
	 */
	@Step("Verifying Page after Token setup and clicking on 'Done' button")
	public void verifyPageAndClickOnDone(String expectecMessage) throws Exception    
	{
		try {

			String actualMessage = CommonAppiumTest.getTexOfElement(DBSappObject.tokenGetSetupMessage());
			
				if(actualMessage.equalsIgnoreCase(expectecMessage))
					CommonAppiumTest.clickOnElement(DBSappObject.doneButton());
				   
				
				Asserts.assertEquals(actualMessage, expectecMessage, "Title Message Not matching");
					
			
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	
	}

}
