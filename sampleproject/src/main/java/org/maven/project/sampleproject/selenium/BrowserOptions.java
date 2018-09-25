package org.maven.project.sampleproject.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserOptions {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.amazon.in/");
		
		//Webdriver.Window methods demo
		
		driver.manage().window().fullscreen();
		
		driver.manage().window().setPosition(new Point(50, 50));
		
		driver.manage().window().setSize(new Dimension(500, 500));
		
		driver.manage().window().maximize();
		
		System.out.println(driver.manage().window().getPosition().toString());
		
		System.out.println(driver.manage().window().getSize().toString());
		
		
		//Webdirver.Navigation methods demo
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Tvs");
		
		driver.navigate().refresh();
				
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Books");
		
		driver.findElement(By.xpath("//span[@id='nav-search-submit-text']/following-sibling::input")).click();
		
		driver.navigate().to("https://www.amazon.in/gp/goldbox?ref=nav_topnav_deals");
		
		driver.navigate().back();
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Refrigerators");
		
		driver.findElement(By.xpath("//span[@id='nav-search-submit-text']/following-sibling::input")).click();
		
		driver.navigate().back();
		
		driver.navigate().forward();
		
		driver.navigate().to("https://www.amazon.in/s/ref=nb_sb_noss?url=search-alias%3Daps&field-keywords=Tvs");
		
		
		
	}

}
