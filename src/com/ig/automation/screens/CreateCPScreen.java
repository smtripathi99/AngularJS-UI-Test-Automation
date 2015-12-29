package com.ig.automation.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ig.automation.coreactions.DataActions;


public class CreateCPScreen extends DataActions {
	public WebElement createDoc;
	public String documentType;
	public WebElement title;
	public WebElement country;
	public Select addDoclanguage;
	public WebElement productName;
	public WebElement enterProductName;
	public WebElement tickBox;
	public WebElement productDoneBtn;
	public Select proprietaryName;
	public WebElement selectAddDocTemplate;
	public WebElement selectATemplate;
	public WebElement templateDoneBtn;
	public WebElement createBtn;
	public WebElement select;
	public WebElement template;
	public WebElement selectedProductName;
	public WebElement selectedTemplate;
	public WebElement createdDoc;
	public WebElement verifyText;
	public WebElement annexType;
	public WebElement packageLeaflet;
	public WebElement supportingDocument;
	public WebElement component;
	public WebElement blisterLabelingText;
	public WebElement uspi;
	public WebElement sopc;
	public WebElement deviceSubmission;
	public WebElement pdp;
	public WebElement clEU;
	public WebElement coreDataSheet;
	public WebElement immidiateLabelingText;
	public WebElement genericName;
	public Select code;
	public WebElement legalStatus;
	public WebElement contents;
	public WebElement authors;
	public WebElement notificationRecipients;
	public WebElement additionalDescription;
	public WebElement comments;
	public Select resonForRevision;
	public Select submissionType;
	public Select registrationProcedure;
	public WebElement selectSourceDocBtn;
	public WebElement selectSourceDoc;
	public WebElement searchTab;
	public WebElement basicSearch;
	public WebElement content;
	public Select status;
	public WebElement advanceSearch;
	public WebElement searchDocType;
	public WebElement selectedDocType;
	public WebElement searchDocBtn;
	public WebElement myDocument;
	public WebElement selectMyDoc;
	public WebElement doneBtnMyDoc;
	public Select countrySearch;
	public Select languageSearch;
	public Select genericNameSearch;
	public Select docIDSearch;
	public WebElement createBtnUSPI;
	public WebElement templateuspi;
	public WebElement selectSourceMyDocListing;
	public WebElement SourceDoneBtn;
	public WebElement searchDocumentBtn;
	public WebElement message;
	public WebElement docProperty;
	public WebElement cancelBtn;
	public WebElement pickTemplate;
	public WebElement selectASourceDoc;
	public WebElement myDocsListing;
	public WebElement searchBtn;
	public WebElement basicSearchProperty;
	public WebElement advanceSearchProperty;
	public WebElement selectedSourceDoc;
	public WebElement selectProduct;
	public WebElement product;
	public WebElement rfa;
	public WebElement optional;
	public WebElement addDocBtn;
	public WebElement createCPBtn;
	public WebElement createCPScreen;
	public WebElement addDocScreen;
	public WebElement countryProp;
	public WebElement proprName;
	public WebElement sopcIcon;
	public WebElement AnnexIIicon;
	public WebElement outerIcon;
	public WebElement immidiateIcon;
	public WebElement blisterIcon;
	public WebElement pLIcon;
	public WebElement docDefIcon;
	public WebElement cCPBtnIcon;
	public WebElement cancelBtnIcon;
	public WebElement productNames;
	public WebElement smpcColor;
	public WebElement annexColor;
	public WebElement outerColor;
	public WebElement plColor;
	public WebElement docDefColor;
	public WebElement immidiateColor;
	public WebElement blisterColor;
	public WebElement smpcHover;
	public WebElement countryDocProp;
	public Select languageDocProp;
	public WebElement selectProductName;
	public WebElement proprietaryNameDocProp;
	public WebElement createDocBtn;
	public WebElement selectSearchDocTypeforLink;
	public WebElement iconGenericName;
	public WebElement iconLanguage;
	public WebElement iconCountries;
	public WebElement iconPencil;
	public WebElement docTablet;
	public WebElement docDefText;
	public WebElement docdefGenericName;
	public WebElement selectDocDef;
	public WebElement linkDoneBtn;
	public WebElement dashboard;
	public WebElement SearchTabforLink;
	public WebElement searchBtnLink;
	public WebElement messageLink;
	public WebElement searchIcon;
	public WebElement searchTextField;
	public Select itemsPerPage;
	public WebElement selectDocType;
	public WebElement piDoc;
	public WebElement linkDocType;
	public WebElement anHover;
	public WebElement outHover;
	public WebElement bliHover;
	public WebElement immHover;
	public WebElement plHover;
	public WebElement linkBasicSearch;
	public WebElement linkDocID;
	public WebElement linkBasicSearchShow;
	public WebElement piResultAN;
	public WebElement docdefForm;
	public WebElement docdefFormText;
	public WebElement docdefStrength;
	public WebElement docdefStrengthText;
	public WebElement docdefPresentation;
	public WebElement docdefPresentationText;
	public WebElement docdefAlkaline;
	public WebElement docdefAlkalineText;
	public WebElement docdefFormSyrup;
	public WebElement docdefFormSyrupText;
	public WebElement createAfterHoverSMPC;
	public WebElement linkAfterHoverSMPC;
	public WebElement removeIconAfterHoverSMPC;
	public WebElement linkAfterHoverAN;
	public WebElement createAfterHoverAN;
	public WebElement createAfterHoverOUT;
	public WebElement linkAfterHoverOUT;
	public WebElement createAfterHoverBLI;
	public WebElement linkAfterHoverBLI;
	public WebElement createAfterHoverIMM;
	public WebElement linkAfterHoverIMM;
	public WebElement createAfterHoverPL;
	public WebElement linkAfterHoverPL;
	public WebElement unlinkIcon;
	public WebElement alakineFirstIcon;
	public WebElement alakineSecIcon;
	public WebElement formIcon;
	public WebElement syrupIcon;
	public WebElement docDefTenMl;
	public WebElement docDefTenMlText;
	public WebElement strengthFirstIcon;
	public WebElement strengthSecIcon;
	public WebElement docDefPresentaionFluid;
	public WebElement docDefPresentaionFluidText;
	public WebElement presentationFirstIcon;
	public WebElement presentationSecIcon;
	public WebElement actions;
	public WebElement euSubmission;
	public WebElement createCPLink;
	public WebElement docLink;
	public WebElement piResultBLI;
	public WebElement piResultIMM;
	public WebElement piResultOUT;
	public WebElement piResultPL;
	public WebElement piResultSMPC;
	public WebElement cpScreentText;
	public WebElement rfaShow;
	public WebElement optionalShow;

