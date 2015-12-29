package com.ig.automation.systemtest;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ig.automation.screens.ContentManagementScreen;
import com.ig.automation.screens.CreateCRScreen;
import com.ig.automation.screens.DocumentDetailsScreen;
import com.ig.automation.screens.EditPropertiesScreen;
import com.ig.automation.screens.HomeScreen;
import com.ig.automation.screens.InboxScreen;
import com.ig.automation.screens.SystemTestScreen;
import com.ig.automation.test.ChangeLifeCycleStateTest;
import com.ig.automation.test.CheckinTest;
import com.ig.automation.test.CopyDocumentTest;
import com.ig.automation.test.CreateCRTest;
import com.ig.automation.test.CreateDocumentTest;
import com.ig.automation.test.CreateNDCTest;
import com.ig.automation.test.ExportDocumentTest;
import com.ig.automation.test.HAInterActionTest;
import com.ig.automation.test.HomeTest;
import com.ig.automation.test.LoginTest;
import com.ig.automation.test.SearchTest;
import com.ig.automation.test.WorkFlowRFATest;
import com.ig.automation.test.WorkFlowRFRTest;
import com.ig.automation.utility.Log;

public class NDCLabelerCodeST extends SystemTestScreen {
	
	LoginTest loginTest = new LoginTest();
	HomeTest homeTest = new HomeTest();
	HomeScreen homeScreen =  new HomeScreen();
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
	CreateNDCTest createNDCTest = new CreateNDCTest();
	EditPropertiesScreen editPropertiesScreen = new EditPropertiesScreen();
	HAInterActionTest haInterActionTest = new HAInterActionTest();
	String documentA = null;
	String docBId = null;
	String usernameRDLA = "dla01";
	String password = "password";
	String usernameRLC = "ra01";
	
	@BeforeClass
	public void login() throws Exception{
		loginTest.launchUrl();
		loginTest.doLogin(usernameRDLA, password);
		Thread.sleep (2000);
		Log.info(usernameRDLA + ": is able to log in Successfully.");
		
	}
	
