package com.ig.automation.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

//import com.opera.core.systems.common.io.ProcessManager;
import com.ig.automation.coreactions.DataActions;
import com.ig.automation.screens.ChangeLifeCycleStateScreen;
import com.ig.automation.screens.ContentManagementScreen;
import com.ig.automation.screens.EditPropertiesScreen;
import com.ig.automation.utility.Log;


public class ChangeLifeCycleStateTest extends ChangeLifeCycleStateScreen {

	HomeTest homeTest = new HomeTest();
	LoginTest loginTest = new LoginTest();
	SearchTest schTest = new SearchTest();
	CreateDocumentTest crDocTest = new CreateDocumentTest();
	ContentManagementScreen contentManagementScreen = new ContentManagementScreen();
	

	// private SoftAssert softAssert = new SoftAssert();

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
	 * Test forChangeLifeCyclefromDocDraftToIAWithSignature of UI 7.0 against the xmL-UI-ADS-002
	 * 
	 * @throws Exception If an error occurs.
	 * 
	 */
	@Test
	public void testChangeStatefromDraftToIAWithSignature() throws Exception {
		
		 DOMConfigurator.configure("log4j.xml"); 
		 Log.startTestCase("ChangeStatefromDraftToIAWithSignature"); 
		 try{
		homeTest.initializeLeftNavigationObjects();
		homeTest.actions.click();
		homeTest.initializeActionObjects();
		homeTest.createDoc.click();
		crDocTest.inilializeObjectsDocType();
		crDocTest.annexType.click();
		String annexID = crDocTest.doCreateDocument("Annex II", "AnnexTest", "Austria", "English", "Alkaline Aqua", "ALLERSOLV", "", "");
		homeTest.searchIcon.click();
		schTest.doSearchDocument("AN");
		initializeDocActionMenu();
		processManagement.click();
		//TODO after clicking on process management -Change life cycle sub menu is not arising 
		initializeDocActionSubMenu();
		subMenuchangeLifeCycleState.click();
		initializeChangeLifeCycleScreen();
		assertTrue(clcScreen.getText().contains("-"), true, clcScreen.getText().contains("-")); // UI-CLS-4
		Log.info("UI-CLS-4- Passed - When the Change Lifecycle State screen is initially displayed, Document ID Displayed in Tablet Format");
		assertTrue(clcScreen.getText().contains("Version"), true, clcScreen.getText().contains("Version")); // UI-CLS-5
		Log.info("UI-CLS-5- Passed - When the Change Lifecycle State screen is initially displayed, Version is Displayed in Tablet Format");
		assertTrue(clcScreen.getText().contains("Status"), true, clcScreen.getText().contains("Status")); // UI-CLS-6
		Log.info("UI-CLS-6- Passed - When the Change Lifecycle State screen is initially displayed, Status is Displayed in Tablet Format");
		assertTrue(clcScreen.getText().contains("Language"), true, clcScreen.getText().contains("Language")); // UI-CLS-7
		Log.info("UI-CLS-7- Passed - When the Change Lifecycle State screen is initially displayed, Language is Displayed in Tablet Format");
		assertTrue(clcScreen.getText().contains("Countries"), true, clcScreen.getText().contains("Countries")); // UI-CLS-8
		Log.info("UI-CLS-8- Passed - When the Change Lifecycle State screen is initially displayed, Countries is Displayed in Tablet Format");
		assertTrue(clcScreen.getText().contains("Title"), true, clcScreen.getText().contains("Title")); // UI-CLS-9
		Log.info("UI-CLS-9- Passed - When the Change Lifecycle State screen is initially displayed, Title is Displayed in Tablet Format");
		initializeTargetLifeCycleStates();
		targetLifeCycleState.selectByIndex(2);
		WebElement List1 = targetLifeCycleState.getFirstSelectedOption();
		System.out.println(List1.getText());
		assertTrue(List1.getText().equals("Internally Approved"), true, List1.getText().equals("Internally Approved")); // UI-CLS-10
		Log.info("UI-CLS-10- Passed - Target lifecycle state list is populated");
		// assertTrue(targetLifeCycleState.isDisplayed(), true, targetLifeCycleState.isDisplayed());
		targetLifeCycleState.selectByIndex(1);
		WebElement List2 = targetLifeCycleState.getFirstSelectedOption();
		System.out.println(List2.getText());
		assertTrue(List2.getText().equals("Internally Approved"), true, List2.getText().equals("Internally Approved")); // UI-CLS-10
		Log.info("UI-CLS-10- Passed - Target lifecycle state list is populated");
		//TODO UI-CLS-11 has to complete
		// assertTrue(targetLifeCycleState.isEnabled(), true, targetLifeCycleState.isEnabled()); //UI-CLS-11
		// Log.info("UI-CLS-11- Passed - Target Lifecycle State field is cleared and enabled.");
		initializeSignOffRequired();
		assertTrue(signOffRequiredLabel.isDisplayed(), true, signOffRequiredLabel.isDisplayed()); // UI-CLS-12
		Log.info("UI-CLS-12- Passed - Sign Off Required label is displayed");
		signatureMeaningLabel.selectByIndex(1);
		WebElement List3 = signatureMeaningLabel.getFirstSelectedOption();
		System.out.println(List3.getText());
		assertTrue(List3.getText().equals("Author Approval"), true, List3.getText().equals("Author Approval")); // UI-CLS-13
		/*
		 * String signature = initializeSignOffRequired(); 
		 * assertTrue(signature.contains("Displayed"), true, signature.contains("Displayed"));
		 */
		Log.info("UI-CLS-13- Passed - Reason for Signature label and selection list is displayed, enabled, and populated with a list of signature ");
		assertTrue(userNameLabel.isEnabled(), true, userNameLabel.isEnabled()); // UI-CLS-14
		Log.info("UI-CLS-14- Passed - User Name label and control is displayed and enabled");
		assertTrue(passwordLabel.isEnabled(), true, passwordLabel.isEnabled()); // UI-CLS-15
		Log.info("UI-CLS-15- Passed - Password label and control is displayed and enabled");
		assertTrue(checkBoxLabel.isSelected(), true, checkBoxLabel.isSelected()); // UI-CLS-16
		Log.info("UI-CLS-16- Passed - Confirmation checkbox and related text is displayed, unchecked and enabled");
		initializeCancelButton();
		assertTrue(cancelBtn.isEnabled(), true, cancelBtn.isEnabled()); // UI-CLS-23
		Log.info("UI-CLS-23- Passed - Cancel button is enabled");
		initializeChangeLifeCycleButton();
		assertTrue(changeLifeCycleBtn.isEnabled(), true, changeLifeCycleBtn.isEnabled()); // UI-CLS-24
		Log.info("UI-CLS-24- Passed - Change Lifecycle State button is displayed and enabled");
		changeLifeCycleBtn.click();
		initializeMessages();
		String successMessage = message.getText();
		assertTrue(message.isDisplayed(), true, message.isDisplayed()); // UI-CLS-30 //UI-CLS-31
		Log.info("UI-CLS-30- Passed - Presses Change LifeCycle button successfully");
		Log.info("UI-CLS-31- Passed - Success message is displayed");
		initializeChangedStatus();
		assertTrue(changedStatus.getText().equals("Internally Approved"), true, changedStatus.getText().equals("Internally Approved")); // UI-CLS-32
		Log.info("UI-CLS-32- Passed - Calling Screen is refreshed");
		assertTrue(changedStatus.isDisplayed(), true, changedStatus.isDisplayed()); // UI-CLS-33
		Log.info("UI-CLS-33- Passed - Change life cycle panel is closed");
		changedStatus.click();
		initializeDocActionMenu();
		processManagement.click();
		initializeDocActionSubMenu();
		subMenuchangeLifeCycleState.click();
		initializeCancelButton();
		cancelBtn.click();
		initializeDocDetailsPanel();
		assertTrue(docDetailsPanel.isDisplayed(), true, docDetailsPanel.isDisplayed()); // UI-CLS-35
		Log.info("UI-CLS-35- Passed -Change Lifecycle State panel is closed.");
		Log.info("UI-CLS-3- Passed -Change Lifecycle State panel is closed.");

		
		 } catch(Throwable t) {
		 
		 Log.info(t.getMessage()); Reporter.log("xmL-UI-ADS-002.doc Document LifeCycle State UA-CLS-30 tested Failed");
		 Log.endTestCase("ChangeStatefromDraftToIAWithSignature"); 
		 Assert.fail(t.getMessage()); 
		 } 
		 Log.endTestCase("ChangeStatefromDraftToIAWithSignature");
		 
	}

