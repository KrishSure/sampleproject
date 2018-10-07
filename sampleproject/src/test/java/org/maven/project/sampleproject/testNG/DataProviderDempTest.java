package org.maven.project.sampleproject.testNG;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;

public class DataProviderDempTest {
  @Test(dataProvider = "dataProvider")
  public void FacebookLogin(String username, String password, String errormsg) {
	  WebDriver driver;

		System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");

		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Exersize
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.name("email")).sendKeys(username);
		
		driver.findElement(By.id("pass")).sendKeys(password);
		
		driver.findElement(By.xpath("//label[@id='loginbutton']/child::input")).click();
		
		String errorMessage = driver.findElement(By.xpath("//div[@class='_4rbf _53ij']")).getText();
		
		System.out.println(" Error message :"+errorMessage);
		
		//assertions
		
		//assertEquals(errorMessage, "The password that you've entered is incorrect. Forgotten password?");
		
		assertTrue(errorMessage.contains(errormsg));
		
		//Teardownerrormsg
		driver.close();
	  
  }

  @DataProvider(name="dataProvider")
  public Object[][] dp() {
    Object obj[][]= new Object[][] {{ "dilipkumarpv8899@gmail.com", "123456" ,"The password that you've entered is incorrect"},
    								{ "seleniumjava75@gmail.com", "Seleniumjava@75","The email address that you've entered doesn't match any account." },
    								{ "surevkrishnarao@yahoo.co.in", "123456870" ,"The password that you've entered is incorrect"}
    							   };
    return obj;
  }
}
