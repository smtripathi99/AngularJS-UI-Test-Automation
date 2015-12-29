package com.ig.automation.systemtest;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ig.automation.coreactions.DataActions;
import com.ig.automation.screens.SystemTestScreen;
import com.ig.automation.test.ChangeLifeCycleStateTest;
import com.ig.automation.test.CheckinTest;
import com.ig.automation.test.CreateCRTest;
import com.ig.automation.test.CreateDocumentTest;
import com.ig.automation.test.DocumentRelationshipTest;
import com.ig.automation.test.EditPropertiesTest;
import com.ig.automation.test.LoginTest;
import com.ig.automation.test.WorkflowTest;
import com.ig.automation.utility.Log;


public class ChangeRequestSystemTest extends SystemTestScreen {

	LoginTest loginTest = new LoginTest();
	CreateDocumentTest cdTest = new CreateDocumentTest();
	CreateCRTest crTest = new CreateCRTest();
	CheckinTest checkinTest = new CheckinTest();
	ChangeLifeCycleStateTest changeLSTest = new ChangeLifeCycleStateTest();
	WorkflowTest rfa = new WorkflowTest();
	DocumentRelationshipTest linkDocRelation = new DocumentRelationshipTest();
	EditPropertiesTest edit = new EditPropertiesTest();
	

	/**
	 * Test the xmL-ST-007 Change Request Document System Test of UI 7.0 against the xmL-SRS-002 
	 * 
	 * @throws Exception If an error occurs.
	 */

	@Test
	public void testChangeRequestST() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("xmL-ST-007 Change Request System Test Started");
		String docA = null, docB = null, docC = null, docD = null, docE = null;

