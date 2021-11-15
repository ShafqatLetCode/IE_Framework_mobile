package com.crestech.common.utilities;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.crestech.base.UserBaseTest;
import com.crestech.config.ContextManager;

import io.appium.java_client.AppiumDriver;

public class Asserts extends UserBaseTest {

	public static void assertTrueScreenshot(boolean condition, String message) {
		try {
			if (prop.getProperty("ReportType").trim().equalsIgnoreCase("Allure")) {
				Assert.assertTrue(condition, message);
				addAttachment();
			} else if (prop.getProperty("ReportType").trim().equalsIgnoreCase("extent")) {
				logScreenshot(condition, message, "assertTrue");
				Assert.assertTrue(condition, message);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void assertTrue(boolean condition, String message) {
		try {
			if (prop.getProperty("ReportType").trim().equalsIgnoreCase("Allure")) {
				Assert.assertTrue(condition, message);
			} else if (prop.getProperty("ReportType").trim().equalsIgnoreCase("extent")) {
				log(condition, message, "assertTrue");
				Assert.assertTrue(condition, message);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void assertFalseScreenshot(boolean condition, String message) {
		try {
			if (prop.getProperty("ReportType").trim().equalsIgnoreCase("Allure")) {
				Assert.assertFalse(condition, message);
				addAttachment();
			} else if (prop.getProperty("ReportType").trim().equalsIgnoreCase("extent")) {
				logScreenshot(condition, message, "assertFalse");
				Assert.assertFalse(condition, message);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public  static void assertFalse(boolean condition, String message) {
		try {
			if (prop.getProperty("ReportType").trim().equalsIgnoreCase("Allure")) {
				Assert.assertFalse(condition, message);
			} else if (prop.getProperty("ReportType").trim().equalsIgnoreCase("extent")) {
				log(condition, message, "assertFalse");
				Assert.assertFalse(condition, message);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void assertEqualsScreenshot(String actual, String expected, String message) {
		try {
			if (prop.getProperty("ReportType").trim().equalsIgnoreCase("Allure")) {
				Assert.assertEquals(actual, expected, message);
				addAttachment();
			} else if (prop.getProperty("ReportType").trim().equalsIgnoreCase("extent")) {
				try {
					if (actual.equals(expected)) {
						ContextManager.getExtentReportForPrecondition()
								.log(Status.PASS, message + "\n" + "Snapshot below:",
										MediaEntityBuilder
												.createScreenCaptureFromPath(
														ScreenshotUtils.getScreenshot(ContextManager.getAndroidDriver()))
												.build());
					} else {
						ContextManager.getExtentReportForPrecondition()
								.log(Status.FAIL, message + "\n" + "Snapshot below:",
										MediaEntityBuilder
												.createScreenCaptureFromPath(
														ScreenshotUtils.getScreenshot(ContextManager.getAndroidDriver()))
												.build());
					}
					Assert.assertEquals(actual, expected, message);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void assertEquals(String actual, String expected, String message) {
		try {
			if (prop.getProperty("ReportType").trim().equalsIgnoreCase("Allure")) {
				Assert.assertEquals(actual, expected, message);
			} else if (prop.getProperty("ReportType").trim().equalsIgnoreCase("extent")) {
				if (actual.equals(expected)) {
					ContextManager.getExtentReportForPrecondition().log(Status.PASS, message);
				} else {
					ContextManager.getExtentReportForPrecondition().log(Status.FAIL, message);
				}
				Assert.assertEquals(actual, expected, message);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void log(boolean condition, String message, String assertCondition) {
		switch (assertCondition) {
		case "assertTrue": {
			if (condition)
				ContextManager.getExtentReportForPrecondition().log(Status.PASS, message);
			else
				ContextManager.getExtentReportForPrecondition().log(Status.FAIL, message);
			break;
		}
		case "assertFalse": {
			if (condition)
				ContextManager.getExtentReportForPrecondition().log(Status.FAIL, message);
			else
				ContextManager.getExtentReportForPrecondition().log(Status.PASS, message);
			break;
		}
		default:
			System.out.println("Incorrect option.");
		}
	}

	public  static void logScreenshot(boolean condition, String message, String assertCondition) {
		try {
			switch (assertCondition) {
			case "assertTrue": {
				if (condition)
					try {
						ContextManager.getExtentReportForPrecondition()
								.log(Status.PASS, message + "\n" + "Snapshot below:",
										MediaEntityBuilder
												.createScreenCaptureFromPath(
														ScreenshotUtils.getScreenshot(ContextManager.getAndroidDriver()))
												.build());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				else
					try {
						ContextManager.getExtentReportForPrecondition()
								.log(Status.FAIL, message + "\n" + "Snapshot below:",
										MediaEntityBuilder
												.createScreenCaptureFromPath(
														ScreenshotUtils.getScreenshot(ContextManager.getAndroidDriver()))
												.build());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				break;
			}
			case "assertFalse": {
				if (condition)
					try {
						ContextManager.getExtentReportForPrecondition()
								.log(Status.FAIL, message + "\n" + "Snapshot below:",
										MediaEntityBuilder
												.createScreenCaptureFromPath(
														ScreenshotUtils.getScreenshot(ContextManager.getAndroidDriver()))
												.build());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				else
					try {
						ContextManager.getExtentReportForPrecondition()
								.log(Status.PASS, message + "\n" + "Snapshot below:",
										MediaEntityBuilder
												.createScreenCaptureFromPath(
														ScreenshotUtils.getScreenshot(ContextManager.getAndroidDriver()))
												.build());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				break;
			}
			default:
				System.out.println("Incorrect option.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}