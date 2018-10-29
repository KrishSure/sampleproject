package org.maven.project.sampleproject.testNG.webtable;

import java.util.List;

import org.maven.project.sampleproject.selenium.Utility.ExcelUtility;
import org.maven.project.sampleproject.selenium.Utility.FunctionLibrary;
import org.maven.project.sampleproject.selenium.pages.webtable.DailyGainersPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class WebTableDemoTest {
  @Test
  public void printAllGainersInfo() {
	  FunctionLibrary fl = new FunctionLibrary();
	  WebDriver driver = fl.launchBrowser("firefox");
	  fl.launchUrl("https://money.rediff.com/gainers");
	  
	  DailyGainersPage dgp = new DailyGainersPage(driver);
	  
	  dgp.clickGroupZLink();

	  List<String> columnNames = dgp.fetchHeaderColumnValues();
	  
	  //ExcelUtility.setResultFile("ExcelData\\DynamicTableData"+fl.generateUniqueId()+".xls");
	  
	  ExcelUtility.excelIntialization("ExcelData\\DynamicTableData"+fl.generateUniqueId()+".xlsx", "WebTableDemo");
	  
	  int h=0;
	  for(String columnName : columnNames) {
		  //System.out.print("\t"+columnName);
		  ExcelUtility.printInExcel(0, h++, columnName);
	  }
	  
	  int d=0;
	  for(int i=0;i<dgp.countOfBodyRows();i++) {
		  List<String> columnValues =  dgp.fetchBodyColumnValues(i);
		  d=0;
		  for(String columnValue : columnValues) {
			 //System.out.print("\t"+columnValue);
			  ExcelUtility.printInExcel(i+1, d++, columnValue); 
		  }
		  
	  }
  }
}
