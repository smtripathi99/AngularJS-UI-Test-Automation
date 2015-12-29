package com.ig.automation.test;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.Reporter;

import com.ig.automation.screens.EstablishmentsByProductScreen;
import com.ig.automation.utility.Log;


public class EstablishmentsByProductTest extends EstablishmentsByProductScreen {

	HomeTest homeTest = new HomeTest();
    LoginTest loginTest =new LoginTest();
	

	/**
	 * Test the Create Document feature of UI 7.0 against the Requirement ID R-CN-1
	 * 
	 * @throws Exception If an error occurs.
	 */
	public String doEstablishmentsByProduct(String docID) throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Product Test");
		try {
			
			initializeReports();
			reports.click();
			initializeEstablishmentsByProduct();
			establishmentsByproduct.click();
			initializeUSPIicon();
			uspiIcon.click();
			initializeInputText();
			inputText.clear();
		    inputText.sendKeys(docID);
		    initializeDocIDverification();
		    //String doc= docIDverification.getText();
		    return docIDverification.getText();
		   
		    			
		
		} catch (Throwable t) {

			Log.info(t.getMessage());
			Reporter.log("xmL-UI-ADS-007.doc Select Product has been tested Failed");
			Log.endTestCase("Product Test");
			Assert.fail(t.getMessage());
		}
		Log.endTestCase("Product Test");
		return docID;
	}

	/*
	 * @AfterClass public void tearDown() throws Exception { driver.close(); driver.quit();
	 * 
	 * }
	 */
}
