package org.maven.project.sampleproject.testNG;

import static org.testng.Assert.assertEquals;

import org.maven.project.sampleproject.selenium.Utility.FunctionLibrary;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertDemoTest {
	WebDriver driver;
	FunctionLibrary fl;

	@BeforeMethod
	public void setup() {
		fl = new FunctionLibrary();
		driver = fl.launchBrowser("firefox");
		fl.launchUrl("http://demo.automationtesting.in/Alerts.html");

	}
	@Test
	public void AlertWothOk() {
		driver.findElement(By.xpath("//a[@href='#OKTab']")).click();

		driver.findElement(By.xpath("//div[@id='OKTab']/button")).click();

		Alert alert = driver.switchTo().alert();

		/*try {
		Thread.sleep(3000l);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
		fl.hardWait(3000l);

		alert.accept();

		fl.hardWait(3000l);
		
		driver.findElement(By.xpath("//div[@id='OKTab']/button")).click();

		fl.hardWait(3000l);

		Alert alert1 = driver.switchTo().alert();

		System.out.println("Alert Message: "+alert1.getText());

		alert1.accept();

	}

	@Test(enabled=true)
	public void AlertWothOkAndCancel() {
		driver.findElement(By.xpath("//a[@href='#CancelTab']")).click();

		driver.findElement(By.xpath("//div[@id='CancelTab']/button")).click();

		Alert alert = driver.switchTo().alert();
		
		fl.hardWait(3000l);
		
		System.out.println(" Alert Message : "+alert.getText());
		
		alert.dismiss();
		
		String resultValue = driver.findElement(By.id("demo")).getText();
		
		assertEquals(resultValue, "You Pressed Cancel");
		
		driver.findElement(By.xpath("//div[@id='CancelTab']/button")).click();

		alert = driver.switchTo().alert();
		
		fl.hardWait(3000l);
		
		System.out.println(" Alert Message : "+alert.getText());
		
		alert.accept();
		
		resultValue = driver.findElement(By.id("demo")).getText();
		
		assertEquals(resultValue, "You pressed Ok");
	}

	@Test(enabled=true)
	public void AlertWothTextBox() {
		driver.findElement(By.xpath("//a[@href='#Textbox']")).click();

		driver.findElement(By.xpath("//div[@id='Textbox']/button")).click();

		Alert alert = driver.switchTo().alert();
		
		fl.hardWait(3000l);
		
		System.out.println(" Alert Message : "+alert.getText());
		
		String alertText = "Charan";
		
		alert.sendKeys(alertText);
		
		fl.hardWait(3000l);
		
		alert.accept();
		
		String resultValue = driver.findElement(By.id("demo1")).getText();
		
		assertEquals(resultValue, "Hello "+alertText+" How are you today");
		
	}

	@AfterMethod
	public void teardown() {
		driver.close();
	}

}
