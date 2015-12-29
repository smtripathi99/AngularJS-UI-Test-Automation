package com.ig.automation.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ig.automation.coreactions.DataActions;


public class CreateRMSScreen extends DataActions {
	public WebElement createDoc;
	public String documentType;
	public WebElement title;
	public WebElement country;
	public Select language;
	public Select addDoclanguage;
	public WebElement productName;
	public WebElement enterProductName;
	public WebElement tickBox;
	public WebElement productDoneBtn;
	public Select proprietaryName;
	public WebElement selectAddDocTemplate;
	public WebElement selectTemplate;
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
	public WebElement createRMSBtn;
	public WebElement createRMSScreen;
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
	public WebElement cRMSBtnIcon;
	public WebElement cancelBtnIcon;
	public WebElement productNames;
	public WebElement smpcColor;
	public WebElement smpcAfterCreateDocColor;
	public WebElement annexColor;
	public WebElement outerColor;
	public WebElement plColor;
	public WebElement docDefColor;
	public WebElement immidiateColor;
	public WebElement blisterColor;
	public WebElement cRMSColor;
	public WebElement cancelColor;
	public WebElement smpcHover;
	public WebElement countryDocProp;
	public Select languageDocProp;
	public WebElement selectProductName;
	public WebElement proprietaryNameDocProp;
	public WebElement createDocBtn;
	public WebElement selectDocType;
	public WebElement iconGenericName;
	public WebElement iconLanguage;
	public WebElement iconCountries;
	public WebElement iconPencil;
	public WebElement iconRemove;
	public WebElement docTablet;
	public WebElement docDefText;
	public WebElement docdefGenericName;
	public WebElement selectDocDef;
	public WebElement anHover;
	public WebElement outHover;
	public WebElement bliHover;
	public WebElement immHover;
	public WebElement plHover;
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
	public WebElement linkDoneBtn;
	public WebElement SearchTabforLink;
	public WebElement linkBasicSearch;
	public WebElement linkBasicSearchShow;
	public WebElement linkDocID;
	public WebElement searchBtnLink;
	public WebElement selectSearchDocTypeforLink;
	public WebElement docdefForm;
	public WebElement docdefPresentation;
	public WebElement docdefPresentationText;
	public WebElement docdefAlkaline;
	public WebElement docdefAlkalineText;
	public WebElement docdefFormSyrup;
	public WebElement docdefFormSyrupText;
	public WebElement messageLink;
	public WebElement searchIcon;
	public WebElement searchTextField;
	public WebElement piDoc;
	public WebElement initializeLinkDocType;
	public Select itemsPerPage;
	public WebElement linkDocType;
	public WebElement initiaizeLinkBasicSearch;
	public WebElement paginatorResult;
	public WebElement dashboard;
	public WebElement docdefStrength;
	public WebElement docdefStrengthText;
	public WebElement docdefFormText;
	public WebElement unlinkIcon;
	public WebElement actions;
	public WebElement euSubmission;
	public WebElement createRMSlink;
	public WebElement rmsScreentText;
	public WebElement rfaShow;
	public WebElement optionalShow;
	
	public void initializeActions(){
		actions = findElement(By.className("actions"));
	}
	public void initializeEUSubmission(){
		euSubmission = findElement(By.
				xpath("//*[contains(text(),'EU Submissions ')]"));
			       
	}
	public void initializeCreateRMSlink(){
		createRMSlink = findElement(By.xpath("//*[contains(@class,'SubNav')]//*[contains(text(),'Create RMS')]"));
	}
	public void initializeRMSScreentext(){
		rmsScreentText = findElement(By.className("darkgrey"));
	}
	public void inilializeObjectsRMS() {
		
		title = findElement(By.className("QA_testing_title"));
		country = findElement(By.
				xpath("//*[contains(@class,'QA_testing_countryies')]/div/div/*[contains(@class,'input')]"));
		language = new Select(findElement(By.className("QA_testing_language")));
		productName = findElement(By.className("QA_testing_product_names"));
		proprietaryName = new Select(findElement(By.className("QA_testing_proprietary_name")));
		//rfa = findElement(By.xpath("//*[contains(@class,'panel-heading')]/h4/a//*[contains(text(),'Required')]"));
		//rfaShow = findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div/div[1]/div/div[2]/div/accordion/div/div/div[2]/div[1]/h4/a/span[2]"));
		optional = findElement(By.xpath("//*[contains(@class,'panel-heading')]/h4/a//*[contains(text(),'Optional')]"));
		optionalShow = findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div/div[1]/div/div[2]/div/accordion/div/div/div[2]/div[1]/h4/a/span[2]"));
		cancelBtn = findElement(By.className("QA_testing_Cancel-Centralised-Procedure"));
	}
	public void initializeShowButton(){
		createRMSBtn = findElement(By.className("QA_testing_Centralised-Procedure"));
		addDocBtn = findElement(By.className("QA_testing_Add-Document"));
	}
	
