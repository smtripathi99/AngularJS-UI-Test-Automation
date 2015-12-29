package com.ig.automation.test;

import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ig.automation.screens.CheckinScreen;
import com.ig.automation.screens.CreateCRScreen;
import com.ig.automation.screens.EditPropertiesScreen;
import com.ig.automation.screens.GeneratePubOutputScreen;
import com.ig.automation.screens.VersionCMSScreen;
import com.ig.automation.utility.Log;


public class GeneratePubOutputTest extends GeneratePubOutputScreen{

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
	 * Test the Generate Published Output for CP of UI 7.0 against the xmL-UI-ADS-023   
	 * @throws Exception If an error occurs.
	 * 
	 */
	@Test
	public void testGeneratePubOutputCP() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Generate Published Output CP Test Started");
		try{
			String docID=getDocID("CP");
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
			Thread.sleep(3000);
			initializeDocument();
			filterDocID.click();
			initializeActionMenu();
			eusubmissionMenu.click();
			initializeGeneratePubOutput();
			generatePubOutput.click();
			initializeGeneratePubOutputPanel();
			Assert.assertEquals(generatePubOutputLabel.getText(),"Generate Published Output");
			Log.info("UI-POUT-1 Passed");
			Assert.assertTrue(generatePubOutputHeader.getText().contains("Status"));
			Log.info("UI-POUT-2 Passed");
			Assert.assertTrue(generatePubOutputHeader.getText().contains("Version"));
			Log.info("UI-POUT-3 Passed");
			Assert.assertTrue(generatePubOutputHeader.getText().contains("Language"));
			Log.info("UI-POUT-4 Passed");
			Assert.assertTrue(generatePubOutputHeader.getText().contains("Country"));
			Log.info("UI-POUT-5 Passed");
			Assert.assertTrue(generatePubOutputHeader.getText().contains("Title"));
			Log.info("UI-POUT-6 Passed");
			Assert.assertTrue(selectLanguage.isEnabled());
			Log.info("UI-POUT-7 Passed");
			Assert.assertTrue(generatePubOutputButton.isEnabled());
			Log.info("UI-POUT-8 Passed");
			generatePubOutputButton.click();
			//TODO Generate Published Output grid is not available for CP
			
			/*versionCP.click();
			filterDocID.click();
			initializeVersionsTab();
			versionTab.click();
			initializeVersionsGrid();
			versionColumn.click();
			initializeVersionsDetails();
			Assert.assertEquals(versionDetail.getText(),"0.2,CURRENT");
			*/
			Reporter.log("xmL-UI-ADS-023.doc Generate Published Output CP tested successfully");
		}
		catch(Throwable e){
			Log.info(e.getMessage());
			Reporter.log("xmL-UI-ADS-023.doc Generate Published Output CP tested unsuccessfully");	
			Assert.fail();
		}
			Log.endTestCase("Generate Published Output CP Test Ended");
	}

		
	/**
	 * Test the Generate Published Output for RMS of UI 7.0 against the xmL-UI-ADS-023   
	 * @throws Exception If an error occurs.
	 * 
	 */
	@Test
	public void testGeneratePubOutputRMS() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Generate Published Output RMS Test Started");
		try{
			String docID=getDocID("RMS");
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
			Thread.sleep(3000);
			initializeDocument();
			filterDocID.click();
			initializeActionMenu();
			eusubmissionMenu.click();
			initializeGeneratePubOutput();
			generatePubOutput.click();
			initializeGeneratePubOutputPanel();
			Assert.assertEquals(generatePubOutputLabel.getText(),"Generate Published Output");
			Log.info("UI-POUT-1 Passed");
			Assert.assertTrue(generatePubOutputHeader.getText().contains("Status"));
			Log.info("UI-POUT-2 Passed");
			Assert.assertTrue(generatePubOutputHeader.getText().contains("Version"));
			Log.info("UI-POUT-3 Passed");
			Assert.assertTrue(generatePubOutputHeader.getText().contains("Language"));
			Log.info("UI-POUT-4 Passed");
			Assert.assertTrue(generatePubOutputHeader.getText().contains("Country"));
			Log.info("UI-POUT-5 Passed");
			Assert.assertTrue(generatePubOutputHeader.getText().contains("Title"));
			Log.info("UI-POUT-6 Passed");
			Assert.assertTrue(selectLanguage.isEnabled());
			Log.info("UI-POUT-7 Passed");
			Assert.assertTrue(generatePubOutputButton.isEnabled());
			Log.info("UI-POUT-8 Passed");
			generatePubOutputButton.click();
			//TODO Generate Published Output grid is not available for RMS
			
			/*versionCP.click();
			filterDocID.click();
			initializeVersionsTab();
			versionTab.click();
			initializeVersionsGrid();
			versionColumn.click();
			initializeVersionsDetails();
			Assert.assertEquals(versionDetail.getText(),"0.2,CURRENT");
			*/
			Reporter.log("xmL-UI-ADS-023.doc Generate Published Output RMS tested successfully");
		}
		catch(Throwable e){
			Log.info(e.getMessage());
			Reporter.log("xmL-UI-ADS-023.doc Generate Published Output RMS tested unsuccessfully");	
			Assert.fail();
		}
			Log.endTestCase("Generate Published Output RMS Test Ended");
	}

	/**
	 * Test the Generate Published Output for CMS of UI 7.0 against the xmL-UI-ADS-023   
	 * @throws Exception If an error occurs.
	 * 
	 */
	@Test
	public void testGeneratePubOutputCMS() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Generate Published Output CMS Test Started");
		try{
			String docID=getDocID("CMS");
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
			Thread.sleep(3000);
			initializeDocument();
			filterDocID.click();
			initializeActionMenu();
			eusubmissionMenu.click();
			initializeGeneratePubOutput();
			generatePubOutput.click();
			initializeGeneratePubOutputPanel();
			Assert.assertEquals(generatePubOutputLabel.getText(),"Generate Published Output");
			Log.info("UI-POUT-1 Passed");
			Assert.assertTrue(generatePubOutputHeader.getText().contains("Status"));
			Log.info("UI-POUT-2 Passed");
			Assert.assertTrue(generatePubOutputHeader.getText().contains("Version"));
			Log.info("UI-POUT-3 Passed");
			Assert.assertTrue(generatePubOutputHeader.getText().contains("Language"));
			Log.info("UI-POUT-4 Passed");
			Assert.assertTrue(generatePubOutputHeader.getText().contains("Country"));
			Log.info("UI-POUT-5 Passed");
			Assert.assertTrue(generatePubOutputHeader.getText().contains("Title"));
			Log.info("UI-POUT-6 Passed");
			Assert.assertTrue(selectLanguage.isEnabled());
			Log.info("UI-POUT-7 Passed");
			Assert.assertTrue(generatePubOutputButton.isEnabled());
			Log.info("UI-POUT-8 Passed");
			generatePubOutputButton.click();
			//TODO Generate Published Output grid is not available for CMS
			
			/*versionCP.click();
			filterDocID.click();
			initializeVersionsTab();
			versionTab.click();
			initializeVersionsGrid();
			versionColumn.click();
			initializeVersionsDetails();
			Assert.assertEquals(versionDetail.getText(),"0.2,CURRENT");
			*/
			Reporter.log("xmL-UI-ADS-023.doc Generate Published Output CMS tested successfully");
		}
		catch(Throwable e){
			Log.info(e.getMessage());
			Reporter.log("xmL-UI-ADS-023.doc Generate Published Output CMS tested unsuccessfully");	
			Assert.fail();
		}
			Log.endTestCase("Generate Published Output CMS Test Ended");
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
