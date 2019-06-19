package com.mendix.test;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.mendix.tool.Constants;
import com.mendix.tool.SharedDriver;
import com.mendix.tool.Sync;
import com.mendix.util.DataProviderUtil.staticProviderClass;

public class VendorScript_NAV extends BaseScript{
	
	WebDriver driver;

	@Test
	public void Vendor_Create_Fill_In_Questionnaire() throws InterruptedException
	{
		Assert.assertTrue(SharedDriver.pageContainer.homePage.navigateToWorkflow());
		SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
		SharedDriver.pageContainer.vendorPage.clickVendor();
		SharedDriver.pageContainer.vendorPage.createVendorNavigate();
		SharedDriver.pageContainer.vendorPage.VendorTypeSelection();
		SharedDriver.pageContainer.vendorPage.createButtonClick();
	}
	
	
/****************************************************************************************************/	
	@Test(dataProvider="Vendor_Create_Global_Disable_Bank_and_LocalData",dataProviderClass=staticProviderClass.class)
	public void Vendor_Create_Fill_In_Data_Global_Local_NAV(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
 		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			SharedDriver.pageContainer.vendorPageNAV.disableBankData_NAV();
// 			SharedDriver.pageContainer.vendorPage.disableBankData();
 			SharedDriver.pageContainer.vendorPageNAV.VendorName(dataMap.get("Name1"));
 			SharedDriver.pageContainer.vendorPageNAV.AddressStreet("kite");//dataMap.get("Street")
 			SharedDriver.pageContainer.vendorPageNAV.AddresHouseNumber("11"); //dataMap.get("House number")
 			SharedDriver.pageContainer.vendorPageNAV.AddresPostalCode("56478"); //dataMap.get("Postal Code")
 			SharedDriver.pageContainer.vendorPageNAV.AddresCity("holland");
 			SharedDriver.pageContainer.vendorPageNAV.ScrollDown();
 			//'DropDowns
 			SharedDriver.pageContainer.vendorPageNAV.AddresCountry("DZ, Algeria"); //dataMap.get("Country")
 			SharedDriver.pageContainer.vendorPageNAV.AddresLanguageKey("EN, English");
 			SharedDriver.pageContainer.vendorPageNAV.AddressCreditInformationNumber("465786234");
 			SharedDriver.pageContainer.vendorPageNAV.AddresIndustryKey("Y001, Trade/Serv/Transport");
 			SharedDriver.pageContainer.vendorPageNAV.AddresCorporateGroup("NPR-BS, NPR-Business Services");
 			
 			SharedDriver.pageContainer.vendorPageNAV.ClickLocaData_NAV();
 			SharedDriver.pageContainer.vendorPageNAV.ClickFinaceNew(); //Clicking on New Button
 		//	SharedDriver.pageContainer.vendorPageNAV.ScrollDown();
 			SharedDriver.pageContainer.vendorPageNAV.VendorPostingGroup("ICV-Trade, IC Vendor Trade");
 			SharedDriver.pageContainer.vendorPageNAV.VendorVATPostingGroup("3PV-Tax, 3rd party vendors Tax");
 			SharedDriver.pageContainer.vendorPageNAV.VendorGenPostingGroup("3PV_IMPORT, 3rd Party Vendor Trade - Import");
 			SharedDriver.pageContainer.vendorPageNAV.validateLocalTestCreate();
 			SharedDriver.pageContainer.vendorPageNAV.LocalFinanceSave();
 			
 			SharedDriver.pageContainer.vendorPageNAV.ClickPurchasingNew();
 			SharedDriver.pageContainer.vendorPageNAV.PaymentTermsCode("V004, Payment within 10 days");
 			SharedDriver.pageContainer.vendorPageNAV.PaymentMethodCode("CASH ORDER, Cashier Order");
 			SharedDriver.pageContainer.vendorPageNAV.validateLocalTestCreate();
 			SharedDriver.pageContainer.vendorPageNAV.LocalFinanceSave();
 		
 			SharedDriver.pageContainer.vendorPageNAV.submitGlobalLocalRequest();
 			SharedDriver.pageContainer.vendorPageNAV.getRequestId();
 			
 		}				
	}

