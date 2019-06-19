package com.mendix.page;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.time.Duration;

import org.openqa.selenium.support.ui.FluentWait;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mendix.tool.Button;
import com.mendix.tool.Constants;
import com.mendix.tool.DropDown;
import com.mendix.tool.SharedDriver;
import com.mendix.tool.Sync;
import com.mendix.tool.Textbox;
import com.mendix.util.ExcelUtil;
import com.mendix.util.DataProviderUtil.staticProviderClass;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class VendorPage_NAV {
	
	/** The driver. */
	WebDriver driver;
	
	@FindBy(how=How.XPATH, using="//a[contains(text(),'Vendors')]")
	WebElement textVendor;
	@FindBy(how=How.XPATH, using=".//*[text()='Partner Bank Type']/../div/div/select")
	WebElement partnerbank;
		
	@FindBy(how=How.XPATH, using="(//*[starts-with(text(),' Create')])[2]")
	WebElement menuCreateVendor;
	
	@FindBy(how=How.XPATH, using="//span[contains(text(),'Y001, 3rd Party Vendor')]")
	WebElement btnvendorTypeSelect;
	
	@FindBy(how=How.XPATH, using="//*[@class='glyphicon glyphicon-forward']")
	WebElement btnCreate;
	
	@FindBy(how=How.XPATH, using="//*[text()='Local Data']")
	WebElement textLocalData;
	
	@FindBy(how=How.XPATH, using="//*[text()='Bank Data']")
	WebElement textBankData;

	@FindBy(how=How.XPATH, using=".//*[@class='glyphicon glyphicon-flash']")
	WebElement	btnLocalActions;

	@FindBy(how=How.XPATH, using="//*[text()='Disable Local Request']")
	WebElement	btnDisableLocalRequest;
	
	@FindBy(how=How.XPATH, using="//*[text()='Disable Bank Request']")
	WebElement	btnDisableBankRequest;

	@FindBy(how=How.XPATH, using="//*[text()='Proceed']")
	WebElement	btnProceed;
	
	//************** Filling create vendor data*************//
	
	@FindBy(how=How.XPATH, using=".//*[text()='Name 1']/../div/input")
	WebElement textName;
	
	@FindBy(how=How.XPATH, using="//*[text()='Search Term 1']/../div/input")
	WebElement textSearchterm1;
	
	@FindBy(how=How.XPATH, using="//*[text()='Search Term 2']/../div/input")
	WebElement textSearchterm2;
	
	@FindBy(how=How.XPATH, using=".//*[text()='Street']/../div/input")
	WebElement textStreet;
	
	@FindBy(how=How.XPATH, using=".//*[text()='House Number']/../div/input")
	WebElement textHouseNumber;
	
	@FindBy(how=How.XPATH, using=".//*[text()='Postal Code']/../div/input")
	WebElement textPostalCode;
	
	@FindBy(how=How.XPATH, using=".//*[text()='City']/../div/input")
	WebElement textCity;
	
	@FindBy(how=How.XPATH, using=".//*[text()='Country']/../div/div/select")
	WebElement textCountry;
	
	@FindBy(how=How.XPATH, using=".//*[text()='Region']/../div/div/select")
	WebElement textRegion;
	
	@FindBy(how=How.XPATH, using=".//*[text()='Language Key']/../div/div/select")
	WebElement textLanguageKey;
	
	@FindBy(how=How.XPATH, using=".//*[text()='Credit Information Number']/../div/input")
	WebElement textCreditInformationNumber;
	
	@FindBy(how=How.XPATH, using=".//*[text()='Industry Key']/../div/div/select")
	WebElement textIndustryKey;
	
	@FindBy(how=How.XPATH, using=".//*[text()='Corporate Group']/../div/div/select")
	WebElement textCorporateGroup;
	
	@FindBy(how=How.XPATH, using=".//*[text()='Company ID Of TradingPartner']/../div/div/select")
	WebElement textCompanyTradeGroup;
	
	
	@FindBy(how=How.XPATH, using=".//*[text()='Request complies to all Validations']")
	WebElement txtValidationMsg;
	
	@FindBy(how=How.XPATH, using=".//*[text()='Vendor Posting Group']/../div/div/select")
	WebElement SelectPostingGroup;
	
	@FindBy(how=How.XPATH, using=".//*[text()='VAT Bus. Posting Group']/../div/div/select")
	WebElement SelectVATPostingGroup;
	
	@FindBy(how=How.XPATH, using=".//*[text()='Gen. Bus. Posting Group']/../div/div/select")
	WebElement SelectGenPostingGroup;
	
	@FindBy(how=How.XPATH, using=".//*[text()='Bank Country']/../div/div/select")
	WebElement SelectBankCountry;
	
	@FindBy(how=How.XPATH, using=".//*[text()='Currency Code']/../div/div/select")
	WebElement SelectCurrencyCode;
	
	@FindBy(how=How.XPATH, using=".//*[text()='Partner Bank Type']/../div/div/select")
	WebElement SelectPartnerBankType;
	
	@FindBy(how=How.XPATH, using="//*[text()='Purchasing']")
	WebElement LinkPurchasing;
	
	@FindBy(how=How.XPATH, using=".//*[text()='Payment Terms Code']/../div/div/select")
	WebElement	SelectPaymentTermsCode;
	
	@FindBy(how=How.XPATH, using=".//*[text()='Payment Method Code']/../div/div/select")
	WebElement	SelectPaymentMethodCode;
	
	
	//**********************************Global Actions*****************************************************************
	
	@FindBy(how=How.XPATH, using=".//button[text()='Submit Global Request']")
	WebElement btnGlobalRequest;
	
	@FindBy(how=How.XPATH, using=".//button[text()='Submit Local Request']")
	WebElement btnLocalRequest;	
	
	@FindBy(how=How.XPATH, using="(.//button[text()='Submit Global and Local Request']/span)[2]")
	WebElement btnGlobalLocalRequest;
	
	@FindBy(how=How.XPATH, using=".//button[text()='Submit Bank Request']")
	WebElement btnBankRequest;
	
	@FindBy(how=How.XPATH, using=".//button[text()='Save As Draft']")
	WebElement btnSaveAsDraft;
	
	@FindBy(how=How.XPATH, using="//*[text()='Validate']")
	WebElement btnValidate;
	
	@FindBy(how=How.XPATH, using="//*[text()='Duplicate Check']")
	WebElement btnDuplicateCheck;
	
	@FindBy(how=How.XPATH, using="//*[text()='Reject Global Request']")
	WebElement btnRejectGlobalRequest;
	
	@FindBy(how=How.XPATH, using="//*[text()='Discard Create']")
	WebElement btnDiscardCreate;
	@FindBy(how=How.XPATH, using="//*[text()='Is DefaultBank']/../div/div/label//input[@value='true']")
	WebElement SelectRadiobutton;
	
	
	//****************************************************************************************************************
	
	@FindBy(how=How.XPATH, using=".//*[@id='mxui_widget_DialogMessage_0']/div[1]/div[2]/p")
	WebElement msgRequestSuccess;
	
	@FindBy(how=How.XPATH, using="//*[text()='No matches / possible duplicates have been found.']")
	WebElement msgDuplicateInfo;
	
	@FindBy(how=How.XPATH, using="//*[text()='OK']")
	WebElement btnOK;
	
	@FindBy(how=How.XPATH, using="//*[text()='Request ID']/../../td[4]/div/input")
	WebElement txtboxReqIdEnter;
	
	@FindBy(how=How.XPATH, using="(//*[starts-with(text(),' Dashboard')])[2]")
	WebElement menuMaterialDashboard;

	@FindBy(how=How.XPATH, using="//*[@class='glyphicon glyphicon-plus']")
	WebElement btnAdvancedSearch;

	@FindBy(how=How.XPATH, using="//button[text()='Search']")
	WebElement btnReqIdEnter;

	@FindBy(how=How.XPATH, using="//*[text()='Created On']/../../td[4]/div/div/div/input")
	WebElement txtboxCreateOnEnter;

	@FindBy(how=How.XPATH, using="//button[text()='Get Full Material Data']")
	WebElement btnFullMaterailData;
	
	@FindBy(how=How.CSS, using=".btn.btn-primary")
	WebElement btnMsgReqIdOk;
	
	//************ Reject Button action to give comments
	@FindBy(how=How.XPATH, using="(.//*[starts-with(@id,'uniqName') And text()='New'])[4]")
	WebElement btnCommentNew;
	
	@FindBy(how=How.XPATH, using="(//*[text()='Comments'])[3]/../div/div[2]/div[2]/button[1]")
	WebElement btnCommentNewReject;
	
	@FindBy(how=How.XPATH, using="//*[text()='Finance']/../../../div/div[1]/div/div/div[2]/div[2]/div[2]/button[1]")
	WebElement btnFinanceNew;
	
	@FindBy(how=How.XPATH, using="//*[text()='Purchasing']/../../../div/div[2]/div/div/div/div[2]/div[2]/button[1]")
	WebElement btnPurchasingNew;
	
	@FindBy(how=How.XPATH, using="//*[text()='Purchasing']/../../../div/div[2]/div/div/div[2]/div[2]//button[text()='Edit']")
	WebElement btnPurchasingEdit;
	@FindBy(how=How.XPATH, using="//*[text()='Finance']/../../../div/div[1]/div/div/div[2]/div[2]//button[text()='Edit']")
	WebElement btnFinanceEdit;	
		
	@FindBy(how=How.XPATH, using="//*[text()='Bank Details']/../div/div[1]/div/div/div/div[2]/div[2]/button[1]")
	WebElement btnBankNew;
	
	@FindBy(how=How.XPATH, using=".//*[text()='Select']")
	WebElement btnSelectBankKey;
	
	
		
	@FindBy(how=How.XPATH, using=".//*[text()='Select the correct Bank Key']/../../div/div/div/div/div/div/div/div/div[1]/div[1]/button[1]")
	WebElement btnSearch2;	
	
	@FindBy(how=How.XPATH, using=".//*[text()='Select the correct Bank Key']/../../div/div/div/div/div/div/div/div/div/div[2]/button[2]")
	WebElement btnSelect;
	
	@FindBy(how=How.XPATH, using=".//*[text()='Select the correct Bank Key']/../../div/div/div/div/div/div/div/div/div[1]/div[2]/div[1]/div[2]/input")
	WebElement textBankKey;
	
	@FindBy(how=How.XPATH, using=".//*[text()='Select the correct Bank Key']/../../div/div/div/div/div/div/div/div/div[3]/div/table[2]/tbody/tr[1]/td[1]")
	WebElement SelectRow12;
	@FindBy(how=How.XPATH, using=".//*[text()='Select the correct Bank Key']/../../div/div/div/div/div/div/div/div/div/div[2]/button[1]")
	WebElement btnSearch;
		
		
	
	
	
	//@FindBy(how=How.XPATH, using=".//*[text()='Select the correct Bank Key']/../../div/div/div/div/div/div/div/div/div[1]/div[2]/div[1]/div[2]/input")
	//WebElement textBankKey;
	
	@FindBy(how=How.XPATH, using=".//*[text()='Select the correct Bank Key']/../../div/div/div/div/div/div/div/div/div[3]/div/table[2]/tbody/tr[1]/td[1]/div")
	WebElement SelectRow1;
		
	@FindBy(how=How.XPATH, using="(.//*[starts-with(@id,'mxui_widget_TextArea')])[5]")
	WebElement textComment;
	
	@FindBy(how=How.XPATH, using="//*[text()='Save']")
	WebElement btnSave;

	@FindBy(how=How.XPATH, using="//span[@class='glyphicon glyphicon-flash']")
	WebElement btnlocalAction;

	@FindBy(how=How.CSS, using=".glyphicon.glyphicon-ok")
	WebElement btnGDAApproval;
	
	@FindBy(how=How.XPATH, using="//*[text()='Reject Local Request']")
	WebElement btnRejectLocalRequest;

	@FindBy(how=How.XPATH, using="//*[text()='Global Data']")
	WebElement txtGlobalData;
	
	@FindBy(how=How.XPATH, using="//*[text()='My record is not a duplicate! Submit.']")
	WebElement btnDuplicateSubmit;
	
	@FindBy(how=How.XPATH, using="//*[@class='close mx-dialog-close']")
	WebElement btnClose;
	
	@FindBy(how=How.XPATH,using=".//*[text()='Duplicate Check']")
	WebElement duplicateCheckButton;

	@FindBy(how=How.XPATH, using="//*[text()='Finance']/../../../div/div[1]/div/div/div[2]/div[2]//button[text()='New']")
	WebElement btnNewFinance;
	
	@FindBy(how=How.XPATH, using=".//*[contains(text(),'Vendor Posting Group')]/../div/div/select")
	WebElement dropdownFinanceVendorPostingGroup;

	@FindBy(how=How.XPATH, using=".//*[contains(text(),'VAT Bus. Posting Group')]/../div/div/select")
	WebElement dropdownFinanceVATBusPostingGroup;

	@FindBy(how=How.XPATH, using="//*[text()='Validate']")
	WebElement btnValidateLocalData;
	
	@FindBy(how=How.XPATH, using="//*[text()='Save']")
	WebElement btnSaveLocalData;
	
	@FindBy(how=How.XPATH, using="//*[text()='Purchasing']")
	WebElement btnPurchasingNav;
	
	@FindBy(how=How.XPATH, using="//*[text()='Purchasing']/../../../div/div[2]/div/div/div[2]/div[2]//button[text()='New']")
	WebElement btnNewPurchasing; 
	
	@FindBy(how=How.XPATH, using=".//*[contains(text(),'Payment Terms Code')]/../div/div/select")
	WebElement dropdownPurchasingPaymentTC;
	
	@FindBy(how=How.XPATH, using=".//*[contains(text(),'Payment Method Code')]/../div/div/select")
	WebElement dropdownPurchasingPaymentMC;	
	@FindBy(how=How.XPATH, using=".//*[text()='CompanyCode']/../../../../../../table[2]/tbody/tr[2]")
	WebElement selectVendorFinancePlant;	
	@FindBy(how=How.XPATH, using=".//*[text()='PurchasingOrganization']/../../../../../../table[2]/tbody/tr[1]")
	WebElement selectVendorPurchasingPlant;


/**********************************************************************************************************
	/**
	 * Instantiates a new home page.
	 *
	 * @param driver the driver
	 */
	
	public VendorPage_NAV(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
		
	}	
	
///********************* Methods for each Action ****************
/*****************************************************************************/
	
	public void  switchToMDMPortal()	throws InterruptedException 
	{
	String mainWindowHandl = driver.getWindowHandle();
	
	//Switch to child window and close it
		for (String childWindowHandle : driver.getWindowHandles()) 
		{
			//If window handle is not main window handle then close it 
			if(!childWindowHandle.equals(mainWindowHandl))
			{
					driver.switchTo().window(childWindowHandle);
			}
		} 
			
		Sync.waitUntilObjectDisappears(driver, "Loading Indicator", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForObject(driver, textVendor);
		driver.manage().window().maximize();
	}
		
/*****************************************************************************/
	public void clickVendor() throws InterruptedException
	{
	Sync.waitForSeconds(Constants.WAIT_6);
	Sync.waitForSeconds(Constants.WAIT_6);
	Sync.waitForObject(driver ,"Vendors", textVendor);
		Button.NewmouseOver("Vendors", driver, textVendor);
		Sync.waitForSeconds(Constants.WAIT_1);	
		Button.click("clicking on vendor link", textVendor);
		
	}

/*****************************************************************************/
	public boolean createVendorNavigate() throws InterruptedException 
	{

		if(Button.verifyObject(menuCreateVendor)){
			Sync.waitForObject(driver ,"Create", menuCreateVendor);
			Sync.waitForSeconds(Constants.WAIT_1);		
			return Button.click("Create", menuCreateVendor);
		}else{
			return Button.click("Create", menuCreateVendor);
		}
	}
/*****************************************************************************/
	public boolean VendorTypeSelection() throws InterruptedException 
	{

		Sync.waitForSeconds(Constants.WAIT_6);
		if(Button.verifyObject(btnvendorTypeSelect)){
			Sync.waitForObject(driver ,"Material Type Select", btnvendorTypeSelect);
			Sync.waitForSeconds(Constants.WAIT_1);		
			return Button.click("Material Type Select", btnvendorTypeSelect);
		}else{
			return Button.click("Material Type Selection", btnvendorTypeSelect);
		}
	}
/*****************************************************************************/
	public boolean createButtonClick() throws InterruptedException 
	{

		Sync.waitForSeconds(Constants.WAIT_2);
		if(Button.verifyObject(btnCreate)){
			Sync.waitForObject(driver ,"Create Button Click", btnCreate);
			Sync.waitForSeconds(Constants.WAIT_1);		
			return Button.click("Create Button Click", btnCreate);
		}else{
			return Button.click("Create Button Click", btnCreate);
		}
		
	}
	
/*****************************************************************************/
	public void ClickBankData_NAV() 
	{

		Sync.waitForSeconds(Constants.WAIT_6);
		//Sync.waitUntilObjectDisappears(driver, "Waiting of Create page to Load", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForObject(driver, textBankData);
		Button.jsclick("Local Data", textBankData, driver);
	}
/*****************************************************************************/
	public void ClickLocaData_NAV() 
	{

		Sync.waitForSeconds(Constants.WAIT_6);
		Sync.waitUntilObjectDisappears(driver, "Waiting of Create page to Load", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForObject(driver, textLocalData);
		Button.click("Local Data", textLocalData);
	}
	
/*****************************************************************************/
	public void ClickFinaceNew() 
	{

		Sync.waitForSeconds(Constants.WAIT_6);
	//	Sync.waitUntilObjectDisappears(driver, "Waiting of Create page to Load", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForObject(driver, btnFinanceNew);
		Button.click("New finace button", btnFinanceNew);
	}
	
/*****************************************************************************/
	public void ClickFinaceEdit() 
	{

		Sync.waitForSeconds(Constants.WAIT_6);
	//	Sync.waitUntilObjectDisappears(driver, "Waiting of Create page to Load", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForObject(driver, btnFinanceEdit);
		Button.click("New finace button", btnFinanceEdit);
	}
	/*******************************************************************************/
	public void ClickPurchasingNew() 
	{
		Sync.waitUntilObjectDisappears(driver, "Waiting of Create page to Load", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class='mx-name-index-0']")));
		Button.click("Link Purchasing", LinkPurchasing);
		Sync.waitForSeconds(Constants.WAIT_3);
		Sync.waitUntilObjectDisappears(driver, "Waiting of Create page to Load", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForObject(driver, btnPurchasingNew);
		Button.click("New Purchasing button", btnPurchasingNew);
	}
	

/*****************************************************************************/
	public void ClickPurchasingTab() 
	{  
		Sync.waitForSeconds(Constants.WAIT_6);	   	
		Sync.waitUntilObjectDisappears(driver, "Waiting of Create page to Load", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		WebDriverWait wait = new WebDriverWait(driver,50);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Purchasing']")));
		Button.click("Link Purchasing", LinkPurchasing);
		Sync.waitForSeconds(Constants.WAIT_3);
		//Sync.waitUntilObjectDisappears(driver, "Waiting of Create page to Load", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));		
	}
	/********************************************************************************/
	public void ClickPurchasingEdit() 
	{
		Sync.waitUntilObjectDisappears(driver, "Waiting of Create page to Load", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForObject(driver, btnPurchasingEdit);
		WebDriverWait wait = new WebDriverWait(driver,50);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Purchasing']/../../../div/div[2]/div/div/div[2]/div[2]//button[text()='Edit']")));
		Button.click("Edit Purchasing button", btnPurchasingEdit);
	}
/************************************************************************************************/
	
	public void ClickBankDetailsNew() 
	{
		Sync.waitForSeconds(Constants.WAIT_6);
		Sync.waitForObject(driver, btnBankNew);
		Button.jsclick("New Bank Button", btnBankNew, driver);
		Sync.waitForSeconds(Constants.WAIT_3);
		//Sync.waitUntilObjectDisappears(driver, "Waiting of Create page to Load", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));

	}
/*****************************************************************************/
	public boolean disableLocaData_NAV() 
	{

		Sync.waitForSeconds(Constants.WAIT_6);
		Sync.waitUntilObjectDisappears(driver, "Waiting of Create page to Load", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForObject(driver, textLocalData);
		Button.click("Local Data", textLocalData);
		Button.click("Local Actions button", btnLocalActions);
		Button.click("Disable Local Request", btnDisableLocalRequest);
		return Button.click("Proceed", btnProceed);
	}
/*****************************************************************************/	
	public boolean disableBankData_NAV() 
	{

		Sync.waitForSeconds(Constants.WAIT_3);
		Sync.waitUntilObjectDisappears(driver, "Waiting of Create page to Load", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForObject(driver, textBankData);
		Button.click("Local Data", textBankData);
		//Button.click("Local Actions button", btnLocalActions);
		Sync.waitForSeconds(Constants.WAIT_1);
		Button.click("Local Actions button", btnLocalActions);
		Button.click("Disable Bank Request", btnDisableBankRequest);
		return Button.click("Proceed", btnProceed);
	}
/*****************************************************************************/		

	public void VendorName(String strValue)
	{
		Sync.waitForSeconds(Constants.WAIT_3);
		Sync.waitForObject(driver, textName);
		WebDriverWait wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(textName));
		Sync.waitForSeconds(Constants.WAIT_1);		
		Textbox.enterValue("Name to create vendor",textName, strValue);	
		Sync.waitForSeconds(Constants.WAIT_5);
		Textbox.click("clicking name1", textSearchterm1);
		
		
	}	
	/***************************************************************************/
	public void SearchTerm(String strValue)
	{
		Sync.waitForSeconds(Constants.WAIT_3);
		WebDriverWait wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(textSearchterm2));
		Textbox.click("Entering Search Term", textSearchterm2);
	}

/********************Address section Global Data*********************************************************/		

	public void AddressStreet(String strValue)
	{
		Sync.waitForSeconds(Constants.WAIT_1);
		Sync.waitForObject(driver, textStreet);
		Textbox.enterValue("Enter Street",textStreet, strValue);	
	}
	
	public void AddresHouseNumber(String strValue)
	{
		Sync.waitForSeconds(Constants.WAIT_1);
		Sync.waitForObject(driver, textHouseNumber);
		Textbox.enterValue("Enter House Number",textHouseNumber, strValue);	
	}
	
	public void AddresPostalCode(String strValue)
	{
//		Sync.waitForSeconds(Constants.WAIT_1);
		Sync.waitForObject(driver, textPostalCode);
		Textbox.enterValue("Enter postal Code",textPostalCode, strValue);	
	}
	
	public void AddresCity(String strValue)
	{
//		Sync.waitForSeconds(Constants.WAIT_1);
		Textbox.enterValue("Enter City",textCity, strValue);	
	}
	
	public void AddresCountry(String strValue)
	{
        Sync.waitForSeconds(Constants.WAIT_2);
        if(DropDown.verifyObject(textCountry)) {
        	Sync.waitForObject(driver ,"Wait for Country", textCountry);
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on Country", textCountry);
			Select Country= new Select(textCountry);
			Country.selectByVisibleText(strValue);
			
		}else{
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on Country", textCountry);
			Select Country= new Select(textCountry);
			Country.selectByVisibleText(strValue);		
			}
		
        }
	public void clickCountry(String strValue) throws InterruptedException
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		this.AddresCountry(strValue);
	}
	
	
	public void AddresRegion(String strValue)
	{
		 Sync.waitForSeconds(Constants.WAIT_2);
	        if(DropDown.verifyObject(textRegion)) {
	        	Sync.waitForObject(driver ,"Wait for Region", textRegion);
				Sync.waitForSeconds(Constants.WAIT_5);
				Sync.waitForSeconds(Constants.WAIT_5);
				Button.click("Click on Region", textRegion);
				Select region= new Select(textRegion);
				region.selectByVisibleText(strValue);
				
			}else{
				Sync.waitForSeconds(Constants.WAIT_5);
				Sync.waitForSeconds(Constants.WAIT_5);
				Button.click("Click on Region", textRegion);
				Select region= new Select(textRegion);
				region.selectByVisibleText(strValue);		
				}		
		
	}
	public void clickRegion(String strValue) throws InterruptedException
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		this.AddresRegion(strValue);
	}
	
	public void AddresLanguageKey(String strValue)
	{
		Sync.waitForSeconds(Constants.WAIT_2);
        if(DropDown.verifyObject(textLanguageKey)) {
        	Sync.waitForObject(driver ,"Wait for Language Key", textLanguageKey);
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on Language Key", textLanguageKey);
			Select LanguageKey= new Select(textLanguageKey);
			LanguageKey.selectByVisibleText(strValue);
			
		}else{
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on Language Key", textLanguageKey);
			Select LanguageKey= new Select(textLanguageKey);
			LanguageKey.selectByVisibleText(strValue);	
			}		
	
		/*Sync.waitForSeconds(Constants.WAIT_2);
		Select LanguageKey= new Select(textLanguageKey);
//		LanguageKey.selectByVisibleText(strValue);
		Sync.waitForSeconds(Constants.WAIT_1);
		LanguageKey.selectByVisibleText(strValue);
		 List <WebElement> elementCount = LanguageKey.getOptions();
		 int iSize = elementCount.size();
//		 System.out.println(iSize);
		 for(int i =0; i<iSize ; i++)
		 {
			String sValue = elementCount.get(i).getText();
			if(sValue.equals(strValue))
			 {
				LanguageKey.selectByIndex(i);
			 break;
			 }
		 }*/
	}
	public void clickLanguageKey(String strValue) throws InterruptedException
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		this.AddresLanguageKey(strValue);
		Sync.waitForSeconds(Constants.WAIT_5);
	}
	
	public void AddressCreditInformationNumber(String strValue)
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		Textbox.enterValue("Enter Credit No",textCreditInformationNumber, strValue);	
		Sync.waitForSeconds(Constants.WAIT_5);
	}
	
	public void AddresIndustryKey(String strValue)
	{
		if(DropDown.verifyObject(textLanguageKey)) {
        	Sync.waitForObject(driver ,"Wait for Country", textIndustryKey);
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on Industry Key", textIndustryKey);
			Select IndustryKey= new Select(textIndustryKey);
			IndustryKey.selectByVisibleText(strValue);
			
		}else{
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on Industry Key", textIndustryKey);
			Select IndustryKey= new Select(textIndustryKey);
			IndustryKey.selectByVisibleText(strValue);	
			}		
		/*Sync.waitForSeconds(Constants.WAIT_1);
		Select IndustryKey= new Select(textIndustryKey);
//		IndustryKey.selectByVisibleText(strValue);
		Sync.waitForSeconds(Constants.WAIT_1);
		 List <WebElement> elementCount = IndustryKey.getOptions();
		 int iSize = elementCount.size();
		 System.out.println(iSize);
		 for(int i =0; i<iSize ; i++)
		 {
			String sValue = elementCount.get(i).getText();
			if(sValue.equals(strValue))
			 {
				IndustryKey.selectByIndex(i);
			 break;
			 }
		 }
	*/}
	public void clickIndustryKey(String strValue) throws InterruptedException
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		this.AddresIndustryKey(strValue);
		Sync.waitForSeconds(Constants.WAIT_5);
	}
	
	public void AddresCorporateGroup(String strValue)
	{
		if(DropDown.verifyObject(textLanguageKey)) {
        	Sync.waitForObject(driver ,"Wait for Country", textCorporateGroup);
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on Corporate Group", textCorporateGroup);
			Select CorporateGroup= new Select(textCorporateGroup);
			CorporateGroup.selectByVisibleText(strValue);
			
		}else{
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on Corporate Group", textCorporateGroup);
			Select CorporateGroup= new Select(textCorporateGroup);
			CorporateGroup.selectByVisibleText(strValue);
			}	
	}
		/*Sync.waitForSeconds(Constants.WAIT_1);
		Select CorporateGroup= new Select(textCorporateGroup);
//		CorporateGroup.selectByVisibleText(strValue);
		Sync.waitForSeconds(Constants.WAIT_1);
		 List <WebElement> elementCount = CorporateGroup.getOptions();
		 int iSize = elementCount.size();
		 System.out.println(iSize);
		 for(int i =0; i<iSize ; i++)
		 {
			String sValue = elementCount.get(i).getText();
			if(sValue.equals(strValue))
			 {
				CorporateGroup.selectByIndex(i);
			 break;
			 }
		 }*/
	public void clickCorporateGroup(String strValue) throws InterruptedException
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		this.AddresCorporateGroup(strValue);
		Sync.waitForSeconds(Constants.WAIT_5);
	}
	
	public void AddresCompanyTrading(String strValue)
	{
		Sync.waitForSeconds(Constants.WAIT_1);
		Select CompanyTradeGroup= new Select(textCompanyTradeGroup);
//		CorporateGroup.selectByVisibleText(strValue);
		Sync.waitForSeconds(Constants.WAIT_1);
		 List <WebElement> elementCount = CompanyTradeGroup.getOptions();
		 int iSize = elementCount.size();
		 System.out.println(iSize);
		 for(int i =0; i<iSize ; i++)
		 {
			String sValue = elementCount.get(i).getText();
			if(sValue.equals(strValue))
			 {
				CompanyTradeGroup.selectByIndex(i);
			 break;
			 }
		 }
	}
	
	public void ScrollDown() throws InterruptedException, AWTException
	{
		Robot robot = new Robot();  // Robot class throws AWT Exception	
	    Thread.sleep(2000); // Thread.sleep throws InterruptedException	
	    robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	    Thread.sleep(1000);
	    robot.keyRelease(KeyEvent.VK_PAGE_DOWN);  
	}
	
	public void Localactionbutton() {
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForObject(driver, btnLocalActions);
		Button.click("Local Actions button", btnLocalActions);
		Sync.waitForSeconds(Constants.WAIT_2);
	}
