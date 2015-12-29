package com.ig.automation.test;

import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ig.automation.screens.DocumentTranslationScreen;
import com.ig.automation.utility.Log;


public class DocumentTranslationTest extends DocumentTranslationScreen {

	HomeTest homeTest = new HomeTest();

	@BeforeClass
	public void login() {
		try {
			homeTest.testHome();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test the UI 7.0 against the xmL-UI-ADS-016 Document Translation 2.1 Create New Translation
	 * 
	 * @throws Exception If an error occurs.
	 * 
	 */
	@Test
	public void testCreateTranslation() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Create Translation Test Started");
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
			Thread.sleep(2000);
			searchButton.click();
			Thread.sleep(2000);
			initializeDocument();
			filterDocID.click();
			initializeTranslationTab();
			translationTab.click();
			initializeCreateTranslationLink();
			createTranslation.click();
			initializeCreateTranslationPanel();
			Assert.assertTrue(translationLabel.isDisplayed()); // A-TR-1
			Log.info("A-TR-1 Passed");
			Assert.assertTrue(transAllLanguage.isDisplayed()); // A-TR-4
			Log.info("A-TR-4 Passed");
			Assert.assertTrue(transLanguage.isDisplayed()); // A-TR-5
			Log.info("A-TR-5 Passed");
			Assert.assertFalse(createTranslation.isSelected()); // A-TR-6
			Log.info("A-TR-6 Passed");
			transLanguage.clear();
			transLanguage.sendKeys("French"); // A-TR-9
			Log.info("A-TR-9 Passed");
			transLanguage.sendKeys(Keys.ARROW_DOWN);
			transLanguage.sendKeys(Keys.ENTER);
			// transAllLanguage.click(); //A-TR-8
			Log.info("A-TR-8 Passed");
			initializeDoneCancel();
			Assert.assertTrue(cancelTransButton.isEnabled()); // A-TR-7
			Log.info("A-TR-7 Passed");
			Assert.assertTrue(crTransButton.isEnabled());
			crTransButton.click();
			Reporter.log("xmL-UI-ADS-016.doc Create Translation tested successfully");
		} catch (Throwable e) {
			Log.info(e.getMessage());
			Reporter.log("xmL-UI-ADS-016.doc Create Translation tested unsuccessfully");
			Assert.fail();
		}
		Log.endTestCase("Create Translation Test Ended");

	}

