package com.ig.automation.screens;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ig.automation.coreactions.DataActions;

public class HAInterActionTestScreen extends DataActions {
	public WebElement documentID;
	public WebElement submitToHA;
	public WebElement submitToHAdetails;
	public WebElement processManagement;
	public WebElement submitBtn;
	public WebElement cancelBtn;
	public WebElement submissionDate;
	public WebElement documentDetails;
	public WebElement documentProperties;
	public WebElement message;
	public WebElement statusChanged;
	public WebElement dateSelector;
	public WebElement language;
	public WebElement country;
	public WebElement textMessage;
	public WebElement displayMessage;
	public WebElement dateHASubmission;
	public WebElement clearBtnCalender;
	public WebElement calendar;
	public WebElement date;
	public Select haResponseDropDown;
	public WebElement haResponseDate;
	public WebElement dateWithdraw;
	public WebElement searchDoc;
	public WebElement basicSearch;
	public Select docIDSearchdropdown;
	public WebElement enterDocIDbox;
	public WebElement haResponseScreen;
	public WebElement filterDocID;
	public WebElement recordHAResponse;
	public WebElement statusState;
	public WebElement versionState;
	public WebElement changelifecycle;
	public WebElement haSubmissionDate;
	public WebElement actionSubMenu;
	public WebElement withdrawHASubmission;
	public WebElement searchButton;
	public WebElement withdrawHASubmissionScreen;
	public WebElement withdrawHAdate;
	public WebElement withdrawBtn;
	private WebElement processManagement1;
	public WebElement haAuthoritySubmissionDate;
	public WebElement title;
	

	
	public void initializeSearch() {

		searchDoc = findElement(By
				.xpath("//*[contains(@class,'bgHeader')]/div[2]/ul[1]/li/i"));
	}

	public void initializeBasicSearch() {

		basicSearch = findElement(By.className("QA_testing_Basic_Search"));
		
	}

	public void initializeDocIDSearch() {

		docIDSearchdropdown = new Select(findElement(By
				.xpath("/html/body/div[2]/div[3]/div[2]/div[2]/div[1]/gc-search/div[1]/accordion/div/div[1]/div[2]/div/div/div/div[7]/div/div/div/select")));

		enterDocIDbox = findElement(By
				.xpath("//*[contains(@class,'section')]//div[7]//input"));
		searchButton  = findElement(By.className("QA_testing_Search_Document_Btn"));

	}
	public void initializeDocActionSubMenuSubmitToHA() {
		submitToHA = findElement(By.
		//		xpath("//*[contains(@class,'gcDocMenu__subMenu')]/div[4]/li"));
				xpath("/html/body/div[1]/div[3]/div[2]/div/div[4]/div/div[2]/ul/li[3]/ul/div[4]"));
	}
	public void initializeSubMenuRecordHAResponse(){
		recordHAResponse = findElement(By.xpath("//*[contains(@class,'gcDocMenu__subMenu')]/div[5]/li"));
	}
	public void initializeSubMenuWindrawHASubmission(){
		withdrawHASubmission = findElement(By.xpath("//*[contains(@class,'gcDocMenu__subMenu')]/div[6]/li"));
	}
	
	public void initializeDocument() {
		filterDocID = findElement(By.cssSelector(".gcGrid__row.ng-scope.gcGrid__row-even>div>div>div>span"));
	}
	public void initializeDocActionMenu() {
		processManagement = findElement(By.xpath("//*[contains(@class,'gcDocMenu__dropdown-menu')]/ul/li[3]"));
	}
	
	
	public void initializeSubmitToHAScreen(){
		submitToHAdetails = findElement(By.className("sidepanel__header_shadow"));
		textMessage = findElement(By.xpath("//*[contains(@class,'gcSidePanel__content')]/div/div/p"));
	}
	public void initializeHAResponseScreen(){
		haResponseScreen = findElement(By.xpath("//*[contains(@class,'sidepanel__header_shadow')]"));
	}
	public void initializeWithdrawHASubmissionScreen(){
		withdrawHASubmissionScreen = findElement(By.xpath("//*[contains(@class,'sidepanel__header_shadow')]"));
	}
	public void initializeHAResponseDropDown(){
		haResponseDropDown = new Select(findElement(By.className("QA_testing_health_authority_response")));
		haResponseDate = findElement(By.className("QA_testing_health_authority_response_date"));
	}
	
	public void initializeCalendar(){
		haSubmissionDate= findElement(By.className("QA_testing_health_authority_submission_date"));
	}
	public void initializeSubmitBtn(){
		submitBtn = findElement(By.className("QA_Testing_Panel_Btn_submit"));
	}
	public void initializeCancelBtn(){
		cancelBtn = findElement(By.className("QA_Testing_Panel_Btn_cancel"));
	}
	public void initializeDateSelector(){
		dateSelector = findElement(By.className("calender_frmt"));
	}
	public void initializeStatusChanged(){
		statusChanged = findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[5]/div/div[4]/div[3]/div[9]/div/div/span/span"));
		                                     
	}
	public void initializeWithdrawHADate(){
		withdrawHAdate = findElement(By.className("QA_testing_withdraw_health_authority_date"));
	}
	public void initializeWithdrawButton(){
		withdrawBtn = findElement(By.className("QA_Testing_Panel_Btn_withdraw"));
	}
	public void initializeMessages() {
		message = driver.findElement(By.id("toast-container"));
	}
    
	public void initializeWithdrawHASubmission(){
	    dateWithdraw = findElement(By.className("QA_testing_Date"));
	}
	
	public void initializechangelifecycle(){
		changelifecycle = findElement(By.xpath("//*[contains(@class,'gcDocMenu__subMenu')]/div[1]/li"));
	}
	public void initializeStatusState(){
		statusState = findElement(By.xpath("//*[contains(@class,'gcGrid__row')]/div[5]/div/span"));
	}
	public void initializeVersionState(){
		versionState = findElement(By.xpath("//*[contains(@class,'gcGrid__row')]/div[7]/div/div/span/span"));
	}
	 public void initializePopUp(){
	    	processManagement = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[2]/div/div/div[1]/div[2]/div/div[4]/div[3]/div[1]/div/div/span"));
	    }
	public void initializeSubmitToHA(){
		
	}
	public void initializeHAPage(){
		
	}
	public void initializeRecordHAResponse(){
		
	}
	public void initializeHAResponse(){
		
	}
}
