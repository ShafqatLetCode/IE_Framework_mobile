package com.crestech.common.utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import com.crestech.annotation.values.ElementDescription;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CommonAlertElements {
	
	public AppiumDriver<RemoteWebElement> driver1;
	public CommonAlertElements(AppiumDriver<RemoteWebElement> driver) {
		this.driver1 = driver; 
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
	}

	public AppiumDriver<RemoteWebElement> driver;
	@ElementDescription(value = "Toast Message Element")
	@AndroidFindBy(xpath = "//android.widget.Toast")
	private MobileElement ToastMessageElement;

	@ElementDescription(value = "Toast Message Element List")
	@AndroidFindBy(xpath = "//android.widget.Toast")
	private List<MobileElement> ToastMessageElementList;

	@ElementDescription(value = "Toggle List")
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='android:id/switch_widget']")
	private List<MobileElement> toggleList;

	@ElementDescription(value = "Title Alert")
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='android:id/alertTitle']")
	private MobileElement TitleAlert;

	@ElementDescription(value = "Message Alert")
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='android:id/message']")
	private MobileElement MessageAlert;

	@ElementDescription(value = "Ok Alert")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='OK']")
	private MobileElement OKAlert;

	@ElementDescription(value = "Cancel Alert")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='CANCEL']")
	private MobileElement CancelAlert;

	@ElementDescription(value = "AllOW Button")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='AllOW']")
	private MobileElement AllOWAlert;

	@ElementDescription(value = "DENY Button")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='DENY']")
	private MobileElement DENYAlert;

	@ElementDescription(value = "DENY ANYWAY Button")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='DENY ANYWAY']")
	private MobileElement DENYANYWAYAlert;

	@ElementDescription(value = "Not Responding Title")
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='android:id/alertTitle']")
	private MobileElement NotRespondingTitle;

	@ElementDescription(value = "Not Responding Close")
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='android:id/aerr_close']")
	private MobileElement NotRespondingClose;

	@ElementDescription(value = "Not Responding Wait")
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='android:id/aerr_wait']")
	private MobileElement NotRespondingWait;

	@ElementDescription(value = "Permission Aler Message")
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.android.permissioncontroller:id/permissions_message']")
	private MobileElement PermissionAlertMessage;

	@ElementDescription(value = "Permission Alert Cancel")
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.android.permissioncontroller:id/cancel_button']")
	private MobileElement PermissionAlertCancel;

	@ElementDescription(value = "Permission Alert Continue")
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.android.permissioncontroller:id/continue_button']")
	private MobileElement PermissionAlertContinue;

	public MobileElement getToastMessageElement() {
		return ToastMessageElement;
	}

	public List<MobileElement> getToastMessageElementList() {
		return ToastMessageElementList;
	}

	public List<MobileElement> toggleList() {
		return toggleList;
	}

	public MobileElement PermissionAlertContinueButton() {
		return PermissionAlertContinue;
	}

	public MobileElement PermissionAlertCancelButton() {
		return PermissionAlertCancel;
	}

	public MobileElement getPermissionMessage() {
		return PermissionAlertMessage;
	}

	public MobileElement NotRespondingWaitButton() {
		return NotRespondingWait;
	}

	public MobileElement NotRespondingCloseButton() {
		return NotRespondingClose;
	}

	public MobileElement getNotRespondingTitle() {
		return NotRespondingTitle;
	}

	public MobileElement DenyAnywayButton() {
		return DENYANYWAYAlert;
	}

	public MobileElement DenyButton() {
		return DENYAlert;
	}

	public MobileElement OkButton() {
		return OKAlert;
	}

	public MobileElement CancelButton() {
		return CancelAlert;
	}

	public MobileElement AllowButton() {
		return AllOWAlert;
	}

	public MobileElement getalertMessage() {
		return MessageAlert;
	}

	public MobileElement getalertTitle() {
		return TitleAlert;
	}
	/**
	 * This is applications alert element asking to relaunch the application
	 */
	
	@ElementDescription(value = "Message")
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView[2]")
	private MobileElement Message;
	
	
	@ElementDescription(value = "Quit Button")
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.Button")
	private MobileElement QuitButton;
	
	@ElementDescription(value = "Title")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Alert']")
	private MobileElement Title;
	
	public MobileElement getMessage() {
		return Message;
	}
	
	public MobileElement getTitle() {
		return Title;
	}
	public MobileElement quitButton() {
		return QuitButton;
	}
	/**
	 * 
	 */
	
	
	/**
	 * This is applications alert element After login 
	 */
	   @ElementDescription(value = "Alert header")
		@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'txt_header')]")
		private MobileElement headerMessage;
		
		
		@ElementDescription(value = "Swipe Button")
		@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.view.View")
		private MobileElement swipeButton;
		
		
		public MobileElement headerMessage() {
			return headerMessage;
		}
		
		public MobileElement swipeButton() {
			return swipeButton;
		}
		
		/**
		 * 
		 */
		
		/**
		 * This is applications alert element asking to enable fingerprint
		 */
		   @ElementDescription(value = "Alert Fingerprint Message")
			@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'id/desc')]")
			private MobileElement headerFingerprintMessage;
			
			
			@ElementDescription(value = "Close Button")
			@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='CLOSE']")
			private MobileElement closeButton;
			
			
			public MobileElement headerFingerprintMessage() {
					return headerFingerprintMessage;
			}
			
			public MobileElement closeButton() {
				 return closeButton;
			}
			
			/**
			 * 
			 */
			
			/**
			 * This is applications alert element asking to enable recording
			 */
			   @ElementDescription(value = "Alert recordingt Message")
				@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'id/title')]")
				private MobileElement headerRecordingMessage;
			
				
			   //android.widget.ImageView[@content-desc="CLOSE"]
			   // closed button is same as previous popup
				
				public MobileElement headerRecordingMessage() {
					return headerRecordingMessage;
				}
				
			
}
