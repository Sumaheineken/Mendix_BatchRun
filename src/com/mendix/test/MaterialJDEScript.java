package com.mendix.test;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.mendix.tool.Constants;
import com.mendix.tool.SharedDriver;
import com.mendix.tool.Sync;
import com.mendix.util.DataProviderUtil.staticProviderClass;

import sun.text.normalizer.Trie.DataManipulate;



public class MaterialJDEScript extends BaseScript{

	WebDriver driver;

	/**
	 * Create Material with Nav.
	 * @throws AWTException 
	 */

	@Test(dataProvider="CreateMaterial_Fill_In",dataProviderClass=staticProviderClass.class)
	public void Material_Create_Fill_In_Data(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException 
	{
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
			SharedDriver.pageContainer.materialPage.validateTestCreate();
//			SharedDriver.pageContainer.materialNavPage.clickLocalAction();	
		}

	}
	@Test(dataProvider="CreateMaterial_Fill_In",dataProviderClass=staticProviderClass.class)
	public void Material_Create_Fill_In_Data_JDE_Planning(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			SharedDriver.pageContainer.materialNavPage.enterLocalData();
//			SharedDriver.pageContainer.materialJdePage.clickAddPlantData();
			SharedDriver.pageContainer.materialJdePage.enterPlantData(dataMap.get("Plant"));
			SharedDriver.pageContainer.materialJdePage.editPlantPlaning();
			SharedDriver.pageContainer.materialJdePage.selectStockingTypeLocal(dataMap.get("Stocking Type Global"));
			SharedDriver.pageContainer.materialJdePage.selectCommitmentDateMethod(dataMap.get("Commitment Method"));
			SharedDriver.pageContainer.materialJdePage.selectLotCalculationAlgorithm(dataMap.get("Lot Calculation Algorithm"));
			SharedDriver.pageContainer.materialJdePage.selectLotProcessType(dataMap.get("Lot Process Type"));
			SharedDriver.pageContainer.materialJdePage.selectLotExpiratonDateCalculationMethod(dataMap.get("Lot Expiration Date Cal Method"));
			SharedDriver.pageContainer.materialJdePage.selectMasterPlanningFamily(dataMap.get("Master Planning Family"));
			SharedDriver.pageContainer.materialJdePage.selectPlanningCode(dataMap.get("Planning Code"));
			SharedDriver.pageContainer.materialNavPage.clickLocalAction();
			SharedDriver.pageContainer.materialNavPage.clickValidatLocalData();
			SharedDriver.pageContainer.materialNavPage.clickPlanningSaveButton();	
		}
	}
	
	@Test(dataProvider="CreateMaterial_Fill_In",dataProviderClass=staticProviderClass.class)
	public void Material_Create_Fill_In_Data_JDE_Edit_Planning(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			SharedDriver.pageContainer.materialNavPage.enterLocalData();
//			SharedDriver.pageContainer.materialJdePage.clickAddPlantData();		
			SharedDriver.pageContainer.materialJdePage.editPlantPlaning();
			SharedDriver.pageContainer.materialJdePage.selectStockingTypeLocal(dataMap.get("Stocking Type Global"));
			SharedDriver.pageContainer.materialJdePage.selectCommitmentDateMethod(dataMap.get("Commitment Method"));
			SharedDriver.pageContainer.materialJdePage.selectLotCalculationAlgorithm(dataMap.get("Lot Calculation Algorithm"));
			SharedDriver.pageContainer.materialJdePage.selectLotProcessType(dataMap.get("Lot Process Type"));
			SharedDriver.pageContainer.materialJdePage.selectLotExpiratonDateCalculationMethod(dataMap.get("Lot Expiration Date Cal Method"));
			SharedDriver.pageContainer.materialJdePage.selectMasterPlanningFamily(dataMap.get("Master Planning Family"));
			SharedDriver.pageContainer.materialJdePage.selectPlanningCode(dataMap.get("Planning Code"));
			SharedDriver.pageContainer.materialNavPage.clickLocalAction();
			SharedDriver.pageContainer.materialNavPage.clickValidatLocalData();
			SharedDriver.pageContainer.materialNavPage.clickPlanningSaveButton();	
		}
	}
	
	@Test(dataProvider="CreateMaterial_Fill_In",dataProviderClass=staticProviderClass.class)
	public void Material_Create_Fill_In_Data_JDE_Finance(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			SharedDriver.pageContainer.materialJdePage.clickFinancetab();
			SharedDriver.pageContainer.materialJdePage.editPlantFinance();
			/*SharedDriver.pageContainer.materialApprovalPage.submitRequestOkBtnClick();
			SharedDriver.pageContainer.materialPage.clickLocalAction();
			SharedDriver.pageContainer.materialJdePage.clickBackAction();
			SharedDriver.pageContainer.materialJdePage.clickProceedAction();
			SharedDriver.pageContainer.materialJdePage.clickPlantData();*/
//			SharedDriver.pageContainer.materialNavPage.clickEditFinanceData();
			
		/*	SharedDriver.pageContainer.materialNavPage.clickEditFinanceData();*/
			SharedDriver.pageContainer.materialJdePage.selectGLClass();
			SharedDriver.pageContainer.materialJdePage.selectingCostingMethodPurchasing(dataMap.get("Costing Method - Purchasing"));
			SharedDriver.pageContainer.materialJdePage.selectingCostingMethodSales(dataMap.get("Costing Method - Sales"));
			/*SharedDriver.pageContainer.materialNavPage.selectGenProdPostingGroup();
			SharedDriver.pageContainer.materialNavPage.selectVATPostingGroup();
			SharedDriver.pageContainer.materialNavPage.selectItemDepositGroupCode();*/
			SharedDriver.pageContainer.materialNavPage.clickLocalAction();
			SharedDriver.pageContainer.materialNavPage.clickValidatLocalData();
			SharedDriver.pageContainer.materialNavPage.clickSaveButton();
			SharedDriver.pageContainer.materialNavPage.clickLocalAction();
			SharedDriver.pageContainer.materialNavPage.clickValidatLocalRequest();
			SharedDriver.pageContainer.materialNavPage.enterGlobalData();		
			SharedDriver.pageContainer.materialPage.duplicateCheckButton();
			SharedDriver.pageContainer.materialPage.clickDuplicateCheck();
			SharedDriver.pageContainer.materialPage.submitGlobalandLocalRequestTest();
			SharedDriver.pageContainer.materialPage.getRequestId_CreateNew(suiteName);
			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();			
		}

	}
	
	@Test(dataProvider="CreateMaterial_Fill_In",dataProviderClass=staticProviderClass.class)
	public void Material_Create_Fill_In_Data_JDE_Edit_Finance(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			SharedDriver.pageContainer.materialJdePage.clickFinancetab();
			SharedDriver.pageContainer.materialJdePage.editPlantFinance();
			/*SharedDriver.pageContainer.materialApprovalPage.submitRequestOkBtnClick();
			SharedDriver.pageContainer.materialPage.clickLocalAction();
			SharedDriver.pageContainer.materialJdePage.clickBackAction();
			SharedDriver.pageContainer.materialJdePage.clickProceedAction();
			SharedDriver.pageContainer.materialJdePage.clickPlantData();*/
//			SharedDriver.pageContainer.materialNavPage.clickEditFinanceData();
			
		/*	SharedDriver.pageContainer.materialNavPage.clickEditFinanceData();*/
			SharedDriver.pageContainer.materialJdePage.selectGLClass();			
			SharedDriver.pageContainer.materialNavPage.clickLocalAction();
			SharedDriver.pageContainer.materialNavPage.clickValidatLocalData();
			SharedDriver.pageContainer.materialNavPage.clickSaveButton();
			SharedDriver.pageContainer.materialNavPage.clickLocalAction();
			SharedDriver.pageContainer.materialNavPage.clickValidatLocalRequest();
			SharedDriver.pageContainer.materialPage.submitLocalRequestTest();				
//			SharedDriver.pageContainer.materialPage.getRequestId();
			SharedDriver.pageContainer.materialPage.getRequestId_CreateNew(suiteName);		
			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();	
			SharedDriver.pageContainer.materialPage.validate();
			SharedDriver.pageContainer.materialPage.duplicateCheckButton();
			SharedDriver.pageContainer.materialPage.clickDuplicateCheck();
			SharedDriver.pageContainer.materialPage.submitGlobalRequestExtend();
			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
	
		}
	}


	@Test(dataProvider="CreateMaterial_Fill_In",dataProviderClass=staticProviderClass.class)
	public void Material_Create_Fill_In_Data_JDE_Site(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
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
	
		}
	}
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Process_Information_Check_Global(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException 
	{
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			SharedDriver.pageContainer.processInfoPage.processInfoSearch();
			SharedDriver.pageContainer.processInfoPage.reqIdSearch_Global(dataMap.get("RequestId"));
			SharedDriver.pageContainer.processInfoPage.getState(dataMap.get("RequestId"));
			SharedDriver.pageContainer.processInfoPage.browserClose();
		}
	}

	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Process_Information_Check_Local(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException 
	{
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			SharedDriver.pageContainer.processInfoPage.processInfoSearch();
			SharedDriver.pageContainer.processInfoPage.reqIdSearch_Local(dataMap.get("RequestId"));
			SharedDriver.pageContainer.processInfoPage.getState(dataMap.get("RequestId"));
			SharedDriver.pageContainer.processInfoPage.browserClose();

		}
	}

	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Material_Create_Review_Global_Data_Approve_LDS(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException 
	{
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			Assert.assertTrue(SharedDriver.pageContainer.homePage.navigateToWorkflow());
			SharedDriver.pageContainer.materialPage.switchToPopup();
			SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
			SharedDriver.pageContainer.materialApprovalPage.approvalBtnClick_Local();
			SharedDriver.pageContainer.materialApprovalPage.submitRequestOkBtnClick();
	
		}
	}

	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Material_Create_Review_Global_Data_Approve_LBDA(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException 
	{
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			Assert.assertTrue(SharedDriver.pageContainer.homePage.navigateToWorkflow());
			SharedDriver.pageContainer.materialPage.switchToPopup();
			SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
			SharedDriver.pageContainer.materialApprovalPage.approvalBtnClick_Local();
			SharedDriver.pageContainer.materialApprovalPage.submitRequestOkBtnClick();	
		}
	}

	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Material_Create_Review_Global_Data_Approve_GDA(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException 
	{
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

	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Material_Create_Syndication_Check (Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException 
	{
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
//			SharedDriver.pageContainer.materialPage.clickFullMaterialData();
//			SharedDriver.pageContainer.materialPage.getMaterial_Number();
			SharedDriver.pageContainer.processInfoPage.browserClose();	
//			SharedDriver.pageContainer.materialApprovalPage.launchUFT();

		}
	}

	@Test
	public void Material_Create_Validate_Submit_Check(ITestContext context) throws InterruptedException, FileNotFoundException, IOException 
	{
		String suiteName = context.getSuite().getName();
		SharedDriver.pageContainer.materialPage.clickLocalAction();
		SharedDriver.pageContainer.materialPage.validateTestCreate();
		SharedDriver.pageContainer.materialPage.submitGlobalRequestTest();
		SharedDriver.pageContainer.materialPage.getRequestId_Create(suiteName);
		// SharedDriver.pageContainer.materialPage.getRequestId();
		SharedDriver.pageContainer.materialApprovalPage.submitRequestOkBtnClick();

	}

	@Test
	public void Material_Create_Jde_Validate_Submit_Check(ITestContext context) throws InterruptedException, FileNotFoundException, IOException 
	{
		String suiteName = context.getSuite().getName();
		SharedDriver.pageContainer.materialPage.clickLocalAction();
		SharedDriver.pageContainer.materialPage.validateTestCreateLocal();
//		SharedDriver.pageContainer.materialPage.clickLocalAction();
//		SharedDriver.pageContainer.materialPage.clickLocalAction();
		SharedDriver.pageContainer.materialPage.submitBtnClick_Local();
//		SharedDriver.pageContainer.materialPage.getRequestId_Create_Local();
		SharedDriver.pageContainer.materialApprovalPage.duplicateCheck();
		SharedDriver.pageContainer.materialPage.getRequestId_Create(suiteName);
		SharedDriver.pageContainer.materialApprovalPage.okbuttonClick();
//		SharedDriver.pageContainer.materialApprovalPage.submitRequestOkBtnClick();

	}
	@Test
	public void Material_Remove_Plant_Validate_LocalData_JDE(ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		String suiteName = context.getSuite().getName();
		SharedDriver.pageContainer.materialNavPage.enterLocalData();
		SharedDriver.pageContainer.materialJdePage.clickAddPlantData();
		//SharedDriver.pageContainer.materialJdePage.SelectingPlant();
		//SharedDriver.pageContainer.materialJdePage.RemovePlant();
		//SharedDriver.pageContainer.materialNavPage.clickLocalAction();
		SharedDriver.pageContainer.materialNavPage.clickValidatLocalRequest();
		SharedDriver.pageContainer.materialNavPage.submitGlobalLocalRequestTest();
		SharedDriver.pageContainer.materialPage.getRequestId_CreateNew(suiteName);
		SharedDriver.pageContainer.materialApprovalPage.submitRequestOkButtonClick();
		
	}

	@Test(dataProvider="CreateMaterial_Fill_In",dataProviderClass=staticProviderClass.class)
	public void Material_Validate_LocalData_JDE(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			SharedDriver.pageContainer.materialNavPage.enterLocalData();
//			SharedDriver.pageContainer.materialJdePage.clickAddPlantData();
			SharedDriver.pageContainer.materialJdePage.editPlantPlaning();
			SharedDriver.pageContainer.materialJdePage.selectStockingTypeLocal(dataMap.get("Stocking Type Global"));
			SharedDriver.pageContainer.materialJdePage.selectCommitmentDateMethod(dataMap.get("Commitment Method"));
			SharedDriver.pageContainer.materialJdePage.selectLotCalculationAlgorithm(dataMap.get("Lot Calculation Algorithm"));
			SharedDriver.pageContainer.materialJdePage.selectLotProcessType(dataMap.get("Lot Process Type"));
			SharedDriver.pageContainer.materialJdePage.selectLotExpiratonDateCalculationMethod(dataMap.get("Lot Expiration Date Cal Method"));
			SharedDriver.pageContainer.materialJdePage.selectMasterPlanningFamily(dataMap.get("Master Planning Family"));
			SharedDriver.pageContainer.materialJdePage.selectPlanningCode(dataMap.get("Planning Code"));
		    SharedDriver.pageContainer.materialNavPage.clickLocalAction();
			SharedDriver.pageContainer.materialNavPage.clickValidateLocalData_Planning();
			SharedDriver.pageContainer.materialNavPage.clickSaveButton();
			/********************Edit Finance Data************************************************/
			SharedDriver.pageContainer.materialJdePage.clickFinancetab();
			SharedDriver.pageContainer.materialJdePage.editPlantFinance();
			SharedDriver.pageContainer.materialJdePage.selectGLClass();
			SharedDriver.pageContainer.materialJdePage.selectCostingMethodPurchasing(dataMap.get("Costing Method - Purchasing"));
			SharedDriver.pageContainer.materialJdePage.selectCostingMethodSales(dataMap.get("Costing Method - Sales"));
			SharedDriver.pageContainer.materialNavPage.clickLocalAction();
			SharedDriver.pageContainer.materialNavPage.clickValidateLocalData_Planning();
			SharedDriver.pageContainer.materialNavPage.clickSaveButton();
			SharedDriver.pageContainer.materialNavPage.clickLocalAction();
			SharedDriver.pageContainer.materialNavPage.clickValidatLocalRequest();
			SharedDriver.pageContainer.materialNavPage.enterGlobalData();
			SharedDriver.pageContainer.materialPage.duplicateCheckButton();
			SharedDriver.pageContainer.materialPage.duplicateCheck_New();		
			//SharedDriver.pageContainer.materialNavPage.submitGlobalLocalRequestTest();
			SharedDriver.pageContainer.materialPage.getRequestId_CreateNew(suiteName);
			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();			
		}

		
	}	
	
	@Test(dataProvider="CreateMaterial_Fill_In",dataProviderClass=staticProviderClass.class)
	public void Material_JDE_Save_As_Draft(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException
	{
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			SharedDriver.pageContainer.materialNavPage.enterLocalData();
//			SharedDriver.pageContainer.materialJdePage.clickAddPlantData();
			SharedDriver.pageContainer.materialJdePage.editPlantPlaning();
			SharedDriver.pageContainer.materialJdePage.selectStockingTypeLocal(dataMap.get("Stocking Type Global"));
			SharedDriver.pageContainer.materialJdePage.selectCommitmentDateMethod(dataMap.get("Commitment Method"));
			SharedDriver.pageContainer.materialJdePage.selectLotCalculationAlgorithm(dataMap.get("Lot Calculation Algorithm"));
			SharedDriver.pageContainer.materialJdePage.selectLotProcessType(dataMap.get("Lot Process Type"));
			SharedDriver.pageContainer.materialJdePage.selectLotExpiratonDateCalculationMethod(dataMap.get("Lot Expiration Date Cal Method"));
			SharedDriver.pageContainer.materialJdePage.selectMasterPlanningFamily(dataMap.get("Master Planning Family"));
			SharedDriver.pageContainer.materialJdePage.selectPlanningCode(dataMap.get("Planning Code"));		
			SharedDriver.pageContainer.materialNavPage.clickLocalAction();
			SharedDriver.pageContainer.materialNavPage.clickValidateLocalData_Planning();
			SharedDriver.pageContainer.materialNavPage.clickSaveButton();
			/********************Edit Finance Data************************************************/
			SharedDriver.pageContainer.materialJdePage.clickFinancetab();
			SharedDriver.pageContainer.materialJdePage.editPlantFinance();
			SharedDriver.pageContainer.materialJdePage.selectGLClass();
			SharedDriver.pageContainer.materialJdePage.selectCostingMethodPurchasing(dataMap.get("Costing Method - Purchasing"));
			SharedDriver.pageContainer.materialJdePage.selectCostingMethodSales(dataMap.get("Costing Method - Sales"));
			SharedDriver.pageContainer.materialNavPage.clickLocalAction();
			SharedDriver.pageContainer.materialNavPage.clickValidateLocalData_Planning();
			SharedDriver.pageContainer.materialNavPage.clickSaveButton();
			SharedDriver.pageContainer.materialNavPage.clickLocalAction();
			SharedDriver.pageContainer.materialNavPage.clickValidatLocalRequest();
			
			
			/************************validate and Save As Draft**************************************/
			SharedDriver.pageContainer.materialNavPage.enterGlobalData();						
			SharedDriver.pageContainer.materialPage.SaveAsDraft();
		    SharedDriver.pageContainer.materialPage.getRequestId_draft(suiteName);		
			SharedDriver.pageContainer.materialApprovalPage.submitRequestOkButtonClick();			
		}
		
	}
	@Test(dataProvider="CreateMaterial_Fill_In",dataProviderClass=staticProviderClass.class)
	public void Material_Create_Fill_In_Data_JDE_Planning_Extend(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			//SharedDriver.pageContainer.materialNavPage.enterLocalData();
//			SharedDriver.pageContainer.materialJdePage.clickAddPlantData();
			SharedDriver.pageContainer.materialJdePage.enterPlantData(dataMap.get("Plant"));
//			SharedDriver.pageContainer.materialJdePage.enterPlantDataJDE();
			//SharedDriver.pageContainer.materialJdePage.SelectPlant();
			SharedDriver.pageContainer.materialJdePage.clickEditPlanningData_Extend();		
			SharedDriver.pageContainer.materialJdePage.selectStockingTypeLocal(dataMap.get("Stocking Type Global"));
			SharedDriver.pageContainer.materialJdePage.selectCommitmentDateMethod(dataMap.get("Commitment Method"));
			SharedDriver.pageContainer.materialJdePage.selectLotCalculationAlgorithm(dataMap.get("Lot Calculation Algorithm"));
			SharedDriver.pageContainer.materialJdePage.selectLotProcessType(dataMap.get("Lot Process Type"));
			SharedDriver.pageContainer.materialJdePage.selectLotExpiratonDateCalculationMethod(dataMap.get("Lot Expiration Date Cal Method"));
			SharedDriver.pageContainer.materialJdePage.selectMasterPlanningFamily(dataMap.get("Master Planning Family"));
			SharedDriver.pageContainer.materialJdePage.selectPlanningCode(dataMap.get("Planning Code"));		
			SharedDriver.pageContainer.materialNavPage.clickLocalAction();
			SharedDriver.pageContainer.materialNavPage.clickValidateLocalData_Planning();
			SharedDriver.pageContainer.materialNavPage.clickSaveButton();
			
		}
	}
	@Test(dataProvider="CreateMaterial_Fill_In",dataProviderClass=staticProviderClass.class)
	public void Material_Create_Fill_In_Data_JDE_Finance_Extend(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			SharedDriver.pageContainer.materialJdePage.clickFinancetabJDE();
			SharedDriver.pageContainer.materialNavPage.clickEditFinanceDataJDE_Extend();
			/*SharedDriver.pageContainer.materialApprovalPage.submitRequestOkBtnClick();
			SharedDriver.pageContainer.materialPage.clickLocalAction();
			SharedDriver.pageContainer.materialJdePage.clickBackAction();
			SharedDriver.pageContainer.materialJdePage.clickProceedAction();
			SharedDriver.pageContainer.materialJdePage.clickPlantData();*/
//			SharedDriver.pageContainer.materialNavPage.clickEditFinanceData();
			
		/*	SharedDriver.pageContainer.materialNavPage.clickEditFinanceData();*/
			SharedDriver.pageContainer.materialJdePage.selectGLClass();
			SharedDriver.pageContainer.materialJdePage.selectCostingMethodPurchasing(dataMap.get("Costing Method - Purchasing"));
			SharedDriver.pageContainer.materialJdePage.selectCostingMethodSales(dataMap.get("Costing Method - Sales"));
			SharedDriver.pageContainer.materialNavPage.clickLocalAction();
			SharedDriver.pageContainer.materialNavPage.clickValidatLocalData();
			SharedDriver.pageContainer.materialNavPage.clickSaveButton();
			SharedDriver.pageContainer.materialNavPage.clickLocalAction();
			SharedDriver.pageContainer.materialNavPage.clickValidatLocalRequest();
			/*SharedDriver.pageContainer.materialNavPage.selectGenProdPostingGroup();
			SharedDriver.pageContainer.materialNavPage.selectVATPostingGroup();
			SharedDriver.pageContainer.materialNavPage.selectItemDepositGroupCode();*/
			
			Sync.waitForSeconds(Constants.WAIT_6);
			System.out.println("Clicked Validate Local request");
	/*		SharedDriver.pageContainer.materialNavPage.clickGlobalDataButton();
		    //	SharedDriver.pageContainer.materialPage.clickLocalAction();
		    SharedDriver.pageContainer.material_Change_Page.clickConfirmExtension();
		    SharedDriver.pageContainer.materialPage.getRequestId_CreateNew();
			SharedDriver.pageContainer.materialApprovalPage.submitRequestOkButtonClick();*/
			/*SharedDriver.pageContainer.materialNavPage.submitGlobalLocalRequestTest();
			SharedDriver.pageContainer.materialPage.clickDuplicateCheck_GlobalLocal();
		
			SharedDriver.pageContainer.materialPage.getRequestId_CreateNew();
			SharedDriver.pageContainer.materialApprovalPage.submitRequestOkButtonClick();*/			
		}

	}
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void material_Data_Extend_JDE(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException
	{
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			SharedDriver.pageContainer.homePage.navigateToWorkflow();
			SharedDriver.pageContainer.materialPage.switchToPopup();
			SharedDriver.pageContainer.materialPage.navigateToDashboard();
			SharedDriver.pageContainer.materialPage.advancedSearch();
			SharedDriver.pageContainer.materialPage.scrolltoGlobalSearch();
			SharedDriver.pageContainer.materialPage.globalSearch(dependentGlobalId);
			SharedDriver.pageContainer.materialPage.clickFullMaterialDataNew();
			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
			SharedDriver.pageContainer.material_Change_Page.clickExtendbutton();
			Sync.waitForSeconds(Constants.WAIT_3);
	
		}		
	}
	
	@Test(dataProvider="CreateMaterial_Fill_In",dataProviderClass=staticProviderClass.class)
	public void material_Create_Fill_In_Data_JDE_Finance_Extend_Nav(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			SharedDriver.pageContainer.materialJdePage.clickFinancetab();
			SharedDriver.pageContainer.materialJdePage.editPlantFinance();
		
			SharedDriver.pageContainer.materialJdePage.selectGLClass();
			SharedDriver.pageContainer.materialJdePage.selectingCostingMethodPurchasing(dataMap.get("Costing Method - Purchasing"));
			SharedDriver.pageContainer.materialJdePage.selectingCostingMethodSales(dataMap.get("Costing Method - Sales"));
			/*SharedDriver.pageContainer.materialNavPage.selectGenProdPostingGroup();
			SharedDriver.pageContainer.materialNavPage.selectVATPostingGroup();
			SharedDriver.pageContainer.materialNavPage.selectItemDepositGroupCode();*/
			SharedDriver.pageContainer.materialNavPage.clickLocalAction();
			SharedDriver.pageContainer.materialNavPage.clickValidatLocalData();
			SharedDriver.pageContainer.materialNavPage.clickSaveButton();
			SharedDriver.pageContainer.materialNavPage.clickLocalAction();
			SharedDriver.pageContainer.materialNavPage.clickValidatLocalRequest();
//			SharedDriver.pageContainer.materialNavPage.enterGlobalData();		
//			SharedDriver.pageContainer.materialPage.duplicateCheckButton();
//			SharedDriver.pageContainer.materialPage.clickDuplicateCheck();
//			SharedDriver.pageContainer.materialPage.submitGlobalandLocalRequestTest();
//			SharedDriver.pageContainer.materialPage.getRequestId_CreateNew();
//			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();	
		}
	}
	
	@Test
	public void confirmExtensionJDE(ITestContext context) throws InterruptedException, FileNotFoundException, IOException
	{
		//SharedDriver.pageContainer.material_Change_Page.clickExtendbutton();
		String suiteName = context.getSuite().getName();
		Sync.waitForSeconds(Constants.WAIT_10);
		System.out.println("Global Data Tab");
		
		SharedDriver.pageContainer.materialNavPage.switchToGlobal();
       SharedDriver.pageContainer.material_Change_Page.clickConfirmExtension();
       SharedDriver.pageContainer.materialPage.getRequestId_CreateNew(suiteName);
	   SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
	}
}