/********************END*********************************************************/	

/*************************NAV Finance data****************************************************/		

	public void VendorPostingGroup(String strValue)
	{
		Sync.waitForSeconds(Constants.WAIT_6);
		Select PostingGroup= new Select(SelectPostingGroup);
		Sync.waitForSeconds(Constants.WAIT_1);
		PostingGroup.selectByVisibleText(strValue);	
	}
	
/****************************************************************************************************/
	public void VendorVATPostingGroup(String strValue)
	{
			
		Sync.waitForSeconds(Constants.WAIT_1);
		Select BusPostingGroup= new Select(SelectVATPostingGroup);
		Sync.waitForSeconds(Constants.WAIT_1);
		BusPostingGroup.selectByVisibleText(strValue);	
	}
	
	
/****************************************************************************************************/
	public void VendorGenPostingGroup(String strValue)
	{
			
		Sync.waitForSeconds(Constants.WAIT_2);
		Select BusPostingGroup= new Select(SelectGenPostingGroup);
		Sync.waitForSeconds(Constants.WAIT_1);
		BusPostingGroup.selectByVisibleText(strValue);	
	}
	
/****************************************************************************************************/
	public void VendorBankCountry(String strValue)
	{
		//Sync.waitUntilObjectDisappears(driver, "Waiting of Create page to Load", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForSeconds(Constants.WAIT_2);
		Sync.waitForObject(driver, SelectBankCountry);
		Select BankCountry= new Select(SelectBankCountry);
		Sync.waitForSeconds(Constants.WAIT_1);
		BankCountry.selectByVisibleText(strValue);	
	}
	
	public void VendorBankCountry_JDE()
	{
		//Sync.waitUntilObjectDisappears(driver, "Waiting of Create page to Load", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForObject(driver, SelectBankCountry);
		Select BankCountry= new Select(SelectBankCountry);
		Sync.waitForSeconds(Constants.WAIT_2);
		BankCountry.selectByVisibleText("SG, Singapore");	
	}
	public void VendorBankCountry_SAP()
	{
		//Sync.waitUntilObjectDisappears(driver, "Waiting of Create page to Load", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForObject(driver, SelectBankCountry);
		Select BankCountry= new Select(SelectBankCountry);
		Sync.waitForSeconds(Constants.WAIT_2);
		BankCountry.selectByVisibleText("BE, Belgium");	
	}
	
