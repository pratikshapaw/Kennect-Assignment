package com.kennect.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	@FindBy(xpath="//*[@name='email']")
	private WebElement email;
	
	@FindBy(xpath="//*[@name='password']")
	private WebElement password;
	
	@FindBy(xpath="//*[text()='Login']")
	private WebElement loginBtn;

	@FindBy(xpath="//*[@class='MuiAlert-message']")
	private WebElement errorMessage;

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	public void login(String username, String pWd)
	{
		email.sendKeys(username);
		password.sendKeys(pWd);
		loginBtn.click();
	}
	
	public WebElement isErrorMsgDisplayed()
	{
		return errorMessage;
	}

}
