package org.maven.project.sampleproject.selenium.pages;

import java.util.List;

import org.maven.project.sampleproject.selenium.Utility.FunctionLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
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
	
	@FindBy(how=How.LINK_TEXT, using="Sign out")
	private WebElement signOutLink;
	
	public GmailLogoutPage clickOnSingOutLink() {
		//signOutLink.click();
		
		fl.clickOnElement(signOutLink);
		
		//GmailLogoutPage glp = new GmailLogoutPage(driver);
		
		//return glp;
		
		return new GmailLogoutPage(driver);
	}
	
	@FindBy(how=How.XPATH, using="//div[text()='Recipients']//parent::div")
	private WebElement recipientsElem;
	
	public void clickOnRecipientsElem() {
		fl.clickOnElement(recipientsElem);
	}
	
	@FindBy(how=How.LINK_TEXT, using="Sent")
	private WebElement sentLink;
	
	public void clickOnSentLink() {
		fl.clickOnElement(sentLink);
	}
	
	@FindBy(how=How.XPATH, using="//span[text()='Message sent.']")
	private WebElement messageSentInfo;
	
	public boolean displayOfmessageSentInfo() {
		return fl.checkingVisibiliy(messageSentInfo).isDisplayed();
	}
	
	@FindBys(@FindBy(how=How.XPATH, using="//span[contains(text(),'Test Mail')]"))
	private List<WebElement> emailSubjects;
	
	public boolean verifyEmailSubject(String value) {
		boolean bflag=false;
		for(WebElement subject: emailSubjects) {
			if(subject.getText().equals(value)) {
				bflag = true;
				break;
			}
		}
		return bflag;
	}
	
	public boolean verifyEmailSubject(String value,String subjectData) {
		List<WebElement> emailSubjects1 = driver.findElements(By.xpath("//span[contains(text(),'"+subjectData+"')]"));	
		boolean bflag=false;
		for(WebElement subject: emailSubjects1) {
			fl.checkingVisibiliy(subject);
			if(subject.getText().equals(value)) {
				bflag = true;
				break;
			}
		}
		return bflag;
	}
	
	
	
}
