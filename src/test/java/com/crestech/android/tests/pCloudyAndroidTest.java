package com.crestech.android.tests;

import java.util.logging.Logger;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crestech.annotation.values.Author;
import com.crestech.appium.utils.CommonAppiumTest;
import com.crestech.base.UserBaseTest;
import com.crestech.listeners.TestListener;
import com.crestech.pages.PcloudyHomePage;
import com.crestech.report.factory.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;

@Listeners(TestListener.class)
@Epic("pCloudy Test")
@Feature("My first report")
public class pCloudyAndroidTest extends UserBaseTest {

	Logger logger = Logger.getLogger(pCloudyAndroidTest.class.getName());

	@Test(description = "Sample test for Android")
	@Description(value = "TestCases For Pcloudy Sample Project")
	@Author(name = "Shibu prasad panda")
	@Parameters({ "version" })
	public void SampleAndroidTest(String version) throws InterruptedException {

		/*****************************
		 * API DEMOS APPLICATION_ STARTS
		 *********************************************/
		PcloudyHomePage homePage = new PcloudyHomePage(driver);
		/*************** Send Data Functionality **********************************/
		homePage.clickOnViews();
		homePage.clickOnAutoComplete();
		homePage.clickOnMultipleItems();
		homePage.clickOnEditBox();
		homePage.sendDataInEditBox("Testing Send Keys");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Navigate to main page");
		homePage.navigateToHomePageFromMI();

		/************** Get Text Functionality ****************************************/
		homePage.clickOnText();
		homePage.clickOnMarquee();
		String text = homePage.getTextFromMarqueeButton();
		logger.info("To Check Text Functionality-------> " + text);
		ExtentTestManager.getTest().log(LogStatus.INFO, "To Check Text Functionality...." + text);
		homePage.navigateToHomePageFromMarquee();

		/*************
		 * SeekBar Functionality
		 *******************************************/

		homePage.clickOnAnimation();
		homePage.clickOnSeeking();
		homePage.performSeekBar();
		homePage.clickOnRunButton();
		logger.info("Done");
		ExtentTestManager.getTest().log(LogStatus.PASS, "Done");

		/*****************************
		 * API DEMOS APPLICATION_ ENDS
		 *********************************************/

	}

// @Test(description="Test Allure")
	@Description("Test Description: Login test with wrong username and wrong password.")
	public void readExcel() {
		logger.info("Test Started");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Test Started");
		CommonAppiumTest commonAppiumTest = new CommonAppiumTest(driver);
		commonAppiumTest.launchApp();
// List<String>s1= ExcelUtils.readExcel(System.getProperty("user.dir")+"//TestData//TestData.xlsx", "pCloudyAndroid","Capabilities");
// System.out.println(s1);
// ExtentTestManager.getTest().log(LogStatus.INFO, "Read excel", "Info: "+s1.get(1));
		logger.info("Test Completed");
		logger.info("Test Failed, Report Generate");
		ExtentTestManager.getTest().log(LogStatus.PASS, "Test completed");
		ExtentTestManager.getTest().log(LogStatus.FAIL, "Test failed, report generate");
	}

}
