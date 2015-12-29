package com.ig.automation.screens;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ig.automation.coreactions.DataActions;

public class EditPropertiesScreen extends DataActions {
	public WebElement searchDoc;
	public WebElement basicSearch;
	public Select 	  docIDSearchdropdown;
	public WebElement enterDocIDbox;
	public WebElement searchButton;
	public WebElement filterDocID;
	public WebElement propertiesTab;
	public WebElement edit;
	public WebElement title;
	public WebElement country;
	public Select countryDropDown;
	public Select language;
	public WebElement optional;
	public WebElement properietary;
	public WebElement legalStatus;
	public WebElement author;
	public WebElement notifrecipient;
	public WebElement addDescription;
	public WebElement comments;
	public Select reasonforRevision;
	public WebElement manufactureActive;
	public WebElement manufactureBatch;
	public Select registrationProcedure;
	public Select submissionType;
	public WebElement doneButton;
	public WebElement cancelButton;
	public WebElement existTitle;
	public WebElement existCountry;
	public WebElement existLanguage;
	public WebElement existProprietary;
	public WebElement existOptional;
	public WebElement existlegalStatus;
	public WebElement existauthor;
	public WebElement existnotifrecipient;
	public WebElement existaddDescription;
	public WebElement existcomments;
	public WebElement existreasonforRevision;
	public WebElement existmanufactureActive;
	public WebElement existmanufactureBatch;
	public WebElement existregistrationProcedure;
	public WebElement existsubmissionType;
	public WebElement existGenericName;
	public WebElement existCode;
	public WebElement rfaProperties;
	public WebElement existRFAProperties;
	public WebElement genericName;
	public Select code;
	public Select splFormat;
	public Select splEffective;
	public WebElement splDate;
	public WebElement splReldoc;
	public WebElement existSPLFormat;
	public WebElement existSPLDate;
	public WebElement existSPLReldoc;
	public WebElement editPropertyLabel;
	public WebElement docHeader;
	public WebElement successMessage;
	public WebElement existCRType;
	public WebElement existPriority;
	public WebElement createEstbPanelTitle;
	public WebElement  estbName;
	public WebElement cancelBtn;
	public WebElement optionalProperties;
	public Select contactCountry;
	public WebElement contactPhone;
	public WebElement contactEmail;
	public WebElement contactName;
	public WebElement contactStreet;
	public WebElement contactCity;
	public WebElement contactState;
	public WebElement contactPostal;
	public WebElement createEstbBtn;
	public WebElement message;
	public WebElement confidential;
	public WebElement typeOperation;
	public WebElement selfidOperation;
	public WebElement usAgent;
	public WebElement importer;
	public WebElement dunsno;
	public WebElement regno;
	public WebElement street;
	public WebElement city;
	public WebElement state;
	public WebElement postal;
	public WebElement estbTab;
	public WebElement createEstbLink;
	public WebElement createRegPanelTitle;
	public Select docType;
	public Select registrant;
	public WebElement contactSPL;
	public WebElement createRegBtn;
	public WebElement docLink;
	public Select contactCountryNDC;
	public WebElement splEffectiveDate;
	public WebElement nextArrow;
	public WebElement date;
	public WebElement saveNDC;
	public WebElement contactPostalCodeNDC;
	public Select countryNDC;
	public WebElement splEffectiveDateNDC;
	public WebElement contactTitleNDC;
	public WebElement contactEmailNDC;
	public WebElement contactPhoneNDC;
	public WebElement contactCityNDC;
	public WebElement contactNameNDC;
	public WebElement contactStreetNDC;
	public WebElement contactStateNDC;
	public WebElement saveButtonNDC;
	public Select labelerEdit;
	public WebElement ndcLabelerCode;
	
