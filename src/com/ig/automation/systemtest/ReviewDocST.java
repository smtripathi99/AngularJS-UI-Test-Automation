package com.ig.automation.systemtest;

import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ig.automation.coreactions.DataActions;
import com.ig.automation.screens.CheckinScreen;
import com.ig.automation.screens.ContentManagementScreen;
import com.ig.automation.screens.CreateCRScreen;
import com.ig.automation.screens.HomeScreen;
import com.ig.automation.screens.InboxScreen;
import com.ig.automation.screens.SystemTestScreen;
import com.ig.automation.screens.WorkflowScreen;
import com.ig.automation.test.ChangeLifeCycleStateTest;
import com.ig.automation.test.CheckinTest;
import com.ig.automation.test.CreateCRTest;
import com.ig.automation.test.CreateDocumentTest;
import com.ig.automation.test.ExportDocumentTest;
import com.ig.automation.test.LoginTest;
import com.ig.automation.test.SearchTest;
import com.ig.automation.test.WorkFlowRFATest;
import com.ig.automation.test.WorkFlowRFRTest;
import com.ig.automation.utility.Log;

public class ReviewDocST extends SystemTestScreen {
	
	LoginTest loginTest = new LoginTest();
	HomeScreen homeScreen = new HomeScreen();
	ContentManagementScreen contentMngScreen = new ContentManagementScreen();
	CreateDocumentTest createDocumentTest = new CreateDocumentTest();
	WorkFlowRFRTest workFlowRFRTest = new WorkFlowRFRTest();
	ContentManagementScreen contentManScreen = new ContentManagementScreen();
	CheckinTest checkinTest = new CheckinTest();
	CreateCRScreen createCRScreen = new CreateCRScreen();
	CreateCRTest crTest = new CreateCRTest();
	InboxScreen inboxScreen = new InboxScreen();
	SystemTestScreen systemTestScreen = new SystemTestScreen();
	WorkFlowRFATest workFlowRFATest = new WorkFlowRFATest();
	SearchTest searchTest = new SearchTest();
	ChangeLifeCycleStateTest changeLifeCycleStateTest = new ChangeLifeCycleStateTest();
	ExportDocumentTest exportDocumentTest = new ExportDocumentTest();
	String documentA = null;
	String documentB = null;
	String documentC = null;
	
	
	@BeforeClass
	public void login() throws Exception{
		loginTest.launchUrl();
		String username = "author01";
		String password = "password";
		loginTest.doLogin(username, password);
		Thread.sleep (2000);
		Log.info(username + ": is able to log in Successfully.");
	}
	
