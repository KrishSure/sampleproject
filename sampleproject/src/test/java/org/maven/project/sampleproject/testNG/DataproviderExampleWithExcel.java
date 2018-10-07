package org.maven.project.sampleproject.testNG;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataproviderExampleWithExcel {
	WebDriver driver;
	WebDriverWait wait;
	
	@DataProvider
	public Object[][] dataMethod() {
			Object[][] datas=null;
		  try {
			File file = new File("ExcelData\\DataCredentials.xlsx");
			  //FileInputStream fio = new FileInputStream(file);
			  Workbook book = new XSSFWorkbook(file);
			  XSSFSheet sheet = (XSSFSheet) book.getSheet("dataSheet");	
			  
			  DataFormatter df = new DataFormatter();
			  
			  int totalRows = sheet.getLastRowNum();
			  int noCells = sheet.getRow(0).getPhysicalNumberOfCells();
			  
			  datas = new Object[totalRows][noCells];
			  
			  for(int i=1;i<=totalRows;i++){
				  XSSFRow row = sheet.getRow(i);
				  int totalCells = row.getPhysicalNumberOfCells();
				  for(int j=0;j<totalCells;j++)
				  {
					  XSSFCell cell = row.getCell(j);
					  System.out.println(df.formatCellValue(cell));
					  String value = df.formatCellValue(cell);	
					  datas[i-1][j]=value;	  
				  }
			  }
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datas;
	}
	
	
	
	@BeforeMethod
	public void setUP()
	{
		System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 10);
		driver.get("https://mail.google.com");
	}
	
  @Test(dataProvider="dataMethod")
  public void login(String sUserName,String sPassword) throws InterruptedException {
	  driver.findElement(By.id("identifierId")).sendKeys(sUserName);

		driver.findElement(By.id("identifierNext")).click();

		Thread.sleep(500);

		driver.findElement(By.name("password")).sendKeys(sPassword);

		driver.findElement(By.id("passwordNext")).click(); 

		driver.findElement(By.xpath("//span[@class='gb_9a gbii']")).click();

		//driver.findElement(By.xpath("//a[@id='gb_71']")).click();
		//driver.findElement(By.linkText("Sign out")).click();

		String emailAddress = driver.findElement(By.className("gb_Eb")).getText();

		assertEquals(emailAddress, sUserName);
  }
  
  @AfterMethod
  public void tearDown() {
	  driver.quit();
  }
}
