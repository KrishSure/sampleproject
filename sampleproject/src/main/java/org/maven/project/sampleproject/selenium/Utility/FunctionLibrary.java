package org.maven.project.sampleproject.selenium.Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FunctionLibrary {
	
	public FunctionLibrary(WebDriver driver) {
		super();
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
	}

	WebDriver driver;	
	WebDriverWait wait;
	
	
	public void clickOnElement(WebElement element)
	{	
		WebElement foundElement = checkingVisibiliy(element);
		foundElement.click();
	}
	
	public void setValue(WebElement element,CharSequence... keysToSend)
	{		
		WebElement foundElement = checkingVisibiliy(element);
		foundElement.clear();
		foundElement.sendKeys(keysToSend);
	}
	
	public WebElement checkingVisibiliy(WebElement element) {
		return  wait.until(ExpectedConditions.visibilityOf(element));		
	}
	
	public String getTextforElement(WebElement element) {
		return checkingVisibiliy(element).getText();
	}


}
