package com.ig.automation.test;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.CaretEvent;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//import com.opera.core.systems.scope.protos.ExecProtos.ActionList.Action;
import com.ig.automation.coreactions.SuperScript;
import com.ig.automation.screens.ContentManagementScreen;
import com.ig.automation.screens.CreateDocScreen;
import com.ig.automation.utility.Log;

public class GenerateCleanCopyTest extends ContentManagementScreen {
	HomeTest homeTest = new HomeTest();
	CreateDocumentTest createDocumentTest = new CreateDocumentTest();
	LoginTest loginTest = new LoginTest();
	SearchTest searchTest = new SearchTest();
	public static String docB = null;
	CreateDocScreen createDocScreen = new CreateDocScreen();

	/**
	 * Test the Generate clean Copy Test of UI 7.0 against the
	 * xmL-UI-ADS-037.doc *
	 * 
	 * @throws Exception
	 */

	@BeforeClass
	public void login() throws Exception {
		loginTest.launchUrl();
		String username = "author01";
		String password = "password";
		loginTest.doLogin(username, password);
		Thread.sleep(2000);
		Log.info(username + ": is able to log in Successfully.");
	}

	@Test(priority = 1)
	public void generateCleanCopyTest() {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Generate Clean Copy Test");
		try {
			homeTest.initializeLeftNavigationObjects();
			homeTest.actions.click();
			Thread.sleep(2000);
			homeTest.initializeActionObjects();
			homeTest.createDoc.click();
			Thread.sleep(2000);
			createDocScreen.inilializeObjectsDocType();
			createDocScreen.annexType.click();
			Thread.sleep(2000);
			docB = createDocumentTest.doCreateDocument("Annex II", "Test ST B",
					"European Union", "English", "Alkaline Aqua", "ALLERSOLV",
					"", "");
			Log.info("New document is created successfully of Annex 2 Type. Document Id : "
					+ docB);
			searchTest.doSearchDocument(docB);
			initializeEdit();
			editLink.click();
			inilializeGenerateCleanCopyLink();
			generateCleanCopyLink.click();
			Thread.sleep(2000);
			getScreenShot("Gen", "GenerateCleanCopycreen");
			initializeGenerateCleanCopyElements();
			Assert.assertTrue(
					generateCleanCopyTitle.getText().contains(
							"Generate Clean Copy"),
					"Generate Clean Copy Screen is displayed successfully for Document Id - "
							+ docB);
			Log.info("Generate Clean Copy Title is displayed Successfully");
			Assert.assertTrue(generateCleanCopyTemplate.getText()
					.contains(docB),
					"Generate Clean Copy Screen is displayed successfully for Document Id - "
							+ docB);
			Log.info("Generate Clean Copy Screen is displayed successfully for Document Id - "
					+ docB);
			Assert.assertTrue(
					generateCleanCopyTemplate.getText().contains("Status"),
					"Status Label is displayed successfully");
			Log.info("Status Label is displayed successfully");
			Assert.assertTrue(
					generateCleanCopyTemplate.getText().contains("Countries"),
					"Countries Label is displayed successfully");
			Log.info("Countries Label is displayed successfully");
			Assert.assertTrue(
					generateCleanCopyTemplate.getText().contains("Title"),
					"Title Label is displayed successfully");
			Log.info("Title Label is displayed successfully");
			Assert.assertTrue(
					generateCleanCopyTemplate.getText().contains("Version"),
					"Version Label is displayed successfully");
			Log.info("Version Label is displayed successfully");
			Assert.assertTrue(
					generateCleanCopyTemplate.getText().contains("Language"),
					"Language Label is displayed successfully");
			Log.info("Language Label is displayed successfully");

			// Preselected defect Id :GLM-1549
			Assert.assertEquals(cleanCopyAccept.isDisplayed(), true,
					"Accept Track Changes Checkbox is displayed Successfully");
			Log.info("Accept Track Changes Checkbox is Passed Successfully");
			System.out.println("accept");
			Assert.assertEquals(cleanCopyRemove.isDisplayed(), true,
					"Remove Internal Comments Checkbox is displayed Successfully");
			Log.info("Remove Internal Comments Checkbox is Passed Successfully");
			Assert.assertEquals(cleanCopyProcessNotes.isDisplayed(), true,
					"Process Notes Checkbox is displayed Successfully");
			Log.info("Process Notes Checkbox is Passed Successfully");

			inilializeGenerateCleanCopyButton();

			// defect 1502 : Generate Clean Copy button not working
			Assert.assertEquals(generateCleanCopyButton.isEnabled(), true,
					"Generate Clean Copy Button is disabled");
			Log.info("Generate Clean Copy Button is Enabled Successfully");
			Assert.assertEquals(generateCleanCopyButton.isDisplayed(), true,
					"Generate Clean Copy Button is not displayed");
			Log.info("Generate Clean Copy Button is displayed Successfully");

			Assert.assertEquals(cancelButton.isEnabled(), true,
					"Cancel Button is disabled");
			Log.info("Cancel Button is Enabled Successfully");
			Assert.assertEquals(cancelButton.isDisplayed(), true,
					"Cancel Button is not displayed");
			Log.info("Cancel Button is displayed Successfully"); // 11
			getScreenShot("ADS-037", "GenerateCleanCopyButtonIsEnabled");

			// generateCleanCopyButton.click();
			/*
			 * initializeSuccessMessages(); String successMessageText =
			 * message.getText(); System.out.println(successMessageText);
			 * Assert.assertTrue(successMessageText.contains(
			 * "Clean copy successfully generated for document"),
			 * "Clean copy is generated successfully for document - " + docB);
			 * Log.info("*** Success Message ***  " + successMessageText);
			 */

			// Assert.assertEquals(generateCleanCopyButton.isDisplayed(), false,
			// "Generate Clean Copy Panel is Not closed");
			if (generateCleanCopyButton == null) {
				Log.info("Generate Clean Copy Panel is closed Successfully");
			}
		} catch (Throwable t) {
			Log.info(t.getMessage());
			Reporter.log(" Generate Clean Copy Test Failed");
			Log.endTestCase("Generate Clean Copy Test");
			Assert.fail(t.getMessage());
		}
	}

