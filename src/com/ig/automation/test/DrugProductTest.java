package com.ig.automation.test;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ig.automation.coreactions.DataActions;
import com.ig.automation.screens.BasicNavigationScreen;
import com.ig.automation.utility.Log;


//	xmL-UI-ADS-028.doc
public class DrugProductTest extends BasicNavigationScreen {

	HomeTest homeTest = new HomeTest();
	LoginTest loginTest = new LoginTest();
	CreateDocumentTest cdTest=new CreateDocumentTest();
	String uspiDocID=null;

	
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
	 * Test the 2.1 Drug Listing feature of UI 7.0 against the UI-ADS-028 
	 * @throws Exception If an error occurs.
	 */
	@Test
	public void testDrugListing() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Drug Listing Test");
		try {
			homeTest.initializeLeftNavigationObjects();
			homeTest.actions.click();
			homeTest.initializeActionObjects();
			homeTest.createDoc.click();
			cdTest.inilializeObjectsDocType("role_author");
			cdTest.uspi.click();			
			Thread.sleep(2000);
			uspiDocID=cdTest.doCreateDocument("US Package Insert", "USPI for MCP", "United States", "English", "", "ALLERSOLV", "COSMETIC", "Alkaline Aqua");	
			Thread.sleep(2000);
			initializeDrugListing();
			drugListingTab.click();
			initializeDrugListingLinks();
			Assert.assertEquals(addMCPLink.isDisplayed() & addMCPLink.isEnabled(), true); 
			Log.info("UI-DL-01 is Passed Successfully");
			Assert.assertEquals(addDrugPLink.isDisplayed() & addDrugPLink.isEnabled(), true); 
			Log.info("UI-DL-02 is Passed Successfully");
			Assert.assertEquals(addDevicePLink.isDisplayed() & addDevicePLink.isEnabled(), true); 
			Log.info("UI-DL-03 is Passed Successfully");
			addMCPLink.click();
			Thread.sleep(2000);
			initializeMCPSidePanel();
			Assert.assertEquals(titleMCPSidePanel.isDisplayed(), true); 
			Log.info("UI-DL-04 is Passed Successfully");
			cancelBtn.click();
			addDrugPLink.click();
			initializeDrugPSidePanel();
			Assert.assertEquals(titleDrugPSidePanel.isDisplayed(), true); 
			Log.info("UI-DL-05 is Passed Successfully");
			cancelBtn.click();
			addDevicePLink.click();
			initializeDevicePSidePanel();
			Assert.assertEquals(titleDevicePSidePanel.isDisplayed(), true); 
			Log.info("UI-DL-06 is Passed Successfully");
			cancelBtn.click();
			
		} catch (Throwable t) {
			Log.info(t.getMessage());
			Reporter.log("xmL-UI-ADS-028.doc Drug Listing test failed");
			Log.endTestCase("Drug Listing Test Ended");
		}
	}
	
	/**
	 * Test the 2.2 Multi Component Panel feature of UI 7.0 against the UI-ADS-028 
	 * @throws Exception If an error occurs.
	 */
	@Test
	public void testMCPPanel() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Multi Component Panel");
		try {
			addMCPLink.click();
			initializeMCPSidePanel();
			Assert.assertTrue(properietaryName.getAllSelectedOptions().size()> 0); 
			Log.info("UI-MCPP-01 is Passed Successfully");
			Assert.assertEquals(properietaryNameSuffix.isDisplayed(), true); 
			Log.info("UI-MCPP-02 is Passed Successfully");
			Assert.assertTrue(overallNonProprietaryName.getAllSelectedOptions().size()> 0); 
			Log.info("UI-MCPP-03 is Passed Successfully");
			Assert.assertEquals(manufacturedProductCode.isDisplayed(), true); 
			Log.info("UI-MCPP-04 is Passed Successfully");
			Assert.assertEquals(dosageForm.isMultiple(), true); 
			Log.info("UI-MCPP-05 is Passed Successfully");
			Assert.assertEquals(doneBtnMCP.isDisplayed(), false); 
			Log.info("UI-MCPP-06 is Passed Successfully");
			Assert.assertEquals(cancelBtn.isDisplayed() & cancelBtn.isEnabled(), true); 
			Log.info("UI-MCPP-07 is Passed Successfully");
			properietaryName.selectByIndex(0);
			Assert.assertEquals(properietaryName.getFirstSelectedOption().isSelected(), true); 
			Log.info("UI-MCPP-08 is Passed Successfully");
			overallNonProprietaryName.selectByIndex(0);
			Assert.assertEquals(overallNonProprietaryName.getFirstSelectedOption().isSelected(), true); 
			Log.info("UI-MCPP-09 is Passed Successfully");
			dosageForm.selectByIndex(0);
			Assert.assertEquals(dosageForm.getFirstSelectedOption().isSelected(), true); 
			Log.info("UI-MCPP-10 is Passed Successfully");
			Assert.assertEquals(doneBtnMCP.isDisplayed() & cancelBtn.isEnabled(), true); 
			Log.info("UI-MCPP-11 is Passed Successfully");
			doneBtnMCP.click();
			initializeMessages();
			Assert.assertEquals(message.getText().contains("success"), true); 
			Log.info("UI-MCPP-12 is Passed Successfully");
			initializeDrugListingDetails();
			
			
			
		} catch (Throwable t) {
			Log.info(t.getMessage());
			Reporter.log("xmL-UI-ADS-028.doc Drug Listing test failed");
			Log.endTestCase("Drug Listing Test Ended");
		}
	}

	/*
	 * @AfterClass public void tearDown() throws Exception { driver.close(); driver.quit();
	 * 
	 * }
	 */
}