	/**
	 * Test the UI 7.0 against the xmL-UI-ADS-016 Document Translation 2.2 Convert To Exact Translation
	 * 
	 * @throws Exception If an error occurs.
	 * 
	 */
	@Test
	public void testConvertToExactTranslation() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Convert To Exact Translation Test Started");
		try {
			String docID = getDocID("AN");
			initializeSearch();
			searchDoc.click();
			initializeBasicSearch();
			basicSearch.click();
			initializeDocIDSearch();
			docIDSearchdropdown.selectByVisibleText("=");
			enterDocIDbox.clear();
			enterDocIDbox.sendKeys(docID);
			Thread.sleep(2000);
			searchButton.click();
			Thread.sleep(2000);
			initializeDocument();
			filterDocID.click();
			initializeTranslationTab();
			translationTab.click();
			initializeTranslationListing();
			partialTranslation.click();
			initializeExactTranslationListing();
			Assert.assertTrue(convertExactLabel.isDisplayed()); // A-ET-1
			Log.info("A-ET-1 Passed");
			Assert.assertTrue(convertExactMessage.isDisplayed()); // A-ET-4
			Log.info("A-ET-4 Passed");
			translatedVersion.click();
			initializeDoneCancel();
			Assert.assertTrue(crTransButton.isDisplayed()); // A-ET-6
			Log.info("A-ET-6 Passed");
			Assert.assertTrue(cancelTransButton.isDisplayed()); // A-ET-7
			Log.info("A-ET-7 Passed");
			crTransButton.click();
			Reporter.log("xmL-UI-ADS-009.doc Make Exact Translation tested successfully");
		} catch (Throwable e) {
			Log.info(e.getMessage());
			Reporter.log("xmL-UI-ADS-009.doc Make Exact Translation tested unsuccessfully");
			Assert.fail();

		}
		Log.endTestCase("Convert To Exact Translation Test Ended");

	}

	/**
	 * Test the UI 7.0 against the xmL-UI-ADS-016 Document Translation 2.2 Convert To Partial Translation
	 * 
	 * @throws Exception If an error occurs.
	 * 
	 */
	@Test
	public void testCovertToPartialTranslation() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Convert To Partial Translation Test Started");
		try {
			String docID = getDocID("AN");
			initializeSearch();
			searchDoc.click();
			initializeBasicSearch();
			basicSearch.click();
			initializeDocIDSearch();
			docIDSearchdropdown.selectByVisibleText("=");
			enterDocIDbox.clear();
			enterDocIDbox.sendKeys(docID);
			Thread.sleep(2000);
			searchButton.click();
			Thread.sleep(2000);
			initializeDocument();
			filterDocID.click();
			initializeTranslationTab();
			translationTab.click();
			initializeTranslationListing();
			partialTranslation.click();
			initializePartialTranslationListing();
			Assert.assertTrue(transChildDocid.getText().contains("FR")); // A-CPT-01
			Log.info("A-CPT-01 Passed");
			Assert.assertTrue(transChildDocid.getText().contains("Status")); // A-CPT-02
			Log.info("A-CPT-02 Passed");
			Assert.assertTrue(transChildDocid.getText().contains("Version")); // A-CPT-03
			Log.info("A-CPT-03 Passed");
			Assert.assertTrue(transChildDocid.getText().contains("Title")); // A-CPT-04
			Log.info("A-CPT-04 Passed");
			Assert.assertTrue(convertPartialLabel.isDisplayed()); // A-CPT-05
			Log.info("A-CPT-05 Passed");
			Assert.assertTrue(masterDocid.getText().contains(docID)); // A-CPT-06
			Log.info("A-CPT-06 Passed");
			Assert.assertTrue(masterDocid.getText().contains("Status")); // A-CPT-07
			Log.info("A-CPT-07 Passed");
			Assert.assertTrue(masterDocid.getText().contains("Version")); // A-CPT-08
			Log.info("A-CPT-08 Passed");
			Assert.assertTrue(masterDocid.getText().contains("Title")); // A-CPT-09
			Log.info("A-CPT-09 Passed");
			Assert.assertTrue(masterDocid.getText().contains("Language")); // A-CPT-10
			Log.info("A-CPT-10 Passed");
			initializeDoneCancel();
			Assert.assertTrue(crTransButton.isDisplayed()); // A-CPT-11
			Log.info("A-CPT-11 Passed");
			Assert.assertTrue(cancelTransButton.isDisplayed()); // A-CPT-12
			Log.info("A-CPT-12 Passed");
			crTransButton.click(); // A-CPT-13
			Log.info("A-CPT-13 Passed");
			Reporter.log("xmL-UI-ADS-009.doc Covert to Partial Translation tested successfully");
		} catch (Throwable e) {
			Log.info(e.getMessage());
			Reporter.log("xmL-UI-ADS-009.doc Covert to Partial Translation tested unsuccessfully");
			Assert.fail();

		}
		Log.endTestCase("Convert To Partial Translation Test Ended");

	}

	/**
	 * Test the UI 7.0 against the xmL-UI-ADS-016 Document Send for Translation
	 * 
	 * @throws Exception If an error occurs.
	 * 
	 */
	@Test
	public void testSendforTranslation() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Send for Translation Test Started");
		try {

			String docID = getDocID("AN");
			initializeSearch();
			searchDoc.click();
			initializeBasicSearch();
			basicSearch.click();
			initializeDocIDSearch();
			docIDSearchdropdown.selectByVisibleText("=");
			enterDocIDbox.clear();
			enterDocIDbox.sendKeys(docID);
			Thread.sleep(2000);
			searchButton.click();
			Thread.sleep(2000);
			initializeDocument();
			filterDocID.click();
			initializeTranslationTab();
			translationTab.click();
			initializeTranslationListing();
			translatledDoc.click();
			initializeActionMenu();
			sendforTranslationmenu.click();
			initializeSendforTranslationPanel();
			Assert.assertTrue(sendforTranslationLabel.isDisplayed()); // A-SFT-1
			Log.info("A-SFT-1 Passed");
			Assert.assertTrue(translateddoc.getText().contains("Status")); // A-SFT-3
			Log.info("A-SFT-3 Passed");
			Assert.assertTrue(translateddoc.getText().contains("Version")); // A-SFT-2
			Log.info("A-SFT-2 Passed");
			Assert.assertTrue(email.isEnabled()); // A-SFT-4
			Log.info("A-SFT-4 Passed");
			Assert.assertTrue(subject.isEnabled()); // A-SFT-5
			Log.info("A-SFT-5 Passed");
			Assert.assertTrue(message.isEnabled()); // A-SFT-6
			Log.info("A-SFT-6 Passed");
			Assert.assertTrue(translationSupport.isEnabled()); // A-SFT-7
			Log.info("A-SFT-7 Passed");
			Assert.assertTrue(msword.isDisplayed()); // A-SFT-8
			Log.info("A-SFT-8 Passed");
			email.sendKeys("snehmani.tripathi@ig.com");
			subject.sendKeys("Test");
			message.sendKeys("Test");
			translationSupport.click();
			msword.click();
			initializeDoneCancel();
			crTransButton.click();
			Reporter.log("xmL-UI-ADS-016.doc Send for Translation tested successfully");
		} catch (Throwable e) {
			Log.info(e.getMessage());
			Reporter.log("xmL-UI-ADS-016.doc Send for Translation tested unsuccessfully");
			Assert.fail();

		}
		Log.endTestCase("Send for Translation Test Ended");

	}

	/**
	 * Test the UI 7.0 against the xmL-UI-ADS-016 Document Receive Translation
	 * 
	 * @throws Exception If an error occurs.
	 * 
	 */
	@Test
	public void testReceiveTranslation() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Receive Translation Test Started");
		try {
			String docID = getDocID("AN");
			initializeSearch();
			searchDoc.click();
			initializeBasicSearch();
			basicSearch.click();
			initializeDocIDSearch();
			docIDSearchdropdown.selectByVisibleText("=");
			enterDocIDbox.clear();
			enterDocIDbox.sendKeys(docID);
			Thread.sleep(2000);
			searchButton.click();
			Thread.sleep(2000);
			initializeDocument();
			filterDocID.click();
			initializeTranslationTab();
			translationTab.click();
			initializeTranslationListing();
			translatledDoc.click();
			initializeActionMenu();
			receiveTranslationmenu.click();
			initializeReceiveTranslationPanel();
			Assert.assertTrue(receiveTranslationLabel.isDisplayed()); // A-RT-1
			Log.info("A-RT-1 Passed");
			Assert.assertTrue(transChildDocid.getText().contains("FR")); // A-RT-2
			Log.info("A-RT-2 Passed");
			Assert.assertTrue(transChildDocid.getText().contains("Status")); // A-RT-3
			Log.info("A-RT-3 Passed");
			Assert.assertTrue(transChildDocid.getText().contains("Version")); // A-RT-4
			Log.info("A-RT-4 Passed");
			Assert.assertTrue(saveAs.isDisplayed()); // A-RT-9
			Log.info("A-RT-9 Passed");
			reasonforRevision.selectByVisibleText("Other");
			Assert.assertTrue(makeExact.isDisplayed()); // A-RT-8
			Log.info("A-RT-8 Passed");
			makeExact.click();
			Assert.assertTrue(promote.isDisplayed()); // A-RT-7
			Log.info("A-RT-7 Passed");
			promote.click();
			initializePromotePanel();
			Assert.assertFalse(signatureMeaning.toString() == null); // A-RT-17
			Log.info("A-RT-17 Passed");
			Assert.assertTrue(userid.isDisplayed()); // A-RT-18
			Log.info("A-RT-18 Passed");
			Assert.assertTrue(password.isDisplayed()); // A-RT-19
			Log.info("A-RT-19 Passed");
			Assert.assertTrue(confirmSig.isDisplayed()); // A-RT-20
			Log.info("A-RT-20 Passed");
			signatureMeaning.selectByVisibleText("Author Approval");
			userid.sendKeys("appmanager01");
			password.sendKeys("password");
			confirmSig.click();
			crTransButton.click();
			Reporter.log("xmL-UI-ADS-016.doc Receive Translation tested successfully");
		} catch (Throwable e) {
			Log.info(e.getMessage());
			Reporter.log("xmL-UI-ADS-016.doc Receive Translation tested unsuccessfully");
			Assert.fail();

		}
		Log.endTestCase("Receive Translation Test Ended");

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

	public String doCreateTranslation(String docid, String[] lang) throws Exception {

		try {
			// String docID=getDocID(docid);
			initializeSearch();
			searchDoc.click();
			initializeBasicSearch();
			basicSearch.click();
			initializeDocIDSearch();
			Thread.sleep(2000);
			docIDSearchdropdown.selectByVisibleText("=");
			enterDocIDbox.clear();
			enterDocIDbox.sendKeys(docid);
			Thread.sleep(2000);
			searchButton.click();
			Thread.sleep(2000);
			initializeDocument();
			filterDocID.click();
			initializeTranslationTab();
			translationTab.click();
			initializeCreateTranslationLink();
			createTranslation.click();
			initializeCreateTranslationPanel();
			transLanguage.clear();
			transLanguage.sendKeys(lang);

			transLanguage.sendKeys(Keys.ARROW_DOWN);
			transLanguage.sendKeys(Keys.ENTER);
			initializeDoneCancel();
			if (transLanguage.getAttribute("value") == null) {
				cancelTransButton.click();
				return "Selected language is not listed in Available Languages in Create New Translation screen";
			} else {

				crTransButton.click();
				initializeMessages();
				return message.getText();
			}
		} catch (Throwable e) {
			Log.info(e.getMessage());
			return "Translation not created";
		}

	}

	public void doConvertToExactTranslation(String docid, String lang) throws Exception {

		try {

			initializeSearch();
			searchDoc.click();
			initializeBasicSearch();
			basicSearch.click();
			initializeDocIDSearch();
			docIDSearchdropdown.selectByVisibleText("=");
			enterDocIDbox.clear();
			enterDocIDbox.sendKeys(docid);
			Thread.sleep(2000);
			searchButton.click();
			Thread.sleep(2000);
			initializeDocument();
			filterDocID.click();
			initializeTranslationTab();
			translationTab.click();
			initializeTranslationListing();
			initializeSearchTranslationListing();
			searchLanguageColumn.click();
			enterLanguageColumn.sendKeys(lang);
			partialTranslation.click();
			initializeExactTranslationListing();
			Assert.assertTrue(convertExactLabel.isDisplayed()); // A-ET-1
			Log.info("A-ET-1 Passed");
			Assert.assertTrue(convertExactMessage.isDisplayed()); // A-ET-4
			Log.info("A-ET-4 Passed");
			translatedVersion.click();
			initializeDoneCancel();
			Assert.assertTrue(crTransButton.isDisplayed()); // A-ET-6
			Log.info("A-ET-6 Passed");
			Assert.assertTrue(cancelTransButton.isDisplayed()); // A-ET-7
			Log.info("A-ET-7 Passed");
			crTransButton.click();
			Reporter.log("xmL-UI-ADS-009.doc Make Exact Translation tested successfully");
		} catch (Throwable e) {
			Log.info(e.getMessage());
			Reporter.log("xmL-UI-ADS-009.doc Make Exact Translation tested unsuccessfully");
			Assert.fail();

		}
		Log.endTestCase("Convert To Exact Translation Test Ended");

	}

	public void doSendforTranslation(String docid, String lang) throws Exception {

		try {
			initializeSearch();
			searchDoc.click();
			initializeBasicSearch();
			basicSearch.click();
			initializeDocIDSearch();
			docIDSearchdropdown.selectByVisibleText("=");
			enterDocIDbox.clear();
			enterDocIDbox.sendKeys(docid);
			Thread.sleep(2000);
			searchButton.click();
			Thread.sleep(2000);
			initializeDocument();
			filterDocID.click();
			initializeTranslationTab();
			translationTab.click();
			initializeTranslationListing();
			initializeSearchTranslationListing();
			searchLanguageColumn.click();
			enterLanguageColumn.sendKeys(lang);
			translatledDoc.click();
			initializeActionMenu();
			sendforTranslationmenu.click();
			initializeSendforTranslationPanel();
			email.sendKeys("snehmani.tripathi@ig.com");
			subject.sendKeys("Test");
			message.sendKeys("Test");
			translationSupport.click();
			msword.click();
			initializeDoneCancel();
			crTransButton.click();
		} catch (Throwable e) {
			Log.info(e.getMessage());
		}

	}
	
	public String doReceiveTranslation(String docid) throws Exception {
		
		try {
			
			initializeSearch();
			searchDoc.click();
			initializeBasicSearch();
			basicSearch.click();
			initializeDocIDSearch();
			docIDSearchdropdown.selectByVisibleText("=");
			enterDocIDbox.clear();
			enterDocIDbox.sendKeys(docid);
			Thread.sleep(2000);
			searchButton.click();
			Thread.sleep(2000);
			initializeDocument();
			filterDocID.click();
			initializeTranslationTab();
			translationTab.click();
			initializeTranslationListing();
			
			translatledDoc.click();
			initializeActionMenu();
			receiveTranslationmenu.click();
			initializeReceiveTranslationPanel();			
			reasonforRevision.selectByVisibleText("Other");			
			makeExact.click();
			promote.click();
			initializePromotePanel();			
			signatureMeaning.selectByVisibleText("Author Approval");
			userid.sendKeys("appmanager01");
			password.sendKeys("password");
			confirmSig.click();
			crTransButton.click();
			return "Recieve Translation success";
		} catch (Throwable e) {
			Log.info(e.getMessage());
			return "Recieve Translation error";
		}

	}
	
	public String doCovertToPartialTranslation(String docid, String lang) throws Exception {
		
		try {
			initializeSearch();
			searchDoc.click();
			initializeBasicSearch();
			basicSearch.click();
			initializeDocIDSearch();
			docIDSearchdropdown.selectByVisibleText("=");
			enterDocIDbox.clear();
			enterDocIDbox.sendKeys(docid);
			Thread.sleep(2000);
			searchButton.click();
			Thread.sleep(2000);
			initializeDocument();
			filterDocID.click();
			initializeTranslationTab();
			translationTab.click();
			initializeTranslationListing();
			initializeSearchTranslationListing();
			searchLanguageColumn.click();
			enterLanguageColumn.sendKeys(lang);
			partialTranslation.click();
			initializeExactTranslationListing();
			partialTranslation.click();
			initializePartialTranslationListing();
			initializeDoneCancel();			
			crTransButton.click();
			return "convert partial success";
			
		} catch (Throwable e) {
			Log.info(e.getMessage());
			return "convert partial error";
		}

	}

	/*
	 * @AfterClass public void tearDown() throws Exception{ driver.close(); driver.quit(); System.out.println("Passed:Login screen is tested successfully."); }
	 */
}