/****************************************************************************************************/
	public void VendorCurrencyCode(String strValue)
	{
		//Sync.waitUntilObjectDisappears(driver, "Waiting of Create page to Load", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForSeconds(Constants.WAIT_2);
		Sync.waitForObject(driver, SelectCurrencyCode);
		Select CurrencyCode= new Select(SelectCurrencyCode);
		Sync.waitForSeconds(Constants.WAIT_1);
		CurrencyCode.selectByVisibleText(strValue);	
		Sync.waitForSeconds(Constants.WAIT_5);
	}
	
/****************************************************************************************************/
	public void VendorPatnerBankType(String strValue)
	{
		Sync.waitForSeconds(Constants.WAIT_1);
		Select CurrencyCode= new Select(SelectPartnerBankType);
		Sync.waitForSeconds(Constants.WAIT_1);
		CurrencyCode.selectByVisibleText(strValue);	
		Sync.waitForSeconds(Constants.WAIT_1);
		Button.jsclick("Click on Save", btnSave, driver);
		//Sync.waitUntilObjectDisappears(driver, "Waiting of Create page to Load", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));		
	}
	
/****************************************************************************************************/
	public boolean validateLocalTestCreate() {

		Sync.waitForSeconds(Constants.WAIT_5);
		Button.click("Local Actions button", btnLocalActions);
		Sync.waitForSeconds(Constants.WAIT_2);
		WebDriverWait wait=new WebDriverWait(driver, 60);
		Sync.waitForSeconds(Constants.WAIT_1);
		wait.until(ExpectedConditions.elementToBeClickable(btnValidate));
		return Button.click("Click Validate button on local action ", btnValidate);
	}