	public WebElement mandatory;
	private WebElement existProduct;
	public WebElement estName;
	public WebElement saveBtn;
	public WebElement titleLbl;
	public WebElement countryLbl;
	public WebElement languageLbl;
	public WebElement productLbl;
	public WebElement proprietaryLbl;
	public WebElement mandatoryLbl;

	
	public void initializeSearch() {

		searchDoc = findElement(By
				.xpath("/html/body/div[2]/div[1]/div/div[2]/ul[1]/li/i"));
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
	}

	public void initializePropertiesTab() {

		propertiesTab = findElement(By
				.xpath("//*[contains(@class,'nav-tabs')]/li[3]/a"));
		}
	
	public void initializeEdit(String docid) {
		mandatoryLbl=findElement(By.xpath("//*[contains(@class,'panel-title')]/a/span"));
		edit = findElement(By.xpath("//*[contains(@class,'gcDocMenu')][contains(text(),'Edit')]"));
		if (docid.contains("AN")){
			titleLbl=findElement(By.xpath("//*[contains(@class,'panel-body')]/div[1]//span[1]"));
			existTitle=findElement(By.xpath("//*[contains(@class,'panel-body')]/div[1]//span[2]"));
			countryLbl=findElement(By.xpath("//*[contains(@class,'panel-body')]/div[2]//span[1]"));
			existCountry=findElement(By.xpath("//*[contains(@class,'panel-body')]/div[2]//span[2]"));
			languageLbl=findElement(By.xpath("//*[contains(@class,'panel-body')]/div[3]//span[1]"));
			existLanguage=findElement(By.xpath("//*[contains(@class,'panel-body')]/div[3]//span[2]"));
			productLbl=findElement(By.xpath("//*[contains(@class,'panel-body')]/div[4]/div"));
			existProduct=findElement(By.xpath("//*[contains(@class,'productListing')]/li"));
			proprietaryLbl=	existProprietary=findElement(By.xpath("//*[contains(@class,'panel-body')]/div[5]//span[1]"));
			existProprietary=findElement(By.xpath("//*[contains(@class,'panel-body')]/div[5]//span[2]"));
		}
		if (docid.contains("USPI")){
			existTitle=findElement(By.xpath("//*[contains(@class,'panel-body')]/div[2]//span[2]"));
			existCountry=findElement(By.xpath("//*[contains(@class,'panel-body')]/div[1]//span[2]"));
			existGenericName=findElement(By.xpath("//*[contains(@class,'panel-body')]/div[4]//span[2]"));
			existCode=findElement(By.xpath("//*[contains(@class,'panel-body')]/div[6]//span[2]"));
			//existRFAProperties = findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div[1]/div/div/div/div[1]/div/div[17]/div/div/div[3]/div/accordion/div/div/div[2]/div[1]/h4/a/span[1]"));
		}
		if (docid.contains("CR")){
			
			existCRType=findElement(By.xpath("//*[contains(@class,'panel-body')]/div[1]//span[2]"));
			existTitle=findElement(By.xpath("//*[contains(@class,'panel-body')]/div[2]//span[2]"));
			existCountry=findElement(By.xpath("//*[contains(@class,'panel-body')]/div[3]//span[2]"));
			existLanguage=findElement(By.xpath("//*[contains(@class,'panel-body')]/div[4]//span[2]"));
			existPriority=findElement(By.xpath("//*[contains(@class,'panel-body')]/div[5]//span[2]"));
			
		}
		existOptional=findElement(By.xpath("//*[contains(@class,'panel-title')]//*[contains(text(),'Optional')]"));

	}
	
	