	public void initializeActions(){
		actions = findElement(By.className("actions"));
	}
	public void initializeEUSubmission(){
		euSubmission = findElement(By.
				xpath("//*[contains(text(),'EU Submissions ')]"));
		       
		
	}
	public void initializeCreateCPLink(){
		createCPLink = findElement(By.
		//		xpath("//*[contains(@class,'SubNav')]/li[1]"));
				xpath("//*[contains(@class,'SubNav')]//*[contains(text(),'Create Centralized Procedure')]"));
	}
	public void initializeCPScreentext(){
		cpScreentText = findElement(By.className("darkgrey"));
	}
	
	public void initializeObjectsCP() {

		title = findElement(By.className("QA_testing_title"));
		country = findElement(By.
				xpath("//*[contains(@class,'QA_testing_countryies')]/div/div/*[contains(@class,'input')]"));
		productName = findElement(By.className("QA_testing_product_names"));
		proprietaryName = new Select(findElement(By.className("QA_testing_proprietary_name")));
		rfa = findElement(By.
             xpath("//*[contains(@class,'panel-heading')]/h4/a//*[contains(text(),'Required')]"));
		rfaShow = findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div/div[1]/div/div[2]/div/accordion/div/div/div[2]/div[1]/h4/a/span[2]"));
		optional = findElement(By.xpath("//*[contains(@class,'panel-heading')]/h4/a//*[contains(text(),'Optional')]"));
		optionalShow = findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div/div[1]/div/div[2]/div/accordion/div/div/div[3]/div[1]/h4/a/span[2]"));
		cancelBtn = findElement(By.className("QA_testing_Cancel-Centralised-Procedure"));
        
	}
	
