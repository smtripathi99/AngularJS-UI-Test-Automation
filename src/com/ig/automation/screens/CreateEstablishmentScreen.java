package com.ig.automation.screens;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ig.automation.coreactions.DataActions;

public class CreateEstablishmentScreen extends DataActions {
	public WebElement searchDoc;
	public WebElement basicSearch;
	public Select 	  docIDSearchdropdown;
	public WebElement enterDocIDbox;
	public WebElement searchButton;
	public WebElement filterDocID;
	public WebElement estbTab;
	public WebElement createEstbLink;
	public WebElement createEstbPanelTitle;
	public WebElement title;
	public WebElement  estbName;
	public WebElement cancelBtn;
	public WebElement optionalProperties;
	public Select contactCountry;
	public WebElement contactPhone;
	public WebElement contactEmail;
	public WebElement contactName;
	public WebElement contactStreet;
	public WebElement contactCity;
	public WebElement contactState;
	public WebElement contactPostal;
	public WebElement createEstbBtn;
	public WebElement message;
	public WebElement confidential;
	public WebElement typeOperation;
	public WebElement selfidOperation;
	public WebElement usAgent;
	public WebElement importer;
	public WebElement dunsno;
	public WebElement regno;
	public WebElement street;
	public WebElement city;
	public WebElement state;
	public WebElement postal;
	public Select country;
	
	
	public void initializeSearch() {

		searchDoc = findElement(By.className("search"));
	}

	public void initializeBasicSearch() {

		basicSearch = findElement(By.className("QA_testing_Basic_Search"));
		
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

	public void initializeEstbTab() {

		estbTab = findElement(By
				.xpath("/html/body/div/div[3]/div[2]/div/div[5]/div/div/ul/li[8]/a"));
	}
	
	public void initializeCreateEstbLink() {

		createEstbLink = findElement(By
				.xpath("/html/body/div/div[3]/div[2]/div/div[5]/div/div/div/div[8]/div/button[1]"));
	}

	
			
			
	public void initializeMandatoryProperties() {
		createEstbPanelTitle=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div/div/div[2]/h1"));
		estbName = findElement(By.className("QA_testing_Establishment"));
		cancelBtn=findElement(By.className("QA_Testing_Panel_Btn_cancel"));
		optionalProperties=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div/div/div[4]/div/div/div/div[2]/div/div/accordion/div/div/div[2]/div[1]/h4/a/span[1]"));
	}
	
	
	
	public void initializeOptionalProperties() {
		confidential=findElement(By.className("QA_testing_Confidential"));
		title=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div/div/div[4]/div/div/div/div[2]/div/div/accordion/div/div/div[2]/div[2]/div/div[12]/div/div/textarea"));
		contactCountry=new Select(findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div/div/div[4]/div/div/div/div[2]/div/div/accordion/div/div/div[2]/div[2]/div/div[7]/div/div/select")));
		contactPhone=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div/div/div[4]/div/div/div/div[2]/div/div/accordion/div/div/div[2]/div[2]/div/div[8]/div/div/input"));
		contactEmail=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div/div/div[4]/div/div/div/div[2]/div/div/accordion/div/div/div[2]/div[2]/div/div[9]/div/div/input"));
		contactName=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div/div/div[4]/div/div/div/div[2]/div/div/accordion/div/div/div[2]/div[2]/div/div[2]/div/div/input"));
		contactStreet=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div/div/div[4]/div/div/div/div[2]/div/div/accordion/div/div/div[2]/div[2]/div/div[3]/div/div/input"));
		contactCity=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div/div/div[4]/div/div/div/div[2]/div/div/accordion/div/div/div[2]/div[2]/div/div[4]/div/div/input"));
		contactState=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div/div/div[4]/div/div/div/div[2]/div/div/accordion/div/div/div[2]/div[2]/div/div[5]/div/div/input"));
		contactPostal=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div/div/div[4]/div/div/div/div[2]/div/div/accordion/div/div/div[2]/div[2]/div/div[6]/div/div/input"));
		typeOperation=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div/div/div[4]/div/div/div/div[2]/div/div/accordion/div/div/div[2]/div[2]/div/div[10]/div/div/div/div/div/div/div/div/tags-input/div/div/input"));
		selfidOperation=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div/div/div[4]/div/div/div/div[2]/div/div/accordion/div/div/div[2]/div[2]/div/div[11]/div/div/div/div/div/div/div/div/tags-input/div/div/input"));
		//usAgent=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div[1]/div/div/div[4]/div/div/div/div[2]/div/div/accordion/div/div/div[2]/div[2]/div/div[12]/div/div/input"));
		//importer=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div[1]/div/div/div[4]/div/div/div/div[2]/div/div/accordion/div/div/div[2]/div[2]/div/div[13]/div/div/div/tags-input/div/div/input"));
		dunsno=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div/div/div[4]/div/div/div/div[2]/div/div/accordion/div/div/div[2]/div[2]/div/div[13]/div/div/input"));
		regno=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div/div/div[4]/div/div/div/div[2]/div/div/accordion/div/div/div[2]/div[2]/div/div[14]/div/div/input"));
		street=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div/div/div[4]/div/div/div/div[2]/div/div/accordion/div/div/div[2]/div[2]/div/div[15]/div/div/input"));
		city=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div/div/div[4]/div/div/div/div[2]/div/div/accordion/div/div/div[2]/div[2]/div/div[16]/div/div/input"));
		state=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div/div/div[4]/div/div/div/div[2]/div/div/accordion/div/div/div[2]/div[2]/div/div[17]/div/div/input"));
		postal=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div/div/div[4]/div/div/div/div[2]/div/div/accordion/div/div/div[2]/div[2]/div/div[18]/div/div/input"));
		country=new Select(findElement(By.className("QA_testing_Country")));
		createEstbBtn=findElement(By.className("QA_Testing_Panel_Btn_createRequest"));	
	}
	
	public void initializeMessages(){
		message = driver.findElement(By.id("toast-container"));
	}	
}
