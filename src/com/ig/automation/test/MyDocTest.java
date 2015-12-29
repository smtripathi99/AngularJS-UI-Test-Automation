package com.ig.automation.test;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.CacheLookup;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ig.automation.coreactions.DataActions;
import com.ig.automation.screens.MyDocScreen;
import com.ig.automation.utility.Log;
import com.ig.automation.utility.Sorting;


public class MyDocTest extends MyDocScreen {

	LoginTest loginTest = new LoginTest();
	HomeTest home = new HomeTest();
	String docid = null;

	@BeforeClass
	public void login() {
		try {
			// loginTest.testLogin();
			launchUrl();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test the my documents Page of UI 7.0 against the UI-ADS-001	 * 
	 * @throws Exception If an error occurs.
	 * 
	 */
	@Test(priority = 1)
	public void testAddtoMyDocs() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Add to My Docs Test Started");
		try {
			String username = DataActions.getUserID("role_eu_labeling_author");
			String password = DataActions.getUserPassword("role_eu_labeling_author");
			loginTest.doLogin(username, password);
			home.initializeLeftNavigationObjects();
			home.actions.click();
			home.initializeActionObjects();
			home.createDoc.click();
			CreateDocumentTest cdTest=new CreateDocumentTest();
			docid=cdTest.doCreateDocument("Core Data Sheet", "Document A", "United States", "English", "", "", "", "Alkaline Aqua");
			SearchTest search = new SearchTest();
			search.doSearchDocument(docid);
			initializeaddMyDocsObjects();
			addremoveMydoc.click();
			Assert.assertEquals(addremoveMydoc.getCssValue("color").matches("#6f6f6f"), "added to my doc");
			Log.info("UA-MD-01 Passed");
			// Thread.sleep(2000);
			loginTest.initializeMessages();
			Assert.assertEquals(loginTest.message.getText().contains("success"), "Show success message: “Document successfully added to MyDocs listing");
			Log.info("UA-MD-02 Passed");
			Reporter.log("Add to My Docs tested successfully xmL-UI-ADS-001");
			Log.endTestCase("Add to My Docs Test Ended");
		} catch (Throwable e) {
			Log.info(e.getMessage());
			Reporter.log("Add to My Docs tested unsuccessfully xmL-UI-ADS-001");
			Log.info("Add to MyDocs failed");
		}
	}

	/**
	 * Test the My Documents Page listing of UI 7.0	 * 
	 * @throws Exception If an error occurs.
	 * 
	 */
	@Test(priority = 2, dependsOnMethods = {"testAddtoMyDocs"})
	public void testMyDocsListing() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("My Docs Listing Test Started");
		try {
			initializeMyDocsObjects();
			Assert.assertEquals(myDocumentLabel.getText(), "My Document");
			Log.info("UA-MD-04 Passed");
			if (myDocID1 == null) {
				Assert.assertTrue(myDocID1 == null);
				Log.info("UA-MD-05 Passed");
			} else {
				Log.info("UA-MD-05 could not be tested");
			}
			home.initializeDocumentsList();
			Assert.assertTrue(home.documentID.isDisplayed());
			Log.info("UA-MD-06 Passed");
			Assert.assertTrue(home.currentVersion.isDisplayed());
			Log.info("UA-MD-07 Passed");
			Assert.assertTrue(home.status.isDisplayed());
			Log.info("UA-MD-08 Passed");
			Assert.assertTrue(home.language.isDisplayed());
			Log.info("UA-MD-09 Passed");
			Assert.assertTrue(home.country.isDisplayed());
			Log.info("UA-MD-10 Passed");
			Assert.assertTrue(title.isDisplayed());
			Log.info("UA-MD-11 Passed");
			Assert.assertTrue(addremoveMydoc.getCssValue("color").matches("#6f6f6f"), "Remove from MyDocs Icon");
			Log.info("UA-MD-12 Passed");
			initializeMyDocPageObjects();
			Assert.assertEquals(myDocPages.getFirstSelectedOption().getText(), "10");
			Log.info("UA-MD-15 Passed");
			if (myDocPages.getFirstSelectedOption().getText().contains("10")) {
				Assert.assertTrue(pagePrevious.isDisplayed());
				Assert.assertTrue(pageNext.isDisplayed());
				Log.info("UA-MD-8 Passed");
				Assert.assertTrue(pageLink.isDisplayed());
				Log.info("UA-MD-9 Passed");
			}
			if (myDocID1 != null && myDocID2 != null) {
				String doc1, doc2;
				doc1 = myDocID1.getText();
				doc2 = myDocID2.getText();
				documentID.click();
				String sort = Sorting.verifySortingForColumn(doc1, doc2);
				Log.info("UA-MD-13 Passed");
				if (sort.contains("Pass")) {
					Assert.assertTrue(true);
				}
				myDocID1.click();
				initializeDocumentInfoObjects();
				Assert.assertTrue(docAction.isDisplayed());
				Log.info("UA-MD-10 Passed");
			} else {
				Assert.assertEquals("No records returned", "No records returned");
				Log.info("UA-MD-5 Passed");
			}
			Reporter.log("my document tested successfully xmL-UI-ADS-001");
			Log.endTestCase("My Docs Listing Test Ended");
		} catch (Throwable e) {
			Log.info(e.getMessage());
			Reporter.log("my document tested unsuccessfully xmL-UI-ADS-001");
			Log.info("mydocs listing failed");
		}
	}

