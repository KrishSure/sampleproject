package org.maven.project.sampleproject.selenium.pages.webtable;

import java.util.ArrayList;
import java.util.List;

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
	
	
	
	public void clickGroupZLink() {
		//groupZLink.click();
		fl.clickOnElement(groupZLink);
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
	
		
}
