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

public class VendorScript extends BaseScript{
	
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
	
	@Test(dataProvider="Vendor_Create_Global_Disable_Bank_and_LocalData",dataProviderClass=staticProviderClass.class)
	public void Vendor_Create_Fill_In_Data_Bank_sap(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			SharedDriver.pageContainer.vendor_JDE_Page.clickNewBankButtonsap();	
 			
 			SharedDriver.pageContainer.vendorPageNAV.VendorBankCountry_SAP();
 			SharedDriver.pageContainer.vendorPageNAV.SelectBankKey_SAP(); 
 			SharedDriver.pageContainer.vendor_JDE_Page.enterBankaccountsap();
 			SharedDriver.pageContainer.vendor_JDE_Page.partnerbank("BE01");		
 			SharedDriver.pageContainer.vendor_JDE_Page.clickSaveBankDetails();		
 			SharedDriver.pageContainer.vendorPage.clickLocalAction_Bank();
 			SharedDriver.pageContainer.vendorPage.submitBankRequestTest();
 			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();			
 		}
	}
	@Test(dataProvider="Vendor_Create_Global_Disable_Bank_and_LocalData",dataProviderClass=staticProviderClass.class)
	public void Vendor_change_Fill_In_Data_Bank_sap(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			SharedDriver.pageContainer.vendor_JDE_Page.clickNewBankButtonsap();	
 			
 			SharedDriver.pageContainer.vendorPageNAV.VendorBankCountry_SAP();
 			SharedDriver.pageContainer.vendorPageNAV.SelectBankKey_SAP(); 
 			SharedDriver.pageContainer.vendor_JDE_Page.enterBankaccountsap();
 			SharedDriver.pageContainer.vendor_JDE_Page.partnerbank("BE02");		
 			SharedDriver.pageContainer.vendor_JDE_Page.clickSaveBankDetails();		
 			SharedDriver.pageContainer.vendorPage.clickLocalAction_Bank();
 			SharedDriver.pageContainer.vendorPage.submitBankRequestTest();
 			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();			
 		}
	}


	@Test(dataProvider="Vendor_Create_Global_Disable_Bank_and_LocalData",dataProviderClass=staticProviderClass.class)
	public void vendor_Create_Fill_In_Data_Global_Nav(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			Sync.waitForSeconds(Constants.WAIT_10);
 			//SharedDriver.pageContainer.vendorPage.disableLocaData();
 			//Sync.waitForSeconds(Constants.WAIT_10);
 			SharedDriver.pageContainer.materialPage.clickLocalAction();
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
 			//SharedDriver.pageContainer.materialPage.duplicateCheckButton();
 			//SharedDriver.pageContainer.materialPage.clickDuplicateCheck();
 			//SharedDriver.pageContainer.vendorPage.submitGlobalRequestTest();
// 			SharedDriver.pageContainer.vendorPage.getRequestId(); 			
 		}
				
	}
	
	@Test(dataProvider="Vendor_Create_Global_Disable_Bank_and_LocalData",dataProviderClass=staticProviderClass.class)
	public void Vendor_Create_local_Fill_In_Data(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			SharedDriver.pageContainer.vendor_JDE_Page.enterLocalData();
 		    SharedDriver.pageContainer.vendor_JDE_Page.textAddclick();		
 			SharedDriver.pageContainer.vendor_JDE_Page.Search();		
 			SharedDriver.pageContainer.vendor_JDE_Page.textisoinput("BE10");		
 			SharedDriver.pageContainer.vendor_JDE_Page.Search1();
 			SharedDriver.pageContainer.vendor_JDE_Page.textselect();
 			SharedDriver.pageContainer.vendor_JDE_Page.Select();
 			SharedDriver.pageContainer.vendor_JDE_Page.editAccounting();		
 			//SharedDriver.pageContainer.materialPage.clickOkToHandlePopup();
 			Sync.waitForSeconds(Constants.WAIT_10);
 			SharedDriver.pageContainer.vendor_JDE_Page.selectReconciliation("0014201001, Acc Payable Trade - Third Party Suppliers <1Yr");
 			Sync.waitForSeconds(Constants.WAIT_10);
 			SharedDriver.pageContainer.vendor_JDE_Page.selectcashmanagement("YT, Trade vendors");
 			Sync.waitForSeconds(Constants.WAIT_10);

 			Sync.waitForSeconds(Constants.WAIT_10);
 			SharedDriver.pageContainer.vendor_JDE_Page.selectsortkey("001, Posting date");
 			Sync.waitForSeconds(Constants.WAIT_10);
 			SharedDriver.pageContainer.vendor_JDE_Page.termsofpayment("V000, Pay immediately");
 			Sync.waitForSeconds(Constants.WAIT_10);
 			SharedDriver.pageContainer.vendor_JDE_Page.validateandSave();
 			Sync.waitForSeconds(Constants.WAIT_10);
 			SharedDriver.pageContainer.vendor_JDE_Page.clickpurchasingData();
 			Sync.waitForSeconds(Constants.WAIT_10);
 			SharedDriver.pageContainer.vendor_JDE_Page.addpurchasing();	
 			Sync.waitForSeconds(Constants.WAIT_10);
 			SharedDriver.pageContainer.vendor_JDE_Page.Searchinpurchasing();
 			Sync.waitForSeconds(Constants.WAIT_10);
 			SharedDriver.pageContainer.vendor_JDE_Page.inputiso("BE01");
 			Sync.waitForSeconds(Constants.WAIT_10);
 			SharedDriver.pageContainer.vendor_JDE_Page.clicksearch1();
 			Sync.waitForSeconds(Constants.WAIT_10);
 			SharedDriver.pageContainer.vendor_JDE_Page.selectbe();
 			Sync.waitForSeconds(Constants.WAIT_10);
 			SharedDriver.pageContainer.vendor_JDE_Page.Select();
 			Sync.waitForSeconds(Constants.WAIT_10);
 			SharedDriver.pageContainer.vendor_JDE_Page.editpurchasing();
 			Sync.waitForSeconds(Constants.WAIT_10);
 			SharedDriver.pageContainer.vendor_JDE_Page.purchaseorder("CHF, Swiss Franc");
 			Sync.waitForSeconds(Constants.WAIT_10);
 			SharedDriver.pageContainer.vendor_JDE_Page.termspurchasing("V000, Pay immediately");
 			Sync.waitForSeconds(Constants.WAIT_10);
 			
 			SharedDriver.pageContainer.vendor_JDE_Page.validateandSave();
 			Sync.waitForSeconds(Constants.WAIT_10);
 			SharedDriver.pageContainer.vendor_JDE_Page.submitLocal();
 			Sync.waitForSeconds(Constants.WAIT_10);
 			SharedDriver.pageContainer.materialPage.clickOkToHandlePopup();
 			
 			
 			//SharedDriver.pageContainer.vendorPage.validateTestCreate();
 			//SharedDriver.pageContainer.materialPage.duplicateCheckButton();
 			//SharedDriver.pageContainer.materialPage.clickDuplicateCheck();
 			//SharedDriver.pageContainer.vendorPage.submitGlobalRequestTest();
// 			SharedDriver.pageContainer.vendorPage.getRequestId(); 			
 		}
				
	}
	@Test(dataProvider="Vendor_Create_Global_Disable_Bank_and_LocalData",dataProviderClass=staticProviderClass.class)
	public void Vendor_Change_local_Fill_In_Data(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			SharedDriver.pageContainer.vendor_JDE_Page.enterLocalData();
 		    SharedDriver.pageContainer.vendor_JDE_Page.textAddclick();		
 			SharedDriver.pageContainer.vendor_JDE_Page.Search();		
 			SharedDriver.pageContainer.vendor_JDE_Page.textisoinput("BE11");		
 			SharedDriver.pageContainer.vendor_JDE_Page.Search1();
 			SharedDriver.pageContainer.vendor_JDE_Page.textselect();
 			SharedDriver.pageContainer.vendor_JDE_Page.Select();
 			SharedDriver.pageContainer.vendor_JDE_Page.editAccounting();		
 			//SharedDriver.pageContainer.materialPage.clickOkToHandlePopup();
 			Sync.waitForSeconds(Constants.WAIT_10);
 			SharedDriver.pageContainer.vendor_JDE_Page.selectReconciliation("0014201101, AP THIRD PARTY SUPPL <1YR OWNERS");
 			Sync.waitForSeconds(Constants.WAIT_10);
 			
 			SharedDriver.pageContainer.vendor_JDE_Page.selectcashmanagement("YV, Employee Vendors");
 			Sync.waitForSeconds(Constants.WAIT_10);
 			
 			Sync.waitForSeconds(Constants.WAIT_10);
 			SharedDriver.pageContainer.vendor_JDE_Page.selectsortkey("009, External doc.number");
 			Sync.waitForSeconds(Constants.WAIT_10);
 			SharedDriver.pageContainer.vendor_JDE_Page.termsofpayment("V000, Pay immediately");
 			Sync.waitForSeconds(Constants.WAIT_10);
 			SharedDriver.pageContainer.vendor_JDE_Page.validateandSave();
 			Sync.waitForSeconds(Constants.WAIT_10);
 			SharedDriver.pageContainer.vendor_JDE_Page.clickpurchasingData();
 			Sync.waitForSeconds(Constants.WAIT_10);
 			SharedDriver.pageContainer.vendor_JDE_Page.addpurchasing();	
 			Sync.waitForSeconds(Constants.WAIT_10);
 			SharedDriver.pageContainer.vendor_JDE_Page.Searchinpurchasing();
 			Sync.waitForSeconds(Constants.WAIT_10);
 			SharedDriver.pageContainer.vendor_JDE_Page.inputiso("BE01");
 			Sync.waitForSeconds(Constants.WAIT_10);
 			SharedDriver.pageContainer.vendor_JDE_Page.clicksearch1();
 			Sync.waitForSeconds(Constants.WAIT_10);
 			SharedDriver.pageContainer.vendor_JDE_Page.selectbe();
 			Sync.waitForSeconds(Constants.WAIT_10);
 			SharedDriver.pageContainer.vendor_JDE_Page.Select();
 			Sync.waitForSeconds(Constants.WAIT_10);
 			SharedDriver.pageContainer.vendor_JDE_Page.editpurchasing();
 			Sync.waitForSeconds(Constants.WAIT_10);
 			SharedDriver.pageContainer.vendor_JDE_Page.purchaseorder("GBP, British Pound");
 			Sync.waitForSeconds(Constants.WAIT_10);
 			SharedDriver.pageContainer.vendor_JDE_Page.termspurchasing("V002, Payment within 7 days");
 			Sync.waitForSeconds(Constants.WAIT_10);
 			
 			SharedDriver.pageContainer.vendor_JDE_Page.validateandSave();
 			Sync.waitForSeconds(Constants.WAIT_10);
 			SharedDriver.pageContainer.vendor_JDE_Page.submitLocal();
 			Sync.waitForSeconds(Constants.WAIT_10);
 			SharedDriver.pageContainer.materialPage.clickOkToHandlePopup();
 			
 			
 			//SharedDriver.pageContainer.vendorPage.validateTestCreate();
 			//SharedDriver.pageContainer.materialPage.duplicateCheckButton();
 			//SharedDriver.pageContainer.materialPage.clickDuplicateCheck();
 			//SharedDriver.pageContainer.vendorPage.submitGlobalRequestTest();
// 			SharedDriver.pageContainer.vendorPage.getRequestId(); 			
 		}				
	}
	
	@Test(dataProvider="Vendor_Create_Global_Disable_Bank_and_LocalData",dataProviderClass=staticProviderClass.class)
	public void vendor_Create_Fill_In_Data_Global_Nav_IncludeBank(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			Sync.waitForSeconds(Constants.WAIT_10);
 			//SharedDriver.pageContainer.vendorPage.disableLocaData();
 			//Sync.waitForSeconds(Constants.WAIT_10);
 			SharedDriver.pageContainer.materialPage.clickLocalAction();
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
 			//SharedDriver.pageContainer.materialPage.duplicateCheckButton();
 			//SharedDriver.pageContainer.materialPage.clickDuplicateCheck();
 			//SharedDriver.pageContainer.vendorPage.submitGlobalRequestTest();
// 			SharedDriver.pageContainer.vendorPage.getRequestId();	
 		}				
	}

