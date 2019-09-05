package com.selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest 
{
	public static WebDriver driver;
	//public static String datapath="./data.properties";
	public static String projectPath=System.getProperty("user.dir");
	public static String datapath=projectPath+"//data.properties";
	public static String amazonorpath=projectPath+"//amazonor.properties";
	public static String log4jpath=projectPath+"//log4j.properties";
	public static Properties dataload=null;
	public static Properties amazonload=null;
	
	//Extent Report Initilizer
	public static ExtentReports report = ExtentManager.getInstance();
	public static ExtentTest test;
	
	
	public static void init() throws Exception
	{
		FileInputStream fis=new FileInputStream(datapath);
		dataload=new Properties();
		dataload.load(fis);
		
		FileInputStream fis1=new FileInputStream(amazonorpath);
		amazonload=new Properties();
		amazonload.load(fis1);
		
		
		FileInputStream fis2=new FileInputStream(log4jpath);
		PropertyConfigurator.configure(fis2);
		
		
		System.out.println("data file got loaded......");
	}
	
	public static void launch(String browser)
	{
		if(dataload.get(browser).equals("chrome")) 
		{
			
			//drivers initialization
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\Drivers\\chromedriver.exe");
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
			System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, System.getProperty("user.dir")+"//drivers//chromedriver.exe");
			
			//Logs clearing
			System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "null");
			
			//Chrome Profile creation
			ChromeOptions option=new ChromeOptions();
			option.addArguments("user-data-dir=C:\\Users\\DELL\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 6");
			
			option.addArguments("--disable-notifications");
			option.addArguments("--disable-infobars");
			option.addArguments("--start-maximized");
			
			//Proxy IP Configuration
			//option.addArguments("--proxy-server=http://192.168.90.84:1234");
			
			driver=new ChromeDriver(option);
		}
		else if(dataload.get(browser).equals("firefox")) 
		{
			//drivers initialization
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//drivers//geckodriver.exe");
			
			//logs removing in console
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "C:\\Users\\DELL\\Desktop\\Drivers\\logs\\ff.txt");
			
			FirefoxOptions option=new FirefoxOptions();
			
			ProfilesIni p=new ProfilesIni();
			FirefoxProfile profile = p.getProfile("p1");
			
			//notifications
			profile.setPreference("dom.webnotifications.enabled", false);
			
			
			//proxy servers
			/*profile.setPreference("network.proxy.type", 1);
			profile.setPreference("network.proxy.socks", "192.168.90.54");
			profile.setPreference("network.proxy.socks_port", 1744);*/
			
			option.setProfile(profile);
			
			//Opening Firefox Browser
			driver=new FirefoxDriver(option);
		}
		else if(dataload.get(browser).equals("edge")) 
		{
			System.setProperty(EdgeDriverService.EDGE_DRIVER_EXE_PROPERTY, System.getProperty("user.dir")+"//drivers//MicrosoftWebDriver.exe");
			
			//logs
			System.setProperty(EdgeDriverService.EDGE_DRIVER_EXE_PROPERTY, "null");
			
			driver=new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("ie")) 
		{
			//logs
			System.setProperty(InternetExplorerDriverService.IE_DRIVER_LOGFILE_PROPERTY, "D:\\IE.log");
			
			InternetExplorerOptions option=new InternetExplorerOptions();
			
			//proxy servers
			DesiredCapabilities cap=new DesiredCapabilities();
			
			String proxy="80.200.90.81:4444";
			Proxy p =new Proxy();
			p.setAutodetect(false);
			p.setProxyType(p.getProxyType());
			p.setSocksProxy(proxy);
			cap.setCapability(CapabilityType.PROXY, p);
			option.merge(cap);
			
			driver=new InternetExplorerDriver(option);
		}
		else 
		{
			System.out.println("Given browser is not matched.....");
		}
		
	}
	
	
	public static void navigate(String url) 
	{
		//driver.get(dataload.getProperty(url));
		driver.navigate().to(dataload.getProperty(url));
		driver.manage().window().maximize();
	}
	
	
	public static void clickObject(String locatorKey)
	{
		//driver.findElement(By.xpath(amazonload.getProperty(locatorKey))).click();
		getElement(locatorKey).click();
	}

	public static void typeText(String locatorKey, String value) 
	{
		//driver.findElement(By.name(amazonload.getProperty(locatorKey))).sendKeys(value);
		getElement(locatorKey).sendKeys(value);
	}

	public static void selectOption(String locatorKey, String option)
	{
		//driver.findElement(By.id(amazonload.getProperty(locatorKey))).sendKeys(option);
		getElement(locatorKey).sendKeys(option);
		
	}

	public static WebElement getElement(String locatorKey)
	{
		WebElement element=null;
		
		if(locatorKey.endsWith("_id")) {
			element=driver.findElement(By.id(amazonload.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_name")) {
			element=driver.findElement(By.name(amazonload.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_classname")) {
			element=driver.findElement(By.className(amazonload.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_xpath")) {
			element=driver.findElement(By.xpath(amazonload.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_css")) {
			element=driver.findElement(By.cssSelector(amazonload.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_linktext")) {
			element=driver.findElement(By.linkText(amazonload.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_partiallinktext")) {
			element=driver.findElement(By.partialLinkText(amazonload.getProperty(locatorKey)));
		}
		return element;
		
	}
	
	
	
	//******************** Verification Methods ****************************
	
	public static boolean verifyTitle(String expectedTitle) 
	{
		String actualTitle = driver.getTitle();
		if(actualTitle.equals(amazonload.getProperty(expectedTitle)))
			return true;
		else
			return false;
	}
	
	
	
	//******************** Reporting Methods ****************************
	
	
	public static void reportSuccess(String passedStatus) 
	{
		test.log(LogStatus.PASS, passedStatus);
	}

	public static void reportFailure(String FailedStatus) 
	{
		test.log(LogStatus.FAIL, FailedStatus);
		takeScreenshot();
	}

	public static void takeScreenshot() 
	{
		Date dt=new Date();
		String screenshotFileName = dt.toString().replace(":", "_").replace(" ", "_")+".png";
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try 
		{
			FileHandler.copy(scrFile, new File(projectPath+"//failure//"+screenshotFileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//put screen shot file in extent reports
		test.log(LogStatus.INFO, "Screenshot --> "+ test.addScreenCapture(projectPath+"//failure//"+screenshotFileName));
		
	}
	
	
	
	

}