	@Test(priority = 2)
	public void generateCleanCopyCancel() throws Exception {
		searchTest.doEditSearchView(docB);
		initializeEdit();
		editLink.click();
		inilializeGenerateCleanCopyLink();
		generateCleanCopyLink.click();
		Thread.sleep(2000);
		initializeGenerateCleanCopyElements();
		cancelButton.click();
		inilializeGenerateCleanCopyButton();
		if (generateCleanCopyButton == null) {
			Log.info("Generate Clean Copy Panel is closed Successfully");
		}
	}

	public List<String> doGenerateCleanCopyTest(String folderName,
			String actionToPerform) throws Exception {
		List<String> itemsToValidateGCC = new ArrayList<>();
		try {
			try {
				initializeEdit();
				editLink.click();
				inilializeGenerateCleanCopyLink();
				generateCleanCopyLink.click();
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			getScreenShot(folderName, "GenerateCleanCopycreen");
			initializeGenerateCleanCopyElements();
			String title = generateCleanCopyTitle.getText();
			itemsToValidateGCC.add(title);
			generateCleanCopyLink.click();
			Thread.sleep(2000);
			getScreenShot(folderName, "GenerateCleanCopycreen");
			initializeGenerateCleanCopyElements();
			if (actionToPerform.equalsIgnoreCase("Accept")) {
				cleanCopyAccept.click();
			} else if (actionToPerform.equalsIgnoreCase("Remove")) {
				cleanCopyRemove.click();
			} else if (actionToPerform.equalsIgnoreCase("Process")) {
				cleanCopyProcessNotes.click();
			} else {
				cleanCopyAccept.click();
				cleanCopyRemove.click();
				cleanCopyProcessNotes.click();
			}
			inilializeGenerateCleanCopyButton();
			generateCleanCopyButton.click();
			initializeSuccessMessages();
			String successMessageText = message.getText();
			System.out.println(successMessageText);
			itemsToValidateGCC.add(successMessageText);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return itemsToValidateGCC;
	}
}
