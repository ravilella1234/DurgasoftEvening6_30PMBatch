package com.selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriverService;

public class BaseTest 
{
	public static WebDriver driver;
	//public static String datapath="./data.properties";
	public static String datapath=System.getProperty("user.dir")+"//data.properties";
	public static Properties dataload=null;
	
	
	public static void init() throws Exception
	{
		FileInputStream fis=new FileInputStream(datapath);
		dataload=new Properties();
		dataload.load(fis);
		System.out.println("data file got loaded......");
	}
	
	public static void launch(String browser)
	{
		if(dataload.get(browser).equals("chrome")) 
		{
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\Drivers\\chromedriver.exe");
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
			System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, System.getProperty("user.dir")+"//drivers//chromedriver.exe");
			driver=new ChromeDriver();
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
			
			option.setProfile(profile);
			
			//Opening Firefox Browser
			driver=new FirefoxDriver(option);
		}
		else if(dataload.get(browser).equals("edge")) 
		{
			System.setProperty(EdgeDriverService.EDGE_DRIVER_EXE_PROPERTY, System.getProperty("user.dir")+"//drivers//MicrosoftWebDriver.exe");
			driver=new EdgeDriver();
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

}
