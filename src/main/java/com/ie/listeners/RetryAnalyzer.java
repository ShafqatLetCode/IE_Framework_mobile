package com.ie.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int count = 0;
    private static int maxTry = 1; //Run the failed test 2 times

    @Override
	public boolean retry(ITestResult iTestResult) {
		if (!iTestResult.isSuccess() && count < maxTry) { // Check if test not succeed
			iTestResult.getTestContext().getSkippedTests().removeResult(iTestResult);
			count++; // Increase the maxTry count by 1
			// iTestResult.setStatus(ITestResult.FAILURE); //Mark test as failed and take
			// base64Screenshot
			return true; // Tells TestNG to re-run the test
		}
		return false;
	}

}
