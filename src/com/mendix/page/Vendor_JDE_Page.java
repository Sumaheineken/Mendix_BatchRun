package com.mendix.page;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
import com.mendix.tool.SharedDriver;
import com.mendix.tool.Sync;



public class Vendor_JDE_Page {

	/** The driver. */
	static WebDriver driver;

	public Vendor_JDE_Page(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	@FindBy(how = How.XPATH, using = ".//*[text()='Partner Bank Type']/../div/div/select")
	WebElement partnerbank;

		@FindBy(how=How.XPATH, using="//*[text()='Local Data']")
	WebElement textLocalData;
	@FindBy(how=How.XPATH, using=".//*[text()='Accounting']/../../../div/div[1]/div/div/div[2]/div[2]/div[2]/button[1]")
	WebElement textAddclick;
	@FindBy(how=How.XPATH, using=".//*[text()='CompanyCode ISO Code']/../../div[2]/input")
	WebElement textisoinput;
	@FindBy(how=How.XPATH, using="//*[text()='CompanyCode ISO Code']/../../../../div//*[text()='Search']")
	WebElement Search1;
	@FindBy(how=How.XPATH, using="//*[text()='Select Company Code']/../../div/div[1]/div[1]/div[1]/div/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]//*[text()='Search']")
	WebElement Search;
	@FindBy(how=How.XPATH, using="//*[text()='BE10, Brouwerijen Alken-Maes NV']")
	WebElement textselect;
	@FindBy(how=How.XPATH, using="//*[text()='Reconciliation Account in General Ledger']/../div/div/select")
	WebElement selectReconciliation;
	@FindBy(how=How.XPATH, using="//*[text()='Cash Management Group/Planning Group']/../div/div/select")
	WebElement selectcashmanagement;
	
	@FindBy(how=How.XPATH, using="//*[text()='Sort Key']/../div/div/select")
	WebElement selectsortkey;
	@FindBy(how=How.XPATH, using="//*[text()='Terms of Payment Key']/../div/div/select")
	WebElement termsofpayment;
	@FindBy(how=How.XPATH, using="(//*[text()='Conditions']/../div[1]/div/table/tbody/tr/td[1]/div/div/div/select)[1]")
	WebElement purchaseorder;
	@FindBy(how=How.XPATH, using="(//*[text()='Conditions']/../div[1]/div/table/tbody/tr/td[1]/div/div/div/select)[3]")
	WebElement termspurchasing;
	
	@FindBy(how=How.XPATH, using="//*[text()='Select']")
	WebElement select;
	//*[text()='CompanyCode ISO Code']/../../../../div//*[text()='Search']
	//*[text()='CompanyCode ISO Code']/../../div[2]/input
	//*[text()='BE10, Brouwerijen Alken-Maes NV']

	@FindBy(how=How.XPATH, using="//*[text()='Bank Data']")
	WebElement textBankData;

	@FindBy(how=How.XPATH, using="//*[text()='JDE Purchasing']/../../../div/div[3]/div/div/div[2]/div[2]/div[2]/button[1]")
	WebElement BtnAddPlantData;
	@FindBy(how=How.XPATH, using="//*[text()='JDE Purchasing']/../../../div/div[3]/div/div/div[2]/div[2]/div[2]/button[2]")
	WebElement BtneditPlantData;
	@FindBy(how=How.XPATH, using="//*[text()='JDE Purchasing']/../../../div/div[3]/div/div/div[2]/div[2]/div[2]/button[1]")
	WebElement BtnAddBanknData;

	@FindBy(how=How.XPATH, using="//*[text()='JDE Finance']/../../../div/div[4]/div/div/div[2]/div[2]/div[2]/button[1]")
	WebElement BtnAddFinanceData;
	@FindBy(how=How.XPATH, using="//*[text()='JDE Finance']/../../../div/div[4]/div/div/div[2]/div[2]/div[2]/button[2]")
	WebElement BtneditFinanceData;
	@FindBy(how=How.XPATH, using="(//*[text()='25000'])[2]")
	WebElement Btneditinpurchansing;
	

	@FindBy(how=How.CSS, using="div[class^='mx-groupbox-body']>div:nth-child(1) >div>div:nth-of-type(1) >div:nth-child(1) >div:nth-of-type(1) >div:nth-of-type(1) >div:nth-of-type(1)>div >select")
	WebElement selectAdjustmentSchedule;
	
	@FindBy(how=How.XPATH, using="//*[text()='Send Method']/../div/div/select")
	WebElement selectsendmethod;
	
	@FindBy(how=How.XPATH, using="//*[text()='Adjustment Schedule']/../div/div/select")
	WebElement adjustmentSchedule;
	

	@FindBy(how=How.XPATH, using="//*[text()='Send Method']/../div/div/select")
	WebElement selectSendMethod;

	@FindBy(how=How.XPATH, using="//*[text()='Mvmt Type Invoice/Payment 1']/../div/div/select")
	WebElement  selectMvmtTypeInvoicePayment1;

	@FindBy(how=How.XPATH, using="//*[text()='Mvmt Type Invoice/Payment 3']/../div/div/select")
	WebElement  selectMvmtTypeInvoicePayment3;

	@FindBy(how=How.XPATH, using="//*[text()='A/B Amount Currency ']/../div/div/select")
	WebElement  selectABAmountCurrency;

	@FindBy(how=How.XPATH, using="//*[text()='Payment Terms - A/P']/../div/div/select")
	WebElement  selectPaymentTerms;

	@FindBy(how=How.XPATH, using="//*[text()='Tax Rate Area']/../div/div/select")
	WebElement  selectTaxRateArea;

	@FindBy(how=How.XPATH, using="//*[text()='Payment Creation']/../div/div/select")
	WebElement  selectPaymentCreation;

	@FindBy(how=How.XPATH, using="//*[text()='Hold Payment']/../div/div/select")
	WebElement  selectHoldPayment;

	@FindBy(how=How.XPATH, using="//*[text()='G/L Class']/../div/div/select")
	WebElement selectGlClass;
	@FindBy(how=How.XPATH, using="//*[text()='Bank Details']/../../../../div[2]/div/div/div[1]/div[2]/div/div/div[2]/div[2]/div[2]//*[text()='New']")
	WebElement 	BtnAddBankData;
	@FindBy(how=How.XPATH, using=".//*[text()='Bank Data']/../../../div/div[2]/div/div/div[6]/div[2]/div/div/div/div[1]/div//*[text()='New']")
	WebElement 	BtnAddBankDatasap;
	
	@FindBy(how=How.XPATH, using="(//*[text()='Bank Details']/../../../div/div/div/div/div[1]/div[1]/div[2]/div[2]/div[2]//button[1])[1]")
	WebElement 	addbanksap;
	@FindBy(how=How.XPATH, using="//*[text()='Select Purchasing Organisation']/../../div[2]/div/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div//button[text()='Search']")
	WebElement 	Searchinpurchasing;
	
	@FindBy(how = How.XPATH, using = ".//*[@class='glyphicon glyphicon-flash']")
	WebElement btnLocalActions;
	
	@FindBy(how=How.XPATH, using="//*[text()='Mvmt Type Invoice/Payment 2']/../div/div/select")
	WebElement selectMvmtTypeInvoicePayment2;

	@FindBy(how=How.XPATH, using="//*[text()='Mvmt Type Invoice/Payment 4']/../div/div/select")
	WebElement selectMvmtTypeInvoicePayment4;

	@FindBy(how=How.XPATH, using="//*[text()='Default Currency']/../div/div/select")
	WebElement  selectDefaultCurrency;

	@FindBy(how=How.XPATH, using="//*[text()='Tax Expl Code']/../div/div/select")
	WebElement  selectTaxExplCode;

	@FindBy(how=How.XPATH, using="//*[text()='Payment Methods']/../div/div/select")
	WebElement  selectPaymentMethods;

	@FindBy(how=How.XPATH, using="//*[text()='Bank Bearer']/../div/div/select")
	WebElement  selectBankBearer;
	
	@FindBy(how=How.XPATH, using="//*[text()='Currency Code']/../div/div/select")
	WebElement  selectCurrencyCode;
	
	@FindBy(how=How.XPATH, using="//*[text()='Partner Bank Type']/../div/div/select")
	WebElement   selectPartnerBankType;

	@FindBy(how=How.XPATH, using="//*[text()='Bank Country']/../div/div/select")
	WebElement  selectBankCountry;

	@FindBy(how=How.XPATH, using="//*[text()='Reject Local Request']")
	WebElement btnRejectLocal;

	@FindBy(how=How.CSS, using=".btn.btn-primary")
	WebElement btnMsgReqIdOk;
	
	@FindBy(how=How.XPATH, using="//*[text()='JDE Purchasing']/../../../div/div[3]/div/div/div/div[2]//button[text()='New']")
	WebElement btnNewJdePurchasing;
	
	@FindBy(how=How.XPATH, using="//*[text()='JDE Finance']/../../../div/div[4]/div/div/div/div[2]//button[text()='New']")
	WebElement btnNewJdeFinance;
	
	@FindBy(xpath="//*[text()='Bank Account']/following::input[@type='text'][1]")
	WebElement textBankAccount;
	@FindBy(xpath="//*[text()='Purchasing']/../../../div/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]//button[text()='Add']")
	WebElement addpurchasing;
	@FindBy(xpath="//*[text()='Purchasing']/../../../div/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]//button[text()='Edit']")
	WebElement editpurchasing;
	
	@FindBy(xpath="//*[text()='PurchaseOrg ISO Code']/../../../div/div[2]/input")
	WebElement inputiso;
	@FindBy(xpath="(//*[text()='Search'])[2]")
	WebElement clicksearch2;
	@FindBy(xpath="(//*[text()='Search'])[1]")
	WebElement clicksearch1;
	@FindBy(xpath="//*[text()='BE01, Alken Maes Purch.']")
	WebElement selectbe;
	
	@FindBy(xpath="//*[text()='Select']")
	WebElement clickSelect;
	
	@FindBy(xpath="//*[text()='Submit Local Request']")
	WebElement submitLocal;
	@FindBy(xpath=".//*[text()='Accounting']/../../../div/div[1]/div/div/div[2]/div[2]/div[2]/button[2]")
	WebElement editAccounting;
	@FindBy(xpath=".//*[text()='Validate']")
	WebElement Validate;
	@FindBy(xpath=".//*[text()='Save']")
	WebElement Save;

	
	//*[text()='Purchasing']/../../../div/div[2]/div/div/div/div[2]/div[2]//*[text()='Add']
	public boolean enterLocalData() {
		WebElement waitElement = null;
		Sync.waitForSeconds(Constants.WAIT_6);
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
					By.xpath("//*[text()='Local Data']"))
					);
		}

		Sync.waitUntilObjectDisappears(driver, "Waiting of Create page to Load", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForObject(driver, textLocalData);
		return Button.click("Local Data", textLocalData);
	}


	public boolean enterBankData() {
		Sync.waitForSeconds(Constants.WAIT_10);
		Sync.waitUntilObjectDisappears(driver, "Waiting of Create page to Load",
				By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForObject(driver, textBankData);
		return Button.click("Bank Data", textBankData);
		/*// Button.click("Local Actions button", btnLocalActions);
		Sync.waitForSeconds(Constants.WAIT_1);
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
					By.xpath("//*[text()='Bank Data']"))
					);
		}

		Sync.waitUntilObjectDisappears(driver, "Waiting of Create page to Load", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForObject(driver, textBankData);
		return Button.click("Local Data", textBankData);*/
	}



	public boolean BtneditPlantData() {
		Sync.waitForSeconds(Constants.WAIT_10);
		Sync.waitForObject(driver, BtneditPlantData);
		return Button.click("Click Edit button", BtneditPlantData);

	}
	public boolean BtnAddPlantData() {
		Sync.waitForSeconds(Constants.WAIT_10);
		Sync.waitForObject(driver, BtnAddPlantData);
		return Button.click("Click Edit button", BtnAddPlantData);

	}
	
	public boolean textAddclick() {
		Sync.waitForSeconds(Constants.WAIT_10);
		Sync.waitForObject(driver, textAddclick);
		return Button.click("Click Edit button", textAddclick);

	}
	public boolean Search() {
		Sync.waitForSeconds(Constants.WAIT_10);
		Sync.waitForObject(driver, Search);
		return Button.click("Click Edit button", Search);

	}
	
	public void textisoinput(String strValue) {
		Sync.waitForSeconds(Constants.WAIT_10);
		Sync.waitForObject(driver, textisoinput);
		textisoinput.sendKeys(strValue);

	}
	public boolean Search1() {
		Sync.waitForSeconds(Constants.WAIT_10);
		Sync.waitForObject(driver, Search);
		return Button.click("Click Search button", Search1);

	}
	public boolean textselect() {
		Sync.waitForSeconds(Constants.WAIT_10);
		Sync.waitForSeconds(Constants.WAIT_10);

		Sync.waitForObject(driver, textselect);
		return Button.click("Click textselect button", textselect);

	}
	public boolean Select() {
		Sync.waitForSeconds(Constants.WAIT_10);

		Sync.waitForSeconds(Constants.WAIT_10);
		Sync.waitForObject(driver, select);
		return Button.click("Click select button", select);

	}
	public boolean editAccounting() {
		Sync.waitForSeconds(Constants.WAIT_2);
		Sync.waitForSeconds(Constants.WAIT_10);

		Sync.waitForObject(driver, editAccounting);
		return Button.click("Click edit button", editAccounting);
		
	}
	
	
	public boolean addpurchasing() {
		Sync.waitForSeconds(Constants.WAIT_10);
		Sync.waitForSeconds(Constants.WAIT_2);

		Sync.waitForObject(driver, addpurchasing);
		return Button.click("Click addpurchasing button", addpurchasing);

	}
	public boolean editpurchasing() {
		Sync.waitForSeconds(Constants.WAIT_10);

		Sync.waitForSeconds(Constants.WAIT_10);
		Sync.waitForObject(driver, editpurchasing);
		return Button.click("Click editpurchasing button", editpurchasing);

	}
	public void inputiso(String strValue) {
		Sync.waitForSeconds(Constants.WAIT_10);

		Sync.waitForSeconds(Constants.WAIT_10);
		//Sync.waitForObject(driver, Search);
		inputiso.sendKeys(strValue);

	}
	public boolean selectbe() {
		Sync.waitForSeconds(Constants.WAIT_10);
		Sync.waitForObject(driver, selectbe);
		return Button.click("Click selectbe button", selectbe);

	}
	public boolean Btneditinpurchansing() {
		Sync.waitForSeconds(Constants.WAIT_10);
		Sync.waitForObject(driver, Btneditinpurchansing);
		return Button.click("Click Btneditinpurchansing button", Btneditinpurchansing);

	}
	
	public boolean submitLocal() {
Sync.waitForSeconds(Constants.WAIT_5);
		
		Sync.waitForSeconds(Constants.WAIT_3);
		Button.click("Local Actions button", btnLocalActions);
		Sync.waitForSeconds(Constants.WAIT_10);
		Sync.waitForObject(driver, submitLocal);
		return Button.click("Click submitLocal; button", submitLocal);

	}
	
	public boolean clickAddFinanceData() {

		Sync.waitForObject(driver, BtnAddFinanceData);
		return Button.click("Click BtnAddFinanceData", BtnAddFinanceData);
		

	}
	public boolean clickeditFinanceData() {

		Sync.waitForObject(driver, BtneditFinanceData);
		return Button.click("Click BtnAddFinanceData", BtneditFinanceData);
		

	}
	public boolean Searchinpurchasing() {

		Sync.waitForObject(driver, Searchinpurchasing);
		return Button.click("Click Searchinpurchasing", Searchinpurchasing);
		

	}
	



	public void clickFinancetab() throws InterruptedException
	{
		//Sync.waitUntilObjectDisappears(driver, "Wait for Save button", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		//Sync.WaitForPageLoad(driver);
	  WebDriverWait wait = new WebDriverWait(driver,60);
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='JDE Finance']")));
	//	Sync.waitUntilObjectDisappears(driver, "Wait for Save button", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForElementToBeClickable(driver, driver.findElement(By.xpath("//*[text()='JDE Finance']")));
		Button.jsclick("Click Finance Tab", driver.findElement(By.xpath("//*[text()='JDE Finance']")), driver);
	}

	public boolean clickEditFinanceData() {

		Sync.waitForObject(driver, driver.findElement(By.xpath("//*[text()='JDE Finance']/../../../div/div[4]/div/div/div[2]/div[2]/div[2]/button[2]")));
		return Button.click("Click Edit button", driver.findElement(By.xpath("//*[text()='JDE Finance']/../../../div/div[4]/div/div/div[2]/div[2]/div[2]/button[2]")));

	}
	public boolean clickpurchasingData() {

		Sync.waitForObject(driver, driver.findElement(By.xpath("//*[@class='mx-name-Purchasing1']")));
		return Button.jsclick("Click Edit button", driver.findElement(By.xpath("//*[@class='mx-name-Purchasing1']")), driver);

	}
	
	public void selectAdjustmentSchedule() throws AWTException
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_5);
		//Sync.waitForSeconds(Constants.WAIT_5);
		//driver.switchTo().window("Application");
		//WebElement element2=driver.findElement(By.xpath("//*[text()='Adjustment Schedule']"));
		Button.click("Select Adjustment Schedule",selectAdjustmentSchedule);
		Select option= new Select(driver.findElement(By.xpath("//*[text()='Adjustment Schedule']/../div/div/select")));
		//element2.click();
		option.selectByIndex(1);
