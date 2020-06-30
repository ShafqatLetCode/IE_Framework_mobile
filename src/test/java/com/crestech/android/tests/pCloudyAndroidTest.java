package com.crestech.android.tests;

import java.util.logging.Logger;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crestech.annotation.values.Author;
import com.crestech.base.UserBaseTest;
import com.crestech.common.utilities.Asserts;
import com.crestech.common.utilities.JiraUtils;
import com.crestech.listeners.RetryAnalyzer;
import com.crestech.listeners.TestListener;
import com.crestech.pages.PcloudyHomePage;

import io.qameta.allure.Description;

@Listeners(TestListener.class)
public class pCloudyAndroidTest extends UserBaseTest {

	Logger logger = Logger.getLogger(pCloudyAndroidTest.class.getName());
	Asserts Assert = new Asserts();

	@Test(description = "Sample test for Android")
	@Description(value = "TestCases For Pcloudy Sample Project")
	@Author(name = "Shibu prasad panda")
	@Parameters({ "version" })
	public void SampleAndroidTest(String version) throws InterruptedException {

		/*****************************
		 * API DEMOS APPLICATION_ STARTS
		 *********************************************/
		PcloudyHomePage homePage = new PcloudyHomePage(driver);
		Asserts asserts=new Asserts();
		/*************** Send Data Functionality **********************************/
		homePage.clickOnViews();
		homePage.clickOnAutoComplete();
		homePage.clickOnMultipleItems();
		homePage.clickOnEditBox();
		homePage.sendDataInEditBox("Testing Send Keys");
		asserts.assertTrueScreenshot(homePage.getDataFromEditBox().equals("Testing Send Keys"), "Expected Text: Testing Send Keys\nActual Text: "+homePage.getDataFromEditBox());
		if (prop.getProperty("ReportType").equals("extent"))
			extentLogs.info("Navigate to main page");
		homePage.navigateToHomePageFromMI();

		/************** Get Text Functionality ****************************************/
		homePage.clickOnText();
		homePage.clickOnMarquee();
		String text = homePage.getTextFromMarqueeButton();
		logger.info("To Check Text Functionality-------> " + text);
		asserts.assertFalseScreenshot(text.isEmpty(), "Text Extracted from Marquee: "+text);
		if (prop.getProperty("ReportType").equals("extent"))
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
		if (prop.getProperty("ReportType").equals("extent")) {
			extentLogs.info("About to end");
			extentLogs.pass("Done");
		}

		/*****************************
		 * API DEMOS APPLICATION_ ENDS
		 *********************************************/

	}

//	@Test(description = "Sample test 2 for Android",retryAnalyzer = RetryAnalyzer.class)
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
		// homePage.clickOnSeeking();
		homePage.performSeekBar();
		homePage.clickOnRunButton();
		logger.info("Done");
//		extentLogs.info("About to end");
		// extentLogs.pass("Done");

		/*****************************
		 * API DEMOS APPLICATION_ ENDS
		 *********************************************/

	}

//	@Test(description = "Raise JIRA ticket")
	@Description(value = "TestCases For Pcloudy Sample Project")
	@Parameters({ "version" })
	public void SampleAndroidTest1(String version) throws InterruptedException {
		JiraUtils jira = new JiraUtils("https://automation-robotics.atlassian.net/",
				"sneha.aggarwal@crestechglobal.com", "WXpH90Jy1h4C09wrEWs2ED4D", "CRS");
		jira.createJiraIssue("Bug", "Test Defect", "Test Defect", "Sneha Aggarwal");
	}
}
