package com.ig.automation.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ig.automation.coreactions.DataActions;

public class ContentManagementScreen extends DataActions{

	public WebElement searchDoc;
	public WebElement basicSearch;
	public WebElement filterDocID;
	
	public WebElement edit;
	public WebElement checkin;
	public Select reasonRevision;
	public WebElement comments;
	public WebElement saveas;
	public WebElement checkinFile;
	public WebElement doneBtn;
	
	public WebElement checkinPanel;
	public WebElement cleanCopyAccept ;
	public WebElement cleanCopyRemove;
	public WebElement cleanCopyProcessNotes;
	public WebElement generateCleanCopyLink;
	public WebElement editLink;
	public WebElement generateCleanCopyButton;
	public WebElement generateCleanCopyTitle;
	public WebElement generateCleanCopyTemplate;
	public WebElement message;
	public WebElement annexLink;
	public WebElement cancelButton;
	public WebElement docType;
	public Select docType1;
	public WebElement selectFileText;
	public WebElement selectFileButton;
	public WebElement title;
	public WebElement countries;
	public WebElement proprietaryNames;
	public WebElement importButton;
	public WebElement importCancelButton;
	public Select language;
	public WebElement selectProductName;
	public WebElement productName;
	public WebElement tickBox;
	public WebElement productDoneButton;
	public Select fileFormat;
	public WebElement fileFormat1;
	public WebElement basicSearchIcon; 
	public WebElement searchIcon;
	public WebElement docIDSearch;
	public Select docIDStatusSearch;
	public WebElement searchBtn;
	public WebElement selectDoc;
	public WebElement selectDoc1;
	public WebElement selectVersionCol;
	public WebElement inputVersion;
	public WebElement searchButton;
	public Select docIDSearchdropdown;
	public WebElement enterDocIDbox;
	public WebElement editMenu;
	public WebElement compareDocument;
	public WebElement editDocument;
	public WebElement checkInKey;
	public WebElement allVersions;
	public WebElement selectDocument;
	public WebElement selectDocument1;
	public WebElement compareDocumentBtn;
	public WebElement documentID;
	public WebElement status;
	public WebElement country;
	public WebElement version;
	public WebElement languageHeader;
	public WebElement titleHeader;
	public WebElement tblDocumentID;
	public WebElement tblStatus;
	public WebElement tblCountry;
	public WebElement tblVersion;
	public WebElement tblLanguage;
	public WebElement tblTitle;
	public WebElement cancelBtn;
	public WebElement compareDocPanelHeading;
	public WebElement myDocIcon;
	public WebElement tblSearchIcon;
	public WebElement tblDocIDSearch;
	public WebElement cdsLink;
	public WebElement checkinHeader;
	public WebElement copyDocument;
	public WebElement copyDocumentButton;
	public WebElement messageCopy;
	public WebElement docLink;
	public WebElement splManagement;
	public WebElement generateSPL;
	public WebElement supportingDocLink;
	
	public void initializeAnnex(){
		annexLink = driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div/div[2]/div/div/div/ul/li[1]"));
	}
	
	public void initializeSupportingDoc(){
		supportingDocLink=findElement(By.xpath("//*[contains(@class,'gcDocumentType')]/li[3]"));
	}
	
	public void initializeCDS(){
		cdsLink = driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div/div[2]/div/div/div/ul/li[12]"));
	}
	public void initializeEdit(){
		//editLink=findElement(By.xpath("//*[contains(@class,'gcDocMenu__dropdown-menu')]/ul/li[1]/a"));
		editLink=findElement(By.xpath("//*[contains(@class,'gcDocMenu__dropdown-menu')]//*[contains(@class,'gcDocMenu__content')]/li/a[contains(text(),'Edit')]"));						
	//	editLink=findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div/div[2]/ul/li[1]/a"));
	//	editMenu = findElement (By.xpath("/html/body/div/div[3]/div[2]/div/div[3]/div/div[2]/ul/li[1]/a"));
	//	editDocument = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[3]/div/div[2]/ul/li[1]/ul/div[1]/li/button"));
	}
	
	public void inilializeGenerateCleanCopyLink(){
	//	generateCleanCopyLink=findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[4]/div/div[2]/ul/li[1]/ul/div[8]/li/button"));
		generateCleanCopyLink = findElement(By.xpath("//*[contains(@class,'gcDocMenu__subMenu')]/div[8]"));
	}
	
	public void initializeEditDocument() {
		editDocument = findElement(By
				.cssSelector("button:contains('Edit Document')"));
	}
	
	public void initializeGenerateCleanCopyElements() {
		generateCleanCopyTitle= findElement(By.xpath("//*[contains(text(),'Generate Clean Copy')]"));
		generateCleanCopyTemplate= findElement(By.cssSelector(".sidepanel__header_shadow"));
		cleanCopyAccept = findElement(By.className("QA_testing_accept_track_changes"));
		cleanCopyRemove = findElement(By.className("QA_testing_remove_internal_comments"));
		cleanCopyProcessNotes = findElement(By.className("QA_testing_process_notes"));
		cancelButton=findElement(By.className("QA_Testing_Panel_Btn_cancel"));
	}
	