//		element2.sendKeys(Keys.ARROW_DOWN);
		Sync.waitForSeconds(Constants.WAIT_5);


	}
	public void selectAdjustmentSchedulechange(String strValue) throws AWTException
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_5);
		
		Button.click("Select Adjustment Schedule",selectAdjustmentSchedule);
		Select option= new Select(driver.findElement(By.xpath("//*[text()='Adjustment Schedule']/../div/div/select")));
		
		option.selectByVisibleText(strValue);;

		Sync.waitForSeconds(Constants.WAIT_5);


	}
	public void selectsendmethod() throws AWTException
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_5);
		
		Button.click("Select send Schedule",selectsendmethod);
		Select option= new Select(driver.findElement(By.xpath("//*[text()='Send Method']/../div/div/select")));
		
		option.selectByIndex(2);

		Sync.waitForSeconds(Constants.WAIT_5);


	}


	public void selectReconciliation(String strValue)
	{
		Sync.waitForSeconds(Constants.WAIT_10);
		Sync.waitForSeconds(Constants.WAIT_5);	
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_5);
		Button.click("Click on selectReconciliation method",selectReconciliation);
		Select option= new Select(selectReconciliation);
		option.selectByVisibleText(strValue);
		Sync.waitForSeconds(Constants.WAIT_5);
	driver.manage().window().maximize();

	}
	
	public void selectcashmanagement(String strValue)
	{
		Sync.waitForSeconds(Constants.WAIT_10);
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_5);
		Button.click("Click on send method",selectcashmanagement);
		Select option1= new Select(selectcashmanagement);
		option1.selectByVisibleText(strValue);
		Sync.waitForSeconds(Constants.WAIT_5);


	}
	public void selectsortkey(String strValue)
	{
		Sync.waitForSeconds(Constants.WAIT_10);
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_5);
		Button.click("Click on selectsortkey method",selectsortkey);
		Select option2= new Select(selectsortkey);
		option2.selectByVisibleText(strValue);

		Sync.waitForSeconds(Constants.WAIT_5);


	}
	public void termsofpayment(String strValue)
	{
		Sync.waitForSeconds(Constants.WAIT_10);
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_5);
		Button.click("Click on send method",termsofpayment);
		Select option3= new Select(termsofpayment);
		option3.selectByVisibleText(strValue);

		Sync.waitForSeconds(Constants.WAIT_5);


	}
	public void partnerbank(String strValue)
	{
		Sync.waitForSeconds(Constants.WAIT_10);
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_5);
		Button.click("Click on send method",partnerbank);
		Select option4= new Select(partnerbank);
		option4.selectByVisibleText(strValue);

		Sync.waitForSeconds(Constants.WAIT_5);


	}

	
	public void purchaseorder(String strValue)

	{
		Sync.waitForSeconds(Constants.WAIT_10);
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_10);
		Sync.waitForSeconds(Constants.WAIT_5);
		Button.click("Click on send method",purchaseorder);
		Select option5= new Select(purchaseorder);
		option5.selectByVisibleText(strValue);

		Sync.waitForSeconds(Constants.WAIT_5);


	}
	public void termspurchasing(String strValue)
	{
		Sync.waitForSeconds(Constants.WAIT_10);
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_5);
		Button.click("Click on send method",termspurchasing);
		Select option6= new Select(termspurchasing);
		option6.selectByVisibleText(strValue);

		Sync.waitForSeconds(Constants.WAIT_5);


	}
	public void validateandSave()
	{
		Sync.waitForSeconds(Constants.WAIT_10);
		Sync.waitForSeconds(Constants.WAIT_5);
		
		Sync.waitForSeconds(Constants.WAIT_3);
		Button.click("Local Actions button", btnLocalActions);
		Sync.waitForSeconds(Constants.WAIT_5);
		Button.click("Click validate method",Validate);
		
		Sync.waitForSeconds(Constants.WAIT_5);
		Button.click("Click save method",Save);

	}
	
	
	public void selectSendMethod()
	{
		Sync.waitForSeconds(Constants.WAIT_10);
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_5);
		Button.click("Click on send method",selectSendMethod );
		Select option= new Select(selectSendMethod);
		option.selectByIndex(1);
		Sync.waitForSeconds(Constants.WAIT_5);

		/*List <WebElement> elementCount = option.getOptions();
		int iSize = elementCount.size();

		for(int i =0; i<iSize ; i++)
		{
			String sValue = elementCount.get(i).getText();
			if(sValue.equals(strValue))
			{
				option.selectByIndex(i);
				break;
			}
		}*/


	}

	public void clickValidatLocalData()
	{
		Sync.waitForSeconds(Constants.WAIT_10);
		Sync.waitForSeconds(Constants.WAIT_5);

		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForElementToBeClickable(driver, driver.findElement(By.xpath(".//*[@class='glyphicon glyphicon-check']")));
		driver.findElement(By.xpath(".//*[@class='glyphicon glyphicon-check']")).click();
	}
	
	public boolean clicksearch1()
	{
		Sync.waitForSeconds(Constants.WAIT_10);
		Sync.waitForSeconds(Constants.WAIT_5);

		Sync.waitForSeconds(Constants.WAIT_5);
		return Button.click("click",clicksearch1);


	}

	
	public void clickPlanningSaveButton()
	{
		Sync.WaitForPageLoad(driver);
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitUntilObjectDisappears(driver, "Wait for Save button", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForObject(driver, "Wait for Click Save button", driver.findElement(By.xpath(".//button[text()='Save']")));
		Button.jsclick("Click Save Button", driver.findElement(By.xpath(".//button[text()='Save']")), driver);

	}

	public boolean rejectLocalBtnClick()
	{
		Sync.waitForSeconds(Constants.WAIT_2);
		Sync.waitUntilObjectDisappears(driver, "Wait My tasks to load", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));

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
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[text()='Reject Local Request']"))
					);
		}



		Sync.waitForElementToBeClickable(driver, btnRejectLocal);
		Button.click("Click Local Action button", btnRejectLocal);
		Sync.waitForSeconds(Constants.WAIT_2);
		return Button.jsclick("Click Approval Button", btnRejectLocal, driver);
	}

	public void scrollToCommentsNew() throws AWTException
	{
		Sync.waitForSeconds(Constants.WAIT_6);
		Sync.waitForSeconds(Constants.WAIT_6);
		Sync.waitForSeconds(Constants.WAIT_6);

		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("(//*[text()='Comments'])[3]"))).click();
		act.sendKeys(Keys.PAGE_DOWN).perform();
		String newButton=driver.findElement(By.xpath("(//button[text()='New'])[8]")).getText();
		System.out.println(newButton);
		Sync.waitForSeconds(Constants.WAIT_6);
		Sync.waitForSeconds(Constants.WAIT_6);
		Sync.waitForSeconds(Constants.WAIT_6);
		Sync.waitForSeconds(Constants.WAIT_6);

	}

	public void clickCommentNew()
	{

		Sync.waitForSeconds(Constants.WAIT_5);
		driver.findElement(By.xpath("(//*[text()='Comments'])[3]/../div/div[2]/div[2]/button[1]")).click();


	}


	public void clickCommentsArea()
	{

		Sync.waitForSeconds(Constants.WAIT_5);
		driver.findElement(By.xpath("(//textarea)[1]")).click();


	}

	public void enterCommentsArea()
	{

		Sync.waitForSeconds(Constants.WAIT_5);
		driver.findElement(By.xpath("(//textarea)[1]")).sendKeys("Rejected by LDS");


	}

	public void clickSaveComments()
	{

		Sync.waitForSeconds(Constants.WAIT_5);
		driver.findElement(By.xpath("//button[text()='Save']")).click();


	}

	public boolean submitRequestOkBtnClick()
	{

		Sync.waitForSeconds(Constants.WAIT_2);
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
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(
					By.xpath(".//*[@id='mxui_widget_Progress_0']"))
					);
		}

		/*		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)                            
				.withTimeout(Duration.ofSeconds(300))          
				.pollingEvery(Duration.ofMillis(600))          
				.ignoring(NoSuchElementException.class);

		WebElement btnMsgReqIdOk=wait.until(new Function<WebDriver, WebElement>() {       
			public WebElement apply(WebDriver driver) { 
				return driver.findElement(By.cssSelector(".btn.btn-primary"));     
			}  
		});*/


		Actions btnselect = new Actions(driver);
		btnselect.moveToElement(btnMsgReqIdOk);
		btnselect.build();
		btnselect.perform();
		return Button.click("Click Ok Button", btnMsgReqIdOk);
	}





	public void selectMvmtTypeInvoicePayment1()
	{
		Sync.waitForSeconds(Constants.WAIT_6);
		Button.click("Select Invoce Payment1", selectMvmtTypeInvoicePayment1);
		Select option= new Select(selectMvmtTypeInvoicePayment1);
		option.selectByIndex(1);
		Sync.waitForSeconds(Constants.WAIT_5);

	}
	public void selectMvmtTypeInvoicePayment1change()
	{
		Sync.waitForSeconds(Constants.WAIT_10);
		Button.click("Select Invoce Payment1", selectMvmtTypeInvoicePayment1);
		Select option= new Select(selectMvmtTypeInvoicePayment1);
		option.selectByIndex(2);
		Sync.waitForSeconds(Constants.WAIT_5);

	}

	public void selectMvmtTypeInvoicePayment3()
	{
		Sync.waitForSeconds(Constants.WAIT_10);
		Button.click("Select Invoce Payment1", selectMvmtTypeInvoicePayment3);
		Select option= new Select(selectMvmtTypeInvoicePayment3);
		option.selectByIndex(1);
		Sync.waitForSeconds(Constants.WAIT_5);

	

	}
	public void selectMvmtTypeInvoicePayment3change()
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		Button.click("Select Invoce Payment1", selectMvmtTypeInvoicePayment3);
		Select option= new Select(selectMvmtTypeInvoicePayment3);
		option.selectByIndex(2);
		Sync.waitForSeconds(Constants.WAIT_5);

	


	}


	public void selectABAmountCurrency()
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		Button.click("Select AB Amount Accuracy",selectABAmountCurrency);
		Select option= new Select(selectABAmountCurrency);
		option.selectByVisibleText("SGD, Singapore Dollar");
		Sync.waitForSeconds(Constants.WAIT_5);

		

	}
	public void selectABAmountCurrencychange()
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		Button.click("Select AB Amount Accuracy",selectABAmountCurrency);
		Select option= new Select(selectABAmountCurrency);
		option.selectByVisibleText("SGD, Singapore Dollar");
		Sync.waitForSeconds(Constants.WAIT_5);

		

	}


	public void selectPaymentTerms()
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		Button.click("Select Payment Terms",selectPaymentTerms);
		Select option= new Select(selectPaymentTerms);
		option.selectByIndex(1);
		Sync.waitForSeconds(Constants.WAIT_5);

	

	}
	public void selectPaymentTermschange()
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		Button.click("Select Payment Terms",selectPaymentTerms);
		Select option= new Select(selectPaymentTerms);
		option.selectByIndex(2);
		Sync.waitForSeconds(Constants.WAIT_5);

	

	}

	public void selectTaxRateArea()
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		Button.click("Click on Text Area", selectTaxRateArea);
		Select option= new Select(selectTaxRateArea);
		option.selectByIndex(2);
		Sync.waitForSeconds(Constants.WAIT_5);

		

	}
	public void selectTaxRateAreachange()
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		Button.click("Click on Text Area", selectTaxRateArea);
		Select option= new Select(selectTaxRateArea);
		option.selectByIndex(1);
		Sync.waitForSeconds(Constants.WAIT_5);

		

	}


	public void selectPaymentCreation()
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		Button.click("Click on Payment Creation", selectPaymentCreation);
		Select option= new Select(selectPaymentCreation);
		option.selectByIndex(1);
		Sync.waitForSeconds(Constants.WAIT_5);

	
	}
	public void selectPaymentCreationchange()
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		Button.click("Click on Payment Creation", selectPaymentCreation);
		Select option= new Select(selectPaymentCreation);
		option.selectByIndex(2);
		Sync.waitForSeconds(Constants.WAIT_5);

	
	}


	public void selectHoldPayment()
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		Button.click("Click on Payment Creation", selectPaymentCreation);
		Select option= new Select(selectHoldPayment);
		option.selectByIndex(1);
	

	}
	public void selectHoldPaymentchange()
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		Button.click("Click on Payment Creation", selectPaymentCreation);
		Select option= new Select(selectHoldPayment);
		option.selectByIndex(2);
	

	}
	public void selectGlClass()
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		Button.click("Click on GL Class", selectGlClass);
		Select option= new Select(selectGlClass);
		option.selectByIndex(1);
		Sync.waitForSeconds(Constants.WAIT_5);
		

	
	}
	public void selectGlClasschange()
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		Button.click("Click on GL Class", selectGlClass);
		Select option= new Select(selectGlClass);
		option.selectByIndex(2);
		Sync.waitForSeconds(Constants.WAIT_5);
		

	
	}


	public void selectMvmtTypeInvoicePayment2()
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		Button.click("Select Invoice payment2", selectMvmtTypeInvoicePayment2);
		Select option= new Select(selectMvmtTypeInvoicePayment2);
		option.selectByIndex(1);
		Sync.waitForSeconds(Constants.WAIT_5);

	/*	List <WebElement> elementCount = option.getOptions();
		int iSize = elementCount.size();

		for(int i =0; i<iSize ; i++)
		{
			String sValue = elementCount.get(i).getText();
			if(sValue.equals("808, Other non cash items"))
			{
				option.selectByIndex(i);
				break;
			}
		}*/
		/*Sync.waitForObjectFluent(driver, selectSendMethod);
		Select selectSendMethoddropDown= new Select(selectSendMethod);
		selectSendMethoddropDown.selectByVisibleText("3, Email");*/

	}

	public void selectMvmtTypeInvoicePayment4()
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		Button.click("Select Invoice payment4", selectMvmtTypeInvoicePayment4);
		Select option= new Select(selectMvmtTypeInvoicePayment4);
		option.selectByIndex(1);

		/*List <WebElement> elementCount = option.getOptions();
		int iSize = elementCount.size();

		for(int i =0; i<iSize ; i++)
		{
			String sValue = elementCount.get(i).getText();
			if(sValue.equals("903, Proceeds & Receipts"))
			{
				option.selectByIndex(i);
				break;
			}
		}*/
		/*Sync.waitForObjectFluent(driver, selectSendMethod);
		Select selectSendMethoddropDown= new Select(selectSendMethod);
		selectSendMethoddropDown.selectByVisibleText("3, Email");*/

	}

	public void selectDefaultCurrency()
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		Button.click("Click on Default Currency", selectDefaultCurrency);
		Select option= new Select(selectDefaultCurrency);
		option.selectByIndex(1);

		/*List <WebElement> elementCount = option.getOptions();
		int iSize = elementCount.size();

		for(int i =0; i<iSize ; i++)
		{
			String sValue = elementCount.get(i).getText();
			if(sValue.equals("USD, United States Dollar"))
			{
				option.selectByIndex(i);
				break;
			}
		}*/
	}

	public void selectTaxExplCode()
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		Button.click("Click on Tax Expl code", selectTaxExplCode);
		Select option= new Select(selectTaxExplCode);
		option.selectByIndex(1);

		/*List <WebElement> elementCount = option.getOptions();
		int iSize = elementCount.size();

		for(int i =0; i<iSize ; i++)
		{
			String sValue = elementCount.get(i).getText();
			if(sValue.equals("VS, VAT - Standard Rated Supplies"))
			{
				option.selectByIndex(i);
				break;
			}
		}*/
	}
	public void selectPaymentMethods()
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		Button.click("Click on Payment Methods", selectPaymentMethods);
		Select option= new Select(selectPaymentMethods);
		option.selectByIndex(1);

		/*List <WebElement> elementCount = option.getOptions();
		int iSize = elementCount.size();

		for(int i =0; i<iSize ; i++)
		{
			String sValue = elementCount.get(i).getText();
			if(sValue.equals("C, Cheque Payment"))
			{
				option.selectByIndex(i);
				break;
			}
		}*/
	}

	public void selectBankBearer()
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		Button.click("Click on Bank Bearer", selectBankBearer);
		Select option= new Select(selectBankBearer);
		option.selectByIndex(1);
		Sync.waitForSeconds(Constants.WAIT_5);

		/*List <WebElement> elementCount = option.getOptions();
		int iSize = elementCount.size();

		for(int i =0; i<iSize ; i++)
		{
			String sValue = elementCount.get(i).getText();
			if(sValue.equals("001, Heineken bears the cost"))
			{
				option.selectByIndex(i);
				break;
			}
		}
*/
	}


	public void selectBankCountry()
	{
		Sync.waitForSeconds(Constants.WAIT_10);
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_5);
//		selectBankCountry.click();
//		Select option= new Select(selectBankCountry);

