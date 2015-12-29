package com.ig.automation.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ig.automation.coreactions.DataActions;


public class WorkflowScreen extends DataActions {
	public WebElement createNDCPanelTitle;
	public WebElement title;
	public Select docType;
	public WebElement searchDoc;
	public WebElement basicSearch;
	public Select docIDSearchdropdown;
	public WebElement enterDocIDbox;
	public WebElement searchButton;
	public WebElement filterDocID;
	public WebElement workflow;
	public WebElement rfa;
	public WebElement wftempalte;
	public WebElement nextBtn;
	public WebElement date;
	public WebElement desc;
	public WebElement performer;
	public WebElement startWF;
	public WebElement selectPerformer;
	public WebElement doneBtn;
	public WebElement searchInbox;
	public WebElement searchInboxEnter;
	public WebElement inboxDoc;
	public WebElement info;
	public WebElement accept;
	public WebElement message;
	public WebElement docLink;
	public WebElement errorMessage;
	public WebElement processMng;
	public WebElement startWorkflowContainer;
	public WebElement testWF;
	public WebElement startWFNext;
	public WebElement startWFCancel;
	public WebElement workfloeInfoDate;
	public WebElement description;
	public WebElement addPerformer1;
	public WebElement getDivCount;
	public WebElement requestReview;
	public WebElement startWorkFlowBtn;
	public WebElement selectPerformerDone;
	public WebElement selectPerformerCancel;
	public WebElement startWorkflowComment;
	public WebElement selectPerformerPanel;
	public WebElement userSelected;
	public WebElement removeUserButton;
	public WebElement selectedPerformerContainer;
	public WebElement activity1Container;
	public WebElement oneStepWF;
	public WebElement startWorkflowContainerRFA;
	public WebElement oneStepWFRFA;
	public WebElement startWFNextRFA;
	public WebElement startWFCancelRFA;
	public WebElement workfloeInfoDateRFA;
	public WebElement descriptionRFA;
	public WebElement addPerformer1RFA;
	public WebElement startWorkflowCommentRFA;
	public WebElement startWorkFlowBtnRFA;
	public WebElement activity1ContainerRFA;
	public WebElement selectPerformerPanelRFA;
	public WebElement getDivCountRFA;
	public WebElement selectPerformerDoneRFA;
	public WebElement selectPerformerCancelRFA;
	public WebElement userSelectedRFA;
	public WebElement removeUserButtonRFA;
	public WebElement selectedPerformerContainerRFA;
	public WebElement startWFMessage;
	public WebElement nextMonth;
	public WebElement selectDate;
	public WebElement nextMonthRFR;
	public WebElement selectDateRFR;
	public WebElement startWFRFATitle;
	public WebElement titleRFR;

	public void initializeSearch() {

		searchDoc = findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/ul[1]/li/i"));
	}

	public void initializeInboxSearch() {

		searchInbox = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[3]/div/div/div[1]/div/div/div[3]/div[1]/span/span/div/span[1]/i"));
		searchInboxEnter = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[3]/div/div/div[1]/div/div/div[3]/div[1]/span/span/div/span[2]/span[2]/input"));
	}

	public void initializeInboxAction() {

		inboxDoc = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[3]/div/div/div[1]/div[1]/div/div[4]/div[3]/div[1]/div/div/div"));

	}

	public void initializeInboxInfo() {

		info = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[3]/div/div/div[1]/div[1]/div/div[4]/div[3]/div[1]/div/div/div"));

		accept = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[3]/div/div/div[1]/div[2]/div/div/div/div[1]/div/div/div[5]/div/div/button/strong"));

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
		filterDocID = findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div[2]/div[2]/div[16]/div[5]/div[3]/div[1]/div/div/span"));
	}

	public void initializeAction() {
		workflow = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div[2]/div/div/div[1]/div[1]/div/div[2]/ul/li[7]/a"));
	}

	public void initializeRFA() {
		rfa = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div[2]/div/div/div[1]/div[1]/div/div[2]/ul/li[7]/ul/div[2]/li/a"));
	}

	public void initializeWFTemplate() {
		wftempalte = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div[1]/div/div/div[4]/div/div[2]/div/div/div[2]/div/div/div/div"));
	}

	public void initializeNext() {
		nextBtn = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div[1]/div/div/div[4]/div/div[2]/div/div/div[2]/div/div/div/div"));
	}

