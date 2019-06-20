
package com.mendix.page;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mendix.tool.Button;
import com.mendix.tool.Constants;
import com.mendix.tool.DropDown;
import com.mendix.tool.SharedDriver;
import com.mendix.tool.Sync;
import com.mendix.tool.Textbox;
import com.mendix.util.ExcelUtil;
import com.mendix.util.ResultUtil;
import com.mendix.util.DataProviderUtil.staticProviderClass;

import javafx.scene.control.Alert;

public class MaterialPage {

	/** The driver. */
	WebDriver driver;

	/**
	 * Instantiates a new home page.
	 *
	 * @param driver
	 *            the driver
	 */
	public String state = null;

	public String globalState = null;

	public String localState = null;

	public String globalLockValue = null;
	public String localLockValue = null;
	public String fFDValue = null;

	public MaterialPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// **********************************Global
	// Actions*****************************************************************

	@FindBy(how = How.XPATH, using = "//*[text()='My record is not a duplicate! Submit.']")
	WebElement btnDuplicateSubmit;

	@FindBy(how = How.XPATH, using = ".//span[@class='glyphicon glyphicon-copy']")
	WebElement duplicateBtn;

	@FindBy(how = How.XPATH, using = ".//span[@class='glyphicon glyphicon-check']")
	WebElement validateDuplicate;

	// *************************************************************************************************
	@FindBy(how = How.XPATH, using = ".modal-body.mx-dialog-body>p")
	WebElement msgRequestSuccessMsg;

	@FindBy(how = How.XPATH, using = "//*[text()='Reject Global Request']")
	WebElement btnRejectGlobalRequest;

	@FindBy(how = How.XPATH, using = "((.//*[text()='Edit Comments'])/../../div[2]/div/div/div/div/div/div[1]/div/div/div/div/div/textarea)")
	WebElement textAreaComment;

	/*
	 * @FindBy(how=How.XPATH,
	 * using="//*[text()='Created On']/../../tr[3]td[4]/div/div/div/input")
	 * WebElement txtboxCreateOnEnter;
	 */
	@FindBy(how = How.XPATH, using = ".//span[@class='glyphicon glyphicon-ban-circle']")
	WebElement btnDiscardCreate;
	
	@FindBy(how = How.XPATH, using = "//*[text()='Discard Local Change']")
	WebElement btnDiscardLocalChange;

	@FindBy(how = How.XPATH, using = "//*[text()='OK']")
	WebElement btnOK;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Materials')]")
	WebElement textMaterial;

	@FindBy(how = How.XPATH, using = "(//*[starts-with(text(),' Create')])[1]")
	WebElement menuCreate;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Production | Raw material, ingredient or processing aid')]")
	WebElement btnMaterialTypeSelect;

	@FindBy(how = How.XPATH, using = ".//div[@class='mx-referenceselector-input-wrapper']/select")
	WebElement slctOpCo;

	@FindBy(how = How.XPATH, using = "//*[@class='glyphicon glyphicon-forward']")
	WebElement btnCreate;

	@FindBy(how = How.XPATH, using = "//*[text()='Local Data']")
	WebElement textLocalData;

	//@FindBy(how = How.XPATH, using = ".//*[@class='mx-layoutcontainer-wrapper mx-scrollcontainer-wrapper']/div[2]/button/span")
	 @FindBy(how=How.XPATH, using=".//*[@class='glyphicon glyphicon-flash']")
	WebElement btnLocalActions;

	@FindBy(how = How.XPATH, using = "//*[text()='Disable Local Request']")
	WebElement btnDisableLocalRequest;

	@FindBy(how = How.XPATH, using = "//*[text()='Proceed']")
	WebElement btnProceed;

	@FindBy(how = How.XPATH, using = "(.//*[@class='glyphicon glyphicon-edit'])[1]")
	WebElement btnEditDesc;

	@FindBy(how = How.CSS, using = "div[id^='mxui_widget_TextInput_'][class*='col-sm-8'] :nth-child(1)")
	WebElement txtboxDesc;
	
	@FindBy(how = How.XPATH, using=".//*[text()='Material Description per Language']/../../div[2]//*[text()='Description']/../div/input")
	WebElement txtBoxDesc;

	@FindBy(how = How.CSS, using = "button[id^='mxui_widget_ActionButton'][class='btn mx-button mx-name-actionButton1 editableByCondition btn-success']")
	WebElement btnMaterialDescSave;

	@FindBy(how = How.XPATH, using = "//*[text()='Material Group']/../div/button/span")
	WebElement btnMaterialGrpselection;

	@FindBy(how = How.XPATH, using = ".//*[@id='mxui_widget_SearchInput_0']/div[2]/input")
	WebElement txtboxMaterialGrpSearch;

	@FindBy(how = How.XPATH, using = "//button[text()='Search']")
	WebElement btnMaterialGrpSearch;

	@FindBy(how = How.XPATH, using = "(//div[contains(text(),'CMG')]/../../../../../../table[2]/tbody/tr[1]/td/div)[1]")
	WebElement txtCMGSelect;

	@FindBy(how = How.XPATH, using = "//button[text()='Select']")
	WebElement btnMaterialGroupSelect;

	@FindBy(how = How.XPATH, using = "//*[text()='Gross Weight Base UoM']/../div/input")
	WebElement txtBoxGrossWeightUOM;

	@FindBy(how = How.XPATH, using = "//*[text()='Unit of Weight']/../div/button/span")
	WebElement btnUnitofWeight;

	@FindBy(how = How.XPATH, using = "//label[text()='Commercial Unit']/../../div[2]/input")
	WebElement txtboxUnitofWeightInput;

	@FindBy(how = How.XPATH, using = "//button[text()='Search']")
	WebElement btnUnitofWeightSearch;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Display value')]/../../../../../../table[2]/tbody/tr[1]/td/div")
	WebElement txtUnitofWeightDisplay;

	@FindBy(how = How.XPATH, using = ".//button[text()='Select']")
	WebElement btnUnitofWeightSelect;

	@FindBy(how = How.XPATH, using = "//*[text()='Base UoM']/../div/button/span")
	WebElement btnBaseUOMSelection;

	@FindBy(how = How.XPATH, using = "//label[text()='Commercial Unit']/../../div[2]/input")
	WebElement txtboxBaseUOM;

	@FindBy(how = How.XPATH, using = "//button[text()='Search']")
	WebElement btnBaseUOMSearch;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Display value')]/../../../../../../table[2]/tbody/tr[1]/td/div")
	WebElement txtBaseUOMDisplay;

	@FindBy(how = How.XPATH, using = "(//*[text()='Select'])[1]")
	WebElement btnBaseUOMSelect;

	@FindBy(how = How.XPATH, using = "//*[text()='Net Weight Base UoM']/../div/input")
	WebElement txtboxNetWeight;

	// @FindBy(how=How.CSS,
	// using="select[id^='mxui_widget_ReferenceSelector_28_input'][class='form-control']")
	@FindBy(how = How.XPATH, using = "//*[text()='UoM - Primary']/../div[1]/div/select")
	WebElement slctUOMPrimary;

	@FindBy(how = How.XPATH, using = "//*[text()='Validate Local Request']")
	WebElement btnValidateLocalRequest;

	@FindBy(how = How.XPATH, using = "//div[@class='mx-placeholder']/button")
	WebElement btnlocalAction;

	@FindBy(how = How.XPATH, using = ".//*[text()='Request complies to all Validations']")
	WebElement txtValidationMsg;

	// **********************************Global
	// Actions*****************************************************************

	@FindBy(how = How.XPATH, using = ".//button[text()='Submit Global Request']")
	WebElement btnGlobalRequest;
	
	

	@FindBy(how = How.XPATH, using = ".//button[text()='Save As Draft']")
	WebElement btnSaveAsDraft;
	@FindBy(how = How.XPATH, using = ".//span[@class='glyphicon glyphicon-saved']")
	WebElement btnSavingAsDraft;

	@FindBy(how = How.XPATH, using = "//*[text()='Validate']")
	WebElement btnValidate;

	@FindBy(how = How.XPATH, using = "//*[text()='Duplicate Check']")
	WebElement btnDuplicateCheck;
	
	@FindBy(how = How.XPATH, using = "//*[text()='Validate and Duplicate Check']")
	WebElement btnValidateDuplicateCheck;

	// *************************************************************************************************
	@FindBy(how = How.XPATH, using = ".//*[@id='mxui_widget_DialogMessage_0']/div[1]/div[2]/p")
	WebElement msgRequestSuccess;

	@FindBy(how = How.XPATH, using = "//*[text()='No matches / possible duplicates have been found.']")
	WebElement msgDuplicateInfo;

	@FindBy(how = How.CSS, using = ".btn.btn-primary")
	WebElement btnMsgReqIdOk;
	
	@FindBy(how = How.XPATH, using = ".//*[text()='Open Record']")
	WebElement btnOpenRecord;
	

	// @FindBy(how=How.XPATH, using="(.//*[text()='New'])[4]")
	/*
	 * @FindBy(how=How.XPATH,
	 * using="(.//*[starts-with(@id,'uniqName') And text()='New'])[4]") WebElement
	 * btnCommentNew;
	 */

	/*
	 * @FindBy(how=How.XPATH,
	 * using="(.//*[starts-with(@id,'mxui_widget_TextArea')])[4]") WebElement
	 * textComment;
	 * 
	 * @FindBy(how=How.XPATH, using="//*[text()='Save']") WebElement btnSave;
	 * 
	 * 
	 * @FindBy(how=How.XPATH,
	 * using="//*[text()='Request ID']/../../td[4]/div/input") WebElement
	 * txtboxReqIdEnter;
	 */

	@FindBy(how = How.XPATH, using = "//*[text()='OK']")
	WebElement btnMsgReqIdOkdraft;

	@FindBy(how = How.XPATH, using = "(//*[starts-with(text(),' Dashboard')])[1]")
	WebElement menuMaterialDashboard;

	@FindBy(how = How.XPATH, using = "//*[@class='glyphicon glyphicon-plus']")
	WebElement btnAdvancedSearch;

	/*
	 * @FindBy(how=How.XPATH, using="//*[text()='Global ID']/../../td[4]/div/input")
	 * WebElement txtboxGlobalIdEnter;
	 */

	@FindBy(how = How.XPATH, using = "//*[text()='Request ID']/../../td[4]/div/input")
	WebElement txtboxReqIdEnter;

	@FindBy(how = How.XPATH, using = "//button[text()='Search']")
	WebElement btnReqIdEnter;

	/*
	 * @FindBy(how=How.XPATH,
	 * using="//*[text()='Created On']/../../td[4]/div/div/div/input") WebElement
	 * txtboxCreateOnEnter;
	 */

	/*
	 * @FindBy(how=How.XPATH,
	 * using="//*[text()='Created On']/../../tr[3]td[4]/div/div/div/input")
	 * WebElement txtboxCreateOnEnter;
	 */

	@FindBy(how = How.XPATH, using = "//*[text()='Created On']/../../tr[4]td[4]/div/div/div/input")
	WebElement txtboxCreateOnEnter;

	@FindBy(how = How.XPATH, using = "//button[text()='Get Full Material Data']")
	WebElement btnFullMaterailData;

	@FindBy(how = How.XPATH, using = "//*[text()='Global ID']/../../td[4]/div/input")
	WebElement txtboxGlobalIdEnter;

	/*
	 * @FindBy(how=How.XPATH,
	 * using=".//span[@class='glyphicon glyphicon-ban-circle']") WebElement
	 * btnDiscardCreate;
	 */
	/*
	 * @FindBy(how=How.XPATH, using="//*[text()='OK']") WebElement btnOK;
	 */
	@FindBy(how = How.CSS, using = ".btn.btn-primary")
	WebElement btnOkay;

	/*
	 * @FindBy(how=How.XPATH, using="//*[text()='Reject Global Request']")
	 * WebElement btnRejectGlobalRequest;
	 */
	/****************************************
	 * Local Actions
	 *********************************/

	@FindBy(how = How.XPATH, using = "//*[text()='Save']")
	WebElement btnSave;

	@FindBy(how = How.XPATH, using = "(.//*[starts-with(@id,'uniqName') And text()='New'])[4]")
	WebElement btnCommentNew;

	@FindBy(how = How.XPATH, using = "((.//*[text()='Edit Comments'])/../../div[2]/div/div/div/div/div/div[1]/div/div/div/div/div/textarea)")
	WebElement textComment;

	@FindBy(how = How.XPATH, using = ".//span[@class='glyphicon glyphicon-flag']")
	WebElement btnDelete;

	@FindBy(how = How.CSS, using = "div[class='modal-body mx-dialog-body']")
	WebElement btnMsgClose;

	@FindBy(how = How.CSS, using = ".modal-body.mx-dialog-body>p")
	WebElement msgGetRequest;

	@FindBy(how = How.XPATH, using = "//*[text()='Plants']/..//input")
	WebElement checkBoxPlant;

