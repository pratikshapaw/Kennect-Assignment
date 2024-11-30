package com.kennect.qa.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.kennect.qa.base.BaseClass;
import com.kennect.qa.pages.HomePage;
import com.kennect.qa.pages.LoginPage;
import com.kennect.qa.pages.PatientsPage;
import com.kennect.qa.pages.TestsPage;
import com.kennect.qa.util.Utility;

public class TestsTest extends BaseClass{
	
	LoginPage loginpage;
	PatientsPage patientspage;
	HomePage homepage;
	TestsPage testspage;
	@BeforeClass
	public void openingBrowser() throws Throwable
	{	
		launchBrowser();
		loginpage=new LoginPage(driver);
		patientspage=new PatientsPage(driver);
		homepage=new HomePage(driver);
		testspage=new TestsPage(driver);
	}

	@Test(priority = 1)
	public void validateTest() throws InterruptedException, IOException
	{
	    loginpage.login(Utility.readConfigProp("username"), Utility.readConfigProp("password"));
		homepage.clickOnTests();
		testspage.clickOnAddPatientTest();
		patientspage.addPatientTest();
		 Assert.assertTrue(patientspage.isTestsPageDisplayed(), "Tests page should be displayed after adding patient test .");
	}

}
