package org.maven.project.sampleproject.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelectExample {
	
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");

		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://html.com/attributes/select-multiple/");
		
		WebElement multiSelectElement = driver.findElement(By.tagName("select"));
		
		Select select = new Select(multiSelectElement);
		
		//Thread.sleep(10000);
		
		if(select.isMultiple()) {
			System.out.println("It is a multiple select");
			
			select.selectByIndex(3);
			select.selectByIndex(0);
			select.selectByIndex(5);
			select.selectByIndex(4);
			
			select.deselectByIndex(0);
			
			List<WebElement> options = select.getOptions();
			
			for(WebElement option : options) {
				System.out.println(option.getText());
			}
			
			select.deselectByValue("Lesser");
			
			select.deselectByIndex(2);
			
			WebElement firstSelectedElement = select.getFirstSelectedOption();
			
			System.out.println("First Selected options Value: "+firstSelectedElement.getAttribute("value"));
			
			List<WebElement> selectedOptions = select.getAllSelectedOptions();
			
			for(WebElement selectedOption: selectedOptions) {
				System.out.println(selectedOption.getAttribute("value"));
			}
			
			
			
			select.deselectAll();
			
			
			
			
		}
		
		
				

	}

}
