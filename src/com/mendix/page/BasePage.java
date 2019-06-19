package com.mendix.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.mendix.tool.Sync;

public class BasePage {
	
	WebDriver driver;

	public BasePage(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void waitForPageLoad() {
		try {
		Sync.waitUntilObjectDisappears(driver, "Wait for Location Code Select",
				By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		} catch(NoSuchElementException | TimeoutException ex) {
		   
		}
		
	}
	

}
