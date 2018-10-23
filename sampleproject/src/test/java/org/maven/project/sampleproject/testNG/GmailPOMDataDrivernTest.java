package org.maven.project.sampleproject.testNG;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.maven.project.sampleproject.selenium.Utility.ExcelUtility;
import org.maven.project.sampleproject.selenium.Utility.FunctionLibrary;
import org.maven.project.sampleproject.selenium.pages.GmailHomePage;
import org.maven.project.sampleproject.selenium.pages.GmailLoginPage;
import org.maven.project.sampleproject.selenium.pages.GmailLogoutPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class GmailPOMDataDrivernTest {

	@Test
	public void sendingMail() {
		int noOfrows = ExcelUtility.setExcel("ExcelData\\SendingAndVerifyingMail.xlsx", "SVMail");
		for(int i=1;i<=noOfrows;i++) {

			WebDriver driver;

			System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");

			driver = new FirefoxDriver();

			FunctionLibrary fl = new FunctionLibrary(driver);

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			//Exersize
			driver.get("https://www.gmail.com/");

			GmailLoginPage glp = new GmailLoginPage(driver);  



			HashMap<String, String> data = ExcelUtility.load(i);	

			String fromGmailAddress = data.get("FromGmailAddress");
			String fromGmailPassword = data.get("FromGmailPassword");
			String toGmailAddress = data.get("ToGmailAddress");
			String toGmailPassword = data.get("ToGmailPassword");
			String messageOfMailBody = data.get("MessageOfMailBody");
			String subject = data.get("Subject");

			String emailName = glp.gmailLogin(fromGmailAddress, fromGmailPassword);

			assertEquals(emailName, fromGmailAddress);

			GmailHomePage ghp = new GmailHomePage(driver);

			ghp.clickOnComposeButton();

			//ghp.clickOnRecipientsElem();

			//String uniqueID = UUID.randomUUID().toString();

			String subjectWithUniqueId = subject+fl.generateUniqueId();

			System.out.println(subjectWithUniqueId);

			ghp.setToReceipents(toGmailAddress);

			ghp.setSubject(subjectWithUniqueId);

			ghp.setMessageBody(messageOfMailBody);

			ghp.clickOnSendButton();

			//ghp.clickOnSentLink();

			assertTrue(ghp.displayOfmessageSentInfo());

			ghp.clickOngoogleAccountIcon();

			GmailLogoutPage glop = ghp.clickOnSingOutLink();

			glp = glop.removeAccountFromGmailList();


			String emailName1 = glp.gmailLogin(toGmailAddress, toGmailPassword);

			assertEquals(emailName1, toGmailAddress);

			ghp = new GmailHomePage(driver);

			assertTrue(ghp.verifyEmailSubject(subjectWithUniqueId));	
			
			driver.close();
		}	
	}

}
