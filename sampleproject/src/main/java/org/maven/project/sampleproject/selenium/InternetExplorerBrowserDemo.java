package org.maven.project.sampleproject.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class InternetExplorerBrowserDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.ie.driver", "D:\\Softwares\\selenium_info\\IEDriverServer_x64_3.8.0\\IEDriverServer.exe");

		/*DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();

		ieCapabilities.setCapability("nativeEvents", true);
		ieCapabilities.setCapability("unexpectedAlertBehaviour", "accept");
		ieCapabilities.setCapability("ignoreProtectedModeSettings", true);
		ieCapabilities.setCapability("disable-popup-blocking", true);
		ieCapabilities.setCapability("enablePersistentHover", true);
		ieCapabilities.setCapability("ignoreZoomSetting", true);
		ieCapabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);*/


		InternetExplorerOptions options = new InternetExplorerOptions();
		options.setCapability("nativeEvents", true);
		options.setCapability("ignoreZoomSetting", true);
		options.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);



		WebDriver driver = new InternetExplorerDriver(options);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);



		driver.get("https://www.facebook.com/");

		driver.findElement(By.id("email")).sendKeys("dilipkumarpv8899@gmail.com");

		/*By passwordBy = By.id("pass");

		WebElement passwordElement = driver.findElement(passwordBy);

		passwordElement.sendKeys("123456");*/

		driver.findElement(By.id("pass")).sendKeys("123456");

		driver.findElement(By.xpath("//label[@id='loginbutton']/child::input")).click();

		String errorMessage = driver.findElement(By.xpath("//div[@class='_4rbf _53ij']")).getText();

		System.out.println(" Error message :"+errorMessage);


	}

}