/****************************************************************************************************/	

	@Test(dataProvider="Vendor_Create_Global_Disable_Bank_and_LocalData",dataProviderClass=staticProviderClass.class)
	public void Vendor_Create_Fill_In_Data(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			Sync.waitForSeconds(Constants.WAIT_10);
			SharedDriver.pageContainer.vendorPage.disableLocaData();
			Sync.waitForSeconds(Constants.WAIT_10);
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
			SharedDriver.pageContainer.materialPage.duplicateCheckButton();
			SharedDriver.pageContainer.materialPage.clickDuplicateCheck();
			//SharedDriver.pageContainer.vendorPage.submitGlobalRequestTest();
			//SharedDriver.pageContainer.vendorPage.getRequestId();
			SharedDriver.pageContainer.materialPage.getRequestId_CreateNew_Extenstion(suiteName);
			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();	
		}
		
				
	}
	
	@Test(dataProvider="Vendor_Create_Global_Disable_Bank_and_LocalData",dataProviderClass=staticProviderClass.class)
	public void Vendor_Create_Fill_In_Data_banksap(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			Sync.waitForSeconds(Constants.WAIT_10);
 			//SharedDriver.pageContainer.vendorPage.disableLocaData();
 			//Sync.waitForSeconds(Constants.WAIT_10);
 			//SharedDriver.pageContainer.vendorPage.disableBankData();
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
 			SharedDriver.pageContainer.vendorPage.validateTestCreatesap();
 			SharedDriver.pageContainer.materialPage.duplicateCheckButton();
 			SharedDriver.pageContainer.materialPage.clickDuplicateCheck();
 			//SharedDriver.pageContainer.vendorPage.submitGlobalRequestTest();
 			SharedDriver.pageContainer.vendorPage.getRequestId(suiteName);			
 		}				
	}
	
	
	/****************************************************************************************************/	
	@Test(dataProvider="Vendor_Create_Global_Disable_Bank_and_LocalData",dataProviderClass=staticProviderClass.class)
	public void Vendor_Create_Fill_In_Data_JDE(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			/*SharedDriver.pageContainer.vendorPage.disableLocaData();
 			SharedDriver.pageContainer.vendorPage.disableBankData();*/
 			SharedDriver.pageContainer.vendorPage.VendorName(dataMap.get("Name1"));
 			SharedDriver.pageContainer.vendorPage.AddressStreet("Hauptstrasse");//dataMap.get("Street")
 			SharedDriver.pageContainer.vendorPage.AddresHouseNumber("11"); //dataMap.get("House number")
 			SharedDriver.pageContainer.vendorPage.AddresPostalCode("255121"); //dataMap.get("Postal Code")
 			SharedDriver.pageContainer.vendorPage.AddresCity("Enzesfeld-Lindabrunn");
 			SharedDriver.pageContainer.vendorPage.ScrollDown();
 			//'DropDowns
 			SharedDriver.pageContainer.vendorPage.AddresCountry("SG, Singapore"); //dataMap.get("Country")
 			SharedDriver.pageContainer.vendorPage.AddresRegion("SG, Singapore");  //dataMap.get("Region")
 			SharedDriver.pageContainer.vendorPage.AddresLanguageKey("EN, English");
 			
 			SharedDriver.pageContainer.vendorPage.AddressCreditInformationNumber("301536819");
 			SharedDriver.pageContainer.vendorPage.AddresIndustryKey("Y001, Trade/Serv/Transport");
 			SharedDriver.pageContainer.vendorPage.AddresCorporateGroup("PR-PACK, PR-Packaging materials");
 			SharedDriver.pageContainer.vendorPage.clickLocalAction_Local();
 			SharedDriver.pageContainer.vendorPage.validateTestCreate();
 			
 			/*SharedDriver.pageContainer.vendorPage.submitGlobalRequestTest();
 			SharedDriver.pageContainer.vendorPage.getRequestId();*/
	
 		}				
	}
	@Test(dataProvider="Vendor_Create_Global_Disable_Bank_and_LocalData",dataProviderClass=staticProviderClass.class)
	public void Vendor_Change_Fill_In_Data_JDE(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			/*SharedDriver.pageContainer.vendorPage.disableLocaData();
 			SharedDriver.pageContainer.vendorPage.disableBankData();*/
 			SharedDriver.pageContainer.vendorPage.VendorNamechange("Name12");
 			SharedDriver.pageContainer.vendorPage.AddressStreet("Hauptstrasse");//dataMap.get("Street")
 			SharedDriver.pageContainer.vendorPage.AddresHouseNumber("11"); //dataMap.get("House number")
 			SharedDriver.pageContainer.vendorPage.AddresPostalCode("255121"); //dataMap.get("Postal Code")
 			SharedDriver.pageContainer.vendorPage.AddresPostalCodepobox("xyz"); //dataMap.get("Postal Code")
 			SharedDriver.pageContainer.vendorPage.AddresPostalCodepo("740075"); //dataMap.get("Postal Code")
 			
 			SharedDriver.pageContainer.vendorPage.AddresCity("Enzesfeld-Lindabrunn");
 			SharedDriver.pageContainer.vendorPage.ScrollDown();
 			//'DropDowns
 			SharedDriver.pageContainer.vendorPage.AddresCountry("SG, Singapore"); //dataMap.get("Country")
 			SharedDriver.pageContainer.vendorPage.AddresRegion("SG, Singapore");  //dataMap.get("Region")
 			SharedDriver.pageContainer.vendorPage.AddresLanguageKey("EN, English");
 			
 			SharedDriver.pageContainer.vendorPage.AddressCreditInformationNumber("301536819");
 			SharedDriver.pageContainer.vendorPage.AddresIndustryKey("Y001, Trade/Serv/Transport");
 			SharedDriver.pageContainer.vendorPage.AddresCorporateGroup("PR-PACK, PR-Packaging materials");
 			SharedDriver.pageContainer.vendorPage.clickLocalAction_Local();
 			SharedDriver.pageContainer.vendorPage.validateTestCreate();
 			
 			/*SharedDriver.pageContainer.vendorPage.submitGlobalRequestTest();
 			SharedDriver.pageContainer.vendorPage.getRequestId();*/	
 		}				
	}

	/****************************************************************************************************/
	@Test
	public void Vendor_Create_Fill_In_Data_JDE_Bank(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
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
 			SharedDriver.pageContainer.vendorPage.clickLocalAction_Local();
 			SharedDriver.pageContainer.vendorPage.validateTestCreate();
 			
 			//SharedDriver.pageContainer.vendorPage.submitGlobalRequestTest();
 			SharedDriver.pageContainer.vendorPage.getRequestId(suiteName);	
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
 			//SharedDriver.pageContainer.processInfoPage.browserClose();	
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
 			SharedDriver.pageContainer.materialPage.clickDuplicateCheck();
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
 			SharedDriver.pageContainer.materialPage.clickLocalAction();
 			SharedDriver.pageContainer.materialPage.validateAndDuplicateCheckButton();
 			SharedDriver.pageContainer.materialApprovalPage.clickDuplicateCheck_GDA();	
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
 			SharedDriver.pageContainer.materialPage.rejectLDS(); 			
 		}
	}
	
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Vendor_Create_Review_Global_Data_Reject_LDP(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			Assert.assertTrue(SharedDriver.pageContainer.homePage.navigateToWorkflow());
 			SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
 			SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
 			SharedDriver.pageContainer.vendorPage.RejectGDA();
 			SharedDriver.pageContainer.vendorPage.getRequestId_ffd(suiteName);
 			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();	
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
 				SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
 				System.out.println("End:Create_Vendor_Rejections_with_Discard-Done");
 				
 			}catch(Exception e){
 				
 				System.out.println("Create_vendor_Rejections_with_Discard is not completed");
 				driver.close();
 			}
 			
 		}
	}
	
