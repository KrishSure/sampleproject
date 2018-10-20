package org.maven.project.sampleproject.selenium.pages;

import org.maven.project.sampleproject.selenium.Utility.FunctionLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GmailLogoutPage {
	
	WebDriver driver;
	FunctionLibrary fl;

	public GmailLogoutPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		fl = new FunctionLibrary(driver);
	}
	
	@FindBy(id="profileIdentifier")
	private WebElement profileId;
	
	public void clickOnProfileId() {
		fl.clickOnElement(profileId);
	}
	
	@FindBy(how=How.XPATH, using="//button[text()='Remove an account']")
	private WebElement removeAnAccount;

	public void clickOnRemoveAnAccount() {
		//removeAnAccount.click();
		fl.clickOnElement(removeAnAccount);
	}
	
	@FindBy(how=How.XPATH, using="//div[@class='k6Zj8d asG8Cb']")
	private WebElement deleteIcon;

	public void clickOnDeleteIcon() {
		//removeAnAccount.click();
		fl.clickOnElement(deleteIcon);
	}
	
	@FindBy(how=How.XPATH, using="//*[text()='Yes, remove']")
	private WebElement confirmPopupYesButton;
	
	public void clickONConfirmPopupYesButton() {
		fl.clickOnElement(confirmPopupYesButton);
	}
	
	public GmailLoginPage removeAccountFromGmailList() {
		clickOnProfileId();
		clickOnRemoveAnAccount();
		clickOnDeleteIcon();
		clickONConfirmPopupYesButton();
		return new GmailLoginPage(driver);	
	}
}
