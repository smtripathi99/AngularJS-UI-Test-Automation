package com.ig.automation.systemtest;

import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ig.automation.coreactions.DataActions;
import com.ig.automation.screens.SystemTestScreen;
import com.ig.automation.test.ChangeLifeCycleStateTest;
import com.ig.automation.test.CheckinTest;
import com.ig.automation.test.CreateDocumentTest;
import com.ig.automation.test.DocumentRelationshipTest;
import com.ig.automation.test.DocumentTranslationTest;
import com.ig.automation.test.EditPropertiesTest;
import com.ig.automation.test.HAInterActionTest;
import com.ig.automation.test.HomeTest;
import com.ig.automation.test.LoginTest;
import com.ig.automation.utility.Log;


public class TranslationsSystemTest extends SystemTestScreen {

	LoginTest loginTest = new LoginTest();
	CreateDocumentTest cdTest = new CreateDocumentTest();
	DocumentTranslationTest dtTest = new DocumentTranslationTest();
	DocumentRelationshipTest drTest = new DocumentRelationshipTest();
	HomeTest ht = new HomeTest();
	EditPropertiesTest edit = new EditPropertiesTest();
	CheckinTest checkinTest = new CheckinTest();
	ChangeLifeCycleStateTest clsTest = new ChangeLifeCycleStateTest();
	HAInterActionTest haTest = new HAInterActionTest();

	/**
	 * Test the Translations System Test of UI 7.0 against the xmL-ST-020
	 * 
	 * @throws Exception If an error occurs.
	 */

	@Test
	public void testTranslationST() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Translations System Test Started");

