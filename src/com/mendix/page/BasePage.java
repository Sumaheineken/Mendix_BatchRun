package com.mendix.page;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.mendix.tool.Constants;
import com.mendix.tool.Sync;
import com.mendix.util.ExcelUtil;

public class BasePage extends ExcelUtil{
	
	WebDriver driver;
	

	public BasePage(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void waitForPageLoad() {
		try {
		Sync.waitUntilObjectDisappears(driver, "Wait for Location Code Select",
				By.xpath(".//*[@id='mxui_widget_Progress_0']/div[2]"));
		} catch(NoSuchElementException | TimeoutException ex) {
		   
		}
		
	}
	
	
	public static void removingSheetFromExcel() 
	{
		try {
			System.out.println("Geting into the method and then checking for the excel sheet");
			FileInputStream file = new FileInputStream("input/MDM_Output"+Constants.EXCEL_FORMAT_XLSX);//input/MDM_Output"+Constants.EXCEL_FORMAT_XLSX));
			workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet("OutputTestData");
			
			if(sheet.getSheetName().equalsIgnoreCase("OutputTestData"))
			{
				workbook.removeSheetAt(0);
			}
			//file.close();
			FileOutputStream output = new FileOutputStream("input/MDM_Output"+Constants.EXCEL_FORMAT_XLSX); //input/MDM_Output"+Constants.EXCEL_FORMAT_XLSX);
			workbook.write(output);
			output.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void addingNewSheetAndNewColumnToExcel()
	{
		
		workbook = new XSSFWorkbook();
		try {
			FileOutputStream output = new FileOutputStream("input/MDM_Output"+Constants.EXCEL_FORMAT_XLSX);
			CreationHelper createHelper = workbook.getCreationHelper();
			Sheet sheet1 = workbook.createSheet("OutputTestData");
			Row headerRow = sheet1.createRow(0);
//			headerRow.createCell(0).setCellValue(createHelper.createRichTextString("Sl.No"));
			headerRow.createCell(0).setCellValue(createHelper.createRichTextString("Test_Case"));
			headerRow.createCell(1).setCellValue(createHelper.createRichTextString("Global_ID"));
			headerRow.createCell(2).setCellValue(createHelper.createRichTextString("Material_Number_AH1"));
			headerRow.createCell(3).setCellValue(createHelper.createRichTextString("Mendix_User"));
			headerRow.createCell(4).setCellValue(createHelper.createRichTextString("Syndication_Status"));
			headerRow.createCell(5).setCellValue(createHelper.createRichTextString("UFT_User"));
			headerRow.createCell(6).setCellValue(createHelper.createRichTextString("Result"));
			
			workbook.write(output);
			output.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void createDummyRow()
	{
		try
		{
			FileInputStream file = new FileInputStream("input/MDM_Output"+Constants.EXCEL_FORMAT_XLSX);
			workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet("OutputTestData");
			int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
			System.out.println("The rowCount is : "+rowCount);
			Row row = sheet.getRow(0);
			
			Row newRow = sheet.createRow(rowCount+1);
			
			for(int i=0; i< row.getLastCellNum(); i++)
			{
				Cell cell = newRow.createCell(i);
				cell.setCellValue("DummyRow");
			}
				
				FileOutputStream output = new FileOutputStream("input/MDM_Output"+Constants.EXCEL_FORMAT_XLSX);
				workbook.write(output);
				output.close();
				file.close();
//			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
	}

	
	public static void createNewRowInOutputFile(String testCaseValue, String globalIdValue, String materialVendorNumberValue,String loginValue, String uftUserValue)
	{
		try
		{
			FileInputStream file = new FileInputStream("input/MDM_Output"+Constants.EXCEL_FORMAT_XLSX);
			workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet("OutputTestData");
			int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
			System.out.println("The rowCount is : "+rowCount);
			Row row = sheet.getRow(0);
			
			Row newRow = sheet.createRow(rowCount+1);
			
//			for(int i=0; i< row.getLastCellNum(); i++)
//			{
//				Cell cell0 = newRow.createCell(0);
//				int serialNumber = cell0.getRowIndex();
//				String serialSequence = "0"+serialNumber;
//				cell0.setCellValue(serialSequence);
				Cell cell0 = newRow.createCell(0);
				cell0.setCellValue(testCaseValue);
				Cell cell1 = newRow.createCell(1);
				cell1.setCellValue(globalIdValue);
				Cell cell2 = newRow.createCell(2);
				cell2.setCellValue(materialVendorNumberValue);
				Cell cell3 = newRow.createCell(3);
				cell3.setCellValue(loginValue);
				Cell cell4 = newRow.createCell(4);
				cell4.setCellValue("Syndication Not Done");
				Cell cell5 = newRow.createCell(5);
				cell5.setCellValue(uftUserValue);
				Cell cell6 = newRow.createCell(6);
				cell6.setCellValue("null");
				
				FileOutputStream output = new FileOutputStream("input/MDM_Output"+Constants.EXCEL_FORMAT_XLSX);
				workbook.write(output);
				output.close();
				file.close();
//			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void writeOutputGlobalId(String testCaseOutputValue, String globalIdValue) {
		
		System.out.println(globalIdValue);
		System.out.println("Moving onto the excel");
		ExcelUtil.setCellDataOutputFile_globalId("OutputTestData", "Global_ID", globalIdValue, testCaseOutputValue);
		
	}

	public static void writeOutputMaterialVendorNumber(String materialVendorNumberValue, String testCaseOutputValue) {
		
		ExcelUtil.setCellDataOutputFile_MaterialVendorNumber("OutputTestData", "Material_Number_AH1", materialVendorNumberValue, testCaseOutputValue);
		System.out.println(materialVendorNumberValue);
	}

	public static void writeOutputMindexUser(String loginValue, String testCaseOutputValue) {
		
		ExcelUtil.setCellDataOutputFile_MendixUser("OutputTestData", "Mendix_User", loginValue, testCaseOutputValue);
		System.out.println(loginValue);
		
	}

	
	public static void writeOutputSyndicationStatus(String syndicationValue, String testCaseOutputValue) {
		
		ExcelUtil.setCellDataOutputFile_Syndication("OutputTestData", "Syndication_Status", syndicationValue, testCaseOutputValue);
		System.out.println(syndicationValue);
		
	}

	public static void writeOutputUftUser(String uftUserValue, String testCaseOutputValue) {
		
		ExcelUtil.setCellDataOutputFile_UftUser("OutputTestData", "UFT_User", uftUserValue, testCaseOutputValue);
		System.out.println(uftUserValue);
	}

}