	/**
	 * Test forChangeLifeCyclefromDocDraftToIAWithoutSignature of UI 7.0 against the xmL-UI-ADS-002
	 * 
	 * @throws Exception If an error occurs.
	 * 
	 */
	@Test
	public void testChangeStatefromIAtoObsoleteWithoutSignature() throws Exception {
		
		 DOMConfigurator.configure("log4j.xml"); 
		 Log.startTestCase("ChangeStatefromIAtoObsoleteWithoutSignature"); 
		 try{
		homeTest.searchIcon.click();
		schTest.doSearchDocument("AN");
		initializeDocActionMenu();
		processManagement.click();
		initializeDocActionSubMenu();
		subMenuchangeLifeCycleState.click();
		initializeChangeLifeCycleScreen();
		initializeTargetLifeCycleStates();
		targetLifeCycleState.selectByIndex(1);
		String signature = initializeSignOffRequired();
		assertTrue(signature.contains("Hidden"), true, signature.contains("Hidden"));
		Log.info("UI-CLS-17- Passed - Sign Off Required label is hidden");
		Log.info("UI-CLS-18- Passed - Reason for Signature label and selection list is hidden");
		Log.info("UI-CLS-19- Passed - User Name label and control is hidden");
		Log.info("UI-CLS-20- Passed - Password control is hidden.");
		Log.info("UI-CLS-21- Passed - Confirmation checkbox and related text is hidden");
		initializeChangeLifeCycleButton();
		assertTrue(!changeLifeCycleBtn.isEnabled(), true, !changeLifeCycleBtn.isEnabled()); //UI-CLS-22
		Log.info("UI-CLS-22- Passed - Change State button is hidden");
		initializeCancelButton();
		cancelBtn.click();
		initializeDocDetailsPanel();
		assertTrue(docDetailsPanel.isDisplayed(), true, docDetailsPanel.isDisplayed()); // UI-CLS-35
		Log.info("UI-CLS-35- Passed -Change Lifecycle State panel is closed.");
		Log.info("UI-CLS-3- Passed -Change Lifecycle State panel is closed.");

		
		 } catch(Throwable t) {
		  
		  Log.info(t.getMessage()); 
		  Reporter.log("xmL-UI-ADS-002.doc Document LifeCycle State tested Failed ");
		  Log.endTestCase("ChangeStatefromIAtoObsoleteWithoutSignature");
		   Assert.fail(t.getMessage());
		    }
		     Log.endTestCase("ChangeStatefromIAtoObsoleteWithoutSignature");
		 
	}

	
	

	

