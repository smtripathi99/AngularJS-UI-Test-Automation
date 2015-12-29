package com.ig.automation.systemtest;

import java.util.List;
import java.util.Properties;

import org.apache.http.util.Asserts;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//import com.opera.core.systems.scope.protos.EcmascriptProtos.EvalResult.Status;
import com.ig.automation.coreactions.DataActions;
import com.ig.automation.screens.CheckinScreen;
import com.ig.automation.screens.CreateCRScreen;
import com.ig.automation.screens.CreateEstablishmentScreen;
import com.ig.automation.screens.CreateNDCScreen;
import com.ig.automation.screens.CreateRegistrationScreen;
import com.ig.automation.screens.CreateSelfIDScreen;
import com.ig.automation.screens.EditPropertiesScreen;
import com.ig.automation.screens.SystemTestScreen;
import com.ig.automation.test.ChangeLifeCycleStateTest;
import com.ig.automation.test.CreateDocumentTest;
import com.ig.automation.test.CreateEstablishmentTest;
import com.ig.automation.test.CreateFromSPLTest;
import com.ig.automation.test.CreateRegistrationTest;
import com.ig.automation.test.DocumentDetailsTest;
import com.ig.automation.test.EstablishmentsByProductTest;
import com.ig.automation.test.HAInterActionTest;
import com.ig.automation.test.HomeTest;
import com.ig.automation.test.LoginTest;
import com.ig.automation.test.SearchTest;
import com.ig.automation.utility.Log;


public class EstablishmentandRegistrationSystemTest extends SystemTestScreen{
	

	HomeTest homeTest = new HomeTest();
    
	LoginTest loginTest = new LoginTest();
	CreateEstablishmentTest estbTest = new CreateEstablishmentTest();
	CreateDocumentTest uspiTest = new CreateDocumentTest();
	CreateRegistrationTest regTest = new CreateRegistrationTest();
	DocumentDetailsTest ddtest = new DocumentDetailsTest();
	SearchTest searchtest = new SearchTest();
    ChangeLifeCycleStateTest clcs = new ChangeLifeCycleStateTest();
    CreateFromSPLTest cfspltest = new CreateFromSPLTest();
    HAInterActionTest ha = new HAInterActionTest();
    EstablishmentsByProductTest estBybprodTest = new EstablishmentsByProductTest();
    
	private String docID;
	
