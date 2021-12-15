package com.crestech.common.utilities;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.crestech.appium.utils.CommonAppiumTest;

public class CreateJSON {

	public void createDeviceJson() throws Exception {
		try {
			XSSFWorkbook wb = null;
			// Create device
			wb = ExcelUtils.openExcel(System.getProperty("user.dir") + "\\TestData\\TestData.xlsx");
			List<String> device = ExcelUtils.readExcel("Device", "DeviceList", wb);
			List<String> version = ExcelUtils.readExcel("Version", "DeviceList", wb);
			List<String> os = ExcelUtils.readExcel("OperatingSystem", "DeviceList", wb);
			List<String> userName = ExcelUtils.readExcel("UserName", "DeviceList", wb);
			List<String> password = ExcelUtils.readExcel("Password", "DeviceList", wb);
			List<String> manafacturer = ExcelUtils.readExcel("Manafacturer", "DeviceList", wb);
			List<String> min_Ver = ExcelUtils.readExcel("Min_Ver", "DeviceList", wb);
			List<String> max_Ver = ExcelUtils.readExcel("Max_Ver", "DeviceList", wb);
			List<String> individual_ID = ExcelUtils.readExcel("Individual_ID", "DeviceList", wb);
			List<String> app_Name = ExcelUtils.readExcel("AppName", "DeviceList", wb);
			ExcelUtils.closeExcel(wb);
			// Creating a JSONObject object
			JSONArray array = new JSONArray();
			JSONObject jsonObj1 = new JSONObject();

			for (int i = 1; i < device.size(); i++) {
				array.add(getDeviceInfo(device.get(i), version.get(i), os.get(i), userName.get(i), password.get(i), manafacturer.get(i), min_Ver.get(i), max_Ver.get(i), individual_ID.get(i), app_Name.get(i)));
			}
			jsonObj1.put("devices", array);
			System.out.println(jsonObj1);

			FileWriter file = new FileWriter(
					System.getProperty("user.dir") + "//src//test//resources//AndroidDevices.json");
			file.write(jsonObj1.toJSONString());
			file.close();
		} catch (IOException e) {
			e.printStackTrace(); 
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	JSONObject getDeviceInfo(String device, String version, String os, String userName , String password, String manafacturer, String min_Ver, String max_Ver, String individual_ID, String app_Name) throws Exception {
		try {
			JSONObject deviceInfo;
			deviceInfo = new JSONObject();
			deviceInfo.put("name", device);
			deviceInfo.put("version", version);
			deviceInfo.put("os", os);
			deviceInfo.put("userName", userName);
			deviceInfo.put("password", password);
			deviceInfo.put("manafacturer", manafacturer);
			deviceInfo.put("min_Ver", min_Ver);
			deviceInfo.put("max_Ver", max_Ver);
			deviceInfo.put("individual_ID", individual_ID);
			deviceInfo.put("app_Name", app_Name);
			return deviceInfo;
		} catch (Exception e) {
			e.printStackTrace(); 
			throw e;
		}
	}
}