	public String doChangeStateDrafttoIA(String documentid) throws Exception {
		// DOMConfigurator.configure("log4j.xml");
		try {
			// String docID=getDocID(documentid);
			/*
			 * initializeSearch(); searchDoc.click(); initializeBasicSearch(); basicSearch.click(); initializeDocIDSearch(); Thread.sleep(2000);
			 * docIDSearchdropdown.selectByVisibleText("="); enterDocIDbox.clear(); enterDocIDbox.sendKeys(documentid); Thread.sleep(3000); searchButton.click();
			 * Thread.sleep(4000); initializeDocument(); Thread.sleep(4000); filterDocID.click(); initializeGear(); Thread.sleep(4000); gear.click();
			 */
			schTest.doSearchDocument(documentid);
			contentManagementScreen.initializeEdit();
			contentManagementScreen.editLink.click();
			initializeChangeLifeCycle();
			Thread.sleep(4000);
			changeLifeCycleIcon.click();
			initializeChangeLifeCycleState();
			initializeCLSProperties();
			initializeTargetLifeCycleStates();
			initializeTargetLifeCycleStateFields();
			initializeTLCSDropDown();
			dropDown.selectByIndex(1);
			initializeSignOffRequired();
			signoffDropDown.selectByIndex(1);
			userNameLabel.sendKeys("appmanager01");
			passwordLabel.sendKeys("password");
			checkBoxLabel.click();
			initializeChangeLifeCycleButton();
			changeLifeCycleBtn.click();
			initializeMessages();
			// String successMessage = message.getText();
			// return successMessage;
		} catch (Throwable t) {
			Log.info(t.getMessage());
			Assert.fail(t.getMessage());
		}
		return message.getText();

	}

	public String doChangeStateDrafttoIA(String documentid, String docType) throws Exception {
		if (docType.equals("NDC")) {
			initializeCLCForNDC();
			makeSelection.selectByVisibleText("Internally Approved");
			finish.click();
		}

		return docType;
	}

	public String doChangeStateDrafttoIAForNonContentDoc() throws Exception {
		// DOMConfigurator.configure("log4j.xml");
		try {
			// String docID=getDocID(documentid);
			// initializeGear();
			// Thread.sleep(4000);
			// gear.click();
			initializeChangeLifeCycle();
			Thread.sleep(4000);
			changeLifeCycleIcon.click();
			initializeChangeLifeCycleState();
			initializeCLSProperties();
			initializeTargetLifeCycleStates();
			initializeTargetLifeCycleStateFields();
			initializeTLCSDropDown();
			dropDown.selectByIndex(1);
			initializeChangeLifeCycleButton();
			changeLifeCycleBtn.click();
			initializeMessages();
			// String successMessage = message.getText();
			// return successMessage;
		} catch (Throwable t) {
			Log.info(t.getMessage());
			Assert.fail(t.getMessage());
		}
		return message.getText();

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
