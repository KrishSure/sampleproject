package org.maven.project.sampleproject.testNG;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersDemo {

  @Parameters({"UserName","Password","errormessage"})
  @Test
  public void facbookLogin(String user_name,String pass,String errormsg) {
	  
	  WebDriver driver;

		System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");

		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Exersize
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.name("email")).sendKeys(user_name);
		
		driver.findElement(By.id("pass")).sendKeys(pass);
		
		driver.findElement(By.xpath("//label[@id='loginbutton']/child::input")).click();
		
		String errorMessage = driver.findElement(By.xpath("//div[@class='_4rbf _53ij']")).getText();
		
		System.out.println(" Error message :"+errorMessage);
		
		//assertions
		
		//assertEquals(errorMessage, "The password that you've entered is incorrect. Forgotten password?");
		
		assertTrue(errorMessage.contains(errormsg));
		
		//Teardown
		driver.close();
  }
}