	/**
	 * Test the Create Establishment Page of UI 7.0 against the xmL-UI-ADS-025 	  
	 * @throws Exception If an error occurs.
	 * 
	 */
	@Test
	public void testCreateEstablishment() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Create Establishment Test Started");
		try{
		
		loginTest.launchUrl();
		String username = DataActions.getUserID("role_drug_listing_author");
		String password = DataActions.getUserPassword("role_drug_listing_author");
		loginTest.doLogin(username, password);
		Log.info("Login Successful. " + username + " " + "user is logged in.");
		initializeAction();
		actions.click();
		Thread.sleep(1000);
		initializeCreate();
		createDoc.click(); // 05
		Thread.sleep(1000);
		regTest.doCreateRegistration();
		
		//TODO- GLM-1356
		//TODO- GLM-1357
		String documentB = estbTest.doCreateEstablishment(docID);
		String documentC = estbTest.doCreateEstablishment(docID);
		String regResult =  regTest.doCreateRegistration();
		ddtest.doDocumentDetails();
		homeTest.initializeLeftNavigationObjects();
		homeTest.logOff.click();
		String username1 = DataActions.getUserID("role_label_coordinator");
		String password1 = DataActions.getUserPassword("role_label_coordinator");
		loginTest.doLogin(username, password);
		Log.info("Login Successful. " + username + " " + "user is logged in.");
		//TODO GLM-1362
		searchtest.doSearchDocument(docID);
		clcs.doChangeStateDrafttoIAForNonContentDoc();
		homeTest.initializeCreateSPL();
		homeTest.createSPL.click();
		Thread.sleep(5000);
		searchtest.doSearchDocument(docID); //Step 23
		cfspltest.doGenerateSPLTest();
		//TODO GLM-1384
		ha.doSubmitToHA(docID);
		//searchtest.doSearchIcon("Submit to Health Authority");
		List<String> auditTrailDetails = ddtest.doDocumentDetailsAuditTrail();
		Assert.assertEquals("Submit to Health Authority", auditTrailDetails.get(0));
		Assert.assertEquals("Application Managager 01", auditTrailDetails.get(1));
		Assert.assertEquals("", auditTrailDetails.get(4));
		Assert.assertTrue(auditTrailDetails.get(5).contains("ha_submission_date"));
		ha.doRecordHAResponse(docID);
		getScreenShot("ST-009", "SR-SO-4");
		initializeDocVersion();
		Assert.assertTrue(docVersion.getText().contains("1.0, CURRENT"), "Document A now becomes major version");
		Log.info("SR-SO-4 is Passed Successfully");
		ha.doHARecord(docID);
		//TODO GLM-1414
		List<String> registered = ha.doHARecord(docID);
		Assert.assertEquals("Registered", registered.get(0));
		Assert.assertEquals("1.0, CURRENT", registered.get(1));
		getScreenShot("ST-009", "SR-SO-4a");
		List<String> auditTrailDetails1 = ddtest.doDocumentDetailsAuditTrail(); //Step 34
		Assert.assertEquals("Record Health Authority Response", auditTrailDetails1.get(0));
		Assert.assertEquals("Application Managager 01", auditTrailDetails1.get(1));
		Assert.assertTrue(auditTrailDetails1.get(6).contains("Received"));
		Assert.assertEquals(auditTrailDetails1.get(6), getFutureDate(1)); 
		//TODO- GLM-1357 step 35 to 41
		//TODO - GLM-1422  Version Registration is not implemented yet //Step 42 to 46
		cfspltest.doGenerateSPLTest(); //step 47
		//TODO GLM-1384  //step 48-52
		ha.doSubmitToHA(docID);
		getScreenShot("ST-009", "SR-SO-4c");
		Log.info("SR-SO-4, Document A version 2.1 is submitted to HA");
		List<String> haSubmitted = ha.doHARecord(docID);  //step 68
		Assert.assertEquals("HA Submitted", haSubmitted.get(0));
		Assert.assertEquals("2.1, CURRENT", haSubmitted.get(1));
		getScreenShot("ST-009", "SR-SO-4d");  //step 69
		Log.info("SR-SO-4, Document A version 2.1 is set to HA Submitted state");
		ha.doRecordHAResponse(docID);  //Step 70
		getScreenShot("ST-009", "SR-SO-4e");  
		Log.info("SR-SO-4, HA response is recorded");
		List<String> registered1 = ha.doHARecord(docID);
		Assert.assertEquals("Registered", registered1.get(0));
		Assert.assertEquals("3.0, CURRENT", registered1.get(1));  //step 71
		getScreenShot("ST-009", "SR-SO-4f");    
		Log.info("SR-SO-4, Lifecycle state of Document A version 3.0 is changed to Registered"); 
		homeTest.initializeLeftNavigationObjects();
		homeTest.logOff.click();
		String username2 = DataActions.getUserID("role_us_labeling_author");
		String password2 = DataActions.getUserPassword("role_us_labeling_author");
		loginTest.doLogin(username, password);
		Log.info("Login Successful. " + username + " " + "user is logged in.");
		inilializeObjectsDocType();
		uSPI.click();
		String uspiID = uspiTest.doCreateDocument("US Package Insert", "Document D", "United States", "English", "", "ALLERSOLV", "COSMETIC", "Alkaline Aqua");
		//TODO - GLM-1425 Not able to search any document from search tab from Search for Establishments
		String resultDocB = estBybprodTest.doEstablishmentsByProduct(documentB);
		Assert.assertEquals(resultDocB.equals(documentB), true, "" );
		String resultDocC = estBybprodTest.doEstablishmentsByProduct(documentC);
		Assert.assertEquals(resultDocC.equals(documentC), true, "" );
		
	}
		catch(Throwable e){
			Log.info(e.getMessage());
			Reporter.log("xmL-UI-ADS-025.doc Create Establishment tested unsuccessfully");	
			Assert.fail();
		}
	
			Log.endTestCase("Create Establishment Test Ended");
	
	

	}
	
	
public String getDocID(String doctype) throws Exception {
		
		List<String[]> list=readCSV();
		for(String[] str: list) {
		    for(String doc: str){
		    	if(doc.contains(doctype))
		    		return doc.toString();
		    } 
		}
	    return null;
	}
	
	/*@AfterClass
	public void tearDown() throws Exception{
		driver.close();
		driver.quit();
		System.out.println("Passed:Login screen is tested successfully.");	
	}*/
}