	public void initializeEditMandatory(String docid) {
		
		editPropertyLabel = findElement(By
						.xpath("//*[contains(@class,'sidepanel__header')]/h1"));		
		
		docHeader=findElement(By
				.xpath("//*[contains(@class,'sidepanel__header_shadow')]"));
		
		mandatory=findElement(By.xpath("//*[contains(@class,'panel-title')]"));
		title = findElement(By
				.className("QA_testing_Title"));
		
		country = findElement(By
			.xpath("//*[contains(@class,'QA_testing_Country(ies)')]//*[contains(@class,'tag-list')]"));
				
		language = new Select(findElement(By
						.className("QA_testing_Language")));	
		properietary=findElement(By
					.xpath("//*[contains(@class,'QA_testing_Proprietary')]/div/div/input"));
		
		if (docid.contains("USPI")){
			
			genericName=findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div[1]/div/div/div/div[1]/div/div[9]/div/div[2]/div/accordion/div/div/div[1]/div[2]/div/div[4]/div/div/div/tags-input/div/div/input"));
			code=new Select (findElement(By
					.className("QA_testing_Code")));
			splFormat=new Select (findElement(By
					.className("QA_testing_SPL")));
			splEffective=new Select(findElement(By
					.xpath("/html/body/div[2]/div[3]/div[2]/div[1]/div/div/div/div[1]/div/div[9]/div/div[2]/div/accordion/div/div/div[2]/div[2]/div/div[2]/div/div/div/div/select")));
			splDate=findElement(By
					.xpath("/html/body/div[2]/div[3]/div[2]/div[1]/div/div/div/div[1]/div/div[9]/div/div[2]/div/accordion/div/div/div[2]/div[2]/div/div[2]/div/div/div/div/input"));
			}else if (docid.contains("NDC")){
				contactCountryNDC = new Select(findElement(By.className("Country")));
				splEffectiveDate=findElement(By.xpath("//*[contains(@class,'Date')]"));
				saveNDC=findElement(By.className("QA_Testing_Panel_Btn_save"));
				labelerEdit=new Select (findElement(By.className("QA_testing_Labeler")));
			}
		
		optional=findElement(By
				.xpath("//*[contains(@class,'panel-title')]/a/span[contains(text(),'Optional')]"));
				
	}
	
	public void initializeEditOptional(String docid) {
		
		if(docid.contains("AN")){
			legalStatus = findElement(By
					.xpath("/html/body/div[2]/div[3]/div[2]/div[2]/div[2]/div[9]/div/div[2]/div/accordion/div/div/div[2]/div[2]/div/div[1]/div/div/div/tags-input/div/div/input"));
				
			author = findElement(By
					.xpath("/html/body/div[2]/div[3]/div[2]/div[2]/div[2]/div[9]/div/div[2]/div/accordion/div/div/div[2]/div[2]/div/div[2]/div/div/div/tags-input/div/div/input"));
			
			notifrecipient = findElement(By
					.xpath("/html/body/div[2]/div[3]/div[2]/div[2]/div[2]/div[9]/div/div[2]/div/accordion/div/div/div[2]/div[2]/div/div[3]/div/div/div/tags-input/div/div/input"));
			
			comments = findElement(By
					.className("QA_testing_Comments"));
			
			manufactureActive = findElement(By
					.xpath("/html/body/div[2]/div[3]/div[2]/div[2]/div[2]/div[9]/div/div[2]/div/accordion/div/div/div[2]/div[2]/div/div[7]/div/div/div/tags-input/div/div/input"));
			
			manufactureBatch = findElement(By
					.xpath("/html/body/div[2]/div[3]/div[2]/div[2]/div[2]/div[9]/div/div[2]/div/accordion/div/div/div[2]/div[2]/div/div[8]/div/div/div/tags-input/div/div/input"));
			
			registrationProcedure = new Select(findElement(By
							.className("QA_testing_Registration")));
			
			submissionType = new Select(findElement(By
					.className("QA_testing_Submission")));
		}
		
		if(docid.contains("AN")||docid.contains("USPI")){
			addDescription = findElement(By
				.className("QA_testing_Additional"));
			reasonforRevision = new Select(findElement(By
				.className("QA_testing_Reason")));
		}
		
		if(docid.contains("USPI")){
			splReldoc = findElement(By
					.xpath("/html/body/div[2]/div[3]/div[2]/div[1]/div/div/div/div[1]/div/div[9]/div/div[2]/div/accordion/div/div/div[3]/div[2]/div/div[3]/div/div/div/tags-input/div/div"));
			
		}
		
		if(docid.contains("NDC")){
			contactPostalCodeNDC=findElement(By.cssSelector(".QA_testing_Contact.Postal.Code"));
			countryNDC=new Select(findElement(By.cssSelector(".QA_testing_Contact.Country")));
			contactPhoneNDC=findElement(By.cssSelector(".QA_testing_Contact.Phone"));
			contactEmailNDC=findElement(By.cssSelector(".QA_testing_Contact.Email"));
			contactTitleNDC=findElement(By.cssSelector(".QA_testing_Title"));
			splEffectiveDateNDC=findElement(By.cssSelector(".QA_testing_SPL.Effective.Date"));
			contactNameNDC=findElement(By.cssSelector(".QA_testing_Contact.Name"));
			contactStreetNDC=findElement(By.cssSelector(".QA_testing_Contact.Address"));
			contactCityNDC=findElement(By.cssSelector(".QA_testing_Contact.City"));
			contactStateNDC=findElement(By.cssSelector(".QA_testing_Contact.State"));
			saveButtonNDC=findElement(By.className("QA_Testing_Panel_Btn_save"));
			ndcLabelerCode=findElement(By.cssSelector("QA_testing_NDC.Labeler.Code"));
		}
		
		doneButton = findElement(By
				//.className("QA_testing_Close_Btn"));
				.xpath("/html/body/div[2]/div[3]/div[2]/div[2]/div[2]/div[9]/div/h1[2]/button[2]"));
		
		cancelButton = findElement(By
				//.className("QA_testing_Done_Btn"));
				  .xpath("/html/body/div[2]/div[3]/div[2]/div[2]/div[2]/div[9]/div/h1[2]/button[1]"));	
	}
	