//		List <WebElement> elementCount = option.getOptions();
		Select selectBankCountrydropDown= new Select(selectBankCountry);
		selectBankCountrydropDown.selectByVisibleText("SG, Singapore");

		/*int iSize = elementCount.size();

		for(int i =0; i<iSize ; i++)
		{

			try {
				Thread.sleep(5000);
				
				String sValue = elementCount.get(i).getText();
				if(sValue.equals("DZ, Algeria"))
				{
					option.selectByIndex(i);
					break;
				}
			}*/
			/*catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
	
	public void AdjustmentSchedule(String strValue) throws InterruptedException
	{
		//Sync.waitForObject(driver, driver.findElement(By.xpath(".//*[contains(text(),'Edit Local Data Planning')]")));
		Sync.waitForSeconds(Constants.WAIT_5);
		if(DropDown.verifyObject(adjustmentSchedule)){
			Sync.waitForObject(driver ,"Wait for selecting Adjustment Schedule", adjustmentSchedule);
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on Adjustment Schedule", adjustmentSchedule);
			Select AdjustmentSchedule= new Select(adjustmentSchedule);
			AdjustmentSchedule.selectByVisibleText(strValue);
			
		}else{
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on Adjustment Schedule", adjustmentSchedule);
			Select AdjustmentSchedule= new Select(adjustmentSchedule);
			AdjustmentSchedule.selectByVisibleText(strValue);
		}
		
	}
	public void selectingAdjustmentSchedule(String strValue) throws InterruptedException 
	{
		Sync.waitForSeconds(Constants.WAIT_10);
		this.AdjustmentSchedule(strValue);
	}
/****************************************************************************/
public void sendMethod(String strValue) throws InterruptedException
	{
		//Sync.waitForObject(driver, driver.findElement(By.xpath(".//*[contains(text(),'Edit Local Data Planning')]")));
		Sync.waitForSeconds(Constants.WAIT_5);
		if(DropDown.verifyObject(selectSendMethod)){
			Sync.waitForObject(driver ,"Wait for selecting send method", selectSendMethod);
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on send method", selectSendMethod);
			Select SendMethod= new Select(selectSendMethod);
			SendMethod.selectByVisibleText(strValue);
			
		}else{
			Sync.waitForObject(driver ,"Wait for selecting send method", selectSendMethod);
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on send method", selectSendMethod);
			Select SendMethod= new Select(selectSendMethod);
			SendMethod.selectByVisibleText(strValue);
		}
		
	}
	public void selectingSendMethod(String strValue) throws InterruptedException 
	{
		Sync.waitForSeconds(Constants.WAIT_10);
		this.sendMethod(strValue);
	}
