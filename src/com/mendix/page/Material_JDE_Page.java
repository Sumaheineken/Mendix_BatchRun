package com.mendix.page;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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


public class Material_JDE_Page {

	/** The driver. */
	WebDriver driver;

	/**
	 * Instantiates a new home page changes
	 *
	 * @param driver the driver
	 */
	public Material_JDE_Page(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}



	@FindBy(how=How.XPATH, using="//*[text()='Local Data']")
	WebElement textLocalData;

	@FindBy(how=How.XPATH, using="(.//*[@class='glyphicon glyphicon-edit'])[5]")
	WebElement BtnEditPlantData;

	@FindBy(how=How.XPATH, using="//*[text()='Finance']/../../../div/div[8]/div/div/div[2]/div[2]//*[text()='Add']")
	WebElement BtnAddPlantData;
	
	@FindBy(how=How.XPATH, using="//*[text()='Finance']/../../../div/div[8]/div/div/div[2]/div[2]//*[text()='Edit']")
	WebElement btnEditPlaning;
	
	
	@FindBy(how=How.XPATH, using="//*[text()='Finance']/../../../div/div[9]/div/div/div[2]/div[2]//*[text()='Edit']")
	WebElement btnEditFinance;


	@FindBy(how=How.XPATH, using=".//*[text()='Finance']/../../../div/div[8]/div/div/div[2]/div[2]//*[text()='Add']")
	WebElement BtnAddPlant;

	@FindBy(how=How.XPATH, using="//button[text()='Select']")
	WebElement BtnPlantSelect;

	@FindBy(how=How.XPATH, using="(.//button[text()='Edit'])[1]")
	WebElement BtnPlantEdit;

	@FindBy(how=How.CSS, using=".btn.btn-primary")
	WebElement btnMsgReqIdOk;

	public boolean enterLocalData() {

//		Sync.waitForSeconds(Constants.WAIT_6);
		Sync.waitUntilObjectDisappears(driver, "Waiting of Create page to Load", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForObject(driver, textLocalData);
		return Button.click("Local Data", textLocalData);
		/*Sync.waitForObject(driver, BtnAddPlant);
		return Button.click("Click Edit button", BtnAddPlant);*/
		
	}
	
	public boolean clickAddPlantData() {

		Sync.waitForObject(driver, BtnAddPlantData);
		return Button.click("Click Edit button", BtnAddPlantData);
		
	}
	public void editPlantPlaning() {
		if(Button.verifyObject(btnEditPlaning)) {
			Sync.waitForSeconds(Constants.WAIT_6);
			WebDriverWait wait=new WebDriverWait(driver,80);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Finance']/../../../div/div[8]/div/div/div[2]/div[2]//*[text()='Edit']")));
			Sync.waitForObject(driver, btnEditPlaning);
			Button.click("Click on Edit Plant Data",btnEditPlaning);
			Sync.waitForSeconds(Constants.WAIT_10);
			Sync.waitForSeconds(Constants.WAIT_5);
		}
		else {
			Sync.waitForSeconds(Constants.WAIT_6);
			Sync.waitForObject(driver, btnEditPlaning);
			Button.click("Click on Edit Plant Data",btnEditPlaning);
		}
	}
	public void editPlantFinance() {
		if(Button.verifyObject(btnEditFinance)) {
			Sync.waitForSeconds(Constants.WAIT_6);
			WebDriverWait wait=new WebDriverWait(driver,80);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Finance']/../../../div/div[9]/div/div/div[2]/div[2]//*[text()='Edit']")));
			Sync.waitForObject(driver, btnEditFinance);
			Button.click("Click on Edit Plant Data",btnEditFinance);
			Sync.waitForSeconds(Constants.WAIT_10);
		}
		else {
			Sync.waitForSeconds(Constants.WAIT_6);
			Sync.waitForObject(driver, btnEditFinance);
			Button.click("Click on Edit Plant Data",btnEditFinance);
		}
	}



	public boolean enterPlantData(String strValue) {

		Sync.waitForSeconds(Constants.WAIT_2);
		Sync.waitUntilObjectDisappears(driver, "Waiting of Create page to Load", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForObject(driver, BtnAddPlant);
		Button.click("Local Plant Data", BtnAddPlant);


		WebDriverWait wait= new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='"+strValue+"']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='"+strValue+"']")));
		driver.findElement(By.xpath("//div[text()='"+strValue+"']")).click();
		return Button.jsclick("Click Select Button", BtnPlantSelect, driver);

	}

	public void clickEditPlanningData() throws AWTException, IOException
	{
		Sync.waitForSeconds(Constants.WAIT_6);
		driver.findElement(By.xpath("(//button[text()='Edit'])[5]")).click();
		Sync.waitForSeconds(Constants.WAIT_3);
		Sync.waitUntilObjectDisappears(driver, "Wait for Materials", By.xpath((".//*[@id='mxui_widget_Progress_0']/div[2]")));

	}

	public void selectRoundingPrecision(String strValue)
	{

		WebElement dropdown =driver.findElement(By.xpath(".//*[text()='Rounding Precision']/../div/div/select"));
		Sync.waitForObjectFluent(driver, dropdown);
		Select roundPrecisiondropDown= new Select(dropdown);
		roundPrecisiondropDown.selectByVisibleText(strValue);//"0.01"
		Sync.waitForSeconds(Constants.WAIT_1);

	}



