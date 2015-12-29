package com.ig.automation.screens;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ig.automation.coreactions.DataActions;

public class CreateCMSScreen extends DataActions {
	
	public WebElement searchDoc;
	public WebElement basicSearch;
	public Select 	  docIDSearchdropdown;
	public WebElement enterDocIDbox;
	public WebElement searchButton;
	public WebElement filterDocID;
	public WebElement editMenu;
	public WebElement createCMS;
	public WebElement createCMSLabel;
	public WebElement rmsHeader;
	public WebElement title;
	public WebElement country;
	public Select language;
	public WebElement createCMSButton;
	public WebElement message;
	
	
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

	public void initializeEditMenu() {

		editMenu = findElement(By
				.xpath("/html/body/div/div[3]/div[2]/div[1]/div[2]/div/div/div[1]/div[1]/div/div[2]/ul/li[1]/a"));
		}
	
	public void initializeCreateCMS() {

		createCMS = findElement(By
				.xpath("/html/body/div/div[3]/div[2]/div[1]/div[2]/div/div/div[1]/div[1]/div/div[2]/ul/li[1]/ul/div[11]/li/a"));
	}
		
	public void initializeCMSPanel() {

		createCMSLabel = findElement(By
				.xpath("/html/body/div/div[3]/div[2]/div[1]/div[1]/div/div/div[2]/h1"));
		
		rmsHeader=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[1]/div/div/div[2]/div/div/div[2]"));
		
		title=findElement(By.className("QA_testing_Title"));
		
		country=findElement(By.
				xpath("/html/body/div/div[3]/div[2]/div[1]/div[1]/div/div/div[4]/div/div/div/accordion/div/div/div[1]/div[2]/div/div[2]/div/div/div/tags-input/div/div/input"));
	
		language=new Select(findElement(By.className("QA_testing_Language")));

		createCMSButton=findElement(By.className("QA_testing_Language"));

	
	}

	public void initializeMessages(){
		message = driver.findElement(By.id("toast-container"));
	}
	
	
	

}
