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
		
		System.out.println("Test Case Values:"+dataMap.get("Test_Case"));
		String curStr = "CurrRowNo";		
		String lastStr = "LastRowNo";
		int cuurentRowFirstIndex = testCaseOutputValue.indexOf("CurrRowNo");
		int cuurentRowLastIndex = cuurentRowFirstIndex + curStr.length();
		System.out.println("cuurentRowLastIndex"+cuurentRowLastIndex);
		
		int lastRowFirstIndex = testCaseOutputValue.indexOf("LastRowNo");
		System.out.println("lastRowFirstIndex"+lastRowFirstIndex);
		int lastRowLastIndex = lastRowFirstIndex+lastStr.length();
		System.out.println("lastRowLastIndex"+lastRowLastIndex);
		String currentRowNum = testCaseOutputValue.substring(cuurentRowLastIndex, lastRowFirstIndex);
		System.out.println("current Row Num:"+currentRowNum);
		String lastRowNum = testCaseOutputValue.substring(lastRowLastIndex);
		System.out.println("Last Row Num: "+lastRowNum);
		
		String testCaseName = testCaseOutputValue.substring(0,cuurentRowFirstIndex);
		System.out.println("testCaseName: "+testCaseName);

//		if(testCaseOutputValue != null)
//		{
			System.out.println("sai coding");
			if(testCaseName.equalsIgnoreCase(testCaseValue))
			{
				System.out.println("Checking for the columns");
				SharedDriver.pageContainer.basePage.writeOutputGlobalId(globalIdValue, testCaseOutputValue);
//				SharedDriver.pageContainer.basePage.writeOutputMaterialVendorNumber(materialVendorNumberValue, testCaseOutputValue);
//				SharedDriver.pageContainer.basePage.writeOutputMindexUser(loginValue, testCaseOutputValue);
//				SharedDriver.pageContainer.basePage.writeOutputSyndicationStatus("Syndication Not Done", testCaseOutputValue);
//				SharedDriver.pageContainer.basePage.writeOutputUftUser(uftUserValue, testCaseOutputValue);
				System.out.println("Excel updation is done");
			}
			else if(currentRowNum.equals(lastRowNum))
			{
				
				System.out.println("sai ");
				BasePage.createNewRowInOutputFile(testCaseValue, globalIdValue, materialVendorNumberValue, loginValue, uftUserValue);
			}
//		}

//			System.out.println("sai coding34455");
//			BasePage.createNewRowInOutputFile(testCaseValue, globalIdValue, materialVendorNumberValue, loginValue, uftUserValue);

//		SharedDriver.pageContainer.basePage.readAndWriteInEmptyCellsOfOutputExcel();
	}
	
	
	@Test
	public void removingOldSheetAndCreatingNewOne() throws IOException
	{
			BasePage.removingSheetFromExcel();
			BasePage.addingNewSheetAndNewColumnToExcel();
			BasePage.createDummyRow();
//			BasePage.createNewRowInOutputFile(testCaseValue, globalIdValue, materialVendorNumberValue, loginValue, uftUserValue);
	}
	
	@Test
	public void sample()
	{
		System.out.println("Sample method done");
	}

	@Test
	public void waitForSpecificTimeStamp() throws InterruptedException
	{
		
		Thread.sleep(120000);
	}
}
