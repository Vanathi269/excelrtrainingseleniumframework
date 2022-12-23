package com.excelr.util;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelreader {
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	
	public static Object[][] getuserdata() {
		String filepath="./SeleniumTraining/src/test/java/textng/data.xlsx";
		try {
			wb = new XSSFWorkbook(filepath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheet =wb.getSheet("data");//this workbook get the name data
		
		//get the numberbof rows
		int rowCount =sheet.getPhysicalNumberOfRows();
		int colCount =sheet.getRow(0).getLastCellNum();
		
		//reading the data
		Object[][] data=new Object[colCount][rowCount];
		
		for(int row=0;row<rowCount;row++) {
			for(int col=0;col<colCount;col++) {
		data[row][col]	= sheet.getRow(row).getCell(col);	
			}
			
		}
		return data;
	}
}