/**********************************************************************************/
	public void ABAmountCurrency(String strValue) throws InterruptedException
	{
		//Sync.waitForObject(driver, driver.findElement(By.xpath(".//*[contains(text(),'Edit Local Data Planning')]")));
		Sync.waitForSeconds(Constants.WAIT_5);
		if(DropDown.verifyObject(selectABAmountCurrency)){
			Sync.waitForObject(driver ,"Wait for selecting AB Amount Currency", selectABAmountCurrency);
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on AB Amount Currency", selectABAmountCurrency);
			Select ABAmountCurrency= new Select(selectABAmountCurrency);
			ABAmountCurrency.selectByVisibleText(strValue);
			
		}else{
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on AB Amount Currency", selectABAmountCurrency);
			Select ABAmountCurrency= new Select(selectABAmountCurrency);
			ABAmountCurrency.selectByVisibleText(strValue);
		}
		
	}


	public void selectingABAmountCurrency(String strValue) throws InterruptedException 
	{
		Sync.waitForSeconds(Constants.WAIT_10);
		this.ABAmountCurrency(strValue);
	}
/*************************************************************************/
public void paymentTerms(String strValue) throws InterruptedException
	{
		//Sync.waitForObject(driver, driver.findElement(By.xpath(".//*[contains(text(),'Edit Local Data Planning')]")));
		Sync.waitForSeconds(Constants.WAIT_5);
		if(DropDown.verifyObject(selectPaymentTerms)){
			Sync.waitForObject(driver ,"Wait for selecting Payment Terms", selectPaymentTerms);
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on Payment terms", selectPaymentTerms);
			Select PaymentTerms= new Select(selectPaymentTerms);
			PaymentTerms.selectByVisibleText(strValue);
			
		}else{
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on Payment terms", selectPaymentTerms);
			Select PaymentTerms= new Select(selectPaymentTerms);
			PaymentTerms.selectByVisibleText(strValue);
		}
		
	}
	public void selectingPaymentTerms(String strValue) throws InterruptedException 
	{
		Sync.waitForSeconds(Constants.WAIT_10);
		this.paymentTerms(strValue);
	}
	
