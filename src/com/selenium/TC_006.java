package com.selenium;

import com.relevantcodes.extentreports.LogStatus;

public class TC_006 extends BaseTest
{

	public static void main(String[] args) throws Exception
	{
		test=report.startTest("TC_006");
		
		init();
		test.log(LogStatus.INFO, "Loading the Configuration files....");
		
		launch("chromebrowser");
		test.log(LogStatus.INFO, "Launching the browser :" + dataload.getProperty("chromebrowser"));
		
		navigate("amazonurl");
		test.log(LogStatus.INFO, "Navigating to url : "+ dataload.getProperty("amazonurl"));
		
		if(!verifyTitle("amazonhomepagetitle"))
			reportFailure("Both titles are not equal..");
		else
			reportSuccess("Both titles are equal..");
		
		
		
		
		report.endTest(test);
		report.flush();

	}

}