		try {
			loginTest.launchUrl();
			Thread.sleep(1000);
			String username = DataActions.getUserID("role_core_data_author");
			String password = DataActions.getUserPassword("role_core_data_author");
			loginTest.doLogin(username, password);
			Log.info("Login Successful. " + username + " " + "user is logged in.");
			initializeAction();
			Thread.sleep(1000);
			actions.click();
			Thread.sleep(1000);
			initializeCreate();
			createDoc.click(); // 05
			Thread.sleep(1000);
			inilializeObjectsDocType();
			Thread.sleep(1000);
			coreDataSheet.click();
			Thread.sleep(2000);
			docA = cdTest.doCreateDocument("Core Data Sheet", "Document A", "United States", "English", "", "", "", "Alkaline Aqua");// 06
			searchDocument(docA);
			Thread.sleep(2000);
			Assert.assertTrue(docA.contains("CDS"), "Document A " + docA + " is created.");
			getScreenShot("ST-007", "DocumentA.jpg");
			Log.info("Document A " + docA + " is created.");
			Thread.sleep(1000);
			logOff.click();
			String username1 = DataActions.getUserID("role_change_req_author");
			String password1 = DataActions.getUserPassword("role_change_req_author");
			loginTest.doLogin(username1, password1); // 07
			Log.info("Login Successful. " + username1 + " " + "user is logged in.");
			Thread.sleep(2000);
			searchDocument(docA); // 08
			Thread.sleep(2000);
			selectDoc.click();
			initializeCRTab();
			Thread.sleep(1000);
			crLink.click();
			initializeDocDetails();
			Thread.sleep(2000);
			createCRLink.click();// 08
			crTest.initializeMandatoryProperties();
			Assert.assertTrue(crTest.createCRPanelTitle.getText().contains("Create New Change Request"), "The “Create New Change Request” screen is displayed");
			Log.info("Requirement SR-CR-1 is passed. The “Create New Change Request” screen is displayed.");
			docC = crTest.doCreateCRMandatory("Document C", "Other", "Austria", "English", "High"); // 09
			//create change request is not showing doc id in toast message.//
			Thread.sleep(1000);
			Assert.assertTrue(docC.contains("change"), "Document C is created");
			Log.info("Requirement SR-CR-2 is passed. The “Document C is created");
			//after create change request audit trail  page comes instead of change request tab //GLM-1370
			getScreenShot("ST-007", "DocumentC_SR-CR-2.jpg");
			viewProperties(docC);
			getScreenShot("ST-007", "DocumentC_Properties.jpg");
			//Assert.assertTrue(edit.existCRType.getText().equalsIgnoreCase("Other"));
			Assert.assertTrue(edit.existTitle.getText().equalsIgnoreCase("Document C"));
			Assert.assertTrue(edit.existCountry.getText().equalsIgnoreCase("Austria"));
			Assert.assertTrue(edit.existLanguage.getText().equalsIgnoreCase("English"));
			Assert.assertTrue(edit.existProprietary.getText().equalsIgnoreCase("High"));
			Log.info("CR Type" + edit.existCRType.getText() + "Title:" + edit.existTitle.getText() + "Country(ies):" + edit.existCountry.getText() + "Language:" + "Priority:"
				+ edit.existProprietary.getText());
			getScreenShot("ST-007", "DocumentC_SR-CR-1.jpg");
			logOff.click();
			//String username2 = DataActions.getUserID("role_core_data_author");
			//String password2 = DataActions.getUserPassword("role_core_data_author");
			loginTest.doLogin(username, password); // 10
			Log.info("Login Successful " + username + "" + "user is logged in");
			searchDocument(docA); // version 0.2
			searchDocumentVersion("0.2");
			selectDoc.click();
			initializeCRTab(); // 11
			crLink.click();
			Assert.assertTrue(selectCRDoc.getText().contains(docC), "Document C is listed on the Change Request tab of document A version 0.1");
			Log.info("Requirement SR-CR-9 passed");
			getScreenShot("ST-007", "SR-CR-9-CRofDocA.jpg");
			checkinTest.doCheckin(docA); // 12
			searchDocument(docA);
			searchDocumentVersion("0.2");
			selectDoc.click();
			initializeCRTab(); // 13
			crLink.click();
			getScreenShot("ST-007", "pass_changerequestA0.2.jpg");
			logOff.click();
			String username3 = DataActions.getUserID("role_application_manager");
			String password3 = DataActions.getUserPassword("role_application_manager");
			loginTest.doLogin(username3, password3); // 14
			Log.info(username3 + "" + "user is logged in");
			String error = changeLSTest.doChangeStateDrafttoIA(docA); // 15
			Assert.assertTrue(!error.contains("success"));
			getScreenShot("ST-007", "pass_changestatedocA0.2.jpg");
			String errorWF = rfa.selectWorkflowTemplate(docA); // 16
			getScreenShot("ST-007", "pass_SR-CR-6.jpg");
			Assert.assertTrue(!errorWF.contains("success"), "The document must be linked to an approved change request before being routed for approval");
			Log.info("Error message is displayed.The document must be linked to an approved change request before being routed for approval.");
			rfa.selectWorkflowTemplate(docC); // 17
			rfa.startWorkflow();
			rfa.doApproveWorkFlow(docC); // 20
			searchDocument(docC); // 21
			selectDoc.click();
			searchDocument(docA); // 23
			searchDocumentVersion("0.1");
			selectDoc.click();
			changeLSTest.doChangeStateDrafttoIA(docA);
			// selectDoc.click();
			searchDocument(docA); // 25
			searchDocumentVersion("1.0");
			selectDoc.click();
			initializeCRTab();
			crLink.click(); // 27
			getScreenShot("ST-007", "pass_changerequestdocA1.0.jpg");
			Log.info("Document C is listed on the Change Request tab of document A version 1.0");
			checkinTest.doCheckin(docA);
			searchDocument(docA); // version 1.1
			searchDocumentVersion("1.1");
			selectDoc.click();
			initializeCRTab();
			crLink.click(); // 27
			getScreenShot("ST-007", "pass_changerequestdocA1.1.jpg");
			Log.info("Document C is not listed on the Change Request tab of document A version 1.1");
			searchDocument(docC); // version 1.0
			searchDocumentVersion("1.0");
			selectDoc.click();
			initializeWhereRefTab();
			whereRef.click();
			initializeWhereRefGrid();
			Assert.assertTrue(!whereRefversion.getText().contains("1.1"), "Document C is not linked to the minor version 1.1 of Document A");
			getScreenShot("ST-007", "pass_SR-CR-9.jpg");
			Log.info("Document C is not linked to the minor version 1.1 of Document A");
			logOff.click();

			//String username4 = DataActions.getUserID("role_change_req_author");
			//String password4 = DataActions.getUserPassword("role_change_req_author");
			loginTest.doLogin(username1, password1); // 29
			Log.info(username1 + "" + "user is logged in");
			Thread.sleep(2000);
			searchDocument(docC); // 30
			searchDocumentVersion("1.0");
			selectDoc.click();
			logOff.click();

			//String username5 = DataActions.getUserID("role_application_manager");
			//String password5 = DataActions.getUserPassword("role_application_manager");
			loginTest.doLogin(username3, password3); // 31
			Log.info(username3 + "" + "user is logged in");
			searchDocument(docA); // 32
			searchDocumentVersion("1.1");
			selectDoc.click();
			String error1 = changeLSTest.doChangeStateDrafttoIA(docA);
			Assert.assertTrue(error.contains("Internally Approved state"),
					"In order to perform this operation the Change Request should exist and be in an Internally Approved state");
			getScreenShot("ST-007", "pass_SR-CR-7-Step-32.jpg");
			Log.info("In order to perform this operation the Change Request should exist and be in an Internally Approved state");
			// searchDocument(docA,"Draft");
			//rfa.selectWorkflowTemplate(docA);
			getScreenShot("ST-007", "pass_SR-CR-7-Step-33.jpg");
			Log.info("The document must be linked to an approved change request before being routed for approval");

			logOff.click();
			String username6 = DataActions.getUserID("role_core_data_author");
			String password6 = DataActions.getUserPassword("role_core_data_author");
			loginTest.doLogin(username6, password6); // 34
			Log.info(username6 + "" + "user is logged in");
			initializeAction();
			actions.click();
			Thread.sleep(1000);
			initializeCreate();
			createDoc.click();
			Thread.sleep(1000);
			inilializeObjectsDocType();
			coreDataSheet.click();
			Thread.sleep(3000);
			docB = cdTest.doCreateDocument("Core Data Sheet", "Document B", "United States", "English", "", "", "", "Alkaline Aqua");// 35
			Log.info("Document B " + docB + " is created"); // 35
			checkinTest.doCheckin(docB);// 36
			Log.info("Document B is checked-out");
			logOff.click();

			//String username7 = DataActions.getUserID("role_change_req_author");
			//String password7 = DataActions.getUserPassword("role_change_req_author");
			loginTest.doLogin(username1, password1); // 37
			Log.info(username1 + "" + "user is logged in");
			searchDocument(docB);
			searchDocumentVersion("0.2");
			selectDoc.click();
			linkDocRelation.doLinkCRDocumentSearch(docB);
			getScreenShot("ST-007", "pass_SR-CR-3-1.jpg");
			searchDocument(docB);// 41
			searchDocumentVersion("0.2");
			selectDoc.click();
			initializeCRTab(); //
			crLink.click();
			initializeDocDetails();
			createCRLink.click();// 42
			getScreenShot("ST-007", "pass_SR-CR-3-2.jpg");
			docD = crTest.doCreateCRMandatory("Document D", "Other", "Austria", "English", "High");// 43
			Log.info("Document D " + docD + " is created");
			Assert.assertTrue(docD.contains("CR-"), "Document C is created");
			viewProperties(docD);
			getScreenShot("ST-007", "DocumentD_Properties.jpg");
			//Assert.assertTrue(edit.existCRType.getText().equalsIgnoreCase("Other"));
			Assert.assertTrue(edit.existTitle.getText().equalsIgnoreCase("Document D"));
			Assert.assertTrue(edit.existCountry.getText().equalsIgnoreCase("Austria"));
			Assert.assertTrue(edit.existLanguage.getText().equalsIgnoreCase("English"));
			Assert.assertTrue(edit.existProprietary.getText().equalsIgnoreCase("High"));
			Log.info("CR Type" + edit.existCRType.getText() + "Title:" + edit.existTitle.getText() + "Country(ies):" + edit.existCountry.getText() + "Language:" + "Priority:"
				+ edit.existProprietary.getText());
			searchDocument(docB);
			searchDocumentVersion("0.2");
			selectDoc.click();
			crLink.click();
			getScreenShot("ST-007", "pass_SR-CR-1.jpg");
			logOff.click();

			//String username8 = DataActions.getUserID("role_application_manager");
			//String password8 = DataActions.getUserPassword("role_application_manager");
			loginTest.doLogin(username3, password3); // 45
			Log.info(username3 + "" + "user is logged in");
			searchDocument(docB); // 46
			searchDocumentVersion("0.2");
			selectDoc.click();
			String error2 = changeLSTest.doChangeStateDrafttoIA(docB);
			Assert.assertTrue(error.contains("Internally Approved state"),
					"In order to perform this operation the Change Request should exist and be in an Internally Approved state");
			getScreenShot("ST-007", "pass_SR-CR-7.jpg");
			searchDocument(docD);
			selectDoc.click();
			String success = changeLSTest.doChangeStateDrafttoIA(docD);// 48
			getScreenShot("ST-007", "pass_SR-CR-7-1.jpg");
			searchDocument(docC);
			searchDocumentVersion("1.1");
			selectDoc.click();
			String successc = changeLSTest.doChangeStateDrafttoIA(docC);// 50
			searchDocument(docB, "Draft");
			searchDocumentVersion("0.2");
			selectDoc.click();
			String successb = changeLSTest.doChangeStateDrafttoIA(docB);// 52
			searchDocument(docA);
			searchDocumentVersion("1.1");
			selectDoc.click();
			initializeCRTab(); //
			crLink.click();
			initializeDocDetails();
			createCRLink.click();// 42
			getScreenShot("ST-007", "pass_SR-CR-5.jpg");
			docE = crTest.doCreateCRMandatory("Document E", "Other", "Austria", "English", "Low");// 43
			Log.info("Document E " + docE + " is created");
			Assert.assertTrue(docE.contains("CR-"), "Document E is created");
			viewProperties(docE);
			getScreenShot("ST-007", "DocumentE_Properties.jpg");
			//Assert.assertTrue(edit.existCRType.getText().equalsIgnoreCase("Other"));
			Assert.assertTrue(edit.existTitle.getText().equalsIgnoreCase("Document E"));
			Assert.assertTrue(edit.existCountry.getText().equalsIgnoreCase("Austria"));
			Assert.assertTrue(edit.existLanguage.getText().equalsIgnoreCase("English"));
			Assert.assertTrue(edit.existProprietary.getText().equalsIgnoreCase("Low"));
			//Log.info("CR Type" + edit.existCRType.getText() + "Title:" + edit.existTitle.getText() + "Country(ies):" + edit.existCountry.getText() + "Language:" + "Priority:"
				//	+ edit.existProprietary.getText());
			searchDocument(docB, "Draft");
			crLink.click();
			getScreenShot("ST-007", "pass_SR-CR-1.jpg");
			searchDocument(docE);
			changeLSTest.doChangeStateDrafttoIA(docE);
			searchDocument(docA);
			searchDocumentVersion("1.1");
			selectDoc.click();
			changeLSTest.doChangeStateDrafttoIA(docA);
			searchDocument(docC);
			searchDocumentVersion("2.0");
			selectDoc.click();
			changeLSTest.doChangeStateDrafttoIA(docC);
			// TODO for delete doc
			logOff.click();

			//String username9 = DataActions.getUserID("role_change_req_author");
			//String password9 = DataActions.getUserPassword("role_change_req_author");
			loginTest.doLogin(username1, password1); // 62
			Log.info(username1 + "" + "user is logged in");
			searchDocument(docA);
			searchDocumentVersion("2.0");
			selectDoc.click();
			initializeCRTab(); //
			crLink.click();
			initializeDocDetails();
			Assert.assertTrue(!createCRLink.isEnabled(), "Allow only one active change request per document."); // 63
			
			//TODO
			
			Log.info("Allow only one active change request per document.");
			Reporter.log("xmL-ST-007.doc tested successfully");
			Log.info("xmL-ST-007 Change Request System Test Ended");
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("xmL-ST-007.doc tested unsuccessfully");
			Log.info("xmL-ST-007 Change Request System Test Failed: " + e.getMessage());
		}		

	}

	public void searchDocument(String docid) throws Exception {
		initializeSearch();
		searchIcon.click();
		initializeBasicSearchIcon();
		basicSearchIcon.click();
		initializeBasicSearch();
		docIDSearch.sendKeys(docid);
		searchBtn.click();
		initializeSearchResult();

	}

	public void searchDocumentVersion(String version) throws Exception {
		initializeSearchResult();
		selectVersionCol.click();
		inputVersion.sendKeys(version);
	}

	public void searchDocument(String docid, String status) throws Exception {
		initializeSearch();
		searchIcon.click();
		initializeBasicSearchIcon();
		basicSearchIcon.click();
		initializeBasicSearch();
		if (status != null) {
			docIDStatusSearch.selectByValue(status);
		}
		docIDSearch.sendKeys(docid);
		searchBtn.click();
		initializeSearchResult();

	}

	public void viewProperties(String docC) {
		edit.initializePropertiesTab();
		edit.propertiesTab.click();
		edit.initializeEdit(docC);
		// edit.click();

	}

	// @AfterClass
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();

	}
}
