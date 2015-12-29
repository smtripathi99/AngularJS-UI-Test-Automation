package com.ig.automation.systemtest;

import java.math.BigInteger;
import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Keys;
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


public class SearchForDocumentsAndDynamicViewsSystemTest extends SystemTestScreen {

	private static final String[] French = null;
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
	DocumentTranslationTest ctTest = new DocumentTranslationTest();
	
	String docA = "AN-3001", docB = "BLI-561", docC = null, docD = null;
	
	
	/**
	 * Test the Search for Documents and Dynamic Views System Test of UI 7.0 against the xmL-ST-025
	 * 
	 * @throws Exception If an error occurs.
	 */

	@Test
	public void testCreateAndManageSelfIdentificationST() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Search for Documents and Dynamic Views System Test Started");
		
		try {
			String DocID;
			String linkedDocID;
			String linkedDocID1;
			String successMsg[];
			
			loginTest.launchUrl();
			String username = DataActions.getUserID("role_author");
			String password = DataActions.getUserPassword("role_author");
			loginTest.doLogin(username, password);
			Thread.sleep (2000);
			ht.initializeTopNavigationObjects(false);
			String loginId = ht.loggedUser.getText();
			Log.info(loginId);
			assertTrue(loginId.contains("Author 01"), true, loginId.contains("Author 01"));
			getScreenShot("ST-025", "SR-UI-3");
			Log.info("Login Successful " + username + " " + "user is logged in");		// step: 4
				
/*			// Document B
			initializeAction();
			actions.click();
			Thread.sleep(1000);
			initializeCreate();
			createDoc.click(); 
			Thread.sleep(1000);
			inilializeObjectsDocType();
			blisterLabelingText.click();
			Thread.sleep(3000);
			docB = cdTest.doCreateDocument("Blister Labeling Text","Document B","United States","English","Alkaline Aqua","ALLERSOLV","","");
			assertTrue(docB.contains("BLI"), true, docB.contains("BLI"));
			Log.info("Document B is Created With Document ID: " + docB);
		
			ctTest.doCreateTranslation(docB, new String[] {"French"});
			Thread.sleep(2000);
			
			initializeDashboard();
			dashboard.click();
			searchTest.doSearchDocument(docB);
			initializeMessages();
			String successMessage1 = message.getText();
			DocID=successMessage1;
			Log.info(DocID);
			writeCSV(DocID);
			Thread.sleep(3000);
			
			// Document C 				Step - 34
			initializeAction();
			actions.click();
			Thread.sleep(1000);
			initializeCreate();
			createDoc.click(); 
			Thread.sleep(1000);
			inilializeObjectsDocType();
			outerLabelingText.click();
			Thread.sleep(3000);
			docC = cdTest.doCreateDocument("Outer Labeling Text","Document C","United States","English","Alkaline Aqua","ALLERSOLV","","");
			getScreenShot("ST-025", "SR-RS-4");
			assertTrue(docC.contains("OUT"), true, docC.contains("OUT"));
			Log.info("Document C is Created With Document ID: " + docC);
			
			 
			// Document A
			initializeAction();
			actions.click();
			Thread.sleep(1000);
			initializeCreate();
			createDoc.click(); 
			Thread.sleep(1000);
			inilializeObjectsDocType();
			annexII.click();
			Thread.sleep(3000);
			docA = cdTest.doCreateDocument("Annex II","Document A","United States","English","Alkaline Aqua","ALLERSOLV","","");
			assertTrue(docA.contains("AN"), true, docA.contains("AN"));
			Log.info("Document A is Created With Document ID: " + docA);
			Thread.sleep(3000);
	
			ctTest.doCreateTranslation(docA, new String[] {"French"});
			Thread.sleep(2000);
			
			initializeDashboard();
			dashboard.click();
			searchTest.doSearchDocument(docA);
			initializeMessages();
			String successMessage = message.getText();
			DocID=successMessage;
			Log.info(DocID);
			writeCSV(DocID);
			Thread.sleep(3000);
			
			
			edit.initializePropertiesTab();
			edit.propertiesTab.click();
			Thread.sleep(2000);
			getScreenShot("ST-025", "SR-UI-2");
			
			edit.initializeEdit(docA);								// Step - 8
			String editLink = edit.edit.getText();
			assertTrue(editLink.equals("Edit"), true, editLink.equals("Edit"));
			Log.info(editLink);
			
			String mandatoryLabel = edit.mandatoryLbl.getText();
			assertTrue(mandatoryLabel.equals("Mandatory"), true, mandatoryLabel.equals("Mandatory"));
			Log.info(mandatoryLabel);
			
			String titleLabel = edit.titleLbl.getText();
			assertTrue(titleLabel.equals("Title:"), true, titleLabel.equals("Title:"));
			Log.info(titleLabel);
			String titleValue = edit.existTitle.getText();
			assertTrue(titleValue.equals("Document A"), true, titleValue.equals("Document A"));
			Log.info(titleValue);
			
			String countryLabel = edit.countryLbl.getText();
			assertTrue(countryLabel.equals("Country(ies):"), true, countryLabel.equals("Country(ies):"));
			Log.info(countryLabel);
			String countryValue = edit.existCountry.getText();
			assertTrue(countryValue.equals("United States"), true, countryValue.equals("United States"));
			Log.info(countryValue);
			
			String languageLabel = edit.languageLbl.getText();
			assertTrue(languageLabel.equals("Language:"), true, languageLabel.equals("Language:"));
			Log.info(languageLabel);
			String languageValue = edit.existLanguage.getText();
			assertTrue(languageValue.equals("English"), true, languageValue.equals("English"));
			Log.info(languageValue);
			
			
			
			//docA Advance Search
			initializeSearch(); 					// Step-12 
			searchIcon.click();
			Thread.sleep(2000);
			searchTest.initializeBasicSearch();
			searchTest.advanceSearch.click();
			Thread.sleep(2000);
			searchTest.initializeAdvanceSearch();
			searchTest.annex.click();
			searchTest.initializedocumentType();
			searchTest.searchDocBtn.click();
			searchTest.initializeSearchResult();
			String docID = searchTest.firstLine.getText();
			Log.info(docID);
			assertTrue(docID.contains(docA), true, docID.contains(docA));
			
			 * TODO After Bug Fix: GLM-1462 
			 * 
			 * Step- 12 and step-17 
			 * 
			 
			
			
			 * Step-20 and Step-21
			 * 
			 * TODO After Bug Fix: GLM-1482
			 * 
			 
			
			
			 * TODO After Bug Fix: GLM-1462 
			 * 
			 * Step- 22
			 * 
			 
			
			
			initializeHome();     // Step- 23
			logOff.click();
			
			// Have to change it for Author02 
			String username1 = DataActions.getUserID("role_author");
			String password1 = DataActions.getUserPassword("role_author");
			loginTest.doLogin(username1, password1);  
			Log.info("Login Successful. " + username1 + " " + "user is logged in");
			
			
			
			  TODO After Bug Fix: GLM-1462 
			 * 
			 * Step- 24
			  
			 
			
			
			initializeHome();     // Step- 25
			logOff.click();
			
			loginTest.doLogin(username, password);  
			
			
			
			// Document D				Step- 28
			initializeAction();
			actions.click();
			Thread.sleep(1000);
			initializeCreate();
			createDoc.click(); 
			Thread.sleep(1000);
			inilializeObjectsDocType();
			immediateLabelingText.click();
			Thread.sleep(3000);
			docD = cdTest.doCreateDocument("Immediate Labeling Text","Document D","United States","English","Alkaline Aqua","ALLERSOLV","","");
			assertTrue(docD.contains("IMM"),true, docD.contains("IMM"));
			Log.info("Document D is Created With Document ID: " + docD);
			searchTest.doSearchDocument(docD);
			Thread.sleep(3000);
			
			
			
			 * Step-27 (Edit docD Part left)
			 * 
			 * 
			 * TODO After Bug Fix: GLM-1482
			 * 
			 
			
			
			
			 * TODO After Bug Fix: GLM-1462 
			 * 
			 * Step- 28-29
			 *
			 
			
			
			 
			 * Step-30-31 (OOS)
			 * 
			 * 
			 
			
			searchTest.doSearchDocument(docA);							// Step-35
			Thread.sleep(3000);
			ddTest.initializeActionMenu();
			String edit = ddTest.edit.getText();
			assertTrue(edit.contains("Edit"),true, edit.contains("Edit"));
			Log.info(edit);
			String view = ddTest.view.getText();
			assertTrue(view.contains("View"),true, view.contains("View"));
			Log.info(view);
			String processManagement = ddTest.processManagement.getText();
			assertTrue(processManagement.contains("Process Management"),true, processManagement.contains("Process Management"));
			Log.info(processManagement);
			String relationshipManagement = ddTest.relationshipManagement.getText();
			assertTrue(relationshipManagement.contains("Relationship Management"),true, relationshipManagement.contains("Relationship Management"));
			Log.info(relationshipManagement);
			
			
			
			ht.initializeLeftNavigationObjects();			// Step-36
			ht.repository.click();
			ht.initializeRepository();
			ht.productLabeling.click();
			Thread.sleep(1000);
			
			ht.initializeProductLabeling();
			ht.docSearchIcon.click();
			ht.docIdSearch.sendKeys("Alkaline Aqua");
			ht.initializeProductSearchResult();
			ht.productSearchResult.click();
			Thread.sleep(2000);
			
			ht.initializeProductLabeling();
			ht.docSearchIcon.click();
			ht.docIdSearch.sendKeys("United States");
			ht.initializeCountrySearchResult();
			ht.countrySearchResult.click();
			Thread.sleep(2000);
			
			ht.initializeProductLabeling();
			ht.docSearchIcon.click();
			ht.docIdSearch.sendKeys("Blister Labeling Text");
			ht.initializeDocTypeSearchResult();
			ht.docTypeSearchResult.click();
			Thread.sleep(2000);
			
			ht.initializeProductLabeling();
			ht.docSearchIcon.click();
			ht.docIdSearch.sendKeys(docB);
			ht.initializeDocIDSearchResult();
			String docID1 = ht.docId.getText();
			getScreenShot("ST-025", "SR-SD-27_and_SR-DR-2");
			assertTrue(docID1.contains(docB),true, docID1.contains(docB));
			Log.info (docID1);
			
			searchTest.doSearchDocument(docB);				// step-37
			searchTest.initializeSearchResult();
			searchTest.searchIcon.click();
			searchTest.documentId.sendKeys(docB);
			searchTest.language1.sendKeys("French");
			getScreenShot("ST-025", "SR-RS-2");
			String docID2 = searchTest.secondLine.getText();
			Log.info(docID2);
			assertTrue(docID2.contains(docB), true, docID2.contains(docB));
			String language = searchTest.secondLine.getText();
			Log.info (language);
			assertTrue(docID2.contains("French"), true, docID2.contains("French"));
			
			searchTest.myDocIcon.click();
		
			Thread.sleep(2000);
			searchTest.doEditSearchView (docA); 		//step-38
			searchTest.initializeSearchResult();
			searchTest.myDocIcon.click();
			
			ht.initializeLeftNavigationObjects();
			ht.myDoc.click();
			
			initializeMyDocuments();			// Step-39
			myDocTblSearchIcon.click();
			myDocSearch.sendKeys(docB);
			Thread.sleep(2000);
			getScreenShot("ST-025", "SR-MD-3");
			searchTest.initializeSearchResult();
			String docID3 = searchTest.firstLine.getText();
			assertTrue(docID3.contains(docB), true, docID3.contains(docB));
			Log.info(docID3);
		
			
			initializeMyDocuments();			// Step-40
			myDocSearch.clear();
			myDocTblSearchIcon.click();
			myDocSearch.sendKeys(docA);
			Thread.sleep(2000);
			searchTest.initializeSearchResult1();
			searchTest.selectDoc1.click();
			Thread.sleep(2000);
			getScreenShot("ST-025", "SR-MD-7");
			searchTest.initializeSearchResult();
			String docID4 = searchTest.firstLine.getText();
			assertTrue(docID4.contains(docA), true, docID4.contains(docA));
			Log.info(docID4);
			
			
			  TODO Step- 41 ( Have some issue to understand requirement)
			 * 
			 * 
			 
			
			searchTest.doSearchDocument (docA); 		//step-42
			searchTest.initializeSearchResult();
			searchTest.myDocIcon.click();
			Thread.sleep(2000);
			searchTest.doEditSearchView (docB); 		
			searchTest.initializeSearchResult();
			searchTest.myDocIcon.click();
			
			initializeMyDocuments();			
			myDocTblSearchIcon.click();
			myDocSearch.sendKeys(docB);
			Thread.sleep(2000);
			getScreenShot("ST-025", "SR-MD-2_B");
			searchTest.initializeSearchResult();
			String docID5 = searchTest.firstLine.getText();
			assertTrue(docID5.equals(null), true, docID5.equals(null));
			
			initializeMyDocuments();			
			myDocSearch.clear();
			myDocTblSearchIcon.click();
			myDocSearch.sendKeys(docA);
			Thread.sleep(2000);
			getScreenShot("ST-025", "SR-MD-2_A");
			searchTest.initializeSearchResult();
			String docID6 = searchTest.secondLine.getText();
			assertTrue(docID6.equals(null), true, docID6.equals(null));*/

			
			
			initializeSearch();						// Step- 45 (its OOS but for test step-46 we have added test steps for that)
			searchIcon.click();
			Thread.sleep(3000);
			searchTest.initializeBasicSearch();
			searchTest.countrytextField.sendKeys("United States");
			searchTest.countrytextField.sendKeys(Keys.ARROW_DOWN);
			searchTest.countrytextField.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			searchTest.advanceSearch.click();
			Thread.sleep(2000);
			searchTest.initializeSelectDocType();
			searchTest.selectDocTypeAnnexII.click();
			searchTest.initializeBasicSearch();
			searchTest.searchDocBtn.click();
			
			/*
			 * 
			 * TODO : cont. from step 46
			 */
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("xmL-ST-025.doc tested unsuccessfully");
			Log.endTestCase("Search for Documents and Dynamic Views System Test Failed");
		}

	}

	
	
	
	
	
	
	
	
	
	
	
	

	// @AfterClass
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();

	}
}
