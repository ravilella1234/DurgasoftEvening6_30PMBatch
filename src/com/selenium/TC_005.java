package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

public class TC_005 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		init();
		
		launch("chromebrowser");
		
		navigate("amazonurl");
		
		/*String actualValue = driver.findElement(By.xpath("//a[contains(text(),'Customer Service')]")).getAttribute("innerHTML");
		String expectedValue="customer Service";
		
		System.out.println("Acctual link : " + actualValue);
		System.out.println("Expected Link :" + expectedValue);
		
		//if(actualValue.equals(expectedValue))
		//if(actualValue.equalsIgnoreCase(expectedValue))
		//if(actualValue.contains(expectedValue))
		if(actualValue.contentEquals(expectedValue))
			System.out.println("Both values are equal...");
		else
			System.out.println("Both values are not equal...");*/
		
		
		
		
		/*WebElement ele = driver.findElement(By.id("twotabsearchtextbox"));
		
		ele.sendKeys("sony");
		
		String val = ele.getAttribute("value");
		
		System.out.println("Given text is : " + val);*/
		
		
		
		String actualValue = driver.findElement(By.xpath("//a[contains(text(),'Customer Service')]")).getAttribute("innerHTML");
		String expectedValue="customer Service";
		
		System.out.println("Acctual link : " + actualValue);
		System.out.println("Expected Link :" + expectedValue);
		
		Assert.assertEquals(actualValue, expectedValue);
		Assert.assertTrue(actualValue.equals(expectedValue), "both links are not equal");
		
		
		
		SoftAssert s=new SoftAssert();
		s.assertEquals(actualValue, expectedValue);
		s.assertTrue(actualValue.equals(expectedValue), "both links are not equal");
		
		s.assertTrue(false, "error1");
		
		s.assertTrue(true, "error2");
		
		s.assertTrue(false, "error3");
		
		driver.findElement(By.xpath("//a[contains(text(),'Customer Service')]")).click();
		
		s.assertAll();
			
	}

}
