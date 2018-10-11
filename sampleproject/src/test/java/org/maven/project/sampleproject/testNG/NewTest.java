package org.maven.project.sampleproject.testNG;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.maven.project.sampleproject.selenium.pages.FacebookLoginPage;
import org.maven.project.sampleproject.selenium.pages.LoginIntoFacebookPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class NewTest {
  @Test
  public void f() {
	  	WebDriver driver;

		System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");

		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Exersize
		driver.get("https://www.facebook.com/");
		
		//FacebookLoginPage flpObj = new FacebookLoginPage();
		
		FacebookLoginPage flpObj = PageFactory.initElements(driver, FacebookLoginPage.class);
		
		flpObj.enterValueForEmailTextField("seleniumjava75@gmail.com");
		
		flpObj.enterValueForpasswordTextField("Seleniumjava@75");
		
		flpObj.clickOnLoginButton();
		
		LoginIntoFacebookPage lifObj = PageFactory.initElements(driver, LoginIntoFacebookPage.class);
		
		String errorMessage = lifObj.getErrorMessageText();
		
		assertTrue(errorMessage.contains("The email address that you've entered doesn't match any account. "));
		
		//Teardown
		driver.close();
		
  }
}
