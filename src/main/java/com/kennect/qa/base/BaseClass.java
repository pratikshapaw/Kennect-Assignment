package com.kennect.qa.base;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

import com.kennect.qa.util.Utility;

import net.bytebuddy.utility.RandomString;

public class BaseClass {
	public static WebDriver driver;
	static ChromeOptions opt;

	public static void launchBrowser() throws IOException
	{
		opt=new ChromeOptions();
		opt.addArguments("incognito");
		opt.addArguments("start-maximized");
		String bName=Utility.readConfigProp("browserName");
		if(bName.equalsIgnoreCase("chrome"))
		{
			
			Reporter.log("launching chromeBrowser", true);
			 driver=new ChromeDriver(opt);
			
		}
		else if(bName.equalsIgnoreCase("firefox"))
		{
			Reporter.log("launching FireFoxBrowser", true);
		     driver=new FirefoxDriver();
		}
		
		driver.get(Utility.readConfigProp("url"));
		Utility.impliciteWait(driver, 5);
			
	}
	

	public static void closeBrowser()
	{
		driver.quit();
	}
	
}