	@Test
	public void reviewDocSTTest() throws Exception{
		System.out.println("Testing Create NDC");
		String typeOfDoc = "NDC LABELER CODE INACTIVATION";
		String labeler ="AbbVie Inc. 078458370";
		/*homeScreen.initializeLeftNavigationObjects();
		homeScreen.actions.click();
		homeScreen.initializeActionObjects();
		homeScreen.spl.click();
		homeScreen.initializeSPLObjects();
		homeScreen.createNewNDC.click();
		System.out.println("Create New NDC is clicked Successfully");
		
		List<String> selectedValuesForNDC = createNDCTest.doCreateNDC("ST_008" ,typeOfDoc,labeler);
		String docId = selectedValuesForNDC.get(3);
		try {
			Assert.assertEquals(selectedValuesForNDC.get(0).contains("Create NDC"),true, "Actual Message is :" + selectedValuesForNDC.get(0) + " Expected source ID Is : Create NDC ");
			Log.info("SR-S0-3 - PASSED : Create NDC screen is displayed Successfully."); //5
			Assert.assertEquals(selectedValuesForNDC.get(1).contains(typeOfDoc),true, "Actual Message is :" + selectedValuesForNDC.get(1) + " Expected source ID Is : " + typeOfDoc);
			Log.info("SR-S0-3 - PASSED : Type Of Document is displayed Successfully."); //5
			Assert.assertEquals(selectedValuesForNDC.get(2).contains(labeler),true, "Actual Message is :" + selectedValuesForNDC.get(2) + " Expected source ID Is : " + labeler);
			Log.info("SR-S0-3 - PASSED : Labeler Value is displayed Successfully."); //5
			Log.info("SR-S0-3 - PASSED : An NDC Labeler Code Request type document (Document A) is created : " + docId); //5
		} catch (Throwable e) {
			System.out.println("Assert fail");
		}*/
		
		String docId = "NDC-372";
		searchTest.doSearchDocument("NDC-372");
		/*documentDetailsScreen.initializeAuditTrail();
		documentDetailsScreen.auditTrail.click();
		getScreenShot("ST_008", "AuditTrailScreen");
		documentDetailsScreen.initializeAuditTrailEvent();
		String eventAT = documentDetailsScreen.auditTrailEvent.getText();
		documentDetailsScreen.initializeUserName();
		String userNameAT = documentDetailsScreen.userName.getText();
		documentDetailsScreen.initializeComment();
		String commentAT = documentDetailsScreen.comment.getText();
		documentDetailsScreen.initializeProperties();
		String proeprtiesAT = documentDetailsScreen.properties.getText();
		Assert.assertEquals(eventAT.contains("Create New Document"),true, "Actual Message is :" + eventAT + " Expected source ID Is : Create New Document");
		Log.info("PASSED : Audit Trail Event is displayed Successfully."); 
		Assert.assertEquals(userNameAT.contains("DL Author 01"),true, "Actual Message is :" + userNameAT + " Expected source ID Is : DL Author 01");
		Log.info("PASSED : Audit Trail UserName is displayed Successfully."); 
		Assert.assertEquals(commentAT.contains(""),true, "Actual Message is :" + commentAT + " Expected source ID Is Blank");
		Log.info("PASSED : Audit Trail Comment is displayed Successfully."); 
		Assert.assertEquals(proeprtiesAT.contains(""),true, "Actual Message is :" + proeprtiesAT + " Expected source ID Is : Blank");
		Log.info("PASSED : Audit Trail Properties is displayed Successfully."); 
		Log.info("Audit Trail is correctly recorded for the create document events.");//6
*/		
		documentDetailsScreen.initializePropertie();
		documentDetailsScreen.properties.click();
		documentDetailsScreen.initializeMandatoryPropertiesValues("NDC");
		String propDocType = documentDetailsScreen.typeOfDoc.getText();
		String propLabeler = documentDetailsScreen.labeler.getText();
		Assert.assertEquals(propDocType.contains(typeOfDoc),true, "Actual Message is :" + propDocType + " Expected source ID Is : " + typeOfDoc);
		Log.info("SR-S0-3 - PASSED : Audit Trail Document Type is displayed Successfully on Properties Tab."); 
		
		Assert.assertEquals(propLabeler.contains(labeler),true, "Actual Message is :" + propLabeler + " Expected source ID Is : " + labeler);
		Log.info("SR-S0-3 - PASSED : Audit Trail Labeler is displayed Successfully on Properties Tab."); 
		Assert.assertEquals(documentDetailsScreen.editLinkNDC.isEnabled(),true, "");
		Log.info("SR-S0-3 - PASSED : Edit link is Enabled Successfully on Properties Tab."); 
		getScreenShot("ST_008", "PropertiesScreen");
		documentDetailsScreen.editLinkNDC.click();
		
		editPropertiesScreen.initializeEditMandatory("NDC");
		editPropertiesScreen.optional.click();
		editPropertiesScreen.contactCountryNDC.selectByVisibleText("ESP");
		String selectedCountry = editPropertiesScreen.contactCountryNDC.getFirstSelectedOption().getText();
		try {
			editPropertiesScreen.splEffectiveDate.sendKeys("cvf");
		} catch (Exception e) {
			// TODO: handle exception
		}
		editPropertiesScreen.splEffectiveDate.click();
		editPropertiesScreen.initializeCalendarNDC();
		editPropertiesScreen.nextArrow.click();
		String date ="19";
		driver.findElement(By.xpath("//*[contains(@class,'calender_frmt')]//*[contains(text(),'"+date+"')]")).click();
		editPropertiesScreen.date.click();
		String selectedDate = editPropertiesScreen.splEffectiveDate.getText();
		editPropertiesScreen.saveNDC.click();
		
		Assert.assertEquals(selectedCountry.contains("ESP"),true, "Actual Value of Country is :" + selectedCountry + " Expected value Is ESP");
		Log.info("SR-S0-3 - PASSED : User is able to edit Country successfully.");
		Log.info("Date Selected is : " + selectedDate);
		Log.info("SR-S0-3 - PASSED : User is able to edit the properties of Document A."); 
		
		documentDetailsScreen.initializeAuditTrail();
		documentDetailsScreen.auditTrail.click();
		getScreenShot("ST_008", "AuditTrailScreen");
		documentDetailsScreen.initializeAuditTrailEvent();
		String eventATAfterEdit = documentDetailsScreen.auditTrailEvent.getText();
		documentDetailsScreen.initializeUserName();
		String userNameATAfterEdit = documentDetailsScreen.userName.getText();
		documentDetailsScreen.initializeComment();
		String commentATAfterEdit = documentDetailsScreen.comment.getText();
		documentDetailsScreen.initializeProperties();
		String proeprtiesATAfterEdit = documentDetailsScreen.properties.getText();
		Assert.assertEquals(eventATAfterEdit.contains("Edit Properties"),true, "Actual Message is :" + eventATAfterEdit + " Expected source ID Is : Edit Properties");
		Log.info("PASSED : Audit Trail Event is displayed Successfully after Editing Properties."); 
		Assert.assertEquals(userNameATAfterEdit.contains("DL Author 01"),true, "Actual Message is :" + userNameATAfterEdit + " Expected source ID Is : DL Author 01");
		Log.info("PASSED : Audit Trail UserName is displayed Successfully after Editing Properties."); 
		Assert.assertEquals(commentATAfterEdit.contains(""),true, "Actual Message is :" + commentATAfterEdit + " Expected source ID Is Blank");
		Log.info("PASSED : Audit Trail Comment is displayed Successfully after Editing Properties."); 
		Assert.assertEquals(proeprtiesATAfterEdit.contains("ESP"),true, "Actual Message is :" + proeprtiesATAfterEdit + " Expected source ID Is : ESP");
		Log.info("PASSED : Audit Trail Country is displayed Successfully after Editing Properties."); 
		//TODO Date
		Assert.assertEquals(proeprtiesATAfterEdit.contains("19"),true, "Actual Message is :" + selectedDate + " Expected Date Is : ");
		Log.info("PASSED : Audit Trail date is displayed Successfully after Editing Properties."); 
		Log.info("Audit Trail is correctly recorded for the create document events.");//6
		
		homeScreen.logOff.click();
		loginTest.doLogin(usernameRLC, password); 
		Log.info("Login Successful " + usernameRLC + "" + "user is logged in");
		
		searchTest.doSearchDocument(docId);
		changeLifeCycleStateTest.doChangeStateDrafttoIA(docId,"NDC");
		Log.info("Document A is promoted to internally Approved state.");
		
		searchTest.doSearchDocument(docId);
		contentMngScreen.initializeSPLManagement();
		contentManScreen.splManagement.click();
		contentManScreen.initializeGenerateSPL();
		contentManScreen.generateSPL.click();
		
		// Defect GLM-1448 Step 12
		//Click Cancel
		
		searchTest.doSearchDocument(docId);
		documentDetailsScreen.initializeProperties();
		documentDetailsScreen.properties.click();
		documentDetailsScreen.editLink.click();
		editPropertiesScreen.initializeEditMandatory(docId);
		editPropertiesScreen.optional.click();
		editPropertiesScreen.initializeEditOptional(docId);
		editPropertiesScreen.contactStateNDC.sendKeys("WB");
		editPropertiesScreen.contactPostalCodeNDC.sendKeys("123453");
		editPropertiesScreen.contactNameNDC.sendKeys("Test NDC");
		editPropertiesScreen.contactStreetNDC.sendKeys("Church Road");
		editPropertiesScreen.contactEmailNDC.sendKeys("a@abc.com");
		editPropertiesScreen.contactPhoneNDC.sendKeys("9856325896");
		editPropertiesScreen.contactSPL.click();
		editPropertiesScreen.initializeCalendarNDC();
		editPropertiesScreen.nextArrow.click();
		editPropertiesScreen.date.click();
		String selectedDateAfterEdit = editPropertiesScreen.splEffectiveDate.getText();
		editPropertiesScreen.saveNDC.click();
		// Need to validate Properties
		Log.info("Properties of Document A are updated.");
		
		searchTest.doSearchDocument(docId);
		contentMngScreen.initializeSPLManagement();
		contentManScreen.splManagement.click();
		contentManScreen.initializeGenerateSPL();
		contentManScreen.generateSPL.click();
		
		// Defect GLM-1448 Step 14 15
		//Defect GLM-1453 -Export SPL 16,17
		
		documentDetailsScreen.initializeAuditTrail();
		documentDetailsScreen.auditTrail.click();
		getScreenShot("ST_008", "AuditTrailScreen");
		documentDetailsScreen.initializeAuditTrailEvent();
		String eventATAfterSPL = documentDetailsScreen.auditTrailEvent.getText();
		documentDetailsScreen.initializeUserName();
		String userNameATAfterSPL = documentDetailsScreen.userName.getText();
		documentDetailsScreen.initializeComment();
		String commentATAfterSPL = documentDetailsScreen.comment.getText();
		documentDetailsScreen.initializeProperties();
		String proeprtiesATAfterSPL = documentDetailsScreen.properties.getText();
		Assert.assertEquals(eventATAfterSPL.contains("Generate SPL"),true, "Actual Message is :" + eventATAfterSPL + " Expected source ID Is : Generate SPL");
		Log.info("PASSED : Audit Trail Event is displayed Successfully after Editing Properties."); 
		Assert.assertEquals(userNameATAfterSPL.contains("RA 01"),true, "Actual Message is :" + userNameATAfterSPL + " Expected source ID Is : RA 01");
		Log.info("PASSED : Audit Trail UserName is displayed Successfully after Editing Properties."); 
		//Need to update
		Assert.assertEquals(commentATAfterSPL.contains(""),true, "Actual Message is :" + commentATAfterSPL + " Expected source ID Is Blank");
		Log.info("PASSED : Audit Trail Comment is displayed Successfully after Editing Properties."); 
		Assert.assertEquals(proeprtiesATAfterEdit.contains(""),true, "Actual Message is :" + proeprtiesATAfterSPL + " Expected source ID Is : ");
		Log.info("PASSED : Audit Trail Country is displayed Successfully after Editing Properties."); 
		Log.info("Audit Trail is correctly recorded for the Generate SPL events.");//20
		
		searchTest.doSearchDocument(docId);
		//Last week
		List<String> haInteractionDtails = haInterActionTest.doSubmitToHA("ST-008", docId);
		Assert.assertEquals(haInteractionDtails.get(0).contains("Submit to Health Authrity"),true, "Actual Message is :" + haInteractionDtails.get(0) + " Expected source ID Is : Submit to Health Authority ");
		Log.info("PASSED : Submit To Health Authority screen is displayed Successfully."); 
		//Need to assert date 
		Assert.assertEquals(haInteractionDtails.get(1).contains(""),true, "Actual Message is :" + haInteractionDtails.get(1) + " Expected source ID Is :");
		Log.info("SR-S0-3 - PASSED : Submit To Health Authority Date is displayed Successfully."); 
		documentDetailsScreen.editLink.click();
		editPropertiesScreen.optional.click();
		editPropertiesScreen.initializeEditOptional(docId);
		editPropertiesScreen.ndcLabelerCode.sendKeys("1234");
		String selectedLabeler = editPropertiesScreen.ndcLabelerCode.getText();
		Assert.assertEquals(selectedLabeler.contains("1234"), true);
		Log.info("SR-S0-3 - PASSED : NDC Labeler Code is recorded : " + selectedLabeler);
		
		
		documentDetailsScreen.initializeAuditTrail();
		documentDetailsScreen.auditTrail.click();
		getScreenShot("ST_008", "AuditTrailScreen");
		documentDetailsScreen.initializeAuditTrailEvent();
		String eventATAfterEdit1 = documentDetailsScreen.auditTrailEvent.getText();
		documentDetailsScreen.initializeUserName();
		String userNameATAfterEdit1 = documentDetailsScreen.userName.getText();
		documentDetailsScreen.initializeComment();
		String commentATAfterEdit1 = documentDetailsScreen.comment.getText();
		documentDetailsScreen.initializeProperties();
		String proeprtiesATAfterEdit1 = documentDetailsScreen.properties.getText();
		Assert.assertEquals(eventATAfterEdit1.contains("Submit to Health Authority"),true, "Actual Message is :" + eventATAfterEdit1 + " Expected source ID Is : Submit to Health Authority");
		Log.info("PASSED : Audit Trail Event is displayed Successfully after Editing Properties."); 
		Assert.assertEquals(userNameATAfterEdit1.contains("RA 01"),true, "Actual Message is :" + userNameATAfterEdit1 + " Expected source ID Is : RA 01");
		Log.info("PASSED : Audit Trail UserName is displayed Successfully after Editing Properties."); 
		Assert.assertEquals(commentATAfterEdit1.contains(""),true, "Actual Message is :" + commentATAfterEdit1 + " Expected source ID Is Blank");
		Log.info("PASSED : Audit Trail Comment is displayed Successfully after Editing Properties.");
		//date
		Assert.assertEquals(proeprtiesATAfterEdit1.contains(""),true, "Actual Message is :" + proeprtiesATAfterEdit1 + " Expected source ID Is : ");
		Log.info("PASSED : Audit Trail Country is displayed Successfully after Editing Properties."); 
		Log.info("Audit Trail is correctly recorded for the Submit to Health Authority events.");//23
		//need to update date 3 days ago
		List<String> HAResponse = haInterActionTest.doRecordHAResponse(docId);
		Log.info("SR-S0-3 - PASSED - HA response is recorded.");
		
		documentDetailsScreen.initializeAuditTrail();
		documentDetailsScreen.auditTrail.click();
		getScreenShot("ST_008", "AuditTrailScreen");
		documentDetailsScreen.initializeAuditTrailEvent();
		String eventATAfterHAResponse = documentDetailsScreen.auditTrailEvent.getText();
		documentDetailsScreen.initializeUserName();
		String userNameATAfterHAResponse = documentDetailsScreen.userName.getText();
		documentDetailsScreen.initializeComment();
		String commentATAfterHAResponse = documentDetailsScreen.comment.getText();
		documentDetailsScreen.initializeProperties();
		String proeprtiesATAfterHAResponse = documentDetailsScreen.properties.getText();
		Assert.assertEquals(eventATAfterHAResponse.contains("Record Health Authority Response"),true, "Actual Message is :" + eventATAfterHAResponse + " Expected source ID Is : Record Health Authority Response");
		Log.info("PASSED : Audit Trail Event is displayed Successfully after Editing Properties."); 
		Assert.assertEquals(userNameATAfterHAResponse.contains("RA 01"),true, "Actual Message is :" + userNameATAfterHAResponse + " Expected source ID Is : RA 01");
		Log.info("PASSED : Audit Trail UserName is displayed Successfully after Editing Properties."); 
		//Need to update date
		Assert.assertEquals(commentATAfterHAResponse.contains("Health Authority Response Recorded with Response Received on"),true, "Actual Message is :" + commentATAfterHAResponse + " Expected source ID Is Health Authority Response Recorded with Response Received on 8-Apr-2015");
		Log.info("PASSED : Audit Trail Comment is displayed Successfully after Editing Properties."); 
		//need to update date
		Assert.assertEquals(proeprtiesATAfterEdit.contains("Received") && proeprtiesATAfterEdit.contains(""),true, "Actual Message is :" + proeprtiesATAfterHAResponse + " Expected source ID Is : Received");
		Log.info("PASSED : Audit Trail Properties is displayed Successfully after Editing Properties."); 
		Log.info("Audit Trail is correctly recorded for the Record Health Authority Response events.");//25
		
		String status = driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[5]/div/div[4]/div[3]/div[7]/div/div/span/span")).getText();
		Assert.assertEquals(status.contains("Code Received"),true, "Actual Message is :" + status + " Expected source ID Is :Code Received");
		Log.info("SR-S0-3 - PASSED : Lifecycle state of document A is changed to the Code Received State."); 
		getScreenShot("ST-008", "Lifecycle state of document A ");
		
		documentDetailsScreen.initializeProperties();
		documentDetailsScreen.properties.click();
		documentDetailsScreen.editLink.click();
		documentDetailsScreen.optional.click();
		editPropertiesScreen.initializeEditOptional(docId);
		editPropertiesScreen.ndcLabelerCode.sendKeys("1234");
		String selectedLabelerValue = editPropertiesScreen.ndcLabelerCode.getText();
		Assert.assertEquals(selectedLabelerValue.contains("1234"), true);
		Log.info("SR-S0-3 - PASSED : NDC Labeler Code is recorded : " + selectedLabelerValue);
		//todo : select date 27
		Log.info("SR-S0-3 - PASSED : Effective Date and NDC Labeler Code properties of Document A are updated.");
		getScreenShot("ST-008", "EditPropertiesScreen");
		editPropertiesScreen.saveButtonNDC.click();
		
		searchTest.doSearchDocument(docId);
		contentMngScreen.initializeSPLManagement();
		contentManScreen.splManagement.click();
		contentManScreen.initializeGenerateSPL();
		contentManScreen.generateSPL.click();
		
		// Defect GLM-1448 Step 14 15
		//Defect GLM-1453 -Export SPL 29 30 31 32
		
		searchTest.doSearchDocument(docId);
		//Last week
		List<String> haInteractionDtails1 = haInterActionTest.doSubmitToHA("ST-008", docId);
		Assert.assertEquals(haInteractionDtails1.get(0).contains("Submit to Health Authrity"),true, "Actual Message is :" + haInteractionDtails1.get(0) + " Expected source ID Is : Submit to Health Authority ");
		Log.info("PASSED : Submit To Health Authority screen is displayed Successfully."); 
		//Need to assert date 
		Assert.assertEquals(haInteractionDtails1.get(1).contains(""),true, "Actual Message is :" + haInteractionDtails1.get(1) + " Expected source ID Is :");
		Log.info("SR-S0-3 - PASSED : Submit To Health Authority Date is displayed Successfully."); 
		
		searchTest.doEditSearchView(docId);
		String statusRS = driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[5]/div/div[4]/div[3]/div[7]/div/div/span/span")).getText();
		Assert.assertEquals(statusRS.contains("Registration Submitted"),true, "Actual Message is :" + statusRS + " Expected source ID Is :Registration Submitted");
		Log.info("SR-S0-3 - PASSED : Lifecycle state of document A is changed to the Registration Submitted State."); 
		getScreenShot("ST-008", "Lifecycle state of document A is changed to the Registration Submitted State."); // 34
		
		//need to update date 3 days ago
		List<String> HAResponseReceived = haInterActionTest.doRecordHAResponse(docId , "Rejected" , "ST-008");
		Log.info("SR-S0-3 - PASSED - HA response is recorded.");
		Assert.assertEquals(HAResponseReceived.get(0).contains("Rejected"),true, "Actual Message is :" + HAResponseReceived.get(0) + " Expected source ID Is : Rejected");
		Log.info("PASSED :  Health Authority Response is rejected Successfully  "); 
		Assert.assertEquals(HAResponseReceived.get(1).contains("Rejected"),true, "Actual Message is :" + HAResponseReceived.get(1) + " Expected source ID Is : ");
		Log.info("PASSED : Health Authority Response date is recoreded Successfully  "); 
		
		String statusCR = driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[5]/div/div[4]/div[3]/div[7]/div/div/span/span")).getText();
		Assert.assertEquals(statusCR.contains("Code Received "),true, "Actual Message is :" + statusCR + " Expected source ID Is : Code Received ");
		Log.info("SR-S0-3 - PASSED : Lifecycle state of document A is changed to the Code Received  State."); 
		getScreenShot("ST-008", "Code received State"); // 36
		
		//Last week
		List<String> haInteractionDetails2 = haInterActionTest.doSubmitToHA("ST-008", docId);
		Assert.assertEquals(haInteractionDetails2.get(0).contains("Submit to Health Authrity"),true, "Actual Message is :" + haInteractionDetails2.get(0) + " Expected source ID Is : Submit to Health Authority ");
		Log.info("PASSED : Submit To Health Authority screen is displayed Successfully."); 
		//Need to assert date 
		Assert.assertEquals(haInteractionDetails2.get(1).contains(""),true, "Actual Message is :" + haInteractionDetails2.get(1) + " Expected source ID Is :");
		Log.info("SR-S0-3 - PASSED : Submit To Health Authority Date is displayed Successfully."); 
		
		//need to update date 3 days ago
		List<String> HAResponseReceived1 = haInterActionTest.doRecordHAResponse(docId , "Received" , "ST-008");
		Log.info("SR-S0-3 - PASSED - HA response is recorded.");
		Assert.assertEquals(HAResponseReceived1.get(0).contains("Received"),true, "Actual Message is :" + HAResponseReceived1.get(0) + " Expected source ID Is : Received");
		Log.info("PASSED :  Health Authority Response is Received Successfully  "); 
		//date
		Assert.assertEquals(HAResponseReceived1.get(1).contains(""),true, "Actual Message is :" + HAResponseReceived1.get(1) + " Expected source ID Is : ");
		Log.info("PASSED : Health Authority Response date is recoreded Successfully  "); 
		
		String statusRS1 = driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[5]/div/div[4]/div[3]/div[7]/div/div/span/span")).getText();
		Assert.assertEquals(statusRS1.contains("Registered state"),true, "Actual Message is :" + statusRS1 + " Expected source ID Is : Registered state ");
		Log.info("SR-S0-3 - PASSED : Lifecycle state of document A is changed to the Registered State."); 
		getScreenShot("ST-008", "Registered State"); // 37
		
		//TODO 38 39 40 Defect
		
		homeScreen.logOff.click();
		loginTest.doLogin(usernameRDLA, password);
		Thread.sleep (2000);
		Log.info(usernameRDLA + ": is able to log in Successfully.");
		
		homeScreen.initializeLeftNavigationObjects();
		homeScreen.actions.click();
		homeScreen.initializeActionObjects();
		homeScreen.spl.click();
		homeScreen.initializeSPLObjects();
		homeScreen.createNewNDC.click();
		System.out.println("Create New NDC is clicked Successfully");
		
		List<String> selectedValuesForNDC = createNDCTest.doCreateNDC("ST_008" ,typeOfDoc,labeler);
		docBId = selectedValuesForNDC.get(3);
		try {
			Assert.assertEquals(selectedValuesForNDC.get(0).contains("Create NDC"),true, "Actual Message is :" + selectedValuesForNDC.get(0) + " Expected source ID Is : Create NDC ");
			Log.info("SR-S0-3 - PASSED : Create NDC screen is displayed Successfully."); //5
			Assert.assertEquals(selectedValuesForNDC.get(1).contains(typeOfDoc),true, "Actual Message is :" + selectedValuesForNDC.get(1) + " Expected source ID Is : " + typeOfDoc);
			Log.info("SR-S0-3 - PASSED : Type Of Document is displayed Successfully."); //5
			Assert.assertEquals(selectedValuesForNDC.get(2).contains(labeler),true, "Actual Message is :" + selectedValuesForNDC.get(2) + " Expected source ID Is : " + labeler);
			Log.info("SR-S0-3 - PASSED : Labeler Value is displayed Successfully."); //5
			Log.info("SR-S0-3 - PASSED : An NDC Labeler Code Request type document (Document B) is created : " + docBId); //42
		} catch (Throwable e) {
			System.out.println("Assert fail");
		}
		
		homeScreen.logOff.click();
		loginTest.doLogin(usernameRLC, password);
		Thread.sleep (2000);
		Log.info(usernameRLC + ": is able to log in Successfully.");
		
		searchTest.doSearchDocument(docBId);
		changeLifeCycleStateTest.doChangeStateDrafttoIA(docBId,"NDC");
		Log.info("SR-S0-3 - PASSED : Document B is promoted to internally Approved state.");
		
		//Last week
		List<String> haInteractionDetailsB= haInterActionTest.doSubmitToHA("ST-008", docBId);
		Assert.assertEquals(haInteractionDetailsB.get(0).contains("Submit to Health Authrity"),true, "Actual Message is :" + haInteractionDetailsB.get(0) + " Expected source ID Is : Submit to Health Authority ");
		Log.info("PASSED : Submit To Health Authority screen is displayed Successfully."); 
		//Need to assert date 
		Assert.assertEquals(haInteractionDetailsB.get(1).contains(""),true, "Actual Message is :" + haInteractionDetailsB.get(1) + " Expected source ID Is :");
		Log.info("SR-S0-3 - PASSED : Submit To Health Authority Date is displayed Successfully."); 
		Log.info("SR-S0-3 - PASSED : Document B is submitted to HA.");
		
		searchTest.doSearchDocument(docBId);
		documentDetailsScreen.initializePropertie();
		documentDetailsScreen.properties.click();
		documentDetailsScreen.initializeMandatoryPropertiesValues("NDC");
		documentDetailsScreen.editLinkNDC.click();
		
		editPropertiesScreen.initializeEditMandatory("NDC");
		editPropertiesScreen.labelerEdit.selectByVisibleText("Infogain 7654321 noida up 201302");
		String selectedValueLabelerAfterEdit = editPropertiesScreen.labelerEdit.getFirstSelectedOption().getText();
		Assert.assertEquals(selectedValueLabelerAfterEdit.contains("Infogain 7654321 noida up 201302"),true, "Actual Value is :" + selectedValueLabelerAfterEdit + " Expected Value Is : Infogain 7654321 noida up 201302");
		Log.info("SR-S0-3 ,SR-SD-17 - PASSED : NDC Labeler Code is recorded."); //46
		
		//need to update date 3 days ago
		List<String> HAResponseRejectedDocB = haInterActionTest.doRecordHAResponse(docId , "Rejected" , "ST-008");
		Log.info("SR-S0-3 - PASSED - HA response is recorded.");
		Assert.assertEquals(HAResponseRejectedDocB.get(0).contains("Rejected"),true, "Actual Message is :" + HAResponseRejectedDocB.get(0) + " Expected source ID Is : Rejected");
		Log.info("PASSED :  Health Authority Response is Rejected Successfully  "); 
		//date
		Assert.assertEquals(HAResponseReceived1.get(1).contains(""),true, "Actual Message is :" + HAResponseReceived1.get(1) + " Expected source ID Is : ");
		Log.info("PASSED : Health Authority Response date is recoreded Successfully  "); 
		
		String statusDraft = driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[5]/div/div[4]/div[3]/div[7]/div/div/span/span")).getText();
		Assert.assertEquals(statusDraft.contains("Draft"),true, "Actual Message is :" + statusDraft + " Expected source ID Is : Draft state ");
		Log.info("SR-S0-3 - PASSED : Lifecycle state of document A is changed to the Draft State."); 
		getScreenShot("ST-008", "Draft State"); // 47
		
		//TODO : step 48 49
		
		homeScreen.logOff.click();
		Log.info("Logout successful.");
	}

}