	@Test
	public void reviewDocSTTest(){
		Actions action = new Actions(driver);
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("System Test");
		try {
			clickCDSlink();
			documentA=createDocumentTest.doCreateDocument("Core Data Sheet", "Document A", "United States", "English", "", "", "", "Alkaline Aqua");
			Log.info("Document A : " + documentA + " is created sucessfully.");
			
			//do Change Request and promote to IA state
			crTest.doInitializrCR();//6
			String docIdCR= crTest.doCreateCRMandatory("Document A", "Other", "Austria", "English", "High");
			Log.info("A change request document for Document A is created.Document Id : " + docIdCR);
			String successMsg = changeLifeCycleStateTest.doChangeStateDrafttoIA(documentA);
			Assert.assertEquals(successMsg.contains("success"), true, "Document A is promoted to internally Approved state.");
			Log.info("Document A is promoted to internally Approved state.");//6
		
			//RFA
			List<String> workFlowRFADetails = workFlowRFATest.doTestWorkflowRFA("ST-026" , "description");//11
			Assert.assertTrue(workFlowRFADetails.get(0).equals("Start workflow"), "SR-WF-1 : Start Workflow screen is displayed.");
			Log.info("SR-WF-1 : Start Workflow screen is displayed.");
			Log.info("SR-WF-4 : Date is Selected Successfully.");
			Assert.assertTrue(workFlowRFADetails.get(2).equals("description"), "SR-WF-4 : Description is Selected Successfully.");
			Log.info("SR-WF-4 : Description is Selected Successfully."); 
			Assert.assertTrue(workFlowRFADetails.get(3).contains("author"), "SR-WF-3 : Task Performer is entered.");
			Log.info("SR-WF-3 : Task Performer is entered.");
			Log.info("Comments are added to the workflow.");
			
			String status = driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[1]/div[1]/div/div[4]/div[3]/div[7]/div/div")).getText();
			Assert.assertTrue(status.equals("Draft"), "The status of Document : " + documentA + "is 'Draft'.");
			Log.info("The status of Document " + documentA + "is 'Draft'."); //11
			
			
			//TODO Steps 12 & 13 --> GLM-1360 -  "I am currently unavailable" link is not being displayed on Inbox screen
			clickCDSlink();
			documentB=createDocumentTest.doCreateDocument("Core Data Sheet", "Document B", "United States", "English", "", "", "", "Alkaline Aqua");
			Log.info("Document Id for document B is : " + documentB);
			
			String message = checkinTest.doCheckin("ST-026", documentB, "");
			Assert.assertEquals(message.contains("success"), true);
			Log.info("SR-EV-18 : Document is checked in as a new minor version."); //16
			
			homeScreen.initializeLeftNavigationObjects();
			homeScreen.logOff.click();
			
			String username2 = "appmanager01";
			String password2 = "password";
			loginTest.doLogin(username2, password2); 
			Log.info("Login Successful " + username2 + "" + "user is logged in");
			searchTest.doSearchDocument(documentB); 
			
			crTest.doInitializrCR();
			String docIdCR1= crTest.doCreateCRMandatory("Other","Test CR", "Austria", "English", "High");
			Log.info("A change request document for Document B version 0.2 is created and promoted to the Internally Approved state for Document Id : " + docIdCR1);
			String successMsgForCR = changeLifeCycleStateTest.doChangeStateDrafttoIA(documentB);
			Assert.assertEquals(successMsgForCR.contains("success"), true, "Document B is promoted to Internally Approved State.");
			Log.info("Document B is promoted to internally Approved state.");//18
		
			homeScreen.initializeLeftNavigationObjects();
			homeScreen.logOff.click();
			String username3 = "author01";
			String password3 = "password";
			loginTest.doLogin(username3, password3); 
			Log.info("Login Successful " + username3 + "" + "user is logged in");//19
			
			searchTest.doSearchDocument(documentB); 
			
			List<String> workFlowRFRDetails = workFlowRFRTest.doTestWorkFlowRFR("ST-026","Description for RFR");//21
			Assert.assertTrue(workFlowRFRDetails.get(0).equals("Start workflow"), "Start Workflow screen is displayed.");
			Log.info("SR-WF-1 : Start Workflow screen is displayed.");
			Log.info("SR-WF-3 : Date is Selected Successfully.");
			Assert.assertTrue(workFlowRFRDetails.get(2).equals("description"), "SR-WF-3 : Description is Selected Successfully.");
			Log.info("SR-WF-3 : Description is Selected Successfully."); 
			/*Assert.assertTrue(workFlowRFRDetails.get(3).contains("author"), "SR-WF-3 : Task Performer is entered.");
			Log.info("SR-WF-3 : Task Performer is entered.");
			Log.info("Comments are added to the workflow.");*/
		
			//Audit Trail
			
			//TODO : GLM-1352 My Workflows menu option is not being displayed under Process Management link. Line No -> 24 - 27
			//depends on the previous step -- need to update
			checkNotification();//28
			//TODO : GLM-1352 My Workflows menu option is not being displayed under Process Management link. Line No -> 29
			
			homeScreen.logOff.click();
			String username4 = "author01";
			String password4 = "password";
			loginTest.doLogin(username4, password4); 
			Log.info("Login Successful " + username4 + "" + "user is logged in");//30
			
			clickCDSlink();
			documentC=createDocumentTest.doCreateDocument("Core Data Sheet", "Document C", "United States", "English", "", "", "", "Alkaline Aqua");
			Log.info("Document Id for Document C is : " + documentC);
			
			String messageDocumentC = checkinTest.doCheckin("ST-026", documentC , "");
			Assert.assertEquals(messageDocumentC.contains("success"), true);
			Log.info("SR-EV-18 : Document is checked in as a new minor version."); //32-33
			
			homeScreen.initializeLeftNavigationObjects();
			homeScreen.logOff.click();
			String username5 = "appmanager01";
			String password5 = "password";
			loginTest.doLogin(username5, password5); 
			Log.info("Login Successful " + username5 + "" + "user is logged in");
			
			searchTest.doSearchDocument(documentC); 
			
			//do Change Request and promote to IA state
			crTest.doInitializrCR();//35
			String docIdCRDocC= crTest.doCreateCRMandatory("Document C", "Other", "Austria", "English", "High");
			Log.info("A change request document for Document C is created.Document Id : " + docIdCRDocC);
			String successMsgDocC = changeLifeCycleStateTest.doChangeStateDrafttoIA(documentC);
			Assert.assertEquals(successMsgDocC.contains("success"), true, "Document C is promoted to internally Approved state.");
			Log.info("Document C is promoted to internally Approved state.");//35
			
			//RFA
			List<String> workFlowRFADetailsDocC = workFlowRFATest.doTestWorkflowRFA("ST-026" , "Description Doc C");//11
			Assert.assertTrue(workFlowRFADetailsDocC.get(0).equals("Start workflow"), "SR-WF-1 : Start Workflow screen is displayed.");
			Log.info("SR-WF-1 : Start Workflow screen is displayed.");
			Log.info("SR-WF-4 : Date is Selected Successfully.");
			Assert.assertTrue(workFlowRFADetailsDocC.get(2).equals("description"), "SR-WF-4 : Description is Selected Successfully.");
			Log.info("SR-WF-4 : Description is Selected Successfully."); 
			Assert.assertTrue(workFlowRFADetailsDocC.get(3).contains("author"), "SR-WF-3 : Task Performer is entered.");
			Log.info("SR-WF-3 : Task Performer is entered.");
			Log.info("Comments are added to the workflow.");
			
			//Log.info("SR-WF-5 - Workflow initiated and the document is promoted to the appropriate lifecycle state.");
			
			// Audit Trail - 39
			
			homeScreen.logOff.click();
			String username6 = "author01";
			String password6 = "password";
			loginTest.doLogin(username6, password6); 
			Log.info("Login Successful " + username6 + "" + "user is logged in");
			
			inboxScreen.inilializeInboxLink();
			inboxScreen.inbox.click();
			
		//	TODO : GLM-1383	GLM-749 Search Document functionality is not working for Inbox.
		//	TODO : GLM-1361	GLM-749 On clicking Delete button on the Inbox screen no action is being performed .
			
			List<String> itemsToValidate = workFlowRFATest.doForwardTaskTest("ST-026");
			Assert.assertTrue(itemsToValidate.get(0).equals("author01"), "SR-RC-1 : The user has signed off on the task by entering his username and password.");
			Log.info("SR-RC-1 : The user has signed off on the task by entering his username and password.");
			Log.info("SR-RC-2 : User has signed off electronically.");
		//doc no longer exist in workflow,
			
			homeScreen.initializeLeftNavigationObjects();
			homeScreen.logOff.click();
			loginTest.doLogin(username5, password5); 
			Log.info("Login Successful " + username5 + "" + "user is logged in");
			
			inboxScreen.inilializeInboxLink();
			inboxScreen.inbox.click();
			//search task
			
			workFlowRFATest.doFinishtask();
			searchTest.doSearchDocument(documentC); 
			String statusA = driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[1]/div[1]/div/div[4]/div[3]/div[7]/div/div")).getText();
			Assert.assertTrue(statusA.equals("Approved"), "The status of Document C has been promoted to “Approved”.");
			Log.info("The status of Document C has been promoted to “Approved”.");
			getScreenShot("ST-026", "approved");
			
			
			exportDocumentTest.doExport();
			Log.info("Manual test");
			
		}catch (Throwable t) {
			Log.info(t.getMessage());
			Reporter.log("xmL-UI-ADS-006.doc Create Document tested Failed");
			Log.endTestCase("Create Document");
			Assert.fail(t.getMessage());
		}
	}
	
	public void clickCDSlink() throws InterruptedException{
		homeScreen.initializeLeftNavigationObjects();
		homeScreen.actions.click();
		Thread.sleep(2000);
		homeScreen.initializeActionObjects();
		homeScreen.createDoc.click();
		Thread.sleep(2000);
		contentMngScreen.initializeCDS();
		contentMngScreen.cdsLink.click();
		Thread.sleep(2000);
	}
	
	public void checkNotification(){
		try {
			inboxScreen.notificationTab.click();
			Thread.sleep(2000);
			getScreenShot("Inbox", "Inbox_NotificationTab");
			inboxScreen.initializeNotificationTab();
			//double click
			inboxScreen.initializeNotificationDetailPanel();
			inboxScreen.deleteButton.click();
			Thread.sleep(2000);//28
			//todo -
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
}
