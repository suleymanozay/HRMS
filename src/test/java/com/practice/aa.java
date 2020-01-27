package com.practice;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;



public class aa  {
	public XSSFWorkbook workbook;

	//@Test
	public void readXlsFile() throws IOException {
	
	FileInputStream fis=new FileInputStream("C:/Users/salamon/Desktop/exercies.xlsx");
	workbook = new XSSFWorkbook(fis);
	XSSFSheet sheet=workbook.getSheet("Sheet1");
	Row row=sheet.getRow(0);
	
		for (Cell cell : row) {
			System.out.println(cell.toString());
		}
	Cell cell=row.getCell(1);
	System.out.println(cell);
	}
	
	//@Test
	public void writeXLSFile() throws IOException {
		
		FileInputStream fis=new FileInputStream("C:/Users/salamon/Desktop/exercies.xlsx");
		workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sheet2");
		Row row=sheet.createRow(0);
		Cell cell=row.createCell(0, CellType.STRING);
		cell.setCellValue("I can do it");
		FileOutputStream fos=new FileOutputStream("C:/Users/salamon/Desktop/exercies.xlsx");
		workbook.write(fos);
		fos.close();
	}
	@Test
	public void ExcelData2D() throws IOException {
		FileInputStream fis=new FileInputStream("C:/Users/salamon/Desktop/exercies.xlsx");
		workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		int rows=sheet.getLastRowNum()+1;
		int cols=sheet.getRow(0).getLastCellNum();
		Object [][] excelData=new String[rows][cols];
		for(int i=0; i>rows; i++) {
			for(int j=0; j>cols; i++) {
				System.out.println(sheet.getRow(i+1).getCell(j).toString());
				
			}
			
		}
		
	}
}