/****************************************************************************************************/
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Vendor_Create_Syndication_Check_SAP (Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException 
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			SharedDriver.pageContainer.homePage.navigateToWorkflow();
 			SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
 			SharedDriver.pageContainer.vendorPage.navigateToDashboard();
 			SharedDriver.pageContainer.vendorPage.advancedSearch();
 			//SharedDriver.pageContainer.vendorPage.scrolltoGlobalSearch();
 			SharedDriver.pageContainer.vendorPage.globalSearch(dataMap.get("Global_ID"));
 			SharedDriver.pageContainer.vendorPage.checkDashboardLockVendor();
 			//SharedDriver.pageContainer.vendorPage.getGlobalId();
 			//SharedDriver.pageContainer.vendorPage.GetFullVendorData();
 			//SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
 			//SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
 			SharedDriver.pageContainer.vendorPage.getVendorAccountNumber(suiteName, dataMap.get("OpCo"));
 			SharedDriver.pageContainer.processInfoPage.browserClose();	
 		}
	}
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void process_Information_Check_GlobalID_Extend_SAP_Vendor(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException 
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
		}		
	}
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void get_Vendor_Account_Number_SAP(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException 
	{
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			SharedDriver.pageContainer.vendorPage.navigateToDashboardSearch_SAP();
			SharedDriver.pageContainer.vendorPage.advancedSearch();
			SharedDriver.pageContainer.vendorPage.globalSearch(dataMap.get("Global_ID"));
			SharedDriver.pageContainer.vendorPage.checkDashboardLockVendor();
			SharedDriver.pageContainer.vendorPage.getVendorAccountNumber(suiteName, dataMap.get("OpCo"));			
			SharedDriver.pageContainer.processInfoPage.browserClose();				
		}
	}
	
	
	@Test
	public void launchUFT_SAP_Vendor() throws IOException, InterruptedException
	{
		//Thread.sleep(1200000);
		SharedDriver.pageContainer.materialApprovalPage.launchUFTSAPVendor();
	}
	
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Vendor_Create_Syndication_Check_NAV (Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException 
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			SharedDriver.pageContainer.homePage.navigateToWorkflow();
 			SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
 			SharedDriver.pageContainer.vendorPage.navigateToDashboard();
 			SharedDriver.pageContainer.vendorPage.advancedSearch();
 			//SharedDriver.pageContainer.vendorPage.scrolltoGlobalSearch();
 			SharedDriver.pageContainer.vendorPage.globalSearch(dependentGlobalId);
 			SharedDriver.pageContainer.vendorPage.checkDashboardLockVendor();
 			//SharedDriver.pageContainer.vendorPage.getGlobalId();
 			//SharedDriver.pageContainer.vendorPage.GetFullVendorData();
 			//SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
 			//SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
 			//SharedDriver.pageContainer.vendorPage.getVendorAccountNumber();
 			SharedDriver.pageContainer.processInfoPage.browserClose();	
 		}
	}
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void vendor_Create_Syndication_Check_Extend_Nav (Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException 
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			SharedDriver.pageContainer.homePage.navigateToWorkflow();
 			SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
 			SharedDriver.pageContainer.vendorPage.navigateToDashboard();
 			SharedDriver.pageContainer.vendorPage.advancedSearch();
 			SharedDriver.pageContainer.vendorPage.globalSearch(dependentGlobalId);
 			SharedDriver.pageContainer.vendorPage.checkDashboardLockVendorExtend(dataMap.get("Global_Id"));
 			SharedDriver.pageContainer.processInfoPage.browserClose(); 			
 		}
	}
	
	@Test
	public void launchUFT_NAV_Vendor() throws IOException, InterruptedException
	{
		//Thread.sleep(1200000);
		SharedDriver.pageContainer.materialApprovalPage.launchUFT_NAV_Vendor();
	}

	
	
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
 			//SharedDriver.pageContainer.vendorPage.scrolltoGlobalSearch();
 			SharedDriver.pageContainer.vendorPage.globalSearch(dependentGlobalId);
 			SharedDriver.pageContainer.vendorPage.checkDashboardLockVendor();
 			SharedDriver.pageContainer.processInfoPage.browserClose(); 			
 		}
	}

	@Test
	public void launchUFT_JDE() throws IOException, InterruptedException
	{
		//Thread.sleep(1200000);
		SharedDriver.pageContainer.materialApprovalPage.launchUFTJDEVendor();
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
	@Test
	public void Vendor_Change_DashBoard() throws InterruptedException
	{
 			System.out.println("test");
 			Assert.assertTrue(SharedDriver.pageContainer.homePage.navigateToWorkflow());
 			SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
 			SharedDriver.pageContainer.vendorPage.clickVendor();
 			SharedDriver.pageContainer.vendorPage.clickVendorDashboard(); 			
	}
	
/****************************************************************************************************/	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Vendor_Change_DashBoard_SearchWith_GlobalID(Map<String,String> dataMap, ITestContext context) throws InterruptedException
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			SharedDriver.pageContainer.vendorPage.advancedSearch();
 			SharedDriver.pageContainer.vendorPage.globalSearch(dependentGlobalId);	 			
 			SharedDriver.pageContainer.vendorPage.GetFullVendorDataNew();
 			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
 			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
 			SharedDriver.pageContainer.vendorPage.EditVendorData();
 			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
 			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
 			//SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();	
 		}		
	}
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Vendor_Changesap_DashBoard_SearchWith_GlobalID(Map<String,String> dataMap, ITestContext context) throws InterruptedException
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			SharedDriver.pageContainer.vendorPage.advancedSearch();
 			SharedDriver.pageContainer.vendorPage.globalSearch(dependentGlobalId);	
 			SharedDriver.pageContainer.vendorPage.GetFullVendorDataNew();
 			
 			SharedDriver.pageContainer.vendorPage.EditVendorgloballovalsapData();
 		}		
	}

	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Vendor_Changejde_DashBoard_SearchWith_GlobalID(Map<String,String> dataMap, ITestContext context) throws InterruptedException
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			SharedDriver.pageContainer.vendorPage.advancedSearch();
 			SharedDriver.pageContainer.vendorPage.globalSearch(dependentGlobalId);	
 			SharedDriver.pageContainer.vendorPage.GetFullVendorDataNew();
 			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
 			SharedDriver.pageContainer.vendorPage.EditVendorgloballovajdeData();
 			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();	
 		}		
	}
	
