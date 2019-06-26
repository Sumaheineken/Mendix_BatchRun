package com.mendix.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.mendix.tool.Constants;
import com.mendix.tool.SharedDriver;
import com.mendix.tool.Sync;
import com.mendix.util.DataProviderUtil.staticProviderClass;

public class MaterialChangeScript extends BaseScript
{

	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Material_Change_Syndication_Check (Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException 
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
//			SharedDriver.pageContainer.materialPage.getCurrDate();

			SharedDriver.pageContainer.materialPage.globalSearch(dependentGlobalId);			

			SharedDriver.pageContainer.materialPage.clickFullMaterialData();
			//SharedDriver.pageContainer.materialApprovalPage.submitRequestOkBtnClick();
			SharedDriver.pageContainer.material_Change_Page.clickEditCheckBox();
			SharedDriver.pageContainer.material_Change_Page.clickEditbutton();	
		}
	}
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Material_Change_Syndication_Check_JDE(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException 
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
//			SharedDriver.pageContainer.materialPage.getCurrDate();

			SharedDriver.pageContainer.materialPage.globalSearch(dependentGlobalId);
			//Thread.sleep(20000);

			SharedDriver.pageContainer.materialPage.clickFullMaterialData();
			//SharedDriver.pageContainer.materialApprovalPage.submitRequestOkBtnClick();
			SharedDriver.pageContainer.material_Change_Page.clickEditCheckBox();
			SharedDriver.pageContainer.material_Change_Page.clickEditCheckBoxForLocal();
			SharedDriver.pageContainer.material_Change_Page.clickEditbutton();	
		}
	}
	
	
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void material_Change_Syndication_Check_Global_Local_Nav(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException 
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
//			SharedDriver.pageContainer.materialPage.getCurrDate();
			SharedDriver.pageContainer.materialPage.globalSearch(dependentGlobalId);
			SharedDriver.pageContainer.materialPage.clickFullMaterialData();
			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
			//SharedDriver.pageContainer.materialApprovalPage.submitRequestOkBtnClick();
			SharedDriver.pageContainer.material_Change_Page.clickEditCheckBox();
			SharedDriver.pageContainer.material_Change_Page.clickEditCheckBoxForLocal();
			SharedDriver.pageContainer.material_Change_Page.clickEditbutton();
		}

	}


	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Material_Extend (Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException 
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
			SharedDriver.pageContainer.material_Change_Page.clickFullMaterialDataNew();
			//SharedDriver.pageContainer.materialPage.clickOkToHandlePopup();
			//SharedDriver.pageContainer.materialApprovalPage.submitRequestOkBtnClick();
				
		}
	}	
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Material_Create_With_Ref (Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException 
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
	    	//SharedDriver.pageContainer.materialPage.getCurrDate();
			SharedDriver.pageContainer.materialPage.globalSearch(dependentGlobalId);
		    //SharedDriver.pageContainer.materialPage.getGlobalId();
			//SharedDriver.pageContainer.materialPage.clickFullMaterialDataNew();
			SharedDriver.pageContainer.materialPage.clickFullMaterialData();
			//SharedDriver.pageContainer.materialApprovalPage.submitRequestOkBtnClick();
	        Sync.waitForSeconds(Constants.WAIT_5);
			SharedDriver.pageContainer.material_Change_Page.clickReferencebutton();
			SharedDriver.pageContainer.materialPage.clickCreateRequestPopup();
			SharedDriver.pageContainer.materialPage.clickCreateRequestButton();
		}

	}
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Material_Create_With_Ref_Multiple_Plants (Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException 
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
	    	//SharedDriver.pageContainer.materialPage.getCurrDate();
			SharedDriver.pageContainer.materialPage.globalSearch(dependentGlobalId);
		    //SharedDriver.pageContainer.materialPage.getGlobalId();
			//SharedDriver.pageContainer.materialPage.clickFullMaterialDataNew();
			SharedDriver.pageContainer.materialPage.clickFullMaterialData();
			//SharedDriver.pageContainer.materialApprovalPage.submitRequestOkBtnClick();
	        Sync.waitForSeconds(Constants.WAIT_5);
			SharedDriver.pageContainer.material_Change_Page.clickReferencebutton();
			SharedDriver.pageContainer.materialPage.clickCreateRequestSelectAllPopup();
			SharedDriver.pageContainer.materialPage.clickCreateRequestButton();

		}
	}
	
	@Test(dataProvider="CreateMaterial_Fill_In",dataProviderClass=staticProviderClass.class)
	public void Material_Edit_Desc(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException
	{   
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			Sync.waitForSeconds(Constants.WAIT_10);
			SharedDriver.pageContainer.materialPage.materialDescCreate(dataMap.get("Description"));
			
		    // SharedDriver.pageContainer.materialPage.clickLocalAction();
		   SharedDriver.pageContainer.materialPage.validateTestCreate();
		       
		   SharedDriver.pageContainer.materialPage.SaveAsDraft();
		   SharedDriver.pageContainer.materialPage.getRequestId_draft(suiteName);
		   SharedDriver.pageContainer.materialApprovalPage.submitRequestOkBtnClick();
		}
	   
	}
	
	
	@Test(dataProvider="CreateMaterial_Fill_In",dataProviderClass=staticProviderClass.class)
	public void Material_Edit_Desc_JDE(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException
	{   
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			Sync.waitForSeconds(Constants.WAIT_3);
			SharedDriver.pageContainer.materialPage.materialDescCreate(dataMap.get("Description"));
			SharedDriver.pageContainer.materialPage.materialGrpSelectionTest(dataMap.get("Material Group"));
			SharedDriver.pageContainer.materialPage.grossWeightEntestTest(dataMap.get("Gross Weight Base UoM"));
			SharedDriver.pageContainer.materialPage.unitOfWeightSelectionTest(dataMap.get("Unit of Weight"));
			SharedDriver.pageContainer.materialPage.baseUOMSelectionTest(dataMap.get("Base UoM"));
			SharedDriver.pageContainer.materialPage.netWeightEnterTest(dataMap.get("Net Weight Base UoM"));
			SharedDriver.pageContainer.materialPage.uomPrimarySelectionTest();	          
	        SharedDriver.pageContainer.materialPage.validateTestCreate();     
	
		}
	   
	}
	@Test(dataProvider="CreateMaterial_Fill_In",dataProviderClass=staticProviderClass.class)
	public void Material_Edit_Desc_JDE_Multiple_Plants(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException
	{   
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			Sync.waitForSeconds(Constants.WAIT_3);
			SharedDriver.pageContainer.materialPage.materialDescCreate(dataMap.get("Description"));
			SharedDriver.pageContainer.materialPage.grossWeightEntestTest(dataMap.get("Gross Weight Base UoM"));
			SharedDriver.pageContainer.materialPage.unitOfWeightSelectionTest(dataMap.get("Unit of Weight"));
			SharedDriver.pageContainer.materialPage.baseUOMSelectionTest(dataMap.get("Base UoM"));
			SharedDriver.pageContainer.materialPage.netWeightEnterTest(dataMap.get("Net Weight Base UoM"));
			SharedDriver.pageContainer.materialPage.uomPrimarySelectionTest();	
	        SharedDriver.pageContainer.materialPage.validateTestCreate();  

		}
	   
	}
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Material_Delete_Record (Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException 
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
	    	//SharedDriver.pageContainer.materialPage.getCurrDate();
			SharedDriver.pageContainer.materialPage.globalSearch(dependentGlobalId);
			//		SharedDriver.pageContainer.materialPage.getGlobalId();
			SharedDriver.pageContainer.materialPage.clickFullMaterialData();
			//SharedDriver.pageContainer.materialApprovalPage.submitRequestOkBtnClick();
			//SharedDriver.pageContainer.materialApprovalPage.submitRequestOkBtnClick();
			
			
			SharedDriver.pageContainer.material_Change_Page.clickFlagForDeletionButton();
			
		
			SharedDriver.pageContainer.materialPage.clickLocalAction();
			SharedDriver.pageContainer.material_Change_Page.clickFlagForDeletion();
			SharedDriver.pageContainer.materialPage.getRequestId_CreateNew(suiteName);
			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
	
		}

	}

	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Material_Delete_Record_Shared_With_Multiple_Opcos (Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException 
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
	    	//SharedDriver.pageContainer.materialPage.getCurrDate();
			SharedDriver.pageContainer.materialPage.globalSearch(dependentGlobalId);
			//		SharedDriver.pageContainer.materialPage.getGlobalId();
			SharedDriver.pageContainer.materialPage.clickFullMaterialData();
			SharedDriver.pageContainer.materialPage.clickOkToHandlePopup();
			//SharedDriver.pageContainer.materialApprovalPage.submitRequestOkBtnClick();
			//SharedDriver.pageContainer.materialApprovalPage.submitRequestOkBtnClick();
			
			
			SharedDriver.pageContainer.material_Change_Page.clickFlagForDeletionButton();	
			
			SharedDriver.pageContainer.material_Change_Page.getErrorPopupMessage();	
		}

	}

	@Test(dataProvider="CreateMaterial_Fill_In",dataProviderClass=staticProviderClass.class)
	public void Material_Create_Fill_In_Data_Change(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException 
	{
		//		SharedDriver.pageContainer.materialPage.disableLocaData();
		//		SharedDriver.pageContainer.materialPage.materialDescCreate(dataMap.get("Description"));
		 
		
			//		SharedDriver.pageContainer.materialPage.disableLocaData();
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
	
		}		
	}
	@Test(dataProvider="CreateMaterial_Fill_In",dataProviderClass=staticProviderClass.class)
	public void Material_Create_Fill_In_Data_Change_JDE(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException 
	{
		//		SharedDriver.pageContainer.materialPage.disableLocaData();
		//		SharedDriver.pageContainer.materialPage.materialDescCreate(dataMap.get("Description"));
		 
		
			//		SharedDriver.pageContainer.materialPage.disableLocaData();
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
		}
		
	}

	@Test
	public void Material_RequestId_Generation(ITestContext context) throws InterruptedException, FileNotFoundException, IOException  
	{
			String suiteName = context.getSuite().getName();
			SharedDriver.pageContainer.materialPage.clickLocalAction();
			SharedDriver.pageContainer.materialPage.validate();
			SharedDriver.pageContainer.materialPage.duplicateCheckButton();
			SharedDriver.pageContainer.materialPage.clickDuplicateCheck_SAP();		
			SharedDriver.pageContainer.materialPage.getRequestId_CreateNew(suiteName);
			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();

	}
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Material_Create_Reference_Syndication_Check (Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException 
	{
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			SharedDriver.pageContainer.homePage.navigateToWorkflow();
			SharedDriver.pageContainer.materialPage.switchToPopup();
			SharedDriver.pageContainer.materialPage.navigateToDashboard();
//			SharedDriver.pageContainer.materialPage.advancedSearch();
//			SharedDriver.pageContainer.materialPage.scrolltoGlobalSearch();
//			SharedDriver.pageContainer.materialPage.getCurrDate();
			SharedDriver.pageContainer.materialPage.globalSearch(dependentGlobalId);
//			SharedDriver.pageContainer.materialPage.getGlobalId();
			SharedDriver.pageContainer.materialPage.clickFullMaterialData();
			SharedDriver.pageContainer.materialPage.clickOkToHandlePopup();
			//SharedDriver.pageContainer.material_Change_Page.clickEditCheckBox();
			SharedDriver.pageContainer.material_Change_Page.clickReferencebutton();
			SharedDriver.pageContainer.materialPage.clickOkToHandlePopup();
			SharedDriver.pageContainer.materialPage.clickOkToHandlePopup();

		}
	}
	
	@Test(dataProvider="CreateMaterial_Fill_In",dataProviderClass=staticProviderClass.class)
	public void Material_Create_Fill_In_Data_Reference(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException 
	{
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
//			SharedDriver.pageContainer.materialPage.disableLocaData();
			//		SharedDriver.pageContainer.materialPage.materialDescCreate(dataMap.get("Description"));
			SharedDriver.pageContainer.materialPage.materialGrpSelectionTest("CMG0012");
			SharedDriver.pageContainer.materialPage.grossWeightEntestTest("100");
			SharedDriver.pageContainer.materialPage.unitOfWeightSelectionTest("KG");
			SharedDriver.pageContainer.materialPage.baseUOMSelectionTest("KG");
			SharedDriver.pageContainer.materialPage.netWeightEnterTest("100");
			SharedDriver.pageContainer.materialPage.uomPrimarySelectionTest();
	
		}
	}
	
	@Test
	public void confirmExtensionSAP(ITestContext context) throws InterruptedException, FileNotFoundException, IOException
	{
		String suiteName = context.getSuite().getName();
		//SharedDriver.pageContainer.material_Change_Page.clickExtendbutton();
		Sync.waitForSeconds(Constants.WAIT_5);
       SharedDriver.pageContainer.materialPage.clickLocalAction();
       SharedDriver.pageContainer.material_Change_Page.clickConfirmExtension();
       SharedDriver.pageContainer.materialPage.getRequestId_CreateNew(suiteName);
	   SharedDriver.pageContainer.materialApprovalPage.submitRequestOkButtonClick();
	}

	
	@Test
	public void confirmExtensionNonSAP(ITestContext context) throws InterruptedException, FileNotFoundException, IOException
	{
		String suiteName = context.getSuite().getName();
		//SharedDriver.pageContainer.material_Change_Page.clickExtendbutton();
		Sync.waitForSeconds(Constants.WAIT_10);
		System.out.println("Global Data Tab");
		
		SharedDriver.pageContainer.materialNavPage.switchToGlobal();
       SharedDriver.pageContainer.material_Change_Page.clickConfirmExtension();
       SharedDriver.pageContainer.materialPage.getRequestId_CreateNew(suiteName);
	   SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
	}

	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Material_Extend_SAP (Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException 
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
	    	//SharedDriver.pageContainer.materialPage.getCurrDate();
			SharedDriver.pageContainer.materialPage.globalSearch(dependentGlobalId);
		    //SharedDriver.pageContainer.materialPage.getGlobalId();
			SharedDriver.pageContainer.material_Change_Page.clickFullMaterialDataSAP();
			SharedDriver.pageContainer.material_Change_Page.selectOperatingEntity();
			SharedDriver.pageContainer.material_Change_Page.clickExtendbutton();
			SharedDriver.pageContainer.materialPage.clickLocalAction();
		    SharedDriver.pageContainer.material_Change_Page.clickConfirmExtension();
		    SharedDriver.pageContainer.materialPage.getRequestId_CreateNew(suiteName);
			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
			
			//SharedDriver.pageContainer.materialPage.clickOkToHandlePopup();
			//SharedDriver.pageContainer.materialApprovalPage.submitRequestOkBtnClick();	
		}		
	}
	
	
}