/**********************************************************************************/
public void textRateArea(String strValue) throws InterruptedException
	{
		//Sync.waitForObject(driver, driver.findElement(By.xpath(".//*[contains(text(),'Edit Local Data Planning')]")));
		Sync.waitForSeconds(Constants.WAIT_5);
		if(DropDown.verifyObject(selectTaxRateArea)){
			Sync.waitForObject(driver ,"Wait for selecting Text Area", selectTaxRateArea);
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on Text Area", selectTaxRateArea);
			Select TextRateArea= new Select(selectTaxRateArea);
			TextRateArea.selectByVisibleText(strValue);
			
		}else{
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on Text Area", selectTaxRateArea);
			Select TextArea= new Select(selectTaxRateArea);
			TextArea.selectByVisibleText(strValue);
		}
		
	}
	public void selectingTaxRateArea(String strValue) throws InterruptedException 
	{
		Sync.waitForSeconds(Constants.WAIT_10);
		this.textRateArea(strValue);
	}
/**********************************************************************************/
public void paymentCreation(String strValue) throws InterruptedException
	{
		//Sync.waitForObject(driver, driver.findElement(By.xpath(".//*[contains(text(),'Edit Local Data Planning')]")));
		Sync.waitForSeconds(Constants.WAIT_5);
		if(DropDown.verifyObject(selectPaymentCreation)){
			Sync.waitForObject(driver ,"Wait for selecting Payment Creation", selectPaymentCreation);
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on Payment Creation", selectPaymentCreation);
			Select paymentCreation= new Select(selectPaymentCreation);
			paymentCreation.selectByVisibleText(strValue);
			
		}else{
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on Payment Creation", selectPaymentCreation);
			Select paymentCreation= new Select(selectPaymentCreation);
			paymentCreation.selectByVisibleText(strValue);
		}
		
	}
	public void selectingPaymentCreation(String strValue) throws InterruptedException 
	{
		this.paymentCreation(strValue);
	}
