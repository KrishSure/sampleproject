package org.maven.project.sampleproject.testNG;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FacebookTest {
	@Test
	public void facebookLoginWithWrongPassword() {
		//setup
		WebDriver driver;

		System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");

		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Exersize
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.name("email")).sendKeys("dilipkumarpv8899@gmail.com");
		
		driver.findElement(By.id("pass")).sendKeys("123456");
		
		driver.findElement(By.xpath("//label[@id='loginbutton']/child::input")).click();
		
		String errorMessage = driver.findElement(By.xpath("//div[@class='_4rbf _53ij']")).getText();
		
		System.out.println(" Error message :"+errorMessage);
		
		//assertions
		
		//assertEquals(errorMessage, "The password that you've entered is incorrect. Forgotten password?");
		
		assertTrue(errorMessage.contains("The password that you've entered is incorrect"));
		
		//Teardown
		driver.close();
		
	}
	
	@Test
	public void facebookLoginWithWrongEmail() {
		//setup
		WebDriver driver;

		System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");

		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Exersize
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.name("email")).sendKeys("dilipkumarpv9@gmail.com");
		
		driver.findElement(By.id("pass")).sendKeys("123456");
		
		driver.findElement(By.xpath("//label[@id='loginbutton']/child::input")).click();
		
		String errorMessage = driver.findElement(By.xpath("//div[@class='_4rbf _53ij']")).getText();
		
		System.out.println(" Error message : "+errorMessage);
		
		//assertions
		
		assertEquals(errorMessage, "The email address that you've entered doesn't match any account. Sign up for an account.");
		
		//assertTrue(errorMessage.contains("The password that you've entered is incorrect"));
		
		//Teardown
		driver.close();
		
	}
}
