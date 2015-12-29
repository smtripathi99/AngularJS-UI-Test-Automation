package com.ig.automation.screens;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ig.automation.coreactions.DataActions;

public class ExportDocumentScreen extends DataActions {
	
	public WebElement searchDoc;
	public WebElement basicSearch;
	public Select 	  docIDSearchdropdown;
	public WebElement enterDocIDbox;
	public WebElement searchButton;
	public WebElement filterDocID;
	public WebElement viewMenu;
	public WebElement exportDoc;
	
	
	public void initializeSearch() {

		searchDoc = findElement(By
				.xpath("/html/body/div/div[1]/div/div[2]/ul[1]/li/i"));
	}

	public void initializeBasicSearch() {

		basicSearch = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[2]/gc-search/div[1]/accordion/div/div[1]/div[1]/h4/a/span[1]"));
		
	}

	public void initializeDocIDSearch() {

		docIDSearchdropdown = new Select(findElement(By
				.xpath("/html/body/div/div[3]/div[2]/div/div[2]/gc-search/div[1]/accordion/div/div[1]/div[2]/div/div/div/div[7]/div/div/div/select")));

		enterDocIDbox = findElement(By
				.xpath("/html/body/div/div[3]/div[2]/div/div[2]/gc-search/div[1]/accordion/div/div[1]/div[2]/div/div/div/div[7]/div/div/div/input"));
		searchButton  = findElement(By.className("QA_testing_Search_Document_Btn"));

	}

	public void initializeDocument() {
		filterDocID = findElement(By
				.xpath("/html/body/div/div[3]/div[2]/div/div[4]/div/div[4]/div[3]/div[1]/div/div/span"));
	}

	public void initializeActionMenu() {

		viewMenu = findElement(By
				.xpath("/html/body/div/div[3]/div[2]/div/div[3]/div/div[2]/ul/li[2]/a"));
		}
	
	public void initializeExport() {

		exportDoc = findElement(By
				.xpath("/html/body/div/div[3]/div[2]/div/div[3]/div/div[2]/ul/li[2]/ul/div[6]/li/a"));
	}
		
		

}