	public void selectStockingTypeLocal(String strValue) throws InterruptedException
	{
		Sync.waitForSeconds(Constants.WAIT_10);
		Sync.waitForSeconds(Constants.WAIT_5);
		
	
		WebElement stockingTypeDropdown =driver.findElement(By.xpath(".//*[text()='Stocking Type Local']/../div/div/select"));
		if(DropDown.verifyObject(stockingTypeDropdown)) {
			Sync.waitForObjectFluent(driver, stockingTypeDropdown);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Waiting for clicking on Stocking type Local", stockingTypeDropdown);			
			Select stockingTypeLocaldropDown= new Select(stockingTypeDropdown);			
			stockingTypeLocaldropDown.selectByVisibleText(strValue);//"P, Purchased"
			Sync.waitForSeconds(Constants.WAIT_10);
	  }
	  else {
		
		  Sync.waitForObjectFluent(driver, stockingTypeDropdown);
		  Button.click("Waiting for clicking on Stocking type Local", stockingTypeDropdown);
		  Select stockingTypeLocaldropDown= new Select(stockingTypeDropdown);
		  Sync.waitForSeconds(Constants.WAIT_5);
		  stockingTypeLocaldropDown.selectByVisibleText(strValue);//"P, Purchased"
		  Sync.waitForSeconds(Constants.WAIT_5);
	   
	  }
}
	public void selectingStockingTypeLocal(String strValue) throws InterruptedException {
		Sync.waitForSeconds(Constants.WAIT_5);
		this.selectStockingTypeLocal(strValue);
	}
	

	public void selectCommitmentDateMethod(String strValue) throws InterruptedException
	{
		Sync.waitForSeconds(Constants.WAIT_10);
		WebElement commitmentDateMethod =driver.findElement(By.xpath(".//*[text()='Commitment Date Method']/../div/div/select"));
		if(DropDown.verifyObject(commitmentDateMethod)) {
			Sync.waitForObjectFluent(driver, commitmentDateMethod);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Waiting for clicking on Commitment Date Method", commitmentDateMethod);			
			Select commitmentDateMethoddropDown= new Select(commitmentDateMethod);
			commitmentDateMethoddropDown.selectByVisibleText(strValue);//"3, Best Before Date"
			Sync.waitForSeconds(Constants.WAIT_10);
		}
		else {
			Sync.waitForObjectFluent(driver, commitmentDateMethod);
			Button.click("Waiting for clicking on Commitment Date Method", commitmentDateMethod);
			Select commitmentDateMethoddropDown= new Select(commitmentDateMethod);
			commitmentDateMethoddropDown.selectByVisibleText(strValue);//"3, Best Before Date"
			Sync.waitForSeconds(Constants.WAIT_5);
		}
	}
	
	public void selectingCommitmentDateMethod(String strValue) throws InterruptedException {
		Sync.waitForSeconds(Constants.WAIT_5);
		this.selectCommitmentDateMethod(strValue);
		
	}