/****************************************************************************************************/
	public boolean LocalFinanceSave() {

		Sync.waitForSeconds(Constants.WAIT_3);
		WebDriverWait wait=new WebDriverWait(driver, 60);
		Sync.waitForSeconds(Constants.WAIT_1);
		wait.until(ExpectedConditions.elementToBeClickable(btnSave));
		return Button.click("Click Save button on local action ", btnSave);
	}
/****************************************************************************************************/
	public void PaymentTermsCode(String strValue)
	{
			
		Sync.waitForSeconds(Constants.WAIT_6);
		Sync.waitUntilObjectDisappears(driver, "Waiting of Create page to Load", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Select BusPostingGroup= new Select(SelectPaymentTermsCode);
		Sync.waitForSeconds(Constants.WAIT_1);
		BusPostingGroup.selectByVisibleText(strValue);	
	}
	
/****************************************************************************************************/
	public void PaymentMethodCode(String strValue)
	{
			
		Sync.waitForSeconds(Constants.WAIT_1);
		Select BusPostingGroup= new Select(SelectPaymentMethodCode);
		Sync.waitForSeconds(Constants.WAIT_1);
		BusPostingGroup.selectByVisibleText(strValue);	
	}
/****************************************************************************************************/
	public boolean validateTestCreate() {

		Sync.waitForSeconds(Constants.WAIT_3);
		WebDriverWait wait=new WebDriverWait(driver, 60);
		Sync.waitForSeconds(Constants.WAIT_1);
		wait.until(ExpectedConditions.elementToBeClickable(btnValidate));
		return Button.click("Click Validate button on local action ", btnValidate);
	}
/****************************************************************************************************/
	public void submitGlobalRequest() throws InterruptedException {
		Sync.waitForSeconds(Constants.WAIT_1);
		WebDriverWait wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(btnGlobalRequest));
		Button.click("Click Global submit Global Request", btnGlobalRequest);
		Sync.waitForSeconds(Constants.WAIT_2);
	}
