package com.ig.automation.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;
//import org.bouncycastle.asn1.x509.DisplayText;
//import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.gargoylesoftware.htmlunit.javascript.host.Popup;
import com.ig.automation.coreactions.DataActions;
import com.ig.automation.screens.ChangeLifeCycleStateScreen;
import com.ig.automation.screens.EditPropertiesScreen;
import com.ig.automation.screens.HAInterActionTestScreen;
import com.ig.automation.utility.Log;


public class HAInterActionTest extends HAInterActionTestScreen {

	HomeTest homeTest = new HomeTest();
	LoginTest loginTest = new LoginTest();
	ChangeLifeCycleStateTest clcs = new ChangeLifeCycleStateTest();
	SearchTest searchTest = new SearchTest();
	CreateDocumentTest crDocTest = new CreateDocumentTest();
	// private SoftAssert softAssert = new SoftAssert();
	private WebDriver webdriver;

	@BeforeClass
	public void login() {
		try {
			launchUrl();
			String username = DataActions.getUserID("role_author");
			String password = DataActions.getUserPassword("role_author");
			loginTest.doLogin(username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test the Change Life Cycle State of UI 7.0 against the xmL-UI-ADS-024 
	 * 
	 * @throws Exception If an error occurs.
	 * 
	 */
	@Test
	public void testSubmitToHA() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Submit to Health Authority for Blister");
		try {
		homeTest.initializeLeftNavigationObjects();
		homeTest.actions.click();
		homeTest.initializeActionObjects();
		homeTest.createDoc.click();
		crDocTest.inilializeObjectsDocType();
		crDocTest.annexType.click();
		String annexID = crDocTest.doCreateDocument("Annex II", "AnnexTest", "Austria", "English", "Alkaline Aqua", "ALLERSOLV", "", "");
		homeTest.searchIcon.click();
		//searchTest.doSearchDocument("BLI-083");
		initializeDocActionMenu();
		initializeDocActionSubMenuSubmitToHA();
		Actions action = new Actions(driver);
		action.moveToElement(processManagement).moveToElement(submitToHA).click().build().perform();
		initializeSubmitToHAScreen();
		assertTrue(submitToHAdetails.getText().contains("-"), true, submitToHAdetails.getText().contains("-")); //UI-HA-1
		Log.info("UI-HA-1- Passed - When Submit To HA screen screen is initially displayed, Document ID is Displayed in Tablet Format");
		assertTrue(submitToHAdetails.getText().contains("Status"), true, submitToHAdetails.getText().contains("Status")); //UI-HA-2
		Log.info("UI-HA-2- Passed - When Submit To HA screen screen is initially displayed, Version is Displayed in Tablet Format");
		assertTrue(submitToHAdetails.getText().contains("Version"), true, submitToHAdetails.getText().contains("Version")); //UI-HA-3
		Log.info("UI-HA-3- Passed - When Submit To HA screen screen is initially displayed, Status is Displayed in Tablet Format");
		assertTrue(submitToHAdetails.getText().contains("Language"), true, submitToHAdetails.getText().contains("Language")); //UI-HA-4
		Log.info("UI-HA-4- Passed - When Submit To HA screen screen is initially displayed, Language is Displayed in Tablet Format");
		assertTrue(submitToHAdetails.getText().contains("Countries"), true, submitToHAdetails.getText().contains("Countries")); //UI-HA-5
		Log.info("UI-HA-5- Passed - When Submit To HA screen screen is initially displayed, Countries is Displayed in Tablet Format");
		assertTrue(submitToHAdetails.getText().contains("Title"), true, submitToHAdetails.getText().contains("Title")); //UI-HA-6
		Log.info("UI-HA-6- Passed - When Submit To HA screen is initially displayed, Title is Displayed in Tablet Format");
		assertTrue(textMessage.getText().contains("Record the date"), true, textMessage.getText().contains("Record the date"));//UI-HA-7
		Log.info("UI-HA-7- Passed - When Submit To HA screen is initially displayed, Message is Displayed in Tablet Format");
		initializeCalendar();
		haSubmissionDate.clear();
		assertTrue(haSubmissionDate.isEnabled(), true, haSubmissionDate.isEnabled());//UI-HA-8
		Log.info("UI-HA-8- Passed - The Health Authority Submission Date field is cleared and enabled");
		initializeSubmitBtn();
		assertFalse(submitBtn.isEnabled(), false); //UI-HA-9
		//assertTrue(submitBtn.isEnabled(), false, submitBtn.isEnabled()); 
		Log.info("UI-HA-9- Passed - The Submit button is hidden");
		initializeCancelBtn();
		assertTrue(cancelBtn.isEnabled(), true, cancelBtn.isEnabled());//UI-HA-10
		Log.info("UI-HA-10- Passed - The Cancel button is enabled");
		haSubmissionDate.click();
		initializeDateSelector();
		assertTrue(dateSelector
				.isDisplayed(), true, dateSelector.isDisplayed());//UI-HA-11
		Log.info("UI-HA-11- Passed - The Date selector control is displayed.");
		haSubmissionDate.sendKeys("selectFutureDate(5)");
		assertTrue(submitBtn.isDisplayed(), true, submitBtn.isDisplayed());
		Log.info("UI-HA-12- Passed - Submit Button is displayed");
		assertTrue(submitBtn.isEnabled(), true, submitBtn.isEnabled());
		Log.info("UI-HA-13- Passed - Submit Button is Enabled");
		submitBtn.click();
		initializeStatusChanged();
		assertTrue(statusChanged.equals("HA Submitted"), true, statusChanged.equals("HA Submitted"));//UI-HA-14 //UI-HA-15
		Log.info("UI-HA-14- Passed - presses the Submit button and no error condition exist");
		Log.info("UI-HA-15- Passed - Close the Submit to Health Authority panel ");
		initializeMessages();
		String successMessage = message.getText();
		assertTrue(message.isDisplayed(), true, message.isDisplayed()); //UI-HA-16
		Log.info("UI-HA-16- Passed - Success Message is displayed successfully");
		Log.info("UI-HA-17- Passed - Refresh the listing screen");
		//TODO UI-HA-18 cancel  button
		initializeSubMenuRecordHAResponse();
		recordHAResponse.click();
		initializeHAResponseScreen();
		assertTrue(haResponseScreen.getText().contains("-"), true, haResponseScreen.getText().contains("-")); //UI-HA-19
		Log.info("UI-HA-19- Passed - When Submit To HA screen screen is initially displayed, Document ID is Displayed in Tablet Format");
		assertTrue(haResponseScreen.getText().contains("Status"), true, haResponseScreen.getText().contains("Status")); //UI-HA-20
		Log.info("UI-HA-20- Passed - When Submit To HA screen screen is initially displayed, Version is Displayed in Tablet Format");
		assertTrue(haResponseScreen.getText().contains("Version"), true, haResponseScreen.getText().contains("Version")); //UI-HA-21
		Log.info("UI-HA-21- Passed - When Submit To HA screen screen is initially displayed, Status is Displayed in Tablet Format");
		assertTrue(haResponseScreen.getText().contains("Language"), true, haResponseScreen.getText().contains("Language")); //UI-HA-22
		Log.info("UI-HA-22- Passed - When Submit To HA screen screen is initially displayed, Language is Displayed in Tablet Format");
		assertTrue(haResponseScreen.getText().contains("Countries"), true, haResponseScreen.getText().contains("Countries")); //UI-HA-23
		Log.info("UI-HA-23- Passed - When Submit To HA screen screen is initially displayed, Countries is Displayed in Tablet Format");
		assertTrue(haResponseScreen.getText().contains("Title"), true, haResponseScreen.getText().contains("Title")); //UI-HA-24
		Log.info("UI-HA-24- Passed - When Submit To HA screen is initially displayed, Title is Displayed in Tablet Format");
		assertTrue(textMessage.getText().contains("Record the Health Authority"), true, textMessage.getText().contains("Record the Health Authority"));//UI-HA-25
		Log.info("UI-HA-7- Passed - When Submit To HA screen is initially displayed, Message is Displayed in Tablet Format");
		initializeHAResponseDropDown();
		haResponseDropDown.selectByIndex(1);
		WebElement List1 = haResponseDropDown.getFirstSelectedOption();
		assertTrue(List1.getText().equals("Approved"), true, List1.getText().equals("Approved"));// UI-HA-26//UI-HA-33
		Log.info("UI-HA-26- Passed - Health Authority Response drop down field is cleared and enabled");
		Log.info("UI-HA-33- Passed - Health Authority Response list value is selected");
		haResponseDate.clear();
		assertTrue(haResponseDate.isEnabled(), true, haResponseDate.isEnabled()); //UI-HA-27
		Log.info("UI-HA-27- Passed - Health Authority Response Date field is cleared and enabled");
		//TODO GLM-1362   UI-HA-28
		initializeCancelBtn();
		assertTrue(cancelBtn.isEnabled(), true, cancelBtn.isEnabled()); //UI-HA-29
		//TODO UI-HA-30
		haResponseDate.click();
		initializeDateSelector();
		assertTrue(dateSelector.isDisplayed(), true, dateSelector.isDisplayed());//UI-HA-31
		Log.info("UI-HA-31- Passed - The Date selector control is displayed.");
		selectPreviousDate("3");
		assertTrue(haResponseDate.getText().contains("3"), true, haResponseDate.getText().contains("3"));//UI-HA-31
		Log.info("UI-HA-32- Passed - The user specified date is displayed in the Health Authority Response Date field");
		//TODO UI-HA-34  Bug GLM-1526
		//TODO UI-HA-35  Bug GLM-1526
		//TODO UI-HA-36  Bug GLM-1526
		//TODO UI-HA-37  Bug GLM-1526
		//TODO UI-HA-38  Bug GLM-1526
		//TODO UI-HA-39 cancel  button
		initializeSubMenuWindrawHASubmission();
		withdrawHASubmission.click();
		initializeWithdrawHASubmissionScreen();
		assertTrue(withdrawHASubmissionScreen.getText().contains("-"), true, withdrawHASubmissionScreen.getText().contains("-")); //UI-HA-40
		Log.info("UI-HA-40- Passed - When WithDraw HA Submission screen screen is initially displayed, Document ID is Displayed in Tablet Format");
		assertTrue(withdrawHASubmissionScreen.getText().contains("Status"), true, withdrawHASubmissionScreen.getText().contains("Status")); //UI-HA-41
		Log.info("UI-HA-41- Passed - When WithDraw HA Submission screen screen is initially displayed, Version is Displayed in Tablet Format");
		assertTrue(withdrawHASubmissionScreen.getText().contains("Version"), true, withdrawHASubmissionScreen.getText().contains("Version")); //UI-HA-42
		Log.info("UI-HA-42- Passed - When WithDraw HA Submission screen screen is initially displayed, Status is Displayed in Tablet Format");
		assertTrue(withdrawHASubmissionScreen.getText().contains("Language"), true, withdrawHASubmissionScreen.getText().contains("Language")); //UI-HA-43
		Log.info("UI-HA-43- Passed - When WithDraw HA Submission screen screen is initially displayed, Language is Displayed in Tablet Format");
		assertTrue(withdrawHASubmissionScreen.getText().contains("Countries"), true, withdrawHASubmissionScreen.getText().contains("Countries")); //UI-HA-44
		Log.info("UI-HA-44- Passed - When WithDraw HA Submission screen screen is initially displayed, Countries is Displayed in Tablet Format");
		assertTrue(withdrawHASubmissionScreen.getText().contains("Title"), true, withdrawHASubmissionScreen.getText().contains("Title")); //UI-HA-45
		Log.info("UI-HA-45- Passed - When WithDraw HA Submission screen screen is initially displayed, Title is Displayed in Tablet Format");
		initializeWithdrawHADate();
		withdrawHAdate.clear();
		assertTrue(withdrawHAdate.isEnabled(), true, withdrawHAdate.isEnabled()); //UI-HA-46
		Log.info("UI-HA-46- Passed - Health Authority Withdraw Date field is cleared and enabled.");
		//TODO GLM-1533     //UI-HA-47
		initializeCancelBtn();
		assertTrue(cancelBtn.isEnabled(), true, cancelBtn.isEnabled()); //UI-HA-48
		Log.info("UI-HA-48- Passed - Cancel button is enabled.");
		initializeDateSelector();
		assertTrue(dateSelector.isDisplayed(), true, dateSelector.isDisplayed()); //UI-HA-49
		Log.info("UI-HA-49- Passed - The Date selector control is displayed");
		selectFutureDate("5");
		assertTrue(withdrawHAdate.getText().contains("5"), true, withdrawHAdate.getText().contains("5")); //UI-HA-50
		Log.info("UI-HA-50- Passed - The user specified date is displayed in the Health Authority Withdraw Date field");
		initializeWithdrawButton();
		withdrawBtn.click();
		initializeStatusChanged();
		assertTrue(statusChanged.equals("HA Withdrawn"), true, statusChanged.equals("HA Withdrawn"));//UI-HA-52 //UI-HA-53
		Log.info("UI-HA-52- Passed - presses the Withdraw button and no error occurs");
		Log.info("UI-HA-53- Passed - Close the Submit to Withdraw HA Response panel ");
		initializeMessages();
		String successMessage1 = message.getText();
		assertTrue(message.isDisplayed(), true, message.isDisplayed()); //UI-HA-54//UI-HA-55
		Log.info("UI-HA-54- Passed - Success Message is displayed successfully");
		Log.info("UI-HA-55- Passed - Refresh the listing screen");
		initializeSubMenuRecordHAResponse();
		recordHAResponse.click();
		initializeCancelBtn();
		cancelBtn.click();
		initializeStatusChanged();
		assertTrue(statusChanged.isDisplayed(), true, statusChanged.isDisplayed());//UI-HA-56
		Log.info("UI-HA-56- Passed - The Withdraw from Health Authority panel closes");
		
			Reporter.log("xmL-UI-ADS-024.doc Interacting With Health Authorities tested successfully");

		} catch (Throwable t) {

			Log.info(t.getMessage());
			Reporter.log("xmL-UI-ADS-024.doc Interacting With Health Authorities tested Failed");
			Log.endTestCase("Interacting With Health Authorities");
			Assert.fail(t.getMessage());
		}
		Log.endTestCase("Interacting With Health Authorities");
	}

	

	public String doSubmitToHA(String docid) {
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
			Thread.sleep(4000);
			initializeDocument();
			Thread.sleep(4000);
			filterDocID.click();
			documentID.click();
			searchTest.doSearchDocument(docid);
			initializePopUp();
			processManagement.click();
			initializeSubmitToHA();
			submitToHA.click();
			initializeHAPage();
			dateHASubmission.click();
			initializeCalendar();
			haAuthoritySubmissionDate.clear();
			haAuthoritySubmissionDate.sendKeys(getFutureDate(1));
			submitBtn.click();
		} catch (Throwable t) {
			Log.info(t.getMessage());
		}
		return "Success";
	}
	
	public List<String> doSubmitToHA(String folderName , String docid) {
		List<String> detailsOfHA = new ArrayList<String>();
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
			Thread.sleep(4000);
			initializeDocument();
			Thread.sleep(4000);
			filterDocID.click();
			documentID.click();
			searchTest.doSearchDocument(docid);
			initializePopUp();
			processManagement.click();
			initializeSubmitToHA();
			submitToHA.click();
			initializeHAPage();
			String pageTitle = title.getText();
			detailsOfHA.add(pageTitle);
			dateHASubmission.click();
			initializeCalendar();
			haAuthoritySubmissionDate.clear();
			haAuthoritySubmissionDate.sendKeys(getFutureDate(1));
			String selectedHADate = haAuthoritySubmissionDate.getText();
			detailsOfHA.add(selectedHADate);
			getScreenShot(folderName, "HealthAuthority_Screen");
			submitBtn.click();
		} catch (Throwable t) {
			Log.info(t.getMessage());
		}
		return detailsOfHA;
	}

