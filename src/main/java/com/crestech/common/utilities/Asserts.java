package com.crestech.common.utilities;

import java.io.IOException;

import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.crestech.base.UserBaseTest;
import com.crestech.config.ContextManager;

public class Asserts extends UserBaseTest {

	public void assertTrueScreenshot(boolean condition, String message) {
		if (prop.getProperty("ReportType").trim().equalsIgnoreCase("Allure")) {
			Assert.assertTrue(condition, message);
			addAttachment();
		} else if (prop.getProperty("ReportType").trim().equalsIgnoreCase("extent")) {
			logScreenshot(condition, message, "assertTrue");
			Assert.assertTrue(condition, message);
		}
	}

	public void assertTrue(boolean condition, String message) {
		if (prop.getProperty("ReportType").trim().equalsIgnoreCase("Allure")) {
			Assert.assertTrue(condition, message);
		} else if (prop.getProperty("ReportType").trim().equalsIgnoreCase("extent")) {
			log(condition, message, "assertTrue");
			Assert.assertTrue(condition, message);
		}
	}

	public void assertFalseScreenshot(boolean condition, String message) {
		if (prop.getProperty("ReportType").trim().equalsIgnoreCase("Allure")) {
			Assert.assertFalse(condition, message);
			addAttachment();
		} else if (prop.getProperty("ReportType").trim().equalsIgnoreCase("extent")) {
			logScreenshot(condition, message, "assertFalse");
			Assert.assertFalse(condition, message);
		}
	}

	public void assertFalse(boolean condition, String message) {
		if (prop.getProperty("ReportType").trim().equalsIgnoreCase("Allure")) {
			Assert.assertFalse(condition, message);
		} else if (prop.getProperty("ReportType").trim().equalsIgnoreCase("extent")) {
			log(condition, message, "assertFalse");
			Assert.assertFalse(condition, message);
		}
	}

	public void assertEqualsScreenshot(String actual, String expected, String message) {
		extentLogs=ContextManager.getExtentReportForPrecondition();
		if (prop.getProperty("ReportType").trim().equalsIgnoreCase("Allure")) {
			Assert.assertEquals(actual, expected, message);
			addAttachment();
		} else if (prop.getProperty("ReportType").trim().equalsIgnoreCase("extent")) {
			try {
				if (actual.equals(expected)) {
					extentLogs.log(Status.PASS, message + "\n" + "Snapshot below:", MediaEntityBuilder
							.createScreenCaptureFromPath(ScreenshotUtils.getScreenshot(ContextManager.getAndroidDriver())).build());
				} else {
					extentLogs.log(Status.FAIL, message + "\n" + "Snapshot below:", MediaEntityBuilder
							.createScreenCaptureFromPath(ScreenshotUtils.getScreenshot(ContextManager.getAndroidDriver())).build());
				}
				Assert.assertEquals(actual, expected, message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void assertEquals(String actual, String expected, String message) {
		extentLogs=ContextManager.getExtentReportForPrecondition();
		if (prop.getProperty("ReportType").trim().equalsIgnoreCase("Allure")) {
			Assert.assertEquals(actual, expected, message);
		} else if (prop.getProperty("ReportType").trim().equalsIgnoreCase("extent")) {
			if (actual.equals(expected)) {
				extentLogs.log(Status.PASS, message);
			} else {
				extentLogs.log(Status.FAIL, message);
			}
			Assert.assertEquals(actual, expected, message);
		}
	}

	public void log(boolean condition, String message, String assertCondition) {
		extentLogs=ContextManager.getExtentReportForPrecondition();
		switch (assertCondition) {
		case "assertTrue": {
			if (condition)
				extentLogs.log(Status.PASS, message);
			else
				extentLogs.log(Status.FAIL, message);
			break;
		}
		case "assertFalse": {
			if (condition)
				extentLogs.log(Status.FAIL, message);
			else
				extentLogs.log(Status.PASS, message);
			break;
		}
		default:
			System.out.println("Incorrect option.");
		}
	}

	public void logScreenshot(boolean condition, String message, String assertCondition) {
		extentLogs=ContextManager.getExtentReportForPrecondition();
		try {
			switch (assertCondition) {
			case "assertTrue": {
				if (condition)

					extentLogs.log(Status.PASS, message + "\n" + "Snapshot below:", MediaEntityBuilder
							.createScreenCaptureFromPath(ScreenshotUtils.getScreenshot(ContextManager.getAndroidDriver())).build());
				else
					extentLogs.log(Status.FAIL, message + "\n" + "Snapshot below:", MediaEntityBuilder
							.createScreenCaptureFromPath(ScreenshotUtils.getScreenshot(ContextManager.getAndroidDriver())).build());
				break;
			}
			case "assertFalse": {
				if (condition)
					extentLogs.log(Status.FAIL, message + "\n" + "Snapshot below:", MediaEntityBuilder
							.createScreenCaptureFromPath(ScreenshotUtils.getScreenshot(ContextManager.getAndroidDriver())).build());
				else
					extentLogs.log(Status.PASS, message + "\n" + "Snapshot below:", MediaEntityBuilder
							.createScreenCaptureFromPath(ScreenshotUtils.getScreenshot(ContextManager.getAndroidDriver())).build());
				break;
			}
			default:
				System.out.println("Incorrect option.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
