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
		}
	}
	
	@Test(dataProvider="Dashboard_Syndication_Flag_Check", dataProviderClass=staticProviderClass.class)
	public void writeIntoTestDataSheet(HashMap<String, String> dataMap, ITestContext context) throws IOException
	{
		String logInOutputValue = dataMap.get("Mendix_User");
		String testCaseOutputValue = dataMap.get("Test_Case");
		String globalIdOutputValue = dataMap.get("Global_ID");
		String materialVendorNumberValue = dataMap.get("Material_Number_AH1");
		String uftUserOutputValue = dataMap.get("UFT_User");
		if(logInOutputValue != null && testCaseOutputValue != null && globalIdOutputValue != null && materialVendorNumberValue != null && uftUserOutputValue != null)
		{
			if(testCaseOutputValue.equalsIgnoreCase(testCaseValue))
			{
				
			}
		}
		else
		{
			
		}
		SharedDriver.pageContainer.basePage.readAndWriteInEmptyCellsOfOutputExcel();
	}
	
	
	@Test
	public void removingOldSheetAndCreatingNewOne() throws IOException
	{
			BasePage.removingSheetFromExcel();
			BasePage.addingNewSheetAndNewColumnToExcel();	
	}

	@Test
	public void waitForSpecificTimeStamp() throws InterruptedException
	{
		
		Thread.sleep(120000);
	}
}
