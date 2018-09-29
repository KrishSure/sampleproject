package org.maven.project.sampleproject.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DynamicDropdownDemo {
	
	public static WebDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");

		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.google.com/");
		
		driver.findElement(By.id("lst-ib")).sendKeys("selenium");
		
		List<WebElement> listElements =  driver.findElements(By.xpath("//ul[@class='sbsb_b']/li"));
		
		for(WebElement element : listElements) {
			String displayName = element.getText();
			System.out.println(displayName);
			if(displayName.equals("selenium webdriver")) {
				element.click();
				break;
			}
		}
		
		driver.findElement(By.partialLinkText("Selenium WebDriver — Selenium Documentation")).click();

	}

}
