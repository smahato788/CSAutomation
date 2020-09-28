package com.customerserveillance.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class CustomAssertion 
{
	//private Log log = LogFactory.getLog(this.getClass());
	private WebDriver driver;
	//private ExtentTest test;
	String currentPath = ".\\test-output\\errorImages";
	String returnPath = ".\\errorImages";
	
	public CustomAssertion(WebDriver d) 
	{
		driver = d;
		//test = extentTest;
	}
	
	public boolean assertEquals(String actual, String expected) throws IOException 
	{
		try 
		{
			Assert.assertEquals(actual, expected);
			//test.log(Status.PASS, "actual: " + actual + " expected: " + expected);
			return true;
		} catch (AssertionError e) 
		{
			String path = snapshot((TakesScreenshot) driver);
			//printError(e, path);
			return false;
		}
	}
	
	public String snapshot(TakesScreenshot drivername) 
	{
		File scrFile = drivername.getScreenshotAs(OutputType.FILE);
		String dt = getDatetime();
		try 
		{
			System.out.println("save snapshot path is:" + currentPath + "\\" + dt + ".png");
			FileUtils.copyFile(scrFile, new File(currentPath + "\\" + dt + ".png"));
			FileUtils.copyFile(scrFile, new File(returnPath + "\\" + dt + ".png"));
		} catch (IOException e) {
			System.out.println("Can't save screenshot");
			return "";
		} finally {
			System.out.println("screen shot finished, it's in " + currentPath + " folder");
			return returnPath + "\\" + dt + ".png";
		}
	}

	public String getDatetime() 
	{
		SimpleDateFormat date = new SimpleDateFormat("yyyymmdd_hhmmss");
		return date.format(new Date());
	}

	/*public void printError(AssertionError e, String message, String path) 
	{
		//log.info(path);
		String[] paths = path.split("/");
		String imageName = paths[paths.length - 1];
		try 
		{
			test.log(Status.FAIL, message + e + "Screencast below: ");
			//ScreenCapture screenCapture = new ScreenCapture();
			//test.addScreenCaptureFromPath(path);
		} catch (IOException e1) 
		{
			e1.printStackTrace();
		}
	}

	public void printError(AssertionError e, String path) 
	{
		try 
		{
			test.log(Status.FAIL, "\n" + e + "\n Screencast below: " + test.addScreenCaptureFromPath(path));
		} catch (IOException e1) 
		{
			e1.printStackTrace();
		}
	}*/
}