package com.customerserveillance.util;

import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.remote.server.handler.Status;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
public class TestCaseBase {
	
	private String testName;
	//protected String className;
	//protected String userStoryName;
	//protected String buildNumber;
	protected PageManager pageManager;
    private WebDriver driver_original;
	protected String browserFlag;
	public String onGrid;
	public String host;
	public String port;
	public static int ieCountCurrent = 0;
	public static int firefoxCountCurrent = 0;
	public static int chromeCountCurrent = 0;
	public static int safariCountCurrent = 0;
	//private LogWebdriverEventListner eventListener;
	protected Log log = LogFactory.getLog(this.getClass());
	protected EventFiringWebDriver driver;
	//public String clientEmail; 
	public String actualResult;
	//public HashMap<String, String> expected;
	public CustomAssertion customAssertion;
	//private final String description = " This is a simple test from complex factory";
	protected static String errorImagesPath=System.getProperty("user.dir") + "/errorimages"; 
	protected File errorImageFolder;
//	protected String[] mailIds;
//	protected String mailAddress; 
	protected String xmlFilesPath=System.getProperty("user.dir") + "/testdata/xmlfiles";
	//protected File xmlFileFolder;
		
	
	@Parameters({ "browserFlagO"})
	@BeforeClass(alwaysRun = true)
	public void setUpBrowser(@Optional("chrome") String browserFlagO) throws Exception 
	{
		log.info("running TEST Case:" + this.getClass().getName());
		browserFlag = browserFlagO;
		selectBrowser();
		//eventListener = new LogWebdriverEventListner();
		driver = new EventFiringWebDriver(driver_original);
		//driver.register(eventListener);
		if (browserFlag.equals("ie") || browserFlag.equals("chrome") || browserFlag.equals("firefox") || browserFlag.equals("safari"))
			driver.manage().window().maximize();
		setDefaultTestData();
	}
	
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(Method caller) {
		String[] classes = caller.getDeclaringClass().getName().split("\\.");
		//className = classes[classes.length - 1];
		//userStoryName = classes[classes.length - 2];
		//testName = browserFlag + "-" + className + "-" + caller.getName();
		//test = ComplexReportFactory.getTest(testName, className, description);
		//test.log(Status.PASS, "Test Started!");
		customAssertion = new CustomAssertion(driver);
		pageManager = new PageManager(driver, browserFlag);
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod(Method caller) {
		//ComplexReportFactory.closeTest(testName);
		//log.info(test.getRunStatus());
		//Assert.assertSame(ComplexReportFactory.getTest(testName).getRunStatus(),  Status.PASS);  
		//Assert.assertEquals(ComplexReportFactory.getTest(testName).getRunStatus(), Status.PASS);

	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		
		//driver.quit();

	}
	private void setDefaultTestData() {
		// TODO Auto-generated method stub
		
	}
	private void selectBrowser() {
		// TODO Auto-generated method stub
		if (browserFlag.equals("ie")) {
			setUpIEWin64(onGrid);
		} else if (browserFlag.equals("firefox")) {
			setUpFirefoxWithDefaultProfile(onGrid);
		} else if (browserFlag.equals("chrome")) {
			setUpChromeWin32(onGrid);
		} else if (browserFlag.equals("safari")) {
			setUpSafari(onGrid);
		} 
		}
	private void setUpSafari(String onGrid2) {
		// TODO Auto-generated method stub
		driver_original = new SafariDriver();
	}
	private void setUpChromeWin32(String onGrid2) {
		// TODO Auto-generated method stub
		File file = new File("./lib/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        //WebDriverManager.chromedriver().setup();
		driver_original = new ChromeDriver();
	}
	private void setUpFirefoxWithDefaultProfile(String onGrid2) {
		// TODO Auto-generated method stub
		File file = new File("./lib/geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
		driver_original = new FirefoxDriver();
	}
	private void setUpIEWin64(String onGrid2) {
		// TODO Auto-generated method stub
		File file = new File("./lib/IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		driver_original = new InternetExplorerDriver();
	}
	
	
}