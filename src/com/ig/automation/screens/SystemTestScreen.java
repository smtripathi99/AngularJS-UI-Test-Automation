package com.ig.automation.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



import com.ig.automation.coreactions.DataActions;


public class SystemTestScreen extends DataActions {

	public WebElement searchIcon;
	public WebElement basicSearchIcon;
	public WebElement docIDSearch;
	public WebElement searchBtn;
	public WebElement selectDoc;
	public WebElement selectVersionCol;
	public WebElement changeRequest;
	public WebElement createCRLink;
	public WebElement createDoc;
	public WebElement createChangeRequest;
	public WebElement logOff;
	public WebElement actions;
	public WebElement coreDataSheet;
	public WebElement crLink;
	public WebElement linkCRLink;
	public Select docIDStatusSearch;
	public WebElement whereRef;
	public WebElement selectCRDoc;
	public WebElement inputVersion;
	public WebElement whereRefversion;
	public WebElement createTranslationLink;
	public WebElement clEU;
	public WebElement taskTab;
	public WebElement notifTab;
	public WebElement notifTabFirstrowDoc;
	public WebElement auditEvent;
	public WebElement auditComment;
	public WebElement datetimeAudit;
	public WebElement dashboard;
	public WebElement uSPI;
	public WebElement docVersion;
	public WebElement changelifecycle;
	public WebElement changelifecycleStatus;
	public WebElement version;
	public WebElement annexII;
	public WebElement blisterLabelingText;
	public WebElement principalDisplayPanel;
	public WebElement createChangeRequestTab;
	public WebElement createChangeRequestLink;
	public WebElement outerLabelingText;
	public WebElement packageLeaflet;
	public WebElement immediateLabelingText;
	public WebElement processManagement;
	public WebElement changeLifeCycleState;
	public WebElement routeForApproval;
	public Select newLifeCycleState;
	public Select signatureMeaning;
	public WebElement userID;
	public WebElement password;
	public WebElement confirmIntention;
	public WebElement finishBtn;
	public WebElement myDocIcon;
	public WebElement relationshipManagement;
	public WebElement translation;
	public WebElement createTranslation;
	public WebElement createTranslationPanel;
	public WebElement targetLanguage;
	public WebElement createTranslationBtn;
	public WebElement message;
	public WebElement docLink;
	public WebElement continueBtn;
	public WebElement sourceDocTab;
	public WebElement linkedDoc1;
	public WebElement linkedDoc2;
	public WebElement myDoc;
	public WebElement myDocTblSearchIcon;
	public WebElement myDocSearch;
	public WebElement repository;
	public WebElement repositorySearch;
	public WebElement repositorySearchIcon;
	public WebElement content;
	public WebElement supportDocTab;
	public WebElement crDocID;
	public WebElement versionRow1;
	public WebElement oneStepApprovalWorkflow;
	public WebElement nextBtn;
	public WebElement docID;
	public WebElement status;
	public WebElement searchTbl;
	public WebElement selectResultCol1;
	public WebElement selectUserName;
	public WebElement auditTrailTab;
	public WebElement tblSearchIcon;
	public WebElement selectComment;
	public WebElement selectProperties;
	public Select selectItemPerPage;
	public Select itemPerPageDropDown;
	
	


	public void initializeHome() {
		createDoc = findElement(By.className("createDoc"));
		createChangeRequest = findElement(By.className("createChangeRequest"));
		logOff = findElement(By.className("logout"));
	}

	public void initializeAction() {
		actions = findElement(By.xpath("/html/body/div/div[2]/div/accordion/div/div[6]/div[1]/h4/a/label/span/span"));
		logOff = findElement(By.className("logout"));
	}
	
	public void initializeMyDoc() {
		myDoc = findElement(By.xpath("/html/body/div/div[2]/div/accordion/div/div[2]/div[1]/h4/a/label/span/span"));
	}
	
