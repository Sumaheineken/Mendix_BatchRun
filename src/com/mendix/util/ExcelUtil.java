package com.mendix.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestContext;

import com.mendix.tool.Constants;
import com.mendix.test.*;
import org.testng.ITestContext;

// TODO: Auto-generated Javadoc
/**
 * The Class ExcelUtil.
 */
public class ExcelUtil {

	public static XSSFWorkbook workbook;
	public static String testCaseName= null;
	public static ITestContext context;
	
	public static LoginScript loginscript = new LoginScript();
	
	public static String Testname = null; 


	/**
	 * Gets the test data.
	 *
	 * @param strWorkbookPath the str workbook path
	 * @param strWorksheetName the str worksheet name
	 * @return the test data
	 */
	public static Iterator<Object[]> getTestData(String strWorkbookPath,String strWorksheetName){
		List<Object[]> data = new ArrayList<Object[]>();
		
		try{
		     
			FileInputStream file = new FileInputStream(new File(strWorkbookPath));

			workbook = new XSSFWorkbook(file);

			//Get first sheet from the workbook
			XSSFSheet sheet = workbook.getSheet(strWorksheetName);
		

			//Get iterator to all the rows in current sheet
			Iterator<Row> rowIterator = sheet.rowIterator();



			Row firstRow=rowIterator.next();

			Map<String,String> columnNamesMap=getColumnNames(firstRow);

			while(rowIterator.hasNext()){
				Iterator<Cell> cellIterator=rowIterator.next().cellIterator();
				Map<String,String> rowMap=new LinkedHashMap<String, String>();
				for(Entry<?, ?> entry:columnNamesMap.entrySet()){
					String strColumnName=entry.getKey().toString();
					String strValue="";
					try{
						Cell cell=cellIterator.next();
						if(cell!=null){strValue=cell.toString();}
						else
						{
							strValue = null;
						}
					}catch(Exception e){}
					rowMap.put(strColumnName, strValue.trim());
				}
				//System.out.println("rowMap Values:"+rowMap.toString());
				//if(rowMap.get("Execute").equalsIgnoreCase("Y")){	
					//rowMap.put("Iteration", ""+inRowCounter);
					data.add(new Object[]{rowMap});
					//inRowCounter++;

				//}
			}

			file.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return data.iterator();
	}
	
	public static Iterator<Object[]> getTestDataOutputSheet(String strWorkbookPath,String strWorksheetName){
		List<Object[]> data = new ArrayList<Object[]>();
		
		try{
		     
			FileInputStream file = new FileInputStream(new File(strWorkbookPath));

			workbook = new XSSFWorkbook(file);

			//Get first sheet from the workbook
			XSSFSheet sheet = workbook.getSheet(strWorksheetName);
		

			//Get iterator to all the rows in current sheet
			Iterator<Row> rowIterator = sheet.rowIterator();



			Row firstRow=rowIterator.next();

			Map<String,String> columnNamesMap=getColumnNames(firstRow);

			while(rowIterator.hasNext()){
				Row itrRow = rowIterator.next();
				Iterator<Cell> cellIterator=itrRow.cellIterator();
				Map<String,String> rowMap=new LinkedHashMap<String, String>();
				for(Entry<?, ?> entry:columnNamesMap.entrySet()){
					String strColumnName=entry.getKey().toString();
					String strValue="";
					try{
						Cell cell=cellIterator.next();
						if(cell!=null){strValue=cell.toString();}
						else
						{
							strValue = null;
						}
					}catch(Exception e){}
					String appendRowNum = strValue+"CurrRowNo"+itrRow.getRowNum()+"LastRowNo"+sheet.getLastRowNum();
					rowMap.put(strColumnName, appendRowNum.trim());
				}

				System.out.println("rowMap Values:"+rowMap.toString());
				//if(rowMap.get("Execute").equalsIgnoreCase("Y")){	
					//rowMap.put("Iteration", ""+inRowCounter);
					data.add(new Object[]{rowMap});
					//inRowCounter++;

				//}
			}

			file.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return data.iterator();
	}

	public static Iterator<Object[]> getTestDataNew(String strWorkbookPath1,String strWorksheetName1,String strWorkbookPath2,String strWorksheetName2){
		List<Object[]> data = new ArrayList<Object[]>();

		try{
			FileInputStream file1 = new FileInputStream(new File(strWorkbookPath1));
			FileInputStream file2 = new FileInputStream(new File(strWorkbookPath2));

			XSSFWorkbook workbook1 = new XSSFWorkbook(file1);
			XSSFWorkbook workbook2 = new XSSFWorkbook(file2);
			//Get first sheet from the workbook
			XSSFSheet sheet1 = workbook1.getSheet(strWorksheetName1);
			XSSFSheet sheet2 = workbook2.getSheet(strWorksheetName2);

			//Get iterator to all the rows in current sheet
			Iterator<Row> rowIterator1 = sheet1.rowIterator();
			Iterator<Row> rowIterator2 = sheet2.rowIterator();

			Row firstRow1=rowIterator1.next();
			Row firstRow2=rowIterator2.next();

			Map<String,String> columnNamesMap1=getColumnNames(firstRow1);
			Map<String,String> columnNamesMap2=getColumnNames(firstRow2);

			while(rowIterator1.hasNext()){
				Iterator<Cell> cellIterator1=rowIterator1.next().cellIterator();
				Map<String,String> rowMap1=new LinkedHashMap<String, String>();
				for(Entry<?, ?> entry:columnNamesMap1.entrySet()){
					String strColumnName1=entry.getKey().toString();
					String strValue1="";
					try{
						Cell cell1=cellIterator1.next();
						if(cell1!=null){strValue1=cell1.toString();}
					}catch(Exception e){}
					rowMap1.put(strColumnName1, strValue1.trim());
				}

				while(rowIterator2.hasNext()){
					Iterator<Cell> cellIterator2=rowIterator2.next().cellIterator();
					Map<String,String> rowMap2=new LinkedHashMap<String, String>();
					for(Entry<?, ?> entry:columnNamesMap2.entrySet()){
						String strColumnName2=entry.getKey().toString();
						String strValue2="";
						try{
							Cell cell2=cellIterator2.next();
							//							if(cell2=null){
							strValue2=cell2.toString();
							//								}
						}catch(Exception e){}
						rowMap2.put(strColumnName2, strValue2.trim());
					}
					if(rowMap2.get("Execute").equalsIgnoreCase("Y")){
						//					if(rowMap1.get("Test_Case").equals(rowMap2.get("Test_Case"))){
						//						if(rowMap1.get("OpCo").equals(rowMap2.get("OpCo"))){	
						//rowMap.put("Iteration", ""+inRowCounter);

						data.add(new Object[]{rowMap2});
						//inRowCounter++;
						//							break;

						//						}
						//					}
						//				}

					}
				}
				file1.close();
				file2.close();
			}
		}

		catch(Exception e){
			e.printStackTrace();
		}
		return data.iterator();
	}




	/**
	 * Gets the column names.
	 *
	 * @param row the row
	 * @return the column names
	 */
	private static Map<String,String> getColumnNames(Row row){
		Map<String,String> columnNamesMap=new LinkedHashMap<String, String>();

		Iterator<Cell> cells=row.cellIterator();

		while(cells.hasNext()){
			String strColumnName=cells.next().toString();
			columnNamesMap.put(strColumnName, strColumnName);
		}

		return columnNamesMap;
	}

	public static void excelWrite(String requestId)
			throws FileNotFoundException, IOException {
		try {
			FileInputStream fis = new FileInputStream("input/Mendix_TestPlan"+Constants.EXCEL_FORMAT_XLSX);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet("TestPlan");
			Cell cell = sheet.getRow(1).getCell(3);
			cell.setCellValue(requestId);
			FileOutputStream fos = new FileOutputStream("input/Mendix_TestPlan"+Constants.EXCEL_FORMAT_XLSX);
			workbook.write(fos);
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void excelWriteGlobalId(String globalId)
			throws FileNotFoundException, IOException {
		try {
			FileInputStream fis = new FileInputStream("input/Mendix_TestPlan"+Constants.EXCEL_FORMAT_XLSX);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet("TestPlan");
			Cell cell = sheet.getRow(1).getCell(4);
			cell.setCellValue(globalId);
			FileOutputStream fos = new FileOutputStream("input/Mendix_TestPlan"+Constants.EXCEL_FORMAT_XLSX);
			workbook.write(fos);
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void excelWriteMaterialNum(String materialNum)
			throws FileNotFoundException, IOException {
		try {
			FileInputStream fis = new FileInputStream("input/Mendix_TestPlan"+Constants.EXCEL_FORMAT_XLSX);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet("TestPlan");
			Cell cell = sheet.getRow(1).getCell(5);
			cell.setCellValue(materialNum);
			FileOutputStream fos = new FileOutputStream("input/Mendix_TestPlan"+Constants.EXCEL_FORMAT_XLSX);
			workbook.write(fos);
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void setCellData_New(String sheetName, String colName, String value, String suiteName)
	{
		List<Object[]> data = new ArrayList<Object[]>();
		try
		{
			FileInputStream fis = new FileInputStream("input/Mendix_TestPlan"+Constants.EXCEL_FORMAT_XLSX);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			int col_Num = 0;
			XSSFSheet sheet = workbook.getSheet(sheetName);

			XSSFRow row = sheet.getRow(getRowNum("input/Mendix_TestPlan"+Constants.EXCEL_FORMAT_XLSX, "TestPlan", value));
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals(colName))
				{
					col_Num = i;
				}
			}

			//			sheet.autoSizeColumn(col_Num);
			//			row = sheet.getRow(getRowNum("input/Mendix_TestPlan"+Constants.EXCEL_FORMAT_XLSX, "TestPlan", value) - 1);
			//			if(row==null)
			//				row = sheet.createRow(rowNum - 1);
			Iterator<Row> rowIterator = sheet.rowIterator();
			Row firstRow=rowIterator.next();


			testCaseName = getTestCaseName("input/Mendix_TestPlan"+Constants.EXCEL_FORMAT_XLSX, "TestPlan", suiteName);
			Map<String, String> headerRow = getColumnNames(firstRow);
			while(rowIterator.hasNext()){
				Iterator<Cell> cellIterator=rowIterator.next().cellIterator();
				Map<String,String> rowMap=new LinkedHashMap<String, String>();
				for(Entry<?, ?> entry:headerRow.entrySet()){
					String strColumnName=entry.getKey().toString();
					String strValue="";
					try{
						Cell cell=cellIterator.next();
						if(cell!=null){strValue=cell.toString();
						rowMap.put(strColumnName, strValue.trim());
							
						if(strColumnName.equalsIgnoreCase("RequestId")) {
							if(rowMap.get("Test_Case").equalsIgnoreCase(testCaseName)){
							cell.setCellValue(value);
							}
						}
						}
					}catch(Exception e){}
				}

				FileOutputStream fos = new FileOutputStream("input/Mendix_TestPlan"+Constants.EXCEL_FORMAT_XLSX);
				workbook.write(fos);
				fos.close();
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			//            return  false;
		}
		//        return true;
	}
	
	public static void setCellData_New_GlobalId(String sheetName, String colName, String value, String suiteName)
	{
		List<Object[]> data = new ArrayList<Object[]>();
		try
		{
			FileInputStream fis = new FileInputStream("input/Mendix_TestPlan"+Constants.EXCEL_FORMAT_XLSX);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			int col_Num = 0;
			XSSFSheet sheet = workbook.getSheet(sheetName);

			XSSFRow row = sheet.getRow(getRowNum("input/Mendix_TestPlan"+Constants.EXCEL_FORMAT_XLSX, "TestPlan", value));
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals(colName))
				{
					col_Num = i;
				}
			}

			//			sheet.autoSizeColumn(col_Num);
			//			row = sheet.getRow(getRowNum("input/Mendix_TestPlan"+Constants.EXCEL_FORMAT_XLSX, "TestPlan", value) - 1);
			//			if(row==null)
			//				row = sheet.createRow(rowNum - 1);
			Iterator<Row> rowIterator = sheet.rowIterator();
			Row firstRow=rowIterator.next();


			testCaseName = getTestCaseName("input/Mendix_TestPlan"+Constants.EXCEL_FORMAT_XLSX, "TestPlan", suiteName);
			Map<String, String> headerRow = getColumnNames(firstRow);
			while(rowIterator.hasNext()){
				Iterator<Cell> cellIterator=rowIterator.next().cellIterator();
				Map<String,String> rowMap=new LinkedHashMap<String, String>();
				for(Entry<?, ?> entry:headerRow.entrySet()){
					String strColumnName=entry.getKey().toString();
					String strValue="";
					try{
						Cell cell=cellIterator.next();
						if(cell!=null){strValue=cell.toString();
						rowMap.put(strColumnName, strValue.trim());
							
						if(strColumnName.equalsIgnoreCase("Global_ID")) {
							if(rowMap.get("Test_Case").equalsIgnoreCase(testCaseName)){
							cell.setCellValue(value);
							}
						}
						}
					}catch(Exception e){}
				}

				FileOutputStream fos = new FileOutputStream("input/Mendix_TestPlan"+Constants.EXCEL_FORMAT_XLSX);
				workbook.write(fos);
				fos.close();
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			//            return  false;
		}
		//        return true;
	}

	public static int getRowNum(String fileName, String sheetName,
			String cellVal) {
		System.out.println("ExcelMethods.getRowNum: from file :-->"+fileName + "<-- and sheet -->"+ sheetName+"<---- and cellVal:"+cellVal);
		try {
			String path = fileName;
			InputStream ExcelFileToRead = new FileInputStream(path);
			XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);
			XSSFSheet sheet = wb.getSheet(sheetName);
			for (Row row : sheet) {
				Cell cell = row.getCell(0);
				int type = cell.getCellType();
				if (type == Cell.CELL_TYPE_FORMULA) {
					cell.getCachedFormulaResultType();
					if (cell.getStringCellValue().trim().equals(cellVal)) {
						// System.out.println("Formulae:"+row.getRowNum());
						return row.getRowNum();
					}
					/*else {
						logError("Row not found in datapool");
					}*/
				} else if (type == Cell.CELL_TYPE_STRING) {
					if (cell.getStringCellValue().trim().equals(cellVal)) {
						// System.out.println("Normal:"+row.getRowNum());
						System.out.println("ExcelMethods.getRowNum: getting header row value from file :-->"+fileName + "<-- and sheet -->"+ sheetName+"<---- "+ " String Cell(0) value ("+cell.getStringCellValue().trim()+" Row:"+row.getRowNum()+"...");
						return row.getRowNum();
					}/*else {
						logError("Row not found in datapool");
					}*/
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static void setCellData(String sheetName, String colName, int rowNum, String value)
	{
		try
		{
			FileInputStream fis = new FileInputStream("input/Mendix_TestPlan"+Constants.EXCEL_FORMAT_XLSX);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			int col_Num = -1;
			XSSFSheet sheet = workbook.getSheet(sheetName);

			XSSFRow row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals(colName))
				{
					col_Num = i;
				}
			}

			sheet.autoSizeColumn(col_Num);
			row = sheet.getRow(rowNum - 1);
			if(row==null)
				row = sheet.createRow(rowNum - 1);

			XSSFCell cell = row.getCell(col_Num);
			if(cell == null)
				cell = row.createCell(col_Num);
			System.out.println(value);


			cell.setCellValue(value);

			FileOutputStream fos = new FileOutputStream("input/Mendix_TestPlan"+Constants.EXCEL_FORMAT_XLSX);
			workbook.write(fos);
			fos.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			//            return  false;
		}
		//        return true;
	}

	public static String getTestCaseName(String testDataFile, String sheetName, String suiteName)
			throws IOException {
		TestData.testDataFile = "input/Mendix_TestPlan"+Constants.EXCEL_FORMAT_XLSX;
		ArrayList<String[]> data = TestData.getTestCaseData("TestPlan", suiteName);
		String testCaseName=null;
		for (int i = 0; i < data.size(); i++) {
			String[] s = data.get(i);
			for (int j = 0; j < s.length; j++) {
				System.out.print(s[j] + " , ");
				testCaseName=s[2].toString();

			}
			System.out.println("");
			//			movedata(testCaseName);
			System.out.println(testCaseName);
		}
		;
		System.out.println(testCaseName);
		//TestData.testCaseIdColNo = testCaseIdColNo;
		return testCaseName;
	}
	
	
	public static void setCellData_New_VendorAccNumber(String sheetName, String colName, String value, String suiteName)
	{
		List<Object[]> data = new ArrayList<Object[]>();
		try
		{
			FileInputStream fis = new FileInputStream("input/Mendix_TestPlan"+Constants.EXCEL_FORMAT_XLSX);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			int col_Num = 0;
			XSSFSheet sheet = workbook.getSheet(sheetName);

			XSSFRow row = sheet.getRow(getRowNum("input/Mendix_TestPlan"+Constants.EXCEL_FORMAT_XLSX, "TestPlan", value));
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals(colName))
				{
					col_Num = i;
				}
			}

			//			sheet.autoSizeColumn(col_Num);
			//			row = sheet.getRow(getRowNum("input/Mendix_TestPlan"+Constants.EXCEL_FORMAT_XLSX, "TestPlan", value) - 1);
			//			if(row==null)
			//				row = sheet.createRow(rowNum - 1);
			Iterator<Row> rowIterator = sheet.rowIterator();
			Row firstRow=rowIterator.next();


			testCaseName = getTestCaseName("input/Mendix_TestPlan"+Constants.EXCEL_FORMAT_XLSX, "TestPlan", suiteName);
			Map<String, String> headerRow = getColumnNames(firstRow);
			while(rowIterator.hasNext()){
				Iterator<Cell> cellIterator=rowIterator.next().cellIterator();
				Map<String,String> rowMap=new LinkedHashMap<String, String>();
				for(Entry<?, ?> entry:headerRow.entrySet()){
					String strColumnName=entry.getKey().toString();
					String strValue="";
					try{
						Cell cell=cellIterator.next();
						if(cell!=null){strValue=cell.toString();
						rowMap.put(strColumnName, strValue.trim());
							
						if(strColumnName.equalsIgnoreCase("Material_Number_AH1")) {
							if(rowMap.get("Test_Case").equalsIgnoreCase(testCaseName)){
							cell.setCellValue(value);
							}
						}
						}
					}catch(Exception e){}
				}

				FileOutputStream fos = new FileOutputStream("input/Mendix_TestPlan"+Constants.EXCEL_FORMAT_XLSX);
				workbook.write(fos);
				fos.close();
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			//            return  false;
		}
		//        return true;
	}

	public static void setCellDataOutputFile(String sheetName, String colName, String value, String testCaseNameValue)
	{
		List<Object[]> data = new ArrayList<Object[]>();
		try
		{
			FileInputStream fis = new FileInputStream("input/MDM_Output"+Constants.EXCEL_FORMAT_XLSX);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			int col_Num = 0;
			XSSFSheet sheet = workbook.getSheet(sheetName);

			XSSFRow row = sheet.getRow(getRowNum("input/MDM_Output"+Constants.EXCEL_FORMAT_XLSX, sheetName, value));
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals(colName))
				{
					col_Num = i;
				}
			}

			Iterator<Row> rowIterator = sheet.rowIterator();
			Row firstRow=rowIterator.next();


			testCaseName = getOutputTestCaseName("input/MDM_Output"+Constants.EXCEL_FORMAT_XLSX, "OutputTestData", testCaseNameValue);
			Map<String, String> headerRow = getColumnNames(firstRow);
			while(rowIterator.hasNext()){
				Iterator<Cell> cellIterator=rowIterator.next().cellIterator();
				Map<String,String> rowMap=new LinkedHashMap<String, String>();
				for(Entry<?, ?> entry:headerRow.entrySet()){
					String strColumnName=entry.getKey().toString();
					String strValue="";
					try{
						Cell cell=cellIterator.next();
						if(cell!=null){strValue=cell.toString();
						rowMap.put(strColumnName, strValue.trim());
							
						if(strColumnName.equalsIgnoreCase("Global_ID")) {
							if(rowMap.get("Test_Case").equalsIgnoreCase(testCaseName)){
							cell.setCellValue(value);
							}
						}
						else if(strColumnName.equalsIgnoreCase("Material_Number_AH1"))
						{
							if(rowMap.get("Test_Case").equalsIgnoreCase(testCaseName)){
								cell.setCellValue(value);
								}
						}
						else if(strColumnName.equalsIgnoreCase("Mendix_User"))
						{
							if(rowMap.get("Test_Case").equalsIgnoreCase(testCaseName)){
								cell.setCellValue(value);
								}
						}
						else if(strColumnName.equalsIgnoreCase("Syndication_Status"))
						{
							if(rowMap.get("Test_Case").equalsIgnoreCase(testCaseName)){
								cell.setCellValue(value);
								}
						}
						else if(strColumnName.equalsIgnoreCase("UFT_User"))
						{
							if(rowMap.get("Test_Case").equalsIgnoreCase(testCaseName)){
								cell.setCellValue(value);
								}
						}
						}
					}catch(Exception e){}
				}

				FileOutputStream fos = new FileOutputStream("input/MDM_Output"+Constants.EXCEL_FORMAT_XLSX);
				workbook.write(fos);
				fos.close();
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			//            return  false;
		}
		//        return true;
	}
	
	public static String getOutputTestCaseName(String testDataFile, String sheetName, String testCaseNameValue)
			throws IOException {
		TestData.testDataFile = "input/MDM_Output"+Constants.EXCEL_FORMAT_XLSX;
		ArrayList<String[]> data = TestData.getTestCaseDataOfOutputSheet(sheetName , testCaseNameValue);
		String testCaseName=null;
		for (int i = 0; i < data.size(); i++) {
			String[] s = data.get(i);
			for (int j = 0; j < s.length; j++) {
				System.out.print(s[j] + " , ");
				testCaseName=s[2].toString();

			}
			System.out.println("");
			//			movedata(testCaseName);
			System.out.println(testCaseName);
		}
		;
		System.out.println(testCaseName);
		//TestData.testCaseIdColNo = testCaseIdColNo;
		return testCaseName;
	}
	
}
