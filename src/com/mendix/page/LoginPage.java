package com.mendix.page;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.mendix.tool.Button;
import com.mendix.tool.Constants;
import com.mendix.tool.Sync;
import com.mendix.tool.Textbox;
import com.mendix.util.DataProviderUtil.staticProviderClass;

public class LoginPage {

	
	WebDriver driver;

	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	@FindBy(how=How.XPATH, using=".//*[@id='logonuidfield']")
	WebElement txtUsername;

	/** The btn search. */
	@FindBy(how=How.XPATH, using=".//*[@id='logonpassfield']")
	WebElement txtPassword;

	/** The btn open. */
	@FindBy(how=How.XPATH, using=".//*[@id='logonForm']/table/tbody/tr[5]/td[2]/input")
	WebElement btnLogin;

		@Test(dataProvider="HeiPort_Login",dataProviderClass=staticProviderClass.class)
	public boolean login(String strUsername,String strPassword){		

		Sync.waitForObject(driver, "Username", txtUsername);		
		Textbox.click("Username", txtUsername);
		Textbox.click("Password", txtPassword);
		Textbox.enterValue("Username", txtUsername, strUsername);
		Textbox.enterValue("Password", txtPassword, strPassword);
		return Button.click("Login", btnLogin);
		 
	}
	
	@Test(dataProvider="HeiPort_Login",dataProviderClass=staticProviderClass.class)
	public boolean login_Vendor(String strUsername,String strPassword){		

		Sync.waitForObject(driver, "Username", txtUsername);		
		Textbox.click("Username", txtUsername);
		Textbox.click("Password", txtPassword);
		Textbox.enterValue("Username", txtUsername, strUsername);
		Textbox.enterValue("Password", txtPassword, strPassword);
		return Button.click("Login", btnLogin);
		 
	}
	
	public static void tasKill() throws IOException {
		Runtime.getRuntime().exec("taskkill /T /F /IM IEDriverServer.exe");
		Runtime.getRuntime().exec("taskkill /T /F /IM UFT.exe");
		Runtime.getRuntime().exec("cmd /c taskkill /f /im excel.exe");
	}
	@Test(dataProvider="HeiPort_Login",dataProviderClass=staticProviderClass.class)
	public boolean Login_as_LDR_Vendor_direct_environment(String strUsername,String strPassword) {
		//WebDriverWait wait = new WebDriverWait(driver,30);
		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("usernameInput"))));
		Textbox.click("Username", txtUsername);
		Textbox.click("Password", txtPassword);
		Textbox.enterValue("Username", txtUsername, strUsername);
		Textbox.enterValue("Password", txtPassword, strPassword);
		return Button.click("Login", btnLogin);
	}
	
	
}
