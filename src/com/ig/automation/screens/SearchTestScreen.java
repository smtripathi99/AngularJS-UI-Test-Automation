package com.ig.automation.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.ig.automation.coreactions.DataActions;

public class SearchTestScreen extends DataActions {
	public WebElement createDoc;
	public WebElement searchIcon;
	public WebElement cancelBtn;
	public WebElement createdDocument;
	public WebElement productNameBtn;
	public WebElement genericName;
	public WebElement enterProductName;
	public WebElement product;
	public WebElement doneBtn;
	public WebElement filterProduct;
	public WebElement dosageFrom;
	public WebElement strength;
	public WebElement presentation;
	public WebElement checkBox;
	public WebElement removeButton;
	public WebElement checkBoxGenericName;
	public WebElement productNameValues;
	public WebElement searchText;
	public WebElement basicSearch;
	public WebElement docID;
	public WebElement status;
	public Select statusDropDown;
	public WebElement language;
	public Select languageDropDown;
	public WebElement country;
	public Select countryDropDown;
	public WebElement contents;
	public WebElement hide;
	public WebElement searchDocBtn;
	public WebElement advanceSearch;
	public WebElement annex;
	public WebElement artWork;
	public WebElement blister;
	public WebElement cp;
	public WebElement cd;
	public WebElement component;
	public WebElement cms;
	public WebElement clEU;
	public WebElement cds;
	public WebElement deviceSubmission;
	public WebElement ilText;
	public WebElement ndc;
	public WebElement outer;
	public WebElement packageLeaflet;
	public WebElement pdp;
	public WebElement rms;
	public WebElement registration;
	public WebElement sopc;
	public WebElement supportingDoc;
	public WebElement template;
	public WebElement uspi;
	public WebElement legalStatus;
	public WebElement docIdValue;
	public WebElement documentId;
	public WebElement firstLine;
	public WebElement secondLine;
	public WebElement thirdLine;
	public WebElement fourthLine;
	public WebElement fifthLine;
	public WebElement sixLine;
	public WebElement sevenLine;
	public WebElement eightLine;
	public WebElement nineLine;
	public WebElement tenLine;
	public WebElement version;
	public WebElement title;
	public Select itemsPerPage;
	public WebElement row;
	public WebElement menuBar;
	public WebElement basicSearchIcon;
	public WebElement selectDoc;
	public WebElement docIDSearch;
	public Select docIDStatusSearch;
	public WebElement docID1;
	public WebElement searchDocBtn1;
	public WebElement selectDoc1;
	public WebElement searchAgainBtn;
	public WebElement editSearchViewBtn;
	public WebElement dynamicViewBtn;
	public WebElement docStatus;
	public WebElement countrytextField;
	public WebElement docTypes;
	public WebElement selectDocTypeResult;
	public WebElement readOnlySearchResult;
	public WebElement selectDocTypeAnnexII;
	public WebElement selectDocTypeArtwork;
	public WebElement selfIdentification;
	public WebElement status1;
	public WebElement language1;
	public WebElement nextlinkPagination;
	public WebElement prevLinkPagination;
	public WebElement pageNumberHyperlink;
	public WebElement docDetailsPanel;
	public WebElement createDynamicViewScreen;
	public WebElement basicSearchScreen;
	public WebElement myDocIcon;
	public WebElement tblSearchIcon;
	public Select statusSearch;
	
	
	public void initializeSearch() {

		searchIcon = findElement(By.className("search"));
	}
	
	public void initializeBasicSearchIcon() {

		basicSearchIcon = findElement(By.className("QA_testing_Basic_Search"));
		// findElement(By.xpath("/html/body/div/div[3]/div[2]/div[2]/div/gc-search/div[1]/accordion/div/div[1]/div[1]/h4/a/i"));
	}
	public void initializeSearchText() {

		searchText = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[2]/h1"));
	}
	public void initializeBasicSearchScreen(){
		basicSearchScreen = findElement(By.xpath("//*[contains(text(),'Contents')]"));
	}