	public void initializeMyDocuments() {
		myDocTblSearchIcon = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div[2]/div/div/div[1]/div[2]/div/div[3]/div[1]/span/span/div/span[1]/i"));
		myDocSearch = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div[2]/div/div/div[1]/div[2]/div/div[3]/div[1]/span/span/div/span[2]/span[2]/input"));
		}
	
	public void initializeRepository() {
		repository = findElement(By.xpath("/html/body/div/div[2]/div/accordion/div/div[4]/div[1]/h4/a/label/span/span"));
	}
	
	public void initializeRepositoryListing() {
		content = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[3]/div/span[1]"));
	}
	
	public void initializeRepositoryDocuments() {
		repositorySearchIcon = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[3]/div/div[3]/div[1]/span/span/div/span[1]/i"));
		repositorySearch = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div[2]/div/div/div[1]/div[2]/div/div[3]/div[1]/span/span/div/span[2]/span[2]/input"));
	}
	
	
	public void initializeCreate() {
		createDoc = findElement(By.xpath("/html/body/div/div[2]/div/accordion/div/div[6]/div[2]/div/accordion/div/div[1]/div[1]/h4/a/label/span"));
		createChangeRequest = findElement(By.xpath("/html/body/div/div[2]/div/accordion/div/div[6]/div[2]/div/accordion/div/div[2]/div[1]/h4/a/label/span"));
	}

	public void inilializeObjectsDocType() {
		coreDataSheet = findElement(By.xpath("//*[contains(@class,'gcDocumentType')]/li[contains(text(),'Core Data Sheet')]"));
		uSPI = findElement(By.xpath("//*[contains(@class,'gcDocumentType')]/li[contains(text(),'US Package Insert')]"));
		clEU = findElement(By.xpath("//*[contains(@class,'gcDocumentType')]/li[contains(text(),'Consolidated Label (EU)')]"));
		annexII = findElement(By.xpath("//*[contains(@class,'gcDocumentType')]/li[contains(text(),'Annex II')]"));
		blisterLabelingText = findElement(By.xpath("//*[contains(@class,'gcDocumentType')]/li[contains(text(),'Blister Labeling Text')]"));
		principalDisplayPanel= findElement(By.xpath("//*[contains(@class,'gcDocumentType')]/li[contains(text(),'Principal Display Panel')]"));
		outerLabelingText = findElement(By.xpath("//*[contains(@class,'gcDocumentType')]/li[contains(text(),'Outer Labeling Text')]"));
		packageLeaflet = findElement(By.xpath("//*[contains(@class,'gcDocumentType')]/li[contains(text(),'Package Leaflet')]"));
		immediateLabelingText = findElement(By.xpath("//*[contains(@class,'gcDocumentType')]/li[contains(text(),'Immediate Labeling Text')]"));

	}

	public void initializeSearch() {

		searchIcon = findElement(By.className("search"));
		
	}

	public void initializeBasicSearchIcon() {

		basicSearchIcon = findElement(By.className("QA_testing_Basic_Search"));
		// findElement(By.xpath("/html/body/div/div[3]/div[2]/div[2]/div/gc-search/div[1]/accordion/div/div[1]/div[1]/h4/a/i"));
	}

