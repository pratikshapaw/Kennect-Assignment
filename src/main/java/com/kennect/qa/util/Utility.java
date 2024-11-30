package com.kennect.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.utility.RandomString;

public class Utility {
	
	public static void impliciteWait(WebDriver driver, int time)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}
	
	public static void expliciteWait(WebDriver driver, int time,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static String  readConfigProp(String propName) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream("src\\main\\java\\com\\kennect\\qa\\config\\config.properties");
		prop.load(file);
		return prop.getProperty(propName);
	}

	public static void takeScreenshot(String FileName,  WebDriver driver) throws IOException
	{
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String random=RandomString.make(3);
		File dest=new File("\\Screenshot"+FileName+random+".png");
		FileHandler.copy(source, dest);
	}


}