/****************************************************************************************************/	
	@Test(dataProvider="Vendor_Create_Global_Disable_Bank_and_LocalData",dataProviderClass=staticProviderClass.class)
	public void Vendor_Create_Fill_In_Data_Global_Local_Bank_NAV(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			//	SharedDriver.pageContainer.vendorPageNAV.disableBankData_NAV();
 			SharedDriver.pageContainer.vendorPageNAV.VendorName(dataMap.get("Name1"));
 			SharedDriver.pageContainer.vendorPageNAV.AddressStreet("kite");//dataMap.get("Street")
 			SharedDriver.pageContainer.vendorPageNAV.AddresHouseNumber("11"); //dataMap.get("House number")
 			SharedDriver.pageContainer.vendorPageNAV.AddresPostalCode("56478"); //dataMap.get("Postal Code")
 			SharedDriver.pageContainer.vendorPageNAV.AddresCity("holland");
 			SharedDriver.pageContainer.vendorPageNAV.ScrollDown();
 			//'DropDowns
 			SharedDriver.pageContainer.vendorPageNAV.AddresCountry("DZ, Algeria"); //dataMap.get("Country")
 			SharedDriver.pageContainer.vendorPageNAV.AddresLanguageKey("EN, English");
 			SharedDriver.pageContainer.vendorPageNAV.AddressCreditInformationNumber("465786234");
 			SharedDriver.pageContainer.vendorPageNAV.AddresIndustryKey("Y001, Trade/Serv/Transport");
 			SharedDriver.pageContainer.vendorPageNAV.AddresCorporateGroup("NPR-BS, NPR-Business Services");
 			
 			SharedDriver.pageContainer.vendorPageNAV.ClickBankData_NAV();
 			
 			SharedDriver.pageContainer.vendorPageNAV.ClickBankDetailsNew();
 			SharedDriver.pageContainer.vendorPageNAV.VendorBankCountry("DZ, Algeria");
 			SharedDriver.pageContainer.vendorPageNAV.SelectBankKey("002");
 			SharedDriver.pageContainer.vendorPageNAV.VendorCurrencyCode("DZD, Algerian Dinar");
 			SharedDriver.pageContainer.vendorPageNAV.VendorPatnerBankType("DE01");
 					
 			SharedDriver.pageContainer.vendorPageNAV.ClickLocaData_NAV();
 			SharedDriver.pageContainer.vendorPageNAV.ClickFinaceNew(); 
 		//	SharedDriver.pageContainer.vendorPageNAV.ScrollDown();
 			SharedDriver.pageContainer.vendorPageNAV.VendorPostingGroup("ICV-Trade, IC Vendor Trade");
 			SharedDriver.pageContainer.vendorPageNAV.VendorVATPostingGroup("3PV-Tax, 3rd party vendors Tax");
 			SharedDriver.pageContainer.vendorPageNAV.VendorGenPostingGroup("3PV_IMPORT, 3rd Party Vendor Trade - Import");
 			SharedDriver.pageContainer.vendorPageNAV.validateLocalTestCreate();
 			SharedDriver.pageContainer.vendorPageNAV.LocalFinanceSave();
 			
 			SharedDriver.pageContainer.vendorPageNAV.ClickPurchasingNew();
 			SharedDriver.pageContainer.vendorPageNAV.PaymentTermsCode("V004, Payment within 10 days");
 			SharedDriver.pageContainer.vendorPageNAV.PaymentMethodCode("CASH ORDER, Cashier Order");
 			SharedDriver.pageContainer.vendorPageNAV.validateLocalTestCreate();
 			SharedDriver.pageContainer.vendorPageNAV.LocalFinanceSave();
 		
 			SharedDriver.pageContainer.vendorPageNAV.submitGlobalLocalRequest();
 			SharedDriver.pageContainer.materialPage.getRequestId_CreateNew(suiteName);
 			
 			SharedDriver.pageContainer.vendorPageNAV.submitBankRequest(); 			
 		}
	}	
	
