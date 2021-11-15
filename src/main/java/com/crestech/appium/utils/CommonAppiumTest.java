package com.crestech.appium.utils;

import java.time.Duration;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.remote.RemoteWebElement;
import com.crestech.common.utilities.GestureUtils;
import com.crestech.common.utilities.WaitUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;

public class CommonAppiumTest extends CommandPrompt {

	public static AppiumDriver<RemoteWebElement> driver;
	public static WaitUtils wait = null;
	public GestureUtils gesture = null;

	public CommonAppiumTest(AppiumDriver<RemoteWebElement> driver2) {
		this.driver = driver2;
		wait = new WaitUtils(driver2);
		gesture = new GestureUtils(driver2);
	}

	/**
	 *  Re launching the application
	 * @throws Exception
	 */
	@Step("application the Relanching")
	public static void relanchApplication(String appPackage, String appActivity) throws Exception
	{
		try {
		
		Activity activity = new Activity(appPackage, appActivity);
		((AndroidDriver<RemoteWebElement>)driver).startActivity(activity);
		wait.ImplicitlyWait();
	
		} catch (Exception e) {
			
			throw new Exception(getExceptionMessage(e));
		}
	}
	/**
	 * Click on element
	 * @param element
	 * @throws Exception
	 */
	public static void clickOnElement(MobileElement element) throws Exception {
		try {
			wait.waitForElementToBeClickable(element);
			element.click();
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	/**
	 * SendText to textFiled
	 * 
	 * @param element
	 * @param TextWhich need to send to textfield
	 * @throws Exception
	 */
	public static void enterTextInTextbox(MobileElement element, String keysToSend) throws Exception {
		try {
			wait.waitForElementVisibility(element);
			element.sendKeys(keysToSend);
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	/**
	 * Extract Text from Element
	 * @param element
	 * @return text
	 * @throws Exception
	 */
	public static String getTexOfElement(MobileElement element) throws Exception {
		try {
			wait.waitForElementVisibility(element);
			return element.getText();
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	/**
	 * Check whether element is displayed
	 * 
	 * @param element
	 * @return boolean
	 * @throws Exception
	 */
	public static boolean isElementVisible(MobileElement element) throws Exception {
		try {
			wait.waitForElementVisibility(element);
			return element.isDisplayed();
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}
	/**
	 * Check whether element is enable
	 * 
	 * @param element
	 * @return boolean
	 * @throws Exception
	 */
	public static boolean isElementEnable(MobileElement element) throws Exception {
		try {
			wait.waitForElementVisibility(element);
			return element.isEnabled();
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}
	/**
	 * Check whether element is selected
	 * 
	 * @param element
	 * @return boolean
	 * @throws Exception
	 */
	public static boolean isElementSelected(MobileElement element) throws Exception {
		try {
			wait.waitForElementVisibility(element);
			return element.isSelected();
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	/**
	 * 
	 * @param element
	 * @return Point(x and Y co-ordinate)
	 * @throws Exception
	 */
	public static Point getLocationOfElement(MobileElement element) throws Exception {
		try {
			return element.getLocation();
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	/**
	 * 
	 * @param element
	 * @return X co-ordinate
	 * @throws Exception
	 */
	public static int getXCoordinateOfElement(MobileElement element) throws Exception {
		try {
			wait.waitForElementToBeClickable(element);
			return element.getLocation().getX();
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	/**
	 * 
	 * @param element
	 * @return Y co-ordinate
	 * @throws Exception
	 */
	public static int getYCoordinateOfElement(MobileElement element) throws Exception {
		try {
			wait.waitForElementToBeClickable(element);
			return element.getLocation().getY();
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	/**
	 * Click On Home Button
	 * 
	 * @throws Exception
	 */
	//WORKING FINE
	public static void clickOnHomeButton() throws Exception {
		try {
			((AndroidDriver<RemoteWebElement>) driver).pressKey(new KeyEvent(AndroidKey.HOME));
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	/**
	 * Lock the device
	 * 
	 * @throws Exception
	 */
	public static void lockTheDevice() throws Exception {
		try {
			((AndroidDriver<RemoteWebElement>) driver).lockDevice();
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	/**
	 * Check if device is locked
	 * 
	 * @return
	 * @throws Exception
	 */
	public static boolean isDeviceLocked() throws Exception {
		try {
			boolean isLocked = ((AndroidDriver<RemoteWebElement>) driver).isDeviceLocked();
			return isLocked;
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	/**
	 * Unlock the device
	 * 
	 * @throws Exception
	 */

	public static void unlockTheDevice() throws Exception {
		try {
			((AndroidDriver<RemoteWebElement>) driver).unlockDevice();
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	/**
	 * Enable Wifi
	 * 
	 * @throws Exception
	 */
	public static void enableWifi(String os) throws Exception {

		try {
			//ConfigurationManager prop = ConfigurationManager.getInstance();
			if (os.equalsIgnoreCase("Local")) {
				((AndroidDriver<RemoteWebElement>) driver)
						.setConnection(new ConnectionStateBuilder().withWiFiEnabled().build());
				System.out.println("Enable Wifi");
			} else {
				driver.executeScript("pCloudy_enableWifi", true);
			}
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	/**
	 * Open Notification bar
	 * 
	 * @throws Exception
	 */
	public static void OpenNotificationDrawer() throws Exception {
		try {
			((AndroidDriver<RemoteWebElement>) driver).openNotifications();
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}

	}

	/**
	 * @throws Exception
	 */
	public static void backButton() throws Exception {
		try {
			((AndroidDriver<RemoteWebElement>) driver).pressKey(new KeyEvent(AndroidKey.BACK));
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	/**
	 * disable Wifi
	 * 
	 * @throws Exception
	 */
	public static void disableWifi(String os) throws Exception {
		try {
			//ConfigurationManager prop = ConfigurationManager.getInstance();
			if (os.equalsIgnoreCase("Local")) {
				((AndroidDriver<RemoteWebElement>) driver)
						.setConnection(new ConnectionStateBuilder().withWiFiDisabled().build());
				System.out.println("Disable Wifi");
			} else {
				driver.executeScript("pCloudy_enableWifi", false);

			}
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	public static void resetApplication() throws Exception {
		try {
			driver.resetApp();
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	/**
	 * Launch the App again.
	 * 
	 * @throws Exception
	 */

	public static void launchApp() throws Exception {
		try {
			driver.launchApp();
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	/**
	 * Swiping from top panel to open quick settings.
	 * 
	 * @throws Exception
	 */
	public static void scrollQuickSettings() throws Exception {
		try {
			Dimension windowSize = driver.manage().window().getSize();
			int starty = (int) (windowSize.height * 0.10);
			int endy = (int) (windowSize.height * 0.90);
			int startx = windowSize.width / 2;
			new TouchAction<>(driver).press(PointOption.point(startx, endy))
					.waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
					.moveTo(PointOption.point(startx, starty)).release().perform();
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	/**
	 * Keep App in background
	 * 
	 * @throws Exception
	 */
	public static void runInBackgroundApp() throws Exception {
		try {
			driver.runAppInBackground(Duration.ofMillis(10));
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}

	/**
	 * Open Background app
	 * 
	 * @throws Exception
	 */
	public static void openbackGroundAPP() throws Exception {
		try {
			((StartsActivity) driver).currentActivity();
		} catch (Exception e) {
			throw new Exception(getExceptionMessage(e));
		}
	}
	
	public static String getExceptionMessage(Exception ex) {
		try {
			String exceptionMessage = ex.getLocalizedMessage();
			
			String message = Thread.currentThread().getStackTrace()[2].getClassName() + "::"
					+ Thread.currentThread().getStackTrace()[2].getMethodName() + "() Exception : " + exceptionMessage;

			return message;
		} catch (Exception e) {
			return ex.getLocalizedMessage();
		}
	}

}