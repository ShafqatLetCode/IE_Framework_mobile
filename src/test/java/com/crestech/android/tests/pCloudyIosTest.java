package com.crestech.android.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crestech.annotation.values.Author;
import com.crestech.base.UserBaseTest;
import com.crestech.listeners.TestListener;
import com.crestech.pages.pCloudySampleIOSpage;

import io.qameta.allure.Description;

@Listeners(TestListener.class)
public class pCloudyIosTest extends UserBaseTest {

	Logger logger = Logger.getLogger(pCloudyAndroidTest.class.getName());

	@Test(description = "Sample test for iOS")
	@Description(value = "TestCases For Pcloudy Sample Project")
	@Author(name = "Shibu Prasad panda")
	@Parameters({ "version" })
	public void sampleIosTest(String version) throws InterruptedException {
			pCloudySampleIOSpage homePageios = new pCloudySampleIOSpage(driver);
		
		  logger.info("Test Case started");
		  homePageios.clickOnEmail("testmunk@");
		  
		  homePageios.clickOnPassword("testmunk");
		  
		  homePageios.clickonLogin();
		 
	}

}
