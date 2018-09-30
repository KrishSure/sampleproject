package org.maven.project.sampleproject.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverOptionsDemo {
	
	public static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");

		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		driver.get("https://www.google.com/");
		
		String pagesource = driver.getPageSource();
		
		System.out.println(pagesource);
		
		/*if(pagesource.contains("title"))
		{
			String title=driver.findElement(By.tagName("title")).getText();
			System.out.println(title);
			System.out.println("title is ");
		}else
		{
			System.out.println("no title");
		}*/
		
		System.out.println("Title of the page: "+driver.getTitle());
		
		System.out.println("Current URL : "+driver.getCurrentUrl());
		
		driver.close();


	}

}