/*********************************************************************************************/
	public void submitLocalRequest() throws InterruptedException {
		Sync.waitForSeconds(Constants.WAIT_1);
		WebDriverWait wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(btnLocalRequest));
		Button.click("Click Local submit Local Request", btnLocalRequest);
		Sync.waitForSeconds(Constants.WAIT_2);
	}

	public void approveBankRequest() throws InterruptedException {
		Sync.waitForSeconds(Constants.WAIT_1);
		WebDriverWait wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(btnBankRequest));
		Button.click("Click Local submit Local Request", btnBankRequest);
		Sync.waitForSeconds(Constants.WAIT_2);
	}

	/*******************************************************************************************/
	
	public void submitGlobalRequestTest() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		Sync.waitForSeconds(Constants.WAIT_3);
		
		Sync.waitForObject(driver, "Verify Validate message", txtValidationMsg);
		WebDriverWait wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(btnLocalActions));
/*		Button.click("Local Actions button", btnLocalActions);
		Sync.waitForSeconds(Constants.WAIT_2);*/
		Button.click("Local Actions button", btnLocalActions);
		Sync.waitForSeconds(Constants.WAIT_1);
		wait.until(ExpectedConditions.elementToBeClickable(btnGlobalRequest));
		Button.click("Click Global submit Global Request", btnGlobalRequest);
		Sync.waitForSeconds(Constants.WAIT_2);
		Thread.sleep(8000);
	}
	
/****************************************************************************************************/
	public void submitGlobalLocalRequest() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		Sync.waitForSeconds(Constants.WAIT_6);
		Sync.waitForObject(driver, "Verify Validate message", txtValidationMsg);
	//	WebDriverWait wait=new WebDriverWait(driver, 60);
		Button.click("Local Actions button", btnLocalActions);
		Sync.waitForSeconds(Constants.WAIT_2);
		Button.click("Local Actions button", btnLocalActions);
		Sync.waitForSeconds(Constants.WAIT_2);
		Button.click("Local Actions button", btnLocalActions);
//		wait.until(ExpectedConditions.elementToBeClickable(btnGlobalLocalRequest));
		Button.click("Click Global and Local submit Global Request", btnGlobalLocalRequest);
		System.out.println("Clicked on Submit button");
		Sync.waitForSeconds(Constants.WAIT_2);
		Thread.sleep(8000);
	}
	
/****************************************************************************************************/
	public void submitBankRequest() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		Sync.waitForSeconds(Constants.WAIT_3);
		Sync.waitForObject(driver, "Verify Validate message", txtValidationMsg);
	//	WebDriverWait wait=new WebDriverWait(driver, 60);
/*		Button.click("Local Actions button", btnLocalActions);
		Sync.waitForSeconds(Constants.WAIT_1);*/
		Button.click("Local Actions button", btnLocalActions);
		Sync.waitForSeconds(Constants.WAIT_1);
		Button.click("Local Actions button", btnLocalActions);
//		wait.until(ExpectedConditions.elementToBeClickable(btnGlobalLocalRequest));
		Button.click("Click Bank Request", btnBankRequest);
		System.out.println("Clicked on Submit button");
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForElementToBeClickable(driver, btnOK);
		Button.click("Click Ok Button", btnOK);
	}
	
/****************************************************************************************************/
	public void SaveAsDraft() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		Sync.waitForSeconds(Constants.WAIT_2);
		Sync.waitForObject(driver, "Verify Validate message", txtValidationMsg);
		WebDriverWait wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(btnLocalActions));
		Button.click("Local Actions button", btnLocalActions);
		Sync.waitForSeconds(Constants.WAIT_2);
		Button.click("Local Actions button", btnLocalActions);
		Sync.waitForSeconds(Constants.WAIT_1);
		wait.until(ExpectedConditions.elementToBeClickable(btnSaveAsDraft));
		Button.click("Click Save as Draft button", btnSaveAsDraft);
		Sync.waitForSeconds(Constants.WAIT_2);
		Thread.sleep(8000);
	}
/****************************************************************************************************/	
	public  String getRequestId() throws InterruptedException, FileNotFoundException, IOException {
		
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS) ;
		Sync.waitForObject(driver, "Wait of Dialog Box Success Message", msgRequestSuccess);
		Sync.waitForSeconds(Constants.WAIT_3);
		
		WebDriverWait wait=new WebDriverWait(driver, 60);
//		WebElement text = driver.findElement(By.xpath(".//*[@id='mxui_widget_DialogMessage_0']/div[1]/div[2]/p"));
//		wait.until(ExpectedConditions.elementToBeSelected(text));
		String reqId=driver.findElement(By.xpath(".//*[@id='mxui_widget_DialogMessage_0']/div[1]/div[2]/p")).getText();
		String[] parts = reqId.split(" ");
		String Id = parts[2];
		System.out.println("RequestId is: " + Id);
		ExcelUtil.excelWrite(Id);
		System.out.println("Excel write is done");
		wait.until(ExpectedConditions.elementToBeClickable(btnOK));
		Sync.waitForSeconds(Constants.WAIT_2);
		Sync.waitForElementToBeClickable(driver, btnOK);
		
		Button.click("Click Ok Button", btnOK);
		return Id;
	}
	