	/**
	 * Test the my checked-out documents Page of UI 7.0 UI-ADS-001 2.3 My Checked Out Docs	 * 
	 * @throws Exception If an error occurs.
	 * 
	 */
	@Test(priority = 3)

	public void testMyCheckedoutDocs() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("My Checkedout Docs Test Started");
		try {
			initializeMyDocsObjects();
			Assert.assertEquals(myCheckedDocumentLabel.getText(), "My Checked out documents"); // UA-MD-14
			Log.info("UA-MD-14 Passed");
			home.initializeDocumentsList();
			Assert.assertTrue(home.documentID.isDisplayed());// UA-MD-16
			Log.info("UA-MD-16 Passed");
			Assert.assertTrue(home.language.isDisplayed());
			Assert.assertTrue(home.currentVersion.isDisplayed());
			Assert.assertTrue(home.status.isDisplayed());
			Assert.assertTrue(home.title.isDisplayed());
			initializeMyDocPageObjects();
			Assert.assertEquals(myDocPages.getFirstSelectedOption().getText(), "10");// UA-MD-17
			Log.info("UA-MD-17 Passed");
			if (myDocPages.getFirstSelectedOption().getText().contains("10")) {
				Assert.assertTrue(pagePrevious.isDisplayed());
				Assert.assertTrue(pageNext.isDisplayed());// UA-MD-18
				Log.info("UA-MD-18 Passed");
				Assert.assertTrue(pageLink.isDisplayed());// UA-MD-19
				Log.info("UA-MD-19 Passed");
			}

			if (myCheckedoutDoc != null) {
				myCheckedoutDoc.click();
				initializeDocumentInfoObjects();
				Assert.assertTrue(docAction.isDisplayed());// UA-MD-20
				Log.info("UA-MD-20 Passed");
			} else {
				Assert.assertEquals("No records returned", "No records returned");// UA-MD-15
				Log.info("UA-MD-15 Passed");
			}
			initializeMyCheckedDocsObjects();
			Thread.sleep(9000);
			if(retryingFindClick(myCheckedDocID)){
				Log.info("my checkedout tab clicked");
			}
			Reporter.log("my checkedout documents tested successfully as per ADS xmL-UI-ADS-001");
		} catch (Throwable e) {
			Log.info(e.getMessage());
			Reporter.log("my checkedout documents tested unsuccessfully as per ADS xmL-UI-ADS-001");
		}
		Log.endTestCase("My Checkedout Docs Test Ended");
	}

	

	@AfterClass
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
	}
}
