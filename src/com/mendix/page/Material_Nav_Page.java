package com.mendix.page;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mendix.tool.Button;
import com.mendix.tool.Constants;
import com.mendix.tool.DropDown;
import com.mendix.tool.Sync;

public class Material_Nav_Page{

	/** The driver. */
	WebDriver driver;

	/**
	 * Instantiates a new home page changes
	 *
	 * @param driver
	 *            the driver
	 */
	public Material_Nav_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		//super(driver);
	}
	

	@FindBy(how = How.XPATH, using = "//*[text()='Local Data']")
	WebElement textLocalData;

	@FindBy(how = How.XPATH, using = "//*[text()='Global Data']")
	WebElement btnGlobalData;

	@FindBy(how = How.XPATH, using = "(.//*[@class='glyphicon glyphicon-edit'])[5]")
	WebElement BtnEditPlantData;

	@FindBy(how = How.XPATH, using = "(.//*[@class='glyphicon glyphicon-new-window'])[6]")
	WebElement BtnAddPlantData;

	
	@FindBy(how = How.XPATH, using = "//button[text()='Select']")
	WebElement BtnPlantSelect;

	@FindBy(how = How.XPATH, using = "(.//button[text()='Edit'])[1]")
	WebElement BtnPlantEdit;

	@FindBy(how = How.CSS, using = ".btn.btn-primary")
	WebElement btnMsgReqIdOk;

	@FindBy(how = How.XPATH, using = ".//*[text()='Validate Local Request']")
	WebElement btnValidateLocalRequest;

	@FindBy(how = How.XPATH, using = "//*[@class='btn mx-button mx-name-actionButton2 btn-default']")
	WebElement btnSelectAllOnPopUpPlants;

	@FindBy(how = How.XPATH, using = "//button[text()='Select all']")
	WebElement btnSelectAll;

	@FindBy(how = How.XPATH, using = "//*[@class='btn mx-button mx-name-actionButton5 btn-default']")
	WebElement btnSelectAllOnPopUpSalesOrg;

	@FindBy(how = How.XPATH, using = "//*[@class='btn mx-button mx-name-actionButton1 btn-success']")
	WebElement btnCreateRequestOnPopUp;

	@FindBy(how = How.XPATH, using = ".//*[contains(text(),'Rounding Precision')]/../div/div/select")
	WebElement dropdownPlantRoundingPrecisionValue;

	@FindBy(how = How.XPATH, using = ".//*[@class='mx-layoutcontainer-wrapper mx-scrollcontainer-wrapper']/div[2]/button/span")
	WebElement btnLocalActions;

	@FindBy(how = How.XPATH, using = "//*[text()='Validate Local Data']")
	WebElement btnValidateLocalData;

	@FindBy(how = How.XPATH, using = "//*[text()='Save']")
	WebElement btnSaveLocalData;

	@FindBy(how = How.XPATH, using = ".//*[text()='Request complies to all Validations']")
	WebElement txtValidationMsg;

	@FindBy(how = How.XPATH, using = ".//*[text()='Finance']")
	WebElement btnNavFinance;

	//@FindBy(how = How.XPATH, using = "(//*[text()='Edit'])[3]")
	@FindBy(how=How.XPATH, using = ".//*[text()='Finance']/../../../div/div[2]/div/div/div[2]/div[2]/div[2]/button[2]")
	WebElement btnNavLocalFinanceEditExtend;

	@FindBy(how = How.XPATH, using = ".//*[contains(text(),'VAT Prod. Posting Group')]/../div/div/select")
	WebElement dropDownFinanceVATPostingGroup;

	@FindBy(how = How.XPATH, using = ".//*[text()='Planning']/../../../div/div[1]/div/div/div/div[2]/div[2]/button[1]")
	WebElement btnNavLocalPlantNewCreate;
	
	@FindBy(how = How.XPATH, using = ".//*[text()='Planning']/../../../div/div[1]/div/div/div/div[2]/div[2]/button[2]")
	WebElement btnNavLocalPlantEdit;
	
	@FindBy(how = How.XPATH, using = "//*[@class='mx-datagrid-body']/tr/td[3]")
	WebElement btnRowSelect;

	@FindBy(how = How.XPATH, using = "//button[text()='Edit']")
	WebElement btnSitesSelectEdit;
	

	@FindBy(how = How.XPATH, using = "//*[text()='Confirm Extension']")
	WebElement btnConfirmExtension;
	
	@FindBy(how = How.XPATH, using="//*[text()='Site']/../../../div/div[3]/div/div/div[2]/div[2]/div[2]/button[2]")
	WebElement btnEditLocalSiteNav;
	
	@FindBy(how = How.XPATH, using = "(.//*[contains(text(),'Plant')]/../div/div/select)[1]")
	WebElement dropDownLocalSitePlant;
	
	@FindBy(how = How.XPATH, using = ".//*[contains(text(),'Replenishment System')]/../div/div/select")
	WebElement dropDownLocalSiteRS;
	
	@FindBy(how = How.XPATH, using = ".//*[text()='Site']")
	WebElement btnNavSite;
	
	@FindBy(how = How.XPATH, using = ".//*[text()='Site']/../../../div/div[3]/div/div/div[2]/div[2]/div[2]/button[2]")
	WebElement btnNavLocalSiteEditExtend;
	
	@FindBy(how = How.XPATH, using = ".//*[contains(text(),'Purch. Unit of Measure')]/../div/div/select")
	WebElement dropdownPlantPurchaseUOMValue;
	
	@FindBy(how = How.XPATH, using = ".//*[contains(text(),'Production Unit of Measure')]/../div/div/select")
	WebElement dropdownPlantProductionUOMValue;
	
	@FindBy(how = How.XPATH, using = ".//*[contains(text(),'Sales Unit of Measure')]/../div/div/select")
	WebElement dropdownPlantSalesUOMValue;
	
	@FindBy(how = How.XPATH, using = ".//*[contains(text(),'Inventory Unit of Measure')]/../div/div/select")
	WebElement dropdownPlantInventoryUOMValue;
	
	@FindBy(how = How.XPATH, using = ".//*[contains(text(),'Inventory Posting Group')]/../div/div/select")
	WebElement dropDownFinanceInventoryPostingGroup;
	
	@FindBy(how = How.XPATH, using = ".//*[contains(text(),'WHT Product Posting Group')]/../div/div/select")
	WebElement dropDownFinanceWHTValue;

	@FindBy(how = How.XPATH, using = ".//*[contains(text(),'Gen. Prod. Posting Group')]/../div/div/select")
	WebElement dropDownFinanceGPPostingGroup;
	
	public void enterLocalData() throws InterruptedException {
		Thread.sleep(20000);
		WebDriverWait wait = new WebDriverWait(driver, 200);		
		wait.until(ExpectedConditions.elementToBeClickable(textLocalData));
		Sync.waitForSeconds(Constants.WAIT_6);

		//Sync.waitUntilObjectDisappears(driver, "Waiting of Create page to Load",
		//By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForSeconds(Constants.WAIT_3);
		Sync.waitForObject(driver, textLocalData);
		Button.jsclick("Click on Local Data",textLocalData , driver);
		// Sync.waitForObject(driver, BtnAddPlantData);
		/* return Button.click("Click Edit button", BtnAddPlantData); */

	}
	public void enterGlobalData() {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Global Data']")));
		Sync.waitForSeconds(Constants.WAIT_6);

		/*Sync.waitUntilObjectDisappears(driver, "Waiting of Create page to Load",
				By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));*/
		//WebDriverWait wait1 = new WebDriverWait(driver, 80);
		//wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Global Data']")));
		if(Button.verifyObject(btnGlobalData)) {
			Sync.waitForSeconds(Constants.WAIT_3);
			Sync.waitForObject(driver, btnGlobalData);
			Button.jsclick("Global Data ", btnGlobalData,driver);
			Sync.waitForSeconds(Constants.WAIT_3);
		}
		else {
			Sync.waitForSeconds(Constants.WAIT_3);
			Sync.waitForObject(driver, btnGlobalData);
			Button.click("Local Data", btnGlobalData);
		}
			
		// Sync.waitForObject(driver, BtnAddPlantData);
		/* return Button.click("Click Edit button", BtnAddPlantData); */

	}


	public boolean clickAddPlantData() {

		Sync.waitForObject(driver, BtnAddPlantData);
		return Button.click("Click Edit button", BtnAddPlantData);

	}

	public boolean enterPlantData(String strValue) {

		Sync.waitForSeconds(Constants.WAIT_6);
		Sync.waitUntilObjectDisappears(driver, "Waiting of Create page to Load",
				By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForObject(driver, BtnAddPlantData);
		Button.click("Local Plant Data", BtnAddPlantData);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='" + strValue + "']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='" + strValue + "']")));
		driver.findElement(By.xpath("//div[text()='DZ10']")).click();
		return Button.click("Click Select Button", BtnPlantSelect);

	}

	public void clickEditPlanningData() throws AWTException, IOException {
		Sync.waitForSeconds(Constants.WAIT_6);
		driver.findElement(By.xpath("(//button[text()='Edit'])[5]")).click();
		Sync.waitForSeconds(Constants.WAIT_3);
		Sync.waitUntilObjectDisappears(driver, "Wait for Materials",
				By.xpath((".//*[@id='mxui_widget_Progress_0']/div[2]")));
		/*
		 * JavascriptExecutor jse = (JavascriptExecutor)driver;
		 * Sync.waitForSeconds(Constants.WAIT_6);
		 * jse.executeScript("arguments[0].click()",
		 * driver.findElement(By.xpath("(//*[text()='OK'])[2]")));
		 * Sync.waitForSeconds(Constants.WAIT_3);
		 * jse.executeScript("arguments[0].click()",
		 * driver.findElement(By.xpath("(//*[text()='OK'])[1]")));
		 */
	}

	public void selectRoundingPrecision(String strValue) {

		WebElement dropdown = driver.findElement(By.xpath(".//*[text()='Rounding Precision']/../div/div/select"));
		Sync.waitForObjectFluent(driver, dropdown);
		Select roundPrecisiondropDown = new Select(dropdown);
		roundPrecisiondropDown.selectByVisibleText(strValue);

	}

	public void clickLocalAction() {
		Sync.waitForSeconds(Constants.WAIT_5);
		WebElement waitElement = null;
		FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMinutes(3))
				.pollingEvery(Duration.ofSeconds(600)).ignoring(NoSuchElementException.class)
				.ignoring(TimeoutException.class);

		// First checking to see if the loading indicator is found
		// we catch and throw no exception here in case they aren't ignored
		try {
			waitElement = fwait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath(".//*[@id='mxui_widget_Progress_0']"));
				}
			});
		} catch (Exception e) {
		}

		// checking if loading indicator was found and if so we wait for it to
		// disappear
		if (waitElement != null) {
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(".//*[@class='glyphicon glyphicon-flash']")));
		}
		// Sync.waitUntilObjectDisappears(driver, "Wait for Materials",
		// By.xpath((".//*[@id='mxui_widget_Progress_0']/div[2]")));
		Sync.waitForElementToBeClickable(driver,
				driver.findElement(By.xpath(".//*[@class='glyphicon glyphicon-flash']")));
		driver.findElement(By.xpath(".//*[@class='glyphicon glyphicon-flash']")).click();
	}

	public void clickValidatLocalData() {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		Sync.waitForSeconds(Constants.WAIT_5);

		driver.findElement(By.xpath(".//*[@class='glyphicon glyphicon-check']")).click();

	}

	public void clickValidatLocalRequest() {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[text()='Validate Local Request']")));
		
		Sync.waitForSeconds(Constants.WAIT_5);

		driver.findElement(By.xpath(".//*[text()='Validate Local Request']")).click();
		Sync.waitForSeconds(Constants.WAIT_10);
	}

	public void clickValidateLocalData_Planning() {

		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForObject(driver, "Wait for Planning Data to Load",
				driver.findElement(By.xpath(".//*[@class='glyphicon glyphicon-check']")));
		driver.findElement(By.xpath(".//*[@class='glyphicon glyphicon-check']")).click();
		Sync.waitForSeconds(Constants.WAIT_5);

	}

	public void clickSaveButton() {
		Sync.WaitForPageLoad(driver);
		Sync.waitForSeconds(Constants.WAIT_5);
		//Sync.waitUntilObjectDisappears(driver, "Wait for Save button",
		//		By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForObject(driver, "Wait for Click Save button",
				driver.findElement(By.xpath(".//button[text()='Save']")));
		Button.jsclick("Click Save Button", driver.findElement(By.xpath(".//button[text()='Save']")), driver);
		Sync.waitForSeconds(Constants.WAIT_5);

	}

	public void clickPlanningSaveButton() {
		Sync.WaitForPageLoad(driver);
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitUntilObjectDisappears(driver, "Wait for Save button",
				By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForObject(driver, "Wait for Click Save button",
				driver.findElement(By.xpath(".//button[text()='Save']")));
		Button.jsclick("Click Save Button", driver.findElement(By.xpath(".//button[text()='Save']")), driver);

	}

	public void clickFinancetab() throws InterruptedException {
		Sync.waitUntilObjectDisappears(driver, "Wait for Save button",
				By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.WaitForPageLoad(driver);
		Sync.waitForSeconds(Constants.WAIT_6);
		Sync.waitUntilObjectDisappears(driver, "Wait for Save button",
				By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		// Sync.waitForObject(driver, "Wait for Click element",
		// driver.findElement(By.cssSelector("div[id^='mxui_widget_TabContainer']:nth-child(1)
		// > ul:nth-child(1) >li:nth-child(2)>a")));
		Sync.waitForElementToBeClickable(driver, driver.findElement(By
				.cssSelector("div[id^='mxui_widget_TabContainer']:nth-child(1) > ul:nth-child(1) >li:nth-child(2)>a")));
		// Sync.waitForElementToBeClickable(driver,
		// driver.findElement(By.cssSelector("div[id^='mxui_widget_TabContainer']:nth-child(1)
		// >ul >li:nth-child(9)")));
		Button.jsclick("Click Finance Tab",
				driver.findElement(By.cssSelector(
						"div[id^='mxui_widget_TabContainer']:nth-child(1) > ul:nth-child(1) >li:nth-child(2)>a")),
				driver);
	}

	public void clickEditFinanceData() throws AWTException, IOException {
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitUntilObjectDisappears(driver, "Wait for Save button",
				By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForElementToBeClickable(driver,
				driver.findElement(By.xpath("(//*[text()='Add'])[2]/../button[2]/span")));
		// Button.jsclick("Click Edit Finance Button",
		// driver.findElement(By.xpath("(//*[text()='Add'])[2]/../button[2]/span")),
		// driver);
		Button.jsclick("Click Edit Finance Button", driver.findElement(By.xpath("(//*[text()='Edit'])[6]")), driver);
		// driver.findElement(By.xpath("(//*[text()='Add'])[2]/../button[2]/span")).click();
		/*
		 * Sync.waitForSeconds(Constants.WAIT_3); Sync.waitUntilObjectDisappears(driver,
		 * "Wait for Materials",
		 * By.xpath((".//*[@id='mxui_widget_Progress_0']/div[2]"))); JavascriptExecutor
		 * jse = (JavascriptExecutor)driver; Sync.waitForSeconds(Constants.WAIT_6);
		 * jse.executeScript("arguments[0].click()",
		 * driver.findElement(By.xpath("(//*[text()='OK'])[2]")));
		 * Sync.waitForSeconds(Constants.WAIT_3);
		 * jse.executeScript("arguments[0].click()",
		 * driver.findElement(By.xpath("(//*[text()='OK'])[1]")));
		 */
	}

	public void clickBackAction() {
		Sync.waitForSeconds(Constants.WAIT_2);
		driver.findElement(By.cssSelector("glyphicon glyphicon-backward")).click();
	}

	public void selectVATPostingGroup(String strValue) {
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_3);
		WebElement dropdown = driver.findElement(By.xpath("//*[text()='VAT Prod. Posting Group']/../div/div/select"));
		Sync.waitForObject(driver, "Wait for VAT posting group Select", dropdown);
		Sync.waitForElementToBeClickable(driver, dropdown);
		Button.click("Wait for VAT posting group Select", dropdown);
		Select roundVATPostingGroupDown = new Select(dropdown);
		roundVATPostingGroupDown.selectByVisibleText(strValue);

	}

	public void selectGenProdPostingGroup(String strValue) {
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_3);
		WebElement dropdown = driver.findElement(By.xpath("//*[text()='Gen. Prod. Posting Group']/../div/div/select"));
		Sync.waitForObject(driver, "Wait for VAT posting group Select", dropdown);
		Sync.waitForElementToBeClickable(driver, dropdown);
		Button.click("Wait for VAT posting group Select", dropdown);
		Select roundVATPostingGroupDown = new Select(dropdown);
		roundVATPostingGroupDown.selectByVisibleText(strValue);

	}

	public void selectItemDepositGroupCode(String strValue) {
		WebElement dropdown = driver.findElement(By.xpath("//*[text()='Item Deposit Group Code']/../div/div/select"));
		Select roundVATPostingGroupDown = new Select(dropdown);
		roundVATPostingGroupDown.selectByVisibleText(strValue);

	}

	public void submitGlobalRequestTest() throws InterruptedException {

		// Sync.waitForSeconds(Constants.WAIT_5);
		Sync.WaitForPageLoad(driver);
		// Sync.waitForObject(driver, "Wait for Submit Global Request",
		// driver.findElement(By.xpath("//*[text()='Local
		// Actions:']/../div[2]/div[2]/div[1]/div[1]/div/div[1]/div[1]/div/div/div/div[1]/div/button/span")));
		Sync.waitForElementToBeClickable(driver, driver.findElement(By.xpath(
				"//*[text()='Local Actions:']/../div[2]/div[2]/div[1]/div[1]/div/div[1]/div[1]/div/div/div/div[1]/div/button/span")));
		Button.jsclick("Click Global submit Global Request", driver.findElement(By.xpath(
				"//*[text()='Local Actions:']/../div[2]/div[2]/div[1]/div[1]/div/div[1]/div[1]/div/div/div/div[1]/div/button/span")),
				driver);
		Sync.waitForSeconds(Constants.WAIT_2);
		Sync.waitForSeconds(Constants.WAIT_5);

	}

	public void submitGlobalLocalRequestTest() throws InterruptedException {
		Sync.WaitForPageLoad(driver);

		Sync.waitForSeconds(Constants.WAIT_10);
		Sync.waitForObject(driver, "Wait for Submit Global Request",
				driver.findElement(By.xpath(".//*[text()='Global Actions:']/..//*[text()='Submit Global and Local Request']")));
		Sync.waitForElementToBeClickable(driver,
				driver.findElement(By.xpath(".//*[text()='Global Actions:']/..//*[text()='Submit Global and Local Request']")));
		Button.jsclick("Click Global submit Global Request",
				driver.findElement(By.xpath(".//*[text()='Global Actions:']/..//*[text()='Submit Global and Local Request']")), driver);
		// Button.click("Click Global submit Global Request",
		// driver.findElement(By.xpath("(//span[@class='glyphicon
		// glyphicon-save'])[2]")));
		Sync.waitForSeconds(Constants.WAIT_2);
		Sync.waitForSeconds(Constants.WAIT_5);

	}

	public boolean submitRequestOkBtnClick() {

		Sync.waitForSeconds(Constants.WAIT_2);
		WebElement waitElement = null;
		FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMinutes(3))
				.pollingEvery(Duration.ofSeconds(600)).ignoring(NoSuchElementException.class)
				.ignoring(TimeoutException.class);

		// First checking to see if the loading indicator is found
		// we catch and throw no exception here in case they aren't ignored
		try {
			waitElement = fwait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath(".//*[@id='mxui_widget_Progress_0']"));
				}
			});
		} catch (Exception e) {
		}

		// checking if loading indicator was found and if so we wait for it to
		// disappear
		if (waitElement != null) {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn.btn-primary")));
		}

		/*
		 * Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		 * .withTimeout(Duration.ofSeconds(300)) .pollingEvery(Duration.ofMillis(600))
		 * .ignoring(NoSuchElementException.class);
		 * 
		 * WebElement btnMsgReqIdOk=wait.until(new Function<WebDriver, WebElement>() {
		 * public WebElement apply(WebDriver driver) { return
		 * driver.findElement(By.cssSelector(".btn.btn-primary")); } });
		 */

		/*
		 * Actions btnselect = new Actions(driver);
		 * btnselect.moveToElement(btnMsgReqIdOk); btnselect.build();
		 * btnselect.perform();
		 */
		// System.out.println(btnMsgReqIdOk.getCssValue("color"));
		return Button.click("Click Ok Button", btnMsgReqIdOk);
	}

	public void clickSiteNewTab() {

		Sync.waitUntilObjectDisappears(driver, "Wait for Save button",
				By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.WaitForPageLoad(driver);
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitUntilObjectDisappears(driver, "Wait for Save button",
				By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		// Sync.waitForObjectFluent(driver,
		// driver.findElement(By.cssSelector("div[id^='mxui_widget_TabContainer']:nth-child(1)
		// > ul:nth-child(1) >li:nth-child(3)>a")));
		Button.jsclick("Click Site Tab",
				driver.findElement(By.cssSelector(
						"div[id^='mxui_widget_TabContainer']:nth-child(1) > ul:nth-child(1) >li:nth-child(3)>a")),
				driver);
	}

	public void clickSiteNewButton() {

		Sync.waitForObject(driver, "Wait for Site New Button", driver.findElement(By.xpath("//button[text()='New']")));
		Sync.waitForSeconds(Constants.WAIT_2);
		Button.jsclick("Click New Button", driver.findElement(By.xpath("//button[text()='New']")), driver);
		Sync.waitForSeconds(Constants.WAIT_2);

	}

	public void selectLocationCode(String strValue) {
		/*
		 * WebElement dropdown =driver.findElement(By.
		 * xpath("//*[text()='Item Deposit Group Code']/../div/div/select")); Select
		 * LocationCodeDropDown= new Select(dropdown);
		 * LocationCodeDropDown.selectByVisibleText("DZ01, Brewery Rouiba");
		 */
//		Sync.waitUntilObjectDisappears(driver, "Wait for Location Code Select",
//				By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
//		Sync.waitForSeconds(Constants.WAIT_5);
		WebElement dropdown = driver.findElement(By.xpath("//*[text()='Location Code']/../div/div/select"));
		Sync.waitForObject(driver, "Wait for Location Code Select", dropdown);
		Button.click("Wait for Location Code Select", dropdown);
		Select roundVATPostingGroupDown = new Select(dropdown);
		roundVATPostingGroupDown.selectByVisibleText(strValue);
	}

	public void selectReplenishmentSystem(String strValue) {
		// WebElement dropdown =driver.findElement(By.xpath("//*[text()='Replenishment
		// System']/../div/div/select"));
		// Select LocationCodeDropDown= new Select(dropdown);
		// LocationCodeDropDown.selectByVisibleText("2, Transfer");

		Sync.waitUntilObjectDisappears(driver, "Wait for Replenishment System",
				By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForSeconds(Constants.WAIT_5);
		WebElement dropdown = driver.findElement(By.xpath("//*[text()='Replenishment System']/../div/div/select"));
		Sync.waitForObject(driver, "Wait for Location Code Select", dropdown);
		Button.click("Wait for Location Code Select", dropdown);
		Select roundVATPostingGroupDown = new Select(dropdown);
		roundVATPostingGroupDown.selectByVisibleText(strValue);

	}

	public void clickSiteValidateButton() {

		Sync.waitForSeconds(Constants.WAIT_2);
		Sync.waitForElementToBeClickable(driver, driver.findElement(By.xpath("//*[text()='Validate Local Data']")));
		Button.click("Click New Button", driver.findElement(By.xpath("//*[text()='Validate Local Data']")));
		Sync.waitForSeconds(Constants.WAIT_2);

	}

	public void clickSiteSaveButton() {

		Sync.waitForSeconds(Constants.WAIT_2);
		Sync.waitForElementToBeClickable(driver, driver.findElement(By.cssSelector(".glyphicon.glyphicon-ok")));
		Button.click("Click New Button", driver.findElement(By.cssSelector(".glyphicon.glyphicon-ok")));
		Sync.waitForSeconds(Constants.WAIT_2);

	}

	public void scrolltoRoundingPrecision() throws InterruptedException {

		Point hoverItem = driver.findElement(By.xpath(".//*[text()='Rounding Precision']")).getLocation();
		((JavascriptExecutor) driver).executeScript("return window.title;");
		Thread.sleep(6000);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + (hoverItem.getY()) + ");");
	}
	
	

	public void clickEditSiteData() throws AWTException, IOException {
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForObject(driver, btnEditLocalSiteNav);
		
		if(Button.verifyObject(btnEditLocalSiteNav))
		{
			Sync.waitForObject(driver, btnEditLocalSiteNav);
			Button.jsclick("Click Edit Site Button", btnEditLocalSiteNav, driver);
		}
		else
		{
			Sync.waitForObject(driver, btnEditLocalSiteNav);
			Button.jsclick("Click Edit Site Button", btnEditLocalSiteNav, driver);
		}
		//Sync.waitUntilObjectDisappears(driver, "Wait for Location Code Select",By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		// Sync.waitForElementToBeClickable(driver,
		// driver.findElement(By.xpath("(//*[text()='Add'])[3]/../button[2]/span")));
		//Button.jsclick("Click Edit Site Button",driver.findElement(By.xpath("(//*[text()='Add'])[3]/../button[2]/span")), driver);
		// driver.findElement(By.xpath("(//*[text()='Add'])[3]/../button[2]/span")).click();
	}

	/*
	 * public void selectLocationCode(String strValue) {
	 * Sync.waitUntilObjectDisappears(driver, "Wait for Location Code Select",
	 * By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
	 * Sync.waitForSeconds(Constants.WAIT_5); WebElement dropdown
	 * =driver.findElement(By.xpath("//*[text()='Location Code']/../div/div/select")
	 * ); Sync.waitForObject(driver, "Wait for Location Code Select", dropdown);
	 * Button.click("Wait for Location Code Select", dropdown); Select
	 * roundVATPostingGroupDown= new Select(dropdown);
	 * roundVATPostingGroupDown.selectByVisibleText(strValue);/
	 * /"DZ01, Brewery Rouiba" }
	 */

	/*
	 * public void selectReplenishmentSystem() {
	 * 
	 * Sync.waitUntilObjectDisappears(driver, "Wait for Replenishment System",
	 * By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
	 * Sync.waitForSeconds(Constants.WAIT_5); WebElement dropdown
	 * =driver.findElement(By.
	 * xpath("//*[text()='Replenishment System']/../div/div/select"));
	 * Sync.waitForObject(driver, "Wait for Location Code Select", dropdown);
	 * Button.click("Wait for Location Code Select", dropdown); Select
	 * roundVATPostingGroupDown= new Select(dropdown);
	 * roundVATPostingGroupDown.selectByVisibleText("2, Transfer");
	 * 
	 * }
	 */
	public void submitLocalRequest() {
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForObject(driver, "Wait for Submit Local Request",
		driver.findElement(By.xpath(".//*[text()='Submit Local Request']")));
		Sync.waitForElementToBeClickable(driver, driver.findElement(By.xpath(".//*[text()='Submit Local Request']")));
		Button.jsclick("Click  Submit Local Request",
		driver.findElement(By.xpath(".//*[text()='Submit Local Request']")),driver);		
		Sync.waitForSeconds(Constants.WAIT_2);
		Sync.waitForSeconds(Constants.WAIT_5);
	}

	public boolean clickGlobalDataButton() throws InterruptedException {
		boolean isButtonClicked = false;

		System.out.println("Crossed the Local Data addition");
		
		WebElement el = driver.findElement(By.cssSelector(".mx-name-tabPageGlobal"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", el);
		/*
		 * if(Button.verifyObject(btnGlobalData)){ Sync.waitForObject(driver
		 * ,"Global Data", btnGlobalData); Sync.waitForSeconds(Constants.WAIT_5); return
		 * Button.click("Global Data", btnGlobalData); }else{ return
		 * Button.click("Global Data", btnGlobalData); }
		 */
		return isButtonClicked;
	} 
	

	public void clickValidateLocalRequest() {
		//WebDriverWait wait = new WebDriverWait(driver, 90);
		Sync.waitForObject(driver, "Click Validate Local Request", btnValidateLocalRequest);
		if (Button.verifyObject(btnGlobalData)) {
			Sync.waitForObject(driver, "click on validate local request button", btnValidateLocalRequest);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click Validate Local Request", btnValidateLocalRequest);
		} else {
			Sync.waitForSeconds(Constants.WAIT_6);
			Button.click("Click Validate Local Request", btnValidateLocalRequest);
		}
		Sync.waitForSeconds(Constants.WAIT_6);
		System.out.println("Loading the page to display validation message");
		Sync.waitForObject(driver, "Verify Validate message", txtValidationMsg);
		System.out.println("Validation message displayed and going forward");
	}


	public void createWithReferenceRequestforNav() {
		Sync.waitForElementToBeClickable(driver, btnSelectAllOnPopUpPlants);
		Button.jsclick("Select all listed elements for GlobalId", btnSelectAll, driver);
		Sync.waitForSeconds(Constants.WAIT_2);
		// Button.jsclick("Select all listed elements for GlobalId",
		// btnSelectAllOnPopUpPlants, driver);
		//Button.jsclick("Select All for Sales Organizations", btnSelectAllOnPopUpSalesOrg, driver);
		Button.jsclick("Create Request Button for Nav", btnCreateRequestOnPopUp, driver);
		Sync.waitForSeconds(Constants.WAIT_6);

	}

	public void switchToLocal() {
		Sync.waitForSeconds(Constants.WAIT_5);
		Button.jsclick("Local Data", textLocalData, driver);
		Sync.waitForSeconds(Constants.WAIT_5);
	}
	
	public void switchToGlobal() {
		//Sync.waitForObject(driver, "Verify Validate message", txtValidationMsg);
		Sync.waitForSeconds(15);
		Sync.waitForObject(driver, btnGlobalData);
		Button.jsclick("Global Data", btnGlobalData, driver);
		Sync.waitForSeconds(Constants.WAIT_5);
	}

	public void localEditPlantNav() {
		if (Button.verifyObject(btnNavLocalPlantEdit)) {
			Sync.waitForObject(driver, btnNavLocalPlantEdit);
			Button.jsclick("Adding new Plant for Nav", btnNavLocalPlantEdit, driver);
			Sync.waitForSeconds(Constants.WAIT_10);
		} else {
			Sync.waitForSeconds(Constants.WAIT_10);
			Sync.waitForObject(driver, btnNavLocalPlantEdit);
			Button.jsclick("Adding new Plant for Nav", btnNavLocalPlantEdit, driver);
			Sync.waitForSeconds(Constants.WAIT_10);
		}
	}

	public void selectLocalPlantRoundingPrecisionValueDropDown(String strValue) throws InterruptedException {
		// Sync.waitForObject(driver,
		// driver.findElement(By.xpath(".//*[contains(text(),'Edit Local Data
		// Planning')]")));
		Sync.waitForSeconds(Constants.WAIT_5);
		if (DropDown.verifyObject(dropdownPlantRoundingPrecisionValue)) {
			Sync.waitForObject(driver, "Wait for Sales UOM Select", dropdownPlantRoundingPrecisionValue);
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on Sales UOM Select", dropdownPlantRoundingPrecisionValue);
			Select rpValueDropDownSelect = new Select(dropdownPlantRoundingPrecisionValue);
			rpValueDropDownSelect.selectByVisibleText(strValue);

		} else {
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on Sales UOM Select", dropdownPlantRoundingPrecisionValue);
			Select rpValueDropDownSelect = new Select(dropdownPlantRoundingPrecisionValue);
			rpValueDropDownSelect.selectByVisibleText(strValue);
		}

	}

	public void clickAndSelectRoundingPrecisionValueDropDown(String strValue) throws InterruptedException {
		Sync.waitForSeconds(Constants.WAIT_5);
		this.selectLocalPlantRoundingPrecisionValueDropDown(strValue);
	}

	public void validateAndSaveLocalData() {
		Sync.waitForObject(driver, btnLocalActions);
		Button.click("Local Actions button", btnLocalActions);
		Sync.waitForSeconds(Constants.WAIT_6);
		Button.click("Validate Local Data", btnValidateLocalData);
		Sync.waitForSeconds(Constants.WAIT_6);
		Sync.waitForObject(driver, "Verify Validate message", txtValidationMsg);
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_5);
		Button.click("Save Local Data", btnSaveLocalData);
		Sync.waitForSeconds(Constants.WAIT_5);
	}

	public void localEditFinanceDataNav() {

		Sync.waitForObject(driver, btnNavFinance);
		Button.jsclick("Click on the Finance Button in Local Data", btnNavFinance, driver);
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForObject(driver, btnNavLocalFinanceEditExtend);
		if (Button.verifyObject(btnNavLocalFinanceEditExtend)) {
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForObject(driver, btnNavLocalFinanceEditExtend);
			Button.jsclick("Click edit to add data in Finance", btnNavLocalFinanceEditExtend, driver);
			Sync.waitForSeconds(Constants.WAIT_10);

		} else {
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_6);
			Button.jsclick("Click edit to add data in Finance", btnNavLocalFinanceEditExtend, driver);
			Sync.waitForSeconds(Constants.WAIT_10);
		}

	}

	public void selectLocalFinanceVATProdPostingGroupDropDown(String strValue) throws InterruptedException {
		// Sync.waitForObject(driver, textFinanceTabNav);
		Sync.waitForSeconds(Constants.WAIT_5);
		if (DropDown.verifyObject(dropDownFinanceVATPostingGroup)) {
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForObject(driver, "Wait for VAT Prod. Posting Group Select", dropDownFinanceVATPostingGroup);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on VAT Prod. Posting Group Select", dropDownFinanceVATPostingGroup);
			Select vatPGDropDownSelect = new Select(dropDownFinanceVATPostingGroup);
			vatPGDropDownSelect.selectByVisibleText(strValue);

		} else {
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on VAT Prod. Posting Group Select", dropDownFinanceVATPostingGroup);
			Select vatPGDropDownSelect = new Select(dropDownFinanceVATPostingGroup);
			vatPGDropDownSelect.selectByVisibleText(strValue);
		}

	}

	public void clickAndSelectVATPostingGroupDropDown(String strValue) throws InterruptedException {
		Sync.waitForSeconds(Constants.WAIT_5);
		this.selectLocalFinanceVATProdPostingGroupDropDown(strValue);
	}
	
	public void selectLocalSitePlantDropDown(String strValue) throws InterruptedException {
		// Sync.waitForObject(driver, textFinanceTabNav);
		Sync.waitForSeconds(Constants.WAIT_5);
		if (DropDown.verifyObject(dropDownLocalSitePlant)) {
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForObject(driver, "Wait for Plant Select", dropDownLocalSitePlant);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on Plant Select", dropDownLocalSitePlant);
			Select sitePlantDropDownSelect = new Select(dropDownLocalSitePlant);
			sitePlantDropDownSelect.selectByVisibleText(strValue);

		} else {
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on Plant Select", dropDownLocalSitePlant);
			Select sitePlantDropDownSelect = new Select(dropDownLocalSitePlant);
			sitePlantDropDownSelect.selectByVisibleText(strValue);
		}

	}

	public void clickAndSelectSitePlantDropDown(String strValue) throws InterruptedException {
		Sync.waitForSeconds(Constants.WAIT_5);
		this.selectLocalSitePlantDropDown(strValue);
	}
	
	public void selectLocalSiteReplenishmentSystemDropDown(String strValue) throws InterruptedException {
		// Sync.waitForObject(driver, textFinanceTabNav);
		Sync.waitForSeconds(Constants.WAIT_5);
		if (DropDown.verifyObject(dropDownLocalSiteRS)) {
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForObject(driver, "Wait for Replenishment System Select", dropDownLocalSiteRS);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on Replenishment System Select", dropDownLocalSiteRS);
			Select siteRSDropDownSelect = new Select(dropDownLocalSiteRS);
			siteRSDropDownSelect.selectByVisibleText(strValue);

		} else {
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on Replenishment System Select", dropDownLocalSiteRS);
			Select siteRSDropDownSelect = new Select(dropDownLocalSiteRS);
			siteRSDropDownSelect.selectByVisibleText(strValue);
		}

	}

	public void clickAndSelectSiteReplenishmentSystemDropDown(String strValue) throws InterruptedException {
		Sync.waitForSeconds(Constants.WAIT_5);
		this.selectLocalSiteReplenishmentSystemDropDown(strValue);
	}


	public void localAddInNewPlantNav() {

		Sync.waitForSeconds(Constants.WAIT_10);
		Sync.waitForObject(driver, textLocalData);

		if (Button.verifyObject(btnNavLocalPlantNewCreate)) {
			Sync.waitForObject(driver, btnNavLocalPlantNewCreate);
			Button.jsclick("Adding new Plant for Nav", btnNavLocalPlantNewCreate, driver);
			Sync.waitForSeconds(Constants.WAIT_10);
		} else {
			Sync.waitForSeconds(Constants.WAIT_10);
			Sync.waitForObject(driver, btnNavLocalPlantNewCreate);
			Button.jsclick("Adding new Plant for Nav", btnNavLocalPlantNewCreate, driver);
			Sync.waitForSeconds(Constants.WAIT_10);
		}

	}

	public void selectingRow() {
		Sync.waitForSeconds(Constants.WAIT_5);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class='mx-name-index-0']")));
		Sync.waitForObject(driver, "Waiting for selecting Row",
				driver.findElement(By.xpath(".//*[@class='mx-name-index-0']")));
		Sync.waitForSeconds(Constants.WAIT_10);
		if (Button.verifyObject(btnRowSelect)) {
			Sync.waitForObject(driver, btnRowSelect);
			Button.jsclick("Select the row in Sites tab", btnRowSelect, driver);
			Sync.waitForSeconds(Constants.WAIT_5);
		} else {
			Sync.waitForObject(driver, btnRowSelect);
			Button.jsclick("Select the row in Sites tab", btnRowSelect, driver);
			Sync.waitForSeconds(Constants.WAIT_5);
		}
		// driver.findElement(By.xpath("//*[@class='mx-datagrid-body']/tr/td[3]")).click();
		/*
		 * if(driver.findElement(By.xpath(".//*[@class='mx-name-index-0']")).isSelected(
		 * )) { Sync.waitForSeconds(Constants.WAIT_10); } else {
		 * driver.findElement(By.xpath(".//*[@class='mx-name-index-0']")).click(); }
		 */

		Sync.waitForObject(driver, driver.findElement(By.xpath("//button[text()='Edit']")));
	}

	public void clickSiteEditButton() {
		Sync.waitForSeconds(Constants.WAIT_5);
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Edit']")));
		Sync.waitForObject(driver, "Wait for Site New Button", driver.findElement(By.xpath("//button[text()='Edit']")));
		if (Button.verifyObject(btnSitesSelectEdit)) {
			Sync.waitForObject(driver, btnSitesSelectEdit);
			Button.jsclick("Click on Sites Edit Button after selecting the site", btnSitesSelectEdit, driver);
			Sync.waitForSeconds(Constants.WAIT_10);
		} else {
			Sync.waitForObject(driver, btnSitesSelectEdit);
			Button.jsclick("Click on Sites Edit Button after selecting the site", btnSitesSelectEdit, driver);
			Sync.waitForSeconds(Constants.WAIT_10);
		}
		// Sync.waitForSeconds(Constants.WAIT_2);
		// Button.click("Click Edit Button",
		// driver.findElement(By.xpath("//button[text()='Edit']")));
		// Sync.waitForSeconds(Constants.WAIT_2);
	}
	
	public void confirmExtensionNav() {
		// Sync.waitForSeconds(Constants.WAIT_6);
		Sync.waitForSeconds(Constants.WAIT_5);
		// Sync.waitUntilObjectDisappears(driver, "Wait for Save button",
		// By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForSeconds(Constants.WAIT_5);
		if (Button.verifyObject(btnConfirmExtension)) {
			Sync.waitForSeconds(Constants.WAIT_10);
			Sync.waitForObject(driver, btnConfirmExtension);
			Button.jsclick("Click confirm Extension", btnConfirmExtension, driver);
			Sync.waitForSeconds(Constants.WAIT_10);
		} else {
			Sync.waitForSeconds(Constants.WAIT_10);
			Sync.waitForObject(driver, btnConfirmExtension);
			Button.jsclick("Click confirm Extension", btnConfirmExtension, driver);
			Sync.waitForSeconds(Constants.WAIT_10);
		}
	}
	
	public void localEditSiteDataNav() {

		Sync.waitForObject(driver, btnNavSite);
		Button.jsclick("Click on the Finance Button in Local Data", btnNavSite, driver);
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForObject(driver, btnNavLocalSiteEditExtend);
		if (Button.verifyObject(btnNavLocalSiteEditExtend)) {
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForObject(driver, btnNavLocalSiteEditExtend);
			Button.jsclick("Click edit to add data in Site", btnNavLocalSiteEditExtend, driver);
			Sync.waitForSeconds(Constants.WAIT_10);

		} else {
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_6);
			Button.jsclick("Click edit to add data in Site", btnNavLocalSiteEditExtend, driver);
			Sync.waitForSeconds(Constants.WAIT_10);
		}

	}

	
	public void clickEditFinanceDataJDE_Extend() throws AWTException, IOException
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[text()='Finance']/../../../div/div[9]/div/div/div[2]/div[2]//*[text()='Edit']")));
		Sync.waitUntilObjectDisappears(driver, "Wait for Save button", By.xpath(".//*[text()='Finance']/../../../div/div[9]/div/div/div[2]/div[2]//*[text()='Edit']"));
		Sync.waitForElementToBeClickable(driver, driver.findElement( By.xpath(".//*[text()='Finance']/../../../div/div[9]/div/div/div[2]/div[2]//*[text()='Edit']")));
		Button.jsclick("Click Edit Finance Button", driver.findElement(By.xpath(".//*[text()='Finance']/../../../div/div[9]/div/div/div[2]/div[2]//*[text()='Edit']")), driver);
