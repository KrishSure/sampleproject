package org.maven.project.sampleproject.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectExample {

	public static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");

		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.facebook.com/");

		WebElement daySelectElement = driver.findElement(By.id("day"));

		Select daySelect = new Select(daySelectElement);

		if(daySelect.isMultiple())
		{
			System.out.println("It is multiple select option");

		}else {

			System.out.println("It is not multiple select options");

			daySelect.selectByIndex(8);

			daySelect.selectByValue("19");

			daySelect.selectByVisibleText("16");
		}


		WebElement monthSelectElement = driver.findElement(By.id("month"));

		Select monthSelect = new Select(monthSelectElement);

		if(monthSelect.isMultiple())
		{
			System.out.println("It is multiple select option");
			
			//monthSelect.deselectAll();

		}else {

			System.out.println("It is not multiple select options");

			monthSelect.selectByIndex(5);

			monthSelect.selectByValue("7");

			monthSelect.selectByVisibleText("Mar");
		}
		
		
		WebElement yearSelectElement = driver.findElement(By.id("year"));

		Select yearSelect = new Select(yearSelectElement);

		if(yearSelect.isMultiple())
		{
			System.out.println("It is multiple select option");

		}else {

			System.out.println("It is not multiple select options");

			yearSelect.selectByIndex(5);

			yearSelect.selectByValue("1987");

			yearSelect.selectByVisibleText("1990");
		}

		
		List<WebElement> optionElements = monthSelect.getOptions();
		
		for(WebElement option : optionElements) {
			System.out.println("Value : " +option.getAttribute("value"));
			System.out.println("Visible Text : "+option.getText());
		}
		
		

	}

}
