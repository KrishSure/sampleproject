package org.maven.project.sampleproject.testNG;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

//import org.apache.commons.io.FileUtils;
import org.maven.project.sampleproject.selenium.Utility.FunctionLibrary;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;


public class ScreenshotDemoTest {
	WebDriver driver;
	FunctionLibrary fl;

	
	@BeforeMethod
	public void setup() {
		fl = new FunctionLibrary();
		driver = fl.launchBrowser("firefox");
		fl.launchUrl("http://jquery.com");

	}
  @Test
  public void screenshotDemo() {
	  
	  /*TakesScreenshot ts = (TakesScreenshot)driver;
	  File srcFile = ts.getScreenshotAs(OutputType.FILE);
	  
	  File destFile = new File("Screenshots//Screenshot_"+fl.generateUniqueId()+".jpg");
	  
	  try {
		FileUtils.copyFile(srcFile, destFile);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	 fl.takescreenshot();
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  
	  js.executeScript("scroll(0,30000)");
	  js.executeScript("alert('Your taking secondScreenshot')");
	  
	  fl.takescreenshot();
	  
  }
  
  @Test
  public void fullScreenShotDemo() {
	  fl.hardWait(10000l);
	  Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		try {
			ImageIO.write(fpScreenshot.getImage(),"PNG",new File("Screenshots//Screenshot_"+fl.generateUniqueId()+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
}