/****************************************************************************************************/
	@Test(dataProvider="Vendor_Create_Global_Disable_Bank_and_LocalData",dataProviderClass=staticProviderClass.class)
	public void Vendor_Create_Fill_In_Data_SavaASDraft(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			SharedDriver.pageContainer.vendorPage.disableLocaData();
 			SharedDriver.pageContainer.vendorPage.disableBankData();
 			SharedDriver.pageContainer.vendorPage.VendorName(dataMap.get("Name1"));
 			SharedDriver.pageContainer.vendorPage.AddressStreet("Hauptstrasse");//dataMap.get("Street")
 			SharedDriver.pageContainer.vendorPage.AddresHouseNumber("11"); //dataMap.get("House number")
 			SharedDriver.pageContainer.vendorPage.AddresPostalCode("2551"); //dataMap.get("Postal Code")
 			SharedDriver.pageContainer.vendorPage.AddresCity("Enzesfeld-Lindabrunn");
 			SharedDriver.pageContainer.vendorPage.ScrollDown();
 			//'DropDowns
 			SharedDriver.pageContainer.vendorPage.AddresCountry("AT, Austria"); //dataMap.get("Country")
 			SharedDriver.pageContainer.vendorPage.AddresRegion("NOE, Lower Austria");  //dataMap.get("Region")
 			SharedDriver.pageContainer.vendorPage.AddresLanguageKey("EN, English");
 			SharedDriver.pageContainer.vendorPage.AddressCreditInformationNumber("301536819");
 			SharedDriver.pageContainer.vendorPage.AddresIndustryKey("Y001, Trade/Serv/Transport");
 			SharedDriver.pageContainer.vendorPage.AddresCorporateGroup("PR-PACK, PR-Packaging materials");
 			SharedDriver.pageContainer.vendorPage.validateTestCreate();
 			
 			SharedDriver.pageContainer.vendorPage.SaveAsDraft();
 			SharedDriver.pageContainer.vendorPage.getRequestId_Draft(suiteName);
 			SharedDriver.pageContainer.processInfoPage.browserClose();
	
 		}				
	}
	
/****************************************************************************************************/	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Vendor_Create_Fill_in_Data_Save_as_Draft_Submit (Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException 
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			Assert.assertTrue(SharedDriver.pageContainer.homePage.navigateToWorkflow());
 			SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
 			SharedDriver.pageContainer.processInfoPage.processInfoSearch();
 			SharedDriver.pageContainer.processInfoPage.reqIdSearch_Global(dataMap.get("RequestId"));
 			SharedDriver.pageContainer.processInfoPage.getState(dataMap.get("RequestId"));
 			SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
 			SharedDriver.pageContainer.vendorPage.Localactionbutton();
 			SharedDriver.pageContainer.vendorPage.validateTestCreate();
 			SharedDriver.pageContainer.vendorPage.submitGlobalRequestTest();
 			SharedDriver.pageContainer.vendorPage.submitRequestPopup();
	
 		}		
	}
/****************************************************************************************************/	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Process_Information_Check(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException 
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
/****************************************************************************************************/	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Vendor_Create_Review_Global_Data_Approve_GDA(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException 
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			Assert.assertTrue(SharedDriver.pageContainer.homePage.navigateToWorkflow());
 			SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
 			SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
 			SharedDriver.pageContainer.materialApprovalPage.approvalBtnClick();
 			SharedDriver.pageContainer.vendorPage.duplicateCheck();	
 		}	
	}
/****************************************************************************************************/	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Vendor_Create_Review_Global_Data_Reject_GDA(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			Assert.assertTrue(SharedDriver.pageContainer.homePage.navigateToWorkflow());
 			SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
 			SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
 			SharedDriver.pageContainer.vendorPage.RejectGDA(); 			
 		}
	}
	
/****************************************************************************************************/	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Create_Vendor_Rejections_with_Discard  (Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException 
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			try{
 				System.out.println("Start:Create_Vendor_Rejections_with_Discard");

 				SharedDriver.pageContainer.homePage.navigateToWorkflow();
 				SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
 				SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
 				SharedDriver.pageContainer.vendorPage.DiscardCreateLDR();
 				
 				System.out.println("End:Create_Vendor_Rejections_with_Discard-Done");
 				
 			}catch(Exception e){
 				
 				System.out.println("Create_vendor_Rejections_with_Discard is not completed");
 				driver.close();
 			} 			
 		}
	}
	
/****************************************************************************************************/	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Vendor_Create_Syndication_Check (Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException 
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			SharedDriver.pageContainer.homePage.navigateToWorkflow();
 			SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
 			SharedDriver.pageContainer.vendorPage.navigateToDashboard();
 			SharedDriver.pageContainer.vendorPage.advancedSearch();
 			SharedDriver.pageContainer.vendorPage.scrolltoGlobalSearch();
 			SharedDriver.pageContainer.vendorPage.reqIdSearchGlobal(dataMap.get("RequestId"));
 			SharedDriver.pageContainer.vendorPage.getGlobalId(suiteName);
 			SharedDriver.pageContainer.processInfoPage.browserClose();	
// 			SharedDriver.pageContainer.materialApprovalPage.launchUFT(); 			
 		}
	}
