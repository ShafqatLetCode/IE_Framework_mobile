package com.crestech.listeners;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import com.crestech.common.utilities.ScreenshotUtils;
import com.crestech.config.ContextManager;
import com.relevantcodes.extentreports.LogStatus;
import com.crestech.base.UserBaseTest;

public class InvokedMethodListeners extends UserBaseTest implements IInvokedMethodListener {

	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

		if (method.getTestMethod().getMethodName().contains("Precondition")) {
//			report = ContextManager.getExtentReportForClassMethods().createNode(method.getTestMethod().getMethodName(), "");
//			ContextManager.setExtentReportsForPrecondition(report);
		}
	}

	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		if (method.getTestMethod().getMethodName().contains("Precondition")) {
			if (testResult.getStatus() == ITestResult.SUCCESS) {
				System.out.println("PASS");
				ContextManager.getExtentReportForPrecondition().log(LogStatus.PASS,
						method.getTestMethod().getMethodName() + "Test Passed");
			}

			if (testResult.getStatus() == ITestResult.FAILURE) {
				System.out.println("FAIL");
				ContextManager.getExtentReportForPrecondition().log(LogStatus.FAIL,
						method.getTestMethod().getMethodName() + "Test Failed \n"
								+ testResult.getThrowable().getMessage());
				try {
//					ContextManager.getExtentReportForPrecondition().addScreenCaptureFromBase64String(ScreenshotUtils.base64conversion(ContextManager.getAndroidDriver()), method.getTestMethod().getMethodName());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (testResult.getStatus() == ITestResult.SKIP) {
				System.out.println("SKIP");
				ContextManager.getExtentReportForPrecondition().log(LogStatus.SKIP,
						method.getTestMethod().getMethodName() + "Test Skiped");
			}
		}
	}
}