package com.ig.automation.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ig.automation.coreactions.DataActions;

public class InboxScreen extends DataActions{
	
	public WebElement inboxTitle;
	public WebElement documentLabel;
	public WebElement subjectLabel;
	public WebElement dueDateLabel;
	public WebElement statusLabel;
	public WebElement workFlowLabel;
	public WebElement firstDocDetailContainer;
	public WebElement acceptButton;
	public WebElement delegateButton;
	public WebElement finishButton;
	public WebElement delegateTaskLabel;
	public WebElement addUser;
	public WebElement doneButton;
	public WebElement selectUserContainer;
	public WebElement selectUserArrow;
	public WebElement doneDelegateTaskButton;
	public WebElement delegateToLabel;
	
	
	public WebElement inbox ;
	public WebElement firstDocStatus;
	public WebElement finishTaskLabel;
	public WebElement cancelFinishTaskButton;
	public WebElement doneFinishTaskButton;
	public WebElement delegateButtonRFA;
	public WebElement rejectButtonRFA;
	public WebElement forwardButtonRFA;
	public WebElement rejectTaskLabel;
	public Select reasonForRejection;
	public WebElement userID;
	public WebElement password;
	public WebElement cancelReject;
	public WebElement doneReject;
	public WebElement approveForward;
	public WebElement confirmSignOff;
	public WebElement forwardTask;
	public Select signOff;
	public WebElement userIDForward;
	public WebElement passwordForward;
	public WebElement cancelForward;
	public WebElement delagateTaskRFA;
	public WebElement addPerformerRFA;
	public WebElement doneDelagateRFA;
	public WebElement selectedDelagateUser;
	public WebElement acceptButtonRFA;
	public WebElement selectUserContainerRFA;
	public WebElement doneDelegateTaskButtonRFA;
	public WebElement selectUserArrowRFA;
	public WebElement rejectHeader;
	public Select itemsPerPage;
	public WebElement nextLink;
	public WebElement firstPage;
	public WebElement pagenation;
	public WebElement notificationTab;
	public WebElement taskDetailPanel;
	public WebElement documentLabelNotification;
	public WebElement subjectLabelNotification;
	public WebElement dueDateLabelNotification;
	public WebElement statusLabelNotification;
	public WebElement firstContainer;
	public WebElement itemsPerPageNotification;
	public WebElement nextLinkNotification;
	public WebElement firstPageNotification;
	public WebElement workFlowLabelNotification;
	public WebElement from;
	public WebElement dateReceived;
	public WebElement subject;
	public WebElement instructions;
	public WebElement due;
	public WebElement deleteButton;
	public WebElement detailPanel;
	
	public void inilializeInboxLink(){
		inbox= findElement(By.xpath("/html/body/div/div[2]/div/accordion/div/div[3]/div[1]/h4/a/label/span/span"));
	}
	