	public void initializeBasicSearch() {

	//	docIDSearch = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[3]/gc-search/div[1]/accordion/div/div[1]/div[2]/div/div/div/div[7]/div/div/div/input"));
		docIDSearch = findElement(By.cssSelector(".panel-collapse.collapse.in>div>div>div>div:nth-child(7)>div>div>div>input"));
		docIDStatusSearch = new Select(findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[3]/gc-search/div[1]/accordion/div/div[1]/div[2]/div/div/div/div[2]/div/div/div/select[2]")));
		searchBtn = findElement(By.className("QA_testing_Search_Document_Btn"));
	}

	public void initializeSearchResult() {

		//selectDoc = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[5]/div/div[4]/div[3]/div[1]/div/div/span"));											
		selectDoc = findElement(By.cssSelector(".gcGrid__row.ng-scope.gcGrid__row-even>div:nth-child(1)>div>div>span"));
		selectVersionCol = findElement(By.cssSelector(".gcGrid__row.ng-scope.gcGrid__row-even.gcGrid__hover>div:nth-child(5)>div>span"));																					
		inputVersion = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[5]/div/div[3]/div[5]/span/span/div/span[2]/span[2]/input"));	
		myDocIcon = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[5]/div/div[4]/div[3]/div[1]/div/div/i[1]"));
		status = findElement(By.cssSelector(".gcGrid__row.ng-scope.gcGrid__row-even>div:nth-child(7)>div>div>span>span"));
		
	}

	public void initializeDocDetails() {

		createCRLink = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[5]/div/div/div/div[8]/div/a[1]"));
		linkCRLink = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[5]/div/div/div/div[8]/div/a[2]"));
	}

	public void initializeWhereRefTab() {

		whereRef = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[5]/div/div/ul/li[6]/a"));
	}

	public void initializeWhereRefGrid() {

		whereRefversion = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[5]/div/div/div/div[6]/div/div[2]/div/div[4]/div[3]/div[5]/div/span"));
	}

	public void initializeTranslationTab() {

		createTranslationLink = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[2]/div/div/div[1]/div[3]/div/div/div/div[8]/div/a[1]"));
	}

	public void initializeCRTab() {

		crLink = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[5]/div/div/ul/li[8]/a"));
		selectCRDoc = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[4]/div/div[4]/div[3]/div[1]/div/div/span"));

	}

	public void initializeInboxTabs() {
		taskTab = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/ul/li[1]/a"));
		notifTab = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/ul/li[2]/a"));
	}

	public void initializeNotifTabDetails() {

		notifTabFirstrowDoc = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[2]/div/div/div[4]/div[3]/div[1]"));
	}

	public void initializeAuditTab() {
		auditEvent = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div[2]/div/div/div[1]/div[3]/div/div/div/div[1]/div/div/div[4]/div[3]/div[1]/div/span"));
		auditComment = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div[2]/div/div/div[1]/div[3]/div/div/div/div[1]/div/div/div[4]/div[3]/div[9]/div/span/text()"));
		datetimeAudit = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[5]/div/div/div/div[1]/div/div/div[4]/div[3]/div[7]/div/span"));
	}

	public void initializeDashboard(){
		dashboard= findElement(By.className("QA_testing_navigation_home"));
	}									

	public void initializeSearchResult1() {
       selectDoc = findElement(By.cssSelector(".gcGrid__row.ng-scope.gcGrid__row-even>div>div>div>span"));
	}
	
	public void initializeDocVersion(){
	   docVersion = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[5]/div/div[4]/div[3]/div[5]/div/span"));
	}
	
   	public void initializechangelifecycle(){
	   changelifecycle = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[4]/div/div[2]/ul/li[2]/ul/div[1]/li/button"));
   	}
   	
   	public void initializelifecycleStatus(){
	   changelifecycleStatus = findElement(By.className("DocumentStatusTag"));
   	}

	public void initializecreateChangeRequest(){
		createChangeRequestTab=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[6]/div/div/ul/li[8]/a"));
		createChangeRequestLink=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[6]/div/div/div/div[8]/div/a[1]"));
	}													
	
	public void initializeProcessManagement(){
		processManagement=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[4]/div/div[2]/ul/li[3]/a"));
		changeLifeCycleState=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[4]/div/div[2]/ul/li[3]/ul/div[1]"));
		routeForApproval=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[4]/div/div[2]/ul/li[3]/ul/div[3]"));
	}		
	
	public void initializeRelationshipManagement(){
		relationshipManagement=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[4]/div/div[2]/ul/li[4]/a"));
		translation=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[4]/div/div[2]/ul/li[4]/ul/li[1]/a"));
		createTranslation=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[4]/div/div[2]/ul/li[4]/ul/li[1]/ul/div[1]/li/button"));
	}
	
   public void initializeVersion(){
		version=findElement(By.xpath("//*[contains(@class,'gcGrid__row')]/div[7]/div/span"));
	}
	
	public void initializeCreateTranslationPanel(){
		createTranslationPanel=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[2]/div/div/div[2]/h1"));
		targetLanguage=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[2]/div/div/div[4]/div/div[1]/div[1]/div/tags-input/div/div/input"));
		createTranslationBtn = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[2]/div/div/div[5]/button[2]"));
		//continueBtn= findElement(By.className ("QA_Testing_Panel_Btn_continued"));
		
	}
	public void initializeProcessManagementPanel(){
		newLifeCycleState= new Select(findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[2]/div/div/div[4]/div/div[1]/div[1]/select")));									
		signatureMeaning=new Select(findElement(By.className("QA_testing_Signature")));
		userID = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[2]/div/div/div[4]/div/div[1]/div[2]/div[2]/input"));
		password = findElement(By.className("QA_testing_Password"));
		confirmIntention = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[2]/div/div/div[4]/div/div[1]/div[2]/div[4]/label/input"));
		finishBtn = findElement(By.className("QA_Testing_Panel_Btn_lifecycle"));
	}

	
	public void initializeMessages() {
		message = driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[5]/div/div[4]/div[4]/div[1]/div/div/span"));
		//message = waitForElementToAppear(driver, "toast-container");
		
		docLink = findElement(By.xpath("//*[contains(@id,'toast-container')]/div/div[2]/a[2]/b"));
	}
	
	public void initializeLinkedSourceDoc() {
		linkedDoc1 = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[6]/div/div/div/div[6]/div/div[2]/div/div[4]/div[3]/div[1]/div/div/span"));
		linkedDoc2 = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[6]/div/div/div/div[6]/div/div[2]/div/div[4]/div[4]/div[1]/div/div/span"));
											
	}
	
	public void initializeChangedRequestDocTbl() {
		crDocID = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[6]/div/div/div/div[8]/div/div[2]/div/div[4]/div[3]/div[1]/div/div/span"));
	}
	
	public void initializeSourceDocumentTab() {

		sourceDocTab = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[6]/div/div/ul/li[6]/a"));
	}
	
	public void initializeSourceDocumentTbl() {
		docIDSearch = findElement(By.cssSelector(".gcGrid__row.gcGrid__header>div:nth-child(1)>span>span>div>span.display_tbcell.ps_rel>span.tbl_input>input"));
		versionRow1 = findElement(By.cssSelector(".gcGrid__row.ng-scope.gcGrid__row-even.gcGrid__hover>div:nth-child(5)>div>span"));
	}
	
	public void initializeSupportingDocumentTab() {

		supportDocTab = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[6]/div/div/ul/li[7]/a"));
	}	
	
	public void initializeSupportingDocumentTbl() {
		
		docIDSearch = findElement(By.cssSelector(".gcGrid__row.gcGrid__header>div:nth-child(1)>span>span>div>span.display_tbcell.ps_rel>span.tbl_input>input"));
		versionRow1 = findElement(By.cssSelector(".gcGrid__row.ng-scope.gcGrid__row-even.gcGrid__hover>div:nth-child(5)>div>span"));
		docID = findElement(By.cssSelector(".gcGrid__row.ng-scope.gcGrid__row-even.gcGrid__hover>div:nth-child(1)>div>div>span"));
	}	
	
	public void initializeSelectWorkFlowTemplete(){
		oneStepApprovalWorkflow = findElement(By.cssSelector(".gcSidePanel__content>div>div:nth-child(2)>div>div>div.section.Pd1.gc__table-list-Wrap>div>div>div>div>span:nth-child(2)"));
		nextBtn = findElement(By.className("QA_Testing_Panel_Btn_saveTemplate"));
	}
	

	public void initializeAuditTrailItemsPerPage(){
	
		selectItemPerPage = new Select (findElement(By.cssSelector(".ng-scope.active>div>div>div.gcGrid__row.gcGrid__paging>div>div>select")));
	
	}
	
	public void initializeSearchItemsPerPage(){
		itemPerPageDropDown = new Select (findElement(By.cssSelector(".gcGrid__row.gcGrid__paging>div>div>select")));
	}

	
}