	public void initializeShowButton(){
		createCPBtn = findElement(By.className("QA_testing_Centralised-Procedure"));
		addDocBtn = findElement(By.className("QA_testing_Add-Document"));
	}
	
	public void initializeDashboardScreen(){
		dashboard = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/h1"));
	}

	public void initializeCPScreen() {
		createCPScreen = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[2]/div/div[2]/h1"));

	}

	public void initializeAddDocScreen() {
		addDocScreen = findElement(By.className("createProcedurePannel"));
		sopcIcon = findElement(By.className("gcAddDocument__bg_gtc_xm_prescribing_info_eu"));
		AnnexIIicon = findElement(By.className("gcAddDocument__bg_gtc_xm_annex_ll"));
		outerIcon = findElement(By.className("gcAddDocument__bg_gtc_xm_pkg_text_outer"));
		blisterIcon = findElement(By.className("gcAddDocument__bg_gtc_xm_pkg_text_blister"));
		immidiateIcon = findElement(By.className("gcAddDocument__bg_gtc_xm_pkg_text_immediate"));
		pLIcon = findElement(By.className("gcAddDocument__bg_gtc_xm_patient_info_eu"));
		docDefIcon = findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[1]/div/div[7]"));
		cCPBtnIcon = findElement(By.xpath("//*[contains(@class,'gcAddDocument__button')]/button[1]"));
		cancelBtnIcon = findElement(By.xpath("//*[contains(@class,'gcAddDocument__button')]/button[2]"));
	}

	public void initializeCPProperties() {
		countryProp = findElement(By.xpath("//*[contains(@class,'pull-left')]/div/span[1]"));
		proprName = findElement(By.xpath("//*[contains(@class,'pull-left')]/div/span[3]"));
		productNames = findElement(By.xpath("//*[contains(@class,'pull-left')]/div/span[5]"));
		
	}

	public void initializeColor() {
		smpcColor = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[1]"));
       	annexColor = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[2]"));
		outerColor = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[3]"));
		plColor = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[6]"));
		docDefColor = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[7]"));
		immidiateColor = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[4]"));
		blisterColor = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[4]"));

	}

	public void initializeSMPCHover() {
		smpcHover = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[1]"));
	}
	public void initializeCreateAfterHoverSMPC(){
		createAfterHoverSMPC = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[1]/div/span[1]"));
	}
	public void initializeLinkAfterHoverSMPC(){
		linkAfterHoverSMPC = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[1]/div/span[2]"));
	}
	public void initializeRemoveIconAfterHoverSMPC(){
		removeIconAfterHoverSMPC= findElement(By.className("gcAddDocument__panel_icon_remove"));
	}
	public void initializeCreateAfterHoverAN(){
		createAfterHoverAN = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[2]/div/span[1]"));
	}
	public void initializeLinkAfterHoverAN(){
		linkAfterHoverAN = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[2]/div/span[2]"));
	}
	public void initializeCreateAfterHoverOUT(){
		createAfterHoverOUT = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[3]/div/span[1]"));
	}
	public void initializeLinkAfterHoverOUT(){
		linkAfterHoverOUT = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[3]/div/span[2]"));
	}
	public void initializeCreateAfterHoverBLI(){
		createAfterHoverBLI = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[4]/div/span[1]"));
	}
	public void initializeLinkAfterHoverBLI(){
		linkAfterHoverBLI = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[4]/div/span[2]"));
	}
	public void initializeCreateAfterHoverIMM(){
		createAfterHoverIMM = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[5]/div/span[1]"));
	}
	public void initializeLinkAfterHoverIMM(){
		linkAfterHoverIMM = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[5]/div/span[2]"));
	}
	public void initializeCreateAfterHoverPL(){
		createAfterHoverPL = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[6]/div/span[1]"));
	}
	public void initializeLinkAfterHoverPL(){
		linkAfterHoverPL = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[6]/div/span[2]"));
	}
	public void initializeANHover() {
		anHover = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[2]"));
	}