	public void initializeExistingOptional(String docid) {
		
		if(docid.contains("AN")){
			
			successMessage=findElement(By.id("toast-container"));
					
			existlegalStatus = findElement(By
					.xpath("/html/body/div[2]/div[3]/div[2]/div[2]/div[2]/div[17]/div/div/div[3]/div/accordion/div/div/div[2]/div[2]/div/div[1]/div/span[2]"));
			
		
			existauthor = findElement(By
					.xpath("/html/body/div[2]/div[3]/div[2]/div[2]/div[2]/div[9]/div/div[2]/div/accordion/div/div/div[2]/div[2]/div/div[2]/div/div/div/tags-input/div/div/input"));
			
			existnotifrecipient = findElement(By
					.xpath("/html/body/div[2]/div[3]/div[2]/div[2]/div[2]/div[17]/div/div/div[3]/div/accordion/div/div/div[2]/div[2]/div/div[3]/div/span[2]/text()"));
			
			
			
			existcomments = findElement(By
					.xpath("/html/body/div[2]/div[3]/div[2]/div[2]/div[2]/div[17]/div/div/div[3]/div/accordion/div/div/div[2]/div[2]/div/div[5]/div/span[2]"));
			
			
			
			existmanufactureActive = findElement(By
					.xpath("/html/body/div[2]/div[3]/div[2]/div[2]/div[2]/div[9]/div/div[2]/div/accordion/div/div/div[2]/div[2]/div/div[7]/div/div/div/tags-input/div/div/input"));
			
	
			existmanufactureBatch = findElement(By
					.xpath("/html/body/div[2]/div[3]/div[2]/div[2]/div[2]/div[9]/div/div[2]/div/accordion/div/div/div[2]/div[2]/div/div[8]/div/div/div/tags-input/div/div/input"));
			
			existregistrationProcedure = findElement(By
							.xpath("/html/body/div[2]/div[3]/div[2]/div[2]/div[2]/div[17]/div/div/div[3]/div/accordion/div/div/div[2]/div[2]/div/div[9]/div/span[2]"));
			
			existsubmissionType = findElement(By
					.xpath("/html/body/div[2]/div[3]/div[2]/div[2]/div[2]/div[17]/div/div/div[3]/div/accordion/div/div/div[2]/div[2]/div/div[10]/div/span[2]"));
		}
	
		if(docid.contains("AN")||docid.contains("USPI")){
			existaddDescription = findElement(By
					.xpath("/html/body/div[2]/div[3]/div[2]/div[2]/div[2]/div[17]/div/div/div[3]/div/accordion/div/div/div[2]/div[2]/div/div[4]/div/span[2]"));	
	
			existreasonforRevision = findElement(By
					.xpath("/html/body/div[2]/div[3]/div[2]/div[2]/div[2]/div[17]/div/div/div[3]/div/accordion/div/div/div[2]/div[2]/div/div[6]/div/span[2]"));
		}
		
		if(docid.contains("USPI")){
			existSPLFormat=findElement(By
					.xpath("/html/body/div[2]/div[3]/div[2]/div[1]/div/div/div/div[1]/div/div[17]/div/div/div[3]/div/accordion/div/div/div[2]/div[2]/div/div[1]/div/span[2]"));
			
			existSPLDate=findElement(By
					.xpath("/html/body/div[2]/div[3]/div[2]/div[1]/div/div/div/div[1]/div/div[17]/div/div/div[3]/div/accordion/div/div/div[2]/div[2]/div/div[2]/div/span[2]"));
			
			existSPLReldoc=findElement(By
					.xpath("/html/body/div[2]/div[3]/div[2]/div[1]/div/div/div/div[1]/div/div[17]/div/div/div[3]/div/accordion/div/div/div[3]/div[2]/div/div[3]/div/comment()"));
			}
	}
	public void initializeEstbTab() {

		estbTab = findElement(By
				.xpath("/html/body/div/div[3]/div[2]/div/div[5]/div/div/ul/li[8]/a"));
	}
	