/************************************************************************************************************/	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Vendor_Change_DashBoard_SearchWith_GlobalID_EDit_GlobalLocal(Map<String,String> dataMap, ITestContext context) throws InterruptedException
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			SharedDriver.pageContainer.materialPage.globalSearch(dependentGlobalId);
 			SharedDriver.pageContainer.vendorPage.GetFullVendorData();
 			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
 			SharedDriver.pageContainer.vendorPage.EditVendorDataGlobalLocal();
 			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp(); 			
 		}
	}
/************************************************************************************************************/
	@Test(dataProvider="Vendor_Create_Global_Disable_Bank_and_LocalData",dataProviderClass=staticProviderClass.class)
	public void Vendor_Change_Fill_In_Data(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			/*SharedDriver.pageContainer.vendorPage.disableLocaData();
 			SharedDriver.pageContainer.vendorPage.disableBankData();*/
 			SharedDriver.pageContainer.vendorPage.VendorName("Test");
 			SharedDriver.pageContainer.vendorPage.AddressStreet("Change Hauptstrasse");//dataMap.get("Street")
 			SharedDriver.pageContainer.vendorPage.AddresHouseNumber("12"); //dataMap.get("House number")
 			SharedDriver.pageContainer.vendorPage.AddresPostalCode("3551"); //dataMap.get("Postal Code")
 			SharedDriver.pageContainer.vendorPage.AddresCity("Change Enzesfeld");
 			SharedDriver.pageContainer.vendorPage.ScrollDown();
 			//'DropDowns
 			SharedDriver.pageContainer.vendorPage.AddresCountry("AT, Austria"); //dataMap.get("Country")
 			SharedDriver.pageContainer.vendorPage.AddresRegion("NOE, Lower Austria");  //dataMap.get("Region")
 			SharedDriver.pageContainer.vendorPage.AddresLanguageKey("EN, English");
 			SharedDriver.pageContainer.vendorPage.AddressCreditInformationNumber("201536819");
 			SharedDriver.pageContainer.vendorPage.AddresIndustryKey("Y001, Trade/Serv/Transport");
 			SharedDriver.pageContainer.vendorPage.AddresCorporateGroup("PR-RAW, PR-Raw Materials");
 			SharedDriver.pageContainer.vendorPage.BtnLocalActions();
 			SharedDriver.pageContainer.vendorPage.validateTestCreate();
 			
 			SharedDriver.pageContainer.materialPage.duplicateCheckButton();
 			SharedDriver.pageContainer.materialPage.clickDuplicateCheck();
 			SharedDriver.pageContainer.vendorPage.getRequestId_Vendor(suiteName);	
 		}				
	}
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Vendor_Extend_Dashboard_Check(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			SharedDriver.pageContainer.homePage.navigateToWorkflow();
 			SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
 			SharedDriver.pageContainer.vendorPage.navigateToDashboard();
 			SharedDriver.pageContainer.vendorPage.advancedSearch();
 			SharedDriver.pageContainer.materialPage.globalSearch(dependentGlobalId);
 			SharedDriver.pageContainer.vendorPage.GetFullVendorData();
 			SharedDriver.pageContainer.vendorPage.clickOkToHandlePopup();
 			SharedDriver.pageContainer.vendorPage.clickExtendButton();
 			SharedDriver.pageContainer.vendorPage.clickOkToHandlePopup();
 			SharedDriver.pageContainer.materialNavPage.switchToGlobal();
 			SharedDriver.pageContainer.vendorPage.clickToConfirm();
 			SharedDriver.pageContainer.vendorPage.clickConfirmExtension();
 			SharedDriver.pageContainer.vendorPage.clickOkToHandlePopup(); 			
 		}
	}

	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Happy_Flag_Deletion(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			SharedDriver.pageContainer.homePage.navigateToWorkflow();
 			SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
 			SharedDriver.pageContainer.vendorPage.navigateToDashboard();
 			SharedDriver.pageContainer.vendorPage.advancedSearch();
 			SharedDriver.pageContainer.vendorPage.gobalIDSearchGlobal(dataMap.get("GlobalId"));	
 			SharedDriver.pageContainer.materialPage.clickFullMaterialData();
 			SharedDriver.pageContainer.materialPage.clickOkToHandlePopup();
 			SharedDriver.pageContainer.vendorPage.clickflagDeletion();		 			
 		}
	}
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Vendor_Delete_Record_Shared_With_Multiple_Opcos(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			SharedDriver.pageContainer.homePage.navigateToWorkflow();
 			SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
 			SharedDriver.pageContainer.vendorPage.navigateToDashboard();
 			SharedDriver.pageContainer.vendorPage.advancedSearch();
 			SharedDriver.pageContainer.materialPage.globalSearch(dependentGlobalId);
 			SharedDriver.pageContainer.vendorPage.GetFullVendorData();
 			SharedDriver.pageContainer.vendorPage.clickOkOnInformationButton();
 			SharedDriver.pageContainer.vendorPage.clickOkOnInformationButton();
 			SharedDriver.pageContainer.vendorPage.clickflagDeletion();
 			SharedDriver.pageContainer.vendorPage.clickOkOnInformationButton();
 			SharedDriver.pageContainer.vendorPage.clickOkOnInformationButton();
 			SharedDriver.pageContainer.material_Change_Page.getErrorPopupMessage(); 			
 		}
	}
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Vendor_Global_LockCheck(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			/*SharedDriver.pageContainer.homePage.navigateToWorkflow();
 			SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
 			SharedDriver.pageContainer.vendorPage.navigateToDashboard();
 			SharedDriver.pageContainer.vendorPage.advancedSearch();
 			SharedDriver.pageContainer.vendorPage.globalSearch(dataMap.get("GlobalId"));
 			SharedDriver.pageContainer.vendorPage.GetFullVendorData();
 			SharedDriver.pageContainer.vendorPage.getGlobalIdNew();
 			SharedDriver.pageContainer.homePage.navigateToWorkflow();
 			SharedDriver.pageContainer.vendorPage.switchToMDMPortal();*/
 				
 			SharedDriver.pageContainer.homePage.navigateToWorkflow();
 			SharedDriver.pageContainer.vendorPage.switchToMDMPortal();	
 			SharedDriver.pageContainer.vendorPage.navigateToDashboard();
 			SharedDriver.pageContainer.vendorPage.advancedSearch();
 			SharedDriver.pageContainer.materialPage.globalSearch(dependentGlobalId);
 			SharedDriver.pageContainer.vendorPage.GetFullVendorData();
 			SharedDriver.pageContainer.vendorPage.checkGlobalIdYes();	
 			SharedDriver.pageContainer.vendorPage.navigateToDashboard();
 			SharedDriver.pageContainer.vendorPage.advancedSearch();
 			SharedDriver.pageContainer.materialPage.globalSearch(dependentGlobalId);
 			SharedDriver.pageContainer.vendorPage.checkGlobalIdYes();	
 		}	
	}

	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void vendor_Create_Review_Global_Data_Approve_LBDA(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException 
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			SharedDriver.pageContainer.homePage.navigateToWorkflow();
 			SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
 			SharedDriver.pageContainer.vendorPage.navigateToDashboard();
 			SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
 			SharedDriver.pageContainer.materialPage.clickLocalAction();
 			//SharedDriver.pageContainer.materialApprovalPage.clickApprovalButton();
 			SharedDriver.pageContainer.materialPage.duplicateCheckButton();
 			SharedDriver.pageContainer.materialApprovalPage.clickDuplicateCheck_GDA();
 			Sync.waitForSeconds(Constants.WAIT_10);
 			//SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp(); 			
 		}
	}
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void vendor_Create_Review_Global_Data_Reject_LBDA(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			Assert.assertTrue(SharedDriver.pageContainer.homePage.navigateToWorkflow());
 			SharedDriver.pageContainer.materialPage.switchToPopup();
 			SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
 			SharedDriver.pageContainer.vendorPage.rejectLBDAVendor();
 			Sync.waitForSeconds(Constants.WAIT_10);	
 		}	
	}
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void vendor_Confirm_Extension_Nav(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			SharedDriver.pageContainer.vendorPageNAV.switchToGlobal();
 			SharedDriver.pageContainer.materialPage.clickLocalAction();
 			SharedDriver.pageContainer.vendorPage.clickConfirmExtension();
 			SharedDriver.pageContainer.vendorPage.getRequestId_Extend(suiteName);
 			//SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp(); 			
 		}
	}
	
	/**********************************************************************************************************************************/
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void vendor_Extend_Global_Nav_With_Rejections(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			SharedDriver.pageContainer.homePage.navigateToWorkflow();
 			SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
 			SharedDriver.pageContainer.vendorPage.navigateToDashboard();
 			SharedDriver.pageContainer.vendorPage.advancedSearch();
 			//SharedDriver.pageContainer.vendorPage.gobalIDSearchGlobal(dataMap.get("Global_ID"));
 			//SharedDriver.pageContainer.vendorPage.globalSearch(dataMap.get("GlobalId"));
 			SharedDriver.pageContainer.materialPage.globalSearch(dependentGlobalId);
 			SharedDriver.pageContainer.vendorPage.GetFullVendorDataNew();
 			SharedDriver.pageContainer.vendorPage.clickOkOnInformationButton();
 			SharedDriver.pageContainer.vendorPage.clickOkOnInformationButton();
 			SharedDriver.pageContainer.vendorPage.clickExtendButton(); 			
 		}
	}
	
	/*******************************************************************************************************************************/
	
	@Test(dataProvider="CreateVendor_Fill_In_Local",dataProviderClass=staticProviderClass.class)
	public void vendor_Create_Fill_In_Local_Finance_Tab(Map<String,String> dataMap, ITestContext context) throws InterruptedException
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			SharedDriver.pageContainer.materialNavPage.switchToLocal();
 			SharedDriver.pageContainer.vendorPageNAV.localAddInNewFinanceNav();
 			SharedDriver.pageContainer.vendorPageNAV.clickAndSelectVendorPostingGroupDropDown(dataMap.get("Vendor Posting Group"));
 			SharedDriver.pageContainer.vendorPageNAV.clickAndSelectVATBusPostingGroupDropDown(dataMap.get("VAT Bus. Posting Group"));
 			SharedDriver.pageContainer.vendorPageNAV.validateAndSaveLocalData(); 			
 		}
	}

	/*********************************************************************************************************************************/
	
	@Test(dataProvider="CreateVendor_Fill_In_Local",dataProviderClass=staticProviderClass.class)
	public void vendor_Create_Fill_In_Local_Purchasing_Tab(Map<String,String> dataMap, ITestContext context) throws InterruptedException
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			SharedDriver.pageContainer.vendorPageNAV.localAddInPurchasingNav();
 			SharedDriver.pageContainer.vendorPageNAV.clickAndSelectPaymentTCDropDown(dataMap.get("Payment Terms Code"));
 			SharedDriver.pageContainer.vendorPageNAV.clickAndSelectPaymentMCDropDown(dataMap.get("Payment Method Code"));
 			SharedDriver.pageContainer.vendorPageNAV.validateAndSaveLocalData(); 			
 		}
	}

	/** *************************************************************************************************************************************/
	@Test(dataProvider="CreateVendor_Fill_In_Local",dataProviderClass=staticProviderClass.class)
	public void vendor_Create_Fill_In_Bank(Map<String,String> dataMap, ITestContext context) throws InterruptedException
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			SharedDriver.pageContainer.vendorPageNAV.localAddInPurchasingNav();
 			SharedDriver.pageContainer.vendorPageNAV.clickAndSelectPaymentTCDropDown(dataMap.get("Payment Terms Code"));
 			SharedDriver.pageContainer.vendorPageNAV.clickAndSelectPaymentMCDropDown(dataMap.get("Payment Method Code"));
 			SharedDriver.pageContainer.vendorPageNAV.validateAndSaveLocalData(); 			
 		}
	}

	/** *************************************************************************************************************************************/

	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void vendor_Submit_Global_And_Local_Request(Map<String,String> dataMap, ITestContext context) throws FileNotFoundException, InterruptedException, IOException
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			SharedDriver.pageContainer.materialNavPage.switchToGlobal();
 			SharedDriver.pageContainer.materialPage.clickLocalAction();
 			SharedDriver.pageContainer.materialPage.duplicateCheckButton();
 			SharedDriver.pageContainer.materialPage.clickDuplicateCheck();
 			//SharedDriver.pageContainer.materialPage.submitGlobalLocalRequest();
 			//SharedDriver.pageContainer.materialPage.clickDuplicateCheck();
 			SharedDriver.pageContainer.materialPage.getRequestId_CreateNew(suiteName);
 			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
 			Sync.waitForSeconds(Constants.WAIT_3);
 			
 		}
	}
	
	@Test
	public void vendor_Submit_Bank_Request() 
	{
		Sync.waitForSeconds(Constants.WAIT_6);
		SharedDriver.pageContainer.vendorPage.submitBankRequest();
		SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
		Sync.waitForSeconds(Constants.WAIT_3);
	}
	
	/****************************************************************************************************************************************/
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void vendor_Create_Review_Local_Data_Approve_LDS(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			Assert.assertTrue(SharedDriver.pageContainer.homePage.navigateToWorkflow());
 			SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
 			SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
 			SharedDriver.pageContainer.materialApprovalPage.approvalBtnClickLocalLDS();
 			Sync.waitForSeconds(Constants.WAIT_5);
 			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
 			//SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp(); 			
 		}
	}
	
