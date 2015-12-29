package com.ig.automation.screens;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ig.automation.coreactions.DataActions;

public class GenerateProfileViewScreen extends DataActions {
	
	public WebElement searchDoc;
	public WebElement basicSearch;
	public Select 	  docIDSearchdropdown;
	public WebElement enterDocIDbox;
	public WebElement searchButton;
	public WebElement filterDocID;
	public WebElement generateProfile;
	public WebElement generateProfileTitle;
	public WebElement docHeader;
	public WebElement productCheckbox;
	public WebElement formCheckbox;
	public WebElement strengthCheckbox;
	public WebElement generateProfileBtn;
	public WebElement generateProfileCancelBtn;
	public WebElement relationsMenu;
	public WebElement presentationCheckbox;
	
	
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

		relationsMenu = findElement(By
				.xpath("/html/body/div/div[3]/div[2]/div[1]/div[2]/div/div/div[1]/div[1]/div/div[2]/ul/li[4]/a"));
		}
	
	public void initializeGenerateProfile() {

		generateProfile = findElement(By
				.xpath("/html/body/div/div[3]/div[2]/div[1]/div[2]/div/div/div[1]/div[1]/div/div[2]/ul/li[4]/ul/div/li/a"));
	}
		
	public void initializeGenerateProfileViewPanel() {

		generateProfileTitle = findElement(By
				.xpath("/html/body/div/div[3]/div[2]/div[1]/div[1]/div/div/div[2]/h1"));
		
		docHeader = findElement(By
						.xpath("/html/body/div/div[3]/div[2]/div[1]/div[1]/div/div/div[2]/div/div/div[2]"));	
		productCheckbox=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[1]/div/div/div[4]/div/div/div[2]/div/div[1]/span/input"));
		formCheckbox=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[1]/div/div/div[4]/div/div/div[2]/div/div[2]/div/div[1]/span/input"));
		strengthCheckbox=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[1]/div/div/div[4]/div/div/div[2]/div/div[2]/div/div[2]/div/div[1]/span/input"));
		presentationCheckbox=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[1]/div/div/div[4]/div/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/span/input"));

	}

	public void initializeGenerateButtons() {

		generateProfileBtn = findElement(By.className("QA_testing_Panel_Btn"));
		generateProfileCancelBtn = findElement(By.className("QA_testing_Panel_Btn"));

	}

}
