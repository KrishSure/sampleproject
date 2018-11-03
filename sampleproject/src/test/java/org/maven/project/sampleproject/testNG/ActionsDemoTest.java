package org.maven.project.sampleproject.testNG;

import org.maven.project.sampleproject.selenium.Utility.FunctionLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsDemoTest {
	WebDriver driver;
	FunctionLibrary fl;

	@BeforeMethod
	public void setup() {
		fl = new FunctionLibrary();
		driver = fl.launchBrowser("firefox");
		fl.launchUrl("http://jqueryui.com");

	}
	@AfterMethod
	public void teardown() {
		//driver.close();
	}
  @Test
  public void draggableDemoCase() {
	  driver.navigate().to("http://jqueryui.com/draggable/");
	  
	  driver.switchTo().frame(0);
	  
	  WebElement draggableElement = driver.findElement(By.id("draggable"));
	  
	  Actions action = new Actions(driver);
	  
	  //action.dragAndDropBy(draggableElement, 100, 100).build().perform();
	  
	  action.clickAndHold(draggableElement).moveByOffset(100, 100).release(draggableElement).build().perform();
	  
  }
  
  @Test
  public void dragAndDropDemoCase() {
	  driver.navigate().to("http://jqueryui.com/droppable/");
	  
	  driver.switchTo().frame(0);
	  
	  WebElement draggableElement = driver.findElement(By.id("draggable"));
	  
	  WebElement droppableElement = driver.findElement(By.id("droppable"));
	  
	  Actions action = new Actions(driver);
	  
	  action.clickAndHold(draggableElement).moveToElement(droppableElement).release(draggableElement).build().perform();
	  fl.hardWait(5000l);
	  //action.dragAndDrop(draggableElement, droppableElement);
	  
  }
}