/****************************************************************************************************/	
	public  void submitRequestPopup_NAV() {
		
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS) ;
//		Sync.waitForObject(driver, "Wait of Dialog Box Success Message", msgRequestSuccess);
		Sync.waitForSeconds(Constants.WAIT_3);
		
		WebDriverWait wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(btnOK));
		Sync.waitForSeconds(Constants.WAIT_2);
		Sync.waitForElementToBeClickable(driver, btnOK);
		
		Button.click("Click Ok Button", btnOK);
	}
	
	/****************************************************************************************************/	
	public  String getRequestId_Draft() throws InterruptedException, FileNotFoundException, IOException {
		
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS) ;
		Sync.waitForObject(driver, "Wait of Dialog Box Success Message", msgRequestSuccess);
		Sync.waitForSeconds(Constants.WAIT_3);
		
		WebDriverWait wait=new WebDriverWait(driver, 60);
//		WebElement text = driver.findElement(By.xpath(".//*[@id='mxui_widget_DialogMessage_0']/div[1]/div[2]/p"));
//		wait.until(ExpectedConditions.elementToBeSelected(text));
		String reqId=driver.findElement(By.xpath(".//*[@id='mxui_widget_DialogMessage_0']/div[1]/div[2]/p")).getText();
		String[] parts = reqId.split(" ");
		String Id = parts[16];
		String Idnum = Id.replaceAll("\\.", "");
		System.out.println("RequestId is: " + Idnum);
		
		ExcelUtil.excelWrite(Idnum);
		System.out.println("Excel write is done");
		wait.until(ExpectedConditions.elementToBeClickable(btnOK));
		Sync.waitForSeconds(Constants.WAIT_2);
		Sync.waitForElementToBeClickable(driver, btnOK);
		
		Button.click("Click Ok Button", btnOK);
		return Id;
	}
/****************************************************************************************************/	
	public boolean navigateToDashboard() {

		Sync.waitUntilObjectDisappears(driver, "Wait for Materials", By.xpath((".//*[@id='mxui_widget_Progress_0']/div[2]")));
		Sync.waitForObject(driver, "Wait until the vendor appears", textVendor);
		Button.click("Click Materials Menu", textVendor);
		return Button.click("Click Dashboard Menu", menuMaterialDashboard);
	}
	
/****************************************************************************************************/
	public void advancedSearch() throws InterruptedException
	{

		TimeUnit.SECONDS.sleep(8);
		driver.switchTo().window("Application");
		TimeUnit.SECONDS.sleep(7);
		Button.click("Click Advanced Search", btnAdvancedSearch);
		TimeUnit.SECONDS.sleep(3);
	}
	
/****************************************************************************************************/
	public void scrolltoGlobalSearch() {
		JavascriptExecutor js;
		js = (JavascriptExecutor) driver;
		js.executeScript("$(\".mx-layoutcontainer-wrapper.mx-scrollcontainer-wrapper\").animate({ scrollBottom: \"100px\" })");
	}

/****************************************************************************************************/	
	public  void reqIdSearchGlobal(String strValue) throws InterruptedException {
		Sync.waitForSeconds(Constants.WAIT_2);
		WebElement elementSearch=driver.findElement(By.xpath("//*[text()='Request ID']/../../td[4]/div/input"));
		Sync.waitForObject(driver, txtboxReqIdEnter);

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		//get current date time with Date()
		Date date = new Date();

		// Now format the date
		String dateFormatted= dateFormat.format(date);
		Textbox.clear("Clear TextBox Value", txtboxReqIdEnter);
		Textbox.enterValue("Enter TextBox Value", txtboxReqIdEnter, strValue);
		Textbox.enterValue("Enter TextBox Value", txtboxCreateOnEnter, dateFormatted);
		Button.click("Click Search button", btnReqIdEnter);
		Sync.waitForSeconds(Constants.WAIT_2);	}
	
/****************************************************************************************************/
	public  String getGlobalId() throws FileNotFoundException, IOException {
		Sync.waitForSeconds(Constants.WAIT_3);
		Sync.waitForObject(driver, "Wait for Global Vendor Id", driver.findElement(By.xpath("//*[text()='Global Vendor ID']/../../../../../../table[2]/tbody/tr/td[4]/div")));
		String globalId=driver.findElement(By.xpath("//*[text()='Global Vendor ID']/../../../../../../table[2]/tbody/tr/td[4]/div")).getText();
		System.out.println(globalId);
		ExcelUtil.excelWriteGlobalId(globalId);;
		return globalId;
	}

/****************************************************************************************************/
	public void duplicateCheck() {
		try {
						
			WebElement waitElement = null;
			FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMinutes(3))
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
			    		  By.xpath(".//*[text()='Open Record']"))
			            );
			        }

			driver.manage().window().setPosition(new Point(-2000, 0)) ;
			driver.findElement(By.xpath(".//*[text()='Open Record']")).sendKeys(Keys.TAB);
			driver.findElement(By.xpath(".//*[text()='Export to Excel']")).sendKeys(Keys.TAB);
			driver.findElement(By.xpath("//*[text()='Confirm and Approve']")).sendKeys(Keys.TAB);
			driver.findElement(By.xpath("//*[text()='Confirm and Approve']")).sendKeys(Keys.RETURN);
			driver.findElement(By.xpath("//*[text()='Proceed']")).click();
			Sync.waitForSeconds(Constants.WAIT_3);


			driver.manage().window().maximize();
			Actions actions = new Actions(driver);
			actions.moveToElement(btnMsgReqIdOk);
			actions.perform();

			Button.click("Click Ok Button", btnMsgReqIdOk);

			
		}
		catch(Exception e) {
			System.err.println(e.getMessage());


		}
	}
/****************************************************************************************************/	
	public void RejectGDA() throws InterruptedException, AWTException {

		Thread.sleep(3000);
		System.out.println("Scrolling");
		Robot robot = new Robot();  // Robot class throws AWT Exception	
        Thread.sleep(1000); // Thread.sleep throws InterruptedException	
        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(1000);
        robot.keyRelease(KeyEvent.VK_DOWN);
        
        Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(1000);
	
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(1000);
		
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(1000);
		
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(1000);
        
		Sync.waitForObject(driver, btnCommentNew);
		Thread.sleep(5000);
		System.out.println("checking for new button");
		
//		driver.findElement(By.xpath("(.//*[@class='btn mx-button mx-name-newButton2 btn-default'])[1]")).click();
		
		System.out.println("clicked new button");
		Thread.sleep(2000);
		
/*		Button.jsclick("Click Comment Text Boc", textComment, driver);
//		Textbox.jsEnterValue("Enter Comments ", driver, textComment, "Material data");
		Thread.sleep(2000);
//		WebElement txtArea=driver.findElement(By.cssSelector("#mxui_widget_TextArea_2_input"));
//		 ((JavascriptExecutor) driver).executeScript("document.getElementById('mxui_widget_TextArea_3_input').focus");
		 String script ="arguments[0].setAttribute('value','Set to this text.')";
		 ((JavascriptExecutor) driver).executeScript(script,textComment);
//		Textbox.enterValue("typing comment", txtArea, "material data");
*/		 
		
		Thread.sleep(2000);
		Textbox.enterValue("typing comment", textComment, "Vendor data");
		Textbox.click("Click on Save Button", btnSave);
		Thread.sleep(2000);
		Button.click("Local Actions button click", btnLocalActions);
		Thread.sleep(2000);
		Sync.waitForObject(driver, btnRejectGlobalRequest);
		Textbox.click("Click on reject button in locl action", btnRejectGlobalRequest);
		Thread.sleep(3000);
		Sync.waitForObject(driver, btnOK);
		Button.click("Click On OK button", btnOK);
		Thread.sleep(2000);
	}
	/****************************************************************************************************/
	public void DiscardCreateLDR() throws InterruptedException {

		Thread.sleep(6000);
		Button.click("Local Actions button click", btnLocalActions);
		Thread.sleep(2000);
		Sync.waitForObject(driver, btnDiscardCreate);
		Textbox.click("Click on reject button in locl action", btnDiscardCreate);
		Thread.sleep(4000);
		Sync.waitForObject(driver, btnOK);
		Button.click("Click On OK button", btnOK);
		Thread.sleep(2000);
	}
