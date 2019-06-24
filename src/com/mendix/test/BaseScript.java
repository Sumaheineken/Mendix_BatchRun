package com.mendix.test;

import java.io.IOException;
import java.util.HashMap;

import org.testng.ITestContext;
import org.testng.annotations.Test;

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
			loginValue = dataMap.get("Login");
			testCaseValue = dataMap.get("Test_Case");
			requestIdValue = dataMap.get("RequestId");
			globalIdValue = dataMap.get("Global_ID");
			materialVendorNumberValue = dataMap.get("Material_Number_AH1");	
		}
	}
	
	@Test(dataProvider="Dashboard_Syndication_Flag_Check", dataProviderClass=staticProviderClass.class)
	public void writeIntoTestDataSheet(HashMap<String, String> dataMap, ITestContext context) throws IOException
	{
		SharedDriver.pageContainer.basePage.readAndWriteInEmptyCellsOfOutputExcel();
	}
	

}
