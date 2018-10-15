package org.maven.project.sampleproject.selenium.pages;

import org.maven.project.sampleproject.selenium.Utility.FunctionLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailLoginPage {
	
	public GmailLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		fl = new FunctionLibrary(driver);
	}

	WebDriver driver;
	
	FunctionLibrary fl;
	
	
	@FindBy(how=How.ID, using="identifierId")
	private WebElement emailOrPhoneField;
	
	public void setEmailOrPhoneField(CharSequence... keysToSend) {
		//emailOrPhoneField.sendKeys(keysToSend);
		fl.setValue(emailOrPhoneField, keysToSend);
	}

	@FindBy(how=How.ID, using="identifierNext")
	private WebElement emailNextButton;
	
	public void clickOnEmailNextButton() {
		//emailNextButton.click();
		fl.clickOnElement(emailNextButton);
	}

	@FindBy(how=How.NAME, using="password")
	private WebElement passwordField;
	
	public void setPasswordField(CharSequence... keysToSend) {
		/*WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(passwordField));
		passwordField.sendKeys(keysToSend);*/		
		fl.setValue(passwordField, keysToSend);
	}

	public GmailHomePage clickOnPasswordNextButton() {
		
		//passwordNextButton.click();
		fl.clickOnElement(passwordNextButton);
		
		return new GmailHomePage(driver);
	}

	@FindBy(how=How.ID, using="passwordNext")
	private WebElement passwordNextButton;
	
	public String gmailLogin(String username, String password) {
		
		setEmailOrPhoneField(username);
		
		clickOnEmailNextButton();
		
		setPasswordField(password);
		
		GmailHomePage ghp = clickOnPasswordNextButton();
		
		ghp.clickOngoogleAccountIcon();
		
		String emailName = ghp.getTextOfemailDisplayElement();
		
		return emailName;
	}
	
	
}
