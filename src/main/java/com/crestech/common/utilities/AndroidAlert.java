package com.crestech.common.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.RemoteWebElement;
import com.crestech.appium.utils.CommonAppiumTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;

/**
 * @author Shafkat Ali, Divya Devi
 *
 */
public class AndroidAlert{

	public AppiumDriver<RemoteWebElement> driver;
	CommonAppiumTest commonAppTest = null;
	GestureUtils gestUtils = null;
	HandleException obj_handleexception = null;
	public AndroidAlert(AppiumDriver<RemoteWebElement> driver2) {
		this.driver = driver2;
		commonAppTest = new CommonAppiumTest(driver);
		gestUtils = new GestureUtils(driver);
		obj_handleexception =new HandleException(null, null);
	}
	
	public String ToastMessage() throws Exception    //android.widget.Toast[1]
	{
		try {
			CommonAlertElements obj =new CommonAlertElements(driver);
			return obj.getToastMessageElement().getAttribute("name");
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
	}
	
	public List<String> MultiToastMessage() throws Exception    //android.widget.Toast[1]
	{
		try {
			CommonAlertElements obj =new CommonAlertElements(driver);
			List<MobileElement> Elementlist = obj.getToastMessageElementList();
		
			int l = Elementlist.size();
			List<String> ToastMessagelist = new ArrayList<String>();
			String str;
			for (int i = 0; i < l; i++) {
				str = Elementlist.get(i).getAttribute("name");
				ToastMessagelist.add(i, str);
			}
			return ToastMessagelist;
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
	}
	
	public void PermissionAlertToggleList(int index) throws Exception {

		try {
			CommonAlertElements obj = new CommonAlertElements(driver);
			List<MobileElement> Elementlist = obj.toggleList();

			commonAppTest.clickOnElement(Elementlist.get(index));

		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
	}
	
	public void AlertHandlingWithButtonTiltleMessage(MobileElement Button, String expectecMessage, String expectecTitle) throws Exception    //android.widget.Toast[1]
	{
		try {
			CommonAlertElements obj =new CommonAlertElements(driver);
			String actualTitle = commonAppTest.getTexOfElement(obj.getalertTitle());
			String actualMessage = commonAppTest.getTexOfElement(obj.getalertMessage());
			
				if( actualTitle.equalsIgnoreCase(expectecTitle) && actualMessage.equalsIgnoreCase(expectecMessage))
					commonAppTest.clickOnElement(Button);
				   
				Asserts.assertEquals(actualTitle, expectecTitle, "Title Not matching");
				Asserts.assertEquals(actualMessage, expectecMessage, "Alert Message Not matching");
					
			
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
	
	}
	
	public void AlertHandlingWithButtonMessage(MobileElement Button, String expectecMessage, MobileElement messageElement) throws Exception    //android.widget.Toast[1]
	{
		try {
			String actualMessage = commonAppTest.getTexOfElement(messageElement);
			Asserts.assertEquals(actualMessage, expectecMessage, "Message Not matching");
			if (actualMessage.equalsIgnoreCase(expectecMessage))
				commonAppTest.clickOnElement(Button);
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Alert Handling  ",e);		
		}
		catch (Exception e) {			
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Alert Handling   ",e);
		}
	}
	
	/**
	 *Relaunch application alert
	 */
	@Step("Quiting the application for relanching")
	public void relanchAlertWithButtonTiltleMessage(MobileElement Button, String expectecMessage, String expectecTitle) throws Exception    //android.widget.Toast[1]
	{
		try {CommonAlertElements obj =new CommonAlertElements(driver);
			String actualTitle = commonAppTest.getTexOfElement(obj.getTitle());
			String actualMessage = commonAppTest.getTexOfElement(obj.getMessage());
			
				if( actualTitle.equalsIgnoreCase(expectecTitle) && actualMessage.equalsIgnoreCase(expectecMessage))
					commonAppTest.clickOnElement(Button);
				   
				Asserts.assertEquals(actualTitle, expectecTitle, "Title Not matching");
				Asserts.assertEquals(actualMessage, expectecMessage, "Alert Message Not matching");
					
			
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
	
	}


	
	@Step("Accepting Alert Message")
	public void AlertHandlingWithButtonMessageContainsCase(MobileElement Button, String expectecMessage) throws Exception    //android.widget.Toast[1]
	{
		try {

			CommonAlertElements obj =new CommonAlertElements(driver);
			String actualMessage = commonAppTest.getTexOfElement(obj.getalertMessage());
			
				if(actualMessage.toLowerCase().contains(expectecMessage.toLowerCase()))
					commonAppTest.clickOnElement(Button);
				   
				
				Asserts.assertTrue(actualMessage.toLowerCase().contains(expectecMessage.toLowerCase()), "Alert Message Does not contain expected String");
					
			
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
	
	}
	
	public void AlertHandlingWithButtonTiltle(MobileElement Button, String expectecTitle) throws Exception    //android.widget.Toast[1]
	{
		try {
			CommonAlertElements obj =new CommonAlertElements(driver);
			String actualTitle = commonAppTest.getTexOfElement(obj.getalertTitle());
			
			
				if( actualTitle.equalsIgnoreCase(expectecTitle))
					commonAppTest.clickOnElement(Button);
				   
				Asserts.assertEquals(actualTitle, expectecTitle, "Title Not matching");
				
					
			
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
	
	}
	public void notRespondingAlertWithButtonTiltle(MobileElement Button, String expectecTitle) throws Exception    //android.widget.Toast[1]
	{
		try {
			CommonAlertElements obj =new CommonAlertElements(driver);
			String actualTitle = commonAppTest.getTexOfElement(obj.getNotRespondingTitle());
			
			
				if( actualTitle.equalsIgnoreCase(expectecTitle))
					commonAppTest.clickOnElement(Button);
				   
				Asserts.assertEquals(actualTitle, expectecTitle, "Title Not matching");
				
					
			
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
	
	}
	public void permissionAlertWithButtonMessage(MobileElement Button, String expectecMessage) throws Exception    //android.widget.Toast[1]
	{
		try {

			CommonAlertElements obj =new CommonAlertElements(driver);
			String actualMessage = commonAppTest.getTexOfElement(obj.getPermissionMessage());
			
				if(actualMessage.equalsIgnoreCase(expectecMessage))
					commonAppTest.clickOnElement(Button);
				   
				
				Asserts.assertEquals(actualMessage, expectecMessage, "Alert Message Not matching");
					
			
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
	
	}
	
	public String getAlertTitle(MobileElement title) throws Exception    //android.widget.Toast[1]
	{
		try {	
			return title.getText();
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
	
	}
	public String getAlertMessage(MobileElement message) throws Exception    
	{
		try {
			return message.getText();
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
		
	}
	
	public void ClickOnButtonAlert(MobileElement Button) throws Exception    
	{
		try {
		
		commonAppTest.clickOnElement(Button);
		
	} catch (Exception e) {
		e.printStackTrace(); throw e;
	}
	}
	
	
	public void getContextWebORNative() throws Exception    //android.widget.Toast[1]
	{
		try {
			Set<String> contextNames = driver.getContextHandles();
		for (String contextName : contextNames) {
		    System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
		}
	
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}}
	public void switchContext(String AppType) throws Exception    //android.widget.Toast[1]
	{
		try {
			
		driver.context(AppType);
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
		
	}

	/**
	 * This is applications 1st alert handling After login 
	 */
	@Step
	public void handlingFirstPopupAfterLogin(String expectecMessage) throws Exception    
	{
		
		try {
			CommonAlertElements obj =new CommonAlertElements(driver);
			String actualMessage = commonAppTest.getTexOfElement(obj.headerMessage());
			if(actualMessage.equalsIgnoreCase(expectecMessage)) {
				Dimension windowSize1 = driver.manage().window().getSize();
				int y =(int)((windowSize1.getHeight())-10);
				int x =(int)((windowSize1.getWidth())/2);
				gestUtils.swipeElementtoCoordinate(obj.swipeButton(),  x,  y);
			}
			
			Asserts.assertEquals(actualMessage, expectecMessage, "Alert Message Not matching");
			
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
	}
	
	public boolean isAlertPresent() {
		try {
			this.driver.switchTo().alert();
			return true;
		} 
		catch (Exception Ex) {
			return false;
		} 
	} 

	public boolean isIOSAlertPresent() {
		try {
			this.driver.findElementByXPath("//XCUIElementTypeStaticText[@name='digibank Alert']");
			return true;
		} 
		catch (Exception Ex) {
			return false;
		} 
	}
	
	public boolean isIOSOfflineAlertPresent() {
		try {
			this.driver.findElementByXPath("//XCUIElementTypeStaticText[@name='You seem to be offline']");
			return true;
		} 
		catch (Exception Ex) {
			return false;
		} 
	}

}
