package org.maven.project.sampleproject.selenium.Utility;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FunctionLibrary {
	
	public FunctionLibrary() {
		super();
	}
	
	

	public static WebDriver driver;	
	public static WebDriverWait wait;
	
	public WebDriver launchBrowser(String browser) {
		System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		;
		wait = new WebDriverWait(driver, 30);
		return driver;
	}
	
	public void launchUrl(String URL) {
		driver.get(URL);
	}
	
	public void clickOnElement(WebElement element)
	{	
		WebElement foundElement = checkingVisibiliy(element);
		foundElement = elementIsClickable(foundElement);
		if(isElementDisplayed(foundElement))
			foundElement.click();
		else
			System.out.println("element is not visible");
	}
	
	public boolean isElementDisplayed(WebElement element) {
		
		try {
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
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
	
	public WebElement elementIsClickable(WebElement element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public String getTextforElement(WebElement element) {
		return checkingVisibiliy(element).getText();
	}
	
	public String generateUniqueId() {
		return UUID.randomUUID().toString();
	}


}