	@FindBy(how = How.XPATH, using = ".//*[text()='Plants']/..//button[1]")
	WebElement selectAllButton;

	@FindBy(how = How.XPATH, using = ".//*[text()='Create Request']")
	WebElement createRequest;
	@FindBy(how = How.XPATH, using = "//*[text()='Global Data']")
	WebElement btnGlobalData;

	@FindBy(how = How.XPATH, using = "//button[@class='btn mx-button mx-name-actionButton1 btn-lg btn-action-panel pull-right btn-default']")
	WebElement btnToConfirm;

	@FindBy(how = How.XPATH, using = "//button[@text='Confirm Extension']")
	WebElement btnConfirmExtension;

	@FindBy(how = How.XPATH, using = "//button[text()='Flag For Deletion']")
	WebElement btnflagForDeletion;

	@FindBy(how = How.XPATH, using = "//button[@class='btn mx-button mx-name-actionButton8 btn-success']")
	WebElement btnok;

	@FindBy(how = How.XPATH, using = "//*[@class='close mx-dialog-close']")
	WebElement btnClose;

	@FindBy(how = How.XPATH, using = ".//*[text()='Open Record']")
	WebElement openRecord;

	@FindBy(how = How.XPATH, using = "(//*[text()='Submit Global and Local Request'])[2]")
	WebElement btnGlobalLocalRequest;

	@FindBy(how = How.XPATH, using = ".//*[text()='Finance']")
	WebElement btnFinance;

	@FindBy(how = How.XPATH, using = "(.//*[text()='Edit'])[6]")
	WebElement btnEdit;

	@FindBy(how = How.XPATH, using = ".//*[contains(text(),'WHT Product Posting Group')]/../div/div/select")
	WebElement dropdownWHTValue;

	@FindBy(how = How.XPATH, using = "//*[text()='Validate Local Data']")
	WebElement btnValidateLocalData;

	@FindBy(how = How.XPATH, using = "//*[text()='Save']")
	WebElement btnSaveLocalData;

	@FindBy(how = How.XPATH, using = "(.//*[starts-with(@id,'uniqName') And text()='New'])[8]")
	WebElement btnCommentLocalNewNav;

	@FindBy(how = How.XPATH, using = "//*[text()='Reject Local Request']")
	WebElement btnRejectLocalRequest;
	
	@FindBy(how = How.XPATH, using = "//*[text()='Reject Bank Request']")
	WebElement btnRejectBankRequest;

	@FindBy(how = How.XPATH, using = ".//button[text()='Submit Local Request']")
	WebElement btnLocalRequest;

//	@FindBy(how = How.CSS, using = "div[id^='mxui_widget_NumberInput_'][class^='mx-name-textBox2'] :nth-child(1)")
	@FindBy(how=How.XPATH, using="//*[text()='Request ID']/../../td/div/input")
	WebElement txtboxRequestId;

