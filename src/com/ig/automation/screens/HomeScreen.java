package com.ig.automation.screens;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ig.automation.coreactions.DataActions;


public class HomeScreen extends DataActions {
	public WebElement actions;
	public WebElement createDoc;
	public WebElement myDoc;
	public WebElement cabinets;
	public WebElement productList;
	public WebElement folder;
	public WebElement leftTitle;
	public WebElement logOff;
	public WebElement createCR;
	public WebElement searchIcon;
	public WebElement createCP;
	public WebElement createRMS;
	public WebElement eusubmission;
	public WebElement spl;
	public WebElement createSPL;
	public WebElement createNewRegistration;
	public WebElement createNewSelfID;
	public WebElement createNewNDC;
	public WebElement inbox;
	public WebElement basicSearchIcon;
	public WebElement docIDSearch;
	public WebElement searchBtn;
	public WebElement importContact;
	public WebElement admin;
	public WebElement manageLegalHold;
	public WebElement createRegistrationSPL;
	public WebElement dashboard;
	public WebElement repository;
	public WebElement dynview;
	public WebElement reports;
	public WebElement xmLimage;
	public WebElement loggedUser;
	public WebElement notification;
	public WebElement dashboardLabel;
	public WebElement SMPCLink;
	public WebElement docList;
	public WebElement documentID;
	public WebElement language;
	public WebElement currentVersion;
	public WebElement status;
	public WebElement title;
	public WebElement productLabeling;
	public WebElement docIdSearch;
	public WebElement productSearchResult;
	public WebElement countrySearchResult;
	public WebElement docTypeSearchResult;
	public WebElement docSearchIcon;
	public WebElement  docId;
	public WebElement country;
	
	public void initializeLeftNavigationObjects() {
		
		dashboard = findElement(By
				.className("dashboard"));
		repository = findElement(By				
				.className("repository"));
		dynview = findElement(By				
				.className("dynView"));
		actions= findElement(By.className("actions"));
		myDoc = findElement(By.xpath("//*[contains(@class,'myDoc')]"));
		leftTitle = findElement(By.className("logo"));		
		logOff = findElement(By
				.className("logout"));
		searchIcon = findElement(By
				.className("search"));
		reports = findElement(By
				.className("reports"));
		admin = findElement(By
				.className("admin"));
		inbox = findElement(By.className("inbox"));	
	
	}

public void initializeTopNavigationObjects(boolean mail) {
		
		leftTitle = findElement(By.className("logo"));			
		searchIcon = findElement(By
				.className("search"));		
		loggedUser=findElement(By.className("userCont"));
		if(mail==true){
			notification = findElement(By.className("mail"));
		}
		logOff = findElement(By
				.className("logout"));
		
	}
	public void initializeActionObjects() {

		createDoc = findElement(By.xpath("//*[contains(text(),'Create New Document')]"));
		createCR = findElement(By.xpath("//*[contains(text(),'Create Change Request')]"));
		spl = findElement(By.xpath("//*[contains(text(),'SPL')]"));
		eusubmission = findElement(By.xpath("//*[contains(text(),'EU Submissions')]"));
		
	}
	
	public void initializeDashboard() {

		dashboardLabel = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/h1"));
	
	}

	public void initializeSearch() {

		searchIcon = findElement(By.className("search"));
	}

	public void initializeBasicSearchIcon() {

		basicSearchIcon = findElement(By.className("QA_testing_Basic_Search"));
		// findElement(By.xpath("/html/body/div/div[3]/div[2]/div[2]/div/gc-search/div[1]/accordion/div/div[1]/div[1]/h4/a/i"));
	}

	public void initializeBasicSearch() {

		//docIDSearch = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[2]/gc-search/div[1]/accordion/div/div[1]/div[2]/div/div/div/div[7]/div/div/div/input"));
		searchBtn = findElement(By.className("QA_testing_Search_Document_Btn"));
	}

