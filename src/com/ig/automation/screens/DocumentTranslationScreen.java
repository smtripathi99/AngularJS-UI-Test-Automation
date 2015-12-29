package com.ig.automation.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ig.automation.coreactions.DataActions;


public class DocumentTranslationScreen extends DataActions {
	public WebElement searchDoc;
	public WebElement basicSearch;
	public Select docIDSearchdropdown;
	public WebElement enterDocIDbox;
	public WebElement searchButton;
	public WebElement filterDocID;
	public WebElement crTransButton;
	public WebElement cancelTransButton;
	public WebElement translationTab;
	public WebElement transDocid;
	public WebElement transType;
	public WebElement transStatus;
	public WebElement createTranslation;
	public WebElement translationLabel;
	public WebElement transLanguage;
	public WebElement transAllLanguage;
	public WebElement sendforTranslationmenu;
	public WebElement sendforTranslationLabel;
	public WebElement email;
	public WebElement subject;
	public WebElement message;
	public WebElement translationSourcedoc;
	public WebElement translationSupport;
	public WebElement msword;
	public WebElement receiveTranslationmenu;
	public WebElement receiveTranslationLabel;
	public WebElement saveAs;
	public Select reasonforRevision;
	public WebElement checkinFile;
	public WebElement makeExact;
	public WebElement promote;
	public WebElement translatledDoc;
	public WebElement partialTranslation;
	public WebElement convertExactLabel;
	public WebElement translatedVersion;
	public WebElement convertExactMessage;
	public WebElement convertPartialLabel;
	public WebElement convertPartialMessage;
	public WebElement masterDocid;
	public WebElement transChildDocid;
	public WebElement translateddoc;
	public Select signatureMeaning;
	public WebElement confirmSig;
	public WebElement password;
	public WebElement userid;
	public WebElement messageCreate;
	public WebElement searchLanguageColumn;
	public WebElement enterLanguageColumn;

	public void initializeSearch() {

		searchDoc = findElement(By.className("search"));
				//findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/ul[1]/li/i"));
										
	}

	public void initializeBasicSearch() {

		basicSearch = findElement(By.className("QA_testing_Basic_Search"));
				//findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div[2]/div/gc-search/div[1]/accordion/div/div[1]/div[1]/h4/a/span[1]"));

	}

