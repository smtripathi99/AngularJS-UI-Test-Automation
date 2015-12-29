package com.ig.automation.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ig.automation.coreactions.DataActions;


public class CreateDocScreen extends DataActions {
	public WebElement createDoc;
	public String documentType;
	public WebElement title;
	public WebElement country;
	public Select language;
	public WebElement productName;
	public WebElement enterProductName;
	public WebElement tickBox;
	public WebElement productDoneBtn;
	public WebElement proprietaryName;
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
	public WebElement outerLabelingText;
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
	public WebElement docLink;
	public WebElement optionalArrow;

	public void inilializeObjectsDocType() {
	//	createDoc = findElement(By.xpath("/html/body/div/div[2]/div/accordion/div/div[6]/div[2]/div/accordion/div/div[1]/div[1]/h4/a/label/span"));
		// .className("createDoc"));
		annexType = findElement(By.xpath("//*[contains(@class,'gcDocumentType_condition')]/li[1]"));

		packageLeaflet = findElement(By.xpath("//*[contains(@class,'gcDocumentType_condition')]/li[2]"));
		supportingDocument = findElement(By.xpath("//*[contains(@class,'gcDocumentType_condition')]/li[3]"));
		component = findElement(By.xpath("//*[contains(@class,'gcDocumentType_condition')]/li[4]"));
		blisterLabelingText = findElement(By.xpath("//*[contains(@class,'gcDocumentType_condition')]/li[5]"));
		outerLabelingText = findElement(By.xpath("//*[contains(@class,'gcDocumentType_condition')]/li[6]"));
		uspi = findElement(By.xpath("//*[contains(@class,'gcDocumentType_condition')]/li[7]"));
		sopc = findElement(By.xpath("//*[contains(@class,'gcDocumentType_condition')]/li[8]"));
		deviceSubmission = findElement(By.xpath("//*[contains(@class,'gcDocumentType_condition')]/li[9]"));
		clEU = findElement(By.xpath("//*[contains(@class,'gcDocumentType_condition')]/li[11]"));
		pdp = findElement(By.xpath("//*[contains(@class,'gcDocumentType_condition')]/li[10]"));
		coreDataSheet = findElement(By.xpath("//*[contains(@class,'gcDocumentType_condition')]/li[12]"));
		immidiateLabelingText = findElement(By.xpath("//*[contains(@class,'gcDocumentType_condition')]/li[13]"));

		/*
		 * createdDoc = findElement(By .xpath("/html/body/div/div[4]/div[2]/div[3]/h1"));
		 */
		selectedDocType = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div/div[1]/h1"));

		// cancelBtn = findElement(By.className("QA_testing_Cancel_Document"));
	}
	
	public void inilializeObjectsDocType(String userrole) {
		//createDoc = findElement(By.xpath("/html/body/div/div[2]/div/accordion/div/div[6]/div[2]/div/accordion/div/div[1]/div[1]/h4/a/label/span"));
		// .className("createDoc"));
		annexType = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div/div[2]/div/div/div/ul/li[1]"));

		packageLeaflet = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div/div[2]/div/div/div/ul/li[2]"));
		supportingDocument = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div/div[2]/div/div/div/ul/li[3]"));
		component = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div/div[2]/div/div/div/ul/li[4]"));
		blisterLabelingText = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div/div[2]/div/div/div/ul/li[5]"));
		outerLabelingText = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div/div[2]/div/div/div/ul/li[6]"));
		if(!userrole.equals("role_eu_labeling_author")){
			uspi = findElement(By.xpath("//*[contains(@class,'gcDocumentType')]/li[contains(text(),'US')]"));
			deviceSubmission = findElement(By.xpath("//*[contains(@class,'gcDocumentType')]/li[contains(text(),'Device')]"));
			pdp = findElement(By.xpath("//*[contains(@class,'gcDocumentType')]/li[contains(text(),'Principal')]"));
			coreDataSheet = findElement(By.xpath("//*[contains(@class,'gcDocumentType')]/li[contains(text(),'Core')]"));
		}
		sopc = findElement(By.xpath("//*[contains(@class,'gcDocumentType')]/li[contains(text(),'Summary')]"));		
		clEU = findElement(By.xpath("//*[contains(@class,'gcDocumentType')]/li[contains(text(),'Consolidated')]"));	
		immidiateLabelingText = findElement(By.xpath("//*[contains(@class,'gcDocumentType')]/li[contains(text(),'Immediate')]"));
		/*
		 * createdDoc = findElement(By .xpath("/html/body/div/div[4]/div[2]/div[3]/h1"));
		 */
		selectedDocType = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div/div[1]/h1"));
		// cancelBtn = findElement(By.className("QA_testing_Cancel_Document"));
	}

