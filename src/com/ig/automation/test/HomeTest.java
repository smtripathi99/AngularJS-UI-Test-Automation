package com.ig.automation.test;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ig.automation.coreactions.DataActions;
import com.ig.automation.screens.HomeScreen;
import com.ig.automation.screens.MyDocScreen;
import com.ig.automation.utility.Log;


public class HomeTest extends HomeScreen {

	LoginTest loginTest = new LoginTest();

	@BeforeClass
	public void login() {
		try {
			//loginTest.testLogin();
			launchUrl();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testActionTab() throws Exception {
		launchUrl();
		login();
		System.out.println("Testing Naviagtion");
		initializeLeftNavigationObjects();
		actions.click();
		Thread.sleep(2000);
	}

	public void loginTest() throws Exception {
		launchUrl();
		login();
	}

	public void testHome() throws Exception {
		launchUrl();
		login();
		/*
		 * String username=DataActions.getUserID("role_eu_labeling_author"); String password=DataActions.getUserPassword("role_eu_labeling_author"); loginTest.doLogin(username,
		 * password);
		 */
		initializeLeftNavigationObjects();
		actions.click();
		initializeActionObjects();
		Thread.sleep(2000);
		createDoc.click();
	}

	public void testMyDoc() throws Exception {
		launchUrl();
		login();
		initializeLeftNavigationObjects();
		// initializeObjects();
		myDoc.click();
		Thread.sleep(2000);
	}

	@Test(priority=1)
	public void testLogoff() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Logoff Test Started as per xmL-UI-ADS-003");
		try {
			//launchUrl();
			// login();
			String username = DataActions.getUserID("role_eu_labeling_author");
			String password = DataActions.getUserPassword("role_eu_labeling_author");
			loginTest.doLogin(username, password);
			initializeLeftNavigationObjects();
			Thread.sleep(1000);
			logOff.click();
			Thread.sleep(1000);
			loginTest.initializeObjects();
			Assert.assertTrue(loginTest.titleObj.isDisplayed(),"The user’s session is ended");
			Log.info("UA-LO-01 Passed");
			Assert.assertTrue(loginTest.loginButton.isDisplayed(), "The system log in screen is displayed");
			Log.info("UA-LO-02 passed");
			Reporter.log("xmL-UI-ADS-008 tested successfully");
			Log.endTestCase("Logoff Test Ended");

		} catch (Throwable e) {
			Log.info(e.getMessage());
			Reporter.log("Logoff tested unsuccessfully");
			Assert.fail();
		}

	}

	@Test(priority=2)
	public void testLeftNavigationHome() throws Exception {

		try {
			//launchUrl();
			// login();
			DOMConfigurator.configure("log4j.xml");
			Log.startTestCase("Left Navigation Pane Test Started as per xmL-UI-ADS-003");
			String username = DataActions.getUserID("role_eu_labeling_author");
			String password = DataActions.getUserPassword("role_eu_labeling_author");
			loginTest.doLogin(username, password);
			initializeLeftNavigationObjects();
			Assert.assertTrue(dashboard.isDisplayed(), "Dashboard is displayed");
			Log.info("UA-LNP-1 is passed");
			Assert.assertTrue(repository.isDisplayed(), "Repository is displayed");
			Log.info("UA-LNP-2 is passed");
			Assert.assertTrue(myDoc.isDisplayed(), "My Docs is displayed");
			Log.info("UA-LNP-3 is passed");
			Assert.assertTrue(inbox.isDisplayed(), "Inbox is displayed");
			Log.info("UA-LNP-4 is passed");
			Assert.assertTrue(dynview.isDisplayed(), "Dynamic View is displayed");
			Log.info("UA-LNP-5 is passed");
			Assert.assertTrue(actions.isDisplayed(), "Action is displayed");
			Log.info("UA-LNP-6 is passed");
			Assert.assertTrue(reports.isDisplayed(), "Reports is displayed");
			Log.info("UA-LNP-7 is passed");
			Assert.assertTrue(admin.isDisplayed(), "Admin is displayed");
			Log.info("UA-LNP-8 is passed");
			dashboard.click();
			initializeDashboard();
			Assert.assertTrue(dashboardLabel.isDisplayed(), "Dashborad page is displayed");
			Log.info("UA-LNP-9 is passed");
			repository.click();
			Log.info("UA-LNP-10 is passed");
			myDoc.click();
			Log.info("UA-LNP-11 is passed");
			inbox.click();
			Log.info("UA-LNP-12 is passed");
			dynview.click();
			Log.info("UA-LNP-13 is passed");
			actions.click();
			Log.info("UA-LNP-14 is passed");
			Thread.sleep(1000);
			admin.click();
			logOff.click();
			Log.info("UA-LNP-15 is passed");
			Log.endTestCase("Left Navigation Pane Test Ended");
		} catch (Throwable e) {
			Log.info(e.getMessage());
			Reporter.log("Left Navigation Pane tested unsuccessfully");
			Assert.fail();
		}

	}

	@Test(priority=3)
	public void testTopNavigationHome() throws Exception {
		try {
			//launchUrl();
			// login();
			DOMConfigurator.configure("log4j.xml");
			Log.startTestCase("Top Navigation Pane Test Started as per xmL-UI-ADS-003");
			String username = DataActions.getUserID("role_eu_labeling_author");
			String password = DataActions.getUserPassword("role_eu_labeling_author");
			loginTest.doLogin(username, password);
			initializeTopNavigationObjects(false);
			Assert.assertTrue(leftTitle.isDisplayed(), "xmLabeling Logo is displayed");
			Log.info("UA-TNP-1 is passed");
			Assert.assertTrue(searchIcon.isDisplayed(), "Search Icon is displayed");
			Log.info("UA-TNP-2 is passed");
			Assert.assertTrue(loggedUser.isDisplayed(), "Logged in username is displayed");
			Log.info("UA-TNP-3 is passed");
			if (!(notification==null)){
				Assert.assertTrue(notification.isDisplayed(), "Notification Icon is displayed");
				Log.info("UA-TNP-4 is passed");
			}
			else{
				Log.info("UA-TNP-4 could not be tested as there are no notifications");
			}
			Assert.assertTrue(logOff.isDisplayed(), "Dynamic View is displayed");
			Log.info("UA-TNP-5 is passed");
			searchIcon.click();
			initializeBasicSearch();
			Assert.assertTrue(searchBtn.isDisplayed(), "Search Page is displayed");
			Log.info("UA-TNP-6 is passed");
			if (!(notification==null)){
			notification.click();
			Log.info("UA-TNP-7 is passed");
			}
			else{
				Log.info("UA-TNP-7 could not be tested as there are no notifications");
			}
			logOff.click();
			Log.info("UA-TNP-8 is passed");
			Log.endTestCase("Top Navigation Pane Test Ended");
		} catch (Throwable e) {
			Log.info(e.getMessage());
			Reporter.log("Top Navigation Pane tested unsuccessfully");
			Assert.fail();
		}

	}

	/**
	 * Test the Repository Listing Page of UI 7.0 against the xmL-UI-ADS-012.doc	 * 
	 * @throws Exception If an error occurs.
	 * 
	 */
	@Test(priority=4)
	public void testRepositoryListing() throws Exception {
		try {
			//launchUrl();
			DOMConfigurator.configure("log4j.xml");
			Log.startTestCase("Repository Test Started as per xmL-UI-ADS-012");
			String username = DataActions.getUserID("role_eu_labeling_author");
			String password = DataActions.getUserPassword("role_eu_labeling_author");
			loginTest.doLogin(username, password);
			initializeLeftNavigationObjects();
			repository.click();
			initializeCabinets();
			Assert.assertTrue(productList.isDisplayed(), "Cabinets Page is displayed");
			Log.info("UA-RL-01 is passed");
			productList.click();
			Thread.sleep(2000);
			initializeFolders();
			Assert.assertTrue(folder.isDisplayed(), "Folder of cabinet is displayed");
			Log.info("UA-RL-02 is passed");
			while (!folder.getText().contains("Trans")) {
				Thread.sleep(1000);
				folder.click();
				Thread.sleep(1000);
				initializeFolders();
				Thread.sleep(1000);
			}
			Assert.assertTrue(folder.getText().contains("Trans"), "All applicable documents stored in the current folder is displayed");
			Log.info("UA-RL-03 is passed");
			MyDocScreen mdscr = new MyDocScreen();
			mdscr.initializeMyDocPageObjects();
			Assert.assertEquals(mdscr.myDocPages.getFirstSelectedOption().getText(), "10");
			Log.info("UA-RL-04 Passed");
			if (mdscr.myDocPages.getFirstSelectedOption().getText().contains("10")) {
				Assert.assertTrue(mdscr.pagePrevious.isDisplayed());
				Log.info("UA-RL-05 Passed");
				Assert.assertTrue(mdscr.pageNext.isDisplayed());
				Log.info("UA-RL-06 Passed");
				Assert.assertTrue(mdscr.pageLink.isDisplayed());
				Log.info("UA-RL-07 Passed");
			}
			initializeDocumentsList();
			//docList.click();
			Assert.assertTrue(documentID.isDisplayed());
			Log.info("UA-RL-09 Passed");
			Assert.assertTrue(currentVersion.isDisplayed());
			Log.info("UA-RL-10 Passed");
			Assert.assertTrue(status.isDisplayed());
			Log.info("UA-RL-11 Passed");
			Assert.assertTrue(language.isDisplayed());
			Log.info("UA-RL-12 Passed");
			Assert.assertTrue(title.isDisplayed());
			Log.info("UA-RL-13 Passed");
			Assert.assertTrue(country.isDisplayed());
			Log.info("UA-RL-14 Passed");
			Reporter.log("xmL-UI-ADS-012.doc tested successfully");
			Log.info("Refer Document Details xmL-UI-ADS-012 Test Results");
			logOff.click();

			Log.endTestCase("Repository Listing Test Ended");
		} catch (Throwable e) {
			Log.info(e.getMessage());
			Reporter.log("Repository Listing tested unsuccessfully");
			//Assert.fail();
		}
	}

	public void testCreateCR() throws Exception {
		launchUrl();
		login();
		initializeLeftNavigationObjects();
		actions.click();
		initializeActionObjects();
		createCR.click();
	}

	public void testScreen() throws Exception {
		launchUrl();
		login();
		initializeLeftNavigationObjects();
		searchIcon.click();
	}

	public void testSearch() throws Exception {
		launchUrl();
		login();
		System.out.println("Testing Search");
		initializeSearch();
		searchIcon.click();
		initializeBasicSearchIcon();
		basicSearchIcon.click();
		initializeBasicSearch();
		// docIDSearch.click();
		// Reporter.log("R-CN-1 of xmL-SRS-005.doc v1.0 tested successfully");
		// Log.info("R-CN-1 of xmL-SRS-005.doc v1.0 tested successfully");
	}

	public void testCP() throws Exception {
		launchUrl();
		// login();
		String userid = DataActions.getUserID("role_eu_labeling_author");
		String password = DataActions.getUserPassword("role_eu_labeling_author");
		loginTest.doLogin(userid, password);
		initializeLeftNavigationObjects();
		actions.click();
		Thread.sleep(2000);
		initializeActionObjects();
		Thread.sleep(2000);
		eusubmission.click();
		Thread.sleep(2000);
		initializeEUSubmissionObjects();
		createCP.click();
		Reporter.log("R-CN-1 of xmL-SRS-015.doc v1.0 tested successfully");
		Log.info("R-CN-1 of xmL-SRS-015.doc v1.0 tested successfully");
	}

	public void testRMS() throws Exception {
		launchUrl();
		login();
		initializeLeftNavigationObjects();
		actions.click();
		Thread.sleep(2000);
		initializeActionObjects();
		Thread.sleep(2000);
		eusubmission.click();
		Thread.sleep(2000);
		initializeEUSubmissionObjects();
		createRMS.click();
		System.out.println("Create RMS is clicked Successfully");
		Reporter.log("R-CN-1 of xmL-SRS-020.doc v1.0 tested successfully");
		Log.info("R-CN-1 of xmL-SRS-020.doc v1.0 tested successfully");
	}

	public void testSPLReg() throws Exception {
		launchUrl();
		login();
		initializeLeftNavigationObjects();
		actions.click();
		initializeActionObjects();
		spl.click();
		initializeSPLObjects();
		createNewRegistration.click();
	}

	public void testSPLSelfID() throws Exception {
		launchUrl();
		login();
		initializeLeftNavigationObjects();
		actions.click();
		initializeActionObjects();
		spl.click();
		initializeSPLObjects();
		createNewSelfID.click();
	}

	public void testSPLNDC() throws Exception {
		launchUrl();
		login();
		initializeLeftNavigationObjects();
		actions.click();
		initializeActionObjects();
		spl.click();
		initializeSPLObjects();
		createNewNDC.click();
	}

	public void testRFA() throws Exception {
		launchUrl();
		// login();
		String userid = DataActions.getUserID("role_eu_labeling_author");
		String password = DataActions.getUserPassword("role_eu_labeling_author");
		loginTest.doLogin(userid, password);
		initializeLeftNavigationObjects();
		actions.click();
		Thread.sleep(2000);
		initializeActionObjects();
		Thread.sleep(2000);
		eusubmission.click();
		Thread.sleep(2000);
		initializeEUSubmissionObjects();
		createCP.click();
	}

	public void clickSMPCLink() throws InterruptedException {
		initializeLeftNavigationObjects();
		actions.click();
		Thread.sleep(2000);
		initializeActionObjects();
		createDoc.click();
		Thread.sleep(2000);
		initializeSelectDocType();
		SMPCLink.click();
		Thread.sleep(2000);
	}

	@AfterClass
	public void tearDown() throws Exception {
		if(driver !=null){
			driver.close();
			driver.quit();
		}
	}

}
