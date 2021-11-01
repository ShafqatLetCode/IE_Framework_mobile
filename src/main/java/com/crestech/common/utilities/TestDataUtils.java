package com.crestech.common.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestDataUtils {
	String fileName;
	String TestcaseName;

	// Identify Testcases coloum by scanning the entire 1st row
	// once column is identified then scan entire testcase coloum to identify
	// purcjhase testcase row
	// after you grab purchase testcase row = pull all the data of that row and feed
	// into test
	public TestDataUtils(String fileName, String TestcaseName) {
		this.fileName = fileName;
		this.TestcaseName = TestcaseName;
	}

	public String Read(String dataAttribute) throws IOException {
		// fileInputStream argument
		ArrayList<String> a = new ArrayList<String>();
		File excelDir = new File("dataRepository");
		File excel = new File(excelDir, fileName); /// "DR_module_1.xlsx"
		String path = excel.getAbsolutePath();
		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		String S = null;
		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("Read")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				// Identify Testcases coloum by scanning the entire 1st row

				Iterator<Row> rows = sheet.iterator();// sheet is collection of rows
				Row firstrow = rows.next();
				Iterator<Cell> ce = firstrow.cellIterator();// row is collection of cells
				int k = 0;
				int coloumn = 0;
				int index = 0;
				int j = 0;
				while (ce.hasNext()) {
					Cell value = ce.next();

					if (value.getStringCellValue().equalsIgnoreCase("TestCases")) {
						coloumn = k;

					} else if (value.getStringCellValue().equalsIgnoreCase(dataAttribute)) {
						index = k;
					}

					k++;
				}
				System.out.println(coloumn);
				////// index of attribute name

				//// once coloumn is identified then scan entire testcase coloum to identify
				//// purcjhase testcase row

				while (rows.hasNext()) {

					Row r = rows.next();
					if (r.getCell(coloumn) != null) {
						if (r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(TestcaseName)) {

							//// after you grab purchase testcase row = pull all the data of that row and
							//// feed into test

							Iterator<Cell> cv = r.cellIterator();
							while (cv.hasNext()) {
								Cell c = cv.next();

								if (j == (index - coloumn)) 
									S = c.getStringCellValue();
						
								

								j++;
							}
						}
					}
				}

			}

		}
		return S;

	}

	public void Write(String dataAttribute, String datawrite) throws IOException {
		// fileInputStream argument
		ArrayList<String> a = new ArrayList<String>();
		File excelDir = new File("src/test/dataRepository");
		File excel = new File(excelDir, fileName); /// "DR_module_1.xlsx"
		String path = excel.getAbsolutePath();
		FileInputStream inputStream = new FileInputStream(path);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		
		String S = null;
		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("Write")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				// Identify Testcases coloum by scanning the entire 1st row

				Iterator<Row> rows = sheet.iterator();// sheet is collection of rows
				Row firstrow = rows.next();
				Iterator<Cell> ce = firstrow.cellIterator();// row is collection of cells
				int k = 0;
				int coloumn = 0;
				int index = 0;
				int j = 0;
				while (ce.hasNext()) {
					Cell value = ce.next();

					if (value.getStringCellValue().equalsIgnoreCase("TestCases")) {
						coloumn = k;

					} else if (value.getStringCellValue().equalsIgnoreCase(dataAttribute)) {
						index = k;
					}

					k++;
				}
				System.out.println(coloumn);
				////// index of attribute name

				//// once coloumn is identified then scan entire testcase coloum to identify
				//// purcjhase testcase row

				while (rows.hasNext()) {

					Row r = rows.next();
					if (r.getCell(coloumn) != null) {
						if (r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(TestcaseName)) {

							//// after you grab purchase testcase row = pull all the data of that row and
							//// feed into test

							Iterator<Cell> cv = r.cellIterator();
							while (cv.hasNext()) {
								Cell c = cv.next();

								if (j == (index - coloumn)) {

									c.setCellValue(datawrite);
									FileOutputStream fos = new FileOutputStream(path);
									workbook.write(fos);
									fos.close();
								} 
								j++;
							}
						}
					}
				}

			}

		}

	}
}
