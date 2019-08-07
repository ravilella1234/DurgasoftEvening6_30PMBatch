package com.selenium;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
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
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

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
		//driver.manage().window().maximize();
	}

}