/****************************************************************************************************/	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Process_Information_Check_Discard (Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException 
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			System.out.println("Start:Process_Information_Check_Discard");
 			try{
 				SharedDriver.pageContainer.processInfoPage.processInfoSearch();
 				SharedDriver.pageContainer.processInfoPage.reqIdSearch_Global(dataMap.get("RequestId"));
 				SharedDriver.pageContainer.processInfoPage.getState(dataMap.get("RequestId"));
 				SharedDriver.pageContainer.processInfoPage.ValidateStateDiscarded(dataMap.get("RequestId"));
 				SharedDriver.pageContainer.processInfoPage.browserClose();
 				System.out.println("Process_Information_Check_Discard-Done");
 				
 			}catch(Exception e){
 				
 				System.out.println("Process_Information_Check_Discard is not completed");
 				driver.close();
 			}	
 		}				
	}
	
/****************************************************************************************************/	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Vendor_Create_Review_Local_Data_Approve_LDS(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException 
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			Assert.assertTrue(SharedDriver.pageContainer.homePage.navigateToWorkflow());
 			SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
 			SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
 			SharedDriver.pageContainer.vendorPageNAV.markViewsBtnClick_Local();
 			SharedDriver.pageContainer.vendorPageNAV.submitRequestPopup_NAV();
 			//SharedDriver.pageContainer.vendorPageNAV.approveLocalRequest();
 			SharedDriver.pageContainer.vendorPageNAV.submitLocalRequest();
 	        SharedDriver.pageContainer.vendorPageNAV.submitRequestPopup_NAV();
 			
 			/*SharedDriver.pageContainer.vendorPage.duplicateCheck();*/	 			
 		}
	}
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Vendor_Create_Review_Local_Data_reApprove_LDS(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException 
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{

 			//SharedDriver.pageContainer.vendorPage.clickLocalAction_Local();
 				//		SharedDriver.pageContainer.materialNavPage.clickLocalAction();
 				SharedDriver.pageContainer.materialNavPage.submitGlobalRequestTest();
 				SharedDriver.pageContainer.materialPage.duplicateCheck_New();
 				SharedDriver.pageContainer.vendorPage.getRequestId_Vendor(suiteName);
 			
 			/*SharedDriver.pageContainer.vendorPage.duplicateCheck();*/	
 			
 		}
	}
/***************************************************************************************************/	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Vendor_Create_Review_Local_Data_Reject_LDS(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			Assert.assertTrue(SharedDriver.pageContainer.homePage.navigateToWorkflow());
 			SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
 			SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
 			SharedDriver.pageContainer.vendorPageNAV.RejectLocaRequestLDS(); 			
 		}
	}
	
