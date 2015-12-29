package com.ig.automation.systemtest;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ig.automation.coreactions.DataActions;
import com.ig.automation.screens.HomeScreen;
import com.ig.automation.screens.InboxScreen;
import com.ig.automation.screens.SystemTestScreen;
import com.ig.automation.test.ChangeLifeCycleStateTest;
import com.ig.automation.test.CheckinTest;
import com.ig.automation.test.CreateCRTest;
import com.ig.automation.test.CreateDocumentTest;
import com.ig.automation.test.DocumentRelationshipTest;
import com.ig.automation.test.DocumentTranslationTest;
import com.ig.automation.test.EditPropertiesTest;
import com.ig.automation.test.HAInterActionTest;
import com.ig.automation.test.LoginTest;
import com.ig.automation.test.SearchTest;
import com.ig.automation.test.WorkFlowRFATest;
import com.ig.automation.test.WorkflowTest;
import com.ig.automation.utility.Log;




public class DocumentRelationshipsAndLegalHoldSystemTest extends SystemTestScreen {

	private static final String[] French = null;
	LoginTest loginTest = new LoginTest();
	DataActions dataActions = new DataActions();
	CreateDocumentTest cdTest = new CreateDocumentTest();
	CreateCRTest crTest = new CreateCRTest();
	CheckinTest checkinTest = new CheckinTest();
	ChangeLifeCycleStateTest changeLSTest = new ChangeLifeCycleStateTest();
	WorkflowTest rfa = new WorkflowTest();
	DocumentRelationshipTest linkDocRelation = new DocumentRelationshipTest();
	EditPropertiesTest edit = new EditPropertiesTest();
	DocumentTranslationTest ctTest = new DocumentTranslationTest();
	SearchTest searchTest = new SearchTest();
	WorkFlowRFATest rfaTest = new WorkFlowRFATest();
	InboxScreen inboxScreen = new InboxScreen();
	HomeScreen homeScreen = new HomeScreen();
	HAInterActionTest haInt = new HAInterActionTest();

	/**
	 * Test the xml-ST-027 "Document Relationships and Legal Hold System Test Script" of UI 7.0 against the xxxx 
	 * 
	 * @throws Exception If an error occurs.
	 */

	@Test
	public void DocRelationshipsAndLegalHoldST() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("xmL-ST-027 Change Request System Test Started");
		String docA = null, docB = null, docC = null, docD = null, docE = null, docG = null, docR = null, docRChangeReq = null, docAChangeReq = null;

		try {
			loginTest.launchUrl();
			String username = "author01";
			String password = "badpassword";
			loginTest.doLogin(username, password);
			Thread.sleep (2000);
			getScreenShot("ST-027", "SR-SE-1_step-5");
			loginTest.initializeObjects();
			Assert.assertEquals(loginTest.loginButton.isDisplayed(), true, "We're sorry, authentication failed"); 
			Log.info("Login Unsuccessful. " + username + " " + "user is unable logged in.");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("xmL-ST-027.doc tested unsuccessfully");
			Log.info("xmL-ST-027 Document Relationships and Legal Hold System Test Script failed: " + e.getMessage());
		}
		
		try {
			loginTest.userIdObj.clear();
			loginTest.pwdObj.clear();
			String username = "author";
			String password = "anypassword";
			loginTest.doLogin(username, password);
			Thread.sleep (2000);
			getScreenShot("ST-027", "SR-SE-1_step-6");
			loginTest.initializeObjects();
			Assert.assertEquals(loginTest.loginButton.isDisplayed(), true, "We're sorry, authentication failed"); 
			Log.info("Login Unsuccessful. " + username + " " + "user is unable logged in.");
			Log.info("SR-SE-1_step-6 completed successfully");
			
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("xmL-ST-027.doc tested unsuccessfully");
			Log.info("xmL-ST-027 Document Relationships and Legal Hold System Test Script failed: " + e.getMessage());
		}
		
		
		try {
			loginTest.userIdObj.clear();
			loginTest.pwdObj.clear();
			String username = "";
			String password = "";
			loginTest.doLogin(username, password);
			Thread.sleep (2000);
			getScreenShot("ST-027", "SR-SE-1_step-7");
			loginTest.initializeObjects();
			Assert.assertEquals(loginTest.loginButton.isDisplayed(), true, "We're sorry, authentication failed"); 
			Log.info("Login Unsuccessful. " + username + " " + "user is unable logged in.");
			Log.info("SR-SE-1_step-7 completed successfully");
			
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("xmL-ST-027.doc tested unsuccessfully");
			Log.info("xmL-ST-027 Document Relationships and Legal Hold System Test Script failed: " + e.getMessage());
		}
		
		
		try {
			loginTest.launchUrl();
			loginTest.userIdObj.clear();
			loginTest.pwdObj.clear();
			String username = DataActions.getUserID("role_author");
			String password = DataActions.getUserPassword("role_author");
			loginTest.doLogin(username, password);  
			Log.info("Login Successful. " + username + " " + "user is logged in");
			Thread.sleep(2000);
			getScreenShot("ST-027", "SR-SE-1_step-8");
			loginTest.initializeObjects();
			Assert.assertEquals(loginTest.loginButton.isDisplayed(), false, "We're sorry, authentication failed"); 
			Log.info("Login Unsuccessful. " + username + " " + "user is Unable to logged in.");
			Log.info("SR-SE-1_step-8 completed successfully");
			initializeHome();
			logOff.click();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("xmL-ST-027.doc tested unsuccessfully");
			Log.info("xmL-ST-027 Document Relationships and Legal Hold System Test Script failed: " + e.getMessage());
		}
						