    public void initializeScreen(){
    	createRMSScreen = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[2]/div/div[2]/h1"));
    }
	
    public void initializeAddDocScreen() {
		addDocScreen = findElement(By.className("createProcedurePannel"));
		sopcIcon = findElement(By.className("gcAddDocument__bg_gtc_xm_prescribing_info_eu"));
		AnnexIIicon = findElement(By.className("gcAddDocument__bg_gtc_xm_annex_ll"));
		outerIcon = findElement(By.className("gcAddDocument__bg_gtc_xm_pkg_text_outer"));
		blisterIcon = findElement(By.className("gcAddDocument__bg_gtc_xm_pkg_text_blister"));
		immidiateIcon = findElement(By.className("gcAddDocument__bg_gtc_xm_pkg_text_immediate"));
		pLIcon = findElement(By.className("gcAddDocument__bg_gtc_xm_patient_info_eu"));
		docDefIcon = findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[1]/div/div[6]/button/h1"));
		cRMSBtnIcon = findElement(By.xpath("//*[contains(@class,'gcAddDocument__button')]/button[1]"));
		cancelBtnIcon = findElement(By.xpath("//*[contains(@class,'gcAddDocument__button')]/button[2]"));
	}

    public void initializeRMSProperties() {
		countryProp = findElement(By.xpath("//*[contains(@class,'pull-left')]/div/span[1]"));
		proprName = findElement(By.xpath("//*[contains(@class,'pull-left')]/div/span[3]"));
		productNames = findElement(By.xpath("//*[contains(@class,'pull-left')]/div/span[5]"));
		
	}

