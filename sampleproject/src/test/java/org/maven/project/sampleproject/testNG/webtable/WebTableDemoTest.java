package org.maven.project.sampleproject.testNG.webtable;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.maven.project.sampleproject.selenium.Utility.ExcelUtility;
import org.maven.project.sampleproject.selenium.Utility.FunctionLibrary;
import org.maven.project.sampleproject.selenium.pages.webtable.DailyGainersPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTableDemoTest {
	WebDriver driver;
	FunctionLibrary fl;
	DailyGainersPage dgp;
	@BeforeMethod
	public void setup() {
		  fl = new FunctionLibrary();
		  driver = fl.launchBrowser("firefox");
		  fl.launchUrl("https://money.rediff.com/gainers");
		  dgp = new DailyGainersPage(driver);
	}
  @Test(enabled=false)
  public void printAllGainersInfo() {
	  dgp.storeGroupDetailsInExcel("All");
	    /*dgp.clickGroupZLink();
	   
	  ExcelUtility.excelIntialization("ExcelData\\DynamicTableData"+fl.generateUniqueId()+".xlsx", "WebTableDemo");
	  List<String> columnNames = dgp.fetchHeaderColumnValues();
	  
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
		  
	  }*/
  }
  @Test(enabled=false)  public void printGroupAGainersInfo() {  dgp.storeGroupDetailsInExcel("Group A"); }
  @Test(enabled=false)  public void printGroupBGainersInfo() {  dgp.storeGroupDetailsInExcel("Group B"); }
  @Test(enabled=false)  public void printGroupMGainersInfo() {  dgp.storeGroupDetailsInExcel("Group M"); }
  @Test(enabled=false)  public void printGroupTGainersInfo() {  dgp.storeGroupDetailsInExcel("Group T"); }
  @Test(enabled=false)  public void printGroupMTGainersInfo() {  dgp.storeGroupDetailsInExcel("Group MT"); }
  @Test(enabled=false)  public void printGroupZGainersInfo() {  dgp.storeGroupDetailsInExcel("Group Z"); }
  
  @Test  
  public void printCompanyDetails() {
	  dgp.printCompanyInfo("Sun Retail","All");
  }
  
  @Test  
  public void verifyCompanyDetails() {
	  List<String> companyInfo = dgp.searchForCompany("MindTree Ltd.");
	  
	  boolean bFlag = true;
	  
	  if(!companyInfo.get(1).equals("A")) 
		  bFlag=bFlag&&false;
	  
	  if(!companyInfo.get(2).equals("786.25")) 
		  bFlag=bFlag&&false;
	  
	  if(!companyInfo.get(3).equals("852.55")) 
		  bFlag=bFlag&&false;
	  
	  if(!companyInfo.get(4).equals("+ 8.43")) 
		  bFlag=bFlag&&false;
	  
	  assertTrue(bFlag);
		  
  }
  
  @AfterMethod
  public void tearDown() {
	  driver.close();
  }
}