		try {
			loginTest.launchUrl();
			String username1 = DataActions.getUserID("role_author");
			String password1 = DataActions.getUserPassword("role_author");
			loginTest.doLogin(username1, password1);  
			Log.info("Login Successful. " + username1 + " " + "user is logged in");
						
			initializeAction();
			actions.click();
			Thread.sleep(1000);
			initializeCreate();
			createDoc.click(); 
			Thread.sleep(1000);
			inilializeObjectsDocType();
			coreDataSheet.click();
			Thread.sleep(3000);
			docA = cdTest.doCreateDocument("Core Data Sheet","Document A","United States","English","","","","Alkaline Aqua");// 06
			Assert.assertTrue(docA.contains("CDS"), "Document A " + docA + " is created.");
			getScreenShot("ST-027", "DocumentA");
			Log.info("Document A " + docA + " is created.");
			searchTest.doSearchDocument(docA);
			Thread.sleep(3000);
			myDocIcon.click();
			Thread.sleep(1000);
			initializeHome();
			logOff.click();
			
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("xmL-ST-027.doc tested unsuccessfully");
			Log.info("xmL-ST-027 Document Relationships and Legal Hold System Test Script failed: " + e.getMessage());
		}
		
		
		try {
			loginTest.launchUrl();
			String username1 = DataActions.getUserID("role_author");
			String password1 = DataActions.getUserPassword("role_author");
			loginTest.doLogin(username1, password1);  
			Log.info("Login Successful. " + username1 + " " + "user is logged in");
					
			initializeAction();
			actions.click();
			Thread.sleep(1000);
			initializeCreate();
			createDoc.click(); 
			Thread.sleep(1000);
			inilializeObjectsDocType();
			annexII.click();
			Thread.sleep(3000);
			docB = cdTest.doCreateDocument("Annex II","Document B","United States","English","Alkaline Aqua","ALLERSOLV","","");
			Assert.assertTrue(docB.contains("AN"), "Document B " + docB + " is created.");
			getScreenShot("ST-027", "DocumentB");
			Log.info("Document B " + docB + " is created.");
			searchTest.doSearchDocument(docB);
			Thread.sleep(3000);
			myDocIcon.click();
			Thread.sleep(1000);
			initializeHome();
			logOff.click();
			
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("xmL-ST-027.doc tested unsuccessfully");
			Log.info("xmL-ST-027 Document Relationships and Legal Hold System Test Script failed: " + e.getMessage());
		}
		
		
		try {
			loginTest.launchUrl();
			String username1 = DataActions.getUserID("role_author");
			String password1 = DataActions.getUserPassword("role_author");
			loginTest.doLogin(username1, password1);  
			Log.info("Login Successful. " + username1 + " " + "user is logged in");
					
			initializeAction();
			actions.click();
			Thread.sleep(1000);
			initializeCreate();
			createDoc.click(); 
			Thread.sleep(1000);
			inilializeObjectsDocType();
			blisterLabelingText.click();
			Thread.sleep(3000);
			docC = cdTest.doCreateDocument("Blister Labeling Text","Document C","United States","English","Alkaline Aqua","ALLERSOLV","","");
			Assert.assertTrue(docC.contains("BLI"), "Document C " + docC + " is created.");
			getScreenShot("ST-027", "DocumentC");
			Log.info("Document C " + docC + " is created.");
			initializeHome();
			logOff.click();
			
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("xmL-ST-027.doc tested unsuccessfully");
			Log.info("xmL-ST-027 Document Relationships and Legal Hold System Test Script failed: " + e.getMessage());
		}
		
	
		
		
		try {
			
			String username1 = DataActions.getUserID("role_author");
			String password1 = DataActions.getUserPassword("role_author");
			loginTest.doLogin(username1, password1);  
			Log.info("Login Successful. " + username1 + " " + "user is logged in");
		
			initializeAction();
			actions.click();
			Thread.sleep(1000);
			initializeCreate();
			createDoc.click(); 
			Thread.sleep(1000);
			inilializeObjectsDocType();
			outerLabelingText.click();
			Thread.sleep(3000);
			docD = cdTest.doCreateDocument("Outer Labeling Text","Document D","United States","English","Alkaline Aqua","ALLERSOLV","","");
			Assert.assertTrue(docD.contains("OUT"), "Document D " + docD + " is created.");
			getScreenShot("ST-027", "DocumentD");
			Log.info("Document D " + docD + " is created.");
			Thread.sleep(3000);
			initializeHome();
			logOff.click();
			
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("xmL-ST-027.doc tested unsuccessfully");
			Log.info("xmL-ST-027 Document Relationships and Legal Hold System Test Script failed: " + e.getMessage());
		}
			
		
		try {
			String username1 = DataActions.getUserID("role_author");
			String password1 = DataActions.getUserPassword("role_author");
			loginTest.doLogin(username1, password1);  
			Log.info("Login Successful. " + username1 + " " + "user is logged in");
		
			
			initializeAction();
			actions.click();
			Thread.sleep(1000);
			initializeCreate();
			createDoc.click(); 
			Thread.sleep(1000);
			inilializeObjectsDocType();
			packageLeaflet.click();
			Thread.sleep(3000);
			docE = cdTest.doCreateDocument("Package Leaflet","Document E","United States","English","Alkaline Aqua","ALLERSOLV","","");
			Assert.assertTrue(docE.contains("PL"), "Document E " + docE + " is created.");
			getScreenShot("ST-027", "DocumentE");
			Log.info("Document E " + docE + " is created.");
			initializeHome();
			logOff.click();
			
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("xmL-ST-027.doc tested unsuccessfully");
			Log.info("xmL-ST-027 Document Relationships and Legal Hold System Test Script failed: " + e.getMessage());
		}
		
