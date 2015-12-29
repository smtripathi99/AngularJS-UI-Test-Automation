package com.ig.automation.test;

import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ig.automation.screens.CreateCRScreen;
import com.ig.automation.utility.Log;


public class CreateCRTest extends CreateCRScreen {

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
	 * Test the Create Change Request Page of UI 7.0 against the xmL-UI-ADS-XXX using mandatory fields
	 * 
	 * @throws Exception If an error occurs.
	 * 
	 */
	@Test
	public void testCreateCRMandatory() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Create CR Test Started");
		try {

			initializeMandatoryProperties();
			Assert.assertEquals(createCRPanelTitle.isDisplayed(), true); // A-CCR-1
			Assert.assertEquals(crType.isMultiple(), true);
			Assert.assertEquals(title.isDisplayed(), true);
			Assert.assertEquals(country.isDisplayed(), false);
			Assert.assertEquals(language.isMultiple(), true);
			Assert.assertEquals(priority.isMultiple(), true);
			crType.selectByVisibleText("Other");
			title.sendKeys("Test CR");
			country.clear();
			country.sendKeys("Austria");
			country.sendKeys(Keys.ARROW_DOWN);
			country.sendKeys(Keys.ENTER);
			language.selectByVisibleText("English");
			priority.selectByVisibleText("High");
			createCRBtn.click();
			Reporter.log("xmL-UI-ADS-XXX.doc Create CR tested successfully");
		} catch (Throwable e) {
			Log.info(e.getMessage());
			Reporter.log("xmL-UI-ADS-XXX.doc Create CR tested unsuccessfully");
			Assert.fail();
		}
		Log.endTestCase("Create CR Test Ended");
	}

	/**
	 * Test the Create Change Request Page of UI 7.0 against the xmL-UI-ADS-XXX using optional fields
	 * 
	 * @throws Exception If an error occurs.
	 * 
	 */
	@Test
	public void testCreateCROptional() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Create CR Test Started");
		try {

			initializeMandatoryProperties();
			crType.selectByVisibleText("Other");
			title.sendKeys("Test CR");
			country.clear();
			country.sendKeys("Austria");
			country.sendKeys(Keys.ARROW_DOWN);
			country.sendKeys(Keys.ENTER);
			language.selectByVisibleText("English");
			priority.selectByVisibleText("High");
			initializeOptionalProperties();
			createCRoptional.click();
			initializeCreateCRPanelOptional();

			Assert.assertEquals(relatedDoc.isDisplayed(), true); // A-CCR-1
			Assert.assertEquals(summary.isDisplayed(), true);
			Assert.assertEquals(description.isDisplayed(), true);
			Assert.assertEquals(reason.isDisplayed(), false);
			Assert.assertEquals(jurification.isDisplayed(), true);

			createCRBtn.click();
			Reporter.log("xmL-UI-ADS-XXX.doc Create CR tested successfully");
		} catch (Throwable e) {
			Log.info(e.getMessage());
			Reporter.log("xmL-UI-ADS-XXX.doc Create CR tested unsuccessfully");
			Assert.fail();
		}
		Log.endTestCase("Create CR Test Ended");
	}

	/**
	 * Test the Cancel CR Page of UI 7.0 against the xmL-UI-ADS-XXX
	 * 
	 * @throws Exception If an error occurs.
	 * 
	 */
	@Test
	public void testCancelCR() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Cancel Create CR Test Started");
		try {
			// createCR.click();
			initializeMandatoryProperties();
			cancelBtn.click(); // A-CCR-23
			Reporter.log("xmL-UI-ADS-XXX.doc tested successfully for Cancel");
		} catch (Throwable e) {
			Log.info(e.getMessage());
			Reporter.log("xmL-UI-ADS-XXX.doc tested unsuccessfully for Cancel");
			Assert.fail();
		}
		Log.endTestCase("Cancel Create CR Test Ended");

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
	
	public void doInitializrCR(){
		initializeCRTab();
		changeRequest.click();
		initializeCreateCRLink();
		createChangeRequest.click();
		initializeMandatoryProperties();
	}

	public String doCreateCRMandatory(String title1,String crtype1, String country1, String language1, String priority1) throws Exception {
		String docID = null;
		try {

			initializeMandatoryProperties();
			crType.selectByVisibleText(crtype1);
			title.sendKeys(title1);
			country.clear();
			country.sendKeys(country1);
			country.sendKeys(Keys.ARROW_DOWN);
			country.sendKeys(Keys.ENTER);
			language.selectByVisibleText(language1);
			priority.selectByVisibleText(priority1);
			initializeCRCreateBtn();
			createCRBtn.click();
			initializeMessages();
			// docLink.click();
			String successMessage = message.getText(); // Document CR-123,
			docID = successMessage.substring(31, 38);
			//writeCSV(docID);
			return docID;
		} catch (Throwable e) {
			Log.info(e.getMessage());
			Log.info("Change Request not created or doc id not available in toast message");
			//Assert.fail();
			return "Change request not created or doc id not available in toast message";
		}
		
	}

	/*
	 * @AfterClass public void tearDown() throws Exception{ driver.close(); driver.quit(); System.out.println("Passed:Login screen is tested successfully."); }
	 */
}
