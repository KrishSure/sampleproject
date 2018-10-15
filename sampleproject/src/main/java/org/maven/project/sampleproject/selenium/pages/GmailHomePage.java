package org.maven.project.sampleproject.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GmailHomePage {
	WebDriver driver;
	public GmailHomePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.XPATH, using="//span[@class='gb_9a gbii']")
	private WebElement googleAccountIcon;
	
	public void clickOngoogleAccountIcon() {
		googleAccountIcon.click();
	}
	
	@FindBy(how=How.CLASS_NAME, using="gb_Eb")
	private WebElement emailDisplayElement;
	
	public String getTextOfemailDisplayElement() {
		return emailDisplayElement.getText();
	}
	
}
