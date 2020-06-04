package com.crestech.base;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.ITestListener;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.log4testng.Logger;

import com.crestech.appium.utils.ConfigurationManager;
import com.crestech.common.utilities.ExcelUtils;
import com.crestech.report.factory.ExtentTestManager;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.qameta.allure.Description;

/**
 *
 * @author Shibu Prasad Panda
 *
 */

public class UserBaseTest extends TestListenerAdapter implements ITestListener {

	public AppiumDriver<RemoteWebElement> driver = null;
	public ConfigurationManager prop;
	protected boolean dontStopAppOnReset = false;
	public String device_udid;
	public ExtentTest report;
	private AppiumDriverLocalService service;
	private AppiumServiceBuilder builder;

	Logger logger = Logger.getLogger(UserBaseTest.class);

	public UserBaseTest() {
		try {
			prop = ConfigurationManager.getInstance();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @author Shibu Prasad Panda
	 * @param name- device name/udid
	 * @throws Exception
	 */
	@BeforeMethod(alwaysRun = true)
	@Parameters({ "device", "version", "os" })
	public void startApp(String device, String version, Method method, String os) throws Exception {

		report = ExtentTestManager.startTest(method.getName() + "-" + device,
				method.getAnnotation(Description.class).value());

		List<String> s1 = new ArrayList<String>();
		s1 = ExcelUtils.readExcel(System.getProperty("user.dir") + "//TestData//TestData.xlsx", os, "Capabilities");
		DesiredCapabilities androidCaps = androidNative(s1, device, version, os);
		System.out.println(androidCaps);
		Thread.sleep(2000);
		try {
			this.driver = startingServerInstance(androidCaps, os);
			//ContextManager.setAndroidDriver(this.driver);
		} catch (Exception e) {
			report.log(LogStatus.SKIP, device + " is not reachable");
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			throw e;
		}
	}

	@Parameters({ "device", "os" })
	@AfterMethod(alwaysRun = true)
	public void stopApp(String device, String os) {
		System.out.println("stopApp");
		if (driver != null) {
			this.driver.quit();
		}
		if (os.equalsIgnoreCase("Android"))
			service.stop();
	}

	@AfterSuite(alwaysRun = true)
	public void flushReport() {
		System.out.println("My Report Flushed Start.....");
		/*
		 * if (ExtentManager.getExtent() != null) { ExtentManager.getExtent().flush();
		 * System.out.println("Report Flushed....."); }
		 */

		System.out.println("My Report Flushed End.....");
	}

	/**
	 * This will return the Desired Capabilities instance
	 *
	 * @param device Id
	 * @return capabilities instance
	 * @throws IOException
	 */

	public synchronized DesiredCapabilities androidNative(List<String> s, String device_udid, String version, String os)
			throws IOException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		switch (os) {
		case "Android":
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device_udid);
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
			capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, s.get(3));
			capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, s.get(4));
			capabilities.setCapability(MobileCapabilityType.APP,
					System.getProperty("user.dir") + "\\App\\" + s.get(16));
			capabilities.setCapability(MobileCapabilityType.UDID, s.get(8));
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			if (checkDeviceVersion(version)) {
				capabilities.setCapability("automationName", s.get(6));
			} else {
				capabilities.setCapability("automationName", "UiAutomator1");
			}
			if (dontStopAppOnReset == true) {
				capabilities.setCapability(AndroidMobileCapabilityType.DONT_STOP_APP_ON_RESET, true);
			} else {
				capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
			}
			break;

