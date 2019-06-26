package com.mendix.test;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.mendix.tool.Button;
import com.mendix.tool.Constants;
import com.mendix.tool.SharedDriver;
import com.mendix.tool.Sync;
import com.mendix.util.BrowserUtil;
import com.mendix.util.DataProviderUtil.staticProviderClass;
import com.mendix.util.ResultUtil;

public class MaterialScript extends BaseScript{

	WebDriver driver;

	/**
	 * Create Material,Change Material,Extend Material
	 */
	String s ="";

	@Test
	public void Material_Create_Fill_In_Questionnaire() throws InterruptedException {

		SharedDriver.pageContainer.homePage.navigateToWorkflow();
		SharedDriver.pageContainer.materialPage.switchToPopup();
		SharedDriver.pageContainer.materialPage.clickMaterial("Materials");
		SharedDriver.pageContainer.materialPage.createMaterialNavigate();
		SharedDriver.pageContainer.materialPage.materialTypeSelection();
		SharedDriver.pageContainer.materialPage.createButtonClick();

	}
   @Test(dataProvider = "CreateMaterial_Fill_In", dataProviderClass = staticProviderClass.class)
	public void Material_Create_Fill_In_Data(Map<String, String> dataMap, ITestContext context)
			throws InterruptedException, FileNotFoundException, IOException {
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			SharedDriver.pageContainer.materialPage.disableLocaData();
			SharedDriver.pageContainer.materialPage.materialDescCreate(dataMap.get("Description"));
			SharedDriver.pageContainer.materialPage.materialGrpSelectionTest(dataMap.get("Material Group"));
			SharedDriver.pageContainer.materialPage.grossWeightEntestTest(dataMap.get("Gross Weight Base UoM"));
			SharedDriver.pageContainer.materialPage.unitOfWeightSelectionTest(dataMap.get("Unit of Weight"));
			SharedDriver.pageContainer.materialPage.baseUOMSelectionTest(dataMap.get("Base UoM"));
			SharedDriver.pageContainer.materialPage.netWeightEnterTest(dataMap.get("Net Weight Base UoM"));
			SharedDriver.pageContainer.materialPage.uomPrimarySelectionTest();	
		}
	}

	@Test(dataProvider = "CreateMaterial_Fill_In_Rejection", dataProviderClass = staticProviderClass.class)
	public void Material_Create_Fill_In_Data_Reject(Map<String, String> dataMap, ITestContext context)
			throws InterruptedException, FileNotFoundException, IOException {
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			try {
				SharedDriver.pageContainer.materialPage.disableLocaData();
				SharedDriver.pageContainer.materialPage.materialDescCreate(dataMap.get("Description"));
				SharedDriver.pageContainer.materialPage.materialGrpSelectionTest(dataMap.get("Material Group"));
				SharedDriver.pageContainer.materialPage.grossWeightEntestTest(dataMap.get("Gross Weight Base UoM"));
				SharedDriver.pageContainer.materialPage.unitOfWeightSelectionTest(dataMap.get("Unit of Weight"));
				SharedDriver.pageContainer.materialPage.baseUOMSelectionTest(dataMap.get("Base UoM"));
				SharedDriver.pageContainer.materialPage.netWeightEnterTest(dataMap.get("Net Weight Base UoM"));
				SharedDriver.pageContainer.materialPage.uomPrimarySelectionTest();
				SharedDriver.pageContainer.materialPage.validateTestCreate();
				SharedDriver.pageContainer.materialPage.submitGlobalRequestTest();
				SharedDriver.pageContainer.materialPage.getRequestId(suiteName);
				System.out.println("Material_Create_Fill_In_Data_Reject-Done");
			} catch (Exception e) {
				System.out.println("Material_Create_Fill_In_Data_Reject is not completed");
				driver.close();
			}	
		}
	}

	@Test(dataProvider = "Process_Information_Check", dataProviderClass = staticProviderClass.class)
	public void Process_Information_Check(Map<String, String> dataMap, ITestContext context)
			throws InterruptedException, FileNotFoundException, IOException {
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			Sync.waitForSeconds(Constants.WAIT_6);
			Sync.waitForSeconds(Constants.WAIT_5);

			SharedDriver.pageContainer.processInfoPage.processInfoSearch();
			SharedDriver.pageContainer.processInfoPage.reqIdSearch_Global(dataMap.get("RequestId"));
			// SharedDriver.pageContainer.processInfoPage.getState(dataMap.get("RequestId"));
			//SharedDriver.pageContainer.processInfoPage.getState_New(dataMap.get("RequestId"));
			// SharedDriver.pageContainer.processInfoPage.requestCreated_between();
			SharedDriver.pageContainer.processInfoPage.getState(dataMap.get("RequestId"));
			Sync.waitForSeconds(Constants.WAIT_10);
			SharedDriver.pageContainer.processInfoPage.browserClose();	
		}
		
	}

	@Test(dataProvider = "Process_Information_Check", dataProviderClass = staticProviderClass.class)
	public void Process_Information_Check_FlagDeletion(Map<String, String> dataMap, ITestContext context)
			throws InterruptedException, FileNotFoundException, IOException {
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			SharedDriver.pageContainer.processInfoPage.processInfoSearch();
			SharedDriver.pageContainer.processInfoPage.reqIdSearch_Global(dataMap.get("RequestId"));
			// SharedDriver.pageContainer.processInfoPage.getState(dataMap.get("RequestId"));
			SharedDriver.pageContainer.processInfoPage.getState_New(dataMap.get("RequestId"));

			SharedDriver.pageContainer.materialPage.navigateToDashboard();
			SharedDriver.pageContainer.materialPage.advancedSearch();
			SharedDriver.pageContainer.materialPage.scrolltoGlobalSearch();
			SharedDriver.pageContainer.materialPage.reqIdSearchGlobal(dataMap.get("RequestId"));
			SharedDriver.pageContainer.materialPage.getGlobalId();
			// SharedDriver.pageContainer.materialPage.clickFullMaterialData();
			// SharedDriver.pageContainer.materialPage.getMaterial_Number();
			SharedDriver.pageContainer.processInfoPage.browserClose();
			
			//SharedDriver.pageContainer.materialApprovalPage.launchUFT();

			SharedDriver.pageContainer.processInfoPage.browserClose();	
		}
	}
	/*
	 * @Test(dataProvider="Process_Information_Check",dataProviderClass=
	 * staticProviderClass.class) public void
	 * Process_Information_Check_Extend(Map<String,String> dataMap) throws
	 * InterruptedException, FileNotFoundException, IOException {
	 * 
	 * SharedDriver.pageContainer.processInfoPage.processInfoSearch();
	 * SharedDriver.pageContainer.materialPage.globalSearch(dataMap.get("Global_ID")
	 * );
	 * //SharedDriver.pageContainer.processInfoPage.getState(dataMap.get("RequestId"
	 * )); SharedDriver.pageContainer.processInfoPage.getState_New(dataMap.get(
	 * "Global_ID"));
	 * //SharedDriver.pageContainer.processInfoPage.requestCreated_between();
	 * 
	 * SharedDriver.pageContainer.processInfoPage.browserClose(); }
	 */

	@Test(dataProvider = "Process_Information_Check", dataProviderClass = staticProviderClass.class)
	public void Material_Create_Review_Global_Data_Approve_GDA_Duplicate(Map<String, String> dataMap, ITestContext context)
			throws InterruptedException, FileNotFoundException, IOException {
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			Assert.assertTrue(SharedDriver.pageContainer.homePage.navigateToWorkflow());
			SharedDriver.pageContainer.materialPage.switchToPopup();
			SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
			SharedDriver.pageContainer.materialPage.clickLocalAction();
			SharedDriver.pageContainer.materialPage.validateAndDuplicateCheckButton();
			SharedDriver.pageContainer.materialApprovalPage.clickDuplicateCheck_GDA();
			SharedDriver.pageContainer.materialPage.clickLocalAction();
			SharedDriver.pageContainer.materialApprovalPage.approvalBtnClick();
			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
			//SharedDriver.pageContainer.materialApprovalPage.duplicateCheck();
			//SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
			// SharedDriver.pageContainer.materialApprovalPage.submitRequestOkBtnClick();
			// SharedDriver.pageContainer.processInfoPage.browserClose();
			// SharedDriver.pageContainer.materialApprovalPage.duplicateCheck();

			//SharedDriver.pageContainer.materialApprovalPage.duplicateCheck();
			//SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
			// SharedDriver.pageContainer.materialApprovalPage.submitRequestOkBtnClick();
			// SharedDriver.pageContainer.processInfoPage.browserClose();
			// SharedDriver.pageContainer.materialApprovalPage.duplicateCheck();

		}

	}


	@Test(dataProvider = "Process_Information_Check", dataProviderClass = staticProviderClass.class)
	public void Material_Create_Review_Global_Data_Approve_GBDA(Map<String, String> dataMap, ITestContext context)
			throws InterruptedException, FileNotFoundException, IOException {
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			Assert.assertTrue(SharedDriver.pageContainer.homePage.navigateToWorkflow());
			SharedDriver.pageContainer.materialPage.switchToPopup();
			SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));		
			SharedDriver.pageContainer.materialPage.Localactionbutton();
			SharedDriver.pageContainer.materialPage.validate();
			SharedDriver.pageContainer.materialPage.duplicateCheckButton();
			SharedDriver.pageContainer.materialApprovalPage.clickDuplicateCheck_GDA();
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
			SharedDriver.pageContainer.materialPage.clickLocalAction();
			SharedDriver.pageContainer.materialPage.validateAndDuplicateCheckButton();
			SharedDriver.pageContainer.materialApprovalPage.clickDuplicateCheck_GDA();
			//SharedDriver.pageContainer.materialPage.clickLocalAction();
			//SharedDriver.pageContainer.materialApprovalPage.approvalBtnClick();
			//SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
		}


	}

	@Test(dataProvider = "Process_Information_Check", dataProviderClass = staticProviderClass.class)
	public void Material_Save_As_Draft_Data_SubmitRequest_LDR(Map<String, String> dataMap, ITestContext context)
			throws InterruptedException, FileNotFoundException, IOException {
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			Assert.assertTrue(SharedDriver.pageContainer.homePage.navigateToWorkflow());
			SharedDriver.pageContainer.materialPage.switchToPopup();
			SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
			// SharedDriver.pageContainer.materialPage.clickLocalAction();
			SharedDriver.pageContainer.materialPage.validateTestCreate();
			SharedDriver.pageContainer.materialPage.duplicateCheckButton();
			SharedDriver.pageContainer.materialPage.clickDuplicateCheck();
//			SharedDriver.pageContainer.materialPage.submitGlobalRequestTest();		
			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
		}

	}

	@Test
	public void Material_Create_Validate_Submit_Check(ITestContext context)
			throws InterruptedException, FileNotFoundException, IOException {
		String suiteName = context.getSuite().getName();
		SharedDriver.pageContainer.materialPage.validateTestCreate();
		SharedDriver.pageContainer.materialPage.duplicateCheckButton();
		SharedDriver.pageContainer.materialPage.clickDuplicateCheck_SAP();		
		SharedDriver.pageContainer.materialPage.getRequestId_CreateNew(suiteName);
		SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
		// SharedDriver.pageContainer.materialPage.getRequestId();
		//SharedDriver.pageContainer.materialApprovalPage.submitRequestOkBtnClick();
		// SharedDriver.pageContainer.materialApprovalPage.okbuttonClick();
		// SharedDriver.pageContainer.materialPage.getRequestId();
		//SharedDriver.pageContainer.materialApprovalPage.submitRequestOkBtnClick();
		// SharedDriver.pageContainer.materialApprovalPage.okbuttonClick();

	}

	@Test(dataProvider = "CreateMaterial_Fill_In", dataProviderClass = staticProviderClass.class)
	public void Material_Create_Validate_Submit_Save_Check(Map<String, String> dataMap, ITestContext context)
			throws InterruptedException, FileNotFoundException, IOException {
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			SharedDriver.pageContainer.materialPage.validateTestCreate();
			SharedDriver.pageContainer.materialPage.SaveAsDraft();
			SharedDriver.pageContainer.materialPage.getRequestId_draft(suiteName);
			SharedDriver.pageContainer.materialApprovalPage.submitRequestOkBtnClick();
			// SharedDriver.pageContainer.processInfoPage.browserClose();
		}
		/*
		 * SharedDriver.pageContainer.materialPage.disableLocaData();
		 * SharedDriver.pageContainer.materialPage.materialDescCreate(dataMap.get(
		 * "Description"));
		 * SharedDriver.pageContainer.materialPage.materialGrpSelectionTest(dataMap.
		 * get("Material Group"));
		 * SharedDriver.pageContainer.materialPage.grossWeightEntestTest(dataMap.
		 * get("Gross Weight Base UoM"));
		 * SharedDriver.pageContainer.materialPage.unitOfWeightSelectionTest(dataMap.
		 * get("Unit of Weight"));
		 * SharedDriver.pageContainer.materialPage.baseUOMSelectionTest(dataMap.
		 * get("Base UoM"));
		 * SharedDriver.pageContainer.materialPage.netWeightEnterTest(dataMap.
		 * get("Net Weight Base UoM"));
		 * SharedDriver.pageContainer.materialPage.uomPrimarySelectionTest();
		 */
	}

	@Test(dataProvider = "CreateMaterial_Fill_In_draft", dataProviderClass = staticProviderClass.class)
	public void Material_Create_Fill_In_Data_Save_as_draft(Map<String, String> dataMap, ITestContext context)
			throws InterruptedException, FileNotFoundException, IOException {
		// String Id=null;
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			SharedDriver.pageContainer.materialPage.disableLocaData();
			SharedDriver.pageContainer.materialPage.materialDescCreate(dataMap.get("Description"));
			SharedDriver.pageContainer.materialPage.materialGrpSelectionTest(dataMap.get("Material Group"));
			SharedDriver.pageContainer.materialPage.grossWeightEntestTest(dataMap.get("Gross Weight Base UoM"));
			SharedDriver.pageContainer.materialPage.unitOfWeightSelectionTest(dataMap.get("Unit of Weight"));
			SharedDriver.pageContainer.materialPage.baseUOMSelectionTest(dataMap.get("Base UoM"));
			SharedDriver.pageContainer.materialPage.netWeightEnterTest(dataMap.get("Net Weight Base UoM"));
			SharedDriver.pageContainer.materialPage.uomPrimarySelectionTest();
			SharedDriver.pageContainer.materialPage.validateTestCreate();
			SharedDriver.pageContainer.materialPage.SaveAsDraft();
			SharedDriver.pageContainer.materialPage.getRequestId_draft(suiteName);
			SharedDriver.pageContainer.processInfoPage.browserClose();	
		}

	}

	@Test(dataProvider = "Process_Information_Check", dataProviderClass = staticProviderClass.class)
	public void Material_Create_Fill_in_Data_Save_as_Draft_Submit(Map<String, String> dataMap, ITestContext context)
			throws InterruptedException, FileNotFoundException, IOException {
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			SharedDriver.pageContainer.homePage.navigateToWorkflow();
			SharedDriver.pageContainer.materialPage.switchToPopup();
			SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));		
			SharedDriver.pageContainer.materialPage.validateTestCreate();
			SharedDriver.pageContainer.materialPage.duplicateCheckButton();
			SharedDriver.pageContainer.materialPage.clickDuplicateCheck();
			SharedDriver.pageContainer.materialPage.submitGlobalRequestTest();
			SharedDriver.pageContainer.materialPage.getRequestId_CreateNew(suiteName);
			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();

		}
		// Thread.sleep(3000);
		// Sync.waitForSeconds(Constants.WAIT_3);
		
		// SharedDriver.pageContainer.processInfoPage.browserClose();
		/*
		 * SharedDriver.pageContainer.materialApprovalPage.submitGlobalRequest_draft();
		 * SharedDriver.pageContainer.materialApprovalPage.approvalBtnClick_Local();
		 * SharedDriver.pageContainer.materialApprovalPage.submitRequestOkBtnClick();
		 */
	}

	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void process_Information_Check_GlobalID_Extend(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException 
	{
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			System.out.println("Waiting for Clicking on Process Info Search");
			SharedDriver.pageContainer.processInfoPage.processInfoSearch();
			SharedDriver.pageContainer.processInfoPage.reqIdSearch_Global(dataMap.get("RequestId"));
			//SharedDriver.pageContainer.processInfoPage.getState_New(dataMap.get("RequestId"));
			//SharedDriver.pageContainer.processInfoPage.capturing_GlobalID();
			
			SharedDriver.pageContainer.materialPage.checkSyndicationTest(dataMap.get("RequestId"));
			SharedDriver.pageContainer.materialPage.getGlobalIdProcessInfo_Extend(dataMap.get("RequestId"), suiteName);
			Sync.waitForSeconds(Constants.WAIT_5);
			SharedDriver.pageContainer.materialPage.checkSyndicationDoneStatus(dataMap.get("RequestId"));
			Sync.waitForSeconds(Constants.WAIT_10);
			Sync.waitForSeconds(Constants.WAIT_10);
			SharedDriver.pageContainer.processInfoPage.browserClose();	
		}		
	}
	
	
	@Test(dataProvider = "Process_Information_Check", dataProviderClass = staticProviderClass.class)
	public void material_Create_Syndication_Check_GlobalId(Map<String, String> dataMap, ITestContext context)
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
			SharedDriver.pageContainer.materialPage.globalSearch(dependentGlobalId);
			
			SharedDriver.pageContainer.materialPage.checkDashboardLock();
			// SharedDriver.pageContainer.materialPage.getGlobalId();
			// SharedDriver.pageContainer.materialPage.clickFullMaterialData();
			// SharedDriver.pageContainer.materialPage.getMaterial_Number();
			SharedDriver.pageContainer.processInfoPage.browserClose();
			// SharedDriver.pageContainer.materialApprovalPage.launchUFT();
			
		}
	}
	
	
	@Test
	public void launchUFT_SAP_Material() throws InterruptedException, IOException
	{
		//Thread.sleep(1200000);
		SharedDriver.pageContainer.materialApprovalPage.launchUFTSAPMaterial();
	}
	
	@Test
	public void launchUFT_NAV_Material() throws InterruptedException, IOException
	{
		//Thread.sleep(1200000);
		SharedDriver.pageContainer.materialApprovalPage.launchUFTNAVMaterial();
	}
	
	@Test
	public void launchUFT_JDE_Material() throws InterruptedException, IOException
	{
		//Thread.sleep(1200000);
		SharedDriver.pageContainer.materialApprovalPage.launchUFTJDEMaterial();
	}



	@Test(dataProvider = "Process_Information_Check", dataProviderClass = staticProviderClass.class)
	public void Material_Extend_Syndication_Check(Map<String, String> dataMap, ITestContext context)
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
			SharedDriver.pageContainer.materialPage.globalSearch(dependentGlobalId);
			SharedDriver.pageContainer.materialPage.getGlobalId();
			// SharedDriver.pageContainer.materialPage.clickFullMaterialData();
			// SharedDriver.pageContainer.materialPage.getMaterial_Number();
			SharedDriver.pageContainer.processInfoPage.browserClose();
		//	SharedDriver.pageContainer.materialApprovalPage.launchUFT();
			
		}
	}

	@Test(dataProvider = "Process_Information_Check", dataProviderClass = staticProviderClass.class)
	public void Global_Lock_Validation(Map<String, String> dataMap, ITestContext context)
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
			// SharedDriver.pageContainer.materialPage.getCurrDate();
			SharedDriver.pageContainer.materialPage.globalSearch(dependentGlobalId);
			SharedDriver.pageContainer.materialPage.clickFullMaterialData();
			SharedDriver.pageContainer.material_Change_Page.getGlobalIdNew();

			SharedDriver.pageContainer.materialPage.navigateToDashboard();
			SharedDriver.pageContainer.materialPage.advancedSearch();
			SharedDriver.pageContainer.materialPage.scrolltoGlobalSearch();
			// SharedDriver.pageContainer.materialPage.getCurrDate();
			SharedDriver.pageContainer.materialPage.globalSearch(dependentGlobalId);

			SharedDriver.pageContainer.material_Change_Page.getGlobalIdNew();
			// SharedDriver.pageContainer.materialPage.clickFullMaterialData();
			// SharedDriver.pageContainer.materialPage.getMaterial_Number();
			SharedDriver.pageContainer.processInfoPage.browserClose();
			//SharedDriver.pageContainer.materialApprovalPage.launchUFT();
			
		}
	}

	/*
	 * @Test(dataProvider="Process_Information_Check_Material_Reject",
	 * dataProviderClass=staticProviderClass.class) public void
	 * Material_Data_With_Reject_GDA (Map<String,String> dataMap) throws
	 * InterruptedException, FileNotFoundException, IOException, AWTException {
	 * 
	 * try{ System.out.println("Start:Material_Data_With_Reject_GDA ");
	 * SharedDriver.pageContainer.homePage.navigateToWorkflow();
	 * SharedDriver.pageContainer.materialPage.switchToPopup();
	 * SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.
	 * get("RequestId")); System.out.println("search task opened"); //
	 * SharedDriver.pageContainer.materialPage.validateTestCreate(); //
	 * SharedDriver.pageContainer.materialApprovalPage.duplicateCheck();
	 * SharedDriver.pageContainer.materialPage.RejectGDA();
	 * 
	 * System.out.println("Material_Data_With_Reject_GDA-Done"); }catch (Exception
	 * e){ System.out.println("Material_Data_With_Reject_GDA is not completed");
	 * driver.close(); }
	 * 
	 * }
	 */

	@Test(dataProvider = "Process_Information_Check_Reject_LDR", dataProviderClass = staticProviderClass.class)
	public void Process_Information_Check_LDRInitiator(Map<String, String> dataMap, ITestContext context)
			throws InterruptedException, FileNotFoundException, IOException {
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			try {
				System.out.println("Start:Process_Information_Check_LDRInitiator");

				SharedDriver.pageContainer.processInfoPage.processInfoSearch();
				SharedDriver.pageContainer.processInfoPage.reqIdSearch(dataMap.get("RequestId"));
				SharedDriver.pageContainer.processInfoPage.getState(dataMap.get("RequestId"));
				SharedDriver.pageContainer.processInfoPage.ValidateStateLDR(dataMap.get("RequestId"));
				SharedDriver.pageContainer.processInfoPage.browserClose();
				System.out.println("Process_Information_Check_LDRInitiator-Done");
			} catch (Exception e) {
				System.out.println("Process_Information_Check_LDRInitiator is not completed");
				driver.close();
			}	
		}
	}

	/*
	 * @Test(dataProvider="Process_Information_Check_Material_Reject",
	 * dataProviderClass=staticProviderClass.class) public void
	 * Create_Material_Rejections_with_Discard (Map<String,String> dataMap) throws
	 * InterruptedException, FileNotFoundException, IOException { try{
	 * System.out.println("Start:Create_Material_Rejections_with_Discard");
	 * Sync.waitForSeconds(Constants.WAIT_5);
	 * SharedDriver.pageContainer.homePage.navigateToWorkflow();
	 * SharedDriver.pageContainer.materialPage.switchToPopup();
	 * Sync.waitForSeconds(Constants.WAIT_5);
	 * SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.
	 * get("RequestId")); Sync.waitForSeconds(Constants.WAIT_5);
	 * System.out.println("search task opened");
	 * Sync.waitForSeconds(Constants.WAIT_5);
	 * SharedDriver.pageContainer.materialPage.DiscardCreateGDA();
	 * 
	 * System.out.println("Create_Material_Rejections_with_Discard-Done");
	 * 
	 * }catch(Exception e){
	 * 
	 * System.out.println("Create_Material_Rejections_with_Discard is not completed"
	 * ); driver.close(); } }
	 */
	@Test(dataProvider = "Process_Information_Check", dataProviderClass = staticProviderClass.class)
	public void Material_Data_With_Reject_GDA(Map<String, String> dataMap, ITestContext context)
			throws InterruptedException, FileNotFoundException, IOException, AWTException {
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			System.out.println("Start:Material_Data_With_Reject_GDA ");
			SharedDriver.pageContainer.homePage.navigateToWorkflow();
			SharedDriver.pageContainer.materialPage.switchToPopup();
			SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
			System.out.println("search task opened");
			// SharedDriver.pageContainer.materialPage.validateTestCreate();
			// SharedDriver.pageContainer.materialApprovalPage.duplicateCheck();
			SharedDriver.pageContainer.materialPage.RejectGDA();

			System.out.println("Material_Data_With_Reject_GDA-Done");

		}
	}
	
	/*
		 * catch (Exception e){
		 * System.out.println("Material_Data_With_Reject_GDA is not completed");
		 * driver.close(); }
		 */

	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Create_Material_Rejections_with_Discard(Map<String, String> dataMap, ITestContext context)
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
				SharedDriver.pageContainer.materialNavPage.switchToGlobal();
				SharedDriver.pageContainer.materialPage.DiscardCreateGDA();

				System.out.println("Create_Material_Rejections_with_Discard-Done");

			} catch (Exception e) {

				System.out.println("Create_Material_Rejections_with_Discard is not completed");
				driver.close();
			}	
		}
	}
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Create_Material_Rejections_with_Discard_Local(Map<String, String> dataMap, ITestContext context)
			throws InterruptedException, FileNotFoundException, IOException {
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			try {
				System.out.println("Start:Create_Material_Rejections_with_Discard Local");
				SharedDriver.pageContainer.materialApprovalPage.clickOnOpenTask();
				//SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
				System.out.println("search task opened");
				SharedDriver.pageContainer.materialPage.clickLocalAction();
				SharedDriver.pageContainer.materialPage.DiscardCreateLocal();

				System.out.println("Create_Material_Rejections_with_Discard-Done");

			} catch (Exception e) {

				System.out.println("Create_Material_Rejections_with_Discard is not completed");
				driver.close();
			}	
		}
	}

	@Test(dataProvider = "Process_Information_Check_Reject_LDR", dataProviderClass = staticProviderClass.class)
	public void Process_Information_Check_Discard(Map<String, String> dataMap, ITestContext context)
			throws InterruptedException, FileNotFoundException, IOException {
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			System.out.println("Start:Process_Information_Check_Discard");
			try {
				SharedDriver.pageContainer.processInfoPage.processInfoSearch();
				SharedDriver.pageContainer.processInfoPage.reqIdSearch(dataMap.get("RequestId"));
				SharedDriver.pageContainer.processInfoPage.getState(dataMap.get("RequestId"));
				SharedDriver.pageContainer.processInfoPage.ValidateStateDiscarded(dataMap.get("RequestId"));
				SharedDriver.pageContainer.processInfoPage.browserClose();
				System.out.println("Process_Information_Check_Discard-Done");

			} catch (Exception e) {

				System.out.println("Process_Information_Check_Discard is not completed");
				driver.close();
			}	
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
			// SharedDriver.pageContainer.processInfoPage.browserClose();
			// SharedDriver.pageContainer.materialApprovalPage.launchUFT();

		}
	}

	@Test(dataProvider = "Process_Information_Check", dataProviderClass = staticProviderClass.class)
	public void Happy_Flag_Deletion(Map<String, String> dataMap, ITestContext context)
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
			
		}
	}
	

	@Test(dataProvider = "Process_Information_Check", dataProviderClass = staticProviderClass.class)
	public void material_Create_With_ref_Edit_Nav(Map<String, String> dataMap, ITestContext context)
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
			SharedDriver.pageContainer.materialPage.globalSearch(dependentGlobalId);
			SharedDriver.pageContainer.materialPage.clickFullMaterialData();
			Sync.waitForSeconds(Constants.WAIT_5);
			SharedDriver.pageContainer.material_Change_Page.clickReferencebutton();
			Sync.waitForSeconds(Constants.WAIT_5);
			SharedDriver.pageContainer.materialNavPage.createWithReferenceRequestforNav();
	
		}		
	}
	
	@Test(dataProvider = "CreateMaterial_Fill_In_Nav", dataProviderClass = staticProviderClass.class)
	public void material_Global_Data_Edit_Nav(Map<String, String> dataMap, ITestContext context) throws InterruptedException
	{
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			SharedDriver.pageContainer.materialPage.materialDescCreate(dataMap.get("Description"));
			Sync.waitForSeconds(Constants.WAIT_3);
			// SharedDriver.pageContainer.materialPage.clickLocalAction();
			SharedDriver.pageContainer.materialPage.grossWeightEntestTest(dataMap.get("Gross Weight Base UoM"));
			SharedDriver.pageContainer.materialPage.unitOfWeightSelectionTest(dataMap.get("Unit of Weight"));
			SharedDriver.pageContainer.materialPage.baseUOMSelectionTest(dataMap.get("Base UoM"));
			SharedDriver.pageContainer.materialPage.netWeightEnterTest(dataMap.get("Net Weight Base UoM"));
			SharedDriver.pageContainer.materialPage.uomPrimarySelectionTest();
			SharedDriver.pageContainer.materialPage.validateTestCreate();
			
		}
	}

	
	@Test(dataProvider = "CreateMaterial_Fill_In_Local", dataProviderClass = staticProviderClass.class)
	public void material_Create_With_ref_Local_Data_Edit_Nav(Map<String, String> dataMap, ITestContext context)
			throws InterruptedException, FileNotFoundException, IOException, AWTException {
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			// SharedDriver.pageContainer.materialPage.validateTestCreate();
			// SharedDriver.pageContainer.materialPage.validateLocalDataForNAVCreateRef("WHT_OTH_G");
			SharedDriver.pageContainer.materialNavPage.switchToLocal();
			System.out.println("Editing of Plant Data Start");
			SharedDriver.pageContainer.materialNavPage.localEditPlantNav();
			SharedDriver.pageContainer.materialNavPage.clickAndSelectPurchaseUOMValueDropDown(dataMap.get("Purch. Unit of Measure"));
			SharedDriver.pageContainer.materialNavPage.clickAndSelectProdUOMValueDropDown(dataMap.get("Production Unit of Measure"));
			SharedDriver.pageContainer.materialNavPage.clickAndSelectSalesUOMValueDropDown(dataMap.get("Sales Unit of Measure"));
			SharedDriver.pageContainer.materialNavPage.clickAndSelectRoundingPrecisionValueDropDown(dataMap.get("Rounding Precision"));
			SharedDriver.pageContainer.materialNavPage.clickAndSelectInventoryUOMValueDropDown(dataMap.get("Inventory Unit of Measure"));
			SharedDriver.pageContainer.materialNavPage.validateAndSaveLocalData();
			System.out.println("Editing of Local Data Start");
			SharedDriver.pageContainer.materialNavPage.localEditFinanceDataNav();
			SharedDriver.pageContainer.materialNavPage.clickAndSelectVATPostingGroupDropDown("NO_VAT, 0% VAT");
			
			SharedDriver.pageContainer.materialNavPage.validateAndSaveLocalData();
			System.out.println("Editing of Sites Data Start");
			// Code blocked with requirement change in application effecting previous
			// scripts and needs to be clarified from Business Team
			// Blocked Execution from here and needs code change to edit site data
			//SharedDriver.pageContainer.materialNavPage.localEditSiteDataNav();
			SharedDriver.pageContainer.materialNavPage.clickSiteNewTab();
			SharedDriver.pageContainer.materialNavPage.clickEditSiteData();
			Sync.waitForSeconds(Constants.WAIT_6);
			Sync.waitForSeconds(Constants.WAIT_5);
			SharedDriver.pageContainer.materialNavPage.selectingRow();
			Sync.waitForSeconds(Constants.WAIT_10);
			SharedDriver.pageContainer.materialNavPage.clickSiteEditButton();
			Sync.waitForSeconds(Constants.WAIT_5);
			SharedDriver.pageContainer.materialNavPage.clickAndSelectSitePlantDropDown(dataMap.get("Location Code"));
			Sync.waitForSeconds(Constants.WAIT_5);
			SharedDriver.pageContainer.materialNavPage.clickAndSelectSiteReplenishmentSystemDropDown(dataMap.get("Replenishment System"));
			Sync.waitForSeconds(Constants.WAIT_6);
			SharedDriver.pageContainer.materialNavPage.validateAndSaveLocalData();
			SharedDriver.pageContainer.materialPage.validateAndsubmitGlobalLocalRequest();
			SharedDriver.pageContainer.materialPage.getRequestId_CreateNew(suiteName);
			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
			Sync.waitForSeconds(Constants.WAIT_3);			
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
			SharedDriver.pageContainer.materialPage.clickLocalAction();
			SharedDriver.pageContainer.materialPage.duplicateCheckButton();
			SharedDriver.pageContainer.materialApprovalPage.clickDuplicateCheck_GDA();
			//SharedDriver.pageContainer.materialPage.clickLocalAction();
			//SharedDriver.pageContainer.materialApprovalPage.approvalBtnClick();
			Sync.waitForSeconds(Constants.WAIT_10);
			//SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
			//SharedDriver.pageContainer.materialPage.browserClose();	
		}
	}
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void material_Create_Review_Local_Data_Approve_LDS(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException
	{
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			Assert.assertTrue(SharedDriver.pageContainer.homePage.navigateToWorkflow());
			SharedDriver.pageContainer.materialPage.switchToPopup();
			SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
			SharedDriver.pageContainer.materialApprovalPage.approvalBtnClickLocalLDS();
			Sync.waitForSeconds(Constants.WAIT_5);
			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
			//SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();	
		}
	}
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void material_Create_With_ref_Global_and_Local_Nav(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException
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
			SharedDriver.pageContainer.materialPage.clickFullMaterialData();
			Sync.waitForSeconds(Constants.WAIT_5);
			SharedDriver.pageContainer.material_Change_Page.clickReferencebutton();
			Sync.waitForSeconds(Constants.WAIT_5);
			SharedDriver.pageContainer.materialNavPage.createWithReferenceRequestforNav();
			SharedDriver.pageContainer.materialPage.materialDescCreate(dataMap.get("Material Description"));
			//Heineken_Sample_two_one"
			SharedDriver.pageContainer.materialPage.validateTestCreate();
			//SharedDriver.pageContainer.materialPage.validateLocalDataForNAVCreateRef("WHT_OTH_G");
			SharedDriver.pageContainer.materialNavPage.switchToLocal();
			SharedDriver.pageContainer.materialPage.validateTestCreateLocal();
			//SharedDriver.pageContainer.materialNavPage.switchToGlobal();
			//SharedDriver.pageContainer.materialPage.clickLocalAction();
			SharedDriver.pageContainer.materialPage.duplicateCheckButton();
			SharedDriver.pageContainer.materialPage.clickDuplicateCheck();
			SharedDriver.pageContainer.materialPage.submitGlobalLocalRequest();
			Sync.waitForSeconds(Constants.WAIT_10);
			//SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
			Sync.waitForSeconds(Constants.WAIT_10);
			SharedDriver.pageContainer.materialPage.getRequestId_CreateNew(suiteName);
			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
			//SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
			Sync.waitForSeconds(Constants.WAIT_3);	
		}
	}
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void material_Create_Local_Data_Approve_LDP_NAV(Map<String,String> dataMap, ITestContext context) throws InterruptedException
	{
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			Assert.assertTrue(SharedDriver.pageContainer.homePage.navigateToWorkflow());
			SharedDriver.pageContainer.materialPage.switchToPopup();
			SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
			SharedDriver.pageContainer.materialApprovalPage.approvalBtnClickLocal();
			Sync.waitForSeconds(Constants.WAIT_5);
			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
			//SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();			
		}
	}
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void material_Reject_LDS(Map<String,String> dataMap, ITestContext context) throws InterruptedException, AWTException
	{
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			System.out.println("Start:Material_Data_With_Reject_LDS");
			SharedDriver.pageContainer.homePage.navigateToWorkflow();
			SharedDriver.pageContainer.materialPage.switchToPopup();
			SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
			SharedDriver.pageContainer.materialPage.clickLocalAction();
			SharedDriver.pageContainer.materialPage.rejectLDS();
			
			System.out.println("Material Data With Reject LDS Done");			
		}
	}
	
	@Test
	public void navigate_To_MDM_Workflow() throws InterruptedException
	{
		Assert.assertTrue(SharedDriver.pageContainer.homePage.navigateToWorkflow());
		SharedDriver.pageContainer.materialPage.switchToPopup();
	}
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void material_Resubmit_To_Local_Approval(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException
	{
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
			//SharedDriver.pageContainer.materialPage.validateTestCreate();
			SharedDriver.pageContainer.materialPage.clickLocalAction();
			SharedDriver.pageContainer.materialPage.submitLocalRequestTest();
			//SharedDriver.pageContainer.materialPage.getRequestIdDuringResubmission();
			//SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
			Sync.waitForSeconds(Constants.WAIT_3);
			
		}
	}
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Material_Create_Review_Global_Data_Approve_LDP_NAV(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException 
	{
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			Assert.assertTrue(SharedDriver.pageContainer.homePage.navigateToWorkflow());
			SharedDriver.pageContainer.materialPage.switchToPopup();
			SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
			//SharedDriver.pageContainer.materialPage.clickLocalAction();
			SharedDriver.pageContainer.materialPage.validateTestCreate();
			SharedDriver.pageContainer.materialPage.duplicateCheckButton();
			SharedDriver.pageContainer.materialPage.clickDuplicateCheck_without_Extend();
			//SharedDriver.pageContainer.materialPage.submitGlobalRequestTest();
			Sync.waitForSeconds(Constants.WAIT_5);
			//SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();			
		}
	}
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void material_Create_Review_Global_Data_Approve_GBDA_NAV(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException 
	{
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			Assert.assertTrue(SharedDriver.pageContainer.homePage.navigateToWorkflow());
			SharedDriver.pageContainer.materialPage.switchToPopup();
			SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
			//SharedDriver.pageContainer.materialPage.clickLocalAction();
			SharedDriver.pageContainer.materialPage.validateTestCreate();
			SharedDriver.pageContainer.materialPage.duplicateCheckButton();
			SharedDriver.pageContainer.materialApprovalPage.clickDuplicateCheck_GDA();
			//SharedDriver.pageContainer.materialPage.clickLocalAction();
			//SharedDriver.pageContainer.materialApprovalPage.approvalBtnClick();
			Sync.waitForSeconds(Constants.WAIT_5);
			//SharedDriver.pageContainer.materialApprovalPage.duplicateCheck();
			//SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();			
		}
	}
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Material_Reject_GDA (Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			System.out.println("Start:Material_Data_With_Reject_GDA ");
			SharedDriver.pageContainer.homePage.navigateToWorkflow();
			SharedDriver.pageContainer.materialPage.switchToPopup();
			SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
			System.out.println("search task opened");
		//	SharedDriver.pageContainer.materialPage.validateTestCreate();
		//	SharedDriver.pageContainer.materialApprovalPage.duplicateCheck();
			SharedDriver.pageContainer.materialPage.RejectGDA();
			System.out.println("Material_Data_With_Reject_GDA-Done");				
		}
	}
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Material_Reject_LBDA (Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			System.out.println("Start:Material_Data_With_Reject_GDA ");
			SharedDriver.pageContainer.homePage.navigateToWorkflow();
			SharedDriver.pageContainer.materialPage.switchToPopup();
			SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
			System.out.println("search task opened");
		//	SharedDriver.pageContainer.materialPage.validateTestCreate();
		//	SharedDriver.pageContainer.materialApprovalPage.duplicateCheck();
			SharedDriver.pageContainer.materialPage.RejectGDA();
			System.out.println("Material_Data_With_Reject_LBDA-Done");				
		}
	}
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void material_Resubmit_To_Global_Approval(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException
	{
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
			SharedDriver.pageContainer.materialPage.Localactionbutton();
			SharedDriver.pageContainer.materialPage.validate();
			SharedDriver.pageContainer.materialPage.duplicateCheckButton();
			SharedDriver.pageContainer.materialPage.clickDuplicateCheck();
			SharedDriver.pageContainer.materialPage.submitGlobalRequestTest();
			//SharedDriver.pageContainer.materialPage.getRequestIdDuringResubmission();
			//SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
			Sync.waitForSeconds(Constants.WAIT_3);			
		}
	}
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void material_Resubmit_To_Global_Approval_Extend(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException
	{
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
			SharedDriver.pageContainer.materialPage.clickLocalAction();
			//SharedDriver.pageContainer.materialPage.duplicateCheckButton();
			SharedDriver.pageContainer.materialPage.submitGlobalRequestExtend();
			SharedDriver.pageContainer.materialPage.clickDuplicateCheck();
			//SharedDriver.pageContainer.materialPage.getRequestIdDuringResubmission();
			//SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
			Sync.waitForSeconds(Constants.WAIT_6);
			Sync.waitForSeconds(Constants.WAIT_5);
			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
			Sync.waitForSeconds(Constants.WAIT_3);			
		}
	}
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Material_Direct_Copy_With_References(Map<String,String> dataMap, ITestContext context) throws InterruptedException, IOException
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
			SharedDriver.pageContainer.materialPage.clickFullMaterialData();
			Sync.waitForSeconds(Constants.WAIT_5);
			SharedDriver.pageContainer.material_Change_Page.clickReferencebutton();
			Sync.waitForSeconds(Constants.WAIT_5);
			//String popUpText = driver.findElement(By.xpath("//*[@class='modal-body mx-dialog-body']/p")).getText();
			//if(popUpText.equalsIgnoreCase("Can not copy local data as local data is not found for selected material."))
			//{
			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
			SharedDriver.pageContainer.materialPage.disableLocaData();
			SharedDriver.pageContainer.materialPage.validateTestCreate();
			SharedDriver.pageContainer.materialPage.submitGlobalRequestTest();
			//SharedDriver.pageContainer.materialPage.getRequestId();
			SharedDriver.pageContainer.materialPage.getRequestId_CreateNew(suiteName);
			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
			Sync.waitForSeconds(Constants.WAIT_3);			
		}
	}
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void material_Data_Extend_NAV(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException
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
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Material_Data_Extend(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException
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
			//SharedDriver.pageContainer.materialPage.clickOkToHandlePopup();
			SharedDriver.pageContainer.material_Change_Page.clickExtendbutton();
			Sync.waitForSeconds(Constants.WAIT_3);
			SharedDriver.pageContainer.materialPage.clickLocalAction();
			SharedDriver.pageContainer.material_Change_Page.clickConfirmExtensionButton();
			Sync.waitForSeconds(Constants.WAIT_5);
			SharedDriver.pageContainer.materialPage.getRequestId_CreateNew(suiteName);
			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
	
		}
		
	}
	
}
	




