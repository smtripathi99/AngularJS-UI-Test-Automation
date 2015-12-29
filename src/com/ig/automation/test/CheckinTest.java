package com.ig.automation.test;

import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ig.automation.screens.CheckinScreen;
import com.ig.automation.screens.ContentManagementScreen;
import com.ig.automation.utility.Log;


public class CheckinTest extends CheckinScreen {

	HomeTest homeTest = new HomeTest();
	SearchTest searchTest = new SearchTest();
	ContentManagementScreen contentManagementScreen = new ContentManagementScreen();
	LoginTest loginTest = new LoginTest();
	CreateDocumentTest createDocumentTest = new CreateDocumentTest();
	ChangeLifeCycleStateTest changeLifeCycleStateTest = new ChangeLifeCycleStateTest();
	HAInterActionTest haInterActionTest = new HAInterActionTest();
	
	
	@BeforeClass
	public void login() {
		try {
			loginTest.launchUrl();
			String username = "appmanager01";
			String password = "password";
			loginTest.doLogin(username, password);
			Thread.sleep (2000);
			Log.info(username + ": is able to log in Successfully.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test the Checkin Page of UI 7.0 against the xmL-UI-ADS-004 Check-in
	 * 
	 * @throws Exception If an error occurs.
	 * 
	 */
	@Test
	public void testCheckin() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Checkin Test Started");
		try {
			/*homeTest.initializeLeftNavigationObjects();
			homeTest.actions.click();
			Thread.sleep(2000);
			homeTest.initializeActionObjects();
			homeTest.createDoc.click();
			Thread.sleep(2000);
			contentManagementScreen.initializeAnnex();
			contentManagementScreen.annexLink.click();
			Thread.sleep(2000);
			String docId=createDocumentTest.doCreateDocument("Annex II","Test ST B","Austria","English","Alkaline Aqua","ALLERSOLV","","");
			System.out.println(docId);
			Log.info("New Annex 2 Document is created successfully .Document Id Is : " + docId); */
			String docId = "AN-3369";
		//	searchTest.doSearchDocument(docId);
		/*	try {
				contentManagementScreen.initializeEdit();
				contentManagementScreen.editLink.click();
				contentManagementScreen.initializeEditDocument();
				contentManagementScreen.editDocument.click();
			} catch (Exception e) {
				System.out.println("Edit Fail");
			}
			driver.switchTo().defaultContent();*/
	//		initializeCheckInKey();
	//		checkInKey.click();
	//		initializeCheckinPanel();
			/*try {
				checkInTitle.getText();
				assertTrue(checkInTitle.getText().contains("Checkin Document"),true,checkInTitle.getText().contains("Checkin Document"));
				Log.info("Check In Screen is displayed Successfully");
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			try {
				checkInHeader.getText();
				assertTrue(checkInHeader.getText().contains(docId),true ,checkInHeader.getText().contains(docId));
				Log.info(" UI-CIC-01 - PASSED : Document ID is displayed successfully for Check In Panel." + docId);
				assertTrue(checkInHeader.getText().contains("Version"), true ,checkInHeader.getText().contains("Version"));
				Log.info(" UI-CIC-02 - PASSED : Version is displayed successfully for Check In Panel.");
				assertTrue(checkInHeader.getText().contains("Status"), true , checkInHeader.getText().contains("Status"));
				Log.info(" UI-CIC-03 - PASSED : Status is displayed successfully for Check In Panel.");
				assertTrue(checkInHeader.getText().contains("Language"), true ,checkInHeader.getText().contains("Language"));
				Log.info(" UI-CIC-04 - PASSED : Language is displayed successfully for Check In Panel.");
				assertTrue(checkInHeader.getText().contains("Countries"),true ,checkInHeader.getText().contains("Countries"));
				Log.info(" UI-CIC-05 - PASSED : Countries is displayed successfully for Check In Panel.");
				assertTrue(checkInHeader.getText().contains("Title"), true,checkInHeader.getText().contains("Title"));
				Log.info(" UI-CIC-06 - PASSED : Title is displayed successfully for Check In Screen.");
			} catch (Exception e) {
				// TODO: handle exception
			}
			//TODO - UI-CIC-07
		//	assertTrue(reasonRevision.is, true,checkInHeader.getText().contains("Title"));
		//	Log.info(" UI-CIC-07 - PASSED : Title is displayed successfully for Check In Screen.");
			
			
			assertTrue(comments.isDisplayed(), true,comments.isDisplayed());
			Log.info(" UI-CIC-08 - PASSED : Comment field is displayed successfully for Check In Panel.");
			assertTrue(comments.isEnabled(), true,comments.isEnabled());
			Log.info(" UI-CIC-08 - PASSED : Comment field is Enabled successfully for Check In Panel.");
			cancelBtn.click();
			Thread.sleep(2000);*/
			
		/*	searchTest.doEditSearchView("TMP-", "Draft");
			initializeLockKey();
			if(lockKey!=null){
				try {
					contentManagementScreen.initializeEdit();
					contentManagementScreen.editLink.click();
					contentManagementScreen.initializeEditDocument();
					//TODO :click on cancel checkout link 
					contentManagementScreen.editDocument.click();
				} catch (Exception e) {
					System.out.println("Edit Fail");
				}
				driver.switchTo().defaultContent();
				initializeCheckInKey();
				checkInKey.click();
			}else if(checkInKey!=null){
				checkInKey.click();
			}else{
				try {
					contentManagementScreen.initializeEdit();
					contentManagementScreen.editLink.click();
					contentManagementScreen.initializeEditDocument();
					contentManagementScreen.editDocument.click();
				} catch (Exception e) {
					System.out.println("Edit Fail");
				}
				driver.switchTo().defaultContent();
				initializeCheckInKey();
				checkInKey.click();
			}
			
			initializeCheckInSameMinorRadioBtn();
			assertTrue(minorVersionRadioBtn.isDisplayed(), true,minorVersionRadioBtn.isDisplayed());
			Log.info(" SR-EV-18 - PASSED : Minor Version Radio Button is displayed successfully for Check In Panel.");
			assertTrue(sameVersionRadioBtn.isDisplayed(), true,sameVersionRadioBtn.isDisplayed());
			Log.info(" SR-EV-19 - PASSED : Same Version Radio Button is displayed successfully for Check In Panel."); //10
			doneBtn.click();*/
			/*homeTest.initializeLeftNavigationObjects();
			homeTest.actions.click();
			Thread.sleep(2000);
			homeTest.initializeActionObjects();
			homeTest.createDoc.click();
			Thread.sleep(2000);
			contentManagementScreen.initializeSupportingDoc();
			contentManagementScreen.supportingDocLink.click();
			
			String docIdForSupportingDoc=createDocumentTest.doCreateDocument("Supporting Document","Test Supporting Doc","Austria","Romanian","","","","");
			System.out.println(docIdForSupportingDoc);
			Log.info("New supproting Document is created successfully .Document Id Is : " + docIdForSupportingDoc); */
		String docIdForSupportingDoc= "SUP-003";
			searchTest.doEditSearchView(docIdForSupportingDoc);
			try {
				contentManagementScreen.initializeEdit();
				contentManagementScreen.editLink.click();
				contentManagementScreen.initializeEditDocument();
				contentManagementScreen.editDocument.click();
			} catch (Exception e) {
				System.out.println("Edit Fail");
			}
			driver.switchTo().defaultContent();
			initializeCheckInKey();
			checkInKey.click();
			
			initializeMajorVersion();
			assertTrue(majorVersion.isDisplayed(), true,majorVersion.isDisplayed());
			Log.info("PASSED : Major Version is displayed successfully for Check In Panel."); //11
			initializeCheckinPanel();
			cancelBtn.click();
			
			changeLifeCycleStateTest.doChangeStateDrafttoIA(docIdForSupportingDoc);
			
			haInterActionTest.doSubmitToHA(docId);
			haInterActionTest.doRecordHAResponse(docId, "Approved", "ADS-004");
			
			doCheckin(docId);
			searchTest.doSearchDocument(docId, "HA Approved");
			checkInKey.click();
			initializeBrachVersion();
			assertTrue(branchVersion.isDisplayed(), true,branchVersion.isDisplayed());
			Log.info(" SR-EV-20 - PASSED : Branch Version is displayed successfully for Check In Panel."); 
			//Defect Radio Button : Step 12 7 13
			//Defect 1528 : Step 15 & 16
			
			initializeSourceDocPanel();
			assertTrue(sourceDocLabel.isDisplayed(), true,sourceDocLabel.isDisplayed());
			Log.info(" SR-EV-46 - PASSED : Source Document Section in the Check In panel is displayed successfully.");
			
			assertTrue(sourceDocHeader.getText().contains("Doc Id"),true,sourceDocHeader.getText().contains("Doc Id"));
			Log.info("PASSED : Document ID is displayed Successfully for each Source Document version listed on the screen.");
			assertTrue(sourceDocHeader.getText().contains("Version"),true ,sourceDocHeader.getText().contains("Version"));
			Log.info("PASSED : Version is displayed Successfully for each Source Document version listed on the screen.");
			assertTrue(sourceDocHeader.getText().contains("Status"), true ,sourceDocHeader.getText().contains("Status"));
			Log.info("PASSED : Status is displayed Successfully for each Source Document version listed on the screen.");
			assertTrue(sourceDocHeader.getText().contains("Language"), true , sourceDocHeader.getText().contains("Language"));
			Log.info("PASSED : Language is displayed Successfully for each Source Document version listed on the screen.");
			assertTrue(sourceDocHeader.getText().contains("Countries"), true ,sourceDocHeader.getText().contains("Countries"));
			Log.info("PASSED : Countries is displayed Successfully for each Source Document version listed on the screen.");
			assertTrue(sourceDocHeader.getText().contains("Title"),true ,sourceDocHeader.getText().contains("Title"));
			Log.info("PASSED : Title is displayed Successfully for each Source Document version listed on the screen.");
			
			assertTrue(doneBtn.isDisplayed(), true,doneBtn.isDisplayed());
			Log.info(" PASSED : Check In button is displayed successfully for Check In Panel.");
			assertTrue(doneBtn.isEnabled(), true,doneBtn.isEnabled());
			Log.info(" PASSED : Check In button is Enabled successfully for Check In Panel.");
			
			assertTrue(cancelBtn.isDisplayed(), true,cancelBtn.isDisplayed());
			Log.info(" PASSED : Cancel button is displayed successfully for Check In Panel.");
			assertTrue(cancelBtn.isEnabled(), true,cancelBtn.isEnabled());
			Log.info(" PASSED : Cancel button is Enabled successfully for Check In Panel.");
			
			
			//Defect : Step 27 & 28 GLM -1350
			
			cancelBtn.click();
			assertFalse(checkInHeader.getText().contains("Checkin Document"),false,checkInHeader.getText().contains("Checkin Document"));
			Log.info("The Check in panel is closed successfully.");

		} catch (Throwable e) {
			Log.info(e.getMessage());
			Reporter.log("xmL-UI-ADS-004.doc Checkin Document tested unsuccessfully");
			Assert.fail();
		}
		Log.endTestCase("Checkin Test Ended");
	}

	/**
	 * Test the Cancel Edit Properties Page of UI 7.0 against the xmL-UI-ADS-009 Document Properties UA-EP-11
	 * 
	 * @throws Exception If an error occurs.
	 * 
	 */
	@Test
	public void testCancelCheckin() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Edit Properties Cancel Test Started");
		try {
			String docID = getDocID("AN");
			/*initializeSearch();
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
			initializeDocument();*/
			filterDocID.click();
			editMenu.click();
			initializeCheckinPanel();
			cancelBtn.click(); // A-CIC-23
			Reporter.log("xmL-UI-ADS-004.doc Checkin A-CIC-23 tested successfully for Cancel");
		} catch (Throwable e) {
			Log.info(e.getMessage());
			Reporter.log("xmL-UI-ADS-004.doc Checkin A-CIC-23 tested unsuccessfully for Cancel");
			Assert.fail();
		}
		Log.endTestCase("Checkin Cancel Test Ended");

	}
	public String doCheckin(String docid) throws Exception {
		try {
			searchTest.doSearchDocument(docid);
			try {
				contentManagementScreen.initializeEdit();
				contentManagementScreen.editLink.click();
				contentManagementScreen.initializeEditDocument();
				contentManagementScreen.editDocument.click();
			} catch (Exception e) {
				System.out.println("Edit Fail");
			}
			driver.switchTo().defaultContent();
			initializeCheckInKey();
			checkInKey.click();
			initializeCheckinPanel();
			reasonRevision.selectByVisibleText("Health Authority Request");
			comments.sendKeys("Test");
			doneBtn.click();
			return "Checkin success";
		} catch (Throwable e) {
			Log.info(e.getMessage());
			return "Checkin error";
		}
	}

	/*public String doCheckin(String folderName ,String docid) throws Exception {
		try {
			searchTest.doSearchDocument(docid);
			try {
				initializeActionMenu();
				editMenu.click();
				initializeEdit();
				edit.click();
			} catch (Exception e) {
				System.out.println("Edit Fail");
			}
			getScreenShot(folderName, "Edit Screen");
			driver.switchTo().defaultContent();
			initializeCheckInKey();
			checkInKey.click();
			initializeCheckinPanel();
			reasonRevision.selectByVisibleText("Health Authority Request");
			comments.sendKeys("Test");
			getScreenShot(folderName, "Check In Screen");
			doneBtn.click();
			return "Checkin success";
		} catch (Throwable e) {
			Log.info(e.getMessage());
			return "Checkin error";
		}
	}*/
	
	public String doCheckin(String folderName ,String docid, String filePath) throws Exception {
		try {
			try {
				contentManagementScreen.initializeEdit();
				contentManagementScreen.editLink.click();
				contentManagementScreen.initializeEditDocument();
				contentManagementScreen.editDocument.click();
			} catch (Exception e) {
				System.out.println("Edit Fail");
			}
			getScreenShot(folderName, "Edit Screen");
			driver.switchTo().defaultContent();
			initializeCheckInKey();
			checkInKey.click();
			initializeCheckinPanel();
			reasonRevision.selectByVisibleText("Health Authority Request");
			comments.sendKeys("Test");
			if(filePath!= "" || filePath!= null)
				checkinFile.sendKeys(filePath);
			getScreenShot(folderName, "Check In Screen");
			doneBtn.click();
			return "Checkin success";
		} catch (Throwable e) {
			Log.info(e.getMessage());
			return "Checkin error";
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
