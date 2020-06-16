package com.crestech.android.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crestech.annotation.values.Author;
import com.crestech.base.UserBaseTest;
import com.crestech.listeners.RetryAnalyzer;
import com.crestech.listeners.TestListener;
import com.crestech.pages.ChromeHomePage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;

@Listeners(TestListener.class)
@Epic("pCloudy Chrome Test")
@Feature("My first report for chrome")
public class pCloudyAndroidChromeTest extends UserBaseTest {

	Logger logger = Logger.getLogger(pCloudyAndroidTest.class.getName());
	

	@Test(description = "Sample test for Android Chrome", retryAnalyzer = RetryAnalyzer.class)
	@Description(value = "TestCases For Pcloudy Sample Project on chrome")
	@Author(name = "Pooja Thakur")
	@Parameters({ "version" })

	public void SampleAndroidTest(String version) throws InterruptedException, IOException {
		/*****************************
		 * API DEMOS APPLICATION_ STARTS
		 *********************************************/

		ChromeHomePage chromeHomePage = new ChromeHomePage(driver);

		driver.get(prop.getProperty("Application"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		/*****************************
		 * API DEMOS APPLICATION_ STARTS
		 *********************************************/
		Thread.sleep(70000);
		logger.info("To Check Navigate to Home page Functionality-------> ");
		extentLogs.info("Navigate to Home page");
		chromeHomePage.sendDataInUsername("pooja.thakur@crestechglobal.com");
		chromeHomePage.sendDataInPAssword("123456789");
	}

}