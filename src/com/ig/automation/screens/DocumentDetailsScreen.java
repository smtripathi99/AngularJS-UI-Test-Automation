package com.ig.automation.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ig.automation.coreactions.DataActions;


public class DocumentDetailsScreen extends DataActions {
	public WebElement properties;
	public WebElement typeofDoc;
	public WebElement editLink;
	public WebElement draftState;
	public WebElement rfalink;
	public Select registrant;
	public WebElement optional;
	public WebElement effectiveDate;
	public WebElement saveBtn;
	public WebElement auditTrail;
	public WebElement auditTrailEvent;
	public WebElement userName;
	public WebElement comment;
	public WebElement version;
	public WebElement date;
	public WebElement titleValue;
	public WebElement countriesValue;
	public WebElement languageValue;
	public WebElement productNames;
	public WebElement proprietaryNames;
	public WebElement sourceDoc;
	public WebElement sourceDocId;
	public WebElement versionSourceDoc;
	public WebElement secSourceDocId;
	public WebElement establishments;
	public WebElement linkEstablishment;
	public WebElement searchTab;
	public WebElement editLinkNDC;
	public WebElement typeOfDoc;
	public WebElement labeler;
	public WebElement rfaRegistrant;
	public WebElement contactCountry;
	public WebElement contactPhone;
	public WebElement contactEmail;
	public WebElement title;
	public WebElement splEffectiveDate;
	public WebElement contactName;
	public WebElement contactStreet;
	public WebElement contactCity;
	public WebElement contactState;
	public WebElement contactPostalCode;
	public WebElement estDocID;
	public WebElement estStatus;
	public WebElement dunsNumber;
	public WebElement regNumber;
	public WebElement streetAddress;
	public WebElement city;
	public WebElement state;
	public WebElement postalCode;
	public WebElement edit;
	public WebElement view;
	public WebElement processManagement;
	public WebElement relationshipManagement;


	public void initializePropertie() {
		properties = findElement(By
				.xpath("//*[contains(@class,'ng-binding')][contains(text(),'Properties')]"));
	}

	public void initializeTypeofDoc() {
		typeofDoc = findElement(By
				.xpath("/html/body/div/div[3]/div[2]/div/div/div[4]/div/div/div/div[3]/div/div/accordion/div/div/div[1]/div[2]/div/div/div/span[2]"));
	}

	public void initializeEditLink() {
		editLink = findElement(By
				.cssSelector(".ng-scope.ng-isolate-scope>button:contains('Edit')"));
	}

	public void initializeDraftState() {
		draftState = findElement(By
				.xpath("/html/body/div/div[3]/div[2]/div/div/div[1]/div/div/div[2]/div/div/div[2]/div/div[1]/div[1]/p[1]/span/span"));
	}

	public void initializerfaLink() {
		rfalink = findElement(By
				.xpath("/html/body/div/div[3]/div[2]/div/div/div[1]/div/div/div[4]/div/div/accordion/div/div/div[2]/div[1]/h4/a/span[1]"));
	}

	public void initializeRegistrant() {
		registrant = new Select(
				findElement(By
						.xpath("/html/body/div/div[3]/div[2]/div/div/div[1]/div/div/div[4]/div/div/accordion/div/div/div[2]/div[2]/div/div/div/div/select")));
	}

	public void initializeOptional() {
		optional = findElement(By
				.xpath("//*[contains(@class,'hdng ng-scope')][contains(text(),'Optional')]"));
	}

	public void initializeEffectiveDate() {
		effectiveDate = findElement(By
				.xpath("/html/body/div/div[3]/div[2]/div/div/div[1]/div/div/div[4]/div/div/accordion/div/div/div[3]/div[2]/div/div[5]/div/div/div/div/input"));
	}
	public void initializeSaveBtn(){
		saveBtn = findElement(By.className("QA_Testing_Panel_Btn_save"));
	}
	public void initializeAuditTrail(){
		auditTrail = findElement(By.xpath("//*[contains(@class,'tabbable')]/ul/li[1]"));
	}
	public void initializeAuditTrailEvent(){
		auditTrailEvent = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[6]/div/div/div/div[1]/div/div/div[4]/div[3]/div[1]/div/span"));
	}
	
	//Audit Trail User Name
	public void initializeUserName(){
		userName = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[6]/div/div/div/div[1]/div/div/div[4]/div[3]/div[3]/div/span"));
	}
	//Audit Trail Comment
	public void initializeComment(){
		comment = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[6]/div/div/div/div[1]/div/div/div[4]/div[3]/div[9]/div/span"));
	}
	
	//Audit Trail properties
	public void initializeProperties(){
		properties = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[6]/div/div/div/div[1]/div/div/div[4]/div[3]/div[11]/div/span"));
	}
	
	//Audit Trail Version
	public void initializeVersion(){
		version = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[6]/div/div/div/div[1]/div/div/div[4]/div[3]/div[5]/div/span"));
	}
	
	//Audit Trail Date
	public void initializeDate(){
		date = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[6]/div/div/div/div[1]/div/div/div[4]/div[3]/div[7]/div/span"));
	}
	