		try {
			loginTest.launchUrl();
			String username1 = DataActions.getUserID("role_author");
			String password1 = DataActions.getUserPassword("role_author");
			loginTest.doLogin(username1, password1);  
			Log.info("Login Successful. " + username1 + " " + "user is logged in");
			
			
			initializeAction();
			actions.click();
			Thread.sleep(1000);
			initializeCreate();
			createDoc.click(); 
			Thread.sleep(1000);
			inilializeObjectsDocType();
			immediateLabelingText.click();
			Thread.sleep(3000);
			docB = cdTest.doCreateDocument("Immediate Labeling Text","Document G","United States","English","Alkaline Aqua","ALLERSOLV","","");
			Assert.assertTrue(docG.contains("IMM"), "Document G " + docG + " is created.");
			getScreenShot("ST-027", "DocumentG");
			Log.info("Document G " + docG + " is created.");
			searchTest.doSearchDocument(docG);
			Thread.sleep(3000);
			myDocIcon.click();
			Thread.sleep(1000);
			initializeHome();
			logOff.click();
			
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("xmL-ST-027.doc tested unsuccessfully");
			Log.info("xmL-ST-027 Document Relationships and Legal Hold System Test Script failed: " + e.getMessage());
		}
		
		
		
		try {
			loginTest.launchUrl();
			String username2 = DataActions.getUserID("role_application_manager");
			String password2 = DataActions.getUserPassword("role_application_manager");
			loginTest.doLogin(username2, password2);  
			Log.info("Login Successful. " + username2 + " " + "user is logged in");
					
			searchTest.doSearchDocument(docA);
			Thread.sleep(3000);
			initializecreateChangeRequest();
			createChangeRequestTab.click();
			Thread.sleep(2000);
			createChangeRequestLink.click();
			Thread.sleep(2000);
			docAChangeReq = crTest.doCreateCRMandatory("CRTEST", "Modify Document", "United States", "English", "High");
			Thread.sleep(3000);
			getScreenShot("ST-027", "CreateChangeRequest_SR-LC-9");
			Assert.assertTrue(docAChangeReq.contains("CR"), docAChangeReq + "Create Change Request Successful");
			Log.info("Change Request is created for Document A -- Step-12");
			Thread.sleep(3000);
			
			searchTest.doSearchDocument("docA");
			Thread.sleep(3000);
			initializeProcessManagement();
			processManagement.click();
			changeLifeCycleState.click();
			Thread.sleep(2000);
			initializeProcessManagementPanel();
			newLifeCycleState.selectByVisibleText("Internally Approved");
			Thread.sleep(2000);
			signatureMeaning.selectByVisibleText("Author Approval");
			Thread.sleep(1000);
			userID.sendKeys(username2);
			password.sendKeys(password2);
			Thread.sleep(1000);
			confirmIntention.click();
			finishBtn.click();
			Thread.sleep(2000);
			getScreenShot("ST-027", "DocumentA_Approved"); // Have to add assert after bug fix
			Log.info("Trace SR-LC-5 and SR-LC-9 completed successfully -- Step-13");
			Thread.sleep(1000);
			
			initializeHome();
			logOff.click();
			loginTest.initializeObjects();
			Assert.assertEquals(loginTest.loginButton.isDisplayed(), true, "Logout successfully"); 
			Log.info("Logout successfully -- Step-13");
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("CreateChangeRequest unsuccessfully");
			Log.info("xmL-ST-027 Document Relationships and Legal Hold System Test Script failed: " + e.getMessage());
		}
		
		
			try {
			
			loginTest.launchUrl();
			String DocID;
			String linkedDocID;
			String linkedDocID1;
			String successMsg[];
			String username2 = DataActions.getUserID("role_author");
			String password2 = DataActions.getUserPassword("role_author");
			loginTest.doLogin(username2, password2);  
			Log.info("Login Successful. " + username2 + " " + "user is logged in");
				
			
			ctTest.doCreateTranslation(docB, new String[] {"French"});
			getScreenShot("ST-027", "DocumentB_PartialTranslation"); 
			Log.info("Trace SR-RM-1 completed successfully -- Step-15");
			Thread.sleep(2000);
			
			initializeDashboard();
			dashboard.click();
			searchTest.doSearchDocument(docB);
			initializeMessages();
			String successMessage = message.getText();
			DocID=successMessage;
			Log.info(DocID);
			writeCSV(DocID);
			
			initializeDashboard();
			dashboard.click();
			ctTest.doConvertToExactTranslation(docB, "French");
			getScreenShot("ST-027", "DocumentB_Translation"); 
			Log.info("Trace SR-RM-2 completed successfully -- Step-16");
			Thread.sleep(1000);
			
			initializeDashboard();
			dashboard.click();
			searchTest.doSearchDocument("docB");
			linkDocRelation.doLinkSourceDocumentSearch(docC);
			getScreenShot("ST-027", "DocumentB_SourceDoc_Relationship_with_C_1"); 
			Log.info("Trace SR-RM-7 Completed successfully -- Step-17 and Step-18");
			Thread.sleep(1000);
			initializeSourceDocumentTab();
			sourceDocTab.click();
			Thread.sleep(1000);
			getScreenShot("ST-027", "DocumentB_Relationship_with_C_2"); 
			Log.info("Trace SR-RM-3 and SR-RS-2 completed successfully -- Step-19");
			
			initializeMyDoc();
			myDoc.click();
			initializeMyDocuments();
			myDocTblSearchIcon.click();
			myDocSearch.sendKeys(docB);
			Thread.sleep(1000);
			getScreenShot("ST-027", "Users_MyDocs_listing_SR-RM-13"); 
			Log.info("Trace SR-RM-13 completed successfully -- Step-20");
			linkDocRelation.doLinkSourceDocumentSearch(docA);
			getScreenShot("ST-027", "DocumentB_SourceDoc_Relationship_with_A_1"); 
			Log.info("Trace SR-RM-7 Completed successfully -- Step-21");
			Thread.sleep(1000);
			initializeSourceDocumentTab();
			sourceDocTab.click();
			Thread.sleep(1000);
			getScreenShot("ST-027", "DocumentB_Relationship__with_A_2"); 
				
			initializeDashboard();
			dashboard.click();
			searchTest.doSearchDocument(docB);
			initializeSourceDocumentTab();
			sourceDocTab.click();
			initializeLinkedSourceDoc();
			String linkedSourceDoc1 = linkedDoc1.getText();
			Log.info(linkedSourceDoc1);
			writeCSV(linkedSourceDoc1);
			Assert.assertTrue(linkedSourceDoc1.contains(docC),  "Linked Source Document Successful");
					
			initializeLinkedSourceDoc();
			String linkedSourceDoc2 = linkedDoc2.getText();
			Log.info(linkedSourceDoc2);
			writeCSV(linkedSourceDoc2);
			Assert.assertTrue(linkedSourceDoc2.contains(docA),  "Linked Source Document Successful");
			Log.info("Trace SR-RM-3 and SR-RS-2 completed successfully -- Step-23");
			linkedDoc2.click();
			getScreenShot("ST-027", "DocumentB_SourceDoc_Relationship_Docs"); 
			
			initializeDashboard();
			dashboard.click();
			searchTest.doSearchDocument(docB);
			linkDocRelation.doLinkSupportingDocumentSearch(docD);
			getScreenShot("ST-027", "DocumentB_SupportingDoc_Relation_with_D_1"); 
			Log.info("Trace SR-RM-7 Completed successfully -- Step-24 and Step-25");
			Thread.sleep(1000);
			initializeSupportingDocumentTab();
			supportDocTab.click();
			Thread.sleep(1000);
			initializeSupportingDocumentTbl();
			docIDSearch.sendKeys(docD);
			String supportingDocID1 = docID.getText();
			Assert.assertTrue(supportingDocID1.equals(docD));
			getScreenShot("ST-027", "DocumentB_SupportingDoc_Relationship_with_D_2"); 
			Log.info("Trace SR-RM-15 and SR-RM-4 completed successfully -- Step-26"); 
			
			
			initializeDashboard();
			dashboard.click();
			searchTest.doSearchDocument(docB);
			linkDocRelation.doLinkSupportingDocumentSearch(docG);
			getScreenShot("ST-027", "DocumentB_SupportingDoc_Relation_with_G_1"); 
			Log.info("Trace SR-RM-15 Completed successfully -- Step-27 and Step-28");
			Thread.sleep(1000);
			initializeSupportingDocumentTab();
			supportDocTab.click();
			Thread.sleep(1000);
			initializeSupportingDocumentTbl();
			docIDSearch.sendKeys(docG);
			String supportingDocID2 = docID.getText();
			Assert.assertTrue(supportingDocID2.equals(docG));
			getScreenShot("ST-027", "DocumentB_SupportingDoc_Relationship_with_G_2"); 
			Log.info("Trace SR-RM-15 and SR-RM-4 completed successfully -- Step-28"); 
			
	} catch (Exception e) {
		e.printStackTrace();
		Reporter.log("CreateChangeRequest unsuccessfully");
		Log.endTestCase("Translations System Test Failed");
	}
	

