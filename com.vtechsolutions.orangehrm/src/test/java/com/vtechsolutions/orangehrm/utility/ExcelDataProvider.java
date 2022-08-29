package com.vtechsolutions.orangehrm.utility;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	 static XSSFWorkbook workbook;
	
	public ExcelDataProvider(String filePath)
	{
		try {
			FileInputStream fins = new FileInputStream(filePath);
			workbook = new XSSFWorkbook(fins);			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public static int getRowCount(String sheetname)
	{
		return workbook.getSheet(sheetname).getLastRowNum();
	}
	
	public static int getColsCount(String sheetname)
	{
		return workbook.getSheet(sheetname).getRow(0).getLastCellNum();
	}
	
	public static int getRowCount(int index)
	{
		return workbook.getSheetAt(index).getLastRowNum();
	}
	
	public static int getColsCount(int index)
	{
		return workbook.getSheetAt(index).getRow(0).getLastCellNum();
	}
	
	public static String getStringCellData(String sheetname, int row, int col)
	{
		 return workbook.getSheet(sheetname).getRow(row).getCell(col).getStringCellValue();
	}
	
	public static String getStringCellData(int index, int row, int col)
	{
		return  workbook.getSheetAt(index).getRow(row).getCell(col).getStringCellValue();
	}
	
	public static int getNumericCellData(String sheetname, int row, int col)
	{
		return (int) workbook.getSheet(sheetname).getRow(row).getCell(col).getNumericCellValue();
	}
	
	public static int getNumericCellData(int index, int row, int col)
	{
		 return (int) workbook.getSheetAt(index).getRow(row).getCell(col).getNumericCellValue();
	}
	
	public static Object[][] getExcelData(String sheetname)
	{
		
		int row = getRowCount(sheetname);
		int cols = getColsCount(sheetname);
		System.out.println(row);
		System.out.println(cols);
		
		Object[][] data = new Object[row][cols];
		
		for (int i =0; i<row; i++) {
			for (int j = 0; j < cols; j++) {
				
				data[i][j] =workbook.getSheet(sheetname).getRow(i+1).getCell(j).toString();
			}
			
		}
		
		return data;
	}
	
//	public static void main(String[] args) {
//		 ExcelDataProvider excelData = new ExcelDataProvider("./Data/TestData.xlsx");
//		 
//		Object[][] data1 = excelData.getExcelData("Login1");
//		
//		System.out.println(data1);
//	}
	
	
}