		try {
			loginTest.launchUrl();
			String username = DataActions.getUserID("role_eu_labeling_author");
			String password = DataActions.getUserPassword("role_eu_labeling_author");
			loginTest.doLogin(username, password);
			initializeAction();
			actions.click();
			Thread.sleep(1000);
			initializeCreate();
			createDoc.click();
			inilializeObjectsDocType();
			clEU.click();
			Thread.sleep(3000);
			String docB = cdTest.doCreateDocument("Consolidated Label (EU)", "", "European Union", "English", "Alkaline Aqua", "", "", "");// 05
			Assert.assertTrue(docB.contains("CL"), "Document B " + docB + " is created.");
			Log.info("Document B " + docB + " is created.");
			clEU.click();
			Thread.sleep(3000);
			String docA = cdTest.doCreateDocument("Consolidated Label (EU)", "", "European Union", "English", "Alkaline Aqua", "", "", "");// 06
			Assert.assertTrue(docA.contains("CL"), "Document A " + docA + " is created.");
			Log.info("Document A " + docA + " is created.");
			dtTest.doCreateTranslation(docA, new String[] {"Bulgarian"}); // 7
			getScreenShot("ST-020", "Document-SR-TR-11.jpg");
			Log.info("Bulagarian Translation of Document A " + docA + " is created.");
			clEU.click();
			Thread.sleep(3000);
			String docC = cdTest.doCreateDocument("Consolidated Label (EU)", "", "European Union", "English", "Alkaline Aqua", "", "", "");// 08
			searchDocument(docC);
			Assert.assertTrue(docC.contains("CL"), "Document C " + docC + " is created.");
			Log.info("Document C " + docC + " is created.");
			searchDocument(docA);
			selectDoc.click();
			String drResult = drTest.doLinkSupportingDocumentSearch(docB);// 09
			Assert.assertTrue(drResult.contains("success"), "Supporting Document relationship is established between Document A and Document B");
			Log.info("Supporting Document relationship is established between Document A and Document B");
			String dtResult = dtTest.doCreateTranslation(docA, new String[] {"French"}); // 10
			// searchDocument(docA);
			Assert.assertTrue(dtResult.contains("request sent"), "French Translation of Document A " + docA + " is created.");
			getScreenShot("ST-020", "Document-SR-TR-1-7-11.jpg");
			Log.info("French Translation of Document A " + docA + " is created.");
			searchDocument(docA);
			selectDoc.click();
			initializeAuditTab();
			Assert.assertTrue(auditComment.getText().contains("French translation relationship established with " + docA + "v0.1-FR"));
			Log.info("French translation relationship established with " + docA + "v0.1-FR");
			getScreenShot("ST-020", "DocumentA-SR-TR-12.jpg");
			String dtResultsame = dtTest.doCreateTranslation(docA, new String[] {"French"}); // 18
			Assert.assertTrue(dtResultsame.contains("language is not listed in Available Languages"),
					"French language is not listed in Available Languages in Create New Translation screen");
			Log.info("The system will not allow the user to translate a component for a language that already exists");
			String dtResultGerman = dtTest.doCreateTranslation(docA, new String[] {"German"}); // 20
			Assert.assertTrue(dtResultGerman.contains("request sent"), "German Translation of Document A " + docA + " is created.");
			searchDocument(docA);
			selectDoc.click();
			dtTest.initializeTranslationTab();
			dtTest.translationTab.click();
			getScreenShot("ST-020", "SR-TR-1-4-7.jpg");
			ht.initializeLeftNavigationObjects();
			ht.inbox.click();
			initializeInboxTabs();
			notifTab.click();
			initializeNotifTabDetails();
			Assert.assertTrue(notifTabFirstrowDoc.getText().contains("German"),
					"Notification has been received in the Inbox for the successful creation of the German translation document for Document A");
			Log.info("Notification has been received in the Inbox for the successful creation of the German translation document for Document A");
			String dtResultMul = dtTest.doCreateTranslation(docA, new String[] {"Danish", "Dutch", "Finnish"}); // 18
			Assert.assertTrue(dtResultMul.contains("request sent"), "Document IDs of Danish, Dutch and Finnish partial translation documents of Document A are created.");
			getScreenShot("ST-020", "Document-A-SR-TR-1-4-7.jpg");
			Log.info("Document IDs of Danish, Dutch and Finnish partial translation documents of Document A are created.");
			dtTest.translationTab.click();
			getScreenShot("ST-020", "SR-TR-1-4-7-1.jpg");
			ht.inbox.click();
			initializeInboxTabs();
			notifTab.click();
			initializeNotifTabDetails();
			Assert.assertTrue(notifTabFirstrowDoc.getText().contains("Danish"),
					"Notification has been received in the Inbox for the successful creation of the Danish translation document for Document A");
			Log.info("Notification has been received in the Inbox for the successful creation of the Danish translation document for Document A");
			searchDocument(docA + "v0.1-DA");
			selectDoc.click();
			viewProperties(docA + "v0.1-DA");
			dtTest.initializeTranslationTab();
			dtTest.translationTab.click();
			getScreenShot("ST-020", "SR-TR-5.jpg");
			Log.info("Dutch, Finnish, German and French translations of Document A are also displayed in the Translations section on the homepage of Danish translation of Document A");
			dtTest.doConvertToExactTranslation(docA, "French");
			Assert.assertTrue(dtTest.partialTranslation.getText().contains("Exact"), "The French translation of Document A is now an exact translation");
			getScreenShot("ST-020", "SR-RM-2.jpg");
			Log.info("The French translation of Document A is now an exact translation");
			searchDocument(docA);
			selectDoc.click();
			initializeAuditTab();
			Assert.assertTrue(auditComment.getText().contains("Audit trail has been recorded for the convert to exact event"));
			getScreenShot("ST-020", "DocumentA-SR-TR-32.jpg");
			Log.info("Audit trail has been recorded for the convert to exact event" + datetimeAudit.getText());
			checkinTest.doCheckin(docA + "v0.1-FR");
			Log.info("Document A French Translation is checked in as new version 0.2");
			checkinTest.doCheckin(docA + "v0.1-NL");
			Log.info("Document A Dutch Translation is checked in as new version 0.2");
			searchDocument(docA);
			selectDoc.click();
			dtTest.initializeTranslationTab();
			dtTest.translationTab.click();
			getScreenShot("ST-020", "SR-TR-31.jpg");
			dtTest.initializeExactTranslationListing();
			dtTest.initializeSearchTranslationListing();
			dtTest.searchLanguageColumn.click();
			dtTest.enterLanguageColumn.sendKeys("French");
			Assert.assertTrue(dtTest.translatedVersion.getText().contains("0.1"), "Exact translation versions and latest partial translation versions are listed on the homepage");

			dtTest.searchLanguageColumn.click();
			dtTest.enterLanguageColumn.sendKeys("Dutch");
			Assert.assertTrue(dtTest.translatedVersion.getText().contains("0.1"), "Exact translation versions and latest partial translation versions are listed on the homepage");

			dtTest.searchLanguageColumn.click();
			dtTest.enterLanguageColumn.sendKeys("Finnish");
			Assert.assertTrue(dtTest.translatedVersion.getText().contains("0.1"), "Exact translation versions and latest partial translation versions are listed on the homepage");
			Log.info("Exact translation versions and latest partial translation versions are listed on the homepage");

			dtTest.searchLanguageColumn.click();
			dtTest.enterLanguageColumn.sendKeys("German");
			Assert.assertTrue(dtTest.translatedVersion.getText().contains("0.1"), "Exact translation versions and latest partial translation versions are listed on the homepage");
			Log.info("Exact translation versions and latest partial translation versions are listed on the homepage");

			dtTest.doSendforTranslation(docA, "French");
			getScreenShot("ST-020", "SR-TR-34.jpg");
			Log.info("Send for Translation dialog is initially displayed. Document B is displayed as the supporting document and all the applicable renditions of Document A are displayed");

			ht.inbox.click();
			initializeInboxTabs();
			notifTab.click();
			initializeNotifTabDetails();
			Assert.assertTrue(notifTabFirstrowDoc.getText().contains("Send for Translation"),
					"Verify notification is received in current user’s inbox for Document successfully Sent for Translation.");
			Log.info("Verify notification is received in current user’s inbox for Document successfully Sent for Translation.");

			searchDocument(docA + "v0.1-FR");
			selectDoc.click();
			initializeAuditTab();
			Assert.assertTrue(auditComment.getText().contains("Document sent for translation"));
			getScreenShot("ST-020", "DocumentA-FR.jpg");
			Log.info("Audit Trail is recorded correctly for “Send for Translation” event." + datetimeAudit.getText());

			String checkinResult = checkinTest.doCheckin(docA + "v0.1-FR");
			Assert.assertTrue(checkinResult.contains("error"),
					"System displays an error message indicating the selected document(s) have been sent for translation via the Send for Translation function and cannot be checked in");
			Log.info("System displays an error message indicating the selected document(s) have been sent for translation via the Send for Translation function and cannot be checked in");
			viewProperties(docA + "v0.1-FR");
			Log.info("Send for Translation property is not available");

			String rctransResult = dtTest.doReceiveTranslation(docA + "v0.1-FR");
			Assert.assertTrue(
					rctransResult.contains("success"),
					"Homepage of Document A French Translation is displayed.Version 0.2 of Document A French Translation is checked in the system as version 0.3 and converted to the Exact Translation and version 0.1 of Document A French Translation is converted to Historic Exact.");
			Log.info("Homepage of Document A French Translation is displayed.Version 0.2 of Document A French Translation is checked in the system as version 0.3 and converted to the Exact Translation and version 0.1 of Document A French Translation is converted to Historic Exact.");
			getScreenShot("ST-020", "SR-TR-35.jpg");

			searchDocument(docA + "v0.2-FR");
			selectDoc.click();
			initializeAuditTab();
			Assert.assertTrue(auditComment.getText().contains("Receive Translation"));
			Log.info("Audit Trail is correctly recorded for the “Receive Translation” event");

			searchDocument(docA + "v0.3-FR");
			selectDoc.click();
			initializeAuditTab();
			Assert.assertTrue(auditComment.getText().contains("convert to exact"));
			Log.info("Audit trail has been recorded for the convert to exact event + datetimeAudit.getText()");
			getScreenShot("ST-020", "SR-TR-32.jpg");

			dtTest.doConvertToExactTranslation(docA, "German");
			Assert.assertTrue(dtTest.partialTranslation.getText().contains("Exact"), "The German translation of Document A is now an exact translation");
			getScreenShot("ST-020", "SR-RM-27.jpg");
			Log.info("The German translation of Document A is now an exact translation");
			logOff.click();

			loginTest.doLogin(username, password);
			String partrans = dtTest.doCovertToPartialTranslation(docA, "German");
			Assert.assertTrue(dtTest.partialTranslation.getText().contains("Partial"), "The German translation of Document A is now an partial translation");
			getScreenShot("ST-020", "SR-RM-30.jpg");
			Log.info("The German translation of Document A is now an exact translation");

			String checkinResult1 = checkinTest.doCheckin(docA);
			Assert.assertTrue(checkinResult1.contains("success"), "Document A is checked in as new version 0.2.Version 0.1 is promoted to the Historical state.");
			Log.info("Document A is checked in as new version 0.2. Version 0.1 is promoted to the Historical state.");

			String dtResultFG = dtTest.doCreateTranslation(docA, new String[] {"French", "Greek"});
			Assert.assertTrue(dtResultFG.contains("request sent"), "French and Greek Translation of Document A v0.2" + docA + " is created.");
			getScreenShot("ST-020", "Document-SR-TR-1.jpg");
			Log.info("The homepage of document A version 0.2 is displayed.Screen print is captured, labeled and attached.");

			String dtResultDDF = dtTest.doCreateTranslation(docA, new String[] {"Danish", "Dutch", "Finnish"});
			Assert.assertTrue(dtResultDDF.contains("request sent"), "Danish, Dutch and Finnish Translation of Document A v0.2" + docA + " is created.");
			getScreenShot("ST-020", "Document-SR-TR-33.jpg");
			Log.info("The homepage of document A version 0.2 is displayed.Screen print is captured, labeled and attached.");
			logOff.click();

			String usernameapp = DataActions.getUserID("role_application_manager");
			String passwordapp = DataActions.getUserPassword("role_application_manager");
			loginTest.doLogin(usernameapp, passwordapp);

			clsTest.doChangeStateDrafttoIA(docA + "v0.2-DA");
			Log.info("Danish translation is promoted to the Internally Approved state");
			String hasub = haTest.doSubmitToHA(docA + "v0.2-DA");
			Assert.assertTrue(hasub.contains("success"), "The Danish translation created in Step 70  is promoted to the HA Submitted state");
			Log.info("The Danish translation created in Step 70  is promoted to the HA Submitted state");

			List<String> harec = haTest.doRecordHAResponse(docA + "v0.2-DA");
			Assert.assertTrue(harec.contains("success"), "The Danish translation created above is promoted to major version 1.0 and HA Approved state.");
			Log.info("The Danish translation created above is promoted to major version 1.0 and HA Approved state.");
			logOff.click();

			loginTest.doLogin(username, password);

			String checkinResultA = checkinTest.doCheckin(docA);
			Assert.assertTrue(checkinResultA.contains("success"), "Document A is checked in as new version 0.3.Version 0.2 is promoted to the Historical state");
			Log.info("Document A is checked in as new version 0.3.Version 0.2 is promoted to the Historical state");

			searchDocument(docA);// v0.2
			// TODO
			// Navigate to homepage of Document A version 0.2. Verify that the Dutch and Finnish translations have been promoted to the Historical state.
			// Print, label and attach the screen print

			searchDocument(docA);// v0.3
			String dtResultDD = dtTest.doCreateTranslation(docA, new String[] {"Danish", "Dutch"});
			Assert.assertTrue(dtResultDD.contains("request sent"), "Danish and Dutch Translation of Document A v0.3" + docA + " is created.");
			Log.info("The homepage of document A version 0.3 is displayed.Screen print is captured, labeled and attached.");

			logOff.click();

			loginTest.doLogin(usernameapp, passwordapp);

			clsTest.doChangeStateDrafttoIA(docA + "v0.3-DA");
			Log.info("Danish translation is promoted to the Internally Approved state");

			String hasub3 = haTest.doSubmitToHA(docA + "v0.3-DA");
			Assert.assertTrue(hasub3.contains("success"), "The Danish translation created above is promoted to the HA Submitted state");
			Log.info("The Danish translation created in Step 70  is promoted to the HA Submitted state");

			List<String> harec3 = haTest.doRecordHAResponse(docA + "v0.3-DA");
			Assert.assertTrue(harec3.contains("success"), "The Danish translation created above is promoted to major version 1.0 and HA Approved state.");
			Log.info("The Danish translation created above is promoted to major version 1.0 and HA Approved state.");

			searchDocument(docA);// v0.2

			searchDocument(docA);// v0.3
			String clsResult = clsTest.doChangeStateDrafttoIA(docA);
			Assert.assertTrue(clsResult.contains("success"), "Document A version 0.3 is promoted to version 1.0.");

			Log.info("Document A version 0.3 is promoted to version 1.0.");

			String hasubA3 = haTest.doSubmitToHA(docA);
			Assert.assertTrue(hasubA3.contains("success"), "Document A version 0.3 is promoted to the HA Submitted state");
			Log.info("Document A version 0.3 is promoted to the HA Submitted state");

			List<String> harecA3 = haTest.doRecordHAResponse(docA);
			Assert.assertTrue(harecA3.contains("success"), "Document A version 0.3 is promoted to major version 1.0 and HA Approved state");
			Log.info("Document A version 0.3 is promoted to major version 1.0 and HA Approved state");

			searchDocument(docA);// v1.0
			// Verify that the Document ID of the Dutch translation is updated to reflect the updated version number of the master document as stated below:
			// “Document ID of the English Master (object.object_name) and append the following:“v” + <version number of master document> + “-“ + <2-letter Language Abbreviation>”.
			// Record the Document ID of the Dutch Translation
			// Print, label and attach the screen print

			// Navigate to the Consolidated Label (EU)/Translations folder in the repository.
			// Verify that the Dutch and the Finnish translations recorded in step 79 are deleted.
			// Verify that the Danish translation recorded in step 87 is listed in the corresponding Translations folder.
			// Print, label and attach the screen print

			searchDocument(docC);// v0.1
			String dtResultFC = dtTest.doCreateTranslation(docA, new String[] {"French"});
			Assert.assertTrue(dtResultFC.contains("request sent"), "French Translation of Document C v0.1" + docC + " is created.");
			Log.info("The homepage of document C version 0.1 is displayed.");

			String checkinResultCFR = checkinTest.doCheckin(docC + "v0.1-FR");
			Assert.assertTrue(checkinResultCFR.contains("success"), "Document C French Translation is checked in as new version");
			Log.info("Document C French Translation is checked in as new version");

			String checkinResultC = checkinTest.doCheckin(docC);
			Assert.assertTrue(checkinResultC.contains("success"), "Document C version 0.2 is created.");
			Log.info("Document C version 0.2 is created.");

			searchDocument(docC);// v0.2

			String dtResultFGC = dtTest.doCreateTranslation(docC, new String[] {"French", "German"});
			Assert.assertTrue(dtResultFGC.contains("request sent"), "German and French Translations of Document C version 0.2 are created.");
			Log.info("German and French Translations of Document C version 0.2 are created");

			// View the content of Document C version 0.2.
			// View the content of the German translation recorded in step 93.
			// Verify that the content of the German translation is the same as the content of Document C.
			// Print, label, and attach the content of the viewed French translations

			// Locate and select the French Translation recorded in step 93 and promote it to In Review State via Route for Review function.
			// Verify that the French Translation is promoted to the In Review state

			String checkinResultC3 = checkinTest.doCheckin(docC);
			Assert.assertTrue(checkinResultC3.contains("success"), "Document C version 0.3 is created.");
			Log.info("Document C version 0.3 is created.");

			String dtResultFC3 = dtTest.doCreateTranslation(docC, new String[] {"French"});
			Assert.assertTrue(!dtResultFC3.contains("request sent"), "A warning message is displayed.");
			Log.info("A warning message is displayed.");
			getScreenShot("ST-020", "Document-SR-TR-41.jpg");

			logOff.click();

			loginTest.doLogin(usernameapp, passwordapp);

			// Create a Centralised Procedure and link an existing Partial Translated Annex II document.
			// Link another Blister document which is Exact Translation.
			// Link another SMPC document with pending translation.
			// Go to Translation Status of tab from home page of Centralised Procedure.
			// Print, label, and attach a screen print.

			Reporter.log("xmL-ST-020.doc tested successfully");
			Log.endTestCase("Translations System Test Ended Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("xmL-ST-020.doc tested unsuccessfully");
			Log.endTestCase("Translations System Test Failed");
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
