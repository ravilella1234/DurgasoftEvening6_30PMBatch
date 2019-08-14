package com.selenium;

import com.relevantcodes.extentreports.LogStatus;

public class TC_004 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		test=report.startTest("TC_004");
		
		init();
		test.log(LogStatus.INFO, "Loading the Configuration files....");
		
		launch("chromebrowser");
		test.log(LogStatus.INFO, "Launching the browser :" + dataload.getProperty("chromebrowser"));
		
		navigate("amazonurl");
		test.log(LogStatus.INFO, "Navigating to url : "+ dataload.getProperty("amazonurl"));
		
		selectOption("amazonproductdropdown_id","Books");
		test.log(LogStatus.INFO, "Selected the value Books By using the locator : - "  + amazonload.getProperty("amazonproductdropdown_id"));
		
		typeText("amazonsearchtext_id","harrypotter");
		test.log(LogStatus.INFO, "Entered the text Harrypotter by using the locator : -" + amazonload.getProperty("amazonsearchtext_id"));
		
		clickObject("amazonsearchbutton_xpath");
		test.log(LogStatus.INFO, "Clicked on Search Button By using Locator  : " + amazonload.getProperty("amazonsearchbutton_xpath"));

		report.endTest(test);
		report.flush();
	}

}