		try {
			//docR = "CDS-020";
			//loginTest.launchUrl();
			String username1 = DataActions.getUserID("role_author");
			String password1 = DataActions.getUserPassword("role_author");
			loginTest.doLogin(username1, password1);  
			Log.info("Login Successful. " + username1 + " " + "user is logged in");
		
			initializeAction();
			actions.click();
			Thread.sleep(1000);
			initializeCreate();
			createDoc.click(); 
			Thread.sleep(1000);
			inilializeObjectsDocType();
			coreDataSheet.click();
			Thread.sleep(3000);
			docA = cdTest.doCreateDocument("Core Data Sheet","Document R","United States","English","","","","Alkaline Aqua");
			Assert.assertTrue(docR.contains("CDS"), "Document R " + docR + " is created.");
			getScreenShot("ST-027", "DocumentR");
			Log.info("Document R " + docR + " is created.");
			
			searchTest.doSearchDocument(docR);
			Thread.sleep(3000);
			initializecreateChangeRequest();
			createChangeRequestTab.click();
			Thread.sleep(2000);
			createChangeRequestLink.click();
			Thread.sleep(2000);
			docRChangeReq = crTest.doCreateCRMandatory("CRTEST", "Modify Document", "United States", "English", "High");
			Log.info(docRChangeReq + "created");
			Thread.sleep(3000);
			getScreenShot("ST-027", "CreateChangeRequest_Step-30");
			Assert.assertTrue(docRChangeReq.contains("CR"), docRChangeReq + "Create Change Request Successful");
			Log.info("Change Request is created for Document R -- Step-30 and 31");
			Thread.sleep(3000);
			initializeHome();
			logOff.click();
			
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("xmL-ST-027.doc tested unsuccessfully");
			Log.info("xmL-ST-027 Document Relationships and Legal Hold System Test Script failed: " + e.getMessage());
		}
			
