package org.maven.project.sampleproject.selenium.pages;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FacebookLoginPage {
	
	@FindBy(name="email")
	private WebElement emailTextField;
	
	public void enterValueForEmailTextField(String emailValue) {
		emailTextField.clear();
		emailTextField.sendKeys(emailValue);
	}
	
	@FindBy(id="pass")
	private WebElement passwordTextField;
	
	public void enterValueForpasswordTextField(String passwordValue) {
		passwordTextField.clear();
		passwordTextField.sendKeys(passwordValue);
	}
	
	@FindBy(xpath="//label[@id='loginbutton']/child::input")
	private WebElement loginButton;
	
	public void clickOnLoginButton() {
		loginButton.click();
	}		
}
