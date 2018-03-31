package com.app.tests;

import java.io.FileInputStream;



import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelRead {
		public static void main(String [] args) throws Exception {
			String filePath="C:\\Users\\Osman\\Desktop\\Workbook.xlsx";
			
			// when we reading the file we use FileinputStream
			// open file and convert to a stream of data
			FileInputStream inStream = new FileInputStream(filePath);
			// take a stream of data and use it as WorkBook
			Workbook workbook = WorkbookFactory.create(inStream);
			// get the first worksheet from the workbook
			Sheet worksheet = workbook.getSheetAt(0);
			// go to first row
			Row row = worksheet.getRow(0);
			// goto fist fell;
			Cell cell = row.getCell(0);
			System.out.println(cell.toString());
			
			 //Find out how many rows in excel sheet
			int rowsCount = worksheet.getPhysicalNumberOfRows(); 
			
			
			System.out.println("Number of rows: "+rowsCount);
			
			
			for(int rowNum= 1; rowNum <rowsCount;rowNum++ ) {
				row = worksheet.getRow(rowNum);
				cell=row.getCell(0);
				System.out.println(rowNum + " - " + cell.toString());
			//	System.out.println(rowNum+ " - " + worksheet.getRow(rowNum).getCell(0));
			}
			
			//Find dimurat JOB_ID using
			Cell DilmuratJob = worksheet.getRow(4).getCell(2);
			System.out.println(DilmuratJob);
			
			
			for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
				Row myrow= worksheet.getRow(i);
				if(myrow.getCell(0).toString().equals("SDET")) {
					System.out.println("Dilmurat works as " + myrow.getCell(2).toString());
					break;
				}
				
			}
			
			
			workbook.close();
			inStream.close();
			
			
			
			
		}
}