	public void initializeColor() {
		smpcColor = findElement(By
				.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[1]"));
		smpcAfterCreateDocColor = findElement(By
				.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[1]/button"));
		outerColor = findElement(By
				.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[2]"));	
		plColor = findElement(By
				.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[5]"));
		docDefColor = findElement(By
				.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[6]"));
		immidiateColor = findElement(By
				.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[4]"));
		blisterColor = findElement(By
				.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[3]"));
		cRMSColor = findElement(By
				.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[7]/button[1]"));
		cancelColor = findElement(By
				.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[7]/button[2]"));

	}
	
	public void initializeSMPCHover() {
		smpcHover = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[1]"));
	}
	public void initializeOUTHover() {
		outHover = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[2]"));
		
	}
	
	public void initializeBLIHover() {
		bliHover = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[3]"));
	}

	public void initializeIMMHover() {
		immHover = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[4]"));
	}

	public void initializePLHover() {
		plHover = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[5]"));
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
	public void initializeCreateAfterHoverOUT(){
		createAfterHoverOUT = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[2]/div/span[1]"));
	}
	public void initializeLinkAfterHoverOUT(){
		linkAfterHoverOUT = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[2]/div/span[2]"));
		
	}
	public void initializeCreateAfterHoverBLI(){
		createAfterHoverBLI = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[3]/div/span[1]"));
	}
	public void initializeLinkAfterHoverBLI(){
		linkAfterHoverBLI = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[3]/div/span[2]"));
	}
	public void initializeCreateAfterHoverIMM(){
		createAfterHoverIMM = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[4]/div/span[1]"));
	}
	public void initializeLinkAfterHoverIMM(){
		linkAfterHoverIMM = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[4]/div/span[2]"));
	}
	public void initializeCreateAfterHoverPL(){
		createAfterHoverPL = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[5]/div/span[1]"));
	}
	public void initializeLinkAfterHoverPL(){
		linkAfterHoverPL = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[5]/div/span[2]"));
	}

	
	public void initializeUnlinkIcon() {
		unlinkIcon = findElement(By.className("gcAddDocument__panel_icon_remove"));
	}

	
	public void initializeLanguage(){
		language = new Select(findElement(By.className("QA_testing_language")));
	}
	
	public void initializeAddDocLanguage() {
		addDoclanguage = new Select(findElement(By.className("QA_testing_language")));
	}
	
	public void initializeDocDefFormText() {
		docdefFormText = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[3]/div/div/div[2]/div/div[1]/div/div[2]/div/div[1]/span/div/div/div[2]/ul/li"));
	}
	
	public void initializeDocProp(){
		//title = findElement(By.className("QA_testing_title"));
		//countryDocProp = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[3]/div/div[1]/div/div[2]/div/accordion/div/div/div[1]/div[2]/div/div[2]/div/div/div/tags-input/div/div/input"));
		//languageDocProp = new Select(findElement(By.className("QA_testing_language")));
		selectProductName = findElement(By.className("QA_testing_Select_product"));
		}
			
		public void initializeProductName() {

			enterProductName = findElement(By.xpath("//*[contains(@class,'QA_testing_generic_name')]/div/div/input"));
			productDoneBtn = findElement(By.className("QA_Testing_Panel_Btn_done"));

		}

	public void initializeTickBox() {
		tickBox = findElement(By
				.className("QA_testing_Product_name_values_0"));
	}
	
	public void initializeSelectAddDocTemplate() {
		/*
		 * selectedProductName = findElement(By
		 * .xpath("/html/body/div/div[4]/div[2]/div[3]/div[2]/div[1]/div/div/accordion/div/div/div[1]/div[2]/div/div[4]/div/div/div/div/div/ul/li[4]"));
		 */

		selectAddDocTemplate = findElement(By.className("QA_testing_Select_Template"));

		// System.out.println(searchTemplate.getText());
	}
	
	public void initializeAddDocTemplate() {
		selectATemplate = findElement(By
		// .xpath("/html/body/div/div[3]/div[2]/div[3]/div/div[5]/div/div[4]/div/div[1]/div"));
				.className("gcTablet__wrap"));

		templateDoneBtn = findElement(By
		 .className("QA_Testing_Panel_Btn_doneTemplate"));
				
	}

	public void initializeproprietary(){
		proprietaryNameDocProp = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[3]/div/div[1]/div/div[2]/div/accordion/div/div/div[1]/div[2]/div/div[5]/div/div/div/tags-input/div/div/input"));
	}
	
	
    public void initializeTemplate(){
    	selectATemplate = findElement(By
				.xpath("/html/body/div/div[3]/div[2]/div[3]/div/div[5]/div/div[4]/div/div[1]/div"));
    	    	
		templateDoneBtn = findElement(By
				//.className("QA_testing_Done_Btn"));
                 .xpath("/html/body/div/div[3]/div[2]/div[3]/div/div[5]/div/h1/button[2]"));
	}
    
    public void initializecreateDocumentBtn(){
    	createDocBtn = findElement(By.className("QA_testing_Create_Document"));
    }
    
    public void initializeLinkSearchBtn() {

		searchBtnLink = findElement(By.className("QA_testing_Search_Document_Btn"));
	}
    
   //***************************
    public void initializeDocIcon(){
    	iconGenericName = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[1]/button/div/div/span[3]"));
        iconLanguage = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[1]/button/div/div/span[2]"));
        iconCountries = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[1]/button/div/div/span[1]"));
        iconPencil = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[1]/div/button[2]"));
        iconRemove = findElement (By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[1]/div/button[1]"));
        
       
    }
    
    
    public void initializeLinkToExisting() {
		SearchTabforLink = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[4]/div/div[4]/div/div/div/ul/li[2]/a"));

	}

    
    public void initializeLinkBtn(){
    	selectDocType = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[4]/div/div[4]/div/div/div/div[1]/div/div/div[1]/div/div[2]"));
    	linkDoneBtn = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[4]/div/h1/button[2]"));
    }
    public void initializedocTablet(){
    	docTablet = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[1]/button/div/div"));
    }
    public void initializeDocDefText(){
    	docDefText = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[3]/div/div/div[1]/h1"));
    }
    public void initializeDocDefGenericName(){
    	docdefGenericName = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[3]/div/div/div[2]/div/div[1]/div/div[1]/span/input"));
    }
    
    public void initializeDocDefForm(){
    	docdefForm = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[3]/div/div/div[2]/div/div[1]/div/div[2]/div/div[1]/span/input"));
    }
    
    public void initializeSelectDocDef(){
    	selectDocDef = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[3]/div/div/div[2]/div/div[1]/div/div[1]/span/div/div/div[2]/ul/li"));
    }
    

    public void initializeMessage(){
		message = driver.findElement(By.id("toast-container"));
	}
    
 
	public void initiaizeLinkBasicSearchShow() {
		linkBasicSearchShow = findElement(By
				.xpath("/html/body/div/div[3]/div[2]/div[4]/div/div[4]/div/div/div/div/div[2]/div/gc-search/div[1]/accordion/div/div[1]/div[1]/h4/a/span[2]"));
	}
    
    
    public void initializeSelectedTemplate(){
    	selectedTemplate = findElement(By
				.xpath("/html/body/div/div[3]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div/div[2]"));
    }  
    
    public void initializeSelectSourceDocumentButton(){
    	if (documentType.equals("Package Leaflet") ||  documentType.equals("US Package Insert") ||
    			documentType.equals("Device Submission") || documentType.equals("Consolidated Label (EU)") ||
    			documentType.equals("Summary of Product Characteristics"))
    	{
    	selectSourceDocBtn = findElement(By.className("QA_testing_Select_Source_Document"));	
    	}                             
    }
    public void initializeSelectASourceDoc(){
    	selectASourceDoc = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[3]/div[3]/div[2]/h1"));
    	myDocsListing = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[3]/div[3]/div[2]/div[2]/div/div/div[2]/ul/li[2]/a"));
    }

   public void initializeSelectSourceDocumentMyDocListing(){
    	
    	selectSourceMyDocListing = findElement(By.xpath("/html/body/div/div[4]/div[2]/div[3]/div[3]/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]"));	
    }
   
   
   public void initializeSearch(){
	   searchTab = findElement(By.xpath("/html/body/div/div[4]/div[2]/div[3]/div[3]/div[2]/div[2]/div/div/div[2]/ul/li[1]/a"));
       basicSearch = findElement(By.xpath("/html/body/div/div[4]/div[2]/div[3]/div[3]/div[2]/div[2]/div/div/div[2]/div/div[1]/div/gc-search/div[1]/accordion/div/div[1]/div[1]/h4/a/span[1]"));
	   basicSearchProperty = findElement(By.xpath("/html/body/div/div[4]/div[2]/div[3]/div[3]/div[2]/div[2]/div/div/div[2]/div/div[1]/div/gc-search/div[1]/accordion/div/div[1]/div[2]/div"));
	   advanceSearch = findElement(By.xpath("/html/body/div/div[4]/div[2]/div[3]/div[3]/div[2]/div[2]/div/div/div[2]/div/div[1]/div/gc-search/div[1]/accordion/div/div[2]/div[1]/h4/a/span[1]"));
       advanceSearchProperty = findElement(By.xpath("/html/body/div/div[4]/div[2]/div[3]/div[3]/div[2]/div[2]/div/div/div[2]/div/div[1]/div/gc-search/div[1]/accordion/div/div[2]/div[2]/div/div/div/div/label"));
	   
	   
   }
   public void initializeDoneBtn(){
	   searchDocBtn = findElement(By.className("QA_testing_Search_Document_Btn"));
	   SourceDoneBtn = findElement(By.xpath("QA_testing_Done_Btn"));
	  
	   
   }
   public void initializeSelectedSourceDoc(){
	   selectedSourceDoc = findElement(By.xpath("/html/body/div/div[4]/div[2]/div[3]/div[2]/div[3]/div/div/div/div[2]"));
   }

   public void initializeSelectSearchDocTypeforLink() {
	   selectSearchDocTypeforLink = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[4]/div/div[4]/div/div/div/div/div[2]/div/div/div[2]/div[1]/div"));
   }
		
   public void initializeLinkDoneBtn() {

		linkDoneBtn = findElement(By.
		// className("QA_testing_Panel_Btn"));
				xpath("/html/body/div/div[3]/div[2]/div[4]/div/h1/button[2]"));
	}
   
   public void initializeDocDefStrength() {
		docdefStrength = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[3]/div/div/div[2]/div/div[1]/div/div[2]/div/div[2]/div/div[1]/span/input"));
	}
   
   public void initializeDocDefStrengthText() {
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
		piDoc = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[4]/div/div/ul/li[7]/a"));
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
   
   public void initializeMessageLink() {
		messageLink = findElement(By.xpath("//*[contains(@id,'toast-container')]/div/div[2]/a[2]/b"));
	
	}
   
	public void initializePaginatorResult() {
		paginatorResult = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[4]/div/div/div/div[7]/div/div[2]/div/div[4]"));
	}
   
   
   public void initializeItemsPerPage() {
		itemsPerPage = new Select(findElement(By.className("QA_testing_")));
	}
   
	public void initializeSelectSourceDocumentMyDocument(){
		myDocument = findElement(By.xpath("/html/body/div/div[4]/div[2]/div[3]/div[3]/div[3]/div[2]/div/div/div[2]/ul/li[2]/a"));
	    selectMyDoc = findElement(By.xpath("/html/body/div/div[4]/div[2]/div[3]/div[3]/div[3]/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/p[2]"));
	    doneBtnMyDoc = findElement(By.xpath("/html/body/div/div[4]/div[2]/div[3]/div[3]/div[3]/div[3]/button"));
	}
	public void initializeMessages(){
		message = driver.findElement(By.id("toast-container"));
	}
	
}
