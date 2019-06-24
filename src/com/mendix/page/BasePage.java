package com.mendix.page;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
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
	

	/* Test Code Created by Sai for UFT solution */
	public void readAndWriteInEmptyCellsOfOutputExcel() throws IOException
	{
		FileInputStream file = new FileInputStream(new File("input/MDM_Output_Dummy"+Constants.EXCEL_FORMAT_XLSX));
		workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("OutputTestData");
		Iterator rows = sheet.rowIterator();
		
		while(rows.hasNext())
		{
			XSSFRow row = (XSSFRow) rows.next();
			System.out.println("Row:");
			Iterator cells = row.cellIterator();
			
			while(cells.hasNext())
			{
				XSSFCell cell = (XSSFCell) cells.next();
				System.out.println("Cell: "+cell.toString());
			}
		}
//		for(int rn = sheet.getFirstRowNum(); rn <= sheet.getLastRowNum(); rn++)
//		{
//			Row row = sheet.getRow(rn);
//			if(row == null)
//			{
//				System.out.println("The row is empty and we can print the new test case data here");
//				
//			}
//			else
//			{
//				for(int cn = 0; cn<row.getLastCellNum(); cn++)
//				{
//					Cell cell = row.getCell(cn);
//					if(cell == null)
//					{
//						System.out.println("Cell is empty");
//					}
//					else
//					{
//						System.out.println("Cell is not empty");
//					}
//				}
//		}
			
//		}
		
	}
	

}
