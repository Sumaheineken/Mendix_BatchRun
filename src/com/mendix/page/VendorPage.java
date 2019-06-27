package com.mendix.page;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
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
import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mendix.tool.Button;
import com.mendix.tool.Constants;
import com.mendix.tool.SharedDriver;
import com.mendix.tool.Sync;
import com.mendix.tool.Textbox;
import com.mendix.util.ExcelUtil;
import com.mendix.util.DataProviderUtil.staticProviderClass;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class VendorPage {

	/** The driver. */
	WebDriver driver;
	
	public String globalLockValue = null;
	
	public String localLockValue = null;
	
	public String fFDValue = null;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Vendors')]")
	WebElement textVendor;
	@FindBy(how = How.XPATH, using = "//*[text()=' Vendors']")
	WebElement vendorname;


	@FindBy(how = How.XPATH, using = "(//*[starts-with(text(),' Create')])[2]")
	WebElement menuCreateVendor;

	@FindBy(how = How.XPATH, using = "(//*[starts-with(text(),' Dashboard')])[2]")
	WebElement menuDashboard;

	@FindBy(how = How.XPATH, using = "//*[starts-with(text(),'Global ID')]/../../td[4]/div/input")
	WebElement GlobalIdSearch;

	@FindBy(how = How.XPATH, using = "//*[starts-with(text(),'Header')]/../button[1]")
	WebElement GlobalIdSearchButton;

	@FindBy(how = How.XPATH, using = "//button[text()='Get Full Vendor Data']")
	WebElement GetFullVendorData;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Y001, 3rd Party Vendor')]")
	WebElement btnvendorTypeSelect;

	@FindBy(how = How.XPATH, using = "//*[@class='glyphicon glyphicon-forward']")
	WebElement btnCreate;

	/*
	 * @FindBy(how=How.XPATH, using=".//*[text()='Discard Create']") WebElement
	 * btnLocalDiscard;
	 */

	@FindBy(how = How.XPATH, using = "//*[text()='Local Data']")
	WebElement textLocalData;

	@FindBy(how = How.XPATH, using = "//*[text()='Bank Data']")
	WebElement textBankData;

	@FindBy(how = How.XPATH, using = ".//*[@class='glyphicon glyphicon-flash']")
	WebElement btnLocalActions;

	@FindBy(how = How.XPATH, using = "//*[text()='Disable Local Request']")
	WebElement btnDisableLocalRequest;

	@FindBy(how = How.XPATH, using = "//*[text()='Disable Bank Request']")
	WebElement btnDisableBankRequest;

	@FindBy(how = How.XPATH, using = "//*[text()='Proceed']")
	WebElement btnProceed;
	@FindBy(how=How.XPATH, using="//*[text()='Discard Extension']")
	WebElement btnDiscardExtension;
	

	// ************** Filling create vendor data*************//

	@FindBy(how = How.XPATH, using = ".//*[text()='Name 1']/../div/input")
	WebElement textName;

	@FindBy(how = How.XPATH, using = ".//*[text()='Search Term 1']/../div/input")
	WebElement textSearchterm1;

	@FindBy(how = How.XPATH, using = ".//*[text()='Street']/../div/input")
	WebElement textStreet;

	@FindBy(how = How.XPATH, using = ".//*[text()='House Number']/../div/input")
	WebElement textHouseNumber;

	@FindBy(how = How.XPATH, using = ".//*[text()='Postal Code']/../div/input")
	WebElement textPostalCode;
	@FindBy(how = How.XPATH, using = "//*[text()='P.O. Box Postal Code']/../div/input")
	WebElement textPostalCodepo;
	@FindBy(how = How.XPATH, using = "//*[text()='P.O. Box']/../div/input")
	WebElement textPostalCodepobox;
	
	@FindBy(how = How.XPATH, using = ".//*[text()='City']/../div/input")
	WebElement textCity;

	@FindBy(how = How.XPATH, using = ".//*[text()='Country']/../div/div/select")
	WebElement textCountry;

	@FindBy(how = How.XPATH, using = ".//*[text()='Region']/../div/div/select")
	WebElement textRegion;

	@FindBy(how = How.XPATH, using = ".//*[text()='Language Key']/../div/div/select")
	WebElement textLanguageKey;

	@FindBy(how = How.XPATH, using = ".//*[text()='Credit Information Number']/../div/input")
	WebElement textCreditInformationNumber;

	@FindBy(how = How.XPATH, using = ".//*[text()='Industry Key']/../div/div/select")
	WebElement textIndustryKey;

	@FindBy(how = How.XPATH, using = ".//*[text()='Corporate Group']/../div/div/select")
	WebElement textCorporateGroup;

	@FindBy(how = How.XPATH, using = ".//*[text()='Request complies to all Validations']")
	WebElement txtValidationMsg;
	@FindBy(how=How.XPATH, using="//*[text()='Submit Local Request']")
	WebElement btnSumitLocalRequest;

	@FindBy(how = How.XPATH, using = ".//*[text()='Discard Create']")
	WebElement btnLocalDiscard;
	// **********************************Global
	// Actions*****************************************************************

	@FindBy(how = How.XPATH, using = ".//button[text()='Submit Global Request']")
	WebElement btnGlobalRequest;
	
	@FindBy(how = How.XPATH, using = ".//button[text()='Submit Local Request']")
	WebElement btnLocalRequest;

	@FindBy(how = How.XPATH, using = ".//button[text()='Save As Draft']")
	WebElement btnSaveAsDraft;

	@FindBy(how = How.XPATH, using = "//*[text()='Validate']")
	WebElement btnValidate;

	@FindBy(how = How.XPATH, using = "//*[text()='Duplicate Check']")
	WebElement btnDuplicateCheck;

	@FindBy(how = How.XPATH, using = "//*[text()='Reject Global Request']")
	WebElement btnRejectGlobalRequest;

	@FindBy(how = How.XPATH, using = "//*[text()='Discard Create']")
	WebElement btnDiscardCreate;
	@FindBy(how = How.XPATH, using = "((.//*[text()='Edit Comments'])/../../div[2]/div/div/div/div/div/div[1]/div/div/div/div/div/textarea)")
	WebElement textAreaComment;

	@FindBy(how=How.XPATH, using=".//*[text()='CompanyCode']/../../../../../../table[2]/tbody/tr[2]/td[1]")
	WebElement selectVendorFinancePlant;
	
	@FindBy(how=How.XPATH,using=".//*[text()='PurchasingOrganization']/../../../../../../table[2]/tbody/tr[1]/td[1]")
	WebElement selectVendorPurchasingPlant;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='mxui_widget_DialogMessage_0']/div[1]/div[2]/p")
	WebElement msgRequestSuccess;

	@FindBy(how = How.XPATH, using = "//*[text()='No matches / possible duplicates have been found.']")
	WebElement msgDuplicateInfo;

	@FindBy(how = How.XPATH, using = "//*[text()='OK']")
	WebElement btnOK;

	@FindBy(how = How.XPATH, using = "(//*[text()='OK'])[2]")
	WebElement btnOK1;

	@FindBy(how = How.XPATH, using = "//*[text()='Edit']")
	WebElement btnEdit;

	@FindBy(how = How.XPATH, using = "//*[text()='Edit Global Data']/../div/input")
	WebElement EditGlobalData;
	@FindBy(how = How.XPATH, using = "//*[text()='Edit Local Data']/../div/input")
	WebElement EditlocalData;
	@FindBy(how = How.XPATH, using = "//*[text()='Edit Bank Data']/../div/input")
   

	WebElement EditbankData;
	
	
	
	@FindBy(how=How.XPATH, using = "//*[text()='Edit Local Data']/../div/input")
	WebElement EditLocalData;
	
	@FindBy(how = How.XPATH, using = "//*[text()='Request ID']/../../td[4]/div/input")
	WebElement txtboxReqIdEnter;

	@FindBy(how = How.XPATH, using = "(//*[starts-with(text(),' Dashboard')])[2]")
	WebElement menuMaterialDashboard;

	@FindBy(how = How.XPATH, using = "//*[@class='glyphicon glyphicon-plus']")
	WebElement btnAdvancedSearch;

	@FindBy(how = How.XPATH, using = "//button[text()='Search']")
	WebElement btnReqIdEnter;

	@FindBy(how = How.XPATH, using = "//*[text()='Created On']/../../td[4]/div/div/div/input")
	WebElement txtboxCreateOnEnter;

	@FindBy(how = How.XPATH, using = "//*[text()='Created On']/../../../tr[4]/td[4]/div/div/div/input")
	WebElement txtboxCreateOnEnterSecond;

	@FindBy(how = How.XPATH, using = "//button[text()='Get Full Material Data']")
	WebElement btnFullMaterailData;

	@FindBy(how = How.CSS, using = ".btn.btn-primary")
	WebElement btnMsgReqIdOk;

	// ************ Reject Button action to give comments
	@FindBy(how = How.XPATH, using = "(.//*[starts-with(@id,'uniqName') And text()='New'])[4]")
	WebElement btnCommentNew;

	@FindBy(how = How.XPATH, using = "((.//*[text()='Edit Comments'])/../../div[2]/div/div/div/div/div/div[1]/div/div/div/div/div/textarea)")
	WebElement textComment;

	@FindBy(how = How.XPATH, using = "//*[text()='Save']")
	WebElement btnSave;

	@FindBy(how = How.XPATH, using = ".//button[text()='Submit Bank Request']")
	WebElement btnBankRequest;
	/*************************************************************************************************
	 * 
	 * /
	 ************************************************************************************************************/
	/************** Extend Flow Locators **********/

	@FindBy(how = How.XPATH, using = "//*[text()='Global ID']/../../td[4]/div/input")
	WebElement txtBoxGlobalId;
	@FindBy(how = How.XPATH, using = "//*[text()='Approve Global Request']")
	WebElement btnGlobalRequestApprove;
	

	@FindBy(how = How.XPATH, using = "//button[text()='Extend']")
	WebElement btnExtend;

	@FindBy(how = How.XPATH, using = "//*[text()='Global Data']")
	WebElement btnGlobalData;

	@FindBy(how = How.XPATH, using = "//button[@class='btn mx-button mx-name-actionButton1 btn-lg btn-action-panel pull-right btn-default']")
	WebElement btnToConfirm;

	@FindBy(how = How.XPATH, using = "//button[text()='Confirm Extension']")
	WebElement btnConfirmExtension;

	@FindBy(how = How.XPATH, using = "//button[text()='Flag For Deletion']")
	WebElement btnflagForDeletion;

	@FindBy(how = How.XPATH, using = "//button[@class='btn mx-button mx-name-actionButton8 btn-success']")
	WebElement btnok;
	
	@FindBy(how = How.XPATH, using = "(.//*[starts-with(@id,'uniqName') And text()='New'])[1]")
	WebElement btnCommentNewLBDA;
	
	@FindBy(how = How.XPATH, using = "//*[text()='Flag for Deletion']")
	WebElement btnFlagForDeletionConfirmNav;
	
	@FindBy(how = How.XPATH, using = ".//*[text()='Vendor account number']/../../../../../../table[2]/tbody/tr/td[2]//*[text()='PH1700']/../../td[1]/div")
	WebElement vendorAccountNumberBE;
	
	@FindBy(how = How.XPATH, using = ".//*[text()='Vendor account number']/../../../../../../table[2]/tbody/tr/td[2]//*[text()='PH1700']")
	WebElement vendorTargetSystemBE;
	
	@FindBy(how = How.XPATH, using = ".//*[text()='Vendor account number']/../../../../../../table[2]/tbody/tr/td[2]//*[text()='PE2700']")
	WebElement vendorTargetSystemPL;
	
	@FindBy(how = How.XPATH, using = ".//*[text()='Vendor account number']/../../../../../../table[2]/tbody/tr/td[2]//*[text()='PE2700']/../../td[1]/div")
	WebElement vendorAccountNumberPL;
	
	@FindBy(how=How.XPATH, using="//div[contains(@class,'mx-name-dataView2 searchResults')]//table[2]/tbody/tr[1]/td[1]/div")
	WebElement txtGlobalLockValue;
	
	@FindBy(how=How.XPATH, using=".//*[text()='Global Locked']/../../../../../../table[2]/tbody/tr[1]/td[2]/div")
	WebElement txtLocalLockValue;
	
	@FindBy(how=How.XPATH, using=".//*[text()='Global Locked']/../../../../../../table[2]/tbody/tr[1]/td[3]/div")
	WebElement txtFFDValue;
	
	@FindBy(how=How.XPATH, using="//*[text()='Edit Global Data']/../div/input")
	WebElement checkBoxEdit;


	/**********************************************************************************************************
	 * /** /** Instantiates a new home page.
	 *
	 * @param driver
	 *            the driver
	 */

	public VendorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;

	}

	/// ********************* Methods for each Action ****************
	/*****************************************************************************/

	public void switchToMDMPortal() throws InterruptedException {
		String mainWindowHandl = driver.getWindowHandle();

		// Switch to child window and close it
		for (String childWindowHandle : driver.getWindowHandles()) {
			// If window handle is not main window handle then close it
			if (!childWindowHandle.equals(mainWindowHandl)) {
				driver.switchTo().window(childWindowHandle);
			}
		}

		Sync.waitUntilObjectDisappears(driver, "Loading Indicator",
				By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForObject(driver, textVendor);
		driver.manage().window().maximize();
	}

	/*****************************************************************************/
	public void clickVendor() throws InterruptedException {
		Sync.waitForSeconds(Constants.WAIT_6);
		Sync.waitForSeconds(Constants.WAIT_6);
		Sync.waitForObject(driver, "Vendors", textVendor);
		Button.NewmouseOver("Vendors", driver, textVendor);
		Sync.waitForSeconds(Constants.WAIT_1);
		Button.jsclick("clicking on vendor link", textVendor, driver);

	}

	/*****************************************************************************/
	public boolean clickVendorDashboard() throws InterruptedException {
		if (Button.verifyObject(menuDashboard)) {
			Sync.waitForObject(driver, "Create", menuDashboard);
			Sync.waitForSeconds(Constants.WAIT_1);
			return Button.click("Dashboard", menuDashboard);
		} else {
			return Button.click("Dashboard", menuDashboard);
		}
	}

	/*****************************************************************************/
	public boolean createVendorNavigate() throws InterruptedException {

		if (Button.verifyObject(menuCreateVendor)) {
			Sync.waitForObject(driver, "Create", menuCreateVendor);
			Sync.waitForSeconds(Constants.WAIT_1);
			return Button.click("Create", menuCreateVendor);
		} else {
			return Button.click("Create", menuCreateVendor);
		}
	}

	/*****************************************************************************/

	public void VendorTypeSelection() throws InterruptedException {
		Sync.waitForObject(driver, "Material Type Select", btnvendorTypeSelect);
		Button.jsclick("Material Type Select", btnvendorTypeSelect, driver);	

	}

	/*****************************************************************************/
	public boolean createButtonClick() throws InterruptedException {

		Sync.waitForSeconds(Constants.WAIT_2);
		if (Button.verifyObject(btnCreate)) {
			Sync.waitForObject(driver, "Create Button Click", btnCreate);
			Sync.waitForSeconds(Constants.WAIT_1);
			return Button.click("Create Button Click", btnCreate);
		} else {
			return Button.click("Create Button Click", btnCreate);
		}

	}

	/*****************************************************************************/
	public void SearchGlobalID(String strValue) {

		Sync.waitForSeconds(Constants.WAIT_2);
		Sync.waitUntilObjectDisappears(driver, "Waiting of Create page to Load",
				By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForObject(driver, GlobalIdSearch);
		Button.click("Global ID text button", GlobalIdSearch);
		Textbox.enterValue("enter global id", GlobalIdSearch, strValue);
		Button.click("Global ID search button", GlobalIdSearchButton);
	}

	/*****************************************************************************/
	public void GetFullVendorData() {
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitUntilObjectDisappears(driver, "Waiting of Create page to Load",By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForObject(driver, GetFullVendorData);
		Button.click("GetFullVendorData", GetFullVendorData);
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitUntilObjectDisappears(driver, "Waiting of Create page to Load",
				By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));

		/*
		 * String globalLockState=driver.findElement(By.
		 * xpath("//*[text()='Global Lock']/../../../../../../table[2]/tbody[1]/tr[1]/td[1]/div"
		 * )).getText(); System.out.println(globalLockState);
		 * if(globalLockState.equalsIgnoreCase("NO")){
		 * Button.click("Select EDit button", EditGlobalData);
		 * Button.click("Click EDit button", btnEdit);
		 * 
		 * }
		 * 
		 * else if(globalLockState.equalsIgnoreCase("Yes")){
		 * 
		 * //String globalLockStateNew=driver.findElement(By.
		 * xpath("//*[text()='Global Lock']/../../../../../../table[2]/tbody[1]/tr[1]/td[1]/div"
		 * )).getText(); System.out.println(globalLockState);
		 * 
		 * }
		 * 
		 * 
		 * String globalId=driver.findElement(By.
		 * cssSelector("tr > td.mx-name-column2.mx-right-aligned > div")).getText();
		 * System.out.println(globalId); /*ExcelUtil.excelWriteGlobalId(globalId);
		 */
		// Button.click("Select EDit button", EditGlobalData);
		// Button.click("Click EDit button", btnEdit);
		/*
		 * Button.click("Click on OK", btnOK1); Sync.waitForSeconds(Constants.WAIT_1);
		 * Button.click("Click on OK", btnOK); Sync.waitForSeconds(Constants.WAIT_1);
		 */

	}

	/*****************************************************************************/
	public void EditVendorData() {
		Button.click("Select EDit button", EditGlobalData);
		Sync.waitForSeconds(Constants.WAIT_2);
		Button.click("Click EDit button", btnEdit);
		Sync.waitForSeconds(Constants.WAIT_5);
		
	}
	public void EditVendorgloballovalsapData() {
		Button.click("Select EDit button", EditGlobalData);
		Sync.waitForSeconds(Constants.WAIT_2);
		Button.click("Select EDit button", EditbankData);
		Sync.waitForSeconds(Constants.WAIT_2);
		Button.click("Select EDit button", EditlocalData);
		Sync.waitForSeconds(Constants.WAIT_2);

		Button.click("Click EDit button", btnEdit);
		Sync.waitForSeconds(Constants.WAIT_5);
		
	}
	public void EditVendorgloballovajdeData() {
		Button.click("Select EDit button", EditGlobalData);
		Sync.waitForSeconds(Constants.WAIT_2);
				Button.click("Select EDit button", EditlocalData);
		Sync.waitForSeconds(Constants.WAIT_2);

		Button.click("Click EDit button", btnEdit);
		Sync.waitForSeconds(Constants.WAIT_5);
		
	}

	public void EditVendorDataGlobalLocal() 
	{
		Button.click("Select EDit button", EditGlobalData);
		Button.click("Select EDit button", EditLocalData);
		
		Button.click("Click EDit button", btnEdit);
		Sync.waitForSeconds(Constants.WAIT_3);
	
	}
  
	public boolean disableLocaData() {
		Sync.waitForSeconds(Constants.WAIT_10);
		Sync.waitUntilObjectDisappears(driver, "Waiting of Create page to Load",
				By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForObject(driver, textLocalData);
		Button.click("Local Data", textLocalData);
		Button.click("Local Actions button", btnLocalActions);
		Button.click("Disable Local Request", btnDisableLocalRequest);
		return Button.click("Proceed", btnProceed);
	}


	public boolean disableBankData() {
		Sync.waitForSeconds(Constants.WAIT_10);
		Sync.waitUntilObjectDisappears(driver, "Waiting of Create page to Load",
				By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForObject(driver, textBankData);
		Button.click("Local Data", textBankData);
		// Button.click("Local Actions button", btnLocalActions);
		Sync.waitForSeconds(Constants.WAIT_1);
		Button.click("Disable Bank Request", btnDisableBankRequest);
		return Button.click("Proceed", btnProceed);
	}

	/*****************************************************************************/

	public void VendorName(String strValue) {
		Sync.waitForSeconds(Constants.WAIT_3);
		Sync.waitForObject(driver, textName);
		Textbox.enterValue("Name to create vendor", textName, strValue);
		Sync.waitForSeconds(Constants.WAIT_1);
		Textbox.click("clicking name1", textSearchterm1);
	}
	public void VendorNamechange(String strValue) {
		Sync.waitForSeconds(Constants.WAIT_3);
		Sync.waitForObject(driver, textName);
		textName.clear();
		Textbox.enterValue("Name to create vendor", textName, strValue);
		Sync.waitForSeconds(Constants.WAIT_1);
		//Textbox.click("clicking name1", textSearchterm1);
	}
	public void clickEditCheckBox() {
		WebDriverWait wait = new WebDriverWait(driver,80);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Edit Global Data']/../div/input")));		
		//Sync.waitUntilObjectDisappears(driver, "Wait for Materials", By.xpath((".//*[@id='mxui_widget_Progress_0']/div[2]")));
		Sync.waitForObject(driver, "Wait until the Material appears", checkBoxEdit);
		Button.jsclick("Click Edit Global Global Data Checkbox", checkBoxEdit,driver);
		System.out.println("Clicked on Golbal Edit Check box");
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_5);
	}	
	
	public void clickEditbutton() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Edit']")));	
		//Sync.waitUntilObjectDisappears(driver, "Wait for Materials", By.xpath((".//*[@id='mxui_widget_Progress_0']/div[2]")));
		Sync.waitForObject(driver, "Wait until the Material appears", btnEdit);
		Button.jsclick("Click Edit Button", btnEdit, driver);
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_5);
	}

	/********************
	 * Address section
	 *********************************************************/

	public void AddressStreet(String strValue) {
		Sync.waitForSeconds(Constants.WAIT_1);
		Sync.waitForObject(driver, textStreet);
		Textbox.enterValue("Enter Street", textStreet, strValue);
	}

	public void AddresHouseNumber(String strValue) {
		Sync.waitForSeconds(Constants.WAIT_1);
		Sync.waitForObject(driver, textHouseNumber);
		Textbox.enterValue("Enter Street", textHouseNumber, strValue);
	}

	public void AddresPostalCode(String strValue) {
		// Sync.waitForSeconds(Constants.WAIT_1);
		Sync.waitForObject(driver, textPostalCode);
		Textbox.enterValue("Enter Street", textPostalCode, strValue);
	}

	public void AddresPostalCodepo(String strValue) {
		// Sync.waitForSeconds(Constants.WAIT_1);
		Sync.waitForObject(driver, textPostalCodepo);
		Textbox.enterValue("Enter Street", textPostalCodepo, strValue);
	}
	public void AddresPostalCodepobox(String strValue) {
		// Sync.waitForSeconds(Constants.WAIT_1);
		Sync.waitForObject(driver, textPostalCodepobox);
		Textbox.enterValue("Enter Street", textPostalCodepobox, strValue);
	}



	public void AddresCity(String strValue) {
		// Sync.waitForSeconds(Constants.WAIT_1);
		Textbox.enterValue("Enter Street", textCity, strValue);
	}

	public void AddresCountry(String strValue) {
		// Sync.waitForSeconds(Constants.WAIT_1);
		Select Country = new Select(textCountry);
		// Country.selectByVisibleText(strValue);
		// Sync.waitForSeconds(Constants.WAIT_1);
		/*
		 * List <WebElement> elementCount = Country.getOptions(); int iSize =
		 * elementCount.size(); // System.out.println(iSize); for(int i =0; i<iSize ;
		 * i++) { String sValue = elementCount.get(i).getText();
		 * if(sValue.equals(strValue)) { Country.selectByIndex(i);
		 * System.out.println(i); break; } }
		 */
		Country.selectByVisibleText(strValue);
	}

	public void AddresRegion(String strValue) {
		Sync.waitForSeconds(Constants.WAIT_1);
		Select region = new Select(textRegion);
		Sync.waitForSeconds(Constants.WAIT_1);
		region.selectByVisibleText(strValue);
	}

	public void AddresLanguageKey(String strValue) {
		Sync.waitForSeconds(Constants.WAIT_1);
		Select LanguageKey = new Select(textLanguageKey);
		// LanguageKey.selectByVisibleText(strValue);
		Sync.waitForSeconds(Constants.WAIT_1);
		LanguageKey.selectByVisibleText(strValue);
		/*
		 * List <WebElement> elementCount = LanguageKey.getOptions(); int iSize =
		 * elementCount.size(); // System.out.println(iSize); for(int i =0; i<iSize ;
		 * i++) { String sValue = elementCount.get(i).getText();
		 * if(sValue.equals(strValue)) { LanguageKey.selectByIndex(i); break; } }
		 */
	}

	public void AddressCreditInformationNumber(String strValue) {
		Sync.waitForSeconds(Constants.WAIT_1);
		Textbox.enterValue("Enter Credit No", textCreditInformationNumber, strValue);
	}

	public void AddresIndustryKey(String strValue) {
		Sync.waitForSeconds(Constants.WAIT_1);
		Select IndustryKey = new Select(textIndustryKey);
		// IndustryKey.selectByVisibleText(strValue);
		Sync.waitForSeconds(Constants.WAIT_1);
		List<WebElement> elementCount = IndustryKey.getOptions();
		int iSize = elementCount.size();
		System.out.println(iSize);
		for (int i = 0; i < iSize; i++) {
			String sValue = elementCount.get(i).getText();
			if (sValue.equals(strValue)) {
				IndustryKey.selectByIndex(i);
				break;
			}
		}
	}

	public void AddresCorporateGroup(String strValue) {
		Sync.waitForSeconds(Constants.WAIT_1);
		Select CorporateGroup = new Select(textCorporateGroup);
		// CorporateGroup.selectByVisibleText(strValue);
		Sync.waitForSeconds(Constants.WAIT_1);
		List<WebElement> elementCount = CorporateGroup.getOptions();
		int iSize = elementCount.size();
		System.out.println(iSize);
		for (int i = 0; i < iSize; i++) {
			String sValue = elementCount.get(i).getText();
			if (sValue.equals(strValue)) {
				CorporateGroup.selectByIndex(i);
				break;
			}
		}
	}

	public void ScrollDown() throws InterruptedException, AWTException {
		Robot robot = new Robot(); // Robot class throws AWT Exception
		Thread.sleep(2000); // Thread.sleep throws InterruptedException
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
	}

	public void Localactionbutton() {
		Sync.waitForSeconds(Constants.WAIT_10);
		Sync.waitForObject(driver, btnLocalActions);
		if(Button.verifyObject(btnLocalActions)) {
			Sync.waitForSeconds(Constants.WAIT_2);
			Button.click("Local Actions button", btnLocalActions);
			Sync.waitForSeconds(Constants.WAIT_2);
		}
		else {
			Sync.waitForSeconds(Constants.WAIT_2);
			Button.click("Local Actions button", btnLocalActions);
			Sync.waitForSeconds(Constants.WAIT_2);
		}
		
	}

	/********************
	 * END
	 *********************************************************/

	public boolean validateTestCreate() {
		
		Sync.waitForSeconds(Constants.WAIT_3);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		Sync.waitForSeconds(Constants.WAIT_1);
		wait.until(ExpectedConditions.elementToBeClickable(btnValidate));
		return Button.click("Click Validate button on local action ", btnValidate);
	}
	public boolean validateTestCreatesap() {
		Sync.waitForSeconds(Constants.WAIT_3);
		Button.click("Local Actions button", btnLocalActions);
		Sync.waitForSeconds(Constants.WAIT_3);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		Sync.waitForSeconds(Constants.WAIT_1);
		wait.until(ExpectedConditions.elementToBeClickable(btnValidate));
		return Button.click("Click Validate button on local action ", btnValidate);
	}
	/****************************************************************************************************/
	public boolean BtnLocalActions() {
		Sync.waitForSeconds(Constants.WAIT_1);
		return Button.click("Local Actions button", btnLocalActions);
	}

	/****************************************************************************************************/
	public void submitGlobalRequestTest() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Sync.waitForSeconds(Constants.WAIT_2);
		Sync.waitForObject(driver, "Verify Validate message", txtValidationMsg);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		//wait.until(ExpectedConditions.elementToBeClickable(btnLocalActions));
		//Button.click("Local Actions button", btnLocalActions);
		//Sync.waitForSeconds(Constants.WAIT_2);
		//Button.click("Local Actions button", btnLocalActions);
		Sync.waitForSec(Constants.WAIT_1);
		wait.until(ExpectedConditions.elementToBeClickable(btnGlobalRequest));
		Button.jsclick("Click Global submit Global Request", btnGlobalRequest, driver);
		Sync.waitForSec(Constants.WAIT_2);
		Thread.sleep(8000);
	}

	/****************************************************************************************************/
	public void SaveAsDraft() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Sync.waitForSeconds(Constants.WAIT_2);
		Sync.waitForObject(driver, "Verify Validate message", txtValidationMsg);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(btnLocalActions));
		Button.click("Local Actions button", btnLocalActions);
		if(driver.findElements(By.xpath(".//button[text()='Save As Draft']")).size()>0)
		{
		Sync.waitForSec(Constants.WAIT_2);
		//Button.click("Local Actions button", btnLocalActions);
		Sync.waitForSec(Constants.WAIT_5);
		wait.until(ExpectedConditions.elementToBeClickable(btnSaveAsDraft));
		Button.jsclick("Click Save as Draft button", btnSaveAsDraft, driver);
		Sync.waitForSeconds(Constants.WAIT_2);
		Thread.sleep(8000);
		}
		else
		{
			Sync.waitForSec(Constants.WAIT_2);
			Button.click("Local Actions button", btnLocalActions);
			Sync.waitForSec(Constants.WAIT_5);
			wait.until(ExpectedConditions.elementToBeClickable(btnSaveAsDraft));
			Button.jsclick("Click Save as Draft button", btnSaveAsDraft, driver);
			Sync.waitForSeconds(Constants.WAIT_2);
			Thread.sleep(8000);

		}
	}

	/****************************************************************************************************/
	public String getRequestId(String suiteName) throws InterruptedException, FileNotFoundException, IOException {

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Sync.waitForObject(driver, "Wait of Dialog Box Success Message", msgRequestSuccess);
		Sync.waitForSeconds(Constants.WAIT_3);

		WebDriverWait wait = new WebDriverWait(driver, 80);
		// WebElement text =
		// driver.findElement(By.xpath(".//*[@id='mxui_widget_DialogMessage_0']/div[1]/div[2]/p"));
		// wait.until(ExpectedConditions.elementToBeSelected(text));
		String reqId = driver.findElement(By.xpath(".//*[@id='mxui_widget_DialogMessage_0']/div[1]/div[2]/p"))
				.getText();
		String[] parts = reqId.split(" ");
		String Id = parts[2];
		System.out.println("RequestId is: " + Id);
		// ExcelUtil.excelWrite(Id);
		ExcelUtil.setCellData_New("TestPlan", "RequestId", Id, suiteName);
		System.out.println("Excel write is done");
		wait.until(ExpectedConditions.elementToBeClickable(btnOK));
		Sync.waitForSeconds(Constants.WAIT_2);
		Sync.waitForElementToBeClickable(driver, btnOK);

		Button.click("Click Ok Button", btnOK);
		return Id;
	}
	public String getRequestId_Extend(String suiteName) throws InterruptedException, FileNotFoundException, IOException {

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Sync.waitForObject(driver, "Wait of Dialog Box Success Message", msgRequestSuccess);
		Sync.waitForSeconds(Constants.WAIT_3);

		WebDriverWait wait = new WebDriverWait(driver, 80);
		// WebElement text =
		// driver.findElement(By.xpath(".//*[@id='mxui_widget_DialogMessage_0']/div[1]/div[2]/p"));
		// wait.until(ExpectedConditions.elementToBeSelected(text));
		String reqId = driver.findElement(By.xpath(".//*[text()='Information']/../../div[2]/p"))
				.getText();
		String[] parts = reqId.split(" ");
		String Id = parts[2];
		System.out.println("RequestId is: " + Id);
		// ExcelUtil.excelWrite(Id);
		ExcelUtil.setCellData_New("TestPlan", "RequestId", Id, suiteName);
		System.out.println("Excel write is done");
		wait.until(ExpectedConditions.elementToBeClickable(btnOK));
		Sync.waitForSeconds(Constants.WAIT_2);
		Sync.waitForElementToBeClickable(driver, btnOK);

		Button.click("Click Ok Button", btnOK);
		return Id;
	}

		/****************************************************************************************************/
	public void submitRequestPopup() {

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Sync.waitForObject(driver, "Wait of Dialog Box Success Message", msgRequestSuccess);
		Sync.waitForSeconds(Constants.WAIT_3);

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(btnOK));
		Sync.waitForSeconds(Constants.WAIT_2);
		Sync.waitForElementToBeClickable(driver, btnOK);

		Button.click("Click Ok Button", btnOK);
	}

	/****************************************************************************************************/
	public String getRequestId_Vendor(String suiteName) throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("Waiting For Excel write to be done");
	   	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Sync.waitForObject(driver, "Wait of Dialog Box Success Message", msgRequestSuccess);
		Sync.waitForSeconds(Constants.WAIT_10);

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mxui_widget_DialogMessage_0']/div[1]/div[2]/p")));
		// WebElement text =
		// driver.findElement(By.xpath(".//*[@id='mxui_widget_DialogMessage_0']/div[1]/div[2]/p"));
		// wait.until(ExpectedConditions.elementToBeSelected(text));
		String reqId = driver.findElement(By.xpath(".//*[@id='mxui_widget_DialogMessage_0']/div[1]/div[2]/p"))
				.getText();
		String[] parts = reqId.split(" ");
		String Id = parts[2];
		System.out.println("RequestId is: " + Id);
		// ExcelUtil.excelWrite(Id);
		ExcelUtil.setCellData_New("TestPlan", "RequestId", Id, suiteName);
		System.out.println("Excel write is done");
		wait.until(ExpectedConditions.elementToBeClickable(btnOK));
		Sync.waitForSeconds(Constants.WAIT_2);
		Sync.waitForElementToBeClickable(driver, btnOK);

		Button.click("Click Ok Button", btnOK);
		return Id;
	}

	/****************************************************************************************************/

	public String getRequestId_Draft(String suiteName) throws InterruptedException, FileNotFoundException, IOException {

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Sync.waitForObject(driver, "Wait of Dialog Box Success Message", msgRequestSuccess);
		Sync.waitForSeconds(Constants.WAIT_3);

		WebDriverWait wait = new WebDriverWait(driver, 60);
		// WebElement text =
		// driver.findElement(By.xpath(".//*[@id='mxui_widget_DialogMessage_0']/div[1]/div[2]/p"));
		// wait.until(ExpectedConditions.elementToBeSelected(text));
		String reqId = driver.findElement(By.xpath(".//*[@id='mxui_widget_DialogMessage_0']/div[1]/div[2]/p"))
				.getText();
		String[] parts = reqId.split(" ");
		String Id = parts[parts.length-1];
		String Idnum = Id.replaceAll("\\.", "");
		System.out.println("RequestId is: " + Idnum);

		ExcelUtil.setCellData_New("TestPlan", "RequestId", Idnum, suiteName);
		System.out.println("Excel write is done");
		wait.until(ExpectedConditions.elementToBeClickable(btnOK));
		Sync.waitForSeconds(Constants.WAIT_2);
		Sync.waitForElementToBeClickable(driver, btnOK);

		Button.click("Click Ok Button", btnOK);
		return Id;
	}

	/****************************************************************************************************/
	@Test(dataProvider = "Process_Information_Check", dataProviderClass = staticProviderClass.class)
	public void Vendor_Create_Review_Global_Data_Approve_GDA(Map<String, String> dataMap)
			throws InterruptedException, FileNotFoundException, IOException {
		Assert.assertTrue(SharedDriver.pageContainer.homePage.navigateToWorkflow());
		SharedDriver.pageContainer.materialPage.switchToPopup();
		SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
		SharedDriver.pageContainer.materialApprovalPage.approvalBtnClick();
	}

	/****************************************************************************************************/
	public boolean navigateToDashboard() {

		Sync.waitForObject(driver, "Wait until the vendor appears", textVendor);
		Button.jsclick("Click Vendor Menu", textVendor, driver);
		return Button.click("Click Dashboard Menu", menuMaterialDashboard);
	}
	
	
	public boolean navigateToDashboardSearch_SAP() {

		Button.jsclick("Click Vendor Menu", textVendor, driver);
		return Button.click("Click Dashboard Menu", menuMaterialDashboard);
	}

	/****************************************************************************************************/
	public void advancedSearch() throws InterruptedException {

		TimeUnit.SECONDS.sleep(8);
		driver.switchTo().window("Application");
		TimeUnit.SECONDS.sleep(7);
		Button.click("Click Advanced Search", btnAdvancedSearch);
		TimeUnit.SECONDS.sleep(3);
	}

	/****************************************************************************************************/
	public void scrolltoGlobalSearch() {
		Sync.waitForSeconds("5");
		JavascriptExecutor js;
		js = (JavascriptExecutor) driver;
		js.executeScript(
				"$(\".mx-layoutcontainer-wrapper.mx-scrollcontainer-wrapper\").animate({ scrollBottom: \"100px\" })");
	}

	/****************************************************************************************************/
	public void reqIdSearchGlobal(String strValue) throws InterruptedException {
		Sync.waitForSeconds(Constants.WAIT_2);
		WebElement elementSearch = driver.findElement(By.xpath("//*[text()='Request ID']/../../td[4]/div/input"));
		Sync.waitForObject(driver, txtboxReqIdEnter);

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		// get current date time with Date()
		Date date = new Date();

		// Now format the date
		String dateFormatted = dateFormat.format(date);
		Textbox.clear("Clear TextBox Value", txtboxReqIdEnter);
		Textbox.enterValue("Enter TextBox Value", txtboxReqIdEnter, strValue);
		Textbox.enterValue("Enter TextBox Value", txtboxCreateOnEnter, dateFormatted);
		Button.click("Click Search button", btnReqIdEnter);
		Sync.waitForSeconds(Constants.WAIT_2);
	}
		/****************************************************************************************************/
	public String getGlobalId(String suiteName) throws FileNotFoundException, IOException {
		Sync.waitForSeconds(Constants.WAIT_3);
		Sync.waitForObject(driver, "Wait for Global Vendor Id", driver
				.findElement(By.xpath("//*[text()='Global Vendor ID']/../../../../../../table[2]/tbody/tr/td[4]/div")));
		String globalId = driver
				.findElement(By.xpath("//*[text()='Global Vendor ID']/../../../../../../table[2]/tbody/tr/td[4]/div"))
				.getText();
		System.out.println(globalId);
		// ExcelUtil.excelWriteGlobalId(globalId);
		ExcelUtil.setCellData_New_GlobalId("TestPlan", "Global_ID", globalId, suiteName);
		return globalId;
	}

	/****************************************************************************************************/

	public void RejectGDA() throws InterruptedException, AWTException {

		Thread.sleep(3000);
		System.out.println("Scrolling");
		Robot robot = new Robot(); // Robot class throws AWT Exception
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

		driver.findElement(By.xpath("(.//*[@class='btn mx-button mx-name-newButton2 btn-default'])[1]")).click();

		System.out.println("clicked new button");
		Thread.sleep(2000);

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
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".glyphicon.glyphicon-flash")));
		}

		Button.jsclick("Click Local Action Flash Button",
				driver.findElement(By.cssSelector(".glyphicon.glyphicon-flash")), driver);
	}

	public void DiscardCreateLDR() throws InterruptedException {

		Thread.sleep(6000);
		Button.click("Local Actions button click", btnLocalActions);
		Thread.sleep(2000);
		Sync.waitForObject(driver, btnDiscardCreate);
		Button.jsclick("Click on Discard button in locl action", btnDiscardCreate, driver);
		Thread.sleep(4000);
		//Sync.waitForObject(driver, btnOK);
		//Button.click("Click On OK button", btnOK);
		Thread.sleep(2000);
	}

	public void gobalIDSearchGlobal(String strValue) throws InterruptedException {
		Sync.waitForSeconds(Constants.WAIT_2);
		// WebElement elementSearch=driver.findElement(By.xpath("//*[text()='Request
		// ID']/../../td[4]/div/input"));
		Sync.waitForObject(driver, txtboxReqIdEnter);

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		// get current date time with Date()
		Date date = new Date();

		// Now format the date
		String dateFormatted = dateFormat.format(date);
		Textbox.clear("Clear TextBox Value", txtBoxGlobalId);
		Textbox.enterValue("Enter TextBox Value", txtBoxGlobalId, strValue);
		Textbox.enterValue("Enter TextBox Value", txtboxCreateOnEnter, dateFormatted);
		Button.click("Click Search button", btnReqIdEnter);
		Sync.waitForSeconds(Constants.WAIT_2);
	}

	public boolean clickExtendButton() throws InterruptedException {

		if (Button.verifyObject(btnExtend)) {
			//Sync.waitForObject(driver, "Extend", btnExtend);
			Sync.waitForSeconds(Constants.WAIT_1);
			return Button.click("Extend", btnExtend);
		} else {
			return Button.click("Extend", btnExtend);
		}
	}

	public boolean clickGlobalDataButton() throws InterruptedException {
		boolean isButtonClicked = false;

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

	public void clickLocalAction_Local() {
		Sync.waitForSeconds(Constants.WAIT_6);
		/*
		 * WebElement waitElement = null; FluentWait<WebDriver> fwait = new
		 * FluentWait<WebDriver>(driver) .withTimeout(Duration.ofMinutes(3))
		 * .pollingEvery(Duration.ofSeconds(600))
		 * .ignoring(NoSuchElementException.class) .ignoring(TimeoutException.class);
		 * 
		 * //First checking to see if the loading indicator is found // we catch and
		 * throw no exception here in case they aren't ignored try { waitElement =
		 * fwait.until(new Function<WebDriver, WebElement>() { public WebElement
		 * apply(WebDriver driver) { return
		 * driver.findElement(By.xpath(".//*[@id='mxui_widget_Progress_0']")); } }); }
		 * catch (Exception e) { }
		 */

		// checking if loading indicator was found and if so we wait for it to
		// disappear
		/*
		 * if (waitElement != null) { WebDriverWait wait = new WebDriverWait(driver,
		 * 120); wait.until(ExpectedConditions.visibilityOfElementLocated(
		 * By.cssSelector(".glyphicon.glyphicon-flash")) ); }
		 */
		Sync.waitForObject(driver, By.cssSelector(".glyphicon.glyphicon-flash"));
		Button.jsclick("Click Local Action Flash Button",
				driver.findElement(By.cssSelector(".glyphicon.glyphicon-flash")), driver);
	}

	public void clickLocalAction_Bank() {
		Sync.waitForSeconds(Constants.WAIT_6);
		/*
		 * WebElement waitElement = null; FluentWait<WebDriver> fwait = new
		 * FluentWait<WebDriver>(driver) .withTimeout(Duration.ofMinutes(3))
		 * .pollingEvery(Duration.ofSeconds(600))
		 * .ignoring(NoSuchElementException.class) .ignoring(TimeoutException.class);
		 * 
		 * //First checking to see if the loading indicator is found // we catch and
		 * throw no exception here in case they aren't ignored try { waitElement =
		 * fwait.until(new Function<WebDriver, WebElement>() { public WebElement
		 * apply(WebDriver driver) { return
		 * driver.findElement(By.xpath(".//*[@id='mxui_widget_Progress_0']")); } }); }
		 * catch (Exception e) { }
		 * 
		 * //checking if loading indicator was found and if so we wait for it to
		 * //disappear if (waitElement != null) { WebDriverWait wait = new
		 * WebDriverWait(driver, 120);
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(
		 * By.cssSelector(".glyphicon.glyphicon-flash")) ); }
		 */
		
		Button.jsclick("Click Local Action Flash Button",
				driver.findElement(By.cssSelector(".glyphicon.glyphicon-flash")), driver);
	}

	public boolean discardLocalButtonClick() throws InterruptedException {

		Sync.waitForSeconds(Constants.WAIT_2);
		if (Button.verifyObject(btnCreate)) {
			Sync.waitForObject(driver, "Create Button Click", btnCreate);
			Sync.waitForSeconds(Constants.WAIT_1);
			return Button.click("Create Button Click", btnLocalDiscard);
		} else {
			return Button.click("Create Button Click", btnLocalDiscard);
		}

	}

	public void submitBankRequestTest() throws InterruptedException {

		/*
		 * driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		 * Sync.waitForSeconds(Constants.WAIT_2); Sync.waitForObject(driver,
		 * "Verify Validate message", txtValidationMsg);
		 */
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(btnLocalActions));
		/*
		 * Button.click("Local Actions button", btnLocalActions);
		 * Sync.waitForSeconds(Constants.WAIT_2);
		 */
		Button.click("Local Actions button", btnLocalActions);
		Sync.waitForSeconds(Constants.WAIT_1);
		wait.until(ExpectedConditions.elementToBeClickable(btnBankRequest));
		Button.click("Click Global submit Global Request", btnBankRequest);
		Sync.waitForSeconds(Constants.WAIT_2);
		Thread.sleep(8000);
	}
		
	public void submitBankRequestTest1() throws InterruptedException {

		/*
		 * driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		 * Sync.waitForSeconds(Constants.WAIT_2); Sync.waitForObject(driver,
		 * "Verify Validate message", txtValidationMsg);
		 */
		Sync.waitForSeconds(Constants.WAIT_10);
		Button.click("Click Global submit Global Request", btnBankRequest);
		Sync.waitForSeconds(Constants.WAIT_2);
		Thread.sleep(8000);
	}
	public boolean clickToConfirm() throws InterruptedException {

		if (Button.verifyObject(btnToConfirm)) {
			Sync.waitForObject(driver, "Click Button To Confirm", btnToConfirm);
			Sync.waitForSeconds(Constants.WAIT_5);
			return Button.click("Click Button To Confirm", btnToConfirm);
		} else {
			return Button.click("Click Button To Confirm", btnToConfirm);
		}
	}

	public boolean clickConfirmExtension() throws InterruptedException {

		if (Button.verifyObject(btnConfirmExtension)) {
			//Sync.waitForObject(driver, "Click Button To Confirm", btnConfirmExtension);
			Sync.waitForSeconds(Constants.WAIT_5);
			return Button.click("Click Button To Confirm", btnConfirmExtension);
		} else {
			return Button.click("Click Button To Confirm", btnConfirmExtension);
		}
	}

	public boolean clickflagDeletion() throws InterruptedException {

		if (Button.verifyObject(btnflagForDeletion)) {
			Sync.waitForObject(driver, "Click Button To Delete", btnflagForDeletion);
			Sync.waitForSeconds(Constants.WAIT_5);
			return Button.click("Click Button To Delete", btnflagForDeletion);
		} else {
			return Button.click("Click Button To Delete", btnflagForDeletion);
		}
		
	
	}

	public boolean clickOk() throws InterruptedException {

		if (Button.verifyObject(btnok)) {
			Sync.waitForObject(driver, "Click Button To ok", btnok);
			Sync.waitForSeconds(Constants.WAIT_5);
			return Button.click("Click Button To ok", btnok);
		} else {
			return Button.click("Click Button To ok", btnok);
		}
	}

	public void duplicateCheck() {
		try {

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
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[text()='Open Record']")));
			}

			driver.manage().window().setPosition(new Point(-2000, 0));
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
			Sync.waitForSeconds(Constants.WAIT_3);
			Button.click("Click Ok Button", btnMsgReqIdOk);

		} catch (Exception e) {
			System.err.println(e.getMessage());

		}
	}

	/*
	 * public boolean clickOkToHandlePopup() {
	 * Sync.waitForSeconds(Constants.WAIT_5); WebElement popUp =
	 * driver.findElement(By.xpath("//*[@class='close mx-dialog-close']")); return
	 * Button.jsclick("Click on Popup", popUp, driver);
	 * //Sync.waitForSeconds(Constants.WAIT_1); //
	 * Button.jsclick("Click ok on info Popup", btnOkay, driver); }
	 */

	public void globalSearch(String strValue) throws InterruptedException {
		// Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_3);
		Button.click("Click Search button", btnReqIdEnter);

		// Sync.waitForObject(driver, txtboxReqIdEnter);

		// Button.click("Click Search button", btnReqIdEnter);
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_5);
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[text()='Global ID']/../../td[4]/div/input")));
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_5);
		// Sync.waitForSeconds(Constants.WAIT_5);

		// Sync.waitForObject(driver, txtboxGlobalIdEnter);
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_5);

		Textbox.clear("Clear TextBox Value", txtBoxGlobalId);
		Textbox.enterValue("Enter TextBox Value", txtBoxGlobalId, strValue);
		Sync.waitForSeconds(Constants.WAIT_5);
		Button.click("Click Search button", btnReqIdEnter);
		Sync.waitForSeconds(Constants.WAIT_5);
	}

	public String getGlobalIdNew() throws FileNotFoundException, IOException {
		Sync.waitForSeconds(Constants.WAIT_10);
		FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMinutes(3))
				.pollingEvery(Duration.ofSeconds(600)).ignoring(NoSuchElementException.class)
				.ignoring(TimeoutException.class);

		String globalLockState = driver
				.findElement(
						By.xpath("//*[text()='Global Locked']/../../../../../../table[2]/tbody[1]/tr[1]/td[1]/div"))
				.getText();
		System.out.println(globalLockState);
		if (globalLockState.equalsIgnoreCase("NO")) {
			Button.click("Select EDit button", EditGlobalData);
			Button.click("Click EDit button", btnEdit);

		}

		else if (globalLockState.equalsIgnoreCase("Yes")) {

			// String globalLockStateNew=driver.findElement(By.xpath("//*[text()='Global
			// Lock']/../../../../../../table[2]/tbody[1]/tr[1]/td[1]/div")).getText();
			System.out.println(globalLockState);

		}

		String globalId = driver.findElement(By.cssSelector("tr > td.mx-name-column2.mx-right-aligned > div"))
				.getText();
		System.out.println(globalId);
		/* ExcelUtil.excelWriteGlobalId(globalId); */
		return globalId;
	}

	public void checkGlobalIdYes() throws FileNotFoundException, IOException {
		Sync.waitForSeconds(Constants.WAIT_10);
		Sync.waitForSeconds(Constants.WAIT_10);
		
		FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMinutes(3))
				.pollingEvery(Duration.ofSeconds(600)).ignoring(NoSuchElementException.class)
				.ignoring(TimeoutException.class);

		String globalLockState = driver
				.findElement(By.xpath("//*[text()='Global Locked']/../../../../../../table[2]/tbody[1]/tr[1]/td[1]/div")).getText();
		System.out.println("Global Lock State is "+globalLockState);
		if (globalLockState.equalsIgnoreCase("No")) {			
			clickEditCheckBox();
		     clickEditbutton();
		     clickOkOnInformationButton();
		     clickOkOnInformationButton();
		     
		}
		else if(globalLockState.equalsIgnoreCase("Yes")) {
			System.out.println("Global Lock State is "+globalLockState);
		}

	}

	public boolean clickOkToHandlePopup() {
		Sync.waitForSeconds(Constants.WAIT_5);
		WebElement popUp = driver.findElement(By.xpath("//*[@class='close mx-dialog-close']"));
		return Button.jsclick("Click on Popup", popUp, driver);
		// Sync.waitForSeconds(Constants.WAIT_1);
		// Button.jsclick("Click ok on info Popup", btnOkay, driver);
	}

	public void duplicateCheck_Submit() {
		try {
			// Sync.waitUntilObjectDisappears(driver, "Wait for Duplicate check",
			// By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));

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
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[text()='Open Record']")));
			}

			driver.manage().window().setPosition(new Point(-2000, 0));
			driver.findElement(By.xpath(".//*[text()='Open Record']")).sendKeys(Keys.TAB);
			driver.findElement(By.xpath(".//*[text()='Extend Selected']")).sendKeys(Keys.TAB);
			driver.findElement(By.xpath("//*[text()='Export to Excel']")).sendKeys(Keys.TAB);
			driver.findElement(By.xpath("//*[text()='My record is not a duplicate! Submit.']")).sendKeys(Keys.RETURN);
			driver.findElement(By.xpath("//*[text()='Proceed']")).click();
			Sync.waitForSeconds(Constants.WAIT_3);

			driver.manage().window().maximize();
			Actions actions = new Actions(driver);
			actions.moveToElement(btnMsgReqIdOk);
			actions.perform();

			Button.click("Click Ok Button", btnMsgReqIdOk);

			/*
			 * try { if(btnMsgReqIdOkdraft.isEnabled()) { Button.click("Click Ok Button",
			 * btnMsgReqIdOkdraft); System.out.println("Button is Clicked"); }
			 * 
			 * } catch(Exception e) { System.err.println(e.getMessage());
			 * 
			 * 
			 * }
			 */

		} catch (Exception e) {
			System.err.println(e.getMessage());

		}
	}

	public void rejectLBDAVendor() throws InterruptedException, AWTException {

		System.out.println("Scrolling action");

		Sync.waitForSeconds(Constants.WAIT_6);
		System.out.println("Scrolling");
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_5);
		// String test =
		// driver.findElement(By.xpath(".//*[@id='mxui_widget_TextInput_3']/p")).getText();
		// driver.findElement(By.xpath(".//*[@id='mxui_widget_TextInput_3']/p")).click();
		// System.out.println(test);

		Sync.waitForSeconds(Constants.WAIT_5);
		Robot robot = new Robot(); // Robot class throws AWT Exception
		Thread.sleep(4000); // Thread.sleep throws InterruptedException
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
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

		Sync.waitForObject(driver, btnCommentNewLBDA);
		Sync.waitForSeconds(Constants.WAIT_5);
		System.out.println("checking for new button");
		Sync.waitForSeconds(Constants.WAIT_5);
		// String
		// text1=driver.findElement(By.xpath(".//*[@id='mxui_widget_NumberInput_3']/p")).getText();
		// System.out.println(text1);
		// String text2=driver.findElement(By.xpath("(.//*[@class='btn mx-button
		// mx-name-newButton2 btn-default'])[1]")).getText();
		// System.out.println(text2);
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_5);

		Button.jsclick("Add new comments to Reject", driver.findElement(By.xpath(".//*[text()='Comments']/../div/div[2]/div[2]/button[1]")), driver);

		System.out.println("clicked new button");
		Sync.waitForSeconds(Constants.WAIT_5);
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"(.//*[text()='Edit Comments']/../../div[2]/div/div/div/div/div/div[1]/div/div/div/div/div/textarea)")));

		Textbox.enterValue("typing comment", textAreaComment, "Data Rejection");
		Textbox.click("Click on Save Button", btnSave);

		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_5);

		Button.click("Local Actions button click", btnLocalActions);

		Sync.waitForObject(driver, btnRejectGlobalRequest);
		Textbox.click("Click on reject button in locl action", btnRejectGlobalRequest);
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForObject(driver, btnOK);
		Button.click("Click On OK button", btnOK);
		Sync.waitForSeconds(Constants.WAIT_5);
	}
 
    public void clickOkOnInformationButton() {
		if(driver.findElements(By.xpath("//*[@class='close mx-dialog-close']")).size()>0) {
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.jsclick("Click on Popup", driver.findElement(By.xpath("//*[@class='close mx-dialog-close']")), driver);
			//Button.jsclick("Click ok on info Popup", btnOkay, driver);
			
			}
		else{
			WebDriverWait wait = new WebDriverWait(driver,50);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Extend']")));
			
		}
	}
    
    public void selectVendorFinancePlant() 
	{
	
		Sync.waitForObject(driver, selectVendorFinancePlant);
		Button.click("Select the plant",selectVendorFinancePlant);
	}

	public void GetFullVendorDataNew() throws InterruptedException {
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitUntilObjectDisappears(driver, "Waiting of Create page to Load",
				By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForObject(driver, GetFullVendorData);
		Button.click("GetFullVendorData", GetFullVendorData);
		
		Sync.waitForSeconds(Constants.WAIT_10);
		Sync.waitForSeconds(Constants.WAIT_10);
	}

	/*************************************************************************************************************/
	public void clickResubmitGlobalRequest() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(btnLocalActions));
		Button.click("Local Actions button", btnLocalActions);
		Sync.waitForSeconds(Constants.WAIT_2);
		// Button.click("Local Actions button", btnLocalActions);
		Sync.waitForSeconds(Constants.WAIT_1);
		wait.until(ExpectedConditions.elementToBeClickable(btnGlobalRequest));
		Button.click("Click Global submit Global Request", btnGlobalRequest);
		Sync.waitForSeconds(Constants.WAIT_2);
		Thread.sleep(8000);
	}
	public void clickResubmitGlobalApprove() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(btnLocalActions));		
		Sync.waitForSeconds(Constants.WAIT_2);
		// Button.click("Local Actions button", btnLocalActions);
		Sync.waitForSeconds(Constants.WAIT_1);
		wait.until(ExpectedConditions.elementToBeClickable(btnGlobalRequestApprove));
		Button.click("Click Global submit Global Request", btnGlobalRequestApprove);
		Sync.waitForSeconds(Constants.WAIT_2);
		Thread.sleep(8000);
	}
	/***************************************************************************************************************/
	public void clickResubmitLocalRequest() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(btnLocalActions));
		Button.click("Local Actions button", btnLocalActions);
		Sync.waitForSeconds(Constants.WAIT_2);
		// Button.click("Local Actions button", btnLocalActions);
		Sync.waitForSeconds(Constants.WAIT_1);
		wait.until(ExpectedConditions.elementToBeClickable(btnLocalRequest));
		Button.click("Click Global submit Global Request", btnLocalRequest);
		Sync.waitForSeconds(Constants.WAIT_2);
		Thread.sleep(8000);
	}
	/*************************************************************************************************************/
	
	public boolean clickConfirmFlagForDeletionButton() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(btnLocalActions));
		Button.click("Local Actions button", btnLocalActions);

		if (Button.verifyObject(btnFlagForDeletionConfirmNav)) {
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForObject(driver, btnFlagForDeletionConfirmNav);
			return Button.jsclick("Confirm Flag for Deletion", btnFlagForDeletionConfirmNav, driver);
		} else {
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForObject(driver, btnFlagForDeletionConfirmNav);
			return Button.jsclick("Confirm Flag for Deletion", btnFlagForDeletionConfirmNav, driver);
		}
	}

	/*****************************************************************************************************************/
	
	/***********************************************************************************************************************************/
	public String getRequestId_ffd(String suiteName) throws InterruptedException, FileNotFoundException, IOException {

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Sync.waitForObject(driver, "Wait of Dialog Box Success Message", msgRequestSuccess);
		Sync.waitForSeconds(Constants.WAIT_3);

		WebDriverWait wait = new WebDriverWait(driver, 80);
		// WebElement text =
		// driver.findElement(By.xpath(".//*[@id='mxui_widget_DialogMessage_0']/div[1]/div[2]/p"));
		// wait.until(ExpectedConditions.elementToBeSelected(text));
		String reqId = driver.findElement(By.xpath(".//*[text()='Information']/../../div[2]/p"))
				.getText();
		String[] parts = reqId.split(" ");
		String Id = parts[6];
		System.out.println("RequestId is: " + Id);
		// ExcelUtil.excelWrite(Id);
		ExcelUtil.setCellData_New("TestPlan", "RequestId", Id, suiteName);
		System.out.println("Excel write is done");
		wait.until(ExpectedConditions.elementToBeClickable(btnOK));
		Sync.waitForSeconds(Constants.WAIT_2);
		Sync.waitForElementToBeClickable(driver, btnOK);

		Button.click("Click Ok Button", btnOK);
		return Id;
	}
	 public void DiscardExtensionLDR() throws InterruptedException {

			Sync.waitForSeconds(Constants.WAIT_6);
			Button.jsclick("Local Actions button click", btnLocalActions, driver);
			Sync.waitForSeconds(Constants.WAIT_6);
			Sync.waitForObject(driver,btnDiscardExtension);
			Button.jsclick("Click on reject button in locl action", btnDiscardExtension, driver);
			Sync.waitForSeconds(Constants.WAIT_6);
			Sync.waitForObject(driver, btnOK);
			Button.click("Click On OK button", btnOK);
			Sync.waitForSeconds(Constants.WAIT_6);
		}
		public void resubmitLocalRequest() throws InterruptedException {

			//Thread.sleep(6000);
			Sync.waitForSeconds(Constants.WAIT_6);
			Button.click("Local Actions button click", btnLocalActions);
			Sync.waitForSeconds(Constants.WAIT_6);
			Sync.waitForObject(driver, btnSumitLocalRequest);
			Textbox.click("Click on Submit Local Request in locl action", btnSumitLocalRequest);
			Sync.waitForSeconds(Constants.WAIT_6);
			Sync.waitForObject(driver, btnOK);
			Button.click("Click On OK button", btnOK);
			Sync.waitForSeconds(Constants.WAIT_6);
		}

		
		public void getVendorAccountNumber(String testCaseNameValue, String mendixUser) {
	
			if(mendixUser.equalsIgnoreCase("MDVM_BE01_LDR"))
			{
				String vendorTargetSystemBelgium = vendorTargetSystemBE.getText();
				if(vendorTargetSystemBelgium.equalsIgnoreCase("PH1700"))
				{
					if(driver.findElements(By.xpath(".//*[text()='Vendor account number']/../../../../../../table[2]/tbody/tr/td[2]//*[text()='PH1700']/../../td[1]/div")).size()>0)
					{
						String vendorAccNumber = vendorAccountNumberBE.getText();
						System.out.println("The Vendor Account Number is :"+vendorAccNumber);
						ExcelUtil.setCellDataOutputFile("OutputTestData", "Material_Number_AH1", vendorAccNumber, testCaseNameValue);
						System.out.println(""+vendorAccNumber);	
					}
					else
					{
						System.out.println("No Vendor Account Number Generated on UI for selected Global Id");
					}
				}
				else
				{
					System.out.println("No Element found to print in console");
				}
			}
			else if(mendixUser.equalsIgnoreCase("MDVM_PL01_LDR"))
			{
				String vendorTargetSystemPoland = vendorTargetSystemPL.getText();
				if(vendorTargetSystemPoland.equalsIgnoreCase("PE2700"))
				{
					if(driver.findElements(By.xpath(".//*[text()='Vendor account number']/../../../../../../table[2]/tbody/tr/td[2]//*[text()='PE2700']/../../td[1]/div")).size()>0)
					{
						String vendorAccNumber = vendorAccountNumberPL.getText();
						System.out.println("The Vendor Account Number is :"+vendorAccNumber);
						ExcelUtil.setCellDataOutputFile("OutputTestData", "Material_Number_AH1", vendorAccNumber, testCaseNameValue);
						System.out.println(""+vendorAccNumber);						
					}
					else
					{
						System.out.println("No Vendor Account Number Generated on UI for selected Global Id");
					}

				}
				else
				{
					System.out.println("No Element found to print in console");
				}	
			}
			
		}
		
		public void checkDashboardLockVendor() {
			// TODO Auto-generated method stub
			
			Sync.waitForSeconds(Constants.WAIT_5);
			globalLockValue = txtGlobalLockValue.getText();		
			
			localLockValue = txtLocalLockValue.getText();
			
			fFDValue = txtFFDValue.getText();
			
			System.out.println("Global lock: "+globalLockValue);
			System.out.println("Local Lock : "+localLockValue);
			System.out.println("FFD : "+fFDValue);
			
			if(globalLockValue.equalsIgnoreCase("No") && localLockValue.equalsIgnoreCase("No") && fFDValue.equalsIgnoreCase("No"))
			{
				System.out.println("Syndication Done");
				
				SharedDriver.pageContainer.vendorPage.GetFullVendorData();
				
				Sync.waitForSeconds(Constants.WAIT_10);
				
				if(driver.findElements(By.xpath("//*[@class='close mx-dialog-close']")).size()>0)
				{
					SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
					if(driver.findElements(By.xpath("//*[@class='close mx-dialog-close']")).size()>0)
					{
						SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
					}
				}
				
				if(driver.findElements(By.xpath(".//*[text()='Vendor account number']/../../../../../../table[2]/tbody/tr/td[1]")).size()>0)
				{
					List<WebElement> vendorAccountNumberList = driver.findElements(By.xpath(".//*[text()='Vendor account number']/../../../../../../table[2]/tbody/tr/td[1]"));
					
					List<WebElement> targetSystemList = driver.findElements(By.xpath(".//*[text()='Vendor account number']/../../../../../../table[2]/tbody/tr/td[2]"));
					
					Iterator<WebElement> i = targetSystemList.iterator();
					while(i.hasNext())
					{
					
						WebElement row = i.next();
						String targetSystem = row.getText();
						
						for(WebElement vendorList : vendorAccountNumberList)
						{	
						
							String vendorNumb = vendorList.getText();
							System.out.println("Vendor Account Number = "+vendorNumb+" for Target System : "+targetSystem);
						}
					}
				}
				else
				{
					System.out.println("No vendor Account numbers formed yet for the provided globalId");
				}
			}
			else
			{
				System.out.println("Syndiction not done");
				if(globalLockValue.equalsIgnoreCase("Yes"))
				{
					System.out.println("Global Lock is still active");
				}
				else if(localLockValue.equalsIgnoreCase("Yes"))
				{
					System.out.println("Local Lock is still active");
				}
				else if(fFDValue.equalsIgnoreCase("Yes"))
				{
					System.out.println("FFd Value is still active");
				}
				
				SharedDriver.pageContainer.vendorPage.GetFullVendorData();
				Sync.waitForSeconds(Constants.WAIT_10);
				if(driver.findElements(By.xpath("//*[@class='close mx-dialog-close']")).size()>0)
				{
					SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
					if(driver.findElements(By.xpath("//*[@class='close mx-dialog-close']")).size()>0)
					{
						SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
					}	
				}
				if(driver.findElements(By.xpath(".//*[text()='Vendor account number']/../../../../../../table[2]/tbody/tr/td[1]")).size()>0)
				{
					List<WebElement> vendorAccountNumberList = driver.findElements(By.xpath(".//*[text()='Vendor account number']/../../../../../../table[2]/tbody/tr/td[1]"));
					
					List<WebElement> targetSystemList = driver.findElements(By.xpath(".//*[text()='Vendor account number']/../../../../../../table[2]/tbody/tr/td[2]"));
					
					Iterator<WebElement> i = targetSystemList.iterator();
					while(i.hasNext())
					{
					
						WebElement row = i.next();
						String targetSystem = row.getText();
						
						for(WebElement vendorList : vendorAccountNumberList)
						{	
						
							String vendorNumb = vendorList.getText();
							System.out.println("Vendor Account Number = "+vendorNumb+" for Target System : "+targetSystem);
						}
					}					
				}
				else
				{
					System.out.println("No vendor Account numbers formed yet for the provided globalId");
				}
			}
			
		}
		
		public void checkDashboardLockVendorExtend(String strValue) throws InterruptedException {
			// TODO Auto-generated method stub
			
			Sync.waitForSeconds(Constants.WAIT_5);
			globalLockValue = txtGlobalLockValue.getText();		
			
			localLockValue = txtLocalLockValue.getText();
			
			fFDValue = txtFFDValue.getText();
			
			System.out.println("Global lock: "+globalLockValue);
			System.out.println("Local Lock : "+localLockValue);
			System.out.println("FFD : "+fFDValue);
			if((globalLockValue.equalsIgnoreCase("Yes") && localLockValue.equalsIgnoreCase("Yes") && fFDValue.equalsIgnoreCase("Yes")) || (globalLockValue.equalsIgnoreCase("Yes") && localLockValue.equalsIgnoreCase("No") && fFDValue.equalsIgnoreCase("No"))||(globalLockValue.equalsIgnoreCase("No") && localLockValue.equalsIgnoreCase("Yes") && fFDValue.equalsIgnoreCase("No"))||(globalLockValue.equalsIgnoreCase("No") && localLockValue.equalsIgnoreCase("No") && fFDValue.equalsIgnoreCase("Yes"))||(globalLockValue.equalsIgnoreCase("Yes") && localLockValue.equalsIgnoreCase("Yes") && fFDValue.equalsIgnoreCase("No")))
			{
//				Thread.sleep(120000);
				Textbox.clear("Clear TextBox Value", txtBoxGlobalId);
				Textbox.enterValue("Enter TextBox Value", txtBoxGlobalId, strValue);
				Sync.waitForSeconds(Constants.WAIT_5);
				Button.click("Click Search button", btnReqIdEnter);
				Sync.waitForSeconds(Constants.WAIT_5);
				
				if(globalLockValue.equalsIgnoreCase("No") && localLockValue.equalsIgnoreCase("No") && fFDValue.equalsIgnoreCase("No"))
				{
					System.out.println("Syndication Done");
				
					SharedDriver.pageContainer.vendorPage.GetFullVendorData();
				
					Sync.waitForSeconds(Constants.WAIT_10);
				
					SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
				
					if(driver.findElements(By.xpath("//*[@class='close mx-dialog-close']")).size()>0)
					{
						SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
					}
				
					List<WebElement> vendorAccountNumberList = driver.findElements(By.xpath(".//*[text()='Vendor account number']/../../../../../../table[2]/tbody/tr/td[1]"));
				
					List<WebElement> targetSystemList = driver.findElements(By.xpath(".//*[text()='Vendor account number']/../../../../../../table[2]/tbody/tr/td[2]"));
				
					Iterator<WebElement> i = targetSystemList.iterator();
					while(i.hasNext())
					{
				
						WebElement row = i.next();
						String targetSystem = row.getText();
					
						for(WebElement vendorList : vendorAccountNumberList)
						{	
					
							String vendorNumb = vendorList.getText();
							System.out.println("Vendor Account Number = "+vendorNumb+" for Target System : "+targetSystem);
						}
					}
				}
				else
				{
					System.out.println("Syndiction not done");
					if(globalLockValue.equalsIgnoreCase("Yes"))
					{
						System.out.println("Global Lock is still active");
					}
					else if(localLockValue.equalsIgnoreCase("Yes"))
					{
						System.out.println("Local Lock is still active");
					}
					else if(fFDValue.equalsIgnoreCase("Yes"))
					{
						System.out.println("FFd Value is still active");
					}
//					Assert.assertEquals(globalLockValue, "No", "Global Lock is still active");
//					Assert.assertEquals(localLockValue, "No", "Local lock is still active");
//					Assert.assertEquals(fFDValue, "No", "FFD Value is still active");
				}
			}
			else if(globalLockValue.equalsIgnoreCase("No") && localLockValue.equalsIgnoreCase("No") && fFDValue.equalsIgnoreCase("No"))
			{
				System.out.println("Syndication Done");
				
				SharedDriver.pageContainer.vendorPage.GetFullVendorData();
				
				Sync.waitForSeconds(Constants.WAIT_10);
				
				SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
				
				if(driver.findElements(By.xpath("//*[@class='close mx-dialog-close']")).size()>0)
				{
					SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
				}
				
				List<WebElement> vendorAccountNumberList = driver.findElements(By.xpath(".//*[text()='Vendor account number']/../../../../../../table[2]/tbody/tr/td[1]"));
				
				List<WebElement> targetSystemList = driver.findElements(By.xpath(".//*[text()='Vendor account number']/../../../../../../table[2]/tbody/tr/td[2]"));
				
				Iterator<WebElement> i = targetSystemList.iterator();
				while(i.hasNext())
				{
				
					WebElement row = i.next();
					String targetSystem = row.getText();
					
					for(WebElement vendorList : vendorAccountNumberList)
					{	
					
						String vendorNumb = vendorList.getText();
						System.out.println("Vendor Account Number = "+vendorNumb+" for Target System : "+targetSystem);
					}
				}
				
			}
			else
			{
				System.out.println("Syndication failed");
			}
			
		}
				
		public void submitBankRequest() {
			Sync.waitForSeconds(Constants.WAIT_1);
			Sync.waitForSeconds(Constants.WAIT_6);
			//Sync.waitForSeconds(Constants.WAIT_5);
			// Sync.waitForObject(driver, textLocalData);
			Sync.waitForObject(driver, btnBankRequest);
			Button.jsclick("Click Submit bank Request", btnBankRequest, driver);
			Sync.waitForSeconds(Constants.WAIT_5);

		}
		
		public void get_Vendor_Account_Number_SAP(String testCaseNameValue, String mendixLogin) throws InterruptedException, FileNotFoundException, IOException 
		{
				SharedDriver.pageContainer.vendorPage.checkDashboardLockVendor();
				SharedDriver.pageContainer.vendorPage.getVendorAccountNumber(testCaseNameValue, mendixLogin);							
		}
	
}
