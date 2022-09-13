package com.ie.appium.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Shubham Kumar Gupta
 */
public class ConfigurationManager {
	private static ConfigurationManager instance;
	private Properties prop = new Properties();

	private ConfigurationManager(String configFile) throws IOException {
		FileInputStream inputStream = new FileInputStream(configFile);
		prop.load(inputStream);
	}

	public String getProperty(String key) throws Exception{
		try {
			return prop.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace(); 
			throw e;
		}
	}

	public String getProperty(String key, String defaultValue) throws Exception{
		try {
			return prop.getProperty(key, defaultValue);
		} catch (Exception e) {
			e.printStackTrace(); throw e;
		}
	}

	public static ConfigurationManager getInstance() {
		try {
			if (instance == null) {
				String configFile = "config.properties";
				instance = new ConfigurationManager(configFile);
			}
			return instance;
		} catch (IOException e) {
			System.out.println("ConfigurationManager::getInstance():: "+e);
			return null;
		}
	}

	public boolean containsKey(String key) throws Exception{
		try {
			return prop.containsKey(key);
		} catch (Exception e) {
			e.printStackTrace(); 
			throw e;
		}
	}
}
