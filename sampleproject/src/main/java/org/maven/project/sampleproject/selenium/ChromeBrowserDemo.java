package org.maven.project.sampleproject.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowserDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\selenium_info\\chromedriver_win32_2.42\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		//To Maxmize the window 
		driver.manage().window().maximize();
		
		
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
