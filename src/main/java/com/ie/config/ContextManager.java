package com.crestech.config;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.openqa.selenium.remote.RemoteWebElement;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.appium.java_client.AppiumDriver;

/**
 * Created by pCloudy.com.
 *
 * @author: Shibu Prasad Panda Date: 11.05.2019 Purpose: To set the
 *          configuration for type of drivers
 */


public class ContextManager {
	
	private static ExtentHtmlReporter htmlReporter;
	private static ExtentReports extent;
	private static ExtentTest extendLogger;
	
	private static Map<Long, ExtentTest> reportLogger = new ConcurrentHashMap<Long, ExtentTest>();
	private static Map<Long, AppiumDriver<RemoteWebElement>> driverMapper = new ConcurrentHashMap<Long, AppiumDriver<RemoteWebElement>>();
	

	public synchronized static void startReport() {
		if (extent == null) {
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
			//Set HTML reporting file location
			htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/ExtentReport/ExtentReport_" + dateFormat.format(date) + ".html");
			// Create an object of Extent Reports
			extent = new ExtentReports();  
			extent.attachReporter(htmlReporter);
			extent.setSystemInfo("Host Name", "Crestech");
			extent.setSystemInfo("Environment", "Production");
			extent.setSystemInfo("User Name", "Automation Tester");
			htmlReporter.config().setDocumentTitle("AutomationTesting On Crestechglobal"); 
			htmlReporter.config().setTheme(Theme.DARK);   
			htmlReporter.config().setReportName("Automation Report");
			htmlReporter.config().setCSS(".r-img { width: 40%;}");
		}
	}

	public  static void createNode(String nodeName) {
		extendLogger = extent.createTest(nodeName);  
		reportLogger.put(Thread.currentThread().getId(), extendLogger);
	}

	public synchronized static ExtentTest getExtentReportForPrecondition() {
		return  reportLogger.get(Thread.currentThread().getId());
	}

	public synchronized static void endReport() {
		extent.flush();
	}

	public static void setDriver(AppiumDriver<RemoteWebElement> driver) {
		driverMapper.put(Thread.currentThread().getId(), driver);
	}

	public static AppiumDriver<RemoteWebElement> getDriver() {
		return  driverMapper.get(Thread.currentThread().getId());
	}
	
	
	

	/*private static ThreadLocal<ExtentTest> extentReportForTestMethod = new ThreadLocal<>();

	public static ExtentTest getExtentReportForTestMethods() {
		return extentReportForTestMethod.get();
	}

	public static void setExtentReportsForTestMethods(ExtentTest extent) {
		extentReportForTestMethod.set(extent);
	}

	private static ThreadLocal<ExtentTest> extentReportForClassMethod = new ThreadLocal<>();

	public static ExtentTest getExtentReportForClassMethods() {
		return extentReportForClassMethod.get();
	}

	public static void setExtentReportsForClassMethods(ExtentTest extent) {
		extentReportForClassMethod.set(extent);
	}

	private static ThreadLocal<ExtentTest> extentReportForPrecondition = new ThreadLocal<>();

	public static ExtentTest getExtentReportForPrecondition() {
		return extentReportForPrecondition.get();
	}

	public static void setExtentReportsForPrecondition(ExtentTest extent) {
		extentReportForPrecondition.set(extent);
	}

	private static ThreadLocal<AppiumDriver<RemoteWebElement>> androidDriver = new ThreadLocal<>();

	public static void setAndroidDriver(AppiumDriver<RemoteWebElement> driver) {
		androidDriver.set(driver);
	}

	public static AppiumDriver<RemoteWebElement> getAndroidDriver() {
		return androidDriver.get();
	}*/
	
}
