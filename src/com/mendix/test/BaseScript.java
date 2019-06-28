package com.mendix.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.mendix.page.BasePage;
import com.mendix.tool.Constants;
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
			System.out.println(loginValue);
			testCaseValue = dataMap.get("Test_Case");
			globalIdValue = dataMap.get("Global_ID");
			materialVendorNumberValue = dataMap.get("Material_Number_AH1");
			uftUserValue = dataMap.get("UFT_User");
			System.out.println("Data picked up and moving on");
		}
	}
	
	@Test(dataProvider="Dashboard_Syndication_Flag_Check",dataProviderClass=staticProviderClass.class)
	public void writeIntoTestDataSheet(HashMap<String, String> dataMap) throws IOException //HashMap<String, String> dataMap
	{
		String testCaseOutputValue = dataMap.get("Test_Case");
		
		System.out.println("Test Case Value Got from DataMap:"+dataMap.get("Test_Case"));
		String curStr = "CurrRowNo";		
		String lastStr = "LastRowNo";
		int currentRowFirstIndex = testCaseOutputValue.indexOf("CurrRowNo");
		int currentRowLastIndex = currentRowFirstIndex + curStr.length();
		//System.out.println("cuurentRowLastIndex"+cuurentRowLastIndex);
		int lastRowFirstIndex = testCaseOutputValue.indexOf("LastRowNo");
		//System.out.println("lastRowFirstIndex"+lastRowFirstIndex);
		int lastRowLastIndex = lastRowFirstIndex+lastStr.length();
		//System.out.println("lastRowLastIndex"+lastRowLastIndex);
		String currentRowNum = testCaseOutputValue.substring(currentRowLastIndex, lastRowFirstIndex);
		System.out.println("current Row Num:"+currentRowNum);
		String lastRowNum = testCaseOutputValue.substring(lastRowLastIndex);
		System.out.println("Last Row Num: "+lastRowNum);
		
		String testCaseName = testCaseOutputValue.substring(0,currentRowFirstIndex);
		System.out.println("testCaseName: "+testCaseName);

		if(testCaseName.equalsIgnoreCase(testCaseValue))
		{
			System.out.println("Checking for the columns");
			BasePage.writeOutputGlobalId(globalIdValue, testCaseName);
			BasePage.writeOutputMaterialVendorNumber(materialVendorNumberValue, testCaseName);
			BasePage.writeOutputMindexUser(loginValue, testCaseName);
			BasePage.writeOutputSyndicationStatus("Syndication Not Done", testCaseName);
			BasePage.writeOutputUftUser(uftUserValue, testCaseName);
			System.out.println("Excel updation is done");
		}
		else if(currentRowNum.equals(lastRowNum))
		{		
			System.out.println("New Row is getting created as there are no rows exists with test case name");
			BasePage.createNewRowInOutputFile(testCaseValue, globalIdValue, materialVendorNumberValue, loginValue, uftUserValue);
		}

	}
	
	
	@Test
	public void removingOldSheetAndCreatingNewOne() throws IOException
	{
			BasePage.removingSheetFromExcel();
			BasePage.addingNewSheetAndNewColumnToExcel();
			BasePage.createDummyRow();
	}

	
	@Test
	public void waitForSpecificTimeStamp() throws InterruptedException
	{
		
		Thread.sleep(120000);
	}
}
