package org.maven.project.sampleproject.testNG;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;

import org.maven.project.sampleproject.selenium.Utility.FunctionLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class DatePickerDemo {
	WebDriver driver;
	FunctionLibrary fl;

	@BeforeMethod
	public void setup() {
		fl = new FunctionLibrary();
		driver = fl.launchBrowser("firefox");
		fl.launchUrl("https://www.jetairways.com/en/IN/Home.aspx");

	}
	@Test
	public void datePickerDemo() throws InterruptedException, ParseException, IOException {
				
		WebElement departElement = driver.findElement(By.id("txtStartDate"));
		WebElement returnElement = driver.findElement(By.id("txtEndDate"));
			
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date d = sdf.parse("12/09/2019");
		
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int date = cal.get(Calendar.DATE);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		int weekOfMonth = cal.get(Calendar.WEEK_OF_MONTH);
		
		System.out.println("year value :"+year);
		System.out.println("Month value :"+month);
		System.out.println("date value :"+date);
		System.out.println("dayOfWeek :"+dayOfWeek);
		System.out.println("dayOfWeek :"+weekOfMonth);
		
		Calendar currentCal = Calendar.getInstance();
		
		int currentMonth = currentCal.get(Calendar.MONTH);
		
		int count;
		if (month != currentMonth - 1) {
			if (month < currentMonth)
				month = month + 12;

			count = month - currentMonth;
			
			departElement.click();
			
			for (int i = 0; i < count; i++) {
				driver.findElement(By.xpath("//a[contains(@class,'ui-datepicker-next')]")).click();
				Thread.sleep(2000L);
			}

			int rowValue = (date / 7) + 1;

			driver.findElement(By.xpath("//div[contains(@class,'ui-datepicker-group-first')]/table/tbody/tr["
					+ weekOfMonth + "]/td[" + dayOfWeek + "]/a")).click();
		}
		else
		{
			System.out.println("you can choose only 11 months ahead as the depart date");
		}
		/*Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(30000)).takeScreenshot(driver);
		ImageIO.write(fpScreenshot.getImage(),"PNG",new File("/screenshots/file"+Calendar.getInstance().getTimeInMillis()+".png"));
		*/
		
	}
}
