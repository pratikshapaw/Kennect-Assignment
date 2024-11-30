package com.kennect.qa.test;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.kennect.qa.base.BaseClass;
import com.kennect.qa.pages.HomePage;
import com.kennect.qa.pages.LoginPage;
import com.kennect.qa.pages.PatientsPage;
import com.kennect.qa.pages.TestsPage;
import com.kennect.qa.util.Utility;

public class PatientTest extends BaseClass{
	
	LoginPage loginpage;
	HomePage homepage;
	TestsPage testpage;
	PatientsPage patientspage;
	
	@BeforeClass
	public void openingBrowser() throws Throwable
	{	
		launchBrowser();
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		testpage=new TestsPage(driver);
		patientspage=new PatientsPage(driver);

	}
	
	@Test
	public void validatePatientTest() throws IOException, InterruptedException
	{
		loginpage.login(Utility.readConfigProp("username"), Utility.readConfigProp("password"));
		homepage.clickOnTests();
		testpage.clickOnAddPatientTest();
		patientspage.addPatientTest();
	}


}
