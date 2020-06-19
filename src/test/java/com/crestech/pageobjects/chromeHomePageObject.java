package com.crestech.pageobjects;

import org.openqa.selenium.support.FindBy;

import com.crestech.annotation.values.ElementDescription;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class chromeHomePageObject {

	@ElementDescription(value = "EmailId")
	@FindBy(id = "m_login_email")
	//@AndroidFindBy(id = "m_login_email")
	private MobileElement EmailId;
	
	@ElementDescription(value = "Password")
	@FindBy(id = "m_login_password")
	//@AndroidFindBy(id = "m_login_password")
	private MobileElement Password;

	
	
	
	
	
	
	public MobileElement EmailId() {
		return EmailId;
	}

	
	public MobileElement Password() {
		return Password;
	}
	
	
}