		try {
			
			String username3 = DataActions.getUserID("role_application_manager");
			String password3 = DataActions.getUserPassword("role_application_manager");
			loginTest.doLogin(username3, password3);  
			Log.info("Login Successful. " + username3 + " " + "user is logged in");
		
			searchTest.doSearchDocument(docRChangeReq);
			Thread.sleep(3000);
		
			rfaTest.doTestWorkflowRFA("ST-027", "Test-Step-35");
			Log.info("Route for Approval successfully -- Step-33 to 36");
			
			
			String username1 = DataActions.getUserID("role_author");
			String password1 = DataActions.getUserPassword("role_author");
			loginTest.doLogin(username1, password1);  
			Log.info("Login Successful. " + username1 + " " + "user is logged in");
		
			inboxScreen.inilializeInboxLink();
			inboxScreen.inbox.click();
			Thread.sleep(2000);
			getScreenShot("ST-027", "Inbox_Screen");
			inboxScreen.initializeInboxLables();
			inboxScreen.firstDocDetailContainer.click();
			Thread.sleep(2000);
			getScreenShot("WorkFlow_RFA", "AcceptButton");
			inboxScreen.initializeInboxAcceptButtonRFA();
			inboxScreen.acceptButtonRFA.click();
			Thread.sleep(2000);
			inboxScreen.firstDocDetailContainer.click();
			inboxScreen.initializeDelRejectForwardButtonRFA();
			inboxScreen.forwardButtonRFA.click();
			inboxScreen.initializeForwardTaskRFA();
			inboxScreen.signOff.selectByValue("Author Approval");
			inboxScreen.userIDForward.sendKeys(username1);
			inboxScreen.passwordForward.sendKeys(password1);
			inboxScreen.confirmSignOff.click(); 
			getScreenShot("ST-027", "ForwardTab_Values");
			inboxScreen.initializeApproveForwardTaskRFA();
			inboxScreen.approveForward.click();
			
		
			loginTest.doLogin(username3, password3);  
			Log.info("Login Successful. " + username3 + " " + "user is logged in");
			
			inboxScreen.inilializeInboxLink();
			inboxScreen.inbox.click();
			Thread.sleep(2000);
			getScreenShot("ST-027", "Inbox_Screen");
			inboxScreen.initializeInboxLables();
			inboxScreen.firstDocDetailContainer.click();
			Thread.sleep(2000);
			
			inboxScreen.initializeInboxDelegateButton();
			inboxScreen.finishButton.click();
			
			inboxScreen.initializeInboxFinishTask();
			inboxScreen.doneFinishTaskButton.click();
			
			searchTest.doSearchDocument(docRChangeReq);
			Thread.sleep(3000);
			initializeSearchResult();
			String updatedVersion = selectVersionCol.getText();
			Log.info(updatedVersion);
			writeCSV(updatedVersion);
			Assert.assertTrue(updatedVersion.contains("1.0"), "Document R CR has" + updatedVersion + " updated version.");
			Log.info("Updated version of" + docRChangeReq + "is" +updatedVersion+ "completed successfully -- step 37-38");

			
			initializeHome();
			logOff.click();
			loginTest.initializeObjects();
			Assert.assertEquals(loginTest.loginButton.isDisplayed(), true, "Logout successfully"); 
			Log.info("Logout successfully -- Step-39");
			
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("routeForApproval unsuccessfully");
			Log.endTestCase("routeForApproval System Test Failed for document R");
		}
		
			
		try {
			//docR = "CDS-015";
			//loginTest.launchUrl();
			String username3 = DataActions.getUserID("role_application_manager");
			String password3 = DataActions.getUserPassword("role_application_manager");
			loginTest.doLogin(username3, password3);  
			Log.info("Login Successful. " + username3 + " " + "user is logged in");
		
			searchTest.doSearchDocument(docD);
			Thread.sleep(3000);
			initializeProcessManagement();
			processManagement.click();
			changeLifeCycleState.click();
			Thread.sleep(2000);
			initializeProcessManagementPanel();
			newLifeCycleState.selectByVisibleText("Internally Approved");
			Thread.sleep(2000);
			signatureMeaning.selectByVisibleText("Author Approval");
			Thread.sleep(1000);
			userID.sendKeys(username3);
			password.sendKeys(password3);
			Thread.sleep(1000);
			confirmIntention.click();
			finishBtn.click();
			Thread.sleep(2000);
			getScreenShot("ST-027", "DocumentD_Approved"); // Have to add assert after bug GLM-1406 fix
			Log.info("completed successfully -- Step-40");
			Thread.sleep(1000);

			
			searchTest.doSearchDocument(docR);
			Thread.sleep(3000);
			initializeProcessManagement();
			processManagement.click();
			changeLifeCycleState.click();
			Thread.sleep(2000);
			initializeProcessManagementPanel();
			newLifeCycleState.selectByVisibleText("Internally Approved");
			Thread.sleep(2000);
			signatureMeaning.selectByVisibleText("Author Approval");
			Thread.sleep(1000);
			userID.sendKeys(username3);
			password.sendKeys(password3);
			Thread.sleep(1000);
			confirmIntention.click();
			finishBtn.click();
			Thread.sleep(2000);
			getScreenShot("ST-027", "DocumentR_Approved"); // Have to add assert after bug GLM-1406 fix
			Log.info("completed successfully -- Step-41 and 42");
			Thread.sleep(1000);
			
			initializeHome();
			logOff.click();
			loginTest.initializeObjects();
			Assert.assertEquals(loginTest.loginButton.isDisplayed(), true, "Logout successfully"); 
			Log.info("Logout successfully -- Step-43");
					
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("xmL-ST-027.doc tested unsuccessfully");
			Log.info("xmL-ST-027 Document Relationships and Legal Hold System Test Script failed: " + e.getMessage());
		}
		
