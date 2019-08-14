package com.selenium;

import org.apache.log4j.Logger;

public class TC_003 extends BaseTest
{

	private static final Logger log=Logger.getLogger(TC_003.class.getName());
	
	public static void main(String[] args) throws Exception 
	{
		init();
		log.info("Loading the Configuration files....");
		
		launch("chromebrowser");
		log.info("Launching the browser :" + dataload.getProperty("chromebrowser"));
		
		navigate("amazonurl");
		log.info("Navigating to url : "+ dataload.getProperty("amazonurl"));
		
		selectOption("amazonproductdropdown_id","Books");
		log.info("Selected the value Books By using the locator : - "  + amazonload.getProperty("amazonproductdropdown_id"));
		
		typeText("amazonsearchtext_id","harrypotter");
		log.info("Entered the text Harrypotter by using the locator : -" + amazonload.getProperty("amazonsearchtext_id"));
		
		clickObject("amazonsearchbutton_xpath");
		log.info("Clicked on Search Button By using Locator  : " + amazonload.getProperty("amazonsearchbutton_xpath") );
	
	}
}
