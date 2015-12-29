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
import com.ig.automation.screens.VersionSPLScreen;
import com.ig.automation.utility.Log;


public class VersionSPLTest extends VersionSPLScreen{

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
	 * Test the Version USPI Page of UI 7.0 against the xmL-UI-ADS-XXX   
	 * @throws Exception If an error occurs.
	 * 
	 */
	@Test
	public void testVersionUSPI() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Version USPI Test Started");
		try{
			String docID=getDocID("USPI");
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
			splMenu.click();
			initializeVersionSPL();
			versionUSPI.click();
			filterDocID.click();
			initializeVersionsTab();
			versionTab.click();
			initializeVersionsGrid();
			versionColumn.click();
			initializeVersionsDetails();
			Assert.assertEquals(versionDetail.getText(),"0.2,CURRENT");
			Reporter.log("xmL-UI-ADS-XXX.doc Version USPI tested successfully");
		}
		catch(Throwable e){
			Log.info(e.getMessage());
			Reporter.log("xmL-UI-ADS-XXX.doc Version USPI tested unsuccessfully");	
			Assert.fail();
		}
			Log.endTestCase("Version USPI Test Ended");
	}

	/**
	 * Test the Version Registration Page of UI 7.0 against the xmL-UI-ADS-XXX   
	 * @throws Exception If an error occurs.
	 * 
	 */
	@Test
	public void testVersionReg() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Version Registration Test Started");
		try{
			String docID=getDocID("REG");
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
			splMenu.click();
			initializeVersionSPL();
			versionReg.click();
			filterDocID.click();
			initializeVersionsTab();
			versionTab.click();
			initializeVersionsGrid();
			versionColumn.click();
			initializeVersionsDetails();
			Assert.assertEquals(versionDetail.getText(),"0.2,CURRENT");
			Reporter.log("xmL-UI-ADS-XXX.doc Version Registration tested successfully");
		}
		catch(Throwable e){
			Log.info(e.getMessage());
			Reporter.log("xmL-UI-ADS-XXX.doc Version Registration tested unsuccessfully");	
			Assert.fail();
		}
			Log.endTestCase("Version Registration Test Ended");
	}	

	/**
	 * Test the Version SelfID Page of UI 7.0 against the xmL-UI-ADS-XXX   
	 * @throws Exception If an error occurs.
	 * 
	 */
	@Test
	public void testVersionSelfID() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Version SelfID Test Started");
		try{
			String docID=getDocID("SID");
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
			splMenu.click();
			initializeVersionSPL();
			versionSelfID.click();
			filterDocID.click();
			initializeVersionsTab();
			versionTab.click();
			initializeVersionsGrid();
			versionColumn.click();
			initializeVersionsDetails();
			Assert.assertEquals(versionDetail.getText(),"0.2,CURRENT");
			Reporter.log("xmL-UI-ADS-XXX.doc Version SelfID tested successfully");
		}
		catch(Throwable e){
			Log.info(e.getMessage());
			Reporter.log("xmL-UI-ADS-XXX.doc Version SelfID tested unsuccessfully");	
			Assert.fail();
		}
			Log.endTestCase("Version SelfID Test Ended");
	}
	
	/**
	 * Test the Version Establishment Page of UI 7.0 against the xmL-UI-ADS-XXX   
	 * @throws Exception If an error occurs.
	 * 
	 */
	@Test
	public void testVersionEstb() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Version Establishment Test Started");
		try{
			String docID=getDocID("EST");
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
			splMenu.click();
			initializeVersionSPL();
			versionEstb.click();
			filterDocID.click();
			initializeVersionsTab();
			versionTab.click();
			initializeVersionsGrid();
			versionColumn.click();
			initializeVersionsDetails();
			Assert.assertEquals(versionDetail.getText(),"0.2,CURRENT");
			Reporter.log("xmL-UI-ADS-XXX.doc Version Establishment tested successfully");
		}
		catch(Throwable e){
			Log.info(e.getMessage());
			Reporter.log("xmL-UI-ADS-XXX.doc Version Establishment tested unsuccessfully");	
			Assert.fail();
		}
			Log.endTestCase("Version Establishment Test Ended");
	}
	
	/**
	 * Test the Version NDC Page of UI 7.0 against the xmL-UI-ADS-XXX   
	 * @throws Exception If an error occurs.
	 * 
	 */
	@Test
	public void testVersionNDC() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Version NDC Test Started");
		try{
			String docID=getDocID("NDC");
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
			splMenu.click();
			initializeVersionSPL();
			versionNDC.click();
			filterDocID.click();
			initializeVersionsTab();
			versionTab.click();
			initializeVersionsGrid();
			versionColumn.click();
			initializeVersionsDetails();
			Assert.assertEquals(versionDetail.getText(),"0.2,CURRENT");
			Reporter.log("xmL-UI-ADS-XXX.doc Version NDC tested successfully");
		}
		catch(Throwable e){
			Log.info(e.getMessage());
			Reporter.log("xmL-UI-ADS-XXX.doc Version NDC tested unsuccessfully");	
			Assert.fail();
		}
			Log.endTestCase("Version NDC Test Ended");
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