	public void initializeOUTHover() {
		outHover = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[3]"));
	}

	public void initializeBLIHover() {
		bliHover = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[4]"));
	}

	public void initializeIMMHover() {
		immHover = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[5]"));
	}

	public void initializePLHover() {
		plHover = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[6]"));
	}
	public void initializeUnlinkIcon(){
		unlinkIcon = findElement(By
				 .className("gcAddDocument__panel_icon_remove"));
	}

	public void initializeAddDocLanguage() {
		addDoclanguage = new Select(findElement(By.className("QA_testing_language")));
	}

	public void initializeDocProp() {
		title = findElement(By.className("QA_testing_title"));
		selectProductName = findElement(By.className("QA_testing_product_names"));
	}

	public void initializeProductName() {

		enterProductName = findElement(By.xpath("//*[contains(@class,'QA_testing_generic_name')]/div/div/input"));
		productDoneBtn = findElement(By.className("QA_Testing_Panel_Btn_done"));

	}

	public void initializeTickBox() {
		tickBox = findElement(By.className("QA_testing_Product_name_values_0"));
	}

	public void initializeproprietary() {
		proprietaryNameDocProp = findElement(By
				.xpath("/html/body/div/div[3]/div[2]/div[3]/div/div[1]/div/div[2]/div/accordion/div/div/div[1]/div[2]/div/div[5]/div/div/div/tags-input/div/div/input"));
	}

	public void initializeSelectAddDocTemplate() {
		/*
		 * selectedProductName = findElement(By
		 * .xpath("/html/body/div/div[4]/div[2]/div[3]/div[2]/div[1]/div/div/accordion/div/div/div[1]/div[2]/div/div[4]/div/div/div/div/div/ul/li[4]"));
		 */

		selectAddDocTemplate = findElement(By.className("QA_testing_Select_Template"));

			}

	public void initializeAddDocTemplate() {
		selectATemplate = findElement(By
		 .xpath("//*[contains(@class,'gcSidePanel__content')]/div/div/div/div[2]/h1"));
				

		templateDoneBtn = findElement(By
		 .className("QA_Testing_Panel_Btn_doneTemplate"));
				}

	public void initializecreateDocumentBtn() {
		createDocBtn = findElement(By.className("QA_testing_Create_Document"));
	}

	public void initializeDocIcon() {
		iconGenericName = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[1]/button/div/div/span[3]"));
		iconLanguage = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[1]/button/div/div/span[2]"));
		iconCountries = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[1]/button/div/div/span[1]"));
		iconPencil = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[1]/div/button[2]"));

	}

	public void initializeLinkToExisting() {
		SearchTabforLink = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[4]/div/div[4]/div/div/div/ul/li[2]/a"));

	}

	public void initializeLinkSearchBtn() {

		searchBtnLink = findElement(By.className("QA_testing_Search_Document_Btn"));
	}

	public void initializeSelectSearchDocTypeforLink() {

		selectSearchDocTypeforLink = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[4]/div/div[4]/div/div/div/div/div[2]/div/div/div[2]/div[1]/div"));

	}

	public void initializeLinkDoneBtn() {

		linkDoneBtn = findElement(By.
		className("QA_Testing_Panel_Btn_doneLinkToExisiting"));
				//xpath("/html/body/div/div[3]/div[2]/div[4]/div/h1/button[2]"));
	}

	public void initializedocTablet() {
		docTablet = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[1]/button/div/div"));

	}

	public void initializeDocDefText() {
		docDefText = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[3]/div/div/div[1]/h1"));
	}

