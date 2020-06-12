package com.crestech.android.tests;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crestech.base.UserBaseTest;
import com.crestech.listeners.TestListener;
import com.crestech.pages.ChromeHomePage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;

@Listeners(TestListener.class)
@Epic("Chrome Test")
@Feature("My first report")
public class chromeTest extends UserBaseTest {
	Logger logger = Logger.getLogger(chromeTest.class.getName());

	@Test(description = "Sample test for Android")
	//@Test(retryAnalyzer = RetryAnalyzer.class)
	@Description(value = "TestCases For Pcloudy Sample Project")
	@Parameters({ "version" })
	public void SampleAndroidTest(String version) {
		driver.get(prop.getProperty("Application"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		/*****************************
		 * API DEMOS APPLICATION_ STARTS
		 *********************************************/
		logger.info("To Check Login Functionality-------> ");
		ChromeHomePage chromeHomePage = new ChromeHomePage(driver);
	//	ExtentTestManager.getTest().log(LogStatus.INFO, "Navigate to Home page");
		chromeHomePage.sendDataInUsername("pooja.thakur@crestechglobal.com");
		chromeHomePage.sendDataInPAssword("123456789");
	}
}