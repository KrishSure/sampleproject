package org.maven.project.sampleproject.selenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FluentWaitDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.setProperty("webdriver.gecko.driver", "D:\\Softwares\\selenium_info\\geckodriver-v0.22.0-win64\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.google.com/");
		
		driver.findElement(By.linkText("Gmail")).click();
		
		
		//driver.findElement(By.linkText("Sign In")).click();
		
		//driver.findElement(By.className("gmail-nav__nav-link gmail-nav__nav-link__sign-in")).click();
		
		driver.findElement(By.xpath("//a[@class='gmail-nav__nav-link gmail-nav__nav-link__sign-in']")).click();
		
		driver.findElement(By.id("identifierId")).sendKeys("seleniumjava75@gmail.com");
		
		driver.findElement(By.id("identifierNext")).click();
		
		
		
		//FluentWait
		/*Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(Duration.ofSeconds(30))
			       .pollingEvery(Duration.ofMillis(50)).ignoring(ElementNotInteractableException.class);
			       */
		//Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 30);

			  /* WebElement password = wait.until(new Function<WebDriver, WebElement>() {
			     public WebElement apply(WebDriver driver) {
			       return driver.findElement(By.name("password"));
			     }
			   });*/
		
		WebElement password =wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("password"))));
		
		//Thread.sleep(500);
		
		//driver.findElement(By.name("password")).sendKeys("Seleniumjava@75");
	 password.sendKeys("Seleniumjava@75");
		
		driver.findElement(By.id("passwordNext")).click(); 
	}

}