	public void initializeDocDefGenericName() {
		docdefGenericName = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[3]/div/div/div[2]/div/div[1]/div/div[1]/span/input"));
	}
    public void initializeDocDefForm(){
    	docdefForm = findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div/div/div[2]/div/div[1]/div/div[2]/div/div[1]/span/input"));
    }
    public void initializeDocDefFormText(){
    	docdefFormText = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[3]/div/div/div[2]/div/div[1]/div/div[2]/div/div[1]/span/div/div/div[2]/ul/li"));
    }
    public void initializeDocDefStrength(){
    	docdefStrength = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[3]/div/div/div[2]/div/div[1]/div/div[2]/div/div[2]/div/div[1]/span/input"));
    }
    public void initializeDocDefStrengthText(){
    	docdefStrengthText = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[3]/div/div/div[2]/div/div[1]/div/div[2]/div/div[2]/div/div[1]/span/div/div/div[2]/ul/li[1]"));
    }
    public void initializeDocDefPresentation(){
    	docdefPresentation = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[3]/div/div/div[2]/div/div[1]/div/div[2]/div/div[2]/div/div[2]/span/input"));
    }
    public void initializeDocDefPresentationText(){
    	docdefPresentationText = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[3]/div/div/div[2]/div/div[1]/div/div[2]/div/div[2]/div/div[2]/span/div/div/div[2]/ul/li[1]"));
    }
    public void initializeDocDefAlkaline(){
    	docdefAlkaline = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[3]/div/div/div[2]/div/div[2]/div/div[1]/span/input"));
    }
    public void initializeDocDefAlkalineText(){
    	docdefAlkalineText = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[3]/div/div/div[2]/div/div[2]/div/div[1]/span/div/div/div[2]/ul/li"));
    }
    public void initializeDocDefFormSyrup(){
    	docdefFormSyrup = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[3]/div/div/div[2]/div/div[2]/div/div[2]/div[1]/div[1]/span/input"));
    }
    public void initializeDocDefFormSyrupText(){
    	docdefFormSyrupText = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[3]/div/div/div[2]/div/div[2]/div/div[2]/div[1]/div[1]/span/div/div/div[2]/ul/li"));
    }
	public void initializeSelectDocDef() {
		selectDocDef = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[3]/div/div/div[2]/div/div[1]/div/div[1]/span/div/div/div[2]/ul/li"));
	}

	public void initializeMessage() {
		message = waitForElementToAppear(driver, "toast-container");
		//docLink = findElement(By.xpath("//*[contains(@id,'toast-container')]/div/div[2]/a[2]/b"));
	}

	public void initializeMessageLink() {
		messageLink = findElement(By.xpath("//*[contains(@id,'toast-container')]/div/div[2]/a[2]/b"));
	}

	public void initializeItemsPerPage() {
		itemsPerPage = new Select(findElement(By.className("QA_testing_")));
	}

	public void initializeSearchIcon() {
		searchIcon = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[3]/div/div[3]/div[1]/span/span/div/span[1]/i"));
	}

	public void initializeSearchTextField() {
		searchTextField = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[3]/div/div[3]/div[1]/span/span/div/span[2]/span[2]/input"));
	}

	public void initializeSelectDocType() {
		selectDocType = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[3]/div/div[4]/div[3]"));
	}

	public void initializePIDoc() {
		piDoc = findElement(By.xpath("//*[contains(@class,'tabbable')]/ul/li[7]/a"));
	}

	public void initializeLinkDocType() {
		linkDocType = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[4]/div/div/div/div[7]/div/div[2]/div/div[4]/div[3]"));
	}

	public void initiaizeLinkBasicSearch() {
		linkBasicSearch = findElement(By.className("QA_testing_Basic_Search"));
	}

	public void initializeLinkDocID() {
		linkDocID = findElement(By
				.xpath("/html/body/div/div[3]/div[2]/div[4]/div/div[4]/div/div/div/div/div[2]/div/gc-search/div[1]/accordion/div/div[1]/div[2]/div/div/div/div[7]/div/div/div/input"));
	}