	public void initializeEstablishments(){
		establishments = findElement(By.xpath("//*[contains(@class,'tabbable')]/ul/li[8]/a"));
	}
	public void initializeLinkEstablishment(){
		linkEstablishment = findElement(By.xpath("//*[contains(@class,'tab-content')]/div[8]/div/button[2]"));
	}
	
	public void intializeEstablishmentsTbl(){
		
		estDocID = findElement(By.cssSelector(".ng-scope.gcGrid__row-even.gcGrid__selected.gcGrid__hover>div:nth-child(1)>div>div>span"));
		estStatus = findElement(By.cssSelector(".ng-scope.gcGrid__row-even.gcGrid__selected.gcGrid__hover>div:nth-child(7)>div>div>span>span"));
	}
	
	public void initializeSearchTab(){
		searchTab = findElement(By.xpath("//*[contains(@class,'gcSidePanel__content')]/div/div/div/ul/li[2]/a"));
	}
	
	public void initializePropertiesValues(){
		titleValue = findElement(By.cssSelector(".form-field>div.property_list_item>span:nth-child(2)"));
		countriesValue = findElement(By.xpath("//*[contains(@class,'panel-body')]/div[2]/div/span[2]"));
		languageValue = findElement(By.xpath("//*[contains(@class,'panel-body')]/div[3]/div/span[2]"));
		productNames = findElement(By.xpath("//*[contains(@class,'panel-body')]/div[4]/div/div/div/div/div/ul"));
		proprietaryNames = findElement(By.xpath("//*[contains(@class,'panel-body')]//div[5]/div/span[2]"));
	}
	
	public void initializeMandatoryPropertiesValues(String docType){
		if(docType.equals("NDC")){
			editLinkNDC=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[6]/div/div/div/div[3]/div/button"));
			typeOfDoc=findElement(By.xpath("//*[contains(@class,'panel-body')]/div[1]/div/span[2]"));
			labeler=findElement(By.xpath("//*[contains(@class,'panel-body')]/div[2]/div/span[2]"));
		}
		
		if (docType.equals("SID")){
			typeOfDoc=findElement(By.cssSelector(".ng-scope.active>div>div>accordion>div>div>div:nth-child(1)>div.panel-collapse.collapse.in>div>div>div>span:nth-child(2)"));
			
		}
		
		if (docType.equals("EST")){
			typeOfDoc=findElement(By.cssSelector(".ng-scope.active>div>div>accordion>div>div>div:nth-child(1)>div.panel-collapse.collapse.in>div>div>div>span:nth-child(2)"));
		}
		
	}
	