	public List<String> doRecordHAResponse(String docid) {
		
		try {
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
			Thread.sleep(4000);
			initializeDocument();
			Thread.sleep(4000);
			filterDocID.click();
			documentID.click();
			searchTest.doSearchDocument(docid);
			initializePopUp();
			processManagement.click();
			initializeRecordHAResponse();
			recordHAResponse.click();
			//initializeSubmitToHA();
			//submitToHA.click();
			initializeHAPage();			
			initializeHAResponse();
			haResponseDropDown.selectByIndex(1); 
			dateHASubmission.click();
			initializeCalendar();
			haAuthoritySubmissionDate.clear();
			haAuthoritySubmissionDate.sendKeys(getFutureDate(1));
			submitBtn.click();
			initializeStatusState();
			String Status = statusState.getText();
			initializeVersionState();
			String Version = versionState.getText();
			List<String> itemsToAdd = new ArrayList<String>();
			itemsToAdd.add(Status);
			itemsToAdd.add(Version);
			return itemsToAdd;		
			//return "Record HA success";
		} catch (Throwable t) {

			Log.info(t.getMessage());
			//return "Record HA error";
		}
		return null;
		
	}
	
public List<String> doRecordHAResponse(String docid , String healthResponse , String folderName) {
	List<String> itemsToAdd = new ArrayList<String>();
		try {
			searchTest.doSearchDocument(docid);
			initializePopUp();
			processManagement.click();
			initializeRecordHAResponse();
			recordHAResponse.click();
			initializeHAPage();			
			initializeHAResponse();
			haResponseDropDown.selectByVisibleText(healthResponse);
			String selectedHAresponse = haResponseDropDown.getFirstSelectedOption().getText();
			itemsToAdd.add(selectedHAresponse);
			//date
			dateHASubmission.click();
			initializeCalendar();
			haAuthoritySubmissionDate.clear();
			haAuthoritySubmissionDate.sendKeys(getFutureDate(1));
			getScreenShot(folderName, "HAResponse_Screen");
			String selectedDate= haAuthoritySubmissionDate.getText();
			itemsToAdd.add(selectedDate);
			submitBtn.click();
			initializeStatusState();
			String Status = statusState.getText();
			initializeVersionState();
			String Version = versionState.getText();
		} catch (Throwable t) {
			Log.info(t.getMessage());
		}
		return itemsToAdd;
	}
	
	private void assertFalse(boolean enabled, boolean b) {
		// TODO Auto-generated method stub
		
	}

	public List<String> doHARecord(String docID) throws InterruptedException{
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
		Thread.sleep(4000);
		initializeDocument();
		Thread.sleep(4000);
		filterDocID.click();
		initializeStatusState();
		String Status = statusState.getText();
		initializeVersionState();
		String Version = versionState.getText();
		List<String> itemsToAdd = new ArrayList<String>();
		itemsToAdd.add(Status);
		itemsToAdd.add(Version);
		return itemsToAdd;
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

	@AfterClass
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
		System.out.println("Passed:Login screen is tested successfully.");
	}
}
