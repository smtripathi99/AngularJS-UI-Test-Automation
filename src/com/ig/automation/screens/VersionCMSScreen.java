package com.ig.automation.screens;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ig.automation.coreactions.DataActions;

public class VersionCMSScreen extends DataActions {
	
	public WebElement searchDoc;
	public WebElement basicSearch;
	public Select 	  docIDSearchdropdown;
	public WebElement enterDocIDbox;
	public WebElement searchButton;
	public WebElement filterDocID;
	public WebElement eusubmissionMenu;
	public WebElement versionCMS;
	public WebElement versionTab;
	public WebElement versionColumn;
	public WebElement versionDetail;
	
	
	public void initializeSearch() {

		searchDoc = findElement(By
				.xpath("/html/body/div[2]/div[1]/div/div[2]/ul[1]/li/i"));
	}

	public void initializeBasicSearch() {

		basicSearch = findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div[2]/div/gc-search/div[1]/accordion/div/div[1]/div[1]/h4/a/span[1]"));
		
	}

	public void initializeDocIDSearch() {

		docIDSearchdropdown = new Select(findElement(By
				.xpath("/html/body/div[2]/div[3]/div[2]/div[2]/div[1]/gc-search/div[1]/accordion/div/div[1]/div[2]/div/div/div/div[7]/div/div/div/select")));

		enterDocIDbox = findElement(By
				.xpath("/html/body/div[2]/div[3]/div[2]/div[2]/div[1]/gc-search/div[1]/accordion/div/div[1]/div[2]/div/div/div/div[7]/div/div/div/input"));
		searchButton  = findElement(By.className("QA_testing_Search_Document_Btn"));

	}

	public void initializeDocument() {
		filterDocID = findElement(By
				.xpath("/html/body/div[2]/div[3]/div[2]/div[2]/div[2]/div[16]/div[5]/div[3]/div[1]/div/div/span"));
	}

	public void initializeActionMenu() {

		eusubmissionMenu = findElement(By
				.xpath("/html/body/div/div[3]/div[2]/div[1]/div[2]/div/div/div[1]/div[1]/div/div[2]/ul/li[5]/a"));
		}
	
	public void initializeVersionCMS() {

		versionCMS = findElement(By
				.xpath("/html/body/div/div[3]/div[2]/div[1]/div[2]/div/div/div[1]/div[1]/div/div[2]/ul/li[5]/ul/div[7]/li/a"));
	}
		
	public void initializeVersionsTab() {

		versionTab = findElement(By
				.xpath("/html/body/div/div[3]/div[2]/div[1]/div[2]/div/div/div[1]/div[3]/div/div/ul/li[2]/a"));
	}

	public void initializeVersionsGrid() {

		versionColumn = findElement(By
				.xpath("/html/body/div/div[3]/div[2]/div[1]/div[2]/div/div/div[1]/div[3]/div/div/div/div[2]/div/div[2]/div/div[3]/div[5]/span/span/div/span[2]/span[1]/span"));
	}
	
	
	
	public void initializeVersionsDetails() {

		versionDetail = findElement(By
				.xpath("/html/body/div/div[3]/div[2]/div[1]/div[2]/div/div/div[1]/div[3]/div/div/div/div[2]/div/div[2]/div/div[4]/div[3]/div[5]/div/span"));
	}
	
	
	
	

}