	public void initializeCreateEstbLink() {

		createEstbLink = findElement(By
				.xpath("/html/body/div/div[3]/div[2]/div/div[5]/div/div/div/div[8]/div/button[1]"));
	}

	
			
			
	public void initializeMandatoryProperties() {
		createEstbPanelTitle=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div/div/div[2]/h1"));
		estbName = findElement(By.xpath("//*[contains(@class,'QA_testing_Establishment Name')]"));
		cancelBtn=findElement(By.className("QA_Testing_Panel_Btn_cancel"));
		optionalProperties=findElement(By.xpath("//*[contains(@class,'panel-title')]//*[contains(text(),'Optional')]"));
	}	
	
	
	public void initializeOptionalProperties() {
			confidential=findElement(By.className("QA_testing_Confidential"));
		title=findElement(By.xpath("//*[contains(@class,'QA_testing_Title')]"));
		contactCountry=new Select(findElement(By.xpath("//*[contains(@class,'QA_testing_Contact Country')]")));
		contactPhone=findElement(By.xpath("//*[contains(@class,'QA_testing_Contact Phone')]"));
		contactEmail=findElement(By.xpath("//*[contains(@class,'QA_testing_Contact Email')]"));
		contactName=findElement(By.xpath("//*[contains(@class,'QA_testing_Contact Name')]"));
		contactStreet=findElement(By.xpath("//*[contains(@class,'QA_testing_Contact Street Address')]"));
		contactCity=findElement(By.xpath("//*[contains(@class,'QA_testing_Contact City')]"));
		contactState=findElement(By.xpath("//*[contains(@class,'QA_testing_Contact State')]"));
		contactPostal=findElement(By.xpath("//*[contains(@class,'QA_testing_Contact Postal Code')]"));
		typeOperation=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div/div/div[4]/div/div/div/div[2]/div/div/accordion/div/div/div[2]/div[2]/div/div[10]/div/div/div/div/div/div/div/div/tags-input/div/div/input"));
		selfidOperation=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div/div/div[4]/div/div/div/div[2]/div/div/accordion/div/div/div[2]/div[2]/div/div[11]/div/div/div/div/div/div/div/div/tags-input/div/div/input"));
		usAgent=findElement(By.xpath("//*[contains(@class,'QA_testing_US Agent')]"));
		//importer=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div[1]/div/div/div[4]/div/div/div/div[2]/div/div/accordion/div/div/div[2]/div[2]/div/div[13]/div/div/div/tags-input/div/div/input"));
		dunsno=findElement(By.xpath("//*[contains(@class,'QA_testing_Duns Number')]"));
		regno=findElement(By.xpath("//*[contains(@class,'QA_testing_Registration Number/FEI')]"));
		street=findElement(By.xpath("//*[contains(@class,'QA_testing_Street Address')]"));
		city=findElement(By.xpath("//*[contains(@class,'QA_testing_ City')]"));
		state=findElement(By.xpath("//*[contains(@class,'QA_testing_State')]"));
		postal=findElement(By.xpath("//*[contains(@class,'QA_testing_Postal Code')]"));
		countryDropDown=new Select(findElement(By.className("QA_testing_Country")));
		createEstbBtn=findElement(By.className("QA_Testing_Panel_Btn_createRequest"));	
		saveBtn=findElement(By.className("QA_Testing_Panel_Btn_save"));	
	}
	public void initializeMessages(){
		message = driver.findElement(By.id("toast-container"));

	}
	
	
	public void initializeMandatoryPropertiesReg() {
		createRegPanelTitle=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[2]/h1"));
		docType = new Select(findElement(By.className("QA_testing_Type")));
		cancelBtn=findElement(By.className("QA_testing_Panel_Btn"));
				
		rfaProperties=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[4]/div/div/accordion/div/div/div[2]/div[1]/h4/a/span[1]"));
		
		optionalProperties=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[4]/div/div/accordion/div/div/div[3]/div[1]/h4/a/span[1]"));
	}
	
