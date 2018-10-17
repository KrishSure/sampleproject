package org.maven.project.sampleproject.selenium.pages;

import java.util.List;

import org.maven.project.sampleproject.selenium.Utility.FunctionLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
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
	
	public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
		return emailNextButton.getScreenshotAs(target);
	}

	public void click() {
		emailNextButton.click();
	}

	public void submit() {
		emailNextButton.submit();
	}

	public void sendKeys(CharSequence... keysToSend) {
		emailNextButton.sendKeys(keysToSend);
	}

	public void clear() {
		emailNextButton.clear();
	}

	public String getTagName() {
		return emailNextButton.getTagName();
	}

	public String getAttribute(String name) {
		return emailNextButton.getAttribute(name);
	}

	public boolean isSelected() {
		return emailNextButton.isSelected();
	}

	public boolean isEnabled() {
		return emailNextButton.isEnabled();
	}

	public String getText() {
		return emailNextButton.getText();
	}

	public List<WebElement> findElements(By by) {
		return emailNextButton.findElements(by);
	}

	public WebElement findElement(By by) {
		return emailNextButton.findElement(by);
	}

	public boolean isDisplayed() {
		return emailNextButton.isDisplayed();
	}

	public Point getLocation() {
		return emailNextButton.getLocation();
	}

	public Dimension getSize() {
		return emailNextButton.getSize();
	}

	public Rectangle getRect() {
		return emailNextButton.getRect();
	}

	public String getCssValue(String propertyName) {
		return emailNextButton.getCssValue(propertyName);
	}

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