//		driver.findElement(By.xpath("(//*[text()='Add'])[2]/../button[2]/span")).click();
		/*Sync.waitForSeconds(Constants.WAIT_3);
		Sync.waitUntilObjectDisappears(driver, "Wait for Materials", By.xpath((".//*[@id='mxui_widget_Progress_0']/div[2]")));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Sync.waitForSeconds(Constants.WAIT_6);
		jse.executeScript("arguments[0].click()", driver.findElement(By.xpath("(//*[text()='OK'])[2]")));
		Sync.waitForSeconds(Constants.WAIT_3);
		jse.executeScript("arguments[0].click()", driver.findElement(By.xpath("(//*[text()='OK'])[1]")));*/
	}
	
	public void selectLocalPlantPurchaseUOMValueDropDown(String strValue) throws InterruptedException {

		// Sync.waitForObject(driver,
		// driver.findElement(By.xpath(".//*[contains(text(),'Edit Local Data
		// Planning')]")));
		Sync.waitForSeconds(Constants.WAIT_5);
		if (Button.verifyObject(dropdownPlantPurchaseUOMValue)) {
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForObject(driver, "Wait for Purchase UOM Select", dropdownPlantPurchaseUOMValue);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on Purchase UOM Select", dropdownPlantPurchaseUOMValue);
			Select purchUOMDropDownSelect = new Select(dropdownPlantPurchaseUOMValue);
			purchUOMDropDownSelect.selectByVisibleText(strValue);

		} else {
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on Purchase UOM Select", dropdownPlantPurchaseUOMValue);
			Select purchUOMDropDownSelect = new Select(dropdownPlantPurchaseUOMValue);
			purchUOMDropDownSelect.selectByVisibleText(strValue);
		}
	}

	public void clickAndSelectPurchaseUOMValueDropDown(String strValue) throws InterruptedException {
		Sync.waitForSeconds(Constants.WAIT_5);
		this.selectLocalPlantPurchaseUOMValueDropDown(strValue);
	}

	public void selectLocalPlantProductionUOMValueDropDown(String strValue) throws InterruptedException {
		// Sync.waitForObject(driver,
		// driver.findElement(By.xpath(".//*[contains(text(),'Edit Local Data
		// Planning')]")));
		Sync.waitForSeconds(Constants.WAIT_5);
		if (Button.verifyObject(dropdownPlantProductionUOMValue)) {
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForObject(driver, "Wait for Production UOM Select", dropdownPlantProductionUOMValue);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on Production UOM Select", dropdownPlantProductionUOMValue);
			Select prodUOMDropDownSelect = new Select(dropdownPlantProductionUOMValue);
			prodUOMDropDownSelect.selectByVisibleText(strValue);

		} else {
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on Production UOM Select", dropdownPlantProductionUOMValue);
			Select prodUOMDropDownSelect = new Select(dropdownPlantProductionUOMValue);
			prodUOMDropDownSelect.selectByVisibleText(strValue);
		}
	}

	public void clickAndSelectProdUOMValueDropDown(String strValue) throws InterruptedException {
		Sync.waitForSeconds(Constants.WAIT_5);
		this.selectLocalPlantProductionUOMValueDropDown(strValue);
	}
	
	public void selectLocalPlantSalesUOMValueDropDown(String strValue) throws InterruptedException {

		// Sync.waitForObject(driver,
		// driver.findElement(By.xpath(".//*[contains(text(),'Edit Local Data
		// Planning')]")));
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_5);
		if (Button.verifyObject(dropdownPlantSalesUOMValue)) {
			Sync.waitForObject(driver, "Wait for Sales UOM Select", dropdownPlantSalesUOMValue);
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on Sales UOM Select", dropdownPlantSalesUOMValue);
			Select salesUOMDropDownSelect = new Select(dropdownPlantSalesUOMValue);
			salesUOMDropDownSelect.selectByVisibleText(strValue);

		} else {
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on Sales UOM Select", dropdownPlantSalesUOMValue);
			Select salesUOMDropDownSelect = new Select(dropdownPlantSalesUOMValue);
			salesUOMDropDownSelect.selectByVisibleText(strValue);
		}
	}

	public void clickAndSelectSalesUOMValueDropDown(String strValue) throws InterruptedException {
		Sync.waitForSeconds(Constants.WAIT_5);
		this.selectLocalPlantSalesUOMValueDropDown(strValue);
	}
	
	public void selectLocalPlantInventoryUOMValueDropDown(String strValue) throws InterruptedException {
		// Sync.waitForObject(driver,
		// driver.findElement(By.xpath(".//*[contains(text(),'Edit Local Data
		// Planning')]")));
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_5);
		if (Button.verifyObject(dropdownPlantInventoryUOMValue)) {
			Sync.waitForObject(driver, "Wait for Sales UOM Select", dropdownPlantInventoryUOMValue);
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on Sales UOM Select", dropdownPlantInventoryUOMValue);
			Select inventoryUOMDropDownSelect = new Select(dropdownPlantInventoryUOMValue);
			inventoryUOMDropDownSelect.selectByVisibleText(strValue);

		} else {
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on Sales UOM Select", dropdownPlantInventoryUOMValue);
			Select inventoryUOMDropDownSelect = new Select(dropdownPlantInventoryUOMValue);
			inventoryUOMDropDownSelect.selectByVisibleText(strValue);
		}

	}

	public void clickAndSelectInventoryUOMValueDropDown(String strValue) throws InterruptedException {
		Sync.waitForSeconds(Constants.WAIT_5);
		this.selectLocalPlantInventoryUOMValueDropDown(strValue);
	}
	
	public void localAddInEditPlantNav() {

		Sync.waitForSeconds(Constants.WAIT_10);
		Sync.waitForObject(driver, textLocalData);

		if (Button.verifyObject(btnNavLocalPlantEdit)) {
			Sync.waitForObject(driver, btnNavLocalPlantEdit);
			Button.jsclick("Editing Plant for Nav", btnNavLocalPlantEdit, driver);
			Sync.waitForSeconds(Constants.WAIT_10);
		} else {
			Sync.waitForSeconds(Constants.WAIT_10);
			Sync.waitForObject(driver, btnNavLocalPlantEdit);
			Button.jsclick("Editing Plant for Nav", btnNavLocalPlantEdit, driver);
			Sync.waitForSeconds(Constants.WAIT_10);
		}

	}
	
	public void selectLocalFinanceInventoryPostingGroupDropDown(String strValue) throws InterruptedException {
		// Sync.waitForSeconds(Constants.WAIT_5);
		// Sync.waitForObject(driver, textFinanceTabNav);
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForObject(driver, dropDownFinanceInventoryPostingGroup);
		if (Button.verifyObject(dropDownFinanceInventoryPostingGroup)) {
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForObject(driver, "Wait for Inventory Posting Group Select", dropDownFinanceInventoryPostingGroup);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on Inventory Posting Group Select", dropDownFinanceInventoryPostingGroup);
			Select inventoryPGDropDownSelect = new Select(dropDownFinanceInventoryPostingGroup);
			inventoryPGDropDownSelect.selectByVisibleText(strValue);

		} else {
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on Inventory Posting Group Select", dropDownFinanceInventoryPostingGroup);
			Select inventoryPGDropDownSelect = new Select(dropDownFinanceInventoryPostingGroup);
			inventoryPGDropDownSelect.selectByVisibleText(strValue);
		}
	}

	public void clickAndSelectInventoryPostingGroupDropDown(String strValue) throws InterruptedException {
		Sync.waitForSeconds(Constants.WAIT_5);
		this.selectLocalFinanceInventoryPostingGroupDropDown(strValue);
	}
	
	public void selectLocalFinanceWHTGroupDropDown(String strValue) throws InterruptedException {

		// Sync.waitForObject(driver, textFinanceTabNav);
		Sync.waitForSeconds(Constants.WAIT_5);
		if (Button.verifyObject(dropDownFinanceWHTValue)) {
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForObject(driver, "Wait for WHT Product Posting Group Select", dropDownFinanceWHTValue);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on WHT Product Posting Group Select", dropDownFinanceWHTValue);
			Select whtGroupDropDownSelect = new Select(dropDownFinanceWHTValue);
			whtGroupDropDownSelect.selectByVisibleText(strValue);

		} else {
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on WHT Product Posting Group Select", dropDownFinanceWHTValue);
			Select whtGroupDropDownSelect = new Select(dropDownFinanceWHTValue);
			whtGroupDropDownSelect.selectByVisibleText(strValue);
		}
	}

	public void clickAndSelectWHTGroupDropDown(String strValue) throws InterruptedException {
		Sync.waitForSeconds(Constants.WAIT_5);
		this.selectLocalFinanceWHTGroupDropDown(strValue);
	}
	
	public void selectLocalFinanceGenProdPostingGroupDropDown(String strValue) throws InterruptedException {
		// Sync.waitForObject(driver, textFinanceTabNav);
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_5);
		if (Button.verifyObject(dropDownFinanceGPPostingGroup)) {
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForObject(driver, "Wait for Gen. Prod. Posting Group Select", dropDownFinanceGPPostingGroup);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on Gen. Prod. Posting Group Select", dropDownFinanceGPPostingGroup);
			Select genProdGroupDropDownSelect = new Select(dropDownFinanceGPPostingGroup);
			genProdGroupDropDownSelect.selectByVisibleText(strValue);

		} else {
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on Gen. Prod. Posting Group Select", dropDownFinanceGPPostingGroup);
			Select genProdGroupDropDownSelect = new Select(dropDownFinanceGPPostingGroup);
			genProdGroupDropDownSelect.selectByVisibleText(strValue);
		}

	}

	public void clickAndSelectGenProdPostingGroupDropDown(String strValue) throws InterruptedException {
		Sync.waitForSeconds(Constants.WAIT_5);
		this.selectLocalFinanceGenProdPostingGroupDropDown(strValue);
	}
}