/***********************************************************************************************************************************/
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void vendor_Reject_Resubmit_LDR(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			SharedDriver.pageContainer.homePage.navigateToWorkflow();
 			SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
 			SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
 			//SharedDriver.pageContainer.vendorPage.validateTestCreate();	
 			//SharedDriver.pageContainer.materialPage.clickLocalAction();
 			SharedDriver.pageContainer.vendorPage.clickResubmitGlobalRequest();
 			SharedDriver.pageContainer.materialPage.clickDuplicateCheck();		
 			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();	
 		}		
	}
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void vendor_Reject_discard_LDR(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			SharedDriver.pageContainer.homePage.navigateToWorkflow();
 			SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
 			SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
 			//SharedDriver.pageContainer.vendorPage.validateTestCreate();	
 			SharedDriver.pageContainer.materialPage.clickLocalAction();
 			//SharedDriver.pageContainer.materialNavPage.switchToGlobal();
 			SharedDriver.pageContainer.materialPage.DiscardCreateGDA();
 			
 			//SharedDriver.pageContainer.materialPage.clickDuplicateCheck();
 			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();	
 		}		
	}
	
	/******************************************************************************************************************************/
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void vendor_Reject_Resubmit_Local_LDR(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			SharedDriver.pageContainer.homePage.navigateToWorkflow();
 			SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
 			SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
 			//SharedDriver.pageContainer.vendorPage.validateTestCreate();		
 			SharedDriver.pageContainer.vendorPage.clickResubmitLocalRequest();
 			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp(); 			
 		}
		
	}
	/*****************************************************************************************************************************/
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void vendor_Extend_Global_Sap_With_Rejections(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			SharedDriver.pageContainer.homePage.navigateToWorkflow();
 			SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
 			SharedDriver.pageContainer.vendorPage.navigateToDashboard();
 			SharedDriver.pageContainer.vendorPage.advancedSearch();
 			SharedDriver.pageContainer.materialPage.globalSearch(dependentGlobalId);
 			SharedDriver.pageContainer.vendorPage.GetFullVendorData();	
 			SharedDriver.pageContainer.vendorPage.clickOkOnInformationButton();
 			SharedDriver.pageContainer.vendorPage.clickOkOnInformationButton();
 			SharedDriver.pageContainer.vendorPage.clickExtendButton();
 			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
 			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
 			SharedDriver.pageContainer.materialPage.clickLocalAction();
 			SharedDriver.pageContainer.vendorPage.clickConfirmExtension();
 			SharedDriver.pageContainer.vendorPage.getRequestId_Extend(suiteName);
 			//SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp(); 			
 		}
	}
	
	/*****************************************************************************************************************************/
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Happy_Flag_Deletion_Nav(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			SharedDriver.pageContainer.homePage.navigateToWorkflow();
 			SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
 			SharedDriver.pageContainer.vendorPage.navigateToDashboard();
 			SharedDriver.pageContainer.vendorPage.advancedSearch();
 			SharedDriver.pageContainer.vendorPage.globalSearch(dependentGlobalId);	
 			SharedDriver.pageContainer.vendorPage.GetFullVendorDataNew();
 			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
 			SharedDriver.pageContainer.vendorPage.clickflagDeletion();
 			SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();	
 			SharedDriver.pageContainer.vendorPage.clickConfirmFlagForDeletionButton();	
 			SharedDriver.pageContainer.vendorPage.getRequestId_ffd(suiteName);
 			//SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp(); 			
 		}
	}
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Create_Vendor_Rejections_with_Discard_Extension  (Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException 
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			try{
 				System.out.println("Start:Create_Vendor_Rejections_with_Discard");

 				SharedDriver.pageContainer.homePage.navigateToWorkflow();
 				SharedDriver.pageContainer.materialPage.switchToPopup();
 				SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
 				System.out.println("search task opened");
 				//SharedDriver.pageContainer.materialPage.clickLocalAction();
 				SharedDriver.pageContainer.vendorPage.DiscardExtensionLDR();
 				System.out.println("End:Create_Vendor_Rejections_with_Discard-Done");
 				
 			}catch(Exception e){
 				
 				System.out.println("Create_vendor_Rejections_with_Discard is not completed");
 				driver.close();
 			} 			
 		}
	}
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void Create_Vendor_Resubmit_Request  (Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException 
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			try{

 				SharedDriver.pageContainer.homePage.navigateToWorkflow();
 				SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
 				SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
 				SharedDriver.pageContainer.vendorPage.resubmitLocalRequest();
 				
 			}catch(Exception e){
 				
 				System.out.println("Create_vendor_Rejections_with_Discard is not completed");
 				driver.close();
 			}

 		}
						
	}
		
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void vendor_Extend_Global_JDE(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
     {
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			SharedDriver.pageContainer.homePage.navigateToWorkflow();
			SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
			SharedDriver.pageContainer.vendorPage.navigateToDashboard();
			SharedDriver.pageContainer.vendorPage.advancedSearch();			
			SharedDriver.pageContainer.materialPage.globalSearch(dependentGlobalId);
			SharedDriver.pageContainer.vendorPage.GetFullVendorDataNew();
			SharedDriver.pageContainer.vendorPage.clickOkOnInformationButton();	
			SharedDriver.pageContainer.vendorPage.clickOkOnInformationButton();	
			SharedDriver.pageContainer.vendorPage.clickExtendButton();
			SharedDriver.pageContainer.vendorPage.clickOkOnInformationButton();	
 		}
			
     }
		
	@Test(dataProvider="CreateVendor_Fill_In_Bank",dataProviderClass=staticProviderClass.class)
	public void vendor_Create_Fill_In_Bank_Tab(Map<String,String> dataMap, ITestContext context) throws InterruptedException
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			SharedDriver.pageContainer.vendorPageNAV.ClickBankData_NAV();
 			SharedDriver.pageContainer.vendorPageNAV.ClickBankDetailsNew();
 			SharedDriver.pageContainer.vendorPageNAV.VendorBankCountry(dataMap.get("Bank Country"));  //"PA, Panama");
 			SharedDriver.pageContainer.vendorPageNAV.SelectBankKey(dataMap.get("Bank key"));  //"002");
 			SharedDriver.pageContainer.vendorPageNAV.VendorCurrencyCode(dataMap.get("Currency Code"));  //"PAB, Panamanian Balboa")
 			SharedDriver.pageContainer.vendorPageNAV.VendorPatnerBankType(dataMap.get("Partner Bank Type"));  //"PAB"); 			
 		}
	}
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void vendor_Create_Review_Local_Data_Reject_LDS(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException, AWTException 
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
	public void change_Vendor_Rejections_with_Discard(Map<String,String> dataMap, ITestContext context) throws InterruptedException, FileNotFoundException, IOException 
	{
		String suiteName = context.getSuite().getName();
 		String testCaseName = dataMap.get("Test_Case");
 		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
 		{
 			try{
 				SharedDriver.pageContainer.homePage.navigateToWorkflow();
 				SharedDriver.pageContainer.vendorPage.switchToMDMPortal();
 				SharedDriver.pageContainer.materialApprovalPage.reqIdSearchMyTasks(dataMap.get("RequestId"));
 				SharedDriver.pageContainer.materialNavPage.switchToGlobal();
 				SharedDriver.pageContainer.materialPage.DiscardCreateGDA();
 				SharedDriver.pageContainer.materialPage.DiscardCreateLocal();
 				//SharedDriver.pageContainer.materialPage.clickCloseButtonToPopUp();
 				System.out.println("End:Change_Vendor_Rejections_with_Discard-Done");
 				
 			}catch(Exception e){
 				
 				System.out.println("Change_vendor_Rejections_with_Discard is not completed");
 				driver.close();
 			}
 			
 		}
	}

}