	// @FindBy(how=How.XPATH, using=".//*[text()='Global
	// Lock']/../../../../../../table[2]/tbody/tr[1]/td[1]/div")
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'mx-name-dataView2 searchResults')]//table[2]/tbody/tr[1]/td[1]/div")
	WebElement txtGlobalLockValue;

	@FindBy(how = How.XPATH, using = ".//*[text()='Global Lock']/../../../../../../table[2]/tbody/tr[1]/td[2]/div")
	WebElement txtLocalLockValue;

	@FindBy(how = How.XPATH, using = ".//*[text()='Global Lock']/../../../../../../table[2]/tbody/tr[1]/td[3]/div")
	WebElement txtFFDValue;
	
	@FindBy(how=How.XPATH, using = ".//*[text()='Material number']/../../../../../../table[2]/tbody/tr/td[2]//*[text()='PH1700']")
	WebElement materialTargetSystemBE;
	
	@FindBy(how=How.XPATH, using = ".//*[text()='Material number']/../../../../../../table[2]/tbody/tr/td[2]//*[text()='PH1700']/../../td[1]/div")
	WebElement materialNumberBE;
	
	@FindBy(how = How.XPATH, using = ".//*[text()='Material number']/../../../../../../table[2]/tbody/tr/td[2]//*[text()='PE2700']")
	WebElement materialTargetSystemPL;
	
	@FindBy(how = How.XPATH, using = ".//*[text()='Material number']/../../../../../../table[2]/tbody/tr/td[2]//*[text()='PE2700']/../../td[1]/div")
	WebElement materialNumberPL;

	/**
	 * Enter UserName. Enter Password
	 * 
	 * Click Login
	 *
	 * @param strMenuName
	 *            the str menu name
	 * @return true, if successful
	 */

	public void switchToPopup() throws InterruptedException {
		String mainWindowHandl = driver.getWindowHandle();
		// Switch to child window and close it

		for (String childWindowHandle : driver.getWindowHandles()) {
			// If window handle is not main window handle then close it
			if (!childWindowHandle.equals(mainWindowHandl)) {
				driver.switchTo().window(childWindowHandle);

			}
		}
		Sync.WaitForPageLoad(driver);
		Sync.waitForObject(driver, textMaterial);
		Sync.waitUntilObjectDisappears(driver, "Loading Indicator",
				By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		driver.manage().window().maximize();
	}

	public boolean clickMaterial(String strPageName) throws InterruptedException {
		Sync.WaitForPageLoad(driver);
		if (Button.verifyObject(textMaterial)) {
			Sync.waitForObject(driver, "Materials", textMaterial);
			Button.NewmouseOver("Materials", driver, textMaterial);

			Sync.waitForSeconds(Constants.WAIT_1);
			return Button.click(strPageName,
					Sync.waitForObject(driver, strPageName, By.xpath("//a[normalize-space(.)='" + strPageName + "']")));
		} else {
			Sync.waitForObject(driver, "Materials", textMaterial);
			return Button.click(strPageName,
					Sync.waitForObject(driver, strPageName, By.xpath("//a[normalize-space(.)='" + strPageName + "']")));
		}
	}

	public boolean createMaterialNavigate() throws InterruptedException {

		Sync.waitForSeconds(Constants.WAIT_6);

		if (Button.verifyObject(menuCreate)) {
			Sync.waitForObject(driver, "Create", menuCreate);
			Sync.waitForSeconds(Constants.WAIT_1);
			return Button.click("Create", menuCreate);
		} else {
			return Button.click("Create", menuCreate);
		}
	}

	public boolean materialTypeSelection() throws InterruptedException {

		Sync.waitForObject(driver, "Material Type Select", btnMaterialTypeSelect);
		if (Button.verifyObject(btnMaterialTypeSelect)) {
			Sync.waitForObject(driver, "Material Type Select", btnMaterialTypeSelect);
			Sync.waitForSeconds(Constants.WAIT_1);
			return Button.click("Material Type Select", btnMaterialTypeSelect);
		} else {
			return Button.click("Material Type Selection", btnMaterialTypeSelect);
		}
	}

	public boolean createButtonClick() throws InterruptedException {

		Sync.waitForObject(driver, "Create Button Click", btnCreate);
		if (Button.verifyObject(btnCreate)) {
			Sync.waitForObject(driver, "Create Button Click", btnCreate);
			Sync.waitForSeconds(Constants.WAIT_3);
			return Button.click("Create Button Click", btnCreate);
		} else {
			return Button.click("Create Button Click", btnCreate);
		}

	}

	public boolean disableLocaData() {

		Sync.WaitForPageLoad(driver);
		Sync.waitUntilObjectDisappears(driver, "Waiting of Create page to Load",
				By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Local Data']")));
		Sync.waitForObject(driver, textLocalData);
		Button.click("Local Data", textLocalData);
		Button.click("Local Actions button", btnLocalActions);
		Button.click("Disable Local Request", btnDisableLocalRequest);
	    Button.click("Proceed", btnProceed);
	    Sync.waitForSeconds(Constants.WAIT_5);
	    return Button.click("Local Actions button", btnLocalActions);
	}

	public void Localactionbutton() {
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForObject(driver, btnLocalActions);
		Button.click("Local Actions button", btnLocalActions);
		Sync.waitForSeconds(Constants.WAIT_2);
	}

	public boolean materialDescCreate(String strValue) throws InterruptedException {
		/*
		 * JavascriptExecutor js; js = (JavascriptExecutor) driver; js.
		 * executeScript("$(\".mx-layoutcontainer-wrapper.mx-scrollcontainer-wrapper\").animate({ scrollBottom: \"100px\" })"
		 * );
		 */
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.WaitForPageLoad(driver);
		Sync.waitForObject(driver, btnEditDesc);
		Button.jsclick("Edit Description button Click", btnEditDesc, driver);
		Sync.waitForSeconds(Constants.WAIT_1);
		Sync.waitForObject(driver, txtboxDesc);
		Button.mouseClick(driver, "Click Material Desc Field", txtBoxDesc);
		Textbox.enterValue("Enter Material Desc", txtBoxDesc, strValue);
		WebDriverWait wait = new WebDriverWait(driver, 50);
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_5);
		return Button.jsclick("Material Description Save", btnMaterialDescSave, driver);
	}

	public boolean materialGrpSelectionTest(String strValue) throws InterruptedException {

		try {
			System.out.println("No Error Popup");
		} catch (Exception e) {
			Thread.sleep(4000);
			Sync.waitForObject(driver, btnOK);
			Button.click("Click On Ok on Error Popup", btnOK);
		}
		Sync.waitForSeconds(Constants.WAIT_5);
		JavascriptExecutor js;
		js = (JavascriptExecutor) driver;
		js.executeScript(
				"$(\".mx-layoutcontainer-wrapper.mx-scrollcontainer-wrapper\").animate({ scrollBottom: \"50px\" })");
		Sync.waitForElementToBeClickable(driver, btnMaterialGrpselection);
		Button.jsclick("Click Material Group Selection button", btnMaterialGrpselection, driver);
		Sync.waitForObject(driver, "Wait for Material Group Selection Text Box", txtboxMaterialGrpSearch);
		Sync.waitForSeconds("5");
		Textbox.click("Enter Material Group", txtboxMaterialGrpSearch);
		Textbox.clear("Enter Material Group", txtboxMaterialGrpSearch);
		Textbox.enterValue("Enter Material Group", txtboxMaterialGrpSearch, strValue);
		Button.click("Click Search Button", btnMaterialGrpSearch);
		Sync.waitForSeconds("5");
		Button.click("Click CMG Search result", txtCMGSelect);
		Sync.waitForObject(driver, "Wait for Material Group Selection Text Box", btnMaterialGroupSelect);
		return Button.click("Click Material Group Select", btnMaterialGroupSelect);

	}

	public boolean grossWeightEntestTest(String strValue) {

		Sync.waitForSeconds(Constants.WAIT_2);
		Sync.waitForElementToBeClickable(driver, txtBoxGrossWeightUOM);
		Textbox.click("Click Gross Weight Base UOM", txtBoxGrossWeightUOM);
		// Sync.waitForSeconds(Constants.WAIT_1);
		Sync.waitForObject(driver, "Wait for Gross Weight Base UOM TextBox", txtBoxGrossWeightUOM);
		return Textbox.enterValue("Enter Gross Weight Base UOM", txtBoxGrossWeightUOM, strValue);
	}

	public void unitOfWeightSelectionTest(String strValue) throws InterruptedException {

		/*Sync.waitForSeconds(Constants.WAIT_2);
		Sync.waitForElementToBeClickable(driver, btnUnitofWeight);
		Button.click("Click Unit of Weight selecction button", btnUnitofWeight);
		Sync.waitForObject(driver, "Wait for UOM popup", txtboxUnitofWeightInput);
		Textbox.enterValue("Enter Unit of Weight", txtboxUnitofWeightInput, strValue);
		Sync.waitForObject(driver, "Wait for UOM popup", btnUnitofWeightSearch);
		Button.click("Click Search Unit of Weight button", btnUnitofWeightSearch);
		Sync.waitForSeconds(Constants.WAIT_10);
		
		 * Sync.waitForObjectFluent(driver, driver.findElement(By.
		 * xpath("//div[@class='mx-datagrid-head-caption' and text()='Commercial Unit']/../../../../../../table[2])"
		 * ))); // Sync.waitForElementToBeClickable(driver,
		 * driver.findElement(By.xpath("//*[text()='"+strValue+"']")));
		 * 
		 * Actions btnselect = new Actions(driver);
		 * btnselect.moveToElement(driver.findElement(By.xpath("//*[text()='"+strValue+
		 * "']"))); btnselect.build(); btnselect.perform(); btnselect.click();
		 

		driver.findElement(By.xpath("//*[text()='" + strValue + "']")).click();
		System.out.println("Click on Selected Value");
		Sync.waitForSeconds(Constants.WAIT_10);
		Sync.waitForElementToBeClickable(driver, btnUnitofWeightSelect);

		// Actions act = new Actions(driver);
		// new WebDriverWait(driver,
		// 60).until(ExpectedConditions.visibilityOf(child_menu));
		// act.moveToElement(main_menu).moveToElement(child_menu).click().build().perform();

		Actions btnselect = new Actions(driver);
		btnselect.moveToElement(btnUnitofWeightSelect);
		btnselect.build();
		btnselect.perform();
		Button.click("Click Unit Of Weight Select Button", btnUnitofWeightSelect);	
*/		
		
		Sync.waitForElementToBeClickable(driver, btnUnitofWeight);		
		Sync.waitForSeconds(Constants.WAIT_5);
		Button.click("Click Unit of Weight selecction button", btnUnitofWeight);
		Sync.waitForObject(driver, "Wait for Unit Of weight", txtboxUnitofWeightInput);
		Sync.waitForSeconds(Constants.WAIT_5);
		Textbox.enterValue("Enter Unit of Weight", txtboxUnitofWeightInput, strValue);
		Sync.waitForObject(driver, "Wait for UOM popup", btnUnitofWeightSearch);
		Button.click("Click Search Unit of Weight button", btnUnitofWeightSearch);
		Sync.waitForSeconds(Constants.WAIT_10);

		driver.findElement(By.xpath("//*[text()='" + strValue + "']")).click();
		Sync.waitForElementToBeClickable(driver, btnBaseUOMSelect);

		// Actions act = new Actions(driver);
		// new WebDriverWait(driver,
		// 60).until(ExpectedConditions.visibilityOf(child_menu));
		// act.moveToElement(main_menu).moveToElement(child_menu).click().build().perform();

		Actions btnselect = new Actions(driver);
		btnselect.moveToElement(btnBaseUOMSelect);
		btnselect.build();
		btnselect.perform();
		Button.click("Click Base UOM select button", btnBaseUOMSelect);


	}

	public void baseUOMSelectionTest(String strValue) throws InterruptedException {

		Sync.waitForSeconds(Constants.WAIT_5);
		JavascriptExecutor js;
		js = (JavascriptExecutor) driver;
		js.executeScript(
				"$(\".mx-layoutcontainer-wrapper.mx-scrollcontainer-wrapper\").animate({ scrollTop: \"60px\" })");

		Sync.waitForElementToBeClickable(driver, btnBaseUOMSelection);
		Sync.waitForSeconds(Constants.WAIT_5);
		Button.click("Click Base UOM selection button", btnBaseUOMSelection);
		Sync.waitForObject(driver, "Wait for Base UOM Text Box Enter", txtboxBaseUOM);
		Sync.waitForSeconds(Constants.WAIT_5);
		Textbox.enterValue("Enter Base UOM", txtboxBaseUOM, strValue);
		Sync.waitForElementToBeClickable(driver, btnBaseUOMSearch);
		Button.click("Click Base UOM Search button", btnBaseUOMSearch);
		Sync.waitForElementToBeClickable(driver, txtBaseUOMDisplay);
		driver.findElement(By.xpath("//*[text()='" + strValue + "']")).click();
		Sync.waitForElementToBeClickable(driver, btnBaseUOMSelect);

		// Actions act = new Actions(driver);
		// new WebDriverWait(driver,
		// 60).until(ExpectedConditions.visibilityOf(child_menu));
		// act.moveToElement(main_menu).moveToElement(child_menu).click().build().perform();

		Actions btnselect = new Actions(driver);
		btnselect.moveToElement(btnBaseUOMSelect);
		btnselect.build();
		btnselect.perform();
		Button.click("Click Base UOM select button", btnBaseUOMSelect);
	}

	public boolean netWeightEnterTest(String strValue) throws InterruptedException {

		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForElementToBeClickable(driver, txtboxNetWeight);
		Textbox.clear("Enter Net Weight", txtboxNetWeight);
		Button.click("Click Net Weight Enter TextBox", txtboxNetWeight);

		return Textbox.enterValue("Enter Net Weight", txtboxNetWeight, strValue);
	}

	public void uomPrimarySelectionTest() throws InterruptedException {
		/*
		 * JavascriptExecutor js; js = (JavascriptExecutor) driver; js.
		 * executeScript("$(\".mx-layoutcontainer-wrapper.mx-scrollcontainer-wrapper\").animate({ scrollBottom: \"100px\" })"
		 * );
		 */

		// Sync.waitForObject(driver, "Wait for UOM Primary Select", slctUOMPrimary);
		Sync.waitForSeconds(Constants.WAIT_2);
		System.out.println("Click drop down");
		Sync.waitForSeconds(Constants.WAIT_5);
		// driver.findElement(By.cssSelector(".//*[text()='UoM -
		// Primary']/../div/div/select")).click();

		Select dropdownUOM = new Select(slctUOMPrimary);
		dropdownUOM.selectByIndex(1);
	}

	public boolean validateTestCreate() {
		Sync.waitForSeconds(Constants.WAIT_10);
		
		if(Button.verifyObject(btnLocalActions))
		{
			Sync.waitForSeconds(Constants.WAIT_10);
			//WebDriverWait wait = new WebDriverWait(driver,100);
			//wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='mx-layoutcontainer-wrapper mx-scrollcontainer-wrapper']/div[2]/button/span")));
			
			Button.jsclick("Click on Local Actions", btnLocalActions, driver);
			Sync.waitForSeconds(Constants.WAIT_6);
			Sync.waitForSeconds(Constants.WAIT_1);
			Button.click("Click Validate", btnValidate);
			return Sync.waitForObject(driver, "Verify Validate message", txtValidationMsg);
		}
		else
		{
			Button.jsclick("Local Actions button", btnLocalActions, driver);
			Sync.waitForSeconds(Constants.WAIT_6);
			Sync.waitForSeconds(Constants.WAIT_1);
			Button.click("Click Validate", btnValidate);
			return Sync.waitForObject(driver, "Verify Validate message", txtValidationMsg);
		}

	}
	public void validate() {
		WebDriverWait wait=new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[text()='Validate']"))));
				if(Button.verifyObject(btnValidate))  {
					Sync.waitForSeconds(Constants.WAIT_5);
					Button.click("Click on Validate",btnValidate);
				}
				else {
					Button.click("Click on Validate",btnValidate);
				}
	}

	public void DuplicateCheck() {

		Sync.waitForSeconds(Constants.WAIT_6);
		Sync.waitForSeconds(Constants.WAIT_1);
		Button.click("Click Duplicate check", btnDuplicateCheck);
		// click on popup No matches / possible duplicates have been found.
		Sync.waitForObject(driver, btnOK);
		Button.click("Click On Ok on duplicate check info popup", btnOK);

	}

	/*
	 * public void submitGlobalRequestTest() throws InterruptedException {
	 * 
	 * 
	 * Sync.waitForSeconds(Constants.WAIT_5); Sync.waitForSeconds(Constants.WAIT_1);
	 * Sync.waitForObject(driver, "Verify Validate message", txtValidationMsg);
	 * Sync.waitForSeconds(Constants.WAIT_6); Sync.waitForSeconds(Constants.WAIT_5);
	 * 
	 * Button.click("Click Global submit Global Request", btnGlobalRequest);
	 * Sync.waitForSeconds(Constants.WAIT_5); Sync.waitForSeconds(Constants.WAIT_5);
	 * 
	 * 
	 * }
	 */

	/*
	 * public void RejectGDA() throws InterruptedException, AWTException {
	 * 
	 * System.out.println("Scrolling action");
	 * 
	 * Thread.sleep(3000); System.out.println("Scrolling"); String test =
	 * driver.findElement(By.xpath(".//*[@id='mxui_widget_TextInput_3']/p")).getText
	 * ();
	 * driver.findElement(By.xpath(".//*[@id='mxui_widget_TextInput_3']/p")).click()
	 * ; System.out.println(test); Thread.sleep(2000);
	 * 
	 * Robot robot = new Robot(); // Robot class throws AWT Exception
	 * Thread.sleep(4000); // Thread.sleep throws InterruptedException
	 * robot.keyPress(KeyEvent.VK_DOWN); Thread.sleep(2000);
	 * robot.keyRelease(KeyEvent.VK_DOWN);
	 * 
	 * Actions action = new Actions(driver);
	 * action.sendKeys(Keys.PAGE_DOWN).build().perform(); Thread.sleep(1000);
	 * 
	 * action.sendKeys(Keys.PAGE_DOWN).build().perform(); Thread.sleep(1000);
	 * 
	 * action.sendKeys(Keys.PAGE_DOWN).build().perform(); Thread.sleep(1000);
	 * 
	 * action.sendKeys(Keys.PAGE_DOWN).build().perform(); Thread.sleep(1000);
	 * 
	 * Sync.waitForObject(driver, btnCommentNew); Thread.sleep(5000);
	 * System.out.println("checking for new button");
	 * 
	 * String
	 * text1=driver.findElement(By.xpath(".//*[@id='mxui_widget_NumberInput_3']/p"))
	 * .getText(); System.out.println(text1); String text2=driver.findElement(By.
	 * xpath("(.//*[@class='btn mx-button mx-name-newButton2 btn-default'])[1]")).
	 * getText(); System.out.println(text2);
	 * 
	 * driver.findElement(By.
	 * xpath("(.//*[@class='btn mx-button mx-name-newButton2 btn-default'])[1]")).
	 * click();
	 * 
	 * System.out.println("clicked new button"); Thread.sleep(2000);
	 * 
	 * Textbox.enterValue("typing comment", textComment, "material data");
	 * Textbox.click("Click on Save Button", btnSave); Thread.sleep(2000);
	 * 
	 * 
	 * Button.click("Local Actions button click", btnLocalActions);
	 * Thread.sleep(2000); Sync.waitForObject(driver, btnRejectGlobalRequest);
	 * Textbox.click("Click on reject button in locl action",
	 * btnRejectGlobalRequest); Thread.sleep(3000); Sync.waitForObject(driver,
	 * btnOK); Button.click("Click On OK button", btnOK); Thread.sleep(2000); }
	 */

	/*
	 * public void DiscardCreateGDA() throws InterruptedException {
	 * 
	 * Thread.sleep(6000); Button.click("Local Actions button click",
	 * btnLocalActions); Thread.sleep(2000); Sync.waitForObject(driver,
	 * btnDiscardCreate); Textbox.click("Click on reject button in locl action",
	 * btnDiscardCreate); Thread.sleep(4000); Sync.waitForObject(driver, btnOK);
	 * Button.click("Click On OK button", btnOK); Thread.sleep(2000); }
	 */

	public void submitGlobalRequestTest() throws InterruptedException {

		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForObject(driver, "Verify Validate message", txtValidationMsg);
		Button.click("Click Global submit Global Request", btnGlobalRequest);
		Sync.waitForSeconds(Constants.WAIT_5);
		
	}
	
	public void submitGlobalRequest() throws InterruptedException {

		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForObject(driver, "Verify Validate message", btnGlobalRequest);
		Button.click("Click Global submit Global Request", btnGlobalRequest);
		Sync.waitForSeconds(Constants.WAIT_5);
		
	}

	public void submitGlobalandLocalRequestTest() throws InterruptedException {

		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForObject(driver, "Verify Validate message", txtValidationMsg);
		Button.click("Click Global submit Global Request", btnLocalRequest);
		Sync.waitForSeconds(Constants.WAIT_2);
		Thread.sleep(8000);
	}

	public String getRequestId(String suiteName) throws InterruptedException, FileNotFoundException, IOException {

		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitUntilObjectDisappears(driver, "Waiting of Create page to Load",
				By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(300))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);

		WebElement msgRequestSuccess = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//p[contains(text(),'Request ID')]"));
			}
		});

		System.out.println(msgRequestSuccess.getText());
		Sync.waitForObject(driver, "Wait of Dialog Box Success Message", msgRequestSuccess);
		Sync.waitForSeconds(Constants.WAIT_3);
		String reqId = driver.findElement(By.xpath(".//*[@id='mxui_widget_DialogMessage_0']/div[1]/div[2]/p"))
				.getText();
		String[] parts = reqId.split(" ");
		String Id = parts[2];
		System.out.println("RequestId is: " + Id);
		// ExcelUtil.excelWrite(Id);
		ExcelUtil.setCellData_New("input/Mendix_TestPlan" + Constants.EXCEL_FORMAT_XLSX, "Test_Case", Id, suiteName);
		System.out.println("Excel write is done");
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForElementToBeClickable(driver, btnOK);

		Button.click("Click Ok Button", btnOK);
		return Id;
	}

	/*
	 * public void clickLocalAction() { Sync.waitForSeconds(Constants.WAIT_2);
	 * WebElement element =
	 * driver.findElement(By.xpath(".//*[@class='glyphicon glyphicon-flash']"));
	 * Actions actions = new Actions(driver);
	 * actions.moveToElement(element).click().build().perform(); //
	 * driver.findElement(By.xpath(".//*[@class='glyphicon glyphicon-flash']")).
	 * click(); }
	 */

	public boolean validateTestCreateLocal() {
		Sync.waitForSeconds(Constants.WAIT_6);
		Sync.waitForSeconds(Constants.WAIT_1);
		Button.click("Click Validate", btnValidateLocalRequest);
		return Sync.waitForObject(driver, "Verify Validate message", txtValidationMsg);
	}

	// ***********************************************************************************

	public String getRequestIdOne(String suiteName) throws InterruptedException, FileNotFoundException, IOException {

		WebDriverWait wait = new WebDriverWait(driver, 80);
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_5);

		WebElement waitElement = null;

		FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMinutes(3))
				.pollingEvery(Duration.ofSeconds(600)).ignoring(NoSuchElementException.class)
				.ignoring(TimeoutException.class);

		try {
			waitElement = fwait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.cssSelector(".modal-body.mx-dialog-body>p"));
				}
			});
		} catch (Exception e) {
		}


		System.out.println(msgGetRequest.getText());
		Sync.waitForObject(driver, "Wait of Dialog Box Success Message", msgGetRequest);
		String reqId = driver.findElement(By.cssSelector(".modal-body.mx-dialog-body>p")).getText();
		String[] parts = reqId.split(" ");
		String Id = parts[2];
		System.out.println("RequestId is: " + Id);
		// ExcelUtil.setCellDataNew("TestPlan",4,10,Id);
		ExcelUtil.setCellData_New("TestPlan", "RequestId", Id, suiteName);
		// Sync.waitForSeconds(Constants.OBJECT_WAIT_TIME);
		/*
		 * System.out.println(btnMsgReqIdOk.getCssValue("color")); Actions actions = new
		 * Actions(driver); actions.moveToElement(btnMsgReqIdOk); actions.perform();
		 * 
		 * Button.click("Click Ok Button", btnMsgReqIdOk);
		 */
		return Id;
	}

	public void clickLocalAction() {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='glyphicon glyphicon-flash']")));
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_1);
		WebElement waitElement = null;
		/*
		 * FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
		 * .withTimeout(Duration.ofMinutes(3)) .pollingEvery(Duration.ofSeconds(600))
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
		// if (waitElement != null) {
		//WebDriverWait wait = new WebDriverWait(driver, 120);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class='glyphicon glyphicon-flash']")));
		// }
		// Sync.waitUntilObjectDisappears(driver, "Wait for Materials",
		// By.xpath((".//*[@id='mxui_widget_Progress_0']/div[2]")));
		// Sync.waitForElementToBeClickable(driver,
		// driver.findElement(By.xpath(".//*[@class='glyphicon glyphicon-flash']")));
		driver.findElement(By.xpath(".//*[@class='glyphicon glyphicon-flash']")).click();
	}

	// ***********************************************************************************

	public void SaveAsDraft() throws InterruptedException {

		Sync.waitForSeconds(Constants.WAIT_5);
		WebDriverWait wait=new WebDriverWait(driver,80);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//span[@class='glyphicon glyphicon-saved']")));
				
		//Sync.waitForObject(drivr, "Verify Validate message", txtValidationMsg);
		/* Button.click("Click Save as Draft", btnSaveAsDraft); */
		Button.click("Click Save as Draft", btnSavingAsDraft);
		Sync.waitForSeconds(Constants.WAIT_5);
		// Sync.waitForSeconds(Constants.WAIT_6);
	}

	public String getRequestId_draft(String suiteName) throws InterruptedException, FileNotFoundException, IOException {

		Sync.waitForSeconds(Constants.WAIT_5);
		WebDriverWait wait = new WebDriverWait(driver, 140);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal-body.mx-dialog-body>p")));

		Sync.waitForObject(driver, "Wait of Dialog Box Success Message", msgRequestSuccessMsg);
		// String
		// reqId=driver.findElement(By.xpath(".//*[@id='mxui_widget_DialogMessage_0']/div[1]/div[2]/p")).getText();
		String reqId = driver.findElement(By.cssSelector(".modal-body.mx-dialog-body>p")).getText();
		String[] parts = reqId.split(" ");
		//String Id = parts[14];
		String Id = parts[parts.length-1];
		String IdNum = Id.replaceAll("\\.", "");
		System.out.println("RequestId is: " + Id);
		// ExcelUtil.excelWrite(IdNum);
		// ExcelUtil.setCellDataNew("TestPlan",4,11,Id);
		Sync.waitForSeconds(Constants.WAIT_5);
		ExcelUtil.setCellData_New("TestPlan", "RequestId", IdNum, suiteName);
		
		System.out.println("RequestId is: " + IdNum);
		Sync.waitForSeconds(Constants.WAIT_3);
		Sync.waitForElementToBeClickable(driver, btnMsgReqIdOkdraft);
		// Button.click("Click Ok Button", btnMsgReqIdOkdraft);
		return Id;
	}



	public void advancedSearch() throws InterruptedException {

		TimeUnit.SECONDS.sleep(8);
		driver.switchTo().window("Application");
		TimeUnit.SECONDS.sleep(7);
		Button.click("Click Advanced Search", btnAdvancedSearch);
		TimeUnit.SECONDS.sleep(3);

	}

	public boolean navigateToDashboard() {
		Sync.waitForSeconds(Constants.WAIT_6);
		Sync.waitForSeconds(Constants.WAIT_1);

		// Sync.waitUntilObjectDisappears(driver, "Wait for Materials",
		// By.xpath((".//*[@id='mxui_widget_Progress_0']/div[2]")));
		Sync.waitForObject(driver, "Wait until the Material appears", textMaterial);
		Button.jsclick("Click Materials Menu", textMaterial, driver);
		return Button.jsclick("Click Dashboard Menu", menuMaterialDashboard, driver);
	}

	public void scrolltoGlobalSearch() {
		JavascriptExecutor js;
		js = (JavascriptExecutor) driver;
		js.executeScript(
				"$(\".mx-layoutcontainer-wrapper.mx-scrollcontainer-wrapper\").animate({ scrollBottom: \"100px\" })");
	}

	public void reqIdSearchGlobal(String strValue) throws InterruptedException {
		Sync.waitForSeconds(Constants.WAIT_2);
		Sync.waitForObject(driver, txtboxReqIdEnter);

		Textbox.clear("Clear TextBox Value", txtboxReqIdEnter);
		Textbox.enterValue("Enter TextBox Value", txtboxReqIdEnter, strValue);

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

	public boolean clickFullMaterialData() {
		//Sync.waitForSeconds(Constants.WAIT_3);
		Sync.waitUntilObjectDisappears(driver, "Wait for Materials",
				By.xpath((".//*[@id='mxui_widget_Progress_0']/div[2]")));
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Get Full Material Data']")));

		Sync.waitForSeconds(Constants.WAIT_2);
		Sync.waitForObject(driver, "Wait until the Material appears", btnFullMaterailData);
		return Button.click("Click Get Full Material Data", btnFullMaterailData);
	}

	public void getCurrDate() throws InterruptedException {

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		// get current date time with Date()
		Date date = new Date();

		// Now format the date
		String dateFormatted = dateFormat.format(date);

		Textbox.enterValue("Enter TextBox Value", txtboxCreateOnEnter, dateFormatted);
	}

	public String getGlobalId() throws FileNotFoundException, IOException {
		Sync.waitForSeconds(Constants.WAIT_3);

		// Sync.waitForSeconds(Constants.WAIT_2);
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
		 * WebDriverWait(driver, 30);
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(
		 * By.cssSelector("tr > td.mx-name-column2.mx-right-aligned > div"))
		 * 
		 * ); }
		 */
		// Sync.waitForObject(driver, "Wait for Global Material Id",
		// driver.findElement(By.cssSelector("tr > td.mx-name-column2.mx-right-aligned >
		// div")));
		// String globalLock=driver.findElement(By.cssSelector("tr >
		// td.mx-name-column17.mx-left-aligned > div")).getText();
		String globalLockState = driver
				.findElement(By.xpath("//*[text()='Global Lock']/../../../../../../table[2]/tbody[1]/tr[1]/td[1]/div"))
				.getText();
		System.out.println(globalLockState);

		// String globalId=driver.findElement(By.cssSelector("tr >
		// td.mx-name-column2.mx-right-aligned > div")).getText();
		String globalId = driver
				.findElement(By.xpath("//*[text()='Global ID']/../../../../../../table[2]/tbody[1]/tr[1]/td[2]/div"))
				.getText();
		System.out.println(globalId);
		ExcelUtil.excelWriteGlobalId(globalId);
		return globalId;
	}

	public String getGlobalIdProcessInfo(String suiteName) throws FileNotFoundException, IOException {
		Sync.waitForSeconds(Constants.WAIT_3);

		// Sync.waitForSeconds(Constants.WAIT_2);
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
		 * WebDriverWait(driver, 30);
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(
		 * By.cssSelector("tr > td.mx-name-column2.mx-right-aligned > div"))
		 * 
		 * ); }
		 */
		// Sync.waitForObject(driver, "Wait for Global Material Id",
		// driver.findElement(By.cssSelector("tr > td.mx-name-column2.mx-right-aligned >
		// div")));
		// String globalLock=driver.findElement(By.cssSelector("tr >
		// td.mx-name-column17.mx-left-aligned > div")).getText();
		// String globalLockState=driver.findElement(By.xpath("//*[text()='Global
		// Lock']/../../../../../../table[2]/tbody[1]/tr[1]/td[1]/div")).getText();
		// System.out.println(globalLockState);

		// String globalId=driver.findElement(By.cssSelector("tr >
		// td.mx-name-column2.mx-right-aligned > div")).getText();
		String globalId = driver
				.findElement(By.xpath("//*[text()='Global ID']/../../../../../../table[2]/tbody[1]/tr[1]/td[2]/div")).getText();
		System.out.println(globalId);
		ExcelUtil.setCellData_New_GlobalId("TestPlan","Global_ID",globalId, suiteName);
		return globalId;
	}

	/*
	 * public void clickFullMaterialData() { Sync.waitForSeconds(Constants.WAIT_5);
	 * Sync.waitForSeconds(Constants.WAIT_5); Sync.waitUntilObjectDisappears(driver,
	 * "Wait for Materials",
	 * By.xpath((".//*[@id='mxui_widget_Progress_0']/div[2]")));
	 * Sync.waitForObject(driver, "Wait until the Material appears",
	 * btnFullMaterailData); Button.click("Click Materials Menu",
	 * btnFullMaterailData); Sync.waitForSeconds(Constants.WAIT_5); }
	 * 
	 * public boolean clickFullMaterialData() {
	 * Sync.waitForSeconds(Constants.WAIT_3);
	 * 
	 * Sync.waitUntilObjectDisappears(driver, "Wait for Materials",
	 * By.xpath((".//*[@id='mxui_widget_Progress_0']/div[2]")));
	 * Sync.waitForSeconds(Constants.WAIT_2); Sync.waitForObject(driver,
	 * "Wait until the Material appears", btnFullMaterailData); return
	 * Button.click("Click Get Full Material Data", btnFullMaterailData);
	 * 
	 * }
	 */
	public void clickFullMaterialDataNew() {
		Sync.waitForSeconds(Constants.WAIT_2);
		Sync.waitUntilObjectDisappears(driver, "Wait for Materials",
				By.xpath((".//*[@id='mxui_widget_Progress_0']/div[2]")));
		Sync.waitForSeconds(Constants.WAIT_2);
		Sync.waitForObject(driver, "Wait until the Material appears", btnFullMaterailData);
		Button.click("Click Materials Menu", btnFullMaterailData);
		Sync.waitForSeconds(Constants.WAIT_10);
		/*
		 * while(driver.findElement(By.xpath("//*[@class='close mx-dialog-close']")).
		 * isDisplayed()) { WebElement popUp =
		 * driver.findElement(By.xpath("//*[@class='close mx-dialog-close']")); String
		 * popUpText =
		 * driver.findElement(By.xpath("//*[@class='modal-body mx-dialog-body']/p")).
		 * getText(); System.out.println(popUpText); //if(popUpText.
		 * equalsIgnoreCase("This Material does not have a local material number yet, so no local data was retrieved"
		 * )) //{
		 * 
		 * Button.jsclick("Click on Popup", popUp, driver);
		 * Sync.waitForSeconds(Constants.WAIT_2);
		 * 
		 * //Sync.waitForElementToBeClickable(driver, clickOkButton);
		 * //Button.jsclick("Click ok on info Popup", btnOkay, driver); //} }
		 */

	}

	public void clickFullMaterialDataDeletion() throws InterruptedException {
		Sync.waitForSeconds(Constants.WAIT_2);
		Sync.waitUntilObjectDisappears(driver, "Wait for Materials",
				By.xpath((".//*[@id='mxui_widget_Progress_0']/div[2]")));
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForObject(driver, "Wait until the Material appears", btnFullMaterailData);
		Button.click("Click Get Full Materaial", btnFullMaterailData);
		/*
		 * WebElement waitElement = null; FluentWait<WebDriver> fwait = new
		 * FluentWait<WebDriver>(driver) .withTimeout(Duration.ofMinutes(1))
		 * .pollingEvery(Duration.ofSeconds(600))
		 * .ignoring(NoSuchElementException.class) .ignoring(TimeoutException.class);
		 * 
		 * //First checking to see if the loading indicator is found // we catch and
		 * throw no exception here in case they aren't ignored try { waitElement =
		 * fwait.until(new Function<WebDriver, WebElement>() { public WebElement
		 * apply(WebDriver driver) { return
		 * driver.findElement(By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]")); }
		 * }); } catch (Exception e) { }
		 * 
		 * //checking if loading indicator was found and if so we wait for it to
		 * //disappear if (waitElement != null) { WebDriverWait wait = new
		 * WebDriverWait(driver, 100);
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(
		 * By.xpath(".//*[text()='OK']")));
		 * 
		 * 
		 * 
		 * }
		 * 
		 */
		// Switching to Alert

		try {
			/*
			 * WebDriverWait wait = new WebDriverWait(driver, 100);
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(
			 * By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]]")));
			 */
			WebElement msgbox = driver.findElement(By.xpath(
					".//p[text()='This Material does not have a local material number yet, so no local data was retrieved']"));
			while (msgbox.isDisplayed()) {

				System.out.println("Button is Clicked");

				Sync.waitForSeconds(Constants.WAIT_5);
				Button.click("Click ok button", btnOK);

			}
			// else{
			JavascriptExecutor js;
			js = (JavascriptExecutor) driver;
			js.executeScript(
					"$(\".mx-layoutcontainer-wrapper.mx-scrollcontainer-wrapper\").animate({ scrollTop: \"100px\" })");
			Sync.waitForSeconds(Constants.WAIT_5);

			Sync.waitForSeconds(Constants.WAIT_5);

			Button.click("Click Flag for Delete Button", btnDelete);

			// driver.findElement(By.xpath(".//span[@class='glyphicon glyphicon-flag']"));
			// }
			// }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickFlagForDeletion() throws InterruptedException {
		
		Sync.waitForObject(driver, btnDelete);
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_5);

		Button.jsclick("Click Flag for Delete Button", btnDelete, driver);

	}

	public String getMaterial_Number() throws FileNotFoundException, IOException {
		Sync.waitUntilObjectDisappears(driver, "Wait for Materials",
				By.xpath((".//*[@id='mxui_widget_Progress_0']/div[2]")));
		String materialNum = driver
				.findElement(By.xpath("//*[text()='Material number']/../../../../../../table[2]/tbody/tr[2]/td[1]/div"))
				.getText();
		System.out.println(materialNum);
		String numMaterial = materialNum.replaceFirst("^0+(?!$)", "");
		ExcelUtil.excelWriteMaterialNum(numMaterial);
		;
		return materialNum;
	}

	/*
	 * public void SaveAsDraft() throws InterruptedException {
	 * 
	 * Sync.waitForSeconds(Constants.WAIT_5);
	 * Button.click("Local Actions button click", btnLocalActions);
	 * Sync.waitForSeconds(Constants.WAIT_5); Sync.waitForObject(driver,
	 * btnDiscardCreate); Textbox.click("Click on discard button in locl action",
	 * btnDiscardCreate); Sync.waitForSeconds(Constants.WAIT_5);
	 * Sync.waitForObject(driver, btnOK); Button.click("Click On OK button", btnOK);
	 * Sync.waitForSeconds(Constants.WAIT_5); }
	 */

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
			Sync.waitForObject(driver, "Click Button To Confirm", btnConfirmExtension);
			Sync.waitForSeconds(Constants.WAIT_5);
			return Button.click("Click Button To Confirm", btnConfirmExtension);
		} else {
			return Button.click("Click Button To Confirm", btnConfirmExtension);
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

	public boolean clickflagDeletion() throws InterruptedException {

		if (Button.verifyObject(btnflagForDeletion)) {
			Sync.waitForObject(driver, "Click Button To Delete", btnflagForDeletion);
			Sync.waitForSeconds(Constants.WAIT_5);
			return Button.jsclick("Click Button To Delete", btnflagForDeletion, driver);
		} else {
			return Button.jsclick("Click Button To Delete", btnflagForDeletion, driver);
		}
	}

	// }

	public String getRequestId_Create(String suiteName) throws InterruptedException, FileNotFoundException, IOException {

		Sync.waitForSeconds(Constants.WAIT_6);
		Sync.waitForObject(driver, "Wait of Dialog Box Success Message", msgRequestSuccess);
		String reqId = driver.findElement(By.xpath(".//*[@id='mxui_widget_DialogMessage_0']/div[1]/div[2]/p"))
				.getText();
		String[] parts = reqId.split(" ");
		String Id = parts[2];
		System.out.println(Id);
		String IdNum = Id.replaceAll("\\.", "");
		System.out.println("RequestId is: " + Id);
		// ExcelUtil.excelWrite(IdNum);
		ExcelUtil.setCellData_New("TestPlan", "RequestId", Id, suiteName);
		System.out.println("RequestId is: " + IdNum);
		Sync.waitForSeconds(Constants.WAIT_3);
		Sync.waitForElementToBeClickable(driver, btnMsgReqIdOkdraft);
		// Button.click("Click Ok Button", btnMsgReqIdOkdraft);
		return Id;
	}

	public String getRequestId_Create_Local() throws InterruptedException, FileNotFoundException, IOException {

		Sync.waitForSeconds(Constants.WAIT_6);
		Sync.waitForObject(driver, "Wait of Dialog Box Success Message", msgRequestSuccess);
		String reqId = driver.findElement(By.xpath(".//*[@id='mxui_widget_DialogMessage_0']/div[1]/div[2]/p"))
				.getText();
		String[] parts = reqId.split("\\");
		String Id = parts[2];
		String IdNum = Id.replaceAll("\\.", "");
		System.out.println("RequestId is: " + Id);
		ExcelUtil.excelWrite(IdNum);
		System.out.println("RequestId is: " + IdNum);
		Sync.waitForSeconds(Constants.WAIT_3);
		Sync.waitForElementToBeClickable(driver, btnMsgReqIdOkdraft);
		// Button.click("Click Ok Button", btnMsgReqIdOkdraft);
		return Id;
	}

	public void submitBtnClick_Local() {
		WebElement waitElement = null;
		/*
		 * FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
		 * .withTimeout(Duration.ofMinutes(3)) .pollingEvery(Duration.ofSeconds(600))
		 * .ignoring(NoSuchElementException.class) .ignoring(TimeoutException.class);
		 * 
		 * //First checking to see if the loading indicator is found // we catch and
		 * throw no exception here in case they aren't ignored try { waitElement =
		 * fwait.until(new Function<WebDriver, WebElement>() { public WebElement
		 * apply(WebDriver driver) { return
		 * driver.findElement(By.xpath(".//*[@id='mxui_widget_Progress_0']")); } }); }
		 * catch (Exception e) {
		 * 
		 * }
		 */

		// checking if loading indicator was found and if so we wait for it to
		// disappear
		// if (waitElement != null) {
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 60);
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(
		 * By.xpath("(.//*[text()='Submit Global and Local Request'])[1]"))); // }
		 */ Sync.waitForSeconds(Constants.WAIT_2);

		Button.jsclick("Click Approval Button", btnLocalRequest, driver);
	}

	public void globalSearch(String strValue) throws InterruptedException {
		Sync.waitForSeconds(Constants.WAIT_3);

		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Search']")));
		// Sync.waitForObject(driver, txtboxReqIdEnter);
		Button.click("Click Search button", btnReqIdEnter);
		Sync.waitForSeconds(Constants.WAIT_5);
		// WebDriverWait wait = new WebDriverWait(driver, 50);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(
		// By.xpath("//*[text()='Global ID']/../../td[4]/div/input")));
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_5);

		Sync.waitForObject(driver, txtboxGlobalIdEnter);
		Sync.waitForSeconds(Constants.WAIT_10);
		Sync.waitForSeconds(Constants.WAIT_5);
		// Sync.waitForSeconds(Constants.WAIT_10);

		// Textbox.clear("Clear TextBox Value", txtboxGlobalIdEnter);
		Textbox.enterValue("Enter TextBox Value", txtboxGlobalIdEnter, strValue);
		Sync.waitForSeconds(Constants.WAIT_10);
		Sync.waitForSeconds(Constants.WAIT_5);
		
		Button.click("Click Search button", btnReqIdEnter);
		Sync.waitForSeconds(Constants.WAIT_10);
		Sync.waitForSeconds(Constants.WAIT_10);
	}

	public void DiscardCreateGDA() throws InterruptedException {

		//Sync.waitForSeconds(Constants.WAIT_5);
		//Button.click("Local Actions button click", btnLocalActions);
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForObject(driver, btnDiscardCreate);
		Textbox.click("Click on discard button in locl action", btnDiscardCreate);
		Sync.waitForSeconds(Constants.WAIT_5);
		Button.jsclick("Click Proceed button", btnProceed, driver);
		Sync.waitForObject(driver, btnOK);
		Button.click("Click On OK button", btnOK);
		Sync.waitForSeconds(Constants.WAIT_5);
	}
	public void DiscardCreateLocal() throws InterruptedException {

		//Sync.waitForSeconds(Constants.WAIT_5);
		//Button.click("Local Actions button click", btnLocalActions);
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForObject(driver, btnDiscardLocalChange);
		Textbox.click("Click on discard button in Local Request", btnDiscardLocalChange);
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForObject(driver, btnOK);
		Button.click("Click On OK button", btnOK);
		Sync.waitForSeconds(Constants.WAIT_5);
	}


	/*
	 * public void SaveAsDraft() throws InterruptedException {
	 * 
	 * Sync.waitForSeconds(Constants.WAIT_5);
	 * Button.click("Local Actions button click", btnLocalActions);
	 * Sync.waitForSeconds(Constants.WAIT_5); Sync.waitForObject(driver,
	 * btnDiscardCreate); Textbox.click("Click on discard button in locl action",
	 * btnDiscardCreate); Sync.waitForSeconds(Constants.WAIT_5);
	 * Sync.waitForObject(driver, btnOK); Button.click("Click On OK button", btnOK);
	 * Sync.waitForSeconds(Constants.WAIT_5); }
	 */
	public void RejectGDA() throws InterruptedException, AWTException {

		System.out.println("Scrolling action");

		Sync.waitForSeconds(Constants.WAIT_6);
		System.out.println("Scrolling");
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_5);
		String test = driver.findElement(By.xpath(".//*[@id='mxui_widget_TextInput_3']/p")).getText();
		driver.findElement(By.xpath(".//*[@id='mxui_widget_TextInput_3']/p")).click();
		System.out.println(test);

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

		Sync.waitForObject(driver, btnCommentNew);
		Sync.waitForSeconds(Constants.WAIT_5);
		System.out.println("checking for new button");
		Sync.waitForSeconds(Constants.WAIT_5);
		String text1 = driver.findElement(By.xpath(".//*[@id='mxui_widget_NumberInput_3']/p")).getText();
		System.out.println(text1);
		String text2 = driver.findElement(By.xpath("(.//*[@class='btn mx-button mx-name-newButton2 btn-default'])[1]"))
				.getText();
		System.out.println(text2);
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_5);

		Button.jsclick("Click New Button",
				driver.findElement(By.xpath("(.//*[@class='btn mx-button mx-name-newButton2 btn-default'])[1]")),
				driver);

		System.out.println("clicked new button");
		Sync.waitForSeconds(Constants.WAIT_5);

		Textbox.enterValue("typing comment", textComment, "material data");
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

	public void RejectLocalRequest() {
		Sync.waitForSeconds(Constants.WAIT_5);
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(.//*[@class='btn mx-button mx-name-newButton2 btn-default'])[2]")));
		Sync.waitForObject(driver,
				driver.findElement(By.xpath("(.//*[@class='btn mx-button mx-name-newButton2 btn-default'])[2]")));

		driver.findElement(By.xpath("(.//*[@class='btn mx-button mx-name-newButton2 btn-default'])[2]")).click();
		System.out.println("clicked new button");
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_5);

		Textbox.enterValue("typing comment", textComment, "material data");
		Textbox.click("Click on Save Button", btnSave);
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[text()='Reject Local Request']")));
		Sync.waitForObject(driver, "Wait for Reject Local Request",
				driver.findElement(By.xpath(".//*[text()='Reject Local Request']")));
		Sync.waitForElementToBeClickable(driver, driver.findElement(By.xpath(".//*[text()='Reject Local Request']")));
		Button.click("Click  Reject Local Request",
				driver.findElement(By.xpath(".//*[text()='Reject Local Request']")));
		// Button.click("Click Global submit Global Request",
		// driver.findElement(By.xpath("(//span[@class='glyphicon
		// glyphicon-save'])[2]")));
		Sync.waitForSeconds(Constants.WAIT_2);
		Sync.waitForSeconds(Constants.WAIT_5);
	}

	public void rejectVendorLocalRequest() {
		Sync.waitForSeconds(Constants.WAIT_5);

		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(.//*[@class='btn mx-button mx-name-newButton2 btn-default'])[3]")));
		Sync.waitForObject(driver,
				driver.findElement(By.xpath("(.//*[@class='btn mx-button mx-name-newButton2 btn-default'])[3]")));

		driver.findElement(By.xpath("(.//*[@class='btn mx-button mx-name-newButton2 btn-default'])[3]")).click();
		System.out.println("clicked new button");
		Sync.waitForSeconds(Constants.WAIT_5);
		// WebDriverWait wait1 = new WebDriverWait(driver,80);
		// wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(.//*[text()='Edit
		// Comments'])/../../div[2]/div/div/div/div/div/div[1]/div/div/div/div/div/textarea")));

		Textbox.enterValue("typing comment", textAreaComment, "Material data");
		Sync.waitForSeconds(Constants.WAIT_5);
		Textbox.click("Click on Save Button", btnSave);
		WebDriverWait wait2 = new WebDriverWait(driver, 20);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[text()='Reject Local Request']")));
		Sync.waitForObject(driver, "Wait for Reject Local Request",
				driver.findElement(By.xpath(".//*[text()='Reject Local Request']")));
		Sync.waitForElementToBeClickable(driver, driver.findElement(By.xpath(".//*[text()='Reject Local Request']")));
		Button.click("Click  Reject Local Request",
				driver.findElement(By.xpath(".//*[text()='Reject Local Request']")));
		// Button.click("Click Global submit Global Request",
		// driver.findElement(By.xpath("(//span[@class='glyphicon
		// glyphicon-save'])[2]")));
		Sync.waitForSeconds(Constants.WAIT_2);
		Sync.waitForSeconds(Constants.WAIT_5);
	}

	public void clickOkToHandlePopup() {
		Sync.waitForSeconds(Constants.WAIT_10);
		if(Button.verifyObject(btnClose)) {
			
			WebDriverWait wait = new WebDriverWait(driver,80);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='close mx-dialog-close']")));
		//WebElement popUp = driver.findElement(By.xpath("//*[@class='close mx-dialog-close']"));
		 Button.jsclick("Click on Popup", btnClose, driver);
		 Sync.waitForSeconds(Constants.WAIT_10);
		}
		else {
			Sync.waitForSec(Constants.WAIT_5);
		}
		// Sync.waitForSeconds(Constants.WAIT_1);
		// Button.jsclick("Click ok on info Popup", btnOkay, driver);
	}

	public boolean clickCreateRequestPopup() {
		Sync.waitForSeconds(Constants.WAIT_5);

		Sync.waitForSeconds(Constants.WAIT_5);
		// WebElement popUp = driver.findElement(By.xpath("//*[@class='close
		// mx-dialog-close']"));
		Sync.waitForObject(driver, checkBoxPlant);
		return Button.jsclick("Click on Edit Checkbox", checkBoxPlant, driver);
	}

	public boolean clickCreateRequestSelectAllPopup() {
		Sync.waitForSeconds(Constants.WAIT_5);

		Sync.waitForSeconds(Constants.WAIT_5);
		// WebElement popUp = driver.findElement(By.xpath("//*[@class='close
		// mx-dialog-close']"));
		Sync.waitForObject(driver, checkBoxPlant);
		return Button.jsclick("Click on Edit Checkbox", selectAllButton, driver);
	}

	public boolean clickCreateRequestButton() {
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_1);
		// WebElement popUp = driver.findElement(By.xpath("//*[@class='close
		// mx-dialog-close']"));
		Sync.waitForObject(driver, createRequest);
		return Button.jsclick("Click on Create Request Button", createRequest, driver);
	}

	public boolean SubmitLocalRequst() {
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_1);
		// WebElement popUp = driver.findElement(By.xpath("//*[@class='close
		// mx-dialog-close']"));
		Sync.waitForObject(driver, createRequest);
		return Button.jsclick("Click on Create Request Button", createRequest, driver);
	}

	public String getRequestId_CreateNew(String suiteName) throws InterruptedException, FileNotFoundException, IOException {

		Sync.waitForSeconds(Constants.WAIT_10);
		WebDriverWait wait = new WebDriverWait(driver, 180);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal-body.mx-dialog-body>p")));

		Sync.waitForObject(driver, "Wait of Dialog Box Success Message", msgRequestSuccessMsg);
		 String reqId=driver.findElement(By.xpath(".//*[@id='mxui_widget_DialogMessage_0']/div[1]/div[2]/p")).getText();
		//String reqId = driver.findElement(By.cssSelector(".modal-body.mx-dialog-body>p")).getText();
		String[] parts = reqId.split(" ");
		String Id = parts[2];
		System.out.println(Id);
		String IdNum = Id.replaceAll("\\.", "");
		System.out.println("RequestId is: " + Id);
		// ExcelUtil.excelWrite(IdNum);
		// ExcelUtil.setCellDataNew("TestPlan",4,11,Id);
		ExcelUtil.setCellData_New("TestPlan", "RequestId", Id, suiteName);
		System.out.println("RequestId is: " + IdNum);
		Sync.waitForSeconds(Constants.WAIT_10);
		Sync.waitForElementToBeClickable(driver, btnMsgReqIdOkdraft);
		// Button.click("Click Ok Button", btnMsgReqIdOkdraft);
		return Id;
	}
	
	public String getRequestId_CreateNew_Extenstion(String suiteName) throws InterruptedException, FileNotFoundException, IOException {

		Sync.waitForSeconds(Constants.WAIT_10);
		WebDriverWait wait = new WebDriverWait(driver, 180);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal-body.mx-dialog-body>p")));

		Sync.waitForObject(driver, "Wait of Dialog Box Success Message", msgRequestSuccessMsg);
		 String reqId=driver.findElement(By.xpath(".//*[@id='mxui_widget_DialogMessage_0']/div[1]/div[2]/p")).getText();
		//String reqId = driver.findElement(By.cssSelector(".modal-body.mx-dialog-body>p")).getText();
		String[] parts = reqId.split(" ");
		String Id = parts[2];
		System.out.println(Id);
		String IdNum = Id.replaceAll("\\.", "");
		System.out.println("RequestId is: " + Id);
		// ExcelUtil.excelWrite(IdNum);
		// ExcelUtil.setCellDataNew("TestPlan",4,11,Id);
		ExcelUtil.setCellData_New("TestPlan", "RequestId", Id, suiteName);
		System.out.println("RequestId is: " + IdNum);
		Sync.waitForSeconds(Constants.WAIT_10);
		Sync.waitForElementToBeClickable(driver, btnMsgReqIdOkdraft);
		// Button.click("Click Ok Button", btnMsgReqIdOkdraft);
		return Id;
	}

	public void duplicateCheck() {
		try {
			// Sync.waitUntilObjectDisappears(driver, "Wait for Duplicate check",
			// By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
			Sync.waitForSeconds(Constants.WAIT_5);
			// Sync.waitForSeconds(Constants.WAIT_5);
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
				WebDriverWait wait = new WebDriverWait(driver, 180);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[text()='Open Record']")));
				System.out.println("Clicked on Open Record");

			}

			driver.manage().window().setPosition(new Point(-2000, 0));
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

	@FindBy(how=How.XPATH, using = ".//*[text()='Open Record']")
	WebElement btnDuplicateCheckOpenRecord;
	
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


		driver.manage().window().maximize();
		/*Actions actions = new Actions(driver);
		actions.moveToElement(btnMsgReqIdOk);
		actions.perform();

		Button.click("Click Ok Button", btnMsgReqIdOk);*/

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
	public void duplicateCheck_LDP_WithoutExtend() {
		
		Sync.waitForSeconds(Constants.WAIT_5);
		
		WebDriverWait wait = new WebDriverWait(driver, 100);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[text()='Open Record']")));
		System.out.println("Clicked on Open Record");

		// }

		driver.manage().window().setPosition(new Point(-2000, 0));
		driver.findElement(By.xpath(".//*[text()='Open Record']")).sendKeys(Keys.TAB);
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
		/*
		 * driver.manage().window().maximize(); Actions actions = new Actions(driver);
		 * actions.moveToElement(btnMsgReqIdOk); actions.perform();
		 * 
		 * Button.click("Click Ok Button", btnMsgReqIdOk);
		 */

		/*
		 * try { if(btnMsgReqIdOkdraft.isEnabled()) { Button.click("Click Ok Button",
		 * btnMsgReqIdOkdraft); System.out.println("Button is Clicked"); }
		 * 
		 * } catch(Exception e) { System.err.println(e.getMessage());
		 * 
		 * 
		 * }
		 */

		// }
		// catch(Exception e) {
		// System.err.println(e.getMessage());
		//
		//
		// }
	}


	public void duplicateCheck_New_ExtendSelected() {
		try {
			// Sync.waitUntilObjectDisappears(driver, "Wait for Duplicate check",
			// By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
			Sync.waitForSeconds(Constants.WAIT_5);
			// Sync.waitForSeconds(Constants.WAIT_5);
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
			 * //disappear if (waitElement != null) {
			 */ WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[text()='Open Record']")));

			System.out.println("Clicked on Open Record");

			// }
			if (Button.verifyObject(openRecord)) {
				driver.findElement(By.xpath(" (.//*[@class='mx-datagrid-body']/tr[1]/td[3])[2]")).click();
				driver.manage().window().setPosition(new Point(-2000, 0));
				driver.findElement(By.xpath(".//*[text()='Open Record']")).sendKeys(Keys.TAB);
				Sync.waitForSeconds(Constants.WAIT_2);
				driver.findElement(By.xpath(".//*[text()='Extend Selected']")).sendKeys(Keys.RETURN);
				Sync.waitForSeconds(Constants.WAIT_2);
				/*
				 * driver.findElement(By.xpath("//*[text()='Export to Excel']")).sendKeys(Keys.
				 * TAB); Sync.waitForSeconds(Constants.WAIT_2); driver.findElement(By.
				 * xpath("//*[text()='My record is not a duplicate! Submit.']")).sendKeys(Keys.
				 * RETURN); Sync.waitForSeconds(Constants.WAIT_2);
				 */
				driver.findElement(By.xpath("//*[text()='Proceed']")).click();
				Sync.waitForSeconds(Constants.WAIT_3);
				System.out.println("Clicked on proceed");

				driver.manage().window().maximize();
				Actions actions = new Actions(driver);
				actions.moveToElement(btnMsgReqIdOk);
				actions.perform();

				Button.click("Click Ok Button", btnMsgReqIdOk);
			} else {
				Button.click("Click Ok Button", btnMsgReqIdOk);
			}

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

	public void duplicateCheckButton() {
		Sync.waitForSeconds(Constants.WAIT_5);
		// WebDriverWait wait = new WebDriverWait(driver, 100);
		//Sync.waitUntilObjectDisappears(driver, "Wait for Duplicate check",
			//	By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForObject(driver, btnDuplicateCheck);
		Sync.waitForSeconds(Constants.WAIT_6);
		if (Button.verifyObject(duplicateBtn)) {
			Sync.waitForObject(driver, "Wait for the duplicate button", duplicateBtn);
			Button.jsclick("Click on Duplicate button", duplicateBtn, driver);
		} else {
			Button.jsclick("Clicked on Duplicate button", duplicateBtn, driver);
		}
	}


	public void clickDuplicateCheck() throws InterruptedException 
    {

   	 //Sync.waitUntilObjectDisappears(driver, "Wait for Duplicate check", By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
   	 Sync.waitForSeconds(Constants.WAIT_5); 
   	 Sync.waitForSeconds(Constants.WAIT_6);
   	 //btnDuplicateSubmit
   	 
   	 Thread.sleep(30000);
   	 if(driver.findElements(By.xpath(".//*[text()='Open Record']")).size()>0) 
   	 {
   		 System.out.println("Entered into the if loop");
   		 Sync.waitForSeconds(Constants.WAIT_5);
   		 this.duplicateCheck_New();
   	 }
   	 else if(Button.verifyObject(btnClose))
   	 {
   		 Sync.waitForSeconds(Constants.WAIT_5);
   		 Sync.waitForObject(driver, "Wait for the information PopUp", msgRequestSuccess);
   		 clickCloseButtonToPopUp();
   		 submitGlobalLocalRequest();
   	 }
    }

	public void validateAndDuplicateCheckButton() {
		Sync.waitForSeconds(Constants.WAIT_5);
		// WebDriverWait wait = new WebDriverWait(driver, 100);
		//Sync.waitUntilObjectDisappears(driver, "Wait for Duplicate check",
			//	By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForObject(driver, btnValidateDuplicateCheck);
		Sync.waitForSeconds(Constants.WAIT_6);
		if (Button.verifyObject(btnValidateDuplicateCheck)) {
			Sync.waitForObject(driver, "Wait for the duplicate button", btnValidateDuplicateCheck);
			Button.click("Click on Duplicate button", btnValidateDuplicateCheck);
		} else {
			Button.click("Clicked on Duplicate button", btnValidateDuplicateCheck);
		}
	}
	
	
	

	
	public void clickDuplicateCheck_without_Extend() throws InterruptedException {
		Sync.waitUntilObjectDisappears(driver, "Wait for Duplicate check",
		By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForSeconds(Constants.WAIT_5);
		//WebDriverWait wait = new WebDriverWait(driver, 50);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='My record is not a duplicate! Submit.']")));
		Thread.sleep(20000);
		if (driver.findElements(By.xpath(".//*[text()='Open Record']")).size()>0) {
			Sync.waitForSeconds(Constants.WAIT_5);
			duplicateCheck_LDP_WithoutExtend();
		} else if (Button.verifyObject(btnClose)) {

			Sync.waitForSeconds(Constants.WAIT_5);
			//Sync.waitForObject(driver, "Wait for the information PopUp", msgRequestSuccess);
			this.clickCloseButtonToPopUp();
			submitGlobalRequestTest();
			clickCloseButtonToPopUp();
		}
	}
	

	public void clickDuplicateCheckDuplicateFound() {
		Sync.waitUntilObjectDisappears(driver, "Wait for Duplicate check",
				By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForSeconds(Constants.WAIT_5);
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[text()='My record is not a duplicate! Submit.']")));

		if (Button.verifyObject(btnDuplicateSubmit)) {
			Sync.waitForSeconds(Constants.WAIT_5);
			duplicateCheck_New_ExtendSelected();
		} else if (Button.verifyObject(btnClose)) {

			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForObject(driver, "Wait for the information PopUp", msgRequestSuccess);

			clickOkToHandlePopup();
		}
	}

	public void clickDuplicateCheck_GlobalLocal() {
		Sync.waitUntilObjectDisappears(driver, "Wait for Duplicate check",
				By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForSeconds(Constants.WAIT_5);

		if (Button.verifyObject(btnDuplicateSubmit)) {
			Sync.waitForSeconds(Constants.WAIT_5);
			duplicateCheck_New();
		} else {

			Sync.waitForSeconds(Constants.WAIT_5);
			// Sync.waitForObject(driver, "Wait for the information PopUp",
			// msgRequestSuccess);

		}
	}

	public void validateDuplicateCheck() {
		Sync.waitUntilObjectDisappears(driver, "Wait for Duplicate check",
				By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		Sync.waitForSeconds(Constants.WAIT_5);
		if (Button.verifyObject(validateDuplicate)) {
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click on Validate and duplicate check", validateDuplicate);
		} else if (Button.verifyObject(btnClose)) {

			Sync.waitForSeconds(Constants.WAIT_5);

			Button.click("Click on Validate and duplicate check", validateDuplicate);
		}
	}

	public void clickCloseButtonToPopUp() {
		Sync.waitForSeconds(Constants.WAIT_10);
		
		if (Button.verifyObject(btnClose)) {

			Sync.waitForSeconds(Constants.WAIT_10);
			Sync.waitForObject(driver, "Wait for the information PopUp", msgRequestSuccess);
			// WebElement popUp = driver.findElement(By.xpath("//*[@class='close
			// mx-dialog-close']"));
			Button.jsclick("Click close PopUp", btnClose, driver);

		} else {
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForObject(driver, "Wait for the information PopUp", msgRequestSuccess);
			Button.jsclick("Click close PopUp", btnClose, driver);
		}
		// Sync.waitForSeconds(Constants.WAIT_3);
		// return Button.jsclick("Click ok on info Popup", btnOkay, driver);
	}

	public void validateAndsubmitGlobalLocalRequest() {
		Sync.waitForSeconds(Constants.WAIT_1);
		Sync.waitForSeconds(Constants.WAIT_6);
		Sync.waitForObject(driver, btnLocalActions);
		Button.click("Local Actions button", btnLocalActions);
		Sync.waitForSeconds(Constants.WAIT_6);
		Button.click("Validate Local Data", btnValidateLocalRequest);
		Sync.waitForSeconds(Constants.WAIT_6);
		Sync.waitForObject(driver, "Verify Validate message", txtValidationMsg);
		Sync.waitForSeconds(Constants.WAIT_5);

		// Sync.waitForSeconds(Constants.WAIT_5);
		// Sync.waitForObject(driver, "Verify Validate message", txtValidationMsg);
		// Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_5);
		// Sync.waitForObject(driver, textLocalData);
		Button.click("Click Global and Local submit Request", btnGlobalLocalRequest);
		Sync.waitForSeconds(Constants.WAIT_5);

	}
	
	public void submitGlobalLocalRequest() {
		Sync.waitForSeconds(Constants.WAIT_1);
		Sync.waitForSeconds(Constants.WAIT_6);
//		Sync.waitForObject(driver, btnLocalActions);
//		Button.click("Local Actions button", btnLocalActions);
//		Sync.waitForSeconds(Constants.WAIT_6);
//		Button.click("Validate Local Data", btnValidateLocalRequest);
//		Sync.waitForSeconds(Constants.WAIT_6);
//		Sync.waitForObject(driver, "Verify Validate message", txtValidationMsg);
//		Sync.waitForSeconds(Constants.WAIT_5);

		// Sync.waitForSeconds(Constants.WAIT_5);
		// Sync.waitForObject(driver, "Verify Validate message", txtValidationMsg);
		// Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_5);
		// Sync.waitForObject(driver, textLocalData);
		Button.jsclick("Click Global and Local submit Request", btnGlobalLocalRequest, driver);
		Sync.waitForSeconds(Constants.WAIT_5);

	}
	
	
	public void validateLocalDataForNAVCreateRef(String strValue) throws InterruptedException {
		Sync.waitForSeconds(Constants.WAIT_5);
		Button.jsclick("Local Data", textLocalData, driver);
		// Button.click("Local Actions button", btnLocalActions);
		Button.click("Validate Local Data", btnValidateLocalRequest);
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_5);

	//	WebElement popUp = driver.findElement(By.xpath("//*[@class='close mx-dialog-close']"));
	//	Button.jsclick("Click on Popup", popUp, driver);

		Sync.waitForSeconds(Constants.WAIT_5);
		Button.click("Local Data", textLocalData);

		// Sync.waitForObject(driver, "Verify Validate message", txtValidationMsg);
		Sync.waitForSeconds(Constants.WAIT_5);
		Button.jsclick("Local Data Finance", btnFinance, driver);
		Button.click("Click on Edit", btnEdit);
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_5);
		// WebElement dropdownWHTValue
		// =driver.findElement(By.xpath(".//*[contains(text(),'WHT Product Posting
		// Group')]/../div/div/select"));
		// Sync.waitForObject(driver, "Wait for WHT posting group Select",
		// dropdownWHTValue);
		// Sync.waitForElementToBeClickable(driver, dropdownWHTValue);
		// Button.click("Wait for WHT posting group Select", dropdownWHTValue);
		// Select roundVATPostingGroupDown= new Select(dropdownWHTValue);
		// roundVATPostingGroupDown.selectByVisibleText(strValue);

		this.selectWHTValueInDropDown(strValue);
		Sync.waitForSeconds(Constants.WAIT_1);
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

	public void selectWHTValueInDropDown(String strValue) throws InterruptedException {

		if (DropDown.verifyObject(dropdownWHTValue)) {
			Sync.waitForObject(driver, "Wait for WHT posting group Select", dropdownWHTValue);
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Wait for WHT posting group Select", dropdownWHTValue);
			Select roundVATPostingGroupDown = new Select(dropdownWHTValue);
			roundVATPostingGroupDown.selectByVisibleText(strValue);

		} else {
			Button.click("Wait for WHT posting group Select", dropdownWHTValue);
			Select roundVATPostingGroupDown = new Select(dropdownWHTValue);
			roundVATPostingGroupDown.selectByVisibleText(strValue);
		}
	}

	public void rejectLDS() throws AWTException {

		System.out.println("Scrolling action");

		Sync.waitForSeconds(Constants.WAIT_2);
		System.out.println("Scrolling");

		Sync.waitForObject(driver, btnCommentLocalNewNav);
		Sync.waitForSeconds(Constants.WAIT_2);
		System.out.println("checking for new button");

		//
//		String text1 = driver.findElement(By.xpath(".//*[text()='Comments']/../div[1]/div[2]/div[2]/button[1]")).getText();
//		System.out.println(text1);
//		Sync.waitForSeconds(Constants.WAIT_10);

		Button.jsclick("Click new to add a comment", driver.findElement(By.xpath(".//*[text()='Comments']/../div[1]/div[2]/div[2]/button[1]")), driver);
		// Button.jsclick("Click on New Button TO Add comment", btnCommentLocalNewNav,
		// driver);
		System.out.println("clicked new button");
		Sync.waitForSeconds(Constants.WAIT_10);
		Sync.waitForObject(driver, textComment);
		Textbox.enterValue("typing comment", textComment, "Data Rejection");
		Button.click("Click on Save Button", btnSave);
		Sync.waitForSeconds(Constants.WAIT_2);
		//Sync.waitForObject(driver, btnLocalActions);
		//Button.click("Local Actions button click", btnLocalActions);
		Sync.waitForSeconds(Constants.WAIT_2);
		Sync.waitForObject(driver, btnRejectLocalRequest);
		Button.click("Click on reject button in locl action", btnRejectLocalRequest);
		Sync.waitForSeconds(Constants.WAIT_2);
		Sync.waitForObject(driver, btnOK);
		Button.click("Click On OK button", btnOK);
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_2);

	}
	public void rejectLDSBank() throws AWTException {
		System.out.println("Scrolling action");

		Sync.waitForSeconds(Constants.WAIT_2);
		System.out.println("Scrolling");

		Sync.waitForObject(driver, btnCommentLocalNewNav);
		Sync.waitForSeconds(Constants.WAIT_2);
		System.out.println("checking for new button");

		String text1 = driver.findElement(By.xpath("(.//*[@class='btn mx-button mx-name-newButton2 btn-default'])[2]"))
				.getText();
		System.out.println(text1);
		Sync.waitForSeconds(Constants.WAIT_10);

		driver.findElement(By.xpath("(.//*[@class='btn mx-button mx-name-newButton2 btn-default'])[2]")).click();
		// Button.jsclick("Click on New Button TO Add comment", btnCommentLocalNewNav,
		// driver);
		System.out.println("clicked new button");
		Sync.waitForSeconds(Constants.WAIT_10);
		Sync.waitForObject(driver, textComment);
		Textbox.enterValue("typing comment", textComment, "material data");
		Button.click("Click on Save Button", btnSave);
		Sync.waitForSeconds(Constants.WAIT_2);
		//Sync.waitForObject(driver, btnLocalActions);
		//Button.click("Local Actions button click", btnLocalActions);
		Sync.waitForSeconds(Constants.WAIT_2);
		Sync.waitForObject(driver, btnRejectBankRequest);
		Button.click("Click on reject button in locl action", btnRejectBankRequest);
		Sync.waitForSeconds(Constants.WAIT_2);
		Sync.waitForObject(driver, btnOK);
		Button.click("Click On OK button", btnOK);
		Sync.waitForSeconds(Constants.WAIT_5);
		Sync.waitForSeconds(Constants.WAIT_2);

	}

	public void submitLocalRequestTest() throws InterruptedException {
		Sync.waitForSeconds(Constants.WAIT_10);
	
		if (Button.verifyObject(btnLocalRequest)) {
			WebDriverWait wait=new WebDriverWait(driver,80);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//button[text()='Submit Local Request']")));
			Sync.waitForSeconds(Constants.WAIT_5);
			Button.click("Click Submit Local Request", btnLocalRequest);
			Sync.waitForSeconds(Constants.WAIT_5);
		} else {
			Sync.waitForSeconds(Constants.WAIT_6);
			Sync.waitForSeconds(Constants.WAIT_1);
			//Button.click("Local Actions button", btnLocalActions);
			Sync.waitForSeconds(Constants.WAIT_6);
			Sync.waitForObject(driver, btnLocalRequest);
			Button.click("Click Submit Local Request", btnLocalRequest);
			Sync.waitForSeconds(Constants.WAIT_6);
		}
	}

	public void getGlobalIdProcessInfo_Extend(String strValue, String suiteName) throws FileNotFoundException, IOException {
		Sync.waitForSeconds(Constants.WAIT_3);

		state = driver.findElement(By.xpath(".//div[contains(@class,'searchResults')]/div[3]/div/table[2]/tbody/tr[1]/td[10]/div")).getText();

		if (state.equalsIgnoreCase("Syndication") || state.equalsIgnoreCase("Completed")) {
			System.out.println(state);
			String globalId = driver
					.findElement(
							By.xpath("//*[text()='Global ID']/../../../../../../table[2]/tbody[1]/tr[1]/td[2]/div"))
					.getText();
			System.out.println(globalId);
			ExcelUtil.setCellData_New_GlobalId("TestPlan", "Global_ID", globalId, suiteName);
			System.out.println(globalId);
		} else {
			state = driver.findElement(By.xpath(".//div[contains(@class,'searchResults')]/div[3]/div/table[2]/tbody/tr[1]/td[10]/div")).getText();
			System.out.println(state);

		}
	}
	
	
	public void checkSyndicationTest(String strValue) {
		Sync.waitForSeconds(Constants.WAIT_5);
		//Sync.waitForObject(driver, driver.findElement(By.xpath("(.//*[text()='" + strValue + "']/../../td[9]/div)[1]")));
		
		List<WebElement> states= driver.findElements(By.xpath(".//div[contains(@class,'searchResults')]/div[3]/div/table[2]/tbody/tr/td[10]"));
		for(WebElement state:states) {
			System.out.println("Request Id status details "+state.getText());
			SoftAssert assertSyndication = new SoftAssert();
			assertSyndication.assertEquals("Syndication",state.getText(), "Not changed to Syndication State");						
		}		
	}

	public void checkSyndication(String strValue) {
		Sync.waitForSeconds(Constants.WAIT_5);
		//Sync.waitForObject(driver, driver.findElement(By.xpath("(.//*[text()='" + strValue + "']/../../td[9]/div)[1]")));
		
		if(driver.findElements(By.xpath("(.//*[text()='" + strValue + "']/../../td[9]/div)[1]")).size()>0 && driver.findElements(By.xpath("(.//*[text()='" + strValue + "']/../../td[9]/div)[2]")).size()>0)
		{
			globalState = driver.findElement(By.xpath("(.//*[text()='" + strValue + "']/../../td[9]/div)[1]")).getText();
			localState = driver.findElement(By.xpath("(.//*[text()='" + strValue + "']/../../td[9]/div)[2]")).getText();

			System.out.println("Global State : " + globalState);
			System.out.println("Local State : " + localState);

			SoftAssert assertSyndication = new SoftAssert();
			assertSyndication.assertEquals(globalState, "Syndication", "Not changed to Syndication State");
			assertSyndication.assertEquals(localState, "Syndication", "Not changed to Syndication State");
		}
		else if(driver.findElements(By.xpath("(.//*[text()='" + strValue + "']/../../td[9]/div)[1]")).size()>0)
		{
			globalState = driver.findElement(By.xpath("(.//*[text()='" + strValue + "']/../../td[9]/div)[1]")).getText();
			System.out.println("Global State : " + globalState);
			SoftAssert assertSyndication = new SoftAssert();
			assertSyndication.assertEquals(globalState, "Syndication", "Not changed to Syndication State");
		}
		else
		{
			System.out.println("Element not displayed in the Process Information check Page");
		}
		
	}

public void checkSyndicationDoneStatus(String strValue) throws InterruptedException {
		
	Sync.waitForSeconds(Constants.WAIT_6);
	if(driver.findElements(By.xpath(".//div[contains(@class,'searchResults')]/div[3]/div/table[2]/tbody/tr/td[10]")).size()==2)
	{	
		globalState=driver.findElement(By.xpath(".//div[contains(@class,'searchResults')]/div[3]/div/table[2]/tbody/tr[1]/td[10]/div")).getText();
 		localState = driver.findElement(By.xpath(".//div[contains(@class,'searchResults')]/div[3]/div/table[2]/tbody/tr[2]/td[10]/div")).getText();
 		
 		if(globalState.equalsIgnoreCase("Completed") && localState.equalsIgnoreCase("Completed"))
 		{
 			System.out.println("Syndication Done Not required to wait for 20 minutes");
 		}
 		else
 		{
 			//Thread.sleep(1200000);
 			Sync.waitForSeconds(Constants.WAIT_3);
 			Sync.waitForObject(driver, "Wait for Request Id", txtboxRequestId);
		
 			Sync.waitForSeconds(Constants.WAIT_6);
 			Textbox.click("Click Request Id Text Box", txtboxRequestId);
 			Sync.waitForSeconds(Constants.WAIT_1);
 			Textbox.enterValue("Enter Request Id", txtboxRequestId, strValue);
 			Sync.waitForSeconds(Constants.WAIT_2);
 			Sync.waitForSeconds(Constants.WAIT_2);
		
 			driver.findElement(By.xpath(".//*[@class='glyphicon glyphicon-search']")).click();
		
 			Sync.waitForSeconds(Constants.WAIT_5);
 			globalState=driver.findElement(By.xpath(".//div[contains(@class,'searchResults')]/div[3]/div/table[2]/tbody/tr[1]/td[10]/div")).getText();
 	 		localState = driver.findElement(By.xpath(".//div[contains(@class,'searchResults')]/div[3]/div/table[2]/tbody/tr[2]/td[10]/div")).getText();
 		
 			System.out.println("Global State : "+globalState);
 			System.out.println("Local State : "+localState);
 		
 		if(globalState.equalsIgnoreCase("Completed") && localState.equalsIgnoreCase("Completed"))
 		{
 			System.out.println("Syndication done");
 		}
 		else
 		{
 			System.out.println("Syndication not done");
 		}
// 			Assert.assertEquals(globalState, "Completed", "Syndication not yet done");
// 			Assert.assertEquals(localState, "Completed", "Syndication not yet done");
 
 		}
	}
	else
	{
		globalState=driver.findElement(By.xpath(".//div[contains(@class,'searchResults')]/div[3]/div/table[2]/tbody/tr[1]/td[10]/div")).getText();
		if(globalState.equalsIgnoreCase("Completed"))
 		{
 			System.out.println("Syndication Done Not required to wait for 20 minutes");
 		}
 		else
 		{
 			//Thread.sleep(1200000);
 			Sync.waitForSeconds(Constants.WAIT_3);
 			Sync.waitForObject(driver, "Wait for Request Id", txtboxRequestId);
		
 			Sync.waitForSeconds(Constants.WAIT_6);
 			Textbox.click("Click Request Id Text Box", txtboxRequestId);
 			Sync.waitForSeconds(Constants.WAIT_1);
 			Textbox.enterValue("Enter Request Id", txtboxRequestId, strValue);
 			Sync.waitForSeconds(Constants.WAIT_2);
 			Sync.waitForSeconds(Constants.WAIT_2);
		
 			driver.findElement(By.xpath(".//*[@class='glyphicon glyphicon-search']")).click();
		
 			Sync.waitForSeconds(Constants.WAIT_5);
 			globalState=driver.findElement(By.xpath(".//div[contains(@class,'searchResults')]/div[3]/div/table[2]/tbody/tr[1]/td[10]/div")).getText();
 			System.out.println("Global State : "+globalState);
 			if(globalState.equalsIgnoreCase("Completed"))
 			{
 				System.out.println("Syndication done");
 				
 			}
 			else
 			{
 				System.out.println("Syndication not done");
 			}
 			//			Assert.assertEquals(globalState, "Completed", "Syndication not yet done");
 
 		}

	}

	}

	public void checkDashboardLock() {
		// TODO Auto-generated method stub

		Sync.waitForSeconds(Constants.WAIT_5);
		globalLockValue = txtGlobalLockValue.getText();

		localLockValue = txtLocalLockValue.getText();

		fFDValue = txtFFDValue.getText();

		System.out.println("Global lock: " + globalLockValue);
		System.out.println("Local Lock : " + localLockValue);
		System.out.println("FFD : " + fFDValue);

		if (globalLockValue.equalsIgnoreCase("No") && localLockValue.equalsIgnoreCase("No")
				&& fFDValue.equalsIgnoreCase("No")) {
			System.out.println("Syndication Done");

			SharedDriver.pageContainer.materialPage.clickFullMaterialData();

			Sync.waitForSeconds(Constants.WAIT_10);
			if(driver.findElements(By.xpath("//*[@class='close mx-dialog-close']")).size()>0)
			{
				SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();				
			}

			//SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();

			List<WebElement> materialNumberlist = driver
					.findElements(By.xpath(".//*[text()='Material number']/../../../../../../table[2]/tbody/tr/td[1]"));

			List<WebElement> targetSystemList = driver
					.findElements(By.xpath(".//*[text()='Material number']/../../../../../../table[2]/tbody/tr/td[2]"));

			Iterator<WebElement> i = targetSystemList.iterator();
			while (i.hasNext()) {

				WebElement row = i.next();
				String targetSystem = row.getText();

				for (WebElement materialList : materialNumberlist) {

					String materialNumb = materialList.getText();
					System.out.println("Material Number = " + materialNumb + " for Target System : " + targetSystem);
				}
			}
		} else {
			System.out.println("Syndiction not done");
			SoftAssert assrt = new SoftAssert();
			assrt.assertEquals(globalLockValue, "No", "Global Lock is still active");
			assrt.assertEquals(localLockValue, "No", "Local lock is still active");
			assrt.assertEquals(fFDValue, "No", "FFD Value is still active");
			SharedDriver.pageContainer.materialPage.clickFullMaterialData();

			Sync.waitForSeconds(Constants.WAIT_10);

			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();

			//SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();

			List<WebElement> materialNumberlist = driver
					.findElements(By.xpath(".//*[text()='Material number']/../../../../../../table[2]/tbody/tr/td[1]"));

			List<WebElement> targetSystemList = driver
					.findElements(By.xpath(".//*[text()='Material number']/../../../../../../table[2]/tbody/tr/td[2]"));

			Iterator<WebElement> i = targetSystemList.iterator();
			while (i.hasNext()) {

				WebElement row = i.next();
				String targetSystem = row.getText();

				for (WebElement materialList : materialNumberlist) {

					String materialNumb = materialList.getText();
					System.out.println("Material Number = " + materialNumb + " for Target System : " + targetSystem);
				}
			}
		}

	}
	
	
	public void getMaterialNumber(String suiteName, String opco) {
		// TODO Auto-generated method stub
		//Sync.waitForObject(driver, materialTargetSystemBE);
		//SoftAssert assertTargetSystem = new SoftAssert();
		//assertTargetSystem.assertEquals(materialTargetSystemBE.getText(), "PH1700", "The Target System is not there in Vendor Details of selected Global ID");
		if(opco.equalsIgnoreCase("BE01"))
		{
			String materialTargetSystemBelgium = materialTargetSystemBE.getText();
			if(materialTargetSystemBelgium.equalsIgnoreCase("PH1700"))
			{
				String materialNumber = materialNumberBE.getText();
				System.out.println("The Material Number is :"+materialNumber);
				ExcelUtil.setCellData_New_VendorAccNumber("TestPlan", "Material_Number_AH1", materialNumber, suiteName);
				System.out.println(""+materialNumber);
			}
			else
			{
				System.out.println("No Element found to print in console");
			}			
		}
		else if(opco.equalsIgnoreCase("PL01"))
		{
			String materialTargetSystemPoland = materialTargetSystemPL.getText();
			if(materialTargetSystemPoland.equalsIgnoreCase("PE2700"))
			{
				String materialNumber = materialNumberPL.getText();
				System.out.println("The Material Number is :"+materialNumber);
				ExcelUtil.setCellData_New_VendorAccNumber("TestPlan", "Material_Number_AH1", materialNumber, suiteName);
				System.out.println(""+materialNumber);
			}
			else
			{
				System.out.println("No Element found to print in console");
			}
		}
		
	}
	
	public void submitGlobalRequestExtend() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//button[text()='Submit Global Request']")));

		if (Button.verifyObject(btnGlobalRequest)) {
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForObject(driver, btnGlobalRequest);
			Button.jsclick("Click Global submit Global Request", btnGlobalRequest, driver);
			Sync.waitForSeconds(Constants.WAIT_2);
		} else {
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForObject(driver, btnGlobalRequest);
			Button.jsclick("Click Global submit Global Request", btnGlobalRequest, driver);
			Sync.waitForSeconds(Constants.WAIT_2);
		}
	}
	
	public void checkFFDLock() {
		// TODO Auto-generated method stub

		Sync.waitForSeconds(Constants.WAIT_5);
		globalLockValue = txtGlobalLockValue.getText();

		localLockValue = txtLocalLockValue.getText();

		fFDValue = txtFFDValue.getText();

		System.out.println("Global lock: " + globalLockValue);
		System.out.println("Local Lock : " + localLockValue);
		System.out.println("FFD : " + fFDValue);

		if (globalLockValue.equalsIgnoreCase("Yes") && localLockValue.equalsIgnoreCase("No")
				&& fFDValue.equalsIgnoreCase("Yes")) {
			
			System.out.println("Flag For Deletion Done");

		} else {
			System.out.println("Flag for Deletion not done");

		}

	}
	
}