	public void initiaizeLinkBasicSearchShow() {
		linkBasicSearchShow = findElement(By
				.xpath("/html/body/div/div[3]/div[2]/div[4]/div/div[4]/div/div/div/div/div[2]/div/gc-search/div[1]/accordion/div/div[1]/div[1]/h4/a/span[2]"));
	}

	public void initializePIResult() {
		piResultAN = findElement(By.xpath("//*[contains(@class,'tab-pane')]//*[contains(@class,'gcGrid__cell')]//*[contains(text(),'AN-')]"));
		piResultBLI = findElement(By.xpath("//*[contains(@class,'tab-pane')]//*[contains(@class,'gcGrid__cell')]//*[contains(text(),'BLI-')]"));
		piResultIMM = findElement(By.xpath("//*[contains(@class,'tab-pane')]//*[contains(@class,'gcGrid__cell')]//*[contains(text(),'IMM-')]"));
		piResultOUT = findElement(By.xpath("//*[contains(@class,'tab-pane')]//*[contains(@class,'gcGrid__cell')]//*[contains(text(),'OUT-')]"));
		piResultPL = findElement(By.xpath("//*[contains(@class,'tab-pane')]//*[contains(@class,'gcGrid__cell')]//*[contains(text(),'PL-')]"));
		piResultSMPC = findElement(By.xpath("//*[contains(@class,'tab-pane')]//*[contains(@class,'gcGrid__cell')]//*[contains(text(),'SmPC-')]"));
	}
	public void initializeSelectedTemplate() {
		selectedTemplate = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div/div[2]"));
	}

	public void initializeSelectSourceDocumentButton() {
		if (documentType.equals("Package Leaflet") || documentType.equals("US Package Insert") || documentType.equals("Device Submission")
				|| documentType.equals("Consolidated Label (EU)") || documentType.equals("Summary of Product Characteristics")) {
			selectSourceDocBtn = findElement(By.className("QA_testing_Select_Source_Document"));
		}
	}

	public void initializeSelectASourceDoc() {
		selectASourceDoc = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[3]/div[3]/div[2]/h1"));
		myDocsListing = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[3]/div[3]/div[2]/div[2]/div/div/div[2]/ul/li[2]/a"));
	}

	public void initializeSelectSourceDocumentMyDocListing() {

		selectSourceMyDocListing = findElement(By.xpath("/html/body/div/div[4]/div[2]/div[3]/div[3]/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]"));

	}

	public void initializeSearch() {
		searchTab = findElement(By.xpath("/html/body/div/div[4]/div[2]/div[3]/div[3]/div[2]/div[2]/div/div/div[2]/ul/li[1]/a"));
		basicSearch = findElement(By
				.xpath("/html/body/div/div[4]/div[2]/div[3]/div[3]/div[2]/div[2]/div/div/div[2]/div/div[1]/div/gc-search/div[1]/accordion/div/div[1]/div[1]/h4/a/span[1]"));
		basicSearchProperty = findElement(By
				.xpath("/html/body/div/div[4]/div[2]/div[3]/div[3]/div[2]/div[2]/div/div/div[2]/div/div[1]/div/gc-search/div[1]/accordion/div/div[1]/div[2]/div"));
		advanceSearch = findElement(By
				.xpath("/html/body/div/div[4]/div[2]/div[3]/div[3]/div[2]/div[2]/div/div/div[2]/div/div[1]/div/gc-search/div[1]/accordion/div/div[2]/div[1]/h4/a/span[1]"));
		advanceSearchProperty = findElement(By
				.xpath("/html/body/div/div[4]/div[2]/div[3]/div[3]/div[2]/div[2]/div/div/div[2]/div/div[1]/div/gc-search/div[1]/accordion/div/div[2]/div[2]/div/div/div/div/label"));

	}

	public void initializeDoneBtn() {
		searchDocBtn = findElement(By.className("QA_testing_Search_Document_Btn"));
		SourceDoneBtn = findElement(By.xpath("QA_testing_Done_Btn"));

	}

