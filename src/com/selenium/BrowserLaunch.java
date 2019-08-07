package com.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserLaunch 
{

	public static void main(String[] args) 
	{
		WebDriver driver;
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\Latest Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in");
		
		
		driver=new FirefoxDriver();
		driver.get("https://www.flipkart.com");
		
		
		driver=new EdgeDriver();
		driver.get("https://www.ebay.com");
		
	}

}
