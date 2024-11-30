package com.kennect.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kennect.qa.base.BaseClass;

public class HomePage extends BaseClass{

	@FindBy(xpath="//*[@class='MuiContainer-root MuiContainer-maxWidthLg']")
	private WebElement todoList;

	@FindBy(xpath="(//*[@class='MuiButtonBase-root MuiListItem-root MuiListItem-gutters MuiListItem-button MuiListItem-secondaryAction']/parent::li)[7]")
	private WebElement testCostCalculator ;
	
	@FindBy(xpath="//*[ @id='patient-test']")
	private WebElement addPatientTest;
	
	@FindBy(xpath="//*[@class='MuiSelect-root MuiSelect-select MuiSelect-selectMenu MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input']")
	private WebElement discountTxtBox;

	@FindBy(xpath="//*[@class='MuiBox-root jss73']")
	private WebElement subTotal;
	
	@FindBy(xpath = "//*[@class='MuiBox-root jss76']")
	private WebElement total;
	
	@FindBy(xpath = "//*[@class='MuiListItemText-root']/child::span[text()='Tests']")
	private WebElement tests;
	
	Actions act;
	public HomePage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
		act=new Actions(driver);
	}


	public boolean isHomepageDisplyed()
	{
		return todoList.isDisplayed();
	}
	
	public void testCostCalculator() throws InterruptedException
	{
		act.scrollToElement(addPatientTest).build().perform();
		addPatientTest.click();
		addPatientTest.sendKeys("AFP (ALPHA FETO PROTEINS)");	
		
		act.moveByOffset(305, 169).click(testCostCalculator).build().perform();
		 act.scrollToElement(discountTxtBox).build().perform();
		discountTxtBox.click();
		List<WebElement> discountList = driver.findElements(By.xpath("//*[@class='MuiList-root MuiMenu-list MuiList-padding']/li"));
		for(  WebElement discounts:discountList)
		{
			String discount = discounts.getText();
			if(discount.equals("5%"))
			{
				discounts.click();
				break;
			}
		}
	}
	
	public TestsPage clickOnTests()
	{
		tests.click();
		return new TestsPage(driver);
	}
	
	
	
}
