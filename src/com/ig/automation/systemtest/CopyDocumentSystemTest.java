package com.ig.automation.systemtest;

import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ig.automation.screens.ContentManagementScreen;
import com.ig.automation.screens.CreateCRScreen;
import com.ig.automation.screens.DocumentDetailsScreen;
import com.ig.automation.screens.InboxScreen;
import com.ig.automation.screens.SystemTestScreen;
import com.ig.automation.test.ChangeLifeCycleStateTest;
import com.ig.automation.test.CheckinTest;
import com.ig.automation.test.CopyDocumentTest;
import com.ig.automation.test.CreateCRTest;
import com.ig.automation.test.CreateDocumentTest;
import com.ig.automation.test.ExportDocumentTest;
import com.ig.automation.test.HomeTest;
import com.ig.automation.test.LoginTest;
import com.ig.automation.test.SearchTest;
import com.ig.automation.test.WorkFlowRFATest;
import com.ig.automation.test.WorkFlowRFRTest;
import com.ig.automation.utility.Log;

public class CopyDocumentSystemTest extends SystemTestScreen{
	
	LoginTest loginTest = new LoginTest();
	HomeTest homeTest = new HomeTest();
	ContentManagementScreen contentMngScreen = new ContentManagementScreen();
	CreateDocumentTest createDocumentTest = new CreateDocumentTest();
	WorkFlowRFRTest workFlowRFRTest = new WorkFlowRFRTest();
	ContentManagementScreen contentManScreen = new ContentManagementScreen();
	CheckinTest checkinTest = new CheckinTest();
	CreateCRScreen createCRScreen = new CreateCRScreen();
	CreateCRTest crTest = new CreateCRTest();
	InboxScreen inboxScreen = new InboxScreen();
	SystemTestScreen systemTestScreen = new SystemTestScreen();
	WorkFlowRFATest workFlowRFATest = new WorkFlowRFATest();
	SearchTest searchTest = new SearchTest();
	ChangeLifeCycleStateTest changeLifeCycleStateTest = new ChangeLifeCycleStateTest();
	ExportDocumentTest exportDocumentTest = new ExportDocumentTest();
	DocumentDetailsScreen documentDetailsScreen = new DocumentDetailsScreen();
	CopyDocumentTest copyDocument = new CopyDocumentTest();
	String documentA = null;
	String documentB = null;
	String documentC = null;
	String title= "SMPC - Document A";
	String country = "European Union" ;
	String language = "English";
	String product = "Alkaline Aqua";
	String proprietary = "ALLERSOLV";

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
		Log.startTestCase("Copy Document System Test");
		try {
			homeTest.clickSMPCLink();
			documentA=createDocumentTest.doCreateDocument("Summary of Product Characteristics", title, country, language,  product , proprietary , "" , "");
			Log.info("Document A is created sucessfully.");
			Log.info("Document ID of Document A is : " + documentA);
			try {
				String successMessage = changeLifeCycleStateTest.doChangeStateDrafttoIA(documentA);
				//Need to update the expected message 
				Assert.assertEquals(successMessage.contains("Success"),true, "Actual Message is :" + successMessage + " Expected source ID Is : ");
				Log.info("Document A state should be changed to “Internally Approved”"); //6
			} catch (Exception e) {
				// TODO: handle exception
			}
								
			String docIdB = copyDocument.doCopyDocument(documentA);
			Log.info("SR-CD-1 ,SR-CD-3,SR-CD-6 - Document B is created and the Document Id is" + docIdB);
			
			searchTest.doSearchDocument(docIdB);
			String statusDocB = driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[3]/div/div/div[1]/div[1]/div/div[4]/div[3]/div[7]/div/div")).getText();
			Assert.assertTrue(statusDocB.equals("Draft"), "Draft Status is displayed successfully for Document B .");
			Log.info("SR-CD-7 , SR-CD-8 - Draft Status is displayed successfully for Document B .");
			propertiesCheck();
			getScreenShot("ST_018", "Doc B Details"); //10
			
			searchTest.doSearchDocument(documentA);
			String docIdC = copyDocument.doCopyDocument(documentA);
			Log.info(" SR-CD-3 - Document C is created and the Document Id is" + docIdC);//11
			getScreenShot("ST_018", "Doc C Screen"); //11
			
			
			List<String> sourceDocDetailsDocB0_1 = searchTest.doCheckSourceDoc(docIdB);
			Assert.assertEquals(sourceDocDetailsDocB0_1.get(0).contains(documentA),true, "Actual source Id is :" + sourceDocDetailsDocB0_1.get(0) + " Expected source ID Is : " + documentA);
			Log.info("  SR-CD-11 - Source document of Document B : " + sourceDocDetailsDocB0_1.get(0) + "is displayed successfully.");
			Assert.assertEquals(sourceDocDetailsDocB0_1.get(1).contains("0.1"),true, "Actual Version for Doc A is :" + sourceDocDetailsDocB0_1.get(1) + " Expected source ID Is : 0.1 ");
			Log.info("  SR-CD-11 - Version ID of Document A " + sourceDocDetailsDocB0_1.get(1) + "is displayed successfully."); //12
			documentDetailsScreen.initializeSecondSourceDocId();
			Assert.assertTrue(documentDetailsScreen.secSourceDocId.equals("null"));
			Log.info("Document C version 0.1 is not listed on the Clones Tab of Document B version 0.1.");
			getScreenShot("ST_018", "SourceScreen_DocB");
			
			List<String> sourceDocDetailsDocC0_1 = searchTest.doCheckSourceDoc(docIdC);
			Assert.assertEquals(sourceDocDetailsDocC0_1.get(0).contains(documentA),true, "Actual source Id is :" + sourceDocDetailsDocC0_1.get(0) + " Expected source ID Is : " + documentA);
			Log.info("  SR-CD-11 - Source document of Document C : " + sourceDocDetailsDocB0_1.get(0) + "is displayed successfully.");
			Assert.assertEquals(sourceDocDetailsDocC0_1.get(1).contains("0.1"),true, "Actual Version for Doc A is :" + sourceDocDetailsDocC0_1.get(1) + " Expected source ID Is : 0.1 ");
			Log.info("  SR-CD-11 - Version ID of Document A " + sourceDocDetailsDocC0_1.get(1) + "is displayed successfully."); //13
			documentDetailsScreen.initializeSecondSourceDocId();
			Assert.assertTrue(documentDetailsScreen.secSourceDocId.equals("null"));
			Log.info("Document B version 0.1 is not listed on the Clones Tab of Document C version 0.1");
			getScreenShot("ST_018", "SourceScreen_DocC");
			
			
			searchTest.doSearchDocument(documentA);
			checkinTest.doCheckin("ST_", documentA ,"");
			initializeVersion();
			String versionValueForDocA0_1 = version.getText();
			Assert.assertEquals(versionValueForDocA0_1.contains("0.2"),true, "Actual Version is :" + versionValueForDocA0_1 + " Expected source ID Is : 0.2 " );
			Log.info(" Document A is checked in as new minor version 0.2 Successfully."); //14
				
			List<String> sourceDocDetailsDocB = searchTest.doCheckSourceDoc(docIdB);
			Assert.assertEquals(sourceDocDetailsDocB.get(0).contains(documentA),true, "Actual source Id is :" + sourceDocDetailsDocB.get(0) + " Expected source ID Is : " + documentA);
			Log.info("  SR-CD-11 - Source document of Document B : " + sourceDocDetailsDocB0_1.get(0) + "is displayed successfully.");
			Assert.assertEquals(sourceDocDetailsDocB.get(1).contains("0.2"),true, "Actual Version for Doc A is :" + sourceDocDetailsDocB.get(1) + " Expected source ID Is : 0.2 ");
			Log.info("  SR-CD-11 - Version ID of Document A " + sourceDocDetailsDocB.get(1) + "is displayed successfully."); 
			
			
			searchTest.doSearchDocument(documentA);
			checkinTest.doCheckin("ST_", documentA ,"");
			initializeVersion();
			String versionValueForDocA0_2 = version.getText();
			Assert.assertEquals(versionValueForDocA0_2.contains("0.3"),true, "Actual Version is :" + versionValueForDocA0_2 + " Expected source ID Is : 0.3 " );
			Log.info(" SR-CD-7- Document A is checked in as new minor version 0.3 Successfully."); //18
			getScreenShot("ST_018", "Doc A _ 0.3");
			
			searchTest.doSearchDocument(docIdB);
			checkinTest.doCheckin("ST_", docIdB ,"");
			initializeVersion();
			String versionValueForDocB0_1 = version.getText();
			Assert.assertEquals(versionValueForDocB0_1.contains("0.2"),true, "Actual Version is :" + versionValueForDocB0_1 + " Expected source ID Is : 0.2 " );
			Log.info(" SR-CD-7 - Document B is checked in as new minor version 0.2 Successfully."); //18
			getScreenShot("ST_018", "Doc B _ 0.2");
			
			List<String> sourceDocDetailsDocB0_2 = searchTest.doCheckSourceDoc(docIdB);
			Assert.assertEquals(sourceDocDetailsDocB0_2.get(0).contains(documentA),true, "Actual source Id is :" + sourceDocDetailsDocB0_2.get(0) + " Expected source ID Is : " + documentA);
			Log.info(" SR-CD-11 - Source document of Document B " + sourceDocDetailsDocB0_2.get(0) + "is displayed successfully.");
			Assert.assertEquals(sourceDocDetailsDocB0_2.get(1).contains("0.3"),true, "Actual Version for Doc A is :" + sourceDocDetailsDocB0_2 + " Expected source ID Is : 0.3 ");
			Log.info(" SR-CD-11 - Version ID of Document A " + sourceDocDetailsDocB0_2.get(1) + "is displayed successfully."); //19
			getScreenShot("ST_018", "SR-CD-11_DocB");
			
			List<String> sourceDocDetailsForDocC0_1 = searchTest.doCheckSourceDoc(docIdC);
			Assert.assertEquals(sourceDocDetailsForDocC0_1.get(0).contains(documentA),true, "Actual source Id is :" + sourceDocDetailsForDocC0_1.get(0) + " Expected source ID Is : " + documentA);
			Log.info(" SR-CD-11 - Source document of Document C " + sourceDocDetailsForDocC0_1.get(0) + "is displayed successfully.");
			Assert.assertEquals(sourceDocDetailsForDocC0_1.get(1).contains("0.3"),true, "Actual Version for Doc A is :" + sourceDocDetailsForDocC0_1.get(1) + " Expected source ID Is : 0.3 ");
			Log.info(" SR-CD-11 - Version ID of Document A " + sourceDocDetailsForDocC0_1.get(1) + "is displayed successfully."); //20
			getScreenShot("ST_018", "SR-CD-11_DocC");
			
			searchTest.doSearchDocument(docIdB);
			documentDetailsScreen.initializeAuditTrailEvent();
			String event = documentDetailsScreen.auditTrailEvent.getText();
			Assert.assertEquals(event.contains("Copy Document"),true, "Actual Event for Doc B is :" + event + " Expected document for Document B is Copy Document. ");
			Log.info(" SR-CD-11 - Version ID of Document A " + sourceDocDetailsForDocC0_1.get(1) + "is displayed successfully."); //20
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	public void propertiesCheck(){
		documentDetailsScreen.initializeProperties();
		documentDetailsScreen.properties.click();
		documentDetailsScreen.initializePropertiesValues();
		String copiedTitleValue = documentDetailsScreen.titleValue.getText();
		String copiedCountryValue = documentDetailsScreen.countriesValue.getText();
		String copiedLanguageValue = documentDetailsScreen.languageValue.getText();
		String copiedProductValue = documentDetailsScreen.productNames.getText();
		String copiedProprietryValue = documentDetailsScreen.proprietaryNames.getText();
		
		Assert.assertEquals(copiedTitleValue.contains(title),true, "Actual is :" + title + " Expected Value : " + copiedTitleValue);
		Log.info("Title is displayed Successfully.");
		Assert.assertEquals(copiedTitleValue.contains(title),true, "Actual is :" + country + " Expected Value : " + copiedCountryValue);
		Log.info("Country is displayed Successfully");
		Assert.assertEquals(copiedTitleValue.contains(title),true, "Actual is :" + language + " Expected Value : " + copiedLanguageValue);
		Log.info("Language is displayed Successfully");
		Assert.assertEquals(copiedTitleValue.contains(title),true, "Actual is :" + product + " Expected Value : " + copiedProductValue);
		Log.info("Product Name is displayed Successfully");
		Assert.assertEquals(copiedTitleValue.contains(title),true, "Actual is :" + proprietary + " Expected Value : " + copiedProprietryValue);
		Log.info("Proprietery is displayed Successfully");
		Log.info("SR-CR-5 - The applicable properties have been copied as per the xmLabeling SCS.");
	}
	
	
}
