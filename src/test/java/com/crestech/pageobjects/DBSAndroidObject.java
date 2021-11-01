package com.crestech.pageobjects;

import org.openqa.selenium.support.FindBy;
import com.crestech.annotation.values.ElementDescription;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;;

/**
 *
 * @author Divya
 *This class is used to store the objects of Android Page.
 *
 */

public class DBSAndroidObject {

	@ElementDescription(value = "Views Button")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Graphics']")
	private MobileElement Graphics;

	@ElementDescription(value = "Views Button")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='WebView']")
	private MobileElement WebView;

	@ElementDescription(value = "Drag and drop Button")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Drag and Drop']")
	private MobileElement dragAndDrop;

	@ElementDescription(value = "Drag and drop Button")
	@AndroidFindBy(xpath = "//android.view.View[@resource-id='io.appium.android.apis:id/drag_dot_1']")
	private MobileElement dragAndDrop1;

	@ElementDescription(value = "Drag and drop Button")
	@AndroidFindBy(xpath = "//android.view.View[@resourceid='io.appium.android.apis:id/drag_dot_2']")
	private MobileElement dragAndDrop2;
	
	@ElementDescription(value = "EmailId")
	@FindBy(id = "m_login_email")
	//@AndroidFindBy(id = "m_login_email")
	private MobileElement EmailId;
	
	@ElementDescription(value = "Password")
	@FindBy(id = "m_login_password")
	//@AndroidFindBy(id = "m_login_password")
	private MobileElement Password; 

	public MobileElement Graphics() {
		return Graphics;
	}

	public MobileElement WebView() {
		return WebView;
	}

	public MobileElement dragAndDrop() {
		return dragAndDrop;
	}

	public MobileElement dragAndDrop1() {
		return dragAndDrop1;
	}

	public MobileElement dragAndDrop2() {
		return dragAndDrop2;
	}
	
	public MobileElement EmailId() {
		return EmailId;
	}

	
	public MobileElement Password() {
		return Password;
	}

	/*
	 * public pCloudyHomePageObject(AppiumDriver<RemoteWebElement> driver) {
	 * PageFactory.initElements(driver, this); }
	 */

	/*
	 * public MobileElement getAcceptButton() { return acceptButton; }
	 */
//	@ElementDescription(value = "Allow Button")
//	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.pcloudy.appiumdemo:id/accept']")
//	private MobileElement allowButton;
//
//	@ElementDescription(value = "flight Button")
//	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.pcloudy.appiumdemo:id/flightButton']")
//	private MobileElement flightButton;
//
//	@ElementDescription(value = " spinner from")
//	@AndroidFindBy(xpath = "//android.widget.Spinner[@resource-id='com.pcloudy.appiumdemo:id/spinnerfrom']")
//	private MobileElement spinnerfrom;
//
//	@ElementDescription(value = " Select Bangalore Title")
//	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='Bangalore, India (BLR)']")
//	private MobileElement selectCity;
//
//	/*********************************
//	 * API DEMO APPLICATION Elements_STARTS
//	 ***************************************************************/
//	@ElementDescription(value = "Views")
//	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Views']")
//	private MobileElement Views;
//
//	@ElementDescription(value = "AutoComplete")
//	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Auto Complete']")
//	// For checking failed scenario
//	//@AndroidFindBy(xpath = "//android.widget.TextView[@text='Auto Complete text']")
//	private MobileElement AutoComplete;
//
//	@ElementDescription(value = "MultipleItems")
//	@AndroidFindBy(xpath = "//android.widget.TextView[@text='6. Multiple items']")
//	private MobileElement MultipleItems;
//
//	@ElementDescription(value = "EditField")
//	@AndroidFindBy(id = "com.example.android.apis:id/edit")
//	private MobileElement selectEditField;
//
//	@ElementDescription(value = "Text")
//	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Text']")
//	private MobileElement Text;
//
//	@ElementDescription(value = "Marquee")
//	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Marquee']")
//	private MobileElement selectMarquee;
//
//	@ElementDescription(value = "MarqueeButton")
//	@AndroidFindBy(xpath = "//android.widget.Button[1]")
//	private MobileElement selectMarqueeButton;
//
//	@ElementDescription(value = "Animation")
//	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Animation']")
//	private MobileElement Animation;
//
//	@ElementDescription(value = "Seeking")
//	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Seeking']")
//	private MobileElement Seeking;
//
//	@ElementDescription(value = "Seekbar")
//	@AndroidFindBy(id = "com.example.android.apis:id/seekBar")
//	private MobileElement selectSeekbar;
//
//	@ElementDescription(value = "RunButton")
//	@AndroidFindBy(xpath = "//android.widget.Button[@text='RUN']")
//	private MobileElement RunButton;
//
//	/*********************************
//	 * API DEMO APPLICATION Elements_ENDS
//	 ***************************************************************/
//
//	/*********************************
//	 * API DEMO APPLICATION Getter Setter_STARTS
//	 ***************************************************************/
//
//	public MobileElement Views() {
//		return Views;
//	}
//
//	public MobileElement AutoComplete() {
//		return AutoComplete;
//	}
//
//	public MobileElement MultipleItems() {
//		return MultipleItems;
//	}
//
//	public MobileElement Text() {
//		return Text;
//	}
//
//	public MobileElement Animation() {
//		return Animation;
//	}
//
//	public MobileElement Seeking() {
//		return Seeking;
//	}
//
//	public MobileElement RunButton() {
//		return RunButton;
//	}
//
//	public MobileElement getSelectMarqueeButton() {
//		return selectMarqueeButton;
//	}
//
//	public MobileElement getSelectEditField() {
//		return selectEditField;
//	}
//
//	public MobileElement getSelectMarquee() {
//		return selectMarquee;
//	}
//
//	public MobileElement getSelectSeekbar() {
//		return selectSeekbar;
//	}
//
//	/*********************************
//	 * API DEMO APPLICATION Getter Setter_ENDS
//	 ***************************************************************/
//
//	public MobileElement getSelectCity() {
//		return selectCity;
//	}
//
//	public MobileElement allowButton() {
//		return allowButton;
//	}
//
//	public MobileElement getFlightButton() {
//		return flightButton;
//	}
//
//	public MobileElement spinnerfrom() {
//		return spinnerfrom;
//	}

}