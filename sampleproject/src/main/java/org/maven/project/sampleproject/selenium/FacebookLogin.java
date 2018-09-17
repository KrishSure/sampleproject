package org.maven.project.sampleproject.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FacebookLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//step 1: downloading the geckodriver.exe file and extracted in below location
		//step 2: The path of the geckodriver.exe file is set to a property for webdriver.gecko.driver key
		System.setProperty("webdriver.gecko.driver", "D:\\Softwares\\selenium_info\\geckodriver-v0.22.0-win64\\geckodriver.exe");
		
		//step 3: Creating a driver object with FirefoxDriver
		WebDriver driver = new FirefoxDriver();
		
		//step 4: Launching the browser with URL
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.name("email")).sendKeys("dilipkumarpv8899@gmail.com");
		
		/*By passwordBy = By.id("pass");
		
		WebElement passwordElement = driver.findElement(passwordBy);
		
		passwordElement.sendKeys("123456");*/
		
		driver.findElement(By.id("pass")).sendKeys("123456");
		
		driver.findElement(By.xpath("//label[@id='loginbutton']/child::input")).click();
		
		String errorMessage = driver.findElement(By.xpath("//div[@class='_4rbf _53ij']")).getText();
		
		System.out.println(" Error message :"+errorMessage);
		
		if(errorMessage.contains("The password that you've entered is incorrect")) {
			System.out.println("Test case is passed");
		}
		else
		{
			System.out.println("Test case is failed");
		}
		
		
		
	}

}