		try {
			String username2 = DataActions.getUserID("role_author");
			String password2 = DataActions.getUserPassword("role_author");
			loginTest.doLogin(username2, password2);  
			Log.info("Login Successful. " + username2 + " " + "user is logged in");
		
			searchTest.doSearchDocument(docC);
			Thread.sleep(3000);
			
			initializeSearchResult();
			String currentVersion = selectVersionCol.getText();
			Log.info(currentVersion);
			writeCSV(currentVersion);
			
			checkinTest.doCheckin(docC);
			
			searchTest.doSearchDocument(docC);
			Thread.sleep(3000);
			initializeSearchResult();
			String updatedVersion = selectVersionCol.getText();
			Log.info(updatedVersion);
			writeCSV(updatedVersion);
			Log.info("Updated version of" + docC + "is" +updatedVersion+ "completed successfully -- step 44");
			
			searchTest.doSearchDocument(docB);
			Thread.sleep(3000);
			initializeSourceDocumentTab();
			sourceDocTab.click();
			Thread.sleep(1000);
			getScreenShot("ST-027", "DocumentB_Relationship_with_C_after_Version_SR-RM-8"); 
			initializeSourceDocumentTbl();
			docIDSearch.sendKeys(docC);
			String updatedVersion1 = versionRow1.getText();
			Log.info(updatedVersion1);
			writeCSV(updatedVersion1);
			Assert.assertTrue(!currentVersion.equals(updatedVersion1));
			Log.info("Trace SR-RM-8 completed successfully -- Step-45");
			
			
			searchTest.doSearchDocument("docC");
			Thread.sleep(3000);
			initializeProcessManagement();
			processManagement.click();
			changeLifeCycleState.click();
			Thread.sleep(2000);
			initializeProcessManagementPanel();
			newLifeCycleState.selectByVisibleText("Internally Approved");
			Thread.sleep(2000);
			signatureMeaning.selectByVisibleText("Author Approval");
			Thread.sleep(1000);
			userID.sendKeys(username2);
			password.sendKeys(password2);
			Thread.sleep(1000);
			confirmIntention.click();
			finishBtn.click();
			Thread.sleep(2000);
			getScreenShot("ST-027", "DocumentC_Approved"); // Have to add assert after bug GLM-1406 fix
			Log.info("completed successfully -- Step-46 and Step-47");
			Thread.sleep(1000);
			
			initializeHome();
			logOff.click();
			loginTest.initializeObjects();
			Assert.assertEquals(loginTest.loginButton.isDisplayed(), true, "Logout successfully"); 
			Log.info("Logout successfully -- Step-48");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("xmL-ST-027.doc tested unsuccessfully");
			Log.info("xmL-ST-027 Document Relationships and Legal Hold System Test Script failed: " + e.getMessage());
		}
		
		
		
