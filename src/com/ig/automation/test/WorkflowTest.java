package com.ig.automation.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import com.ig.automation.screens.WorkflowScreen;
import com.ig.automation.utility.Log;


public class WorkflowTest extends WorkflowScreen {

	HomeTest homeTest = new HomeTest();

	@BeforeMethod
	public void login() {
		try {
			homeTest.testHome();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Route for Approval helper of UI 7.0 for ST automation
	 * 
	 * @throws Exception If an error occurs.
	 * 
	 */

	public String selectWorkflowTemplate(String docid) throws Exception {
		try {
			initializeSearch();
			searchDoc.click();
			initializeBasicSearch();
			basicSearch.click();
			initializeDocIDSearch();
			Thread.sleep(2000);
			docIDSearchdropdown.selectByVisibleText("=");
			enterDocIDbox.clear();
			enterDocIDbox.sendKeys(docid);
			Thread.sleep(3000);
			searchButton.click();
			Thread.sleep(3000);
			initializeDocument();
			filterDocID.click();
			initializeAction();
			workflow.click();
			initializeRFA();
			rfa.click();
			return "Workflow template found";

		} catch (Throwable e) {
			Log.info(e.getMessage());
			return "No workflow template found";

		}
	}

	public String startWorkflow() throws Exception {
		try {
			
			initializeWFTemplate();			
			if(wftempalte!=null){
				//getScreenShot(folder, fileName);
				wftempalte.click();
				initializeNext();
				nextBtn.click();
				initializeStartWF();
				date.sendKeys(getFutureDate(1));
				desc.sendKeys("Test workflow");
				selectPerformer.click();
				doneBtn.click();
				startWF.click();
				initializeMessages();
				return message.getText();
			}
			initializeErrorMessages();
			if (errorMessage!=null){
				//getScreenShot(folder, fileName);
				return errorMessage.getText();
			}
			return "Workflow started";

		} catch (Throwable e) {
			Log.info(e.getMessage());
			return "Workflow could not be started";
		}
	}
	/**
	 * Approve Workflow helper of UI 7.0 for ST automation
	 * 
	 * @throws Exception If an error occurs.
	 * 
	 */
	public void doApproveWorkFlow(String docid) throws Exception {
		try {
			homeTest.inbox.click();
			initializeInboxSearch();
			searchInbox.click();
			searchInboxEnter.click();
			searchInboxEnter.sendKeys(docid);
			initializeInboxAction();
			inboxDoc.click();
			accept.click();
		} catch (Throwable e) {
			Log.info(e.getMessage());

		}
	}

	

	/*
	 * @AfterClass public void tearDown() throws Exception{ driver.close(); driver.quit(); System.out.println("Passed:Login screen is tested successfully."); }
	 */
}