	public void selectLotCalculationAlgorithm(String strValue) throws InterruptedException
	{
		Sync.waitForSeconds(Constants.WAIT_10);
		WebElement  lotCalculationAlgorithm=driver.findElement(By.xpath(".//*[text()='Lot Calculation Algorithm']/../div/div/select"));
		if(DropDown.verifyObject(lotCalculationAlgorithm)) {
			Sync.waitForSeconds(Constants.WAIT_3);
			Sync.waitForObjectFluent(driver, lotCalculationAlgorithm);
			Button.click("Waiting for clicking on Lot Caliculation Algorithm", lotCalculationAlgorithm);			
			Select lotCalculationAlgorithmdropDown= new Select(lotCalculationAlgorithm);
			lotCalculationAlgorithmdropDown.selectByVisibleText(strValue);//"01, Bulk Product Related Materials"
			Sync.waitForSeconds(Constants.WAIT_10);
		}
		else {
			Sync.waitForObjectFluent(driver, lotCalculationAlgorithm);
			Button.click("Waiting for clicking on Lot Caliculation Algorithm", lotCalculationAlgorithm);
			Select lotCalculationAlgorithmdropDown= new Select(lotCalculationAlgorithm);
			lotCalculationAlgorithmdropDown.selectByVisibleText(strValue);//"01, Bulk Product Related Materials"
			Sync.waitForSeconds(Constants.WAIT_2);
		}
	}
	public void selectingLotCalculationAlgorithm(String strValue) throws InterruptedException {
		Sync.waitForSeconds(Constants.WAIT_5);
		this.selectingLotCalculationAlgorithm(strValue);
	}

	
	public void selectLotProcessType(String strValue) throws InterruptedException
	{
		Sync.waitForSeconds(Constants.WAIT_10);
		WebElement lotProcessType =driver.findElement(By.xpath(".//*[text()='Lot Process Type']/../div/div/select"));
		if(DropDown.verifyObject(lotProcessType)) {
			Sync.waitForSeconds(Constants.WAIT_3);
			Sync.waitForObjectFluent(driver, lotProcessType);
			Button.click("Waiting for clicking on Lot Process Type", lotProcessType);			
			Select lotProcessTypedropDown= new Select(lotProcessType);
			lotProcessTypedropDown.selectByVisibleText(strValue);//"3, Lots must be Assigned Manually"
			Sync.waitForSeconds(Constants.WAIT_10);
		}
		else
		 {
			Sync.waitForSeconds(Constants.WAIT_3);
			Button.click("Waiting for clicking on Lot Process Type", lotProcessType);
			Select lotProcessTypedropDown= new Select(lotProcessType);
			lotProcessTypedropDown.selectByVisibleText(strValue);//"3, Lots must be Assigned Manually"
			Sync.waitForSeconds(Constants.WAIT_2);
		 }
	}
	public void selectingLotProcessType(String strValue) throws InterruptedException {
		Sync.waitForSeconds(Constants.WAIT_5);
		this.selectingLotProcessType(strValue);
	}
	public void selectLotExpiratonDateCalculationMethod(String strValue) throws InterruptedException
	{
		Sync.waitForSeconds(Constants.WAIT_10);
		WebElement  LotExpiratonDateCalculationMethod=driver.findElement(By.xpath(".//*[text()='Lot Expiraton Date Calculation Method']/../div/div/select"));
		if(DropDown.verifyObject(LotExpiratonDateCalculationMethod)) {
			Sync.waitForObjectFluent(driver,LotExpiratonDateCalculationMethod);
			Sync.waitForSeconds(Constants.WAIT_3);
			Button.click("Waiting for clicking on Lot Expiraton Date Calculation Method ", LotExpiratonDateCalculationMethod);			
			Select lotExpiratonDateCalculationMethoddropDown= new Select(LotExpiratonDateCalculationMethod);
			lotExpiratonDateCalculationMethoddropDown.selectByVisibleText(strValue);//"1, On Hand Date"
			Sync.waitForSeconds(Constants.WAIT_10);			
		}
		else {
			Sync.waitForObjectFluent(driver,LotExpiratonDateCalculationMethod);
			Button.click("Waiting for clicking on Lot Expiraton Date Calculation Method", LotExpiratonDateCalculationMethod);
			Select lotExpiratonDateCalculationMethoddropDown= new Select(LotExpiratonDateCalculationMethod);
			lotExpiratonDateCalculationMethoddropDown.selectByVisibleText(strValue);//"1, On Hand Date"
			Sync.waitForSeconds(Constants.WAIT_2);		
		}
	}
	public void selectingLotExpiratonDateCalculationMethod(String strValue) throws InterruptedException {
		Sync.waitForSeconds(Constants.WAIT_5);
		this.selectingLotExpiratonDateCalculationMethod(strValue);
	}
	public void selectMasterPlanningFamily(String strValue) throws InterruptedException
	{
		Sync.waitForSeconds(Constants.WAIT_10);
		WebElement  MasterPlanningFamily=driver.findElement(By.xpath(".//*[text()='Master Planning Family']/../div/div/select"));
		if(DropDown.verifyObject(MasterPlanningFamily)) {
			Sync.waitForObjectFluent(driver, MasterPlanningFamily);
			Sync.waitForSeconds(Constants.WAIT_3);
			Button.click("Waiting for clicking on Master Planning Family", MasterPlanningFamily);			
			Select masterPlanningFamilydropDown= new Select(MasterPlanningFamily);
			masterPlanningFamilydropDown.selectByVisibleText(strValue);//"097, Typ. 09 - S&OP - MRP"
			Sync.waitForSeconds(Constants.WAIT_10);
		}
		else {
			Sync.waitForObjectFluent(driver, MasterPlanningFamily);
			Sync.waitForSeconds(Constants.WAIT_3);
			Button.click("Waiting for clicking on Master Planning Family", MasterPlanningFamily);
			Select masterPlanningFamilydropDown= new Select(MasterPlanningFamily);
			masterPlanningFamilydropDown.selectByVisibleText(strValue);//"097, Typ. 09 - S&OP - MRP"
			Sync.waitForSeconds(Constants.WAIT_5);
		}
	}
	public void selectingMasterPlanningFamily(String strValue) throws InterruptedException {
		Sync.waitForSeconds(Constants.WAIT_5);
		this.selectMasterPlanningFamily(strValue);
		
	}
	
	public void selectPlanningCode(String strValue) throws InterruptedException
	{
		Sync.waitForSeconds(Constants.WAIT_10);
		WebElement PlanningCode =driver.findElement(By.xpath(".//*[text()='Planning Code']/../div/div/select"));
		if(DropDown.verifyObject(PlanningCode)) {
			Sync.waitForSeconds(Constants.WAIT_3);
			Sync.waitForObjectFluent(driver, PlanningCode);
			Button.click("Waiting for clicking on Planning Code", PlanningCode);			
			Select planningCodedropDown= new Select(PlanningCode);
			planningCodedropDown.selectByVisibleText(strValue);//"0, Not Planned"
			Sync.waitForSeconds(Constants.WAIT_10);
		}
		else {
			Sync.waitForObjectFluent(driver, PlanningCode);
			Button.click("Waiting for clicking on Planning Code", PlanningCode);
			Select planningCodedropDown= new Select(PlanningCode);
			planningCodedropDown.selectByVisibleText(strValue);//"0, Not Planned"
			Sync.waitForSeconds(Constants.WAIT_2);
		}
	}
	public void selectingPlanningCode(String strValue) throws InterruptedException {
		Sync.waitForSeconds(Constants.WAIT_5);
		this.selectPlanningCode(strValue);
	}

	public void clickLocalAction()
	{
		//		Sync.waitForSeconds(Constants.WAIT_3);
		Sync.waitForSeconds(Constants.WAIT_3);
		Sync.waitUntilObjectDisappears(driver, "Wait for Materials", By.xpath((".//*[@id='mxui_widget_Progress_0']/div[2]")));
		Sync.waitForElementToBeClickable(driver, driver.findElement(By.xpath(".//*[@class='glyphicon glyphicon-flash']")));
		driver.findElement(By.xpath(".//*[@class='glyphicon glyphicon-flash']")).click();
	}

