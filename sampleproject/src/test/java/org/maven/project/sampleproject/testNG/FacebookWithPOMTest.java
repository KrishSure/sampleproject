package org.maven.project.sampleproject.testNG;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.maven.project.sampleproject.selenium.pages.FacebookLoggedInPage;
import org.maven.project.sampleproject.selenium.pages.FacebookLoginPage;
import org.maven.project.sampleproject.selenium.pages.LoginIntoFacebookPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ org.maven.project.sampleproject.selenium.Utility.TestListener.class})
public class FacebookWithPOMTest {
	
	@Test
	public void f(ITestContext context) {
		WebDriver driver;

		System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");

		driver = new FirefoxDriver();
		//context.setAttribute("driver", driver);  
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Exersize
		driver.get("https://www.facebook.com/");

		//FacebookLoginPage flpObj = new FacebookLoginPage();
		context.setAttribute("driver", driver);
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

	@Test(description="Verify the facebook login with correct username and password")
	public void second(ITestContext context) {
		WebDriver driver;

		System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");

		ProfilesIni profile = new ProfilesIni();

		//FirefoxProfile fp = new FirefoxProfile();

		FirefoxProfile fp = profile.getProfile("selenium");

		fp.setPreference("dom.webnotifications.enabled", false);

		FirefoxOptions ffopt = new FirefoxOptions();
		ffopt.setProfile(fp);

		driver = new FirefoxDriver(ffopt);
		context.setAttribute("driver", driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Exersize
		driver.get("https://www.facebook.com/");

		driver.manage().deleteAllCookies();

		driver.navigate().refresh();

		//FacebookLoginPage flpObj = new FacebookLoginPage();

		FacebookLoginPage flpObj = PageFactory.initElements(driver, FacebookLoginPage.class);

		flpObj.enterValueForEmailTextField("dilipkumarpv8899@gmail.com");

		flpObj.enterValueForpasswordTextField("Dilip258963");

		flpObj.clickOnLoginButton();



		FacebookLoggedInPage flipObj = PageFactory.initElements(driver, FacebookLoggedInPage.class);

		assertTrue(flipObj.isNavigationIconDisplayed());

		flipObj.clickOnNavigationIcon();

		flipObj.clickOnLogoutButton();




		//Teardown
		driver.close();

	}
}
