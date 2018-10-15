package org.maven.project.sampleproject.selenium.pages;

import org.maven.project.sampleproject.selenium.Utility.FunctionLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailHomePage {
	WebDriver driver;
	FunctionLibrary fl;
	public GmailHomePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		fl = new FunctionLibrary(driver);
	}

	@FindBy(how=How.XPATH, using="//span[@class='gb_9a gbii']")
	private WebElement googleAccountIcon;
	
	public void clickOngoogleAccountIcon() {
		//googleAccountIcon.click();
		fl.clickOnElement(googleAccountIcon);
	}
	
	@FindBy(how=How.CLASS_NAME, using="gb_Eb")
	private WebElement emailDisplayElement;
	
	public String getTextOfemailDisplayElement() {
		//return emailDisplayElement.getText();
		return fl.getTextforElement(emailDisplayElement);
	}
	
	@FindBy(how=How.XPATH, using="//div[@role='button'][text()='Compose']")
	private WebElement composeButton;
	
	public void clickOnComposeButton() {
		/*WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(composeButton));
		composeButton.click();*/
		
		fl.clickOnElement(composeButton);
	}
	
	@FindBy(how=How.NAME, using="to")
	private WebElement toReceipents;
	
	public void setToReceipents(CharSequence... keysToSend) {
		/*toReceipents.clear();
		toReceipents.sendKeys(keysToSend);*/
		
		fl.setValue(toReceipents, keysToSend);
	}

	@FindBy(how=How.NAME, using="subjectbox")
	private WebElement subject;
	
	public void setSubject(CharSequence... keysToSend) {
		/*subject.clear();
		subject.sendKeys(keysToSend);*/
		fl.setValue(subject, keysToSend);
	}
	
	@FindBy(how=How.XPATH, using="//div[@aria-label='Message Body']")
	private WebElement messageBody;
	
	public void setMessageBody(CharSequence... keysToSend) {
		/*messageBody.clear();
		messageBody.sendKeys(keysToSend);*/
		
		fl.setValue(messageBody, keysToSend);
	}
	
	@FindBy(how=How.XPATH, using="//div[text()='Send']")
	private WebElement sendButton;
	
	public void clickOnSendButton() {
		//sendButton.click();
		
		fl.clickOnElement(sendButton);
	}
	
	@FindBy(how=How.LINK_TEXT, using="Sign Out")
	private WebElement signOutLink;
	
	public void clickOnSingOutLink() {
		//signOutLink.click();
		
		fl.clickOnElement(signOutLink);
	}
	
	
}