	public void clickValidatLocalData()
	{

		Sync.waitForSeconds(Constants.WAIT_5);
		driver.findElement(By.xpath(".//*[@class='glyphicon glyphicon-check']")).click();


	}

	public void clickValidateLocalData_Planning()
	{

		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForObject(driver, "Wait for Planning Data to Load", driver.findElement(By.xpath(".//*[@class='glyphicon glyphicon-check']")));
		driver.findElement(By.xpath(".//*[@class='glyphicon glyphicon-check']")).click();


	}



	public void clickSaveButton()
	{
		Sync.WaitForPageLoad(driver);
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitUntilObjectDisappears(driver, "Wait for Save button", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForObject(driver, "Wait for Click Save button", driver.findElement(By.xpath(".//button[text()='Save']")));
		Button.jsclick("Click Save Button", driver.findElement(By.xpath(".//button[text()='Save']")), driver);

	}

	public void clickPlanningSaveButton()
	{
		Sync.WaitForPageLoad(driver);
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitUntilObjectDisappears(driver, "Wait for Save button", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForObject(driver, "Wait for Click Save button", driver.findElement(By.xpath(".//button[text()='Save']")));
		Button.jsclick("Click Save Button", driver.findElement(By.xpath(".//button[text()='Save']")), driver);

	}



	public void clickFinancetab() throws InterruptedException
	{

		WebElement waitElement = null;
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
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//a[text()='Finance']"))
					);
		}
		/*Sync.waitUntilObjectDisappears(driver, "Wait for Save button", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.WaitForPageLoad(driver);
		Sync.waitForSeconds(Constants.WAIT_6);
		Sync.waitUntilObjectDisappears(driver, "Wait for Save button", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForElementToBeClickable(driver, driver.findElement(By.cssSelector("div[id^='mxui_widget_TabContainer']:nth-child(1) > ul:nth-child(1) >li:nth-child(2)>a")));*/
		Button.jsclick("Click Finance Tab", driver.findElement(By.xpath("//a[text()='Finance']")), driver);
	}
	public void clickBackAction()
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		driver.findElement(By.cssSelector(".glyphicon.glyphicon-backward")).click();
	}

	public void clickProceedAction()
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		driver.findElement(By.xpath("//*[text()='Proceed']")).click();
	}

	public void clickPlantData(String strValue)
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_5);
		//		driver.findElement(By.xpath("(.//*[text()='Plant'])[1]/../../../../../../table/tbody/tr[1]/td[1]"));

		Actions action = new Actions(driver);
		//Find the targeted element
		WebElement ele = driver.findElement(By.xpath("//div[text()='"+strValue+"']"));
		//Here I used JavascriptExecutor interface to scroll down to the targeted element
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ele);
		//used doubleClick(element) method to do double click action
		action.doubleClick(ele).build().perform();
		//		 driver.findElement(By.xpath("//div[text()='10000']")).sendKeys(Keys.RETURN);
	}



	public void clickEditFinanceData() throws AWTException, IOException
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitUntilObjectDisappears(driver, "Wait for Save button", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForElementToBeClickable(driver, driver.findElement(By.xpath("(//*[text()='Add'])[2]/../button[2]/span")));
		Button.jsclick("Click Edit Finance Button", driver.findElement(By.xpath("(//*[text()='Add'])[2]/../button[2]/span")), driver);

	}

	public void selectVATPostingGroup(String strValue)
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_3);
		WebElement VATPostingGroup =driver.findElement(By.xpath("//*[text()='VAT Prod. Posting Group']/../div/div/select"));
		if(DropDown.verifyObject(VATPostingGroup)) {
			Sync.waitForObject(driver, "Wait for VAT posting group Select", VATPostingGroup);
			Sync.waitForElementToBeClickable(driver, VATPostingGroup);
			Button.click("Wait for VAT posting group Select", VATPostingGroup);
			Select roundVATPostingGroupDown= new Select(VATPostingGroup);
			roundVATPostingGroupDown.selectByVisibleText(strValue);
		}//"NO_VAT, 0% VAT"
		else {
			Sync.waitForObject(driver, "Wait for VAT posting group Select", VATPostingGroup);
			Sync.waitForElementToBeClickable(driver, VATPostingGroup);
			Button.click("Wait for VAT posting group Select", VATPostingGroup);
			Select roundVATPostingGroupDown= new Select(VATPostingGroup);
			roundVATPostingGroupDown.selectByVisibleText(strValue);
		}

	}
	public void selectGLClass()
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_3);
		WebElement  GLClass=driver.findElement(By.xpath("//*[text()='G/L Class']/../div/div/select"));
		if(DropDown.verifyObject(GLClass)) {		
			Sync.waitForObject(driver, "Wait for GL Class", GLClass);
			Sync.waitForElementToBeClickable(driver, GLClass);
			Button.click("Wait for GL Class", GLClass);
			Select roundVATPostingGroupDown= new Select(GLClass);
			roundVATPostingGroupDown.selectByIndex(1);//"CTDB, CTS - DB Inst Non-Cap"
			Sync.waitForSeconds(Constants.WAIT_10);
		}
		else {
			Sync.waitForObject(driver, "Wait for VAT posting group Select", GLClass);
			Sync.waitForElementToBeClickable(driver, GLClass);
			Button.click("Wait for VAT posting group Select", GLClass);
			Select roundVATPostingGroupDown= new Select(GLClass);
			roundVATPostingGroupDown.selectByIndex(1);//"CTDB, CTS - DB Inst Non-Cap"
		}

	}

	public void selectCostingMethodPurchasing(String strValue) throws InterruptedException
	{
		Sync.waitForSeconds(Constants.WAIT_10);
		
		WebElement CostingMethodPurchasing =driver.findElement(By.xpath("//*[text()='Costing Method - Purchasing']/../div/div/select"));
		if(DropDown.verifyObject(CostingMethodPurchasing)) {
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForObjectFluent(driver, CostingMethodPurchasing);
			Sync.waitForObject(driver, "Wait for click on Cost Method purchasing", CostingMethodPurchasing);
			Sync.waitForElementToBeClickable(driver, CostingMethodPurchasing);
			Button.click("Wait for click on Cost Method purchasing", CostingMethodPurchasing);			
			Select roundVATPostingGroupDown= new Select(CostingMethodPurchasing);
			roundVATPostingGroupDown.selectByVisibleText(strValue);//"07, Standard"
			Sync.waitForSeconds(Constants.WAIT_5);
		}
		else {
			Sync.waitForObject(driver, "Wait for click on Cost Method purchasing", CostingMethodPurchasing);
			Sync.waitForElementToBeClickable(driver, CostingMethodPurchasing);
			Button.click("Wait for click on Cost Method purchasing", CostingMethodPurchasing);
			Select roundVATPostingGroupDown= new Select(CostingMethodPurchasing);
			roundVATPostingGroupDown.selectByVisibleText(strValue);//"07, Standard"
		}

	}
	public void selectingCostingMethodPurchasing(String strValue) throws InterruptedException {
		Sync.waitForSeconds(Constants.WAIT_5);
		this.selectCostingMethodPurchasing(strValue);
	}

	public void selectCostingMethodSales(String strValue) throws InterruptedException
	{
		Sync.waitForSeconds(Constants.WAIT_10);
		
		WebElement CostingMethodSales =driver.findElement(By.xpath("//*[text()='Costing Method - Sales']/../div/div/select"));
		if(DropDown.verifyObject(CostingMethodSales)) {
			Sync.waitForObjectFluent(driver, CostingMethodSales);
			Sync.waitForObject(driver, "Wait for click on Cost Method Sales", CostingMethodSales);
			Sync.waitForElementToBeClickable(driver, CostingMethodSales);
			Button.click("Wait for click on Cost Method Sales", CostingMethodSales);			
			Select roundVATPostingGroupDown= new Select(CostingMethodSales);
			roundVATPostingGroupDown.selectByVisibleText(strValue);//"08, Purchasing-Base Cost No Adds"
			Sync.waitForSeconds(Constants.WAIT_5);
		}
		else {
			Sync.waitForObject(driver, "Wait for click on Cost Method Sales", CostingMethodSales);
			Sync.waitForElementToBeClickable(driver, CostingMethodSales);
			Button.click("Wait for click on Cost Method Sales", CostingMethodSales);
			Select roundVATPostingGroupDown= new Select(CostingMethodSales);
			roundVATPostingGroupDown.selectByVisibleText(strValue);//"08, Purchasing-Base Cost No Adds"
		}

	}
	public void selectingCostingMethodSales(String strValue) throws InterruptedException {
		Sync.waitForSeconds(Constants.WAIT_5);
		this.selectCostingMethodSales(strValue);
	}




	public void selectItemDepositGroupCode(String strValue)
	{
		WebElement dropdown =driver.findElement(By.xpath("//*[text()='Item Deposit Group Code']/../div/div/select"));
		Select roundVATPostingGroupDown= new Select(dropdown);
		roundVATPostingGroupDown.selectByVisibleText(strValue);//"02, Keg"

	}

	public void submitGlobalRequestTest() throws InterruptedException {

		//		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.WaitForPageLoad(driver);
		//		Sync.waitForObject(driver, "Wait for Submit Global Request", driver.findElement(By.xpath("//*[text()='Local Actions:']/../div[2]/div[2]/div[1]/div[1]/div/div[1]/div[1]/div/div/div/div[1]/div/button/span")));
		Sync.waitForElementToBeClickable(driver, driver.findElement(By.xpath("//*[text()='Local Actions:']/../div[2]/div[2]/div[1]/div[1]/div/div[1]/div[1]/div/div/div/div[1]/div/button/span")));
		Button.jsclick("Click Global submit Global Request", driver.findElement(By.xpath("//*[text()='Local Actions:']/../div[2]/div[2]/div[1]/div[1]/div/div[1]/div[1]/div/div/div/div[1]/div/button/span")), driver);
		Sync.waitForSeconds(Constants.WAIT_2);
		Sync.waitForSeconds(Constants.WAIT_5);

	}

	public void submitGlobalLocalRequestTest() throws InterruptedException {

		TimeUnit.MINUTES.sleep(2);
		Sync.waitForObject(driver, "Wait for Submit Global Request", driver.findElement(By.xpath("(//span[@class='glyphicon glyphicon-save'])[2]")));
		Sync.waitForElementToBeClickable(driver, driver.findElement(By.xpath("(//span[@class='glyphicon glyphicon-save'])[2]")));
		Button.jsclick("Click Global submit Global Request", driver.findElement(By.xpath("(//span[@class='glyphicon glyphicon-save'])[2]")), driver);
//		Button.click("Click Global submit Global Request", driver.findElement(By.xpath("(//span[@class='glyphicon glyphicon-save'])[2]")));
		Sync.waitForSeconds(Constants.WAIT_2);
		Sync.waitForSeconds(Constants.WAIT_5);

	}


	public void clickSiteNewTab(){


		Sync.waitUntilObjectDisappears(driver, "Wait for Save button", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.WaitForPageLoad(driver);
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitUntilObjectDisappears(driver, "Wait for Save button", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
//		Sync.waitForObjectFluent(driver, driver.findElement(By.cssSelector("div[id^='mxui_widget_TabContainer']:nth-child(1) > ul:nth-child(1) >li:nth-child(3)>a")));
		Button.jsclick("Click Site Tab", driver.findElement(By.cssSelector("div[id^='mxui_widget_TabContainer']:nth-child(1) > ul:nth-child(1) >li:nth-child(3)>a")), driver);
	}
	
	public void clickSiteNewButton(){

		Sync.waitForObject(driver, "Wait for Site New Button", driver.findElement(By.xpath("//button[text()='New']")));
		Sync.waitForSeconds(Constants.WAIT_2);
		Button.click("Click New Button", driver.findElement(By.xpath("//button[text()='New']")));
		Sync.waitForSeconds(Constants.WAIT_2);
	
	}

	public void selectLocationCode(String strValue)
	{
		/*WebElement dropdown =driver.findElement(By.xpath("//*[text()='Item Deposit Group Code']/../div/div/select"));
		Select LocationCodeDropDown= new Select(dropdown);
		LocationCodeDropDown.selectByVisibleText("DZ01, Brewery Rouiba");
		 */		
		Sync.waitUntilObjectDisappears(driver, "Wait for Location Code Select", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForSeconds(Constants.WAIT_5);
		WebElement dropdown =driver.findElement(By.xpath("//*[text()='Location Code']/../div/div/select"));
		Sync.waitForObject(driver, "Wait for Location Code Select", dropdown);
		Button.click("Wait for Location Code Select", dropdown);
		Select roundVATPostingGroupDown= new Select(dropdown);
		roundVATPostingGroupDown.selectByVisibleText(strValue);//"DZ01, Brewery Rouiba"
	}

	public void selectReplenishmentSystem(String strValue)
	{
		//		WebElement dropdown =driver.findElement(By.xpath("//*[text()='Replenishment System']/../div/div/select"));
		//		Select LocationCodeDropDown= new Select(dropdown);
		//		LocationCodeDropDown.selectByVisibleText("2, Transfer");

		Sync.waitUntilObjectDisappears(driver, "Wait for Replenishment System", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForSeconds(Constants.WAIT_5);
		WebElement dropdown =driver.findElement(By.xpath("//*[text()='Replenishment System']/../div/div/select"));
		Sync.waitForObject(driver, "Wait for Location Code Select", dropdown);
		Button.click("Wait for Location Code Select", dropdown);
		Select roundVATPostingGroupDown= new Select(dropdown);
		roundVATPostingGroupDown.selectByVisibleText(strValue);//"2, Transfer"

	}

	public void clickSiteValidateButton(){


		Sync.waitForSeconds(Constants.WAIT_2);
		Sync.waitForElementToBeClickable(driver, driver.findElement(By.xpath("//*[text()='Validate Local Data']")));
		Button.click("Click New Button", driver.findElement(By.xpath("//*[text()='Validate Local Data']")));
		Sync.waitForSeconds(Constants.WAIT_2);

	}

	public void clickSiteSaveButton(){

		Sync.waitForSeconds(Constants.WAIT_2);
		Sync.waitForElementToBeClickable(driver, driver.findElement(By.cssSelector(".glyphicon.glyphicon-ok")));
		Button.click("Click New Button", driver.findElement(By.cssSelector(".glyphicon.glyphicon-ok")));
		Sync.waitForSeconds(Constants.WAIT_2);

	}

	public void scrolltoRoundingPrecision() throws InterruptedException {

		Point hoverItem =driver.findElement(By.xpath(".//*[text()='Rounding Precision']")).getLocation();
		((JavascriptExecutor)driver).executeScript("return window.title;");    
		Thread.sleep(6000);
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,"+(hoverItem.getY())+");");
	}

	public void clickEditSiteData() throws AWTException, IOException
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitUntilObjectDisappears(driver, "Wait for Location Code Select", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Button.jsclick("Click Edit Site Button", driver.findElement(By.xpath("(//*[text()='Add'])[3]/../button[2]/span")), driver);
	}
   public void SelectingPlant() {
		WebDriverWait wait = new WebDriverWait(driver,100);
		Sync.waitForSeconds(Constants.WAIT_5);
		//Sync.waitForSeconds(Constants.WAIT_2);
		driver.findElement(By.xpath("(.//tbody[@class='mx-datagrid-body'])[15]/tr[2]")).click();
		System.out.println("Plant Get Selected");
	}
	public void RemovePlant() {
		WebDriverWait wait = new WebDriverWait(driver,100);
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_2);
		Sync.waitForElementToBeClickable(driver, driver.findElement(By.xpath("//*[text()='Finance']/../../../div/div[8]/div/div/div[2]/div[2]//*[text()='Remove']")));
		Button.click("Click Remove Button",driver.findElement(By.xpath("//*[text()='Finance']/../../../div/div[8]/div/div/div[2]/div[2]//*[text()='Remove']")));
		System.out.println("plant get removed");
	}
	public void selectLocationCode()
	{
		/*WebElement dropdown =driver.findElement(By.xpath("//*[text()='Item Deposit Group Code']/../div/div/select"));
		Select LocationCodeDropDown= new Select(dropdown);
		LocationCodeDropDown.selectByVisibleText("DZ01, Brewery Rouiba");
*/		
		Sync.waitUntilObjectDisappears(driver, "Wait for Location Code Select", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForSeconds(Constants.WAIT_5);
		WebElement dropdown =driver.findElement(By.xpath("//*[text()='Location Code']/../div/div/select"));
		Sync.waitForObject(driver, "Wait for Location Code Select", dropdown);
		Button.click("Wait for Location Code Select", dropdown);
		Select roundVATPostingGroupDown= new Select(dropdown);
		roundVATPostingGroupDown.selectByVisibleText("DZ01, Brewery Rouiba");
	}
	
	public void selectReplenishmentSystem()
	{
//		WebElement dropdown =driver.findElement(By.xpath("//*[text()='Replenishment System']/../div/div/select"));
//		Select LocationCodeDropDown= new Select(dropdown);
//		LocationCodeDropDown.selectByVisibleText("2, Transfer");
		
		Sync.waitUntilObjectDisappears(driver, "Wait for Replenishment System", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForSeconds(Constants.WAIT_5);
		WebElement dropdown =driver.findElement(By.xpath("//*[text()='Replenishment System']/../div/div/select"));
		Sync.waitForObject(driver, "Wait for Location Code Select", dropdown);
		Button.click("Wait for Location Code Select", dropdown);
		Select roundVATPostingGroupDown= new Select(dropdown);
		roundVATPostingGroupDown.selectByVisibleText("2, Transfer");
		
	}
	public void SelectPlant() { 
		WebDriverWait wait=new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Select']")));
		System.out.println("Witing for Select button");
		Sync.waitForSeconds(Constants.WAIT_2);
		Sync.waitForObject(driver, BtnPlantSelect);
		if(Button.verifyObject(BtnPlantSelect))
		{
			Sync.waitForSeconds(Constants.WAIT_2);
			Button.jsclick("Click Select Button",BtnPlantSelect,driver);
			
		}
		else 
		{   	
			Sync.waitForSeconds(Constants.WAIT_2);
			Button.jsclick("Click Select Button",BtnPlantSelect,driver);
		}
	}
	public void clickEditPlanningData_Extend() throws AWTException, IOException
	{
		Sync.waitForSeconds(Constants.WAIT_6);
		WebDriverWait wait= new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" .//*[text()='Finance']/../../../div/div[8]/div/div/div[2]/div[2]//*[text()='Edit']")));
		driver.findElement(By.xpath(" .//*[text()='Finance']/../../../div/div[8]/div/div/div[2]/div[2]//*[text()='Edit']")).click();
		Sync.waitForSeconds(Constants.WAIT_3);
		Sync.waitUntilObjectDisappears(driver, "Wait for Materials", By.xpath((".//*[@id='mxui_widget_Progress_0']/div[2]")));
		
	}
	
	public void clickFinancetabJDE() throws InterruptedException
	{
		Sync.waitForSeconds(Constants.WAIT_6);
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
		*/      WebDriverWait wait = new WebDriverWait(driver, 120);
		      wait.until(ExpectedConditions.visibilityOfElementLocated(
		    		  By.xpath("//a[text()='Finance']"))
		            );
		       // }
		/*Sync.waitUntilObjectDisappears(driver, "Wait for Save button", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.WaitForPageLoad(driver);
		Sync.waitForSeconds(Constants.WAIT_6);
		Sync.waitUntilObjectDisappears(driver, "Wait for Save button", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForElementToBeClickable(driver, driver.findElement(By.cssSelector("div[id^='mxui_widget_TabContainer']:nth-child(1) > ul:nth-child(1) >li:nth-child(2)>a")));*/
		Button.jsclick("Click Finance Tab", driver.findElement(By.xpath("//a[text()='Finance']")), driver);
	}
	
	/*public void selectGLClass()
	{
		Sync.waitForSeconds(Constants.WAIT_1);
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='G/L Class']")));
		Sync.waitForSeconds(Constants.WAIT_5);
		
		WebElement dropdown =driver.findElement(By.xpath("//*[text()='G/L Class']/../div/div/select"));
		Sync.waitForObject(driver, "Wait for VAT posting group Select", dropdown);
		Sync.waitForElementToBeClickable(driver, dropdown);
		Button.click("Wait for VAT posting group Select", dropdown);
		Select roundVATPostingGroupDown= new Select(dropdown);
		roundVATPostingGroupDown.selectByIndex(1);
		
	}*/
	
	public void selectCostingMethodPurchasing()
	{
		//Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_3);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Costing Method - Purchasing']/../div/div/select")));
		WebElement dropdown =driver.findElement(By.xpath("//*[text()='Costing Method - Purchasing']/../div/div/select"));
		Sync.waitForObject(driver, "Wait for VAT posting group Select", dropdown);
		Sync.waitForElementToBeClickable(driver, dropdown);
		Button.click("Wait for VAT posting group Select", dropdown);
		Select roundVATPostingGroupDown= new Select(dropdown);
		roundVATPostingGroupDown.selectByVisibleText("07, Standard");
		
	}
	
	public void selectCostingMethodSales()
	{
		Sync.waitForSeconds(Constants.WAIT_2);
		//Sync.waitForSeconds(Constants.WAIT_3);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Costing Method - Sales']")));
		
		WebElement dropdown =driver.findElement(By.xpath("//*[text()='Costing Method - Sales']/../div/div/select"));
		Sync.waitForObject(driver, "Wait for VAT posting group Select", dropdown);
		Sync.waitForElementToBeClickable(driver, dropdown);
		Button.click("Wait for VAT posting group Select", dropdown);
		Select roundVATPostingGroupDown= new Select(dropdown);
		roundVATPostingGroupDown.selectByVisibleText("08, Purchasing-Base Cost No Adds");
		
	}
	public void selectStockingTypeLocal()
	{
		Sync.waitForSeconds(Constants.WAIT_6);

      WebDriverWait wait = new WebDriverWait(driver,50);
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[text()='Stocking Type Local']/../div/div/select")));
		
		WebElement dropdown =driver.findElement(By.xpath(".//*[text()='Stocking Type Local']/../div/div/select"));
		Sync.waitForObjectFluent(driver, dropdown);
//		dropdown.click();
		Select stockingTypeLocaldropDown= new Select(dropdown);
		Sync.waitForSeconds(Constants.WAIT_1);
		stockingTypeLocaldropDown.selectByVisibleText("P, Purchased");
		Sync.waitForSeconds(Constants.WAIT_1);
	}
	
	public void selectCommitmentDateMethod()
	{
		Sync.waitForSeconds(Constants.WAIT_3);
		WebDriverWait wait = new WebDriverWait(driver,50);
	      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[text()='Commitment Date Method']/../div/div/select")));
		WebElement dropdown =driver.findElement(By.xpath(".//*[text()='Commitment Date Method']/../div/div/select"));
		Sync.waitForObjectFluent(driver, dropdown);
		Select commitmentDateMethoddropDown= new Select(dropdown);
		commitmentDateMethoddropDown.selectByVisibleText("3, Best Before Date");
		Sync.waitForSeconds(Constants.WAIT_1);
	}
	
	public void selectLotCalculationAlgorithm()
	{
		Sync.waitForSeconds(Constants.WAIT_3);
		WebDriverWait wait = new WebDriverWait(driver,50);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[text()='Lot Calculation Algorithm']/../div/div/select")));
		WebElement dropdown =driver.findElement(By.xpath(".//*[text()='Lot Calculation Algorithm']/../div/div/select"));
		Sync.waitForObjectFluent(driver, dropdown);
		Select lotCalculationAlgorithmdropDown= new Select(dropdown);
		lotCalculationAlgorithmdropDown.selectByVisibleText("01, Bulk Product Related Materials");
		Sync.waitForSeconds(Constants.WAIT_1);
	}
	public void selectLotProcessType()
	{
		Sync.waitForSeconds(Constants.WAIT_3);
		WebDriverWait wait = new WebDriverWait(driver,50);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[text()='Lot Process Type']/../div/div/select")));
		WebElement dropdown =driver.findElement(By.xpath(".//*[text()='Lot Process Type']/../div/div/select"));
		Sync.waitForObjectFluent(driver, dropdown);
		Select lotProcessTypedropDown= new Select(dropdown);
		lotProcessTypedropDown.selectByVisibleText("3, Lots must be Assigned Manually");
		Sync.waitForSeconds(Constants.WAIT_1);
	}
	public void selectLotExpiratonDateCalculationMethod()
	{
		Sync.waitForSeconds(Constants.WAIT_3);
		WebDriverWait wait= new WebDriverWait(driver, 20);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[text()='Lot Expiraton Date Calculation Method']/../div/div/select")));
		WebElement dropdown =driver.findElement(By.xpath(".//*[text()='Lot Expiraton Date Calculation Method']/../div/div/select"));
		Sync.waitForObjectFluent(driver, dropdown);
		Select lotExpiratonDateCalculationMethoddropDown= new Select(dropdown);
		lotExpiratonDateCalculationMethoddropDown.selectByVisibleText("1, On Hand Date");
		Sync.waitForSeconds(Constants.WAIT_1);
	}
	public void selectMasterPlanningFamily()
	{
		Sync.waitForSeconds(Constants.WAIT_3);
		WebDriverWait wait= new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[text()='Lot Expiraton Date Calculation Method']/../div/div/select")));
		WebElement dropdown =driver.findElement(By.xpath(".//*[text()='Master Planning Family']/../div/div/select"));
		Sync.waitForObjectFluent(driver, dropdown);
		Select masterPlanningFamilydropDown= new Select(dropdown);
		masterPlanningFamilydropDown.selectByVisibleText("097, Typ. 09 - S&OP - MRP");
		Sync.waitForSeconds(Constants.WAIT_2);
	}
	public void selectPlanningCode()
	{
		Sync.waitForSeconds(Constants.WAIT_3);
		WebDriverWait wait= new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[text()='Planning Code']/../div/div/select")));
		
		WebElement dropdown =driver.findElement(By.xpath(".//*[text()='Planning Code']/../div/div/select"));
		Sync.waitForObjectFluent(driver, dropdown);
		Select planningCodedropDown= new Select(dropdown);
		planningCodedropDown.selectByVisibleText("0, Not Planned");
		Sync.waitForSeconds(Constants.WAIT_1);
	}

	}


