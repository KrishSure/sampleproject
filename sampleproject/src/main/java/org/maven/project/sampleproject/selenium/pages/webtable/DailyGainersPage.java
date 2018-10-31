package org.maven.project.sampleproject.selenium.pages.webtable;

import java.util.ArrayList;
import java.util.List;

import org.maven.project.sampleproject.selenium.Utility.ExcelUtility;
import org.maven.project.sampleproject.selenium.Utility.FunctionLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class DailyGainersPage {

	public DailyGainersPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		fl=new FunctionLibrary();

	}

	WebDriver driver;
	FunctionLibrary fl;

	@FindBy(xpath="//table[@class='dataTable']/thead/tr")
	private WebElement headerRow;

	@FindBys(@FindBy(xpath="//table[@class='dataTable']/tbody/tr"))
	private List<WebElement> bodyrows;

	@FindBy(linkText="Group Z")
	private WebElement groupZLink;

	@FindBy(linkText="Group A")
	private WebElement groupALink;

	@FindBy(linkText="Group B")
	private WebElement groupBLink;

	@FindBy(linkText="Group M")
	private WebElement groupMLink;

	@FindBy(linkText="Group T")
	private WebElement groupTLink;

	@FindBy(linkText="Group MT")
	private WebElement groupMTLink;

	@FindBy(linkText="All")
	private WebElement allLink;



	public void clickGroupZLink() {

		fl.clickOnElement(groupZLink);
	}

	public void clickGroupALink() {

		fl.clickOnElement(groupALink);
	}

	public void clickGroupBLink() {

		fl.clickOnElement(groupBLink);
	}

	public void clickGroupTLink() {

		fl.clickOnElement(groupTLink);
	}

	public void clickGroupMTLink() {

		fl.clickOnElement(groupMTLink);
	}

	public void clickGroupMLink() {

		fl.clickOnElement(groupMLink);
	}

	public void clickAllLink() {

		fl.clickOnElement(allLink);
	}

	public List<String> fetchHeaderColumnValues() {

		List<String> names=new ArrayList<String>();
		List<WebElement> headerColumnsData = headerRow.findElements(By.tagName("th"));
		for(WebElement columnNmae : headerColumnsData) {
			String name = columnNmae.getText();
			//System.out.println(name);
			names.add(name);
		}
		return names;
		//System.out.println(headerRow.getText());
	}

	public List<String> fetchBodyColumnValues(int index) {		
		List<String> names=new ArrayList<String>();
		List<WebElement> headerColumnsData = bodyrows.get(index).findElements(By.tagName("td"));
		for(WebElement columnNmae : headerColumnsData) {
			String name = columnNmae.getText();
			//System.out.println(name);
			names.add(name);
		}
		return names;
		//System.out.println(headerRow.getText());
	}

	public int countOfBodyRows() {
		return bodyrows.size();
	}

	public boolean clickGroupName(String groupName) {
		boolean bFlag = false;
		switch(groupName){
		case "Group A":
			clickGroupALink();
			bFlag = true;
			break;
		case "Group B":
			clickGroupBLink();
			bFlag = true;
			break;
		case "Group M":
			clickGroupMLink();
			bFlag = true;
			break;
		case "Group T":
			clickGroupTLink();
			bFlag = true;
			break;
		case "Group MT":
			clickGroupMTLink();
			bFlag = true;
			break;
		case "Group Z":
			clickGroupZLink();
			bFlag = true;
			break;
		case "All":
			bFlag = true;
			break;
		default:
			System.out.println("your given group is not there please check once");
			bFlag = false;
		}
		return bFlag;
	}

	public void storeGroupDetailsInExcel(String groupName) {
		switch(groupName){
		case "Group A":
			clickGroupALink();
			break;
		case "Group B":
			clickGroupBLink();
			break;
		case "Group M":
			clickGroupMLink();
			break;
		case "Group T":
			clickGroupTLink();
			break;
		case "Group MT":
			clickGroupMTLink();
			break;
		case "Group Z":
			clickGroupZLink();
			break;
		case "All":

			break;
		default:
			System.out.println("your given group is not there please check once");
			return;

		}


		ExcelUtility.excelIntialization("ExcelData\\"+groupName+fl.generateUniqueId()+".xlsx", groupName);
		List<String> columnNames = fetchHeaderColumnValues();

		int h=0;
		for(String columnName : columnNames) {
			//System.out.print("\t"+columnName);
			ExcelUtility.printInExcel(0, h++, columnName);
		}

		int d=0;
		for(int i=0;i<countOfBodyRows();i++) {
			List<String> columnValues =  fetchBodyColumnValues(i);
			d=0;
			for(String columnValue : columnValues) {
				//System.out.print("\t"+columnValue);
				ExcelUtility.printInExcel(i+1, d++, columnValue); 
			}

		}
	}

	public List<String> searchForCompany(String companyName) {
		List<String> columnValues=null;
		for(int i=0;i<countOfBodyRows();i++) {
			columnValues =  fetchBodyColumnValues(i);	
			String appCompanyName = columnValues.get(0);
			if(companyName.equals(appCompanyName)) {
				/*System.out.println("Company Name : "+columnValues.get(0));
				System.out.println("Group : "+columnValues.get(1));
				System.out.println("Prev Close (Rs) : "+columnValues.get(2));
				System.out.println("Current Price (Rs) : "+columnValues.get(3));
				System.out.println("% Change : "+columnValues.get(4));*/
				break;
			}	
		}
		return columnValues;
	}

	public void printCompanyInfo(String companyName) {
		List<String> comapnyInfo=searchForCompany(companyName);
		if(comapnyInfo!=null) {
			System.out.println("Company Name : "+comapnyInfo.get(0));
			System.out.println("Group : "+comapnyInfo.get(1));
			System.out.println("Prev Close (Rs) : "+comapnyInfo.get(2));
			System.out.println("Current Price (Rs) : "+comapnyInfo.get(3));
			System.out.println("% Change : "+comapnyInfo.get(4));
		}
	}

	public void printCompanyInfo(String companyName, String groupName) {
		if(clickGroupName(groupName)) {
			System.out.println("Successfully clicked on "+ groupName);
			printCompanyInfo(companyName);
		}
		else
		{
			System.out.println("Given group is not available "+groupName);
		}
	}
}
