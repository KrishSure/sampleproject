package org.maven.project.sampleproject.selenium.Utility;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

	public void hardWait(long waitTimeInMilliseconds) {
		 try {
				Thread.sleep(waitTimeInMilliseconds);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void takescreenshot() {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File("Screenshots//Screenshot_"+generateUniqueId()+".png");
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
