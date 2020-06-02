package com.crestech.common.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Listeners;

import com.crestech.listeners.TestListener;

import io.qameta.allure.Step;

@Listeners({ TestListener.class })
public class ExcelUtils {

	/**
	 * @author Sneha Aggarwal
	 * @param name- file path, key and sheet name
	 * @exception file not found handles, IO Exception
	 * @implSpec Read excel at a specified path, sheet and a key value
	 * @return List of String
	 */

	@Step("Read Excel")
	public static List<String> readExcel(String path, String key, String sheetName) {
		// initialize variables
		XSSFRow row = null;
		XSSFCell cell = null;
		XSSFWorkbook wb = null;
		XSSFSheet sheet = null;
		List<String> val = new ArrayList<String>();
		// Open excel
		try {
			wb = new XSSFWorkbook(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Open sheet of the excel and add all column values of the specified row in a
		// list
		sheet = wb.getSheet(sheetName);
		for (int i = 0; i < sheet.getLastRowNum() + 1; i++) {
			row = sheet.getRow(i);
			cell = row.getCell(0);
			if (cell.getStringCellValue().equals(key)) {
				for (Iterator<Cell> cit = row.iterator(); cit.hasNext();) {
					Cell cell_value = cit.next();
					val.add(cell_value.getStringCellValue());
				}
				break;
			}
		}
		try {
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return val;
	}
	
	/**
	 * @author Sneha Aggarwal
	 * @param name- file path
	 * @exception file not found handles, IO Exception
	 * @implSpec Opens specified excel
	 * @return workbook
	 */
	@Step("Read Excel")
	public static XSSFWorkbook openExcel(String path) {
		// initialize variables
		XSSFWorkbook wb = null;
		// Open excel
		try {
			wb = new XSSFWorkbook(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return wb;
	}

	
	/**
	 * @author Sneha Aggarwal
	 * @param name- file path
	 * @exception file not found handles, IO Exception
	 * @implSpec Opens specified excel
	 * @return workbook
	 */
	@Step("Read Excel")
	public static void closeExcel(XSSFWorkbook wb) {
		try {
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @author Sneha Aggarwal
	 * @param name- file path, key and sheet name
	 * @exception file not found handles, IO Exception
	 * @implSpec Read already opened excel using sheet and a key value
	 * @return List of String
	 */
	@Step("Read Excel")
	public static List<String> readExcel(String key, String sheetName,XSSFWorkbook wb) {
		// initialize variables
		XSSFRow row = null;
		XSSFCell cell = null;
		XSSFSheet sheet = null;
		List<String> val = new ArrayList<String>();
		// Open sheet of the excel and add all column values of the specified row in a
		// list
		sheet = wb.getSheet(sheetName);
		for (int i = 0; i < sheet.getLastRowNum() + 1; i++) {
			row = sheet.getRow(i);
			cell = row.getCell(0);
			if (cell.getStringCellValue().equals(key)) {
				for (Iterator<Cell> cit = row.iterator(); cit.hasNext();) {
					Cell cell_value = cit.next();
					val.add(cell_value.getStringCellValue());
				}
				break;
			}
		}
		return val;
	}

	/**
	 * @author Sneha Aggarwal
	 * @param name- file path, key
	 * @exception file not found handles, IO Exception
	 * @implSpec Read excel at a specified path for the first sheet in the excel and
	 *           a key value
	 * @return List of String
	 */

	public static List<String> readExcel(String path, String key) {
		// initialize
		XSSFRow row = null;
		XSSFCell cell = null;
		XSSFWorkbook wb = null;
		XSSFSheet sheet = null;
		List<String> val = new ArrayList<String>();
		// Open workbook
		try {
			wb = new XSSFWorkbook(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Open sheet of the excel and add all column values of the specified row in a
		// list
		sheet = wb.getSheetAt(0);
		for (int i = 0; i < sheet.getLastRowNum() + 1; i++) {
			row = sheet.getRow(i);
			cell = row.getCell(0);
			if (cell.getStringCellValue().equals(key)) {
				for (Iterator<Cell> cit = row.iterator(); cit.hasNext();) {
					Cell cell_value = cit.next();
					val.add(cell_value.getStringCellValue());
				}
				break;
			}
		}
		try {
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return val;
	}

	/**
	 * @author Sneha Aggarwal
	 * @param name- file path, key and sheet name
	 * @exception file not found handles, IO Exception
	 * @implSpec Read excel with row and cell value
	 * @return String
	 */

	public static String readExcel(String path, String key, String sheetName, int rowNum, int colNum) {
		XSSFRow row = null;
		XSSFCell cell = null;
		XSSFWorkbook wb = null;
		XSSFSheet sheet = null;
		String val = null;
		try {
			wb = new XSSFWorkbook(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Open sheet of the excel and get value of the specified cell
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);
		val = cell.getStringCellValue();
		try {
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return val;
	}

	/**
	 * @author Sneha Aggarwal
	 * @param name- file path, data to be written and sheet name
	 * @exception file not found handles, IO Exception
	 * @implSpec Create a new excel and write to the first sheet and first row
	 * @return List of String
	 */

	public static void writeToNewExcel(String sheetName, List<String> data, String path) {
		// Create a Workbook
		XSSFWorkbook workbook = new XSSFWorkbook();
		// Create a Sheet
		XSSFSheet sheet = workbook.createSheet(sheetName);
		// Create a row
		XSSFRow row = sheet.createRow(0);
		// Create cell
		for (int i = 0; i < data.size(); i++) {
			Cell cell = row.createCell(i);
			cell.setCellValue(data.get(i));
		}
		// Save file and close
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
			fileOut.close();
			workbook.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @author Sneha Aggarwal
	 * @param name- file path, data to be appended and sheet name
	 * @exception file not found handles, IO Exception
	 * @implSpec Create a new excel and write to the first sheet and first row
	 * @return List of String
	 */

	public static void writeToExcel(String sheetName, List<String> data, String path) {
		// Obtain a workbook from the excel file
		File file = new File(path);
		FileInputStream inputStream = null;
		// Create an object of FileInputStream class to read excel file
		try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}
		XSSFWorkbook wb = null;
		try {
			wb = new XSSFWorkbook(inputStream);
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		// Create a Sheet
		XSSFSheet sheet = null;
		boolean temp = false;
		XSSFRow row = null;
		for (int i = 0; i < wb.getNumberOfSheets(); i++) {
			System.out.println(wb.getSheetAt(i).getSheetName());
			if (wb.getSheetAt(i).getSheetName().equalsIgnoreCase(sheetName)) {
				sheet = wb.getSheet(sheetName);
				// Read the excel
				int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
				if (rowCount == 0) {
					row = sheet.createRow(0);
					for (int k = 0; k < data.size(); k++) {
						Cell cell = row.createCell(k);
						cell.setCellValue(data.get(k));
						System.out.println(data.get(k));
					}
				} else {
					for (int j = 0; j < rowCount; j++) {
						row = sheet.createRow(rowCount + 1);
						for (int k = 0; k < data.size(); k++) {
							Cell cell = row.createCell(k);
							cell.setCellValue(data.get(k));
						}
					}
				}
				temp = true;
				break;
			}
		}
		System.out.println(temp);
		if (!temp) {
			sheet = wb.createSheet(sheetName);
			row = sheet.createRow(0);
			// Create cell
			for (int i = 0; i < data.size(); i++) {
				Cell cell = row.createCell(i);
				cell.setCellValue(data.get(i));
			}
		}
		// Save file and close
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream(path);
			wb.write(fileOut);
			fileOut.close();
			wb.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * @author Sneha Aggarwal
	 * @param name- file path and sheet name
	 * @exception file not found handles, IO Exception
	 * @return data in excel sheet in the hashmap
	 */
	public static HashMap<String, String> getMapData(String path, String sheetName) {
		FileInputStream fis;
		XSSFWorkbook wb=null;
		HashMap<String, String> dataMap = new HashMap<String, String>();
		try {
			fis = new FileInputStream(path);
			wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet(sheetName);
			int lastRow = sheet.getLastRowNum();
			
			// Looping over entire row
			for (int i = 0; i <= lastRow; i++) {
				XSSFRow row = sheet.getRow(i);
				// 1st Cell as Value
				Cell valueCell = row.getCell(1);
				// 0th Cell as Key
				Cell keyCell = row.getCell(0);
				String value = valueCell.getStringCellValue().trim();
				String key = keyCell.getStringCellValue().trim();
				// Putting key & value in dataMap
				dataMap.put(key, value);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Returning excelFileMap
		return dataMap;
	}
	
	

}
