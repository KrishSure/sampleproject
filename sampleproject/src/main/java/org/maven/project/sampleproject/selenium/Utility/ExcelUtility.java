package org.maven.project.sampleproject.selenium.Utility;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static XSSFWorkbook book;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFRow coloumnNamesRow;

	public static int setExcel(String filePath, String sheetName) {
		try {
			File file = new File(filePath);
			book = new XSSFWorkbook(file);
			sheet = (XSSFSheet) book.getSheet(sheetName);
			coloumnNamesRow = sheet.getRow(0);			
			return sheet.getLastRowNum();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}

	}
	

	public static HashMap<String, String> load(int rowNum) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		row = sheet.getRow(rowNum);
		
		int lastCellNum = coloumnNamesRow.getLastCellNum();

		System.out.println("Cell count "+lastCellNum);
		
		for(int i=0;i<=lastCellNum;i++) {
			
			String key = fetchColumnName(i);
			String value = fetchCellValue(i);
			System.out.println("key : "+key+" -> value : "+value);
			
			if(key!="")
				map.put(key,value);
		}
		
		return map;
	}

	public static String fetchCellValue(int cellNum) {			
		XSSFCell cell = row.getCell(cellNum);		
		if(cell!=null) {			
			return cell.getStringCellValue();
		}else
			return "";
	}
	
	public static String fetchColumnName(int cellNum) {
		XSSFCell cell = coloumnNamesRow.getCell(cellNum);	
		if(cell!=null) {			
			return cell.getStringCellValue();
		}else
			return "";
	}
}
