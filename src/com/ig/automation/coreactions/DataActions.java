  package com.ig.automation.coreactions;

import java.io.File;
import java.io.IOException;

import com.google.common.collect.Table.Cell;

import jxl.LabelCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DataActions extends SuperScript {

	public static String url;
	public static String userId;
	public static String pwd;

	
	public static void createConnection() throws Exception {
		try {
			Workbook wrk1 = Workbook.getWorkbook(new File(
					"src/com/ig/automation/testdata/connection.xls"));
			Sheet sheet1 = wrk1.getSheet(0);
			url = sheet1.getCell(0, 1).getContents();
			userId = sheet1.getCell(1, 1).getContents();
			pwd = sheet1.getCell(2, 1).getContents();
		} catch (BiffException e) {
			e.printStackTrace();
		}

	}
	
	public static String getUserID(String role) throws Exception {
		try {
				Workbook wrk1 = Workbook.getWorkbook(new File(
					"src/com/ig/automation/testdata/users.xls"));
				Sheet sheet1 = wrk1.getSheet(0);
				if (role=="role_eu_labeling_author"){
					userId = sheet1.getCell(0, 1).getContents();
				}
				else if (role=="docu"){
					userId = sheet1.getCell(0, 2).getContents();
				}
				else if (role=="role_author"){
					userId = sheet1.getCell(0, 3).getContents();
				}
				else if (role=="role_drug_listing_author"){
					userId = sheet1.getCell(0, 6).getContents();
				}
				else if (role=="role_label_coordinator"){
					userId = sheet1.getCell(0, 7).getContents();
				}
				else if (role=="role_us_labeling_author"){
					userId = sheet1.getCell(0, 8).getContents();
				}
			} catch (BiffException e) {
				e.printStackTrace();
			}
		return userId;

	}
	
	public static String getUserPassword(String role) throws Exception {
		try {
				Workbook wrk1 = Workbook.getWorkbook(new File(
					"src/com/ig/automation/testdata/users.xls"));
				Sheet sheet1 = wrk1.getSheet(0);
				if (role=="role_eu_labeling_author"){
					pwd = sheet1.getCell(1, 1).getContents();
				}
				else if (role=="docu"){
					pwd = sheet1.getCell(1, 2).getContents();
				}
				else if (role=="role_author"){
					pwd = sheet1.getCell(1, 3).getContents();
				}
				else if (role=="role_drug_listing_author"){
					pwd = sheet1.getCell(1, 6).getContents();
				}
				else if (role=="role_label_coordinator"){
					pwd = sheet1.getCell(1, 7).getContents();
				}
				else if (role=="role_us_labeling_author"){
					pwd = sheet1.getCell(1, 8).getContents();
				}
			} catch (BiffException e) {
				e.printStackTrace();
			}
		return pwd;

	}
	
	public static String[][] getTableArray(String xlFilePath, String sheetName, String tableName,String tlbEnd) throws Exception{
		String[][] tabArray=null;

		Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
		Sheet sheet = workbook.getSheet(sheetName); 
		int startRow,startCol, endRow, endCol,ci,cj;
		jxl.Cell tableStart=sheet.findCell(tableName);
		startRow=tableStart.getRow();
		startCol=tableStart.getColumn();


		LabelCell tableEnd = sheet.findLabelCell(tlbEnd);
		endRow=tableEnd.getRow();
		endCol=tableEnd.getColumn();
		System.out.println("startRow="+startRow+", endRow="+endRow+", " +
				"startCol="+startCol+", endCol="+endCol);
		tabArray=new String[endRow-startRow-1][endCol-startCol-1];
		ci=0;

		for (int i=startRow+1;i<endRow;i++,ci++){
			cj=0;
			for (int j=startCol+1;j<endCol;j++,cj++){
				tabArray[ci][cj]=sheet.getCell(j,i).getContents();

			}
		}

		return(tabArray);
	}
}
