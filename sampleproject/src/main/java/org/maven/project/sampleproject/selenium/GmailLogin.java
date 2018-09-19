package org.maven.project.sampleproject.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GmailLogin {

	public static void main(String[] args) throws InterruptedException {
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
		
		Thread.sleep(500);
		
		driver.findElement(By.name("password")).sendKeys("Seleniumjava@75");
		
		driver.findElement(By.id("passwordNext")).click(); 
	}

}