	public void initializeDocIDSearch() {

		docIDSearchdropdown = new Select(findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[3]/gc-search/div[1]/accordion/div/div[1]/div[2]/div/div/div/div[7]/div/div/div/select")));
		enterDocIDbox = findElement(By.cssSelector(".panel-collapse.collapse.in>div>div>div>div:nth-child(7)>div>div>div>input"));
				//findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div[2]/div[1]/gc-search/div[1]/accordion/div/div[1]/div[2]/div/div/div/div[7]/div/div/div/input"));
		searchButton = findElement(By.className("QA_testing_Search_Document_Btn"));

	}

	public void initializeDocument() {
		filterDocID = findElement(By.cssSelector(".gcGrid__row.ng-scope.gcGrid__row-even>div:nth-child(1)>div>div>span"));
				//findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div[2]/div[2]/div[16]/div[5]/div[3]/div[1]/div/div/span"));
	}

	public void initializeTranslationTab() {

		translationTab = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[6]/div/div/ul/li[4]/a"));
				// "/html/body/div[2]/div[3]/div[2]/div[2]/div[2]/div[17]/div/ul/li[4]/a"));
											  
	}

	public void initializeCreateTranslationLink() {

		createTranslation = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[6]/div/div/div/div[4]/div/button"));
				//"/html/body/div[2]/div[3]/div[2]/div[2]/div[2]/div[17]/div/div/div[4]/a"));
	}

	public void initializeCreateTranslationPanel() {

		translationLabel = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[2]/div/div/div[2]/h1"));

		transLanguage = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[2]/div/div/div[4]/div/div[1]/div[1]/div/div/div/tags-input/div/div/input"));

		transAllLanguage = findElement(By.className("QA_testing_Select"));

	}

	public void initializeDoneCancel() {

		crTransButton = findElement(By.className("QA_Testing_Panel_Btn_createTranslation"));

		cancelTransButton = findElement(By.className("QA_Testing_Panel_Btn_cancel"));

	}

	public void initializeTranslationListing() {

		translatledDoc = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div/div/div[1]/div/div[17]/div/div/div[4]/div/div[5]/div[3]/div[1]/div/div/span"));
		partialTranslation = findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div[1]/div/div/div/div[1]/div/div[17]/div/div/div[4]/div/div[5]/div[3]/div[5]/div/div/a"));

	}

	public void initializeSearchTranslationListing() {

		searchLanguageColumn = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[5]/div/div/div/div[4]/div/div[2]/div[3]/div[3]/span/span/div/span[1]/i"));

		enterLanguageColumn = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[5]/div/div/div/div[4]/div/div[2]/div[3]/div[3]/span/span/div/span[2]/span[2]/input"));
	}

	public void initializeExactTranslationListing() {

		convertExactLabel = findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div[1]/div/div/div/div[1]/div/div[5]/div/h1[1]"));

		convertExactMessage = findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div[1]/div/div/div/div[1]/div/div[5]/div/div[2]/div/div/div[2]/p/text()"));

		translatedVersion = findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div[1]/div/div/div/div[1]/div/div[5]/div/div[2]/div/div/div[4]/div/div/div[2]"));
	}

	public void initializePartialTranslationListing() {

		convertPartialLabel = findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div[1]/div/div/div/div[1]/div/div[6]/div/h1[1]"));

		transChildDocid = findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div[1]/div/div/div/div[1]/div/div[6]/div/div[2]/div/div[1]/div[2]"));

		convertPartialMessage = findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div[1]/div/div/div/div[1]/div/div[6]/div/div[2]/div/div[2]/p/text()"));

		masterDocid = findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div[1]/div/div/div/div[1]/div/div[6]/div/div[2]/div/div[3]/div[2]"));

	}

	public void initializeActionMenu() {

		sendforTranslationmenu = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div/div/div[1]/div/div[16]/div[1]/div[2]/ul/li[5]/a"));
		receiveTranslationmenu = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[2]/div[2]/div[16]/div[1]/div[2]/ul/li[6]/a"));

	}

	public void initializeSendforTranslationPanel() {

		sendforTranslationLabel = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div/div/div/div[1]/div/div[7]/div/h1[1]"));

		translateddoc = findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div[1]/div/div/div/div[1]/div/div[7]/div/div[2]/div/div/div[1]"));

		email = findElement(By.className("QA_testing_Email"));
		subject = findElement(By.className("QA_testing_Subject"));
		message = findElement(By.className("QA_testing_Message"));
		translationSupport = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[2]/div[2]/div[7]/div/div[2]/div/div/div[7]/div[1]/div/div[2]/h1"));
		msword = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[2]/div[2]/div[7]/div/div[2]/div/div/div[9]/div/label/input"));

	}

	public void initializeReceiveTranslationPanel() {

		receiveTranslationLabel = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[2]/div[2]/div[8]/div/h1[1]"));

		saveAs = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[2]/div[2]/div[8]/div/div[2]/div/div[2]/div[1]/div/div/div/label/input"));
		reasonforRevision = new Select(findElement(By.className("QA_testing_Reason")));
		checkinFile = findElement(By.className("QA_testing_Check"));

		makeExact = findElement(By.className("QA_testing_Make"));
		promote = findElement(By.className("QA_testing_Promote"));
	}

	public void initializePromotePanel() {

		signatureMeaning = new Select(findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div[1]/div/div/div/div[1]/div/div[8]/div/div[2]/div/div[3]/div[1]/div/select")));

		userid = findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div[1]/div/div/div/div[1]/div/div[8]/div/div[2]/div/div[3]/div[2]/div/input"));
		password = (findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div[1]/div/div/div/div[1]/div/div[8]/div/div[2]/div/div[3]/div[3]/div/input")));
		confirmSig = findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div[1]/div/div/div/div[1]/div/div[8]/div/div[2]/div/div[3]/div[4]/div/label/input"));

	}

	public void initializeMessages() {
		messageCreate = waitForElementToAppear(driver, "toast-container");
		// docLink = findElement(By.xpath("//*[contains(@id,'toast-container')]/div/div[2]/a[2]/b"));

	}

}
