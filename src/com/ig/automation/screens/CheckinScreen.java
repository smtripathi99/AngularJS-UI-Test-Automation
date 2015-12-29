package com.ig.automation.screens;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ig.automation.coreactions.DataActions;

public class CheckinScreen extends DataActions {
	public WebElement searchDoc;
	public WebElement basicSearch;
	public Select 	  docIDSearchdropdown;
	public WebElement enterDocIDbox;
	public WebElement searchButton;
	public WebElement filterDocID;
	public WebElement editMenu;
	public WebElement edit;
	public WebElement checkin;
	public Select reasonRevision;
	public WebElement comments;
	public WebElement saveas;
	public WebElement checkinFile;
	public WebElement doneBtn;
	public WebElement cancelBtn;
	public WebElement checkinPanel;
	public WebElement checkInKey;
	public WebElement checkInHeader;
	public WebElement sameVersionRadioBtn;
	public WebElement minorVersionRadioBtn;
	public WebElement lockKey;
	public WebElement majorVersion;
	public WebElement branchVersion;
	public WebElement sourceDocLabel;
	public WebElement sourceDocHeader;
	public WebElement checkInTitle;
	
	
	/*public void initializeSearch() {

		searchDoc = findElement(By
				.xpath("/html/body/div[2]/div[1]/div/div[2]/ul[1]/li/i"));
		
		searchDoc=findElement(By.className("search"));
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
	}*/

	/*public void initializeActionMenu() {

		editMenu = findElement(By
				.xpath("//*[contains(@class,'gcDocMenu__content')]/li[1]"));
		}
	
	public void initializeEdit() {

		edit = findElement(By
				.xpath("/html/body/div/div[3]/div[2]/div[1]/div[2]/div/div/div[1]/div[1]/div/div[2]/ul/li[1]/ul/div[1]/li/a/text()"));
		checkin= findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[2]/div/div/div[1]/div[1]/div/div[2]/ul/li[1]/ul/div[3]/li/a/text()"));
		
	}*/
	
	public void initializeCheckInKey(){
		checkInKey=findElement(By.cssSelector(".gcGrid__row.ng-scope.gcGrid__row-even>div>div>div>i.gcGridCellDocument__icon.keyIcon.ng-scope"));
	}
	
	public void initializeLockKey(){
		lockKey=findElement(By.xpath("//*[contains(@class,'lockIcon ')]"));
	}
	
	
	public void initializeCheckinPanel() {
		//only absolute path is working
//		checkInTitle=findElement(By.xpath("//*[contains(@class,'sidepanel__header')]"));
		checkInTitle=findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[2]/div/div/div[2]/h1"));
		checkInHeader = findElement(By.xpath("//*[contains(@class,'sidepanel__header')]//div[contains(@class,'gc__table-list-Wrap')]"));
		reasonRevision= new Select(findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[2]/div/div/div[4]/div/div/div/div[2]/select")));
		
		comments =findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[2]/div/div/div[4]/div/div/div/div[3]/div/div/textarea"));
		checkinFile=findElement(By.xpath("//*[@id='selectedfile']"));
		doneBtn=findElement(By.className("QA_Testing_Panel_Btn_checkin"));
		cancelBtn=findElement(By.className("QA_Testing_Panel_Btn_cancel"));
	}	
	
	public void initializeCheckInSameMinorRadioBtn(){
		sameVersionRadioBtn=findElement(By.xpath("//*[contains(@class,'section')]/div/div/div[1]/label/input"));
		minorVersionRadioBtn=findElement(By.xpath("//*[contains(@class,'section')]/div/div/div[2]/label/input"));
	}
	
	public void initializeMajorVersion(){
		majorVersion=findElement(By.xpath("//*[contains(@class,'section ')]/div/label"));
	}
	
	public void initializeBrachVersion(){
		branchVersion=findElement(By.cssSelector("label:contains('branch')"));
	}
	
	public void initializeSourceDocPanel(){
		sourceDocLabel=findElement(By.cssSelector("//*[contains(text(),'Select the source document')]"));
		sourceDocHeader=findElement(By.xpath("//*[contains(@class,'ng-isolate-scope')]//div[contains(@class,'gcGrid__header')]"));
	}
}
