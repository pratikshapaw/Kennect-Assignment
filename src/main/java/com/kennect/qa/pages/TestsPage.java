package com.kennect.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestsPage {

	@FindBy(xpath="//*[@href='/patients/add']")
	private WebElement addPatientTest;
	
	public TestsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);	
	}
	
	public void clickOnAddPatientTest()
	{
		addPatientTest.click();
	
	}
}