	public void initializeInboxLables(){
		inboxTitle = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[1]/h3"));
		documentLabel=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[1]/div/div/div[3]/div[1]/span/span/div/span[2]/span[1]/span"));
		subjectLabel=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[1]/div/div/div[3]/div[3]/span/span/div/span[2]/span[1]/span"));
		dueDateLabel = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[1]/div/div/div[3]/div[5]/span/span/div/span[2]/span[1]/span"));
		statusLabel = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[1]/div/div/div[3]/div[7]/span/span/div/span[2]/span[1]/span"));
		workFlowLabel = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[1]/div/div/div[3]/div[9]/span/span/div/span[2]/span[1]/span"));
		firstDocDetailContainer=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[1]/div/div/div[4]/div[3]/div[1]/div/div/div/div[2]"));
		firstDocStatus=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[1]/div[1]/div/div[4]/div[3]/div[7]/div/div"));
		itemsPerPage = new Select(findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[1]/div/div/div[2]/div[2]/div/select")));
		nextLink=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[1]/div/div/div[2]/div[1]/span[8]/a"));
		firstPage=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[1]/div/div/div[2]/div[1]/span[3]/a"));
		pagenation = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[1]/div/div/div[2]/div[1]"));
	notificationTab=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/ul/li[2]"));
	}
	
	public void initializeTaskDetailsPanel(){
		taskDetailPanel=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[1]/div[2]/div/div/ul/li[1]/a"));
	}
	
	public void initializeNotificationTab(){
		documentLabelNotification=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[2]/div[1]/div/div[3]/div[1]/span/span/div/span[2]/span[1]"));
		subjectLabelNotification=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[2]/div[1]/div/div[3]/div[3]/span/span/div/span[2]/span[1]/span"));
		dueDateLabelNotification = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[2]/div[1]/div/div[3]/div[5]/span/span/div/span[2]/span[1]/span"));
		statusLabelNotification = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[2]/div[1]/div/div[3]/div[7]/span/span/div/span[2]/span[1]/span"));
		workFlowLabelNotification = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[2]/div[1]/div/div[3]/div[9]/span/span/div/span[2]/span[1]/span"));
		firstContainer=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[2]/div[1]/div/div[4]/div[3]"));
		itemsPerPageNotification =findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[2]/div[1]/div/div[2]/div[2]/div/select"));
		nextLinkNotification=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[2]/div[1]/div/div[2]/div[1]/span[9]/a"));
		firstPageNotification=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[2]/div[1]/div/div[2]/div[1]/span[3]"));
	}
	
	public void initializeNotificationDetailPanel(){
		detailPanel=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[2]/div[2]/div/div/div"));
		from=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[2]/div[2]/div/div/div/div/div/div/div[2]/div[1]/strong"));
		dateReceived=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[2]/div[2]/div/div/div/div/div/div/div[2]/div[2]/strong"));
		due = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[2]/div[2]/div/div/div/div/div/div/div[2]/div[3]/strong"));
		instructions = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[2]/div[2]/div/div/div/div/div/div/div[3]/div[1]/strong"));
		subject = findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[2]/div[2]/div/div/div/div/div/div/div[1]/strong"));
		deleteButton=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[2]/div[2]/div/div/div/div/div/div/div[4]/div/div/button"));
	}
	
	public void initializeInboxAcceptButton(){
		acceptButton=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[1]/div[2]/div/div/div/div[1]/div/div/div[5]/div/div/button"));
	}
	
	public void initializeInboxAcceptButtonRFA(){
		acceptButtonRFA=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[1]/div[2]/div/div/div/div[1]/div/div/div[5]/div/div/button"));
	}

	public void initializeDelRejectForwardButtonRFA(){
		delegateButtonRFA=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[1]/div[2]/div/div/div/div[1]/div/div/div[5]/div[3]/div"));
		rejectButtonRFA=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[1]/div[2]/div/div/div/div[1]/div/div/div[5]/div[2]/div"));
		forwardButtonRFA=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[1]/div[2]/div/div/div/div[1]/div/div/div[5]/div[1]/div"));
	}
	
	public void initializeInboxDelegateButton(){
		delegateButton=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[1]/div[2]/div/div/div/div[1]/div/div/div[5]/div[2]/div/button"));
		finishButton=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[1]/div[2]/div/div/div/div[1]/div/div/div[5]/div[1]/div/button"));
	}
	
	public void initializeInboxDelegateTask(){
		delegateTaskLabel=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[2]/div/div/div[2]/h1"));
		addUser=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[2]/div/div/div[4]/div/div/div/div[2]/span/a"));
		doneButton=findElement(By.className("QA_Testing_Panel_Btn_action_finishTask"));
		delegateToLabel=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[2]/div/div/div[4]/div/div/div/div[1]"));
	}
	
	public void initializeInboxFinishTask(){
		finishTaskLabel=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[2]/div/div/div[2]/h1"));
		cancelFinishTaskButton=findElement(By.className("QA_Testing_Panel_Btn_cancel"));
		doneFinishTaskButton=findElement(By.className("QA_Testing_Panel_Btn_action_finishTask"));
	}
	
	public void initializeDelegateSelectUser(){
		selectUserContainer=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[2]/div/div/div[4]/div/div/div/div[3]/div/div/div[4]/div/div[1]/div/div[2]/div/div[137]"));
		selectUserArrow=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[2]/div/div/div[4]/div/div/div/div[3]/div/div/div[4]/div/div[1]/div/div[2]/div/div[137]/div/div[2]/span[2]/i"));
		doneDelegateTaskButton=findElement(By.className("QA_Testing_Panel_Btn_doneSelectPerformer"));
	}
	
	public void initializeRejectTaskRFA(){
		rejectTaskLabel=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[2]/div/div/div[2]/h1"));
		rejectHeader=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[2]/div/div/div[2]/div[1]/div/div[2]"));
		reasonForRejection = new Select(findElement(By.className("QA_testing_Reason for Rejection")));
		userID=findElement(By.className("QA_testing_User ID"));
		password=findElement(By.className("QA_testing_Password"));
		cancelReject=findElement(By.className("QA_Testing_Panel_Btn_cancel"));
	}
	
	public void initializeDoneRejectTaskRFA(){
		doneReject=findElement(By.className("QA_Testing_Panel_Btn_action_finishTask"));
	}
	
	public void initializeForwardTaskRFA(){
		forwardTask=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[2]/div/div/div[2]/h1"));
		signOff = new Select(findElement(By.className("QA_testing_Signature Meaning")));
		userIDForward=findElement(By.className("QA_testing_User ID"));
		passwordForward=findElement(By.className("QA_testing_Password"));
		confirmSignOff=findElement(By.className("QA_testing_Confirm "));
		cancelForward=findElement(By.className("QA_Testing_Panel_Btn_cancel"));
	}
	
	public void initializeApproveForwardTaskRFA(){
		approveForward=findElement(By.className("QA_Testing_Panel_Btn_action_finishTask"));
	}

	
	public void initializeDelegateTaskRFA(){
		delagateTaskRFA=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[2]/div/div/div[2]/h1"));
		addPerformerRFA=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[2]/div/div/div[4]/div/div/div/div[2]/span/a"));
		selectedDelagateUser=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[2]/div/div/div[4]/div/div/div/div[1]"));
	}
	
	public void initializeDelegateSelectUserRFA(){
		selectUserContainerRFA=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[2]/div/div/div[4]/div/div/div/div[3]/div/div/div[4]/div/div[1]/div/div[2]/div/div[137]"));
		selectUserArrowRFA=findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[2]/div/div/div[4]/div/div/div/div[3]/div/div/div[4]/div/div[1]/div/div[2]/div/div[137]/div/div[2]/span[2]/i"));
		doneDelegateTaskButtonRFA=findElement(By.className("QA_Testing_Panel_Btn_doneSelectPerformer"));
	}
	
	public void initializeDoneDelagateTaskRFA(){
		doneDelagateRFA=findElement(By.className("QA_Testing_Panel_Btn_action_finishTask"));
	}
}

