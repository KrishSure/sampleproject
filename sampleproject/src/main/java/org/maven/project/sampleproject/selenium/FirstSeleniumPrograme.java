package org.maven.project.sampleproject.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstSeleniumPrograme {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//step 1: downloading the geckodriver.exe file and extracted in below location
		//step 2: The path of the geckodriver.exe file is set to a property for webdriver.gecko.driver key
		System.setProperty("webdriver.gecko.driver", "D:\\Softwares\\selenium_info\\geckodriver-v0.22.0-win64\\geckodriver.exe");
		
		//step 3: Creating a driver object with FirefoxDriver
		WebDriver driver = new FirefoxDriver();
		
		//step 4: Launching the browser with URL
		driver.get("https://www.facebook.com/");
		
		//step 5: Closing the browser
		driver.close();
	}

}