/****************************************************************************************************/	
	@Test(dataProvider="Vendor_Create_Global_Disable_Bank_and_LocalData",dataProviderClass=staticProviderClass.class)
	public void Vendor_Change_Fill_In_Data_Global_Local_Bank_NAV(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			SharedDriver.pageContainer.vendorPageNAV.VendorName(dataMap.get("Name1"));
 			SharedDriver.pageContainer.vendorPageNAV.SearchTerm(dataMap.get("Search Term 2"));		
 			SharedDriver.pageContainer.vendorPageNAV.AddressStreet(dataMap.get("Street"));
 			SharedDriver.pageContainer.vendorPageNAV.AddresHouseNumber(dataMap.get("House number")); 
 			SharedDriver.pageContainer.vendorPageNAV.AddresPostalCode(dataMap.get("Postal Code")); 
 			SharedDriver.pageContainer.vendorPageNAV.AddresCity(dataMap.get("City"));
 			SharedDriver.pageContainer.vendorPageNAV.ScrollDown();
 			//'DropDowns
 			SharedDriver.pageContainer.vendorPageNAV.AddresCountry(dataMap.get("Country"));
 			SharedDriver.pageContainer.vendorPageNAV.AddresLanguageKey(dataMap.get("Language Key"));
 			SharedDriver.pageContainer.vendorPageNAV.AddressCreditInformationNumber(dataMap.get("Credit Information Number"));
 			SharedDriver.pageContainer.vendorPageNAV.AddresIndustryKey(dataMap.get("Industry Key"));
 			SharedDriver.pageContainer.vendorPageNAV.AddresCorporateGroup(dataMap.get("Corporate Group"));
 			
 			SharedDriver.pageContainer.vendorPageNAV.ClickBankData_NAV();
 			
 			SharedDriver.pageContainer.vendorPageNAV.ClickBankDetailsNew();
 			SharedDriver.pageContainer.vendorPageNAV.VendorBankCountry("DZ, Algeria");
 			SharedDriver.pageContainer.vendorPageNAV.SelectBankKey("002");
 			SharedDriver.pageContainer.vendorPageNAV.VendorCurrencyCode("DZD, Algerian Dinar");
 			SharedDriver.pageContainer.vendorPageNAV.VendorPatnerBankType("DE01");
 					
 			SharedDriver.pageContainer.vendorPageNAV.ClickLocaData_NAV();
 			//SharedDriver.pageContainer.vendorPageNAV.s
 			SharedDriver.pageContainer.vendorPageNAV.ClickFinaceNew(); 
 		//	SharedDriver.pageContainer.vendorPageNAV.ScrollDown();
 			SharedDriver.pageContainer.vendorPageNAV.VendorPostingGroup("ICV-Trade, IC Vendor Trade");
 			SharedDriver.pageContainer.vendorPageNAV.VendorVATPostingGroup("3PV-Tax, 3rd party vendors Tax");
 			SharedDriver.pageContainer.vendorPageNAV.VendorGenPostingGroup("3PV_IMPORT, 3rd Party Vendor Trade - Import");
 			SharedDriver.pageContainer.vendorPageNAV.validateLocalTestCreate();
 			SharedDriver.pageContainer.vendorPageNAV.LocalFinanceSave();
 			
 			SharedDriver.pageContainer.vendorPageNAV.ClickPurchasingNew();
 			SharedDriver.pageContainer.vendorPageNAV.PaymentTermsCode("V004, Payment within 10 days");
 			SharedDriver.pageContainer.vendorPageNAV.PaymentMethodCode("CASH ORDER, Cashier Order");
 			SharedDriver.pageContainer.vendorPageNAV.validateLocalTestCreate();
 			SharedDriver.pageContainer.vendorPageNAV.LocalFinanceSave();
 		
 			SharedDriver.pageContainer.vendorPageNAV.submitGlobalLocalRequest();
 			SharedDriver.pageContainer.vendorPageNAV.getRequestId();
 			
 			SharedDriver.pageContainer.vendorPageNAV.submitBankRequest(); 			
 		}
	}