	public void initializeSelectedSourceDoc() {
		selectedSourceDoc = findElement(By.xpath("/html/body/div/div[4]/div[2]/div[3]/div[2]/div[3]/div/div/div/div[2]"));
	}

	/*
	 * public void initializeSelectSourceBasicSearch(){ selectSourceDoc = findElement(By.xpath("/html/body/div/div[4]/div[2]/div[3]/div[2]/div[3]/h1/button")); searchTab =
	 * findElement(By.xpath("/html/body/div/div[4]/div[2]/div[3]/div[3]/div[3]/div[2]/div/div/div[2]/ul/li[1]/a")); basicSearch =
	 * findElement(By.xpath("/html/body/div/div[4]/div[2]/div[3]/div[3]/div[3]/div[2]/div/div/div[2]/div/div[1]/div/accordion/div/div[1]/div[1]/h4/a/span[1]")); content =
	 * findElement
	 * (By.xpath("/html/body/div/div[4]/div[2]/div[3]/div[3]/div[3]/div[2]/div/div/div[2]/div/div[1]/div/accordion/div/div[1]/div[2]/div/div/div/div/div/div/div/div/input"));
	 * status = new Select(findElement(By.xpath(
	 * "/html/body/div/div[4]/div[2]/div[3]/div[3]/div[2]/div[2]/div/div/div[2]/div/div[1]/div/gc-search/div[1]/accordion/div/div[1]/div[2]/div/div/div/div[2]/div/div/div/select[2]"
	 * ))); countrySearch = new Select(findElement(By.xpath(
	 * "/html/body/div/div[4]/div[2]/div[3]/div[3]/div[2]/div[2]/div/div/div[2]/div/div[1]/div/gc-search/div[1]/accordion/div/div[1]/div[2]/div/div/div/div[3]/div/div/div/select[2]"
	 * ))); languageSearch = new Select(findElement(By.xpath(
	 * "/html/body/div/div[4]/div[2]/div[3]/div[3]/div[2]/div[2]/div/div/div[2]/div/div[1]/div/gc-search/div[1]/accordion/div/div[1]/div[2]/div/div/div/div[4]/div/div/div/select[2]"
	 * ))); genericNameSearch = new Select(findElement(By.xpath(
	 * "/html/body/div/div[4]/div[2]/div[3]/div[3]/div[2]/div[2]/div/div/div[2]/div/div[1]/div/gc-search/div[1]/accordion/div/div[1]/div[2]/div/div/div/div[6]/div/div/div/select[2]"
	 * ))); docIDSearch = new Select(findElement(By.xpath(
	 * "/html/body/div/div[4]/div[2]/div[3]/div[3]/div[2]/div[2]/div/div/div[2]/div/div[1]/div/gc-search/div[1]/accordion/div/div[1]/div[2]/div/div/div/div[7]/div/div/div/input"
	 * )));
	 * 
	 * }
	 * 
	 * public void initializeSelectSourceAdvanceSearch(){
	 * 
	 * advanceSearch = findElement(By.xpath("/html/body/div/div[4]/div[2]/div[3]/div[3]/div[3]/div[2]/div/div/div[2]/div/div[1]/div/accordion/div/div[2]/div[1]/h4/a/span[1]"));
	 * searchDocType =
	 * findElement(By.xpath("/html/body/div/div[4]/div[2]/div[3]/div[3]/div[3]/div[2]/div/div/div[2]/div/div[1]/div/accordion/div/div[2]/div[2]/div/div/div[1]/input"));
	 * selectDocType =
	 * findElement(By.xpath("/html/body/div/div[4]/div[2]/div[3]/div[3]/div[3]/div[2]/div/div/div[2]/div/div[1]/div/accordion/div/div[2]/div[2]/div/div/div[1]/ul/li[1]"));
	 * searchDocBtn = findElement(By.xpath("/html/body/div/div[4]/div[2]/div[3]/div[3]/div[3]/div[2]/div/div/div[2]/div/div[1]/div/div/button"));
	 * 
	 * }
	 */
	public void initializeSelectSourceDocumentMyDocument() {
		myDocument = findElement(By.xpath("/html/body/div/div[4]/div[2]/div[3]/div[3]/div[3]/div[2]/div/div/div[2]/ul/li[2]/a"));
		selectMyDoc = findElement(By.xpath("/html/body/div/div[4]/div[2]/div[3]/div[3]/div[3]/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/p[2]"));
		doneBtnMyDoc = findElement(By.xpath("/html/body/div/div[4]/div[2]/div[3]/div[3]/div[3]/div[3]/button"));
	}

