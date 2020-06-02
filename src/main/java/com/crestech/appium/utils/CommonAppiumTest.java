package com.crestech.appium.utils;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.remote.RemoteWebElement;

import com.crestech.common.utilities.GestureUtils;
import com.crestech.common.utilities.WaitUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class CommonAppiumTest extends CommandPrompt {

	public AppiumDriver<RemoteWebElement> driver;
	public WaitUtils wait=null;
	public GestureUtils gesture=null;

	public CommonAppiumTest(AppiumDriver<RemoteWebElement> driver2) {
		this.driver = driver2;
	    wait=new WaitUtils(driver2);	
	    gesture=new GestureUtils(driver2);
	}

	/**
	 * Click on element
	 * 
	 * @param element
	 */
	public void clickOnElement(MobileElement element) {
		element.click();
	}

	/**
	 * SendText to textFiled
	 * 
	 * @param element
	 * @param TextWhich need to send to textfield
	 */
	public void sendkeys(MobileElement element, String keysToSend) {
		element.sendKeys(keysToSend);
		;
	}

	/**
	 * Extract Text from Element
	 * 
	 * @param element
	 * @return text
	 */
	public String getTexOfElement(MobileElement element) {
		return element.getText();
	}

	/**
	 * Check whether element is displayed
	 * 
	 * @param element
	 * @return boolean
	 */
	public boolean isElementVisible(MobileElement element) {
		return element.isDisplayed();
	}

	/**
	 * 
	 * @param element
	 * @return Point(x and Y co-ordinate)
	 */
	public Point getLocationOfElement(MobileElement element) {
		return element.getLocation();
	}

	/**
	 * 
	 * @param element
	 * @return X co-ordinate
	 */
	public int getXCoordinateOfElement(MobileElement element) {
		return element.getLocation().getX();
	}

	/**
	 * 
	 * @param element
	 * @return Y co-ordinate
	 */
	public int getYCoordinateOfElement(MobileElement element) {
		return element.getLocation().getY();
	}

	/**
	 * Click On Home Button
	 */
	public void clickOnHomeButton() {
		((AndroidDriver<RemoteWebElement>) driver).pressKey(new KeyEvent(AndroidKey.HOME));
	}

	/**
	 * Lock the device
	 */
	public void lockTheDevice() {
		((AndroidDriver<RemoteWebElement>) driver).lockDevice();
	}

	/**
	 * Check if device is locked
	 * 
	 * @return
	 */
	public boolean isDeviceLocked() {
		boolean isLocked = ((AndroidDriver<RemoteWebElement>) driver).isDeviceLocked();
		return isLocked;
	}

	/**
	 * Unlock the device
	 */

	public void unlockTheDevice() {
		((AndroidDriver<RemoteWebElement>) driver).unlockDevice();
	}

	/**
	 * Enable Wifi
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void enableWifi(String os) throws InterruptedException, IOException {

		ConfigurationManager prop = ConfigurationManager.getInstance();
		if (os.equalsIgnoreCase("Local")) {
			((AndroidDriver<RemoteWebElement>) driver)
					.setConnection(new ConnectionStateBuilder().withWiFiEnabled().build());
			System.out.println("Enable Wifi");
		} else {
			driver.executeScript("pCloudy_enableWifi", true);
		}
	}

	/**
	 * Open Notification bar
	 */
	public void clickOnopenNotificationDrawer() {
		((AndroidDriver<RemoteWebElement>) driver).openNotifications();

	}

	public void backButton() {
		((AndroidDriver<RemoteWebElement>) driver).pressKey(new KeyEvent(AndroidKey.BACK));
	}

	/**
	 * disable Wifi
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void disableWifi(String os) throws InterruptedException, IOException {
		ConfigurationManager prop = ConfigurationManager.getInstance();
		if (os.equalsIgnoreCase("Local")) {
			((AndroidDriver<RemoteWebElement>) driver)
					.setConnection(new ConnectionStateBuilder().withWiFiDisabled().build());
			System.out.println("Disable Wifi");
		} else {
			driver.executeScript("pCloudy_enableWifi", false);

		}
	}

	public void resetApplication() {
		driver.resetApp();
	}

	/**
	 * Launch the App again.
	 */

	public void launchApp() {
		driver.launchApp();
	}

	/**
	 * Swiping from top panel to open quick settings.
	 */
	public void scrollQuickSettings() {
		Dimension windowSize = driver.manage().window().getSize();
		int starty = (int) (windowSize.height * 0.10);
		int endy = (int) (windowSize.height * 0.90);
		int startx = windowSize.width / 2;
		new TouchAction<>(driver).press(PointOption.point(startx, endy))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(startx, starty))
				.release().perform();
	}

	/**
	 * Keep App in background
	 */
	public void runInBackgroundApp() {
		driver.runAppInBackground(Duration.ofMillis(10));
	}

	/**
	 * Open Background app
	 */
	public void openbackGroundAPP() {
		((StartsActivity) driver).currentActivity();
	}

}