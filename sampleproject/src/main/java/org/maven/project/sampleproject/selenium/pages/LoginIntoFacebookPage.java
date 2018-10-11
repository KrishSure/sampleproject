package org.maven.project.sampleproject.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginIntoFacebookPage {
	
	@FindBy(xpath="//div[@class='_4rbf _53ij']")
	private WebElement errorMessage;
	
	public String getErrorMessageText() {
		return errorMessage.getText();
	}
}