	public void initializeBasicSearch() {
		docID=findElement(By.xpath("//div[7]//*[contains(@name,'title')]"));
       basicSearch = findElement(By.className("QA_testing_Basic_Search"));
    //   docID = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[2]/div/gc-search/div[1]/accordion/div/div[1]/div[2]/div/div/div/div[7]/div/div/label"));
       status = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[3]/gc-search/div[1]/accordion/div/div[1]/div[2]/div/div/div/div[2]/div/div/div/select[1]"));
		statusDropDown = new Select(
				findElement(By
						.xpath("/html/body/div/div[3]/div[2]/div/div[3]/gc-search/div[1]/accordion/div/div[1]/div[2]/div/div/div/div[2]/div/div/div/select[2]")));
       language = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[3]/gc-search/div[1]/accordion/div/div[1]/div[2]/div/div/div/div[4]/div/div/div/select[1]"));
       languageDropDown = new Select (findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[3]/gc-search/div[1]/accordion/div/div[1]/div[2]/div/div/div/div[4]/div/div/div/select[2]")));
       countrytextField = findElement(By.xpath("//*[contains(@class,'QA_testing_countryies')]/div/div/input"));
    		   //"/html/body/div/div[3]/div[2]/div/div[3]/gc-search/div[1]/accordion/div/div[1]/div[2]/div/div/div/div[3]/div/div/div/div/tags-input/div/div/input"));
	   countryDropDown = new Select (findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[3]/gc-search/div[1]/accordion/div/div[1]/div[2]/div/div/div/div[3]/div/div/div/select")));
	   contents = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[3]/gc-search/div[1]/accordion/div/div[1]/div[2]/div/div/div/div[1]/div/div/div/input"));
	   hide = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[3]/gc-search/div[1]/accordion/div/div[1]/div[1]/h4/a/span[2]"));
	   searchDocBtn =  findElement(By.className("QA_testing_Search_Document_Btn"));
	   advanceSearch = findElement(By.xpath("//*[contains(@class,'QA_testing_Advance_Search')]"));
	   docIdValue = findElement(By
				.xpath("//*[contains(@class,'panel-body')]/div/div/div[7]/div/div/div/input"));
	 
	}               
	public void initializeDocTypes(){
		docTypes = findElement(By.className("doc_container_full"));
	}
	public void initializeSelectDocType(){
		selectDocTypeAnnexII = findElement(By.xpath("//*[contains(@class,'doc_container_full')]/li[1]/span"));
				
	}
	public void initializeSelectDocTypeResult(){
		selectDocTypeResult = findElement(By.xpath("//*[contains(text(),'Additional Description')]"));
	}
	public void initializeReadOnlySearchResult(){
		readOnlySearchResult = findElement(By.xpath("//*[contains(@class,'gc__table-list-Wrap')]/div/div/div[1]/p"));
	}   
	
	public void initializeAdvanceSearch(){
		/*selectDocType = findElement(By
				.xpath("/html/body/div/div[3]/div[2]/div[2]/div[1]/gc-search/div[1]/accordion/div/div[2]/div[2]/div/div/div/div/label"));*/
		annex =       findElement(By.xpath("//*[contains(@class,'doc_container_full')]/li[1]/span"));
		artWork =     findElement(By.xpath("//*[contains(@class,'doc_container_full')]/li[2]/span"));
		blister =     findElement(By.xpath("//*[contains(@class,'doc_container_full')]/li[3]/span"));
		cp =          findElement(By.xpath("//*[contains(@class,'doc_container_full')]/li[4]/span"));
		cd =          findElement(By.xpath("//*[contains(@class,'doc_container_full')]/li[5]/span"));
		component =   findElement(By.xpath("//*[contains(@class,'doc_container_full')]/li[6]/span"));
		cms =         findElement(By.xpath("//*[contains(@class,'doc_container_full')]/li[7]/span")); 
		clEU =        findElement(By.xpath("//*[contains(@class,'doc_container_full')]/li[8]/span"));
		cds =         findElement(By.xpath("//*[contains(@class,'doc_container_full')]/li[9]/span"));
		deviceSubmission = findElement(By.xpath("//*[contains(@class,'doc_container_full')]/li[10]/span"));
		ilText =      findElement(By.xpath("//*[contains(@class,'doc_container_full')]/li[11]/span"));
		ndc =         findElement(By.xpath("//*[contains(@class,'doc_container_full')]/li[12]/span"));
		outer =       findElement(By.xpath("//*[contains(@class,'doc_container_full')]/li[13]/span"));
		packageLeaflet = findElement(By.xpath("//*[contains(@class,'doc_container_full')]/li[14]/span"));
		pdp =         findElement(By.xpath("//*[contains(@class,'doc_container_full')]/li[15]/span"));
		rms =         findElement(By.xpath("//*[contains(@class,'doc_container_full')]/li[16]/span"));
		registration = findElement(By.xpath("//*[contains(@class,'doc_container_full')]/li[17]/span"));
		selfIdentification = findElement(By.xpath("//*[contains(@class,'doc_container_full')]/li[18]/span"));
		sopc =        findElement(By.xpath("//*[contains(@class,'doc_container_full')]/li[19]/span"));
		supportingDoc =   findElement(By.xpath("//*[contains(@class,'doc_container_full')]/li[20]/span"));
		template =    findElement(By.xpath("//*[contains(@class,'doc_container_full')]/li[21]/span"));
		uspi =        findElement(By.xpath("//*[contains(@class,'doc_container_full')]/li[22]/span"));

	}
	public void initializedocumentType(){
		legalStatus = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[2]/div/gc-search/div[1]/accordion/div/div[2]/div[2]/div/div/div/div[2]/div/div/label"));
		searchDocBtn =  findElement(By.className("QA_testing_Search_Document_Btn"));
		
	}
	public void initializeSearchResult(){
		selectDoc = findElement(By.cssSelector(".gcGrid__row.ng-scope.gcGrid__row-even>div>div>div>span"));
		//documentId = findElement(By.xpath("//*[contains(text(),'Document ID')]"));
		documentId = findElement(By.xpath("//*[contains(@class,'gcGrid__row')]/div[1]/span/span"));
		version = findElement(By.xpath("//*[contains(@class,'gcGrid__row')]/div[5]/span/span"));
		status1 =  findElement(By.xpath("//*[contains(@class,'gcGrid__row')]/div[7]/span/span"));
		language1 =  findElement(By.xpath("//*[contains(@class,'gcGrid__row')]/div[3]/span/span"));
		title = findElement(By.xpath("//*[contains(@class,'gcGrid__row')]/div[9]/span/span"));
		itemsPerPage  = new Select(findElement(By.xpath("//*[contains(@class,'gcGrid__paging')]/div[2]/div/select")));
		firstLine = findElement(By.xpath("//*[contains(@class,'ng-isolate-scope')]/div[4]/div[3]"));
		secondLine = findElement(By.xpath("//*[contains(@class,'ng-isolate-scope')]/div[4]/div[4]"));
		/*	thirdLine = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[5]/div/div[4]/div[5]/div[1]/div/div/span"));
		fourthLine = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[5]/div/div[4]/div[6]/div[1]/div/div/span"));
		fifthLine = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[5]/div/div[4]/div[7]/div[1]/div/div/span"));
		sixLine = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[5]/div/div[4]/div[8]/div[1]/div/div/span"));
		sevenLine = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[5]/div/div[4]/div[9]/div[1]/div/div/span"));
		eightLine = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[5]/div/div[4]/div[10]/div[1]/div/div/span"));
		nineLine = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[5]/div/div[4]/div[11]/div[1]/div/div/span"));
		tenLine = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[5]/div/div[4]/div[12]/div[1]/div/div/span"));*/
		//row = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[2]/div[2]/div/div[4]/div[3]/div[1]/div/div"));
	  //  menuBar = findElement(By.className("cntrfrmt"));
		myDocIcon = findElement(By.xpath("//*[contains(@class,'ng-isolate-scope')]/div[4]/div[3]/div[1]/div/div/i[1]"));
		tblSearchIcon = findElement(By.xpath("//*[contains(@class,'ng-isolate-scope')]/div/div[3]/div[3]/span/span/div/span[1]/i"));

	}
	public void initializeMenuBar(){
		menuBar = findElement(By.className("gcDocMenu__dropdown-menu"));
	}
	 public void pageScrollUp() {
		 Actions actions = new Actions(driver);
		 actions.keyUp(Keys.CONTROL).sendKeys(Keys.END).perform();
		 }
	
	public void initializeNextLinkpagination(){
		nextlinkPagination = findElement(By.xpath("//*[contains(@class,'gcGrid__paging')]/div[1]/span[9]/a"));
	}
	public void initializePrevLinkPagination(){
		prevLinkPagination = findElement(By.xpath("//*[contains(@class,'gcGrid__paging')]/div[1]/span[1]"));
	}
	public void initializePageNumberHyperlink(){
		pageNumberHyperlink = findElement(By.xpath("//*[contains(@class,'gcGrid__paging')]/div[1]/span[4]"));
	}
	public void initializeDocDetailsPanel(){
		docDetailsPanel= findElement(By.xpath("//*[contains(@class,'tabbable')]/ul/li[1]"));
	}
	
	
	
	public void initializeBasicSearch1() {
		statusSearch=new Select(findElement(By.className("QA_testing_status")));
		docID1=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[3]/gc-search/div[1]/accordion/div/div[1]/div[2]/div/div/div/div[7]/div/div/div/input"));
		searchDocBtn1 =  findElement(By.className("QA_testing_Search_Document_Btn"));
	}
	
	public void initializeSearchResult1(){
		selectDoc1 = findElement(By.cssSelector(".gcGrid__row.ng-scope.gcGrid__row-even>div>div>div>span"));
		docStatus = findElement(By.
				//cssSelector(".gcGrid__row-even.gcGrid__selected.gcGrid__hover>div:nth-child(7)>div>div"));
	            xpath("/html/body/div[1]/div[3]/div[2]/div/div[5]/div/div[4]/div[3]/div[9]/div/div/span/span"));
	}
	
	public void initializeSearchCriteria(){
		dynamicViewBtn = findElement(By.className("QA_testing_Dynamic_View_Btn"));
		searchAgainBtn = findElement(By.className("QA_testing_Search_Again_Btn"));
		editSearchViewBtn = findElement(By.xpath("//*[contains(@class,'QA_testing_Edit_Search_Btn')]"));
	}
	public void initializeCreateDynamicViewScreen(){
		createDynamicViewScreen = findElement(By.className("gcSidePanel__content"));
	}
	
}
