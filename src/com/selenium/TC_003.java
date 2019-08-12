package com.selenium;

public class TC_003 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		init();
		
		launch("chromebrowser");
		
		navigate("amazonurl");
		
		selectOption("amazonproductdropdown_id","Books");
		
		typeText("amazonsearchtext_id","harrypotter");
		
		clickObject("amazonsearchbutton_xpath");
	
	}
}