	public void initializeRFAValues(String docType){
		
		if (docType.equals("SID")){
			rfaRegistrant=findElement(By.cssSelector(".ng-scope.active>div>div>accordion>div>div>div:nth-child(2)>div.panel-collapse.collapse.in>div>div>div>span:nth-child(2)"));
		}
		
	}
	
	
	public void initializeOptionalValues(String docType){
		
		if (docType.equals("SID")){
			contactCountry = findElement(By.cssSelector(".ng-scope.active>div>div>accordion>div>div>div:nth-child(3)>div.panel-collapse.collapse.in>div>div:nth-child(2)>div>span:nth-child(2)"));
			contactPhone = findElement(By.cssSelector(".ng-scope.active>div>div>accordion>div>div>div:nth-child(3)>div.panel-collapse.collapse.in>div>div:nth-child(3)>div>span:nth-child(2)"));
			contactEmail = findElement(By.cssSelector(".ng-scope.active>div>div>accordion>div>div>div:nth-child(3)>div.panel-collapse.collapse.in>div>div:nth-child(4)>div>span:nth-child(2)"));
			title = findElement(By.cssSelector(".ng-scope.active>div>div>accordion>div>div>div:nth-child(3)>div.panel-collapse.collapse.in>div>div:nth-child(5)>div>span:nth-child(2)"));
			splEffectiveDate = findElement(By.cssSelector(".ng-scope.active>div>div>accordion>div>div>div:nth-child(3)>div.panel-collapse.collapse.in>div>div:nth-child(6)>div>span:nth-child(2)"));
			contactName = findElement(By.cssSelector(".ng-scope.active>div>div>accordion>div>div>div:nth-child(3)>div.panel-collapse.collapse.in>div>div:nth-child(7)>div>span:nth-child(2)"));
			contactStreet = findElement(By.cssSelector(".ng-scope.active>div>div>accordion>div>div>div:nth-child(3)>div.panel-collapse.collapse.in>div>div:nth-child(8)>div>span:nth-child(2)"));
			contactCity = findElement(By.cssSelector(".ng-scope.active>div>div>accordion>div>div>div:nth-child(3)>div.panel-collapse.collapse.in>div>div:nth-child(9)>div>span:nth-child(2)"));
			contactState = findElement(By.cssSelector(".ng-scope.active>div>div>accordion>div>div>div:nth-child(3)>div.panel-collapse.collapse.in>div>div:nth-child(10)>div>span:nth-child(2)"));
			contactPostalCode = findElement(By.cssSelector(".ng-scope.active>div>div>accordion>div>div>div:nth-child(3)>div.panel-collapse.collapse.in>div>div:nth-child(11)>div>span:nth-child(2)"));

		}
		
		if (docType.equals("EST")){
			contactName = findElement(By.cssSelector(".ng-scope.active>div>div>accordion>div>div>div:nth-child(2)>div.panel-collapse.collapse.in>div>div:nth-child(2)>div>span:nth-child(2)"));
			contactStreet = findElement(By.cssSelector(".ng-scope.active>div>div>accordion>div>div>div:nth-child(2)>div.panel-collapse.collapse.in>div>div:nth-child(3)>div>span:nth-child(2)"));
			contactCity = findElement(By.cssSelector(".ng-scope.active>div>div>accordion>div>div>div:nth-child(2)>div.panel-collapse.collapse.in>div>div:nth-child(4)>div>span:nth-child(2)"));
			contactState = findElement(By.cssSelector(".ng-scope.active>div>div>accordion>div>div>div:nth-child(2)>div.panel-collapse.collapse.in>div>div:nth-child(5)>div>span:nth-child(2)"));
			contactPostalCode = findElement(By.cssSelector(".ng-scope.active>div>div>accordion>div>div>div:nth-child(2)>div.panel-collapse.collapse.in>div>div:nth-child(6)>div>span:nth-child(2)"));
			contactCountry = findElement(By.cssSelector(".ng-scope.active>div>div>accordion>div>div>div:nth-child(2)>div.panel-collapse.collapse.in>div>div:nth-child(7)>div>span:nth-child(2)"));
			contactPhone = findElement(By.cssSelector(".ng-scope.active>div>div>accordion>div>div>div:nth-child(2)>div.panel-collapse.collapse.in>div>div:nth-child(8)>div>span:nth-child(2)"));
			contactEmail = findElement(By.cssSelector(".ng-scope.active>div>div>accordion>div>div>div:nth-child(2)>div.panel-collapse.collapse.in>div>div:nth-child(9)>div>span:nth-child(2)"));
			dunsNumber = findElement(By.cssSelector(".ng-scope.active>div>div>accordion>div>div>div:nth-child(2)>div.panel-collapse.collapse.in>div>div:nth-child(16)>div>span:nth-child(2)"));
			regNumber =	findElement(By.cssSelector(".ng-scope.active>div>div>accordion>div>div>div:nth-child(2)>div.panel-collapse.collapse.in>div>div:nth-child(17)>div>span:nth-child(2)"));
			streetAddress = findElement(By.cssSelector(".ng-scope.active>div>div>accordion>div>div>div:nth-child(2)>div.panel-collapse.collapse.in>div>div:nth-child(18)>div>span:nth-child(2)"));
			city = findElement(By.cssSelector(".ng-scope.active>div>div>accordion>div>div>div:nth-child(2)>div.panel-collapse.collapse.in>div>div:nth-child(19)>div>span:nth-child(2)"));
			state = findElement(By.cssSelector(".ng-scope.active>div>div>accordion>div>div>div:nth-child(2)>div.panel-collapse.collapse.in>div>div:nth-child(20)>div>span:nth-child(2)"));
			postalCode = findElement(By.cssSelector(".ng-scope.active>div>div>accordion>div>div>div:nth-child(2)>div.panel-collapse.collapse.in>div>div:nth-child(21)>div>span:nth-child(2)"));
			
		}
		
	}
	
	
	public void initializeActionMenu(){
		
		edit = findElement(By.xpath("//*[contains(@class,'gcDocMenu__content')]/li[1]/a"));
		view = findElement(By.xpath("//*[contains(@class,'gcDocMenu__content')]/li[2]/a"));
		processManagement = findElement(By.xpath("//*[contains(@class,'gcDocMenu__content')]/li[3]/a"));
		relationshipManagement = findElement(By.xpath("//*[contains(@class,'gcDocMenu__content')]/li[4]/a"));	
	}
	
	
	
	public void initializePropertiesValuesForNDC(){
		editLinkNDC=findElement(By.cssSelector("button:contains('Edit')"));
		typeOfDoc=findElement(By.xpath("//*[contains(@class,'panel-body')]/div[1]/div/span[2]"));
		labeler=findElement(By.xpath("//*[contains(@class,'panel-body')]/div[2]/div/span[2]"));
	}
	
	public void initializeSourceDoc(){
		sourceDoc=findElement(By.cssSelector("a:contains('Source Documents')"));
	}
	
	public void initializesourceDocId(){
		sourceDocId=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[6]/div/div/div/div[6]/div/div[2]/div/div[4]/div[3]/div[1]/div/div/span"));
		versionSourceDoc=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[5]/div/div[4]/div[3]/div[5]/div/span"));
	}
	
	public void initializeSecondSourceDocId(){
		secSourceDocId=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[6]/div/div/div/div[6]/div/div[2]/div/div[4]/div[3]/div[1]/div/div/span"));
	}
}