/****************************************************************************************************/
	public void RejectLocaRequestLDS() throws InterruptedException, AWTException {

		Thread.sleep(3000);
		System.out.println("Scrolling");
		Robot robot = new Robot();  // Robot class throws AWT Exception	
        Thread.sleep(1000); // Thread.sleep throws InterruptedException	
        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(1000);
        robot.keyRelease(KeyEvent.VK_DOWN);
        
        Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(1000);
	
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(1000);
		
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(1000);
		
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(1000);
        
		Sync.waitForObject(driver, btnCommentNewReject);
		Thread.sleep(5000);
		System.out.println("checking for new button in LDS Reject ");
		
		Button.click("Click On new button", btnCommentNewReject);		
		System.out.println("clicked new button");
		Thread.sleep(2000);
		Textbox.enterValue("typing comment", textComment, "Vendor data");
		Textbox.click("Click on Save Button", btnSave);
		Thread.sleep(2000);
		Button.click("Local Actions button click", btnLocalActions);
		Thread.sleep(2000);
		Sync.waitForObject(driver, btnRejectLocalRequest);
		Textbox.click("Click on reject button in locl action", btnRejectLocalRequest);
		Thread.sleep(3000);
		Sync.waitForObject(driver, btnOK);
		Button.click("Click On OK button", btnOK);
		Thread.sleep(2000);
	}
/****************************************************************************************************/
	public void markViewsBtnClick_Local()
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
			      WebDriverWait wait = new WebDriverWait(driver, 60);
			      wait.until(ExpectedConditions.invisibilityOfElementLocated(
			    		  By.xpath(".//*[@id='mxui_widget_Progress_0']"))
			            );
			        }
			 System.out.println("Waiting for loading");
			Button.click("Click Local Action button", btnlocalAction);
			Sync.waitForSeconds(Constants.WAIT_2);
			
			Button.jsclick("Click Approval Button", driver.findElement(By.xpath("//button[text()='Mark all Views Completed']")), driver);
			Sync.waitForSeconds(Constants.WAIT_2);
	//		Button.jsclick("Click Approval Button", btnGDAApproval, driver);
		}
/****************************************************************************************************/
	
/****************************************************************************************************/		
	public boolean approveLocalRequest()
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForElementToBeClickable(driver, btnlocalAction);
		Button.click("Click Local Action button", btnlocalAction);
		return Button.jsclick("Click Approval Button", btnGDAApproval, driver);
	}

/****************************************************************************************************/
	public boolean approvalBtnClick()
	{

		Sync.waitForElementToBeClickable(driver, btnlocalAction);
		Button.click("Click Local Action button", btnlocalAction);
		return Button.click("Click Approval button", btnGDAApproval);
	}
	
/****************************************************************************************************/
	public void SelectBankKey_JDE()
	{
		Sync.waitForSeconds(Constants.WAIT_6);
		Button.jsclick("Click Select button", btnSelectBankKey, driver);
		Sync.waitForSeconds(Constants.WAIT_6);
		//Sync.waitUntilObjectDisappears(driver, "Waiting of Create page to Load", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForObject(driver, btnSearch);
		Button.jsclick("Click Search button", btnSearch, driver);
		Sync.waitForSeconds(Constants.WAIT_3);
		Textbox.enterValue("Bank Key type", textBankKey, "319002");
		Sync.waitForSeconds(Constants.WAIT_3);
		Button.jsclick("Select Row 1 in Bank Key", SelectRadiobutton, driver);
		Sync.waitForSeconds(Constants.WAIT_2);
		Button.jsclick("Click Search button", btnSearch2, driver);
		Sync.waitForSeconds(Constants.WAIT_2);
		Button.jsclick("Select Row 1 in Bank Key", SelectRow12, driver);
		Sync.waitForSeconds(Constants.WAIT_2);		
		Button.jsclick("click on select", btnSelect, driver);
		Sync.waitForSeconds(Constants.WAIT_2);
	}
	public void SelectBankKey_SAP()
	{
		Sync.waitForSeconds(Constants.WAIT_6);
		Button.jsclick("Click Select button", btnSelectBankKey, driver);
		Sync.waitForSeconds(Constants.WAIT_6);
		//Sync.waitUntilObjectDisappears(driver, "Waiting of Create page to Load", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForObject(driver, btnSearch);
		Button.jsclick("Click Search button", btnSearch, driver);
		Sync.waitForSeconds(Constants.WAIT_3);
		Textbox.enterValue("Bank Key type", textBankKey, "002");
		Sync.waitForSeconds(Constants.WAIT_3);
		Button.jsclick("Select Row 1 in Bank Key", SelectRadiobutton, driver);
		Sync.waitForSeconds(Constants.WAIT_2);
		Button.jsclick("Click Search button", btnSearch2, driver);
		Sync.waitForSeconds(Constants.WAIT_2);
		Button.jsclick("Select Row 1 in Bank Key", SelectRow12, driver);
		Sync.waitForSeconds(Constants.WAIT_2);		
		Button.jsclick("click on select", btnSelect, driver);
		Sync.waitForSeconds(Constants.WAIT_2);
	}
	public void SelectBankKey(String strValue)
	{
		Button.jsclick("Click Select button", btnSelectBankKey, driver);
		Sync.waitForSeconds(Constants.WAIT_3);
		//Sync.waitUntilObjectDisappears(driver, "Waiting of Create page to Load", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForObject(driver, btnSearch);
		Button.jsclick("Click Search button", btnSearch, driver);
		Sync.waitForSeconds(Constants.WAIT_2);
		Textbox.enterValue("Bank Key type", textBankKey, strValue);
		Button.jsclick("Click Search button", btnSearch2, driver);
		Sync.waitForSeconds(Constants.WAIT_2);
		Button.jsclick("Select Row 1 in Bank Key", SelectRow1, driver);
		Button.jsclick("click on select", btnSelect, driver);
		Sync.waitForSeconds(Constants.WAIT_2);
	}
	
	public void switchToGlobal() {
		// TODO Auto-generated method stub
		Sync.waitForObject(driver, txtGlobalData);
		if(Button.verifyObject(txtGlobalData))
		{
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.jsclick("Switch to Global Data", txtGlobalData, driver);
			Sync.waitForSeconds(Constants.WAIT_6);
		}
		else
		{
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.jsclick("Switch to Global Data", txtGlobalData, driver);
			Sync.waitForSeconds(Constants.WAIT_6);
		}
		
	}
	
/*************************************************************************************************************************************/
	 public void clickDuplicateCheck() 
     {
    	 Sync.waitUntilObjectDisappears(driver, "Wait for Duplicate check", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
    	 Sync.waitForSeconds(Constants.WAIT_5);
    	 WebDriverWait wait = new WebDriverWait(driver,50);
    	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='My record is not a duplicate! Submit.']")));
    	 
    	 if(Button.verifyObject(btnDuplicateSubmit)) 
    	 {
    		 Sync.waitForSeconds(Constants.WAIT_5);
    		 duplicateCheck_New();
    	 }
    	 else if(Button.verifyObject(btnClose))
    	 {

    		 Sync.waitForSeconds(Constants.WAIT_5);
    		 Sync.waitForObject(driver, "Wait for the information PopUp", msgRequestSuccess);

    		 clickOkToHandlePopup();
    	 }
     }
