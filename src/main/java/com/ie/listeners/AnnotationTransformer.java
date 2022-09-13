package com.ie.listeners;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import org.testng.annotations.Parameters;

import com.ie.common.utilities.ExcelUtils;

public class AnnotationTransformer implements IAnnotationTransformer {

	private List<String> activatedDeviceList;
	private List<String> activatedTestCaseList;

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		 annotation.setRetryAnalyzer(RetryAnalyzer.class);
		
		try {
			activatedDeviceList = getDeviceNameList();
			activatedTestCaseList = getTestCasesList();//{a,b,(c)}
			for (int k = 0; k < activatedDeviceList.size(); k++) {
				String[] arrOfStr = activatedTestCaseList.get(k).split(",");
				List<String> myList = new ArrayList<String>(Arrays.asList(arrOfStr));
				if (myList.contains(testMethod.getName())) 
					annotation.setEnabled(true);
				else 
					annotation.setEnabled(false);		
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<String> getDeviceNameList() {
		XSSFWorkbook wb = null;
		try {
			wb = ExcelUtils.openExcel(
					System.getProperty("user.dir") + File.separator + "TestData" + File.separator + "TestData.xlsx");
			List<String> device = ExcelUtils.readExcel("Device", "DeviceList", wb);
			List<String> deviceList = new ArrayList<String>();
			for(int i = 1; i<device.size();i++)
				deviceList.add(device.get(i));
			wb.close();
			return deviceList;
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<String> getTestCasesList() {
		XSSFWorkbook wb = null;
		try {
			wb = ExcelUtils.openExcel(
					System.getProperty("user.dir") + File.separator + "TestData" + File.separator + "TestData.xlsx");
			List<String> testCase = ExcelUtils.readExcel("ReRunTestCase", "DeviceList", wb);
			List<String> testCaseList = new ArrayList<String>();
			for(int i = 1; i<testCase.size();i++)
				testCaseList.add(testCase.get(i));
			wb.close();
			return testCaseList;
		} catch (Exception e) {
			return null;
		}
	}
}