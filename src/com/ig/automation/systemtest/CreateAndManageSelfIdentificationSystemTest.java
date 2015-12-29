package com.ig.automation.systemtest;

import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ig.automation.coreactions.DataActions;
import com.ig.automation.screens.DocumentDetailsScreen;
import com.ig.automation.screens.SystemTestScreen;
import com.ig.automation.test.ChangeLifeCycleStateTest;
import com.ig.automation.test.CheckinTest;
import com.ig.automation.test.CreateDocumentTest;
import com.ig.automation.test.CreateSelfIDTest;
import com.ig.automation.test.DocumentRelationshipTest;
import com.ig.automation.test.DocumentTranslationTest;
import com.ig.automation.test.EditPropertiesTest;
import com.ig.automation.test.HAInterActionTest;
import com.ig.automation.test.HomeTest;
import com.ig.automation.test.LoginTest;
import com.ig.automation.test.SearchTest;
import com.ig.automation.utility.Log;


public class CreateAndManageSelfIdentificationSystemTest extends SystemTestScreen {

	LoginTest loginTest = new LoginTest();
	CreateDocumentTest cdTest = new CreateDocumentTest();
	DocumentTranslationTest dtTest = new DocumentTranslationTest();
	DocumentRelationshipTest drTest = new DocumentRelationshipTest();
	DocumentDetailsScreen ddTest = new DocumentDetailsScreen();
	HomeTest ht = new HomeTest();
	EditPropertiesTest edit = new EditPropertiesTest();
	CheckinTest checkinTest = new CheckinTest();
	ChangeLifeCycleStateTest clsTest = new ChangeLifeCycleStateTest();
	HAInterActionTest haTest = new HAInterActionTest();
	SearchTest searchTest = new SearchTest();
	DataActions dataActions = new DataActions();
	CreateSelfIDTest csiTest = new CreateSelfIDTest();
	

	String docX = "USPI-1321", searchResultCol1 = null, userName = null, docB ="EST-518";
	List <String> createDocA;
	String docA;
	List<String> editDocB;
	String typeOfDocument = "GENERIC DRUG FACILITY IDENTIFICATION SUBMISSION";
	String registrant = "GENERIC DRUG FACILITY IDENTIFICATION SUBMISSION";
	String title = "Document A";
	String contactCountry = "USA";
	String contactPhone = "2165105432";
	String contactEmail = "test@ig.com";
	String contactName = "Test";
	String contactStreet = "2nd Street";
	String contactCity = "Austin";
	String contactState = "Texas";
	String contactPostal = "75462";
	
	/**
	 * Test the Create And Manage Self Identification System Test of UI 7.0 against the xmL-ST-021
	 * 
	 * @throws Exception If an error occurs.
	 */

	@Test
	public void testCreateAndManageSelfIdentificationST() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Create And Manage Self Identification System Test Started");