	public void initializeRFAProperties() {
		registrant= new Select(findElement(By.className("QA_testing_Registrant")));

	}
	
	public void initializeOptionalPropertiesReg() {
		title=findElement(By.className("QA_testing_Title"));
		contactCountry=new Select(findElement(By.className("QA_testing_Contact")));
		contactPhone=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[4]/div/div/accordion/div/div/div[3]/div[2]/div/div[3]/div/div/input"));
		contactEmail=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[4]/div/div/accordion/div/div/div[3]/div[2]/div/div[4]/div/div/input"));
		contactSPL=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[4]/div/div/accordion/div/div/div[3]/div[2]/div/div[5]/div/div/div/div/input"));
		contactName=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[4]/div/div/accordion/div/div/div[3]/div[2]/div/div[6]/div/div/input"));
		contactStreet=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[4]/div/div/accordion/div/div/div[3]/div[2]/div/div[7]/div/div/input"));
		contactCity=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[4]/div/div/accordion/div/div/div[3]/div[2]/div/div[8]/div/div/input"));
		contactState=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[4]/div/div/accordion/div/div/div[3]/div[2]/div/div[9]/div/div/input"));
		contactPostal=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[4]/div/div/accordion/div/div/div[3]/div[2]/div/div[10]/div/div/input"));
		createRegBtn=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/h1/button[2]"));	
	}
	
	public void initializeMessagesReg(){
		message = waitForElementToAppear(driver, "toast-container");
		docLink = findElement(By.xpath("//*[contains(@id,'toast-container')]/div/div[2]/a[2]/b"));
	}	
	
	public void initializeCalendarNDC(){
		nextArrow = findElement(By.cssSelector(".glyphicon.glyphicon-chevron-right"));
		String dateselect = "19" ;
		date =findElement(By.xpath("//*[contains(@class,'calender_frmt')]//*[contains(text(),'"+dateselect+"')]"));
	}
}


