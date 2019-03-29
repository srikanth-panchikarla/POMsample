
package com.oakton.hwi.Utility;
/**
* @Copyright ©OAKTON CONSULTING TECHNOLOGY 
* @ClassDescription 
* This Class is used read TestData from excel sheet
*  
* @author Srikanth Panchikarla
* @version 1.0
* @Date 01/06/2017
* 
* 
* ************************************************* Version History *************************************************************************************************************
* *******************************************************************************************************************************************************************************
* DATE                                     VERSION                       DEVELOPER                                        CHANGE DESCRIPTION 
* ================================================================================================================================================================================
*01/06/2017                                1.0                          Srikanth Panchikarla                            This Class is used read TestData from excel sheet 
*                                                                                                                                                                                 
*
*/
import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadTestData {

	public XSSFWorkbook wb;
	public XSSFSheet sheet;
	public XSSFRow row = null;
	public XSSFCell cell = null;

	public FileInputStream fis = null;
	// public XSSFWorkbook workbook=null;
	// public XSSFSheet Sheet=null;

	/*
	 * This method is to read data from excel 
	 */
	public ReadTestData(String xcelPath) {

		try {
			System.out.println("=======In ReadTestData method========");
			File src = new File(xcelPath);
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	/*
	 * This method is to read sheet in excel 
	 */
	public String readXcelSheet(String sheetName, int rowNum, int colNum) {
		System.out.println("=======In readXcelSheet method========");
		sheet = wb.getSheet(sheetName);
		String data = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		return data;

	}
	
	/*
	 * This method is to get row count 
	 */
	public int getRowCount(String sName) {
		System.out.println("=======In getRowCount method========");
		sheet = wb.getSheet(sName);
		System.out.println("=======In getRowCount method========" + sName);
		int rowCount = sheet.getLastRowNum() + 1;
		System.out.println("In getrowcount method");
		return rowCount;
	}

	/*
	 * This method is to get column count 
	 */
	public int getcolCount(String sName) {
		System.out.println("=======In getcolCount method========");
		sheet = wb.getSheet(sName);
		row = sheet.getRow(0);
		int colCount = row.getLastCellNum();
		System.out.println("In getColcount method");
		return colCount;
	}

	/*
	 * This method is to read cell data 
	 */
	@SuppressWarnings("deprecation")
	public String getCellData(String SheetName, int ColNum, int RowNum) throws Exception {
		try {
			System.out.println("=======In getdatacell method========");
			sheet = wb.getSheet(SheetName);
			row = sheet.getRow(RowNum);
			cell = row.getCell(ColNum);
			if (cell.getCellTypeEnum() == CellType.STRING)

				return cell.getStringCellValue();

			else if (cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.FORMULA) {

				String cellValue = String.valueOf(cell.getNumericCellValue());
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					DateFormat dt = new SimpleDateFormat("dd/MM/YY");
					Date date = cell.getDateCellValue();
					cellValue = dt.format(date);

				}
				return cellValue;

			} else if (cell.getCellTypeEnum() == CellType.BLANK)
				return " ";
			else
				return String.valueOf(cell.getBooleanCellValue());
		} catch (Exception e) {
			e.printStackTrace();
			return "Not found";
		}

	}

}
