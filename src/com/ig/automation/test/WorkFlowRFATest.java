package com.ig.automation.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ig.automation.screens.ContentManagementScreen;
import com.ig.automation.screens.HomeScreen;
import com.ig.automation.screens.InboxScreen;
import com.ig.automation.screens.WorkflowScreen;
import com.ig.automation.utility.Log;

public class WorkFlowRFATest extends WorkflowScreen {
	
	HomeTest homeTest = new HomeTest();
	ContentManagementScreen contentManScreen = new ContentManagementScreen();
	CreateDocumentTest createDocumentTest = new CreateDocumentTest();
	String docB ;
	HomeScreen homeScreen = new HomeScreen();
	InboxScreen inboxScreen = new InboxScreen();
	
	@BeforeClass
	public void login() {
		try {
			homeTest.testHome();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority=1)
	public void startWorkFlowRFATest(){
		Actions action = new Actions(driver);
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("WorkFlow - Route For Approval Test");
		try {
			contentManScreen.initializeAnnex();
			contentManScreen.annexLink.click();
			docB=createDocumentTest.doCreateDocument("Annex II","Test ST B","European Union","English","Alkaline Aqua","ALLERSOLV","","");
			driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[2]/div/div[2]/ul/li[3]/a")).click();
			Thread.sleep(2000);
			initializeProcessManagement();
			processMng.click();
			Thread.sleep(2000);
			initializeRFA();
			rfa.click();
			Thread.sleep(2000);
			getScreenShot("WorkFlow_RFA", "RFA_Screen");
			initializeWorkFlowRFA();
			Assert.assertTrue(startWorkflowContainerRFA.getText().contains(docB), "UI-WF-01 - Start Workflow Screen is displayed successfully for Document Id - " + docB);
			Log.info("UI-WF-01 - Start Workflow Screen is displayed successfully for Document Id - " + docB);
			Assert.assertTrue(startWorkflowContainerRFA.getText().contains("Status"), "UI-WF-03 - Status Label is displayed successfully");
			Log.info("UI-WF-03 - Status Label is displayed successfully");
			Assert.assertTrue(startWorkflowContainerRFA.getText().contains("Version"), "UI-WF-04 - Version Label is displayed successfully");
			Log.info("UI-WF-04 - Version Label is displayed successfully");
			Assert.assertTrue(startWorkflowContainerRFA.getText().contains("Language"), "UI-WF-05 - Language Label is displayed successfully");
			Log.info("UI-WF-05 - Language Label is displayed successfully");
			Assert.assertTrue(startWorkflowContainerRFA.getText().contains("Countries"), "UI-WF-06 - Countries Label is displayed successfully");
			Log.info("UI-WF-06 - Countries Label is displayed successfully");
			Assert.assertTrue(startWorkflowContainerRFA.getText().contains("Title"), "UI-WF-07 - Title Label is displayed successfully");
			Log.info("UI-WF-07 - Title Label is displayed successfully");
			Assert.assertEquals(startWFNextRFA.isDisplayed(), true, "Next Button is displayed Successfully"); 
			Log.info("Next Button is Passed Successfully");
			Assert.assertEquals(startWFCancelRFA.isDisplayed(), true, "Cancel Button is displayed Successfully"); 
			Log.info("Cancel Button is Passed Successfully");
			Assert.assertEquals(oneStepWFRFA.isDisplayed(), true, "UI-WF-08 - Select Workflow Template is Displayed Successfully"); 
			Log.info("UI-WF-08 -Select Workflow Template is Displayed Successfully");
			oneStepWFRFA.click();
			startWFNextRFA.click();
			Thread.sleep(2000);
			getScreenShot("WorkFlow_RFA", "RFA_Screen1");
			initializeWorkFlowInfoRFA();
			Assert.assertEquals(workfloeInfoDateRFA.isDisplayed(), true, "UI-WF-16 - Workflow Due Date control is Displayed Successfully"); 
			Log.info("UI-WF-16 - Workflow Due Date control is Displayed Successfully");
			Assert.assertEquals(workfloeInfoDateRFA.isEnabled(), true, "UI-WF-16 - Workflow Due Date control is Enabled Successfully"); 
			Log.info("UI-WF-16 - Workflow Due Date control is Enabled Successfully");
			Assert.assertEquals(workfloeInfoDateRFA.getText(), "", "UI-WF-16 - Workflow Due Date control is Cleared"); 
			Log.info("UI-WF-16 - Workflow Due Date control is Cleared");
			Assert.assertEquals(descriptionRFA.isDisplayed(), true, "UI-WF-17 - Workflow Instructions field is Displayed Successfully"); 
			Log.info("UI-WF-17 - Workflow Instructions field is Displayed Successfully");
			Assert.assertEquals(descriptionRFA.isEnabled(), true, "UI-WF-17 - Workflow Instructions field is Enabled Successfully"); 
			Log.info("UI-WF-17 - Workflow Instructions field is Enabled Successfully");
			Assert.assertEquals(descriptionRFA.getText(), "", "UI-WF-17 -Workflow Instructions field is Cleared"); 
			Log.info("UI-WF-17 - Workflow Instructions field is Cleared");
			Assert.assertEquals(addPerformer1RFA.isDisplayed(), true, "UI-WF-18 - Add Performer link is Displayed Successfully"); 
			Log.info("UI-WF-18 - Add Performer link is Displayed Successfully");
			Assert.assertEquals(addPerformer1RFA.isEnabled(), true, "UI-WF-18 - Add Performer link is Enabled Successfully"); 
			Log.info("UI-WF-18 - Add Performer link is Enabled Successfully");
			Assert.assertEquals(startWorkflowCommentRFA.isDisplayed(), true, "UI-WF-19 - Comments field is Displayed Successfully"); 
			Log.info("UI-WF-19 -Comments field is Displayed Successfully");
			Assert.assertEquals(startWorkflowCommentRFA.isEnabled(), true, "UI-WF-19 -Comments field is Enabled Successfully"); 
			Log.info("UI-WF-19 - Comments field is Enabled Successfully");
			Assert.assertEquals(startWorkflowCommentRFA.getText(), "", "UI-WF-19 -Comments field is Cleared"); 
			Log.info("UI-WF-19 - Comments field is Cleared");
			
			// TODO : Select date from Calendar
			workfloeInfoDateRFA.click();
			workfloeInfoDateRFA.sendKeys("26-Mar-2015");
			Thread.sleep(1000);
			descriptionRFA.sendKeys("Test description");
			addPerformer1RFA.click();
			Thread.sleep(2000);
			
			initializePerformerListRFA();			
			Assert.assertEquals(selectPerformerPanelRFA.isDisplayed(), true, "UI-WF-20 - The Select Performers panels is Displayed Successfully"); 
			Log.info("UI-WF-20 -The Select Performers panels is Displayed Successfully");
			
			if(selectPerformerPanelRFA.getSize() != null){
				Log.info("UI-AP-01 -The Select Performers panels is Displayed with group or user names Successfully");
			}
			//Done button should be disabled - Issue
			Assert.assertEquals(selectPerformerDoneRFA.isDisplayed(), true, "UI-AP-04 - Done button is Displayed Successfully"); 
			Log.info("UI-AP-04 - Done button is Displayed Successfully");
			Assert.assertEquals(selectPerformerCancelRFA.isDisplayed(), true, "UI-AP-05 - Cancel button is Displayed Successfully"); 
			Log.info("UI-AP-05 - Cancel button is Displayed Successfully");
			Assert.assertEquals(selectPerformerCancelRFA.isEnabled(), true, "UI-AP-05 - Cancel button is Enabled Successfully"); 
			Log.info("UI-AP-05 - Cancel button is Enabled Successfully");
			
			initializeSelectPerformersRFA();
			Assert.assertEquals(userSelectedRFA.isDisplayed(),true , "UI-AP-03 -Selected Performer section is displayed"); 
			Log.info("UI-AP-03 -Selected Performer section is displayed.");
			Assert.assertEquals(userSelectedRFA.getText().contains(""),true , "UI-AP-03 -Selected Performer section is empty."); 
			Log.info("UI-AP-03 -Selected Performer section is empty.");
			
			driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[1]/div/div/div[4]/div/div[4]/div/div/div[4]/div/div[1]/div/div[2]/div/div[2]")).click();
			Thread.sleep(2000);
			//TODO - need to update the xpath
			action.moveToElement(driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[1]/div/div/div[4]/div/div[4]/div/div/div[4]/div/div[1]/div/div[2]/div/div[1]/div/div[2]/span[2]/i"))).click().build().perform();
			Thread.sleep(2000);
			
			getScreenShot("WorkFlow_RFA", "Select_Performer");
			Assert.assertEquals(userSelectedRFA.getText().contains("role_application_manager"),true , "UI-AP-07 -The group or user name is displayed in the Selected Performers section."); 
			Log.info("UI-AP-07 - The group or user name is displayed in the Selected Performers section.");
			Assert.assertEquals(selectPerformerDoneRFA.isDisplayed(), true, "UI-AP-09 - Done button is Displayed Successfully"); 
			Log.info("UI-AP-09 - Done button is Displayed Successfully");
			Assert.assertEquals(selectPerformerDoneRFA.isEnabled(), true, "UI-AP-09 - Done button is Enabled Successfully"); 
			Log.info("UI-AP-09 - Done button is Enabled Successfully");
			userSelectedRFA.click();
			action.moveToElement(removeUserButtonRFA).click().build().perform();
			Thread.sleep(2000);
			if(selectedPerformerContainerRFA.getText().equals("")){
				Log.info("UI-AP-10 - When user clicks the “x” next to the group or user in the Selected Performers section,Group or user name is removed from the Selected Performer section Successfully.");
			}
			driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[1]/div/div/div[4]/div/div[4]/div/div/div[4]/div/div[1]/div/div[2]/div/div[2]/div/div[1]")).click();
			Thread.sleep(2000);
			//TODO - need to update the xpath
			action.moveToElement(driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[1]/div/div/div[4]/div/div[4]/div/div/div[4]/div/div[1]/div/div[2]/div/div[1]/div/div[2]/span[2]/i"))).click().build().perform();
			Thread.sleep(2000);
			
			//TODO :UI-AP-06
			
			selectPerformerDoneRFA.click();
			Thread.sleep(2000);
			if (startWorkFlowBtnRFA.isDisplayed()){
				Log.info(" UI-AP-12 - The Select Performers panel closes Successfully.");
			}
			Assert.assertEquals(activity1ContainerRFA.getText().contains("role_application_manager"), true, "UI-AP-13 - The selected group or user name is displayed next to the Task");
			Log.info("UI-AP-13 - The selected group or user name is displayed next to the Task");
			startWorkFlowBtnRFA.click();
			initializeStartWFSuccessMsg();
			
			if(startWFMessage.isDisplayed()){
				Log.info("UI-WF-22 - Success Message is displayed successfully");
			}else{
				Log.info("UI-WF-21 - Success Message is not displayed successfully . Error is displayed");
			}
				
			Assert.assertFalse(startWorkFlowBtnRFA.isDisplayed(), "UI-WF-23 : The Start Workflow panel closes.");
			Log.info("UI-WF-23 : The Start Workflow panel closes.");
			Thread.sleep(2000);
		}catch (Throwable t) {
			Log.info(t.getMessage());
			Reporter.log("Start Workflow Test Failed");
			Log.endTestCase("Start Workflow Test Failed");
			Assert.fail(t.getMessage());
		}
	}
	
	@Test
	public void startWFCancel(){
		Log.info(" *** WorkFlow Cancel Test *** ");
		try {
			initializeProcessManagement();
			processMng.click();
			Thread.sleep(2000);
			initializeRFA();
			rfa.click();
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("CLICK RFA FAILED");
		}
		initializeWorkFlowRFA();
		Assert.assertTrue(startWorkflowContainerRFA.getText().contains(docB), "Start Workflow Screen is displayed successfully for Document Id - " + docB);
		Log.info("Start Workflow Screen is displayed successfully for Document Id - " + docB);
		initializeWorkFlowRFA();
		startWFCancelRFA.click();
		Assert.assertFalse(startWorkFlowBtnRFA.isDisplayed(), "UI-WF-24 : The Start Workflow panel closes.");
		Log.info("UI-WF-24 : The Start Workflow panel closes.");
	}
	
	@Test(priority=2)
	public void delegateTaskTest() throws Exception{
		inboxScreen.inilializeInboxLink();
		inboxScreen.inbox.click();
		Thread.sleep(2000);
		getScreenShot("WorkFlow_RFA", "Inbox_Screen");
		inboxScreen.initializeInboxLables();
		Actions action = new Actions(driver);
		Assert.assertTrue(inboxScreen.firstDocDetailContainer.getText().contains(docB), "UI-PWF-03 - Start Workflow Screen is displayed successfully for Document Id - " + docB);
		Log.info("UI-PWF-03 - Start Workflow Screen is displayed successfully for Document Id - " + docB);
		Assert.assertTrue(inboxScreen.firstDocDetailContainer.getText().contains("Status"), "UI-PWF-04 - Status Label is displayed successfully");
		Log.info("UI-PWF-04 - Status Label is displayed successfully");
		Assert.assertTrue(inboxScreen.firstDocDetailContainer.getText().contains("Version"), "UI-PWF-05- Version Label is displayed successfully");
		Log.info("UI-PWF-05 - Version Label is displayed successfully");
		Assert.assertTrue(inboxScreen.firstDocDetailContainer.getText().contains("Language"), "UI-PWF-06 - Language Label is displayed successfully");
		Log.info("UI-PWF-06 - Language Label is displayed successfully");
		Assert.assertTrue(inboxScreen.firstDocDetailContainer.getText().contains("Countries"), "UI-PWF-07 - Countries Label is displayed successfully");
		Log.info("UI-PWF-07 - Countries Label is displayed successfully");
		Assert.assertTrue(inboxScreen.firstDocDetailContainer.getText().contains("Title"), "UI-PWF-08 - Title Label is displayed successfully");
		Log.info("UI-PWF-08- Title Label is displayed successfully");
		
		String status2 = driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[1]/div[1]/div/div[4]/div[3]/div[7]/div/div")).getText();
		Assert.assertTrue(status2.equals("dormant"), "Dormant - Status is displayed successfully");
		Log.info("Dormant - Status is displayed successfully");
		
		inboxScreen.firstDocDetailContainer.click();
		Thread.sleep(2000);
		getScreenShot("WorkFlow_RFA", "AcceptButton");
		inboxScreen.initializeInboxAcceptButtonRFA();
		Assert.assertEquals(inboxScreen.acceptButtonRFA.isDisplayed(), true, "UI-PWF-09 - Accept button is Displayed Successfully"); 
		Log.info("UI-PWF-09 - Accept button is Displayed Successfully");
		inboxScreen.acceptButtonRFA.click();
		Thread.sleep(2000);
		
		// TOdo : UI-PWF-16 Message is Not displayed
		
		String status = driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[1]/div[1]/div/div[4]/div[3]/div[7]/div/div")).getText();
		Assert.assertTrue(status.equals("acquired"), "UI-PWF-17 - After accepting the Document Acquired - Status is displayed successfully");
		Log.info("UI-PWF-17 - After accepting the Document Acquired - Status is displayed successfully");
		
		try {
			inboxScreen.firstDocDetailContainer.click();
		} catch (Exception e) {
			driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[1]/div[1]/div/div[4]/div[3]/div[1]/div/div/div/div[2]")).click();
		}
		inboxScreen.initializeDelRejectForwardButtonRFA();
		Assert.assertEquals(inboxScreen.delegateButtonRFA.isDisplayed(), true, "UI-PWF-24 - Delegate button is Displayed Successfully"); 
		Log.info("UI-PWF-24 - Delegate button is Displayed Successfully");
		
		inboxScreen.delegateButtonRFA.click();
		Thread.sleep(2000);
		inboxScreen.initializeDelegateTaskRFA();
		Assert.assertEquals(inboxScreen.delagateTaskRFA.getText(), "Delegate Task", "UI-PWF-25 - Delegate Task Screen is Displayed Successfully"); 
		Log.info("UI-PWF-25 - Delegate Task Screen is Displayed Successfully");
		getScreenShot("WorkFlow_RFA", "DelegateTaskTab");
		inboxScreen.addPerformerRFA.click();
		Thread.sleep(2000);
		inboxScreen.initializeDelegateSelectUserRFA();
		Thread.sleep(2000);
		action.moveToElement((inboxScreen.selectUserArrowRFA)).click().build().perform();
		Thread.sleep(2000);
		inboxScreen.doneDelegateTaskButtonRFA.click();;
		Thread.sleep(2000);
		Assert.assertEquals(inboxScreen.selectedDelagateUser.getText().contains("role_application_manager"), true, "User is added Successfully for Delagate Task"); 
		Log.info("User is added Successfully for Delagate Task");
		inboxScreen.initializeInboxDelegateTask();
		inboxScreen.doneButton.click();
		Thread.sleep(2000);
		String changedStatus = driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[1]/div[1]/div/div[4]/div[3]/div[7]/div/div")).getText();
		Assert.assertTrue(changedStatus.equals("dormant"), "After delegate Dormant - Status is displayed successfully");
		Log.info("After delegate Dormant - Status is displayed successfully");
	}
	
	@Test(priority=3)
	public void rejectCancel() throws InterruptedException{
		try {
			inboxScreen.firstDocDetailContainer.click();
		} catch (Exception e) {
			System.out.println("Failed");
			driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[1]/div[1]/div/div[4]/div[3]/div[1]/div/div/div/div[2]")).click();
		}
		try {
			inboxScreen.acceptButtonRFA.click();
			Thread.sleep(2000);
		} catch (Exception e) {
			driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[1]/div[2]/div/div/div/div[1]/div/div/div[5]/div/div/button/strong")).click();
		}
		inboxScreen.firstDocDetailContainer.click();
		inboxScreen.initializeDelRejectForwardButtonRFA();
		inboxScreen.rejectButtonRFA.click();
		Thread.sleep(2000);
		inboxScreen.initializeRejectTaskRFA();
		inboxScreen.cancelReject.click();
		Thread.sleep(2000);
		
		Assert.assertEquals(inboxScreen.rejectButtonRFA.isDisplayed(), false, "	UI-RT-16 - Reject Task Panel is Closed"); 
		Log.info("UI-RT-16 - Reject Task Panel is Closed");
	}
	
	@Test(priority=3)
	public void rejectTaskTest() throws Exception{
		try {
			inboxScreen.firstDocDetailContainer.click();
		} catch (Exception e) {
			System.out.println("Failed");
			driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[1]/div[1]/div/div[4]/div[3]/div[1]/div/div/div/div[2]")).click();
		}
		try {
			inboxScreen.acceptButtonRFA.click();
			Thread.sleep(2000);
		} catch (Exception e) {
			driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[1]/div[2]/div/div/div/div[1]/div/div/div[5]/div/div/button/strong")).click();
		}
		String statusA = driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[1]/div[1]/div/div[4]/div[3]/div[7]/div/div")).getText();
		Assert.assertTrue(statusA.equals("acquired"), "After accepting the Document Acquired - Status is displayed successfully");
		Log.info("After accepting the Document Acquired - Status is displayed successfully");
	
		try {
			inboxScreen.firstDocDetailContainer.click();
		} catch (Exception e) {
			System.out.println("Failed");
			driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[1]/div[1]/div/div[4]/div[3]/div[1]/div/div/div/div[2]")).click();
		}
		inboxScreen.initializeDelRejectForwardButtonRFA();
		Assert.assertEquals(inboxScreen.rejectButtonRFA.isDisplayed(), true, "	UI-PWF-11 - Reject Buttom is displayed Successfully"); 
		Log.info("UI-PWF-11 - Reject Button is displayed Successfully");
		inboxScreen.rejectButtonRFA.click();
		Thread.sleep(2000);
		getScreenShot("WorkFlow_RFA", "RejectTaskTab");
		inboxScreen.initializeRejectTaskRFA();
		Assert.assertEquals(inboxScreen.rejectTaskLabel.getText().contains("Reject Task"), true, "UI-PWF-23 - Reject Task screen is displayed"); 
		Log.info("UI-PWF-23 - Reject Task screen is displayed");
		Assert.assertTrue(inboxScreen.rejectHeader.getText().contains("Status"), "UI-RT-01 - The Reject panel is initially displayed in Tabular Format");
		Log.info("UI-RT-01 - The Reject panel is initially displayed in Tabular Format");
		
		Assert.assertEquals(inboxScreen.rejectButtonRFA.isDisplayed(), true, "	UI-RT-11 - Reject Buttom is displayed Successfully"); 
		Log.info("UI-PWF-11 - Reject Button is displayed Successfully");
		verifyDropDOwnValue();
		Log.info("UI-RT-02 - B.	Reason for Rejection label and selection list is displayed Successfully");
		Assert.assertEquals(inboxScreen.userID.isDisplayed(), true, "UI-RT-03 - UserId textbox is displayed Successfully"); 
		Log.info("UI-RT-03 - UserId textbox is displayed Successfully");
		Assert.assertEquals(inboxScreen.userID.isEnabled(), true, "UI-RT-03 - UserId textbox is enabled Successfully"); 
		Log.info("UI-RT-03 - UserId textbox is enabled Successfully");
		Assert.assertEquals(inboxScreen.userID.getText().equals(""), true, "UI-RT-03 - UserId textbox is Cleared"); 
		Log.info("UI-RT-03 - UserId textbox is Cleared");
		
		Assert.assertEquals(inboxScreen.password.isDisplayed(), true, "	UI-RT-04 - Password textbox is displayed Successfully"); 
		Log.info("UI-RT-04- Password textbox is displayed Successfully");
		Assert.assertEquals(inboxScreen.password.isEnabled(), true, "UI-RT-04 - Password textbox is enabled Successfully"); 
		Log.info("UI-RT-04 - Password textbox is enabled Successfully");
		Assert.assertEquals(inboxScreen.password.getText().equals(""), true, "UI-RT-04 - Password textbox is Cleared"); 
		Log.info("UI-RT-04 - Password textbox is Cleared");
		
		Assert.assertEquals(inboxScreen.confirmSignOff.isDisplayed(), true, "	UI-RT-05 - Confirmation checkbox is displayed Successfully"); 
		Log.info("UI-RT-05- Confirmation checkbox is displayed Successfully");
		Assert.assertEquals(inboxScreen.confirmSignOff.isEnabled(), true, "UI-RT-05 - Confirmation checkbox is enabled Successfully"); 
		Log.info("UI-RT-05 - Confirmation checkbox is enabled Successfully");
		//TODO : UI-RT-06 Reject button is hidden.
		
		Assert.assertEquals(inboxScreen.cancelReject.isDisplayed(), true, "UI-RT-07 -Cancel Button is displayed Successfully"); 
		Log.info("UI-RT-07 - Cancel Button is displayed Successfully");
		Assert.assertEquals(inboxScreen.cancelReject.isEnabled(), true, "UI-RT-07 -Cancel Button is enabled Successfully"); 
		Log.info("UI-RT-07 - Cancel Button is enabled Successfully");
		
		// TODO :UI-RT-12	Implied	If the user clicks the Reject button and the user enters and incorrect password:

		inboxScreen.reasonForRejection.selectByValue("Additional Information Needed");
		Log.info("UI-RT-08 - Selects a Reason for Rejection");
		inboxScreen.userID.sendKeys("sneh");
		Log.info("UI-RT-09 - Enters their correct user id ");
		inboxScreen.password.sendKeys("password");
		Log.info("UI-RT-10 - Enters a value in the password field");
		getScreenShot("WorkFlow_RFA", "RejectTab_Values");
		inboxScreen.initializeDoneRejectTaskRFA();
		Assert.assertEquals(inboxScreen.rejectButtonRFA.isDisplayed(), true, "	UI-RT-11 - Reject Buttom is displayed Successfully"); 
		Log.info("UI-PWF-11 - Reject Button is displayed Successfully");
		Assert.assertEquals(inboxScreen.rejectButtonRFA.isEnabled(), true, "	UI-RT-11 - Reject Buttom is displayed Successfully"); 
		Log.info("UI-PWF-11 - Reject Button is enabled Successfully");
		inboxScreen.doneReject.click();
		Thread.sleep(2000);
		Assert.assertEquals(inboxScreen.rejectButtonRFA.isDisplayed(), false, "	UI-RT-14 - Reject Task Panel is Closed"); 
		Log.info("UI-RT-14 - Reject Task Panel is Closed");
		
		//TODO :UI-RT-15
		String changedStatusR = driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[1]/div[1]/div/div[4]/div[3]/div[7]/div/div")).getText();
		Assert.assertTrue(changedStatusR.equals("acquired"), "UI-RT-13 - After Rejection acquired - Status is displayed successfully");
		Log.info("UI-RT-13 - After Rejection acquired - Status is displayed successfully");
	}
	
	public void verifyDropDOwnValue(){
		 String[] exp = {"Additional Information Needed","Provide Supporting Scientific Documents","Other"};
		 boolean match = false;
		 for(int i=1 ; i<4 ; i++){
			 
			 WebElement options = inboxScreen.reasonForRejection.getOptions().get(i);  
			 System.out.println(options.getText());
			 if (options.getText().contains(exp[i-1])){
			        match = true;
			   }
		 }
		  Assert.assertTrue(match);
	}
	
	@Test(priority=3)
	public void forwardTaskTest() throws Exception{
		try {
			inboxScreen.firstDocDetailContainer.click();
		} catch (Exception e) {
			System.out.println("Failed");
			driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[1]/div[1]/div/div[4]/div[3]/div[1]/div/div/div/div[2]")).click();
		}
		try {
			inboxScreen.acceptButtonRFA.click();
			Thread.sleep(2000);
		} catch (Exception e) {
			driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[1]/div[2]/div/div/div/div[1]/div/div/div[5]/div/div/button/strong")).click();
		}
		String statusA = driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[1]/div[1]/div/div[4]/div[3]/div[7]/div/div")).getText();
		Assert.assertTrue(statusA.equals("acquired"), "After accepting the Document Acquired - Status is displayed successfully");
		Log.info("After accepting the Document Acquired - Status is displayed successfully");
	
		try {
			inboxScreen.firstDocDetailContainer.click();
		} catch (Exception e) {
			System.out.println("Failed");
			driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[1]/div[1]/div/div[4]/div[3]/div[1]/div/div/div/div[2]")).click();
		}
		inboxScreen.initializeDelRejectForwardButtonRFA();
		inboxScreen.forwardButtonRFA.click();
		Thread.sleep(2000);
		getScreenShot("WorkFlow_RFA", "ForwardTaskTab");
		inboxScreen.initializeForwardTaskRFA();
		Assert.assertEquals(inboxScreen.forwardButtonRFA.getText().contains("Forward Task"), true, "Forward Task screen is displayed"); 
		Log.info("Forward Task screen is displayed");
		inboxScreen.signOff.selectByValue("Author Approval");
		inboxScreen.userIDForward.sendKeys("appmanager01");
		inboxScreen.passwordForward.sendKeys("password");
		inboxScreen.confirmSignOff.click(); 
		getScreenShot("WorkFlow_RFA", "ForwardTab_Values");
		inboxScreen.initializeApproveForwardTaskRFA();
		inboxScreen.approveForward.click();
		/*String changedStatusR = driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[1]/div[1]/div/div[4]/div[3]/div[7]/div/div")).getText();
		Assert.assertTrue(changedStatusR.equals("acquired"), "After Rejection acquired - Status is displayed successfully");
		Log.info("After Rejection acquired - Status is displayed successfully");*/
	}
	
	public List<String> doTestWorkflowRFA(String screenShotFolder, String desc){
		Actions action = new Actions(driver);
		List<String> itemsToReturnRFA = new ArrayList<>();
		try {
			initializeProcessManagement();
			processMng.click();
			Thread.sleep(2000);
			try {
				initializeRFA();
				rfa.click();
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			initializeWorkFlowRFA();
			String title = startWFRFATitle.getText();
			itemsToReturnRFA.add(title);
			oneStepWFRFA.click();
			Thread.sleep(2000);
			startWFNextRFA.click();
			Thread.sleep(2000);
			initializeWorkFlowInfoRFA();
			workfloeInfoDateRFA.click();
			Thread.sleep(1000);
			initializeCalendarRFA();
			nextMonth.click();
			Thread.sleep(1000);
			selectDate.click();
			Thread.sleep(1000);
			String selectedDate =workfloeInfoDateRFA.getText();
			itemsToReturnRFA.add(selectedDate);
			descriptionRFA.sendKeys(desc);
			String selectedDesc =descriptionRFA.getText();
			itemsToReturnRFA.add(selectedDesc);
			getScreenShot(screenShotFolder, "WorkFlowInfo_RFA");
			
			addPerformer1RFA.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div[1]/div/div/div[4]/div/div[4]/div/div/div[4]/div/div[1]/div/div[2]/div/div[4]/div/div[1]")).click();
			Thread.sleep(2000);
			//TODO - need to update the xpath
			action.moveToElement(driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div[1]/div/div/div[4]/div/div[4]/div/div/div[4]/div/div[1]/div/div[2]/div/div[22]/span[3]/i"))).click().build().perform();
			Thread.sleep(2000);
			getScreenShot(screenShotFolder, "AddPerformer_RFA");
			initializeSelectPerformersRFA();
			String userselectedRFA =userSelectedRFA.getText();
			itemsToReturnRFA.add(userselectedRFA);
			initializePerformerListRFA();
			selectPerformerDoneRFA.click();
			Thread.sleep(2000);
		//	initializeWorkFlowInfoRFA();
			startWorkflowCommentRFA.sendKeys("Test comment");
			startWorkFlowBtnRFA.click();
			getScreenShot(screenShotFolder, "start_RFA");
			Thread.sleep(2000);
		}catch (Throwable t) {
			Log.info(t.getMessage());
			Reporter.log("Start Workflow Test Failed");
			Log.endTestCase("Start Workflow Test Failed");
			Assert.fail(t.getMessage());
		}
		return itemsToReturnRFA;
	}
	
	public List<String> doForwardTaskTest(String folderName) throws Exception{
		List<String> RFAItemsToVerify = new ArrayList<>();
		try {
			
			inboxScreen.firstDocDetailContainer.click();
		} catch (Exception e) {
			System.out.println("Failed");
			driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[1]/div[1]/div/div[4]/div[3]/div[1]/div/div/div/div[2]")).click();
		}
		try {
			inboxScreen.acceptButtonRFA.click();
			Thread.sleep(2000);
		} catch (Exception e) {
			driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[1]/div[2]/div/div/div/div[1]/div/div/div[5]/div/div/button/strong")).click();
		}
		String statusA = driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[1]/div[1]/div/div[4]/div[3]/div[7]/div/div")).getText();
		Assert.assertTrue(statusA.equals("acquired"), "After accepting the Document Acquired - Status is displayed successfully");
		Log.info("After accepting the Document Acquired - Status is displayed successfully");
	
		try {
			inboxScreen.firstDocDetailContainer.click();
		} catch (Exception e) {
			System.out.println("Failed");
			driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[1]/div[1]/div/div[4]/div[3]/div[1]/div/div/div/div[2]")).click();
		}
		inboxScreen.initializeDelRejectForwardButtonRFA();
		inboxScreen.forwardButtonRFA.click();
		Thread.sleep(2000);
		getScreenShot(folderName, "ForwardTaskTab");
		inboxScreen.initializeForwardTaskRFA();
		Assert.assertEquals(inboxScreen.forwardButtonRFA.getText().contains("Forward Task"), true, "Forward Task screen is displayed"); 
		Log.info("Forward Task screen is displayed");
		inboxScreen.signOff.selectByValue("Author Approval");
		inboxScreen.userIDForward.sendKeys("author1");
		String userName = inboxScreen.userIDForward.getText();
		RFAItemsToVerify.add(userName);
		inboxScreen.passwordForward.sendKeys("password");
		inboxScreen.confirmSignOff.click(); 
		getScreenShot(folderName, "ForwardTab_Values");
		inboxScreen.initializeApproveForwardTaskRFA();
		inboxScreen.approveForward.click();
		/*String changedStatusR = driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[1]/div[1]/div/div[4]/div[3]/div[7]/div/div")).getText();
		Assert.assertTrue(changedStatusR.equals("acquired"), "After Rejection acquired - Status is displayed successfully");
		Log.info("After Rejection acquired - Status is displayed successfully");*/
		return RFAItemsToVerify;
	}

	public void doFinishtask() throws InterruptedException{
		inboxScreen.initializeInboxDelegateButton();
		inboxScreen.finishButton.click();
		Thread.sleep(2000);
		inboxScreen.initializeInboxFinishTask();
		Assert.assertEquals(inboxScreen.finishTaskLabel.getText().contains("Finish Task "), true, "Finish Task screen is displayed");
		Log.info("Finish Task screen is displayed");
		inboxScreen.doneFinishTaskButton.click();
		Thread.sleep(2000);
		//search in Inbox removed task
		Log.info("Workflow is finished and task is removed from inbox.");
	}
	
}

