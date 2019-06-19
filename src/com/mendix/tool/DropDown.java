package com.mendix.tool;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class DropDown {
	
	static WebDriver driver;
	
	public DropDown(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public static boolean verifyObject(WebElement element){
		  boolean isVerified= false;
		  try{
		   if(element.isDisplayed()){
		    isVerified = true;
		   }
		  }catch(Exception e){
		     }
		  return isVerified;
		 }

}
