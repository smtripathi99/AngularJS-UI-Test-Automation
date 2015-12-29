package com.ig.automation.screens;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ig.automation.coreactions.DataActions;

public class VersionCPScreen extends DataActions {
	
	public WebElement searchDoc;
	public WebElement basicSearch;
	public Select 	  docIDSearchdropdown;
	public WebElement enterDocIDbox;
	public WebElement searchButton;
	public WebElement filterDocID;
	public WebElement eusubmissionMenu;
	public WebElement versionTab;
	public WebElement versionColumn;
	public WebElement versionDetail;
	public WebElement versionCP;
	
	

	public void initializeDocument() {
		filterDocID = findElement(By
				.xpath("/html/body/div[2]/div[3]/div[2]/div[2]/div[2]/div[16]/div[5]/div[3]/div[1]/div/div/span"));
	}

	public void initializeActionMenu() {

		eusubmissionMenu = findElement(By
				.xpath("/html/body/div/div[3]/div[2]/div[1]/div[2]/div/div/div[1]/div[1]/div/div[2]/ul/li[5]/a"));
		}
	
	public void initializeVersionCP() {

		versionCP = findElement(By
				.xpath("/html/body/div/div[3]/div[2]/div[1]/div[2]/div/div/div[1]/div[1]/div/div[2]/ul/li[5]/ul/div[1]/li/a"));
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