	public void inilializObjectsProperty(String docType) {
		documentType = docType;
		docProperty = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div[2]/div"));
		if (!docType.equals("Consolidated Label (EU)") || (!docType.equals("Principal Display Panel"))) {
			title = findElement(By
			// .xpath("/html/body/div/div[4]/div[2]/div[3]/div[2]/div[1]/div/div/accordion/div/div/div[1]/div[2]/div/div[1]/div/div/textarea"));
					.className("QA_testing_title"));
		}
		country = findElement(By.xpath("//*[contains(@class,'QA_testing_countryies')]/div/div/input"));

		language = new Select(findElement(By.className("QA_testing_language")));
		// .xpath("/html/body/div/div[4]/div[2]/div[3]/div[2]/div[1]/div/div/accordion/div/div/div[1]/div[2]/div/div[2]/div/div/select")));

		if (!docType.equals("Consolidated Label (EU)") || !docType.equals("Package Leaflet") || !docType.equals("Supporting Document") || docType.equals("Summary of Product Characteristics")
				|| docType.equals("Device Submission") || docType.equals("Immediate Labeling Text") | !docType.equals("Principal Display Panel")) {

			proprietaryName = findElement(By.xpath("//*[contains(@class,'QA_testing_proprietary_names')]/div/div/input"));

		}

		if (docType.equals("US Package Insert") || docType.equals("Principal Display Panel") || docType.equals("Core Data Sheet")) {
			genericName = findElement(By.xpath("//*[contains(@class,'QA_testing_generic_names')]/div/div/input"));

		}
		if (docType.equals("US Package Insert") || docType.equals("Device Submission")) {

			code = new Select(findElement(By.className("QA_testing_code")));
			// .xpath("/html/body/div/div[4]/div[2]/div[3]/div[2]/div[1]/div/div/accordion/div/div/div[1]/div[2]/div/div[5]/div/div/select")));

		}
		createBtn = findElement(By.className("QA_testing_Create_Document"));

		if (docType.equals("Consolidated Label (EU)") || docType.equals("Annex II") || docType.equals("Package Leaflet") || docType.equals("Blister Labeling Text") || docType.equals("Outer Labeling Text")
				|| docType.equals("Summary of Product Characteristics") || docType.equals("Immediate Labeling Text")) {
			productName = findElement(By.className("QA_testing_product_names"));
		}

		cancelBtn = findElement(By.className("QA_testing_Cancel_Document"));
	}

	public void initializeProductName() {

		// selectProduct = findElement(By.xpath("/html/body/div/div[4]/div[2]/div[3]/div[2]/div[1]/div/div/accordion/div/div/div[1]/div[2]/div/div[4]/div/div/div[2]/div/h1[1]"));
		enterProductName = findElement(By.xpath("//*[contains(@class,'QA_testing_generic_name')]/div/div/input"));
		// .xpath("/html/body/div/div[4]/div[2]/div[3]/div[2]/div[1]/div/div/accordion/div/div/div[1]/div[2]/div/div[4]/div/div/div[2]/div/div[2]/div/div[1]/div/tags-input/div/div/input"));
				
		// product =
		// findElement(By.xpath("/html/body/div/div[4]/div[2]/div[3]/div[2]/div[1]/div/div/accordion/div/div/div[1]/div[2]/div/div[4]/div/div/div[2]/div/div[2]/div/div[2]/div/div/span/span"));
		productDoneBtn = findElement(By
		//		.xpath("/html/body/div/div[3]/div[2]/div[2]/div/div/div[1]/div/div[2]/div/accordion/div/div/div[1]/div[2]/div/div[4]/div/div/div[2]/div/h1/button[2]"));
				.className("QA_Testing_Panel_Btn_done"));
	}

