package com.kennect.qa.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.kennect.qa.base.BaseClass;

public class PatientsPage extends BaseClass{

	@FindBy(xpath="//*[@class='MuiInputBase-input MuiOutlinedInput-input' and @name='name']")
	private WebElement patientName;
	
	@FindBy(xpath="//*[@class='MuiInputBase-input MuiOutlinedInput-input' and @name='email']")
	private WebElement patientEmail;
	
	@FindBy(xpath="//*[@name='phone']")
	private WebElement mobileNo;
	
	@FindBy(xpath="//*[text()='General Details']/parent::button")
	private WebElement generalDetails;
	
	@FindBy(xpath="//*[@name='height']")
	private WebElement height;
	
	@FindBy(xpath="//*[@name='weight']")
	private WebElement weight;
	
	@FindBy(xpath="//*[@id='mui-component-select-gender']")
	private WebElement gender;
	
//	@FindBy(xpath="//*[@class='MuiList-root MuiMenu-list MuiList-padding']/li")
//	private WebElement genderList;
	
	@FindBy(xpath="//*[@class='MuiInputBase-input MuiOutlinedInput-input' and @name='age']")
	private WebElement age;
	
	@FindBy(xpath="//*[@class='MuiInputBase-input MuiOutlinedInput-input' and @name='systolic']")
	private WebElement systolicBP;
	
	@FindBy(xpath="//*[@class='MuiInputBase-input MuiOutlinedInput-input' and @name='diastolic']")
	private WebElement diastolicBP;
	
	@FindBy(xpath="//*[@class='MuiButtonBase-root MuiButton-root jss98 MuiButton-contained MuiButton-containedPrimary']")
	private WebElement addTestsBtn;
	
	@FindBy(xpath="//*[@id='patient-test']")
	private WebElement addPatientTest;
	
	@FindBy(xpath="//*[@class='MuiFormControl-root']//div[@class='MuiSelect-root MuiSelect-select MuiSelect-selectMenu MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input']")
	private WebElement discountTxtBox;
	
	@FindBy(xpath="//*[text()='5%']")
	private WebElement discount;
	
	@FindBy(xpath="//*[@id='patient-tests-labs']")
	private WebElement labTxtBox;
	
	@FindBy(xpath="//*[@name='doctor_name']")
	private WebElement doctorTxtBox;
	
	@FindBy(xpath="//*[@id='mui-component-select-doctor_commission']")
	private WebElement doctorsCommissionTxtBox;
	
	@FindBy(xpath = "//*[@class='material-icons MuiIcon-root' and text()='add_box']")
	private WebElement addEquipmentBtn;
	
	@FindBy(xpath = "//*[@class='MuiSelect-root MuiSelect-select MuiSelect-selectMenu MuiInputBase-input MuiInput-input']")
	private WebElement Equipmentdropdown;
	
	@FindBy(xpath = "//*[text()='check']")
	private WebElement saveEquipment;
	
	@FindBy(xpath = "//*[@class='MuiButtonBase-root MuiButton-root jss98 MuiButton-contained MuiButton-containedPrimary']")
	private WebElement addPatientBtn;
	
	@FindBy(xpath = "//*[@class='MuiContainer-root MuiContainer-maxWidthLg']")
	private WebElement testDashboard;
	
	public PatientsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void addPatientTest() throws InterruptedException
	{
		patientName.click();
		patientName.sendKeys("jon");
		
		patientEmail.click();
		patientEmail.sendKeys("jon@gmail.com");
		
		mobileNo.click();
		mobileNo.sendKeys("6666666666");
		
		generalDetails.click();
		
		height.click();
		height.clear();
		height.sendKeys("145");
		
		weight.click();
		weight.clear();
		weight.sendKeys("45");
		
		gender.click();
		
		List<WebElement> genderlist = driver.findElements(By.xpath("//*[@class='MuiList-root MuiMenu-list MuiList-padding']/li"));
		for(WebElement gender:genderlist)
		{
			 String genders = gender.getText();
			if(genders.equals("Male"))
			{
				gender.click();
			}
		}
		
		age.click();
		age.clear();
		age.sendKeys("24");
		
		systolicBP.click();
		systolicBP.clear();
		systolicBP.sendKeys("120");
		
		diastolicBP.click();
		diastolicBP.clear();
		diastolicBP.sendKeys("90");
		
		Actions act =new Actions(driver);
		act.scrollToElement(addTestsBtn).build().perform();
		addTestsBtn.click();
		
		addPatientTest.click();
		addPatientTest.sendKeys("AFP (ALPHA FETO PROTEINS)");	
		
		act.moveByOffset(315, 330).click(discountTxtBox).build().perform();
		
		discountTxtBox.click();
		List<WebElement> discountList = driver.findElements(By.xpath("//*[@class='MuiList-root MuiMenu-list MuiList-padding']/li"));
		for(  WebElement discounts:discountList)
		{
			String discount = discounts.getText();
			if(discount.equals("5%"))
			{
				discounts.click();
			}
		}
		
		labTxtBox.click();
		labTxtBox.sendKeys("HEALTHCARE PATHOLOGY");
		act.moveByOffset(315, 330).click(doctorTxtBox).build().perform();
		
		doctorTxtBox.click();
		doctorTxtBox.sendKeys("kiran");
		act.sendKeys(Keys.ENTER).build().perform();
		act.scrollToElement(addPatientBtn).build().perform();
		doctorsCommissionTxtBox.click();
		
		List<WebElement> commissionList = driver.findElements(By.xpath("//*[@class='MuiList-root MuiMenu-list MuiList-padding']/li"));
	
		for(  WebElement commissions:commissionList)
		{
			String commission = commissions.getText();
			if(commission.equals("10%"))
			{
				commissions.click();
			}
		}
		
		addEquipmentBtn.click();
		addEquipmentBtn.click();
		Equipmentdropdown.click();
		
		List<WebElement> equipmentList = driver.findElements(By.xpath("//*[@class='MuiList-root MuiMenu-list MuiList-padding']/li"));

		for(  WebElement equipments:equipmentList)
		{
			String equipment = equipments.getText();
			if(equipment.equals("injection"))
			{
				equipments.click();
			}
		}
		
		saveEquipment.click();
		addPatientBtn.click();
	}
	
	public boolean isTestsPageDisplayed()
	{
		return testDashboard.isDisplayed();
	}
}