		case "iOS":
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device_udid);
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
			capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/App/" + s.get(5));
			capabilities.setCapability(MobileCapabilityType.UDID, s.get(8));
			capabilities.setCapability("automationName", s.get(6));
			capabilities.setCapability("bundleId", s.get(9));
			if (dontStopAppOnReset == true) {
				capabilities.setCapability(AndroidMobileCapabilityType.DONT_STOP_APP_ON_RESET, true);
			} else {
				capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
			}
			capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 600);
			break;

		case "Android_Chrome":
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, s.get(18));
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, s.get(2));
			capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, s.get(3));
			capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, s.get(4));
			capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/App/" + s.get(16));
			capabilities.setCapability(MobileCapabilityType.UDID, s.get(8));
			if (checkDeviceVersion(version)) {
				capabilities.setCapability("automationName", s.get(6));
				capabilities.setCapability("uiautomator2ServerLaunchTimeout", 90000);
				capabilities.setCapability("noSign", true);
			} else {
				capabilities.setCapability("automationName", "UiAutomator1");
			}
			if (dontStopAppOnReset == true) {
				capabilities.setCapability(AndroidMobileCapabilityType.DONT_STOP_APP_ON_RESET, true);
			} else {
				capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
			}
			capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 600);
			break;

		case "pCloudyAndroid":

			System.out.println(device_udid + "," + version);
			capabilities.setCapability("pCloudy_Username", s.get(14));
			capabilities.setCapability("pCloudy_ApiKey", s.get(15));
			capabilities.setCapability("pCloudy_DurationInMinutes", s.get(17));
			capabilities.setCapability("newCommandTimeout", 600);
			capabilities.setCapability("launchTimeout", 90000);
			capabilities.setCapability("pCloudy_DeviceFullName", device_udid);
			capabilities.setCapability("platformVersion", version);
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("pCloudy_ApplicationName", s.get(16));
			capabilities.setCapability("appPackage", s.get(4));
			capabilities.setCapability("appActivity", s.get(3));
			capabilities.setCapability("pCloudy_WildNet", "false");

			if (checkDeviceVersion(version)) {
				capabilities.setCapability("automationName", "UiAutomator2");
				capabilities.setCapability("uiautomator2ServerLaunchTimeout", 90000);
				capabilities.setCapability("noSign", true);
			} else {
				capabilities.setCapability("automationName", "UiAutomator1");
			}

			break;

		case "pCloudyIOS":
			capabilities.setCapability("pCloudy_Username", s.get(14));
			capabilities.setCapability("pCloudy_ApiKey", s.get(15));
			capabilities.setCapability("pCloudy_ApplicationName", s.get(16));
			capabilities.setCapability("pCloudy_DurationInMinutes", s.get(17));
			capabilities.setCapability("pCloudy_DeviceFullName", device_udid);
			capabilities.setCapability("platformVersion", version);
			capabilities.setCapability("newCommandTimeout", 600);
			capabilities.setCapability("launchTimeout", 90000);
			capabilities.setCapability("bundleId", s.get(9));
			capabilities.setCapability("acceptAlerts", true);
			capabilities.setCapability("automationName", s.get(6));
			capabilities.setCapability("pCloudy_WildNet", "false");
			capabilities.setCapability("platformName", "ios");

			break;

		default:
			System.out.println("Please Select pCloudyAndroid OR pCloudyIOS in properties File");
			capabilities = null;
		}

		return capabilities;
	}

	

	/**
	 * This will Start the Server
	 *
	 * @param Capabilities
	 * @return Driver Instance
	 * @throws Exception
	 */
	public AppiumDriver<RemoteWebElement> startingServerInstance(DesiredCapabilities androidCaps, String os)
			throws Exception {

		if (os.equalsIgnoreCase("Android")) {
			// if simple appium installed
			// driver = new AndroidDriver<RemoteWebElement>(new
			// URL("http://127.0.0.1:4723/wd/hub"), androidCaps);

			// install nodejs in your system ->through nodejs install appium
			// Build the Appium service
			builder = new AppiumServiceBuilder();
			builder.withIPAddress(prop.getProperty("server_address"));
			builder.usingPort(Integer.parseInt(prop.getProperty("port")));
			builder.withCapabilities(androidCaps);
			builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);

			// Start the server with the builder 
			service =AppiumDriverLocalService.buildService(builder);
			try {
			service.start();
			}
			finally {
				service.stop();
			}
			driver = new AndroidDriver<RemoteWebElement>(androidCaps);
		} else if (os.equalsIgnoreCase("pCloudyAndroid")) {
			driver = new AndroidDriver<RemoteWebElement>(
					new URL(prop.getProperty("pCloudy_Endpoint") + "/appiumcloud/wd/hub"), androidCaps);
		} else {
			driver = new IOSDriver<RemoteWebElement>(
					new URL(prop.getProperty("pCloudy_Endpoint") + "/appiumcloud/wd/hub"), androidCaps);
		}
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		return driver;
	}

	/**
	 * This method is to check Memory is deducted or not
	 *
	 * @param availableMemoryBeforeDownload
	 * @param availableMemoryAfterDownload
	 * @return
	 */
	public boolean isMemoryDeducted(double availableMemoryBeforeDownload, double availableMemoryAfterDownload) {

		if (availableMemoryBeforeDownload > availableMemoryAfterDownload)
			return true;
		else
			return false;
	}

	/**
	 * This method is to check Memory is reverted or not
	 *
	 * @param availableMemoryBeforeCancel -Memory Space At start
	 * @param availableMemoryAfterCancel  -Memory Space After Cancellation
	 * @return-return the boolean value
	 */
	public boolean isMemoryReverted(double availableMemoryAfterCancel, double availableMemoryBeforeCancel) {

		if (availableMemoryAfterCancel > availableMemoryBeforeCancel)
			return true;
		else
			return false;
	}

	public boolean isEpisodeFitOnDeviceQueue(int startEpisode, int lastEpisode, Set<Integer> episodeList) {
		for (Integer episode : episodeList) {
			if (episode >= startEpisode && episode <= lastEpisode) {
				return true;
			} else {
				break;
			}
		}
		return false;
	}

	/**
	 * To check whether the device version is >=6
	 *
	 * @param deviceVersion
	 * @return true/false
	 */
	public boolean checkDeviceVersion(String deviceVersion) {
		try {
			String str = deviceVersion.replace(".", ",").split(",")[0];
			int version = Integer.parseInt(str);
			if (version >= 6) {
				return true;
			}
			return false;
		} catch (Exception e) {
			System.out.println("version not given. Required to set automationName:UiAutomator2");
		}

		return false;
	}

}