/***************************************************************************************************************************************/
	@Test(dataProvider="Vendor_Create_Global_Disable_Bank_and_LocalData",dataProviderClass=staticProviderClass.class)
	public void Vendor_Change_Fill_In_Data_Global_NAV(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			SharedDriver.pageContainer.vendorPageNAV.VendorName(dataMap.get("Name1"));
 			SharedDriver.pageContainer.vendorPageNAV.SearchTerm(dataMap.get("Search Term 2"));
 			SharedDriver.pageContainer.vendorPageNAV.AddressStreet(dataMap.get("Street"));
 			SharedDriver.pageContainer.vendorPageNAV.AddresHouseNumber(dataMap.get("House number"));
 			SharedDriver.pageContainer.vendorPageNAV.AddresPostalCode(dataMap.get("Postal Code")); 
 			SharedDriver.pageContainer.vendorPageNAV.AddresCity(dataMap.get("City"));
 			//SharedDriver.pageContainer.vendorPageNAV.ScrollDown();
 			//'DropDowns
 			SharedDriver.pageContainer.vendorPageNAV.clickCountry(dataMap.get("Country"));
 			SharedDriver.pageContainer.vendorPageNAV.clickLanguageKey(dataMap.get("Language Key"));
 			SharedDriver.pageContainer.vendorPageNAV.AddressCreditInformationNumber(dataMap.get("Credit Information Number"));
 			SharedDriver.pageContainer.vendorPageNAV.clickIndustryKey(dataMap.get("Industry Key"));
 			SharedDriver.pageContainer.vendorPageNAV.clickCorporateGroup(dataMap.get("Corporate Group"));
 			//SharedDriver.pageContainer.vendorPageNAV.AddresCompanyTrading(dataMap.get("Company Trading Partner"));
 			SharedDriver.pageContainer.vendorPage.Localactionbutton();
 			SharedDriver.pageContainer.vendorPageNAV.validateTestCreate();
 			SharedDriver.pageContainer.vendorPageNAV.duplicateCheckButton();
 			SharedDriver.pageContainer.vendorPageNAV.clickDuplicateCheck();		
 			//SharedDriver.pageContainer.vendorPageNAV.submitGlobalRequestTest();
 			SharedDriver.pageContainer.vendorPageNAV.submitGlobalRequest();
 			SharedDriver.pageContainer.materialApprovalPage.submitRequestOkButtonClick();	
 		}		
	}
		
	@Test(dataProvider="CreateVendor_Fill_In_Local",dataProviderClass=staticProviderClass.class)	
	public void Vendor_Change_Fill_In_Data_Local_NAV(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			SharedDriver.pageContainer.vendorPageNAV.ClickLocaData_NAV();
 			SharedDriver.pageContainer.vendorPageNAV.selectVendorFinancePlant();
 			SharedDriver.pageContainer.vendorPageNAV.ClickFinaceEdit();
 		//	SharedDriver.pageContainer.vendorPageNAV.ScrollDown();
 			SharedDriver.pageContainer.vendorPageNAV.clickAndSelectVendorPostingGroupDropDown(dataMap.get("Vendor Posting Group"));
 			SharedDriver.pageContainer.vendorPageNAV.clickAndSelectVATBusPostingGroupDropDown(dataMap.get("VAT Bus. Posting Group"));
 			//SharedDriver.pageContainer.vendorPageNAV.VendorGenPostingGroup("3PV_IMPORT, 3rd Party Vendor Trade - Import");
 			//SharedDriver.pageContainer.vendorPage.Localactionbutton();
 			SharedDriver.pageContainer.vendorPageNAV.validateLocalTestCreate();
 			SharedDriver.pageContainer.vendorPageNAV.LocalFinanceSave();
 			
 			SharedDriver.pageContainer.vendorPageNAV.ClickPurchasingTab();
 			//SharedDriver.pageContainer.vendorPageNAV.selectVendorPurchasingPlant();
 			SharedDriver.pageContainer.vendorPageNAV.ClickPurchasingEdit();
 			SharedDriver.pageContainer.vendorPageNAV.clickAndSelectPaymentTCDropDown(dataMap.get("Payment Terms Code"));
 			SharedDriver.pageContainer.vendorPageNAV.clickAndSelectPaymentMCDropDown(dataMap.get("Payment Method Code"));
 			SharedDriver.pageContainer.vendorPageNAV.validateLocalTestCreate();
 			SharedDriver.pageContainer.vendorPageNAV.LocalFinanceSave();
 			//SharedDriver.pageContainer.materialApprovalPage.submitRequestOkButtonClick();
 			
 			//SharedDriver.pageContainer.vendorPageNAV.submitBankRequest(); 			
 		}
	}
	
	@Test
	public void vendor_Submit_Global_Request(ITestContext context) throws InterruptedException, FileNotFoundException, IOException
	{
		String suiteName = context.getSuite().getName();
		SharedDriver.pageContainer.materialNavPage.switchToGlobal();
		SharedDriver.pageContainer.vendorPage.Localactionbutton();
		//SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
		SharedDriver.pageContainer.materialPage.duplicateCheckButton();
		SharedDriver.pageContainer.materialPage.clickDuplicateCheck();
		SharedDriver.pageContainer.materialPage.submitGlobalRequest();
		SharedDriver.pageContainer.materialPage.getRequestId_CreateNew(suiteName);
		SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
	}
	
	@Test
	public void vendor_Submit_Local_Request() throws InterruptedException
	{
		SharedDriver.pageContainer.vendorPageNAV.submitLocalRequest();
		SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
	}

	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void vendor_Create_Review_Bank_Data_Approve_LDS(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException 
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			Assert.assertTrue(SharedDriver.pageContainer.homePage.navigateToWorkflow());
 			SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
 			SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
 			//SharedDriver.pageContainer.vendorPageNAV.markViewsBtnClick_Local();
 			//SharedDriver.pageContainer.vendorPageNAV.submitRequestPopup_NAV();
 			SharedDriver.pageContainer.materialPage.clickLocalAction();
 			SharedDriver.pageContainer.vendorPageNAV.approveBankRequest();
 	        SharedDriver.pageContainer.vendorPageNAV.submitRequestPopup_NAV();
 			
 			/*SharedDriver.pageContainer.vendorPage.duplicateCheck();*/	 			
 		}
	}
	
}

