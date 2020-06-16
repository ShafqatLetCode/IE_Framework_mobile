package com.crestech.android.tests;

import java.util.logging.Logger;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crestech.annotation.values.Author;
import com.crestech.base.UserBaseTest;
import com.crestech.common.utilities.Asserts;
import com.crestech.listeners.RetryAnalyzer;
import com.crestech.listeners.TestListener;
import com.crestech.pages.PcloudyHomePage;

import io.qameta.allure.Description;

@Listeners(TestListener.class)
public class pCloudyAndroidTest extends UserBaseTest {
	
	

	Logger logger = Logger.getLogger(pCloudyAndroidTest.class.getName());
	Asserts Assert= new Asserts();

//	@Test(description = "Sample test for Android")
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
		extentLogs.info("Navigate to main page");
		homePage.navigateToHomePageFromMI();

		/************** Get Text Functionality ****************************************/
		homePage.clickOnText();
		homePage.clickOnMarquee();
		String text = homePage.getTextFromMarqueeButton();
		logger.info("To Check Text Functionality-------> " + text);
		extentLogs.info("To Check Text Functionality....");
		homePage.navigateToHomePageFromMarquee();

		/*************
		 * SeekBar Functionality
		 *******************************************/

		homePage.clickOnAnimation();
		homePage.clickOnSeeking();
		homePage.performSeekBar();
		homePage.clickOnRunButton();
		logger.info("Done");
		extentLogs.info("About to end");
		//extentLogs.pass("Done");

		/*****************************
		 * API DEMOS APPLICATION_ ENDS
		 *********************************************/

	}
	
	
	@Test(description = "Sample test 2 for Android",retryAnalyzer = RetryAnalyzer.class)
	@Description(value = "TestCases For Pcloudy Sample Project")
	@Parameters({ "version" })
	public void SampleAndroidTest2(String version) throws InterruptedException {

		/*****************************
		 * API DEMOS APPLICATION_ STARTS
		 *********************************************/
		PcloudyHomePage homePage = new PcloudyHomePage(driver);
		/*************** Send Data Functionality **********************************/
		homePage.clickOnViews();
		Assert.assertTrue(true, "My Message");
		homePage.clickOnAutoComplete();
		homePage.clickOnMultipleItems();
		homePage.clickOnEditBox();
		homePage.sendDataInEditBox("Testing Send Keys");
//		extentLogs.info("Navigate to main page");
		homePage.navigateToHomePageFromMI();

		/************** Get Text Functionality ****************************************/
		homePage.clickOnText();
		homePage.clickOnMarquee();
		String text = homePage.getTextFromMarqueeButton();
		logger.info("To Check Text Functionality-------> " + text);
//		extentLogs.info("To Check Text Functionality....");
		homePage.navigateToHomePageFromMarquee();

		/*************
		 * SeekBar Functionality
		 *******************************************/

		homePage.clickOnAnimation();
		//homePage.clickOnSeeking();
		homePage.performSeekBar();
		homePage.clickOnRunButton();
		logger.info("Done");
//		extentLogs.info("About to end");
		//extentLogs.pass("Done");

		/*****************************
		 * API DEMOS APPLICATION_ ENDS
		 *********************************************/

	}
	
//	@Test(description = "Sample test 2 for Android",retryAnalyzer = RetryAnalyzer.class)
	@Description(value = "TestCases For Pcloudy Sample Project")
	@Parameters({ "version" })
	public void SampleAndroidTest1(String version) throws InterruptedException {

		Assert.assertTrueScreenshot("pCloud".equals("pCloud"), "assertTrueScreenshot tested");
		Assert.assertTrue("pCloud".equals("pCloud"), "assertTrue tested");
		Assert.assertFalseScreenshot(!"pCloud".equals("pCloud"), "assertFalseScreenshsot tested");
		Assert.assertFalse(!"pCloud".equals("pCloud"), "assertFalse tested");
		Assert.assertFalseScreenshot("pCloud".equals("pCloud"), "assertFalseScreenshsot tested- should fail");
	}

}