	public void initializeSPLObjects() {

		createNewRegistration = findElement(By.xpath("//*[contains(text(),'Create New Registration')]"));
		createNewSelfID = findElement(By.xpath("//*[contains(text(),'Create New Self Identification')]"));
		createNewNDC = findElement(By.xpath("//*[contains(text(),'Create New NDC Labeler Code')]"));
	}

	public void initializeEUSubmissionObjects() {

		createCP = findElement(By
		// .className("centralisedprocedure"));
				.xpath("//*[contains(text(),'Create Centralized Procedure')]"));

		createRMS = findElement(By.xpath("//*[contains(text(),'Create RMS')]"));
	}

	public void initializeCabinets() {
		productList = findElement(By.xpath("//*[contains(text(),'Product Labeling')]"));		
		
	}

	public void initializeFolders() {
		folder = findElement(By.xpath("//*[contains(@class,'gcGrid__cell')]/div/div/span"));
	}
	
	public void initializeDocumentsList() {
		docList = findElement(By.xpath("//*[contains(@class,'gcGrid__row')]/div[1]/div/div/span"));
		documentID=findElement(By
				.xpath("//span[text()='Document ID']"));						
		language=findElement(By
				.xpath("//span[text()='Language']"));
		currentVersion=findElement(By
				.xpath("//span[text()='Version']"));
		status=findElement(By
				.xpath("//span[text()='Status']"));
		title=findElement(By
				.xpath("//span[text()='Title']"));
		country=findElement(By
				.xpath("//span[text()='Country']"));
	}

	public void initializeImportContact() {
		importContact = findElement(By.xpath("/html/body/div/div[2]/div/accordion/div/div[6]/div[2]/div/accordion/div/div[3]/div[1]/h4/a/label/span"));
	}

	public void initializeCreateSPL() {
		createSPL = findElement(By.xpath("/html/body/div/div[2]/div/accordion/div/div[6]/div[2]/div/accordion/div/div[4]/div[2]/div/ul/li[1]"));
	}
	
	public void initializeCreateRegistrationSPL(){
		createRegistrationSPL=findElement(By.xpath("/html/body/div/div[2]/div/accordion/div/div[6]/div[2]/div/accordion/div/div[4]/div[2]/div/ul/li[5]"));
	}
	
	public void initializeAdmin(){
		manageLegalHold=findElement(By.xpath("/html/body/div/div[2]/div/accordion/div/div[8]/div[2]/div/accordion/div/div[2]/div[1]/h4/a/label/span"));
	}
	
	public void initializeSelectDocType(){
		SMPCLink=findElement(By.xpath("//*[contains(@class,'gcDocumentType_condition')]/li[8]"));
		
	}
	
	public void initializeCreateNewSelfIdentification() {
		createNewSelfID=findElement(By.xpath("//*[contains(@class,'panel-body')]/ul/li[3][contains(text(),'Create New Self Identification')]"));
	}
	
	
	public void initializeRepository() {
		productLabeling=findElement(By.xpath("//*[contains(@class,'hCabinate')]/span[1][contains(text(),'Product')]"));
	}
	
	public void initializeProductLabeling(){
		docSearchIcon = findElement(By.xpath("//*[contains(@class,'TblsearchIcon')]"));
		docIdSearch = findElement(By.xpath("//*[contains(@class,'tbl_input')]/input"));
	}
	
	public void initializeProductSearchResult(){
		productSearchResult = findElement(By.xpath("//*[contains(text(),'Alkaline Aqua')]"));

	}
	
	public void initializeCountrySearchResult(){
		countrySearchResult = findElement(By.xpath("//*[contains(text(),'United States')]"));

	}
	
	public void initializeDocTypeSearchResult(){
		docTypeSearchResult = findElement(By.xpath("//*[contains(text(),'Blister Labeling Text')]"));

	}
	
	public void initializeDocIDSearchResult(){
		docId = findElement(By.cssSelector(".ng-scope>div>div>div.tab-content>div.gcGrid__upperSection>div>div>div>div:nth-child(4)>div.gcGrid__row.ng-scope.gcGrid__row-even.gcGrid__hover>div:nth-child(1)>div>div>span"));
	}
}
