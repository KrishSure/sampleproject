package org.maven.project.sampleproject.testNG;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.maven.project.sampleproject.selenium.Utility.FunctionLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicRadioButtonDemo {
	WebDriver driver;
	FunctionLibrary fl;

	@BeforeMethod
	public void setup() {
		fl = new FunctionLibrary();
		driver = fl.launchBrowser("firefox");
		fl.launchUrl("https://material.angularjs.org/latest/demo/radioButton");

	}
  @Test
  public void SelectAppleRadioButton() {
	  
	 WebElement appleRadioButton = driver.findElement(By.xpath("//*[contains(@id,'radio')][@value='Apple']"));
	  
	 fl.hardWait(5000);
	 System.out.println("element is getting displayed or not "+appleRadioButton.isDisplayed());
	 //if(!appleRadioButton.isSelected()) 
	 if(appleRadioButton.getAttribute("aria-checked").equals("false")) 
		 fl.clickOnElement(appleRadioButton);
	 else
		 System.out.println("Apple is already selected");
	 fl.hardWait(3000);
	 //assertTrue(appleRadioButton.isSelected());
	 assertEquals(appleRadioButton.getAttribute("aria-checked"), "true");
	  
  }
  
  @Test
  public void Selectavatar_3RadioButton() {
	  
	 WebElement avatar_3RadioButton = driver.findElement(By.xpath("//*[contains(@id,'radio')][@value='avatar-3']"));
	 fl.hardWait(5000);
	 
	 System.out.println("element is getting displayed or not "+avatar_3RadioButton.isDisplayed());
	 //if(!avatar_3RadioButton.isSelected())
	 if(avatar_3RadioButton.getAttribute("aria-checked").equals("false")) 
		 fl.clickOnElement(avatar_3RadioButton);
	 else
		 System.out.println("avatar-3 is already selected");
	 
	 fl.hardWait(3000);
	 //assertTrue(avatar_3RadioButton.isSelected());
	 assertTrue(avatar_3RadioButton.getAttribute("aria-checked").equals("true"));
	  
  }
  
  @AfterMethod
  public void tearDown() {
	 // driver.close();
  }
}
