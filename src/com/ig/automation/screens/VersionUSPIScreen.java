package com.ig.automation.screens;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ig.automation.coreactions.DataActions;

public class VersionUSPIScreen extends DataActions {
	
	public WebElement searchDoc;
	public WebElement basicSearch;
	public Select 	  docIDSearchdropdown;
	public WebElement enterDocIDbox;
	public WebElement searchButton;
	public WebElement filterDocID;
	public WebElement eusubmissionMenu;
	public WebElement versionRMS;
	public WebElement versionTab;
	public WebElement versionColumn;
	public WebElement versionDetail;
	public WebElement actions;
	public WebElement logOff;
	public WebElement createDoc;
	public WebElement createChangeRequest;
	public WebElement usPackageInsert;
	public WebElement basicSearchIcon; 
	public WebElement searchIcon;
	public WebElement docIDSearch;
	public Select docIDStatusSearch;
	public WebElement searchBtn;
	public WebElement selectDoc;
	public WebElement selectVersionCol;
	public WebElement inputVersion;
	
	public void initializeAction() {
		actions = findElement(By.xpath("/html/body/div/div[2]/div/accordion/div/div[6]/div[1]/h4/a/label/span/span"));
		logOff = findElement(By.className("logout"));
	}

	public void initializeCreate() {
		createDoc = findElement(By.xpath("/html/body/div/div[2]/div/accordion/div/div[6]/div[2]/div/accordion/div/div[1]/div[1]/h4/a/label/span"));
		createChangeRequest = findElement(By.xpath("/html/body/div/div[2]/div/accordion/div/div[6]/div[2]/div/accordion/div/div[2]/div[1]/h4/a/label/span"));
	}
	
	public void inilializeObjectsDocType() {
		usPackageInsert = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div/div[2]/div/div/div/ul/li[7]"));

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

		versionRMS = findElement(By
				.xpath("/html/body/div/div[3]/div[2]/div[1]/div[2]/div/div/div[1]/div[3]/div/div/div/div[2]/div/div[1]/div/div[2]/ul/li[5]/ul/div[5]/li/a"));
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
