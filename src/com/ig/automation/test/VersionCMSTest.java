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
import com.ig.automation.screens.VersionCMSScreen;
import com.ig.automation.utility.Log;


public class VersionCMSTest extends VersionCMSScreen{

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
	 * Test the Version CMS Page of UI 7.0 against the xmL-UI-ADS-XXX   
	 * @throws Exception If an error occurs.
	 * 
	 */
	@Test
	public void testVersionCMS() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Version CMS Test Started");
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
			initializeVersionCMS();
			versionCMS.click();
			filterDocID.click();
			initializeVersionsTab();
			versionTab.click();
			initializeVersionsGrid();
			versionColumn.click();
			initializeVersionsDetails();
			Assert.assertEquals(versionDetail.getText(),"0.2,CURRENT");
			Reporter.log("xmL-UI-ADS-XXX.doc Version CMS tested successfully");
		}
		catch(Throwable e){
			Log.info(e.getMessage());
			Reporter.log("xmL-UI-ADS-XXX.doc Version CMS tested unsuccessfully");	
			Assert.fail();
		}
			Log.endTestCase("Version CMS Test Ended");
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
