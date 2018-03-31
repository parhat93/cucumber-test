package com.app.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.app.pages.GasMileageCalculatorPage;
import com.app.utilities.ConfigurationReader;
import com.app.utilities.Driver;

public class BasicDataDriverTest {
	WebDriver driver;
	Workbook workbook;
	Sheet worksheet;
	FileInputStream inStream;
	FileOutputStream outStream;
	GasMileageCalculatorPage page;
	public static final int CURRENTOD_COLNUM = 1;
	public static final int PREVIOUS_COLUM = 2;
	public static final int GAS_COLUM = 3;

	@BeforeClass
	public void setUp() throws Exception {
		inStream = new FileInputStream(
				ConfigurationReader.getProperty("gasmilege.testData.path"));
		workbook = WorkbookFactory.create(inStream);
		worksheet = workbook.getSheetAt(0);

		driver = Driver.getDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.calculator.net/gas-mileage-calculator.html");
	}

	@AfterClass
	public void tearDown() throws IOException {
		outStream = new FileOutputStream(ConfigurationReader.getProperty("gasmilege.testData.path"));
		workbook.write(outStream);
		outStream.close();
		inStream.close();
		workbook.close();
		driver.close();

	}
	@Test
	public void dataDrivenMileageCalculatorTest() {
		
		for (int rowNum = 1; rowNum < worksheet
				.getPhysicalNumberOfRows(); rowNum++) {

			Row currentRow = worksheet.getRow(rowNum);
			
			//check the control column. if it does not say Y, then skip this row
			if(!currentRow.getCell(0).toString().equalsIgnoreCase("Y")) {
				if (currentRow.getCell(6) == null) {
					currentRow.createCell(6);
				}
				currentRow.createCell(6).setCellValue("Skip Requested");
				continue;
			}
			
			
			double currentOr = currentRow.getCell(CURRENTOD_COLNUM)
					.getNumericCellValue();
			double previousOr = currentRow.getCell(PREVIOUS_COLUM)
					.getNumericCellValue();
			double gas = currentRow.getCell(GAS_COLUM).getNumericCellValue();

			page = new GasMileageCalculatorPage();

			page.currentOdometer.clear();
			page.currentOdometer.sendKeys(String.valueOf(currentOr));

			page.previousOdometer.clear();
			page.previousOdometer.sendKeys(String.valueOf(previousOr));

			page.GasAdded.clear();
			page.GasAdded.sendKeys(String.valueOf(gas));

			page.Calculate.click();
			// actual result
			String[] result = page.Result.getText().split(" ");
			System.out.println(result[0]);
			String actualResult = result[0].replace(",", "");
			// wite result to Actual Result column
			if (currentRow.getCell(5) == null) {
				currentRow.createCell(5);
			}
				currentRow.getCell(5).setCellValue(actualResult);
			
			double calculationResult = (currentOr - previousOr) / gas;
			DecimalFormat format = new DecimalFormat("0.00");

			System.out.println(format.format(calculationResult));
			// write result to excepted result column
			if (currentRow.getCell(4) == null) {
				currentRow.createCell(4);
			}
				currentRow.getCell(4).setCellValue(format.format(calculationResult));
				
				if (currentRow.getCell(6) == null) {
					currentRow.createCell(6);
				}
			// write pass or fail to stats column
//			if (actualResult.equals(format.format(calculationResult))) {
//				System.out.println("Pass");
//				currentRow.getCell(6).setCellValue("Pass");
//			} else {
//				System.out.println("Fail");
//				currentRow.getCell(6).setCellValue("Fail");
//			}
				
				if (Double.valueOf(actualResult).equals(Double.valueOf(format.format(calculationResult)))) {
					System.out.println("Pass");
					currentRow.getCell(6).setCellValue("Pass");
				} else {
					System.out.println("Fail");
					currentRow.getCell(6).setCellValue("Fail");
				}
				
				
			
			//write current time
			if (currentRow.getCell(7) == null) {
				currentRow.createCell(7);
			}
			
			currentRow.getCell(7).setCellValue(LocalDateTime.now().toString());
			currentRow.getCell(7).getCellStyle().setWrapText(true);
			
			
		}
	}

}
