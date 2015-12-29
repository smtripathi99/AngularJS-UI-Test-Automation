package com.ig.automation.systemtest;

import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ig.automation.screens.ContentManagementScreen;
import com.ig.automation.screens.SystemTestScreen;
import com.ig.automation.test.CheckinTest;
import com.ig.automation.test.CreateDocumentTest;
import com.ig.automation.test.GenerateCleanCopyTest;
import com.ig.automation.test.HomeTest;
import com.ig.automation.test.LoginTest;
import com.ig.automation.test.SearchTest;
import com.ig.automation.utility.Log;

public class GenerateCleanCopyST extends SystemTestScreen {
	
	LoginTest loginTest = new LoginTest();
	HomeTest homeTest = new HomeTest();
	ContentManagementScreen contentManagementScreen = new ContentManagementScreen();
	CreateDocumentTest createDocumentTest = new CreateDocumentTest();
	SearchTest searchTest = new SearchTest();
	CheckinTest checkinTest = new CheckinTest();
	GenerateCleanCopyTest generateCleanCopyTest = new GenerateCleanCopyTest();
	
	
	@BeforeClass
	public void login() throws Exception{
		loginTest.launchUrl();
		String username = "author01";
		String password = "password";
		loginTest.doLogin(username, password);
		Thread.sleep (2000);
		Log.info(username + ": is able to log in Successfully.");
	}
	
	@Test
	public void reviewDocSTTest() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Generate Clean Copy System Test");
		try {
			homeTest.actions.click();
			Thread.sleep(2000);
			homeTest.initializeActionObjects();
			homeTest.createDoc.click();
			Thread.sleep(2000);
			contentManagementScreen.initializeAnnex();
			contentManagementScreen.annexLink.click();
			String docId=createDocumentTest.doCreateDocument("Annex II","Test ST B","Austria","English","Alkaline Aqua","ALLERSOLV","","");
			System.out.println(docId);
			Log.info("New Annex 2 Document is created successfully .Document Id Is : " + docId); // 5	
		//	String docId = "" ;
//		searchTest.doSearchDocument("AN-3091");
			
			String checkInMessage_01 = checkinTest.doCheckin("ST-030", docId , "D:\\GWS\\xmLabeling_ig_UI\\Test\\UI\\Automation\\gtc_ig_automation\\testData\\Annex-TestData1.xml");
			assertTrue(checkInMessage_01.contains("Success"), true , checkInMessage_01.contains("Success"));
			Log.info("SR-EV-04 - PASSED :Document A is checked In the system Successfully");
			initializeVersion();
			try {
				String versionValueForDocA_01 = version.getText();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		//	Assert.assertEquals(versionValueForDocA_01.contains("0.2"),true, "Actual Version is :" + versionValueForDocA_01 + " Expected source ID Is : 0.2 " );
			Log.info("SR-EV-10 - PASSED : Document A is checked in as new minor version 0.2 Successfully.");
			 Log.info("Please verify Step 2 to Step 5 manually");
			
			// Defect - GCC success message is not displayed - 
			List<String> itemsToValidateGCC_02 = generateCleanCopyTest.doGenerateCleanCopyTest("ST-030", "Accept");
			assertTrue(itemsToValidateGCC_02.get(0).contains("Generate Clean Copy"), true, itemsToValidateGCC_02.get(0).contains("Generate Clean Copy"));
			Log.info("Generate Clean Copy Screen is displayed Successfully");
			assertTrue(itemsToValidateGCC_02.get(1).contains("Clean copy successfully generated for document"), true ,itemsToValidateGCC_02.get(1).contains("Clean copy successfully generated for document"));
			Log.info("SR-RM-11 - PASSED : Clean copy successfully generated for document.*** Success Message ***  " + itemsToValidateGCC_02.get(1));
			initializeVersion();
			String versionValueForDocAAfterGCC_02 = version.getText();
			Assert.assertEquals(versionValueForDocAAfterGCC_02.contains("0.3"),true, "Actual Version is :" + versionValueForDocAAfterGCC_02 + " Expected source ID Is : 0.3 " );
			Log.info("SR-RM-11 - PASSED :  A new minor version 0.3 of Document A is created successfully ..");
			
			
			searchTest.doSearchDocument(docId);
			String checkInMessage_03 = checkinTest.doCheckin("ST-030", docId , "D:/GWS/xmLabeling_ig_UI/Test/UI/Automation/gtc_ig_automation/test/DatatestData/Annex-TestData2.xml");
			assertTrue(checkInMessage_03.contains("Success"), true , checkInMessage_03.contains("Success"));
			Log.info("Document A is checked In the system Successfully");
			initializeVersion();
			String versionValueForDocA_03= version.getText();
			Assert.assertEquals(versionValueForDocA_03.contains("0.4"),true, "Actual Version is :" + versionValueForDocA_03 + " Expected source ID Is : 0.4 " );
			Log.info("Document A is checked in as new minor version 0.4 Successfully.");
			 Log.info("Please verify step 7 to Step 24 manually");
			
			List<String> itemsToValidateGCC_04 = generateCleanCopyTest.doGenerateCleanCopyTest("ST-030", "All");
			assertTrue(itemsToValidateGCC_04.get(0).contains("Generate Clean Copy"), true, itemsToValidateGCC_04.get(0).contains("Generate Clean Copy"));
			Log.info("Generate Clean Copy Screen is displayed Successfully");
			assertTrue(itemsToValidateGCC_04.get(1).contains("Clean copy successfully generated for document"), true ,itemsToValidateGCC_04.get(1).contains("Clean copy successfully generated for document"));
			Log.info("SR-RM-11 - PASSED : Clean copy successfully generated for document.*** Success Message ***  " + itemsToValidateGCC_04.get(1));
			initializeVersion();
			String versionValueForDocAAfterGCC_04 = version.getText();
			Assert.assertEquals(versionValueForDocAAfterGCC_04.contains("0.5"),true, "Actual Version is :" + versionValueForDocAAfterGCC_04 + " Expected source ID Is : 0.5" );
			Log.info("SR-RM-11 - PASSED :  A new minor version 0.5 of Document A is created successfully."); //36
			 Log.info("Please verify Step 25 to Step 45 manually.");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