	public void inilializeGenerateCleanCopyButton(){
		generateCleanCopyButton = findElement(By.className("QA_Testing_Panel_Btn_genCleanCopy"));
		copyDocument=findElement(By.cssSelector(".gcDocMenu__dropdown-menu>ul>li>ul>div:nth-child(2).ng-isolate-scope"));
	}
	
	public void initializeSuccessMessages() {
		message = waitForElementToAppear(driver, "toast-container");

	}
	
	public void initializeImportDocType(){
		docType=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[4]/div/div/div[2]/div[1]/select"));
		docType1=new Select(findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[4]/div/div/div[2]/div[1]/select")));
		selectFileText=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[4]/div/div/div[2]/div[2]/div/input"));
		selectFileButton=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[4]/div/div/div[2]/div[2]/div/button"));
	}
	
	public void initializeImportDocs(){
		title=findElement(By.className("QA_testing_Title"));
		fileFormat1=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[4]/div/div/div[2]/div[3]/select"));
		fileFormat=new Select(findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[4]/div/div/div[2]/div[3]/select")));
		countries=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[4]/div/div/div[2]/div[4]/accordion/div/div/div[1]/div[2]/div/div[2]/div/div/div/tags-input/div/div/input"));
		language=new Select(findElement(By.className("QA_testing_Language")));
		selectProductName=findElement(By.className("QA_testing_Select_product"));
		proprietaryNames=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[4]/div/div/div[2]/div[4]/accordion/div/div/div[1]/div[2]/div/div[5]/div/div/div/tags-input/div/div/input"));
		importButton=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/h1/button[2]"));
		importCancelButton=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/h1/button[1]"));
	}
	
	public void initializeProductName(){
		productName=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[4]/div/div/div[2]/div[4]/accordion/div/div/div[1]/div[2]/div/div[4]/div/div/div[2]/div/div[4]/div/div[1]/div/tags-input/div/div/input"));
	}
	
	public void initializeTickBox(){
		tickBox=findElement(By.className("QA_testing_Product_name_values_0"));
		productDoneButton=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[4]/div/div/div[2]/div[4]/accordion/div/div/div[1]/div[2]/div/div[4]/div/div/div[2]/div/h1/button[2]"));
	}
	
	
	
	public void initializeSearch() {

		searchIcon = findElement(By.className("search"));
	}

	public void initializeBasicSearchIcon() {

		basicSearchIcon = findElement(By.className("QA_testing_Basic_Search"));
		// findElement(By.xpath("/html/body/div/div[3]/div[2]/div[2]/div/gc-search/div[1]/accordion/div/div[1]/div[1]/h4/a/i"));
	}

	public void initializeBasicSearch() {

		docIDSearch = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[2]/gc-search/div[1]/accordion/div/div[1]/div[2]/div/div/div/div[7]/div/div/div/input"));
		docIDStatusSearch = new Select(findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[2]/gc-search/div[1]/accordion/div/div[1]/div[2]/div/div/div/div[2]/div/div/div/select[2]")));
		searchBtn = findElement(By.className("QA_testing_Search_Document_Btn"));
	}

	public void initializeSearchResult() {

		selectDoc = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[4]/div/div[4]/div[3]/div[1]/div/div/i[3]"));
		///html/body/div/div[3]/div[2]/div/div[4]/div/div[4]/div[3]/div[1]/div/div/i[3]
		selectDoc1 = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[4]/div/div[4]/div[4]/div[1]/div/div/i[3]"));
		myDocIcon = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[4]/div/div[4]/div[3]/div[1]/div/div/i[1]"));
	}
	
	public void initializeCompareDocument() {
		compareDocument = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div[2]/div/div/div[1]/div[1]/div/div[2]/ul/li[1]/ul/div[8]/li/button"));
		allVersions = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div/div/div[4]/div/div/div/ul/li[2]/a"));
		selectDocument = findElement (By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div/div/div[4]/div/div/div/div/div[2]/div/div[4]/div[4]/div[1]/div"));
		selectDocument1 = findElement (By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div/div/div[4]/div/div/div/div/div[1]/div/div[4]/div[3]/div[1]/div"));
		compareDocumentBtn = findElement (By.xpath("QA_Testing_Panel_Btn_compareDocument"));
		cancelBtn = findElement (By.xpath("QA_Testing_Panel_Btn_cancel"));
		compareDocPanelHeading = findElement (By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div/div/div[2]/h1"));
	}
	
	public void initializeCheckIn() {
		checkInKey = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[4]/div/div[4]/div[3]/div[1]/div/div/i[2]"));
	}
	
	public void initializeDocIDSearch() {

		docIDSearchdropdown = new Select(findElement(By
				.xpath("/html/body/div/div[3]/div[2]/div/div[2]/gc-search/div[1]/accordion/div/div[1]/div[2]/div/div/div/div[7]/div/div/div/select")));

		enterDocIDbox = findElement(By
				.xpath("/html/body/div/div[3]/div[2]/div/div[2]/gc-search/div[1]/accordion/div/div[1]/div[2]/div/div/div/div[7]/div/div/div/input"));
						
		searchButton  = findElement(By.className("QA_testing_Search_Document_Btn"));

	}
			
	
	public void initializeCompareDocumentHeaderPanel(){
		documentID = findElement (By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div/div/div[2]/div/div/div[2]/h1"));
		status = findElement (By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div/div/div[2]/div/div/div[2]/div/div[1]/div[1]/p[1]/span"));
		country = findElement (By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div/div/div[2]/div/div/div[2]/div/div[1]/div[1]/p[2]/span"));
		version = findElement (By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div/div/div[2]/div/div/div[2]/div/div[1]/div[2]/p[1]/span"));
		languageHeader = findElement (By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div/div/div[2]/div/div/div[2]/div/div[1]/div[2]/p[2]/span"));
		titleHeader = findElement (By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div/div/div[2]/div/div/div[2]/div/div[2]/p/span"));
	}
	
	
	public void initializeCompareDocumentTable(){
		tblDocumentID = findElement (By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div/div/div[4]/div/div/div/div/div[1]/div/div[4]/div[3]/div[1]/div/span"));
		tblStatus = findElement (By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div/div/div[4]/div/div/div/div/div[1]/div/div[4]/div[3]/div[5]/div/div/span"));
		tblCountry = findElement (By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div/div/div[4]/div/div/div/div/div[1]/div/div[4]/div[3]/div[9]/div/span"));
		tblVersion = findElement (By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div/div/div[4]/div/div/div/div/div[1]/div/div[4]/div[3]/div[3]/div/span"));
		tblLanguage = findElement (By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div/div/div[4]/div/div/div/div/div[1]/div/div[4]/div[3]/div[7]/div/span"));
		tblTitle = findElement (By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div/div/div[4]/div/div/div/div/div[1]/div/div[4]/div[3]/div[11]"));
		tblSearchIcon = findElement (By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div/div/div[4]/div/div/div/div/div[1]/div/div[3]/div[1]/span/span/div/span[1]/i"));
		tblDocIDSearch = findElement (By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div/div/div[4]/div/div/div/div/div[1]/div/div[3]/div[1]/span/span/div/span[2]/span[2]/input"));
	}	

	public void initializeDocument() {
		filterDocID = findElement(By
				.xpath("/html/body/div[2]/div[3]/div[2]/div[2]/div[2]/div[16]/div[5]/div[3]/div[1]/div/div/span"));
	}

	public void initializeActionMenu() {

		editMenu = findElement(By
				.xpath("//*[contains(text(),'Edit')]"));
		}
	
	
	
	public void initializeCheckInKey(){
		checkInKey=findElement(By.cssSelector(".gcGrid__row.ng-scope.gcGrid__row-even>div>div>div>i.gcGridCellDocument__icon.keyIcon.ng-scope"));
	}
	
	public void initializeCheckinPanel() {
		checkinPanel=findElement(By.xpath("//*[contains(text(),'Checkin Document')]"));
		checkinHeader=findElement(By.xpath("//*[contains(@class,'gc__table-list-Wrap')]"));
		reasonRevision = new Select(findElement(By
				.xpath("//*[contains(@class,'form-control')]")));
						
		comments= findElement(By.xpath("//*[contains(@name,'title')]"));
	//	saveas= findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[1]/div/div/div[4]/div/div/div[1]/div/label/b"));
	//	checkinFile= findElement(By.className("QA_testing_Checkin"));
		checkinFile=findElement(By.xpath("//*[@id='selectedfile']"));
		doneBtn=findElement(By.className("QA_Testing_Panel_Btn_checkin"));
		cancelBtn=findElement(By.className("QA_testing_Panel_Btn"));
	}	
	public void initializeCopyDocumentButton(){
		copyDocumentButton=findElement(By.className("QA_Testing_Panel_Btn_copyDocument"));
		
	}
	
	public void initializeMessages() {
		// message = driver.findElement(By.id("toast-container"));
		messageCopy = waitForElementToAppear(driver, "toast-container");
		docLink = findElement(By.xpath("//*[contains(@id,'toast-container')]/div/div[2]/a[2]/b"));

	}
	public void initializeSPLManagement(){
		splManagement = findElement(By.cssSelector("span:contains('SPL Management')"));
	}
	
	public void initializeGenerateSPL(){
		generateSPL=findElement(By.cssSelector("button:contains('Generate SPL')"));
	}
	
}
