package com.kennect.qa.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.kennect.qa.base.BaseClass;
import com.kennect.qa.pages.HomePage;
import com.kennect.qa.pages.LoginPage;
import com.kennect.qa.util.Utility;

public class HomePageTest extends BaseClass{
	
	LoginPage loginpage;
	HomePage homepage;

	@BeforeClass
	public void openingBrowser() throws Throwable
	{	
		launchBrowser();
		loginpage=new LoginPage(driver);
		homepage = new HomePage(driver);

	}

	@Test(priority = 1)
	public void validateTestCostCalculator() throws InterruptedException, IOException
	{
		loginpage.login(Utility.readConfigProp("username"), Utility.readConfigProp("password"));
		homepage.testCostCalculator();
	}

}
