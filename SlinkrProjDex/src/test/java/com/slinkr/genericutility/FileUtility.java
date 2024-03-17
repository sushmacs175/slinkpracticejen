package com.slinkr.genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {

	public String getPropertyData(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream("src/test/resources/slinkrdata.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String value=pobj.getProperty(key);
		return value;
	}

	
	public String getExceldata(String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("src/test/resources/slinkrtestdata.xlsx");
		Workbook workBook=WorkbookFactory.create(fis);
		String data = workBook.getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
		return data;
	}
	
	public String getExceldataUserName(String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("src/test/resources/usernametestdatastring.xlsx");
		Workbook workBook=WorkbookFactory.create(fis);
		String data = workBook.getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
		return data;
	}
}
