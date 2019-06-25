package com.mendix.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.mendix.page.BasePage;
import com.mendix.tool.SharedDriver;
import com.mendix.util.DataProviderUtil.staticProviderClass;

public class BaseScript 
{
	
	static String dependentTCName = "";
	static String dependentGlobalId;
	static String loginValue;
	static String testCaseValue;
	static String requestIdValue;
	static String globalIdValue;
	static String materialVendorNumberValue;
	static String uftUserValue;
	
	public boolean matchTestCaseAndSuiteName(String testCaseName,String suitName){
		boolean match = false;
		if(testCaseName.equalsIgnoreCase(suitName)){
			match = true;
		}
		return match;
	}
	
	@Test(dataProvider="Process_Information_Check",dataProviderClass=staticProviderClass.class)
	public void readAndSetValuesFromDataSheet(HashMap<String, String> dataMap, ITestContext context) throws IOException
	{
		String suiteName = context.getSuite().getName();
		String testCaseName = dataMap.get("Test_Case");
		if(matchTestCaseAndSuiteName(testCaseName, suiteName))
		{
			loginValue = dataMap.get("Mendix_User");
			testCaseValue = dataMap.get("Test_Case");
			globalIdValue = dataMap.get("Global_ID");
			materialVendorNumberValue = dataMap.get("Material_Number_AH1");
			uftUserValue = dataMap.get("UFT_User");
		}
	}
	
	@Test(dataProvider="Dashboard_Syndication_Flag_Check", dataProviderClass=staticProviderClass.class)
	public void writeIntoTestDataSheet(HashMap<String, String> dataMap, ITestContext context) throws IOException
	{
		String logInOutputValue = dataMap.get("Mendix_User");
		String testCaseOutputValue = dataMap.get("Test_Case");
		String globalIdOutputValue = dataMap.get("Global_ID");
		String materialVendorNumberOutputValue = dataMap.get("Material_Number_AH1");
		String uftUserOutputValue = dataMap.get("UFT_User");
	
		if(logInOutputValue != null && testCaseOutputValue != null && globalIdOutputValue != null && materialVendorNumberOutputValue != null && uftUserOutputValue != null)
		{
			if(testCaseOutputValue.equalsIgnoreCase(testCaseValue))
			{
				SharedDriver.pageContainer.basePage.writeOutputGlobalId(globalIdValue, testCaseOutputValue);
				SharedDriver.pageContainer.basePage.writeOutputMaterialVendorNumber(materialVendorNumberValue, testCaseOutputValue);
				SharedDriver.pageContainer.basePage.writeOutputMindexUser(loginValue, testCaseOutputValue);
				SharedDriver.pageContainer.basePage.writeOutputSyndicationStatus("Syndication Not Done", testCaseOutputValue);
				SharedDriver.pageContainer.basePage.writeOutputUftUser(uftUserValue, testCaseOutputValue);
			}
			else
			{
				BasePage.createNewRowInOutputFile(testCaseValue, globalIdValue, materialVendorNumberValue, loginValue, uftUserValue);
			}
		}
		else
		{
			BasePage.createNewRowInOutputFile(testCaseValue, globalIdValue, materialVendorNumberValue, loginValue, uftUserValue);
		}
//		SharedDriver.pageContainer.basePage.readAndWriteInEmptyCellsOfOutputExcel();
	}
	
	
	@Test
	public void removingOldSheetAndCreatingNewOne() throws IOException
	{
			BasePage.removingSheetFromExcel();
			BasePage.addingNewSheetAndNewColumnToExcel();
//			BasePage.createNewRowInOutputFile(testCaseValue, globalIdValue, materialVendorNumberValue, loginValue, uftUserValue);
	}

	@Test
	public void waitForSpecificTimeStamp() throws InterruptedException
	{
		
		Thread.sleep(120000);
	}
}