		try {
			loginTest.launchUrl();
			String username = DataActions.getUserID("role_us_labeling_author");
			String password = DataActions.getUserPassword("role_us_labeling_author");
			loginTest.doLogin(username, password);
			Thread.sleep (2000);
			Log.info("Login Successful " + username + " " + "user is logged in");			// step: 1
			
			initializeAction();
			actions.click();
			Thread.sleep(1000);
			initializeCreate();
			createDoc.click(); 
			Thread.sleep(1000);
			inilializeObjectsDocType();
			uSPI.click();
			Thread.sleep(3000);
			docX = cdTest.doCreateDocument("US Package Insert","Document X","United States","English","","ALLERSOLV","COSMETIC","Alkaline Aqua");  	// step: 5
			Assert.assertTrue(docX.contains("USPI"), "Expected Result: Test Setup data (USPI doc) created." + "Actual Result: " + docX );
			Log.info("Document X is created successfully with DocID: " + docX);
			
			searchTest.doSearchDocument(docX);
			
			initializeSearchItemsPerPage();
			itemPerPageDropDown.selectByIndex(1);
			
			ddTest.initializeAuditTrail();
			ddTest.auditTrail.click();
			
			pageScrollDown();
			
			initializeAuditTrailItemsPerPage();
			selectItemPerPage.selectByIndex(1);
			getScreenShot("ST-021", "AuditTrail");
			
			ddTest.initializeAuditTrail();
			String event_DocX = ddTest.auditTrailEvent.getText();
			ddTest.initializeUserName();
			String userName_DocX = ddTest.userName.getText();
			ddTest.initializeAuditTrailEvent();
			String comment_DocX = ddTest.comment.getText();
			ddTest.initializeProperties();
			String properties_DocX = ddTest.properties.getText();
			
		
			Assert.assertTrue(event_DocX.contains("Create New Document"), "Expected Result: Audit Trail is correctly recorded for the create document events" + "Actual Result: Audit Trail is not correctly recorded for the create document events.");
			Log.info("Event: "+ event_DocX);
			Assert.assertTrue(userName_DocX.contains("US Label Author 01"), "Expected Result: Audit Trail is correctly recorded for the create document events" + "Actual Result: Audit Trail is not correctly recorded for the create document events.");
			Log.info("UserName: "+ userName_DocX);
			Assert.assertTrue(comment_DocX.contains(null), "Expected Result: Audit Trail is correctly recorded for the create document events" + "Actual Result: Audit Trail is not correctly recorded for the create document events.");
			Log.info("Comment: "+ comment_DocX);
			Assert.assertTrue(properties_DocX.contains(null), "Expected Result: Audit Trail is correctly recorded for the create document events" + "Actual Result: Audit Trail is not correctly recorded for the create document events.");
			Log.info("Properties: "+ properties_DocX);
			
		
			
			createDocA = csiTest.doCreateSelfID(typeOfDocument,registrant,title,contactCountry,contactPhone,contactEmail,contactName,contactStreet,contactCity,contactState,contactPostal);
			getScreenShot("ST-021", "SR-SO-6");
			docA = createDocA.get(11);
			assertTrue(docA.contains("SID"), true, docA.contains("SID"));
			Log.info("New Self Identification is created successfully with selfID: " + docA);
			
			searchTest.doSearchDocument(docA);
			
			searchTest.initializeSearchResult1();
			String docStatus = searchTest.docStatus.getText();
			assertTrue(docStatus.contains("Draft"), "Expected Result: Document created is in Draft state." , "Actual Result: Document created is not in Draft state.");
			Log.info("Created Document state is: " + docStatus);
			
			ddTest.initializePropertie();
			ddTest.properties.click();
			
			ddTest.initializeMandatoryPropertiesValues("SID");
			String typeOfDoc = ddTest.typeOfDoc.getText();
			
			ddTest.initializeRFAValues("SID");
			String registrant = ddTest.rfaRegistrant.getText();
			
			ddTest.initializeOptional();
			ddTest.optional.click();
			ddTest.initializeOptionalValues("SID");
			String title1 = ddTest.title.getText();
			String contactCountry1 = ddTest.title.getText();
			String contactPhone1 = ddTest.contactPhone.getText();
			String contactEmail1 = ddTest.contactEmail.getText();
			String contactName1 = ddTest.contactName.getText();
			String contactStreet1 = ddTest.contactStreet.getText();
			String contactCity1 = ddTest.contactCity.getText();
			String contactState1 = ddTest.contactState.getText();
			String contactPostalCode1 = ddTest.contactPostalCode.getText();
			
			
			
			assertTrue(createDocA.get(0).contains(typeOfDoc), true, createDocA.get(0).contains(typeOfDoc));
			Log.info("Entered and properties document type is same: "+ typeOfDocument);
			assertTrue(createDocA.get(1).contains(registrant), true, createDocA.get(1).contains(registrant));
			Log.info("Entered and properties registrant type is same: "+ registrant);
			assertTrue(createDocA.get(2).contains(title1), true, createDocA.get(2).contains(title1));
			Log.info("Entered and properties title is same: "+ title1);
			assertTrue(createDocA.get(3).contains(contactCountry1), true, createDocA.get(3).contains(contactCountry1));
			Log.info("Entered and properties Contact Country is same: "+ contactCountry1);
			assertTrue(createDocA.get(4).contains(contactPhone1), true, createDocA.get(4).contains(contactPhone1));
			Log.info("Entered and properties Contact Phone is same: "+ contactPhone1);
			assertTrue(createDocA.get(5).contains(contactEmail1), true, createDocA.get(5).contains(contactEmail1));
			Log.info("Entered and properties Contact Email is same: "+ contactEmail1);
			assertTrue(createDocA.get(6).contains(contactName1), true, createDocA.get(6).contains(contactName1));
			Log.info("Entered and properties Contact Name is same: "+ contactName1);
			assertTrue(createDocA.get(7).contains(contactStreet1), true, createDocA.get(7).contains(contactStreet1));
			Log.info("Entered and properties Contact Street is same: "+ contactStreet1);
			assertTrue(createDocA.get(8).contains(contactCity1), true, createDocA.get(8).contains(contactCity1));
			Log.info("Entered and properties Contact City is same: "+ contactCity1);
			assertTrue(createDocA.get(9).contains(contactState1), true, createDocA.get(9).contains(contactState1));
			Log.info("Entered and properties Contact State is same: "+ contactState);
			assertTrue(createDocA.get(10).contains(contactPostalCode1), true, createDocA.get(10).contains(contactPostalCode1));
			Log.info("Entered and properties Contact Postal is same: "+ contactPostalCode1);
			
			
				
			
					
			/*
			 * Edit is not working Logged Bug: GLM-1459    // Step-8-9
			 * 
			 * 
			 */
			
			
						
			initializeSearchItemsPerPage();
			itemPerPageDropDown.selectByIndex(1);
			
			ddTest.initializeAuditTrail();			// Step-10
			ddTest.auditTrail.click();
			
			pageScrollDown();
			
			initializeAuditTrailItemsPerPage();
			selectItemPerPage.selectByIndex(1);
			Thread.sleep(2000);
			getScreenShot("ST-021", "AuditTrail_Step-10");
			Thread.sleep(2000);
			
			ddTest.initializeAuditTrailEvent();
			String event_DocA = ddTest.auditTrailEvent.getText();
			ddTest.initializeUserName();
			String userName_DocA = ddTest.userName.getText();
			ddTest.initializeComment();
			String comment_DocA = ddTest.comment.getText();
			ddTest.initializeProperties();
			String properties_DocA = ddTest.properties.getText();
			
			// Have to Re-Check Asserts
			Assert.assertTrue(event_DocA.contains("Edit Properties."), "Expected Result: Audit Trail is correctly recorded for the create document events" + "Actual Result: Audit Trail is not correctly recorded for the create document events.");
			Log.info("Event: "+ event_DocA);
			Assert.assertTrue(userName_DocA.contains("US Label Author 01"), "Expected Result: Audit Trail is correctly recorded for the create document events" + "Actual Result: Audit Trail is not correctly recorded for the create document events.");
			Log.info("UserName: "+ userName_DocA);
			Assert.assertTrue(comment_DocA.contains(null), "Expected Result: Audit Trail is correctly recorded for the create document events" + "Actual Result: Audit Trail is not correctly recorded for the create document events.");
			Log.info("Comment: "+ comment_DocA);
			Assert.assertTrue(properties_DocA.contains(null), "Expected Result: Audit Trail is correctly recorded for the create document events" + "Actual Result: Audit Trail is not correctly recorded for the create document events.");
			Log.info("Properties: "+ properties_DocA);
			
			
			/*
			 * BUG: GLM-1470
			 * TODO : Step-11 
			 * 
			 * 
			 */
			
			
			searchTest.doSearchDocument(docB);		// Step-12
			initializeSearchItemsPerPage();
			itemPerPageDropDown.selectByIndex(1);
			ddTest.initializeAuditTrail();
			ddTest.auditTrail.click();
			pageScrollDown();
			initializeAuditTrailItemsPerPage();
			selectItemPerPage.selectByIndex(1);
			getScreenShot("ST-021", "est_AuditTrail");
			ddTest.initializeAuditTrail();
			String event_DocB = ddTest.auditTrailEvent.getText();
			ddTest.initializeUserName();
			String userName_DocB = ddTest.userName.getText();
			ddTest.initializeAuditTrailEvent();
			String comment_DocB = ddTest.comment.getText();
			ddTest.initializeProperties();
			String properties_DocB = ddTest.properties.getText();
			
			Assert.assertTrue(event_DocB.contains("Create New Document"), "Expected Result: Audit Trail is correctly recorded for the create document events" + "Actual Result: Audit Trail is not correctly recorded for the create document events.");
			Log.info("Event: "+ event_DocB);
			Assert.assertTrue(userName_DocB.contains("US Label Author 01"), "Expected Result: Audit Trail is correctly recorded for the create document events" + "Actual Result: Audit Trail is not correctly recorded for the create document events.");
			Log.info("UserName: "+ userName_DocB);
			Assert.assertTrue(comment_DocB.contains(null), "Expected Result: Audit Trail is correctly recorded for the create document events" + "Actual Result: Audit Trail is not correctly recorded for the create document events.");
			Log.info("Comment: "+ comment_DocB);
			Assert.assertTrue(properties_DocB.contains(null), "Expected Result: Audit Trail is correctly recorded for the create document events" + "Actual Result: Audit Trail is not correctly recorded for the create document events.");
			Log.info("Properties: "+ properties_DocB);
			
			
			searchTest.doEditSearchView(docA);		// Step-13
			initializeSearchItemsPerPage();
			itemPerPageDropDown.selectByIndex(1);
			ddTest.initializeEstablishments();
			ddTest.establishments.click();
			Thread.sleep(2000);
			pageScrollDown();
			initializeAuditTrailItemsPerPage();
			selectItemPerPage.selectByIndex(1);
			getScreenShot("ST-021", "Est_in_docA_step-13");
			ddTest.intializeEstablishmentsTbl();
			String docId_est = ddTest.estDocID.getText();
			
			Assert.assertTrue(docId_est.contains(docB), "Expected Result: Establishment created is Present" + "Actual Result: Establishment created is not Present");
			String status_est = ddTest.estStatus.getText();
			Assert.assertTrue(status_est.contains("Draft"), "Expected Result: Establishment is Draft" + "Actual Result: Establishment is not Draft");

			
			searchTest.doSearchDocument(docB);		// Step-14
			ddTest.initializePropertie();				
			ddTest.properties.click();
			
			// TODO --- Have to complete Assert with list
			ddTest.initializeMandatoryPropertiesValues("EST");
		
			editDocB = edit.doEditESTPropertiesTest("EstTestUpdated","Dave","5th Street","Atlanta","Georgia","32003","2105124444","updated@ig.com","TestUpdated","34567","54322","1st Street","Atlanta","Georgia","30042");
			
			searchTest.doSearchDocument(docB);		// Step-15
			initializeSearchItemsPerPage();
			itemPerPageDropDown.selectByIndex(1);
			ddTest.initializeAuditTrail();
			ddTest.auditTrail.click();
			pageScrollDown();
			initializeAuditTrailItemsPerPage();
			selectItemPerPage.selectByIndex(1);
			getScreenShot("ST-021", "est_AuditTrail_Step-15");
			ddTest.initializeAuditTrail();
			String event_DocB_est = ddTest.auditTrailEvent.getText();
			ddTest.initializeUserName();
			String userName_DocB_est = ddTest.userName.getText();
			ddTest.initializeAuditTrailEvent();
			String comment_DocB_est = ddTest.comment.getText();
			ddTest.initializeProperties();
			String properties_DocB_est = ddTest.properties.getText();
			// TODO get for other Properties value which comes after EDIT docB
			
			Assert.assertTrue(event_DocB_est.contains("Create New Document"), "Expected Result: Audit Trail is correctly recorded for the create document events" + "Actual Result: Audit Trail is not correctly recorded for the create document events.");
			Log.info("Event: "+ event_DocB_est);
			Assert.assertTrue(userName_DocB_est.contains("US Label Author 01"), "Expected Result: Audit Trail is correctly recorded for the create document events" + "Actual Result: Audit Trail is not correctly recorded for the create document events.");
			Log.info("UserName: "+ userName_DocB_est);
			Assert.assertTrue(comment_DocB_est.contains(null), "Expected Result: Audit Trail is correctly recorded for the create document events" + "Actual Result: Audit Trail is not correctly recorded for the create document events.");
			Log.info("Comment: "+ comment_DocB_est);
			Assert.assertTrue(properties_DocB_est.contains(null), "Expected Result: Audit Trail is correctly recorded for the create document events" + "Actual Result: Audit Trail is not correctly recorded for the create document events.");
			Log.info("Properties: "+ properties_DocB_est);
			
			// TODO Add more asserts for other Properties value which comes after EDIT docB
			
			
			
			/*
			 *  BUG: GLM-1470
			 *  TODO - Step-16 to 18 after fix of Step-11 issue
			 *  
			 */
		
			initializeHome();				// Step-19
			logOff.click();
			
			String username1 = DataActions.getUserID("role_label_coordinator");
			String password1 = DataActions.getUserPassword("role_label_coordinator");
			loginTest.doLogin(username1, password1);
			Thread.sleep (2000);
			Log.info("Login Successful " + username1 + " " + "user is logged in");
			
			
			
			/*
			 * BUG: GLM-1471
			 * 
			 * TODO- Step-20-21 After bug Fix
			 * 
			 */
			
			
			/*
			 * BUG: GLM-1472
			 * 
			 * TODO - Steps- 22 to 28 after bug fix 
			 * 
			 */
			
			/*
			 * BUG: GLM-1475
			 * 
			 * TODO - Steps- 29 to 37 after bug fix 
			 * 
			 */
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("xmL-ST-021.doc tested unsuccessfully");
			Log.endTestCase("Create And Manage Self Identification System Test Failed");
		}

	}

	
	
	
	
	
	
	
	
	
	
	
	

	// @AfterClass
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();

	}
}
