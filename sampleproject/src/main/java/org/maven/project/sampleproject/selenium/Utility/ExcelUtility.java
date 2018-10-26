package org.maven.project.sampleproject.selenium.Utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
	public static HashMap<String, String> map;
	public static String excelFilePath;

	public static int setExcel(String filePath, String sheetName) {
		try {
			excelFilePath = filePath;
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

		map = new HashMap<String, String>();

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

	public static void updateCell(String columnName, String value) {		
		try {
			map.put(columnName, value);		

			int columnNameCellNum = coloumnNamesRow.getLastCellNum();
			for(int i=0;i<=columnNameCellNum;i++) {
				
				XSSFCell cNamesCell =coloumnNamesRow.getCell(i);
				
				if(cNamesCell!=null) {

					if(columnName.equals(cNamesCell.getStringCellValue())) {

						//row.getCell(i).setCellValue(value);
						XSSFCell rowCell = row.getCell(i);
						
						if(rowCell!=null)
							rowCell.setCellValue(value);
						else
							row.createCell(i).setCellValue(value);
						
						FunctionLibrary fl = new FunctionLibrary();
						FileOutputStream fileOut = new FileOutputStream("ExcelData\\ReulstFile"+fl.generateUniqueId()+".xls");

						book.write(fileOut);

						fileOut.flush();

						fileOut.close();

						break;
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
