package com.mendix.test;

import java.awt.AWTException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mendix.tool.Button;
import com.mendix.tool.Constants;
import com.mendix.tool.Sync;

public class SampleTest {

	private static WebDriver driver;

	public void Login_as_LDR_Vendor() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--disable-extensions");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://heiportacc.heiway.net:51900/irj/portal");
		waitForElementClickable(driver.findElement(By.id("logonuidfield")));
		driver.findElement(By.id("logonuidfield")).sendKeys("MDVM_BE01_LDR");
		driver.findElement(By.id("logonpassfield")).sendKeys("Heineken01");
		driver.findElement(By.xpath(".//*[@id='logonForm']/table/tbody/tr[5]/td[2]/input")).click();
		waitForElementPresent(driver.findElement(By.cssSelector("#anchor1")));
		mouseHoverJScript(driver.findElement(By.cssSelector("#anchor1")));
		driver.findElement(By.xpath("//a[text()='MDM Workflow']")).click();
		waitForSeconds(5);
	}

	public void fill_in_Questionnaire() throws Throwable {
		String mainWindowHandle = driver.getWindowHandle();
		for (String childWindowHandle : driver.getWindowHandles()) {
			if (!childWindowHandle.equals(mainWindowHandle)) {
				driver.switchTo().window(childWindowHandle);
			}
		}
		waitForElementPresent(driver.findElement(By.xpath("//a[contains(text(),'Vendors')]")));
		driver.manage().window().maximize();
		mouseHoverJScript(driver.findElement(By.xpath("//a[contains(text(),'Vendors')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Vendors')]")).click();
		driver.findElement(By.xpath("(//*[starts-with(text(),' Create')])[2]")).click();
		waitForElementPresent(driver.findElement(By.xpath("//span[contains(text(),'Y001, 3rd Party Vendor')]")));
		driver.findElement(By.xpath("//span[contains(text(),'Y001, 3rd Party Vendor')]")).click();
		waitForElementClickable(driver.findElement(By.xpath("//*[@class='glyphicon glyphicon-forward']")));
		driver.findElement(By.xpath("//*[@class='glyphicon glyphicon-forward']")).click();
	}

	public void fill_in_data() throws AWTException, InterruptedException {
		waitForElementPresent(driver.findElement(By.xpath("//*[text()='Local Data']")));
		driver.findElement(By.xpath("//*[text()='Local Data']")).click();
		driver.findElement(By.xpath(".//*[@class='glyphicon glyphicon-flash']")).click();
		driver.findElement(By.xpath("//*[text()='Disable Local Request']")).click();
		driver.findElement(By.xpath("//*[text()='Proceed']")).click();
		waitForSeconds(5);
		waitForElementClickable(driver.findElement(By.xpath("//a[contains(@class,'mx-name-tabPageBank')]")));
		driver.findElement(By.xpath("//a[contains(@class,'mx-name-tabPageBank')]")).click();
		waitForElementPresent(driver.findElement(By.xpath("//*[text()='Disable Bank Request']")));
		driver.findElement(By.xpath("//*[text()='Disable Bank Request']")).click();
		waitForElementPresent(driver.findElement(By.xpath("//*[text()='Proceed']")));
		driver.findElement(By.xpath("//*[text()='Proceed']")).click();
		waitForElementClickable(driver.findElement(By.xpath(".//*[text()='Name 1']/../div/input")));
		driver.findElement(By.xpath(".//*[text()='Name 1']/../div/input")).sendKeys("Automation Vendor");
		waitForElementClickable(driver.findElement(By.xpath(".//*[text()='Search Term 1']/../div/input")));
		driver.findElement(By.xpath(".//*[text()='Search Term 1']/../div/input")).click();
		waitForElementClickable(driver.findElement(By.xpath(".//*[text()='Street']/../div/input")));
		driver.findElement(By.xpath(".//*[text()='Street']/../div/input")).sendKeys("Hauptstrasse");
		driver.findElement(By.xpath(".//*[text()='House Number']/../div/input")).sendKeys("11");
		driver.findElement(By.xpath(".//*[text()='Postal Code']/../div/input")).sendKeys("2551");
		driver.findElement(By.xpath(".//*[text()='City']/../div/input")).sendKeys("Enzesfeld-Lindabrunn");
		selectByVisibleText(driver.findElement(By.xpath(".//*[text()='Country']/../div/div/select")), "AT, Austria");
		selectByVisibleText(driver.findElement(By.xpath(".//*[text()='Region']/../div/div/select")),
				"NOE, Lower Austria");
		selectByVisibleText(driver.findElement(By.xpath(".//*[text()='Language Key']/../div/div/select")),
				"EN, English");
		driver.findElement(By.xpath(".//*[text()='Credit Information Number']/../div/input")).sendKeys("301536819");
		selectByIndex(driver.findElement(By.xpath("//label[contains(text(),'Industry Key')]/following::select[1]")), 2);
		selectByIndex(driver.findElement(By.xpath("//label[contains(text(),'Corporate Group')]/following::select[1]")),
				2);
		waitForElementClickable(driver.findElement(By.xpath("//*[text()='Validate']")));
		driver.findElement(By.xpath("//*[text()='Validate']")).click();
		waitForSeconds(8);
	}

	public void save_as_draft() throws Throwable {
		driver.findElement(By.xpath("//*[text()='Save As Draft']")).click();
		waitForElementPresent(driver.findElement(By.xpath(".//*[@id='mxui_widget_DialogMessage_0']/div[1]/div[2]/p")));
		String reqId = driver.findElement(By.xpath(".//*[@id='mxui_widget_DialogMessage_0']/div[1]/div[2]/p"))
				.getText();
		driver.findElement(By.xpath("//*[text()='OK']")).click();
		driver.quit();
	}

	public void save_as_draft_request() throws Throwable {
		driver.findElement(By.xpath("//*[text()='close']")).click();
		waitForElementPresent(driver.findElement(By.xpath(".//*[@id='mxui_widget_DialogMessage_0']/div[1]/div[2]/p")));
		String reqId = driver.findElement(By.xpath(".//*[@id='mxui_widget_DialogMessage_0']/div[1]/div[2]/p"))
				.getText();
		driver.findElement(By.xpath("//*[text()='OK']")).click();
	}
	public void duplicateCheck_New() {
		try {
		// Sync.waitUntilObjectDisappears(driver, "Wait for Duplicate check", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
        Sync.waitForSeconds(Constants.WAIT_10);
       // Sync.waitForSeconds(Constants.WAIT_5);
		/*WebElement waitElement = null;
		FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
		.withTimeout(Duration.ofMinutes(3))
		.pollingEvery(Duration.ofSeconds(600))
		.ignoring(NoSuchElementException.class)
		.ignoring(TimeoutException.class);

		//First checking to see if the loading indicator is found
		// we catch and throw no exception here in case they aren't ignored
		try {
		waitElement = fwait.until(new Function<WebDriver, WebElement>() {
		public WebElement apply(WebDriver driver) {
		return driver.findElement(By.xpath(".//*[@id='mxui_widget_Progress_0']"));
		}
		});
		} catch (Exception e) {
		}

		//checking if loading indicator was found and if so we wait for it to
		//disappear
		if (waitElement != null) {
*/		WebDriverWait wait = new WebDriverWait(driver, 150);
        
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[text()='Open Record']")));
	    System.out.println("Clicked on Open Record");
		
		//}
	    
	    Sync.waitForSeconds(Constants.WAIT_10);
		driver.manage().window().setPosition(new Point(-2000, 0)) ;
		driver.findElement(By.xpath(".//*[text()='Open Record']")).sendKeys(Keys.TAB);
		Sync.waitForSeconds(Constants.WAIT_2);
		driver.findElement(By.xpath(".//*[text()='Extend Selected']")).sendKeys(Keys.TAB);
		Sync.waitForSeconds(Constants.WAIT_2);
		driver.findElement(By.xpath("//*[text()='Export to Excel']")).sendKeys(Keys.TAB);
		Sync.waitForSeconds(Constants.WAIT_2);
		driver.findElement(By.xpath("//*[text()='My record is not a duplicate! Submit.']")).sendKeys(Keys.RETURN);
		Sync.waitForSeconds(Constants.WAIT_2);
		driver.findElement(By.xpath("//*[text()='Proceed']")).click();
		Sync.waitForSeconds(Constants.WAIT_3);
		System.out.println("Clicked on proceed");
	 }
	catch(Exception e) {
		System.err.println(e.getMessage());


	}
} 
	
	
	
	@Test
	public void create_Material() {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--disable-extensions");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://heiportacc.heiway.net:51900/irj/portal");
		waitForElementClickable(driver.findElement(By.id("logonuidfield")));
		driver.findElement(By.id("logonuidfield")).sendKeys("MDMM_BE01_LDR");
		driver.findElement(By.id("logonpassfield")).sendKeys("Heineken01");
		driver.findElement(By.xpath(".//*[@id='logonForm']/table/tbody/tr[5]/td[2]/input")).click();
		waitForSeconds(5);
		waitForElementPresent(driver.findElement(By.cssSelector("#anchor1")));
		mouseHoverJScript(driver.findElement(By.cssSelector("#anchor1")));
		driver.findElement(By.xpath("//a[text()='MDM Workflow']")).click();
		waitForSeconds(5);
		
		String mainWindowHandl = driver.getWindowHandle();
		for (String childWindowHandle : driver.getWindowHandles()) {

			if (!childWindowHandle.equals(mainWindowHandl)) {
				driver.switchTo().window(childWindowHandle);
				waitForElementClickable(driver.findElement(By.xpath("//a[contains(text(),'Materials')]")));
				
			}
		}
		driver.manage().window().maximize();
		mouseHoverJScript(driver.findElement(By.xpath("//a[contains(text(),'Materials')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Materials')]")).click();
		driver.findElement(By.xpath("(//*[starts-with(text(),' Create')])[1]")).click();
		waitForElementClickable(driver.findElement(By.xpath("//*[@class='glyphicon glyphicon-forward']")));
		List<WebElement> listOfQuestionaries = driver.findElements(By.xpath("//*[text()='My material is a:']/../div/div/div"));
		for(WebElement questionarie : listOfQuestionaries)
		{
			String question = questionarie.getText();			
			if(question.equalsIgnoreCase("Production | Raw material, ingredient or processing aid"))
				{
				  waitForSeconds(10);
				   waitForElementClickable(driver.findElement(By.xpath("//*[text()='My material is a:']/../div/div/div[6]/label/input")));
				   
					driver.findElement(By.xpath("//*[text()='My material is a:']/../div/div/div[6]/label/input")).click();
				}
		} 
		driver.findElement(By.xpath("//*[@class='glyphicon glyphicon-forward']")).click();
		//Disable local data
		waitForElementClickable(driver.findElement(By.xpath("//*[text()='Local Data']")));
		driver.findElement(By.xpath("//*[text()='Local Data']")).click();
		driver.findElement(By.xpath(".//*[@class='mx-layoutcontainer-wrapper mx-scrollcontainer-wrapper']/div[2]/button/span")).click();
		driver.findElement(By.xpath("//*[text()='Disable Local Request']")).click();		
		driver.findElement(By.xpath("//*[text()='Proceed']")).click();
		//waitForSeconds(5);
		driver.findElement(By.xpath(".//*[@class='mx-layoutcontainer-wrapper mx-scrollcontainer-wrapper']/div[2]/button/span")).click();
		waitForSeconds(7);
		driver.findElement(By.xpath("(.//*[@class='glyphicon glyphicon-edit'])[1]")).click();
		waitForSeconds(5);
		driver.findElement(By.xpath(".//*[text()='Material Description per Language']/../../div[2]//*[text()='Description']/../div/input")).sendKeys("Create Material Description");
		waitForSeconds(5);
		driver.findElement(By.cssSelector("button[id^='mxui_widget_ActionButton'][class='btn mx-button mx-name-actionButton1 editableByCondition btn-success']")).click();
		waitForSeconds(10);
		waitForElementClickable(driver.findElement(By.xpath("//*[text()='Material Group']/../div/button/span")));
		driver.findElement(By.xpath("//*[text()='Material Group']/../div/button/span")).click();
		driver.findElement(By.xpath(".//*[@id='mxui_widget_SearchInput_0']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='mxui_widget_SearchInput_0']/div[2]/input")).sendKeys("CMG0472");
		driver.findElement(By.xpath("//button[text()='Search']")).click();
		driver.findElement(By.xpath("(//div[contains(text(),'CMG')]/../../../../../../table[2]/tbody/tr[1]/td/div)[1]")).click();
		driver.findElement(By.xpath("//button[text()='Select']")).click();
		
		driver.findElement(By.xpath("//*[text()='Gross Weight Base UoM']/../div/input")).click();
		driver.findElement(By.xpath("//*[text()='Gross Weight Base UoM']/../div/input")).sendKeys("400");
		
		waitForElementClickable(driver.findElement(By.xpath("//*[text()='Unit of Weight']/../div/button/span")));
		driver.findElement(By.xpath("//*[text()='Unit of Weight']/../div/button/span")).click();
		driver.findElement(By.xpath("//label[text()='Commercial Unit']/../../div[2]/input")).click();
		driver.findElement(By.xpath("//label[text()='Commercial Unit']/../../div[2]/input")).sendKeys("G");
		driver.findElement(By.xpath("//button[text()='Search']")).click();
		driver.findElement(By.xpath("//*[text()='G']")).click();
		driver.findElement(By.xpath("//button[text()='Select']")).click();
		
		waitForSeconds(20);
		JavascriptExecutor js;
		js = (JavascriptExecutor) driver;
		js.executeScript(
				"$(\".mx-layoutcontainer-wrapper.mx-scrollcontainer-wrapper\").animate({ scrollT: \"80px\" })");
		
		waitForElementClickable(driver.findElement(By.xpath("//*[text()='Base UoM']/../div/button/span")));
		driver.findElement(By.xpath("//*[text()='Base UoM']/../div/button/span")).click();
		driver.findElement(By.xpath("//label[text()='Commercial Unit']/../../div[2]/input")).click();
		driver.findElement(By.xpath("//label[text()='Commercial Unit']/../../div[2]/input")).sendKeys("G");
		driver.findElement(By.xpath("//button[text()='Search']")).click();
		driver.findElement(By.xpath("//*[text()='G']")).click();
		driver.findElement(By.xpath("//button[text()='Select']")).click();
		
		driver.findElement(By.xpath("//*[text()='Net Weight Base UoM']/../div/input")).click();
		driver.findElement(By.xpath("//*[text()='Net Weight Base UoM']/../div/input")).sendKeys("200");
		
		waitForSeconds(5);
		waitForElementClickable(driver.findElement(By.xpath("//*[text()='UoM - Primary']/../div[1]/div/select")));
		Select dropdownUOM = new Select(driver.findElement(By.xpath("//*[text()='UoM - Primary']/../div[1]/div/select")));
		dropdownUOM.selectByIndex(1);
		
		waitForElementClickable(driver.findElement(By.xpath(".//*[@class='mx-layoutcontainer-wrapper mx-scrollcontainer-wrapper']/div[2]/button/span")));
		
		driver.findElement(By.xpath(".//*[@class='mx-layoutcontainer-wrapper mx-scrollcontainer-wrapper']/div[2]/button/span")).click();
		waitForElementClickable(driver.findElement(By.xpath("//*[text()='Validate']")));
		
		driver.findElement(By.xpath("//*[text()='Validate']")).click();
		
		waitForElementClickable(driver.findElement(By.xpath("//span[@class='glyphicon glyphicon-copy']")));
		driver.findElement(By.xpath(".//span[@class='glyphicon glyphicon-copy']")).click();
		
		 if(driver.findElements(By.xpath(".//*[text()='Open Record']")).size()>0) 
	   	 {
	   		
	   		waitForSeconds(10);
	   		 this.duplicateCheck_New();
	   		

	   	 }
	   	 else if(Button.verifyObject(driver.findElement(By.xpath("/*[@class='close mx-dialog-close']"))))
	   	 {
	   		 Sync.waitForSeconds(Constants.WAIT_5);
	   		 Sync.waitForObject(driver, "Wait for the information PopUp", driver.findElement(By.xpath(".//*[@id='mxui_widget_DialogMessage_0']/div[1]/div[2]/p")));
	   		 driver.findElement(By.xpath("/*[@class='close mx-dialog-close']")).click();
	   		 

	 
	   	 }
	    		
		waitForElementClickable(driver.findElement(By.xpath(".//button[text()='Submit Global Request']")));
		driver.findElement(By.xpath(".//button[text()='Submit Global Request']")).click();
		waitForSeconds(10);
		String reqId = driver.findElement(By.cssSelector(".modal-body.mx-dialog-body>p")).getText();
		String[] parts = reqId.split(" ");
		String Id = parts[2];
		System.out.println(Id);
		String IdNum = Id.replaceAll("\\.", "");
		System.out.println("RequestId is: " + Id);
		
		
		waitForElementClickable(driver.findElement(By.xpath("//a[contains(text(),'Process Information')]")));
	    
	    driver.findElement(By.xpath("//a[contains(text(),'Process Information')]")).click();
	    driver.findElement(By.xpath("(//*[starts-with(text(),' Process Search')])[1]")).click();
	    
	    driver.findElement(By.cssSelector("div[id^='mxui_widget_NumberInput_'][class^='mx-name-textBox2'] :nth-child(1)")).click();
	    driver.findElement(By.cssSelector("div[id^='mxui_widget_NumberInput_'][class^='mx-name-textBox2'] :nth-child(1)")).sendKeys(IdNum);
	    
	    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    Date date = new Date();
	    String dateFormatted= dateFormat.format(date);
	    
	    driver.findElement(By.xpath("//*[@class='form-control mx-dateinput-input']")).sendKeys(dateFormatted);
	    //getting state
	    
	    driver.findElement(By.xpath(".//*[@class='glyphicon glyphicon-search']")).click();
	    List<WebElement> states= driver.findElements(By.xpath(".//div[contains(@class,'searchResults')]/div[3]/div/table[2]/tbody/tr/td[9]"));
		for(WebElement state:states) {
			System.out.println("Request Id status details "+state.getText());						
		}
		
		waitForSeconds(10);
		driver.close();
		this.closeSession();
		
		
		//Login with GDA
		/*System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--disable-extensions");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);*/
		driver.get("http://heiportacc.heiway.net:51900/irj/portal");
		waitForElementClickable(driver.findElement(By.id("logonuidfield")));
		driver.findElement(By.id("logonuidfield")).sendKeys("MDM_GDA");
		driver.findElement(By.id("logonpassfield")).sendKeys("Heineken01");
		driver.findElement(By.xpath(".//*[@id='logonForm']/table/tbody/tr[5]/td[2]/input")).click();
		waitForSeconds(5);
		waitForElementPresent(driver.findElement(By.cssSelector("#anchor1")));
		mouseHoverJScript(driver.findElement(By.cssSelector("#anchor1")));
		driver.findElement(By.xpath("//a[text()='MDM Workflow']")).click();
		waitForSeconds(5);
		
		
		for (String childWindowHandle : driver.getWindowHandles()) {

			if (!childWindowHandle.equals(mainWindowHandl)) {
				driver.switchTo().window(childWindowHandle);
				waitForElementClickable(driver.findElement(By.xpath("//a[contains(text(),'Materials')]")));
				
			}
		}
		driver.manage().window().maximize();
		
		//Click on My Tasks
		waitForSeconds(5);		
		waitForElementClickable(driver.findElement(By.xpath("//a[text()=' My Tasks']")));		
		
		driver.findElement(By.xpath(".//*[text()='Search']")).click();
		waitForSeconds(5);		
		waitForElementClickable(driver.findElement(By.xpath(".//*[text()='Search']")));	
		driver.findElement(By.xpath(".//*[text()='Search']")).click();
		
		waitForSeconds(5);		
		waitForElementClickable(driver.findElement(By.xpath("//label[text()='Request ID']/../../div[2]/input")));	
		
		driver.findElement(By.xpath("//label[text()='Request ID']/../../div[2]/input")).click();
		
		driver.findElement(By.xpath("//label[text()='Request ID']/../../div[2]/input")).sendKeys(IdNum);
		
		waitForSeconds(5);		
		waitForElementClickable(driver.findElement(By.xpath("(.//button[text()='Search'])[1]")));
		driver.findElement(By.xpath("(.//button[text()='Search'])[1]")).click();
		
		waitForSeconds(5);		
		waitForElementClickable(driver.findElement(By.xpath(".//*[@class='glyphicon glyphicon-flash']")));
		driver.findElement(By.xpath(".//*[@class='glyphicon glyphicon-flash']")).click();
		
		waitForSeconds(5);		
		waitForElementClickable(driver.findElement(By.xpath("//*[text()='Validate and Duplicate Check']")));
		driver.findElement(By.xpath("//*[text()='Validate and Duplicate Check']")).click();
		
		 if(driver.findElements(By.xpath(".//*[text()='Open Record']")).size()>0) 
	   	 {
	   		 System.out.println("Entered into the if loop");
	   		waitForSeconds(10);
	   		 this.duplicateCheck_New();
	   		

	   	 }
	   	 else if(Button.verifyObject(driver.findElement(By.xpath("/*[@class='close mx-dialog-close']"))))
	   	 {
	   		waitForSeconds(10);
	   		 Sync.waitForObject(driver, "Wait for the information PopUp", driver.findElement(By.xpath(".//*[@id='mxui_widget_DialogMessage_0']/div[1]/div[2]/p")));
	   		 driver.findElement(By.xpath("/*[@class='close mx-dialog-close']")).click(); 
	   	 }
		 
		 
		 waitForSeconds(10);
		 driver.findElement(By.xpath(".//button[text()='Approve Global Request']")).click();
		 waitForSeconds(10);
		 driver.findElement(By.xpath("/*[@class='close mx-dialog-close']")).click(); 
		 
		 waitForElementClickable(driver.findElement(By.xpath("//a[contains(text(),'Process Information')]")));
		    
		    driver.findElement(By.xpath("//a[contains(text(),'Process Information')]")).click();
		    driver.findElement(By.xpath("(//*[starts-with(text(),' Process Search')])[1]")).click();
		    
		    driver.findElement(By.cssSelector("div[id^='mxui_widget_NumberInput_'][class^='mx-name-textBox2'] :nth-child(1)")).click();
		    driver.findElement(By.cssSelector("div[id^='mxui_widget_NumberInput_'][class^='mx-name-textBox2'] :nth-child(1)")).sendKeys(IdNum);
		    
		   /* DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		    Date date = new Date();
		    String dateFormatted= dateFormat.format(date);*/
		    
		    driver.findElement(By.xpath("//*[@class='form-control mx-dateinput-input']")).sendKeys(dateFormatted);
		    //getting state
		    
		    driver.findElement(By.xpath(".//*[@class='glyphicon glyphicon-search']")).click();
		   /* String globalID = driver
					.findElement(
							By.xpath("//*[text()='Global ID']/../../../../../../table[2]/tbody[1]/tr[1]/td[2]/div")).getText();
		    
		    List<WebElement> states1= driver.findElements(By.xpath(".//div[contains(@class,'searchResults')]/div[3]/div/table[2]/tbody/tr/td[9]"));
			for(WebElement state:states1) {
				System.out.println("Request Id status details "+state.getText());
				SoftAssert assertSyndication = new SoftAssert();
				assertSyndication.assertEquals("Syndication",state.getText(), "Not changed to Syndication State");	
				if (state.equalsIgnoreCase("Syndication") || state.equalsIgnoreCase("Completed")) {
					System.out.println(state);
					String globalId = driver
							.findElement(
									By.xpath("//*[text()='Global ID']/../../../../../../table[2]/tbody[1]/tr[1]/td[2]/div"))
							.getText();
					System.out.println(globalId);
				}
			}
			
			*/
			
			waitForSeconds(10);
			driver.close();
			this.closeSession();
			
			/*//Login with LDR for Syndication checking
			driver.get("http://heiportacc.heiway.net:51900/irj/portal");
			waitForElementClickable(driver.findElement(By.id("logonuidfield")));
			driver.findElement(By.id("logonuidfield")).sendKeys("MDMM_BE01_LDR");
			driver.findElement(By.id("logonpassfield")).sendKeys("Heineken01");
			driver.findElement(By.xpath(".//*[@id='logonForm']/table/tbody/tr[5]/td[2]/input")).click();
			waitForSeconds(5);
			waitForElementPresent(driver.findElement(By.cssSelector("#anchor1")));
			mouseHoverJScript(driver.findElement(By.cssSelector("#anchor1")));
			driver.findElement(By.xpath("//a[text()='MDM Workflow']")).click();
			waitForSeconds(5);
			
		//	String mainWindowHandl = driver.getWindowHandle();
			for (String childWindowHandle : driver.getWindowHandles()) {

				if (!childWindowHandle.equals(mainWindowHandl)) {
					driver.switchTo().window(childWindowHandle);
					waitForElementClickable(driver.findElement(By.xpath("//a[contains(text(),'Materials')]")));
					
				}
			}
			driver.manage().window().maximize();
			
			waitForSeconds(10);
			waitForElementClickable(driver.findElement(By.xpath("//a[contains(text(),'Materials')]")));
			driver.findElement(By.xpath("//a[contains(text(),'Materials')]")).click();
			
			waitForSeconds(10);
			waitForElementClickable(driver.findElement(By.xpath("(//*[starts-with(text(),' Dashboard')])[1]")));
			driver.findElement(By.xpath("(//*[starts-with(text(),' Dashboard')])[1]")).click();
			
			driver.switchTo().window("Application");
			waitForSeconds(10);	
			waitForElementClickable(driver.findElement(By.xpath("//*[@class='glyphicon glyphicon-plus']")));
			driver.findElement(By.xpath("//*[@class='glyphicon glyphicon-plus']")).click();
			//Searching Global Id
			
			js.executeScript(
					"$(\".mx-layoutcontainer-wrapper.mx-scrollcontainer-wrapper\").animate({ scrollBottom: \"100px\" })");
			waitForSeconds(10);	
			waitForElementClickable(driver.findElement(By.xpath("//button[text()='Search']")));
			driver.findElement(By.xpath("//button[text()='Search']")).click();
			
			waitForSeconds(10);	
			waitForElementClickable(driver.findElement(By.xpath("//*[text()='Global ID']/../../td[4]/div/input")));
			driver.findElement(By.xpath("//*[text()='Global ID']/../../td[4]/div/input")).click();
			driver.findElement(By.xpath("//*[text()='Global ID']/../../td[4]/div/input")).sendKeys(golbalID);
			
			waitForSeconds(10);	
			waitForElementClickable(driver.findElement(By.xpath("//button[text()='Search']")));
			driver.findElement(By.xpath("//button[text()='Search']")).click();
*/			
			
			
			
			
			
			
			
			
			
			
			
			
			
			

			
			
			

		 
		 
		 
		 
		 
		 
		
		
		
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	    
	    		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

	public void closeSession() {
		driver.quit();
	}

	public static void waitForElementPresent(WebElement element) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.visibilityOf(element));

		} catch (TimeoutException e) {
			e.getMessage();
		}

	}

	public static void waitForElementClickable(WebElement element) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.elementToBeClickable(element));

		} catch (TimeoutException e) {
			e.getMessage();
		}
	}

	public static void mouseHoverJScript(WebElement element) {
		waitForElementPresent(element);
		String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
		((JavascriptExecutor) driver).executeScript(mouseOverScript, element);

	}

	public static void waitForSeconds(int ms) {
		try {
			Thread.sleep(ms * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void selectByValue(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByValue(value);
	}

	public static void selectByVisibleText(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByVisibleText(value);
	}

	public static void selectByIndex(WebElement element, int i) {
		Select object = new Select(element);
		object.selectByIndex(i);
	}

}
