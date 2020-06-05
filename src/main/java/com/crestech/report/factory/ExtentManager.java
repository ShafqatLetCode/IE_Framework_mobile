package com.crestech.report.factory;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.crestech.appium.utils.*;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

	private static ExtentReports extent;
	static Date date = new Date();
	static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
	private static String filePath = System.getProperty("user.dir") + "/ExtentReport/ExtentReports"
			+ dateFormat.format(date) + ".html";

//	private static ExtentHtmlReporter getHtmlReporter() {
//		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(filePath);
//
//		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/src/main/resources/extent.xml");
//		htmlReporter.config().setDocumentTitle("pCloudy Execution Report");
//		htmlReporter.config().setReportName("pCloudy Automation");
//		htmlReporter.config().setTheme(Theme.STANDARD);
//		return htmlReporter;
//	}

	public synchronized static ExtentReports getReporter() {
		if (extent == null) {
			// Set HTML reporting file location
			extent = new ExtentReports(filePath, true);
		}
		return extent;
	}
}
