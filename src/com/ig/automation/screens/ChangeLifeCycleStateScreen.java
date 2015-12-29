package com.ig.automation.screens;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ig.automation.coreactions.DataActions;


public class ChangeLifeCycleStateScreen extends DataActions {
	public WebElement searchDoc;
	public WebElement basicSearch;
	public Select docIDSearchdropdown;
	public WebElement enterDocIDbox;
	public WebElement searchButton;
	public WebElement filterDocID;
	public WebElement propertiesTab;
	public WebElement edit;
	public WebElement title;
	public WebElement country;
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
	public WebElement docActionall;
	public WebElement changeLifeCycleIcon;
	public WebElement changeLifeCycleStateText;
	public WebElement changeLifeCycleStateProperties;
	public Select targetLifeCycleState;
	public WebElement targetLifeCycleStateField;
	public WebElement signOffRequiredLabel;
	public Select signatureMeaningLabel;
	public WebElement signatureMeaningListing;
	public WebElement userNameLabel;
	public WebElement passwordLabel;
	public WebElement checkBoxLabel;
	public WebElement doneBtn;
	public WebElement cancelBtn;
	public WebElement removeScreen;
	public WebElement gear;
	public WebElement cls;
	public Select dropDown;
	public Select signoffDropDown;
	public WebElement message;
	public WebElement changelifecycle;
	public WebElement processManagement;
	public WebElement changelifecycleStatus;
	public WebElement changelifecycleVersion;
	public Select makeSelection;
	public WebElement titleNDC;
	public WebElement finish;
	public WebElement subMenuchangeLifeCycleState;
	public WebElement propertiesDocID;
	public WebElement propertiesVersion;
	public WebElement propertiesStatus;
	public WebElement propertiesLanguage;
	public WebElement propertiesCountry;
	public WebElement propertiesTitle;
	public WebElement clcScreen;
	public WebElement changeLifeCycleBtn;
	public WebElement changedStatus;
	public WebElement docDetailsPanel;

	public void initializeSearch() {

		searchDoc = findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/ul[1]/li/i"));
	}

	public void initializeBasicSearch() {

		basicSearch = findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div[2]/div/gc-search/div[1]/accordion/div/div[1]/div[1]/h4/a/span[1]"));

	}

	public void initializeDocIDSearch() {

		docIDSearchdropdown = new Select(
				findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div[2]/div[1]/gc-search/div[1]/accordion/div/div[1]/div[2]/div/div/div/div[7]/div/div/div/select")));

		enterDocIDbox = findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div[2]/div[1]/gc-search/div[1]/accordion/div/div[1]/div[2]/div/div/div/div[7]/div/div/div/input"));
		searchButton = findElement(By.className("QA_testing_Search_Document_Btn"));

	}

	public void initializeDocument() {
		filterDocID = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[2]/div[2]/div[16]/div[5]/div[3]/div[1]/div/div/i[3]"));
	}

	public void initializeDocActionMenu() {
		processManagement = findElement(By.xpath("//*[contains(@class,'gcDocMenu__dropdown-menu')]/ul/li[3]/a"));
	}

	public void initializeDocActionSubMenu() {
		subMenuchangeLifeCycleState = findElement(By.xpath("//*[contains(@class,'gcDocMenu__subMenu')]/div[1]/li"));
	}

	public void initializeChangeLifeCycleScreen() {
		clcScreen = findElement(By.xpath("//*[contains(@class,'sidepanel__header_shadow')]"));
	}

	public void initializeTargetLifeCycleStates() {
		targetLifeCycleState = new Select(findElement(By.xpath("//*[contains(@class,'gcSidePanel__content')]/div/div[1]/div[1]/div/select")));
	}

	public void initializeGear() {
		gear = findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div[2]/div[2]/div[16]/div[2]/div/div/div/i[3]"));
	}

	public void initializeChangeLifeCycle() {
		changeLifeCycleIcon = findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div[2]/div[2]/div[16]/div[2]/div/div/div/i[3]/div/div[2]/div/i[3]"));
	}

	public void initializeChangeLifeCycleState() {
		changeLifeCycleStateText = findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div[2]/div[2]/div[3]/div/h1[1]"));
	}

	public void initializeCLSProperties() {
		changeLifeCycleStateProperties = findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div[2]/div[2]/div[3]/div/div[2]/div/div[1]/div/div[2]"));
	}

	public void initializeTargetLifeCycleStateFields() {
		targetLifeCycleStateField = findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div[2]/div[2]/div[3]/div/div[2]/div/div[2]/div[1]/select"));
	}

	public void initializeTLCSDropDown() {
		dropDown = new Select(findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div[2]/div[2]/div[3]/div/div[2]/div/div[2]/div[1]/select")));
	}

	public String initializeSignOffRequired() {
		signOffRequiredLabel = findElement(By.xpath("//*[contains(@class,'gcSidePanel__content')]/div/div[1]/div[2]/div[1]/h4"));
		signatureMeaningLabel = new Select(findElement(By.xpath("//*[contains(@class,'gcSidePanel__content')]/div/div[1]/div[2]/div[2]/div/select")));
		userNameLabel = findElement(By.xpath("//*[contains(@class,'gcSidePanel__content')]/div/div[1]/div[2]/div[3]/div/input"));
		passwordLabel = findElement(By.xpath("//*[contains(@class,'gcSidePanel__content')]/div/div[1]/div[2]/div[4]/div/input"));
		checkBoxLabel = findElement(By.xpath("//*[contains(@class,'gcSidePanel__content')]/div/div[1]/div[2]/div[5]/div/label/input"));

		if (signOffRequiredLabel == null && signatureMeaningLabel == null && userNameLabel == null && passwordLabel == null && checkBoxLabel == null) {
			return "Signature is Hidden";
		} else {
			return "Signature is Displayed";
		}

	}

	public void initializeCancelButton() {

		cancelBtn = findElement(By.className("QA_Testing_Panel_Btn_cancel"));
	}

	public void initializeChangeLifeCycleButton() {
		changeLifeCycleBtn = findElement(By.className("QA_Testing_Panel_Btn_lifecycle"));

	}

	public void initializeRemoveScreen() {
		removeScreen = findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div[2]/h1"));
	}

	public void initializeMessages() {
		message = driver.findElement(By.id("toast-container"));
		// docLink = findElement(By.xpath("//*[contains(@id,'toast-container')]/div/div[2]/a[2]/b"));

	}

	public void initializeChangedStatus() {
		changedStatus = findElement(By.xpath("//*[contains(@class,'gcGrid__cell')]/div/div/span/span"));
	}

	public void initializeDocDetailsPanel() {
		docDetailsPanel = findElement(By.xpath("//*[contains(@class,'tabbable')]/ul/li[1]"));
	}

	public void initializeCLCForNDC() {
		titleNDC = findElement(By.cssSelector("h1:contains('Change Lifecycle State')"));
		makeSelection = new Select(findElement(By.cssSelector(".QA_testing_Select ")));
	}

}
