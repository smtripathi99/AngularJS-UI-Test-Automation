package com.ig.automation.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
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

public class WorkFlowRFRTest extends WorkflowScreen {
	
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
	public void startWorkFlowTest(){
		Actions action = new Actions(driver);
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("WorkFlow - Route For Review");
		try {
			contentManScreen.initializeAnnex();
			contentManScreen.annexLink.click();
			docB=createDocumentTest.doCreateDocument("Annex II","Test ST B","European Union","English","Alkaline Aqua","ALLERSOLV","","");
			Thread.sleep(2000);
			initializeProcessManagement();
			Thread.sleep(2000);
			processMng.click();
			Thread.sleep(2000);
			initializeRFR();
			requestReview.click();
			Thread.sleep(2000);
			getScreenShot("WorkFlow_RFR", "RFRScreen");
			initializeWorkFlowRFR();
			Assert.assertTrue(startWorkflowContainer.getText().contains(docB), "UI-WF-01 - Start Workflow Screen is displayed successfully for Document Id - " + docB);
			Log.info("UI-WF-01 - Start Workflow Screen is displayed successfully for Document Id - " + docB);
			Assert.assertTrue(startWorkflowContainer.getText().contains("Status"), "UI-WF-03 - Status Label is displayed successfully");
			Log.info("UI-WF-03 - Status Label is displayed successfully");
			Assert.assertTrue(startWorkflowContainer.getText().contains("Version"), "UI-WF-04- Version Label is displayed successfully");
			Log.info("UI-WF-04 - Version Label is displayed successfully");
			Assert.assertTrue(startWorkflowContainer.getText().contains("Language"), "UI-WF-05 - Language Label is displayed successfully");
			Log.info("UI-WF-05 - Language Label is displayed successfully");
			Assert.assertTrue(startWorkflowContainer.getText().contains("Countries"), "UI-WF-06 - Countries Label is displayed successfully");
			Log.info("UI-WF-06 - Countries Label is displayed successfully");
			Assert.assertTrue(startWorkflowContainer.getText().contains("Title"), "UI-WF-07 - Title Label is displayed successfully");
			Log.info("UI-WF-07 - Title Label is displayed successfully");
			Assert.assertEquals(startWFNext.isDisplayed(), true, "Next Button is displayed Successfully"); 
			Log.info("Next Button is Passed Successfully");
			Assert.assertEquals(startWFCancel.isDisplayed(), true, "Cancel Button is displayed Successfully"); 
			Log.info("Cancel Button is Passed Successfully");
			Assert.assertEquals(oneStepWFRFA.isDisplayed(), true, "UI-WF-09 - Select Workflow Template is Displayed Successfully"); 
			Log.info("UI-WF-09 -Select Workflow Template is Displayed Successfully");
			oneStepWF.click();
			startWFNext.click();
			Thread.sleep(2000);
			initializeWorkFlowInfoRFR();
			
			Assert.assertEquals(workfloeInfoDate.isDisplayed(), true, "UI-WF-16 - Workflow Due Date control is Displayed Successfully"); 
			Log.info("UI-WF-16 - Workflow Due Date control is Displayed Successfully");
			Assert.assertEquals(workfloeInfoDate.isEnabled(), true, "UI-WF-16 - Workflow Due Date control is Enabled Successfully"); 
			Log.info("UI-WF-16 - Workflow Due Date control is Enabled Successfully");
			Assert.assertEquals(workfloeInfoDate.getText(), "", "UI-WF-16 - Workflow Due Date control is Cleared"); 
			Log.info("UI-WF-16 - Workflow Due Date control is Cleared");
			Assert.assertEquals(description.isDisplayed(), true, "UI-WF-17 - Workflow Instructions field is Displayed Successfully"); 
			Log.info("UI-WF-17 - Workflow Instructions field is Displayed Successfully");
			Assert.assertEquals(description.isEnabled(), true, "UI-WF-17 - Workflow Instructions field is Enabled Successfully"); 
			Log.info("UI-WF-17 - Workflow Instructions field is Enabled Successfully");
			Assert.assertEquals(description.getText(), "", "UI-WF-17 -Workflow Instructions field is Cleared"); 
			Log.info("UI-WF-17 - Workflow Instructions field is Cleared");
			Assert.assertEquals(addPerformer1.isDisplayed(), true, "UI-WF-18 - Add Performer link is Displayed Successfully"); 
			Log.info("UI-WF-18 - Add Performer link is Displayed Successfully");
			Assert.assertEquals(addPerformer1.isEnabled(), true, "UI-WF-18 - Add Performer link is Enabled Successfully"); 
			Log.info("UI-WF-18 - Add Performer link is Enabled Successfully");
			Assert.assertEquals(startWorkflowComment.isDisplayed(), true, "UI-WF-19 - Comments field is Displayed Successfully"); 
			Log.info("UI-WF-19 -Comments field is Displayed Successfully");
			Assert.assertEquals(startWorkflowComment.isEnabled(), true, "UI-WF-19 -Comments field is Enabled Successfully"); 
			Log.info("UI-WF-19 - Comments field is Enabled Successfully");
			Assert.assertEquals(startWorkflowComment.getText(), "", "UI-WF-19 -Comments field is Cleared"); 
			Log.info("UI-WF-19 - Comments field is Cleared");
			
			//TODO Calendar
			workfloeInfoDate.click();
			Thread.sleep(1000);
			initializeCalendarRFR();
			nextMonthRFR.click();
			Thread.sleep(1000);
			selectDateRFR.click();
			Thread.sleep(1000);
			description.sendKeys("Test description");
			
			addPerformer1.click();
			Thread.sleep(2000);
			initializePerformerList();
			
			Assert.assertEquals(selectPerformerPanel.isDisplayed(), true, "UI-WF-20 - The Select Performers panels is Displayed Successfully"); 
			Log.info("UI-WF-20 -The Select Performers panels is Displayed Successfully");
			
			//Done button should be disabled - Issue
			Assert.assertEquals(selectPerformerDone.isDisplayed(), true, "UI-AP-04 - Done button is Displayed Successfully"); 
			Log.info("UI-AP-04 - Done button is Displayed Successfully");
			Assert.assertEquals(selectPerformerCancel.isDisplayed(), true, "UI-AP-05 - Cancel button is Displayed Successfully"); 
			Log.info("UI-AP-05 - Cancel button is Displayed Successfully");
			Assert.assertEquals(selectPerformerCancel.isEnabled(), true, "UI-AP-05 - Cancel button is Enabled Successfully"); 
			Log.info("UI-AP-05 - Cancel button is Enabled Successfully");
			
			driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[1]/div/div/div[4]/div/div[4]/div/div/div[4]/div/div[1]/div/div[2]/div/div[2]/div/div[1]")).click();
			Thread.sleep(2000);
			//TODO - need to update the xpath
			//TODO - UI-AP-08
			action.moveToElement(driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[1]/div/div/div[4]/div/div[4]/div/div/div[4]/div/div[1]/div/div[2]/div/div[1]/div/div[2]/span[2]/i"))).click().build().perform();
			Thread.sleep(2000);
			getScreenShot("WorkFlow_RFR", "Select_Performer");
			initializeSelectPerformers();
			Assert.assertEquals(userSelected.getText().contains("role_application_manager"),true , "UI-AP-07 -The group or user name is displayed in the Selected Performers section."); 
			Log.info("UI-AP-07 - The group or user name is displayed in the Selected Performers section.");
			Assert.assertEquals(selectPerformerDone.isDisplayed(), true, "UI-AP-09 - Done button is Displayed Successfully"); 
			Log.info("UI-AP-09 - Done button is Displayed Successfully");
			Assert.assertEquals(selectPerformerDone.isEnabled(), true, "UI-AP-09 - Done button is Enabled Successfully"); 
			Log.info("UI-AP-09 - Done button is Enabled Successfully");
			
			userSelected.click();
			action.moveToElement(removeUserButton).click().build().perform();
			Thread.sleep(2000);
			//TODO UI-AP-11
			if(selectedPerformerContainer.getText().equals("")){
				Log.info("UI-AP-10 - When user clicks the “x” next to the group or user in the Selected Performers section,Group or user name is removed from the Selected Performer section Successfully.");
			}
			
			driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[1]/div/div/div[4]/div/div[4]/div/div/div[4]/div/div[1]/div/div[2]/div/div[2]/div/div[1]")).click();
			Thread.sleep(2000);
			//TODO - need to update the xpath
			action.moveToElement(driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[1]/div/div/div[4]/div/div[4]/div/div/div[4]/div/div[1]/div/div[2]/div/div[1]/div/div[2]/span[2]/i"))).click().build().perform();
			Thread.sleep(2000);
			selectPerformerDone.click();
			Thread.sleep(2000);
			if (startWorkFlowBtn.isDisplayed()){
				Log.info(" UI-AP-12 - The Select Performers panel closes Successfully.");
			}
			
			Assert.assertEquals(activity1Container.getText().contains("role_application_manager"), true, "UI-AP-13 - The selected group or user name is displayed next to the Task");
			Log.info("UI-AP-13 - The selected group or user name is displayed next to the Task");
			startWorkFlowBtn.click();
			Thread.sleep(2000);
			System.out.println("DONE");
		}catch (Throwable t) {
			Log.info(t.getMessage());
			Reporter.log("Start Workflow Test Failed");
			Log.endTestCase("Start Workflow Test Failed");
			Assert.fail(t.getMessage());
		}
	}
	
	@Test(priority=2)
	public void inboxTest() throws Exception{
		inboxScreen.inilializeInboxLink();
		inboxScreen.inbox.click();
		Thread.sleep(2000);
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
		inboxScreen.initializeInboxAcceptButton();
		Assert.assertEquals(inboxScreen.acceptButton.isDisplayed(), true, "UI-PWF-09 - Accept button is Displayed Successfully"); 
		Log.info("UI-PWF-09 - Accept button is Displayed Successfully");
		inboxScreen.acceptButton.click();
		Thread.sleep(2000);
		String status = driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[1]/div[1]/div/div[4]/div[3]/div[7]/div/div")).getText();
		Assert.assertTrue(status.equals("acquired"), "After accepting the Document Acquired - Status is displayed successfully");
		Log.info("After accepting the Document Acquired - Status is displayed successfully");
		inboxScreen.firstDocDetailContainer.click();
		
		
		inboxScreen.initializeInboxDelegateButton();
		Assert.assertEquals(inboxScreen.delegateButton.isDisplayed(), true, "UI-PWF-24 - Delegate button is Displayed Successfully"); 
		Log.info("UI-PWF-24 - Delegate button is Displayed Successfully");
		inboxScreen.delegateButton.click();
		Thread.sleep(2000);
		getScreenShot("WorkFlow_RFR", "DelegateScreen");
		inboxScreen.initializeInboxDelegateTask();
		Assert.assertEquals(inboxScreen.delegateTaskLabel.getText(), "Delegate Task", "UI-PWF-25 - Delegate Task Screen is Displayed Successfully"); 
		Log.info("UI-PWF-25 - Delegate Task Screen is Displayed Successfully");
		inboxScreen.addUser.click();
		Thread.sleep(2000);
		
		inboxScreen.initializeDelegateSelectUser();
		Thread.sleep(2000);
		action.moveToElement((inboxScreen.selectUserArrow)).click().build().perform();
		Thread.sleep(2000);
		inboxScreen.doneDelegateTaskButton.click();;
		Thread.sleep(2000);
		
		
		Assert.assertEquals(inboxScreen.delegateToLabel.getText().contains("role_application_manager"), true, "User is added Successfully for Delagate Task"); 
		Log.info("User is added Successfully for Delagate Task");
		
		inboxScreen.doneButton.click();
		Thread.sleep(2000);
		String changedStatus = driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[1]/div[1]/div/div[4]/div[3]/div[7]/div/div")).getText();
		Assert.assertTrue(changedStatus.equals("dormant"), "After delegate Dormant - Status is displayed successfully");
		Log.info("After delegate Dormant - Status is displayed successfully");
		
		inboxScreen.firstDocDetailContainer.click();
		Thread.sleep(2000);
		inboxScreen.finishButton.click();
		Thread.sleep(2000);
		inboxScreen.initializeInboxFinishTask();
		
		Assert.assertEquals(inboxScreen.finishTaskLabel.getText().contains("Finish Task"), true, "Finish Task screen is displayed Successfully"); 
		Log.info("Finish Task screen is displayed Successfully");
		
		inboxScreen.doneFinishTaskButton.click();
	}
	
	public List<String> doTestWorkFlowRFR(String screenShotFolder , String desc){
		Actions action = new Actions(driver);
		List<String> itemsToReturnRFR = new ArrayList<>();
		try {
			initializeProcessManagement();
			Thread.sleep(2000);
			processMng.click();
			Thread.sleep(2000);
			initializeRFR();
			requestReview.click();
			Thread.sleep(2000);
			initializeWorkFlowRFR();
			String title= startWFRFATitle.getText();
			itemsToReturnRFR.add(title);
			oneStepWF.click();
			Thread.sleep(2000);
			startWFNext.click();
			Thread.sleep(2000);
			initializeWorkFlowInfoRFR();
			workfloeInfoDate.click();
			Thread.sleep(1000);
			initializeCalendarRFR();
			nextMonthRFR.click();
			Thread.sleep(1000);
			selectDateRFR.click();
			Thread.sleep(1000);
			String date=workfloeInfoDate.getText();
			itemsToReturnRFR.add(date);
			description.sendKeys(desc);
			String descriptionText = description.getText();
			itemsToReturnRFR.add(descriptionText);
			getScreenShot(screenShotFolder, "WorkFlowScreenRFR");
			addPerformer1.click();
			Thread.sleep(2000);
			initializePerformerList();
			driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div[1]/div/div/div[4]/div/div[4]/div/div/div[4]/div/div[1]/div/div[2]/div/div[4]/div/div[1]")).click();
			Thread.sleep(2000);
			//TODO - need to update the xpath
			action.moveToElement(driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[1]/div[1]/div/div/div[4]/div/div[4]/div/div/div[4]/div/div[1]/div/div[2]/div/div[8]/span[3]/i"))).click().build().perform();
			Thread.sleep(2000);
			initializeSelectPerformers();
			String selectedUser = userSelected.getText();
			itemsToReturnRFR.add(selectedUser);
			getScreenShot(screenShotFolder, "AddPerformerRFR");
			selectPerformerDone.click();
			Thread.sleep(2000);
			getScreenShot(screenShotFolder, "StartWorkFlowScreen");
			startWorkFlowBtn.click();
			Thread.sleep(2000);
		}catch (Throwable t) {
			Log.info(t.getMessage());
			Reporter.log("Start Workflow Test Failed");
			Log.endTestCase("Start Workflow Test Failed");
			Assert.fail(t.getMessage());
		}
		return itemsToReturnRFR;
	}
	
}
