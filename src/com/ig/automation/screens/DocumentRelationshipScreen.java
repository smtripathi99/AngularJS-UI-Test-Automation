package com.ig.automation.screens;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ig.automation.coreactions.DataActions;


public class DocumentRelationshipScreen extends DataActions {
	public WebElement searchDoc;
	public WebElement basicSearch;
	public Select docIDSearchdropdown;
	public WebElement enterDocIDbox;
	public WebElement searchButton;
	public WebElement filterDocID;
	public WebElement cancelButton;
	public WebElement sourceDocTab;
	public WebElement linkSource;
	public WebElement searchSourceLabel;
	public WebElement myDocSource;
	public WebElement createRelationBtn;
	public WebElement searchSource;
	public WebElement searchDocBtn;
	public WebElement supportDocTab;
	public WebElement linkSupport;
	public WebElement searchSupportingLabel;
	public WebElement myDocSupport;
	public WebElement createCRLink;
	public WebElement linkCRLink;
	public WebElement crLink;
	public WebElement message;
	public WebElement basicSearchLink;
	public WebElement basicSearchDocID;
	public WebElement searchResultDocID;

	public void initializeSearch() {

		searchDoc = findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/ul[1]/li/i"));
	}

	public void initializeBasicSearch() {

		basicSearch = findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div[2]/div/gc-search/div[1]/accordion/div/div[1]/div[1]/h4/a/span[1]"));

	}

	public void initializeDocIDSearch() {

		docIDSearchdropdown = new Select(
				findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div[2]/div[1]/gc-search/div[1]/accordion/div/div[1]/div[2]/div/div/div/div[7]/div/div/div/select")));

		enterDocIDbox = findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div[2]/div[1]/gc-search/div[1]/accordion/div/div[1]/div[2]/div/div/div/div[7]/div/div/div/input"));
		searchButton = findElement(By.className("QA_testing_Search_Document_Btn"));

	}

	public void initializeDocument() {
		filterDocID = findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div[2]/div[2]/div[16]/div[5]/div[3]/div[1]/div/div/span"));
	}

	public void initializeSourceDocumentTab() {

		sourceDocTab = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[6]/div/div/ul/li[6]/a"));
	}										

	public void initializeLinkSource() {

		linkSource = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[6]/div/div/div/div[6]/div/button"));

	}

	public void initializeSearchSourceMyDoc() {

		searchSourceLabel = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[1]/div/div/div[2]/h1"));

		myDocSource = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[2]/div/div/div[4]/div/div/div/ul/li[1]/a"));

		searchSource = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[2]/div/div/div[4]/div/div/div/ul/li[2]/a"));

		createRelationBtn = findElement(By.className("QA_Testing_Panel_Btn_linkEstablishment"));

		cancelButton = findElement(By.className("QA_Testing_Panel_Btn_cancel"));

	}

	public void initializeSearchSource() {

		searchDocBtn = findElement(By.className("QA_testing_Search_Document_Btn"));

	}

	public void initializeSupportingDocumentTab() {

		supportDocTab = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[6]/div/div/ul/li[7]/a"));
	}

	public void initializeLinkSupporting() {

		linkSupport = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[6]/div/div/div/div[7]/div/button[1]"));

	}

	public void initializeSearchSupportMyDoc() {

		searchSupportingLabel = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[2]/div/div/div[2]/h1"));

		myDocSupport = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[2]/div/div/div[4]/div/div/div/ul/li[1]/a"));

		searchSource = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[2]/div/div/div[4]/div/div/div/ul/li[2]/a"));

											
		createRelationBtn = findElement(By.className("QA_Testing_Panel_Btn_linkEstablishment"));

		cancelButton = findElement(By.className("QA_Testing_Panel_Btn_cancel"));

	}
	
	public void initializeBasicSearchSupport() {

		basicSearchLink = findElement(By.className("QA_testing_Basic_Search"));

	}
	
	
	public void initializeBasicSearchOptions() {

		basicSearchDocID = findElement(By.cssSelector(".panel-collapse.collapse.in>div>div>div>div:nth-child(7)>div>div>div>input"));
	}
	
	public void initializeBasicSearchResults() {

		searchResultDocID = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[2]/div/div/div[4]/div/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/h1"));
	}
	
	public void initializeDocDetails() {

		createCRLink = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[5]/div/div/div/div[8]/div/a[1]"));
		linkCRLink = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[5]/div/div/div/div[8]/div/a[2]"));
	}

	public void initializeCRTab() {

		crLink = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[5]/div/div/ul/li[8]/a"));
	}
	public void initializeMessages() {
		message = driver.findElement(By.id("toast-container"));
		// docLink = findElement(By.xpath("//*[contains(@id,'toast-container')]/div/div[2]/a[2]/b"));

	}
}