	public void initializeStartWF() {
		date = findElement(By.className("QA_testing_Date"));
		desc = findElement(By.className("QA_testing_Description"));
		performer = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div[1]/div/div/div[4]/div/div[3]/div[2]/div/div[2]/div/span[2]/a"));
		startWF = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div[1]/div/div/h1/button[2]"));
		selectPerformer = findElement(By
				.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div[1]/div/div/div[4]/div/div[4]/div/div/div[4]/div/div[1]/div/div[2]/div/div[2]/div[2]/span[2]/i"));

		doneBtn = findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div[1]/div/div/div[4]/div/div[4]/div/div/h1/button[2]"));

	}

	public void initializeMessages() {
		message = driver.findElement(By.id("toast-container"));
		// docLink = findElement(By.xpath("//*[contains(@id,'toast-container')]/div/div[2]/a[2]/b"));
		
	}
	public void initializeErrorMessages() {
		errorMessage = driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div[1]/div/div/div[4]"));
		// docLink = findElement(By.xpath("//*[contains(@id,'toast-container')]/div/div[2]/a[2]/b"));
	}
	
	public void initializeProcessManagement(){
		processMng=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[2]/div/div[2]/ul/li[3]/a"));
	}
	
	public void initializeRFR(){
		requestReview=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[2]/div/div[2]/ul/li[3]/ul/div[2]/li/button"));
	}
	
	public void initializeWorkFlowRFR(){
		titleRFR=findElement(By.cssSelector(".ng-scope>div>div.section.Pd1.mr_t3>div.ng-isolate-scope>div>div>div.sidepanel__header.black>h1"));
		startWorkflowContainer=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[1]/div/div/div[2]"));
		oneStepWF=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[1]/div/div/div[4]/div/div[2]/div/div/div[2]/div/div[1]/div/div/span[1]"));
		testWF=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[1]/div/div/div[4]/div/div[2]/div/div/div[2]/div/div[2]/div/div/span[1]"));
		startWFNext=findElement(By.className("QA_Testing_Panel_Btn_saveTemplate"));
		startWFCancel=findElement(By.className("QA_Testing_Panel_Btn_cancel"));
	}
	
	public void initializeWorkFlowRFA(){
		startWFRFATitle = findElement(By.cssSelector(".whitebg.gcSidePanel-right.gcSidePanel__widthOne>div>h1"));
		startWorkflowContainerRFA=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[1]/div/div/div[2]"));
		oneStepWFRFA=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[1]/div/div/div[4]/div/div[2]/div/div/div[2]/div/div/div"));
		startWFNextRFA=findElement(By.className("QA_Testing_Panel_Btn_saveTemplate"));
		startWFCancelRFA=findElement(By.className("QA_Testing_Panel_Btn_cancel"));
	}
	
	public void initializeWorkFlowInfoRFA(){
		workfloeInfoDateRFA=findElement(By.className("QA_testing_Date"));
		descriptionRFA=findElement(By.className("QA_testing_Description"));
																
		addPerformer1RFA=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[1]/div/div/div[4]/div/div[3]/div[2]/div/div[2]/div/span[2]/a"));
		startWorkFlowBtnRFA=findElement(By.className("QA_Testing_Panel_Btn_startWorkflow"));
		startWorkflowCommentRFA=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[1]/div/div/div[4]/div/div[3]/div[3]/div/div[2]/div[1]/input"));
		activity1ContainerRFA=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[1]/div/div/div[4]/div/div[3]/div[2]/div/div[2]"));
	}
	
	public void initializeWorkFlowInfoRFR(){
		workfloeInfoDate=findElement(By.className("QA_testing_Date"));
		description=findElement(By.className("QA_testing_Description"));
		addPerformer1=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[1]/div/div/div[4]/div/div[3]/div[2]/div/div[2]/div/span[2]/a"));
		startWorkFlowBtn=findElement(By.className("QA_Testing_Panel_Btn_startWorkflow"));
		startWorkflowComment=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[1]/div/div/div[4]/div/div[3]/div[3]/div/div[2]/div[1]/input"));
		activity1Container=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div[1]/div/div/div[4]/div/div[3]/div[2]/div/div[2]/div[1]"));
	}
	
	public void initializeStartWFSuccessMsg(){
		startWFMessage = waitForElementToAppear(driver, "toast-container");
	}
	public void initializePerformerList(){
		selectPerformerPanel=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div[1]/div/div/div[4]/div/div[4]/div/div/div[2]/h1"));
		getDivCount=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[1]/div/div/div[4]/div/div[4]/div/div/div[4]/div/div[1]/div/div[2]/div/"));
		selectPerformerDone=findElement(By.className("QA_Testing_Panel_Btn_doneSelectPerformer"));
		selectPerformerCancel=findElement(By.className("QA_Testing_Panel_Btn_cancel"));
	}
	
	public void initializePerformerListRFA(){
		selectPerformerPanelRFA=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[1]/div/div/div[4]/div/div[4]/div/div/div[4]/div/div[1]/div/div[2]/div"));
		getDivCountRFA=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[1]/div/div/div[4]/div/div[4]/div/div/div[4]/div/div[1]/div/div[2]/div/"));
		selectPerformerDoneRFA=findElement(By.className("QA_Testing_Panel_Btn_doneSelectPerformer"));
		selectPerformerCancelRFA=findElement(By.className("QA_Testing_Panel_Btn_cancel"));
	}
	
	public void initializeSelectPerformers(){
		userSelected=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[1]/div/div/div[4]/div/div[4]/div/div/div[4]/div/div[2]/div/div[2]/div"));
		removeUserButton=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[1]/div/div/div[4]/div/div[4]/div/div/div[4]/div/div[2]/div/div[2]/div/div[2]/span[2]/i"));
		selectedPerformerContainer=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[1]/div/div/div[4]/div/div[4]/div/div/div[4]/div/div[2]/div/div[2]"));
	}
	
	public void initializeSelectPerformersRFA(){
		userSelectedRFA=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[1]/div/div/div[4]/div/div[4]/div/div/div[4]/div/div[2]/div/div[2]/div"));
		removeUserButtonRFA=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[1]/div/div/div[4]/div/div[4]/div/div/div[4]/div/div[2]/div/div[2]/div/div[2]/span[2]/i"));
		selectedPerformerContainerRFA=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[1]/div/div/div[4]/div/div[4]/div/div/div[4]/div/div[2]/div/div[2]"));
	}
	
	public void initializeCalendarRFA(){
		nextMonth=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div[1]/div/div/div[4]/div/div[3]/div[1]/div/div[2]/div[1]/div/div/ul/li[1]/table/thead/tr[1]/th[3]/button"));
		selectDate=findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div[1]/div/div/div[4]/div/div[3]/div[1]/div/div[2]/div[1]/div/div/ul/li[1]/table/tbody/tr[3]/td[6]/button/span"));
	}
	
	public void initializeCalendarRFR(){
		nextMonthRFR=findElement(By.cssSelector(".pull-right[type=button]"));
		selectDateRFR=findElement(By.xpath("(//button[@type='button'])[15]"));
	}
	
}
