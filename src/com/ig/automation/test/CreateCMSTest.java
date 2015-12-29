package com.ig.automation.test;

import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ig.automation.screens.CheckinScreen;
import com.ig.automation.screens.CreateCMSScreen;
import com.ig.automation.screens.CreateCRScreen;
import com.ig.automation.screens.EditPropertiesScreen;
import com.ig.automation.screens.VersionCMSScreen;
import com.ig.automation.screens.VersionRMSScreen;
import com.ig.automation.utility.Log;


public class CreateCMSTest extends CreateCMSScreen{

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
	 * Test the Create CMS Page of  UI 7.0 against the xmL-UI-ADS-021   
	 * @throws Exception If an error occurs.
	 * 
	 */
	@Test
	public void testCreateCMS() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Create CMS Test Started");
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
			initializeEditMenu();
			editMenu.click();
			initializeCreateCMS();
			createCMS.click();
			initializeCMSPanel();
			Assert.assertTrue(createCMSLabel.isDisplayed());
			title.clear();
			title.sendKeys("CMS UI Test");
			country.clear();
			country.sendKeys("Austria");
			country.sendKeys(Keys.ARROW_DOWN);
			country.sendKeys(Keys.ENTER);
			language.selectByVisibleText("English");
			createCMSButton.click();
			Thread.sleep(1000);
			initializeMessages();
			Assert.assertTrue(message.getText().contains("RMS Create sucessfully"));
			System.out.println(message.getText());
			String successMessage = message.getText(); // Document PL-123,
			String DocID = successMessage.substring(29, 36); 
			writeCSV(DocID);

			Reporter.log("xmL-UI-ADS-021.doc CreateCMS tested successfully");
		}
		catch(Throwable e){
			Log.info(e.getMessage());
			Reporter.log("xmL-UI-ADS-021.doc CreateCMS tested unsuccessfully");	
			Assert.fail();
		}
			Log.endTestCase("Create CMS Test Ended");
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
