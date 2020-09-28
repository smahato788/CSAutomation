package com.customerserveillance.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PageManager {
	
	private WebDriver driver;
	protected String browserFlag;
	
	public PageManager(WebDriver driverRemote, String browser) {
		driver = driverRemote;
		browserFlag = browser;
		PageFactory.initElements(driver, this);
	}
	
	public void navigate(String url) {
		try {
			driver.navigate().to(url);
				
		} catch (Exception exception) {
			//exceptionPrintError(exception,null);
		} 
	}
	
	public String getTitle() {
		String t = null;
		try {
			t = driver.getTitle();
			//test.log(Status.PASS, "Page Title is " + t);
		} catch (Exception exception) {
			//exceptionPrintError(exception,null);
		} 
		return t;
	}
	
	public void click(WebElement element) {
		try {
			element.click();
			//test.log(Status.PASS, "Click " + element + " | " + element.getText().toString());
		} catch (Exception exception) {
			//exceptionPrintError(exception,element);
		} 
	}
	
	public void sendKeys(WebElement element, String keys) {
		try {
		
			element.clear();
			element.sendKeys(keys);

			//test.log(Status.PASS, "Send " + keys + " to " + element + " | " + element.toString());
		} catch (Exception exception) {
			//exceptionPrintError(exception,element);
		} 
	}
	
	public String getText(WebElement element) {
		String t = null;
		try {
			t = element.getText();
			//test.log(Status.PASS, "Get Text " + t + " of " + element.toString());
		} catch (Exception exception) {
			//exceptionPrintError(exception,element);
		} 
		return t;
	}

	public WebDriver getDriver() {
		// TODO Auto-generated method stub
		WebDriver driver = null;
		try {
			driver = this.driver;
			//test.log(Status.PASS, "WebDriver instance is created");
		} catch (Exception exception) {
			//exceptionPrintError(exception,null);
		} 
		return driver;
	}
	
	
}