/*******************************************************************************************************************************************************/
	 public void duplicateCheck_New() {
			try {
			// Sync.waitUntilObjectDisappears(driver, "Wait for Duplicate check", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
	        Sync.waitForSeconds(Constants.WAIT_5);
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
	*/		WebDriverWait wait = new WebDriverWait(driver, 100);
	        
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[text()='Open Record']")));
		    System.out.println("Clicked on Open Record");
			
			//}

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


			driver.manage().window().maximize();
			Actions actions = new Actions(driver);
			actions.moveToElement(btnMsgReqIdOk);
			actions.perform();

			Button.click("Click Ok Button", btnMsgReqIdOk);

			/*try
			{
			if(btnMsgReqIdOkdraft.isEnabled())
			{
			Button.click("Click Ok Button", btnMsgReqIdOkdraft);
			System.out.println("Button is Clicked");
			}

			}
			catch(Exception e) {
			System.err.println(e.getMessage());


			}*/

			}
			catch(Exception e) {
			System.err.println(e.getMessage());


			}
			} 
	 /*******************************************************************************************************************************/
	 public boolean clickOkToHandlePopup()
		{
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_2);
		WebElement popUp = driver.findElement(By.xpath("//*[@class='close mx-dialog-close']"));
		return Button.jsclick("Click on Popup", popUp, driver);
		//Sync.waitForSeconds(Constants.WAIT_1);
	   // Button.jsclick("Click ok on info Popup", btnOkay, driver);
		} 
	 
	 
	 /*********************************************************************************************************************************/
	 public void duplicateCheckButton() {
		 if(Button.verifyObject(duplicateCheckButton)) {
			 Sync.waitForSeconds(Constants.WAIT_5);
			 Button.click("Click on Duplicate check", duplicateCheckButton);
		 }
		 else {
			 Button.click("Click on Duplicate check", duplicateCheckButton); 
		 }
	 }


	/*******************************************************************************************************************************/
	
	public void localAddInNewFinanceNav()
	{

		Sync.waitForSeconds(Constants.WAIT_10);
		Sync.waitForObject(driver, textLocalData);
		if(Button.verifyObject(btnNewFinance))
		{
			Sync.waitForObject(driver, btnNewFinance);
			Button.jsclick("Adding new Finance for Nav", btnNewFinance, driver);
			Sync.waitForSeconds(Constants.WAIT_10);
		}
		else
		{
			Sync.waitForSeconds(Constants.WAIT_10);
			Sync.waitForObject(driver, btnNewFinance);
			Button.jsclick("Adding new Finance for Nav", btnNewFinance, driver);
			Sync.waitForSeconds(Constants.WAIT_10);
		}

	} 
	
	/*******************************************************************************************************************************************/
	
	public void selectLocalFinanceVendorPostingGroupDropDown(String strValue) throws InterruptedException
	{
		//Sync.waitForObject(driver, driver.findElement(By.xpath(".//*[contains(text(),'Edit Local Data Planning')]")));
		Sync.waitForSeconds(Constants.WAIT_5);
		if(DropDown.verifyObject(dropdownFinanceVendorPostingGroup)){
			Sync.waitForObject(driver ,"Wait for Vendor Posting Group Select", dropdownFinanceVendorPostingGroup);
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on Vendor Posting Group Select", dropdownFinanceVendorPostingGroup);
			Select vendorPGDropDownSelect= new Select(dropdownFinanceVendorPostingGroup);
			vendorPGDropDownSelect.selectByVisibleText(strValue);
			
		}else{
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on Vendor Posting Group Select", dropdownFinanceVendorPostingGroup);
			Select vendorPGDropDownSelect= new Select(dropdownFinanceVendorPostingGroup);
			vendorPGDropDownSelect.selectByVisibleText(strValue);
		}
		
	}
	
	public void clickAndSelectVendorPostingGroupDropDown(String strValue) throws InterruptedException
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		this.selectLocalFinanceVendorPostingGroupDropDown(strValue);
	}

	/*************************************************************************************************************************************************/
		
	public void selectLocalFinanceVATBusPostingGroupDropDown(String strValue) throws InterruptedException
	{
		//Sync.waitForObject(driver, driver.findElement(By.xpath(".//*[contains(text(),'Edit Local Data Planning')]")));
		Sync.waitForSeconds(Constants.WAIT_5);
		if(DropDown.verifyObject(dropdownFinanceVATBusPostingGroup)){
			Sync.waitForObject(driver ,"Wait for Vendor Posting Group Select", dropdownFinanceVATBusPostingGroup);
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on VAT Bus. Posting Group Select", dropdownFinanceVATBusPostingGroup);
			Select vendorPGDropDownSelect= new Select(dropdownFinanceVATBusPostingGroup);
			vendorPGDropDownSelect.selectByVisibleText(strValue);
			
		}else{
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on VAT Bus. Posting Group Select", dropdownFinanceVATBusPostingGroup);
			Select vATBPostingGroupDropDownSelect= new Select(dropdownFinanceVATBusPostingGroup);
			vATBPostingGroupDropDownSelect.selectByVisibleText(strValue);
		}
		
	}
	
	public void clickAndSelectVATBusPostingGroupDropDown(String strValue) throws InterruptedException
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		this.selectLocalFinanceVATBusPostingGroupDropDown(strValue);
	}
	
/**************************************************************************************************************************************************/
	
	public void validateAndSaveLocalData()
	{
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
/******************************************************************************************************************************************/	
	
	public void localAddInPurchasingNav()
	{

		Sync.waitForObject(driver, btnPurchasingNav);
		Button.jsclick("Click on the Purchasing Button in Local Data", btnPurchasingNav, driver);
		Sync.waitForSeconds(Constants.WAIT_5);

		Sync.waitForObject(driver, btnNewPurchasing);
		if(Button.verifyObject(btnNewPurchasing))
		{
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForObject(driver, btnNewPurchasing);
			Button.jsclick("Click create add data in Purchasing", btnNewPurchasing, driver);
			Sync.waitForSeconds(Constants.WAIT_5);

		}
		else
		{
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForObject(driver, btnNewPurchasing);
			Button.jsclick("Click create add data in Purchasing", btnNewPurchasing, driver);
			Sync.waitForSeconds(Constants.WAIT_5);
		}

	}
/****************************************************************************************************************************************/
	
	
	public void selectLocalPurchasingPaymentTCDropDown(String strValue) throws InterruptedException
	{
		//Sync.waitForObject(driver, driver.findElement(By.xpath(".//*[contains(text(),'Edit Local Data Planning')]")));
		Sync.waitForSeconds(Constants.WAIT_5);
		if(DropDown.verifyObject(dropdownPurchasingPaymentTC)){
			Sync.waitForObject(driver ,"Wait for Payment Term Code Select", dropdownPurchasingPaymentTC);
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on Payment Term Code Select", dropdownPurchasingPaymentTC);
			Select paymentTCDropDownSelect= new Select(dropdownPurchasingPaymentTC);
			paymentTCDropDownSelect.selectByVisibleText(strValue);
			
		}else{
			Sync.waitForObject(driver ,"Wait for Payment Term Code Select", dropdownPurchasingPaymentTC);
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on Payment Term Code Select", dropdownPurchasingPaymentTC);
			Select paymentTCDropDownSelect= new Select(dropdownPurchasingPaymentTC);
			paymentTCDropDownSelect.selectByVisibleText(strValue);		}
		
	}
	
	public void clickAndSelectPaymentTCDropDown(String strValue) throws InterruptedException
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		this.selectLocalPurchasingPaymentTCDropDown(strValue);
	}
	
	/************************************************************************************************************************************************/
	
	
	public void selectLocalPurchasingPaymentMCDropDown(String strValue) throws InterruptedException
	{
		//Sync.waitForObject(driver, driver.findElement(By.xpath(".//*[contains(text(),'Edit Local Data Planning')]")));
		Sync.waitForSeconds(Constants.WAIT_5);
		if(DropDown.verifyObject(dropdownPurchasingPaymentMC)){
			Sync.waitForObject(driver ,"Wait for Payment Method Code Select", dropdownPurchasingPaymentMC);
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on Payment Method Code Select", dropdownPurchasingPaymentMC);
			Select paymentMCDropDownSelect= new Select(dropdownPurchasingPaymentMC);
			paymentMCDropDownSelect.selectByVisibleText(strValue);
			
		}else{
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on Payment Method Code Select", dropdownPurchasingPaymentMC);
			Select paymentMCDropDownSelect= new Select(dropdownPurchasingPaymentMC);
			paymentMCDropDownSelect.selectByVisibleText(strValue);		
			}
		
	}
	
	public void clickAndSelectPaymentMCDropDown(String strValue) throws InterruptedException
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		this.selectLocalPurchasingPaymentMCDropDown(strValue);
	}
	
	public void selectVendorFinancePlant() 	
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForObject(driver, selectVendorFinancePlant);
		Button.click("Select the plant",selectVendorFinancePlant);
	}
	public void selectVendorPurchasingPlant() 	
	{
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForObject(driver, selectVendorPurchasingPlant);
		Button.click("Select the plant",selectVendorPurchasingPlant);
	}

	
	

}

