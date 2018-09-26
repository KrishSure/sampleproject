package org.maven.project.sampleproject.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebElementsExamples {

	public static WebDriver driver;

	public static void main(String args[]) {

		System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");

		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.facebook.com/");

		String zender = "Female";

		System.out.println("//label[contains(text(),'"+zender+"')]/preceding-sibling::input");

		driver.findElement(By.xpath("//label[contains(text(),'"+zender+"')]/preceding-sibling::input")).click();

		radioButtonDemoOnJQuery();
	}


	public static void radioButtonDemoOnJQuery() {

		driver.navigate().to("http://jqueryui.com/checkboxradio/");

		driver.switchTo().frame(0);

		String cityName = "London";


		/*System.out.println("//label[contains(text(),'"+cityName+"')]/following-sibling::input");

		driver.findElement(By.xpath("//label[contains(text(),'\"+cityName+\"')]/following-sibling::input")).click();
		 */

		List<WebElement> radioButtonNames = driver.findElements(By.xpath("//label[contains(@class,'ui-checkboxradio-label')]"));
		
		String name;
		
		for(int i=0; i<radioButtonNames.size();i++) {
		
			name = radioButtonNames.get(i).getText();
			
			System.out.println(name);

			if(name.equals(cityName))
				radioButtonNames.get(i).click();
		}
	}
}
