package org.maven.project.sampleproject.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FacebookLoggedInPage {
	
	@FindBy(id="userNavigationLabel")
	private WebElement navigationIcon;
	
	public void clickOnNavigationIcon() {
		navigationIcon.click();
	}
	
	public boolean isNavigationIconDisplayed() {
		return navigationIcon.isDisplayed();
	}
	
	@FindBy(xpath="//ul/li/a/span/span[text()='Log Out']")
	private WebElement logoutButton;
	
	public void clickOnLogoutButton() {
		logoutButton.click();
	}

}
