package com.mendix.test;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.mendix.tool.Constants;
import com.mendix.tool.SharedDriver;
import com.mendix.tool.Sync;
import com.mendix.util.DataProviderUtil.staticProviderClass;
import com.mendix.page.VendorPage;

public class Vendor_JDE_Script extends BaseScript{


	@Test(dataProvider="Vendor_Create_Global_Disable_Bank_and_LocalData",dataProviderClass=staticProviderClass.class)
	public void Vendor_Create_Fill_In_Data_JDE_Local_Purchasing(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			SharedDriver.pageContainer.vendor_JDE_Page.enterLocalData();
			SharedDriver.pageContainer.vendor_JDE_Page.BtnAddPlantData();
			SharedDriver.pageContainer.vendor_JDE_Page.selectAdjustmentSchedule();
			//SharedDriver.pageContainer.vendor_JDE_Page.selectSendMethod();		
			SharedDriver.pageContainer.vendorPage.clickLocalAction_Local();
			SharedDriver.pageContainer.vendor_JDE_Page.clickValidatLocalData();		
			SharedDriver.pageContainer.vendor_JDE_Page.clickPlanningSaveButton();
	
		}
	}
	@Test(dataProvider="Vendor_Create_Global_Disable_Bank_and_LocalData",dataProviderClass=staticProviderClass.class)
	public void Vendor_Change_Fill_In_Data_JDE_Local_Purchasing(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			SharedDriver.pageContainer.vendor_JDE_Page.enterLocalData();
			SharedDriver.pageContainer.vendor_JDE_Page.Btneditinpurchansing();
			SharedDriver.pageContainer.vendor_JDE_Page.BtneditPlantData();
			
			SharedDriver.pageContainer.vendor_JDE_Page.selectAdjustmentSchedulechange("PQ, P*Q Contracts");
			SharedDriver.pageContainer.vendor_JDE_Page.selectsendmethod();
			//SharedDriver.pageContainer.vendor_JDE_Page.selectSendMethod();		
			SharedDriver.pageContainer.vendorPage.clickLocalAction_Local();
			SharedDriver.pageContainer.vendor_JDE_Page.clickValidatLocalData();		
			SharedDriver.pageContainer.vendor_JDE_Page.clickPlanningSaveButton();
	
		}
	}

	@Test(dataProvider="Vendor_Create_Global_Disable_Bank_and_LocalData",dataProviderClass=staticProviderClass.class)
	public void Vendor_Create_Fill_In_Data_JDE_Local_Finance(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			SharedDriver.pageContainer.vendor_JDE_Page.enterLocalData();
			SharedDriver.pageContainer.vendor_JDE_Page.clickFinancetab();
			SharedDriver.pageContainer.vendor_JDE_Page.clickAddFinanceData();
			//SharedDriver.pageContainer.vendor_JDE_Page.selectMvmtTypeInvoicePayment1();
			//SharedDriver.pageContainer.vendor_JDE_Page.selectMvmtTypeInvoicePayment3();
			//SharedDriver.pageContainer.vendor_JDE_Page.selectABAmountCurrency();
			//SharedDriver.pageContainer.vendor_JDE_Page.selectPaymentTerms();
			//SharedDriver.pageContainer.vendor_JDE_Page.selectTaxRateArea();
			//SharedDriver.pageContainer.vendor_JDE_Page.selectPaymentCreation();
		//	SharedDriver.pageContainer.vendor_JDE_Page.selectHoldPayment();
			//SharedDriver.pageContainer.vendor_JDE_Page.selectGlClass();
			//SharedDriver.pageContainer.vendor_JDE_Page.selectMvmtTypeInvoicePayment2();
			//SharedDriver.pageContainer.vendor_JDE_Page.selectMvmtTypeInvoicePayment4();
			//SharedDriver.pageContainer.vendor_JDE_Page.selectDefaultCurrency();
			//SharedDriver.pageContainer.vendor_JDE_Page.selectTaxExplCode();
			//SharedDriver.pageContainer.vendor_JDE_Page.selectPaymentMethods();
			//SharedDriver.pageContainer.vendor_JDE_Page.selectBankBearer();
			SharedDriver.pageContainer.vendorPage.clickLocalAction_Local();
			SharedDriver.pageContainer.vendor_JDE_Page.clickValidatLocalData();
			SharedDriver.pageContainer.vendor_JDE_Page.clickPlanningSaveButton();
			SharedDriver.pageContainer.vendorPage.clickLocalAction_Local();
			//		SharedDriver.pageContainer.materialNavPage.clickLocalAction();
			SharedDriver.pageContainer.materialNavPage.submitGlobalRequestTest();
			SharedDriver.pageContainer.materialPage.duplicateCheck_New();
			SharedDriver.pageContainer.vendorPage.getRequestId_Vendor(suiteName);
//			SharedDriver.pageContainer.materialPage.getRequestId_Create();
	
		}		
	}
	
	@Test(dataProvider="Vendor_Create_Global_Disable_Bank_and_LocalData",dataProviderClass=staticProviderClass.class)
	public void Vendor_Change_Fill_In_Data_JDE_Local_Finance(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			
			SharedDriver.pageContainer.vendor_JDE_Page.clickFinancetab();
			SharedDriver.pageContainer.vendor_JDE_Page.clickeditFinanceData();
			
			SharedDriver.pageContainer.vendor_JDE_Page.selectABAmountCurrencychange();
			SharedDriver.pageContainer.vendor_JDE_Page.selectPaymentTermschange();
			SharedDriver.pageContainer.vendor_JDE_Page.selectTaxRateAreachange();
			SharedDriver.pageContainer.vendor_JDE_Page.selectPaymentCreationchange();
			SharedDriver.pageContainer.vendor_JDE_Page.selectHoldPayment();
			SharedDriver.pageContainer.vendor_JDE_Page.selectGlClass();
			SharedDriver.pageContainer.vendor_JDE_Page.selectMvmtTypeInvoicePayment2();
			SharedDriver.pageContainer.vendor_JDE_Page.selectMvmtTypeInvoicePayment4();
			SharedDriver.pageContainer.vendor_JDE_Page.selectDefaultCurrency();
			SharedDriver.pageContainer.vendor_JDE_Page.selectTaxExplCode();
			SharedDriver.pageContainer.vendor_JDE_Page.selectPaymentMethods();
			SharedDriver.pageContainer.vendor_JDE_Page.selectBankBearer();
			SharedDriver.pageContainer.vendorPage.clickLocalAction_Local();
			SharedDriver.pageContainer.vendor_JDE_Page.clickValidatLocalData();
			SharedDriver.pageContainer.vendor_JDE_Page.clickPlanningSaveButton();
			SharedDriver.pageContainer.vendorPage.clickLocalAction_Local();
			SharedDriver.pageContainer.materialPage.submitLocalRequestTest();
			Sync.waitForSeconds(Constants.WAIT_10);		
			SharedDriver.pageContainer.materialPage.clickOkToHandlePopup();
			Sync.waitForSeconds(Constants.WAIT_10);	
			SharedDriver.pageContainer.materialPage.duplicateCheckButton();
			SharedDriver.pageContainer.materialPage.clickDuplicateCheck_SAP();		
			SharedDriver.pageContainer.materialPage.getRequestId_CreateNew(suiteName);		  
			SharedDriver.pageContainer.materialPage.clickOkToHandlePopup();	

			
						
		}

	}
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Vendor_Create_Review_Global_Data_Reject_LDS(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			Assert.assertTrue(SharedDriver.pageContainer.homePage.navigateToWorkflow());
			SharedDriver.pageContainer.materialPage.switchToPopup();
			SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
//			SharedDriver.pageContainer.vendorPage.clickLocalAction_Local();
			SharedDriver.pageContainer.vendor_JDE_Page.scrollToCommentsNew();
			SharedDriver.pageContainer.vendor_JDE_Page.clickCommentNew();
			SharedDriver.pageContainer.vendor_JDE_Page.clickCommentsArea();
			SharedDriver.pageContainer.vendor_JDE_Page.enterCommentsArea();
			SharedDriver.pageContainer.vendor_JDE_Page.clickSaveComments();
			SharedDriver.pageContainer.vendorPage.clickLocalAction_Local();
			SharedDriver.pageContainer.vendor_JDE_Page.rejectLocalBtnClick();
			SharedDriver.pageContainer.vendor_JDE_Page.submitRequestOkBtnClick();
	
		}
	}
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Vendor_Create_Review_Global_Data_Reject_Discard_LDR(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			Assert.assertTrue(SharedDriver.pageContainer.homePage.navigateToWorkflow());
			SharedDriver.pageContainer.materialPage.switchToPopup();
			SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
			SharedDriver.pageContainer.vendorPage.clickLocalAction_Local();
			SharedDriver.pageContainer.vendorPage.discardLocalButtonClick();
			SharedDriver.pageContainer.vendor_JDE_Page.submitRequestOkBtnClick();
		}		
	}

	@Test(dataProvider="CreateVendor_Fill_In_Bank",dataProviderClass=staticProviderClass.class)
	public void Vendor_Create_Fill_In_Data_Bank_Local(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			//SharedDriver.pageContainer.vendor_JDE_Page.enterBankData();
			//SharedDriver.pageContainer.vendorPage.clickLocalAction_Bank();
			SharedDriver.pageContainer.vendor_JDE_Page.clickNewBankButton();	
			
			//SharedDriver.pageContainer.vendor_JDE_Page.enterBankData();
			//SharedDriver.pageContainer.vendor_JDE_Page.clickNewBankButton();
			SharedDriver.pageContainer.vendorPageNAV.VendorBankCountry_JDE();
			SharedDriver.pageContainer.vendorPageNAV.SelectBankKey_JDE(); 
			SharedDriver.pageContainer.vendor_JDE_Page.enterBankaccount();
			SharedDriver.pageContainer.vendor_JDE_Page.clickSaveBankDetails();
			
			SharedDriver.pageContainer.vendorPage.clickLocalAction_Bank();
			SharedDriver.pageContainer.vendorPage.submitBankRequestTest();
			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
			
			/*SharedDriver.pageContainer.vendorPageNAV.VendorBankCountry(dataMap.get("Bank Country"));  //"PA, Panama");
			SharedDriver.pageContainer.vendorPageNAV.SelectBankKey(dataMap.get("Bank key"));  //"002");
			SharedDriver.pageContainer.vendorPageNAV.VendorCurrencyCode(dataMap.get("Currency Code"));  //"PAB, Panamanian Balboa")
			SharedDriver.pageContainer.vendorPageNAV.VendorPatnerBankType(dataMap.get("Partner Bank Type"));  //"PAB");
			SharedDriver.pageContainer.vendor_JDE_Page.clickSaveBankDetails();
			SharedDriver.pageContainer.vendorPage.clickLocalAction_Bank();
			SharedDriver.pageContainer.vendorPage.submitBankRequestTest();
			*/	
		}
	}
	
    @Test(dataProvider="CreateVendor_Fill_In_Local",dataProviderClass=staticProviderClass.class)
	public void Vendor_Extend_Create_Fill_In_Data_JDE_Local_Purchasing(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			SharedDriver.pageContainer.vendor_JDE_Page.localAddInNewPurchasingJDE();
			SharedDriver.pageContainer.vendor_JDE_Page.selectingAdjustmentSchedule(dataMap.get("Adjustment Schedule"));
			/*SharedDriver.pageContainer.vendor_JDE_Page.selectAdjustmentSchedule();
			SharedDriver.pageContainer.vendor_JDE_Page.selectSendMethod();*/
			SharedDriver.pageContainer.vendor_JDE_Page.selectingSendMethod(dataMap.get("Send Method"));
			SharedDriver.pageContainer.vendorPage.clickLocalAction_Local();
			SharedDriver.pageContainer.vendor_JDE_Page.clickValidatLocalData();
			SharedDriver.pageContainer.vendor_JDE_Page.clickPlanningSaveButton();
			
		}
	}
     
     @Test(dataProvider="CreateVendor_Fill_In_Local",dataProviderClass=staticProviderClass.class)
 	public void Vendor_Extend_Create_Fill_In_Data_JDE_Local_Finance(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
 	{
 		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 	 		SharedDriver.pageContainer.vendor_JDE_Page.clickFinancetab();
 	 		SharedDriver.pageContainer.vendor_JDE_Page.localAddInNewFinanceJDE();
 	 		SharedDriver.pageContainer.vendor_JDE_Page.selectMvmtTypeInvoicePayment1();
 	 		SharedDriver.pageContainer.vendor_JDE_Page.selectMvmtTypeInvoicePayment3();
 	 		/*SharedDriver.pageContainer.vendor_JDE_Page.selectABAmountCurrency();
 	 		SharedDriver.pageContainer.vendor_JDE_Page.selectPaymentTerms();
 	 		SharedDriver.pageContainer.vendor_JDE_Page.selectTaxRateArea();
 	 		SharedDriver.pageContainer.vendor_JDE_Page.selectPaymentCreation();
 	 		SharedDriver.pageContainer.vendor_JDE_Page.selectHoldPayment();
 	 		SharedDriver.pageContainer.vendor_JDE_Page.selectGlClass();	*/		
 	 		SharedDriver.pageContainer.vendor_JDE_Page.selectingABAmountCurrency(dataMap.get("A/B Amount Currency"));	
 	 		SharedDriver.pageContainer.vendor_JDE_Page.selectingPaymentTerms(dataMap.get("Payment Terms"));
 	 		SharedDriver.pageContainer.vendor_JDE_Page.selectingTaxRateArea(dataMap.get("Text Rate Area"));
 	 		SharedDriver.pageContainer.vendor_JDE_Page.selectingPaymentCreation(dataMap.get("Payment creation"));
 	 		SharedDriver.pageContainer.vendor_JDE_Page.selectingHoldPayment(dataMap.get("Hold Payment"));
 	 		SharedDriver.pageContainer.vendor_JDE_Page.selectingGLClass(dataMap.get("GL Class"));
 	 		SharedDriver.pageContainer.vendor_JDE_Page.selectMvmtTypeInvoicePayment2();
 	 		SharedDriver.pageContainer.vendor_JDE_Page.selectMvmtTypeInvoicePayment4();	
 	 		/*SharedDriver.pageContainer.vendor_JDE_Page.selectDefaultCurrency();
 	 		SharedDriver.pageContainer.vendor_JDE_Page.selectTaxExplCode();
 	 		SharedDriver.pageContainer.vendor_JDE_Page.selectPaymentMethods();
 	 		SharedDriver.pageContainer.vendor_JDE_Page.selectBankBearer();*/
 	 		//SharedDriver.pageContainer.vendor_JDE_Page.selectingDefaultCurrency(dataMap.get("Default Currency"));
 	 		SharedDriver.pageContainer.vendor_JDE_Page.selectingTaxEplCode(dataMap.get("Tax EPL Code"));
 	 		SharedDriver.pageContainer.vendor_JDE_Page.selectingPaymentMethod(dataMap.get("Payment Metods"));
 	 		//SharedDriver.pageContainer.vendor_JDE_Page.selectingBankBearer(dataMap.get("Bank Bearer"));
 	 		SharedDriver.pageContainer.vendorPage.clickLocalAction_Local();
 	 		SharedDriver.pageContainer.vendor_JDE_Page.clickValidatLocalData();
 	 		SharedDriver.pageContainer.vendor_JDE_Page.clickPlanningSaveButton();	
 		}
 	}
     
     @Test
 	public void vendor_Extend_Fill_In_Data_JDE_Local_Purchasing() throws InterruptedException, FileNotFoundException, IOException, AWTException 
 	{

 		SharedDriver.pageContainer.vendor_JDE_Page.localAddInNewPurchasingJDE();
 		SharedDriver.pageContainer.vendorPage.clickLocalAction_Local();
 		SharedDriver.pageContainer.vendor_JDE_Page.clickValidatLocalData();
 		SharedDriver.pageContainer.vendor_JDE_Page.clickPlanningSaveButton();
 	}
     
    @Test
  	public void vendor_Extend_Fill_In_Data_JDE_Local_Finance() throws InterruptedException, FileNotFoundException, IOException, AWTException 
  	{
  		SharedDriver.pageContainer.vendor_JDE_Page.clickFinancetab();
  		SharedDriver.pageContainer.vendor_JDE_Page.localAddInNewFinanceJDE();
  		SharedDriver.pageContainer.vendorPage.clickLocalAction_Local();
  		SharedDriver.pageContainer.vendor_JDE_Page.clickValidatLocalData();
  		SharedDriver.pageContainer.vendor_JDE_Page.clickPlanningSaveButton();

  	}

}

