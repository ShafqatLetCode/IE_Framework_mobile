package com.crestech.android.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.crestech.annotation.values.Author;
import com.crestech.appium.utils.CommonAppiumTest;
import com.crestech.base.UserBaseTest;
import com.crestech.listeners.TestListener;
import com.crestech.pageobjects.DBS_IOSObject;
import com.crestech.pages.DBS_IOSpage;

import io.qameta.allure.Description;

@Listeners(TestListener.class)
public class DBS_IOSTest extends UserBaseTest {
	
	Logger logger = Logger.getLogger(DBSAndroidTest.class.getName());

	@Test(description = "Sample test for iOS")
	@Description(value = "TestCases For Pcloudy Sample Project")
	@Author(name = "Shibu Prasad panda")
	@Parameters({"userName", "password" })
	public void sampleIosTest(String userName,String password) {
		try {
			DBS_IOSObject IOShomePgaeObject = new DBS_IOSObject(driver);
			//pCloudySampleIOSpage homePageios = new pCloudySampleIOSpage(driver);
		
		  logger.info("Test Case started");
//		  IOShomePgaeObject.setEmailID(userName);
//		  IOShomePgaeObject.setPassword(password);
//		  IOShomePgaeObject.clickOnLogin();

		} catch (Exception e) {
			Assert.assertTrue(false,e.getMessage());
		}
	}

}
