package com.crestech.android.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crestech.annotation.values.Author;
import com.crestech.base.UserBaseTest;
import com.crestech.listeners.TestListener;
import com.crestech.pages.pCloudySampleIOSpage;
import com.crestech.report.factory.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

import io.qameta.allure.Description;

@Listeners(TestListener.class)
public class pCloudyIosTest extends UserBaseTest {

	Logger logger = Logger.getLogger(pCloudyAndroidTest.class.getName());

	@Test(description = "Sample test for iOS")
	@Description(value = "TestCases For Pcloudy Sample Project")
	@Author(name = "Shibu Prasad panda")
	@Parameters({ "version", "device" })
	public void sampleIosTest(String version, String device) {
		try {
			pCloudySampleIOSpage homePageios = new pCloudySampleIOSpage(driver);
			System.out.println(device + "," + Thread.currentThread().getId());
			logger.info("Test Case started");
			ExtentTestManager.getTest().log(LogStatus.INFO, "Enter Email id");
			homePageios.clickOnEmail("testmunk@");

			ExtentTestManager.getTest().log(LogStatus.INFO, "Enter password");
			homePageios.clickOnPassword("testmunk");

			ExtentTestManager.getTest().log(LogStatus.INFO, "Click on  Login Button");
			homePageios.clickonLogin();
		} catch (Exception e) {
			Assert.assertTrue(false,e.getMessage());
		}
	}

}