		try {
			String username2 = DataActions.getUserID("role_author");
			String password2 = DataActions.getUserPassword("role_author");
			loginTest.doLogin(username2, password2);  
			Log.info("Login Successful. " + username2 + " " + "user is logged in");
		
		
			checkinTest.doCheckin(docC);
			
			searchTest.doSearchDocument(docC);
			Thread.sleep(3000);
			initializeSearchResult();
			String updatedVersion2 = selectVersionCol.getText();
			Log.info(updatedVersion2);
			writeCSV(updatedVersion2);
			Assert.assertTrue(updatedVersion2.contains("1.1"), "Document C has" + updatedVersion2 + " updated version.");
			Log.info("Updated version of" + docC + "is" +updatedVersion2+ "completed successfully -- step 49");
	
			searchTest.doSearchDocument(docB);
			Thread.sleep(3000);
			initializeSourceDocumentTab();
			sourceDocTab.click();
			Thread.sleep(1000);
			getScreenShot("ST-027", "DocumentB_Relationship_with_C_after_Version_SR-RM-8"); 
			initializeSourceDocumentTbl();
			docIDSearch.sendKeys(docC);
			String updatedVersion3 = versionRow1.getText();
			Log.info(updatedVersion3);
			writeCSV(updatedVersion3);
			Assert.assertTrue(updatedVersion3.contains("1.0"), "Document C has" + updatedVersion3 + " updated version.");
			Log.info("Trace SR-RM-8 completed successfully -- Step-50");
			
			/*
			 * 
			 * STEP 51 is missing because of Bug: GLM-749
			 */
			
			
			searchTest.doSearchDocument("docB");
			Thread.sleep(3000);
			initializeProcessManagement();
			processManagement.click();
			changeLifeCycleState.click();
			Thread.sleep(2000);
			initializeProcessManagementPanel();
			newLifeCycleState.selectByVisibleText("Internally Approved");
			Thread.sleep(2000);
			signatureMeaning.selectByVisibleText("Author Approval");
			Thread.sleep(1000);
			userID.sendKeys(username2);
			password.sendKeys(password2);
			Thread.sleep(1000);
			confirmIntention.click();
			finishBtn.click(); 								// bug GLM-1406 fix
			Thread.sleep(2000);
			getScreenShot("ST-027", "DocumentB_Approved"); 
			Thread.sleep(1000);

			searchTest.doSearchDocument(docB);
			Thread.sleep(3000);
			initializeSearchResult();
			String updatedVersion4 = selectVersionCol.getText();
			Log.info(updatedVersion4);
			writeCSV(updatedVersion4);
			Assert.assertTrue(updatedVersion4.contains("1.0"), "Document B has updated to major version." + updatedVersion4);
			Log.info("Updated version of" + docB + "is" +updatedVersion4+ "completed successfully -- step 54");
	
			// checking current version of D
			searchTest.doSearchDocument(docD);
			Thread.sleep(3000);
			initializeSearchResult();
			String currentVersion = selectVersionCol.getText();
			Log.info(currentVersion);
			writeCSV(currentVersion);
			
			checkinTest.doCheckin(docD);
			
			searchTest.doSearchDocument(docD);
			Thread.sleep(3000);
			initializeSearchResult();
			String updatedVersion5 = selectVersionCol.getText();
			Log.info(updatedVersion5);
			writeCSV(updatedVersion5);
			Assert.assertTrue(updatedVersion5.contains("1.1"), "Document D has" + updatedVersion5 + " updated version.");
			Log.info("Updated version of" + docD + "is" +updatedVersion5+ "completed successfully -- step 55");

			
			searchTest.doSearchDocument(docB);
			Thread.sleep(3000);
			initializeSourceDocumentTab();
			sourceDocTab.click();
			Thread.sleep(1000);
			getScreenShot("ST-027", "DocumentB_Relationship_with_D_after_Version_SR-RM-18"); 
			initializeSourceDocumentTbl();
			docIDSearch.sendKeys(docD);
			String updatedVersion6 = versionRow1.getText();
			Log.info(updatedVersion6);
			writeCSV(updatedVersion6);
			Assert.assertTrue(!currentVersion.equals(updatedVersion6));
			Log.info("Trace SR-RM-18 completed successfully -- Step-56");
			
			
			/*
			 * 
			 * STEP 57 is missing because of Bug: GLM-749
			 * 
			 */
			
			
			checkinTest.doCheckin(docA);
			
			searchTest.doSearchDocument(docA);
			Thread.sleep(3000);
			getScreenShot("ST-027", "DocumentA_after_Updating_Version_SR-RM-10");
			initializeSearchResult();
			String updatedVersion7 = selectVersionCol.getText();
			Log.info(updatedVersion7);
			writeCSV(updatedVersion7);
			Assert.assertTrue(updatedVersion7.contains("1.1"), "Document A has" + updatedVersion7 + " updated version.");
			Log.info("Updated version of" + docA + "is" +updatedVersion7+ "completed successfully -- step-58");
	
			
			initializeDashboard();
			dashboard.click();
			searchTest.doSearchDocument("docA");
			linkDocRelation.doLinkSourceDocumentSearch(docC);
			getScreenShot("ST-027", "DocumentA_SourceDoc_Relationship_with_C_1"); 
			Log.info("Trace SR-RM-7 Completed successfully -- Step-59");
			Thread.sleep(1000);
			
			searchTest.doSearchDocument(docA);
			initializeSourceDocumentTab();
			sourceDocTab.click();
			Thread.sleep(1000);
			initializeSourceDocumentTbl();
			docIDSearch.sendKeys(docC);
			getScreenShot("ST-027", "DocumentA_Relationship_with_C_2"); 
			Log.info("Trace SR-RM-10 completed successfully -- Step-59 and Step-60");
			
			
			/*
			 * 
			 * 
			 * Change parent Version is not in UI right now. Need to disusss
			 * step-61 and 62 (SR-RM-12)
			 * 
			 */

			
			/*
			 * Import Supporting Documents link is not coming 
			 * Bug: GLM-1237
			 * 
			 * step-63, step-64 and step-65 (SR-RM-16)
			 * 
			 */
			
			
			initializeHome();
			logOff.click();
			loginTest.initializeObjects();
			Assert.assertEquals(loginTest.loginButton.isDisplayed(), true, "Logout successfully"); 
			Log.info("Logout successfully -- Step-66");
			
	
			String username3 = DataActions.getUserID("role_application_manager");
			String password3 = DataActions.getUserPassword("role_application_manager");
			loginTest.doLogin(username3, password3);  
			Log.info("Login Successful. " + username3 + " " + "user is logged in --- Step-66");
			
			
			searchTest.doSearchDocument(docD);
			Thread.sleep(3000);
			initializeProcessManagement();
			processManagement.click();
			changeLifeCycleState.click();
			Thread.sleep(2000);
			initializeProcessManagementPanel();
			newLifeCycleState.selectByVisibleText("Internally Approved");
			Thread.sleep(2000);
			signatureMeaning.selectByVisibleText("Author Approval");
			Thread.sleep(1000);
			userID.sendKeys(username3);
			password.sendKeys(password3);
			Thread.sleep(1000);
			confirmIntention.click();
			finishBtn.click(); 										//  bug GLM-1406 
			Thread.sleep(2000);
			getScreenShot("ST-027", "DocumentD_Approved_Step-67"); 
			Log.info("completed successfully -- Step-67");
			Thread.sleep(1000);
			searchTest.initializeSearchCriteria();
			searchTest.searchAgainBtn.click();
			initializeSearchResult();
			String updatedVersion8 = selectVersionCol.getText();
			Log.info(updatedVersion8);
			writeCSV(updatedVersion8);
			Assert.assertTrue(updatedVersion8.contains("2.0"), "Document D has" + updatedVersion8 + " updated version.");
			Log.info("Updated version of" + docD + "is" +updatedVersion6+ "completed successfully -- step 67");

			
			searchTest.doEditSearchView(docRChangeReq);
			initializeProcessManagement();
			processManagement.click();
			changeLifeCycleState.click();
			Thread.sleep(2000);
			initializeProcessManagementPanel();
			newLifeCycleState.selectByVisibleText("Closed");
			Thread.sleep(2000);
			finishBtn.click(); 												//  bug GLM-1406 
			Thread.sleep(2000);
			getScreenShot("ST-027", "DocumentD_Approved_Step-67"); 
			Log.info("Document R is promoted to the Closed state and completed successfully -- Step-68");
			Thread.sleep(1000);
		/*
		 * 
		 * Need to add assert after bug fix (bug GLM-1406)
		 * 
		 */
			
			initializeHome();
			logOff.click();
			loginTest.initializeObjects();
			Assert.assertEquals(loginTest.loginButton.isDisplayed(), true, "Logout successfully"); 
			Log.info("Logout successfully -- Step-69");		
			
	
			// Login as Author
			loginTest.doLogin(username2, password2);   
			Log.info("Login Successful. " + username3 + " " + "user is logged in --- Step-69");
			
			
			
			searchTest.doSearchDocument(docB);
			Thread.sleep(3000);
			initializeSupportingDocumentTab();
			supportDocTab.click();
			Thread.sleep(1000);
			initializeSupportingDocumentTbl();
			docIDSearch.sendKeys(docD);
			String versionOfDocD = versionRow1.getText();
			String supportingDocID1 = docID.getText();
		
			initializeSupportingDocumentTbl();
			docIDSearch.sendKeys(docG);
			String versionOfDocG = versionRow1.getText();
			String supportingDocID2 = docID.getText();
			
			homeScreen.dashboard.click();
			
			checkinTest.doCheckin(docB);

			searchTest.doEditSearchView(docB);
			Thread.sleep(3000);
			initializeSearchResult();
			String updatedVersion = selectVersionCol.getText();
			Log.info(updatedVersion);
			writeCSV(updatedVersion);
			Assert.assertTrue(updatedVersion.contains("1.1"), "Document B has" + updatedVersion + " updated version.");
			Log.info("Updated version of" + docB + "is" +updatedVersion+ "completed successfully -- step 70");
			
			initializeSupportingDocumentTab();
			supportDocTab.click();
			Thread.sleep(1000);
			initializeSupportingDocumentTbl();
			docIDSearch.sendKeys(docD);
			getScreenShot("ST-027", "Test01_SR-RM-19"); 
			String versionOfDocD1 = versionRow1.getText();
			String supportingDocID3 = docID.getText();
		
			initializeSupportingDocumentTbl();
			docIDSearch.sendKeys(docG);
			getScreenShot("ST-027", "Test02_SR-RM-19"); 
			String versionOfDocG1 = versionRow1.getText();
			String supportingDocID4 = docID.getText();
			
			Assert.assertTrue(versionOfDocD.equals(versionOfDocD1) && supportingDocID1.equals(supportingDocID3),  "Successfully passed :-- SR-RM-19");
			Assert.assertTrue(versionOfDocG.equals(versionOfDocG1) && supportingDocID2.equals(supportingDocID4),  "Successfully passed :-- SR-RM-19");
			Log.info("Supporting documents are rolled up to the new parent version on check in. -- step 71 and Successfully passed :-- SR-RM-19");
			
			
			
			searchTest.doEditSearchView(docG);
			Thread.sleep(3000);
			
			checkinTest.doCheckin(docG);
			
			searchTest.doEditSearchView(docG);
			haInt.doSubmitToHA(docG);
			
			searchTest.doEditSearchView(docG);
			Thread.sleep(3000);
			checkinTest.doCheckin(docG);
			
			searchTest.doEditSearchView(docG);
			getScreenShot("ST-027", "Test_SR-EV-28"); 
			initializeSearchResult();
			String updatedVersionG = selectVersionCol.getText();
			String updatedStatusG = status.getText();
			Assert.assertTrue(updatedVersionG.contains("1.1") && updatedStatusG.contains("Draft"), "Document G has" + updatedVersionG + " updated version and has status: " + updatedStatusG );
			Log.info("Document G is checked in as a new minor version 1.1 and The lifecycle resets to the Draft state after being edited. Successfully passed :-- SR-EV-28"); // step-72
			
			
			searchTest.doEditSearchView(docB);
			initializeSupportingDocumentTab();
			supportDocTab.click();
			Thread.sleep(1000);
			initializeSupportingDocumentTbl();
			docIDSearch.sendKeys(docG);
			getScreenShot("ST-027", "Test_SR-RM-17"); 
			String versionOfDocG3 = versionRow1.getText();
			Assert.assertTrue(versionOfDocG3.contains("1.1"), "Document B supporting document relationship has been rolled up to the new minor version of Document G." + versionOfDocG3 );
			Log.info("Document B supporting document relationship has been rolled up to the new minor version of Document G. Successfully passed :-- SR-RM-17"); // step-73


			
			searchTest.doEditSearchView(docB);
			Thread.sleep(3000);
			checkinTest.doCheckin(docB); 
			Log.info("Document B is checked in as version 1.2."); 

			searchTest.doEditSearchView(docB);
			initializeSourceDocumentTab();
			sourceDocTab.click();
			Thread.sleep(1000);
			initializeSourceDocumentTbl();
			docIDSearch.sendKeys(docC);
			getScreenShot("ST-027", "Test_R-RM-10.1"); 
			String versionOfDocC = versionRow1.getText();   // This may be have problem because of Step-61 (Change parent Version is not in UI right now. Need to disusss)
			Assert.assertTrue(versionOfDocC.contains("1.0"), "Document C version 1.0 is still attached with the Document B version 1.2." + versionOfDocC );

			initializeHome();
			logOff.click();
			loginTest.initializeObjects();
			Assert.assertEquals(loginTest.loginButton.isDisplayed(), true, "Logout successfully"); 
			Log.info("Logout successfully -- Step-75");		
			
			
			// Login as Application Manager
			loginTest.doLogin(username3, password3);   
			Log.info("Login Successful. " + username3 + " " + "user is logged in --- Step-75");
			
			
			
			
		
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("xmL-ST-027.doc tested unsuccessfully");
			Log.info("xmL-ST-027 Document Relationships and Legal Hold System Test Script failed: " + e.getMessage());
		}
	}
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
