package com.mendix.test;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.mendix.tool.Constants;
import com.mendix.tool.SharedDriver;
import com.mendix.tool.Sync;
import com.mendix.util.DataProviderUtil.staticProviderClass;

public class MaterialNavScript extends BaseScript{

	WebDriver driver;

	/**
	 * Create Material with Nav.
	 * 
	 * @throws AWTException
	 */

	
	@Test(dataProvider = "CreateMaterial_Fill_In_Nav", dataProviderClass = staticProviderClass.class)
	public void Material_Create_Fill_In_Data(Map<String, String> dataMap, ITestContext context)
			throws InterruptedException, FileNotFoundException, IOException {
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			SharedDriver.pageContainer.materialPage.materialDescCreate(dataMap.get("Description"));
			SharedDriver.pageContainer.materialPage.materialGrpSelectionTest(dataMap.get("Material Group"));
			SharedDriver.pageContainer.materialPage.grossWeightEntestTest(dataMap.get("Gross Weight Base UoM"));
			SharedDriver.pageContainer.materialPage.unitOfWeightSelectionTest(dataMap.get("Unit of Weight"));
			SharedDriver.pageContainer.materialPage.baseUOMSelectionTest(dataMap.get("Base UoM"));
			SharedDriver.pageContainer.materialPage.netWeightEnterTest(dataMap.get("Net Weight Base UoM"));
			SharedDriver.pageContainer.materialPage.uomPrimarySelectionTest();
			//SharedDriver.pageContainer.materialNavPage.clickLocalAction();
			SharedDriver.pageContainer.materialPage.validateTestCreate();
			//SharedDriver.pageContainer.materialPage.duplicateCheckButton();
			//SharedDriver.pageContainer.materialPage.clickDuplicateCheck();	
		}
	}

	@Test(dataProvider = "CreateMaterial_Fill_In_Nav", dataProviderClass = staticProviderClass.class)
	public void Material_Create_Fill_In_Data_JDE_Planning(Map<String, String> dataMap, ITestContext context)
			throws InterruptedException, FileNotFoundException, IOException, AWTException {
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			SharedDriver.pageContainer.materialNavPage.enterLocalData();
			SharedDriver.pageContainer.materialNavPage.enterPlantData(dataMap.get("Plant"));
			SharedDriver.pageContainer.materialNavPage.clickEditPlanningData();
			SharedDriver.pageContainer.materialNavPage.scrolltoRoundingPrecision();
			SharedDriver.pageContainer.materialNavPage.selectRoundingPrecision(dataMap.get("Rounding Precision"));
			SharedDriver.pageContainer.materialNavPage.clickLocalAction();
			SharedDriver.pageContainer.materialNavPage.clickValidatLocalData();
			SharedDriver.pageContainer.materialNavPage.clickPlanningSaveButton();	
		}
		
	}

	@Test(dataProvider = "CreateMaterial_Fill_In_Nav", dataProviderClass = staticProviderClass.class)
	public void Material_Create_Fill_In_Data_JDE_Finance(Map<String, String> dataMap, ITestContext context)
			throws InterruptedException, FileNotFoundException, IOException, AWTException {
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			SharedDriver.pageContainer.materialNavPage.clickFinancetab();
			SharedDriver.pageContainer.materialNavPage.clickEditFinanceData();
			SharedDriver.pageContainer.materialNavPage.selectGenProdPostingGroup(dataMap.get("Gen. Prod. Posting Group"));
			SharedDriver.pageContainer.materialNavPage.selectVATPostingGroup(dataMap.get("VAT Prod. Posting Group"));
			SharedDriver.pageContainer.materialNavPage.selectItemDepositGroupCode(dataMap.get("Item Deposit Group Code"));
			SharedDriver.pageContainer.materialNavPage.clickLocalAction();
			SharedDriver.pageContainer.materialNavPage.clickValidatLocalData();
			SharedDriver.pageContainer.materialNavPage.clickSaveButton();	
		}
	}

	@Test(dataProvider = "CreateMaterial_Fill_In_Nav", dataProviderClass = staticProviderClass.class)
	public void Material_Create_Fill_In_Data_JDE_Site(Map<String, String> dataMap, ITestContext context)
			throws InterruptedException, FileNotFoundException, IOException, AWTException {
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			SharedDriver.pageContainer.materialNavPage.clickSiteNewTab();
			SharedDriver.pageContainer.materialNavPage.clickEditSiteData();
			SharedDriver.pageContainer.materialNavPage.clickSiteNewButton();
			SharedDriver.pageContainer.materialNavPage.selectLocationCode(dataMap.get("Location Code"));
			SharedDriver.pageContainer.materialNavPage.selectReplenishmentSystem(dataMap.get("Replenishment System"));
			SharedDriver.pageContainer.materialNavPage.clickSiteValidateButton();
			SharedDriver.pageContainer.materialNavPage.clickSiteSaveButton();
			SharedDriver.pageContainer.materialNavPage.clickLocalAction();
			SharedDriver.pageContainer.materialNavPage.clickSaveButton();
			SharedDriver.pageContainer.materialNavPage.clickLocalAction();
			SharedDriver.pageContainer.materialNavPage.submitGlobalRequestTest();
			SharedDriver.pageContainer.materialPage.getRequestId(suiteName);
			SharedDriver.pageContainer.materialApprovalPage.submitRequestOkBtnClick();	
		}
	}
	
	@Test(dataProvider = "Process_Information_Check", dataProviderClass = staticProviderClass.class)
	public void Process_Information_Check_Global(Map<String, String> dataMap, ITestContext context)
			throws InterruptedException, FileNotFoundException, IOException {
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			SharedDriver.pageContainer.processInfoPage.processInfoSearch();
			SharedDriver.pageContainer.processInfoPage.reqIdSearch_Global(dataMap.get("RequestId"));
			SharedDriver.pageContainer.processInfoPage.getState_New(dataMap.get("RequestId"));
			SharedDriver.pageContainer.processInfoPage.browserClose();	
		}
		
	}

	@Test(dataProvider = "Process_Information_Check", dataProviderClass = staticProviderClass.class)
	public void Process_Information_Check_Local(Map<String, String> dataMap, ITestContext context)
			throws InterruptedException, FileNotFoundException, IOException {
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			SharedDriver.pageContainer.processInfoPage.processInfoSearch();
			SharedDriver.pageContainer.processInfoPage.reqIdSearch_Local(dataMap.get("RequestId"));
			SharedDriver.pageContainer.processInfoPage.getState_New(dataMap.get("RequestId"));
			SharedDriver.pageContainer.processInfoPage.browserClose();
		}
	}

	@Test(dataProvider = "Process_Information_Check", dataProviderClass = staticProviderClass.class)
	public void Material_Create_Review_Global_Data_Approve_LDS(Map<String, String> dataMap, ITestContext context)
			throws InterruptedException, FileNotFoundException, IOException {
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			Assert.assertTrue(SharedDriver.pageContainer.homePage.navigateToWorkflow());
			SharedDriver.pageContainer.materialPage.switchToPopup();
			SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
			//SharedDriver.pageContainer.materialApprovalPage.approvalBtnClick_Local();
			SharedDriver.pageContainer.materialApprovalPage.markViewsBtnClick_Local();
			SharedDriver.pageContainer.materialApprovalPage.submitRequestOkButtonClick();
			SharedDriver.pageContainer.materialApprovalPage.approveLocalRequest();
			// SharedDriver.pageContainer.materialPage.getRequestId();
			SharedDriver.pageContainer.materialApprovalPage.submitRequestOkButtonClick();	
		}		
	}

	@Test(dataProvider = "Process_Information_Check", dataProviderClass = staticProviderClass.class)
	public void Material_Create_Review_Global_Data_Approve_LBDA(Map<String, String> dataMap, ITestContext context)
			throws InterruptedException, FileNotFoundException, IOException {
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			Assert.assertTrue(SharedDriver.pageContainer.homePage.navigateToWorkflow());
			SharedDriver.pageContainer.materialPage.switchToPopup();
			SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
			SharedDriver.pageContainer.materialApprovalPage.approvalBtnClick_Local();
			SharedDriver.pageContainer.materialApprovalPage.approveLocalRequest();
			SharedDriver.pageContainer.materialApprovalPage.submitRequestOkBtnClick();	
		}
		
	}

	@Test(dataProvider = "Process_Information_Check", dataProviderClass = staticProviderClass.class)
	public void Material_Create_Review_Global_Data_Approve_GDA(Map<String, String> dataMap, ITestContext context)
			throws InterruptedException, FileNotFoundException, IOException {
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			Assert.assertTrue(SharedDriver.pageContainer.homePage.navigateToWorkflow());
			SharedDriver.pageContainer.materialPage.switchToPopup();
			SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
			SharedDriver.pageContainer.materialApprovalPage.approvalBtnClick();
			SharedDriver.pageContainer.materialApprovalPage.duplicateCheck();
			SharedDriver.pageContainer.materialApprovalPage.submitRequestOkBtnClick();	
		}
		
	}

	@Test(dataProvider = "Process_Information_Check", dataProviderClass = staticProviderClass.class)
	public void Material_Create_Syndication_Check(Map<String, String> dataMap, ITestContext context)
			throws InterruptedException, FileNotFoundException, IOException {
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			SharedDriver.pageContainer.homePage.navigateToWorkflow();
			SharedDriver.pageContainer.materialPage.switchToPopup();
			SharedDriver.pageContainer.materialPage.navigateToDashboard();
			SharedDriver.pageContainer.materialPage.advancedSearch();
			SharedDriver.pageContainer.materialPage.scrolltoGlobalSearch();
			SharedDriver.pageContainer.materialPage.reqIdSearchGlobal(dataMap.get("RequestId"));
			SharedDriver.pageContainer.materialPage.getGlobalId();
			// SharedDriver.pageContainer.materialPage.clickFullMaterialData();
			// SharedDriver.pageContainer.materialPage.getMaterial_Number();
			SharedDriver.pageContainer.processInfoPage.browserClose();
			// SharedDriver.pageContainer.materialApprovalPage.launchUFT();	
		}
	}

	// ========================================Material Create Fill In Local Data Adding New Plant======================================================

	@Test(dataProvider = "CreateMaterial_Fill_In_Local", dataProviderClass = staticProviderClass.class)
	public void material_Local_Plant_Data_Fill_In_Nav(Map<String, String> dataMap, ITestContext context) throws InterruptedException {
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			Sync.waitForSeconds(Constants.WAIT_10);
			Sync.waitForSeconds(Constants.WAIT_6);
			SharedDriver.pageContainer.materialNavPage.localAddInNewPlantNav();
			// SharedDriver.pageContainer.materialNavPage.clickAndSelectPurchaseUOMValueDropDown(dataMap.get("Purch. Unit of Measure"));
			// SharedDriver.pageContainer.materialNavPage.clickAndSelectProdUOMValueDropDown(dataMap.get("Production Unit of Measure"));
			// SharedDriver.pageContainer.materialNavPage.clickAndSelectSalesUOMValueDropDown(dataMap.get("Sales Unit of Measure"));
			SharedDriver.pageContainer.materialNavPage.clickAndSelectRoundingPrecisionValueDropDown(dataMap.get("Rounding Precision"));
			// SharedDriver.pageContainer.materialNavPage.clickAndSelectInventoryUOMValueDropDown(dataMap.get("Inventory Unit of Measure"));
			SharedDriver.pageContainer.materialNavPage.validateAndSaveLocalData();
		}
		
	}
	/*
	 * ======================================Meterial Create Fill in Local Data Adding New Finance====================================================
	 */

	@Test(dataProvider = "CreateMaterial_Fill_In_Local", dataProviderClass = staticProviderClass.class)
	public void material_Local_Finance_Data_Fill_In_Nav(Map<String, String> dataMap, ITestContext context) throws InterruptedException {
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			SharedDriver.pageContainer.materialNavPage.localEditFinanceDataNav();
			// SharedDriver.pageContainer.materialNavPage.clickAndSelectInventoryPostingGroupDropDown(dataMap.get("Inventory Posting Group"));
			// SharedDriver.pageContainer.materialNavPage.clickAndSelectWHTGroupDropDown(dataMap.get("WHTProduct Posting Group"));
			// SharedDriver.pageContainer.materialNavPage.clickAndSelectGenProdPostingGroupDropDown(dataMap.get("Gen.Prod. Posting Group"));
			SharedDriver.pageContainer.basePage.waitForPageLoad();
			SharedDriver.pageContainer.materialNavPage.clickAndSelectVATPostingGroupDropDown(dataMap.get("VAT Prod. Posting Group"));
			SharedDriver.pageContainer.materialNavPage.validateAndSaveLocalData();
			// SharedDriver.pageContainer.materialNavPage
		}
		
	}

	/*
	 * =========================================Material Create Fill in Local Data
	 * Adding Site Data==================================================
	 */

	@Test(dataProvider = "CreateMaterial_Fill_In_Local", dataProviderClass = staticProviderClass.class)
	public void material_Create_Fill_In_Data_Nav_Local_Site(Map<String, String> dataMap, ITestContext context)
			throws InterruptedException, FileNotFoundException, IOException, AWTException {
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			SharedDriver.pageContainer.materialNavPage.clickSiteNewTab();
			SharedDriver.pageContainer.materialNavPage.clickEditSiteData();
			Sync.waitForSeconds(Constants.WAIT_5);
			SharedDriver.pageContainer.materialNavPage.selectingRow();
			Sync.waitForSeconds(Constants.WAIT_10);
			SharedDriver.pageContainer.materialNavPage.clickSiteEditButton();
			Sync.waitForSeconds(Constants.WAIT_10);
			//SharedDriver.pageContainer.basePage.waitForPageLoad();
			SharedDriver.pageContainer.materialNavPage.clickAndSelectSitePlantDropDown(dataMap.get("Location Code"));
			SharedDriver.pageContainer.materialNavPage.clickAndSelectSiteReplenishmentSystemDropDown(dataMap.get("Replenishment System"));
			SharedDriver.pageContainer.materialNavPage.clickLocalAction();
			SharedDriver.pageContainer.materialNavPage.clickSiteValidateButton();
			SharedDriver.pageContainer.materialNavPage.clickSiteSaveButton();
			SharedDriver.pageContainer.materialNavPage.clickLocalAction();
			SharedDriver.pageContainer.materialNavPage.clickSaveButton();
			SharedDriver.pageContainer.materialNavPage.clickLocalAction();
			SharedDriver.pageContainer.materialNavPage.clickValidateLocalRequest();
			// Sync.waitForSeconds(Constants.WAIT_10);	
		}
		
	}
	
	/**********************With Adding new row for sites data instead of editing the pre-existing template****************/
	@Test(dataProvider = "CreateMaterial_Fill_In_Local", dataProviderClass = staticProviderClass.class)
	public void material_Create_Fill_In_Data_Nav_Local_Adding_Site(Map<String, String> dataMap, ITestContext context)
			throws InterruptedException, FileNotFoundException, IOException, AWTException {
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			SharedDriver.pageContainer.materialNavPage.clickSiteNewTab();
			SharedDriver.pageContainer.materialNavPage.clickEditSiteData();
			Sync.waitForSeconds(Constants.WAIT_5);
			//SharedDriver.pageContainer.materialNavPage.selectingRow();
			Sync.waitForSeconds(Constants.WAIT_10);
			//SharedDriver.pageContainer.materialNavPage.clickSiteEditButton();
			SharedDriver.pageContainer.materialNavPage.clickSiteNewButton();
			Sync.waitForSeconds(Constants.WAIT_10);
			Sync.waitForSeconds(Constants.WAIT_5);
			//SharedDriver.pageContainer.basePage.waitForPageLoad();
			SharedDriver.pageContainer.materialNavPage.clickAndSelectSitePlantDropDown(dataMap.get("Location Code"));
			Sync.waitForSeconds(Constants.WAIT_5);
			SharedDriver.pageContainer.materialNavPage.clickAndSelectSiteReplenishmentSystemDropDown(dataMap.get("Replenishment System"));
			Sync.waitForSeconds(Constants.WAIT_6);
			SharedDriver.pageContainer.materialNavPage.clickLocalAction();
			SharedDriver.pageContainer.materialNavPage.clickSiteValidateButton();
			SharedDriver.pageContainer.materialNavPage.clickSiteSaveButton();
			SharedDriver.pageContainer.materialNavPage.clickLocalAction();
			SharedDriver.pageContainer.materialNavPage.clickSaveButton();
			SharedDriver.pageContainer.materialNavPage.clickLocalAction();
			SharedDriver.pageContainer.materialNavPage.clickValidateLocalRequest();
			Sync.waitForSeconds(Constants.WAIT_10);
		}
	
		
	}
	
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void material_Confirm_Extension(Map<String, String> dataMap, ITestContext context) throws FileNotFoundException, InterruptedException, IOException
	{
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			//Sync.waitForSeconds(Constants.WAIT_10);
			//SharedDriver.pageContainer.basePage.waitForPageLoad();
			SharedDriver.pageContainer.materialNavPage.clickGlobalDataButton();
			SharedDriver.pageContainer.materialNavPage.confirmExtensionNav();
			Sync.waitForSeconds(Constants.WAIT_5);
			Sync.waitForSeconds(Constants.WAIT_6);
			Sync.waitForSeconds(Constants.WAIT_5);
			//Sync.waitForObject(driver, driver.findElement(By.cssSelector(".modal-body.mx-dialog-body>p")));
			SharedDriver.pageContainer.materialPage.getRequestId_CreateNew(suiteName);
			Sync.waitForSeconds(Constants.WAIT_10);
			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();	
		}
	
	}
	
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Process_Information_Check_GlobalID(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException 
	{
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			SharedDriver.pageContainer.processInfoPage.processInfoSearch();
			SharedDriver.pageContainer.processInfoPage.reqIdSearch_Global(dataMap.get("RequestId"));
			SharedDriver.pageContainer.processInfoPage.getState_New(dataMap.get("RequestId"));
			//SharedDriver.pageContainer.processInfoPage.capturing_GlobalID();
			SharedDriver.pageContainer.materialPage.getGlobalIdProcessInfo(suiteName);
			Sync.waitForSeconds(Constants.WAIT_5);
			SharedDriver.pageContainer.processInfoPage.browserClose();	
		}
		
	}
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Material_Create_Review_Local_Data_Reject_LDS(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			Assert.assertTrue(SharedDriver.pageContainer.homePage.navigateToWorkflow());
			SharedDriver.pageContainer.materialPage.switchToPopup();
			SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
			
			//SharedDriver.pageContainer.materialApprovalPage.approvalBtnClick_Local();
			SharedDriver.pageContainer.materialApprovalPage.markViewsBtnClick_Local();
			SharedDriver.pageContainer.materialPage.clickOkToHandlePopup();
			SharedDriver.pageContainer.materialPage.rejectLDS();
			//SharedDriver.pageContainer.materialApprovalPage.submitRequestOkButtonClick();		
		}
	}
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Material_Create_Review_Bank_Data_Reject_LDS(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			Assert.assertTrue(SharedDriver.pageContainer.homePage.navigateToWorkflow());
			SharedDriver.pageContainer.materialPage.switchToPopup();
			SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
			
			//SharedDriver.pageContainer.materialApprovalPage.approvalBtnClick_Local();
			SharedDriver.pageContainer.materialApprovalPage.markViewsBtnClick_Local();
			SharedDriver.pageContainer.materialPage.clickOkToHandlePopup();
			SharedDriver.pageContainer.materialPage.rejectLDSBank();
			//SharedDriver.pageContainer.materialApprovalPage.submitRequestOkButtonClick();		
		}
	}
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Material_Global_LocalData_Submit_LDR(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException 
	{
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			SharedDriver.pageContainer.homePage.navigateToWorkflow();
			SharedDriver.pageContainer.materialPage.switchToPopup();
			SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));		
			SharedDriver.pageContainer.materialApprovalPage.approvalBtnClick_Local();
			SharedDriver.pageContainer.materialPage.duplicateCheckButton();
			SharedDriver.pageContainer.materialPage.duplicateCheck_New();
			SharedDriver.pageContainer.materialPage.submitGlobalRequestExtend();
			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
			Sync.waitForSeconds(Constants.WAIT_10);
			SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
			SharedDriver.pageContainer.materialPage.Localactionbutton();
			SharedDriver.pageContainer.materialNavPage.clickValidatLocalRequest();
			SharedDriver.pageContainer.materialNavPage.submitLocalRequest();
			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();

		}
		
	}
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Material_LocalData_Submit_LDR(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException 
	{
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			Assert.assertTrue(SharedDriver.pageContainer.homePage.navigateToWorkflow());
			SharedDriver.pageContainer.materialPage.switchToPopup();
			SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));		
			SharedDriver.pageContainer.materialApprovalPage.approvalBtnClick_Local();
			
			SharedDriver.pageContainer.materialNavPage.submitLocalRequest();
			SharedDriver.pageContainer.materialApprovalPage.submitRequestOkButtonClick();	
		}
	}
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Material_BankData_Submit_LDR(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException 
	{
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			Assert.assertTrue(SharedDriver.pageContainer.homePage.navigateToWorkflow());
			SharedDriver.pageContainer.materialPage.switchToPopup();
			SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
			
			SharedDriver.pageContainer.materialApprovalPage.approvalBtnClick_Local();
			//SharedDriver.pageContainer.vendorPage.clickLocalAction_Bank();
			SharedDriver.pageContainer.vendorPage.submitBankRequestTest1();
			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();	
		}
		
	}
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Material_LocalGlobal_Submit_LDR(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException 
	{
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			Assert.assertTrue(SharedDriver.pageContainer.homePage.navigateToWorkflow());
			SharedDriver.pageContainer.materialPage.switchToPopup();
			SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
			SharedDriver.pageContainer.materialApprovalPage.approvalBtnClick_Local();
			SharedDriver.pageContainer.materialPage.duplicateCheckButton();		
			SharedDriver.pageContainer.materialPage.clickDuplicateCheck_SAP();		
			SharedDriver.pageContainer.materialApprovalPage.submitRequestOkButtonClick();
	        SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
			SharedDriver.pageContainer.materialApprovalPage.approvalBtnClick_Local();
			SharedDriver.pageContainer.materialPage.submitGlobalandLocalRequestTest();
			SharedDriver.pageContainer.materialApprovalPage.submitRequestOkButtonClick();	
		}
	}
	

	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Process_Information_Check_Local_Reject_Status_LDS(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException 
	{
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			SharedDriver.pageContainer.processInfoPage.processInfoSearch();
			SharedDriver.pageContainer.processInfoPage.reqIdSearch_Local(dataMap.get("RequestId"));
			//SharedDriver.pageContainer.processInfoPage.getState_New(dataMap.get("RequestId"));
			SharedDriver.pageContainer.processInfoPage.validateGetTask_Status(dataMap.get("RequestId"));
			
			SharedDriver.pageContainer.processInfoPage.browserClose();			
		}

	}

	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Process_Information_Check_Local_Extension(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException 
	{
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			SharedDriver.pageContainer.processInfoPage.processInfoSearch();
			SharedDriver.pageContainer.processInfoPage.reqIdSearch_Local(dataMap.get("RequestId"));
			SharedDriver.pageContainer.processInfoPage.getState_New(dataMap.get("RequestId"));
			SharedDriver.pageContainer.processInfoPage.browserClose();	
		}
	}
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void validate_And_Submit_Global_Local_Request(Map<String,String> dataMap, ITestContext context) throws FileNotFoundException, InterruptedException, IOException
	{
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			SharedDriver.pageContainer.materialNavPage.switchToGlobal();
			//SharedDriver.pageContainer.materialPage.clickLocalAction();
			SharedDriver.pageContainer.materialPage.duplicateCheckButton();
			SharedDriver.pageContainer.materialPage.clickDuplicateCheck();
			//SharedDriver.pageContainer.materialPage.submitGlobalLocalRequest();
			//SharedDriver.pageContainer.materialPage.clickDuplicateCheck();
			SharedDriver.pageContainer.materialPage.getRequestId_CreateNew(suiteName);
			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
			Sync.waitForSeconds(Constants.WAIT_3);
		}
	
	}
	
	@Test(dataProvider = "CreateMaterial_Fill_In_Local", dataProviderClass = staticProviderClass.class)
	public void material_Local_Plant_Data_Fill_In_For_Change_Nav(Map<String, String> dataMap, ITestContext context) throws InterruptedException {
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			Sync.waitForSeconds(Constants.WAIT_10);
			Sync.waitForSeconds(Constants.WAIT_6);
			SharedDriver.pageContainer.materialNavPage.localAddInEditPlantNav();
			SharedDriver.pageContainer.materialNavPage.clickAndSelectPurchaseUOMValueDropDown(dataMap.get("Purch. Unit of Measure"));
			SharedDriver.pageContainer.materialNavPage.clickAndSelectProdUOMValueDropDown(dataMap.get("Production Unit of Measure"));
			SharedDriver.pageContainer.materialNavPage.clickAndSelectSalesUOMValueDropDown(dataMap.get("Sales Unit of Measure"));
			SharedDriver.pageContainer.materialNavPage.clickAndSelectRoundingPrecisionValueDropDown(dataMap.get("Rounding Precision"));
			SharedDriver.pageContainer.materialNavPage.clickAndSelectInventoryUOMValueDropDown(dataMap.get("Inventory Unit of Measure"));
			SharedDriver.pageContainer.materialNavPage.validateAndSaveLocalData();	
		}
	}
	
	@Test(dataProvider = "CreateMaterial_Fill_In_Local", dataProviderClass = staticProviderClass.class)
	public void material_Local_Finance_Data_Fill_In_For_Change_Nav(Map<String, String> dataMap, ITestContext context) throws InterruptedException {
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			SharedDriver.pageContainer.materialNavPage.localEditFinanceDataNav();
			SharedDriver.pageContainer.materialNavPage.clickAndSelectInventoryPostingGroupDropDown(dataMap.get("Inventory Posting Group"));
			//SharedDriver.pageContainer.materialNavPage.clickAndSelectWHTGroupDropDown(dataMap.get("WHTProduct Posting Group"));
			SharedDriver.pageContainer.materialNavPage.clickAndSelectGenProdPostingGroupDropDown(dataMap.get("Gen.Prod. Posting Group"));
			//SharedDriver.pageContainer.basePage.waitForPageLoad();
			//SharedDriver.pageContainer.materialNavPage.clickAndSelectVATPostingGroupDropDown(dataMap.get("VAT Prod. Posting Group"));
			SharedDriver.pageContainer.materialNavPage.validateAndSaveLocalData();
			// SharedDriver.pageContainer.materialNavPage	
		}
	}
	
	@Test
	public void material_Submit_Global_And_Local_Requests(ITestContext context) throws InterruptedException, FileNotFoundException, IOException
	{
		String suiteName = context.getSuite().getName();
		//String testCaseName = dataMap.get("Test_Case");
//		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
//		{
			SharedDriver.pageContainer.materialPage.validateTestCreate();
			SharedDriver.pageContainer.materialPage.submitLocalRequestTest();
			SharedDriver.pageContainer.materialPage.getRequestId_CreateNew(suiteName);
			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
			SharedDriver.pageContainer.materialPage.duplicateCheckButton();
			SharedDriver.pageContainer.materialPage.clickDuplicateCheck();
			SharedDriver.pageContainer.materialPage.submitGlobalRequest();
			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();			
	}
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Create_Material_Rejections_with_Discard_Change_Nav(Map<String, String> dataMap, ITestContext context)
			throws InterruptedException, FileNotFoundException, IOException {
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			try {
				System.out.println("Start:Create_Material_Rejections_with_Discard");

				SharedDriver.pageContainer.homePage.navigateToWorkflow();
				SharedDriver.pageContainer.materialPage.switchToPopup();
				SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
				System.out.println("search task opened");
				SharedDriver.pageContainer.materialPage.clickLocalAction();
				//SharedDriver.pageContainer.materialNavPage.switchToGlobal();
				SharedDriver.pageContainer.materialPage.DiscardCreateLocal();
				SharedDriver.pageContainer.materialPage.DiscardCreateGDA();

				System.out.println("Create_Material_Rejections_with_Discard-Done");

			} catch (Exception e) {

				System.out.println("Create_Material_Rejections_with_Discard is not completed");
				driver.close();
			}	
		}
		
	}
	
	@Test(dataProvider = "Process_Information_Check", dataProviderClass = staticProviderClass.class)
	public void happy_Flag_Deletion_Nav(Map<String, String> dataMap, ITestContext context)
			throws InterruptedException, FileNotFoundException, IOException, AWTException {
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			SharedDriver.pageContainer.homePage.navigateToWorkflow();
			SharedDriver.pageContainer.materialPage.switchToPopup();
			SharedDriver.pageContainer.materialPage.navigateToDashboard();
			SharedDriver.pageContainer.materialPage.advancedSearch();
			SharedDriver.pageContainer.materialPage.scrolltoGlobalSearch();
			// SharedDriver.pageContainer.materialPage.getCurrDate();
			SharedDriver.pageContainer.materialPage.globalSearch(dependentGlobalId);
			SharedDriver.pageContainer.materialPage.clickFullMaterialData();
			SharedDriver.pageContainer.materialPage.clickflagDeletion();
			SharedDriver.pageContainer.materialPage.clickOkToHandlePopup();
			SharedDriver.pageContainer.materialPage.clickLocalAction();
			SharedDriver.pageContainer.materialPage.clickFlagForDeletion();
			SharedDriver.pageContainer.materialPage.getRequestId_CreateNew(suiteName);
			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();	
		}
	}
	
	@Test(dataProvider = "Process_Information_Check", dataProviderClass = staticProviderClass.class)
	public void material_Flag_For_Deletion_Syndication_Check_GlobalId(Map<String, String> dataMap, ITestContext context)
			throws InterruptedException, FileNotFoundException, IOException {
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			SharedDriver.pageContainer.materialPage.navigateToDashboard();
			SharedDriver.pageContainer.materialPage.advancedSearch();
			SharedDriver.pageContainer.materialPage.scrolltoGlobalSearch();
			SharedDriver.pageContainer.materialPage.globalSearch(dependentGlobalId);
			
			SharedDriver.pageContainer.materialPage.checkFFDLock();
			// SharedDriver.pageContainer.materialPage.getGlobalId();
			// SharedDriver.pageContainer.materialPage.clickFullMaterialData();
			// SharedDriver.pageContainer.materialPage.getMaterial_Number();
			SharedDriver.pageContainer.processInfoPage.browserClose();
			// SharedDriver.pageContainer.materialApprovalPage.launchUFT();			
		}

	}
}
