package com.ig.automation.test;

import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ig.automation.screens.DocumentRelationshipScreen;
import com.ig.automation.screens.DocumentTranslationScreen;
import com.ig.automation.screens.EditPropertiesScreen;
import com.ig.automation.utility.Log;


public class DocumentRelationshipTest extends DocumentRelationshipScreen {

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
	 * Test the Document Relationship of UI 7.0 against the xmL-UI-ADS-019 Link Source Document using MyDocs
	 * 
	 * @throws Exception If an error occurs.
	 * 
	 */
	@Test
	public void testLinkSourceDocumentMyDocs() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Source Document Relationship using MyDocs Test Started");
		try {

			String docID = getDocID("USPI");
			initializeSearch();
			searchDoc.click();
			initializeBasicSearch();
			basicSearch.click();
			initializeDocIDSearch();
			Thread.sleep(2000);
			docIDSearchdropdown.selectByVisibleText("=");
			enterDocIDbox.clear();
			enterDocIDbox.sendKeys(docID);
			Thread.sleep(3000);
			searchButton.click();
			Thread.sleep(3000);
			initializeDocument();
			filterDocID.click();
			initializeSourceDocumentTab();
			sourceDocTab.click();
			initializeLinkSource();
			linkSource.click();
			initializeSearchSourceMyDoc();
			Assert.assertTrue(searchSourceLabel.isDisplayed());
			Log.info("UI-SDR-1 Passed");
			myDocSource.click();
			createRelationBtn.click();
			Log.info("UA-EP-9 Passed");
			Reporter.log("xmL-UI-ADS-019.doc Document Relationship tested successfully for Source");
		} catch (Throwable e) {
			Log.info(e.getMessage());
			Reporter.log("xmL-UI-ADS-019.doc Document Relationship tested successfully for Source");
			Assert.fail();
		}
		Log.endTestCase("Source Document Relationship using MyDocs Test Ended");
	}

	/**
	 * Test the Document Relationship of UI 7.0 against the xmL-UI-ADS-019 Link Source Document using Search
	 * 
	 * @throws Exception If an error occurs.
	 * 
	 */
	@Test
	public void testLinkSourceDocumentSearch() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Source Document Relationship using Search Test Started");
		try {

			String docID = getDocID("USPI");
			initializeSearch();
			searchDoc.click();
			initializeBasicSearch();
			basicSearch.click();
			initializeDocIDSearch();
			Thread.sleep(2000);
			docIDSearchdropdown.selectByVisibleText("=");
			enterDocIDbox.clear();
			enterDocIDbox.sendKeys(docID);
			Thread.sleep(3000);
			searchButton.click();
			Thread.sleep(3000);
			initializeDocument();
			filterDocID.click();
			initializeSourceDocumentTab();
			sourceDocTab.click();
			initializeLinkSource();
			linkSource.click();
			initializeSearchSourceMyDoc();
			// Assert.assertTrue(searchSourceLabel.isDisplayed());
			searchSource.click();
			searchDocBtn.click();
			// TODO search has bugs now
			createRelationBtn.click();
			Log.info("UA-EP-9 Passed");
			Reporter.log("xmL-UI-ADS-019.doc Document Relationship tested successfully for Source");
		} catch (Throwable e) {
			Log.info(e.getMessage());
			Reporter.log("xmL-UI-ADS-019.doc Document Relationship tested successfully for Source");
			Assert.fail();
		}
		Log.endTestCase("Source Document Relationship using Search Test Ended");
	}

	/**
	 * Test the Cancel Link Source Document Page of UI 7.0 against the xmL-UI-ADS-019
	 * 
	 * @throws Exception If an error occurs.
	 * 
	 */
	@Test
	public void testCancelLinkSourceDocument() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Link Source Doc Cancel Test Started");
		try {
			String docID = getDocID("AN");
			initializeSearch();
			searchDoc.click();
			initializeBasicSearch();
			basicSearch.click();
			initializeDocIDSearch();
			Thread.sleep(2000);
			docIDSearchdropdown.selectByVisibleText("=");
			enterDocIDbox.clear();
			enterDocIDbox.sendKeys(docID);
			Thread.sleep(3000);
			searchButton.click();
			Thread.sleep(3000);
			initializeDocument();
			filterDocID.click();
			initializeSourceDocumentTab();
			sourceDocTab.click();
			initializeLinkSource();
			linkSource.click();
			initializeSearchSourceMyDoc();
			cancelButton.click();
			Log.info("UA-EP-11 Passed");
			Reporter.log("xmL-UI-ADS-019.doc Link Source Document tested unsuccessfully for Cancel");
		} catch (Throwable e) {
			Log.info(e.getMessage());
			Reporter.log("xmL-UI-ADS-019.doc Link Source Document tested unsuccessfully for Cancel");
			Assert.fail();
		}
		Log.endTestCase("Link Source Doc Cancel Test Ended");

	}

	/**
	 * Test the Document Relationship of UI 7.0 against the xmL-UI-ADS-019 Link Source Document using MyDocs
	 * 
	 * @throws Exception If an error occurs.
	 * 
	 */
	@Test
	public void testLinkSupportingDocumentMyDocs() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Supporting Document Relationship using MyDocs Test Started");
		try {

			String docID = getDocID("AN");
			initializeSearch();
			searchDoc.click();
			initializeBasicSearch();
			basicSearch.click();
			initializeDocIDSearch();
			Thread.sleep(2000);
			docIDSearchdropdown.selectByVisibleText("=");
			enterDocIDbox.clear();
			enterDocIDbox.sendKeys(docID);
			Thread.sleep(3000);
			searchButton.click();
			Thread.sleep(3000);
			initializeDocument();
			filterDocID.click();
			initializeSupportingDocumentTab();
			supportDocTab.click();
			initializeLinkSource();
			linkSupport.click();
			initializeSearchSupportMyDoc();
			Assert.assertTrue(searchSupportingLabel.isDisplayed());
			Log.info("UI-SDR-1 Passed");
			myDocSupport.click();
			createRelationBtn.click();
			Log.info("UA-EP-9 Passed");
			Reporter.log("xmL-UI-ADS-019.doc Document Relationship tested successfully for Supporting docs");
		} catch (Throwable e) {
			Log.info(e.getMessage());
			Reporter.log("xmL-UI-ADS-019.doc Document Relationship tested successfully for Supporting docs");
			Assert.fail();
		}
		Log.endTestCase("Supporting Document Relationship using MyDocs Test Ended");
	}

	/**
	 * Test the Document Relationship of UI 7.0 against the xmL-UI-ADS-019 Link Source Document using Search
	 * 
	 * @throws Exception If an error occurs.
	 * 
	 */
	@Test
	public void testLinkSupportingDocumentSearch() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Supporting Document Relationship using Search Test Started");
		try {

			String docID = getDocID("USPI");
			initializeSearch();
			searchDoc.click();
			initializeBasicSearch();
			basicSearch.click();
			initializeDocIDSearch();
			Thread.sleep(2000);
			docIDSearchdropdown.selectByVisibleText("=");
			enterDocIDbox.clear();
			enterDocIDbox.sendKeys(docID);
			Thread.sleep(3000);
			searchButton.click();
			Thread.sleep(3000);
			initializeDocument();
			filterDocID.click();
			initializeSupportingDocumentTab();
			supportDocTab.click();
			initializeLinkSource();
			linkSupport.click();
			initializeSearchSupportMyDoc();
			// Assert.assertTrue(searchSourceLabel.isDisplayed());
			searchSource.click();
			searchDocBtn.click();
			// TODO search has bugs now
			createRelationBtn.click();
			Log.info("UA-EP-9 Passed");
			Reporter.log("xmL-UI-ADS-019.doc Document Relationship tested successfully for Supporting");
		} catch (Throwable e) {
			Log.info(e.getMessage());
			Reporter.log("xmL-UI-ADS-019.doc Document Relationship tested successfully for Supporting");
			Assert.fail();
		}
		Log.endTestCase("Supporting Document Relationship using Search Test Ended");
	}

	// helper for ST tests
	public String doLinkCRDocumentSearch(String docid) throws Exception {
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
			initializeCRTab();
			crLink.click();
			initializeDocDetails();
			linkCRLink.click();
			initializeSearchSupportMyDoc();
			// Assert.assertTrue(searchSourceLabel.isDisplayed());
			searchSource.click();
			searchDocBtn.click();
			// TODO search has bugs now
			createRelationBtn.click();
			initializeMessages();

			} 
			catch (Throwable e) {
			Log.info(e.getMessage());
			Reporter.log("xmL-UI-ADS-019.doc Document Relationship tested successfully for Supporting");
			Assert.fail();
		}
		return message.getText();
	}

	public String doLinkSupportingDocumentSearch(String linkdocid) throws Exception {
		try {

			initializeSupportingDocumentTab();
			supportDocTab.click();
			initializeLinkSupporting();
			linkSupport.click();
			initializeSearchSupportMyDoc();
			searchSource.click();
			initializeBasicSearchSupport();
			basicSearchLink.click();
			initializeBasicSearchOptions();
			basicSearchDocID.sendKeys(linkdocid);
			searchDocBtn.click();
			searchResultDocID.click();
			// TODO search has bugs now
			
			createRelationBtn.click();
			initializeMessages();
			return message.getText();

		} catch (Throwable e) {
			Log.info(e.getMessage());
			return "Create Relationship failed";

		}
	}
	
	
		
	public String doLinkSourceDocumentSearch(String linkdocid) throws Exception {
		try {

			initializeSourceDocumentTab();
			sourceDocTab.click();
			initializeLinkSource();
			linkSource.click();
			initializeSearchSourceMyDoc();
			// Assert.assertTrue(searchSourceLabel.isDisplayed());
			searchSource.click();
			initializeBasicSearchSupport();
			basicSearchLink.click();
			initializeBasicSearchOptions();
			basicSearchDocID.sendKeys(linkdocid);
			searchDocBtn.click();
			searchResultDocID.click();
			//searchDocBtn.click();
			// TODO search has bugs now
			createRelationBtn.click();
			initializeMessages();
			return message.getText();

		} catch (Throwable e) {
			Log.info(e.getMessage());
			return "Create Relationship failed";

		}
	}
	
	
	
	
	
	public String getDocID(String doctype) throws Exception {

		List<String[]> list = readCSV();
		for (String[] str : list) {
			for (String doc : str) {
				if (doc.contains(doctype)) return doc.toString();
			}
		}
		return null;
	}

	/*
	 * @AfterClass public void tearDown() throws Exception{ driver.close(); driver.quit(); System.out.println("Passed:Login screen is tested successfully."); }
	 */
}
