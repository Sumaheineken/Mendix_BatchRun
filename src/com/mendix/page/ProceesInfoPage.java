package com.mendix.page;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.mendix.tool.Button;
import com.mendix.tool.Constants;
import com.mendix.tool.Sync;
import com.mendix.tool.Textbox;
import com.mendix.util.ExcelUtil;
import com.mendix.util.ResultUtil;
import com.relevantcodes.extentreports.LogStatus;

public class ProceesInfoPage {

	/** The driver. */
	WebDriver driver;

	/**
	 * Instantiates a new process Info page.
	 *
	 * @param driver the driver
	 */
	public ProceesInfoPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}


	public ProceesInfoPage(String  state)
    {
        state = this.state;
    }
	
	public static String state= null;
    
//    		{ get; private set;}

//	@FindBy(how=How.CSS, using="div[id^='mxui_widget_NumberInput_'][class^='mx-name-textBox2'] :nth-child(1)")
	//@FindBy(how=How.XPATH, using="//*[text()='Request ID']/../../td/div/input")
	@FindBy(how=How.XPATH, using="//span[contains(text(),'Request ID')]/following::input[1]")
	WebElement txtboxRequestId;

	@FindBy(how=How.XPATH, using=".//*[@class='glyphicon glyphicon-search']")
	WebElement btnReqIdSearch;

	@FindBy(how=How.XPATH, using="//a[contains(text(),'Process Information')]")
	WebElement menuProcessInfo;

	@FindBy(how=How.XPATH, using="(//*[starts-with(text(),' Process Search')])[1]")
	WebElement menuProcessInfoSearch;

	@FindBy(how=How.CSS, using=".btn.btn-primary")
	WebElement btnMsgReqIdOk;

	@FindBy(how=How.XPATH, using="//*[@class='glyphicon glyphicon-refresh']")
	WebElement btnReqIDClear;

	@FindBy(how=How.XPATH, using="(//*[text()='State'])[2]/../../../../../../table[2]//td[9]")
	WebElement txtStatus;

	@FindBy(how=How.XPATH, using="(//*[@class='mx-dateinput-input-wrapper'])[1]")
	WebElement txtboxRequestedDate;
	
	@FindBy(how=How.XPATH, using="//*[@class='form-control mx-dateinput-input']")
	WebElement txtBoxRequestedStrtDate; 
	
	
	
	/**
	 * Enter UserName.
	 * Enter Password
	 * 
	 * Click Login
	 *
	 * @param strMenuName the str menu name
	 * @return 
	 * @return true, if successful
	 */


	public boolean reqIdSearch(String strValue) throws InterruptedException, FileNotFoundException, IOException {

		driver.switchTo().window("Application");
		Sync.waitForSeconds(Constants.WAIT_3);
		Sync.waitForObject(driver, "Wait for Request Id", txtboxRequestId);
		Textbox.click("Click Request Id Text Box", txtboxRequestId);
		Textbox.clear("Clear Request Id Text Box", txtboxRequestId);
		Textbox.enterValue("Enter Request Id", txtboxRequestId, strValue);
		Sync.waitForSeconds(Constants.WAIT_10);
		return Button.click("Click Request Id Search Button", btnReqIdSearch);
	}
	public void reqIdSearch_Global(String strValue) throws InterruptedException, FileNotFoundException, IOException {

//		driver.switchTo().window("Application");
		Sync.waitForSeconds(Constants.WAIT_3);
		Sync.waitForObject(driver, "Wait for Request Id", txtboxRequestId);
/*		Wait<WebDriver> Wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(100))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);

		Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver arg0) {
				WebElement element = arg0.findElement(By.cssSelector("div[id^='mxui_widget_NumberInput_'][class^='mx-name-textBox2'] :nth-child(1)"));

				if (element.isDisplayed()) {
					return true;
				}
				return false;
			}
		};

		Wait.until(function);*/
		Sync.waitForSeconds(Constants.WAIT_6);
		Textbox.click("Click Request Id Text Box", txtboxRequestId);
		Sync.waitForSeconds(Constants.WAIT_5);
		Textbox.enterValue("Enter Request Id", txtboxRequestId, strValue);
		
		Sync.waitForSeconds(Constants.WAIT_10);
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		//get current date time with Date()
		Date date = new Date();

		// Now format the date
		String dateFormatted= dateFormat.format(date);
		Textbox.enterValue("Enter TextBox Value", txtBoxRequestedStrtDate, dateFormatted);

/*		driver.findElement(By.xpath("(.//*[@class='btn mx-button mx-dateinput-select-button'])[1]")).click();
		driver.findElement(By.xpath(".//*[@aria-selected='true']/span")).click();
		Sync.waitForSeconds(Constants.WAIT_5);*/
		driver.findElement(By.xpath(".//*[@class='glyphicon glyphicon-search']")).click();
         Thread.sleep(2000);
	}

	public void reqIdSearch_Local(String strValue) throws InterruptedException, FileNotFoundException, IOException {

		driver.switchTo().window("Application");
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForObject(driver, "Wait for Request Id", txtboxRequestId);
		Wait<WebDriver> Wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(100))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);

		Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver arg0) {
				WebElement element = arg0.findElement(By.cssSelector("div[id^='mxui_widget_NumberInput_'][class^='mx-name-textBox2'] :nth-child(1)"));

				if (element.isDisplayed()) {
					return true;
				}
				return false;
			}
		};

		Wait.until(function);
		Sync.waitForSeconds(Constants.WAIT_6);
		Textbox.click("Click Request Id Text Box", txtboxRequestId);
		Sync.waitForSeconds(Constants.WAIT_1);
		Textbox.enterValue("Enter Request Id", txtboxRequestId, strValue);
		Sync.waitForSeconds(Constants.WAIT_2);
		Sync.waitForSeconds(Constants.WAIT_2);
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		//get current date time with Date()
		Date date = new Date();

		// Now format the date
		String dateFormatted= dateFormat.format(date);
		Textbox.enterValue("Enter TextBox Value", txtBoxRequestedStrtDate, dateFormatted);
		/*driver.findElement(By.xpath("(.//*[@class='btn mx-button mx-dateinput-select-button'])[1]")).click();
		driver.findElement(By.xpath(".//*[@aria-selected='true']/span")).click();*/
		Sync.waitForSeconds(Constants.WAIT_5);
		driver.findElement(By.xpath(".//*[@class='glyphicon glyphicon-search']")).click();
	}

	public boolean processInfoSearch() throws InterruptedException {
		
       
		WebDriverWait wait = new WebDriverWait(driver,160);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Process Information')]")));
		
		//WebElement el = driver.findElement(By.xpath("//a[contains(text(),'Process Information')]"));
		//((JavascriptExecutor)driver).executeScript("arguments[0].click()", el);

		Sync.waitForObjectFluent(driver, menuProcessInfo);
		Button.jsclick("Click the Process Info Menu", menuProcessInfo, driver);

		Sync.waitForSeconds(Constants.WAIT_5);
		//Sync.waitForSeconds(Constants.WAIT_5);
		
		return Button.jsclick("Click the Procees info search menu", menuProcessInfoSearch, driver);
	}

	public void getState(String strValue) throws InterruptedException{
		Sync.waitForSeconds(Constants.WAIT_6);
		Sync.waitForSeconds(Constants.WAIT_3);
//		Sync.waitForObject(driver, "Wait for the status to display", txtStatus);
//		String state=driver.findElement(By.xpath(".//*[text()='"+strValue+"']/../../td[9]/div")).getText();
//		System.out.println(state);
		List<WebElement> states= driver.findElements(By.xpath(".//div[contains(@class,'searchResults')]/div[3]/div/table[2]/tbody/tr/td[10]"));
		for(WebElement state:states) {
			System.out.println("Request Id status details "+state.getText());						
		}
//		ExcelUtil.setCellData("MDM", "Level2", 2, state);
	}

	public String getState_New(String strValue){
		Sync.waitForSeconds(Constants.WAIT_6);
		Sync.waitForSeconds(Constants.WAIT_3);
		Sync.waitForObject(driver, "Wait for the status to display", txtStatus);
		state=driver.findElement(By.xpath(".//*[text()='"+strValue+"']/../../td[9]/div")).getText();
//		String status=driver.findElement(By.xpath("//*[text()='Task status']/../../../../../../../table[2]/tbody/tr[1]/td[10]/div" )).getText();
//		if(status.equalsIgnoreCase("Submitted")) {
		
			
			Sync.waitForSeconds(Constants.WAIT_3);
//		}
//		else {

			System.out.println(state);
			Sync.waitForSeconds(Constants.WAIT_5);
			
//		}
		movedata(state);
		return state;
		
		
	}
	/*public void requestCreated_between(){
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		//get current date time with Date()
		Date date = new Date();

		// Now format the date
		String dateFormatted= dateFormat.format(date);
		
		Textbox.enterValue("Enter TextBox Value", txtboxRequestedDatebetween, dateFormatted);
	}*/
	/*public void browserClose() {

		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_5);
		driver.close();
		driver.quit();
	}*/
	
	public String movedata(String state){
	    return this.state;
	}
	
	public String ValidateStateLDR(String strValue){
		
		String state=driver.findElement(By.xpath(".//*[text()='"+strValue+"']/../../td[9]/div")).getText();
		
		Assert.assertEquals(state, "LDR");
		
		return state;
	}

	public String ValidateStateDiscarded(String strValue){
		
		String state=driver.findElement(By.xpath(".//*[text()='"+strValue+"']/../../td[9]/div")).getText();
		
		Assert.assertEquals(state, "Discarded");
		
		return state;
	}
	
	public String ValidateStateGBDA(String strValue){
		
		String state=driver.findElement(By.xpath(".//*[text()='"+strValue+"']/../../td[9]/div")).getText();
		
		Assert.assertEquals(state, "GDA");
		
		return state;
	}
	public void browserClose() {
		Sync.waitForSeconds(Constants.WAIT_2);
		Sync.waitForSeconds(Constants.SCRIPT_WAIT_TIME);
		driver.close();
		driver.quit();
		
	}
	public void validateGetTask_Status(String strValue){
		Sync.waitForSeconds(Constants.WAIT_10);
		String stateOne=driver.findElement(By.xpath("(.//*[text()='"+strValue+"']/../../td[9]/div)[2]")).getText();
		//String taskStatus=driver.findElement(By.xpath("(.//*[text()='"+strValue+"']/../../td[10]/div)[2]")).getText();
		Assert.assertEquals(stateOne, "LDR","Staus is LDR");
		if(!("LDR".equalsIgnoreCase(stateOne))){			
		   ResultUtil.reporter.log(LogStatus.FAIL,"The State is"+stateOne);	
		   System.out.println("Canot Proceed Futher");
		}	
		else {
			ResultUtil.reporter.log(LogStatus.PASS,"The State is"+stateOne);
			System.out.println(stateOne);
			
		}
		
		Sync.waitForSeconds(Constants.WAIT_10);		
		
	}

	
	
	


}
