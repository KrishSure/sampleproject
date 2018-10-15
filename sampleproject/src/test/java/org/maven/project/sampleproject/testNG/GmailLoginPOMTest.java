package org.maven.project.sampleproject.testNG;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.maven.project.sampleproject.selenium.pages.GmailHomePage;
import org.maven.project.sampleproject.selenium.pages.GmailLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class GmailLoginPOMTest {
  @Test
  public void GmailLoginTest() {
	  WebDriver driver;

		System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");

		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Exersize
		driver.get("https://www.gmail.com/");
		
		GmailLoginPage glp = new GmailLoginPage(driver);
		
		//GmailLoginPage glp = PageFactory.initElements(driver, GmailLoginPage.class);
		
		/*glp.setEmailOrPhoneField("dilipkumarpv9988@gmail.com");
		
		glp.clickOnEmailNextButton();
		
		glp.setPasswordField("Dilip258963");
		
		glp.clickOnPasswordNextButton();*/
		
		String emailName = glp.gmailLogin("dilipkumarpv9988@gmail.com", "Dilip258963");
		
		/*GmailHomePage ghp = new GmailHomePage(driver);
		
		ghp.clickOngoogleAccountIcon();
		
		String emailName = ghp.getTextOfemailDisplayElement();*/
		
		assertEquals(emailName, "dilipkumarpv9988@gmail.com");
  }
}
