package com.selenium.PageObjectModel;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.selenium.BaseTest;

public class PageClass1 extends BaseTest
{
	
	AutomationLoginPage page=null;
	
	@BeforeTest
	public void startprocess() throws Exception
	{
		init();
		launch("chromebrowser");
		navigate("automationurl");
	}
	
	@Test
	public void loginTest()
	{
		page=new AutomationLoginPage(driver);
		page.customerLogin();
		Assert.assertEquals(page.verifyError(), "Authentication failed.");
		
	}

}
