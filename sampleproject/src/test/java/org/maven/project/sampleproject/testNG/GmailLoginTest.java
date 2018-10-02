package org.maven.project.sampleproject.testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class GmailLoginTest {
	WebDriver driver;
	@Test
	public void gmailLogin() throws InterruptedException {
		System.out.println(" I am gmail Login Test method");

		driver.get("https://www.google.com/");

		driver.findElement(By.linkText("Gmail")).click();


		//driver.findElement(By.linkText("Sign In")).click();

		//driver.findElement(By.className("gmail-nav__nav-link gmail-nav__nav-link__sign-in")).click();

		driver.findElement(By.xpath("//a[@class='gmail-nav__nav-link gmail-nav__nav-link__sign-in']")).click();

		driver.findElement(By.id("identifierId")).sendKeys("seleniumjava75@gmail.com");

		driver.findElement(By.id("identifierNext")).click();

		Thread.sleep(500);

		driver.findElement(By.name("password")).sendKeys("Seleniumjava@75");

		driver.findElement(By.id("passwordNext")).click(); 

		driver.findElement(By.xpath("//span[@class='gb_9a gbii']")).click();

		//driver.findElement(By.xpath("//a[@id='gb_71']")).click();
		//driver.findElement(By.linkText("Sign out")).click();

		String emailAddress = driver.findElement(By.className("gb_Eb")).getText();

		assertEquals(emailAddress, "seleniumjava75@gmail.com");

	}

	@Test
	public void gmailLogout() throws InterruptedException {
		System.out.println(" I am gmail Logout Test method");

		driver.get("https://www.google.com/");

		driver.findElement(By.linkText("Gmail")).click();


		//driver.findElement(By.linkText("Sign In")).click();

		//driver.findElement(By.className("gmail-nav__nav-link gmail-nav__nav-link__sign-in")).click();

		driver.findElement(By.xpath("//a[@class='gmail-nav__nav-link gmail-nav__nav-link__sign-in']")).click();

		driver.findElement(By.id("identifierId")).sendKeys("seleniumjava75@gmail.com");

		driver.findElement(By.id("identifierNext")).click();

		Thread.sleep(500);

		driver.findElement(By.name("password")).sendKeys("Seleniumjava@75");

		driver.findElement(By.id("passwordNext")).click(); 

		driver.findElement(By.xpath("//span[@class='gb_9a gbii']")).click();

		//driver.findElement(By.xpath("//a[@id='gb_71']")).click();
		//driver.findElement(By.linkText("Sign out")).click();

		String emailAddress = driver.findElement(By.className("gb_Eb")).getText();

		assertEquals(emailAddress, "seleniumjava75@gmail.com");

		driver.findElement(By.linkText("Sign out")).click();

		driver.findElement(By.id("profileIdentifier")).click();

		Thread.sleep(5000);

		driver.findElement(By.className("q4UYxb")).click();

		Thread.sleep(5000);

		driver.findElement(By.xpath("//div[@class='vdE7Oc f3GIQ']/div[@class='k6Zj8d asG8Cb']/*[1]")).click();

	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println(" I am  before method");

		//System.setProperty("webdriver.gecko.driver", "D:\\Softwares\\selenium_info\\geckodriver-v0.22.0-win64\\geckodriver.exe");

		driver = new FirefoxDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println(" I am  after method");
		driver.close();
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println(" I am  before class");
		System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
	}

	@AfterClass
	public void afterClass() {
		System.out.println(" I am  after class");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println(" I am  before test");
	}

	@AfterTest
	public void afterTest() {
		System.out.println(" I am  after test");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println(" I am  before suite");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println(" I am  after suite");
	}

}
