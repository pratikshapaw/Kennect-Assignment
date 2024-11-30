package com.kennect.qa.test;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.kennect.qa.base.BaseClass;
import com.kennect.qa.pages.HomePage;
import com.kennect.qa.pages.LoginPage;
import com.kennect.qa.util.Utility;

public class LoginTest extends BaseClass {
	LoginPage loginpage;
	HomePage homepage;

	@BeforeClass
	public void openingBrowser() throws Throwable
	{	
		launchBrowser();
		loginpage=new LoginPage(driver);

	}

	@Test(priority = 1)
	public void validLogin() throws InterruptedException, IOException
	{
		loginpage.login(Utility.readConfigProp("username"), Utility.readConfigProp("password"));
		homepage = new HomePage(driver);
		 Assert.assertTrue(homepage.isHomepageDisplyed(), "Home page should be displayed after login.");
	}

	@Test(priority = 2,enabled = false)
	public void invalidLogin() throws InterruptedException, IOException
	{
		
		loginpage.login(Utility.readConfigProp("invalidusername"), Utility.readConfigProp("invalidpassword"));
		WebElement errormessage = loginpage.isErrorMsgDisplayed();

		Assert.assertTrue(errormessage.isDisplayed(), "There is no user record corresponding to this identifier. The user may have been deleted.");

	}

	@AfterMethod
	public void logout() throws InterruptedException
	{

		Thread.sleep(2000);
		driver.close();
	}
	@AfterClass
	public void tearDown() throws InterruptedException
	{
		closeBrowser();
		Thread.sleep(3000);
	}



}