	public void initializeTickBox() {
		tickBox = findElement(By.className("QA_testing_Product_name_values_0"));
	}

	public void initializeOptionalProperty() {
		optionalArrow = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[2]/div/div/div[1]/div/div[2]/div/accordion/div/div/div[2]/div[1]/h4/a/span[1]"));
		legalStatus = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[2]/div/div/div[1]/div/div[2]/div/accordion/div/div/div[2]/div[2]/div/div[1]/div/div/div/tags-input/div/div/input"));
		contents = findElement(By.xpath("/html/body/div/div[4]/div[2]/div[3]/div[2]/div[1]/div/div/accordion/div/div/div[2]/div[2]/div/div[2]/div/input"));
		authors = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[2]/div/div/div[1]/div/div[2]/div/accordion/div/div/div[2]/div[2]/div/div[2]/div/div/div/tags-input/div/div/input"));
		notificationRecipients = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[2]/div/div/div[1]/div/div[2]/div/accordion/div/div/div[2]/div[2]/div/div[3]/div/div/div/tags-input/div/div/input"));
		additionalDescription = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[2]/div/div/div[1]/div/div[2]/div/accordion/div/div/div[2]/div[2]/div/div[4]/div/div/input"));
		comments = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[2]/div/div/div[1]/div/div[2]/div/accordion/div/div/div[2]/div[2]/div/div[5]/div/div/textarea"));
		resonForRevision = new Select(findElement(By.xpath("/html/body/div/div[3]/div[2]/div[2]/div/div/div[1]/div/div[2]/div/accordion/div/div/div[2]/div[2]/div/div[6]/div/div/select")));
															
		submissionType = new Select(findElement(By.xpath("/html/body/div/div[3]/div[2]/div[2]/div/div/div[1]/div/div[2]/div/accordion/div/div/div[2]/div[2]/div/div[10]/div/div/select")));
		registrationProcedure = new Select(findElement (By.xpath("/html/body/div/div[3]/div[2]/div[2]/div/div/div[1]/div/div[2]/div/accordion/div/div/div[2]/div[2]/div/div[9]/div/div/select")));

	}

	public void initializeSelectTemplate() {
		/*
		 * selectedProductName = findElement(By
		 * .xpath("/html/body/div/div[4]/div[2]/div[3]/div[2]/div[1]/div/div/accordion/div/div/div[1]/div[2]/div/div[4]/div/div/div/div/div/ul/li[4]"));
		 */

		selectTemplate = findElement(By.className("QA_testing_Select_Template"));

		// System.out.println(searchTemplate.getText());
	}

	public void initializeTemplate() {
		selectATemplate = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[2]/div/div/div[3]/div/div[2]"));
		// pickTemplate = findElement(By.className("QA_testing_Select_Template_0"));
	//	pickTemplate = findElement(By.cssSelector("div.Pd_lr1[value=Countries:]"));
		pickTemplate = findElement(By.xpath("//*[contains(@class,'col0')]//*[contains(@class,'mr_t7')]"));
		
		//									 /html/body/div/div[3]/div[2]/div[2]/div/div/div[3]/div/div[4]/div/div[1]/div/div[2]
		// if (!documentType.equals("US Package Insert")) {

		// template = findElement(By
		// .xpath("/html/body/div/div[4]/div[2]/div[3]/div[3]/div[1]/div[2]/div/div/div[2]/h1"));
		// } else {
		// templateuspi = findElement(By
		// .xpath("/html/body/div/div[4]/div[2]/div[3]/div[3]/div[1]/div[2]/div/div[1]/div[2]/h1"));
		// }

		templateDoneBtn = findElement(By
		.className("QA_Testing_Panel_Btn_doneTemplate"));
		//		.xpath("/html/body/div/div[3]/div[2]/div[2]/div/div/div[3]/div/h1/button[2]"));
	}					

	public void initializeSelectedTemplate() {
		selectedTemplate = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[2]"));
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
		// message = driver.findElement(By.id("toast-container"));
		message = waitForElementToAppear(driver, "toast-container");
		docLink = findElement(By.xpath("//*[contains(@id,'toast-container')]/div/div[2]/a[2]/b"));

	}

}
