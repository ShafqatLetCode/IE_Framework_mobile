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
			ExcelUtils.closeExcel(wb);
			// Creating a JSONObject object
			JSONArray array = new JSONArray();
			JSONObject jsonObj1 = new JSONObject();

			for (int i = 1; i < device.size(); i++) {
				array.add(getDeviceInfo(device.get(i), version.get(i), os.get(i), userName.get(i), password.get(i)));
			}
			jsonObj1.put("devices", array);
			System.out.println(jsonObj1);

			FileWriter file = new FileWriter(
					System.getProperty("user.dir") + "//src//test//resources//AndroidDevices.json");
			file.write(jsonObj1.toJSONString());
			file.close();
		} catch (IOException e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}

	@SuppressWarnings("unchecked")
	JSONObject getDeviceInfo(String device, String version, String os, String userName , String password) throws Exception {
		try {
			JSONObject deviceInfo;
			deviceInfo = new JSONObject();
			deviceInfo.put("name", device);
			deviceInfo.put("version", version);
			deviceInfo.put("os", os);
			deviceInfo.put("userName", userName);
			deviceInfo.put("password", password);
			return deviceInfo;
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	}
}