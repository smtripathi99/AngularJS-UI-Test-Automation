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
import com.ig.automation.screens.GenerateProfileViewScreen;
import com.ig.automation.screens.VersionCMSScreen;
import com.ig.automation.screens.VersionRMSScreen;
import com.ig.automation.utility.Log;


public class GenerateProfileViewTest extends GenerateProfileViewScreen{

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
	 * Test the Generate Profile View Page of UI 7.0 against the xmL-UI-ADS-022   
	 * @throws Exception If an error occurs.
	 * 
	 */
	@Test
	public void testGenerateProfileView() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Generate Profile View Test Started");
		try{
			String docID=getDocID("AN");
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
			relationsMenu.click();
			initializeGenerateProfile();
			generateProfile.click();
			initializeGenerateProfileViewPanel();
			Assert.assertEquals(generateProfileTitle.getText(),"Generate Profiled View");
			Log.info("UI-PVD-1 Passed");
			Assert.assertTrue(docHeader.getText().contains("AN-"));
			Assert.assertTrue(docHeader.getText().contains("Status"));
			Log.info("UI-PVD-2 Passed");
			Assert.assertTrue(docHeader.getText().contains("Version"));
			Log.info("UI-PVD-3 Passed");
			Assert.assertTrue(docHeader.getText().contains("Language"));
			Log.info("UI-PVD-4 Passed");
			Assert.assertTrue(docHeader.getText().contains("Country"));
			Log.info("UI-PVD-5 Passed");
			Assert.assertTrue(docHeader.getText().contains("Title"));
			Log.info("UI-PVD-6 Passed");
			Assert.assertTrue(productCheckbox.isDisplayed());
			Log.info("UI-PVD-7 Passed");
			productCheckbox.click();
			formCheckbox.click();
			strengthCheckbox.click();
			presentationCheckbox.click();
			Assert.assertTrue(generateProfileBtn.isEnabled());
			generateProfileBtn.click();
			Log.info("UI-PVD-11 Passed");
			//TODO profile tab on grid is not yet implemented
			Reporter.log("xmL-UI-ADS-022.doc Generate Profile View tested successfully");
		}
		catch(Throwable e){
			Log.info(e.getMessage());
			Reporter.log("xmL-UI-ADS-022.doc Generate Profile View tested unsuccessfully");	
			Assert.fail();
		}
			Log.endTestCase("Generate Profile View Test Ended");
	}

	/**
	 * Test the Generate Profile View Page of UI 7.0 against the xmL-UI-ADS-022 Cancel  
	 * @throws Exception If an error occurs.
	 * 
	 */
	@Test
	public void testCancelGenerateProfileView() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Cancel Generate Profile View Test Started");
		try{
			relationsMenu.click();
			initializeGenerateProfile();
			generateProfile.click();
			initializeGenerateProfileViewPanel();
			Assert.assertFalse(generateProfileBtn.isDisplayed());
			Log.info("UI-PVD-8 Passed");
			Assert.assertTrue(generateProfileCancelBtn.isDisplayed());
			Log.info("UI-PVD-9 Passed");
			generateProfileCancelBtn.click();
			Assert.assertTrue(filterDocID.isDisplayed());
			Log.info("UI-PVD-13 Passed");
			Reporter.log("xmL-UI-ADS-022.doc Cancel Generate Profile View tested successfully");
		}
		catch(Throwable e){
			Log.info(e.getMessage());
			Log.info("UI-PVD-13 Failed");
			Reporter.log("xmL-UI-ADS-022.doc Cancel Generate Profile View tested unsuccessfully");	
			Assert.fail();
		}
			Log.endTestCase("Cancel Generate Profile View Test Ended");
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