	public void initializeMessages() {
		message = driver.findElement(By.id("toast-container"));
	}
	public void initializeAlakineIcon(){
		alakineFirstIcon =findElement(By.xpath("/html/body/div/div[3]/div[2]/div[3]/div/div/div[2]/div/div[2]/div/div[1]/div/div/span/i[1]"));
		alakineSecIcon =findElement(By.xpath("/html/body/div/div[3]/div[2]/div[3]/div/div/div[2]/div/div[2]/div/div[1]/div/div/span/i[2]"));
	}
	
	public void initializeFormIcon(){
		formIcon =findElement(By.xpath("/html/body/div/div[3]/div[2]/div[3]/div/div/div[2]/div/div[2]/div/div[2]/div[1]/div[1]/div/div/span/i[1]"));
		syrupIcon =findElement(By.xpath("/html/body/div/div[3]/div[2]/div[3]/div/div/div[2]/div/div[2]/div/div[2]/div[1]/div[1]/div/div/span/i[2]"));
	}
	
	public void initializeDocDefStrength10ml(){
		docDefTenMl=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[3]/div/div/div[2]/div/div[2]/div/div[2]/div[1]/div[2]/div/div[1]/span/input"));
	}
	
	
	public void initializeDocDefStrength10mlText(){
		docDefTenMlText=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[3]/div/div/div[2]/div/div[2]/div/div[2]/div[1]/div[2]/div/div[1]/span/div/div/div[2]/ul/li[1]"));
	}
	
	
	public void initializeStrengthIcon(){
		strengthFirstIcon =findElement(By.xpath("/html/body/div/div[3]/div[2]/div[3]/div/div/div[2]/div/div[2]/div/div[2]/div[1]/div[2]/div/div[1]/div/div/span/i[1]"));
		strengthSecIcon =findElement(By.xpath("/html/body/div/div[3]/div[2]/div[3]/div/div/div[2]/div/div[2]/div/div[2]/div[1]/div[2]/div/div[1]/div/div/span/i[2]"));
	}
	
	public void inilializeDocDefFluid(){
		docDefPresentaionFluid=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[3]/div/div/div[2]/div/div[2]/div/div[2]/div[1]/div[2]/div/div[2]/div/span/input"));
	}
	
	public void inilializeDocDefFluidText(){
		docDefPresentaionFluidText=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[3]/div/div/div[2]/div/div[2]/div/div[2]/div[1]/div[2]/div/div[2]/div/span/div/div/div[2]/ul/li[1]"));
	}
	
	public void initializePresentationIcon(){
		presentationFirstIcon =findElement(By.xpath("/html/body/div/div[3]/div[2]/div[3]/div/div/div[2]/div/div[2]/div/div[2]/div[1]/div[2]/div/div[2]/div/div/div/span/i[1]"));
		presentationSecIcon =findElement(By.xpath("/html/body/div/div[3]/div[2]/div[3]/div/div/div[2]/div/div[2]/div/div[2]/div[1]/div[2]/div/div[2]/div/div/div/span/i[2]"));
	}
	
	public void initializeProductCancel(){
		presentationFirstIcon =findElement(By.xpath("/html/body/div/div[3]/div[2]/div[3]/div/div/div[2]/div/div[2]/div/div[1]/div/div/span/i[1]/span"));
		
	}

}