/******************************************************************************/
public void holdPayment(String strValue) throws InterruptedException
	{
		//Sync.waitForObject(driver, driver.findElement(By.xpath(".//*[contains(text(),'Edit Local Data Planning')]")));
		Sync.waitForSeconds(Constants.WAIT_5);
		if(DropDown.verifyObject(selectHoldPayment)){
			Sync.waitForObject(driver ,"Wait for selecting Hold Payment", selectHoldPayment);
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on Hold Payment", selectHoldPayment);
			Select HoldPayment= new Select(selectHoldPayment);
			HoldPayment.selectByVisibleText(strValue);
			
		}else{
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on Hold Payment", selectHoldPayment);
			Select HoldPayment= new Select(selectHoldPayment);
			HoldPayment.selectByVisibleText(strValue);
		}
		
	}
	public void selectingHoldPayment(String strValue) throws InterruptedException 
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		this.holdPayment(strValue);
	}
/*****************************************************************************/
public void glClass(String strValue) throws InterruptedException
	{
		//Sync.waitForObject(driver, driver.findElement(By.xpath(".//*[contains(text(),'Edit Local Data Planning')]")));
		Sync.waitForSeconds(Constants.WAIT_5);
		if(DropDown.verifyObject(selectGlClass)){
			Sync.waitForObject(driver ,"Wait for selecting GL Class", selectGlClass);
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on GL Class", selectGlClass);
			Select GLClass= new Select(selectGlClass);
			GLClass.selectByVisibleText(strValue);
			
		}else{
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on GL Class", selectGlClass);
			Select GLClass= new Select(selectGlClass);
			GLClass.selectByVisibleText(strValue);
		}
		
	}
	public void selectingGLClass(String strValue) throws InterruptedException 
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		this.glClass(strValue);
	}


