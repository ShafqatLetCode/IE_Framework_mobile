package com.crestech.common.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.crestech.appium.utils.CommonAppiumTest;
import com.crestech.base.UserBaseTest;

import io.appium.java_client.MobileElement;

public class AndroidAlert extends UserBaseTest{
	
	CommonAlertElements obj =new CommonAlertElements(driver);
	
	public String ToastMessage() throws Exception    //android.widget.Toast[1]
	{
		try {
			return obj.getToastMessageElement().getAttribute("name");
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}
	
	public List<String> MultiToastMessage() throws Exception    //android.widget.Toast[1]
	{
		try {
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
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}
	
	public void PermissionAlertToggleList(int index) throws Exception    
	{
		
		try {
			List<MobileElement> Elementlist = obj.toggleList();
			
			CommonAppiumTest.clickOnElement(Elementlist.get(index));
			
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}
	
	public void AlertHandlingWithButtonTiltleMessage(MobileElement Button, String expectecMessage, String expectecTitle) throws Exception    //android.widget.Toast[1]
	{
		try {
			String actualTitle = CommonAppiumTest.getTexOfElement(obj.getalertTitle());
			String actualMessage = CommonAppiumTest.getTexOfElement(obj.getalertMessage());
			
				if( actualTitle.equalsIgnoreCase(expectecTitle) && actualMessage.equalsIgnoreCase(expectecMessage))
					CommonAppiumTest.clickOnElement(Button);
				   
				Asserts.assertEquals(actualTitle, expectecTitle, "Title Not matching");
				Asserts.assertEquals(actualMessage, expectecMessage, "Alert Message Not matching");
					
			
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	
	}
	public void AlertHandlingWithButtonMessage(MobileElement Button, String expectecMessage) throws Exception    //android.widget.Toast[1]
	{
		try {


			String actualMessage = CommonAppiumTest.getTexOfElement(obj.getalertMessage());
			
				if(actualMessage.equalsIgnoreCase(expectecMessage))
					CommonAppiumTest.clickOnElement(Button);
				   
				
				Asserts.assertEquals(actualMessage, expectecMessage, "Alert Message Not matching");
					
			
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	
	}
	
	public void AlertHandlingWithButtonTiltle(MobileElement Button, String expectecTitle) throws Exception    //android.widget.Toast[1]
	{
		try {
			String actualTitle = CommonAppiumTest.getTexOfElement(obj.getalertTitle());
			
			
				if( actualTitle.equalsIgnoreCase(expectecTitle))
					CommonAppiumTest.clickOnElement(Button);
				   
				Asserts.assertEquals(actualTitle, expectecTitle, "Title Not matching");
				
					
			
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	
	}
	public void notRespondingAlertWithButtonTiltle(MobileElement Button, String expectecTitle) throws Exception    //android.widget.Toast[1]
	{
		try {
			String actualTitle = CommonAppiumTest.getTexOfElement(obj.getNotRespondingTitle());
			
			
				if( actualTitle.equalsIgnoreCase(expectecTitle))
					CommonAppiumTest.clickOnElement(Button);
				   
				Asserts.assertEquals(actualTitle, expectecTitle, "Title Not matching");
				
					
			
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	
	}
	public void permissionAlertWithButtonMessage(MobileElement Button, String expectecMessage) throws Exception    //android.widget.Toast[1]
	{
		try {


			String actualMessage = CommonAppiumTest.getTexOfElement(obj.getPermissionMessage());
			
				if(actualMessage.equalsIgnoreCase(expectecMessage))
					CommonAppiumTest.clickOnElement(Button);
				   
				
				Asserts.assertEquals(actualMessage, expectecMessage, "Alert Message Not matching");
					
			
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	
	}
	
	public String getAlertTitle(MobileElement title) throws Exception    //android.widget.Toast[1]
	{
		try {	
			return title.getText();
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	
	}
	public String getAlertMessage(MobileElement message) throws Exception    
	{
		try {
			return message.getText();
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
		
	}
	
	public void ClickOnButtonAlert(MobileElement Button) throws Exception    
	{
		try {
		
		CommonAppiumTest.clickOnElement(Button);
		
	} catch (Exception e) {
		throw new Exception(CommonAppiumTest.getExceptionMessage(e));
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
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}}
	public void switchContext(String AppType) throws Exception    //android.widget.Toast[1]
	{
		try {
			
		driver.context(AppType);
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
		
	}
	

}
