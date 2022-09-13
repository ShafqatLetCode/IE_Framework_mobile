package com.ie.listeners;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.IAlterSuiteListener;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.ie.appium.utils.CommonAppiumTest;
import com.ie.appium.utils.ConfigurationManager;
import com.ie.common.utilities.CreateJSON;

public class AlterSuite implements IAlterSuiteListener {

	public ConfigurationManager prop;

	public AlterSuite() {
		try {
			prop = ConfigurationManager.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void alter(List<XmlSuite> suites) {
		List<XmlTest> dynamictests = null;
		try {
			CreateJSON json = new CreateJSON();
			json.createDeviceJson();
			AlterSuite alterSuite = new AlterSuite();
			String jsonString = alterSuite.readText();
			alterSuite.validatejSonString(jsonString);
			List<Map<String, String>> deviceList = alterSuite.getDevices(jsonString);
			XmlSuite suite = suites.get(0);
			suite.setThreadCount(deviceList.size());
			suite.setPreserveOrder(true);
			dynamictests = suite.getTests().stream().filter(xmlTest -> xmlTest.getName().startsWith("Test"))
					.collect(Collectors.toList());
			dynamictests.get(0).setName(deviceList.get(0).get("name"));
			dynamictests.get(0).getLocalParameters().put("device", deviceList.get(0).get("name"));
			dynamictests.get(0).getLocalParameters().put("version", deviceList.get(0).get("version"));
			dynamictests.get(0).getLocalParameters().put("os", deviceList.get(0).get("os"));
			dynamictests.get(0).getLocalParameters().put("userName", deviceList.get(0).get("userName"));
			dynamictests.get(0).getLocalParameters().put("password", deviceList.get(0).get("password"));
			dynamictests.get(0).getLocalParameters().put("manafacturer", deviceList.get(0).get("manafacturer"));
			dynamictests.get(0).getLocalParameters().put("min_Ver", deviceList.get(0).get("min_Ver"));
			dynamictests.get(0).getLocalParameters().put("max_Ver", deviceList.get(0).get("max_Ver"));
			dynamictests.get(0).getLocalParameters().put("individual_ID", deviceList.get(0).get("individual_ID"));
			dynamictests.get(0).getLocalParameters().put("app_Name", deviceList.get(0).get("app_Name"));
			List<XmlTest> clonedTests = new ArrayList<>();
			for (XmlTest each : dynamictests) {
				for (int i = 1; i < deviceList.size(); i++) {
					XmlTest cloned = new XmlTest(suite);
					cloned.setName(deviceList.get(i).get("name"));
					cloned.getLocalParameters().put("device", deviceList.get(i).get("name"));
					cloned.getLocalParameters().put("version", deviceList.get(i).get("version"));
					cloned.getLocalParameters().put("os", deviceList.get(i).get("os"));
					cloned.getLocalParameters().put("userName", deviceList.get(i).get("userName"));
					cloned.getLocalParameters().put("password", deviceList.get(i).get("password"));
			
					cloned.getLocalParameters().put("manafacturer", deviceList.get(i).get("manafacturer"));
					cloned.getLocalParameters().put("min_Ver", deviceList.get(i).get("min_Ver"));
					cloned.getLocalParameters().put("max_Ver", deviceList.get(i).get("max_Ver"));
					cloned.getLocalParameters().put("individual_ID", deviceList.get(i).get("individual_ID"));
					cloned.getLocalParameters().put("app_Name", deviceList.get(i).get("app_Name"));
					
					cloned.getXmlClasses().addAll(each.getClasses());
					clonedTests.add(cloned);
				}
			}
			dynamictests.addAll(clonedTests);
			Thread.sleep(3000);
			System.out.println(dynamictests);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("resource")
	public String readText() throws Exception {
// pass the path to the file as a parameter
		String value = "";
		try {
		File file = new File(
				System.getProperty("user.dir") + "/src/test/resources/" + prop.getProperty("DEVICES_JSON_FILE_NAME"));
		Scanner sc;
		
			sc = new Scanner(file);
			while (sc.hasNextLine())
				value += sc.nextLine();
			return value;
		} catch (FileNotFoundException e) {
			e.printStackTrace(); throw e;
		}
	}

	public void validatejSonString(String jsonString) throws Exception {
		try {
			if (jsonString.trim().isEmpty()) {
				System.out.println("Empty JsonString");
				throw new RuntimeException("Emty Device Json File");
			}
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}

	}

	public List<Map<String, String>> getDevices(String jsonString) throws Exception {
		try {
			List<Map<String, String>> deviceList = new ArrayList<Map<String, String>>();
			JSONArray jsonArray = new JSONObject(jsonString).getJSONArray("devices");
			for (int i = 0; i < jsonArray.length(); i++) {
				Map<String, String> device = new HashMap<String, String>();
				JSONObject jsonObject = jsonArray.getJSONObject(i);

				device.put("name", jsonObject.getString("name"));
				device.put("version", jsonObject.getString("version"));
				device.put("os", jsonObject.getString("os"));
				device.put("userName", jsonObject.getString("userName"));
				device.put("password", jsonObject.getString("password"));
				
				device.put("manafacturer", jsonObject.getString("manafacturer"));
				device.put("min_Ver", jsonObject.getString("min_Ver"));
				device.put("max_Ver", jsonObject.getString("max_Ver"));
				device.put("individual_ID", jsonObject.getString("individual_ID"));
				device.put("app_Name", jsonObject.getString("app_Name"));
				deviceList.add(device);
			}
			return deviceList;
		} catch (JSONException e) {
			e.printStackTrace(); throw e;
		}
	}

}