/*********************************************************************************/


/*****************************************************************************/
public void defaultCurrency(String strValue) throws InterruptedException
	{
		//Sync.waitForObject(driver, driver.findElement(By.xpath(".//*[contains(text(),'Edit Local Data Planning')]")));
		Sync.waitForSeconds(Constants.WAIT_5);
		if(DropDown.verifyObject(selectGlClass)){
			Sync.waitForObject(driver ,"Wait for selecting Default Currency", selectDefaultCurrency);
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on Default Currency", selectDefaultCurrency);
			Select DefaultCurrency= new Select(selectDefaultCurrency);
			DefaultCurrency.selectByVisibleText(strValue);
			
		}else{
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on Default Currency", selectDefaultCurrency);
			Select DefaultCurrency= new Select(selectDefaultCurrency);
			DefaultCurrency.selectByVisibleText(strValue);
		}
		
	}		
	
	public void selectingDefaultCurrency(String strValue) throws InterruptedException 
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		this.defaultCurrency(strValue);
	}

/*****************************************************************************/
public void taxExplCode(String strValue) throws InterruptedException
	{
		//Sync.waitForObject(driver, driver.findElement(By.xpath(".//*[contains(text(),'Edit Local Data Planning')]")));
		Sync.waitForSeconds(Constants.WAIT_5);
		if(DropDown.verifyObject(selectGlClass)){
			Sync.waitForObject(driver ,"Wait for selecting Tax Expl code", selectTaxExplCode);
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on Tax Expl code", selectTaxExplCode);
			Select TaxEplCode= new Select(selectTaxExplCode);
			TaxEplCode.selectByVisibleText(strValue);
			
		}else{
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on Tax Expl code", selectTaxExplCode);
			Select TaxEplCode= new Select(selectTaxExplCode);
			TaxEplCode.selectByVisibleText(strValue);
		}
		
	}	public void selectingTaxEplCode(String strValue) throws InterruptedException 
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		this.taxExplCode(strValue);
	}
/*********************************************************************************/





public void paymentsMethod(String strValue) throws InterruptedException
	{
		//Sync.waitForObject(driver, driver.findElement(By.xpath(".//*[contains(text(),'Edit Local Data Planning')]")));
		Sync.waitForSeconds(Constants.WAIT_5);
		if(DropDown.verifyObject(selectPaymentMethods)){
			Sync.waitForObject(driver ,"Wait for selecting Payment Methods", selectPaymentMethods);
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on Payment Methods", selectPaymentMethods);
			Select PymentMethod= new Select(selectPaymentMethods);
			PymentMethod.selectByVisibleText(strValue);
			
		}else{
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on Payment Methods", selectPaymentMethods);
			Select PymentMethod= new Select(selectPaymentMethods);
			PymentMethod.selectByVisibleText(strValue);
		}
		
	}
	public void selectingPaymentMethod(String strValue) throws InterruptedException 
	{
		Sync.waitForSeconds(Constants.WAIT_10);
		this.paymentsMethod(strValue);
	}
