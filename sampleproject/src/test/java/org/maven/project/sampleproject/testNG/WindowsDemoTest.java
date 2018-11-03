package org.maven.project.sampleproject.testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.maven.project.sampleproject.selenium.Utility.FunctionLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class WindowsDemoTest {
	
	WebDriver driver;
	FunctionLibrary fl;

	@BeforeMethod
	public void setup() {
		fl = new FunctionLibrary();
		driver = fl.launchBrowser("firefox");
		fl.launchUrl("http://demo.automationtesting.in/Windows.html");

	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void demoOpenNewTabbedWindows() {
		//driver.findElement(By.xpath("//a[@href='#Tabbed']")).click();
		fl.clickOnElement(driver.findElement(By.xpath("//a[@href='#Tabbed']")));
		
		String window = driver.getWindowHandle();
		
		System.out.println("First Window Name : "+window);
		
		//driver.findElement(By.xpath("//div[@id='Tabbed']/a")).click();
		fl.clickOnElement(driver.findElement(By.xpath("//div[@id='Tabbed']/a")));
				
		ArrayList<String> windows = new ArrayList<String>();
		
		windows.addAll(driver.getWindowHandles());
		
		driver.switchTo().window(windows.get(1));
		
		//driver.findElement(By.linkText("Download")).click();
		fl.clickOnElement(driver.findElement(By.linkText("Download")));
		
		driver.switchTo().window(windows.get(0));
		
		//driver.findElement(By.xpath("//div[@id='Tabbed']/a")).click();
		fl.clickOnElement(driver.findElement(By.xpath("//div[@id='Tabbed']/a")));
		
		ArrayList<String> windows1 = new ArrayList<String>();
		
		windows1.addAll(driver.getWindowHandles());
		
		driver.switchTo().window(windows1.get(1));
		
		fl.hardWait(10000l);
		//driver.findElement(By.linkText("Download")).click();
		fl.clickOnElement(driver.findElement(By.linkText("Download")));
	}
	
	@Test
	public void demoOpenNewSeperateWindows() {
		driver.findElement(By.xpath("//a[@href='#Seperate']")).click();
		
		driver.findElement(By.xpath("//div[@id='Seperate']/button")).click();
		
		String window = driver.getWindowHandle();
		
		System.out.println("First Window Name : "+window);
		
		Set<String> windows = driver.getWindowHandles();
		
		Iterator<String> windowsIterator = windows.iterator();
		String firstWindow = windowsIterator.next();
		String secondWidow = windowsIterator.next();
		
		System.out.println("first window : "+firstWindow);
		
		System.out.println("second window : "+secondWidow);
		
		//switch to second window which is open new
		driver.switchTo().window(secondWidow);
		
		driver.findElement(By.linkText("Download")).click();
		
		driver.switchTo().window(firstWindow);
		
		driver.findElement(By.xpath("//div[@id='Seperate']/button")).click();
		
		
		Set<String> multipleWindows=driver.getWindowHandles();
		
		Iterator<String> multipleWindowsIterator = multipleWindows.iterator();
		
		String windowNames[]= new String[10];
		int i=0;
		
		do {
			windowNames[i++]=multipleWindowsIterator.next();			
		}while(multipleWindowsIterator.hasNext());
		
		
		System.out.println(windowNames.toString());
		
		driver.switchTo().window(windowNames[2]);
		
		driver.findElement(By.linkText("Download")).click();
	}
}