/******************************************************************************/
public void bankBearer(String strValue) throws InterruptedException
	{
		//Sync.waitForObject(driver, driver.findElement(By.xpath(".//*[contains(text(),'Edit Local Data Planning')]")));
		Sync.waitForSeconds(Constants.WAIT_5);
		if(DropDown.verifyObject(selectBankBearer)){
			Sync.waitForObject(driver ,"Wait for selecting Bank Bearer", selectBankBearer);
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on Bank Bearer", selectBankBearer);
			Select BankBearer= new Select(selectBankBearer);
			BankBearer.selectByVisibleText(strValue);
			
		}else{
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on Bank Bearer", selectBankBearer);
			Select BankBearer= new Select(selectBankBearer);
			BankBearer.selectByVisibleText(strValue);
		}
		
	}
	public void selectingBankBearer(String strValue) throws InterruptedException 
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		this.bankBearer(strValue);
	}
	


	

	public void selectBankKey()
	{

		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_5);
		List<WebElement> allvalue = driver.findElements(By.xpath("(.//*[contains(@id,'mxui_widget_DataGrid')])[17]/div[3]/div/table[2]/tbody/tr"));
		// for printing everything in the table
		for(int i =0;i<allvalue.size();i++){
			System.out.println("Value are : " + allvalue.get(i).getText());
		}
		
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_5);

		// for printing a particular column rows
		List<WebElement> allAddressmvalue = driver.findElements(By.xpath("(.//*[contains(@id,'mxui_widget_DataGrid')])[17]/div[3]/div/table[2]/tbody/tr/td[9]"));

		for(int i =0;i<allAddressmvalue.size();i++){
			System.out.println("Value are : " + allAddressmvalue.get(i).getText());
		}

		// for printing all links do it like belwo
			List<WebElement> alllinks = driver.findElements(By.xpath("(.//*[contains(@id,'mxui_widget_DataGrid')])[17]/div[3]/div/table[2]/tbody/tr/td[9]/div"));

		for(int i =0;i<alllinks.size();i++){
			System.out.println("Link is  : " + alllinks.get(i).getText());
		}

		// Now please note that inside the web-table all column and rows are fixed
		// i.e size of each row for each column will be fixed 
		// i.e if size for Country is = 4 then ,size for City ,height ,build,rank 
		// and for link will be same i.e =4

		// hence on that basic we can do it like below 

		for(int i =0;i<allAddressmvalue.size();i++){
						// now on the basis of column value click the corresponding link
			if(alllinks.get(i).getText() == null || alllinks.get(i).getText().trim().isEmpty()){
				Sync.waitForSeconds(Constants.WAIT_5);
				Sync.waitForSeconds(Constants.WAIT_5);
				Sync.waitForSeconds(Constants.WAIT_5);
				Sync.waitForSeconds(Constants.WAIT_5);
				System.out.println("Values are : " + allAddressmvalue.get(i).getText() + "== Corresponding link is : " + alllinks.get(i).getText());
				
				alllinks.get(i).click();
				System.out.println("Values are : " + allAddressmvalue.get(i).getText() + "== Corresponding link is : " + alllinks.get(i).getText());
				Sync.waitForSeconds(Constants.WAIT_5);
				Sync.waitForSeconds(Constants.WAIT_5);
				Sync.waitForSeconds(Constants.WAIT_5);
				Sync.waitForSeconds(Constants.WAIT_5);
				break;
			}
		}
	}

	public void clickBankKey()
	{

		Sync.waitForSeconds(Constants.WAIT_5);
		driver.findElement(By.xpath("//*[text()='Select']")).click();


	}

	public void clickNewBankButton()
	{		
		Sync.waitForSeconds(Constants.WAIT_10);
		//Sync.waitForObject(driver, BtnAddBankData);
		Button.click("New Bank Button", BtnAddBankData);
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitUntilObjectDisappears(driver, "Waiting of Create page to Load", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));

	}
	public void clickNewBankButtonsap()
	{		
		Sync.waitForSeconds(Constants.WAIT_10);
		//Sync.waitForObject(driver, BtnAddBankData);
		Button.click("New Bank Button", BtnAddBankDatasap);
		Sync.waitForSeconds(Constants.WAIT_5);
		//Sync.waitUntilObjectDisappears(driver, "Waiting of Create page to Load", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));

	}
	


	public void clickSelectBankKey()
	{

		Sync.waitForSeconds(Constants.WAIT_5);
		driver.findElement(By.xpath("(//*[text()='Select'])[2]")).click();


	}
	
	public void selectCurrencyCode()
	{
		Sync.waitForSeconds(Constants.WAIT_1);
		Select option= new Select(selectCurrencyCode);
		option.selectByVisibleText("DZD, Algerian Dinar");

		/*List <WebElement> elementCount = option.getOptions();
		int iSize = elementCount.size();

		for(int i =0; i<iSize ; i++)
		{
			String sValue = elementCount.get(i).getText();
			if(sValue.equals("DZD, Algerian Dinar"))
			{
				option.selectByIndex(i);
				break;
			}
		}*/
	}
		
		public void enterBankaccount()
		{
			Sync.waitForSeconds(Constants.WAIT_1);
			textBankAccount.sendKeys("12356778");
			

			
			
	}
		public void enterBankaccountsap()
		{
			Sync.waitForSeconds(Constants.WAIT_1);
			textBankAccount.sendKeys("123-6778777-89");	
			
			
	}



		public void clickSaveBankDetails()
		{

			Sync.waitForSeconds(Constants.WAIT_5);
			driver.findElement(By.xpath("//*[text()='Save']")).click();


		}
		
		
		public void clickLocalAction_Bank()
		{
			Sync.waitForSeconds(Constants.WAIT_5);
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
			      WebDriverWait wait = new WebDriverWait(driver, 120);
			      wait.until(ExpectedConditions.visibilityOfElementLocated(
			    		  By.cssSelector(".glyphicon.glyphicon-flash"))
			            );
			        }*/

			Button.jsclick("Click Local Action Flash Button", driver.findElement(By.cssSelector(".glyphicon.glyphicon-flash")), driver);
		}
		public void localAddInNewPurchasingJDE()
		{

			Sync.waitForSeconds(Constants.WAIT_10);
			WebDriverWait wait = new WebDriverWait(driver,50);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='JDE Purchasing']/../../../div/div[3]/div/div/div/div[2]//button[text()='New']")));
		//	Sync.waitForObject(driver, textLocalData);
			if(Button.verifyObject(btnNewJdePurchasing))
			{
				Sync.waitForObject(driver, btnNewJdePurchasing);
				Button.jsclick("Adding new Purchasing for JDE", btnNewJdePurchasing, driver);
				Sync.waitForSeconds(Constants.WAIT_10);
			}
			else
			{
				Sync.waitForSeconds(Constants.WAIT_10);
				Sync.waitForObject(driver,btnNewJdePurchasing);
				Button.jsclick("Adding new Purchasing for JDE", btnNewJdePurchasing, driver);
				Sync.waitForSeconds(Constants.WAIT_10);
			}

		}
		
		public void localAddInNewFinanceJDE()
		{

			Sync.waitForSeconds(Constants.WAIT_10);
			Sync.waitForObject(driver, textLocalData);
			if(Button.verifyObject(btnNewJdeFinance))
			{
				Sync.waitForObject(driver, btnNewJdeFinance);
				Button.jsclick("Adding new Finance for JDE", btnNewJdeFinance, driver);
				Sync.waitForSeconds(Constants.WAIT_10);
			}
			else
			{
				Sync.waitForSeconds(Constants.WAIT_10);
				Sync.waitForObject(driver, btnNewJdeFinance);
				Button.jsclick("Adding new Finance for JDE", btnNewJdeFinance, driver);
				Sync.waitForSeconds(Constants.WAIT_10);
			}

		}

				

		

}



